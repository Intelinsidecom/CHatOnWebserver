package com.sec.common.p126d.p127a;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HttpRequestEntry.java */
/* renamed from: com.sec.common.d.a.c */
/* loaded from: classes.dex */
public class C4987c {

    /* renamed from: g */
    private String f18204g;

    /* renamed from: h */
    private boolean f18205h;

    /* renamed from: i */
    private boolean f18206i;

    /* renamed from: m */
    private AbstractC4976a f18210m;

    /* renamed from: a */
    private int f18198a = 30000;

    /* renamed from: b */
    private int f18199b = 30000;

    /* renamed from: c */
    private int f18200c = 1;

    /* renamed from: d */
    private int f18201d = this.f18198a;

    /* renamed from: e */
    private int f18202e = this.f18199b;

    /* renamed from: f */
    private int f18203f = this.f18200c;

    /* renamed from: j */
    private Map<String, String> f18207j = new HashMap();

    /* renamed from: k */
    private Map<String, String> f18208k = new HashMap();

    /* renamed from: l */
    private EnumC4988d f18209l = EnumC4988d.GET;

    /* renamed from: c */
    public String mo10632c() {
        return this.f18204g;
    }

    /* renamed from: a */
    public void mo10630a(String str) {
        this.f18204g = str;
    }

    /* renamed from: f */
    public boolean m18939f() {
        return this.f18205h;
    }

    /* renamed from: a */
    public void m18933a(boolean z) {
        this.f18205h = z;
    }

    /* renamed from: g */
    public boolean m18940g() {
        return this.f18206i;
    }

    /* renamed from: b */
    public void m18937b(boolean z) {
        this.f18206i = z;
    }

    /* renamed from: h */
    public Map<String, String> m18941h() {
        return this.f18207j;
    }

    /* renamed from: a */
    public void m18931a(String str, String str2) {
        this.f18207j.put(str, str2);
    }

    /* renamed from: a */
    public void m18932a(Map<String, String> map) {
        this.f18207j = map;
    }

    /* renamed from: i */
    public EnumC4988d m18942i() {
        return this.f18209l;
    }

    /* renamed from: a */
    public void m18930a(EnumC4988d enumC4988d) {
        this.f18209l = enumC4988d;
    }

    /* renamed from: j */
    public int m18943j() {
        return this.f18201d;
    }

    /* renamed from: b */
    public void m18934b(int i) {
        this.f18201d = i;
    }

    /* renamed from: k */
    public int m18944k() {
        return this.f18202e;
    }

    /* renamed from: c */
    public void m18938c(int i) {
        this.f18202e = i;
    }

    /* renamed from: l */
    public int m18945l() {
        return this.f18203f;
    }

    /* renamed from: m */
    public Map<String, String> m18946m() {
        return this.f18208k;
    }

    /* renamed from: b */
    public void m18935b(String str, String str2) {
        this.f18208k.put(str, URLEncoder.encode(str2));
    }

    /* renamed from: b */
    public void m18936b(Map<String, String> map) {
        this.f18208k = map;
    }

    /* renamed from: n */
    public AbstractC4976a m18947n() {
        return this.f18210m;
    }

    /* renamed from: a */
    public void m18929a(AbstractC4976a abstractC4976a) {
        this.f18210m = abstractC4976a;
    }
}
