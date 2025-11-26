package com.sec.chaton.common.entry;

import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;

/* loaded from: classes.dex */
public class HttpEntry {

    /* renamed from: b */
    private HttpResultCode f1304b;

    /* renamed from: c */
    private HttpEnvelope f1305c;

    /* renamed from: h */
    private int f1310h;

    /* renamed from: a */
    private boolean f1303a = false;

    /* renamed from: d */
    private int f1306d = 0;

    /* renamed from: e */
    private String f1307e = "";

    /* renamed from: f */
    private Object f1308f = null;

    /* renamed from: g */
    private Object f1309g = null;

    public HttpEntry(HttpEnvelope httpEnvelope) {
        this.f1305c = httpEnvelope;
    }

    /* renamed from: a */
    public void m1945a(int i) {
        this.f1306d = i;
    }

    /* renamed from: a */
    public void m1946a(HttpResultCode httpResultCode) {
        this.f1304b = httpResultCode;
    }

    /* renamed from: a */
    public void m1947a(Object obj) {
        this.f1308f = obj;
    }

    /* renamed from: a */
    public void m1948a(String str) {
        this.f1307e = str;
    }

    /* renamed from: a */
    public void m1949a(boolean z) {
        this.f1303a = z;
    }

    /* renamed from: a */
    public boolean m1950a() {
        return this.f1303a;
    }

    /* renamed from: b */
    public HttpResultCode m1951b() {
        return this.f1304b;
    }

    /* renamed from: b */
    public void m1952b(int i) {
        this.f1310h = i;
    }

    /* renamed from: b */
    public void m1953b(Object obj) {
        this.f1309g = obj;
    }

    /* renamed from: c */
    public HttpEnvelope m1954c() {
        return this.f1305c;
    }

    /* renamed from: d */
    public Object m1955d() {
        return this.f1308f;
    }

    /* renamed from: e */
    public Object m1956e() {
        return this.f1309g;
    }

    /* renamed from: f */
    public int m1957f() {
        return this.f1306d;
    }

    /* renamed from: g */
    public String m1958g() {
        return this.f1307e;
    }

    /* renamed from: h */
    public int m1959h() {
        return this.f1310h;
    }
}
