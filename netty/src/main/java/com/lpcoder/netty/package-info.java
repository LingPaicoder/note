/**
 * @author liurenpeng
 * @date Created in 19-3-28
 */
package com.lpcoder.netty;

        /*// 1.打开ServerSocketChannel 用于监听客户端的连接 它是所有客户端连接的父管道
        ServerSocketChannel acceptorSvr = ServerSocketChannel.open();

        // 2.绑定监听端口 设置连接为非阻塞模式
        acceptorSvr.socket().bind(new InetSocketAddress(InetAddress.getByName("IP"), PORT));
        acceptorSvr.configureBlocking(false);

        // 3.创建Reactor线程 创建多路复用器并启动线程
        Selector selector = Selector.open();
        new Thread(new ReactorTask()).start();

        // 4.
        SelectionKey key = acceptorSvr.register(selector, SelectionKey.OP_ACCEPT, ioHandler);*/