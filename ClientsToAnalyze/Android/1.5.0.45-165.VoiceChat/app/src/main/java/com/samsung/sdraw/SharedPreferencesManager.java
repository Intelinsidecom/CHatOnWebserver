package com.samsung.sdraw;

import android.content.Context;
import android.content.SharedPreferences;
import com.samsung.android.sdk.pen.settingui.SpenSharedPreferencesManager;

/* loaded from: classes.dex */
public class SharedPreferencesManager {

    /* renamed from: a */
    private SharedPreferences f1290a;

    /* renamed from: b */
    private String f1291b;

    /* renamed from: c */
    private SharedPreferences.Editor f1292c;

    /* renamed from: d */
    private final String f1293d = "PEN_TYPE";

    /* renamed from: e */
    private final String f1294e = "PEN_SIZE";

    /* renamed from: f */
    private final String f1295f = "PEN_ALPHA";

    /* renamed from: g */
    private final String f1296g = "COLOR";

    /* renamed from: h */
    private final String f1297h = SpenSharedPreferencesManager.PRESET_ORDER;

    /* renamed from: i */
    private final String f1298i = "PRESET_";

    /* renamed from: j */
    private final String f1299j = "CURRENT_";

    /* renamed from: k */
    private final String f1300k = "CURRENT_PENTYPE";

    /* renamed from: l */
    private final String f1301l = "FILLING_COLOR";

    /* renamed from: m */
    private final String f1302m = "TEXT_FONT";

    /* renamed from: n */
    private final String f1303n = "TEXT_COLOR";

    /* renamed from: o */
    private final String f1304o = "TEXT_TYPE";

    /* renamed from: p */
    private final String f1305p = "TEXT_SIZE";

    /* renamed from: q */
    private final String f1306q = "TEXT_ALIGNMENT";

    SharedPreferencesManager(Context context) {
        this.f1291b = context.getPackageName();
        this.f1290a = context.getSharedPreferences(this.f1291b, 0);
        this.f1292c = this.f1290a.edit();
    }

    /* renamed from: a */
    void m1127a(String str) {
        if (str != null && !str.isEmpty()) {
            this.f1292c.putString(SpenSharedPreferencesManager.PRESET_ORDER, str);
        } else {
            this.f1292c.remove(SpenSharedPreferencesManager.PRESET_ORDER);
        }
        this.f1292c.commit();
    }

    /* renamed from: a */
    void m1126a(PenData penData, int i, String str) {
        m1123a(penData, String.valueOf(i) + "PRESET_");
        m1127a(str);
    }

    /* renamed from: a */
    C1005ar[] m1128a() {
        String[] strArrSplit;
        int i = 0;
        C1005ar[] c1005arArr = (C1005ar[]) null;
        String string = this.f1290a.getString(SpenSharedPreferencesManager.PRESET_ORDER, null);
        if (string != null && !string.isEmpty() && (strArrSplit = string.split(",")) != null) {
            C1005ar[] c1005arArr2 = new C1005ar[strArrSplit.length];
            int i2 = 0;
            while (i < strArrSplit.length) {
                c1005arArr2[i2] = m1124b(Integer.parseInt(strArrSplit[i]));
                if (c1005arArr2[i2] == null) {
                    i2--;
                }
                i++;
                i2++;
            }
            return c1005arArr2;
        }
        return c1005arArr;
    }

    /* renamed from: a */
    void m1125a(int i) {
        String str = String.valueOf(i) + "PRESET_";
        if (this.f1290a.contains(String.valueOf(str) + "PEN_TYPE")) {
            this.f1292c.remove(String.valueOf(str) + "PEN_TYPE");
        }
        if (this.f1290a.contains(String.valueOf(str) + "PEN_SIZE")) {
            this.f1292c.remove(String.valueOf(str) + "PEN_SIZE");
        }
        if (this.f1290a.contains(String.valueOf(str) + "COLOR")) {
            this.f1292c.remove(String.valueOf(str) + "COLOR");
        }
        if (this.f1290a.contains(String.valueOf(str) + "PEN_ALPHA")) {
            this.f1292c.remove(String.valueOf(str) + "PEN_ALPHA");
        }
        this.f1292c.commit();
    }

    /* renamed from: a */
    private void m1123a(PenData penData, String str) {
        this.f1292c.putInt(String.valueOf(str) + "PEN_TYPE", penData.getPenType());
        this.f1292c.putInt(String.valueOf(str) + "PEN_SIZE", penData.getPenSize());
        this.f1292c.putInt(String.valueOf(str) + "COLOR", penData.getColor());
        this.f1292c.putInt(String.valueOf(str) + "PEN_ALPHA", penData.getAlpha());
        this.f1292c.commit();
    }

    /* renamed from: b */
    private C1005ar m1124b(int i) {
        C1005ar c1005ar = new C1005ar();
        int i2 = this.f1290a.getInt(String.valueOf(i) + "PRESET_PEN_TYPE", 0);
        if (i2 > 5) {
            return null;
        }
        int i3 = this.f1290a.getInt(String.valueOf(i) + "PRESET_PEN_SIZE", 0);
        int i4 = this.f1290a.getInt(String.valueOf(i) + "PRESET_COLOR", 0);
        int i5 = this.f1290a.getInt(String.valueOf(i) + "PRESET_PEN_ALPHA", 0);
        c1005ar.m1380a(i);
        c1005ar.m1387d(i2);
        c1005ar.m1383b(i3);
        c1005ar.m1389e(i4);
        c1005ar.m1385c(i5);
        return c1005ar;
    }
}
