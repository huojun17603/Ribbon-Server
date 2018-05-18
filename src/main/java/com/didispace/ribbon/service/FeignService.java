package com.didispace.ribbon.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "customer-service")
public interface FeignService {

    @RequestMapping("hello")
    public String index();

    @RequestMapping("setName")
    public String setName(String name);

    @RequestMapping("getName")
    public String getName();

}
