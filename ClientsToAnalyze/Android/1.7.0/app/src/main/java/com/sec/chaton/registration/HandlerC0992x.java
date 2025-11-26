package com.sec.chaton.registration;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.util.C1341p;
import com.sec.widget.AlertDialogBuilderC1625m;

/* compiled from: ActivityRegist.java */
/* renamed from: com.sec.chaton.registration.x */
/* loaded from: classes.dex */
class HandlerC0992x extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegistFragment f3388a;

    HandlerC0992x(ActivityRegist.RegistFragment registFragment) {
        this.f3388a = registFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0259g c0259g = (C0259g) message.obj;
        if (message.what == 303 && this.f3388a.getActivity() != null) {
            this.f3388a.m3697d();
            if (this.f3388a.getActivity() != null) {
                this.f3388a.f3230y.dismiss();
            }
            if (c0259g.m927a()) {
                if (c0259g.m928b() == EnumC0518y.SUCCESS) {
                    this.f3388a.getActivity().setResult(-1);
                    this.f3388a.getActivity().finish();
                    return;
                }
                if (c0259g.m928b() == EnumC0518y.NO_CONTENT) {
                    new AlertDialogBuilderC1625m(this.f3388a.f3231z).setTitle(String.format(this.f3388a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f3388a.f3205O)).setPositiveButton(this.f3388a.getResources().getString(R.string.done), (DialogInterface.OnClickListener) null).show();
                    return;
                }
                C1341p.m4663f("ADD BUDDY RESULT : " + c0259g.m934f(), null);
                if (c0259g.m934f() == 16003) {
                    string = this.f3388a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                } else if (c0259g.m934f() == 16004) {
                    string = this.f3388a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                } else if (c0259g.m934f() == 16005) {
                    string = this.f3388a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                } else {
                    string = this.f3388a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                }
                new AlertDialogBuilderC1625m(this.f3388a.f3231z).setTitle(string).setPositiveButton(this.f3388a.getResources().getString(R.string.done), (DialogInterface.OnClickListener) null).show();
                return;
            }
            new AlertDialogBuilderC1625m(this.f3388a.f3231z).setTitle(this.f3388a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).setPositiveButton(this.f3388a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0976h(this)).setNegativeButton(this.f3388a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
        }
    }
}
