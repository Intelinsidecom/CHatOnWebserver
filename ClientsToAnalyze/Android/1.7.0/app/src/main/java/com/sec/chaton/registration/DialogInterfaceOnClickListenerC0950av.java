package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.registration.ActivitySelectLanguage;

/* compiled from: ActivitySelectLanguage.java */
/* renamed from: com.sec.chaton.registration.av */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0950av implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySelectLanguage.SelectLanguageFragment f3341a;

    DialogInterfaceOnClickListenerC0950av(ActivitySelectLanguage.SelectLanguageFragment selectLanguageFragment) {
        this.f3341a = selectLanguageFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
