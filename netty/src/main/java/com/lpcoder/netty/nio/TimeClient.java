package com.lpcoder.netty.nio;

import static com.lpcoder.netty.nio.Constants.PORT;

/**
 * @author liurenpeng
 * @date Created in 19-4-1
 */
public class TimeClient {

    public static void main(String[] args) {
        new Thread(new TimeClientHandler("127.0.0.1",PORT),"TimeClient-001").start();
    }

}
