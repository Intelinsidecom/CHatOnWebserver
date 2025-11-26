package com.sec.vip.amschaton;

import android.text.InputFilter;
import android.text.Spanned;
import com.sec.chaton.R;
import com.sec.widget.C1619g;
import java.io.UnsupportedEncodingException;

/* compiled from: TextInputLayout.java */
/* renamed from: com.sec.vip.amschaton.n */
/* loaded from: classes.dex */
class C1549n implements InputFilter {

    /* renamed from: a */
    protected int f5383a;

    /* renamed from: b */
    final /* synthetic */ ViewOnClickListenerC1382as f5384b;

    /* renamed from: c */
    private String f5385c;

    public C1549n(ViewOnClickListenerC1382as viewOnClickListenerC1382as, int i, String str) {
        this.f5384b = viewOnClickListenerC1382as;
        this.f5383a = i;
        this.f5385c = str;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String strSubstring;
        String string = spanned.subSequence(0, i3).toString();
        String string2 = charSequence.subSequence(i, i2).toString();
        String string3 = spanned.subSequence(i4, spanned.length()).toString();
        boolean z = false;
        String str = new String();
        if (m5627a(string + string2 + string3) <= this.f5383a) {
            strSubstring = null;
        } else {
            z = true;
            strSubstring = str;
            for (int length = string2.length() - 1; length >= 0; length--) {
                strSubstring = string2.substring(0, length);
                if (m5627a(string + strSubstring + string3) <= this.f5383a) {
                    break;
                }
            }
        }
        if (z) {
            if (this.f5384b.f4844g == null) {
                this.f5384b.f4844g = C1619g.m5888a(this.f5384b.f4839b, R.string.toast_text_max_Length, 0);
            } else {
                this.f5384b.f4844g.setText(R.string.toast_text_max_Length);
            }
            this.f5384b.f4844g.show();
            this.f5384b.f4840c.setText(String.format("(%d/%d)", Integer.valueOf(m5627a(strSubstring) + m5627a(spanned.toString())), Integer.valueOf(this.f5384b.f4843f)));
        }
        this.f5384b.m4954d();
        return strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m5627a(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        try {
            return str.getBytes(this.f5385c).length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
