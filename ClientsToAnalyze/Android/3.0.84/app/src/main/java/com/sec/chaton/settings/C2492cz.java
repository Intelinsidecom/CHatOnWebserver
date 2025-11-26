package com.sec.chaton.settings;

import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.cz */
/* loaded from: classes.dex */
class C2492cz implements InputFilter {

    /* renamed from: c */
    boolean f9380c;

    /* renamed from: d */
    final /* synthetic */ AlertDialogC2481co f9381d;

    /* renamed from: a */
    int f9378a = 0;

    /* renamed from: b */
    int f9379b = 23;

    /* renamed from: e */
    private final char[] f9382e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 1632, 1633, 1634, 1635, 1636, 1637, 1638, 1639, 1640, 1641, 1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785};

    public C2492cz(AlertDialogC2481co alertDialogC2481co, boolean z) {
        this.f9381d = alertDialogC2481co;
        this.f9380c = false;
        this.f9380c = z;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        CharSequence charSequenceM9256a = m9256a(charSequence, i, i2, spanned, i3, i4);
        if (charSequenceM9256a == null) {
            charSequenceM9256a = charSequence.subSequence(i, i2);
        }
        String str = String.valueOf(spanned.subSequence(0, i3)) + ((Object) charSequenceM9256a) + ((Object) spanned.subSequence(i4, spanned.length()));
        if ("".equals(str) || str.length() > 2) {
            return "";
        }
        if (!this.f9380c) {
            this.f9379b = 23;
        } else {
            this.f9379b = 59;
        }
        if (Integer.parseInt(str) > this.f9379b) {
            return "";
        }
        return charSequenceM9256a;
    }

    /* renamed from: a */
    private CharSequence m9256a(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5 = i;
        while (i5 < i2 && m9257a(this.f9382e, charSequence.charAt(i5))) {
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
            if (!m9257a(this.f9382e, charSequence.charAt(i7))) {
                spannableStringBuilder.delete(i7, i7 + 1);
            }
        }
        return spannableStringBuilder;
    }

    /* renamed from: a */
    private boolean m9257a(char[] cArr, char c) {
        for (int length = cArr.length - 1; length >= 0; length--) {
            if (cArr[length] == c) {
                return true;
            }
        }
        return false;
    }
}
