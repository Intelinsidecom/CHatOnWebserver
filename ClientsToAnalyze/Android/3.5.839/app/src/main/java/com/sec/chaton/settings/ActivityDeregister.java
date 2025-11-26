package com.sec.chaton.settings;

import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C4822an;

/* loaded from: classes.dex */
public class ActivityDeregister extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        if (C4822an.m18218a()) {
            if (!C4822an.m18255w()) {
                setTitle(getResources().getString(R.string.delete_account));
            }
        } else {
            setTitle(getResources().getString(R.string.setting_termination_of_service));
        }
        return new DeregisterFragment();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
