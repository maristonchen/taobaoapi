package com.iblotus;

import java.util.HashMap;
import java.util.Map;

/**
 * 淘宝接口代理类
 */
public class TaobaoApiConfig {

    private String url;

    private String appKey;

    private String secret;

    private Map<String, ContentDecoder> decoderMap = new HashMap<String, ContentDecoder>();

    public TaobaoApiConfig(String url, String appKey, String secret){

        this.url = url;
        this.appKey = appKey;
        this.secret = secret;
    }

    public String getUrl() {
        return url;
    }

    public String getAppKey() {
        return appKey;
    }

    public String getSecret() {
        return secret;
    }

    public void addDecoder(String methodName, ContentDecoder decoder){

        this.decoderMap.put(methodName, decoder);
    }

    public ContentDecoder getDecoder(String methodName){

        return this.decoderMap.get(methodName);
    }

    public TaobaoApiMethod createMethod(String methodName) {

        return new DefaultTaobaoMethod(methodName, this);
    }
}
