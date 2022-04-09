package com.titxu.core.client;

import com.titxu.base.pojo.dto.SmsDTORequest;
import com.titxu.core.client.fallback.SmsClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "service-sms",fallback = SmsClientFallback.class)
public interface SmsClient {
    @PostMapping("/api/sms/send")
    void send(@RequestBody SmsDTORequest request);
}
