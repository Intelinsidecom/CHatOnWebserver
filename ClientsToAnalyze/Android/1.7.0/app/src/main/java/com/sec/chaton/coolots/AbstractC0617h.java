package com.sec.chaton.coolots;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import com.coolots.sso.p003a.InterfaceC0048a;

/* compiled from: CommonBindService.java */
/* renamed from: com.sec.chaton.coolots.h */
/* loaded from: classes.dex */
public abstract class AbstractC0617h {

    /* renamed from: a */
    private ServiceConnection f2164a = new ServiceConnectionC0612c(this);

    /* renamed from: c */
    protected String f2165c;

    /* renamed from: d */
    protected Context f2166d;

    /* renamed from: e */
    protected InterfaceC0616g f2167e;

    /* renamed from: f */
    protected InterfaceC0048a f2168f;

    /* renamed from: a */
    abstract boolean mo2830a();

    public AbstractC0617h(Context context, InterfaceC0616g interfaceC0616g, String str) {
        this.f2166d = context;
        this.f2167e = interfaceC0616g;
        this.f2165c = str;
    }

    /* renamed from: a */
    public static boolean m2831a(Context context) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo("com.coolots.chaton", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: b */
    public boolean m2832b() {
        Intent intent = new Intent("com.coolots.sso.aidl.ISCOServiceBind");
        intent.putExtra("packageName", this.f2166d.getPackageName());
        boolean zBindService = this.f2166d.bindService(intent, this.f2164a, 1);
        Log.i(this.f2165c, "Service Binded. " + zBindService);
        if (!zBindService) {
            m2833c();
        }
        return zBindService;
    }

    /* renamed from: c */
    protected void m2833c() {
        this.f2166d.unbindService(this.f2164a);
        Log.i(this.f2165c, "Service Unbinded.");
    }

    /* renamed from: d */
    protected boolean m2834d() {
        return true;
    }
}
