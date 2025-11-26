package com.sec.chaton.p025d.p026a;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: GetVersionNoticeTask.java */
/* renamed from: com.sec.chaton.d.a.cp */
/* loaded from: classes.dex */
public class C1215cp extends AbstractC1145a {
    public C1215cp(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        GetVersionNotice getVersionNotice = (GetVersionNotice) c0267d.m1354e();
        C3250y.m11456e("" + getVersionNotice, getClass().getSimpleName());
        if (getVersionNotice != null && c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            int iIntValue = C3159aa.m10962a().m10978a("notice", (Integer) 0).intValue();
            if (getVersionNotice.UTCtimestamp != null) {
                C3159aa.m10966a("server_time", getVersionNotice.UTCtimestamp);
            }
            int iIntValue2 = C3159aa.m10962a().m10978a("admin_upgrade", (Integer) (-1)).intValue();
            boolean zBooleanValue = C3159aa.m10962a().m10977a("admin_notice", (Boolean) false).booleanValue();
            boolean zBooleanValue2 = C3159aa.m10962a().m10977a("admin_disclaimer", (Boolean) false).booleanValue();
            if (C3250y.f11734b) {
                C3250y.m11450b("adminUpgradeStatus : " + iIntValue2 + " adminNotice : " + zBooleanValue + " adminDisclaimer : " + zBooleanValue2, getClass().getSimpleName());
            }
            if (iIntValue2 == 1) {
                getVersionNotice.critical = false;
                getVersionNotice.uptodate = false;
                getVersionNotice.downloadurl = "market://details?id=com.sec.chaton";
                getVersionNotice.samsungappsurl = "samsungapps://ProductDetail/com.sec.chaton";
                getVersionNotice.newversion = "test";
            }
            if (iIntValue2 == 2) {
                getVersionNotice.critical = true;
                getVersionNotice.uptodate = false;
                getVersionNotice.downloadurl = "market://details?id=com.sec.chaton";
                getVersionNotice.samsungappsurl = "samsungapps://ProductDetail/com.sec.chaton";
                getVersionNotice.newversion = "test";
            }
            if (zBooleanValue) {
                getVersionNotice.notice = 5;
            }
            if (zBooleanValue2) {
                getVersionNotice.needPopup = true;
            }
            C3250y.m11450b("#notice : " + getVersionNotice.notice + " #Prefnotice: " + iIntValue, getClass().getSimpleName());
            if (getVersionNotice.notice != null && iIntValue != getVersionNotice.notice.intValue()) {
                C3159aa.m10964a("notice", getVersionNotice.notice);
                LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
            }
            if (!TextUtils.isEmpty(getVersionNotice.disclaimerUID)) {
                C3159aa.m10966a("disclaimer_UID", getVersionNotice.disclaimerUID);
            }
            C3250y.m11450b("disclaimerUID : " + getVersionNotice.disclaimerUID, getClass().getSimpleName());
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000002", "0003", c0267d);
        }
    }
}
