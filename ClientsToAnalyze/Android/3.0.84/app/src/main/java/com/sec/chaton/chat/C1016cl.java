package com.sec.chaton.chat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.sec.chaton.chat.p024b.C0952c;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cl */
/* loaded from: classes.dex */
class C1016cl implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ C0952c f4094a;

    /* renamed from: b */
    final /* synthetic */ Spinner f4095b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f4096c;

    C1016cl(ChatFragment chatFragment, C0952c c0952c, Spinner spinner) {
        this.f4096c = chatFragment;
        this.f4094a = c0952c;
        this.f4095b = spinner;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        String unused = ChatFragment.f3486cQ = this.f4094a.m5154b((String) ((ArrayAdapter) this.f4095b.getAdapter()).getItem(i));
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
