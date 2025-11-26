package com.sec.chaton.base;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.sec.multiwindow.MultiWindow;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.InterfaceC4876cn;
import com.sec.common.actionbar.ActionBarFragmentActivity;

/* loaded from: classes.dex */
public class BaseActivity extends ActionBarFragmentActivity implements InterfaceC4876cn {

    /* renamed from: n */
    private static final String f3347n = BaseActivity.class.getSimpleName();

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        if (C4904y.f17872b) {
            C4904y.m18639b(getClass().getSimpleName() + ".onCreate() " + getIntent() + "isTaskRoot: " + isTaskRoot() + ", savedInstanceStatue: " + bundle + ", " + getIntent().hashCode(), f3347n);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        C1059a.m6163a(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C1059a.m6169e(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C1059a.m6166b(this);
        if (C4904y.f17872b) {
            C4904y.m18639b(getClass().getSimpleName() + ".onResume() " + getIntent() + ", " + getIntent().hashCode(), f3347n);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        C1059a.m6167c(this);
        if (C4904y.f17872b) {
            C4904y.m18639b(getClass().getSimpleName() + ".onPause() " + getIntent() + ", " + getIntent().hashCode(), f3347n);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        C1059a.m6170f(this);
        if (C4904y.f17872b) {
            C4904y.m18639b(getClass().getSimpleName() + ".onStop() " + getIntent() + ", " + getIntent().hashCode(), f3347n);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C1059a.m6171g(this);
        if (C4904y.f17872b) {
            C4904y.m18639b(getClass().getSimpleName() + ".onDestroy() " + getIntent() + ", " + getIntent().hashCode(), f3347n);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (C4904y.f17872b) {
            C4904y.m18639b(getClass().getSimpleName() + ".onNewIntent() " + getIntent() + ", " + getIntent().hashCode(), f3347n);
            Bundle extras = intent.getExtras();
            if (extras != null) {
                for (String str : extras.keySet()) {
                    C4904y.m18639b(" > " + str + ": " + extras.get(str), f3347n);
                }
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (C4904y.f17872b) {
            C4904y.m18639b(getClass().getSimpleName() + ".onSaveInstanceState() " + getIntent() + ", " + bundle, f3347n);
        }
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        return super.onSupportOptionsItemSelected(menuItem);
    }

    /* renamed from: a */
    public static void m6160a(Fragment fragment, boolean z) {
        if (fragment != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("setPhoneHasOptionMenu() Fragment[" + fragment.getClass().getSimpleName() + "], Flag[" + z + "]", BaseActivity.class.getSimpleName());
            }
            fragment.setHasOptionsMenu(z);
        }
    }

    /* renamed from: a */
    public static Bundle m6158a(Intent intent) {
        Bundle extras;
        Bundle bundle = new Bundle();
        if (intent != null && (extras = intent.getExtras()) != null) {
            bundle.putAll(extras);
        }
        return bundle;
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        C1059a.m6168d(this);
    }

    /* renamed from: a */
    public static void m6159a(Activity activity) throws Resources.NotFoundException {
        int i = -1;
        if (!m6161b(activity) && GlobalApplication.m10286e()) {
            Resources resources = GlobalApplication.m18732r().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.floating_window_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.floating_window_height);
            if (resources.getConfiguration().orientation != 1) {
                dimensionPixelSize2 = -1;
                i = dimensionPixelSize;
            }
            activity.getWindow().setLayout(i, dimensionPixelSize2);
        }
    }

    /* renamed from: b */
    public static boolean m6161b(Activity activity) {
        return activity != null && GlobalApplication.m10288g() && MultiWindow.createInstance(activity).isMultiWindow();
    }

    public int getDefaultTheme() {
        return R.style.AppTheme;
    }

    @Deprecated
    public int getBlackTheme() {
        return getDefaultTheme();
    }
}
