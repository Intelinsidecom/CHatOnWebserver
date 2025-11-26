package com.sec.chaton.p013a.p014a;

import android.database.Cursor;
import com.sec.chaton.account.C0233b;
import com.sec.chaton.p025d.p026a.C0621a;
import com.sec.chaton.p025d.p026a.C0633m;
import com.sec.chaton.p030g.C0709a;
import com.sec.chaton.p030g.InterfaceC0712d;

/* compiled from: UploadAddressTask.java */
/* renamed from: com.sec.chaton.a.a.ag */
/* loaded from: classes.dex */
class C0131ag implements InterfaceC0712d {

    /* renamed from: a */
    final /* synthetic */ C0162bk f315a;

    C0131ag(C0162bk c0162bk) {
        this.f315a = c0162bk;
    }

    @Override // com.sec.chaton.p030g.InterfaceC0712d
    /* renamed from: a */
    public void mo674a(Cursor cursor, Cursor cursor2) {
        this.f315a.f383g.add(new C0709a(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
        this.f315a.f381b.add(C0621a.m2836a(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
    }

    @Override // com.sec.chaton.p030g.InterfaceC0712d
    /* renamed from: b */
    public void mo675b(Cursor cursor, Cursor cursor2) {
        this.f315a.f384h.add(new C0709a(cursor2.getInt(0), cursor2.getString(1), cursor2.getInt(2), cursor2.getString(3)));
        this.f315a.f381b.add(C0621a.m2835a(cursor2.getInt(0)));
        this.f315a.f382f.add(C0233b.m900a(cursor2.getColumnName(1)));
    }

    @Override // com.sec.chaton.p030g.InterfaceC0712d
    /* renamed from: c */
    public void mo676c(Cursor cursor, Cursor cursor2) {
        this.f315a.f383g.add(new C0709a(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
        this.f315a.f384h.add(new C0709a(cursor2.getInt(0), cursor2.getString(1), cursor2.getInt(2), cursor2.getString(3)));
        this.f315a.f381b.add(C0621a.m2837a(cursor2.getInt(0), "conatct_number", cursor.getString(1)));
        this.f315a.f382f.add(C0233b.m900a(cursor.getString(1)));
    }

    @Override // com.sec.chaton.p030g.InterfaceC0712d
    /* renamed from: d */
    public void mo677d(Cursor cursor, Cursor cursor2) {
        this.f315a.f381b.add(C0633m.m2880a(cursor.getString(2), cursor.getString(3)));
        this.f315a.f381b.add(C0621a.m2837a(cursor2.getInt(0), "contacts_name", cursor.getString(3)));
        this.f315a.f383g.add(new C0709a(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
    }
}
