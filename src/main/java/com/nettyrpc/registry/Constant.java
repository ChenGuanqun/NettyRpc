package com.nettyrpc.registry;

/**
 * 常量
 *
 * @author huangyong
 * @since 1.0.0
 */
public interface Constant {

    int ZK_SESSION_TIMEOUT = 5000;

    String ZK_lOCK="/lock";
    
    String ZK_REGISTRY_PATH = "/registry";
    String ZK_DATA_PATH = ZK_REGISTRY_PATH + "/data";
}
