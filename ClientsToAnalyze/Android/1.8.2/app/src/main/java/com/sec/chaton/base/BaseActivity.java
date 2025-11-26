package com.sec.chaton.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.BlackScreenNotification;
import com.sec.chaton.util.C1717a;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.ScreenOnNotification;

/* loaded from: classes.dex */
public class BaseActivity extends FragmentActivity {

    /* renamed from: g */
    public static final String f772g = HomeActivity.class.getSimpleName();

    /* renamed from: h */
    public static boolean f773h = false;

    /* renamed from: f */
    final C1717a f774f = C1717a.m5866a(this);

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f774f.m5867a(bundle);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return this.f774f.mo5868a(menu) || super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.f774f.m5869a(menuItem) || super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: a */
    public void mo1830a(Intent intent) {
        startActivity(intent);
    }

    /* renamed from: a */
    public static void m1827a(Fragment fragment, boolean z) {
        if (!GlobalApplication.m3265f()) {
            fragment.setHasOptionsMenu(z);
        }
    }

    /* renamed from: b */
    public static void m1829b(Fragment fragment, boolean z) {
        if (GlobalApplication.m3265f()) {
            fragment.setHasOptionsMenu(z);
        }
    }

    /* renamed from: b */
    public static Bundle m1828b(Intent intent) {
        Bundle extras;
        Bundle bundle = new Bundle();
        if (intent != null && (extras = intent.getExtras()) != null) {
            bundle.putAll(extras);
        }
        return bundle;
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", f772g);
        C1781m.m6022b(getApplicationContext());
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!ScreenOnNotification.f6289a && !BlackScreenNotification.f6234a) {
            m1826a();
            f773h = true;
        }
    }

    /* renamed from: a */
    private void m1826a() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
