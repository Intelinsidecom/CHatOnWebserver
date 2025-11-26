package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.y */
/* loaded from: classes.dex */
class HandlerC2058y extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7354a;

    HandlerC2058y(AMSComposerActivity aMSComposerActivity) {
        this.f7354a = aMSComposerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        if (message.what == 3000) {
            switch (this.f7354a.f7148I.m6304b(this.f7354a.f7165Z)) {
                case 1:
                    this.f7354a.m6262a(R.string.ams_msg_minor_version_changed);
                    break;
                case 2:
                    this.f7354a.m6262a(R.string.ams_msg_major_version_changed);
                    break;
                case 3:
                default:
                    if (!this.f7354a.f7148I.m6326s()) {
                        this.f7354a.m6262a(R.string.ams_msg_edit_protection);
                        break;
                    } else {
                        this.f7354a.f7148I.m6314g();
                        this.f7354a.m6889I();
                        this.f7354a.m6968m();
                        this.f7354a.m6972n();
                        this.f7354a.f7166aa = true;
                        break;
                    }
                case 4:
                    this.f7354a.m6262a(R.string.ams_msg_invalid_ams_file);
                    C1786r.m6054a("Load Error", getClass().getSimpleName());
                    break;
            }
            return;
        }
        if (message.what == 3001) {
            this.f7354a.m6977o(this.f7354a.f7149J);
        }
    }
}
