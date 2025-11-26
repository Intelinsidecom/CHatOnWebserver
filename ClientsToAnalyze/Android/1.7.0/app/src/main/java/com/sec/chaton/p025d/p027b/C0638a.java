package com.sec.chaton.p025d.p027b;

import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.p026a.C0622b;
import java.util.Collection;

/* compiled from: BuddyGroupAddBuddyTask.java */
/* renamed from: com.sec.chaton.d.b.a */
/* loaded from: classes.dex */
public class C0638a extends AbstractC0647j {

    /* renamed from: a */
    private int f2217a;

    /* renamed from: b */
    private Collection f2218b;

    /* renamed from: c */
    private boolean f2219c;

    public C0638a(InterfaceC0641d interfaceC0641d, int i, Collection collection, boolean z) {
        super(interfaceC0641d, new Handler(Looper.getMainLooper()));
        this.f2217a = i;
        this.f2218b = collection;
        this.f2219c = z;
    }

    @Override // com.sec.chaton.p025d.p027b.AbstractC0647j
    /* renamed from: a */
    public Object mo2950a() {
        C0622b.m2844a(GlobalApplication.m3100a().getContentResolver(), this.f2217a, this.f2218b, this.f2219c);
        return true;
    }
}
