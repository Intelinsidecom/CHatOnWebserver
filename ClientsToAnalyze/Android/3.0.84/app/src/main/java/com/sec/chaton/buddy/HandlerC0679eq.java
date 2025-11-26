package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.widget.C3641ai;

/* compiled from: BuddyProfileEditNameActivity.java */
/* renamed from: com.sec.chaton.buddy.eq */
/* loaded from: classes.dex */
class HandlerC0679eq extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileEditNameActivity f2901a;

    HandlerC0679eq(BuddyProfileEditNameActivity buddyProfileEditNameActivity) {
        this.f2901a = buddyProfileEditNameActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f2901a.f2004f != null) {
            C0267d c0267d = (C0267d) message.obj;
            if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                C3641ai.m13210a(this.f2901a.f2004f, R.string.toast_network_unable, 0).show();
                if (this.f2901a.f2011m != null && this.f2901a.f2011m.isShowing()) {
                    this.f2901a.f2011m.dismiss();
                    this.f2901a.f2011m = null;
                    return;
                }
                return;
            }
            C3641ai.m13210a(this.f2901a.f2004f, R.string.buddy_profile_saveprofile_toast_success, 0).show();
            if (this.f2901a.f2011m != null && this.f2901a.f2011m.isShowing()) {
                this.f2901a.f2011m.dismiss();
                this.f2901a.f2011m = null;
            }
        }
    }
}
