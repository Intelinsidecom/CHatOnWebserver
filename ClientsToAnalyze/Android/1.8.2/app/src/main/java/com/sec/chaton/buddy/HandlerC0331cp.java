package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.widget.C2153y;

/* compiled from: BuddyProfileEditNameActivity.java */
/* renamed from: com.sec.chaton.buddy.cp */
/* loaded from: classes.dex */
class HandlerC0331cp extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileEditNameActivity f1473a;

    HandlerC0331cp(BuddyProfileEditNameActivity buddyProfileEditNameActivity) {
        this.f1473a = buddyProfileEditNameActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f1473a.f1079i != null) {
            C0101b c0101b = (C0101b) message.obj;
            if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                C2153y.m7535a(this.f1473a.f1079i, R.string.toast_network_unable, 0).show();
                if (this.f1473a.f1085o != null && this.f1473a.f1085o.isShowing()) {
                    this.f1473a.f1085o.dismiss();
                    this.f1473a.f1085o = null;
                    return;
                }
                return;
            }
            C2153y.m7535a(this.f1473a.f1079i, R.string.buddy_profile_saveprofile_toast_success, 0).show();
            if (this.f1473a.f1085o != null && this.f1473a.f1085o.isShowing()) {
                this.f1473a.f1085o.dismiss();
                this.f1473a.f1085o = null;
            }
        }
    }
}
