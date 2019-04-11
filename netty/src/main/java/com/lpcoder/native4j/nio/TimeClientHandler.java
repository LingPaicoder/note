package com.lpcoder.native4j.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import static com.lpcoder.Constants.CAPACITY;
import static com.lpcoder.Constants.LOCAL_HOST_IP;
import static com.lpcoder.Constants.QUERY_TIME_ORDER_STR;
import static com.lpcoder.Constants.TIME_OUT;

/**
 * @author liurenpeng
 * @date Created in 19-4-1
 */
public class TimeClientHandler implements Runnable {

    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;

    public TimeClientHandler(String host, int port) {
        this.host = host == null ? LOCAL_HOST_IP : host;
        this.port = port;
        try {
            // 1. 打开SocketChannel（绑定客户端本地地址）
            socketChannel = SocketChannel.open();
            // 2. 设置SocketChannel为非阻塞模式
            socketChannel.configureBlocking(false);

            // 6. 创建Reactor线程，创建多路复用器并启动线程
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void run() {
        try {
            doConnect();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        // 7. 多路复用器在线程run方法的无限循环体内轮询准备就绪的Key
        while (!stop) {
            try {
                selector.select(TIME_OUT);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        // 多路复用器关闭后，所有注册在上面的Channel和Pipe等资源都会被自动去注册并关闭，所以不需要重复释放资源
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            // 8. 接收connect事件进行处理
            // 判断是否连接成功
            SocketChannel sc = (SocketChannel) key.channel();
            if (key.isConnectable()) {
                // 9. 判断链接结果，如果链接成功，注册读事件到多路复用器
                if (sc.finishConnect()) {
                    // 10. 注册读事件到多路复用器
                    sc.register(selector, SelectionKey.OP_READ);
                    doWrite(sc);
                } else {
                    // 连接失败，进程退出
                    System.exit(1);
                }
            }
            if (key.isReadable()) {
                ByteBuffer readBuffer = ByteBuffer.allocate(CAPACITY);
                // 11. 异步读客户端请求消息到缓冲区
                // 12? 对ByteBuffer进行编解码，如果有半包消息接收缓冲区reset，继续读取后续的报文
                // 将解码成功的消息封装成Task，投递到业务线程池中，进行业务逻辑编排
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("Now is : " + body);
                    this.stop = true;
                } else if (readBytes < 0) {
                    // 对端链路关闭
                    key.cancel();
                    sc.close();
                } else {
                    ; // 读到0字节，忽略
                }
            }
        }
    }

    private void doConnect() throws IOException {
        // 3. 异步连接服务端
        boolean connected = socketChannel.connect(new InetSocketAddress(host, port));
        System.out.println("connected:" + connected);
        if (connected) {
            // 4. 判断是否连接成功，如果链接成功，则直接注册读状态位到多路复用器中，发送请求消息，读应答
            socketChannel.register(selector, SelectionKey.OP_READ);
            doWrite(socketChannel);
        } else {
            // 5. 异步链接返回false，说明客户端已经发送sync包，服务端没有返回ack包，物理链路还没有建立
            // 如果没有连接成功，向Reactor线程的多路复用器注册OP_CONNECT状态位，监听服务端的TCP ACK应答
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    private void doWrite(SocketChannel sc) throws IOException {
        // 13. 将POJO对象encode成ByteBuffer，调用SocketChannel的异步write接口，将消息异步发送给客户端
        byte[] req = QUERY_TIME_ORDER_STR.getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();
        sc.write(writeBuffer);
        if (!writeBuffer.hasRemaining()) {
            System.out.println("Send order to server succeed.");
        }
    }

}
