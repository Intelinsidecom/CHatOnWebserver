package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import android.view.View;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;

/* compiled from: FileDownloadTask2.java */
/* renamed from: com.sec.chaton.d.a.aa */
/* loaded from: classes.dex */
public class C0533aa {

    /* renamed from: a */
    protected Handler f2164a = null;

    /* renamed from: b */
    protected View f2165b = null;

    /* renamed from: c */
    protected String f2166c = null;

    /* renamed from: d */
    protected String f2167d = null;

    /* renamed from: e */
    protected String f2168e = null;

    /* renamed from: f */
    protected boolean f2169f = false;

    /* renamed from: g */
    protected String f2170g = null;

    /* renamed from: h */
    protected long f2171h = 0;

    /* renamed from: i */
    protected EnumC0695j f2172i = EnumC0695j.ONETOONE;

    /* renamed from: j */
    protected String f2173j = null;

    /* renamed from: k */
    protected int f2174k = 0;

    /* renamed from: l */
    protected EnumC0699n f2175l;

    /* renamed from: m */
    ChatFragment f2176m;

    /* renamed from: a */
    public C0533aa m2715a(Handler handler) {
        this.f2164a = handler;
        return this;
    }

    /* renamed from: a */
    public C0533aa m2716a(View view) {
        this.f2165b = view;
        return this;
    }

    /* renamed from: a */
    public C0533aa m2720a(String str) {
        this.f2166c = str;
        return this;
    }

    /* renamed from: b */
    public C0533aa m2723b(String str) {
        this.f2167d = str;
        return this;
    }

    /* renamed from: c */
    public C0533aa m2724c(String str) {
        this.f2168e = str;
        return this;
    }

    /* renamed from: a */
    public C0533aa m2721a(boolean z) {
        this.f2169f = z;
        return this;
    }

    /* renamed from: d */
    public C0533aa m2725d(String str) {
        this.f2170g = str;
        return this;
    }

    /* renamed from: a */
    public C0533aa m2714a(long j) {
        this.f2171h = j;
        return this;
    }

    /* renamed from: a */
    public C0533aa m2718a(EnumC0695j enumC0695j) {
        this.f2172i = enumC0695j;
        return this;
    }

    /* renamed from: e */
    public C0533aa m2726e(String str) {
        this.f2173j = str;
        return this;
    }

    /* renamed from: a */
    public C0533aa m2713a(int i) {
        this.f2174k = i;
        return this;
    }

    /* renamed from: a */
    public C0533aa m2719a(EnumC0699n enumC0699n) {
        this.f2175l = enumC0699n;
        return this;
    }

    /* renamed from: a */
    public C0533aa m2717a(ChatFragment chatFragment) {
        this.f2176m = chatFragment;
        return this;
    }

    /* renamed from: a */
    public AsyncTaskC0608x m2722a() {
        return new AsyncTaskC0608x(this);
    }
}
