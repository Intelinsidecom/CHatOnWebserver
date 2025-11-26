package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p037j.EnumC1587o;
import java.io.UnsupportedEncodingException;

/* compiled from: ActivitySyncSignInPopup.java */
/* renamed from: com.sec.chaton.registration.t */
/* loaded from: classes.dex */
class HandlerC2303t extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivitySyncSignInPopup f8610a;

    HandlerC2303t(ActivitySyncSignInPopup activitySyncSignInPopup) {
        this.f8610a = activitySyncSignInPopup;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws UnsupportedEncodingException {
        if (!this.f8610a.f8101F) {
            C0267d c0267d = (C0267d) message.obj;
            switch (message.what) {
                case 301:
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        this.f8610a.m8398a(EnumC2124ab.get_buddies, c0267d.m1356g());
                        break;
                    } else {
                        this.f8610a.m8409c();
                        break;
                    }
                    break;
                case 305:
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        this.f8610a.m8398a(EnumC2124ab.extra_info, c0267d.m1356g());
                        break;
                    } else {
                        this.f8610a.m8399a(this.f8610a.getResources().getString(R.string.auto_regi_buddy_sync));
                        C1357af.m5988a();
                        this.f8610a.f8128q.m5717a();
                        this.f8610a.f8128q.m5736c();
                        break;
                    }
                case 2301:
                    if (this.f8610a.f8125n != null && this.f8610a.f8125n.isShowing()) {
                        this.f8610a.f8125n.dismiss();
                        this.f8610a.f8102G = null;
                    }
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        this.f8610a.m8398a(EnumC2124ab.get_chatlist, c0267d.m1356g());
                        break;
                    } else {
                        this.f8610a.m8409c();
                        C1335m.m5781a((Handler) null);
                        break;
                    }
                    break;
            }
        }
    }
}
