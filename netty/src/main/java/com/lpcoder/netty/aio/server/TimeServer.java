package com.lpcoder.netty.aio.server;

import com.lpcoder.netty.Constants;

/**
 * @author liurenpeng
 * @date Created in 19-4-10
 */
public class TimeServer {

    public static void main(String[] args) {
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(Constants.SERVER_LISTENED_PORT);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }

}
