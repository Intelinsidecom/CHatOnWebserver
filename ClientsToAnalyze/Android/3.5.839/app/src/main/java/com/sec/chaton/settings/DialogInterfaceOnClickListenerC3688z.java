package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.sns.p113a.C4368e;

/* compiled from: AccountFragment.java */
/* renamed from: com.sec.chaton.settings.z */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3688z implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC3686x f13293a;

    DialogInterfaceOnClickListenerC3688z(ViewOnClickListenerC3686x viewOnClickListenerC3686x) {
        this.f13293a = viewOnClickListenerC3686x;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f13293a.f13291a.f13282a.m13345f();
        this.f13293a.f13291a.f13282a.m13330a(C4368e.f15820f, (Integer) 202);
    }
}
