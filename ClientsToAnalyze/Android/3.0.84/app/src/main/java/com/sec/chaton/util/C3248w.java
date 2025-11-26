package com.sec.chaton.util;

import android.content.Context;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: ChatONLengthFilter.java */
/* renamed from: com.sec.chaton.util.w */
/* loaded from: classes.dex */
public class C3248w extends C3199bn {

    /* renamed from: a */
    private InterfaceC3200bo f11730a;

    /* renamed from: b */
    private Toast f11731b;

    public C3248w(Context context, int i) {
        super(i);
        this.f11731b = Toast.makeText(context, R.string.toast_text_max_Length, 0);
        this.f11730a = new C3249x(this);
        m11162a(this.f11730a);
    }
}
