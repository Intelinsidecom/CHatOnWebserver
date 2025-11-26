package com.sec.chaton.registration;

import android.widget.CompoundButton;
import com.sec.chaton.util.C4904y;

/* compiled from: FirstLauncherDialog.java */
/* renamed from: com.sec.chaton.registration.ao */
/* loaded from: classes.dex */
class C3146ao implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ C3134ac f11898a;

    C3146ao(C3134ac c3134ac) {
        this.f11898a = c3134ac;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C4904y.m18639b("[Roaming network] isChecked " + z, this.f11898a.f11886v);
        this.f11898a.f11881q = z;
    }
}
