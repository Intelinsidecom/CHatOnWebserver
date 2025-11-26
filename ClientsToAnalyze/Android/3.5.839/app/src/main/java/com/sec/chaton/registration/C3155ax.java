package com.sec.chaton.registration;

import android.widget.CompoundButton;
import com.sec.chaton.util.C4904y;

/* compiled from: FirstLauncherDialog.java */
/* renamed from: com.sec.chaton.registration.ax */
/* loaded from: classes.dex */
class C3155ax implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ C3134ac f11907a;

    C3155ax(C3134ac c3134ac) {
        this.f11907a = c3134ac;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C4904y.m18639b("[WLAN] isChecked " + z, this.f11907a.f11886v);
        this.f11907a.f11881q = z;
    }
}
