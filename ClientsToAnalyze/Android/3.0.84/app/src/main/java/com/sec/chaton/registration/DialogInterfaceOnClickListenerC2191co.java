package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC3265l;
import java.io.UnsupportedEncodingException;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.co */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2191co implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2189cm f8483a;

    DialogInterfaceOnClickListenerC2191co(HandlerC2189cm handlerC2189cm) {
        this.f8483a = handlerC2189cm;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws UnsupportedEncodingException {
        this.f8483a.f8481a.f8246n = ProgressDialogC3265l.m11490a(this.f8483a.f8481a.getActivity(), null, this.f8483a.f8481a.getResources().getString(R.string.download_progressing), true);
        this.f8483a.f8481a.f8223D.m5717a();
    }
}
