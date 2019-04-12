package com.lpcoder.demo.lru

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * @author liurenpeng
 * @date Created in 19-4-2
 */
class LRUCache<K,V>(capacity:Int):LinkedHashMap<K,V>(capacity){
    private val lock : Lock = ReentrantLock()

}

fun main(args: Array<String>) {
    print("abc")
}