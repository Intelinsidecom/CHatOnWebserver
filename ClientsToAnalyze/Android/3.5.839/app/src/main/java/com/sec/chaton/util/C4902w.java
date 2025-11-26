package com.sec.chaton.util;

import android.content.Context;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: ChatONLengthFilter.java */
/* renamed from: com.sec.chaton.util.w */
/* loaded from: classes.dex */
public class C4902w extends C4849bn {

    /* renamed from: a */
    private InterfaceC4850bo f17868a;

    /* renamed from: b */
    private Toast f17869b;

    public C4902w(Context context, int i) {
        super(i);
        this.f17869b = Toast.makeText(context, R.string.toast_text_max_Length, 0);
        this.f17868a = new C4903x(this);
        m18337a(this.f17868a);
    }
}
