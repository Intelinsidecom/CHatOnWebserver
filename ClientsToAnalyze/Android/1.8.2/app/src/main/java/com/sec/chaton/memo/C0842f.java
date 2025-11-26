package com.sec.chaton.memo;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: WriteMemoActivity.java */
/* renamed from: com.sec.chaton.memo.f */
/* loaded from: classes.dex */
class C0842f implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ WriteMemoActivity f3093a;

    C0842f(WriteMemoActivity writeMemoActivity) {
        this.f3093a = writeMemoActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (GlobalApplication.m3265f()) {
            if (this.f3093a.f3067b.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
                this.f3093a.f3074n.findItem(R.id.actionbar_menu_done).setVisible(true).setEnabled(false);
            } else {
                this.f3093a.f3074n.findItem(R.id.actionbar_menu_done).setVisible(true).setEnabled(true);
            }
            if (this.f3093a.f3067b.length() < 1) {
                this.f3093a.f3074n.findItem(R.id.actionbar_menu_done).setVisible(true).setEnabled(false);
            }
        } else {
            if (this.f3093a.f3067b.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
                this.f3093a.f3068c.setEnabled(false);
            } else {
                this.f3093a.f3068c.setEnabled(true);
            }
            if (this.f3093a.f3067b.length() < 1) {
                this.f3093a.f3068c.setEnabled(false);
            }
        }
        if (this.f3093a.f3067b.length() >= 140) {
            Toast.makeText(this.f3093a.f3066a, R.string.setting_input_length_exceed, 1).show();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
