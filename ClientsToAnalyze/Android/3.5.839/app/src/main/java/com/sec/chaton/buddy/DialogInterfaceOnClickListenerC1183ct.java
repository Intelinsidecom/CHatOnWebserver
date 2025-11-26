package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ct */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1183ct implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1182cs f4411a;

    DialogInterfaceOnClickListenerC1183ct(HandlerC1182cs handlerC1182cs) {
        this.f4411a = handlerC1182cs;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4411a.f4410a.getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        new C2128i(this.f4411a.f4410a.f3757cu).m9489a("group", false, (String) null, this.f4411a.f4410a.f3657al.getString("ACTIVITY_PURPOSE_ARG2"), this.f4411a.f4410a.m6604g(), 325);
        if (this.f4411a.f4410a.f3625aF != null) {
            this.f4411a.f4410a.f3625aF.show();
        } else {
            this.f4411a.f4410a.f3625aF = ProgressDialogC4926s.m18728a(this.f4411a.f4410a.getActivity(), null, this.f4411a.f4410a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        }
    }
}
