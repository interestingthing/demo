package com.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: chenjingang@gauzi.com  2019/3/23 23:10
 */
@Controller
public class PageController {

    @RequestMapping("{page}.html")
    public String jump(@PathVariable("page") String page) {
        return page;
    }

}
