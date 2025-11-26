package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.ax */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2436ax implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C2434av f9296a;

    DialogInterfaceOnClickListenerC2436ax(C2434av c2434av) {
        this.f9296a = c2434av;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f9296a.f9294a.f9014s = this.f9296a.f9294a.f9013r;
        String str = this.f9296a.f9294a.f9020y[this.f9296a.f9294a.f9014s];
        if (this.f9296a.f9294a.f9014s == 0) {
            this.f9296a.f9294a.f9007l.m10983b("Setting is simple popup", (Boolean) true);
        } else {
            this.f9296a.f9294a.f9007l.m10983b("Setting is simple popup", (Boolean) false);
        }
        this.f9296a.f9294a.m8986a(str, this.f9296a.f9294a.f9018w, this.f9296a.f9294a.getResources().getColor(R.color.buddy_list_item_status_changed));
    }
}
