package com.sec.chaton.p013a.p014a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.database.sqlite.SQLiteDiskIOException;
import android.os.Handler;
import android.provider.ContactsContract;
import com.sec.chaton.facebook.C0700o;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.C0223v;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0477ab;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p025d.C0656i;
import com.sec.chaton.trunk.database.p046a.C1172a;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1324bt;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1332g;
import com.sec.chaton.util.C1341p;
import java.io.File;

/* compiled from: DeRegistrationTask.java */
/* renamed from: com.sec.chaton.a.a.w */
/* loaded from: classes.dex */
public class C0184w extends AbstractRunnableC0153bb {
    public C0184w(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
            m724b();
        }
    }

    /* renamed from: b */
    public static void m724b() {
        Context contextM3100a = GlobalApplication.m3100a();
        C1332g.m4605a(contextM3100a).m4609a();
        try {
            contextM3100a.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, "account_type='com.sec.chaton'", null);
        } catch (SQLiteDiskIOException e) {
            C1341p.m4664g("ChatON", "SQLiteDiskIOException during deregistration.");
        }
        C1323bs.m4575a().edit().clear().commit();
        contextM3100a.getSharedPreferences("BUDDY_ACTIVITY", 0).edit().clear().commit();
        C0477ab.m2449c();
        C0223v.m821c();
        C0656i.m2982a(contextM3100a).close();
        contextM3100a.deleteDatabase(C0656i.m2983a());
        File databasePath = contextM3100a.getDatabasePath(C0656i.m2983a());
        if (databasePath.exists()) {
            databasePath.delete();
        }
        C1172a.m4229a().close();
        contextM3100a.deleteDatabase("trunk.db");
        File databasePath2 = contextM3100a.getDatabasePath("trunk.db");
        if (databasePath2.exists()) {
            databasePath2.delete();
        }
        if (C1327bw.m4595a()) {
            C1324bt.m4583a();
            C1324bt.m4584a(new File(contextM3100a.getExternalFilesDir(null).toString()));
        }
        C1324bt.m4584a(contextM3100a.getFilesDir());
        AccountManager accountManager = AccountManager.get(GlobalApplication.m3100a());
        for (Account account : accountManager.getAccountsByType("com.sec.chaton")) {
            accountManager.removeAccount(account, null, null);
        }
        C0700o.m3072a(GlobalApplication.m3100a());
        GlobalApplication.m3108i().m4671b();
    }
}
