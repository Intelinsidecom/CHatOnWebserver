package com.sec.chaton.registration;

import android.accounts.AccountManager;
import android.content.Intent;
import com.sec.chaton.DataPacketDialog;
import com.sec.chaton.R;
import com.sec.chaton.SelectCountry;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.widget.C1619g;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.aj */
/* loaded from: classes.dex */
class RunnableC0938aj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f3325a;

    RunnableC0938aj(AuthenticatorActivity authenticatorActivity) {
        this.f3325a = authenticatorActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f3325a.f3274f) {
            if (AccountManager.get(GlobalApplication.m3100a()).getAccountsByType("com.sec.chaton").length <= 0 && C1323bs.m4575a().contains("uid")) {
                this.f3325a.f3270b = C1323bs.m4575a().getString("msisdn", "");
                this.f3325a.f3271c = C1323bs.m4575a().getString("uid", "");
                this.f3325a.m3729a(this.f3325a.f3270b, this.f3325a.f3271c);
            }
            if (C1323bs.m4575a().contains("uid")) {
                C1619g.m5888a(this.f3325a, R.string.regist_already_regist, 0).show();
                this.f3325a.finish();
            } else if (!C1323bs.m4575a().getString("provisioning_disclaimer_status", "").equals("DONE")) {
                if (C1323bs.m4575a().getBoolean("PacketDataDialg", false) || !C1336k.m4623b()) {
                    if (C1336k.m4630g() != null || C1323bs.m4575a().getString("selected_country", "").equals("DONE")) {
                        this.f3325a.m3738f();
                    } else {
                        this.f3325a.startActivityForResult(new Intent(this.f3325a, (Class<?>) SelectCountry.class), 5);
                    }
                } else {
                    this.f3325a.startActivityForResult(new Intent(this.f3325a, (Class<?>) DataPacketDialog.class), 4);
                }
            } else if (!C1323bs.m4575a().getString("provisioning_selfsms_status", "").equals("DONE")) {
                this.f3325a.startActivityForResult(new Intent(this.f3325a, (Class<?>) ActivityRegist.class), 1);
            } else if (!C1323bs.m4575a().getString("provisioning_pushname_status", "").equals("DONE")) {
                this.f3325a.m3734d();
            } else {
                this.f3325a.f3270b = C1323bs.m4575a().getString("msisdn", "");
                this.f3325a.f3269a = C1323bs.m4575a().getString("Push Name", "");
                this.f3325a.m3732c();
            }
        }
        this.f3325a.f3274f = false;
    }
}
