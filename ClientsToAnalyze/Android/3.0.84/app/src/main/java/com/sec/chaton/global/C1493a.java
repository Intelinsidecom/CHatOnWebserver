package com.sec.chaton.global;

import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.sec.chaton.p018b.C0454b;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3364o;
import java.util.HashMap;

/* compiled from: ChatOnFeature.java */
/* renamed from: com.sec.chaton.global.a */
/* loaded from: classes.dex */
public class C1493a {

    /* renamed from: a */
    private static HashMap<String, Boolean> f5528a = new HashMap<>();

    /* renamed from: a */
    public static void m6462a() {
        Boolean bool;
        Boolean.valueOf(false);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) CommonApplication.m11493l().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        if ((Build.VERSION.SDK_INT >= 11 && (GlobalApplication.m6451b().getConfiguration().screenLayout & 15) >= 4) || (Build.VERSION.SDK_INT >= 13 && displayMetrics.densityDpi == 213)) {
            bool = true;
        } else {
            bool = false;
        }
        f5528a.put("tablet_enable_feature", bool);
        f5528a.put("logcollector_feature", false);
        f5528a.put("wifi_80_port", true);
        f5528a.put("auto_regi_feature", true);
        f5528a.put("local_backup_feature", true);
        f5528a.put("poll", false);
        f5528a.put("chatonv_feature", true);
        f5528a.put("for_wifi_only_device", Boolean.valueOf(m6464b()));
        f5528a.put("support_contact_auto_sync", false);
        f5528a.put("support_facebook", false);
        f5528a.put("broadcast2_feature", true);
        f5528a.put("live_chat_feature", false);
        f5528a.put("tabletdb_interg_feature", bool);
        f5528a.put("push_message_encrypt_feature", true);
        f5528a.put("main_icon_badge_feature", false);
        if (bool.booleanValue() && Build.VERSION.SDK_INT >= 17) {
            long jM3079a = C0454b.m3079a();
            if (jM3079a >= 0) {
                f5528a.put("mum_enable_feature", true);
                if (jM3079a > 0) {
                    f5528a.put("for_wifi_only_device", true);
                }
            } else {
                f5528a.put("mum_enable_feature", false);
            }
        } else {
            f5528a.put("mum_enable_feature", false);
        }
        f5528a.put("log_by_shipbuild", true);
    }

    /* renamed from: a */
    public static boolean m6463a(String str) {
        if (str == null || !f5528a.containsKey(str)) {
            return false;
        }
        return f5528a.get(str).booleanValue();
    }

    /* renamed from: b */
    private static boolean m6464b() {
        boolean z;
        String deviceId = ((TelephonyManager) GlobalApplication.m11493l().getSystemService("phone")).getDeviceId();
        boolean zHasSystemFeature = GlobalApplication.m11493l().getPackageManager().hasSystemFeature("android.hardware.telephony");
        if (TextUtils.isEmpty(deviceId)) {
            z = true;
        } else {
            z = (Build.MANUFACTURER == null || !Build.MANUFACTURER.contains("samsung") || C3347i.m11778a(GlobalApplication.m11493l(), "com.android.mms")) ? false : true;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a(" IMEI : ", deviceId, " supportTEL : ", Boolean.valueOf(zHasSystemFeature), " manufacturer : ", Build.MANUFACTURER, " isWifiOnlyDevice : ", Boolean.valueOf(z)), "isWifiOnlyDevice");
        }
        return z;
    }
}
