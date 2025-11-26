package com.sec.vip.amschaton.honeycomb;

import android.widget.CompoundButton;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bo */
/* loaded from: classes.dex */
class C1934bo implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7074a;

    C1934bo(AMSPlayerActivity aMSPlayerActivity) {
        this.f7074a = aMSPlayerActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f7074a.f6978F = z;
    }
}
