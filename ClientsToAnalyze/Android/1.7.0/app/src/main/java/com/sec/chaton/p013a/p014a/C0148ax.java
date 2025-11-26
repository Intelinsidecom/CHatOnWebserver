package com.sec.chaton.p013a.p014a;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.GetVersionNotice;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: GetVersionNoticeTask.java */
/* renamed from: com.sec.chaton.a.a.ax */
/* loaded from: classes.dex */
public class C0148ax extends AbstractRunnableC0153bb {
    public C0148ax(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        GetVersionNotice getVersionNotice = (GetVersionNotice) c0259g.m932d();
        C1341p.m4662e("" + getVersionNotice, getClass().getSimpleName());
        if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
            int i = C1323bs.m4575a().getInt("notice", 0);
            if (getVersionNotice.UTCtimestamp != null) {
                C1323bs.m4579a("server_time", getVersionNotice.UTCtimestamp);
            }
            if (getVersionNotice.mcc != null && C1323bs.m4575a().contains("uid") && C1323bs.m4575a().getString("selected_country", "").equals("DONE")) {
                C1323bs.m4579a("registration_mcc", getVersionNotice.mcc);
            }
            C1341p.m4658b("#notice : " + getVersionNotice.notice + " #Prefnotice: " + i, getClass().getSimpleName());
            if (C1323bs.m4575a().getString("first_disclaimer_status", "").equals("DONE") && i != getVersionNotice.notice.intValue()) {
                C1323bs.m4577a("notice", getVersionNotice.notice);
                LocalBroadcastManager.getInstance(GlobalApplication.m3100a()).sendBroadcast(new Intent("setting_tab_badge_update"));
            }
        }
    }
}
