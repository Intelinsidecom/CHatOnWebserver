package com.sec.chaton.smsplugin.p112ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.common.actionbar.AbstractC4946a;

/* loaded from: classes.dex */
public class ThreadSelectionActivity extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new ThreadSelectionFragment();
    }

    /* renamed from: h */
    public AbstractC4946a m16245h() {
        return m18784t();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        super.onSupportCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.thread_selection_menu, menu);
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        boolean zOnSupportOptionsItemSelected = super.onSupportOptionsItemSelected(menuItem);
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return zOnSupportOptionsItemSelected;
    }

    /* renamed from: i */
    public void m16246i() {
        finish();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        BaseActivity.m6159a(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        BaseActivity.m6159a(this);
    }
}
