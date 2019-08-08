package com.march.enable.service.impl;

import com.march.enable.service.service;

public class FtpServer implements service.Server {

    @Override
    public void start() {
        System.out.println("FTP服务启动中。。。");
    }

    @Override
    public void stop() {
        System.out.println("FTP服务关闭中。。。");
    }
}
