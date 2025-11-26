package com.sec.chaton.sns.p115ui;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.sns.p113a.C4365b;

/* compiled from: TwDialog.java */
/* renamed from: com.sec.chaton.sns.ui.am */
/* loaded from: classes.dex */
class HandlerC4459am extends Handler {

    /* renamed from: a */
    final /* synthetic */ DialogC4455ai f16117a;

    HandlerC4459am(DialogC4455ai dialogC4455ai) {
        this.f16117a = dialogC4455ai;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        switch (i) {
            case -1003:
                this.f16117a.f16107j.mo2272a(new C4365b("Exceed time", i, null));
                this.f16117a.dismiss();
                break;
        }
    }
}
