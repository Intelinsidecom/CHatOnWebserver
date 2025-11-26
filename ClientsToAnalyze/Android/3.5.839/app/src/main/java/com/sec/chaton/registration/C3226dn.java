package com.sec.chaton.registration;

import android.widget.CompoundButton;
import com.sec.chaton.util.C4904y;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dn */
/* loaded from: classes.dex */
class C3226dn implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f11992a;

    C3226dn(FragmentRegist fragmentRegist) {
        this.f11992a = fragmentRegist;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C4904y.m18639b("[Sim sync] isChecked " + z, getClass().getSimpleName());
        this.f11992a.f11733V = z;
    }
}
