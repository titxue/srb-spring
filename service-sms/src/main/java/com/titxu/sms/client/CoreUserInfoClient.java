package com.titxu.sms.client;

import com.titxu.sms.client.fallback.CoreUserInfoClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-core",fallback = CoreUserInfoClientFallback.class)
public interface CoreUserInfoClient {
    @GetMapping("/api/core/userInfo/checkMobile/{mobile}")
    Boolean checkMobile(@PathVariable("mobile") String mobile);

}
