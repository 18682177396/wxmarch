package org.springframework.boot.autoconfigure;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class AutoConfigurationMetadataLoaderTest {

    @Test
    public void loadMetadata(){
        AutoConfigurationMetadata autoConfigurationMetadata = AutoConfigurationMetadataLoader.loadMetadata(Thread.currentThread().getContextClassLoader());

        System.out.println(JSONObject.toJSONString(autoConfigurationMetadata));
    }
}
