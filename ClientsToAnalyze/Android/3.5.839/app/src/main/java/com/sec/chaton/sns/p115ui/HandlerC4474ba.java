package com.sec.chaton.sns.p115ui;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.sns.p113a.C4365b;

/* compiled from: WeiboDialog.java */
/* renamed from: com.sec.chaton.sns.ui.ba */
/* loaded from: classes.dex */
class HandlerC4474ba extends Handler {

    /* renamed from: a */
    final /* synthetic */ DialogC4469aw f16159a;

    HandlerC4474ba(DialogC4469aw dialogC4469aw) {
        this.f16159a = dialogC4469aw;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        switch (i) {
            case -1003:
                this.f16159a.f16147k.mo2272a(new C4365b("Exceed time", i, null));
                this.f16159a.dismiss();
                break;
        }
    }
}
