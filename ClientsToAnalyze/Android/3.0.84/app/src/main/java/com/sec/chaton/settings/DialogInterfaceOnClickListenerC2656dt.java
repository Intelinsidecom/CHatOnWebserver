package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: FragmentMultiDeviceView.java */
/* renamed from: com.sec.chaton.settings.dt */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2656dt implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC2655ds f9921a;

    DialogInterfaceOnClickListenerC2656dt(ViewOnClickListenerC2655ds viewOnClickListenerC2655ds) {
        this.f9921a = viewOnClickListenerC2655ds;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f9921a.f9920b.f9914a.f9159j = ProgressDialogC3265l.m11489a(this.f9921a.f9920b.f9914a.f9153d, null, this.f9921a.f9920b.f9914a.getResources().getString(R.string.dialog_provision_ing));
        this.f9921a.f9920b.f9914a.f9157h.m5618b(this.f9921a.f9919a);
    }
}
