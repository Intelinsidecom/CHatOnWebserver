package com.sec.chaton.chat.translate;

import android.content.DialogInterface;

/* compiled from: TranslatorFragment.java */
/* renamed from: com.sec.chaton.chat.translate.aa */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1845aa implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ TranslatorFragment f7026a;

    DialogInterfaceOnCancelListenerC1845aa(TranslatorFragment translatorFragment) {
        this.f7026a = translatorFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.f7026a.f6971d != null) {
            this.f7026a.f6971d.cancel(true);
        }
    }
}
