package com.sec.chaton.registration;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.du */
/* loaded from: classes.dex */
class HandlerC3233du extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f11999a;

    HandlerC3233du(FragmentRegist fragmentRegist) {
        this.f11999a = fragmentRegist;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0778b c0778b = (C0778b) message.obj;
        if (message.what == 303 && this.f11999a.getActivity() != null) {
            this.f11999a.m12934h();
            if (this.f11999a.getActivity() != null && this.f11999a.f11729R != null && this.f11999a.f11729R.isShowing()) {
                this.f11999a.f11729R.dismiss();
            }
            if (c0778b.m18954n()) {
                if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    this.f11999a.getActivity().setResult(-1);
                    this.f11999a.getActivity().finish();
                    return;
                }
                if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                    this.f11999a.f11743ab = AbstractC4932a.m18733a(this.f11999a.f11731T).mo18740a(String.format(this.f11999a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f11999a.f11740aC)).mo18755c(this.f11999a.getResources().getString(R.string.done), (DialogInterface.OnClickListener) null).mo18745a();
                    if (this.f11999a.getActivity() != null) {
                        this.f11999a.f11743ab.show();
                        return;
                    }
                    return;
                }
                C4904y.m18639b("ADD BUDDY RESULT : " + c0778b.m3111f(), null);
                if (c0778b.m3111f() == 16003) {
                    string = this.f11999a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                } else if (c0778b.m3111f() == 16004) {
                    string = this.f11999a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                } else if (c0778b.m3111f() == 16005) {
                    string = this.f11999a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                } else {
                    string = this.f11999a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                }
                this.f11999a.f11743ab = AbstractC4932a.m18733a(this.f11999a.f11731T).mo18740a(string).mo18755c(this.f11999a.getResources().getString(R.string.done), (DialogInterface.OnClickListener) null).mo18745a();
                if (this.f11999a.getActivity() != null) {
                    this.f11999a.f11743ab.show();
                    return;
                }
                return;
            }
            String strM3112g = c0778b.m3112g();
            this.f11999a.f11743ab = C4859bx.m18375a(AbstractC4932a.m18733a(this.f11999a.f11731T).mo18740a(this.f11999a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).mo18749b(C4822an.m18209a(this.f11999a.getResources().getString(R.string.toast_network_unable), this.f11999a.getResources().getString(R.string.error_code_common), strM3112g)).mo18750b(this.f11999a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC3234dv(this)).mo18741a(this.f11999a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null), this.f11999a.getActivity(), strM3112g).mo18745a();
            if (this.f11999a.getActivity() != null) {
                this.f11999a.f11743ab.show();
            }
        }
    }
}
