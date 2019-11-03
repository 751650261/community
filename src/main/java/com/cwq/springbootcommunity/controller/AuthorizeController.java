package com.cwq.springbootcommunity.controller;

import com.cwq.springbootcommunity.dto.AccessTokenDTO;
import com.cwq.springbootcommunity.dto.GitHubUser;
import com.cwq.springbootcommunity.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cwq
 * @date 2019/11/3 - 22:25
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id("a663ad600416ee18f10e");
        accessTokenDTO.setClient_secret("ca2aa7122adc082e6dc199717e4a366d75968578");
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        GitHubUser user = gitHubProvider.getUser(accessToken);
        System.out.println(user.getName());
        System.out.println(user.getId());
        return "index";
    }

}
