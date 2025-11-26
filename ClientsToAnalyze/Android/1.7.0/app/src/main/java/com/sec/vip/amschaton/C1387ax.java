package com.sec.vip.amschaton;

import android.text.InputFilter;
import android.text.Spanned;

/* compiled from: TextInputLayout.java */
/* renamed from: com.sec.vip.amschaton.ax */
/* loaded from: classes.dex */
class C1387ax implements InputFilter {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC1382as f4878a;

    /* renamed from: b */
    private String f4879b;

    public C1387ax(ViewOnClickListenerC1382as viewOnClickListenerC1382as, String str) {
        this.f4878a = viewOnClickListenerC1382as;
        this.f4879b = null;
        this.f4879b = str;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        String string = charSequence.toString();
        int length = string.length();
        boolean z = false;
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = string.charAt(i5);
            if (cCharAt != '\n') {
                sb.append(cCharAt);
            } else {
                z = true;
            }
        }
        String string2 = sb.toString();
        int length2 = string2.length() + i;
        if (this.f4879b != null) {
            sb.delete(0, sb.length());
            int length3 = string2.length();
            for (int i6 = 0; i6 < length3; i6++) {
                char cCharAt2 = string2.charAt(i6);
                if (this.f4879b.indexOf(cCharAt2) == -1) {
                    sb.append(cCharAt2);
                } else {
                    z = true;
                }
            }
        }
        String string3 = sb.toString();
        int length4 = string3.length() + i;
        if (z) {
            return string3;
        }
        return null;
    }
}
