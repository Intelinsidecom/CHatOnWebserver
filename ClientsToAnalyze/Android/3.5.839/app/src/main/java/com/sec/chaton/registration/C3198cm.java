package com.sec.chaton.registration;

import android.widget.CompoundButton;
import com.sec.chaton.util.C4904y;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cm */
/* loaded from: classes.dex */
class C3198cm implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f11962a;

    C3198cm(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f11962a = fragmentNonSelfSMS;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C4904y.m18639b("[Sim sync] isChecked " + z, getClass().getSimpleName());
        this.f11962a.f11672I = z;
        compoundButton.playSoundEffect(0);
    }
}
