package com.sec.chaton;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.du */
/* loaded from: classes.dex */
class HandlerC2166du extends Handler {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7795a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2166du(TabActivity tabActivity, Looper looper) {
        super(looper);
        this.f7795a = tabActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        GetVersionNotice getVersionNotice;
        if (!this.f7795a.f2044M) {
            C0778b c0778b = (C0778b) message.obj;
            if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR && (getVersionNotice = (GetVersionNotice) c0778b.m3110e()) != null && getVersionNotice.uptodate != null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("[mGetVersionWithDialog] : uptodate : " + getVersionNotice.uptodate + " critical : " + getVersionNotice.critical, TabActivity.f2029t);
                }
                if (getVersionNotice.uptodate.booleanValue()) {
                    C4822an.m18256x();
                    this.f7795a.m3007K();
                } else if (getVersionNotice.critical != null && !getVersionNotice.critical.booleanValue()) {
                    C4809aa.m18105a("UpdateIsCritical", (Boolean) false);
                    this.f7795a.m3007K();
                }
            }
        }
    }
}
