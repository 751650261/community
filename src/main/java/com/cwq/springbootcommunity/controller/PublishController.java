package com.cwq.springbootcommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author cwq
 * @date 2019/11/5 - 9:42
 */
@Controller
public class PublishController {

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

}
