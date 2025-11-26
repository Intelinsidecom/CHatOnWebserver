package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SNSBuddyControl.java */
/* renamed from: com.sec.chaton.d.be */
/* loaded from: classes.dex */
public class C2099be {

    /* renamed from: c */
    private static C2099be f7620c;

    /* renamed from: d */
    private C4368e f7621d = C4368e.m16564a(GlobalApplication.m18732r());

    /* renamed from: e */
    private List<String> f7622e = new ArrayList();

    /* renamed from: f */
    private Map<String, HandlerThread> f7623f = new ConcurrentHashMap();

    /* renamed from: g */
    private Handler f7624g;

    /* renamed from: b */
    private static final String[] f7619b = {C4368e.f15815a, C4368e.f15820f, C4368e.f15818d};

    /* renamed from: a */
    public static final String f7618a = C2099be.class.getSimpleName();

    /* renamed from: a */
    public static synchronized C2099be m9379a() {
        if (f7620c == null) {
            f7620c = new C2099be();
        }
        return f7620c;
    }

    private C2099be() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.f7624g = new Handler(mainLooper);
        }
    }

    /* renamed from: b */
    public boolean m9384b() {
        if (!m9383c()) {
            C4904y.m18639b("No logged in SNS accounts ready for buddy sync", f7618a);
            return false;
        }
        for (String str : this.f7622e) {
            C4904y.m18639b("Logged in SNS accounts ready for buddy sync --> " + str, f7618a);
            if (!m9380a(str)) {
                HandlerThreadC2100bf handlerThreadC2100bf = new HandlerThreadC2100bf(this, str);
                handlerThreadC2100bf.start();
                this.f7623f.put(str, handlerThreadC2100bf);
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m9380a(String str) {
        HandlerThread handlerThread = this.f7623f.get(str);
        return handlerThread != null && handlerThread.isAlive();
    }

    /* renamed from: c */
    private boolean m9383c() {
        C4904y.m18639b("Checking logged in SNS accounts for buddy sync", f7618a);
        for (String str : f7619b) {
            if (m9382b(str)) {
                this.f7622e.add(str);
            }
        }
        C4904y.m18639b("logged in SNS accounts for buddy sync --> " + this.f7622e.toString(), f7618a);
        return this.f7622e.size() > 0;
    }

    /* renamed from: b */
    private boolean m9382b(String str) {
        long jM18118a;
        if (!this.f7621d.m16566a(str)) {
            return false;
        }
        if (str.equals(C4368e.f15815a)) {
            jM18118a = C4809aa.m18104a().m18118a("last_fb_buddy_sync_time", -1L);
        } else if (str.equals(C4368e.f15818d)) {
            jM18118a = C4809aa.m18104a().m18118a("last_odnok_buddy_sync_time", -1L);
        } else {
            jM18118a = str.equals(C4368e.f15820f) ? C4809aa.m18104a().m18118a("last_vkontakte_buddy_sync_time", -1L) : 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jM18118a;
        return jM18118a == -1 || jCurrentTimeMillis >= 604800000 || jCurrentTimeMillis < 0;
    }
}
