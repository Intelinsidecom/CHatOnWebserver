package com.sec.chaton.p015d.p016a;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1793y;
import java.util.LinkedHashMap;

/* compiled from: VerifySMSTask.java */
/* renamed from: com.sec.chaton.d.a.bz */
/* loaded from: classes.dex */
public class C0585bz extends AbstractRunnableC0532a {

    /* renamed from: d */
    private String f2325d;

    /* renamed from: e */
    private String f2326e;

    /* renamed from: f */
    private String f2327f;

    /* renamed from: g */
    private Context f2328g;

    /* renamed from: h */
    private ContentResolver f2329h;

    public C0585bz(Handler handler, C0798h c0798h, String str, String str2, String str3) {
        super(handler, c0798h);
        this.f2325d = str;
        this.f2326e = str2;
        this.f2327f = str3;
        this.f2328g = GlobalApplication.m3260b();
        this.f2329h = this.f2328g.getContentResolver();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1793y c1793y = new C1793y();
        LinkedHashMap linkedHashMap = new LinkedHashMap(3);
        linkedHashMap.put("msisdn", this.f2325d);
        linkedHashMap.put("token", this.f2326e);
        linkedHashMap.put("authnum", this.f2327f);
        String strM6112a = c1793y.m6112a((Object) linkedHashMap);
        C1786r.m6066e(strM6112a, getClass().getSimpleName());
        return strM6112a;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
            C1786r.m6063c("Success, verifySMS task", getClass().getSimpleName());
        }
    }
}
