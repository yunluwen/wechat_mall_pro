package com.zyh.mall.controller;

import com.zyh.mall.config.ProjectUrlConfig;
import com.zyh.mall.enums.ResultEnum;
import com.zyh.mall.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

/**
 * 第三方sdk的使用
 * 对接微信网页授权
 * 使用第三方的sdk : weixin-java-mp
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxMpService wxOpenService;

    /**
     * 项目的一些url信息
     */
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    /**
     * 获取code参数
     * 使用：
     * http://zhangyunhao.natapp1.cc/sell/wechat/authorize?returnUrl=https://www.baidu.com
     *
     * @param returnUrl 需要跳转的url
     * @return
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {
        //MP_OAuth2网页授权步骤：
        //1、首先构造网页授权url，然后构成超链接让用户点击
        String url = projectUrlConfig.getWechatMpAuthorize() + "/sell/wechat/userInfo";  //跳转的url
        System.out.println("跳转url:"+url);
        // 获取微信返回的重定向url
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, URLEncoder.encode(returnUrl));
        return "redirect:" + redirectUrl;
    }

    /**
     * 使用code参数换取access_token信息，并获取到openid
     * @param code
     * @param returnUrl
     * @return
     */
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            // 2、使用code换取access_token信息
            // 当用户同意授权后，会回调所设置的url并把authorization code传过来，
            // 然后用这个code获得access token，其中也包含用户的openid等信息
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        //3、获得用户基本信息
        // 从access_token信息中获取到用户的openid
        String openId = wxMpOAuth2AccessToken.getOpenId();
        System.out.println("获得用户的openId:"+openId);
        // 重定向到我们要跳转的页面
        return "redirect:" + returnUrl + "?openid=" + openId;
    }

    /**
     * 登录授权
     * 重定向
     * @param returnUrl
     * @return
     */
    @GetMapping("/qrAuthorize")
    public String qrAuthorize(@RequestParam("returnUrl") String returnUrl) {
        String url = projectUrlConfig.getWechatOpenAuthorize() + "/sell/wechat/qrUserInfo";
        String redirectUrl = wxOpenService.buildQrConnectUrl(url, WxConsts.QRCONNECT_SCOPE_SNSAPI_LOGIN, URLEncoder.encode(returnUrl));
        return "redirect:" + redirectUrl;
    }

    /**
     * 获取授权信息
     * 重定向
     * @param code
     * @param returnUrl
     * @return
     */
    @GetMapping("/qrUserInfo")
    public String qrUserInfo(@RequestParam("code") String code,
                             @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxOpenService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        log.info("wxMpOAuth2AccessToken={}", wxMpOAuth2AccessToken);
        String openId = wxMpOAuth2AccessToken.getOpenId();

        return "redirect:" + returnUrl + "?openid=" + openId;
    }
}
