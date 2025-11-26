package com.sec.vip.amschaton;

import android.text.InputFilter;
import android.text.Spanned;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;
import java.io.UnsupportedEncodingException;

/* compiled from: TextInputLayout.java */
/* renamed from: com.sec.vip.amschaton.bn */
/* loaded from: classes.dex */
class C3439bn implements InputFilter {

    /* renamed from: a */
    protected int f12587a;

    /* renamed from: b */
    final /* synthetic */ ViewOnClickListenerC3437bl f12588b;

    /* renamed from: c */
    private String f12589c;

    public C3439bn(ViewOnClickListenerC3437bl viewOnClickListenerC3437bl, int i, String str) {
        this.f12588b = viewOnClickListenerC3437bl;
        this.f12587a = i;
        this.f12589c = str;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String strSubstring;
        String string = spanned.subSequence(0, i3).toString();
        String string2 = charSequence.subSequence(i, i2).toString();
        String string3 = spanned.subSequence(i4, spanned.length()).toString();
        boolean z = false;
        String str = new String();
        if (m12320a(string + string2 + string3) <= this.f12587a) {
            strSubstring = null;
        } else {
            z = true;
            strSubstring = str;
            for (int length = string2.length() - 1; length >= 0; length--) {
                strSubstring = string2.substring(0, length);
                if (m12320a(string + strSubstring + string3) <= this.f12587a) {
                    break;
                }
            }
        }
        if (z) {
            if (this.f12588b.f12581g == null) {
                this.f12588b.f12581g = C3641ai.m13210a(this.f12588b.f12576b, R.string.toast_text_max_Length, 0);
            } else {
                this.f12588b.f12581g.setText(R.string.toast_text_max_Length);
            }
            this.f12588b.f12581g.show();
            this.f12588b.f12577c.setText(String.format("(%d/%d)", Integer.valueOf(m12320a(strSubstring) + m12320a(spanned.toString())), Integer.valueOf(this.f12588b.f12580f)));
        }
        this.f12588b.m12309d();
        return strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m12320a(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        try {
            return str.getBytes(this.f12589c).length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
