package com.sec.chaton.coolots;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import com.coolots.sso.p003a.InterfaceC0038a;

/* compiled from: CommonBindService.java */
/* renamed from: com.sec.chaton.coolots.a */
/* loaded from: classes.dex */
public abstract class AbstractC0521a {

    /* renamed from: a */
    protected String f2134a;

    /* renamed from: b */
    protected Context f2135b;

    /* renamed from: c */
    protected InterfaceC0523c f2136c;

    /* renamed from: d */
    protected InterfaceC0038a f2137d;

    /* renamed from: e */
    private ServiceConnection f2138e = new ServiceConnectionC0522b(this);

    /* renamed from: c */
    abstract boolean mo2700c();

    public AbstractC0521a(Context context, InterfaceC0523c interfaceC0523c, String str) {
        this.f2135b = context;
        this.f2136c = interfaceC0523c;
        this.f2134a = str;
    }

    /* renamed from: a */
    public static boolean m2697a(Context context) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo("com.coolots.chaton", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean m2698a() {
        Intent intent = new Intent("com.coolots.sso.aidl.ISCOServiceBind");
        intent.putExtra("packageName", this.f2135b.getPackageName());
        boolean zBindService = this.f2135b.bindService(intent, this.f2138e, 1);
        Log.i(this.f2134a, "Service Binded. " + zBindService);
        if (!zBindService) {
            m2699b();
        }
        return zBindService;
    }

    /* renamed from: b */
    protected void m2699b() {
        this.f2135b.unbindService(this.f2138e);
        Log.i(this.f2134a, "Service Unbinded.");
    }

    /* renamed from: d */
    protected boolean m2701d() {
        return true;
    }
}
