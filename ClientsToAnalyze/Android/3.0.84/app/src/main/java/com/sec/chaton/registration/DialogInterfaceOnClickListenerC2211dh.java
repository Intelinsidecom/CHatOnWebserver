package com.sec.chaton.registration;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.R;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.widget.ProgressDialogC3265l;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.dh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2211dh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f8504a;

    DialogInterfaceOnClickListenerC2211dh(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f8504a = fragmentNonSelfSMS;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!C1493a.m6463a("for_wifi_only_device")) {
            C3159aa.m10963a("contact_sim_sync", Boolean.valueOf(this.f8504a.f8227H));
        }
        if (this.f8504a.f8231L) {
            this.f8504a.f8246n = ProgressDialogC3265l.m11490a(this.f8504a.getActivity(), null, this.f8504a.getResources().getString(R.string.download_progressing), true);
            this.f8504a.f8223D.m5721a(RtspHeaders.Values.APPEND);
        } else if (this.f8504a.getActivity() != null) {
            this.f8504a.getActivity().setResult(-1, new Intent());
            this.f8504a.getActivity().finish();
        }
    }
}
