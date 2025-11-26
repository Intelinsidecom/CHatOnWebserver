package com.sec.vip.amschaton;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: TextInputDialog.java */
/* renamed from: com.sec.vip.amschaton.bk */
/* loaded from: classes.dex */
class C3436bk implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ DialogC3435bj f12574a;

    C3436bk(DialogC3435bj dialogC3435bj) {
        this.f12574a = dialogC3435bj;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        boolean z2;
        String string = editable.toString();
        StringBuilder sb = new StringBuilder();
        int length = string.length();
        boolean z3 = false;
        for (int i = 0; i < length; i++) {
            char cCharAt = string.charAt(i);
            if (cCharAt != '\n') {
                sb.append(cCharAt);
            } else {
                z3 = true;
            }
        }
        String string2 = sb.toString();
        if (this.f12574a.f12569d != null) {
            sb.delete(0, sb.length());
            int length2 = string2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = string2.charAt(i2);
                if (this.f12574a.f12569d.indexOf(cCharAt2) == -1) {
                    sb.append(cCharAt2);
                } else {
                    z3 = true;
                }
            }
        }
        String string3 = sb.toString();
        if (DialogC3435bj.m12293c(sb.toString()) > this.f12574a.f12570e) {
            string3 = this.f12574a.m12299a(sb.toString(), this.f12574a.f12570e);
            z = true;
            z2 = true;
        } else {
            z = z3;
            z2 = false;
        }
        if (z) {
            editable.clear();
            editable.insert(0, string3);
        }
        if (z2) {
            if (this.f12574a.f12572g == null) {
                this.f12574a.f12572g = C3641ai.m13210a(this.f12574a.getContext(), R.string.toast_text_max_Length, 0);
            } else {
                this.f12574a.f12572g.setText(R.string.toast_text_max_Length);
            }
            this.f12574a.f12572g.show();
        }
        this.f12574a.f12567b.setText(String.format("(%d/%d)", Integer.valueOf(DialogC3435bj.m12293c(string3)), Integer.valueOf(this.f12574a.f12570e)));
        this.f12574a.m12295c();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
