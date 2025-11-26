package com.sec.chaton.smsplugin.p112ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: LinkActionChooserFragment.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ad */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4095ad implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AbstractC4102ak f15229a;

    /* renamed from: b */
    final /* synthetic */ Activity f15230b;

    /* renamed from: c */
    final /* synthetic */ String f15231c;

    /* renamed from: d */
    final /* synthetic */ String f15232d;

    /* renamed from: e */
    final /* synthetic */ DialogFragmentC4094ac f15233e;

    DialogInterfaceOnClickListenerC4095ad(DialogFragmentC4094ac dialogFragmentC4094ac, AbstractC4102ak abstractC4102ak, Activity activity, String str, String str2) {
        this.f15233e = dialogFragmentC4094ac;
        this.f15229a = abstractC4102ak;
        this.f15230b = activity;
        this.f15231c = str;
        this.f15232d = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f15233e.f15228l.isChecked()) {
            this.f15229a.mo16294a(this.f15230b, this.f15231c, this.f15232d);
        } else {
            Intent intent = new Intent(this.f15230b, (Class<?>) SMSPreferenceActivity.class);
            if (intent != null) {
                intent.putExtra("URLinkCall", "URL_LINK_SETTING");
                this.f15230b.startActivity(intent);
            }
        }
        dialogInterface.dismiss();
    }
}
