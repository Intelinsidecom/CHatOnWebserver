package com.sec.chaton;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.EnumC4864cb;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.cx */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1895cx implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f7113a;

    /* renamed from: b */
    final /* synthetic */ TabActivity f7114b;

    DialogInterfaceOnClickListenerC1895cx(TabActivity tabActivity, CheckBox checkBox) {
        this.f7114b = tabActivity;
        this.f7113a = checkBox;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f7113a.isChecked()) {
            C4859bx.m18383a(EnumC4864cb.agree, this.f7114b);
        } else {
            C4809aa.m18104a().m18125b("marketing_disclaimer", (Boolean) false);
        }
    }
}
