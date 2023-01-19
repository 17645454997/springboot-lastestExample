package com.xingjiahe.www.date;

import lombok.extern.log4j.Log4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author haisongzhe
 * @date 2022/12/17
 */
@Log4j
public class DateUtilDemo {

    public static final String NORMAL_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) throws ParseException {
        String dateStartTime = "2023-01-05 21:26:54";
        String dateEndTime  = "2023-01-09 23:26:54";
        Date nowTime = new Date();
        boolean effectiveDate = withinTimeRange(nowTime, dateStartTime, dateEndTime);
        if (effectiveDate) {
            System.out.println("当前时间在范围内");
        }else {
            System.out.println("当前时间在不在范围内");
        }

    }

    /**
     * @param nowTime       当前时间
     * @param dateStartTime 开始时间  格式: "2023-01-05 21:26:54"
     * @param dateEndTime   结束时间  格式 : "2023-01-05 21:26:54"
     *                      判断当前时间在时间区间内
     * @return
     */
    public static boolean withinTimeRange(Date nowTime, String dateStartTime, String dateEndTime) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(NORMAL_FORMAT);
            Date startTime = format.parse(dateStartTime);
            Date endTime = format.parse(dateEndTime);

            if (nowTime.getTime() == startTime.getTime()
                    || nowTime.getTime() == endTime.getTime()) {
                return true;
            }

            Calendar date = Calendar.getInstance();
            date.setTime(nowTime);

            Calendar begin = Calendar.getInstance();
            begin.setTime(startTime);

            Calendar end = Calendar.getInstance();
            end.setTime(endTime);

            if (date.after(begin) && date.before(end)) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
    }

}
