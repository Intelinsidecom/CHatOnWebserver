package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.registration.ActivityRegist;

/* renamed from: com.sec.chaton.registration.au */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0423au implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegisteFragment f2934a;

    DialogInterfaceOnClickListenerC0423au(ActivityRegist.RegisteFragment registeFragment) {
        this.f2934a = registeFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
