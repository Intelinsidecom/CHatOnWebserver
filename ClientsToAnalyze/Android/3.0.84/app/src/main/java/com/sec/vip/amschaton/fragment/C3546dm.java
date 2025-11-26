package com.sec.vip.amschaton.fragment;

import android.widget.CompoundButton;

/* compiled from: AMSViewerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.dm */
/* loaded from: classes.dex */
class C3546dm implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ AMSViewerFragment f12974a;

    C3546dm(AMSViewerFragment aMSViewerFragment) {
        this.f12974a = aMSViewerFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f12974a.f12790W = z;
    }
}
