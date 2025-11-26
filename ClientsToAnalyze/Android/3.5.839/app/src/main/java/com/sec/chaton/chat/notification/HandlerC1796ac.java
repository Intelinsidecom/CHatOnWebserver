package com.sec.chaton.chat.notification;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1066bf;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.ac */
/* loaded from: classes.dex */
class HandlerC1796ac extends Handler {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6806a;

    HandlerC1796ac(ScreenNotification2 screenNotification2) {
        this.f6806a = screenNotification2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 100:
                if (message.arg1 == 0) {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.ams_btn_done, 0).show();
                } else {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                }
                this.f6806a.m8882g();
                break;
            case 101:
                this.f6806a.f6751X.setVisibility(8);
                this.f6806a.f6748U.setVisibility(0);
                this.f6806a.f6746S.setScrollDisable(false);
                if (message.arg1 == -2) {
                    if (C4904y.f17873c) {
                        C4904y.m18641c("native message delete failed", ScreenNotification2.f6727v);
                    }
                    this.f6806a.f6734G.setText(R.string.download_failed);
                    this.f6806a.f6734G.show();
                    break;
                } else {
                    if (C4904y.f17873c) {
                        C4904y.m18641c("native message delete success", ScreenNotification2.f6727v);
                    }
                    this.f6806a.f6734G.setText(R.string.message_will_be_deleted);
                    this.f6806a.f6734G.show();
                    if (this.f6806a.f6750W != null) {
                        if (this.f6806a.f6735H.m8964a(this.f6806a.f6750W.f6940n)) {
                            this.f6806a.f6730C.m8936c(C1813b.f6835d);
                        }
                    } else {
                        if (C4904y.f17873c) {
                            C4904y.m18641c("[onDeleteComplete] current item is null. Clear all noti.", ScreenNotification2.f6727v);
                        }
                        this.f6806a.f6730C.m8938d();
                    }
                    C0991aa.m6037a().m18961c(new C1066bf(C1828q.f6913a, -1));
                    break;
                }
            default:
                super.handleMessage(message);
                break;
        }
    }
}
