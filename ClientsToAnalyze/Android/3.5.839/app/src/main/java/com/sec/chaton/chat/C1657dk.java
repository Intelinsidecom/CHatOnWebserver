package com.sec.chaton.chat;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.sec.chaton.chat.translate.C1865r;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dk */
/* loaded from: classes.dex */
class C1657dk implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f6189a;

    /* renamed from: b */
    final /* synthetic */ CheckBox f6190b;

    /* renamed from: c */
    final /* synthetic */ C1670dx f6191c;

    /* renamed from: d */
    final /* synthetic */ C1670dx f6192d;

    /* renamed from: e */
    final /* synthetic */ ChatFragment f6193e;

    C1657dk(ChatFragment chatFragment, CheckBox checkBox, CheckBox checkBox2, C1670dx c1670dx, C1670dx c1670dx2) {
        this.f6193e = chatFragment;
        this.f6189a = checkBox;
        this.f6190b = checkBox2;
        this.f6191c = c1670dx;
        this.f6192d = c1670dx2;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        boolean z2 = true;
        if (z) {
            if (C1865r.m9070b()) {
                if (!this.f6189a.isChecked()) {
                    z2 = false;
                }
            } else if (!this.f6190b.isChecked()) {
                z2 = false;
            }
        }
        this.f6193e.m8076b(z, z2);
        if (C1865r.m9070b()) {
            this.f6193e.m7928a(this.f6191c, z);
        } else {
            this.f6193e.m7928a(this.f6192d, z);
        }
    }
}
