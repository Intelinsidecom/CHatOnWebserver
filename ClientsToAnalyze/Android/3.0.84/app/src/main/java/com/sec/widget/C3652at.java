package com.sec.widget;

import android.text.InputFilter;
import android.text.LoginFilter;
import android.text.Spanned;
import android.widget.EditText;
import com.sec.chaton.widget.ClearableEditText;

/* compiled from: RemoveCharsFilter.java */
/* renamed from: com.sec.widget.at */
/* loaded from: classes.dex */
public class C3652at extends LoginFilter.PasswordFilterGMail {

    /* renamed from: a */
    private char[] f13531a;

    /* renamed from: b */
    private InterfaceC3655aw f13532b;

    private C3652at(char[] cArr, InterfaceC3655aw interfaceC3655aw) {
        this.f13531a = cArr;
        this.f13532b = interfaceC3655aw;
    }

    @Override // android.text.LoginFilter, android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i3, i4);
        if (charSequenceFilter != null && this.f13532b != null) {
            this.f13532b.mo13221a();
        }
        return charSequenceFilter;
    }

    @Override // android.text.LoginFilter.PasswordFilterGMail, android.text.LoginFilter
    public boolean isAllowed(char c) {
        for (int i = 0; i < this.f13531a.length; i++) {
            if (this.f13531a[i] == c) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static void m13219a(EditText editText, char[] cArr, int i) {
        InputFilter[] filters = editText.getFilters();
        InputFilter[] inputFilterArr = new InputFilter[filters == null ? 1 : filters.length + 1];
        for (int i2 = 0; i2 < inputFilterArr.length; i2++) {
            if (i2 == inputFilterArr.length - 1) {
                inputFilterArr[i2] = new C3652at(cArr, new C3653au(editText, i));
            } else {
                inputFilterArr[i2] = filters[i2];
            }
        }
        editText.setFilters(inputFilterArr);
    }

    /* renamed from: a */
    public static void m13220a(ClearableEditText clearableEditText, char[] cArr, int i) {
        InputFilter[] inputFilterArrM11468b = clearableEditText.m11468b();
        InputFilter[] inputFilterArr = new InputFilter[inputFilterArrM11468b == null ? 1 : inputFilterArrM11468b.length + 1];
        for (int i2 = 0; i2 < inputFilterArr.length; i2++) {
            if (i2 == inputFilterArr.length - 1) {
                inputFilterArr[i2] = new C3652at(cArr, new C3654av(clearableEditText, i));
            } else {
                inputFilterArr[i2] = inputFilterArrM11468b[i2];
            }
        }
        clearableEditText.setFilters(inputFilterArr);
    }
}
