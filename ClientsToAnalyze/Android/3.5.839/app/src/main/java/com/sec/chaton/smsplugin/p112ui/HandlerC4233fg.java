package com.sec.chaton.smsplugin.p112ui;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p065io.entry.InviteBuddyEntry;
import com.sec.chaton.p065io.entry.inner.InviteBuddy;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.common.util.log.collector.C5043h;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fg */
/* loaded from: classes.dex */
class HandlerC4233fg extends Handler {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15586a;

    HandlerC4233fg(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15586a = pluginComposeMessageActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        if (message.what == 1201) {
            if (this.f15586a.f15029bf != null && this.f15586a.f15029bf.isShowing()) {
                this.f15586a.f15029bf.dismiss();
            }
            EnumC2464o enumC2464oM3107b = c0778b.m3107b();
            if (c0778b.m18954n() && enumC2464oM3107b == EnumC2464o.SUCCESS) {
                InviteBuddyEntry inviteBuddyEntry = (InviteBuddyEntry) c0778b.m3110e();
                if (inviteBuddyEntry.buddy.size() < 1) {
                    this.f15586a.f14997aq = GlobalApplication.m10283b().getString(R.string.invite_message, "\nhttp://www.chaton.com/invite.html");
                    this.f15586a.f14943O.setText(this.f15586a.f14997aq);
                    C3890m.m14996b("Mms/compose", "SMSMessageControl HTTP Success but result Object is empty");
                }
                InviteBuddy inviteBuddy = inviteBuddyEntry.buddy.get(0);
                switch (inviteBuddy.result.intValue()) {
                    case 0:
                        if (C1427a.f5063a.split("[.]").length == 3) {
                            this.f15586a.f14997aq = GlobalApplication.m10283b().getString(R.string.invite_message, "\nm.chaton.com/r/") + inviteBuddy.token;
                        } else {
                            this.f15586a.f14997aq = GlobalApplication.m10283b().getString(R.string.invite_message, "\nstg.m.chaton.com/r/") + inviteBuddy.token;
                        }
                        C3890m.m14996b("Mms/compose", "SMSMessageControl HTTP Success and send invite message with token(" + inviteBuddy.token + ")");
                        this.f15586a.f14943O.setText(this.f15586a.f14997aq);
                        C5043h.m19179a().m19185a("2001", "2110", false);
                        break;
                    case 1:
                    case 2:
                    case 3:
                        C3890m.m14996b("Mms/compose", "SMSMessageControl HTTP Success (But result has error code: " + inviteBuddy.result + ") and send invite message only");
                        this.f15586a.f14997aq = GlobalApplication.m10283b().getString(R.string.invite_message, "\nwww.chaton.com/invite.html");
                        this.f15586a.f14943O.setText(this.f15586a.f14997aq);
                        break;
                }
            }
        }
    }
}
