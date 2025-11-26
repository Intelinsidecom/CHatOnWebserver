package com.sds.coolots.login.p018a;

import android.content.ContentValues;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.model.NationalCode;
import java.util.List;
import java.util.Locale;

/* renamed from: com.sds.coolots.login.a.b */
/* loaded from: classes.dex */
public class C1266b {

    /* renamed from: a */
    protected static final String f3184a = "[NationalCodeManager]";

    /* renamed from: b */
    public static final int f3185b = 0;

    /* renamed from: c */
    public static final int f3186c = 1;

    /* renamed from: d */
    public static final int f3187d = 2;

    /* renamed from: e */
    private static final String f3188e = "20120829";

    /* renamed from: f */
    private final C1265a f3189f = new C1265a();

    public C1266b() {
        this.f3189f.m3045a();
    }

    /* renamed from: b */
    private void m3053b() throws InterruptedException {
        new C1267c(this, null).start();
        try {
            Thread.sleep(500L);
        } catch (Exception e) {
            m3054e("national conde thread init error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3054e(String str) {
        Log.m2958e(f3184a + str);
    }

    /* renamed from: a */
    public NationalCode m3055a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("countrycode", str);
        List listM3049c = this.f3189f.m3049c(contentValues, 0);
        if (listM3049c == null || listM3049c.isEmpty()) {
            return null;
        }
        return (NationalCode) listM3049c.get(0);
    }

    /* renamed from: a */
    public List m3056a(int i) {
        return this.f3189f.m3044a(null, i);
    }

    /* renamed from: a */
    public void m3057a() throws InterruptedException {
        if (!f3188e.equals(MainApplication.mConfig.getNationalCodeVersion())) {
            m3053b();
            return;
        }
        List listM3059b = m3059b(0);
        if (listM3059b == null || listM3059b.isEmpty()) {
            m3053b();
        }
    }

    /* renamed from: a */
    public void m3058a(List list) {
        this.f3189f.m3046a(list);
    }

    /* renamed from: b */
    public List m3059b(int i) {
        return this.f3189f.m3047b(null, i);
    }

    /* renamed from: b */
    public List m3060b(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mcc", str);
        return this.f3189f.m3047b(contentValues, 0);
    }

    /* renamed from: c */
    public NationalCode m3061c(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("areacode", str);
        List listM3049c = this.f3189f.m3049c(contentValues, 0);
        if (listM3049c == null || !listM3049c.isEmpty()) {
            return null;
        }
        return (NationalCode) listM3049c.get(0);
    }

    /* renamed from: c */
    public List m3062c(int i) {
        return this.f3189f.m3049c(null, i);
    }

    /* renamed from: d */
    public NationalCode m3063d(String str) {
        String upperCase = str.toUpperCase(Locale.getDefault());
        ContentValues contentValues = new ContentValues();
        contentValues.put("iso2", upperCase);
        List listM3049c = this.f3189f.m3049c(contentValues, 0);
        if (listM3049c == null || listM3049c.isEmpty()) {
            return null;
        }
        return (NationalCode) listM3049c.get(0);
    }
}
