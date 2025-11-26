package com.sec.chaton.base;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3226cn;
import com.sec.common.actionbar.ActionBarFragmentActivity;

/* loaded from: classes.dex */
public class BaseActivity extends ActionBarFragmentActivity implements InterfaceC3226cn {

    /* renamed from: a */
    private static final String f1524a = BaseActivity.class.getSimpleName();

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        if (C3250y.f11734b) {
            C3250y.m11450b(getClass().getSimpleName() + ".onCreate() " + getIntent() + "isTaskRoot: " + isTaskRoot() + ", savedInstanceStatue: " + bundle + ", " + getIntent().hashCode(), f1524a);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C3250y.f11734b) {
            C3250y.m11450b(getClass().getSimpleName() + ".onResume() " + getIntent() + ", " + getIntent().hashCode(), f1524a);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (C3250y.f11734b) {
            C3250y.m11450b(getClass().getSimpleName() + ".onPause() " + getIntent() + ", " + getIntent().hashCode(), f1524a);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (C3250y.f11734b) {
            C3250y.m11450b(getClass().getSimpleName() + ".onStop() " + getIntent() + ", " + getIntent().hashCode(), f1524a);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (C3250y.f11734b) {
            C3250y.m11450b(getClass().getSimpleName() + ".onDestroy() " + getIntent() + ", " + getIntent().hashCode(), f1524a);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (C3250y.f11734b) {
            C3250y.m11450b(getClass().getSimpleName() + ".onNewIntent() " + getIntent() + ", " + getIntent().hashCode(), f1524a);
            Bundle extras = intent.getExtras();
            if (extras != null) {
                for (String str : extras.keySet()) {
                    C3250y.m11450b(" > " + str + ": " + extras.get(str), f1524a);
                }
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (C3250y.f11734b) {
            C3250y.m11450b(getClass().getSimpleName() + ".onSaveInstanceState() " + getIntent() + ", " + bundle, f1524a);
        }
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        return super.onSupportOptionsItemSelected(menuItem);
    }

    /* renamed from: a */
    public void mo3084a(Intent intent) {
        startActivity(intent);
    }

    /* renamed from: a */
    public static void m3081a(Fragment fragment, boolean z) {
        fragment.setHasOptionsMenu(z);
    }

    /* renamed from: b */
    public static void m3083b(Fragment fragment, boolean z) {
        if (GlobalApplication.m6456e()) {
            fragment.setHasOptionsMenu(z);
        }
    }

    /* renamed from: b */
    public static Bundle m3082b(Intent intent) {
        Bundle extras;
        Bundle bundle = new Bundle();
        if (intent != null && (extras = intent.getExtras()) != null) {
            bundle.putAll(extras);
        }
        return bundle;
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", getClass().getSimpleName());
        C3241p.m11402b(getApplicationContext());
    }

    /* renamed from: a */
    public static void m3080a(Activity activity) throws Resources.NotFoundException {
        int i = -1;
        if (GlobalApplication.m6456e()) {
            Resources resources = GlobalApplication.m11493l().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.floating_window_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.floating_window_height);
            if (resources.getConfiguration().orientation != 1) {
                dimensionPixelSize2 = -1;
                i = dimensionPixelSize;
            }
            activity.getWindow().setLayout(i, dimensionPixelSize2);
        }
    }

    public int getDefaultTheme() {
        return R.style.AppTheme;
    }

    public int getBlackTheme() {
        return R.style.AppTheme_Black;
    }
}
