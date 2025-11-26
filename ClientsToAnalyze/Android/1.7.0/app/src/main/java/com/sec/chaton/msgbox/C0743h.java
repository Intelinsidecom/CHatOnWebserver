package com.sec.chaton.msgbox;

import android.widget.CompoundButton;

/* compiled from: MsgBoxListAdapter.java */
/* renamed from: com.sec.chaton.msgbox.h */
/* loaded from: classes.dex */
class C0743h implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ int f2538a;

    /* renamed from: b */
    final /* synthetic */ C0736a f2539b;

    C0743h(C0736a c0736a, int i) {
        this.f2539b = c0736a;
        this.f2538a = i;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        compoundButton.setChecked(z);
        this.f2539b.f2524d.setItemChecked(this.f2538a, z);
    }
}
