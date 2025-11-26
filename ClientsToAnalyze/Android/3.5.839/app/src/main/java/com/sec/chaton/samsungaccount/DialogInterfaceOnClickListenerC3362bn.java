package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.AdminMenu;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.bn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3362bn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f12300a;

    DialogInterfaceOnClickListenerC3362bn(MainActivity mainActivity) {
        this.f12300a = mainActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (C4904y.m18637a(this.f12300a.f12218ab.getText().toString())) {
            if (this.f12300a.f12217aa == 3) {
                Intent intent = new Intent(this.f12300a.f12192B, (Class<?>) AdminMenu.class);
                intent.putExtra("mapping_mode", this.f12300a.f12163q);
                this.f12300a.startActivityForResult(intent, 5);
                this.f12300a.f12217aa = 0;
            }
            C4904y.m18632a(1);
            C5179v.m19811a(this.f12300a, "Log On", 1).show();
            if (this.f12300a.f12222af != null && this.f12300a.f12222af.isShowing()) {
                this.f12300a.f12222af.dismiss();
                return;
            }
            return;
        }
        if (C4904y.m18640b(this.f12300a.f12218ab.getText().toString())) {
            if (this.f12300a.f12217aa == 3) {
                Intent intent2 = new Intent(this.f12300a.f12192B, (Class<?>) AdminMenu.class);
                intent2.putExtra("mapping_mode", this.f12300a.f12163q);
                this.f12300a.startActivityForResult(intent2, 5);
                this.f12300a.f12217aa = 0;
            }
            C4904y.m18632a(2);
            C5179v.m19811a(this.f12300a, "Log On With Save", 1).show();
            if (this.f12300a.f12222af != null && this.f12300a.f12222af.isShowing()) {
                this.f12300a.f12222af.dismiss();
            }
        }
    }
}
