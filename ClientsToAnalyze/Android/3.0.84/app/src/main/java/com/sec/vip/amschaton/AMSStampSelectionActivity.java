package com.sec.vip.amschaton;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.CommonApplication;
import com.sec.vip.amschaton.fragment.AMSFragment;
import com.sec.vip.amschaton.fragment.AMSStampSelectionFragment;
import com.sec.vip.amschaton.fragment.InterfaceC3474av;

/* loaded from: classes.dex */
public class AMSStampSelectionActivity extends BaseSinglePaneActivity implements InterfaceC3474av {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        return new AMSStampSelectionFragment();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (GlobalApplication.m6456e()) {
            Resources resources = CommonApplication.m11493l().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ams_layout_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ams_layout_height);
            if (resources.getConfiguration().orientation == 1) {
                dimensionPixelSize = -1;
            }
            getWindow().setLayout(dimensionPixelSize, dimensionPixelSize2);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        boolean zOnSupportOptionsItemSelected = super.onSupportOptionsItemSelected(menuItem);
        if (!zOnSupportOptionsItemSelected && menuItem.getItemId() == 16908332) {
            ((AMSFragment) m3089b()).mo12415c();
            return true;
        }
        return zOnSupportOptionsItemSelected;
    }

    @Override // com.sec.vip.amschaton.fragment.InterfaceC3474av
    /* renamed from: c */
    public void mo11978c() {
        finish();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        ((AMSFragment) m3089b()).mo12415c();
        supportInvalidateOptionsMenu();
    }
}
