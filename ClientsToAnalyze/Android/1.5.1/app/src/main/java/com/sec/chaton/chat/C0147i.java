package com.sec.chaton.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.chat.i */
/* loaded from: classes.dex */
class C0147i implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f958a;

    C0147i(ChatFragment chatFragment) {
        this.f958a = chatFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() == 2000) {
            Toast.makeText(this.f958a.getActivity(), C0062R.string.toast_text_max_Length, 0).show();
        }
    }
}
