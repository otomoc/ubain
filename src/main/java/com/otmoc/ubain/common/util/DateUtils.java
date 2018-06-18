package com.otmoc.ubain.common.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

public class DateUtils {

    private static final DateTimeFormatter STD_DATE_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter STD_DATETIME_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 将标准的yyyy-MM-dd字符串转化为日期
     * @param dateStr
     * @return
     */
    public static Date toSTDDate(String dateStr) {
        if (dateStr == null) {
            return getNullDate();
        }

        return parse(dateStr, STD_DATE_FORMAT);
    }

    /**
     * 将标准的yyyy-MM-dd HH:mm:ss字符串转化为日期时间
     *
     * @param dateStr
     * @return
     */
    public static Date toSTDDateTime(String dateStr) {
        if (dateStr == null) {
            return getNullDate();
        }

        return parse(dateStr, STD_DATETIME_FORMAT);
    }



    private static Date parse(String dateStr, DateTimeFormatter formatter) {
        DateTime dateTime = DateTime.parse(dateStr, formatter);
        return dateTime.toDate();
    }

    private static Date getNullDate() {
        return null;
    }
}
