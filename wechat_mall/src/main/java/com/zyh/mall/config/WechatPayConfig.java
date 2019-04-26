package com.zyh.mall.config;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 微信支付配置
 */
@Component
public class WechatPayConfig {

    @Autowired
    private WechatAccountConfig accountConfig;

    /**
     * 支付操作接口
     * @return
     */
    @Bean
    public BestPayServiceImpl bestPayService() {
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayH5Config(wxPayH5Config());
        return bestPayService;
    }

    /**
     * 微信支付的配置信息
     * @return
     */
    @Bean
    public WxPayH5Config wxPayH5Config() {
        WxPayH5Config wxPayH5Config = new WxPayH5Config();
        wxPayH5Config.setAppId(accountConfig.getMpAppId());         //公众号名称
        wxPayH5Config.setAppSecret(accountConfig.getMpAppSecret()); //公众号密钥
        wxPayH5Config.setMchId(accountConfig.getMchId());           //商户号
        wxPayH5Config.setMchKey(accountConfig.getMchKey());         //商户密钥
        wxPayH5Config.setKeyPath(accountConfig.getKeyPath());       //商户证书路径
        wxPayH5Config.setNotifyUrl(accountConfig.getNotifyUrl());   //微信支付异步通知地址
        return wxPayH5Config;
    }
}
