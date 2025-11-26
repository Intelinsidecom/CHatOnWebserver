package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.eo */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3254eo implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3252em f12021a;

    DialogInterfaceOnClickListenerC3254eo(HandlerC3252em handlerC3252em) {
        this.f12021a = handlerC3252em;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f12021a.f12019a.getActivity() != null) {
            this.f12021a.f12019a.f11729R = ProgressDialogC4926s.m18728a(this.f12021a.f12019a.getActivity(), null, this.f12021a.f12019a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        }
        this.f12021a.f12019a.f11735X.m9359b(this.f12021a.f12019a.f11768h, this.f12021a.f12019a.f11759ar.getText().toString(), this.f12021a.f12019a.f11757ap);
    }
}
