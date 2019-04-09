package com.lpcoder.netty.nio;

import static com.lpcoder.netty.Constants.SERVER_LISTENED_PORT;

/**
 * @author liurenpeng
 * @date Created in 19-3-28
 */
public class TimeServer {

    public static void main(String[] args) throws Exception {
        new Thread(new MultiplexerTimeServer(SERVER_LISTENED_PORT), "NIO-MultiplexerTimeServer-001").start();
    }

}
