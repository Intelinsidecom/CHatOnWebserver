package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.registration.ActivityRegist;

/* renamed from: com.sec.chaton.registration.ar */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0420ar implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegisteFragment f2931a;

    DialogInterfaceOnClickListenerC0420ar(ActivityRegist.RegisteFragment registeFragment) {
        this.f2931a = registeFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f2931a.m3078a(this.f2931a.getActivity(), this.f2931a.f2867l.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
