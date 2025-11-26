package com.sec.chaton;

import android.content.pm.PackageManager;
import android.os.Build;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.InterfaceC1288ak;

/* compiled from: HomeActivity.java */
/* renamed from: com.sec.chaton.g */
/* loaded from: classes.dex */
class C0708g implements InterfaceC1288ak {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f2401a;

    C0708g(HomeActivity homeActivity) {
        this.f2401a = homeActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC1288ak
    /* renamed from: a */
    public boolean mo3044a() throws PackageManager.NameNotFoundException {
        boolean z;
        boolean z2;
        try {
            GlobalApplication.m3100a().getPackageManager().getPackageInfo("com.sec.android.app.samsungapps", 0);
            z = true;
        } catch (PackageManager.NameNotFoundException e) {
            z = false;
        }
        try {
            GlobalApplication.m3100a().getPackageManager().getPackageInfo("com.coolots.chaton", 0);
            z2 = true;
        } catch (PackageManager.NameNotFoundException e2) {
            z2 = false;
        }
        if (z && !z2 && Integer.parseInt(Build.VERSION.SDK) >= 14) {
            new AsyncTaskC0242ae(this.f2401a, null).execute(new Void[0]);
        }
        return true;
    }
}
