package com.sec.chaton.calllog.view;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.f */
/* loaded from: classes.dex */
class HandlerC0864f extends Handler {

    /* renamed from: a */
    final /* synthetic */ CallLogDetailFragment f3385a;

    HandlerC0864f(CallLogDetailFragment callLogDetailFragment) {
        this.f3385a = callLogDetailFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0267d c0267d = (C0267d) message.obj;
        if (this.f3385a.m4542n() != null) {
            this.f3385a.m4548t();
            if (!c0267d.m11704n()) {
                AbstractC3271a.m11494a(this.f3385a.m4542n()).mo11500a(this.f3385a.getResources().getString(R.string.buddy_list_dialog_addbuddy_title)).mo11509b(this.f3385a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).mo11510b(this.f3385a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0865g(this)).mo11501a(this.f3385a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                return;
            }
            if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                if (TextUtils.isEmpty(this.f3385a.f3240M)) {
                    this.f3385a.m4512a((CharSequence) this.f3385a.getResources().getString(R.string.tellfriends_added));
                    return;
                }
                this.f3385a.m4512a((CharSequence) this.f3385a.getResources().getString(R.string.add_buddy_added, this.f3385a.f3240M));
                this.f3385a.f3240M = "";
                this.f3385a.m4538j();
                ((InterfaceC0868j) this.f3385a.getActivity()).mo4503c();
                return;
            }
            if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                AbstractC3271a.m11494a(this.f3385a.m4542n()).mo11500a(String.format(this.f3385a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f3385a.f3239L.m3975b())).mo11510b(this.f3385a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo11512b();
                return;
            }
            C3250y.m11458g("ADD BUDDY RESULT : " + c0267d.m1355f(), "CallLogDetailActivity");
            if (c0267d.m1355f() == 16003) {
                string = this.f3385a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
            } else if (c0267d.m1355f() == 16004) {
                string = this.f3385a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
            } else if (c0267d.m1355f() == 16005) {
                string = this.f3385a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
            } else {
                string = this.f3385a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
            }
            AbstractC3271a.m11494a(this.f3385a.m4542n()).mo11500a(string).mo11510b(this.f3385a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo11512b();
        }
    }
}
