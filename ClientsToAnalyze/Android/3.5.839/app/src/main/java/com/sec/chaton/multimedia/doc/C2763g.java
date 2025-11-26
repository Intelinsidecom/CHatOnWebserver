package com.sec.chaton.multimedia.doc;

import android.text.format.DateFormat;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.CommonApplication;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: FileItem.java */
/* renamed from: com.sec.chaton.multimedia.doc.g */
/* loaded from: classes.dex */
public class C2763g {

    /* renamed from: a */
    private EnumC2758b f9966a;

    /* renamed from: b */
    private String f9967b;

    /* renamed from: c */
    private String f9968c;

    /* renamed from: d */
    private long f9969d;

    /* renamed from: e */
    private long f9970e;

    /* renamed from: f */
    private C2766j f9971f;

    /* renamed from: g */
    private SimpleDateFormat f9972g = new SimpleDateFormat(" hh:mma", GlobalApplication.m10283b().getConfiguration().locale);

    /* renamed from: a */
    public EnumC2758b m11606a() {
        return this.f9966a;
    }

    /* renamed from: a */
    public void m11608a(EnumC2758b enumC2758b) {
        this.f9966a = enumC2758b;
    }

    /* renamed from: b */
    public String m11611b() {
        return this.f9968c;
    }

    /* renamed from: a */
    public void m11610a(String str) {
        this.f9968c = str;
    }

    /* renamed from: c */
    public String m11614c() {
        if (this.f9969d >= 1048576) {
            return String.format("%.2fMB", Float.valueOf(this.f9969d / 1048576.0f));
        }
        return String.format("%.2fKB", Float.valueOf(this.f9969d / 1024.0f));
    }

    /* renamed from: a */
    public void m11607a(long j) {
        this.f9969d = j;
    }

    /* renamed from: d */
    public String m11615d() {
        if (DateFormat.is24HourFormat(CommonApplication.m18732r())) {
            this.f9972g = new SimpleDateFormat(" HH:mm", GlobalApplication.m10283b().getConfiguration().locale);
        }
        Date date = new Date(this.f9970e);
        return DateFormat.getDateFormat(CommonApplication.m18732r()).format(date) + this.f9972g.format(date);
    }

    /* renamed from: b */
    public void m11612b(long j) {
        this.f9970e = j;
    }

    /* renamed from: e */
    public String m11616e() {
        return this.f9967b;
    }

    /* renamed from: b */
    public void m11613b(String str) {
        this.f9967b = str;
    }

    /* renamed from: f */
    public C2766j m11617f() {
        return this.f9971f;
    }

    /* renamed from: a */
    public void m11609a(C2766j c2766j) {
        this.f9971f = c2766j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileType: " + this.f9966a.name());
        sb.append(", FileName: " + this.f9968c);
        sb.append(", FileSize: " + this.f9969d);
        sb.append(", LastModified: " + this.f9970e);
        sb.append(", FilePath: " + this.f9967b);
        sb.append("\n");
        return sb.toString();
    }
}
