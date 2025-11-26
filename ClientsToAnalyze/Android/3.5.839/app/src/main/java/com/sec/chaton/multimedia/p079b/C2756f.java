package com.sec.chaton.multimedia.p079b;

import android.app.Activity;
import android.os.Handler;
import com.sec.chaton.p055d.AbstractC2070ac;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import java.io.File;

/* compiled from: SendFileTask.java */
/* renamed from: com.sec.chaton.multimedia.b.f */
/* loaded from: classes.dex */
public class C2756f {

    /* renamed from: a */
    private File f9911a;

    /* renamed from: b */
    private EnumC2214ab f9912b;

    /* renamed from: c */
    private String f9913c;

    /* renamed from: d */
    private String f9914d;

    /* renamed from: e */
    private String f9915e;

    /* renamed from: f */
    private EnumC2300t f9916f;

    /* renamed from: g */
    private String f9917g;

    /* renamed from: h */
    private AbstractC2070ac f9918h;

    /* renamed from: i */
    private String[] f9919i;

    /* renamed from: j */
    private EnumC2301u f9920j;

    /* renamed from: k */
    private String f9921k;

    /* renamed from: l */
    private String f9922l;

    /* renamed from: m */
    private String f9923m;

    /* renamed from: n */
    private boolean f9924n;

    /* renamed from: o */
    private Handler f9925o;

    /* renamed from: p */
    private String f9926p;

    /* renamed from: q */
    private Activity f9927q;

    /* renamed from: r */
    private boolean f9928r;

    public C2756f(File file, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, AbstractC2070ac abstractC2070ac, String[] strArr, EnumC2301u enumC2301u, String str2, String str3, boolean z) {
        this.f9911a = file;
        this.f9912b = enumC2214ab;
        this.f9916f = enumC2300t;
        this.f9917g = str;
        this.f9918h = abstractC2070ac;
        this.f9919i = strArr;
        this.f9920j = enumC2301u;
        this.f9921k = str2;
        this.f9922l = str3;
        this.f9928r = z;
    }

    /* renamed from: a */
    public C2756f m11572a(String str) {
        this.f9913c = str;
        return this;
    }

    /* renamed from: b */
    public C2756f m11573b(String str) {
        this.f9914d = str;
        return this;
    }

    /* renamed from: c */
    public C2756f m11574c(String str) {
        this.f9915e = str;
        return this;
    }

    /* renamed from: a */
    public C2756f m11570a(Activity activity) {
        this.f9927q = activity;
        return this;
    }

    /* renamed from: d */
    public C2756f m11575d(String str) {
        this.f9923m = str;
        return this;
    }

    /* renamed from: a */
    public C2756f m11571a(Handler handler) {
        this.f9925o = handler;
        return this;
    }

    /* renamed from: e */
    public C2756f m11576e(String str) {
        this.f9926p = str;
        return this;
    }

    /* renamed from: a */
    public AsyncTaskC2754d m11569a() {
        return new AsyncTaskC2754d(this);
    }
}
