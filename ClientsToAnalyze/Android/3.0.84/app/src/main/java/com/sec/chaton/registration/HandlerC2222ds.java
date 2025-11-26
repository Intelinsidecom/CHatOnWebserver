package com.sec.chaton.registration;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.ds */
/* loaded from: classes.dex */
class HandlerC2222ds extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f8516a;

    HandlerC2222ds(FragmentRegist fragmentRegist) {
        this.f8516a = fragmentRegist;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0267d c0267d = (C0267d) message.obj;
        if (message.what == 303 && this.f8516a.getActivity() != null) {
            this.f8516a.m8592h();
            if (this.f8516a.getActivity() != null && this.f8516a.f8269I != null && this.f8516a.f8269I.isShowing()) {
                this.f8516a.f8269I.dismiss();
            }
            if (c0267d.m11704n()) {
                if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    this.f8516a.getActivity().setResult(-1);
                    this.f8516a.getActivity().finish();
                    return;
                }
                if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                    this.f8516a.f8276P = AbstractC3271a.m11494a(this.f8516a.f8271K).mo11500a(String.format(this.f8516a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f8516a.f8288ab)).mo11510b(this.f8516a.getResources().getString(R.string.done), (DialogInterface.OnClickListener) null).mo11505a();
                    if (this.f8516a.getActivity() != null) {
                        this.f8516a.f8276P.show();
                        return;
                    }
                    return;
                }
                C3250y.m11458g("ADD BUDDY RESULT : " + c0267d.m1355f(), null);
                if (c0267d.m1355f() == 16003) {
                    string = this.f8516a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                } else if (c0267d.m1355f() == 16004) {
                    string = this.f8516a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                } else if (c0267d.m1355f() == 16005) {
                    string = this.f8516a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                } else {
                    string = this.f8516a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                }
                this.f8516a.f8276P = AbstractC3271a.m11494a(this.f8516a.f8271K).mo11500a(string).mo11510b(this.f8516a.getResources().getString(R.string.done), (DialogInterface.OnClickListener) null).mo11505a();
                if (this.f8516a.getActivity() != null) {
                    this.f8516a.f8276P.show();
                    return;
                }
                return;
            }
            this.f8516a.f8276P = AbstractC3271a.m11494a(this.f8516a.f8271K).mo11500a(this.f8516a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).mo11509b(C3171am.m11046a(this.f8516a.getResources().getString(R.string.toast_network_unable), this.f8516a.getResources().getString(R.string.toast_error), c0267d.m1356g())).mo11510b(this.f8516a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC2223dt(this)).mo11501a(this.f8516a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11505a();
            if (this.f8516a.getActivity() != null) {
                this.f8516a.f8276P.show();
            }
        }
    }
}
