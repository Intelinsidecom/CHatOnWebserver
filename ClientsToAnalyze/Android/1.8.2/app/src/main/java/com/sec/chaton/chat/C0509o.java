package com.sec.chaton.chat;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.o */
/* loaded from: classes.dex */
class C0509o implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2116a;

    C0509o(ChatFragment chatFragment) {
        this.f2116a = chatFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        int unused = ChatFragment.f1747cl = i;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }
}
