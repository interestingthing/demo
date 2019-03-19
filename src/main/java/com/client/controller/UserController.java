package com.client.controller;

import com.client.async.AsyncTask;
import com.client.dao.UserMapper;
import com.client.feign.RemoteContractClient;
import com.client.dao.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @Author: chenjingang@gauzi.com  2019/2/27 00:33
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    RemoteContractClient remoteContractClient;

    @Resource
    UserMapper userMapper;

    @RequestMapping(value = "/get")
    public User get() {
        return userMapper.getOne(1);
    }

    @RequestMapping(value = "/list")
    public List<User> list() {
        return userMapper.list();
    }
//    @GetMapping("userInfo")
//    User getUserInfo(User user){
//        System.out.println(user);
//        return new User(123,"1");
//    }

//    @GetMapping(value = "userInfo",consumes = {"application/x-www-form-urlencoded;charset=UTF-8","application/json"})
//    User getUserInfo1(Integer id,String name){
//        System.out.println(id+"+++++"+name);
//        return new User(123,"getUserInfo1");
//    }

    @GetMapping(value = "userInfo")
    User getUserInfo11(User user) {
        System.out.println(user);
        return new User(123, "getUserInfo1");
    }
//,
//    consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
//    produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}
    @PostMapping(value = "userInfo")
    User getUserInfo2(@RequestBody User user) {
        System.out.println(user);
        return new User(123, "getUserInfo2");
    }

    @GetMapping("getUserInfo")
    User getUserInfo3(User user) {
        System.out.println(user);
        return remoteContractClient.getInfoByContractIds(user.getId(),user.getName());
    }

    @GetMapping("getUserInfo2")
    User getUserInfo33(User user) {
        System.out.println(user);
        return remoteContractClient.getInfoByContractIds(user);
    }

    @GetMapping("getUserInfo1")
    User getUserInfo4(Integer id, String name) {
        System.out.println(id + "+++++" + name);
        return remoteContractClient.getInfoByContractIds(id, name);
    }

    @PostMapping(value = "postUserInfo")
    User postUserInfo33(User user) {
        System.out.println(user);
        return remoteContractClient.getInfoByContractIds1(user);
    }

    @PostMapping(value = "postUserInfo1")
    User getUserInfo44(Integer id, String name) {
        System.out.println(id + "+++++" + name);
        List<Object> objects = new ArrayList<>();
        return remoteContractClient.getInfoByContractIds1(new User(id, name));
    }

    @Resource
    AsyncTask task;

    @GetMapping("task")
    public String task() throws InterruptedException {
        Instant start = Instant.now();
        ArrayList<CompletableFuture<String>> asyncTasks = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            CompletableFuture<String> asyncTask = task.doAsyncTask(1);
            asyncTasks.add(asyncTask);
        }
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(asyncTasks.toArray(new CompletableFuture[asyncTasks.size()]));
        StringBuilder sb = new StringBuilder();
        try {
            List<String> finalResults = completableFuture.thenApply(t ->
                    asyncTasks.stream().map(f -> {
                        try {
                            return f.get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }).collect(Collectors.toList())
            ).get();

            for (String result : finalResults) {
                sb.append(result);
            }
            System.out.println(sb);
            Instant end = Instant.now();
            System.out.println(Duration.between(start, end) + Instant.now().toString());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
