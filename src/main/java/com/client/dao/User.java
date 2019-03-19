package com.client.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: chenjingang@gauzi.com  2019/2/27 00:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private Integer age;
    private String name;
    private String password;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
