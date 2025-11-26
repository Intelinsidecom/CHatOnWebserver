package com.samsung.sdraw;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;

/* renamed from: com.samsung.sdraw.ad */
/* loaded from: classes.dex */
class C0991ad implements InputFilter {

    /* renamed from: a */
    final Context f1438a;

    /* renamed from: b */
    private int f1439b;

    public C0991ad(Context context, int i) {
        this.f1438a = context;
        this.f1439b = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        int length = this.f1439b - (dest.length() - (dend - dstart));
        if (length <= 0) {
            return "";
        }
        if (length >= end - start) {
            return null;
        }
        return source.subSequence(start, length + start);
    }
}
