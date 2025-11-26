package com.sec.chaton.util;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.R;
import com.sec.chaton.chat.C0520a;
import com.sec.chaton.chat.C0592i;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0257e;
import com.sec.chaton.p015b.p016a.EnumC0255c;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.widget.C1619g;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bl */
/* loaded from: classes.dex */
class HandlerC1316bl extends Handler {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f4535a;

    HandlerC1316bl(ScreenOnNotification screenOnNotification) {
        this.f4535a = screenOnNotification;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int iM917b;
        C0257e c0257e = (C0257e) ((C0592i) message.obj).m2777a();
        if (C0520a.m2709a(message.what, c0257e.m917b()) == EnumC0255c.END_APP) {
            if (!ExitAppDialogActivity.m624a()) {
                ExitAppDialogActivity.m625b();
            }
            return;
        }
        if (C0520a.m2709a(message.what, c0257e.m917b()) == EnumC0255c.RESTART_APP) {
            this.f4535a.showDialog(2);
        }
        if (!c0257e.f604a && (((iM917b = c0257e.m917b()) == 24 || iM917b == 23 || iM917b == 21) && this.f4535a.f4435c != null)) {
            this.f4535a.f4435c.m857f();
            this.f4535a.f4435c.m851a(this.f4535a.f4438f, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
        }
        switch (message.what) {
            case 4:
                if (c0257e.f604a) {
                    this.f4535a.f4435c.m845a(EnumC0665r.m3011a(this.f4535a.f4439g), this.f4535a.f4442k);
                    this.f4535a.f4447p.setText("");
                    C1619g.m5888a(GlobalApplication.m3100a(), R.string.ams_btn_done, 0).show();
                } else {
                    c0257e.m917b();
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    switch (C0520a.m2709a(message.what, r0)) {
                        case CHANGE_SERVER:
                            this.f4535a.f4435c.m857f();
                            this.f4535a.f4435c.m851a(this.f4535a.f4438f, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                            this.f4535a.f4435c.m841a(jElapsedRealtime + 480000);
                            break;
                        case RETRY:
                            this.f4535a.f4435c.m851a(this.f4535a.f4438f, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                            this.f4535a.f4435c.m841a(jElapsedRealtime + 480000);
                            this.f4535a.f4442k = null;
                            break;
                        case BLOCK_RECEIVER:
                            C1619g.m5889a(GlobalApplication.m3100a(), String.format(GlobalApplication.m3100a().getString(R.string.toast_was_blocked), this.f4535a.f4436d), 0).show();
                            break;
                    }
                    C1619g.m5888a(GlobalApplication.m3100a(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                }
                this.f4535a.finish();
                break;
            case 1028:
                this.f4535a.showDialog(1);
                this.f4535a.f4455x.removeCallbacks(this.f4535a.f4456y);
                if (!this.f4535a.f4457z) {
                    this.f4535a.f4455x.postDelayed(this.f4535a.f4456y, this.f4535a.f4454w);
                    break;
                }
                break;
        }
    }
}
