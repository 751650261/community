package com.cwq.springbootcommunity.controller;

import com.cwq.springbootcommunity.dto.QuestionDTO;
import com.cwq.springbootcommunity.mapper.QuestionMapper;
import com.cwq.springbootcommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author cwq
 * @date 2019/11/6 - 16:27
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name="id")Long id, Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        //增加阅读数
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }

}
