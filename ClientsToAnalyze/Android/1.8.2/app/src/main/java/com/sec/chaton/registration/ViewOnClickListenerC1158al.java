package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.registration.ActivityRegistPushName;

/* compiled from: ActivityRegistPushName.java */
/* renamed from: com.sec.chaton.registration.al */
/* loaded from: classes.dex */
class ViewOnClickListenerC1158al implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegistPushName.RegistPushNameFragment f4360a;

    ViewOnClickListenerC1158al(ActivityRegistPushName.RegistPushNameFragment registPushNameFragment) {
        this.f4360a = registPushNameFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (R.id.btnDone == view.getId()) {
            this.f4360a.m4405a();
        } else if (R.id.btnCancel == view.getId()) {
            this.f4360a.getActivity().setResult(0);
            this.f4360a.f4257a.setText("");
        }
    }
}
