package com.zhy.wisdom.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils extends Date {
    public static final String DATE = "yyyy-MM-dd";
    public static final String DATE2 = "yyyy/MM/dd";
    public static final String TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String NUMDATE = "yyyyMMdd";
    public static final String NUMTIME = "yyyyMMddHHmmss";
    private String curFormat = "yyyyMMdd";

    public DateUtils() {
        this.curFormat = "yyyy-MM-dd HH:mm:ss";
    }

    public DateUtils(long date) {
        super(date);
        this.curFormat = "yyyy-MM-dd HH:mm:ss";
    }

    public DateUtils(Date date) {
        super(date.getTime());
        this.curFormat = "yyyy-MM-dd HH:mm:ss";
    }

    private String string;

    public DateUtils(String string) {
        this.string = string;
    }

    public String getCurFormat() {
        return this.curFormat;
    }

    public DateUtils setCurFormat(String curFormat) {
        this.curFormat = curFormat;
        return this;
    }

    public Date asDate() {
        return new Date(this.getTime());
    }

    public static DateUtils fromLong(long date, String... format) {
        String fm = format != null && format.length != 0 ? format[0] : "yyyyMMdd";
        return (new DateUtils(date + "")).parseDate(fm, new DateUtils[0]);
    }

    public static DateUtils fromStr(String date, String... format) {
        String fm = format != null && format.length != 0 ? format[0] : "yyyy-MM-dd";
        return (new DateUtils(date)).parseDate(fm, new DateUtils[0]);
    }

    public Calendar getCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this);
        return cal;
    }

    public String toStr(String... format) {
        if (format != null && format.length > 0) {
            this.curFormat = format[0];
        }

        SimpleDateFormat sdf = new SimpleDateFormat(this.curFormat);
        return sdf.format(this.getTime());
    }

    public DateUtils stepDay(int step) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this);
        cal.add(5, step);
        return (new DateUtils(cal.getTime())).setCurFormat(this.curFormat);
    }

    public DateUtils stepHour(int step) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this);
        cal.add(11, step);
        return (new DateUtils(cal.getTime())).setCurFormat(this.curFormat);
    }

    public DateUtils stepMinute(int step) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this);
        cal.add(12, step);
        return (new DateUtils(cal.getTime())).setCurFormat(this.curFormat);
    }

    public DateUtils stepSecond(int step) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this);
        cal.add(13, step);
        return (new DateUtils(cal.getTime())).setCurFormat(this.curFormat);
    }

    public DateUtils stepMilliSecond(int step) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this);
        cal.add(14, step);
        return (new DateUtils(cal.getTime())).setCurFormat(this.curFormat);
    }

    public int toLong(String... format) {
        this.curFormat = format != null && format.length != 0 ? format[0] : this.curFormat;
        String numDate = this.toStr();
        return Integer.valueOf(numDate);
    }

    public int getWhat(int field) {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        return c.get(field);
    }

    public long getDiff(Date date, TimeUnit unit) {
        long diff = Math.abs(this.getTime() - date.getTime());
        return unit.equals(TimeUnit.DAYS) ? diff / 86400000L : (unit.equals(TimeUnit.HOURS) ? diff / 3600000L : (unit.equals(TimeUnit.MINUTES) ? diff / 60000L : (unit.equals(TimeUnit.SECONDS) ? diff / 1000L : diff)));
    }

    public long getMinuteOfDay() {
        return (long)(this.getWhat(12) + this.getWhat(11) * 60);
    }

    public long getWhatOfDay(TimeUnit unit) {
        int minutes = this.getWhat(12) + this.getWhat(11) * 60;
        return unit.equals(TimeUnit.MINUTES) ? (long)minutes : (unit.equals(TimeUnit.SECONDS) ? (long)(minutes * 60 + this.getWhat(13)) : (long)((minutes * 60 + this.getWhat(13)) * 1000));
    }

    public DateUtils formatDate(String... format) {
        this.curFormat = format != null && format.length != 0 ? format[0] : this.curFormat;
        String strDate = this.toStr();
        return (new DateUtils(strDate)).parseDate(this.curFormat, new DateUtils[0]);
    }

    public DateUtils parseDate(String format, DateUtils... def) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return (new DateUtils(sdf.parse(this.string).getTime())).setCurFormat(format);
        } catch (ParseException var4) {
            var4.printStackTrace();
            return def != null && def.length != 0 ? def[0] : null;
        }
    }

    public static void main(String[] args) {
        new DateUtils();
        new DateUtils(System.currentTimeMillis());
        new DateUtils(new Date());
        DateUtils date = fromStr("2018-11-11");
        date = fromStr("2018/11/11", "yyyy/MM/dd");
        date = fromLong(20181111L);
        date = fromLong(20181111093000L, "yyyyMMddHHmmss");
        date.toStr("yyyy-MM-dd");
        String dateStr = date.setCurFormat("yyyy-MM-dd").toStr();
        long longDate = (long)date.toLong("yyyyMMdd");
        longDate = (long)date.setCurFormat("yyyyMMdd").toLong();
        date = (new DateUtils()).formatDate("yyyy-MM-dd");
        date = (new DateUtils()).stepDay(-1);
        date = (new DateUtils()).stepDay(2);
        date = (new DateUtils()).stepHour(1);
        date = (new DateUtils()).stepMinute(-1);
        date = (new DateUtils()).formatDate("yyyy-MM-dd").stepDay(1);
        int day = (new DateUtils()).getWhat(5);
        int weekDay = (new DateUtils()).getWhat(7);
        int hour = (new DateUtils()).getWhat(11);
        Calendar cal = (new DateUtils()).getCalendar();
        dateStr = fromStr("2018-10-01").formatDate("yyyyMMdd").toStr();
        System.out.println((new DateUtils()).getWhat(12));
        System.out.println((new DateUtils()).getWhat(11));
        System.out.println((new DateUtils()).getWhatOfDay(TimeUnit.MINUTES));
        System.out.println(fromStr("2019-04-30").stepDay(-250).toStr());
        System.out.println((new DateUtils()).getDiff(fromLong(20181201L), TimeUnit.HOURS));
        System.out.println((new DateUtils()).formatDate("yyyy-MM-dd").stepMinute(652));
    }
}
