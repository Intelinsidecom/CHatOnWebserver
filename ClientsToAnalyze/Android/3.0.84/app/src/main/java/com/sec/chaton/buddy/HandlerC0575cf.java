package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1418i;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cf */
/* loaded from: classes.dex */
class HandlerC0575cf extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2537a;

    HandlerC0575cf(BuddyFragment buddyFragment) {
        this.f2537a = buddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f2537a.getActivity() != null) {
            C0267d c0267d = (C0267d) message.obj;
            if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                this.f2537a.m3264Z();
                C3641ai.m13211a(this.f2537a.getActivity(), c0267d.m1351b().toString(), 0).show();
                AbstractC3271a.m11494a(this.f2537a.getActivity()).mo11500a(this.f2537a.getResources().getString(R.string.ams_attention_title)).mo11509b(this.f2537a.getResources().getString(R.string.setting_profile_update_status_failed)).mo11510b(this.f2537a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0576cg(this)).mo11501a(this.f2537a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                return;
            }
            if (this.f2537a.m3444i() > 0) {
                C3250y.m11458g("NEW GROUP NAME : " + this.f2537a.f1762Z.getString("ACTIVITY_PURPOSE_ARG2"), BuddyFragment.f1724a);
                C3250y.m11458g("MEMBER COUNT  : " + this.f2537a.m3444i(), BuddyFragment.f1724a);
                C1379w.m6203a(new C1379w(), 2, new C1418i(this.f2537a.f1889t, this.f2537a.f1762Z.getString("ACTIVITY_PURPOSE_ARG2"), this.f2537a.m3443h(), 2));
            }
            this.f2537a.m3264Z();
            this.f2537a.getActivity().finish();
        }
    }
}
