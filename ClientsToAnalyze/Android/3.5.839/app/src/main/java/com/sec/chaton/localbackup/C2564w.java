package com.sec.chaton.localbackup;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C5179v;

/* compiled from: SecretKeyView.java */
/* renamed from: com.sec.chaton.localbackup.w */
/* loaded from: classes.dex */
class C2564w implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ SecretKeyView f9192a;

    C2564w(SecretKeyView secretKeyView) {
        this.f9192a = secretKeyView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f9192a.f9014i = this.f9192a.f9008c.getText().toString();
        if (this.f9192a.f9016k) {
            if (this.f9192a.f9014i.replaceAll(" ", "").replaceAll("\n", "").length() <= 0 || this.f9192a.f9014i.length() < 8) {
                this.f9192a.f9009d.setVisibility(0);
            } else {
                if (this.f9192a.f9014i.length() >= 16) {
                    C5179v.m19811a(this.f9192a.f9023r, String.format(this.f9192a.f9023r.getString(R.string.maximum_characters), 16), 1).show();
                }
                this.f9192a.f9009d.setVisibility(8);
            }
            if (this.f9192a.f9008c.length() < 8 || this.f9192a.f9011f.length() <= 0) {
                this.f9192a.m10853a(false);
                return;
            } else {
                this.f9192a.m10853a(true);
                return;
            }
        }
        if (this.f9192a.f9008c.length() > 0) {
            this.f9192a.m10853a(true);
        } else {
            this.f9192a.m10853a(false);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
