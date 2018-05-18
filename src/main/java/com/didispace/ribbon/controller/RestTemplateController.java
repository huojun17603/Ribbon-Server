package com.didispace.ribbon.controller;

import com.didispace.ribbon.service.FeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController extends HystrixBaseController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    FeignService feignService;

    @RequestMapping("/ribbon")
    @HystrixCommand(fallbackMethod = "error")
    public String ribbon(){
        return restTemplate.getForEntity("http://CUSTOMER-SERVICE/hello",String.class).getBody();
    }

    @RequestMapping("feign")
    @HystrixCommand(fallbackMethod = "error")
    public String feign(){
        return feignService.index();
    }

    @RequestMapping("setName")
    public String setName(String name){
        return feignService.setName(name);
    }

    @RequestMapping("getName")
    public String getName(){
        return feignService.getName();
    }
}
