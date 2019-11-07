package com.cwq.springbootcommunity.mapper;

import com.cwq.springbootcommunity.model.Question;

public interface QuestionExtMapper {

    int incView(Question record);
    int incComment(Question record);
}