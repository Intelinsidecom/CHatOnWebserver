package com.sec.chaton.p015d.p016a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Handler;
import android.provider.ContactsContract;
import com.sec.chaton.facebook.C0725f;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.p017e.C0706u;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.C0810t;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.trunk.database.p052a.C1585b;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1783o;
import com.sec.chaton.util.C1788t;
import com.sec.chaton.util.C1789u;
import java.io.File;

/* compiled from: DeRegistrationTask.java */
/* renamed from: com.sec.chaton.d.a.n */
/* loaded from: classes.dex */
public class C0598n extends AbstractRunnableC0532a {
    public C0598n(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
            m2784f();
        }
    }

    /* renamed from: f */
    public static void m2784f() {
        Context contextM3260b = GlobalApplication.m3260b();
        C1788t.m6070a(contextM3260b).m6072a();
        contextM3260b.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, "account_type='com.sec.chaton'", null);
        C1789u.m6075a().edit().clear().commit();
        contextM3260b.getSharedPreferences("BUDDY_ACTIVITY", 0).edit().clear().commit();
        C0810t.m3429c();
        C0639k.m2917c();
        C0706u.m3172a(contextM3260b).close();
        contextM3260b.deleteDatabase(C0706u.m3173a());
        File databasePath = contextM3260b.getDatabasePath(C0706u.m3173a());
        if (databasePath.exists()) {
            databasePath.delete();
        }
        C1585b.m5479a().close();
        contextM3260b.deleteDatabase("trunk.db");
        File databasePath2 = contextM3260b.getDatabasePath("trunk.db");
        if (databasePath2.exists()) {
            databasePath2.delete();
        }
        if (C1767bw.m6002a()) {
            C1783o.m6034a();
            C1783o.m6035a(new File(contextM3260b.getExternalFilesDir(null).toString()));
        }
        C1783o.m6035a(contextM3260b.getFilesDir());
        AccountManager accountManager = AccountManager.get(GlobalApplication.m3260b());
        for (Account account : accountManager.getAccountsByType("com.sec.chaton")) {
            accountManager.removeAccount(account, null, null);
        }
        C0725f.m3207a(GlobalApplication.m3260b());
        GlobalApplication.m3264e().m6030b();
    }
}
