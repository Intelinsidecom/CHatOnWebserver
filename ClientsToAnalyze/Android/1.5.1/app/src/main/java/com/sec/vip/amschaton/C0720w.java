package com.sec.vip.amschaton;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.sec.vip.amschaton.w */
/* loaded from: classes.dex */
class C0720w implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ TextInputDialog f4354a;

    C0720w(TextInputDialog textInputDialog) {
        this.f4354a = textInputDialog;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int iIndexOf = editable.toString().indexOf("\n");
        if (iIndexOf != -1) {
            editable.delete(iIndexOf, iIndexOf + 1);
        }
        TextInputDialog.m4175c(editable.toString());
        if (this.f4354a.f4178d != null) {
            for (int i = 0; i < editable.toString().length(); i++) {
                if (this.f4354a.f4178d.indexOf(editable.toString().charAt(i)) != -1) {
                    editable.delete(i, i + 1);
                }
            }
        }
        int iM4175c = TextInputDialog.m4175c(editable.toString());
        while (iM4175c > this.f4354a.f4179e) {
            editable.delete(editable.length() - 1, editable.length());
            iM4175c = TextInputDialog.m4175c(editable.toString());
        }
        this.f4354a.f4176b.setText(String.format("(%d/%d)", Integer.valueOf(iM4175c), Integer.valueOf(this.f4354a.f4179e)));
        this.f4354a.m4177c();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
