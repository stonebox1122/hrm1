package com.stone.hrm.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author stone
 * @date 2019/5/30 15:24
 * description 日期工具类
 */
public class DateUtils {

    /**
     * 将日期时间字符串2019-05-29 13:55:15转换为20190529135515
     * @param strDate 日期格式的字符串：yyyy-MM-dd HH:mm:ss
     * @return 日期格式字符串：yyyyMMddHHmmss
     * @throws ParseException
     */
    public static String getDateAndTime(String strDate) throws ParseException{
        SimpleDateFormat sourceFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sourceFormatter.parse(strDate);

        SimpleDateFormat targetFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return targetFormatter.format(date).toString();
    }

    public static void main(String[] args) {
       String strDate = "2019-05-29 13:55:15";
        try {
            System.out.println(DateUtils.getDateAndTime(strDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
