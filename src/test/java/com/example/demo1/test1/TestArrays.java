package com.example.demo1.test1;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: chenjingang@gauzi.com  2019/1/2 15:25
 */
@Ignore
public class TestArrays extends BaseTest{

    @Test
    public void test1() {

        Object list = new ArrayList<>();
        ((ArrayList) list).add(1);
        ((ArrayList) list).add(2);
        //List a = (ArrayList)objects;

        //System.out.println(a.size());
        System.out.println(Arrays.asList(list).size());

    }
}
