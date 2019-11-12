package com.cwq.springbootcommunity.dto;

import java.util.List;

/**
 * @author cwq
 * @date 2019/11/12 - 11:38
 */
public class TagDTO {
    private String categoryName;
    private List<String> tags;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
