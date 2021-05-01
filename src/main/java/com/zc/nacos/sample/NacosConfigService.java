package com.zc.nacos.sample;

/**
 * 伪代码方案 解密方案
 * @author CoreyChen Zhang
 * @date 2021/4/26 13:25
 * @modified
 */
public class NacosConfigService {

    private String namespace;

    //推荐使用bean注入 （另外的方案classLoader）
    private DecodeService decodeService;

//    @Override
    public String getConfig(String dataId, String group, long timeoutMs){
        String configStr = getConfigInner(namespace, dataId, group, timeoutMs);
        //解密
        final String finalConfigStr = decodeService.decode(configStr);
        return finalConfigStr;
    }

    private String getConfigInner(String tenant, String dataId, String group, long timeoutMs){
        return "";
    }
}

