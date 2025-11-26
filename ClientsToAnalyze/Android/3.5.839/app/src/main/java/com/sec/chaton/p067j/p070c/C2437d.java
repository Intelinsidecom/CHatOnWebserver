package com.sec.chaton.p067j.p070c;

import android.os.Handler;
import android.view.View;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;

/* compiled from: FileDownloadTask2.java */
/* renamed from: com.sec.chaton.j.c.d */
/* loaded from: classes.dex */
public class C2437d {

    /* renamed from: a */
    protected Handler f8717a = null;

    /* renamed from: b */
    protected View f8718b = null;

    /* renamed from: c */
    protected String f8719c = null;

    /* renamed from: d */
    protected String f8720d = null;

    /* renamed from: e */
    protected String f8721e = null;

    /* renamed from: f */
    protected boolean f8722f = false;

    /* renamed from: g */
    protected String f8723g = null;

    /* renamed from: h */
    protected long f8724h = 0;

    /* renamed from: i */
    protected EnumC2300t f8725i = EnumC2300t.ONETOONE;

    /* renamed from: j */
    protected String f8726j = null;

    /* renamed from: k */
    protected int f8727k = 0;

    /* renamed from: l */
    protected EnumC2214ab f8728l;

    /* renamed from: m */
    protected ChatFragment f8729m;

    /* renamed from: a */
    public C2437d m10561a(Handler handler) {
        this.f8717a = handler;
        return this;
    }

    /* renamed from: a */
    public C2437d m10562a(View view) {
        this.f8718b = view;
        return this;
    }

    /* renamed from: a */
    public C2437d m10566a(String str) {
        this.f8719c = str;
        return this;
    }

    /* renamed from: b */
    public C2437d m10568b(String str) {
        this.f8720d = str;
        return this;
    }

    /* renamed from: c */
    public C2437d m10569c(String str) {
        this.f8721e = str;
        return this;
    }

    /* renamed from: a */
    public C2437d m10567a(boolean z) {
        this.f8722f = z;
        return this;
    }

    /* renamed from: d */
    public C2437d m10570d(String str) {
        this.f8723g = str;
        return this;
    }

    /* renamed from: a */
    public C2437d m10560a(long j) {
        this.f8724h = j;
        return this;
    }

    /* renamed from: a */
    public C2437d m10565a(EnumC2300t enumC2300t) {
        this.f8725i = enumC2300t;
        return this;
    }

    /* renamed from: e */
    public C2437d m10571e(String str) {
        this.f8726j = str;
        return this;
    }

    /* renamed from: a */
    public C2437d m10559a(int i) {
        this.f8727k = i;
        return this;
    }

    /* renamed from: a */
    public C2437d m10564a(EnumC2214ab enumC2214ab) {
        this.f8728l = enumC2214ab;
        return this;
    }

    /* renamed from: a */
    public C2437d m10563a(ChatFragment chatFragment) {
        this.f8729m = chatFragment;
        return this;
    }

    /* renamed from: a */
    public AsyncTaskC2436c m10558a() {
        return new AsyncTaskC2436c(this);
    }
}
