package com.example.springbootdemo.localThread;

public class ThreadSafeByLocalThread {
    private final ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
    private final ThreadLocal<Long> threadLocal2 = new ThreadLocal<>();

    public String getString() {
        return threadLocal1.get();
    }

    public Long getLong() {
        return threadLocal2.get();
    }

    public void setString(String s) {
        threadLocal1.set(s);
    }

    public void setLong(Long l) {
        threadLocal2.set(l);
    }
}
