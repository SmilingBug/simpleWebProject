package com.yang4j.servletlearn.util;


/**
 * 转型操作工具类
 */
public final class CastUtil {

    /**
     * 转为String类型
     * @param obj
     * @return
     */
    public static String castString(Object obj) {
        return CastUtil.castString(obj,"");
    }

    /**
     * 转为String类型（提供默认值）
     * @param obj
     * @param defaultValue
     * @return
     */
    public static String castString(Object obj,String defaultValue) {
        return obj != null ? String.valueOf(obj) :defaultValue;
    }
    /**
     * 转为double类型
     * @param object
     * @return
     */
    public static double castDouble(Object object) {
        return CastUtil.castDouble(object,0);
    }

    /**
     * 转为double类型（提供默认值）
     * @param object
     * @param defaultValue
     * @return
     */
    public static double castDouble(Object object,double defaultValue) {
        double doubleValue = defaultValue;
        if (object != null){
            String strValue = castString(object);
            if (StringUtil.isNotEmpty(strValue)){
                try {
                    doubleValue = Double.parseDouble(strValue);
                }catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    /**
     * 转为long类型
     * @param object
     * @return
     */
    public static long castLong(Object object) {
        return CastUtil.castLong(object,0);
    }

    /**
     * 转为long类型（提供默认值）
     * @param object
     * @param defaultValue
     * @return
     */
    public static long castLong(Object object,long defaultValue) {
        long longValue = defaultValue;
        if (object != null){
            String strValue = castString(object);
            if (StringUtil.isNotEmpty(strValue)){
                try {
                    longValue = Long.parseLong(strValue);
                }catch (NumberFormatException e) {
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    /**
     * 转为int类型
     * @param object
     * @return
     */
    public static int castInt(Object object) {
        return CastUtil.castInt(object,0);
    }

    /**
     * 转为int类型（提供默认值）
     * @param object
     * @param defaultValue
     * @return
     */
    public static int castInt(Object object,int defaultValue) {
        int intValue = defaultValue;
        if (object != null){
            String strValue = castString(object);
            if (StringUtil.isNotEmpty(strValue)){
                try {
                    intValue = Integer.parseInt(strValue);
                }catch (NumberFormatException e) {
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }

    /**
     * 转为boolean类型
     * @param object
     * @return
     */
    public static boolean castBoolean(Object object) {
        return CastUtil.castBoolean(object,false);
    }

    /**
     * 转为boolean类型（提供默认值）
     * @param object
     * @param defaultValue
     * @return
     */
    public static boolean castBoolean(Object object,boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (object != null){
            booleanValue = Boolean.parseBoolean(castString(object));
        }
        return booleanValue;
    }
}
