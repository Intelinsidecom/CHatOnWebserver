package com.sec.chaton.forward;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p017e.C0688c;

/* compiled from: ChatForwardFragment.java */
/* renamed from: com.sec.chaton.forward.b */
/* loaded from: classes.dex */
class C0749b extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatForwardFragment f2765a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0749b(ChatForwardFragment chatForwardFragment, Handler handler) {
        super(handler);
        this.f2765a = chatForwardFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f2765a.f2760o.startQuery(1, null, C0688c.f2606a, null, "buddy_is_new='Y'", null, null);
    }
}
