package com.sec.chaton.multimedia.doc;

import android.text.format.DateFormat;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.CommonApplication;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: FileItem.java */
/* renamed from: com.sec.chaton.multimedia.doc.f */
/* loaded from: classes.dex */
public class C1799f {

    /* renamed from: a */
    private EnumC1794a f6674a;

    /* renamed from: b */
    private String f6675b;

    /* renamed from: c */
    private String f6676c;

    /* renamed from: d */
    private long f6677d;

    /* renamed from: e */
    private long f6678e;

    /* renamed from: f */
    private C1802i f6679f;

    /* renamed from: g */
    private SimpleDateFormat f6680g = new SimpleDateFormat(" hh:mma", GlobalApplication.m6451b().getConfiguration().locale);

    /* renamed from: a */
    public EnumC1794a m7412a() {
        return this.f6674a;
    }

    /* renamed from: a */
    public void m7414a(EnumC1794a enumC1794a) {
        this.f6674a = enumC1794a;
    }

    /* renamed from: b */
    public String m7417b() {
        return this.f6676c;
    }

    /* renamed from: a */
    public void m7416a(String str) {
        this.f6676c = str;
    }

    /* renamed from: c */
    public String m7420c() {
        if (this.f6677d >= 1048576) {
            return String.format("%.2fMB", Float.valueOf(this.f6677d / 1048576.0f));
        }
        return String.format("%.2fKB", Float.valueOf(this.f6677d / 1024.0f));
    }

    /* renamed from: a */
    public void m7413a(long j) {
        this.f6677d = j;
    }

    /* renamed from: d */
    public String m7421d() {
        if (DateFormat.is24HourFormat(CommonApplication.m11493l())) {
            this.f6680g = new SimpleDateFormat(" HH:mm", GlobalApplication.m6451b().getConfiguration().locale);
        }
        Date date = new Date(this.f6678e);
        return DateFormat.getDateFormat(CommonApplication.m11493l()).format(date) + this.f6680g.format(date);
    }

    /* renamed from: b */
    public void m7418b(long j) {
        this.f6678e = j;
    }

    /* renamed from: e */
    public String m7422e() {
        return this.f6675b;
    }

    /* renamed from: b */
    public void m7419b(String str) {
        this.f6675b = str;
    }

    /* renamed from: f */
    public C1802i m7423f() {
        return this.f6679f;
    }

    /* renamed from: a */
    public void m7415a(C1802i c1802i) {
        this.f6679f = c1802i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileType: " + this.f6674a.name());
        sb.append(", FileName: " + this.f6676c);
        sb.append(", FileSize: " + this.f6677d);
        sb.append(", LastModified: " + this.f6678e);
        sb.append(", FilePath: " + this.f6675b);
        sb.append("\n");
        return sb.toString();
    }
}
