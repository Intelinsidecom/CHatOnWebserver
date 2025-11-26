package com.sec.vip.amschaton.ics;

import android.widget.CompoundButton;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.av */
/* loaded from: classes.dex */
class C1999av implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7279a;

    C1999av(AMSPlayerActivity aMSPlayerActivity) {
        this.f7279a = aMSPlayerActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f7279a.f7208F = z;
    }
}
