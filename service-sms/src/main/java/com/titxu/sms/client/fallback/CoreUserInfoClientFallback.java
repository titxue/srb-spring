package com.titxu.sms.client.fallback;

import com.titxu.sms.client.CoreUserInfoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CoreUserInfoClientFallback implements CoreUserInfoClient {
    @Override
    public Boolean checkMobile(String mobile) {
        log.info("手机号: {},校验失败,服务熔断,进行降级处理", mobile);
        return false;
    }
}
