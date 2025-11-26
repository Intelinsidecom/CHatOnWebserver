package com.sec.chaton;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import com.sec.chaton.p025d.C1332j;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1366j;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import com.sec.common.util.log.collector.C3353c;

/* compiled from: ApplicationInitializeTask.java */
/* renamed from: com.sec.chaton.k */
/* loaded from: classes.dex */
public class AsyncTaskC1599k extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    private final String f5936a = AsyncTaskC1599k.class.getSimpleName();

    /* renamed from: b */
    private InterfaceC1601l f5937b;

    /* renamed from: a */
    public void m6776a(InterfaceC1601l interfaceC1601l) {
        this.f5937b = interfaceC1601l;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        Cursor cursorQuery;
        try {
            Context contextM11493l = CommonApplication.m11493l();
            ContentResolver contentResolver = contextM11493l.getContentResolver();
            C3353c.m11835d();
            C1404av.m6253a(contextM11493l).getWritableDatabase();
            C1373q.m6153a(contentResolver);
            C3170al.m11042a(contextM11493l, "com.sec.chaton.provider2", C1366j.m6091a());
            try {
                cursorQuery = contentResolver.query(C1398ap.m6249a(EnumC1399aq.Anicon).buildUpon().appendPath("install").build(), new String[]{"item_id"}, C3364o.m11849a("data1", " IS NULL OR ", "data2", " IS NULL OR ", "data3", " IS NULL"), null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToNext()) {
                            if (C3250y.f11734b) {
                                C3250y.m11450b("Retrieve anicon package list.", this.f5936a);
                            }
                            if (new C1332j(contextM11493l, null).m5767a(EnumC1172b.UI, "0", "zip", 240).m5491b().m1351b() == EnumC1587o.SUCCESS) {
                                if (C3250y.f11734b) {
                                    C3250y.m11450b("Success retrieve anicon package list.", this.f5936a);
                                }
                            } else if (C3250y.f11737e) {
                                C3250y.m11442a("Fail retrieve anicon package list.", this.f5936a);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                C3159aa.m10962a().m10981a("primary_translation_address");
                C3159aa.m10962a().m10981a("secondary_translation_address");
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
            }
        } catch (Throwable th3) {
            if (C3250y.f11737e) {
                C3250y.m11443a(th3, this.f5936a);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r2) {
        super.onPostExecute(r2);
        if (this.f5937b != null) {
            this.f5937b.mo1169a();
        }
    }
}
