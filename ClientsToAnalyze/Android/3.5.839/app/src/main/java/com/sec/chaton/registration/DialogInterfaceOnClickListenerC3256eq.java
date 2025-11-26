package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.eq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3256eq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3252em f12023a;

    DialogInterfaceOnClickListenerC3256eq(HandlerC3252em handlerC3252em) {
        this.f12023a = handlerC3252em;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12023a.f12019a.f11742aa.mo9077a(this.f12023a.f12019a.f11774n);
        this.f12023a.f12019a.f11774n.m18262a(30000);
        dialogInterface.dismiss();
        if (this.f12023a.f12019a.getActivity() != null) {
            this.f12023a.f12019a.f11729R = ProgressDialogC4926s.m18728a(this.f12023a.f12019a.getActivity(), null, this.f12023a.f12019a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        }
    }
}
