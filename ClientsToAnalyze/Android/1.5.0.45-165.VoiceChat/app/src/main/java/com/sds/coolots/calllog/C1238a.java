package com.sds.coolots.calllog;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.calllog.model.C1239a;
import com.sds.coolots.common.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.sds.coolots.calllog.a */
/* loaded from: classes.dex */
public class C1238a {

    /* renamed from: a */
    public static final String f2890a = "[CallLogCallDurationManager]";

    /* renamed from: b */
    private final HashMap f2891b;

    public C1238a() {
        m2822c("Instance is created.");
        this.f2891b = new HashMap();
    }

    /* renamed from: a */
    private void m2820a(String str, String str2) {
        if (!this.f2891b.containsKey(str)) {
            this.f2891b.put(str, new C1239a(str2, 0L, 0L));
        }
        m2829b("addMember()" + str);
    }

    /* renamed from: c */
    private int m2821c(String str, long j) {
        if (((C1239a) this.f2891b.get(str)).m2838c() > 0 && ((C1239a) this.f2891b.get(str)).m2836b() > 0 && ((C1239a) this.f2891b.get(str)).m2838c() > ((C1239a) this.f2891b.get(str)).m2836b()) {
            return (int) (((C1239a) this.f2891b.get(str)).m2838c() - ((C1239a) this.f2891b.get(str)).m2836b());
        }
        if (((C1239a) this.f2891b.get(str)).m2836b() > 0) {
            return (int) (j - ((C1239a) this.f2891b.get(str)).m2836b());
        }
        return 0;
    }

    /* renamed from: c */
    private void m2822c(String str) {
        Log.m2963i(f2890a + str);
    }

    /* renamed from: d */
    private void m2823d(String str) {
        Log.m2958e(f2890a + str);
    }

    /* renamed from: a */
    public void m2824a(long j) {
        Iterator it = this.f2891b.keySet().iterator();
        while (it.hasNext()) {
            m2830b((String) it.next(), j);
        }
    }

    /* renamed from: a */
    public void m2825a(String str) {
        if (this.f2891b.containsKey(str)) {
            ((C1239a) this.f2891b.get(str)).m2834a(0L);
            ((C1239a) this.f2891b.get(str)).m2837b(0L);
        }
    }

    /* renamed from: a */
    public void m2826a(String str, long j) {
        if (!this.f2891b.containsKey(str)) {
            this.f2891b.put(str, new C1239a(null, j, 0L));
        } else if (((C1239a) this.f2891b.get(str)).m2836b() == 0) {
            ((C1239a) this.f2891b.get(str)).m2834a(j);
            ((C1239a) this.f2891b.get(str)).m2837b(0L);
        }
        m2829b("setStartTime() userID: " + str + " startTime: " + j);
    }

    /* renamed from: a */
    public void m2827a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            m2820a(simpleUserInfo.getUserID(), simpleUserInfo.getUserType());
        }
    }

    /* renamed from: b */
    public HashMap m2828b(long j) {
        HashMap map = new HashMap();
        for (String str : this.f2891b.keySet()) {
            if (((C1239a) this.f2891b.get(str)).m2836b() == 0) {
                map.put(str, Long.valueOf(j));
            } else {
                map.put(str, Long.valueOf(((C1239a) this.f2891b.get(str)).m2836b()));
            }
        }
        return map;
    }

    /* renamed from: b */
    public void m2829b(String str) {
        m2822c(str);
        for (String str2 : this.f2891b.keySet()) {
        }
    }

    /* renamed from: b */
    public void m2830b(String str, long j) {
        if (this.f2891b.containsKey(str) && ((C1239a) this.f2891b.get(str)).m2836b() != 0 && ((C1239a) this.f2891b.get(str)).m2838c() == 0) {
            ((C1239a) this.f2891b.get(str)).m2837b(j);
            m2829b("setEndTime() userID: " + str + " endTime: " + j);
        }
    }

    /* renamed from: c */
    public HashMap m2831c(long j) {
        HashMap map = new HashMap();
        for (String str : this.f2891b.keySet()) {
            map.put(str, Integer.valueOf(m2821c(str, j)));
        }
        return map;
    }
}
