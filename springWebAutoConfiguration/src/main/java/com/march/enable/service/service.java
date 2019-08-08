package com.march.enable.service;

public class service {
    public static interface Server {

        /**
         * 启动服务
         */
        void start();

        /**
         * 关闭服务
         */
        void stop();

        enum type{
            HTTP,//HTTP服务
            FTP//FTP服务
        }

    }
}
