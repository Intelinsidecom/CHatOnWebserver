package com.sec.chaton.service;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: BackGroundRegiService.java */
/* renamed from: com.sec.chaton.service.b */
/* loaded from: classes.dex */
class HandlerC2387b extends Handler {

    /* renamed from: a */
    final /* synthetic */ BackGroundRegiService f8899a;

    HandlerC2387b(BackGroundRegiService backGroundRegiService) {
        this.f8899a = backGroundRegiService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 104:
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    this.f8899a.m8879a(false);
                    break;
                } else {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("provision was failed", BackGroundRegiService.f8872a);
                    }
                    this.f8899a.m8882b(false);
                    break;
                }
                break;
            case 202:
                if (c0267d != null && c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && this.f8899a.f8880i != null && this.f8899a.f8880i.m5508i()) {
                    C3250y.m11450b("ChatON deregistration is success.", BackGroundRegiService.f8872a);
                    C3641ai.m13211a(GlobalApplication.m11493l(), this.f8899a.getResources().getString(R.string.toast_account_deleted2), 0).show();
                    GlobalApplication.m6449a(GlobalApplication.m11493l());
                    if (this.f8899a.f8874c) {
                        C3159aa.m10963a("delete_account", (Boolean) true);
                    }
                } else {
                    C3250y.m11450b("ChatON deregistration is fail.", BackGroundRegiService.f8872a);
                    C3159aa.m10963a("back_deregi_fail", (Boolean) true);
                }
                this.f8899a.stopSelf();
                break;
            case 2006:
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Fianlly register was success with SA automatically", BackGroundRegiService.f8872a);
                    }
                    C3159aa.m10963a("did_samsung_account_mapping", (Boolean) true);
                    this.f8899a.f8881j = 0;
                    String strM10979a = C3159aa.m10962a().m10979a("temp_account_country_code", "");
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Final account ISO : " + strM10979a, getClass().getSimpleName());
                    }
                    this.f8899a.m8884c();
                    C3159aa.m10966a("account_country_code", strM10979a);
                    this.f8899a.m8882b(true);
                    break;
                } else if (c0267d.m1355f() == 50006) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("SSO token validaion was finished, retryCount : " + BackGroundRegiService.m8886d(this.f8899a), BackGroundRegiService.f8872a);
                    }
                    if (this.f8899a.m8883b()) {
                        if (this.f8899a.f8881j < 2) {
                            this.f8899a.m8879a(true);
                            break;
                        } else {
                            this.f8899a.f8881j = 0;
                            this.f8899a.m8882b(false);
                            break;
                        }
                    } else {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("it was NOT supported auto SSO Registration", BackGroundRegiService.f8872a);
                        }
                        this.f8899a.m8882b(false);
                        break;
                    }
                } else {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("SSO token validaion was failed", BackGroundRegiService.f8872a);
                    }
                    this.f8899a.m8882b(false);
                    break;
                }
                break;
        }
    }
}
