package com.sec.chaton.p057e.p059b;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.common.CommonApplication;

/* compiled from: BuddyUpdateNameTask.java */
/* renamed from: com.sec.chaton.e.b.k */
/* loaded from: classes.dex */
public class C2250k extends AbstractC2240a {

    /* renamed from: c */
    private String f8006c;

    /* renamed from: d */
    private String f8007d;

    /* renamed from: e */
    private int f8008e;

    public C2250k(InterfaceC2243d interfaceC2243d, String str, String str2, int i) {
        super(interfaceC2243d, new Handler(Looper.getMainLooper()));
        this.f8007d = str;
        this.f8008e = i;
        this.f8006c = str2;
    }

    @Override // com.sec.chaton.p057e.p059b.AbstractC2240a
    /* renamed from: a */
    public Object mo8896a() {
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        if (this.f8008e == 2) {
            return Integer.valueOf(C2190d.m9799a(contentResolver, this.f8006c, this.f8007d));
        }
        return null;
    }
}
