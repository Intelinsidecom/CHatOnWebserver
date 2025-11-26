package com.sec.chaton.util;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.ArrayList;

/* compiled from: ProfileImageLoader.java */
/* renamed from: com.sec.chaton.util.by */
/* loaded from: classes.dex */
class HandlerThreadC3210by extends HandlerThread implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C3205bt f11585a;

    /* renamed from: b */
    private final Context f11586b;

    /* renamed from: c */
    private Handler f11587c;

    /* renamed from: d */
    private final ArrayList<C3211bz> f11588d;

    /* renamed from: e */
    private final ArrayList<C3211bz> f11589e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerThreadC3210by(C3205bt c3205bt, Context context) {
        super("ProfileDownloader");
        this.f11585a = c3205bt;
        this.f11588d = C3165ag.m11031a();
        this.f11589e = C3165ag.m11031a();
        this.f11586b = context;
    }

    /* renamed from: a */
    public void m11238a() {
        if (this.f11587c == null) {
            this.f11587c = new Handler(getLooper(), this);
        }
        this.f11587c.sendEmptyMessage(0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        m11237b();
        this.f11585a.f11570i.sendEmptyMessage(2);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x025f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0221 A[SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m11237b() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 628
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.HandlerThreadC3210by.m11237b():void");
    }
}
