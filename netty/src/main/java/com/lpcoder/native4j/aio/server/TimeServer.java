package com.lpcoder.native4j.aio.server;

import com.lpcoder.Constants;

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
