package com.sec.chaton.registration;

import android.content.Intent;
import android.widget.Toast;
import com.sec.chaton.DataPacketDialog;
import com.sec.chaton.R;
import com.sec.chaton.SelectCountry;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1789u;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.aw */
/* loaded from: classes.dex */
class RunnableC1169aw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f4371a;

    RunnableC1169aw(AuthenticatorActivity authenticatorActivity) {
        this.f4371a = authenticatorActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f4371a.f4298e) {
            if (C1789u.m6075a().contains("uid")) {
                Toast.makeText(this.f4371a, R.string.regist_already_regist, 0).show();
                this.f4371a.finish();
            } else if (!C1789u.m6075a().getString("provisioning_disclaimer_status", "").equals("DONE")) {
                if (C1789u.m6075a().getBoolean("PacketDataDialg", false) || !C1721ad.m5875b().booleanValue()) {
                    if (C1721ad.m5883j() != null || C1789u.m6075a().getString("selected_country", "").equals("DONE")) {
                        this.f4371a.m4426f();
                    } else {
                        this.f4371a.startActivityForResult(new Intent(this.f4371a, (Class<?>) SelectCountry.class), 5);
                    }
                } else {
                    this.f4371a.startActivityForResult(new Intent(this.f4371a, (Class<?>) DataPacketDialog.class), 4);
                }
            } else if (!C1789u.m6075a().getString("provisioning_selfsms_status", "").equals("DONE")) {
                this.f4371a.startActivityForResult(new Intent(this.f4371a, (Class<?>) ActivityRegist.class), 1);
            } else if (!C1789u.m6075a().getString("provisioning_pushname_status", "").equals("DONE")) {
                this.f4371a.m4422d();
            } else {
                this.f4371a.f4295b = C1789u.m6075a().getString("msisdn", "");
                this.f4371a.f4294a = C1789u.m6075a().getString("Push Name", "");
                this.f4371a.m4420c();
            }
        }
        this.f4371a.f4298e = false;
    }
}
