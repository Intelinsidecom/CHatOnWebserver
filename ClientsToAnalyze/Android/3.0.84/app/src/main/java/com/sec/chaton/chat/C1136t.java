package com.sec.chaton.chat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.sec.chaton.chat.p024b.C0952c;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.t */
/* loaded from: classes.dex */
class C1136t implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ C0952c f4552a;

    /* renamed from: b */
    final /* synthetic */ Spinner f4553b;

    /* renamed from: c */
    final /* synthetic */ Spinner f4554c;

    /* renamed from: d */
    final /* synthetic */ ChatFragment f4555d;

    C1136t(ChatFragment chatFragment, C0952c c0952c, Spinner spinner, Spinner spinner2) {
        this.f4555d = chatFragment;
        this.f4552a = c0952c;
        this.f4553b = spinner;
        this.f4554c = spinner2;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        String unused = ChatFragment.f3485cP = this.f4552a.m5154b((String) ((ArrayAdapter) this.f4553b.getAdapter()).getItem(i));
        this.f4552a.m5156d().m5131a(this.f4554c, ChatFragment.f3485cP, ChatFragment.f3486cQ);
        String unused2 = ChatFragment.f3486cQ = this.f4552a.m5154b((String) ((ArrayAdapter) this.f4554c.getAdapter()).getItem(0));
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
