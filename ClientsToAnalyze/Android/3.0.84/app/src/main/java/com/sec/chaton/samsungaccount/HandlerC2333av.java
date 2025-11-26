package com.sec.chaton.samsungaccount;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p037j.EnumC1587o;
import java.io.UnsupportedEncodingException;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.av */
/* loaded from: classes.dex */
class HandlerC2333av extends Handler {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8755a;

    HandlerC2333av(MainActivity mainActivity) {
        this.f8755a = mainActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws UnsupportedEncodingException {
        if (!this.f8755a.f8695aq) {
            C0267d c0267d = (C0267d) message.obj;
            switch (message.what) {
                case 301:
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        this.f8755a.m8741a(EnumC2337az.get_buddies, c0267d.m1356g());
                        break;
                    } else {
                        this.f8755a.m8791n();
                        break;
                    }
                    break;
                case 305:
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        this.f8755a.m8741a(EnumC2337az.extra_info, c0267d.m1356g());
                        break;
                    } else {
                        this.f8755a.m8742a(this.f8755a.getResources().getString(R.string.auto_regi_buddy_sync));
                        if (!this.f8755a.f8727x) {
                            this.f8755a.f8719p.m5717a();
                            break;
                        } else {
                            C1357af.m5988a();
                            this.f8755a.f8719p.m5717a();
                            this.f8755a.f8719p.m5736c();
                            break;
                        }
                    }
                case 2301:
                    this.f8755a.m8806u();
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        this.f8755a.m8741a(EnumC2337az.get_chatlist, c0267d.m1356g());
                        break;
                    } else {
                        this.f8755a.m8791n();
                        C1335m.m5781a((Handler) null);
                        break;
                    }
                    break;
            }
        }
    }
}
