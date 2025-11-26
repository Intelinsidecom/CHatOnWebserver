package com.sec.chaton.calllog.common.view.layout;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.calllog.view.CallLogFragment;

/* compiled from: RadioButtonListDialog.java */
/* renamed from: com.sec.chaton.calllog.common.view.layout.d */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0831d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RadioButtonListDialog f3174a;

    DialogInterfaceOnClickListenerC0831d(RadioButtonListDialog radioButtonListDialog) {
        this.f3174a = radioButtonListDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int unused = RadioButtonListDialog.f3165a = i;
        Fragment fragmentFindFragmentById = this.f3174a.getFragmentManager().findFragmentById(R.id.fragment_controller);
        if (fragmentFindFragmentById instanceof CallLogFragment) {
            ((CallLogFragment) fragmentFindFragmentById).m4583c(i);
            this.f3174a.dismiss();
        }
    }
}
