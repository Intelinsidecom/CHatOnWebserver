package com.sec.chaton.settings.moreapps;

import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.base.InterfaceC1061c;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class EventActivity extends BaseSinglePaneActivity {

    /* renamed from: n */
    static final String f13242n = BaseSinglePaneActivity.class.getSimpleName();

    /* renamed from: o */
    private InterfaceC1061c f13243o;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        EventFragment eventFragment = new EventFragment();
        if (eventFragment instanceof InterfaceC1061c) {
            this.f13243o = eventFragment;
        }
        return eventFragment;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f13243o = null;
        super.onDestroy();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        boolean zOnBackKeyPressed = false;
        if (this.f13243o != null) {
            zOnBackKeyPressed = this.f13243o.onBackKeyPressed();
        }
        if (!zOnBackKeyPressed) {
            try {
                super.onBackPressed();
            } catch (IllegalStateException e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.AppTheme_NoTitleBar;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getBlackTheme() {
        return R.style.AppTheme_NoTitleBar;
    }
}
