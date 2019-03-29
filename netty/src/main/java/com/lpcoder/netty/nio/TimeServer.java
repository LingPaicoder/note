package com.lpcoder.netty.nio;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @author liurenpeng
 * @date Created in 19-3-28
 */
public class TimeServer {

    private static final int PORT = 8001;

    public static void main(String[] args) throws Exception {
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(PORT);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }

}
