package com.sec.chaton.registration;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class ActivitySelectLanguage extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        Bundle extras = getIntent().getExtras();
        if (extras != null ? extras.getBoolean(FragmentRegist.f11705a, false) : false) {
            setTitle(R.string.layout_regist_country_registration);
        }
        return new FragmentSelectLanguage();
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
