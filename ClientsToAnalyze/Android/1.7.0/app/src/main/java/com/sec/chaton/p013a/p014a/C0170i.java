package com.sec.chaton.p013a.p014a;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.provider.ContactsContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.RegisterSSMServer;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1349x;
import java.util.LinkedHashMap;

/* compiled from: RegistrationTask.java */
/* renamed from: com.sec.chaton.a.a.i */
/* loaded from: classes.dex */
public class C0170i extends AbstractRunnableC0153bb {

    /* renamed from: a */
    protected String f401a;

    /* renamed from: b */
    protected String f402b;

    /* renamed from: f */
    private String f403f;

    /* renamed from: g */
    private String f404g;

    /* renamed from: h */
    private Context f405h;

    /* renamed from: i */
    private ContentResolver f406i;

    public C0170i(Handler handler, C0503j c0503j, String str, String str2, String str3, String str4) {
        super(handler, c0503j);
        this.f403f = str;
        this.f404g = str2;
        this.f401a = str4;
        this.f402b = str3;
        this.f405h = GlobalApplication.m3100a();
        this.f406i = this.f405h.getContentResolver();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        C1349x c1349x = new C1349x();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("msisdn", this.f403f);
        linkedHashMap.put("imei", C1336k.m4621a());
        if (GlobalApplication.f2407a != null) {
            linkedHashMap.put("regid", GlobalApplication.f2407a);
        }
        linkedHashMap.put("pushtype", "SPP");
        linkedHashMap.put("osversion", "android " + Build.VERSION.SDK);
        linkedHashMap.put("imsi", C1336k.m4629f());
        linkedHashMap.put("model", C1336k.m4625c());
        linkedHashMap.put("name", this.f404g);
        linkedHashMap.put("token", this.f402b);
        linkedHashMap.put("authnum", this.f401a);
        String strM4714a = c1349x.m4714a((Object) linkedHashMap);
        C1341p.m4662e(strM4714a, getClass().getSimpleName());
        return strM4714a;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
            RegisterSSMServer registerSSMServer = (RegisterSSMServer) c0259g.m932d();
            C1323bs.m4575a().edit().putString("msisdn", this.f403f).commit();
            C1323bs.m4575a().edit().putString("uid", registerSSMServer.uid).commit();
            C1323bs.m4579a("Push Name", this.f404g);
            C1341p.m4660c("Success, UID : " + registerSSMServer.uid, getClass().getSimpleName());
            this.f406i.delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build(), "account_type=?", new String[]{"com.sec.chaton"});
        }
    }
}
