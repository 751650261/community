package com.cwq.springbootcommunity.mapper;

import com.cwq.springbootcommunity.model.Question;

import java.util.List;

public interface QuestionExtMapper {

    int incView(Question record);
    int incComment(Question record);
    List<Question> selectRelated(Question question);
}