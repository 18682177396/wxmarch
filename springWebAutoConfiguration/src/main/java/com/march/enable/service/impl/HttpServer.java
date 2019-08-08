package com.march.enable.service.impl;

import com.march.enable.service.service;

public class HttpServer implements service.Server {

    @Override
    public void start() {
        System.out.printf("HTTP服务启动中。。。");
    }

    @Override
    public void stop() {
        System.out.printf("HTTP服务关闭中。。。");
    }
}
