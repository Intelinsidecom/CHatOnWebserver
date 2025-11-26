package com.sec.chaton.shop.inappbilling.p100a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.p025a.p026a.AbstractBinderC0355b;

/* compiled from: IabHelper.java */
/* renamed from: com.sec.chaton.shop.inappbilling.a.e */
/* loaded from: classes.dex */
class ServiceConnectionC3742e implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ InterfaceC3751n f13454a;

    /* renamed from: b */
    final /* synthetic */ C3741d f13455b;

    ServiceConnectionC3742e(C3741d c3741d, InterfaceC3751n interfaceC3751n) {
        this.f13455b = c3741d;
        this.f13454a = interfaceC3751n;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f13455b.m14122c("Billing service disconnected.");
        this.f13455b.m14120b();
        this.f13455b.f13448g = null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f13455b.m14122c("Billing service connected.");
        this.f13455b.f13448g = AbstractBinderC0355b.m1251a(iBinder);
        String packageName = this.f13455b.f13447f.getPackageName();
        try {
            this.f13455b.m14122c("Checking for in-app billing 3 support.");
            int iMo1246a = this.f13455b.f13448g.mo1246a(3, packageName, "inapp");
            if (iMo1246a != 0) {
                if (this.f13454a != null) {
                    this.f13454a.mo14095a(new C3753p(iMo1246a, "Error checking for billing v3 support."));
                }
            } else {
                this.f13455b.m14122c("In-app billing version 3 supported for " + packageName);
                this.f13455b.f13444c = true;
                if (this.f13454a != null) {
                    this.f13454a.mo14095a(new C3753p(0, "Setup successful."));
                }
            }
        } catch (RemoteException e) {
            if (this.f13454a != null) {
                this.f13454a.mo14095a(new C3753p(-1001, "RemoteException while setting up in-app billing."));
            }
            e.printStackTrace();
        }
    }
}
