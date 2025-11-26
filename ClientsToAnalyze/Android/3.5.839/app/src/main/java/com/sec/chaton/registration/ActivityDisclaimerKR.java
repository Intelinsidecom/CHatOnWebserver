package com.sec.chaton.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C4809aa;

/* loaded from: classes.dex */
public class ActivityDisclaimerKR extends BaseSinglePaneActivity {

    /* renamed from: n */
    String f11544n;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f11544n = C4809aa.m18104a().m18121a("country_letter", "");
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        if (TextUtils.isEmpty(this.f11544n)) {
            m18784t().mo18824a(false);
            m18784t().mo18833d(false);
        }
        return new FragmentDisclaimerKR();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        setResult(2, new Intent());
        finish();
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return TextUtils.isEmpty(this.f11544n) ? R.style.AppTheme_WithoutArrow : R.style.AppTheme;
    }
}
