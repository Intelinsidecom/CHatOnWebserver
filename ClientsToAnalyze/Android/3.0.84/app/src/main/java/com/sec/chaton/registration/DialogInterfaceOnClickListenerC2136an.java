package com.sec.chaton.registration;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.AdminMenu;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.an */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2136an implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8410a;

    DialogInterfaceOnClickListenerC2136an(AuthenticatorActivity authenticatorActivity) {
        this.f8410a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (C3250y.m11446a(this.f8410a.f8164w.getText().toString())) {
            if (this.f8410a.f8163v > 13) {
                Intent intent = new Intent(this.f8410a.f8154m, (Class<?>) AdminMenu.class);
                intent.putExtra("mapping_mode", false);
                intent.putExtra("general_tab", true);
                this.f8410a.startActivity(intent);
                this.f8410a.f8163v = 0;
            }
            C3250y.m11439a(1);
            C3641ai.m13211a(this.f8410a, "Log On", 1).show();
            if (this.f8410a.f8166y != null && this.f8410a.f8166y.isShowing()) {
                this.f8410a.f8166y.dismiss();
            }
        }
    }
}
