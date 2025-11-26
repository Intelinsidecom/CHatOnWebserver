package com.sec.chaton.smsplugin.p112ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: BasicSlideEditorView.java */
/* renamed from: com.sec.chaton.smsplugin.ui.h */
/* loaded from: classes.dex */
class C4280h implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ BasicSlideEditorView f15660a;

    C4280h(BasicSlideEditorView basicSlideEditorView) {
        this.f15660a = basicSlideEditorView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f15660a.f14744e && this.f15660a.f14745f != null) {
            this.f15660a.f14745f.mo16484a(charSequence.toString());
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
