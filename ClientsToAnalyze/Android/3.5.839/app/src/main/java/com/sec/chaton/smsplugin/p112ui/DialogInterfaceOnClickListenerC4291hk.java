package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.sec.chaton.util.C4809aa;

/* compiled from: SMSPreferenceActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hk */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4291hk implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f15674a;

    /* renamed from: b */
    final /* synthetic */ C4289hi f15675b;

    DialogInterfaceOnClickListenerC4291hk(C4289hi c4289hi, CheckBox checkBox) {
        this.f15675b = c4289hi;
        this.f15674a = checkBox;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f15674a.isChecked()) {
            C4809aa.m18104a().m18125b("free_sms_show_dialog", (Boolean) true);
        }
    }
}
