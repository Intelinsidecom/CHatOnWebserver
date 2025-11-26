package com.sec.chaton.sns.p115ui;

import android.text.InputFilter;
import android.text.Spanned;
import java.io.UnsupportedEncodingException;

/* compiled from: SnsMessageFragment.java */
/* renamed from: com.sec.chaton.sns.ui.ac */
/* loaded from: classes.dex */
public class C4449ac implements InputFilter {

    /* renamed from: a */
    protected int f16090a;

    /* renamed from: b */
    final /* synthetic */ SnsMessageFragment f16091b;

    /* renamed from: c */
    private String f16092c;

    public C4449ac(SnsMessageFragment snsMessageFragment, int i, String str) {
        this.f16091b = snsMessageFragment;
        this.f16090a = i;
        this.f16092c = str;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String strSubstring;
        String string = spanned.subSequence(0, i3).toString();
        String string2 = charSequence.subSequence(i, i2).toString();
        String string3 = spanned.subSequence(i4, spanned.length()).toString();
        boolean z = false;
        String str = new String();
        if (m16935a(string + string2 + string3) <= this.f16090a) {
            strSubstring = null;
        } else {
            z = true;
            strSubstring = str;
            for (int length = string2.length() - 1; length >= 0; length--) {
                strSubstring = string2.substring(0, length);
                if (m16935a(string + strSubstring + string3) <= this.f16090a) {
                    break;
                }
            }
        }
        if (z) {
            this.f16091b.m16900b(m16935a(strSubstring) + m16935a(spanned.toString()));
        }
        return strSubstring;
    }

    /* renamed from: a */
    public int m16935a(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        try {
            return str.getBytes(this.f16092c).length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
