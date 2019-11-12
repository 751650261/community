package com.cwq.springbootcommunity.cache;

import com.cwq.springbootcommunity.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author cwq
 * @date 2019/11/12 - 11:38
 */
public class TagCache {
    public static List<TagDTO> get(){
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("js","php","css","html","java","node","python","c++","c","golang","objective - c"
                ,"typescript" ,"shell","c#","swift" ,"sass","bash" ,"ruby","less" ,"asp.net","lua" ,"scala"
                ,"coffeescript" ,"actionscript" ,"rust","erlang","perl"));
        tagDTOS.add(program);

        TagDTO framework = new TagDTO();
        framework.setCategoryName("平台框架");
        framework.setTags(Arrays.asList("laravel","spring" ,"express","django","flask","yii" ,"ruby-on-rails","tornado","koa","struts"));
        tagDTOS.add(framework);

        return tagDTOS;
    }

    public static String filterInvalid(String tags){
        String[] split = StringUtils.split(tags, ",");
        List<TagDTO> tagDTOS = get();
        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }
}
