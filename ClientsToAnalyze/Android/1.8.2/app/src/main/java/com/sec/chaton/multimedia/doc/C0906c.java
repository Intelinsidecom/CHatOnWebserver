package com.sec.chaton.multimedia.doc;

import android.text.format.DateFormat;
import com.sec.chaton.global.GlobalApplication;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: FileItem.java */
/* renamed from: com.sec.chaton.multimedia.doc.c */
/* loaded from: classes.dex */
public class C0906c {

    /* renamed from: a */
    private EnumC0905b f3330a;

    /* renamed from: b */
    private String f3331b;

    /* renamed from: c */
    private String f3332c;

    /* renamed from: d */
    private long f3333d;

    /* renamed from: e */
    private long f3334e;

    /* renamed from: f */
    private SimpleDateFormat f3335f = new SimpleDateFormat(" hh:mma", GlobalApplication.m3262c().getConfiguration().locale);

    /* renamed from: a */
    public EnumC0905b m3640a() {
        return this.f3330a;
    }

    /* renamed from: a */
    public void m3642a(EnumC0905b enumC0905b) {
        this.f3330a = enumC0905b;
    }

    /* renamed from: b */
    public String m3644b() {
        return this.f3332c;
    }

    /* renamed from: a */
    public void m3643a(String str) {
        this.f3332c = str;
    }

    /* renamed from: c */
    public String m3647c() {
        if (this.f3333d >= 1048576) {
            return String.format("%.2fMB", Float.valueOf(this.f3333d / 1048576.0f));
        }
        return String.format("%.2fKB", Float.valueOf(this.f3333d / 1024.0f));
    }

    /* renamed from: a */
    public void m3641a(long j) {
        this.f3333d = j;
    }

    /* renamed from: d */
    public String m3648d() {
        if (DateFormat.is24HourFormat(GlobalApplication.m3260b())) {
            this.f3335f = new SimpleDateFormat(" HH:mm", GlobalApplication.m3262c().getConfiguration().locale);
        }
        Date date = new Date(this.f3334e);
        return DateFormat.getDateFormat(GlobalApplication.m3260b()).format(date) + this.f3335f.format(date);
    }

    /* renamed from: b */
    public void m3645b(long j) {
        this.f3334e = j;
    }

    /* renamed from: e */
    public String m3649e() {
        return this.f3331b;
    }

    /* renamed from: b */
    public void m3646b(String str) {
        this.f3331b = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileType: " + this.f3330a.name());
        sb.append(", FileName: " + this.f3332c);
        sb.append(", FileSize: " + this.f3333d);
        sb.append(", LastModified: " + this.f3334e);
        sb.append(", FilePath: " + this.f3331b);
        sb.append("\n");
        return sb.toString();
    }
}
