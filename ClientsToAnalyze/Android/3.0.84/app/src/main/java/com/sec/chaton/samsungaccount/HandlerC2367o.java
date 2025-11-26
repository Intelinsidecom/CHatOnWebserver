package com.sec.chaton.samsungaccount;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import java.io.UnsupportedEncodingException;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.o */
/* loaded from: classes.dex */
class HandlerC2367o extends Handler {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8825a;

    HandlerC2367o(MainActivity mainActivity) {
        this.f8825a = mainActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws UnsupportedEncodingException {
        if (!this.f8825a.f8695aq) {
            C0267d c0267d = (C0267d) message.obj;
            if (message.what == 1104) {
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    this.f8825a.m8741a(EnumC2337az.version_for_nation, c0267d.m1356g());
                    return;
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b("GET_VERSION_NOTICE success", getClass().getSimpleName());
                }
                if (C3214cb.m11256a(this.f8825a.f8714k)) {
                    this.f8825a.m8742a(this.f8825a.getResources().getString(R.string.synchronising_chatonv));
                    if (this.f8825a.f8690al != null) {
                        if (C3214cb.m11245a(this.f8825a.f8714k, this.f8825a.f8690al) != 0) {
                            this.f8825a.m8742a(this.f8825a.getResources().getString(R.string.auto_regi_buddy_sync));
                            C1357af.m5988a();
                            this.f8825a.f8719p.m5717a();
                            this.f8825a.f8719p.m5736c();
                            return;
                        }
                        return;
                    }
                    this.f8825a.m8742a(this.f8825a.getResources().getString(R.string.auto_regi_buddy_sync));
                    C1357af.m5988a();
                    this.f8825a.f8719p.m5717a();
                    this.f8825a.f8719p.m5736c();
                    return;
                }
                this.f8825a.m8742a(this.f8825a.getResources().getString(R.string.auto_regi_buddy_sync));
                C1357af.m5988a();
                this.f8825a.f8719p.m5717a();
                this.f8825a.f8719p.m5736c();
            }
        }
    }
}
