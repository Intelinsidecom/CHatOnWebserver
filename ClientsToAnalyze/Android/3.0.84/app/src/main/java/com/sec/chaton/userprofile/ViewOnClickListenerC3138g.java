package com.sec.chaton.userprofile;

import android.view.View;

/* compiled from: BirthdayImpl.java */
/* renamed from: com.sec.chaton.userprofile.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC3138g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3137f f11394a;

    ViewOnClickListenerC3138g(C3137f c3137f) {
        this.f11394a = c3137f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11394a.f11390s.getFragmentManager().popBackStack();
    }
}
