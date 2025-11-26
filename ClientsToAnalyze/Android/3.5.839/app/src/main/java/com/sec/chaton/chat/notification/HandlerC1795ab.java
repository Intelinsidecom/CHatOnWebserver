package com.sec.chaton.chat.notification;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.C1770hp;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p046a.p047a.EnumC0789m;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.ab */
/* loaded from: classes.dex */
class HandlerC1795ab extends Handler {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6805a;

    HandlerC1795ab(ScreenNotification2 screenNotification2) {
        this.f6805a = screenNotification2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        int iM3152g;
        C0788l c0788l = (C0788l) ((C1770hp) message.obj).m8779a();
        if (c0788l == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("resultEntry is null", getClass().getSimpleName());
            }
            return;
        }
        if (C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.END_APP) {
            if (!ExitAppDialogActivity.m2892a()) {
                ExitAppDialogActivity.m2894b();
                return;
            }
            return;
        }
        if (C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.RESTART_APP) {
            this.f6805a.m8841c(100);
        }
        if (!c0788l.f2172a && (((iM3152g = c0788l.m3152g()) == 24 || iM3152g == 23 || iM3152g == 21) && this.f6805a.f6732E != null)) {
            this.f6805a.f6732E.mo9274d();
            this.f6805a.f6732E.mo9252a(this.f6805a.f6750W.f6931e, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
        }
        switch (message.what) {
            case 0:
            case 4:
                if (c0788l.f2172a) {
                    if (this.f6805a.f6732E != null) {
                        this.f6805a.f6732E.mo9227a(EnumC2300t.m10207a(this.f6805a.f6750W.f6932f), this.f6805a.f6750W.f6935i);
                        this.f6805a.f6745R.setText("");
                        C5179v.m19810a(this.f6805a.f6729B, R.string.ams_btn_done, 0).show();
                    }
                } else {
                    c0788l.m3152g();
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    switch (C1736gi.m8627a(message.what, r0)) {
                        case CHANGE_SERVER:
                            if (this.f6805a.f6732E != null) {
                                this.f6805a.f6732E.mo9274d();
                                this.f6805a.f6732E.mo9252a(this.f6805a.f6750W.f6931e, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                                this.f6805a.f6732E.mo9243a(jElapsedRealtime + 300000);
                                break;
                            }
                            break;
                        case RETRY:
                            if (this.f6805a.f6732E != null) {
                                this.f6805a.f6732E.mo9252a(this.f6805a.f6750W.f6931e, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                                this.f6805a.f6732E.mo9243a(jElapsedRealtime + 300000);
                                break;
                            }
                            break;
                        case BLOCK_RECEIVER:
                            C5179v.m19811a(this.f6805a.f6729B, String.format(this.f6805a.f6729B.getString(R.string.toast_was_blocked), this.f6805a.f6750W.f6927a), 0).show();
                            break;
                    }
                    C5179v.m19810a(this.f6805a.f6729B, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                }
                this.f6805a.m8882g();
                break;
        }
    }
}
