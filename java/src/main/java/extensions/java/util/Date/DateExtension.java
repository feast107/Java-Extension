package extensions.java.util.Date;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Extension
public class DateExtension {
    /**
     * 返回当前时间
     *
     * @return {@link Date}
     */
    @Extension
    public static Date now() {
        return new Date();
    }

    /**
     * 从秒数获取时间
     *
     * @param second 秒数
     * @return {@link Date}
     */
    @Extension
    public static Date fromSeconds(int second) {
        return new Date(1000L * second);
    }

    /**
     * 从分钟数获取时间
     *
     * @param minute 分钟
     * @return {@link Date}
     */
    @Extension
    public static Date fromMinutes(int minute) {
        return new Date(1000L * 60 * minute);
    }

    /**
     * 从小时数获取时间
     *
     * @param hour 小时数
     * @return {@link Date}
     */
    @Extension
    public static Date fromHours(int hour) {
        return new Date(1000L * 60 * 60 * hour);
    }

    /**
     * 从天数获取时间
     *
     * @param days 天数
     * @return {@link Date}
     */
    @Extension
    public static Date fromDays(int days) {
        return new Date(TimeUnit.DAYS.toMillis(days));
    }

    /**
     * 增加毫秒
     * @param date 当前日期
     * @param millionSecond 毫秒数
     * @return 增加后的日期
     */
    public static Date addMillionSeconds(@This Date date, int millionSecond) {
        return new Date(date.getTime() + millionSecond);
    }

    public static Date addSeconds(@This Date date, int second) {
        return new Date(date.getTime() + 1000L * second);
    }

    public static Date addMinutes(@This Date date, int minute) {
        return new Date(date.getTime() + 1000L * 60 * minute);
    }

    public static Date addHours(@This Date date, int hour) {
        return new Date(date.getTime() + 1000L * 60 * 60 * hour);
    }

    public static Date addDays(@This Date date, int day) {
        return new Date(date.getTime() + TimeUnit.DAYS.toMillis(day));
    }

    public static Date add(@This Date date, Date another) {
        return new Date(date.getTime() + another.getTime());
    }

    public static Date minus(@This Date date, Date another) {
        long res = date.getTime() - another.getTime();
        return new Date(res > 0 ? res : 0L);
    }

    public static double totalMillionSeconds(@This Date date) {
        return date.getTime();
    }

    public static double totalSeconds(@This Date date) {
        return date.getTime() / 1000.0;
    }

    public static double totalMinutes(@This Date date) {
        return date.getTime() / 1000.0 / 60;
    }

    public static double totalHours(@This Date date) {
        return date.getTime() / 1000.0 / 60 / 60;
    }

    public static double totalDays(@This Date date) {
        return date.getTime() / 1000.0 / 60 / 60 / 24;
    }
}
