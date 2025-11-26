package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.AdminMenu;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.as */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2330as implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8752a;

    DialogInterfaceOnClickListenerC2330as(MainActivity mainActivity) {
        this.f8752a = mainActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (C3250y.m11446a(this.f8752a.f8683ae.getText().toString())) {
            if (this.f8752a.f8682ad == 3) {
                Intent intent = new Intent(this.f8752a.f8714k, (Class<?>) AdminMenu.class);
                intent.putExtra("mapping_mode", this.f8752a.f8727x);
                this.f8752a.startActivityForResult(intent, 4);
                this.f8752a.f8682ad = 0;
            }
            C3250y.m11439a(1);
            C3641ai.m13211a(this.f8752a, "Log On", 1).show();
            if (this.f8752a.f8687ai != null && this.f8752a.f8687ai.isShowing()) {
                this.f8752a.f8687ai.dismiss();
            }
        }
    }
}
