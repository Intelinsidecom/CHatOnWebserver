package com.sec.chaton.registration;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.dg */
/* loaded from: classes.dex */
class ViewOnClickListenerC3219dg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f11984a;

    ViewOnClickListenerC3219dg(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f11984a = fragmentNonSelfSMS;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11984a.f11685g.requestFocus();
        ((InputMethodManager) this.f11984a.getActivity().getSystemService("input_method")).showSoftInput(this.f11984a.f11685g, 1);
    }
}
