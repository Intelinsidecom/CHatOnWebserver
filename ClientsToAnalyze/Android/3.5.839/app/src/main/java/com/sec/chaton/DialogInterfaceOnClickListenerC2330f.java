package com.sec.chaton;

import android.content.DialogInterface;
import android.widget.EditText;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.f */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2330f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EditText f8282a;

    /* renamed from: b */
    final /* synthetic */ AdminMenu f8283b;

    DialogInterfaceOnClickListenerC2330f(AdminMenu adminMenu, EditText editText) {
        this.f8283b = adminMenu;
        this.f8282a = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4809aa.m18108a("admin_mcc", this.f8282a.getText().toString());
        if (C4904y.f17872b) {
            C4904y.m18639b("set MCC : " + this.f8282a.getText().toString(), "AdminMenu");
        }
    }
}
