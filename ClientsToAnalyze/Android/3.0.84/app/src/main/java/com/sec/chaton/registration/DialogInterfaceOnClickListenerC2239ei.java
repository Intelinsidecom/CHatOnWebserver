package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.ei */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2239ei implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2237eg f8534a;

    DialogInterfaceOnClickListenerC2239ei(HandlerC2237eg handlerC2237eg) {
        this.f8534a = handlerC2237eg;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8534a.f8532a.getActivity() != null) {
            this.f8534a.f8532a.f8269I = ProgressDialogC3265l.m11490a(this.f8534a.f8532a.getActivity(), null, this.f8534a.f8532a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        }
        new C1324bj(this.f8534a.f8532a.f8295i).m5694b();
    }
}
