package com.sec.widget;

import android.text.InputFilter;
import android.text.LoginFilter;
import android.text.Spanned;
import android.widget.EditText;
import com.sec.chaton.widget.ClearableEditText;

/* compiled from: RemoveCharsFilter.java */
/* renamed from: com.sec.widget.ag */
/* loaded from: classes.dex */
public class C5144ag extends LoginFilter.PasswordFilterGMail {

    /* renamed from: a */
    private char[] f18838a;

    /* renamed from: b */
    private InterfaceC5147aj f18839b;

    private C5144ag(char[] cArr, InterfaceC5147aj interfaceC5147aj) {
        this.f18838a = cArr;
        this.f18839b = interfaceC5147aj;
    }

    @Override // android.text.LoginFilter, android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i3, i4);
        if (charSequenceFilter != null && this.f18839b != null) {
            this.f18839b.mo19711a();
        }
        return charSequenceFilter;
    }

    @Override // android.text.LoginFilter.PasswordFilterGMail, android.text.LoginFilter
    public boolean isAllowed(char c2) {
        for (int i = 0; i < this.f18838a.length; i++) {
            if (this.f18838a[i] == c2) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static void m19709a(EditText editText, char[] cArr, int i) {
        InputFilter[] filters = editText.getFilters();
        InputFilter[] inputFilterArr = new InputFilter[filters == null ? 1 : filters.length + 1];
        for (int i2 = 0; i2 < inputFilterArr.length; i2++) {
            if (i2 == inputFilterArr.length - 1) {
                inputFilterArr[i2] = new C5144ag(cArr, new C5145ah(editText, i));
            } else if (filters != null) {
                inputFilterArr[i2] = filters[i2];
            }
        }
        editText.setFilters(inputFilterArr);
    }

    /* renamed from: a */
    public static void m19710a(ClearableEditText clearableEditText, char[] cArr, int i) {
        InputFilter[] inputFilterArrM18662b = clearableEditText.m18662b();
        InputFilter[] inputFilterArr = new InputFilter[inputFilterArrM18662b == null ? 1 : inputFilterArrM18662b.length + 1];
        for (int i2 = 0; i2 < inputFilterArr.length; i2++) {
            if (i2 == inputFilterArr.length - 1) {
                inputFilterArr[i2] = new C5144ag(cArr, new C5146ai(clearableEditText, i));
            } else if (inputFilterArrM18662b != null) {
                inputFilterArr[i2] = inputFilterArrM18662b[i2];
            }
        }
        clearableEditText.setFilters(inputFilterArr);
    }
}
