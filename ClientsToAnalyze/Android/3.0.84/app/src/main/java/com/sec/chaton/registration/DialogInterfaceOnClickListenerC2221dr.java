package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC3265l;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dr */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2221dr implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2217dn f8515a;

    DialogInterfaceOnClickListenerC2221dr(HandlerC2217dn handlerC2217dn) {
        this.f8515a = handlerC2217dn;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8515a.f8511a.f8270J = ProgressDialogC3265l.m11490a(this.f8515a.f8511a.getActivity(), null, this.f8515a.f8511a.getResources().getString(R.string.download_progressing), true);
        this.f8515a.f8511a.f8274N.m5721a(RtspHeaders.Values.APPEND);
    }
}
