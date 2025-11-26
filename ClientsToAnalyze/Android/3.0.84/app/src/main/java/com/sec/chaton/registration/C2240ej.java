package com.sec.chaton.registration;

import android.widget.CompoundButton;
import com.sec.chaton.util.C3250y;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.ej */
/* loaded from: classes.dex */
class C2240ej implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f8535a;

    C2240ej(FragmentRegist fragmentRegist) {
        this.f8535a = fragmentRegist;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C3250y.m11450b("[Sim sync] isChecked " + z, getClass().getSimpleName());
        this.f8535a.f8273M = z;
    }
}
