package com.cwq.springbootcommunity.controller;

import com.cwq.springbootcommunity.dto.PaginationDTO;
import com.cwq.springbootcommunity.dto.QuestionDTO;
import com.cwq.springbootcommunity.mapper.QuestionMapper;
import com.cwq.springbootcommunity.mapper.UserMapper;
import com.cwq.springbootcommunity.model.Question;
import com.cwq.springbootcommunity.model.User;
import com.cwq.springbootcommunity.service.QuestionService;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author cwq
 * @date 2019/11/3 - 15:46
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model,
                        @RequestParam(name="page",defaultValue = "1") Integer page,
                        @RequestParam(name="size",defaultValue = "5") Integer size
    ){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null && cookies.length!=0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }


}
