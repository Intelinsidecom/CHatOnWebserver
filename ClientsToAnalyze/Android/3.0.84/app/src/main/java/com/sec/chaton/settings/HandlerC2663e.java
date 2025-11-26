package com.sec.chaton.settings;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.UpgradeDialog;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.AvaliableApps;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.e */
/* loaded from: classes.dex */
class HandlerC2663e extends Handler {

    /* renamed from: a */
    final /* synthetic */ AboutServiceFragment f9930a;

    HandlerC2663e(AboutServiceFragment aboutServiceFragment) {
        this.f9930a = aboutServiceFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f9930a.getActivity() != null) {
            C0267d c0267d = (C0267d) message.obj;
            AvaliableApps avaliableApps = (AvaliableApps) c0267d.m1354e();
            if (this.f9930a.f8932x != null && this.f9930a.f8932x.isShowing()) {
                this.f9930a.f8932x.dismiss();
            }
            if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR || avaliableApps.resultCode == null || !avaliableApps.resultCode.equals("2")) {
                if (this.f9930a.f8931w) {
                    C3214cb.m11267d(0);
                } else {
                    C3214cb.m11270f(0);
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b("Samsung apps is NOT ready to upgrade chaton", AboutServiceFragment.f8911o);
                    return;
                }
                return;
            }
            if (this.f9930a.f8931w) {
                Intent intent = new Intent(this.f9930a.f8922m, (Class<?>) UpgradeDialog.class);
                intent.putExtra("isCritical", false);
                intent.putExtra("isFromHome", true);
                this.f9930a.startActivity(intent);
            } else {
                C3214cb.m11259b(0);
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("Samsung apps is ready to upgrade chaton", AboutServiceFragment.f8911o);
            }
        }
    }
}
