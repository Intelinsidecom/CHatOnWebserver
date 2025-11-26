package com.sec.chaton.p017e.p019b;

import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.p018a.C0658b;
import java.util.ArrayList;

/* compiled from: BuddyGroupAddBuddyTask.java */
/* renamed from: com.sec.chaton.e.b.f */
/* loaded from: classes.dex */
public class C0679f extends AbstractC0674a {

    /* renamed from: b */
    private int f2571b;

    /* renamed from: c */
    private ArrayList f2572c;

    public C0679f(InterfaceC0677d interfaceC0677d, int i, ArrayList arrayList) {
        super(interfaceC0677d, new Handler(Looper.getMainLooper()));
        this.f2571b = i;
        this.f2572c = arrayList;
    }

    @Override // com.sec.chaton.p017e.p019b.AbstractC0674a
    /* renamed from: a */
    public Object mo3098a() {
        C0658b.m2990a(GlobalApplication.m3260b().getContentResolver(), this.f2571b, this.f2572c);
        return true;
    }
}
