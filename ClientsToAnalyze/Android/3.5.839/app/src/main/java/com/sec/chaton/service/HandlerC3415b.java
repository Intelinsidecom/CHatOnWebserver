package com.sec.chaton.service;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1058ba;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.mobileweb.C2602p;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: BackGroundRegiService.java */
/* renamed from: com.sec.chaton.service.b */
/* loaded from: classes.dex */
class HandlerC3415b extends Handler {

    /* renamed from: a */
    final /* synthetic */ BackGroundRegiService f12429a;

    HandlerC3415b(BackGroundRegiService backGroundRegiService) {
        this.f12429a = backGroundRegiService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 104:
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    this.f12429a.m13265b(false);
                    break;
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("provision was failed", BackGroundRegiService.f12400a);
                    }
                    this.f12429a.m13269c(false);
                    break;
                }
                break;
            case 202:
                if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR && this.f12429a.f12408i != null && this.f12429a.f12408i.m9091e()) {
                    C4904y.m18639b("ChatON deregistration is success.", BackGroundRegiService.f12400a);
                    C5179v.m19811a(GlobalApplication.m18732r(), this.f12429a.getResources().getString(R.string.toast_account_deleted2), 0).show();
                    C4894o.m18606a(GlobalApplication.m18732r().getApplicationInfo().dataDir);
                    C2602p.m11022d();
                    C0991aa.m6037a().m18962d(new C1058ba());
                    if (this.f12429a.f12402c) {
                        C4809aa.m18105a("delete_account", (Boolean) true);
                    }
                } else {
                    C4904y.m18639b("ChatON deregistration is fail.", BackGroundRegiService.f12400a);
                    C4809aa.m18105a("back_deregi_fail", (Boolean) true);
                }
                this.f12429a.stopSelf();
                break;
            case 2006:
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Fianlly register was success with SA automatically", BackGroundRegiService.f12400a);
                    }
                    C4809aa.m18105a("did_samsung_account_mapping", (Boolean) true);
                    this.f12429a.f12409j = 0;
                    String strM18121a = C4809aa.m18104a().m18121a("temp_account_country_code", "");
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Final account ISO : " + strM18121a, getClass().getSimpleName());
                    }
                    this.f12429a.m13267c();
                    C4809aa.m18108a("account_country_code", strM18121a);
                    this.f12429a.m13269c(true);
                    break;
                } else if (c0778b.m3111f() == 50006) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("SSO token validaion was finished, retryCount : " + BackGroundRegiService.m13270d(this.f12429a), BackGroundRegiService.f12400a);
                    }
                    if (this.f12429a.m13266b()) {
                        if (this.f12429a.f12409j < 2) {
                            this.f12429a.m13265b(true);
                            break;
                        } else {
                            this.f12429a.f12409j = 0;
                            this.f12429a.m13269c(false);
                            break;
                        }
                    } else {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("it was NOT supported auto SSO Registration", BackGroundRegiService.f12400a);
                        }
                        this.f12429a.m13269c(false);
                        break;
                    }
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("SSO token validaion was failed", BackGroundRegiService.f12400a);
                    }
                    this.f12429a.m13269c(false);
                    break;
                }
                break;
        }
    }
}
