package com.sec.vip.amschaton.honeycomb;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.t */
/* loaded from: classes.dex */
class HandlerC1969t extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7116a;

    HandlerC1969t(AMSComposerActivity aMSComposerActivity) {
        this.f7116a = aMSComposerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        if (message.what == 3000) {
            switch (this.f7116a.f6914C.m6304b(this.f7116a.f6930S)) {
                case 1:
                    this.f7116a.m6262a(R.string.ams_msg_minor_version_changed);
                    break;
                case 2:
                    this.f7116a.m6262a(R.string.ams_msg_major_version_changed);
                    break;
                case 3:
                    this.f7116a.m6262a(R.string.chat_view_memory_error);
                    break;
                case 4:
                    this.f7116a.m6262a(R.string.ams_msg_invalid_ams_file);
                    C1786r.m6054a("Load Error", getClass().getSimpleName());
                    break;
                default:
                    if (!this.f7116a.f6914C.m6326s()) {
                        this.f7116a.m6262a(R.string.ams_msg_edit_protection);
                        break;
                    } else {
                        this.f7116a.f6914C.m6314g();
                        this.f7116a.m6559F();
                        this.f7116a.m6634m();
                        this.f7116a.m6637n();
                        this.f7116a.f6931T = true;
                        break;
                    }
            }
            return;
        }
        if (message.what == 3001) {
            this.f7116a.m6616h(this.f7116a.f6915D);
        }
    }
}
