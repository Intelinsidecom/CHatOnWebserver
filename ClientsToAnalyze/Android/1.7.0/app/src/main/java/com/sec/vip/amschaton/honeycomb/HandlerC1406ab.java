package com.sec.vip.amschaton.honeycomb;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ab */
/* loaded from: classes.dex */
class HandlerC1406ab extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5034a;

    HandlerC1406ab(AMSComposerActivity aMSComposerActivity) {
        this.f5034a = aMSComposerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        if (message.what == 3000) {
            switch (this.f5034a.f4936A.m4783b(this.f5034a.f4951P)) {
                case 1:
                    this.f5034a.m4738a(R.string.ams_msg_minor_version_changed);
                    break;
                case 2:
                    this.f5034a.m4738a(R.string.ams_msg_major_version_changed);
                    break;
                case 3:
                    this.f5034a.m4738a(R.string.ams_msg_invalid_ams_file);
                    C1341p.m4651a("Load Error", getClass().getSimpleName());
                    break;
                default:
                    if (!this.f5034a.f4936A.m4805s()) {
                        this.f5034a.m4738a(R.string.ams_msg_edit_protection);
                        break;
                    } else {
                        this.f5034a.f4936A.m4793g();
                        this.f5034a.m5034G();
                        this.f5034a.m5096l();
                        this.f5034a.m5098m();
                        this.f5034a.f4952Q = true;
                        break;
                    }
            }
            return;
        }
        if (message.what == 3001) {
            this.f5034a.m5076g(this.f5034a.f4937B);
        }
    }
}
