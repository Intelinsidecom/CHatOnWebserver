package com.sec.chaton.settings;

import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.dx */
/* loaded from: classes.dex */
class C3587dx implements InputFilter {

    /* renamed from: c */
    boolean f13106c;

    /* renamed from: d */
    final /* synthetic */ AlertDialogC3576dm f13107d;

    /* renamed from: a */
    int f13104a = 0;

    /* renamed from: b */
    int f13105b = 23;

    /* renamed from: e */
    private final char[] f13108e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 1632, 1633, 1634, 1635, 1636, 1637, 1638, 1639, 1640, 1641, 1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785};

    public C3587dx(AlertDialogC3576dm alertDialogC3576dm, boolean z) {
        this.f13107d = alertDialogC3576dm;
        this.f13106c = false;
        this.f13106c = z;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        CharSequence charSequenceM13896a = m13896a(charSequence, i, i2, spanned, i3, i4);
        if (charSequenceM13896a == null) {
            charSequenceM13896a = charSequence.subSequence(i, i2);
        }
        String str = String.valueOf(spanned.subSequence(0, i3)) + ((Object) charSequenceM13896a) + ((Object) spanned.subSequence(i4, spanned.length()));
        if ("".equals(str) || str.length() > 2) {
            return "";
        }
        if (!this.f13106c) {
            this.f13105b = 23;
        } else {
            this.f13105b = 59;
        }
        if (Integer.parseInt(str) > this.f13105b) {
            return "";
        }
        return charSequenceM13896a;
    }

    /* renamed from: a */
    private CharSequence m13896a(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5 = i;
        while (i5 < i2 && m13897a(this.f13108e, charSequence.charAt(i5))) {
            i5++;
        }
        if (i5 == i2) {
            return null;
        }
        if (i2 - i == 1) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence, i, i2);
        int i6 = i5 - i;
        for (int i7 = (i2 - i) - 1; i7 >= i6; i7--) {
            if (!m13897a(this.f13108e, charSequence.charAt(i7))) {
                spannableStringBuilder.delete(i7, i7 + 1);
            }
        }
        return spannableStringBuilder;
    }

    /* renamed from: a */
    private boolean m13897a(char[] cArr, char c2) {
        for (int length = cArr.length - 1; length >= 0; length--) {
            if (cArr[length] == c2) {
                return true;
            }
        }
        return false;
    }
}
