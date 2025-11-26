package com.sec.vip.amschaton;

import android.text.InputFilter;
import android.text.Spanned;

/* compiled from: TextInputLayout.java */
/* renamed from: com.sec.vip.amschaton.bo */
/* loaded from: classes.dex */
class C3440bo implements InputFilter {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC3437bl f12590a;

    /* renamed from: b */
    private String f12591b;

    /* synthetic */ C3440bo(ViewOnClickListenerC3437bl viewOnClickListenerC3437bl, String str, C3438bm c3438bm) {
        this(viewOnClickListenerC3437bl, str);
    }

    private C3440bo(ViewOnClickListenerC3437bl viewOnClickListenerC3437bl, String str) {
        this.f12590a = viewOnClickListenerC3437bl;
        this.f12591b = null;
        this.f12591b = str;
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
            if (i5 > this.f12590a.f12580f * 2) {
                break;
            }
        }
        String string2 = sb.toString();
        int length2 = string2.length() + i;
        if (this.f12591b != null) {
            sb.delete(0, sb.length());
            int length3 = string2.length();
            for (int i6 = 0; i6 < length3; i6++) {
                char cCharAt2 = string2.charAt(i6);
                if (this.f12591b.indexOf(cCharAt2) == -1) {
                    sb.append(cCharAt2);
                } else {
                    z = true;
                }
                if (i6 > this.f12590a.f12580f * 2) {
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
