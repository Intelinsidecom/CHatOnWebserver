package com.sec.vip.amschaton;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C1619g;

/* compiled from: TextInputDialog.java */
/* renamed from: com.sec.vip.amschaton.u */
/* loaded from: classes.dex */
class C1556u implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ DialogC1379ap f5412a;

    C1556u(DialogC1379ap dialogC1379ap) {
        this.f5412a = dialogC1379ap;
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
        if (this.f5412a.f4826d != null) {
            sb.delete(0, sb.length());
            int length2 = string2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = string2.charAt(i2);
                if (this.f5412a.f4826d.indexOf(cCharAt2) == -1) {
                    sb.append(cCharAt2);
                } else {
                    z3 = true;
                }
            }
        }
        String string3 = sb.toString();
        if (DialogC1379ap.m4933c(sb.toString()) > this.f5412a.f4827e) {
            string3 = this.f5412a.m4939a(sb.toString(), this.f5412a.f4827e);
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
            if (this.f5412a.f4829g == null) {
                this.f5412a.f4829g = C1619g.m5888a(this.f5412a.getContext(), R.string.toast_text_max_Length, 0);
            } else {
                this.f5412a.f4829g.setText(R.string.toast_text_max_Length);
            }
            this.f5412a.f4829g.show();
        }
        this.f5412a.f4824b.setText(String.format("(%d/%d)", Integer.valueOf(DialogC1379ap.m4933c(string3)), Integer.valueOf(this.f5412a.f4827e)));
        this.f5412a.m4935c();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
