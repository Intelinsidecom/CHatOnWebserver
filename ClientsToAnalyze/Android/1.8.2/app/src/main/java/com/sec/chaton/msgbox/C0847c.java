package com.sec.chaton.msgbox;

import android.widget.CompoundButton;

/* compiled from: MsgBoxListAdapter.java */
/* renamed from: com.sec.chaton.msgbox.c */
/* loaded from: classes.dex */
class C0847c implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ int f3145a;

    /* renamed from: b */
    final /* synthetic */ C0845a f3146b;

    C0847c(C0845a c0845a, int i) {
        this.f3146b = c0845a;
        this.f3145a = i;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        compoundButton.setChecked(z);
        this.f3146b.f3136d.setItemChecked(this.f3145a, z);
    }
}
