package com.sec.vip.amschaton;

import android.text.InputFilter;
import android.text.Spanned;

/* compiled from: TextInputLayout.java */
/* renamed from: com.sec.vip.amschaton.bk */
/* loaded from: classes.dex */
class C1878bk implements InputFilter {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC1875bh f6867a;

    /* renamed from: b */
    private String f6868b;

    public C1878bk(ViewOnClickListenerC1875bh viewOnClickListenerC1875bh, String str) {
        this.f6867a = viewOnClickListenerC1875bh;
        this.f6868b = null;
        this.f6868b = str;
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
            if (i5 > this.f6867a.f6857f * 2) {
                break;
            }
        }
        String string2 = sb.toString();
        int length2 = string2.length() + i;
        if (this.f6868b != null) {
            sb.delete(0, sb.length());
            int length3 = string2.length();
            for (int i6 = 0; i6 < length3; i6++) {
                char cCharAt2 = string2.charAt(i6);
                if (this.f6868b.indexOf(cCharAt2) == -1) {
                    sb.append(cCharAt2);
                } else {
                    z = true;
                }
                if (i6 > this.f6867a.f6857f * 2) {
                    break;
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
