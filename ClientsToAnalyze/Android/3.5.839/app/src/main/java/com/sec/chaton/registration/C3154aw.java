package com.sec.chaton.registration;

import android.widget.CompoundButton;
import com.sec.chaton.util.C4904y;

/* compiled from: FirstLauncherDialog.java */
/* renamed from: com.sec.chaton.registration.aw */
/* loaded from: classes.dex */
class C3154aw implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ C3134ac f11906a;

    C3154aw(C3134ac c3134ac) {
        this.f11906a = c3134ac;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C4904y.m18639b("[Mobile network] isChecked " + z, this.f11906a.f11886v);
        this.f11906a.f11881q = z;
    }
}
