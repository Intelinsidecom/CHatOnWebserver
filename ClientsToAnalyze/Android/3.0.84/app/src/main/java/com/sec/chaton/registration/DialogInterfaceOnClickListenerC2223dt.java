package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC3265l;
import java.io.UnsupportedEncodingException;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dt */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2223dt implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2222ds f8517a;

    DialogInterfaceOnClickListenerC2223dt(HandlerC2222ds handlerC2222ds) {
        this.f8517a = handlerC2222ds;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws UnsupportedEncodingException {
        if (this.f8517a.f8516a.f8271K != null) {
            this.f8517a.f8516a.f8269I = ProgressDialogC3265l.m11490a(this.f8517a.f8516a.f8271K, null, this.f8517a.f8516a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        }
        this.f8517a.f8516a.m8584d();
    }
}
