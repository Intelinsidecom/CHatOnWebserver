package com.sec.chaton.registration;

import android.widget.CompoundButton;
import com.sec.chaton.util.C3250y;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.bc */
/* loaded from: classes.dex */
class C2152bc implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8428a;

    C2152bc(AuthenticatorActivity authenticatorActivity) {
        this.f8428a = authenticatorActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C3250y.m11450b("[DataPacket] isChecked " + z, this.f8428a.f8138A);
        this.f8428a.f8156o = z;
    }
}
