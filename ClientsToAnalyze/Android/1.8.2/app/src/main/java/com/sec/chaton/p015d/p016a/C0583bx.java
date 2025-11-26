package com.sec.chaton.p015d.p016a;

import android.database.Cursor;
import com.sec.chaton.account.C0212i;
import com.sec.chaton.p017e.p018a.C0657a;
import com.sec.chaton.p017e.p018a.C0659c;
import com.sec.chaton.p027i.C0821d;
import com.sec.chaton.p027i.InterfaceC0820c;

/* compiled from: UploadAddressTask.java */
/* renamed from: com.sec.chaton.d.a.bx */
/* loaded from: classes.dex */
class C0583bx implements InterfaceC0820c {

    /* renamed from: a */
    final /* synthetic */ C0582bw f2321a;

    C0583bx(C0582bw c0582bw) {
        this.f2321a = c0582bw;
    }

    @Override // com.sec.chaton.p027i.InterfaceC0820c
    /* renamed from: a */
    public void mo2776a(Cursor cursor, Cursor cursor2) {
        this.f2321a.f2316g.add(new C0821d(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
        this.f2321a.f2314e.add(C0659c.m2999a(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
    }

    @Override // com.sec.chaton.p027i.InterfaceC0820c
    /* renamed from: b */
    public void mo2777b(Cursor cursor, Cursor cursor2) {
        this.f2321a.f2317h.add(new C0821d(cursor2.getInt(0), cursor2.getString(1), cursor2.getInt(2), cursor2.getString(3)));
        this.f2321a.f2314e.add(C0659c.m2998a(cursor2.getInt(0)));
        this.f2321a.f2315f.add(C0212i.m1819a(cursor2.getColumnName(1)));
    }

    @Override // com.sec.chaton.p027i.InterfaceC0820c
    /* renamed from: c */
    public void mo2778c(Cursor cursor, Cursor cursor2) {
        this.f2321a.f2316g.add(new C0821d(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
        this.f2321a.f2317h.add(new C0821d(cursor2.getInt(0), cursor2.getString(1), cursor2.getInt(2), cursor2.getString(3)));
        this.f2321a.f2314e.add(C0659c.m3000a(cursor2.getInt(0), "conatct_number", cursor.getString(1)));
        this.f2321a.f2315f.add(C0212i.m1819a(cursor.getString(1)));
    }

    @Override // com.sec.chaton.p027i.InterfaceC0820c
    /* renamed from: d */
    public void mo2779d(Cursor cursor, Cursor cursor2) {
        this.f2321a.f2314e.add(C0657a.m2975a(cursor.getString(2), cursor.getString(3)));
        this.f2321a.f2314e.add(C0659c.m3000a(cursor2.getInt(0), "contacts_name", cursor.getString(3)));
        this.f2321a.f2316g.add(new C0821d(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
    }
}
