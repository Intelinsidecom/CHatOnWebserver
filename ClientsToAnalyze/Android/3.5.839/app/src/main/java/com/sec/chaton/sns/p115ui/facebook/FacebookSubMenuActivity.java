package com.sec.chaton.sns.p115ui.facebook;

import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class FacebookSubMenuActivity extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new FacebookSubMenuFragment();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
