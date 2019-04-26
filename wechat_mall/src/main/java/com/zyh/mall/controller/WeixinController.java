package com.zyh.mall.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 使用公众平台测试号测试
 * 测试手动获取openId
 * 微信网页授权，获取用户openid
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    /**
     * 访问这个url就可以进入这个方法，
     * 获取code,然后根据这个code来换取access_token(code只是一次性的)
     * 微信访问访问:
     *    https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx5f8d852db7dddc9a&redirect_uri=http://zhangyunhao.natapp1.cc/sell/weixin/auth&response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect
     * @param code
     */
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入auth方法。。。");
        //获取code
        log.info("code={}", code);

        //拿code换access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx5f8d852db7dddc9a&secret=420cc348c8a096b900eb8e854dc38c28&code=" + code + "&grant_type=authorization_code";
        //请求Rest接口的一个模板类
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        //响应的信息: response={
        //              "access_token":"20_NdLdLx1DuCzULfclrUfTrqt9ax8Kw3R7BwS2FUTcGU0iPL-Gl8O2nKXHUXx6lj-HsAbk1Q7KGL86ccY23of9QTH6L3u6ryH8jCtHAMYVlKY",
        //              "expires_in":7200,
        //              "refresh_token":"20_JlHIhBtIuvxOo1WP2e5AfzOAdSTHjUjis6dZdkqxdqnPFl-RiZErtMxzxNPuYd5zjOo7-tPiPefKG7Th3Llnw3HRGA2J-1K4Oh9CID6O9g0",
        //              "openid":"opXgF1UpY2cgV33K5QAAEnnM31H0",
        //              "scope":"snsapi_base"
        //              }
        log.info("response={}", response);
    }
}
