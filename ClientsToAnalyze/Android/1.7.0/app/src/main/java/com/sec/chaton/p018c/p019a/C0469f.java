package com.sec.chaton.p018c.p019a;

import android.os.Handler;
import android.view.View;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;

/* compiled from: FileDownloadTask2.java */
/* renamed from: com.sec.chaton.c.a.f */
/* loaded from: classes.dex */
public class C0469f {

    /* renamed from: a */
    protected Handler f1491a = null;

    /* renamed from: b */
    protected View f1492b = null;

    /* renamed from: c */
    protected String f1493c = null;

    /* renamed from: d */
    protected String f1494d = null;

    /* renamed from: e */
    protected String f1495e = null;

    /* renamed from: f */
    protected boolean f1496f = false;

    /* renamed from: g */
    protected String f1497g = null;

    /* renamed from: h */
    protected long f1498h = 0;

    /* renamed from: i */
    protected EnumC0665r f1499i = EnumC0665r.ONETOONE;

    /* renamed from: j */
    protected String f1500j = null;

    /* renamed from: k */
    protected int f1501k = 0;

    /* renamed from: l */
    protected EnumC0651d f1502l;

    /* renamed from: m */
    ChatFragment f1503m;

    /* renamed from: a */
    public C0469f m2399a(Handler handler) {
        this.f1491a = handler;
        return this;
    }

    /* renamed from: a */
    public C0469f m2400a(View view) {
        this.f1492b = view;
        return this;
    }

    /* renamed from: a */
    public C0469f m2404a(String str) {
        this.f1493c = str;
        return this;
    }

    /* renamed from: b */
    public C0469f m2406b(String str) {
        this.f1494d = str;
        return this;
    }

    /* renamed from: c */
    public C0469f m2407c(String str) {
        this.f1495e = str;
        return this;
    }

    /* renamed from: a */
    public C0469f m2405a(boolean z) {
        this.f1496f = z;
        return this;
    }

    /* renamed from: d */
    public C0469f m2408d(String str) {
        this.f1497g = str;
        return this;
    }

    /* renamed from: a */
    public C0469f m2398a(long j) {
        this.f1498h = j;
        return this;
    }

    /* renamed from: a */
    public C0469f m2403a(EnumC0665r enumC0665r) {
        this.f1499i = enumC0665r;
        return this;
    }

    /* renamed from: e */
    public C0469f m2409e(String str) {
        this.f1500j = str;
        return this;
    }

    /* renamed from: a */
    public C0469f m2397a(int i) {
        this.f1501k = i;
        return this;
    }

    /* renamed from: a */
    public C0469f m2402a(EnumC0651d enumC0651d) {
        this.f1502l = enumC0651d;
        return this;
    }

    /* renamed from: a */
    public C0469f m2401a(ChatFragment chatFragment) {
        this.f1503m = chatFragment;
        return this;
    }

    /* renamed from: a */
    public AsyncTaskC0466c m2396a() {
        return new AsyncTaskC0466c(this);
    }
}
