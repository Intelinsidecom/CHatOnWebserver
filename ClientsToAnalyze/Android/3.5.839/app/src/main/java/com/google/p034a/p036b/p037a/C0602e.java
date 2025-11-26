package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0558aa;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: DateTypeAdapter.java */
/* renamed from: com.google.a.b.a.e */
/* loaded from: classes.dex */
public final class C0602e extends AbstractC0562ae<Date> {

    /* renamed from: a */
    public static final InterfaceC0563af f1396a = new C0603f();

    /* renamed from: b */
    private final DateFormat f1397b = DateFormat.getDateTimeInstance(2, 2, Locale.US);

    /* renamed from: c */
    private final DateFormat f1398c = DateFormat.getDateTimeInstance(2, 2);

    /* renamed from: d */
    private final DateFormat f1399d = m1981a();

    /* renamed from: a */
    private static DateFormat m1981a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date mo1949b(C0666a c0666a) throws IOException {
        if (c0666a.mo1992f() != EnumC0668c.NULL) {
            return m1982a(c0666a.mo1994h());
        }
        c0666a.mo1996j();
        return null;
    }

    /* renamed from: a */
    private synchronized Date m1982a(String str) {
        Date date;
        try {
            date = this.f1398c.parse(str);
        } catch (ParseException e) {
            try {
                date = this.f1397b.parse(str);
            } catch (ParseException e2) {
                try {
                    date = this.f1399d.parse(str);
                } catch (ParseException e3) {
                    throw new C0558aa(str, e3);
                }
            }
        }
        return date;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public synchronized void mo1948a(C0669d c0669d, Date date) {
        if (date == null) {
            c0669d.mo2014f();
        } else {
            c0669d.mo2010b(this.f1397b.format(date));
        }
    }
}
