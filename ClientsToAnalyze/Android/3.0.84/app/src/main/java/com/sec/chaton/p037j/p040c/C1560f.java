package com.sec.chaton.p037j.p040c;

import android.os.Handler;
import android.view.View;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;

/* compiled from: FileDownloadTask2.java */
/* renamed from: com.sec.chaton.j.c.f */
/* loaded from: classes.dex */
public class C1560f {

    /* renamed from: a */
    protected Handler f5773a = null;

    /* renamed from: b */
    protected View f5774b = null;

    /* renamed from: c */
    protected String f5775c = null;

    /* renamed from: d */
    protected String f5776d = null;

    /* renamed from: e */
    protected String f5777e = null;

    /* renamed from: f */
    protected boolean f5778f = false;

    /* renamed from: g */
    protected String f5779g = null;

    /* renamed from: h */
    protected long f5780h = 0;

    /* renamed from: i */
    protected EnumC1450r f5781i = EnumC1450r.ONETOONE;

    /* renamed from: j */
    protected String f5782j = null;

    /* renamed from: k */
    protected int f5783k = 0;

    /* renamed from: l */
    protected EnumC1455w f5784l;

    /* renamed from: m */
    ChatFragment f5785m;

    /* renamed from: a */
    public C1560f m6617a(Handler handler) {
        this.f5773a = handler;
        return this;
    }

    /* renamed from: a */
    public C1560f m6618a(View view) {
        this.f5774b = view;
        return this;
    }

    /* renamed from: a */
    public C1560f m6622a(String str) {
        this.f5775c = str;
        return this;
    }

    /* renamed from: b */
    public C1560f m6624b(String str) {
        this.f5776d = str;
        return this;
    }

    /* renamed from: c */
    public C1560f m6625c(String str) {
        this.f5777e = str;
        return this;
    }

    /* renamed from: a */
    public C1560f m6623a(boolean z) {
        this.f5778f = z;
        return this;
    }

    /* renamed from: d */
    public C1560f m6626d(String str) {
        this.f5779g = str;
        return this;
    }

    /* renamed from: a */
    public C1560f m6616a(long j) {
        this.f5780h = j;
        return this;
    }

    /* renamed from: a */
    public C1560f m6620a(EnumC1450r enumC1450r) {
        this.f5781i = enumC1450r;
        return this;
    }

    /* renamed from: e */
    public C1560f m6627e(String str) {
        this.f5782j = str;
        return this;
    }

    /* renamed from: a */
    public C1560f m6615a(int i) {
        this.f5783k = i;
        return this;
    }

    /* renamed from: a */
    public C1560f m6621a(EnumC1455w enumC1455w) {
        this.f5784l = enumC1455w;
        return this;
    }

    /* renamed from: a */
    public C1560f m6619a(ChatFragment chatFragment) {
        this.f5785m = chatFragment;
        return this;
    }

    /* renamed from: a */
    public AsyncTaskC1557c m6614a() {
        return new AsyncTaskC1557c(this);
    }
}
