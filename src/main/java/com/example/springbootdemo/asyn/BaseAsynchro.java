package com.example.springbootdemo.asyn;

import com.example.springbootdemo.pool.CommonThreadPool;

import java.util.concurrent.*;

//@SuppressWarnings("all")
public class BaseAsynchro {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // future
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            Thread.sleep(3000);
            return 5;
        });
        CommonThreadPool.execute(futureTask);
        while (!futureTask.isDone()) {
            //轮询
            System.out.println("等待1s");
            Thread.sleep(1000L);
            System.out.println(futureTask.get());
        }

        /*  completableFuture  */
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("executorService 是否为守护线程 :" + Thread.currentThread().isDaemon());
                return null;
            }
        });

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("---this is lambda supplyAsync");
            System.out.println("---supplyAsync 是否为守护线程 " + Thread.currentThread().isDaemon());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("---this lambda is executed by forkJoinPool");
            return "---result1";
        });//默认用forkjoin，是守护线程

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this is task with executor");
            System.out.println("supplyAsync 使用executorService 时是否为守护线程 : " + Thread.currentThread().isDaemon());
            return "result2";
        }, executorService); //这里制定了executor
//        System.out.println(completableFuture.get());
//        System.out.println(future.get());

        // 如果完成了，返回结构，未完成，返回入参
        System.out.println(future.getNow("===230"));

        CompletableFuture.runAsync(() -> {
            System.out.println("run不能return值");
        });

        //第一个完成的
        System.out.println("123"+CompletableFuture.anyOf(future, completableFuture));
        // 全都完成  void
        System.out.println("234"+CompletableFuture.allOf(future, completableFuture));
        // 类似get，阻塞线程
//        future.join();
        // 任务完成时
        future.whenComplete((s, e) -> {
            System.out.println("345"+s);
            System.out.println(e);
        });

//        future.thenAccept();

        executorService.shutdown();
    }
}
