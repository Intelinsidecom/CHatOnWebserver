package com.sec.chaton.p025d.p026a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Handler;
import android.provider.ContactsContract;
import com.sec.chaton.R;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.localbackup.database.C1642b;
import com.sec.chaton.msgsend.C1756p;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.multimedia.emoticon.C1833h;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.p031g.C1483a;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.C1596x;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.tellfriends.C2751ba;
import com.sec.chaton.settings.tellfriends.C2770bt;
import com.sec.chaton.trunk.database.p062a.C3045b;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.File;

/* compiled from: DeRegistrationTask.java */
/* renamed from: com.sec.chaton.d.a.ak */
/* loaded from: classes.dex */
public class C1156ak extends AbstractC1145a {

    /* renamed from: b */
    private boolean f4594b;

    public C1156ak(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            this.f4594b = m5507a(true) == 0;
        } else if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000002", "0102", c0267d);
        }
    }

    /* renamed from: a */
    public static int m5507a(boolean z) {
        int count;
        try {
            if (!C3223ck.m11330d() && !z) {
                return 1;
            }
            Context contextM11493l = CommonApplication.m11493l();
            C1103a.m5432a(contextM11493l).m5450a();
            ContentResolver contentResolver = contextM11493l.getContentResolver();
            Cursor cursorQuery = contentResolver.query(ContactsContract.RawContacts.CONTENT_URI, null, "account_type='com.sec.chaton'", null, null);
            if (cursorQuery != null) {
                count = cursorQuery.getCount();
                cursorQuery.close();
            } else {
                count = 0;
            }
            if (count != contentResolver.delete(ContactsContract.RawContacts.CONTENT_URI, "account_type='com.sec.chaton'", null)) {
                C3250y.m11450b("Failed to delete contacts contract" + ContactsContract.RawContacts.CONTENT_URI, "DeRegistrationTask");
            }
            C1756p.m7245d();
            C1595w.m6742a().m6748e();
            C1596x.m6758c();
            C1337o.m5817g();
            C1404av.m6253a(contextM11493l).close();
            contextM11493l.deleteDatabase(C1404av.m6254a());
            File databasePath = contextM11493l.getDatabasePath(C1404av.m6254a());
            if (databasePath.exists() && !databasePath.delete()) {
                C3250y.m11450b("Failed to delete" + C1404av.m6254a(), "DeRegistrationTask");
            }
            C3045b.m10571a().close();
            contextM11493l.deleteDatabase("trunk.db");
            File databasePath2 = contextM11493l.getDatabasePath("trunk.db");
            if (databasePath2.exists() && !databasePath2.delete()) {
                C3250y.m11450b("Failed to delete trunk.db", "DeRegistrationTask");
            }
            C1642b.m6919a().close();
            contextM11493l.deleteDatabase("chaton_local_backup.db");
            File databasePath3 = contextM11493l.getDatabasePath("chaton_local_backup.db");
            if (databasePath3.exists() && !databasePath3.delete()) {
                C3250y.m11450b("Failed to delete chaton_local_backup.db", "DeRegistrationTask");
            }
            if (C3223ck.m11327a()) {
                if (contextM11493l.getExternalFilesDir(null) != null) {
                    C3243r.m11418a(new File(contextM11493l.getExternalFilesDir(null).toString()));
                    C3243r.m11418a(contextM11493l.getExternalCacheDir());
                } else {
                    C3250y.m11450b("Failed to delete multimedia", "DeRegistrationTask");
                }
            } else {
                C3250y.m11450b("Failed to delete multimedia cause storage Not enough", "DeRegistrationTask");
            }
            C3243r.m11418a(contextM11493l.getFilesDir());
            C1483a.m6417a(CommonApplication.m11493l());
            C2751ba.m9842a(CommonApplication.m11493l());
            C2770bt.m9895a(CommonApplication.m11493l());
            GlobalApplication.m6453c().m11413c();
            SharedPreferences.Editor editorEdit = CommonApplication.m11493l().getSharedPreferences("PASSWORD_LOCK", 0).edit();
            editorEdit.putString("LOCK_STATE", C3241p.m11409e());
            editorEdit.putString("PASSWORD", "0000");
            editorEdit.putString("PASSWORD_HINT", "");
            editorEdit.commit();
            C1757q.m7248a();
            C3159aa.m10962a().m10980a();
            C3159aa.m10967b();
            contextM11493l.getSharedPreferences("BUDDY_ACTIVITY", 0).edit().clear().commit();
            contextM11493l.getSharedPreferences("chaton_pref_without_encrypt", 0).edit().clear().commit();
            C3243r.m11419a(contextM11493l.getApplicationInfo().dataDir);
            AccountManager accountManager = AccountManager.get(CommonApplication.m11493l());
            for (Account account : accountManager.getAccountsByType("com.sec.chaton")) {
                accountManager.removeAccount(account, null, null);
            }
            C1833h.m7505b().m11721b();
            C3250y.m11450b("Success to cleat data", "DeRegistrationTask");
            return 0;
        } catch (Exception e) {
            C3250y.m11443a(e, "DeRegistrationTask");
            return z ? 0 : 2;
        }
    }

    /* renamed from: i */
    public boolean m5508i() {
        return this.f4594b;
    }
}
