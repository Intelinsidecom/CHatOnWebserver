package com.sec.chaton.chat;

import android.content.Intent;
import java.util.ArrayList;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.fb */
/* loaded from: classes.dex */
class RunnableC1702fb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f6304a;

    /* renamed from: b */
    final /* synthetic */ ArrayList f6305b;

    /* renamed from: c */
    final /* synthetic */ boolean f6306c;

    /* renamed from: d */
    final /* synthetic */ ChatInfoFragment f6307d;

    RunnableC1702fb(ChatInfoFragment chatInfoFragment, boolean z, ArrayList arrayList, boolean z2) {
        this.f6307d = chatInfoFragment;
        this.f6304a = z;
        this.f6305b = arrayList;
        this.f6306c = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Intent intent = this.f6307d.getActivity().getIntent();
        intent.putExtra("isClosing", true);
        intent.putExtra("isMapping", this.f6304a);
        intent.putExtra("mappedSMS", this.f6305b);
        intent.putExtra("removeLockedSMS", this.f6306c);
        this.f6307d.getActivity().setResult(-1, intent);
        ((InterfaceC1710fj) this.f6307d.getActivity()).mo8281h();
    }
}
