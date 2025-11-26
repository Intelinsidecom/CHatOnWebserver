package com.sec.chaton.p017e.p019b;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.p018a.C0657a;

/* compiled from: BuddyUpdateNameTask.java */
/* renamed from: com.sec.chaton.e.b.j */
/* loaded from: classes.dex */
public class C0683j extends AbstractC0674a {

    /* renamed from: b */
    private String f2580b;

    /* renamed from: c */
    private String f2581c;

    /* renamed from: d */
    private int f2582d;

    public C0683j(InterfaceC0677d interfaceC0677d, String str, String str2, int i) {
        super(interfaceC0677d, new Handler(Looper.getMainLooper()));
        this.f2581c = str;
        this.f2582d = i;
        this.f2580b = str2;
    }

    @Override // com.sec.chaton.p017e.p019b.AbstractC0674a
    /* renamed from: a */
    public Object mo3098a() {
        ContentResolver contentResolver = GlobalApplication.m3260b().getContentResolver();
        if (this.f2582d == 2) {
            return Integer.valueOf(C0657a.m2972a(contentResolver, this.f2580b, this.f2581c));
        }
        return null;
    }
}
