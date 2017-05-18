package com.ieds.util;


import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Created by jia on 2017/5/9.
 */
public class DateUtils {
    /**
     * yyyy-MM-dd
     * @param
     * @return
     */
    public static final String patternA = "yyyy-MM-dd";
    /**
     * yyyyMMdd
     * @param
     * @return
     */
    public static final String patternB = "yyyyMMdd";
    /**
     * yyyy-MM-dd HH-mm-ss
     * @param
     * @return
     */
    public static final String patternC = "yyyy-MM-dd HH-mm-ss";
    /**
     * @param yyyy:MM:dd HH:mm:ss
     * @return
     */
    public static final String patternD = "yyyy-MM-dd HH:mm:ss";
    /**
     * @param yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static final String patternE = "yyyy-MM-dd HH:mm";

    /**
     * @param yyyyMMddHHmmss
     * @return
     */
    public static final String patternF = "yyyyMMddHHmmss";

    public static final String patternG = "yyyy��MM��dd��";

    /**
     * @param yyyy-MM
     * @return
     */
    public static final String patternH = "yyyy-MM";

    public static final String patternI = "yyyyMM";


    /**
     * ��ʽ������Ϊyyyy-MM-dd
     * @param date
     * @return
     */
    public static String formateDate(Date date){
        return dateToString(date,patternA);
    }

    /**
     * ��ʽ������Ϊyyyy-MM
     * @param date
     * @return
     */
    public static String formateYearAndMonth(Date date){
        return dateToString(date,patternH);
    }

    /**
     * ȡ��������
     * @param
     * @return
     */
    public static Date getDate() {
        return Calendar.getInstance().getTime();
    }
    /**
     * ȡָ�������յ�����,��ʽΪyyyy-MM-dd,HH-mm-ss 00-00-00
     * @param
     * @return
     */
    public static Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month-1, day,0,0,0);
        return cal.getTime();

    }
    /**
     * ȡָ����,��,��,Сʱ,��,���ʱ��
     * @param
     * @return
     */
    public static Date getDate(int year,int month,int date,int hour,int mintue,int second)
    {
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month-1);
        cal.set(Calendar.DATE,date);
        cal.set(Calendar.HOUR_OF_DAY,hour);
        cal.set(Calendar.MINUTE,mintue);
        cal.set(Calendar.SECOND,second);
        return cal.getTime();
    }


    /**
     * @param days=n nΪ-,��ȡn��ǰ,nΪ+,��ȡn��������
     * @param date
     * @param days
     * @return
     */
    public static Date getSomeDaysBeforeAfter(Date date, int days){
        GregorianCalendar gc =new GregorianCalendar();
        gc.setTime(date);
        gc.add(5, days);
        gc.set(gc.get(Calendar.YEAR),gc.get(Calendar.MONTH),gc.get(Calendar.DATE));
        return gc.getTime();
    }
    /**
     * ȡָ���������
     * @param
     * @return
     */
    public static int getDateYear(Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }
    /**
     * ȡָ�������·�
     * @param
     * @return
     */
    public static int getDateMonth(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH)+1;
    }
    /**
     * ȡָ�������շ�
     * @param
     * @return
     */
    public static int getDateDay(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DATE);
    }
    /**
     * ȡָ������Сʱ
     * @param
     * @return
     */
    public static int getDateHour(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }
    /**
     * ȡָ�����ڷ���
     * @param
     * @return
     */
    public static int getDateMinute(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }
    /**
     * ȡָ�����ڵĵڶ���Ŀ�ʼʱ��,Сʱ,��,��Ϊ00:00:00
     * @param
     * @return
     */
    public static Date getNextDayStartTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return getNextDayStart(c.get(Calendar.YEAR),
                c.get(Calendar.MONTH)+1, c.get(Calendar.DATE));
    }


    /**
     * ȡָ����,��,�յ���һ�յĿ�ʼʱ��,Сʱ,��,��Ϊ00:00:00
     * ��Ҫ������ȡ���·ݵ�����
     * @param year
     * @param monthIn
     * @param date
     * @return
     */
    public static Date getNextDayStart(int year, int monthIn, int date) {
        int month = monthIn - 1;
        boolean lastDayOfMonth = false;
        boolean lastDayOfYear = false;

        Calendar time = Calendar.getInstance();
        time.set(year, month, date, 0, 0, 0);
        Calendar nextMonthFirstDay = Calendar.getInstance();
        nextMonthFirstDay.set(year, month + 1, 1, 0, 0, 0);

        if (time.get(Calendar.DAY_OF_YEAR) + 1 == nextMonthFirstDay.get(Calendar.DAY_OF_YEAR))
            lastDayOfMonth = true;

        if (time.get(Calendar.DAY_OF_YEAR) == time.getMaximum(Calendar.DATE))
            lastDayOfYear = true;

        time.roll(Calendar.DATE, 1);

        if (lastDayOfMonth)
            time.roll(Calendar.MONTH, 1);

        if (lastDayOfYear)
            time.roll(Calendar.YEAR, 1);


        return time.getTime();
    }

    /**
     * ȡָ�����ڵ���һ�յ�ʱ��
     * @param date
     * @return
     */
    public static Date nextDate(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE,1);
        return cal.getTime();
    }

    /**
     * ָ�����ڵ���һ�յĿ�ʼʱ��,Сʱ,��,��Ϊ00:00:00
     * @param date
     * @return
     */
    public static Date getStartDateNext(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE,1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        return cal.getTime();
    }

    /**
     * ָ�����ڵĿ�ʼʱ��,Сʱ,��,��Ϊ00:00:00
     * @param date
     * @return
     */
    public static Date getStartDateDay(Date date)
    {
        if(date == null)
            return null;
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        return cal.getTime();
    }

    /**
     * ָ�����ڵĽ���ʱ��,Сʱ,��,��Ϊ23:59:59
     * @param date
     * @return
     */
    public static Date getEndDateDay(Date date)
    {
        if(date == null)
            return null;
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE,59);
        cal.set(Calendar.SECOND,59);
        return cal.getTime();
    }

    /**
     * ��ָ������,��ָ��pattern��ʽ,���Stringֵ
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToString(Date date ,String pattern) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.format(date);
        }
    }

    public static String dateToString1(Date date, String formatIn) {
        String format=formatIn;
        if (date == null) {
            return "";
        }
        if (format == null) {
            format = patternD;
        }
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
        return sdf.format(date);
    }


    /**
     * ��ָ����,��,�յ�����תΪ�ַ���,��ʽΪyyyy-MM-dd
     * @param year
     * @param month
     * @param day
     * @param pattern
     * @return
     */
    public static String dateToString(int year, int month, int day, String pattern) {
        return dateToString(getDate(year, month, day), pattern);
    }


    /**
     * ��ָ���ַ�������תΪ������,,��ʽΪָ����pattern
     * @param string
     * @param pattern
     * @return
     */
    public static Date stringToDate(String string, String pattern){
        SimpleDateFormat format = (SimpleDateFormat)DateFormat.getDateInstance();
        format.applyPattern(pattern);
        try {
            return format.parse(string);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * ��ָ���ַ�������תΪ������,ָ����ʽΪyyyy-MM-dd
     * @param string
     * @return
     */
    public static Date stringToDate(String string){
        return stringToDate(string, patternA);
    }

    /**
     * �����������֮����������
     * startDate ��ʼ������
     * endDate ����������
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getDays(Date startDate, Date endDate) {
        int elapsed = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        Date d1 = cal.getTime();

        cal.setTime(endDate);
        Date d2 = cal.getTime();

        long daterange = d2.getTime() - d1.getTime();
        long time = 1000*3600*24; //һ��ĺ�����
        elapsed = (int) (daterange/time);
        return elapsed;
    }

    /**
     * date
     * startTime ��ʽΪ0800����ʾ����8��00��
     * endTime��ʽΪ2200
     * @param date
     * @param startTimeIn
     * @param endTimeIn
     * @return
     */
    public static boolean isWorkHour(Date date,String startTimeIn,String endTimeIn){//�Ƿ��ǹ���ʱ��
        String startTime=startTimeIn;
        String endTime=endTimeIn;
        if(StringUtils.isEmpty(startTime))
            startTime = "0800";
        if(StringUtils.isEmpty(endTime))
            endTime = "2200";
        int start = Integer.parseInt(startTime);
        int end = Integer.parseInt(endTime);
        int hour = getDateHour(date);
        int m = getDateMinute(date);
        String hstr = hour<=9?"0"+hour:hour+"";
        String mstr = m<=9?"0"+m:m+"";
        int dateInt = Integer.parseInt(hstr+mstr);
        if(dateInt>=start&&dateInt<=end){
            return true;
        }
        return false;
    }

    /**
     * ���ݴ������ڣ����ش����ж�����
     * date ��ʽΪ  201408
     * @param date
     * @return
     */
    public static  int getDayOfMonth(String date){
        int year = Integer.parseInt(date.substring(0, 3));
        int month = Integer.parseInt(date.substring(date.length()-1, date.length()));

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH, month-1);//Java�·ݲ�0��ʼ��  6������һ����7��
        int dateOfMonth = cal.getActualMaximum(Calendar.DATE);
        return dateOfMonth;
    }

    /**
     * ȡָ�������·�ǰһ��
     * @param date
     * @return
     */
    public static int getLastDateMonth(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH);
    }
    //ȡ���ڵĵ�ǰ�µ�һ��
    public static Date getMonthFirstDay(Date date){
        return getDate(getDateYear(date), getDateMonth(date), 1);
    }

    //ǰ�µ�һ��
    public static Date getLastDateMonthDay(Date date){
        return getDate(getDateYear(date), getLastDateMonth(date), 1);
    }
}
