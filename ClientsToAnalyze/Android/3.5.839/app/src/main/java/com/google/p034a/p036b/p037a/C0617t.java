package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0558aa;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: SqlDateTypeAdapter.java */
/* renamed from: com.google.a.b.a.t */
/* loaded from: classes.dex */
public final class C0617t extends AbstractC0562ae<Date> {

    /* renamed from: a */
    public static final InterfaceC0563af f1431a = new C0618u();

    /* renamed from: b */
    private final DateFormat f1432b = new SimpleDateFormat("MMM d, yyyy");

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized Date mo1949b(C0666a c0666a) {
        Date date;
        if (c0666a.mo1992f() == EnumC0668c.NULL) {
            c0666a.mo1996j();
            date = null;
        } else {
            try {
                date = new Date(this.f1432b.parse(c0666a.mo1994h()).getTime());
            } catch (ParseException e) {
                throw new C0558aa(e);
            }
        }
        return date;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public synchronized void mo1948a(C0669d c0669d, Date date) {
        c0669d.mo2010b(date == null ? null : this.f1432b.format((java.util.Date) date));
    }
}
