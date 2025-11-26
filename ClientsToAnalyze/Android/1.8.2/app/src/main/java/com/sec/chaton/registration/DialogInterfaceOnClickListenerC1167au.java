package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.registration.ActivitySelectLanguage;

/* compiled from: ActivitySelectLanguage.java */
/* renamed from: com.sec.chaton.registration.au */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1167au implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySelectLanguage.SelectLanguageFragment f4369a;

    DialogInterfaceOnClickListenerC1167au(ActivitySelectLanguage.SelectLanguageFragment selectLanguageFragment) {
        this.f4369a = selectLanguageFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
