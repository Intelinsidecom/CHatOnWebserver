package com.sec.chaton.buddy.dialog;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;

/* compiled from: SpamConfirmDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.z */
/* loaded from: classes.dex */
class HandlerC0644z extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpamConfirmDialog f2864a;

    HandlerC0644z(SpamConfirmDialog spamConfirmDialog) {
        this.f2864a = spamConfirmDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 605:
                if (!c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.SUCCESS) {
                    C3250y.m11450b("****** Report Spammer fail : " + this.f2864a.f2787e, SpamConfirmDialog.f2783b);
                    break;
                } else {
                    C3250y.m11450b("****** Report Spammer success : " + this.f2864a.f2787e, SpamConfirmDialog.f2783b);
                    break;
                }
                break;
        }
    }
}
