package com.sec.chaton.mobileweb;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.util.C4904y;

/* compiled from: GeneralWebFragment.java */
/* renamed from: com.sec.chaton.mobileweb.e */
/* loaded from: classes.dex */
class HandlerC2591e extends Handler {

    /* renamed from: a */
    final /* synthetic */ GeneralWebFragment f9251a;

    HandlerC2591e(GeneralWebFragment generalWebFragment) {
        this.f9251a = generalWebFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f9251a.isValidActivity()) {
            switch (message.what) {
                case 0:
                    String str = (String) message.obj;
                    this.f9251a.loadUrl(str);
                    C4904y.m18639b("[OUT] RESPONSE : " + str, GeneralWebFragment.f9200b);
                    break;
            }
        }
    }
}
