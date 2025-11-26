package com.sec.chaton.p027e.p029b;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.common.CommonApplication;

/* compiled from: BuddyUpdateNameTask.java */
/* renamed from: com.sec.chaton.e.b.k */
/* loaded from: classes.dex */
public class C1420k extends AbstractC1410a {

    /* renamed from: c */
    private String f5266c;

    /* renamed from: d */
    private String f5267d;

    /* renamed from: e */
    private int f5268e;

    public C1420k(InterfaceC1413d interfaceC1413d, String str, String str2, int i) {
        super(interfaceC1413d, new Handler(Looper.getMainLooper()));
        this.f5267d = str;
        this.f5268e = i;
        this.f5266c = str2;
    }

    @Override // com.sec.chaton.p027e.p029b.AbstractC1410a
    /* renamed from: a */
    public Object mo6263a() {
        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
        if (this.f5268e == 2) {
            return Integer.valueOf(C1360d.m6017a(contentResolver, this.f5266c, this.f5267d));
        }
        return null;
    }
}
