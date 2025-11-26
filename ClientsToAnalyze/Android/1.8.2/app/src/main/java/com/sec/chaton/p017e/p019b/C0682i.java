package com.sec.chaton.p017e.p019b;

import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.p018a.C0658b;
import java.util.ArrayList;

/* compiled from: BuddyGroupRemoveBuddyTask.java */
/* renamed from: com.sec.chaton.e.b.i */
/* loaded from: classes.dex */
public class C0682i extends AbstractC0674a {

    /* renamed from: b */
    private int f2578b;

    /* renamed from: c */
    private ArrayList f2579c;

    public C0682i(InterfaceC0677d interfaceC0677d, int i, ArrayList arrayList) {
        super(interfaceC0677d, new Handler(Looper.getMainLooper()));
        this.f2578b = i;
        this.f2579c = arrayList;
    }

    @Override // com.sec.chaton.p017e.p019b.AbstractC0674a
    /* renamed from: a */
    public Object mo3098a() {
        C0658b.m2993b(GlobalApplication.m3260b().getContentResolver(), this.f2578b, this.f2579c);
        return true;
    }
}
