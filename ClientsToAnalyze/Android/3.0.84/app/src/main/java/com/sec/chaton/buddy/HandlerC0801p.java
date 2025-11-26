package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.GetBuddyList;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.p */
/* loaded from: classes.dex */
class HandlerC0801p extends Handler {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f3096a;

    HandlerC0801p(AddBuddyFragment addBuddyFragment) {
        this.f3096a = addBuddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0267d c0267d = (C0267d) message.obj;
        if ((message.what == 303 || message.what == 307) && this.f3096a.f1676X != null) {
            boolean z = message.what == 307;
            this.f3096a.f1701v.dismiss();
            if (!c0267d.m11704n()) {
                AbstractC3271a.m11494a(this.f3096a.f1676X).mo11500a(this.f3096a.getResources().getString(R.string.pop_up_attention)).mo11509b(this.f3096a.getResources().getString(R.string.toast_network_unable)).mo11510b(this.f3096a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0804s(this, z)).mo11501a(this.f3096a.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0803r(this)).mo11512b();
                return;
            }
            if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                this.f3096a.m3197a();
                if (message.what == 303) {
                    GetBuddyList getBuddyList = (GetBuddyList) c0267d.m1354e();
                    if (getBuddyList != null) {
                        this.f3096a.f1672T = getBuddyList.buddy.get(0).name;
                    }
                    C3641ai.m13211a(this.f3096a.f1676X, this.f3096a.getResources().getString(R.string.add_buddy_added, this.f3096a.f1672T), 0).show();
                    this.f3096a.f1676X.setResult(-1);
                    return;
                }
                if (message.what == 307) {
                    this.f3096a.m3173a((GetBuddyList) c0267d.m1354e());
                    return;
                }
                return;
            }
            if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                AbstractC3271a.m11494a(this.f3096a.f1676X).mo11500a(this.f3096a.getResources().getString(R.string.pop_up_attention)).mo11509b(String.format(this.f3096a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f3096a.f1677Y)).mo11510b(this.f3096a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0802q(this)).mo11512b();
                return;
            }
            C3250y.m11458g("ADD BUDDY RESULT : " + c0267d.m1355f(), null);
            if (c0267d.m1355f() == 16003) {
                string = this.f3096a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
            } else if (c0267d.m1355f() == 16004) {
                string = this.f3096a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
            } else if (c0267d.m1355f() == 16005) {
                string = this.f3096a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
            } else if (c0267d.m1355f() == 16010) {
                string = this.f3096a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invalid_phonenumber);
            } else if (c0267d.m1355f() == 16011) {
                string = this.f3096a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invalid_email);
            } else if (c0267d.m1355f() == 16012) {
                string = this.f3096a.getResources().getString(R.string.add_buddy_phone_number_hide_errorcase);
            } else if (c0267d.m1355f() == 16013) {
                string = this.f3096a.getResources().getString(R.string.add_buddy_samsung_account_hide_errorcase);
            } else {
                string = this.f3096a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
            }
            AbstractC3271a.m11494a(this.f3096a.f1676X).mo11500a(this.f3096a.getResources().getString(R.string.pop_up_attention)).mo11509b(string).mo11510b(this.f3096a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo11512b();
        }
    }
}
