package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.et */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3259et implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3257er f12026a;

    DialogInterfaceOnClickListenerC3259et(HandlerC3257er handlerC3257er) {
        this.f12026a = handlerC3257er;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f12026a.f12024a.getActivity() != null) {
            this.f12026a.f12024a.f11729R = ProgressDialogC4926s.m18728a(this.f12026a.f12024a.getActivity(), null, this.f12026a.f12024a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        }
        new C2122ca(this.f12026a.f12024a.f11775o).m9471b();
    }
}
