package com.sec.chaton.calllog.view;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* compiled from: ShowConferenceMemberListFragment.java */
/* renamed from: com.sec.chaton.calllog.view.ae */
/* loaded from: classes.dex */
class HandlerC1463ae extends Handler {

    /* renamed from: a */
    final /* synthetic */ ShowConferenceMemberListFragment f5335a;

    HandlerC1463ae(ShowConferenceMemberListFragment showConferenceMemberListFragment) {
        this.f5335a = showConferenceMemberListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0778b c0778b = (C0778b) message.obj;
        if (this.f5335a.m7764a() != null) {
            switch (message.what) {
                case 303:
                    this.f5335a.m7776d();
                    if (c0778b.m18954n()) {
                        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                            this.f5335a.m7767a(this.f5335a.getResources().getString(R.string.tellfriends_added));
                            this.f5335a.m7780e();
                            this.f5335a.m7785h();
                            break;
                        } else if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                            AbstractC4932a.m18733a(this.f5335a.m7764a()).mo18740a(String.format(this.f5335a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f5335a.f5304i.m7046a())).mo18755c(this.f5335a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo18752b();
                            break;
                        } else {
                            C4904y.m18639b("ADD BUDDY RESULT : " + c0778b.m3111f(), "ShowConferenceMemberList");
                            if (c0778b.m3111f() == 16003) {
                                string = this.f5335a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                            } else if (c0778b.m3111f() == 16004) {
                                string = this.f5335a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                            } else if (c0778b.m3111f() == 16005) {
                                string = this.f5335a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                            } else {
                                string = this.f5335a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                            }
                            AbstractC4932a.m18733a(this.f5335a.m7764a()).mo18740a(string).mo18755c(this.f5335a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo18752b();
                            break;
                        }
                    } else {
                        C5179v.m19810a(GlobalApplication.m18732r(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
                        break;
                    }
                case 311:
                    this.f5335a.m7776d();
                    if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                        C5179v.m19810a(GlobalApplication.m18732r(), R.string.tellfriends_added, 0).show();
                        this.f5335a.m7780e();
                        this.f5335a.m7785h();
                        break;
                    } else {
                        C5179v.m19810a(GlobalApplication.m18732r(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
                        break;
                    }
            }
        }
    }
}
