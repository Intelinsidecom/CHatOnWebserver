package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.widget.C5179v;

/* compiled from: BuddyProfileEditNameActivity.java */
/* renamed from: com.sec.chaton.buddy.fq */
/* loaded from: classes.dex */
class HandlerC1310fq extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileEditNameActivity f4846a;

    HandlerC1310fq(BuddyProfileEditNameActivity buddyProfileEditNameActivity) {
        this.f4846a = buddyProfileEditNameActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f4846a.f3898s != null) {
            C0778b c0778b = (C0778b) message.obj;
            if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                C5179v.m19810a(this.f4846a.f3898s, R.string.toast_network_unable, 0).show();
                if (this.f4846a.f3905z != null && this.f4846a.f3905z.isShowing()) {
                    this.f4846a.f3905z.dismiss();
                    this.f4846a.f3905z = null;
                    return;
                }
                return;
            }
            C5179v.m19810a(this.f4846a.f3898s, R.string.buddy_profile_saveprofile_toast_success, 0).show();
            if (this.f4846a.f3905z != null && this.f4846a.f3905z.isShowing()) {
                this.f4846a.f3905z.dismiss();
                this.f4846a.f3905z = null;
            }
        }
    }
}
