package com.sec.chaton.p015d.p016a;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetVersionNotice;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: GetVersionNoticeTask.java */
/* renamed from: com.sec.chaton.d.a.ba */
/* loaded from: classes.dex */
public class C0560ba extends AbstractRunnableC0532a {
    public C0560ba(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        GetVersionNotice getVersionNotice = (GetVersionNotice) c0101b.m671d();
        C1786r.m6066e("" + getVersionNotice, getClass().getSimpleName());
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
            int i = C1789u.m6075a().getInt("notice", 0);
            if (getVersionNotice.UTCtimestamp != null) {
                C1789u.m6079a("server_time", getVersionNotice.UTCtimestamp);
            }
            C1786r.m6061b("#notice : " + getVersionNotice.notice + " #Prefnotice: " + i, getClass().getSimpleName());
            if (i != getVersionNotice.notice.intValue()) {
                C1789u.m6077a("notice", getVersionNotice.notice);
                LocalBroadcastManager.getInstance(GlobalApplication.m3260b()).sendBroadcast(new Intent("setting_tab_badge_update"));
            }
            if (!TextUtils.isEmpty(getVersionNotice.disclaimerUID)) {
                C1789u.m6079a("disclaimer_UID", getVersionNotice.disclaimerUID);
            }
            C1786r.m6061b("disclaimerUID : " + getVersionNotice.disclaimerUID, getClass().getSimpleName());
        }
    }
}
