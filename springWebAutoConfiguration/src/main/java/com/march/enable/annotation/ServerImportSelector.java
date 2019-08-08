package com.march.enable.annotation;

import com.march.enable.annotation.EnableServer;
import com.march.enable.service.service;
import com.march.enable.service.impl.FtpServer;
import com.march.enable.service.impl.HttpServer;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class ServerImportSelector implements ImportSelector {
    
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableServer.class.getName());

        service.Server.type type = (service.Server.type) annotationAttributes.get("type");

        String[] importClassName = new String[0];

        switch (type){
            case FTP:
                importClassName = new String[]{FtpServer.class.getName()};
                break;
            case HTTP:
                importClassName = new String[]{HttpServer.class.getName()};
                break;
        }
        return importClassName;
    }
}
