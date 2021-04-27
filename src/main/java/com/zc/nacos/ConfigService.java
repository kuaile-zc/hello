package com.zc.nacos;

/**
 * @author CoreyChen Zhang
 * @date 2021/4/26 13:22
 * @modified
 */
public interface ConfigService {


    /**
     * Get Configuration
     *
     * @param dataId    Config ID
     * @param group     Config Group
     * @param timeoutMs read timeout
     * @return config value
     */
    String getConfig(String dataId, String group, long timeoutMs);


}
