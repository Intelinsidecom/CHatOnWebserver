package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC3265l;
import java.io.UnsupportedEncodingException;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2219dp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2217dn f8513a;

    DialogInterfaceOnClickListenerC2219dp(HandlerC2217dn handlerC2217dn) {
        this.f8513a = handlerC2217dn;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws UnsupportedEncodingException {
        this.f8513a.f8511a.f8270J = ProgressDialogC3265l.m11490a(this.f8513a.f8511a.getActivity(), null, this.f8513a.f8511a.getResources().getString(R.string.download_progressing), true);
        this.f8513a.f8511a.f8274N.m5717a();
    }
}
