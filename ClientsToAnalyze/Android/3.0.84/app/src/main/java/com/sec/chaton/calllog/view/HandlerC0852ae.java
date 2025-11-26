package com.sec.chaton.calllog.view;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;

/* compiled from: ShowConferenceMemberListFragment.java */
/* renamed from: com.sec.chaton.calllog.view.ae */
/* loaded from: classes.dex */
class HandlerC0852ae extends Handler {

    /* renamed from: a */
    final /* synthetic */ ShowConferenceMemberListFragment f3362a;

    HandlerC0852ae(ShowConferenceMemberListFragment showConferenceMemberListFragment) {
        this.f3362a = showConferenceMemberListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0267d c0267d = (C0267d) message.obj;
        if (this.f3362a.m4608a() != null) {
            switch (message.what) {
                case 303:
                    this.f3362a.m4620d();
                    if (c0267d.m11704n()) {
                        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                            this.f3362a.m4611a(this.f3362a.getResources().getString(R.string.tellfriends_added));
                            this.f3362a.m4624e();
                            this.f3362a.m4629h();
                            break;
                        } else if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                            AbstractC3271a.m11494a(this.f3362a.m4608a()).mo11500a(String.format(this.f3362a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f3362a.f3331i.m3975b())).mo11510b(this.f3362a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo11512b();
                            break;
                        } else {
                            C3250y.m11458g("ADD BUDDY RESULT : " + c0267d.m1355f(), "ShowConferenceMemberList");
                            if (c0267d.m1355f() == 16003) {
                                string = this.f3362a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                            } else if (c0267d.m1355f() == 16004) {
                                string = this.f3362a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                            } else if (c0267d.m1355f() == 16005) {
                                string = this.f3362a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                            } else {
                                string = this.f3362a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                            }
                            AbstractC3271a.m11494a(this.f3362a.m4608a()).mo11500a(string).mo11510b(this.f3362a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo11512b();
                            break;
                        }
                    } else {
                        C3641ai.m13210a(GlobalApplication.m11493l(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
                        break;
                    }
                case 311:
                    this.f3362a.m4620d();
                    if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                        C3641ai.m13210a(GlobalApplication.m11493l(), R.string.tellfriends_added, 0).show();
                        this.f3362a.m4624e();
                        this.f3362a.m4629h();
                        break;
                    } else {
                        C3641ai.m13210a(GlobalApplication.m11493l(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
                        break;
                    }
            }
        }
    }
}
