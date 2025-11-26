package com.sec.chaton.smsplugin.transaction;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.provider.Telephony;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.AbstractC3900w;
import com.sec.chaton.smsplugin.p111h.C3881d;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.chaton.smsplugin.provider.C3964v;
import com.sec.chaton.smsplugin.spam.C4012bp;
import com.sec.chaton.smsplugin.spam.C4015bs;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5078a;
import com.sec.google.android.p134a.p135a.C5082e;
import com.sec.google.android.p134a.p135a.C5087j;
import com.sec.google.android.p134a.p135a.C5096s;
import com.sec.google.android.p134a.p135a.C5097t;
import com.sec.google.android.p134a.p135a.C5101x;

/* compiled from: RetrieveTransaction.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.transaction.y */
/* loaded from: classes.dex */
public class RunnableC4089y extends AbstractC4059aj implements Runnable {

    /* renamed from: a */
    static final String[] f14720a = {"ct_l", "locked"};

    /* renamed from: f */
    private final Uri f14721f;

    /* renamed from: g */
    private final String f14722g;

    /* renamed from: h */
    private boolean f14723h;

    public RunnableC4089y(Context context, int i, C4064ao c4064ao, String str) throws C5111c {
        super(context, i, c4064ao);
        if (str.startsWith("content://")) {
            this.f14721f = Uri.parse(str);
            String strM15702a = m15702a(context, this.f14721f);
            this.f14722g = strM15702a;
            this.f14640c = strM15702a;
            C3896s.m15046d("X-Mms-Content-Location: " + this.f14722g, "RetrieveTransaction");
            m15695a(C4090z.m15708a(context));
            return;
        }
        throw new IllegalArgumentException("Initializing from X-Mms-Content-Location is abandoned!");
    }

    /* renamed from: a */
    private String m15702a(Context context, Uri uri) throws C5111c {
        Cursor cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), uri, f14720a, (String) null, (String[]) null, (String) null);
        this.f14723h = false;
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() == 1 && cursorQuery.moveToFirst()) {
                    this.f14723h = cursorQuery.getInt(1) == 1;
                    return cursorQuery.getString(0);
                }
            } finally {
                cursorQuery.close();
            }
        }
        throw new C5111c("Cannot get X-Mms-Content-Location from: " + uri);
    }

    @Override // com.sec.chaton.smsplugin.transaction.AbstractC4059aj
    /* renamed from: a */
    public void mo15597a() {
        new Thread(this).start();
    }

    @Override // java.lang.Runnable
    public void run() {
        C5101x c5101x;
        boolean zM15440a;
        Uri uriM19448a = null;
        try {
            try {
                C3881d.m14970b().m14977a(this.f14721f, 129);
                c5101x = (C5101x) new C5096s(m15616a(this.f14722g)).m19425a();
            } catch (Throwable th) {
                C3890m.m14999e("RetrieveTransaction", C3890m.m14993a(th));
                if (this.f14641d.m15641a() != 1) {
                    this.f14641d.m15642a(2);
                    this.f14641d.m15643a(this.f14721f);
                    C3890m.m14999e("RetrieveTransaction", "Retrieval failed.");
                }
            }
            if (c5101x == null) {
                throw new C5111c("Invalid M-Retrieve.conf PDU.");
            }
            if (C3847e.m14674af()) {
                zM15440a = C4149cd.m16424b(this.f14639b, c5101x.mo19324w_().m19308c(), c5101x.mo19314b() != null ? c5101x.mo19314b().m19308c() : null);
            } else if (C3847e.m14675ag()) {
                zM15440a = this.f14721f.getHost().equals(C4012bp.f14467c) ? true : C4015bs.m15441a(this.f14639b, c5101x);
            } else {
                zM15440a = C4015bs.m15440a(this.f14639b, c5101x.mo19324w_(), c5101x.mo19314b());
                if (!zM15440a) {
                    zM15440a = C4015bs.m15441a(this.f14639b, c5101x);
                }
            }
            if (m15705a(this.f14639b, c5101x)) {
                this.f14641d.m15642a(2);
                this.f14641d.m15643a(this.f14721f);
            } else {
                C5097t c5097tM19426a = C5097t.m19426a(this.f14639b);
                uriM19448a = zM15440a ? c5097tM19426a.m19448a(c5101x, C3964v.f14265a, zM15440a) : c5097tM19426a.m19447a(c5101x, Telephony.Mms.Inbox.CONTENT_URI);
                String lastPathSegment = this.f14721f.getLastPathSegment();
                String lastPathSegment2 = uriM19448a.getLastPathSegment();
                C3896s.m15044b("Old msg id = " + lastPathSegment + " New msg Id = " + lastPathSegment2, "RetrieveTransaction");
                C1828q.m8956a().m8962a(lastPathSegment, lastPathSegment2, false);
                ContentValues contentValues = new ContentValues(1);
                contentValues.put("date", Long.valueOf(System.currentTimeMillis() / 1000));
                SqliteWrapper.update(this.f14639b, this.f14639b.getContentResolver(), uriM19448a, contentValues, (String) null, (String[]) null);
                this.f14641d.m15642a(1);
                this.f14641d.m15643a(uriM19448a);
                m15703a(this.f14639b, uriM19448a, this.f14722g, this.f14723h);
            }
            SqliteWrapper.delete(this.f14639b, this.f14639b.getContentResolver(), this.f14721f, (String) null, (String[]) null);
            if (uriM19448a != null) {
                AbstractC3900w.m15067b().m15072a(this.f14639b, uriM19448a);
            }
            m15704a(c5101x);
            if (this.f14641d.m15641a() != 1) {
                this.f14641d.m15642a(2);
                this.f14641d.m15643a(this.f14721f);
                C3890m.m14999e("RetrieveTransaction", "Retrieval failed.");
            }
            m15697d();
        } catch (Throwable th2) {
            if (this.f14641d.m15641a() != 1) {
                this.f14641d.m15642a(2);
                this.f14641d.m15643a(this.f14721f);
                C3890m.m14999e("RetrieveTransaction", "Retrieval failed.");
            }
            m15697d();
            throw th2;
        }
    }

    /* renamed from: a */
    private static boolean m15705a(Context context, C5101x c5101x) {
        byte[] bArrM19459i = c5101x.m19459i();
        if (bArrM19459i != null) {
            Cursor cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), Telephony.Mms.CONTENT_URI, new String[]{"_id"}, "(m_id = ? AND m_type = ?)", new String[]{new String(bArrM19459i), String.valueOf(132)}, (String) null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        return true;
                    }
                } finally {
                    cursorQuery.close();
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m15704a(C5101x c5101x) {
        byte[] bArrM19460j = c5101x.m19460j();
        if (bArrM19460j != null) {
            C5078a c5078a = new C5078a(18, bArrM19460j);
            c5078a.mo19318a(new C5082e(C4149cd.m16391a()));
            if (C3847e.m14715u()) {
                m15618a(new C5087j(this.f14639b, c5078a).m19352a(), this.f14722g);
            } else {
                m15617a(new C5087j(this.f14639b, c5078a).m19352a());
            }
        }
    }

    /* renamed from: a */
    private static void m15703a(Context context, Uri uri, String str, boolean z) {
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("ct_l", str);
        contentValues.put("locked", Boolean.valueOf(z));
        SqliteWrapper.update(context, context.getContentResolver(), uri, contentValues, (String) null, (String[]) null);
    }

    @Override // com.sec.chaton.smsplugin.transaction.AbstractC4059aj
    /* renamed from: b */
    public int mo15598b() {
        return 1;
    }

    /* renamed from: c */
    public String m15706c() {
        return this.f14722g;
    }
}
