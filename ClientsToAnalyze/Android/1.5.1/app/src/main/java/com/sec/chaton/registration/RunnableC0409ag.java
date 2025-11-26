package com.sec.chaton.registration;

import android.content.Intent;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.DataPacketDialog;
import com.sec.chaton.util.ChatONPref;

/* renamed from: com.sec.chaton.registration.ag */
/* loaded from: classes.dex */
class RunnableC0409ag implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f2917a;

    RunnableC0409ag(AuthenticatorActivity authenticatorActivity) {
        this.f2917a = authenticatorActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f2917a.f2892h) {
            if (ChatONPref.m3519a().contains("uid")) {
                Toast.makeText(this.f2917a, C0062R.string.regist_already_regist, 0).show();
                this.f2917a.finish();
            } else if (ChatONPref.m3519a().getString("provisioning_disclaimer_status", "").equals("DONE")) {
                if (!ChatONPref.m3519a().getString("provisioning_selfsms_status", "").equals("DONE")) {
                    Intent intent = new Intent(this.f2917a, (Class<?>) ActivityRegist.class);
                    this.f2917a.f2886b = ChatONPref.m3519a().getString("msisdn", "");
                    intent.putExtra("REG_PNO", this.f2917a.f2886b);
                    this.f2917a.startActivityForResult(intent, 1);
                }
            } else if (ChatONPref.m3519a().getBoolean("PacketDataDialg", false)) {
                this.f2917a.m3099d();
            } else {
                this.f2917a.startActivityForResult(new Intent(this.f2917a, (Class<?>) DataPacketDialog.class), 4);
            }
        }
        this.f2917a.f2892h = false;
        this.f2917a.f2891g = false;
    }
}
