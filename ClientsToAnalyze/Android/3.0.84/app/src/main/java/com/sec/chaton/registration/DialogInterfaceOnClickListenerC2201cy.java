package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cy */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2201cy implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2194cr f8493a;

    DialogInterfaceOnClickListenerC2201cy(HandlerC2194cr handlerC2194cr) {
        this.f8493a = handlerC2194cr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8493a.f8486a.getActivity() != null) {
            this.f8493a.f8486a.f8246n = ProgressDialogC3265l.m11490a(this.f8493a.f8486a.getActivity(), null, this.f8493a.f8486a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        }
        new C1324bj(this.f8493a.f8486a.f8237e).m5694b();
    }
}
