package com.sec.chaton.settings;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.UpgradeDialog;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.AvaliableApps;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.e */
/* loaded from: classes.dex */
class HandlerC3590e extends Handler {

    /* renamed from: a */
    final /* synthetic */ AboutServiceFragment f13111a;

    HandlerC3590e(AboutServiceFragment aboutServiceFragment) {
        this.f13111a = aboutServiceFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f13111a.getActivity() != null) {
            C0778b c0778b = (C0778b) message.obj;
            AvaliableApps avaliableApps = (AvaliableApps) c0778b.m3110e();
            if (this.f13111a.f12462x != null && this.f13111a.f12462x.isShowing()) {
                this.f13111a.f12462x.dismiss();
            }
            if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR || avaliableApps.resultCode == null || !avaliableApps.resultCode.equals(Spam.ACTIVITY_CHECK)) {
                if (this.f13111a.f12464z) {
                    C4822an.m18213a(this.f13111a.f12463y, this.f13111a.getActivity(), true, "NO");
                } else if (this.f13111a.f12461w) {
                    C4859bx.m18395c(0);
                } else {
                    C4859bx.m18403e(0);
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("Samsung apps is NOT ready to upgrade chaton", AboutServiceFragment.f12441o);
                    return;
                }
                return;
            }
            C4809aa.m18104a().m18128b("UpdateAppsReady", "YES");
            if (this.f13111a.f12464z) {
                C4822an.m18213a(this.f13111a.f12463y, this.f13111a.getActivity(), true, "YES");
            } else if (this.f13111a.f12461w) {
                Intent intent = new Intent(this.f13111a.f12452m, (Class<?>) UpgradeDialog.class);
                intent.putExtra("isCritical", this.f13111a.f12464z);
                intent.putExtra("isFromHome", true);
                this.f13111a.startActivity(intent);
            } else {
                C4859bx.m18378a(0);
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("Samsung apps is ready to upgrade chaton", AboutServiceFragment.f12441o);
            }
        }
    }
}
