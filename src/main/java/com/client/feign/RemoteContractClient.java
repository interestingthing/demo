package com.client.feign;

import com.client.dao.User;
import com.client.feign.config.FeignConfig;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: chenjingang@gauzi.com  2019/2/15 20:39
 */

@FeignClient(name = "remoteContractClient", url = "http://localhost:8080", configuration = {FeignConfig.class})
public interface RemoteContractClient {

    @GetMapping(value = "user/userInfo", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    User getInfoByContractIds(@RequestParam("id") Integer id,
                              @RequestParam("name") String name);

    @PostMapping(value = "user/userInfo")
    User getInfoByContractIds1(User user);

    @GetMapping(value = "user/userInfo")
    User getInfoByContractIds(@SpringQueryMap User user);
}
