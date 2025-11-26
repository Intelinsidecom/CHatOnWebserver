package com.sec.chaton.settings.downloads;

import android.R;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.base.InterfaceC0460e;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class ActivityFontDownloads extends BaseSinglePaneActivity {

    /* renamed from: a */
    private InterfaceC0460e f9407a;

    /* renamed from: b */
    private FontDownloads f9408b;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        this.f9408b = new FontDownloads();
        this.f9407a = this.f9408b;
        return this.f9408b;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f9407a == null || !this.f9407a.mo3095a(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                if (this.f9408b != null) {
                    this.f9408b.m9358a();
                    break;
                }
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }
}
