package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1793y;
import java.util.LinkedHashMap;

/* compiled from: SetPrivacyTask.java */
/* renamed from: com.sec.chaton.d.a.bs */
/* loaded from: classes.dex */
public class C0578bs extends AbstractRunnableC0532a {

    /* renamed from: d */
    private String f2305d;

    /* renamed from: e */
    private boolean f2306e;

    public C0578bs(Handler handler, C0798h c0798h, String str, boolean z) {
        super(handler, c0798h);
        this.f2305d = str;
        this.f2306e = z;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1793y c1793y = new C1793y();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("privacy", this.f2305d);
        linkedHashMap.put("value", this.f2306e ? "true" : "false");
        String strM6112a = c1793y.m6112a((Object) linkedHashMap);
        C1786r.m6066e(strM6112a, getClass().getSimpleName());
        return strM6112a;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
    }
}
