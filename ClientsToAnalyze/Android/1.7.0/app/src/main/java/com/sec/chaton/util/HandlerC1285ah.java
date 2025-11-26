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

/* compiled from: BlackScreenNotification.java */
/* renamed from: com.sec.chaton.util.ah */
/* loaded from: classes.dex */
class HandlerC1285ah extends Handler {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f4466a;

    HandlerC1285ah(BlackScreenNotification blackScreenNotification) {
        this.f4466a = blackScreenNotification;
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
            this.f4466a.showDialog(2);
        }
        if (!c0257e.f604a && (((iM917b = c0257e.m917b()) == 24 || iM917b == 23 || iM917b == 21) && this.f4466a.f4381c != null)) {
            this.f4466a.f4381c.m857f();
            this.f4466a.f4381c.m851a(this.f4466a.f4384f, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
        }
        switch (message.what) {
            case 4:
                if (c0257e.f604a) {
                    this.f4466a.f4381c.m845a(EnumC0665r.m3011a(this.f4466a.f4385g), this.f4466a.f4390m);
                    this.f4466a.f4395r.setText("");
                    C1619g.m5888a(GlobalApplication.m3100a(), R.string.ams_btn_done, 0).show();
                } else {
                    c0257e.m917b();
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    switch (C0520a.m2709a(message.what, r0)) {
                        case CHANGE_SERVER:
                            this.f4466a.f4381c.m857f();
                            this.f4466a.f4381c.m851a(this.f4466a.f4384f, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                            this.f4466a.f4381c.m841a(jElapsedRealtime + 480000);
                            break;
                        case RETRY:
                            this.f4466a.f4381c.m851a(this.f4466a.f4384f, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                            this.f4466a.f4381c.m841a(jElapsedRealtime + 480000);
                            this.f4466a.f4390m = null;
                            break;
                        case BLOCK_RECEIVER:
                            C1619g.m5889a(GlobalApplication.m3100a(), String.format(GlobalApplication.m3100a().getString(R.string.toast_was_blocked), this.f4466a.f4382d), 0).show();
                            break;
                    }
                    C1619g.m5888a(GlobalApplication.m3100a(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                }
                this.f4466a.finish();
                break;
            case 1028:
                this.f4466a.showDialog(0);
                break;
        }
    }
}
