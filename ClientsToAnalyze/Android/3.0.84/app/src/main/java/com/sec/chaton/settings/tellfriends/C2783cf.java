package com.sec.chaton.settings.tellfriends;

import android.text.InputFilter;
import android.text.Spanned;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;
import java.io.UnsupportedEncodingException;

/* compiled from: WeiboTextInputLayout.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cf */
/* loaded from: classes.dex */
class C2783cf implements InputFilter {

    /* renamed from: a */
    protected int f10214a;

    /* renamed from: b */
    final /* synthetic */ WeiboTextInputLayout f10215b;

    /* renamed from: c */
    private String f10216c;

    public C2783cf(WeiboTextInputLayout weiboTextInputLayout, int i, String str) {
        this.f10215b = weiboTextInputLayout;
        this.f10214a = i;
        this.f10216c = str;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String strSubstring;
        String string = spanned.subSequence(0, i3).toString();
        String string2 = charSequence.subSequence(i, i2).toString();
        String string3 = spanned.subSequence(i4, spanned.length()).toString();
        boolean z = false;
        String str = new String();
        if (m9925a(string + string2 + string3) <= this.f10214a) {
            strSubstring = null;
        } else {
            z = true;
            strSubstring = str;
            for (int length = string2.length() - 1; length >= 0; length--) {
                strSubstring = string2.substring(0, length);
                if (m9925a(string + strSubstring + string3) <= this.f10214a) {
                    break;
                }
            }
        }
        if (z) {
            if (this.f10215b.f10076g == null) {
                this.f10215b.f10076g = C3641ai.m13210a(this.f10215b.f10071b, R.string.toast_text_max_Length, 0);
            } else {
                this.f10215b.f10076g.setText(R.string.toast_text_max_Length);
            }
            this.f10215b.f10076g.show();
            this.f10215b.f10072c.setText(String.format("(%d/%d)", Integer.valueOf(m9925a(strSubstring) + m9925a(spanned.toString())), Integer.valueOf(this.f10215b.f10075f)));
        }
        return strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m9925a(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        try {
            return str.getBytes(this.f10216c).length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
