package com.sec.chaton.buddy.dialog;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;

/* compiled from: SpamConfirmDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.aj */
/* loaded from: classes.dex */
class HandlerC1210aj extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpamConfirmDialog f4705a;

    HandlerC1210aj(SpamConfirmDialog spamConfirmDialog) {
        this.f4705a = spamConfirmDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 605:
                if (!c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS) {
                    C4904y.m18639b("****** Report Spammer fail : " + this.f4705a.f4656e, SpamConfirmDialog.f4652b);
                    break;
                } else {
                    C4904y.m18639b("****** Report Spammer success : " + this.f4705a.f4656e, SpamConfirmDialog.f4652b);
                    break;
                }
                break;
        }
    }
}
