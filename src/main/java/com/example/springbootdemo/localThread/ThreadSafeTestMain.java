package com.example.springbootdemo.localThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafeTestMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadSafeByLocalThread threadSafeByLocalThread = new ThreadSafeByLocalThread();
        ThreadSafeByMap threadSafeByMap = new ThreadSafeByMap();
        Runnable r1 = () -> {
            threadSafeByMap.set(Thread.currentThread().getId());
            threadSafeByLocalThread.setString(Thread.currentThread().getName());
            threadSafeByLocalThread.setLong(Thread.currentThread().getId());
            System.out.println(threadSafeByMap.get());
            System.out.println(threadSafeByLocalThread.getString());
            System.out.println(threadSafeByLocalThread.getLong());
        };
        Runnable r2 = () -> {
            threadSafeByMap.set(Thread.currentThread().getId());
            threadSafeByLocalThread.setString(Thread.currentThread().getName());
            threadSafeByLocalThread.setLong(Thread.currentThread().getId());
            System.out.println(threadSafeByMap.get());
            System.out.println(threadSafeByLocalThread.getString());
            System.out.println(threadSafeByLocalThread.getLong());
        };
        executorService.execute(r1);
        executorService.execute(r2);
        executorService.shutdown();
    }
}
