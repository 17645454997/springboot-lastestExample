package com.xingjiahe.www.infrastructure.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @Auther: yushiwei
 * @Date: 2019/5/14 14:45
 * @Description: jdk8线程安全时间工具类
 */
public class LocalTimeUtils {

    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter MONTH_FORMATTER    = DateTimeFormatter.ofPattern("yyyy-MM");
    public static final DateTimeFormatter DATE_FORMATTER     = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter TIME_FORMATTER     = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static LocalDate parseLocalDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, DATE_FORMATTER);
        }catch (Exception e){
            LogUtils.ERROR.error("日期转换异常",e);
        }
        return null;
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeStr) {
        try {
            return LocalDateTime.parse(dateTimeStr, DATETIME_FORMATTER);
        }catch (Exception e){
            LogUtils.ERROR.error("日期转换异常",e);
        }
        return null;
    }

    public static LocalTime parseLocalTime(String timeStr) {
        try {
            return LocalTime.parse(timeStr, TIME_FORMATTER);
        }catch (Exception e){
            LogUtils.ERROR.error("日期转换异常",e);
        }
        return null;
    }

    public static String formatLocalDate(LocalDate date) {
        try {
            return date.format(DATE_FORMATTER);
        }catch (Exception e){
            LogUtils.ERROR.error("日期转换异常",e);
        }
        return null;
    }

    public static String formatLocalDateTime(LocalDateTime datetime) {
        try {
            return datetime.format(DATETIME_FORMATTER);
        }catch (Exception e){
            LogUtils.ERROR.error("日期转换异常",e);
        }
        return null;
    }

    public static String formatLocalTime(LocalTime time) {
        try {
            return time.format(TIME_FORMATTER);
        }catch (Exception e){
            LogUtils.ERROR.error("日期转换异常",e);
        }
        return null;
    }

    /**
     * 日期相隔月数
     * @param startDateInclusive
     * @param endDateExclusive
     * @return
     */
    public static long periodMonths(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        try {
            return startDateInclusive.until(endDateExclusive, ChronoUnit.MONTHS);
        }catch (Exception e){
            LogUtils.ERROR.error("日期转换异常",e);
        }
        return 0;
    }

    /**
     * 日期相隔天数
     * @param startDateInclusive
     * @param endDateExclusive
     * @return
     */
    public static long periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        try {
            return startDateInclusive.until(endDateExclusive, ChronoUnit.DAYS);
        }catch (Exception e){
            LogUtils.ERROR.error("日期转换异常",e);
        }
        return 0;
    }

    /**
     * 日期相隔小时
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
        try {
            return startInclusive.until(endExclusive, ChronoUnit.HOURS);
        }catch (Exception e){
            LogUtils.ERROR.error("日期转换异常",e);
        }
        return 0;
    }

    /**
     * 日期相隔分钟
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
        try {
            return startInclusive.until(endExclusive, ChronoUnit.MINUTES);
        }catch (Exception e){
            LogUtils.ERROR.error("日期转换异常",e);
        }
        return 0;
    }

    /**
     * 日期相隔秒数
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationSeconds(Temporal startInclusive, Temporal endExclusive) {
        try {
            return startInclusive.until(endExclusive, ChronoUnit.SECONDS);
        }catch (Exception e){
            LogUtils.ERROR.error("日期转换异常",e);
        }
        return 0;
    }

    /**
     * 日期相隔毫秒数
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
        try {
            return startInclusive.until(endExclusive, ChronoUnit.MILLIS);
        }catch (Exception e){
            LogUtils.ERROR.error("日期转换异常",e);
        }
        return 0;
    }

    /**
     * 返回当前的日期
     * @return
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 返回当前时间
     * @return
     */
    public static LocalTime getCurrentLocalTime() {
        return LocalTime.now();
    }

    public static LocalDateTime get() {
        return LocalDateTime.now();
    }

    public static int getYear() {
        return get().getYear();
    }

    public static LocalDateTime withYear(int year) {
        return get().withYear(year);
    }

    public static int getMonth() {
        return get().getMonthValue();
    }

    public static LocalDateTime firstDayOfThisYear(int year) {
        return withYear(year).with(TemporalAdjusters.firstDayOfYear()).with(LocalTime.MIN);
    }

    /**
     * @Title: getFirstDayOfThisYear
     * @Description: 获取设置所属年最初时间
     * @param year
     * @return String
     */
    public static String getFirstDayOfThisYear(int year) {
        LocalDateTime firstDayOfThisYear = firstDayOfThisYear(year);
        return DATETIME_FORMATTER.format(firstDayOfThisYear);
    }

    public static LocalDateTime lastDayOfThisYear(int year) {
        return withYear(year).with(TemporalAdjusters.lastDayOfYear()).with(LocalTime.MAX);
    }

    /**
     * @Title: getLastDayOfThisYear
     * @Description: 获取设置所属年最后时间
     * @param year
     * @return String
     */
    public static String getLastDayOfThisYear(int year) {
        LocalDateTime lastDayOfThisYear = lastDayOfThisYear(year);
        return DATETIME_FORMATTER.format(lastDayOfThisYear);
    }

    /**
     * @Title: getFirstDayOfThisMonth
     * @Description: 获取本月的第一天
     * @return String
     */
    public static String getFirstDayOfThisMonth() {
        LocalDateTime firstDayOfThisYear = get().with(TemporalAdjusters.firstDayOfMonth());
        return DATETIME_FORMATTER.format(firstDayOfThisYear);
    }

    /**
     * 功能描述:date转LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date)
    {
        try {
            Instant instant = date.toInstant();
            ZoneId zone = ZoneId.systemDefault();
            return LocalDateTime.ofInstant(instant, zone);
        }catch (Exception e){
            LogUtils.ERROR.error("日期转换异常",e);
        }
        return null;
    }

    /**
     * @Title: getFirstDayOfThisMonth
     * @Description: 获取本月的最末天
     * @return String
     */
    public static String getLastDayOfThisMonth() {
        LocalDateTime firstDayOfThisYear = get().with(TemporalAdjusters.lastDayOfMonth());
        return DATETIME_FORMATTER.format(firstDayOfThisYear);
    }

    /**
     * @Title: plusDays
     * @Description: 当前日期向后推多少天s
     * @param days
     * @return LocalDateTime
     */
    public static LocalDateTime plusDays(int days) {
        return get().plusDays(days);
    }

    /**
     * @Title: plusDays
     * @Description: 当前日期向后推多少天s
     * @param days
     * @return LocalDateTime
     */
    public static LocalDateTime minusDays(int days) {
        return get().minusDays(days);
    }

    /**
     * @Title: firstDayOfWeekInYearMonth
     * @Description: 获取指定年月的第一个周一
     * @param year
     * @param month
     * @return LocalDateTime
     */
    public static LocalDateTime firstDayOfWeekInYearMonth(int year, int month) {
        return get().withYear(year).withMonth(month).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
    }

    /**
     * @Title: todayStart
     * @Description: 当天开始时间
     * @return LocalDateTime
     */
    public static LocalDateTime todayStart() {
        return LocalDateTime.of(getCurrentLocalDate(), LocalTime.MIN);
    }

    /**
     * @Title: todayEnd
     * @Description: 当天结束时间
     * @return LocalDateTime
     */
    public static LocalDateTime todayEnd() {
        return LocalDateTime.of(getCurrentLocalDate(), LocalTime.MAX);
    }

    /**
     * @Title: getStartDayOfWeekToString
     * @Description: 获取周第一天
     * @return String
     */
    public static String getStartDayOfWeekToString() {
        return formatLocalDate(getStartDayOfWeek());
    }

    public static LocalDate getStartDayOfWeek() {
        TemporalAdjuster FIRST_OF_WEEK = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.minusDays(localDate
                .getDayOfWeek().getValue() - DayOfWeek.MONDAY.getValue()));
        return getCurrentLocalDate().with(FIRST_OF_WEEK);
    }

    /**
     * @Title: getEndDayOfWeekToString
     * @Description: 获取周最后一天
     * @return String
     */
    public static String getEndDayOfWeekToString() {
        return formatLocalDate(getEndDayOfWeek());
    }

    public static LocalDate getEndDayOfWeek() {
        TemporalAdjuster LAST_OF_WEEK = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.plusDays(
                DayOfWeek.SUNDAY.getValue() - localDate.getDayOfWeek().getValue()));
        return getCurrentLocalDate().with(LAST_OF_WEEK);
    }


    public static LocalDateTime longToLocalDateTime(Long timestamp) {
        try {
            return Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        }catch (Exception e){
            LogUtils.ERROR.error("日期转换异常",e);
        }
        return null;
    }


    public static void main(String[] args) {
        //
        Integer year = 2019;
        System.out.println(getFirstDayOfThisYear(year));
        System.out.println(getLastDayOfThisYear(year));
        //
        System.out.println(DATETIME_FORMATTER.format(plusDays(1)));
        System.out.println(DATETIME_FORMATTER.format(plusDays(-1)));

        // 取第一个周一
        LocalDate ld = LocalDate.parse("2019-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(DATE_FORMATTER.format(ld));
        //
        System.out.println(DATETIME_FORMATTER.format(firstDayOfWeekInYearMonth(year, 3)));
        System.out.println("-------------------");
        // new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format();
        System.out.println(getStartDayOfWeekToString());
        System.out.println(getEndDayOfWeekToString());
        System.out.println("-------------------");
        System.out.println(DATETIME_FORMATTER.format(todayStart()));
        System.out.println(DATETIME_FORMATTER.format(todayEnd()));
    }
}
