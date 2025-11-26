package com.sec.chaton;

import android.content.DialogInterface;
import com.sec.chaton.p055d.C2132m;
import com.sec.chaton.util.C4809aa;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2354h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f8386a;

    DialogInterfaceOnClickListenerC2354h(AdminMenu adminMenu) {
        this.f8386a = adminMenu;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str = "." + this.f8386a.f1902am;
        C4809aa.m18104a().m18128b("operation", str);
        new C2132m(null).m9553a(str);
        dialogInterface.dismiss();
        this.f8386a.finish();
    }
}
