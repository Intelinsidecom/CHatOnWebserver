package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.ao */
/* loaded from: classes.dex */
class C0581ao extends AbstractC0562ae<Timestamp> {

    /* renamed from: a */
    final /* synthetic */ AbstractC0562ae f1378a;

    /* renamed from: b */
    final /* synthetic */ C0580an f1379b;

    C0581ao(C0580an c0580an, AbstractC0562ae abstractC0562ae) {
        this.f1379b = c0580an;
        this.f1378a = abstractC0562ae;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Timestamp mo1949b(C0666a c0666a) {
        Date date = (Date) this.f1378a.mo1949b(c0666a);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, Timestamp timestamp) {
        this.f1378a.mo1948a(c0669d, timestamp);
    }
}
