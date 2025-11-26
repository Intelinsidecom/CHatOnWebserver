package com.sec.chaton.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1342q;

/* loaded from: classes.dex */
public class BaseActivity extends FragmentActivity {

    /* renamed from: h */
    final C1342q f1019h = C1342q.m4665a(this);

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f1019h.m4666a(bundle);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return this.f1019h.m4667a(menu) || super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.f1019h.m4668a(menuItem) || super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: a */
    public void mo2044a(Intent intent) {
        startActivity(intent);
    }

    /* renamed from: a */
    public static void m2041a(Fragment fragment, boolean z) {
        fragment.setHasOptionsMenu(z);
    }

    /* renamed from: b */
    public static void m2043b(Fragment fragment, boolean z) {
        if (GlobalApplication.m3109j()) {
            fragment.setHasOptionsMenu(z);
        }
    }

    /* renamed from: b */
    public static Bundle m2042b(Intent intent) {
        Bundle extras;
        Bundle bundle = new Bundle();
        if (intent != null && (extras = intent.getExtras()) != null) {
            bundle.putAll(extras);
        }
        return bundle;
    }
}
