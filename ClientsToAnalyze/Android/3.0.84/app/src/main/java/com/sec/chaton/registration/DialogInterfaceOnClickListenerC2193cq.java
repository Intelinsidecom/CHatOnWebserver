package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC3265l;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2193cq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2189cm f8485a;

    DialogInterfaceOnClickListenerC2193cq(HandlerC2189cm handlerC2189cm) {
        this.f8485a = handlerC2189cm;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8485a.f8481a.f8246n = ProgressDialogC3265l.m11490a(this.f8485a.f8481a.getActivity(), null, this.f8485a.f8481a.getResources().getString(R.string.download_progressing), true);
        this.f8485a.f8481a.f8223D.m5721a(RtspHeaders.Values.APPEND);
    }
}
