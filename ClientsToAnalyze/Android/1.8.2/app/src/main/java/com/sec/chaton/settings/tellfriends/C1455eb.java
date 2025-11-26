package com.sec.chaton.settings.tellfriends;

import android.text.InputFilter;
import android.text.Spanned;
import com.sec.chaton.R;
import com.sec.widget.C2153y;
import java.io.UnsupportedEncodingException;

/* compiled from: WeiboTextInputLayout.java */
/* renamed from: com.sec.chaton.settings.tellfriends.eb */
/* loaded from: classes.dex */
class C1455eb implements InputFilter {

    /* renamed from: a */
    protected int f5359a;

    /* renamed from: b */
    final /* synthetic */ ViewOnClickListenerC1452dz f5360b;

    /* renamed from: c */
    private String f5361c;

    public C1455eb(ViewOnClickListenerC1452dz viewOnClickListenerC1452dz, int i, String str) {
        this.f5360b = viewOnClickListenerC1452dz;
        this.f5359a = i;
        this.f5361c = str;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String strSubstring;
        String string = spanned.subSequence(0, i3).toString();
        String string2 = charSequence.subSequence(i, i2).toString();
        String string3 = spanned.subSequence(i4, spanned.length()).toString();
        boolean z = false;
        String str = new String();
        if (m5195a(string + string2 + string3) <= this.f5359a) {
            strSubstring = null;
        } else {
            z = true;
            strSubstring = str;
            for (int length = string2.length() - 1; length >= 0; length--) {
                strSubstring = string2.substring(0, length);
                if (m5195a(string + strSubstring + string3) <= this.f5359a) {
                    break;
                }
            }
        }
        if (z) {
            if (this.f5360b.f5353g == null) {
                this.f5360b.f5353g = C2153y.m7535a(this.f5360b.f5348b, R.string.toast_text_max_Length, 0);
            } else {
                this.f5360b.f5353g.setText(R.string.toast_text_max_Length);
            }
            this.f5360b.f5353g.show();
            this.f5360b.f5349c.setText(String.format("(%d/%d)", Integer.valueOf(m5195a(strSubstring) + m5195a(spanned.toString())), Integer.valueOf(this.f5360b.f5352f)));
        }
        return strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m5195a(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        try {
            return str.getBytes(this.f5361c).length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
