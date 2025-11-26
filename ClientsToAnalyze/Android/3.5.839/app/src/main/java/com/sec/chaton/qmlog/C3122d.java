package com.sec.chaton.qmlog;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5052r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: QMLogManager.java */
/* renamed from: com.sec.chaton.qmlog.d */
/* loaded from: classes.dex */
public class C3122d {

    /* renamed from: a */
    private static final String f11476a = C3122d.class.getSimpleName();

    /* renamed from: b */
    private static C3122d f11477b;

    /* renamed from: c */
    private final ReentrantReadWriteLock f11478c = new ReentrantReadWriteLock();

    /* renamed from: d */
    private final Lock f11479d = this.f11478c.readLock();

    /* renamed from: e */
    private final Lock f11480e = this.f11478c.writeLock();

    /* renamed from: f */
    private List<String> f11481f = new ArrayList();

    /* renamed from: g */
    private PhoneStateListener f11482g;

    /* renamed from: h */
    private int f11483h;

    /* renamed from: i */
    private int f11484i;

    /* renamed from: j */
    private long f11485j;

    /* renamed from: a */
    public static C3122d m12732a() {
        synchronized (C3122d.class) {
            if (f11477b == null) {
                f11477b = new C3122d();
            }
        }
        return f11477b;
    }

    private C3122d() {
        m12740g();
        this.f11484i = 0;
        this.f11485j = 0L;
        m12739f();
    }

    /* renamed from: f */
    private void m12739f() {
        new Thread(new RunnableC3123e(this)).start();
    }

    /* renamed from: g */
    private boolean m12740g() {
        TelephonyManager telephonyManager = (TelephonyManager) CommonApplication.m18732r().getSystemService("phone");
        if (this.f11482g != null) {
            return false;
        }
        this.f11482g = new C3125g(this, null);
        telephonyManager.listen(this.f11482g, 256);
        return true;
    }

    /* renamed from: b */
    public static String m12734b() {
        return "http://dev.contact.samsungchaton.com";
    }

    /* renamed from: c */
    public static String m12736c() {
        return "/qm/log";
    }

    /* renamed from: h */
    private String m12741h() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) CommonApplication.m18732r().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return "unknown";
        }
        if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING) {
            String subtypeName = activeNetworkInfo.getSubtypeName();
            if (TextUtils.isEmpty(subtypeName)) {
                return activeNetworkInfo.getTypeName();
            }
            return subtypeName;
        }
        return activeNetworkInfo.getState().name();
    }

    /* renamed from: i */
    private int m12742i() {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) CommonApplication.m18732r().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return 0;
        }
        return connectionInfo.getRssi();
    }

    /* renamed from: a */
    private int m12731a(String str) {
        int i = this.f11483h;
        if ("WIFI".equalsIgnoreCase(str)) {
            return m12742i();
        }
        return i;
    }

    /* renamed from: b */
    private boolean m12735b(String str) {
        String strM12741h = m12741h();
        int iM12731a = m12731a(strM12741h);
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(",").append(strM12741h).append(",").append(iM12731a).append(",").append(0L).append(",").append(0L);
        if (C4904y.f17872b) {
            C4904y.m18639b(sb.toString(), f11476a);
        }
        this.f11480e.lock();
        if (this.f11485j == 0) {
            this.f11485j = System.currentTimeMillis();
        }
        try {
            return m12737c(sb.toString());
        } finally {
            this.f11480e.unlock();
        }
    }

    /* renamed from: a */
    public boolean m12749a(String str, String str2, long j, long j2) {
        Uri uri = Uri.parse(str2);
        String encodedPath = uri.getEncodedPath();
        String encodedQuery = uri.getEncodedQuery();
        StringBuilder sb = new StringBuilder();
        sb.append(encodedPath).append("?").append(encodedQuery);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(EnumC3124f.URLLOAD.m12751a()).append(",").append(str).append(",").append(sb.toString()).append(",").append(j).append(",").append(j2);
        return m12735b(sb2.toString());
    }

    /* renamed from: a */
    public boolean m12746a(long j, long j2, long j3, long j4) {
        StringBuilder sb = new StringBuilder();
        sb.append(EnumC3124f.STICKERDOWNLOAD.m12751a()).append(",").append(j).append(",").append(j2).append(",").append(j3).append(",").append(j4);
        return m12735b(sb.toString());
    }

    /* renamed from: a */
    public boolean m12748a(EnumC3126h enumC3126h, long j, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(EnumC3124f.LOADTAB.m12751a()).append(",").append(enumC3126h.m12752a()).append(",").append(Spam.ACTIVITY_CANCEL).append(",").append(j).append(",").append(j2);
        return m12735b(sb.toString());
    }

    /* renamed from: a */
    private boolean m12733a(EnumC3124f enumC3124f) {
        return enumC3124f == EnumC3124f.RECEIVE || enumC3124f == EnumC3124f.PUSH;
    }

    /* renamed from: a */
    public boolean m12747a(EnumC3124f enumC3124f, long j, long j2, long j3, long j4) {
        if (m12733a(enumC3124f)) {
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("ReceivedTime(before) : ", String.valueOf(j4)), f11476a);
            }
            j4 -= C4809aa.m18104a().m18118a("qmlog_revice_time", 0L);
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("ReceivedTime(after) : ", String.valueOf(j4)), f11476a);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(enumC3124f.m12751a()).append(",").append(j).append(",").append(j2).append(",").append(j3).append(",").append(j4);
        return m12735b(sb.toString());
    }

    /* renamed from: d */
    String m12750d() {
        this.f11480e.lock();
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.f11481f.iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append("\n");
            }
            this.f11481f.clear();
            return sb.toString();
        } finally {
            this.f11480e.unlock();
        }
    }

    /* renamed from: c */
    private boolean m12737c(String str) {
        boolean zAdd = this.f11481f.add(str);
        if (zAdd) {
            this.f11484i++;
        }
        if (m12743j()) {
            if (CommonApplication.m18732r().startService(new Intent(CommonApplication.m18732r(), (Class<?>) QMLogSendingService.class)) == null) {
                C4904y.m18639b("HUK", f11476a);
            } else {
                this.f11484i = 0;
            }
        }
        return zAdd;
    }

    /* renamed from: j */
    private boolean m12743j() {
        return m12744k() || m12745l();
    }

    /* renamed from: k */
    private boolean m12744k() {
        if (System.currentTimeMillis() - this.f11485j <= 3600000) {
            return false;
        }
        this.f11485j = 0L;
        return true;
    }

    /* renamed from: l */
    private boolean m12745l() {
        return this.f11484i >= 50;
    }
}
