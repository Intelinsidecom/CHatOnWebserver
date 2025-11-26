package com.sec.chaton.registration;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.util.C1786r;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: ActivityRegist.java */
/* renamed from: com.sec.chaton.registration.ai */
/* loaded from: classes.dex */
class HandlerC1155ai extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegistFragment f4357a;

    HandlerC1155ai(ActivityRegist.RegistFragment registFragment) {
        this.f4357a = registFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0101b c0101b = (C0101b) message.obj;
        if (message.what == 303 && this.f4357a.getActivity() != null) {
            this.f4357a.m4381d();
            if (this.f4357a.getActivity() != null) {
                this.f4357a.f4256z.dismiss();
            }
            if (c0101b.m664a()) {
                if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                    this.f4357a.getActivity().setResult(-1);
                    this.f4357a.getActivity().finish();
                    return;
                }
                if (c0101b.m665b() == EnumC0803m.NO_CONTENT) {
                    new AlertDialogBuilderC2120a(this.f4357a.f4215A).setTitle(this.f4357a.getResources().getString(R.string.pop_up_attention)).setMessage(String.format(this.f4357a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f4357a.f4230P)).setPositiveButton(this.f4357a.getResources().getString(R.string.done), (DialogInterface.OnClickListener) null).show();
                    return;
                }
                C1786r.m6067f("ADD BUDDY RESULT : " + c0101b.m673f(), null);
                if (c0101b.m673f() == 16003) {
                    if (!GlobalApplication.m3265f()) {
                        string = this.f4357a.f4230P + " " + this.f4357a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                    } else {
                        string = this.f4357a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                    }
                } else if (c0101b.m673f() == 16004) {
                    string = this.f4357a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                } else if (c0101b.m673f() == 16005) {
                    string = this.f4357a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                } else {
                    string = this.f4357a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                }
                new AlertDialogBuilderC2120a(this.f4357a.f4215A).setTitle(this.f4357a.getResources().getString(R.string.pop_up_attention)).setMessage(string).setPositiveButton(this.f4357a.getResources().getString(R.string.done), (DialogInterface.OnClickListener) null).show();
                return;
            }
            new AlertDialogBuilderC2120a(this.f4357a.f4215A).setTitle(this.f4357a.getResources().getString(R.string.buddy_list_dialog_addbuddy_title)).setMessage(this.f4357a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).setNegativeButton(this.f4357a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1156aj(this)).setPositiveButton(this.f4357a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
        }
    }
}
