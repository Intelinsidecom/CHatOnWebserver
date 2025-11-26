package com.sec.chaton.p025d.p026a;

import android.database.Cursor;
import com.sec.chaton.account.C0425k;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p027e.p028a.C1363g;
import com.sec.chaton.p046m.C1672d;
import com.sec.chaton.p046m.InterfaceC1671c;
import com.sec.chaton.util.C3250y;

/* compiled from: UploadAddressTask.java */
/* renamed from: com.sec.chaton.d.a.eg */
/* loaded from: classes.dex */
class C1260eg implements InterfaceC1671c {

    /* renamed from: a */
    final /* synthetic */ C1259ef f4846a;

    C1260eg(C1259ef c1259ef) {
        this.f4846a = c1259ef;
    }

    @Override // com.sec.chaton.p046m.InterfaceC1671c
    /* renamed from: a */
    public void mo5576a(Cursor cursor, Cursor cursor2) {
        C3250y.m11450b("onNumberInserted", "UploadAddressTask");
        String strM5572c = C1259ef.m5572c(cursor.getString(1));
        this.f4846a.f4832f.add(new C1672d(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), strM5572c));
        this.f4846a.f4830c.add(C1363g.m6077a(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), strM5572c));
        String strM6025a = C1360d.m6025a(strM5572c);
        if (strM6025a != null) {
            this.f4846a.f4831e.add(C0425k.m3056a(strM6025a));
        }
        if (strM5572c.length() > 7) {
            this.f4846a.f4830c.add(C1360d.m6022a(strM5572c, cursor.getString(3)));
        }
    }

    @Override // com.sec.chaton.p046m.InterfaceC1671c
    /* renamed from: b */
    public void mo5577b(Cursor cursor, Cursor cursor2) {
        C3250y.m11450b("onNumberDeleted", "UploadAddressTask");
        String strM5572c = C1259ef.m5572c(cursor2.getString(1));
        this.f4846a.f4833g.add(new C1672d(cursor2.getInt(0), strM5572c, cursor2.getInt(2), cursor2.getString(3), strM5572c));
        this.f4846a.f4830c.add(C1363g.m6076a(cursor2.getInt(0)));
        this.f4846a.f4830c.add(C1363g.m6079a(strM5572c));
        String strM6025a = C1360d.m6025a(strM5572c);
        if (strM6025a != null) {
            this.f4846a.f4831e.add(C0425k.m3056a(strM6025a));
        }
    }

    @Override // com.sec.chaton.p046m.InterfaceC1671c
    /* renamed from: c */
    public void mo5578c(Cursor cursor, Cursor cursor2) {
        C3250y.m11450b("onNumberChanged", "UploadAddressTask");
        String strM5572c = C1259ef.m5572c(cursor2.getString(1));
        String strM5572c2 = C1259ef.m5572c(cursor.getString(1));
        this.f4846a.f4832f.add(new C1672d(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), strM5572c2));
        this.f4846a.f4833g.add(new C1672d(cursor2.getInt(0), cursor2.getString(1), cursor2.getInt(2), cursor2.getString(3), strM5572c));
        this.f4846a.f4830c.add(C1363g.m6078a(cursor.getInt(0), "conatct_number", cursor.getString(1), strM5572c2));
        String strM6025a = C1360d.m6025a(strM5572c);
        if (strM6025a != null) {
            this.f4846a.f4831e.add(C0425k.m3056a(strM6025a));
        }
    }

    @Override // com.sec.chaton.p046m.InterfaceC1671c
    /* renamed from: d */
    public void mo5579d(Cursor cursor, Cursor cursor2) {
        C3250y.m11450b("onNameChanged", "UploadAddressTask");
        String strM5572c = C1259ef.m5572c(cursor.getString(1));
        this.f4846a.f4830c.add(C1360d.m6022a(strM5572c, cursor.getString(3)));
        this.f4846a.f4830c.add(C1363g.m6078a(cursor2.getInt(0), "contacts_name", cursor.getString(3), strM5572c));
        this.f4846a.f4832f.add(new C1672d(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), strM5572c));
        C3250y.m11450b("onNameChanged: buddy db has user of Contact rawid = " + cursor.getString(2) + ", buddyName = " + cursor.getString(3), "UploadAddressTask");
        String strM6025a = C1360d.m6025a(strM5572c);
        if (strM6025a != null) {
            this.f4846a.f4831e.add(C0425k.m3056a(strM6025a));
        }
    }
}
