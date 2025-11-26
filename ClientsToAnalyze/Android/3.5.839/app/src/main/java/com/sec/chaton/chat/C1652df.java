package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.df */
/* loaded from: classes.dex */
class C1652df extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6184a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1652df(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f6184a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("mmsSmsMsgChangeObserver onChange() " + z, ChatFragment.f5461a);
        }
        if (!this.f6184a.f5731ej.m14354a()) {
            this.f6184a.m8276u();
        }
        if (this.f6184a.f5731ej != null) {
            this.f6184a.m7998aV();
        }
    }
}
