package com.jerry.tools.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前日期
     */
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    /**
     * 获取当前时间
     */
    public static LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    /**
     * 获取当前日期时间
     */
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取格式化后的日期字符串
     */
    public static String formatDate(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    /**
     * 获取格式化后的时间字符串
     */
    public static String formatTime(LocalTime time) {
        return time.format(TIME_FORMATTER);
    }

    /**
     * 获取格式化后的日期时间字符串
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(DATE_TIME_FORMATTER);
    }

    /**
     * 解析日期字符串为 LocalDate 对象
     */
    public static LocalDate parseDate(String dateString) {
        return LocalDate.parse(dateString, DATE_FORMATTER);
    }

    /**
     * 解析时间字符串为 LocalTime 对象
     */
    public static LocalTime parseTime(String timeString) {
        return LocalTime.parse(timeString, TIME_FORMATTER);
    }

    /**
     * 解析日期时间字符串为 LocalDateTime 对象
     */
    public static LocalDateTime parseDateTime(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, DATE_TIME_FORMATTER);
    }

    public static void main(String[] args) {
        // 使用示例
        LocalDate currentDate = getCurrentDate();
        LocalTime currentTime = getCurrentTime();
        LocalDateTime currentDateTime = getCurrentDateTime();

        System.out.println("当前日期：" + formatDate(currentDate));
        System.out.println("当前时间：" + formatTime(currentTime));
        System.out.println("当前日期时间：" + formatDateTime(currentDateTime));

        String dateString = "2023-10-01";
        String timeString = "12:00:00";
        String dateTimeString = "2023-10-01 12:00:00";

        LocalDate parsedDate = parseDate(dateString);
        LocalTime parsedTime = parseTime(timeString);
        LocalDateTime parsedDateTime = parseDateTime(dateTimeString);

        System.out.println("解析后的日期：" + formatDate(parsedDate));
        System.out.println("解析后的时间：" + formatTime(parsedTime));
        System.out.println("解析后的日期时间：" + formatDateTime(parsedDateTime));
    }
}