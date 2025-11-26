package com.sec.chaton.buddy;

import android.R;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class BuddyGroupProfileActivity extends BaseSinglePaneActivity implements InterfaceC0598db {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        return new BuddyGroupProfileFragment();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.buddy.InterfaceC0598db
    /* renamed from: b */
    public void mo3453b(int i) {
        C3250y.m11458g("mGroup member Count: " + i, "BuddyGroupProfileActivity");
        if (m3089b() instanceof InterfaceC0651dp) {
            ((InterfaceC0651dp) m3089b()).mo3508c(i);
        }
        setTitle(getString(com.sec.chaton.R.string.buddy_group_profile_title, new Object[]{Integer.valueOf(i)}));
    }

    @Override // com.sec.chaton.buddy.InterfaceC0598db
    /* renamed from: a */
    public void mo3452a(int i) {
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m3080a(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3080a(this);
    }
}
