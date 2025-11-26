package com.sec.chaton.registration;

import android.widget.CompoundButton;
import com.sec.chaton.util.C3250y;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cl */
/* loaded from: classes.dex */
class C2188cl implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f8480a;

    C2188cl(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f8480a = fragmentNonSelfSMS;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C3250y.m11450b("[Sim sync] isChecked " + z, getClass().getSimpleName());
        this.f8480a.f8227H = z;
    }
}
