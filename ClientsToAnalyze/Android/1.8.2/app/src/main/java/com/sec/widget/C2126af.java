package com.sec.widget;

import android.text.InputFilter;
import android.text.LoginFilter;
import android.text.Spanned;
import android.widget.EditText;

/* compiled from: RemoveCharsFilter.java */
/* renamed from: com.sec.widget.af */
/* loaded from: classes.dex */
public class C2126af extends LoginFilter.PasswordFilterGMail {

    /* renamed from: a */
    private char[] f7767a;

    /* renamed from: b */
    private InterfaceC2128ah f7768b;

    private C2126af(char[] cArr, InterfaceC2128ah interfaceC2128ah) {
        this.f7767a = cArr;
        this.f7768b = interfaceC2128ah;
    }

    @Override // android.text.LoginFilter, android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i3, i4);
        if (charSequenceFilter != null && this.f7768b != null) {
            this.f7768b.mo7481a();
        }
        return charSequenceFilter;
    }

    @Override // android.text.LoginFilter.PasswordFilterGMail, android.text.LoginFilter
    public boolean isAllowed(char c) {
        for (int i = 0; i < this.f7767a.length; i++) {
            if (this.f7767a[i] == c) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static void m7480a(EditText editText, char[] cArr, int i) {
        InputFilter[] filters = editText.getFilters();
        InputFilter[] inputFilterArr = new InputFilter[filters == null ? 1 : filters.length + 1];
        for (int i2 = 0; i2 < inputFilterArr.length; i2++) {
            if (i2 == inputFilterArr.length - 1) {
                inputFilterArr[i2] = new C2126af(cArr, new C2127ag(editText, i));
            } else {
                inputFilterArr[i2] = filters[i2];
            }
        }
        editText.setFilters(inputFilterArr);
    }
}
