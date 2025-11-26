package com.sec.chaton.memo;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.memo.e */
/* loaded from: classes.dex */
class C0250e implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ WriteMemoActivity f1952a;

    C0250e(WriteMemoActivity writeMemoActivity) {
        this.f1952a = writeMemoActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f1952a.f1939b.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
            this.f1952a.f1940c.setEnabled(false);
        } else {
            this.f1952a.f1940c.setEnabled(true);
        }
        if (this.f1952a.f1939b.length() < 1) {
            this.f1952a.f1940c.setEnabled(false);
        }
        if (this.f1952a.f1939b.length() >= 140) {
            Toast.makeText(this.f1952a.f1938a, C0062R.string.setting_input_length_exceed, 1).show();
        }
    }
}
