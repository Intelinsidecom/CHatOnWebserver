package com.sec.chaton.chat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import com.sec.chaton.chat.translate.C1850c;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dl */
/* loaded from: classes.dex */
class C1658dl implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ C1850c f6194a;

    /* renamed from: b */
    final /* synthetic */ Spinner f6195b;

    /* renamed from: c */
    final /* synthetic */ Spinner f6196c;

    /* renamed from: d */
    final /* synthetic */ CheckBox f6197d;

    /* renamed from: e */
    final /* synthetic */ ChatFragment f6198e;

    C1658dl(ChatFragment chatFragment, C1850c c1850c, Spinner spinner, Spinner spinner2, CheckBox checkBox) {
        this.f6198e = chatFragment;
        this.f6194a = c1850c;
        this.f6195b = spinner;
        this.f6196c = spinner2;
        this.f6197d = checkBox;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        String unused = ChatFragment.f5468dl = this.f6194a.m9034b((String) ((ArrayAdapter) this.f6195b.getAdapter()).getItem(i));
        if (this.f6194a.m9039e().m9008a(this.f6196c, ChatFragment.f5468dl, ChatFragment.f5467dk)) {
            String unused2 = ChatFragment.f5467dk = this.f6194a.m9034b((String) ((ArrayAdapter) this.f6196c.getAdapter()).getItem(0));
            this.f6198e.m8086bc();
        } else if (!this.f6197d.isChecked()) {
            this.f6198e.m8086bc();
        }
        this.f6198e.m8084bb();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
