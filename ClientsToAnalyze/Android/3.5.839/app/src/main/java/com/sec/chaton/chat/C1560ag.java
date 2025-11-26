package com.sec.chaton.chat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import com.sec.chaton.chat.translate.C1850c;
import com.sec.chaton.chat.translate.C1865r;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ag */
/* loaded from: classes.dex */
class C1560ag implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ C1850c f5968a;

    /* renamed from: b */
    final /* synthetic */ Spinner f5969b;

    /* renamed from: c */
    final /* synthetic */ Spinner f5970c;

    /* renamed from: d */
    final /* synthetic */ CheckBox f5971d;

    /* renamed from: e */
    final /* synthetic */ CheckBox f5972e;

    /* renamed from: f */
    final /* synthetic */ ChatFragment f5973f;

    C1560ag(ChatFragment chatFragment, C1850c c1850c, Spinner spinner, Spinner spinner2, CheckBox checkBox, CheckBox checkBox2) {
        this.f5973f = chatFragment;
        this.f5968a = c1850c;
        this.f5969b = spinner;
        this.f5970c = spinner2;
        this.f5971d = checkBox;
        this.f5972e = checkBox2;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        String unused = ChatFragment.f5468dl = this.f5968a.m9034b((String) ((ArrayAdapter) this.f5969b.getAdapter()).getItem(i));
        if (this.f5968a.m9039e().m9008a(this.f5970c, ChatFragment.f5468dl, ChatFragment.f5467dk)) {
            String unused2 = ChatFragment.f5467dk = this.f5968a.m9034b((String) ((ArrayAdapter) this.f5970c.getAdapter()).getItem(0));
            this.f5973f.m8086bc();
        } else if (!this.f5971d.isChecked() && C1865r.m9070b()) {
            this.f5973f.m8086bc();
        } else if (!this.f5972e.isChecked() && !C1865r.m9070b()) {
            this.f5973f.m8086bc();
        }
        this.f5973f.m8084bb();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
