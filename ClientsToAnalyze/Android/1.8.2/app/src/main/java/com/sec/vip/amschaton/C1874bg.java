package com.sec.vip.amschaton;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C2153y;

/* compiled from: TextInputDialog.java */
/* renamed from: com.sec.vip.amschaton.bg */
/* loaded from: classes.dex */
class C1874bg implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ DialogC1873bf f6851a;

    C1874bg(DialogC1873bf dialogC1873bf) {
        this.f6851a = dialogC1873bf;
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
        if (this.f6851a.f6846d != null) {
            sb.delete(0, sb.length());
            int length2 = string2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = string2.charAt(i2);
                if (this.f6851a.f6846d.indexOf(cCharAt2) == -1) {
                    sb.append(cCharAt2);
                } else {
                    z3 = true;
                }
            }
        }
        String string3 = sb.toString();
        if (DialogC1873bf.m6471c(sb.toString()) > this.f6851a.f6847e) {
            string3 = this.f6851a.m6477a(sb.toString(), this.f6851a.f6847e);
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
            if (this.f6851a.f6849g == null) {
                this.f6851a.f6849g = C2153y.m7535a(this.f6851a.getContext(), R.string.toast_text_max_Length, 0);
            } else {
                this.f6851a.f6849g.setText(R.string.toast_text_max_Length);
            }
            this.f6851a.f6849g.show();
        }
        this.f6851a.f6844b.setText(String.format("(%d/%d)", Integer.valueOf(DialogC1873bf.m6471c(string3)), Integer.valueOf(this.f6851a.f6847e)));
        this.f6851a.m6473c();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
