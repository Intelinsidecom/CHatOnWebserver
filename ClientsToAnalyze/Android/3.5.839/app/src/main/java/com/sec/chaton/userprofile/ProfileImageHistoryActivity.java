package com.sec.chaton.userprofile;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C4904y;
import com.sec.common.actionbar.AbstractC4946a;

/* loaded from: classes.dex */
public class ProfileImageHistoryActivity extends BaseSinglePaneActivity {

    /* renamed from: n */
    public static String f17280n = "";

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        if (getIntent().getExtras() != null && getIntent().getExtras().getString("PROFILE_BUDDY_NO") != null) {
            return new ProfileImageHistoryFragment(getIntent().getExtras().getString("PROFILE_BUDDY_NO"), getIntent().getExtras().getString("PROFILE_BUDDY_IMAGE_ID"), getIntent().getExtras().getString("PROFILE_BUDDY_IMAGE_TYPE"));
        }
        if (getIntent().getExtras() != null && getIntent().getExtras().getString("PROFILE_BUDDY_IMAGE_TYPE") == null) {
            int i = getIntent().getExtras().getInt("mSmallImageNum");
            C4904y.m18646e("SmallImageNum: " + i, getClass().getSimpleName());
            return new ProfileImageHistoryFragment(i);
        }
        return new ProfileImageHistoryFragment();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* renamed from: h */
    public AbstractC4946a m17933h() {
        return m18784t();
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
