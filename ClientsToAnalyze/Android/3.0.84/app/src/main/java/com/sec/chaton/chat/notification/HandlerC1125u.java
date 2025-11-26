package com.sec.chaton.chat.notification;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.C1092fg;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p016a.p017a.EnumC0273j;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.u */
/* loaded from: classes.dex */
class HandlerC1125u extends Handler {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f4535a;

    HandlerC1125u(ScreenNotification2 screenNotification2) {
        this.f4535a = screenNotification2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        int iM1365f;
        C0272i c0272i = (C0272i) ((C1092fg) message.obj).m5376a();
        if (c0272i == null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("resultEntry is null", getClass().getSimpleName());
            }
            return;
        }
        if (C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.END_APP) {
            if (!ExitAppDialogActivity.m1139a()) {
                ExitAppDialogActivity.m1141b();
                return;
            }
            return;
        }
        if (C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.RESTART_APP) {
            this.f4535a.m5393a(100);
        }
        if (!c0272i.f858a && (((iM1365f = c0272i.m1365f()) == 24 || iM1365f == 23 || iM1365f == 21) && this.f4535a.f4412m != null)) {
            this.f4535a.f4412m.m5901j();
            this.f4535a.f4412m.m5880a(this.f4535a.f4386E.f4502e, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
        }
        switch (message.what) {
            case 0:
            case 4:
                if (c0272i.f858a) {
                    if (this.f4535a.f4412m != null) {
                        this.f4535a.f4412m.m5871a(EnumC1450r.m6339a(this.f4535a.f4386E.f4503f), this.f4535a.f4386E.f4506i);
                        this.f4535a.f4425z.setText("");
                        C3641ai.m13210a(this.f4535a.f4409j, R.string.ams_btn_done, 0).show();
                    }
                } else {
                    c0272i.m1365f();
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    switch (C1075eq.m5314a(message.what, r0)) {
                        case CHANGE_SERVER:
                            this.f4535a.f4412m.m5901j();
                            this.f4535a.f4412m.m5880a(this.f4535a.f4386E.f4502e, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                            this.f4535a.f4412m.m5893c(jElapsedRealtime + 480000);
                            break;
                        case RETRY:
                            if (this.f4535a.f4412m != null) {
                                this.f4535a.f4412m.m5880a(this.f4535a.f4386E.f4502e, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                                this.f4535a.f4412m.m5893c(jElapsedRealtime + 480000);
                                break;
                            }
                            break;
                        case BLOCK_RECEIVER:
                            C3641ai.m13211a(this.f4535a.f4409j, String.format(this.f4535a.f4409j.getString(R.string.toast_was_blocked), this.f4535a.f4386E.f4498a), 0).show();
                            break;
                    }
                    C3641ai.m13210a(this.f4535a.f4409j, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                }
                this.f4535a.m5424b();
                break;
        }
    }
}
