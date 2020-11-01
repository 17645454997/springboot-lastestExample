//package com.xingjiahe.www.infrastructure.util;
//
//import com.alibaba.fastjson.JSON;
//import com.hellobike.constant.Consts;
//import org.apache.commons.lang.exception.ExceptionUtils;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.Period;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Map;
//
///**
// * create by zmm 弄死熊猫
// * <p>
// * on 2018/8/30
// */
//public class DateUtil {
//
//    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
//
//    public static final String yyyyMMddHHmm = "yyyyMMddHHmm";
//
//    public static final String DATE_PATTERN = "yyyyMMdd";
//
//    public static final String DATE_PATTERN_CHINA = "MM月dd日 HH:mm";
//
//    public static final String HH_MM = "HH:mm";
//
//    public static final String YEAR_MONTH = "yyyyMM";
//
//    public static final String COMMON_DATE_FORMAT = "yyyy-MM-dd HH:mm";
//
//    public static final String DATETIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
//
//    public static final String SIMPLE_DATE_Y_M_D_H_S = "yyyy年MM月dd日HH:mm:ss";
//
//    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    public static SimpleDateFormat simpleDateFormat_common = new SimpleDateFormat(COMMON_DATE_FORMAT);
//
//    public static LocalDateTime formatDateTime(String formatTimeStr, String format) {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
//        return LocalDateTime.parse(formatTimeStr, dtf);
//    }
//
//    public static String format(Date time, String pattern) throws ParseException {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        return simpleDateFormat.format(time);
//    }
//
//    public static String formatDate(Date date, String format) {
//        SimpleDateFormat stf = new SimpleDateFormat(format);
//        return stf.format(date);
//    }
//
//
//
//    public static Date parseDate(Date time, String format) throws ParseException {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
//        return simpleDateFormat.parse(simpleDateFormat.format(time));
//    }
//
//    public static Date dateFormat(Date date, String format) {
//        SimpleDateFormat stf = new SimpleDateFormat(format);
//        String formatDate = stf.format(date);
//        return str2Date(formatDate, format);
//    }
//
//    public static String timeStamp2Str(long timestamp) {
//        Date date = new Date(timestamp);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(COMMON_DATE_FORMAT);
//        return simpleDateFormat.format(date);
//    }
//
//    public static Date str2Date(String formatTimeStr, String format) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
//        try {
//            return simpleDateFormat.parse(formatTimeStr);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static Date getFutureDateOnlyDay(Date date, int days) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.DATE, days);
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        return calendar.getTime();
//    }
//
//    public static boolean isToday(Date date) {
//        Date curDate = new Date();
//        if (date != null) {
//            Calendar cal1 = Calendar.getInstance();
//            cal1.setTime(curDate);
//            Calendar cal2 = Calendar.getInstance();
//            cal2.setTime(date);
//            return isSameDay(cal1, cal2);
//        }
//        return false;
//    }
//
//    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
//        if (cal1 != null && cal2 != null) {
//            return cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA)
//                    && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
//                    && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
//        }
//        return false;
//    }
//
//    public static boolean isSameDay(Date date1, Date date2) {
//        if (date1 == null || date2 == null) {
//            return false;
//        }
//
//        try {
//            return parseDate(date1, DATE_PATTERN).getTime() == parseDate(date2, DATE_PATTERN).getTime();
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.error("DateUtil.isSameDay exception {}", ExceptionUtils.getFullStackTrace(e));
//        }
//
//        return false;
//    }
//
//    public static Date afterDate(Date date, Integer minute) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.MINUTE, minute);// 几分钟之前、后的时间
//        return calendar.getTime();
//    }
//
//    /**
//     * 当前时间的几天之后/之前
//     *
//     * @param date
//     * @param day
//     * @return
//     */
//    public static Date addDay(Date date, int day) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        c.add(Calendar.DATE, day);
//        return c.getTime();
//    }
//
//    /**
//     * 判断目标日期是否在日期区间内
//     */
//    public static boolean isInTimeDuration(Date targetDate, Date leftDate, Date rightDate) {
//        if (targetDate.before(rightDate) && targetDate.after(leftDate)) {
//            return true;
//        }
//        return false;
//    }
//
//
//
//    public static Boolean isInTimeRange(Date targetDate,String leftDate,String rightDate) {
//        SimpleDateFormat sdf = new SimpleDateFormat();
//        sdf.applyPattern("HH:mm");
//        String currentTime = sdf.format(targetDate);
//
//        int set = Integer.valueOf(currentTime.replaceAll(":", ""));
//        int begin = Integer.valueOf(leftDate.replaceAll(":", ""));
//        int end = Integer.valueOf(rightDate.replaceAll(":", ""));
//        if (begin > end) {
//            return set < end || set > begin;
//        } else {
//            return set > begin && set < end;
//        }
//    }
//
//
//
//        public static Date getTimeByDefHour(String hour) {
//        String[] hours = hour.split(":");
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours[0]));
//        cal.set(Calendar.MINUTE, Integer.parseInt(hours[1]));
//        cal.set(Calendar.SECOND, 00);
//        return cal.getTime();
//    }
//
//    public static String getPaidFormatTime(Date date) {
//        String arr[] = new String[]{"今天", "明天"};
//        Instant instant = date.toInstant();
//        Date currentDate = new Date(System.currentTimeMillis());
//
//        ZoneId zoneId = ZoneId.systemDefault();
//
//        LocalDateTime planStartlocalDateTime = instant.atZone(zoneId).toLocalDateTime();
//        String hour = planStartlocalDateTime.getHour() < 10 ? "0" + planStartlocalDateTime.getHour() : planStartlocalDateTime.getHour() + "";
//        String minute = planStartlocalDateTime.getMinute() < 10 ? "0" + planStartlocalDateTime.getMinute() : planStartlocalDateTime.getMinute() + "";
//        String str = hour + ":" + minute;
//
//        LocalDateTime currentLocalDateTime = currentDate.toInstant().atZone(zoneId).toLocalDateTime();
//        Period period = getPeriod(currentLocalDateTime, planStartlocalDateTime);
//        int days = period.getDays();
//        if (days < 2) {
//            str = arr[days] + str;
//        } else {
//            str = planStartlocalDateTime.getMonthValue() + "月" + planStartlocalDateTime.getDayOfMonth() + "日" + str;
//        }
//
//        return str;
//    }
//
//    /**
//     * 获取日期的小时和分钟
//     * 格式：02:39
//     * @param date
//     * @return
//     */
//    public static String getHourMinute(Date date) {
//        Instant instant = date.toInstant();
//
//        ZoneId zoneId = ZoneId.systemDefault();
//
//        LocalDateTime planStartlocalDateTime = instant.atZone(zoneId).toLocalDateTime();
//        String hour = planStartlocalDateTime.getHour() < 10 ? "0" + planStartlocalDateTime.getHour() : planStartlocalDateTime.getHour() + "";
//        String minute = planStartlocalDateTime.getMinute() < 10 ? "0" + planStartlocalDateTime.getMinute() : planStartlocalDateTime.getMinute() + "";
//        String str = hour + ":" + minute;
//
//        return str;
//    }
//
//    private static Period getPeriod(LocalDateTime now, LocalDateTime dob) {
//        return Period.between(now.toLocalDate(), dob.toLocalDate());
//    }
//
//    public static int getIndexOfWeek(Date date) {
//        LocalDateTime time = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//        return time.getDayOfWeek().getValue();
//    }
//
//    public static long getStamp(String time) {
//        SimpleDateFormat formatter = new SimpleDateFormat(COMMON_DATE_FORMAT);
//        long stamp = 0L;
//        try {
//            Date newDate = formatter.parse(time);
//            stamp = newDate.getTime();
//        } catch (Exception e) {
//
//        }
//        return stamp;
//    }
//
//    /**
//     * 计算给定日前是周几
//     *
//     * @param date
//     * @return
//     */
//    public static int getDayOfWeek(Date date) {
//        if (date == null) {
//            return 0;
//        }
//        int[] weekDays = {7, 1, 2, 3, 4, 5, 6};
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
//        return weekDays[w];
//    }
//
//    public static long timesBetweenMinute(long planStartTime, long createTime) {
//        long result = (planStartTime - createTime) / (1000 * 60);
//        return result;
//    }
//
//    public static long timesBetweenMinute(Date planStartTime, Date createTime) {
//
//        Calendar cal1 = Calendar.getInstance();
//        cal1.setTime(createTime);
//        long time1 = cal1.getTimeInMillis();
//
//        Calendar cal2 = Calendar.getInstance();
//        cal2.setTime(planStartTime);
//        long time2 = cal2.getTimeInMillis();
//
//        long result = (time2 - time1) / (1000 * 60);
//
//        return result;
//    }
//
//    /**
//     * 获取给定日期的小时数
//     */
//    public static Integer getHour(Date date) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        return calendar.get(Calendar.HOUR_OF_DAY);
//    }
//
//    /**
//     * 时间字符串转时间戳,时间以半点为分界，小于半点，向下取整；大于半点，向上取整
//     */
//    public static Long strToStamp(String time) {
//        // 小于，向下取整
//        if (getStamp(time, Consts.ORIGIN_HOUR_FORMAT) < getStamp(time, Consts.HALF_HOUR_FORMAT)) {
//            return getStamp(time, Consts.ORIGIN_HOUR_FORMAT_V2);
//        } else {
//            return getStamp(time, Consts.ORIGIN_HOUR_FORMAT_V2) + 60 * 60 * 1000;
//        }
//    }
//
//    /**
//     * 将long形的数据转化为标准时间格式
//     *
//     * @param longTime
//     * @return
//     * @throws ParseException
//     */
//    public static String longToStr(Long longTime) {
//        return simpleDateFormat_common.format(longTime);
//    }
//
//    private static long getStamp(String time, String spliceStr) {
//        long newStamp = 0L;
//        try {
//            String newTime = "";
//            if (spliceStr.equals(Consts.HALF_HOUR_FORMAT)) {
//                // :30:00
//                newTime = time.substring(0, 13).concat(spliceStr);
//            } else if (spliceStr.equals(Consts.ORIGIN_HOUR_FORMAT)) {
//                // :00
//                newTime = time.concat(Consts.ORIGIN_HOUR_FORMAT);
//            } else {
//                // :00:00
//                newTime = time.substring(0, 13).concat(spliceStr);
//            }
//            Date newDate = simpleDateFormat.parse(newTime);
//            newStamp = newDate.getTime();
//        } catch (ParseException e) {
//            Map<String, Object> logMap = Maps.newHashMap();
//            logMap.put("time", time);
//            logMap.put("spliceStr", spliceStr);
//            logMap.put("exception", JSON.toJSONString(e));
//            YunLogger.yun.metric("data.util.getStamp.error", 0.0, logMap);
//        }
//        return newStamp;
//    }
//
//    /**
//     * 校验当前时间是否大于给定时间string加上指定时间间隔后的时间
//     *
//     * @param startTime          格式如，15:15
//     * @param intervalHour，单位小时数
//     * @return
//     */
//    public static Boolean checkCurrentTime(String startTime, Integer intervalHour) {
//        Date currentDate = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat(DATETIME_FORMATTER);
//        // 当前时间字符串
//        String dateStr = formatter.format(currentDate);
//        // 给定时间转成当前时间同一天时间
//        String startTimeTodayStr = dateStr.substring(0, 11).concat(startTime);
//        Date startTimeTodayDate = str2Date(startTimeTodayStr, COMMON_DATE_FORMAT);
//        // 加上指定时间间隔
//        Date addHour = afterDate(startTimeTodayDate, intervalHour * 60);
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(currentDate);
//        long currentTime = cal.getTimeInMillis();
//
//        cal.setTime(addHour);
//        long addHourTime = cal.getTimeInMillis();
//
//        // 当前时间是否大于给定时间string加上指定时间间隔后的时间
//        return currentTime - addHourTime > 0;
//    }
//
//    /**
//     * 去除秒
//     */
//    public static Date removeSecond(Date date) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        return calendar.getTime();
//    }
//}
