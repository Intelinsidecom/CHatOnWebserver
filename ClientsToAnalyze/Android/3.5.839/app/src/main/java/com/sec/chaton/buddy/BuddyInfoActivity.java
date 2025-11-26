package com.sec.chaton.buddy;

import android.R;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.MenuItem;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class BuddyInfoActivity extends BaseSinglePaneActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public BuddyInfoFragment mo2967f() {
        return new BuddyInfoFragment();
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

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (getIntent().getIntExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 0) == 21) {
            BaseActivity.m6159a(this);
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (getIntent().getIntExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 0) == 21) {
            BaseActivity.m6159a(this);
        }
    }
}
