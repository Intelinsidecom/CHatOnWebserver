package com.sec.chaton.p013a.p014a;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1349x;
import java.util.LinkedHashMap;

/* compiled from: VerifySMSTask.java */
/* renamed from: com.sec.chaton.a.a.k */
/* loaded from: classes.dex */
public class C0172k extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private String f413a;

    /* renamed from: b */
    private String f414b;

    /* renamed from: f */
    private String f415f;

    /* renamed from: g */
    private Context f416g;

    /* renamed from: h */
    private ContentResolver f417h;

    public C0172k(Handler handler, C0503j c0503j, String str, String str2, String str3) {
        super(handler, c0503j);
        this.f413a = str;
        this.f414b = str2;
        this.f415f = str3;
        this.f416g = GlobalApplication.m3100a();
        this.f417h = this.f416g.getContentResolver();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        C1349x c1349x = new C1349x();
        LinkedHashMap linkedHashMap = new LinkedHashMap(3);
        linkedHashMap.put("msisdn", this.f413a);
        linkedHashMap.put("token", this.f414b);
        linkedHashMap.put("authnum", this.f415f);
        String strM4714a = c1349x.m4714a((Object) linkedHashMap);
        C1341p.m4662e(strM4714a, getClass().getSimpleName());
        return strM4714a;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
            C1341p.m4660c("Success, verifySMS task", getClass().getSimpleName());
        }
    }
}
