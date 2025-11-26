package com.sec.chaton.calllog.view;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.f */
/* loaded from: classes.dex */
class HandlerC1475f extends Handler {

    /* renamed from: a */
    final /* synthetic */ CallLogDetailFragment f5358a;

    HandlerC1475f(CallLogDetailFragment callLogDetailFragment) {
        this.f5358a = callLogDetailFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0778b c0778b = (C0778b) message.obj;
        if (this.f5358a.m7697o() != null) {
            this.f5358a.m7703u();
            if (!c0778b.m18954n()) {
                AbstractC4932a.m18733a(this.f5358a.m7697o()).mo18740a(this.f5358a.getResources().getString(R.string.buddy_add_contact)).mo18749b(this.f5358a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).mo18755c(this.f5358a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1476g(this)).mo18741a(this.f5358a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
                return;
            }
            if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                if (TextUtils.isEmpty(this.f5358a.f5212M)) {
                    this.f5358a.m7666a((CharSequence) this.f5358a.getResources().getString(R.string.tellfriends_added));
                    return;
                }
                this.f5358a.m7666a((CharSequence) this.f5358a.getResources().getString(R.string.add_buddy_added, this.f5358a.f5212M));
                this.f5358a.f5212M = "";
                this.f5358a.m7693k();
                ((InterfaceC1479j) this.f5358a.getActivity()).mo7657h();
                return;
            }
            if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                AbstractC4932a.m18733a(this.f5358a.m7697o()).mo18740a(String.format(this.f5358a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f5358a.f5211L.m7046a())).mo18755c(this.f5358a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo18752b();
                return;
            }
            C4904y.m18639b("ADD BUDDY RESULT : " + c0778b.m3111f(), "CallLogDetailActivity");
            if (c0778b.m3111f() == 16003) {
                string = this.f5358a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
            } else if (c0778b.m3111f() == 16004) {
                string = this.f5358a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
            } else if (c0778b.m3111f() == 16005) {
                string = this.f5358a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
            } else {
                string = this.f5358a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
            }
            AbstractC4932a.m18733a(this.f5358a.m7697o()).mo18740a(string).mo18755c(this.f5358a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo18752b();
        }
    }
}
