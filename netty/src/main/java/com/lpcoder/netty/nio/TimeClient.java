package com.lpcoder.netty.nio;

import static com.lpcoder.netty.Constants.LOCAL_HOST_IP;
import static com.lpcoder.netty.Constants.SERVER_LISTENED_PORT;

/**
 * @author liurenpeng
 * @date Created in 19-4-1
 */
public class TimeClient {

    public static void main(String[] args) {
        new Thread(new TimeClientHandler(LOCAL_HOST_IP, SERVER_LISTENED_PORT),"TimeClient-001").start();
    }

}
