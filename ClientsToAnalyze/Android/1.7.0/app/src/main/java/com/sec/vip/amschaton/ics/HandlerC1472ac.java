package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ac */
/* loaded from: classes.dex */
class HandlerC1472ac extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5280a;

    HandlerC1472ac(AMSComposerActivity aMSComposerActivity) {
        this.f5280a = aMSComposerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        if (message.what == 3000) {
            switch (this.f5280a.f5180A.m4783b(this.f5280a.f5195P)) {
                case 1:
                    this.f5280a.m4738a(R.string.ams_msg_minor_version_changed);
                    break;
                case 2:
                    this.f5280a.m4738a(R.string.ams_msg_major_version_changed);
                    break;
                case 3:
                    this.f5280a.m4738a(R.string.ams_msg_invalid_ams_file);
                    C1341p.m4651a("Load Error", getClass().getSimpleName());
                    break;
                default:
                    if (!this.f5280a.f5180A.m4805s()) {
                        this.f5280a.m4738a(R.string.ams_msg_edit_protection);
                        break;
                    } else {
                        this.f5280a.f5180A.m4793g();
                        this.f5280a.m5337F();
                        this.f5280a.m5405l();
                        this.f5280a.m5409m();
                        this.f5280a.f5196Q = true;
                        break;
                    }
            }
            return;
        }
        if (message.what == 3001) {
            this.f5280a.m5384g(this.f5280a.f5181B);
        }
    }
}
