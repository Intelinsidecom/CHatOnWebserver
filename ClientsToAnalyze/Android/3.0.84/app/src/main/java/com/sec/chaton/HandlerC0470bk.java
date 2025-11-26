package com.sec.chaton;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.AvaliableApps;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bk */
/* loaded from: classes.dex */
class HandlerC0470bk extends Handler {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1538a;

    HandlerC0470bk(TabActivity tabActivity) {
        this.f1538a = tabActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f1538a.f802z) {
            C0267d c0267d = (C0267d) message.obj;
            AvaliableApps avaliableApps = (AvaliableApps) c0267d.m1354e();
            if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && avaliableApps.resultCode.equals("2")) {
                C3159aa.m10963a("spp_update_is", (Boolean) true);
                if (!TextUtils.isEmpty(avaliableApps.version)) {
                    C3159aa.m10966a("spp_latest_ver", avaliableApps.version);
                }
                if (!C3159aa.m10962a().m10987b("UpdateIsCritical")) {
                    if (this.f1538a.m1201D()) {
                        this.f1538a.f747N = true;
                        return;
                    } else {
                        this.f1538a.startActivity(new Intent(this.f1538a, (Class<?>) SPPUpgradeDialog.class));
                        return;
                    }
                }
                C3250y.m11450b("ChatON updating process is still progressing.", TabActivity.f732f);
                return;
            }
            C3250y.m11450b("There is no update of SPPPushClient.", TabActivity.f732f);
        }
    }
}
