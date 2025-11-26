package com.sec.chaton.calllog.manager.p053b;

import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.calllog.manager.model.C1455c;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4877co;
import com.sec.common.CommonApplication;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: CallLogStringUtil.java */
/* renamed from: com.sec.chaton.calllog.manager.b.a */
/* loaded from: classes.dex */
public final class C1452a {

    /* renamed from: a */
    private static C1452a f5174a = new C1452a();

    /* renamed from: a */
    public static C1452a m7605a() {
        return f5174a;
    }

    /* renamed from: a */
    public String m7614a(String str, String str2) {
        if (str2 == null || "".equals(str2)) {
            return "";
        }
        try {
            return m7615a(m7608b(str, "yyyyMMddHHmmss"), str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public long m7611a(String str) {
        try {
            return m7604a(m7608b(str, "yyyyMMddHHmmss"), new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    /* renamed from: b */
    public static Date m7608b(String str, String str2) {
        return new SimpleDateFormat(str2, GlobalApplication.m18732r().getResources().getConfiguration().locale).parse(str);
    }

    /* renamed from: a */
    public String m7615a(Date date, String str) {
        return new SimpleDateFormat(str, GlobalApplication.m18732r().getResources().getConfiguration().locale).format(date);
    }

    /* renamed from: a */
    private long m7604a(Date date, Date date2) {
        long j;
        long time = (m7607a(date2).getTime() / 1000) - (m7607a(date).getTime() / 1000);
        if (time >= 0) {
            j = time + 43200;
        } else {
            j = time - 43200;
        }
        return j / 86400;
    }

    /* renamed from: a */
    private Date m7607a(Date date) {
        if (!(date instanceof java.sql.Date)) {
            Date date2 = (Date) date.clone();
            date2.setHours(0);
            date2.setMinutes(0);
            date2.setSeconds(0);
            date2.setTime((date2.getTime() / 1000) * 1000);
            return date2;
        }
        return date;
    }

    /* renamed from: a */
    public String m7612a(CallLogData callLogData) {
        int i;
        int i2;
        if (callLogData.callmethod == 12) {
            if (callLogData.rejectmsg != null && !TextUtils.isEmpty(callLogData.rejectmsg)) {
                return callLogData.rejectmsg;
            }
            return "Reject message is empty";
        }
        if (callLogData.groupcallkey != null && callLogData.groupcallkey.get(0).intValue() != 0) {
            i = callLogData.myCalllogtype;
            i2 = callLogData.myDuration;
        } else {
            i = callLogData.userInfo.get(0).f5186l;
            i2 = callLogData.userInfo.get(0).f5185k;
        }
        switch (i) {
            case 0:
            case 1:
            case 5:
                if (i2 != 0) {
                    return C4877co.m18515b(i2);
                }
                return GlobalApplication.m18732r().getResources().getString(R.string.calllog_cancelled_call);
            case 2:
                return GlobalApplication.m18732r().getResources().getString(R.string.calllog_missed_call);
            case 3:
            case 4:
                return GlobalApplication.m18732r().getResources().getString(R.string.calllog_rejected_call);
            default:
                return "Unknown";
        }
    }

    /* renamed from: c */
    public boolean m7617c(String str, String str2) {
        try {
            Date dateM7608b = m7608b(str, "yyyyMMddHHmmss");
            Date dateM7608b2 = m7608b(str2, "yyyyMMddHHmmss");
            if (dateM7608b.getYear() == dateM7608b2.getYear() && dateM7608b.getMonth() == dateM7608b2.getMonth()) {
                if (dateM7608b.getDate() == dateM7608b2.getDate()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: b */
    public String m7616b(CallLogData callLogData) {
        StringBuilder sb = new StringBuilder();
        HashSet hashSet = new HashSet();
        for (C1455c c1455c : callLogData.userInfo) {
            if (!hashSet.contains(c1455c.f5175a) && !C4809aa.m18104a().m18121a("chaton_id", "").equals(c1455c.f5175a)) {
                hashSet.add(c1455c.f5175a);
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                if (c1455c.f5177c == null || TextUtils.isEmpty(c1455c.f5177c)) {
                    if (TextUtils.isEmpty(c1455c.f5176b)) {
                        sb.append(c1455c.f5175a);
                    } else {
                        sb.append(c1455c.f5176b);
                    }
                } else {
                    sb.append(c1455c.f5177c);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public String m7613a(CallLogData callLogData, HashMap<Set<String>, String> map, List<C1455c> list) {
        if (callLogData.groupid == 0) {
            HashSet hashSet = new HashSet();
            Iterator<C1455c> it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().f5175a);
            }
            if (map != null && map.containsKey(hashSet)) {
                return map.get(hashSet);
            }
        }
        return null;
    }

    /* renamed from: c */
    public static int m7610c(CallLogData callLogData) {
        int i;
        int i2;
        if (callLogData.groupcallkey != null && callLogData.groupcallkey.get(0).intValue() != 0) {
            i = callLogData.myCalllogtype;
            i2 = callLogData.myDuration;
        } else {
            i = callLogData.userInfo.get(0).f5186l;
            i2 = callLogData.userInfo.get(0).f5185k;
        }
        switch (i) {
            case 1:
                if (i2 != 0 || callLogData.callmethod == 12) {
                }
                break;
        }
        return R.drawable.common_received;
    }

    /* renamed from: a */
    public static String m7606a(CallLogData callLogData, boolean z) {
        String strM7614a;
        String strM7614a2;
        if (z) {
            strM7614a = m7605a().m7614a(callLogData.userInfo.get(0).f5184j, "HH:mm");
            strM7614a2 = m7605a().m7614a(callLogData.userInfo.get(0).f5184j, "HH:mm");
        } else {
            strM7614a = m7605a().m7614a(callLogData.userInfo.get(0).f5184j, "a h:mm");
            strM7614a2 = m7605a().m7614a(callLogData.userInfo.get(0).f5184j, "h:mm a");
        }
        return m7609b() ? strM7614a : strM7614a2;
    }

    /* renamed from: b */
    private static boolean m7609b() {
        return "kor".equals(CommonApplication.m18732r().getResources().getConfiguration().locale.getISO3Language());
    }
}
