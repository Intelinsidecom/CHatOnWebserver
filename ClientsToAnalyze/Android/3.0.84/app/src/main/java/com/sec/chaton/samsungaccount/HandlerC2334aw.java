package com.sec.chaton.samsungaccount;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3171am;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.aw */
/* loaded from: classes.dex */
class HandlerC2334aw extends Handler {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8756a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2334aw(MainActivity mainActivity, Looper looper) {
        super(looper);
        this.f8756a = mainActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d;
        GetVersionNotice getVersionNotice;
        if (!this.f8756a.f8695aq && (c0267d = (C0267d) message.obj) != null && c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && (getVersionNotice = (GetVersionNotice) c0267d.m1354e()) != null) {
            if ((getVersionNotice.uptodate != null && getVersionNotice.uptodate.booleanValue()) || (getVersionNotice.critical != null && !getVersionNotice.critical.booleanValue())) {
                C3171am.m11081s();
                this.f8756a.m8785j();
            }
        }
    }
}
