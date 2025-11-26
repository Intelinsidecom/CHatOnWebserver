package com.sec.widget;

import android.text.InputFilter;
import android.text.LoginFilter;
import android.text.Spanned;
import android.widget.EditText;

/* compiled from: RemoveCharsFilter.java */
/* renamed from: com.sec.widget.ac */
/* loaded from: classes.dex */
public class C1606ac extends LoginFilter.PasswordFilterGMail {

    /* renamed from: a */
    private char[] f5698a;

    /* renamed from: b */
    private InterfaceC1633u f5699b;

    private C1606ac(char[] cArr, InterfaceC1633u interfaceC1633u) {
        this.f5698a = cArr;
        this.f5699b = interfaceC1633u;
    }

    @Override // android.text.LoginFilter, android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i3, i4);
        if (charSequenceFilter != null && this.f5699b != null) {
            this.f5699b.mo5921a();
        }
        return charSequenceFilter;
    }

    @Override // android.text.LoginFilter.PasswordFilterGMail, android.text.LoginFilter
    public boolean isAllowed(char c) {
        for (int i = 0; i < this.f5698a.length; i++) {
            if (this.f5698a[i] == c) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static void m5880a(EditText editText, char[] cArr, int i) {
        InputFilter[] filters = editText.getFilters();
        InputFilter[] inputFilterArr = new InputFilter[filters == null ? 1 : filters.length + 1];
        for (int i2 = 0; i2 < inputFilterArr.length; i2++) {
            if (i2 == inputFilterArr.length - 1) {
                inputFilterArr[i2] = new C1606ac(cArr, new C1635w(editText, i));
            } else {
                inputFilterArr[i2] = filters[i2];
            }
        }
        editText.setFilters(inputFilterArr);
    }
}
