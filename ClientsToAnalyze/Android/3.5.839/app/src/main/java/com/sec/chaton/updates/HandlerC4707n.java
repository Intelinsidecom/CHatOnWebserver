package com.sec.chaton.updates;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;

/* compiled from: UpdatesFragment.java */
/* renamed from: com.sec.chaton.updates.n */
/* loaded from: classes.dex */
class HandlerC4707n extends Handler {

    /* renamed from: a */
    final /* synthetic */ UpdatesFragment f17054a;

    HandlerC4707n(UpdatesFragment updatesFragment) {
        this.f17054a = updatesFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        if (this.f17054a.getActivity() != null) {
            switch (message.what) {
                case 8001:
                    if (this.f17054a.f16972f != null && this.f17054a.f16972f.isShown()) {
                        this.f17054a.f16972f.setVisibility(8);
                    }
                    if (this.f17054a.f16971e != null && this.f17054a.f16971e.isShown()) {
                        this.f17054a.f16971e.setVisibility(8);
                    }
                    this.f17054a.m17726a((C0778b) message.obj);
                    break;
            }
        }
    }
}
