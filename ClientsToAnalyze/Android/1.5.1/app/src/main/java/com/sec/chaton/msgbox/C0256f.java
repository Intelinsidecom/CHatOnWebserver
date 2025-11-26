package com.sec.chaton.msgbox;

import android.widget.CompoundButton;

/* renamed from: com.sec.chaton.msgbox.f */
/* loaded from: classes.dex */
class C0256f implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ int f1995a;

    /* renamed from: b */
    final /* synthetic */ MsgBoxListAdapter f1996b;

    C0256f(MsgBoxListAdapter msgBoxListAdapter, int i) {
        this.f1996b = msgBoxListAdapter;
        this.f1995a = i;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        compoundButton.setChecked(z);
        this.f1996b.f1955c.setItemChecked(this.f1995a, z);
    }
}
