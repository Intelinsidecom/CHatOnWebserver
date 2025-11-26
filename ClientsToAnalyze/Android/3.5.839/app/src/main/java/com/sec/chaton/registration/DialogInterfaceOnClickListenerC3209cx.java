package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cx */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3209cx implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3204cs f11973a;

    DialogInterfaceOnClickListenerC3209cx(HandlerC3204cs handlerC3204cs) {
        this.f11973a = handlerC3204cs;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f11973a.f11968a.getActivity() != null) {
            this.f11973a.f11968a.f11692n = ProgressDialogC4926s.m18728a(this.f11973a.f11968a.getActivity(), null, this.f11973a.f11968a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        }
        new C2122ca(this.f11973a.f11968a.f11683e).m9471b();
    }
}
