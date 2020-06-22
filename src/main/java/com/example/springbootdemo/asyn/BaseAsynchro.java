package com.example.springbootdemo.asyn;

import com.example.springbootdemo.pool.CommonThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class BaseAsynchro {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            Thread.sleep(3000);
            return 5;
        });
        CommonThreadPool.execute(futureTask);
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
