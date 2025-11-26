package com.sec.chaton;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bh */
/* loaded from: classes.dex */
class HandlerC0467bh extends Handler {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1535a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0467bh(TabActivity tabActivity, Looper looper) {
        super(looper);
        this.f1535a = tabActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        GetVersionNotice getVersionNotice;
        if (!this.f1535a.f802z) {
            C0267d c0267d = (C0267d) message.obj;
            if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && (getVersionNotice = (GetVersionNotice) c0267d.m1354e()) != null && getVersionNotice.uptodate != null) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("[mGetVersionWithDialog] : uptodate : " + getVersionNotice.uptodate + " critical : " + getVersionNotice.critical, TabActivity.f732f);
                }
                if (getVersionNotice.uptodate.booleanValue()) {
                    C3171am.m11081s();
                    this.f1535a.m1206G();
                } else if (getVersionNotice.critical != null && !getVersionNotice.critical.booleanValue()) {
                    C3159aa.m10963a("UpdateIsCritical", (Boolean) false);
                    this.f1535a.m1206G();
                }
            }
        }
    }
}
