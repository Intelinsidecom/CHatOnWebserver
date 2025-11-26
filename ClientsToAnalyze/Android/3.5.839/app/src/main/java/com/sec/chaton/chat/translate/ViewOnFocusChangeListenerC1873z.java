package com.sec.chaton.chat.translate;

import android.view.View;

/* compiled from: TranslatorFragment.java */
/* renamed from: com.sec.chaton.chat.translate.z */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC1873z implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ TranslatorFragment f7091a;

    ViewOnFocusChangeListenerC1873z(TranslatorFragment translatorFragment) {
        this.f7091a = translatorFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f7091a.m9003a(this.f7091a.f6975h, true);
        }
    }
}
