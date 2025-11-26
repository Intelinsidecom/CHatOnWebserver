package com.sec.chaton.p007a.p008a;

import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

/* compiled from: HttpEntry.java */
/* renamed from: com.sec.chaton.a.a.b */
/* loaded from: classes.dex */
public class C0101b {

    /* renamed from: b */
    private EnumC0803m f309b;

    /* renamed from: c */
    private C0798h f310c;

    /* renamed from: h */
    private int f315h;

    /* renamed from: i */
    private String f316i;

    /* renamed from: j */
    private HttpResponse f317j;

    /* renamed from: a */
    private boolean f308a = false;

    /* renamed from: d */
    private int f311d = 0;

    /* renamed from: e */
    private String f312e = "";

    /* renamed from: f */
    private Object f313f = null;

    /* renamed from: g */
    private Object f314g = null;

    /* renamed from: a */
    public boolean m664a() {
        return this.f308a;
    }

    /* renamed from: a */
    public void m663a(boolean z) {
        this.f308a = z;
    }

    public C0101b(C0798h c0798h) {
        this.f310c = c0798h;
    }

    /* renamed from: b */
    public EnumC0803m m665b() {
        return this.f309b;
    }

    /* renamed from: a */
    public void m659a(EnumC0803m enumC0803m) {
        this.f309b = enumC0803m;
    }

    /* renamed from: c */
    public C0798h m669c() {
        return this.f310c;
    }

    /* renamed from: d */
    public Object m671d() {
        return this.f313f;
    }

    /* renamed from: a */
    public void m660a(Object obj) {
        this.f313f = obj;
    }

    /* renamed from: b */
    public void m667b(Object obj) {
        this.f314g = obj;
    }

    /* renamed from: e */
    public Object m672e() {
        return this.f314g;
    }

    /* renamed from: a */
    public void m658a(int i) {
        this.f311d = i;
    }

    /* renamed from: f */
    public int m673f() {
        return this.f311d;
    }

    /* renamed from: a */
    public void m661a(String str) {
        this.f312e = str;
    }

    /* renamed from: g */
    public String m674g() {
        return this.f312e;
    }

    /* renamed from: h */
    public int m675h() {
        return this.f315h;
    }

    /* renamed from: b */
    public void m666b(int i) {
        this.f315h = i;
    }

    /* renamed from: b */
    public void m668b(String str) {
        this.f316i = str;
    }

    /* renamed from: i */
    public String m676i() {
        return this.f316i;
    }

    /* renamed from: a */
    public void m662a(HttpResponse httpResponse) {
        this.f317j = httpResponse;
    }

    /* renamed from: c */
    public Header[] m670c(String str) {
        if (this.f317j == null) {
            return null;
        }
        return this.f317j.getHeaders(str);
    }
}
