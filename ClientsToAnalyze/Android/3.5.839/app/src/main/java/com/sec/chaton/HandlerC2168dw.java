package com.sec.chaton;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.AvaliableApps;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.dw */
/* loaded from: classes.dex */
class HandlerC2168dw extends Handler {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7797a;

    HandlerC2168dw(TabActivity tabActivity) {
        this.f7797a = tabActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f7797a.f2044M) {
            C0778b c0778b = (C0778b) message.obj;
            AvaliableApps avaliableApps = (AvaliableApps) c0778b.m3110e();
            if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR && avaliableApps.resultCode.equals(Spam.ACTIVITY_CHECK)) {
                C4809aa.m18105a("spp_update_is", (Boolean) true);
                if (!TextUtils.isEmpty(avaliableApps.version)) {
                    C4809aa.m18108a("spp_latest_ver", avaliableApps.version);
                }
                if (!C4809aa.m18104a().m18129b("UpdateIsCritical")) {
                    if (this.f7797a.m3004H()) {
                        this.f7797a.f2048Q = true;
                        return;
                    } else {
                        this.f7797a.startActivity(new Intent(this.f7797a, (Class<?>) SPPUpgradeDialog.class));
                        return;
                    }
                }
                C4904y.m18639b("ChatON updating process is still progressing.", TabActivity.f2029t);
                return;
            }
            C4904y.m18639b("There is no update of SPPPushClient.", TabActivity.f2029t);
        }
    }
}
