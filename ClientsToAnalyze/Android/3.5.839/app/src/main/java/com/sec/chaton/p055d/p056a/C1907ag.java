package com.sec.chaton.p055d.p056a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.provider.ContactsContract;
import com.sec.chaton.chat.C1735gh;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.localbackup.database.C2544b;
import com.sec.chaton.msgsend.C2716x;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.multimedia.emoticon.C2797i;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.C2268bn;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.C2417af;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.sns.C4445e;
import com.sec.chaton.sns.p114b.C4374a;
import com.sec.chaton.sns.p114b.C4403bb;
import com.sec.chaton.sns.p114b.C4410bi;
import com.sec.chaton.sns.p114b.C4427k;
import com.sec.chaton.trunk.database.p122a.C4665b;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4864cb;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5033j;
import com.sec.common.util.log.collector.C5038c;
import com.sec.spp.push.Config;
import java.io.File;
import p021c.C0349h;
import p021c.C0351j;

/* compiled from: DeRegistrationTask.java */
/* renamed from: com.sec.chaton.d.a.ag */
/* loaded from: classes.dex */
public class C1907ag extends AbstractC1900a {

    /* renamed from: b */
    private boolean f7127b;

    public C1907ag(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws C0351j {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            if (C4445e.m16842b(CommonApplication.m18732r())) {
                C0349h c0349h = new C0349h();
                C4445e.m16841a(c0349h, CommonApplication.m18732r());
                c0349h.m1236d(C4445e.m16849f(CommonApplication.m18732r()));
            }
            this.f7127b = m9089a(true) == 0;
            return;
        }
        C2404a.m10430a("01000002", "0102", c0778b);
    }

    /* renamed from: a */
    public static int m9089a(boolean z) throws InterruptedException {
        try {
            if (C4904y.f17872b) {
                C4904y.m18639b("Thread, start", "DeRegistrationTask");
            }
            Thread.sleep(600L);
            if (C4904y.f17872b) {
                C4904y.m18639b("Thread, end", "DeRegistrationTask");
            }
            C3892o.m15033g();
            return m9090a(z, false);
        } catch (InterruptedException e) {
            if (C4904y.f17875e) {
                C4904y.m18634a(e.toString(), "DeRegistrationTask");
            }
            return 2;
        }
    }

    /* renamed from: a */
    public static int m9090a(boolean z, boolean z2) {
        int i;
        Context contextR;
        String str;
        int count;
        try {
            try {
            } catch (Exception e) {
                C4904y.m18635a(e, "DeRegistrationTask");
                if (z) {
                    if (!z2) {
                        C4859bx.m18392b(GlobalApplication.m18732r(), "com.sec.chaton.ACTION_DEREGISTERED");
                    }
                    return 0;
                }
                i = 2;
                if (z2) {
                    return 2;
                }
                contextR = GlobalApplication.m18732r();
                str = "com.sec.chaton.ACTION_DEREGISTERED";
            }
            if (!C4873ck.m18503d() && !z) {
                i = 1;
                if (z2) {
                    return 1;
                }
                contextR = GlobalApplication.m18732r();
                str = "com.sec.chaton.ACTION_DEREGISTERED";
                C4859bx.m18392b(contextR, str);
                return i;
            }
            Context contextM18732r = CommonApplication.m18732r();
            C1813b.m8906b().m8935c();
            C1735gh.m8621b();
            ContentResolver contentResolver = contextM18732r.getContentResolver();
            Cursor cursorQuery = contentResolver.query(ContactsContract.RawContacts.CONTENT_URI, null, "account_type='com.sec.chaton'", null, null);
            if (cursorQuery != null) {
                count = cursorQuery.getCount();
                cursorQuery.close();
            } else {
                count = 0;
            }
            if (count != contentResolver.delete(ContactsContract.RawContacts.CONTENT_URI, "account_type='com.sec.chaton'", null)) {
                C4904y.m18639b("Failed to delete contacts contract" + ContactsContract.RawContacts.CONTENT_URI, "DeRegistrationTask");
            }
            C2716x.m11390d();
            C2472w.m10687a().m10694f();
            C2417af.m10456c();
            C2142w.m9614k();
            C2268bn.m10126a(contextM18732r).close();
            C5038c.m19171t();
            C4665b.m17665a().close();
            C2544b.m10951a().close();
            if (!C4873ck.m18500a()) {
                C4904y.m18639b("Failed to delete multimedia cause storage Not enough", "DeRegistrationTask");
            } else if (contextM18732r.getExternalFilesDir(null) != null) {
                C4894o.m18605a(new File(contextM18732r.getExternalFilesDir(null).toString()));
                C4894o.m18605a(contextM18732r.getExternalCacheDir());
            } else {
                C4904y.m18639b("Failed to delete multimedia", "DeRegistrationTask");
            }
            C4374a.m16587a(CommonApplication.m18732r());
            C4410bi.m16740a(CommonApplication.m18732r());
            C4403bb.m16716a(CommonApplication.m18732r());
            C4427k.m16765a(CommonApplication.m18732r());
            GlobalApplication.m10284c().m18597c();
            SharedPreferences.Editor editorEdit = CommonApplication.m18732r().getSharedPreferences("PASSWORD_LOCK", 0).edit();
            editorEdit.putString("LOCK_STATE", C4892m.m18588h());
            editorEdit.putString("PASSWORD", "0000");
            editorEdit.putString("PASSWORD_HINT", "");
            C5033j.m19087a(editorEdit);
            C2717y.m11393a();
            C4809aa.m18104a().m18122a();
            C4809aa.m18109b();
            contextM18732r.getSharedPreferences("BUDDY_ACTIVITY", 0).edit().clear().commit();
            contextM18732r.getSharedPreferences("chaton_pref_without_encrypt", 0).edit().clear().commit();
            C4859bx.m18383a(EnumC4864cb.deregister, GlobalApplication.m18732r());
            C4894o.m18606a(contextM18732r.getApplicationInfo().dataDir);
            AccountManager accountManager = AccountManager.get(CommonApplication.m18732r());
            for (Account account : accountManager.getAccountsByType(Config.CHATON_PACKAGE_NAME)) {
                accountManager.removeAccount(account, null, null);
            }
            C2797i.m11705a().m19004b();
            C2496n.m10782c(GlobalApplication.m18732r());
            C4904y.m18639b("Success to cleat data", "DeRegistrationTask");
            if (!z2) {
                C4859bx.m18392b(GlobalApplication.m18732r(), "com.sec.chaton.ACTION_DEREGISTERED");
            }
            return 0;
        } catch (Throwable th) {
            if (!z2) {
                C4859bx.m18392b(GlobalApplication.m18732r(), "com.sec.chaton.ACTION_DEREGISTERED");
            }
            throw th;
        }
    }

    /* renamed from: e */
    public boolean m9091e() {
        return this.f7127b;
    }
}
