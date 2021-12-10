package com.zhy.wisdom.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间日期工具类
 */
public class TimeUtil {

    private final static String TIME_FORMAT_YEAR_ONE = "yyyy-MM-dd";
    private final static String TIME_FORMAT_YEAR_TWO = "yyyy/MM/dd";
    private final static String TIME_FORMAT_YEAR_INT = "yyyyMMdd";

    private final static String TIME_FORMAT_DAY_ONE = "yyyy-MM-dd HH:mm:ss";
    private final static String TIME_FORMAT_DAY_TWO = "yyyy/MM/dd HH:mm:ss";
    private final static String TIME_FORMAT_DAY_LONG = "yyyyMMddHHmmss";

    private static String getStr(Date date, String formatStr){
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date);
    }

    private static Integer getLong(Date date, String formatStr){
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return Integer.valueOf(format.format(date));
    }

}
