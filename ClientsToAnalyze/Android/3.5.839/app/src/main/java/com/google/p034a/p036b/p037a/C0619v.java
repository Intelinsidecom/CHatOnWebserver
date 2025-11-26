package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0558aa;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: TimeTypeAdapter.java */
/* renamed from: com.google.a.b.a.v */
/* loaded from: classes.dex */
public final class C0619v extends AbstractC0562ae<Time> {

    /* renamed from: a */
    public static final InterfaceC0563af f1433a = new C0620w();

    /* renamed from: b */
    private final DateFormat f1434b = new SimpleDateFormat("hh:mm:ss a");

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized Time mo1949b(C0666a c0666a) {
        Time time;
        if (c0666a.mo1992f() == EnumC0668c.NULL) {
            c0666a.mo1996j();
            time = null;
        } else {
            try {
                time = new Time(this.f1434b.parse(c0666a.mo1994h()).getTime());
            } catch (ParseException e) {
                throw new C0558aa(e);
            }
        }
        return time;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public synchronized void mo1948a(C0669d c0669d, Time time) {
        c0669d.mo2010b(time == null ? null : this.f1434b.format((Date) time));
    }
}
