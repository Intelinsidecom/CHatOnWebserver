package com.sec.chaton.userprofile;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C3250y;
import com.sec.common.actionbar.AbstractC3284a;

/* loaded from: classes.dex */
public class ProfileImageHistoryActivity extends BaseSinglePaneActivity {

    /* renamed from: a */
    public static String f11195a = "";

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        if (getIntent().getExtras() != null && getIntent().getExtras().getString("PROFILE_BUDDY_NO") != null) {
            return new ProfileImageHistoryFragment(getIntent().getExtras().getString("PROFILE_BUDDY_NO"), getIntent().getExtras().getString("PROFILE_BUDDY_IMAGE_ID"), getIntent().getExtras().getString("PROFILE_BUDDY_IMAGE_TYPE"));
        }
        if (getIntent().getExtras() != null && getIntent().getExtras().getString("PROFILE_BUDDY_IMAGE_TYPE") == null) {
            int i = getIntent().getExtras().getInt("mSmallImageNum");
            C3250y.m11456e("SmallImageNum: " + i, getClass().getSimpleName());
            return new ProfileImageHistoryFragment(i);
        }
        return new ProfileImageHistoryFragment();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* renamed from: c */
    public AbstractC3284a m10781c() {
        return m11543k();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        BaseActivity.m3080a(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        BaseActivity.m3080a(this);
    }
}
