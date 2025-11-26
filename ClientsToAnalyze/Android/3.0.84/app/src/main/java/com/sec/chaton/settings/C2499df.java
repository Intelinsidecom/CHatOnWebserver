package com.sec.chaton.settings;

import android.widget.CompoundButton;

/* compiled from: DeregisterFragment.java */
/* renamed from: com.sec.chaton.settings.df */
/* loaded from: classes.dex */
class C2499df implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ DeregisterFragment f9389a;

    C2499df(DeregisterFragment deregisterFragment) {
        this.f9389a = deregisterFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f9389a.m9087b();
        compoundButton.playSoundEffect(0);
    }
}
