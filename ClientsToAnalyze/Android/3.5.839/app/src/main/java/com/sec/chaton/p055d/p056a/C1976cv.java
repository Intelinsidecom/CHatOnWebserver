package com.sec.chaton.p055d.p056a;

import android.content.Intent;
import android.support.v4.content.C0096i;
import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: GetVersionNoticeTask.java */
/* renamed from: com.sec.chaton.d.a.cv */
/* loaded from: classes.dex */
public class C1976cv extends AbstractC1900a {
    public C1976cv(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        GetVersionNotice getVersionNotice = (GetVersionNotice) c0778b.m3110e();
        C4904y.m18646e("" + getVersionNotice, getClass().getSimpleName());
        if (getVersionNotice != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            int iIntValue = C4809aa.m18104a().m18120a("notice", (Integer) 0).intValue();
            if (!TextUtils.isEmpty(getVersionNotice.UTCtimestamp)) {
                C4809aa.m18108a("server_time", getVersionNotice.UTCtimestamp);
            }
            int iIntValue2 = C4809aa.m18104a().m18120a("admin_upgrade", (Integer) (-1)).intValue();
            boolean zBooleanValue = C4809aa.m18104a().m18119a("admin_notice", (Boolean) false).booleanValue();
            boolean zBooleanValue2 = C4809aa.m18104a().m18119a("admin_disclaimer", (Boolean) false).booleanValue();
            if (C4904y.f17872b) {
                C4904y.m18639b("adminUpgradeStatus : " + iIntValue2 + " adminNotice : " + zBooleanValue + " adminDisclaimer : " + zBooleanValue2, getClass().getSimpleName());
            }
            if (iIntValue2 == 1) {
                getVersionNotice.critical = false;
                getVersionNotice.uptodate = false;
                getVersionNotice.downloadurl = "market://details?id=com.sec.chaton";
                getVersionNotice.samsungappsurl = "samsungapps://ProductDetail/com.sec.chaton";
                getVersionNotice.newversion = Spam.CATEGORY_DEFAULT;
            }
            if (iIntValue2 == 2) {
                getVersionNotice.critical = true;
                getVersionNotice.uptodate = false;
                getVersionNotice.downloadurl = "market://details?id=com.sec.chaton";
                getVersionNotice.samsungappsurl = "samsungapps://ProductDetail/com.sec.chaton";
                getVersionNotice.newversion = Spam.CATEGORY_DEFAULT;
            }
            if (zBooleanValue) {
                getVersionNotice.notice = 5;
            }
            if (zBooleanValue2) {
                getVersionNotice.needPopup = true;
            }
            C4904y.m18639b("#notice : " + getVersionNotice.notice + " #Prefnotice: " + iIntValue, getClass().getSimpleName());
            if (getVersionNotice.notice != null && iIntValue != getVersionNotice.notice.intValue()) {
                C4809aa.m18106a("notice", getVersionNotice.notice);
                C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("more_tab_badge_update"));
            }
            if (!TextUtils.isEmpty(getVersionNotice.disclaimerUID)) {
                C4809aa.m18108a("disclaimer_UID", getVersionNotice.disclaimerUID);
            }
            C4904y.m18639b("disclaimerUID : " + getVersionNotice.disclaimerUID, getClass().getSimpleName());
            return;
        }
        C2404a.m10430a("01000002", "0003", c0778b);
    }
}
