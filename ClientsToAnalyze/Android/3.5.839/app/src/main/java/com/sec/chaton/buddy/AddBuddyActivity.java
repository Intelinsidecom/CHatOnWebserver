package com.sec.chaton.buddy;

import android.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C4892m;

/* loaded from: classes.dex */
public class AddBuddyActivity extends BaseSinglePaneActivity {

    /* renamed from: n */
    AddBuddyFragment f3504n;

    /* renamed from: o */
    private Menu f3505o = null;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        if ("com.sec.chaton.action.ADD_BUDDY".equals(getIntent().getAction())) {
            C4892m.m18577c(true);
        }
        this.f3504n = new AddBuddyFragment();
        return this.f3504n;
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportPrepareOptionsMenu(Menu menu) {
        super.onSupportPrepareOptionsMenu(menu);
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                finish();
                return true;
            default:
                return super.onSupportOptionsItemSelected(menuItem);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }
}
