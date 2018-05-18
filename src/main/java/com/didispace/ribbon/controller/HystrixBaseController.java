package com.didispace.ribbon.controller;

public class HystrixBaseController {

    public String error(){
        return "{msg:'请求超时！'}";
    }
}
