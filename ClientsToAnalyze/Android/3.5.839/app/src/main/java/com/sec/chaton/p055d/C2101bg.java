package com.sec.chaton.p055d;

import android.content.res.Resources;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.util.C4904y;

/* compiled from: SNSBuddyControl.java */
/* renamed from: com.sec.chaton.d.bg */
/* loaded from: classes.dex */
class C2101bg implements InterfaceC2113bs {

    /* renamed from: a */
    String f7627a;

    /* renamed from: b */
    HandlerThreadC2100bf f7628b;

    /* renamed from: c */
    final /* synthetic */ C2099be f7629c;

    C2101bg(C2099be c2099be, String str, HandlerThreadC2100bf handlerThreadC2100bf) {
        this.f7629c = c2099be;
        this.f7627a = null;
        this.f7628b = null;
        this.f7627a = str;
        this.f7628b = handlerThreadC2100bf;
    }

    @Override // com.sec.chaton.p055d.InterfaceC2113bs
    /* renamed from: a */
    public void mo9385a(int i, EnumC2111bq enumC2111bq) throws Resources.NotFoundException {
        C4904y.m18634a("updateUI() for sns type :" + this.f7627a + " value: " + i, getClass().getSimpleName());
        switch (i) {
            case 1301:
            case 1302:
            case 1303:
                break;
            case 1304:
            case 1305:
            case 1306:
            default:
                return;
            case 1307:
                C4368e.m16564a(GlobalApplication.m18732r()).m16565a(this.f7627a, false);
                String string = GlobalApplication.m18732r().getResources().getString(R.string.relogin_sns_msg, this.f7627a);
                if (this.f7629c.f7624g != null) {
                    this.f7629c.f7624g.post(new RunnableC2102bh(this, string));
                    break;
                }
                break;
        }
        this.f7628b.quit();
        this.f7629c.f7623f.remove(this.f7627a);
        C4904y.m18639b("ControlThread for SNS " + this.f7627a + " -> quit", C2099be.f7618a);
    }
}
