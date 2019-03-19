package com.client.async;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class AppTest {

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        AsyncTask task = ctx.getBean(AsyncTask.class);
        Instant start = Instant.now();
        ArrayList<CompletableFuture<String>> asyncTasks = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            CompletableFuture<String> asyncTask = task.doAsyncTask(i);
            asyncTasks.add(asyncTask);
        }
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(asyncTasks.toArray(new CompletableFuture[asyncTasks.size()]));

        try {
            List<String> finalResults = completableFuture.thenApply(t -> {
                return asyncTasks.stream().map(f -> f.join()).collect(Collectors.toList());
            }).get();
            StringBuilder sb = new StringBuilder();
            for (String result : finalResults) {
                sb.append(result);
            }


            System.out.println(sb);
            Instant end = Instant.now();
            System.out.println(Duration.between(start, end));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}