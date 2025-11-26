package com.sec.chaton.util;

import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2132m;
import com.sec.common.util.C5034k;
import com.sec.spp.push.Config;

/* compiled from: MessageServerAddressMgr.java */
/* renamed from: com.sec.chaton.util.bi */
/* loaded from: classes.dex */
public class C4844bi {

    /* renamed from: d */
    private EnumC4867ce f17660d = EnumC4867ce.PRIMARY;

    /* renamed from: e */
    private C4846bk f17661e = new C4846bk(this);

    /* renamed from: c */
    private static final String f17658c = C4844bi.class.getSimpleName();

    /* renamed from: a */
    public static int f17656a = -2;

    /* renamed from: b */
    public static int f17657b = -1;

    /* renamed from: f */
    private static C4844bi f17659f = null;

    /* renamed from: a */
    public static C4844bi m18323a() {
        if (f17659f == null) {
            f17659f = new C4844bi();
        }
        return f17659f;
    }

    private C4844bi() {
    }

    /* renamed from: b */
    public void m18327b() {
        switch (C4845bj.f17662a[this.f17660d.ordinal()]) {
            case 1:
                this.f17661e.m18331a(C4865cc.m18453d());
                this.f17661e.m18330a(C4865cc.m18457f().intValue());
                break;
            case 2:
                this.f17661e.m18331a(C4865cc.m18455e());
                this.f17661e.m18330a(C4865cc.m18459g().intValue());
                break;
        }
        C4904y.m18639b("updateCurrentServer : " + this.f17661e.toString(), getClass().getSimpleName());
    }

    /* renamed from: c */
    public C4846bk m18328c() {
        return this.f17661e;
    }

    /* renamed from: a */
    public void m18326a(String str, int i) {
        C4904y.m18639b("request to change the server( old info ) : " + this.f17661e.toString(), getClass().getSimpleName());
        if (str.equals(this.f17661e.m18329a()) && i == this.f17661e.m18332b()) {
            m18325e();
        }
        if (C2349a.m10301a("wifi_80_port")) {
            C4809aa.m18104a().m18126b(Config.PROVIDER_PATH_WIFI_PORT, Integer.valueOf(f17657b));
        }
    }

    /* renamed from: e */
    private void m18325e() {
        switch (C4845bj.f17662a[this.f17660d.ordinal()]) {
            case 1:
                this.f17661e.m18331a(C4865cc.m18455e());
                this.f17661e.m18330a(C4865cc.m18459g().intValue());
                this.f17660d = EnumC4867ce.SECONDARY;
                C4904y.m18639b("change server PRIMARY --> SECONDARY :" + this.f17661e.toString(), getClass().getSimpleName());
                break;
            case 2:
                this.f17661e.m18331a(C4865cc.m18453d());
                this.f17661e.m18330a(C4865cc.m18457f().intValue());
                this.f17660d = EnumC4867ce.PRIMARY;
                C4904y.m18639b("change server SECONDARY --> PRIMARY:" + this.f17661e.toString(), getClass().getSimpleName());
                new C2132m(new Handler(Looper.getMainLooper())).m9552a();
                C4904y.m18639b("request GLD", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: d */
    public static int m18324d() {
        Exception e;
        int i;
        WifiInfo connectionInfo;
        if (!C2349a.m10301a("wifi_80_port") && !C5034k.m19105j()) {
            return m18323a().m18328c().m18332b();
        }
        int iM18332b = m18323a().m18328c().m18332b();
        WifiManager wifiManager = (WifiManager) GlobalApplication.m18732r().getSystemService("wifi");
        String bssid = (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? null : connectionInfo.getBSSID();
        try {
            if (TextUtils.isEmpty(bssid)) {
                i = iM18332b;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("content://").append(Config.PROVIDER_AUTHORITY).append("/").append(Config.PROVIDER_PATH_WIFI_PORT).append("/").append(bssid);
                Cursor cursorQuery = GlobalApplication.m18732r().getContentResolver().query(Uri.parse(sb.toString()), null, null, null, null);
                if (cursorQuery != null) {
                    if (cursorQuery.moveToFirst()) {
                        try {
                            iM18332b = Integer.valueOf(new String(Base64.decode(cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_PORT)), 0))).intValue();
                            if (C4904y.f17872b) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("[WIFI 80] returnPort::").append(iM18332b).append(" PREF_PRIMARY_MESSAGE_PROT::").append(C4809aa.m18104a().m18120a("primary_message_port", (Integer) 5223));
                                C4904y.m18639b(sb2.toString(), f17658c);
                            }
                            i = iM18332b;
                        } catch (Exception e2) {
                            C4904y.m18635a(e2, "WIFI 80");
                        }
                        try {
                            cursorQuery.close();
                        } catch (Exception e3) {
                            e = e3;
                            C4904y.m18639b(e.toString(), f17658c);
                            C4904y.m18639b("[WIFI 80] checkSPPWifiStatusResult return Port ==>> " + i, f17658c);
                            return i;
                        }
                    } else {
                        i = iM18332b;
                        cursorQuery.close();
                    }
                } else {
                    i = f17656a;
                }
            }
        } catch (Exception e4) {
            e = e4;
            i = iM18332b;
            C4904y.m18639b(e.toString(), f17658c);
            C4904y.m18639b("[WIFI 80] checkSPPWifiStatusResult return Port ==>> " + i, f17658c);
            return i;
        }
        C4904y.m18639b("[WIFI 80] checkSPPWifiStatusResult return Port ==>> " + i, f17658c);
        return i;
    }
}
