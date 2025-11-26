package com.sec.chaton.chat.translate;

import android.view.View;

/* compiled from: TranslatorFragment.java */
/* renamed from: com.sec.chaton.chat.translate.x */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC1871x implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ TranslatorFragment f7089a;

    ViewOnFocusChangeListenerC1871x(TranslatorFragment translatorFragment) {
        this.f7089a = translatorFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f7089a.m9003a(this.f7089a.f6974g, true);
        }
    }
}
