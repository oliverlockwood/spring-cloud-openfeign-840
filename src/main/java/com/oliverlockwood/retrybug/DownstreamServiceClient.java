package com.oliverlockwood.retrybug;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "downstream-service")
public interface DownstreamServiceClient {

    @GetMapping("/api/something")
    String getMeSomething();

}
