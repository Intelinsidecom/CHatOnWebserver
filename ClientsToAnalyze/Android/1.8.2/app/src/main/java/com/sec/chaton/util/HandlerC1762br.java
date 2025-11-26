package com.sec.chaton.util;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.R;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0103d;
import com.sec.chaton.p007a.p008a.EnumC0104e;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.widget.C2153y;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.br */
/* loaded from: classes.dex */
class HandlerC1762br extends Handler {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f6400a;

    HandlerC1762br(ScreenOnNotification screenOnNotification) {
        this.f6400a = screenOnNotification;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int iM680a;
        C0103d c0103d = (C0103d) message.obj;
        if (C0493bg.m2680a(message.what, c0103d.m680a()) == EnumC0104e.END_APP) {
            if (!ExitAppDialogActivity.m580a()) {
                ExitAppDialogActivity.m581b();
            }
            return;
        }
        if (C0493bg.m2680a(message.what, c0103d.m680a()) == EnumC0104e.RESTART_APP) {
            this.f6400a.showDialog(2);
        }
        if (!c0103d.f333a && (((iM680a = c0103d.m680a()) == 24 || iM680a == 23 || iM680a == 21) && this.f6400a.f6296c != null)) {
            this.f6400a.f6296c.m2954f();
            this.f6400a.f6296c.m2947a(this.f6400a.f6299i, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
        }
        switch (message.what) {
            case 4:
                if (c0103d.f333a) {
                    this.f6400a.f6308r.setText("");
                    if (this.f6400a.f6296c != null) {
                        this.f6400a.f6296c.m2936a(EnumC0695j.m3145a(this.f6400a.f6300j), this.f6400a.f6303m);
                    }
                } else {
                    c0103d.m680a();
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    switch (C0493bg.m2680a(message.what, r0)) {
                        case CHANGE_SERVER:
                            this.f6400a.f6296c.m2954f();
                            this.f6400a.f6296c.m2947a(this.f6400a.f6299i, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                            this.f6400a.f6296c.m2930a(jElapsedRealtime + 480000);
                            break;
                        case RETRY:
                            this.f6400a.f6296c.m2947a(this.f6400a.f6299i, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                            this.f6400a.f6296c.m2930a(jElapsedRealtime + 480000);
                            this.f6400a.f6303m = null;
                            break;
                        case BLOCK_RECEIVER:
                            C2153y.m7536a(GlobalApplication.m3260b(), String.format(GlobalApplication.m3260b().getString(R.string.toast_was_blocked), this.f6400a.f6297d), 0).show();
                            break;
                    }
                }
                this.f6400a.finish();
                break;
            case 1028:
                this.f6400a.showDialog(1);
                this.f6400a.f6316z.removeCallbacks(this.f6400a.f6290A);
                if (!this.f6400a.f6291B) {
                    this.f6400a.f6316z.postDelayed(this.f6400a.f6290A, this.f6400a.f6315y);
                    break;
                }
                break;
        }
    }
}
