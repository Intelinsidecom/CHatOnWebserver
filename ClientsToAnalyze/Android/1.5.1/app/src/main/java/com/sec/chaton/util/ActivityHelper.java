package com.sec.chaton.util;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/* loaded from: classes.dex */
public class ActivityHelper {

    /* renamed from: a */
    protected Activity f3605a;

    protected ActivityHelper(Activity activity) {
        this.f3605a = activity;
    }

    /* renamed from: a */
    public static ActivityHelper m3461a(Activity activity) {
        return UIUtils.m3683a() ? new ActivityHelperHoneycomb(activity) : new ActivityHelper(activity);
    }

    /* renamed from: a */
    public void m3462a(Bundle bundle) {
    }

    /* renamed from: a */
    public boolean m3463a(Menu menu) {
        return false;
    }

    /* renamed from: a */
    public boolean m3464a(MenuItem menuItem) {
        return false;
    }
}
