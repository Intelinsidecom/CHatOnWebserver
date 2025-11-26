package com.sec.chaton.settings.tellfriends.common;

import android.text.InputFilter;
import android.text.Spanned;
import java.io.UnsupportedEncodingException;

/* compiled from: SnsMessageFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.common.t */
/* loaded from: classes.dex */
public class C2804t implements InputFilter {

    /* renamed from: a */
    protected int f10315a;

    /* renamed from: b */
    final /* synthetic */ SnsMessageFragment f10316b;

    /* renamed from: c */
    private String f10317c;

    public C2804t(SnsMessageFragment snsMessageFragment, int i, String str) {
        this.f10316b = snsMessageFragment;
        this.f10315a = i;
        this.f10317c = str;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String strSubstring;
        String string = spanned.subSequence(0, i3).toString();
        String string2 = charSequence.subSequence(i, i2).toString();
        String string3 = spanned.subSequence(i4, spanned.length()).toString();
        boolean z = false;
        String str = new String();
        if (m10025a(string + string2 + string3) <= this.f10315a) {
            strSubstring = null;
        } else {
            z = true;
            strSubstring = str;
            for (int length = string2.length() - 1; length >= 0; length--) {
                strSubstring = string2.substring(0, length);
                if (m10025a(string + strSubstring + string3) <= this.f10315a) {
                    break;
                }
            }
        }
        if (z) {
            this.f10316b.m9973b(m10025a(strSubstring) + m10025a(spanned.toString()));
        }
        return strSubstring;
    }

    /* renamed from: a */
    public int m10025a(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        try {
            return str.getBytes(this.f10317c).length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
