package com.client.async;

import org.springframework.scheduling.annotation.Async;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class AsyncTask {
    //@Async("mySimpleAsync")

   @Resource(name = "myAsync")
   Executor mySimpleAsync;
    public CompletableFuture<String> doAsyncTask(int time) throws InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // 假设执行一个很耗时的任务
                Thread.sleep(time * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "执行完成，我执行了" + time + "秒\n";
        },mySimpleAsync);

    }
}