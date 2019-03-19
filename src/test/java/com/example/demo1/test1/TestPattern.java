package com.example.demo1.test1;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @Author: chenjingang@gauzi.com  2019/3/15 21:48
 */
public class TestPattern {

    @Test
    public void testPattern() {

        String s = "{\n" +
                "  \"id\" : 123,\n" +
                "  \"name\" : \"chenjingan\"\n" +
                "}";
        String s1 = s.replaceAll("[\\{\\}\\s+\"\\s]", "");
        String s2 = s1.replaceAll("[:]", "=");
        String s3 = s2.replaceAll("[,]", "&");

        System.out.println(s3);
    }
}
