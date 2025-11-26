package com.sec.chaton.smsplugin.p112ui;

import android.text.Annotation;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;

/* compiled from: RecipientsEditor.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ha */
/* loaded from: classes.dex */
class C4281ha implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RecipientsEditor f15661a;

    /* renamed from: b */
    private Annotation[] f15662b;

    C4281ha(RecipientsEditor recipientsEditor) {
        this.f15661a = recipientsEditor;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f15662b = (Annotation[]) ((Spanned) charSequence).getSpans(i, i + i2, Annotation.class);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (i2 == 0 && i3 == 1) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == ',' || cCharAt == ';') {
                this.f15661a.f15078c = cCharAt;
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.f15662b != null) {
            for (Annotation annotation : this.f15662b) {
                editable.removeSpan(annotation);
            }
        }
        this.f15662b = null;
    }
}
