package com.sec.vip.amschaton.ics;

import android.widget.CompoundButton;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bm */
/* loaded from: classes.dex */
class C1509bm implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5333a;

    C1509bm(AMSPlayerActivity aMSPlayerActivity) {
        this.f5333a = aMSPlayerActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f5333a.f5237D = z;
    }
}
