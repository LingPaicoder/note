package com.lpcoder.native4j.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import static com.lpcoder.Constants.BACKLOG;
import static com.lpcoder.Constants.CAPACITY;
import static com.lpcoder.Constants.QUERY_TIME_ORDER_STR;
import static com.lpcoder.Constants.TIME_OUT;

/**
 * @author liurenpeng
 * @date Created in 19-3-29
 */
public class MultiplexerTimeServer implements Runnable {

    private Selector selector;
    private ServerSocketChannel servChannel;
    private volatile boolean stop;

    /**
     * 初始化多路复用器 绑定监听端口
     */
    public MultiplexerTimeServer(int port) {
        try {
            // 1.打开ServerSocketChannel，用于监听客户端的连接，它是所有客户端连接的父管道
            servChannel = ServerSocketChannel.open();
            // 2.绑定监听端口，设置连接为非阻塞模式
            servChannel.socket().bind(new InetSocketAddress(port), BACKLOG);
            servChannel.configureBlocking(false);
            // 3.创建多路复用器
            selector = Selector.open();
            // 4.将ServerSocketChannel注册到多路复用器Selector上，监听ACCEPT事件
            servChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        this.stop = true;
    }

    public void run() {
        while (!stop) {
            try {
                // 5.多路复用器在线程run方法的无限循环体内轮询准备就绪的Key
                selector.select(TIME_OUT);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        key.cancel();
                        if (key.channel() != null) {
                            key.channel().close();
                        }
                    }
                }
            } catch (Throwable t) {
                t.printStackTrace();
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
            // 处理接入的请求消息
            if (key.isAcceptable()) {
                // Access the new connection
                // 6.多路复用器监听到有新的客户端接入，处理新的接入请求，完成TCP三次握手，建立物理链路
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                // 7.设置客户端链路为非阻塞模式
                sc.configureBlocking(false);
                // Add the new connection to the selector
                // 8.将新接入的客户端连接注册到Reactor线程的多路复用器上，监听读操作，用来读取客户端发送的网络消息
                sc.register(selector, SelectionKey.OP_READ);
            }
            if (key.isReadable()) {
                // Read the data
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(CAPACITY);
                // 9.异步读取客户端请求消息到缓冲区
                // ??10.对ByteBuffer进行编解码，如果有半包消息指针reset，继续读取后续的报文，
                //      将解码成功的消息封装成Task，投递到业务线程池中，进行业务逻辑编排
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time server receive order : " + body);
                    String currentTime = QUERY_TIME_ORDER_STR.equalsIgnoreCase(body) ?
                            new Date().toString() : "BAD ORDER";
                    doWrite(sc, currentTime);
                } else if (readBytes < 0) {
                    // 对端链路关闭
                    key.cancel();
                    sc.close();
                } else {
                    ;// 读到0字节，忽略
                }
            }
        }
    }

    private void doWrite(SocketChannel channel, String response) throws IOException {
        // 11.将POJO对象encode成ByteBuffer，调用SocketChannel的异步write接口，将消息异步发送给客户端
        if (response != null && response.trim().length() > 0) {
            byte[] bytes = response.getBytes();
            ByteBuffer writerBuffer = ByteBuffer.allocate(bytes.length);
            writerBuffer.put(bytes);
            writerBuffer.flip();
            channel.write(writerBuffer);
        }
    }
}
