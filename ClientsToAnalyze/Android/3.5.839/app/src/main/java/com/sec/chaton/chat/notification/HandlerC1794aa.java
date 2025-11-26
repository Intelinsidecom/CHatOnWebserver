package com.sec.chaton.chat.notification;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1770hp;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.aa */
/* loaded from: classes.dex */
class HandlerC1794aa extends Handler {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6804a;

    HandlerC1794aa(ScreenNotification2 screenNotification2) {
        this.f6804a = screenNotification2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C1770hp c1770hp = (C1770hp) message.obj;
        if (c1770hp == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("[HttpUIHandler] obj is null. return.", ScreenNotification2.f6727v);
            }
            return;
        }
        C0778b c0778b = (C0778b) c1770hp.m8779a();
        switch (message.what) {
            case 901:
                if (C4904y.f17873c) {
                    C4904y.m18641c("[HttpUIHandler] METHOD_LIVE_DELIVERY_MESAGE", ScreenNotification2.f6727v);
                }
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    this.f6804a.f6745R.setText("");
                    C5179v.m19810a(this.f6804a.f6729B, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                    this.f6804a.m8882g();
                    break;
                } else {
                    this.f6804a.f6745R.setText("");
                    this.f6804a.f6751X.setVisibility(8);
                    C5179v.m19810a(this.f6804a.f6729B, R.string.ams_btn_done, 0).show();
                    break;
                }
        }
    }
}
