package com.sec.chaton.chat;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C1619g;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ad */
/* loaded from: classes.dex */
class C0528ad implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1878a;

    C0528ad(ChatFragment chatFragment) {
        this.f1878a = chatFragment;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() != 2000 || !this.f1878a.f1832bd.isEnabled()) {
            if (this.f1878a.f1816az && charSequence.toString().replaceAll(" ", "").replaceAll("\n", "").length() > 0 && !this.f1878a.f1832bd.isEnabled()) {
                this.f1878a.f1832bd.setEnabled(true);
                return;
            } else {
                if (charSequence.toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
                    this.f1878a.f1832bd.setEnabled(false);
                    return;
                }
                return;
            }
        }
        C1619g.m5888a(this.f1878a.getActivity(), R.string.toast_text_max_Length, 0).show();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
