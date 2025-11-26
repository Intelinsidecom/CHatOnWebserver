package com.coolots.chaton.setting.view.datausage;

import com.coolots.chaton.setting.data.ChatONSettingData;
import com.sds.coolots.MainApplication;
import com.sds.coolots.calllog.model.CallDataUsage;
import java.util.Calendar;

/* loaded from: classes.dex */
public class DataUsageInfoManager {
    public static final int CURRENT_MONTH = 0;
    private static final boolean MOBILE_CALL = false;

    public static class CycleTimeData {
        int endDay;
        int endMon;
        int endYear;
        int startDay;
        int startMon;
        int startYear;
    }

    private static int getTodayDay() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(5);
        return day;
    }

    private static int getDiffYearFromCurMonth(int diff) {
        Calendar cal = Calendar.getInstance();
        cal.add(2, diff);
        int year = cal.get(1);
        return year;
    }

    private static int getDiffMonthFromCurMonth(int diff) {
        Calendar cal = Calendar.getInstance();
        cal.add(2, diff);
        int mon = cal.get(2);
        return mon;
    }

    private static int getDayCountDiffMonth(int diff) {
        Calendar cal = Calendar.getInstance();
        cal.add(2, diff);
        int count = cal.getActualMaximum(5);
        return count;
    }

    public static CycleTimeData getCycleTimeData(int diffMonth) {
        int cycleDay = ChatONSettingData.getInstance().getCycleDayPref();
        int todayDay = getTodayDay();
        CycleTimeData cycleTimeData = new CycleTimeData();
        if (cycleDay == 1) {
            cycleTimeData.startYear = getDiffYearFromCurMonth(diffMonth);
            cycleTimeData.startMon = getDiffMonthFromCurMonth(diffMonth);
            cycleTimeData.startDay = cycleDay;
            cycleTimeData.endYear = getDiffYearFromCurMonth(diffMonth);
            cycleTimeData.endMon = getDiffMonthFromCurMonth(diffMonth);
            cycleTimeData.endDay = getDayCountDiffMonth(diffMonth);
            return cycleTimeData;
        }
        if (cycleDay > todayDay) {
            return getTimeData(cycleDay, diffMonth - 1);
        }
        return getTimeData(cycleDay, diffMonth);
    }

    private static CycleTimeData getTimeData(int cycleDay, int month) {
        CycleTimeData cycleTimeData = new CycleTimeData();
        cycleTimeData.startYear = getDiffYearFromCurMonth(month);
        cycleTimeData.startMon = getDiffMonthFromCurMonth(month);
        cycleTimeData.startDay = cycleDay;
        if (cycleTimeData.startDay > getDayCountDiffMonth(month)) {
            cycleTimeData.startDay = getDayCountDiffMonth(month);
        }
        cycleTimeData.endYear = getDiffYearFromCurMonth(month + 1);
        cycleTimeData.endMon = getDiffMonthFromCurMonth(month + 1);
        cycleTimeData.endDay = cycleDay - 1;
        if (cycleTimeData.endDay >= getDayCountDiffMonth(month + 1)) {
            cycleTimeData.endDay = getDayCountDiffMonth(month + 1) - 1;
        }
        return cycleTimeData;
    }

    public static CallDataUsage getCallDataUsage(long startPeriodTime, long endPeriodTime, boolean isWifi) {
        CallDataUsage callDataUsage = MainApplication.mPhoneManager.getDataUsageManager().getCallDataUsageByPeriod(startPeriodTime, endPeriodTime, isWifi);
        return callDataUsage;
    }

    private static long getLongTimeWithDay(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        long time = cal.getTime().getTime();
        return time;
    }

    public static String getMobileCharge() {
        long userDialCahrge = 0;
        CycleTimeData cycleTimeData = getCycleTimeData(0);
        long startPeriodTime = getLongTimeWithDay(cycleTimeData.startYear, cycleTimeData.startMon, cycleTimeData.startDay);
        long endPeriodTime = getLongTimeWithDay(cycleTimeData.endYear, cycleTimeData.endMon, cycleTimeData.endDay);
        CallDataUsage callDataUsage = getCallDataUsage(startPeriodTime, endPeriodTime, false);
        if (callDataUsage != null) {
            userDialCahrge = callDataUsage.getDialledVoiceDU() + callDataUsage.getDialledVideoDU();
        }
        return String.valueOf(userDialCahrge);
    }
}
