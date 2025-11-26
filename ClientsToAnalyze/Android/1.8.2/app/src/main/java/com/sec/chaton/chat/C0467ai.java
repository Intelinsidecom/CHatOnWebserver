package com.sec.chaton.chat;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C2153y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ai */
/* loaded from: classes.dex */
class C0467ai implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1935a;

    C0467ai(ChatFragment chatFragment) {
        this.f1935a = chatFragment;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() != 2000) {
            if (this.f1935a.f1797aL && charSequence.toString().replaceAll(" ", "").replaceAll("\n", "").length() > 0 && !this.f1935a.f1845bH.isEnabled()) {
                this.f1935a.f1845bH.setEnabled(true);
                return;
            }
            if (charSequence.toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
                if (this.f1935a.f1784Y) {
                    this.f1935a.f1845bH.setEnabled(true);
                    this.f1935a.f1845bH.setShadowLayer(0.0f, 1.0f, 1.0f, R.color.chat_send_button_enable);
                    return;
                } else {
                    this.f1935a.f1845bH.setEnabled(false);
                    this.f1935a.f1845bH.setShadowLayer(0.0f, 1.0f, 1.0f, R.color.chat_send_button_disable);
                    return;
                }
            }
            return;
        }
        C2153y.m7535a(this.f1935a.getActivity(), R.string.toast_text_max_Length, 0).show();
        if (!this.f1935a.f1845bH.isEnabled()) {
            this.f1935a.f1845bH.setEnabled(true);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
