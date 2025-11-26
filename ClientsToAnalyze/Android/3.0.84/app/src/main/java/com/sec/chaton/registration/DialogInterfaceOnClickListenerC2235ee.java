package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.ee */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2235ee implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2231ea f8530a;

    DialogInterfaceOnClickListenerC2235ee(HandlerC2231ea handlerC2231ea) {
        this.f8530a = handlerC2231ea;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!C3171am.m11080r()) {
            this.f8530a.f8526a.m8586e();
        } else if (this.f8530a.f8526a.getActivity() != null) {
            this.f8530a.f8526a.f8269I = ProgressDialogC3265l.m11490a(this.f8530a.f8526a.f8271K, null, this.f8530a.f8526a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            this.f8530a.f8526a.f8275O.m5602a(this.f8530a.f8526a.f8289c, true);
            this.f8530a.f8526a.f8286Z = true;
        }
    }
}
