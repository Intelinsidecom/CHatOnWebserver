package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2248i;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cs */
/* loaded from: classes.dex */
class HandlerC1182cs extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4410a;

    HandlerC1182cs(BuddyFragment buddyFragment) {
        this.f4410a = buddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f4410a.getActivity() != null) {
            C0778b c0778b = (C0778b) message.obj;
            if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                if (this.f4410a.m6605h() > 0) {
                    C4904y.m18639b("NEW GROUP NAME : " + this.f4410a.f3657al.getString("ACTIVITY_PURPOSE_ARG2"), BuddyFragment.f3576a);
                    C4904y.m18639b("MEMBER COUNT  : " + this.f4410a.m6605h(), BuddyFragment.f3576a);
                    this.f4410a.m6539i(this.f4410a.f3657al.getString("ACTIVITY_PURPOSE_ARG2"));
                    C2212z.m10068a(new C2212z(), 2, new C2248i(this.f4410a.f3772y, this.f4410a.f3657al.getString("ACTIVITY_PURPOSE_ARG2"), this.f4410a.m6604g(), 2));
                }
                this.f4410a.getActivity().finish();
            } else {
                C5179v.m19811a(this.f4410a.getActivity(), c0778b.m3107b().toString(), 0).show();
                AbstractC4932a.m18733a(this.f4410a.getActivity()).mo18740a(this.f4410a.getResources().getString(R.string.ams_attention_title)).mo18749b(this.f4410a.getResources().getString(R.string.setting_profile_update_status_failed)).mo18755c(this.f4410a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1183ct(this)).mo18741a(this.f4410a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
            }
            if (this.f4410a.f3625aF != null && this.f4410a.f3625aF.isShowing()) {
                this.f4410a.f3625aF.dismiss();
            }
        }
    }
}
