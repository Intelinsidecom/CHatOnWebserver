package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetBuddyList;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.o */
/* loaded from: classes.dex */
class HandlerC1409o extends Handler {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f5043a;

    HandlerC1409o(AddBuddyFragment addBuddyFragment) {
        this.f5043a = addBuddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0778b c0778b = (C0778b) message.obj;
        if ((message.what == 303 || message.what == 307) && this.f5043a.f3528V != null) {
            boolean z = message.what == 307;
            this.f5043a.f3550u.dismiss();
            if (!c0778b.m18954n()) {
                AbstractC4932a.m18733a(this.f5043a.f3528V).mo18740a(this.f5043a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f5043a.getResources().getString(R.string.toast_network_unable)).mo18755c(this.f5043a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1414t(this, z)).mo18741a(this.f5043a.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1413s(this)).mo18752b();
                return;
            }
            if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                this.f5043a.m6267a();
                if (message.what == 303) {
                    GetBuddyList getBuddyList = (GetBuddyList) c0778b.m3110e();
                    if (getBuddyList != null) {
                        this.f5043a.f3524R = getBuddyList.buddy.get(0).name;
                    }
                    C5179v.m19811a(this.f5043a.f3528V, this.f5043a.getResources().getString(R.string.add_buddy_added, this.f5043a.f3524R), 0).show();
                    this.f5043a.f3528V.setResult(-1);
                    return;
                }
                if (message.what == 307) {
                    this.f5043a.m6241a((GetBuddyList) c0778b.m3110e());
                    return;
                }
                return;
            }
            if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                AbstractC4932a.m18733a(this.f5043a.f3528V).mo18740a(this.f5043a.getResources().getString(R.string.pop_up_attention)).mo18749b(String.format(this.f5043a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f5043a.f3529W)).mo18755c(this.f5043a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1410p(this)).mo18752b();
                return;
            }
            C4904y.m18639b("ADD BUDDY RESULT : " + c0778b.m3111f(), null);
            if (c0778b.m3111f() == 16003) {
                string = this.f5043a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
            } else if (c0778b.m3111f() == 16004 || c0778b.m3111f() == 16005 || c0778b.m3111f() == 16014) {
                string = this.f5043a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
            } else if (c0778b.m3111f() == 16010) {
                string = this.f5043a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invalid_phonenumber);
            } else if (c0778b.m3111f() == 16011) {
                string = this.f5043a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invalid_email);
            } else if (c0778b.m3111f() == 16012) {
                string = this.f5043a.getResources().getString(R.string.add_buddy_phone_number_hide_errorcase);
            } else if (c0778b.m3111f() == 16013) {
                string = this.f5043a.getResources().getString(R.string.add_buddy_samsung_account_hide_errorcase);
            } else {
                string = this.f5043a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
            }
            if (!z || c0778b.m3111f() != 0) {
                AbstractC4932a.m18733a(this.f5043a.f3528V).mo18740a(this.f5043a.getResources().getString(R.string.pop_up_attention)).mo18749b(string).mo18755c(this.f5043a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo18752b();
            } else {
                AbstractC4932a.m18733a(this.f5043a.f3528V).mo18740a(this.f5043a.getResources().getString(R.string.pop_up_attention)).mo18749b(this.f5043a.getResources().getString(R.string.toast_network_unable)).mo18755c(this.f5043a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1412r(this, z)).mo18741a(this.f5043a.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1411q(this)).mo18752b();
            }
        }
    }
}
