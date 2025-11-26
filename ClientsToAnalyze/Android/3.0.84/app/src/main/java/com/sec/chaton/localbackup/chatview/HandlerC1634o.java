package com.sec.chaton.localbackup.chatview;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.localbackup.p045a.C1613d;
import com.sec.common.util.p070a.C3338g;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.o */
/* loaded from: classes.dex */
class HandlerC1634o extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatViewFragment f6082a;

    HandlerC1634o(ChatViewFragment chatViewFragment) {
        this.f6082a = chatViewFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 2:
                C3338g c3338g = (C3338g) message.obj;
                this.f6082a.m6872a((C1613d) c3338g.m11768a(), c3338g.m11772b().getAbsolutePath());
                break;
        }
    }
}
