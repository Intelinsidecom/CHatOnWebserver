package com.sec.chaton.util;

import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1334l;
import com.sec.common.util.C3347i;
import com.sec.spp.push.Config;

/* compiled from: MessageServerAddressMgr.java */
/* renamed from: com.sec.chaton.util.bi */
/* loaded from: classes.dex */
public class C3194bi {

    /* renamed from: d */
    private EnumC3218cf f11545d = EnumC3218cf.PRIMARY;

    /* renamed from: e */
    private C3196bk f11546e = new C3196bk(this);

    /* renamed from: c */
    private static final String f11543c = C3194bi.class.getSimpleName();

    /* renamed from: a */
    public static int f11541a = -2;

    /* renamed from: b */
    public static int f11542b = -1;

    /* renamed from: f */
    private static C3194bi f11544f = null;

    /* renamed from: a */
    public static C3194bi m11149a() {
        if (f11544f == null) {
            f11544f = new C3194bi();
        }
        return f11544f;
    }

    private C3194bi() {
    }

    /* renamed from: b */
    public void m11153b() {
        switch (C3195bj.f11547a[this.f11545d.ordinal()]) {
            case 1:
                this.f11546e.m11157a(C3216cd.m11286d());
                this.f11546e.m11156a(C3216cd.m11290f().intValue());
                break;
            case 2:
                this.f11546e.m11157a(C3216cd.m11288e());
                this.f11546e.m11156a(C3216cd.m11292g().intValue());
                break;
        }
        C3250y.m11450b("updateCurrentServer : " + this.f11546e.toString(), getClass().getSimpleName());
    }

    /* renamed from: c */
    public C3196bk m11154c() {
        return this.f11546e;
    }

    /* renamed from: a */
    public void m11152a(String str, int i) {
        C3250y.m11450b("request to change the server( old info ) : " + this.f11546e.toString(), getClass().getSimpleName());
        if (str.equals(this.f11546e.m11155a()) && i == this.f11546e.m11158b()) {
            m11151e();
        }
        if (C1493a.m6463a("wifi_80_port")) {
            C3159aa.m10962a().m10984b(Config.PROVIDER_PATH_WIFI_PORT, Integer.valueOf(f11542b));
        }
    }

    /* renamed from: e */
    private void m11151e() {
        switch (C3195bj.f11547a[this.f11545d.ordinal()]) {
            case 1:
                this.f11546e.m11157a(C3216cd.m11288e());
                this.f11546e.m11156a(C3216cd.m11292g().intValue());
                this.f11545d = EnumC3218cf.SECONDARY;
                C3250y.m11450b("change server PRIMARY --> SECONDARY :" + this.f11546e.toString(), getClass().getSimpleName());
                break;
            case 2:
                this.f11546e.m11157a(C3216cd.m11286d());
                this.f11546e.m11156a(C3216cd.m11290f().intValue());
                this.f11545d = EnumC3218cf.PRIMARY;
                C3250y.m11450b("change server SECONDARY --> PRIMARY:" + this.f11546e.toString(), getClass().getSimpleName());
                new C1334l(new Handler(Looper.getMainLooper())).m5775a();
                C3250y.m11450b("request GLD", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: d */
    public static int m11150d() {
        Exception e;
        int i;
        if (!C1493a.m6463a("wifi_80_port") && !C3347i.m11787j()) {
            return m11149a().m11154c().m11158b();
        }
        int iM11158b = m11149a().m11154c().m11158b();
        String bssid = ((WifiManager) GlobalApplication.m11493l().getSystemService("wifi")).getConnectionInfo().getBSSID();
        try {
            if (TextUtils.isEmpty(bssid)) {
                i = iM11158b;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("content://").append(Config.PROVIDER_AUTHORITY).append("/").append(Config.PROVIDER_PATH_WIFI_PORT).append("/").append(bssid);
                Cursor cursorQuery = GlobalApplication.m11493l().getContentResolver().query(Uri.parse(sb.toString()), null, null, null, null);
                if (cursorQuery != null) {
                    if (cursorQuery.moveToFirst()) {
                        try {
                            iM11158b = Integer.valueOf(new String(Base64.decode(cursorQuery.getString(cursorQuery.getColumnIndex("port")), 0))).intValue();
                            if (C3250y.f11734b) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("[WIFI 80] returnPort::").append(iM11158b).append(" PREF_PRIMARY_MESSAGE_PROT::").append(C3159aa.m10962a().m10978a("primary_message_port", (Integer) 5223));
                                C3250y.m11450b(sb2.toString(), f11543c);
                            }
                            i = iM11158b;
                        } catch (Exception e2) {
                            C3250y.m11443a(e2, "WIFI 80");
                        }
                        try {
                            cursorQuery.close();
                        } catch (Exception e3) {
                            e = e3;
                            C3250y.m11450b(e.toString(), f11543c);
                            C3250y.m11450b("[WIFI 80] checkSPPWifiStatusResult return Port ==>> " + i, f11543c);
                            return i;
                        }
                    } else {
                        i = iM11158b;
                        cursorQuery.close();
                    }
                } else {
                    i = f11541a;
                }
            }
        } catch (Exception e4) {
            e = e4;
            i = iM11158b;
            C3250y.m11450b(e.toString(), f11543c);
            C3250y.m11450b("[WIFI 80] checkSPPWifiStatusResult return Port ==>> " + i, f11543c);
            return i;
        }
        C3250y.m11450b("[WIFI 80] checkSPPWifiStatusResult return Port ==>> " + i, f11543c);
        return i;
    }
}
