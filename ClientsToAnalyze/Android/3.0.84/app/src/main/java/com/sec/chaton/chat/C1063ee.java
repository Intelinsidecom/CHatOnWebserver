package com.sec.chaton.chat;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.ee */
/* loaded from: classes.dex */
class C1063ee implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1060eb f4181a;

    C1063ee(AlertDialogC1060eb alertDialogC1060eb) {
        this.f4181a = alertDialogC1060eb;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String strValueOf = String.valueOf(charSequence);
        this.f4181a.f4175e.setMaxLength(30);
        if (charSequence.length() >= 30) {
            C3641ai.m13210a(this.f4181a.f4176f, R.string.setting_input_length_exceed, 1).show();
        }
        if (strValueOf.trim().length() > 0) {
            if (Build.VERSION.SDK_INT < 14) {
                this.f4181a.getButton(-1).setEnabled(true);
                return;
            } else {
                this.f4181a.getButton(-2).setEnabled(true);
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 14) {
            this.f4181a.getButton(-1).setEnabled(false);
        } else {
            this.f4181a.getButton(-2).setEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
