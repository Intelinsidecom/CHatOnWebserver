package com.sec.chaton.chat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.sec.chaton.chat.translate.C1850c;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ah */
/* loaded from: classes.dex */
class C1561ah implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ C1850c f5974a;

    /* renamed from: b */
    final /* synthetic */ Spinner f5975b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f5976c;

    C1561ah(ChatFragment chatFragment, C1850c c1850c, Spinner spinner) {
        this.f5976c = chatFragment;
        this.f5974a = c1850c;
        this.f5975b = spinner;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        String unused = ChatFragment.f5467dk = this.f5974a.m9034b((String) ((ArrayAdapter) this.f5975b.getAdapter()).getItem(i));
        this.f5976c.m8086bc();
        this.f5976c.m8084bb();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
