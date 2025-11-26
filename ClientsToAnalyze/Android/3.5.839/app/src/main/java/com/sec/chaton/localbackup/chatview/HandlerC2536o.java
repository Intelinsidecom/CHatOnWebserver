package com.sec.chaton.localbackup.chatview;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.localbackup.p075a.C2513d;
import com.sec.common.util.p133a.C5023g;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.o */
/* loaded from: classes.dex */
class HandlerC2536o extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatViewFragment f9126a;

    HandlerC2536o(ChatViewFragment chatViewFragment) {
        this.f9126a = chatViewFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 2:
                C5023g c5023g = (C5023g) message.obj;
                this.f9126a.m10902a((C2513d) c5023g.m19082a(), c5023g.m19086b().getAbsolutePath());
                break;
        }
    }
}
