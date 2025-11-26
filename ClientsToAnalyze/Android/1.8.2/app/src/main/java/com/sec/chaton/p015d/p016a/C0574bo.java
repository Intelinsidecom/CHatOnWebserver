package com.sec.chaton.p015d.p016a;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.provider.ContactsContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.RegisterSSMServer;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.C1793y;
import java.util.LinkedHashMap;

/* compiled from: RegistrationTask.java */
/* renamed from: com.sec.chaton.d.a.bo */
/* loaded from: classes.dex */
public class C0574bo extends AbstractRunnableC0532a {

    /* renamed from: d */
    protected String f2296d;

    /* renamed from: e */
    protected String f2297e;

    /* renamed from: f */
    private String f2298f;

    /* renamed from: g */
    private String f2299g;

    /* renamed from: h */
    private Context f2300h;

    /* renamed from: i */
    private ContentResolver f2301i;

    public C0574bo(Handler handler, C0798h c0798h, String str, String str2, String str3, String str4) {
        super(handler, c0798h);
        this.f2298f = str;
        this.f2299g = str2;
        this.f2296d = str4;
        this.f2297e = str3;
        this.f2300h = GlobalApplication.m3260b();
        this.f2301i = this.f2300h.getContentResolver();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1793y c1793y = new C1793y();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("msisdn", this.f2298f);
        linkedHashMap.put("imei", C1721ad.m5873a());
        if (GlobalApplication.f2775a != null) {
            linkedHashMap.put("regid", GlobalApplication.f2775a);
        }
        linkedHashMap.put("pushtype", "SPP");
        linkedHashMap.put("osversion", "android " + Build.VERSION.SDK);
        linkedHashMap.put("imsi", C1721ad.m5880g());
        linkedHashMap.put("model", C1721ad.m5876c());
        linkedHashMap.put("name", this.f2299g);
        linkedHashMap.put("token", this.f2297e);
        linkedHashMap.put("authnum", this.f2296d);
        String strM6112a = c1793y.m6112a((Object) linkedHashMap);
        C1786r.m6066e(strM6112a, getClass().getSimpleName());
        return strM6112a;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
            RegisterSSMServer registerSSMServer = (RegisterSSMServer) c0101b.m671d();
            C1789u.m6075a().edit().putString("msisdn", this.f2298f).commit();
            C1789u.m6075a().edit().putString("uid", registerSSMServer.uid).commit();
            C1789u.m6079a("Push Name", this.f2299g);
            C1786r.m6063c("Success, UID : " + registerSSMServer.uid, getClass().getSimpleName());
            this.f2301i.delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build(), "account_type=?", new String[]{"com.sec.chaton"});
        }
    }
}
