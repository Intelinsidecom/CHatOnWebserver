package com.sds.coolots.call.entitlement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: com.sds.coolots.call.entitlement.a */
/* loaded from: classes.dex */
public class C1174a implements IEntitlement {

    /* renamed from: b */
    private static final String f2410b = "pref_atnt_check_date";

    /* renamed from: c */
    private static final long f2411c = 0;

    /* renamed from: d */
    private static final String f2412d = "pref_atnt_result_type";

    /* renamed from: a */
    private HandlerC1175b f2413a;

    public C1174a() {
        m2210a("ATNTEntitlement create()");
    }

    /* renamed from: a */
    public static List m2203a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("310150");
        arrayList.add("310170");
        arrayList.add("310410");
        arrayList.add("310980");
        arrayList.add("310560");
        arrayList.add("311180");
        return arrayList;
    }

    /* renamed from: a */
    public static void m2204a(Context context) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.remove(f2412d);
        if (Build.VERSION.SDK_INT < 9) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2205a(Context context, int i) {
        m2210a("setType() " + i);
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putInt(f2412d, i);
        if (Build.VERSION.SDK_INT < 9) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2206a(Context context, Date date) {
        m2210a("setDate() " + date);
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putLong(f2410b, date.getTime());
        if (Build.VERSION.SDK_INT < 9) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2210a(String str) {
        Log.m2963i("[ATAndTEntitlement]" + str);
    }

    /* renamed from: b */
    public static void m2211b(Context context) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.remove(f2410b);
        if (Build.VERSION.SDK_INT < 9) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    /* renamed from: b */
    private void m2212b(String str) {
        Log.m2963i("[ATAndTEntitlement]" + str);
    }

    /* renamed from: b */
    public static boolean m2213b() {
        return Build.MODEL.equals("SGH-I337Z") || Build.MODEL.equals("SAMSUNG-SGH-I337Z");
    }

    /* renamed from: c */
    private int m2214c(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(f2412d, 0);
    }

    /* renamed from: d */
    private Date m2215d(Context context) {
        long j = PreferenceManager.getDefaultSharedPreferences(context).getLong(f2410b, f2411c);
        if (j == f2411c) {
            return null;
        }
        return new Date(j);
    }

    @Override // com.sds.coolots.call.entitlement.IEntitlement
    public boolean canICheckDirect(Context context) {
        Date dateM2215d = m2215d(context);
        int iM2214c = m2214c(context);
        if (dateM2215d == null || dateM2215d.equals(0) || iM2214c == 0) {
            m2210a("canICheckDirect() lastDate is null or type is RESULT_TYPE_NONE");
            return false;
        }
        m2210a("canICheckDirect() lastDate: " + dateM2215d + ", type: " + iM2214c);
        long time = new Date(System.currentTimeMillis()).getTime();
        long time2 = dateM2215d.getTime();
        m2210a("canICheckDirect() msecCurDate: " + time + ", msecLastDate: " + time2 + ", diff: " + (time - time2));
        return time - time2 < ((long) getTimerDuration());
    }

    @Override // com.sds.coolots.call.entitlement.IEntitlement
    public void checkEntitlement(IEntitlementResultListener iEntitlementResultListener, IEntitlementHangupListener iEntitlementHangupListener) {
        m2210a("checkEnableEntitlement()");
        if (this.f2413a != null) {
            this.f2413a.removeMessages(0);
            this.f2413a.m2216a();
            this.f2413a = null;
        }
        this.f2413a = new HandlerC1175b(this, iEntitlementResultListener, iEntitlementHangupListener);
        new C1176c(this.f2413a).start();
    }

    @Override // com.sds.coolots.call.entitlement.IEntitlement
    public boolean checkEntitlementDirect(Context context) {
        int iM2214c = m2214c(context);
        m2210a("checkEnableEntitlementDirect() type: " + iM2214c);
        return iM2214c == 1;
    }

    @Override // com.sds.coolots.call.entitlement.IEntitlement
    public void dispose() {
        if (this.f2413a != null) {
            this.f2413a.removeMessages(0);
            this.f2413a.m2216a();
            this.f2413a = null;
        }
    }

    @Override // com.sds.coolots.call.entitlement.IEntitlement
    public int getTimerDuration() {
        return 86400000;
    }

    @Override // com.sds.coolots.call.entitlement.IEntitlement
    public boolean isWifiOnlyMode() {
        return MainApplication.mConfig.isApplyATNTWifiOnly();
    }
}
