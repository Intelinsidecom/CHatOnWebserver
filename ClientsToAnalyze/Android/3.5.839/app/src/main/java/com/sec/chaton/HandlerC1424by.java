package com.sec.chaton;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.chat.C1770hp;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.by */
/* loaded from: classes.dex */
class HandlerC1424by extends Handler {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f5060a;

    HandlerC1424by(PlusFragment plusFragment) {
        this.f5060a = plusFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0788l c0788l = (C0788l) ((C1770hp) message.obj).m8779a();
        if (c0788l == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("resultEntry is null", PlusFragment.f1956a);
            }
            return;
        }
        switch (message.what) {
            case 49:
                if (!c0788l.f2172a) {
                    if (c0788l.m3152g() == 3004) {
                        this.f5060a.m2940d();
                        break;
                    } else {
                        if (C4904y.f17873c) {
                            C4904y.m18641c("Failed to send JoinTopicChat, Result object is null. Result Code:" + c0788l.f2173b, PlusFragment.f1956a);
                        }
                        C5179v.m19810a(CommonApplication.m18732r(), R.string.download_failed, 0).show();
                        break;
                    }
                }
                break;
        }
    }
}
