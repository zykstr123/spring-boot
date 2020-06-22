package com.example.springbootdemo.localThread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeByMap {
    private static Map<Long, Object> map = new ConcurrentHashMap<>();

    public Object get() {
        return map.get(Thread.currentThread().getId());
    }

    public void set(Object value) {
        map.put(Thread.currentThread().getId(), value);
    }
}
