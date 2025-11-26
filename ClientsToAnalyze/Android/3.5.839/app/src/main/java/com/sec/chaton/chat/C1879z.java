package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.z */
/* loaded from: classes.dex */
class C1879z extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f7097a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1879z(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f7097a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C4904y.m18639b("[MSGBOX] mChatlistObserver ", ChatFragment.f5461a);
        if (this.f7097a.f5654cr) {
            this.f7097a.f5683dV = true;
        } else {
            this.f7097a.f5546ao.startQuery(99, null, C2299s.m10188b(), null, null, null, null);
        }
    }
}
