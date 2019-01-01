package com.yang4j.servletlearn.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性文件工具类
 */
public final class PropsUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     * @param fileName
     * @return
     */
    public static Properties loadProps(String fileName) {
        Properties properties = null;
        InputStream inputStream = null;
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new FileNotFoundException(fileName+"file is not found");
            }
            properties = new Properties();
            properties.load(inputStream);
        }catch (IOException e){
            LOGGER.error("load properties file failure",e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }catch (IOException e){
                    LOGGER.error("close input stream failure",e);
                }
            }
        }
        return properties;
    }

    /**
     * 获取字符型属性（默认值为空字符串）
     * @param properties
     * @param key
     * @return
     */
    public static String getString(Properties properties,String key) {
        return getString(properties,key,"");
    }

    /**
     * 获取字符型属性（可指定默认值）
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties properties,String key,String defaultValue) {
        String value = defaultValue;
        if (properties.containsKey(key)){
            value = properties.getProperty(key);
        }
        return value;
    }

    /**
     * 获取数值型属性（默认值为0）
     * @param properties
     * @param key
     * @return
     */
    public static int getInt(Properties properties,String key){
        return getInt(properties, key,0);
    }

    /**
     * 获取数值型属性（可指定默认值）
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(Properties properties,String key,int defaultValue) {
        int value = defaultValue;
        if (properties.containsKey(key)){
            value = CastUtil.castInt(properties.getProperty(key));
        }
        return value;
    }

    /**
     * 获取布尔型属性（默认值为false）
     * @param properties
     * @param key
     * @return
     */
    public static boolean getBoolean(Properties properties,String key){
        return getBoolean(properties, key,false);
    }

    /**
     * 获取数值型属性（可指定默认值）
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(Properties properties,String key,Boolean defaultValue) {
        boolean value = defaultValue;
        if (properties.containsKey(key)){
            value = CastUtil.castBoolean(properties.getProperty(key));
        }
        return value;
    }
}
