package com.sec.vip.amschaton.honeycomb;

import android.widget.CompoundButton;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.av */
/* loaded from: classes.dex */
class C1426av implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5059a;

    C1426av(AMSPlayerActivity aMSPlayerActivity) {
        this.f5059a = aMSPlayerActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f5059a.f4991D = z;
    }
}
