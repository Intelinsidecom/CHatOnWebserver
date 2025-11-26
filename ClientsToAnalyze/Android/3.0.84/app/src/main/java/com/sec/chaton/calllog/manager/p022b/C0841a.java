package com.sec.chaton.calllog.manager.p022b;

import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.calllog.manager.model.C0844c;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3227co;
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
public final class C0841a {

    /* renamed from: a */
    private static C0841a f3204a = new C0841a();

    /* renamed from: a */
    public static C0841a m4451a() {
        return f3204a;
    }

    /* renamed from: a */
    public String m4459a(String str, String str2) {
        if (str2 == null || "".equals(str2)) {
            return "";
        }
        try {
            return m4460a(m4462b(str, "yyyyMMddHHmmss"), str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public long m4455a(String str) {
        try {
            return m4450a(m4462b(str, "yyyyMMddHHmmss"), new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    /* renamed from: b */
    public Date m4462b(String str, String str2) {
        return new SimpleDateFormat(str2, GlobalApplication.m11493l().getResources().getConfiguration().locale).parse(str);
    }

    /* renamed from: a */
    public String m4460a(Date date, String str) {
        return new SimpleDateFormat(str, GlobalApplication.m11493l().getResources().getConfiguration().locale).format(date);
    }

    /* renamed from: a */
    private long m4450a(Date date, Date date2) {
        long j;
        long time = (m4452a(date2).getTime() / 1000) - (m4452a(date).getTime() / 1000);
        if (time >= 0) {
            j = time + 43200;
        } else {
            j = time - 43200;
        }
        return j / 86400;
    }

    /* renamed from: a */
    private Date m4452a(Date date) {
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
    public String m4456a(int i) {
        String string;
        String string2 = "00";
        int i2 = i / 60;
        if (i2 >= 60) {
            string2 = Integer.toString(i2 / 60);
            string = Integer.toString(i2 % 60);
        } else {
            string = Integer.toString(i2);
        }
        return m4453b(string2) + ":" + m4453b(string) + ":" + m4453b(Integer.toString(i % 60));
    }

    /* renamed from: b */
    private String m4453b(String str) {
        if (str.length() == 1) {
            return "0" + str;
        }
        return str;
    }

    /* renamed from: a */
    public String m4457a(CallLogData callLogData) {
        int i;
        int i2;
        if (callLogData.callmethod == 12) {
            if (callLogData.rejectmsg != null && !callLogData.rejectmsg.isEmpty()) {
                return callLogData.rejectmsg;
            }
            return "Reject message is empty";
        }
        if (callLogData.groupcallkey != null && callLogData.groupcallkey.get(0).intValue() != 0) {
            i = callLogData.myCalllogtype;
            i2 = callLogData.myDuration;
        } else {
            i = callLogData.userInfo.get(0).f3216l;
            i2 = callLogData.userInfo.get(0).f3215k;
        }
        switch (i) {
            case 0:
            case 1:
            case 5:
                if (i2 != 0) {
                    return C3227co.m11342b(i2);
                }
                return GlobalApplication.m11493l().getResources().getString(R.string.calllog_cancelled_call);
            case 2:
                return GlobalApplication.m11493l().getResources().getString(R.string.calllog_missed_call);
            case 3:
            case 4:
                return GlobalApplication.m11493l().getResources().getString(R.string.calllog_rejected_call);
            default:
                return "Unknown";
        }
    }

    /* renamed from: c */
    public boolean m4463c(String str, String str2) {
        try {
            Date dateM4462b = m4462b(str, "yyyyMMddHHmmss");
            Date dateM4462b2 = m4462b(str2, "yyyyMMddHHmmss");
            if (dateM4462b.getYear() == dateM4462b2.getYear() && dateM4462b.getMonth() == dateM4462b2.getMonth()) {
                if (dateM4462b.getDate() == dateM4462b2.getDate()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: b */
    public String m4461b(CallLogData callLogData) {
        StringBuilder sb = new StringBuilder();
        HashSet hashSet = new HashSet();
        for (C0844c c0844c : callLogData.userInfo) {
            if (!hashSet.contains(c0844c.f3205a) && !C3159aa.m10962a().m10979a("chaton_id", "").equals(c0844c.f3205a)) {
                hashSet.add(c0844c.f3205a);
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                if (c0844c.f3207c == null || c0844c.f3207c.isEmpty()) {
                    if (TextUtils.isEmpty(c0844c.f3206b)) {
                        sb.append(c0844c.f3205a);
                    } else {
                        sb.append(c0844c.f3206b);
                    }
                } else {
                    sb.append(c0844c.f3207c);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public String m4458a(CallLogData callLogData, HashMap<Set<String>, String> map, List<C0844c> list) {
        if (callLogData.groupid == 0) {
            HashSet hashSet = new HashSet();
            Iterator<C0844c> it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().f3205a);
            }
            if (map != null && map.containsKey(hashSet)) {
                return map.get(hashSet);
            }
        }
        return null;
    }

    /* renamed from: c */
    public static int m4454c(CallLogData callLogData) {
        int i;
        int i2;
        if (callLogData.groupcallkey != null && callLogData.groupcallkey.get(0).intValue() != 0) {
            i = callLogData.myCalllogtype;
            i2 = callLogData.myDuration;
        } else {
            i = callLogData.userInfo.get(0).f3216l;
            i2 = callLogData.userInfo.get(0).f3215k;
        }
        switch (i) {
            case 1:
                if (i2 != 0 || callLogData.callmethod == 12) {
                }
                break;
        }
        return R.drawable.common_received;
    }
}
