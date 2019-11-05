package com.cwq.springbootcommunity.service;

import com.cwq.springbootcommunity.dto.QuestionDTO;
import com.cwq.springbootcommunity.mapper.QuestionMapper;
import com.cwq.springbootcommunity.mapper.UserMapper;
import com.cwq.springbootcommunity.model.Question;
import com.cwq.springbootcommunity.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cwq
 * @date 2019/11/5 - 15:20
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
