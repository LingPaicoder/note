package com.lpcoder.netty.aio.client;

import com.lpcoder.netty.Constants;

/**
 * @author liurenpeng
 * @date Created in 19-4-10
 */
public class TimeClient {

    public static void main(String[] args) {
        new Thread(new AsyncTimeClientHandler(
                Constants.LOCAL_HOST_IP, Constants.SERVER_LISTENED_PORT),
                "AIO-AsyncTimeClientHandler-001").start();
    }

}
