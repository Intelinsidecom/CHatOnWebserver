package com.sec.chaton.registration;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.dg */
/* loaded from: classes.dex */
class ViewOnClickListenerC2210dg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f8503a;

    ViewOnClickListenerC2210dg(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f8503a = fragmentNonSelfSMS;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f8503a.f8239g.requestFocus();
        ((InputMethodManager) this.f8503a.getActivity().getSystemService("input_method")).showSoftInput(this.f8503a.f8239g, 1);
    }
}
