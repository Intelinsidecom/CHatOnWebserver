package com.sec.chaton.buddy;

import android.R;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class BuddyProfileImageView extends BaseSinglePaneActivity {

    /* renamed from: n */
    public static String f4020n = "";

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new BuddyProfileImageViewFragment(getIntent().getExtras().getString("PROFILE_BUDDY_NO"), getIntent().getExtras().getString("PROFILE_BUDDY_IMAGE_ID"), getIntent().getExtras().getString("PROFILE_BUDDY_IMAGE_TYPE"));
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        String stringExtra = getIntent().getStringExtra("PROFILE_BUDDY_PROFILE_IMAGE_CALL_PREVIEW");
        if (stringExtra != null && stringExtra.equalsIgnoreCase("PROFILE_BUDDY_PROFILE_IMAGE_CALL_PREVUEW_VALUE")) {
            m6159a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        String stringExtra = getIntent().getStringExtra("PROFILE_BUDDY_PROFILE_IMAGE_CALL_PREVIEW");
        if (stringExtra != null && stringExtra.equalsIgnoreCase("PROFILE_BUDDY_PROFILE_IMAGE_CALL_PREVUEW_VALUE")) {
            m6159a(this);
        }
    }
}
