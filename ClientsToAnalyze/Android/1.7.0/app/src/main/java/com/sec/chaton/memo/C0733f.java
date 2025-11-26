package com.sec.chaton.memo;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C1619g;

/* compiled from: WriteMemoActivity.java */
/* renamed from: com.sec.chaton.memo.f */
/* loaded from: classes.dex */
class C0733f implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ WriteMemoActivity f2476a;

    C0733f(WriteMemoActivity writeMemoActivity) {
        this.f2476a = writeMemoActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f2476a.f2459b.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
            this.f2476a.f2464j.setButtonEnabled(false);
        } else {
            this.f2476a.f2464j.setButtonEnabled(true);
        }
        if (this.f2476a.f2459b.length() < 1) {
            this.f2476a.f2464j.setButtonEnabled(false);
        }
        if (charSequence.length() >= 140) {
            C1619g.m5888a(this.f2476a.f2458a, R.string.setting_input_length_exceed, 1).show();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
