package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.p016a.p017a.C0276m;

/* compiled from: EditProfileFragment.java */
/* renamed from: com.sec.chaton.userprofile.ab */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3076ab implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3075aa f11288a;

    DialogInterfaceOnClickListenerC3076ab(HandlerC3075aa handlerC3075aa) {
        this.f11288a = handlerC3075aa;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C0276m c0276m = new C0276m();
        c0276m.m1368a(this.f11288a.f11287a.f11068b.getText().toString());
        c0276m.m1370b(this.f11288a.f11287a.f11069c.getText().toString());
        this.f11288a.f11287a.f11070d.m5928a(c0276m, "");
        this.f11288a.f11287a.f11071e.show();
    }
}
