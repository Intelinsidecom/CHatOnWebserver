package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.di */
/* loaded from: classes.dex */
class C1655di extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6187a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1655di(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f6187a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("smsMappingTableChangeObserver onChange()", ChatFragment.f5461a);
        }
        if (!this.f6187a.f5731ej.m14354a()) {
            this.f6187a.m8259f(this.f6187a.f5750v);
        }
    }
}
