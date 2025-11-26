package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: EditChatTitleDialog.java */
/* renamed from: com.sec.chaton.chat.gu */
/* loaded from: classes.dex */
class HandlerC1748gu extends Handler {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1747gt f6576a;

    HandlerC1748gu(AlertDialogC1747gt alertDialogC1747gt) {
        this.f6576a = alertDialogC1747gt;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (GlobalApplication.m10279a().getApplicationContext() != null) {
            switch (message.what) {
                case 806:
                    C0778b c0778b = (C0778b) message.obj;
                    if (this.f6576a.f6565b.isShowing()) {
                        this.f6576a.f6565b.dismiss();
                    }
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        this.f6576a.m8693b();
                        this.f6576a.dismiss();
                        break;
                    } else if (c0778b.m3111f() == 12006) {
                        AbstractC4932a.m18733a(this.f6576a.f6570g).mo18734a(R.string.ams_attention_title).mo18749b(CommonApplication.m18732r().getString(R.string.buddy_group_list_addgroup_toast_exist, this.f6576a.f6571h)).mo18751b(true).mo18756d(R.string.dialog_ok, null).mo18752b();
                        break;
                    } else {
                        AbstractC4932a.m18733a(this.f6576a.f6570g).mo18734a(R.string.ams_attention_title).mo18746b(R.string.toast_setting_profile_update_failed).mo18751b(true).mo18756d(R.string.dialog_ok, null).mo18752b();
                        break;
                    }
                    break;
            }
        }
    }
}
