package com.titxu.sms.properties;


import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "sms.tencent")
@Component
@Data
public class SmsProperties implements InitializingBean {
   private String appId;
   private String secretId;
   private String secretKey;
   private String templateId;
   private String signName;

   public static String APP_ID;
   public static String SECRET_ID;
   public static String SECRET_KEY;
   public static String TEMPLATE_ID;
   public static String SIGN_NAME;

    @Override
    public void afterPropertiesSet() {
        APP_ID = this.appId;
        SECRET_ID = this.secretId;
        SECRET_KEY = this.secretKey;
        TEMPLATE_ID = this.templateId;
        SIGN_NAME = this.signName;
    }
}
