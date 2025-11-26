package com.sec.chaton.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.util.ActivityHelper;

/* loaded from: classes.dex */
public class BaseActivity extends FragmentActivity {
    final ActivityHelper mActivityHelper = ActivityHelper.m3461a(this);

    public static Bundle intentToFragmentArgument(Intent intent) {
        Bundle bundle = new Bundle();
        if (intent != null && intent.getExtras() != null) {
            bundle.putAll(intent.getExtras());
        }
        return bundle;
    }

    protected ActivityHelper getActivityHelper() {
        return this.mActivityHelper;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return this.mActivityHelper.m3463a(menu) || super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mActivityHelper.m3464a(menuItem) || super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.mActivityHelper.m3462a(bundle);
    }

    public void openActivityOrFragment(Intent intent) {
        startActivity(intent);
    }
}
