package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.buddy.AddBuddyActivity;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.GetBuddyList;
import com.sec.chaton.util.C1341p;
import com.sec.widget.AlertDialogBuilderC1625m;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.bx */
/* loaded from: classes.dex */
class HandlerC0416bx extends Handler {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1391a;

    HandlerC0416bx(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1391a = addBuddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0259g c0259g = (C0259g) message.obj;
        if ((message.what == 303 || message.what == 307) && this.f1391a.getActivity() != null) {
            boolean z = message.what == 307;
            this.f1391a.f1074m.dismiss();
            if (c0259g.m927a()) {
                if (c0259g.m928b() == EnumC0518y.SUCCESS) {
                    this.f1391a.m2071b();
                    if (message.what == 303) {
                        this.f1391a.getActivity().setResult(-1);
                        this.f1391a.getActivity().finish();
                        return;
                    } else {
                        if (message.what == 307) {
                            this.f1391a.m2069a((GetBuddyList) c0259g.m932d());
                            return;
                        }
                        return;
                    }
                }
                if (c0259g.m928b() == EnumC0518y.NO_CONTENT) {
                    new AlertDialogBuilderC1625m(this.f1391a.getActivity()).setTitle(String.format(this.f1391a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f1391a.f1059B)).setPositiveButton(this.f1391a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0382aq(this)).show();
                    return;
                }
                C1341p.m4663f("ADD BUDDY RESULT : " + c0259g.m934f(), null);
                if (c0259g.m934f() == 16003) {
                    string = this.f1391a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                } else if (c0259g.m934f() == 16004) {
                    string = this.f1391a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                } else if (c0259g.m934f() == 16005) {
                    string = this.f1391a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                } else {
                    string = this.f1391a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                }
                new AlertDialogBuilderC1625m(this.f1391a.getActivity()).setTitle(string).setPositiveButton(this.f1391a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
                return;
            }
            new AlertDialogBuilderC1625m(this.f1391a.getActivity()).setTitle(this.f1391a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).setPositiveButton(this.f1391a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0380ao(this, z)).setNegativeButton(this.f1391a.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0381ap(this)).show();
        }
    }
}
