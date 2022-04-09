package com.titxu.core.client.fallback;

import com.titxu.base.pojo.dto.SmsDTORequest;
import com.titxu.core.client.SmsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class SmsClientFallback implements SmsClient {


    @Override
    public void send(SmsDTORequest request) {
        log.error("发送短信失败:{}", request);
    }
}
