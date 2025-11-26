package com.sec.chaton;

import android.content.DialogInterface;
import android.widget.EditText;
import com.sec.chaton.util.C4822an;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.d */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1898d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EditText f7117a;

    /* renamed from: b */
    final /* synthetic */ AdminMenu f7118b;

    DialogInterfaceOnClickListenerC1898d(AdminMenu adminMenu, EditText editText) {
        this.f7118b = adminMenu;
        this.f7117a = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4822an.m18215a(this.f7117a.getText().toString());
    }
}
