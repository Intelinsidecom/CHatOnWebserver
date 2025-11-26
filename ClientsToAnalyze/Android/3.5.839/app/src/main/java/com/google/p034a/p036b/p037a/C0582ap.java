package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.ap */
/* loaded from: classes.dex */
final class C0582ap extends AbstractC0562ae<Calendar> {
    C0582ap() {
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Calendar mo1949b(C0666a c0666a) throws IOException, NumberFormatException {
        int i = 0;
        if (c0666a.mo1992f() == EnumC0668c.NULL) {
            c0666a.mo1996j();
            return null;
        }
        c0666a.mo1989c();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (c0666a.mo1992f() != EnumC0668c.END_OBJECT) {
            String strMo1993g = c0666a.mo1993g();
            int iMo1999m = c0666a.mo1999m();
            if ("year".equals(strMo1993g)) {
                i6 = iMo1999m;
            } else if ("month".equals(strMo1993g)) {
                i5 = iMo1999m;
            } else if ("dayOfMonth".equals(strMo1993g)) {
                i4 = iMo1999m;
            } else if ("hourOfDay".equals(strMo1993g)) {
                i3 = iMo1999m;
            } else if ("minute".equals(strMo1993g)) {
                i2 = iMo1999m;
            } else if ("second".equals(strMo1993g)) {
                i = iMo1999m;
            }
        }
        c0666a.mo1990d();
        return new GregorianCalendar(i6, i5, i4, i3, i2, i);
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, Calendar calendar) throws IOException {
        if (calendar == null) {
            c0669d.mo2014f();
            return;
        }
        c0669d.mo2012d();
        c0669d.mo2006a("year");
        c0669d.mo2004a(calendar.get(1));
        c0669d.mo2006a("month");
        c0669d.mo2004a(calendar.get(2));
        c0669d.mo2006a("dayOfMonth");
        c0669d.mo2004a(calendar.get(5));
        c0669d.mo2006a("hourOfDay");
        c0669d.mo2004a(calendar.get(11));
        c0669d.mo2006a("minute");
        c0669d.mo2004a(calendar.get(12));
        c0669d.mo2006a("second");
        c0669d.mo2004a(calendar.get(13));
        c0669d.mo2013e();
    }
}
