package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.registration.ActivityRegistPushName;

/* compiled from: ActivityRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ae */
/* loaded from: classes.dex */
class ViewOnClickListenerC0933ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegistPushName.RegistPushNameFragment f3320a;

    ViewOnClickListenerC0933ae(ActivityRegistPushName.RegistPushNameFragment registPushNameFragment) {
        this.f3320a = registPushNameFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (R.id.btnDone == view.getId()) {
            this.f3320a.m3717a();
        } else if (R.id.btnCancel == view.getId()) {
            this.f3320a.getActivity().setResult(0);
            this.f3320a.f3232a.setText("");
        }
    }
}
