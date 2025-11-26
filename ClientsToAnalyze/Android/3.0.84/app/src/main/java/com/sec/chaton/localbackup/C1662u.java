package com.sec.chaton.localbackup;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: SecretKeyView.java */
/* renamed from: com.sec.chaton.localbackup.u */
/* loaded from: classes.dex */
class C1662u implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ SecretKeyView f6147a;

    C1662u(SecretKeyView secretKeyView) {
        this.f6147a = secretKeyView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f6147a.f5972i = this.f6147a.f5966c.getText().toString();
        if (this.f6147a.f5974k) {
            if (this.f6147a.f5972i.replaceAll(" ", "").replaceAll("\n", "").length() <= 0 || this.f6147a.f5972i.length() < 8) {
                this.f6147a.f5967d.setVisibility(0);
            } else {
                if (this.f6147a.f5972i.length() >= 16) {
                    C3641ai.m13211a(this.f6147a.f5981r, String.format(this.f6147a.f5981r.getString(R.string.maximum_characters), 16), 1).show();
                }
                this.f6147a.f5967d.setVisibility(8);
            }
            if (this.f6147a.f5966c.length() < 8 || this.f6147a.f5969f.length() <= 0) {
                this.f6147a.m6825a(false);
                return;
            } else {
                this.f6147a.m6825a(true);
                return;
            }
        }
        if (this.f6147a.f5966c.length() > 0) {
            this.f6147a.m6825a(true);
        } else {
            this.f6147a.m6825a(false);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
