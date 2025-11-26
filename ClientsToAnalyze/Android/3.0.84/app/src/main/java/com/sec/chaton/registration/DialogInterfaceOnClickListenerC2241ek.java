package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.widget.ProgressDialogC3265l;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.ek */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2241ek implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f8536a;

    DialogInterfaceOnClickListenerC2241ek(FragmentRegist fragmentRegist) {
        this.f8536a = fragmentRegist;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!C1493a.m6463a("for_wifi_only_device")) {
            C3159aa.m10963a("contact_sim_sync", Boolean.valueOf(this.f8536a.f8273M));
        }
        this.f8536a.f8270J = ProgressDialogC3265l.m11490a(this.f8536a.getActivity(), null, this.f8536a.getResources().getString(R.string.download_progressing), true);
        this.f8536a.f8274N.m5721a(RtspHeaders.Values.APPEND);
    }
}
