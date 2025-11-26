package com.sec.chaton.chat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.sec.chaton.chat.p024b.C0952c;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ci */
/* loaded from: classes.dex */
class C1013ci implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ C0952c f4088a;

    /* renamed from: b */
    final /* synthetic */ Spinner f4089b;

    /* renamed from: c */
    final /* synthetic */ Spinner f4090c;

    /* renamed from: d */
    final /* synthetic */ ChatFragment f4091d;

    C1013ci(ChatFragment chatFragment, C0952c c0952c, Spinner spinner, Spinner spinner2) {
        this.f4091d = chatFragment;
        this.f4088a = c0952c;
        this.f4089b = spinner;
        this.f4090c = spinner2;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        String unused = ChatFragment.f3485cP = this.f4088a.m5154b((String) ((ArrayAdapter) this.f4089b.getAdapter()).getItem(i));
        this.f4088a.m5156d().m5131a(this.f4090c, ChatFragment.f3485cP, ChatFragment.f3486cQ);
        String unused2 = ChatFragment.f3486cQ = this.f4088a.m5154b((String) ((ArrayAdapter) this.f4090c.getAdapter()).getItem(0));
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
