package com.sec.vip.amschaton;

import android.text.InputFilter;
import android.text.Spanned;
import com.sec.chaton.R;
import com.sec.widget.C2153y;
import java.io.UnsupportedEncodingException;

/* compiled from: TextInputLayout.java */
/* renamed from: com.sec.vip.amschaton.bj */
/* loaded from: classes.dex */
class C1877bj implements InputFilter {

    /* renamed from: a */
    protected int f6864a;

    /* renamed from: b */
    final /* synthetic */ ViewOnClickListenerC1875bh f6865b;

    /* renamed from: c */
    private String f6866c;

    public C1877bj(ViewOnClickListenerC1875bh viewOnClickListenerC1875bh, int i, String str) {
        this.f6865b = viewOnClickListenerC1875bh;
        this.f6864a = i;
        this.f6866c = str;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String strSubstring;
        String string = spanned.subSequence(0, i3).toString();
        String string2 = charSequence.subSequence(i, i2).toString();
        String string3 = spanned.subSequence(i4, spanned.length()).toString();
        boolean z = false;
        String str = new String();
        if (m6498a(string + string2 + string3) <= this.f6864a) {
            strSubstring = null;
        } else {
            z = true;
            strSubstring = str;
            for (int length = string2.length() - 1; length >= 0; length--) {
                strSubstring = string2.substring(0, length);
                if (m6498a(string + strSubstring + string3) <= this.f6864a) {
                    break;
                }
            }
        }
        if (z) {
            if (this.f6865b.f6858g == null) {
                this.f6865b.f6858g = C2153y.m7535a(this.f6865b.f6853b, R.string.toast_text_max_Length, 0);
            } else {
                this.f6865b.f6858g.setText(R.string.toast_text_max_Length);
            }
            this.f6865b.f6858g.show();
            this.f6865b.f6854c.setText(String.format("(%d/%d)", Integer.valueOf(m6498a(strSubstring) + m6498a(spanned.toString())), Integer.valueOf(this.f6865b.f6857f)));
        }
        this.f6865b.m6487d();
        return strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m6498a(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        try {
            return str.getBytes(this.f6866c).length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
