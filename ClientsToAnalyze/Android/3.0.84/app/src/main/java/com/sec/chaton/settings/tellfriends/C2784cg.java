package com.sec.chaton.settings.tellfriends;

import android.text.InputFilter;
import android.text.Spanned;

/* compiled from: WeiboTextInputLayout.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cg */
/* loaded from: classes.dex */
class C2784cg implements InputFilter {

    /* renamed from: a */
    final /* synthetic */ WeiboTextInputLayout f10217a;

    /* renamed from: b */
    private String f10218b;

    public C2784cg(WeiboTextInputLayout weiboTextInputLayout, String str) {
        this.f10217a = weiboTextInputLayout;
        this.f10218b = null;
        this.f10218b = str;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        boolean z = false;
        StringBuilder sb = new StringBuilder();
        String string = charSequence.toString();
        int length = string.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = string.charAt(i5);
            if (cCharAt != '\n') {
                sb.append(cCharAt);
            }
        }
        String string2 = sb.toString();
        int length2 = string2.length() + i;
        if (this.f10218b != null) {
            sb.delete(0, sb.length());
            int length3 = string2.length();
            for (int i6 = 0; i6 < length3; i6++) {
                char cCharAt2 = string2.charAt(i6);
                if (this.f10218b.indexOf(cCharAt2) == -1) {
                    sb.append(cCharAt2);
                } else {
                    z = true;
                }
            }
        }
        String string3 = sb.toString();
        int length4 = string3.length() + i;
        if (z) {
            return string3;
        }
        return null;
    }
}
