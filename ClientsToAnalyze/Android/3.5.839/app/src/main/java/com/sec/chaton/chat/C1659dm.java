package com.sec.chaton.chat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.sec.chaton.chat.translate.C1850c;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dm */
/* loaded from: classes.dex */
class C1659dm implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ C1850c f6199a;

    /* renamed from: b */
    final /* synthetic */ Spinner f6200b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f6201c;

    C1659dm(ChatFragment chatFragment, C1850c c1850c, Spinner spinner) {
        this.f6201c = chatFragment;
        this.f6199a = c1850c;
        this.f6200b = spinner;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        String unused = ChatFragment.f5467dk = this.f6199a.m9034b((String) ((ArrayAdapter) this.f6200b.getAdapter()).getItem(i));
        this.f6201c.m8086bc();
        this.f6201c.m8084bb();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
