package com.sec.chaton.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;

/* loaded from: classes.dex */
public class ActivityDisclaimerGlobal extends BaseSinglePaneActivity {

    /* renamed from: n */
    private String f11543n;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f11543n = C4809aa.m18104a().m18121a("country_letter", "");
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        if (C4822an.m18243k() != null || TextUtils.isEmpty(this.f11543n)) {
            m18784t().mo18824a(false);
            m18784t().mo18833d(false);
        }
        return new FragmentDisclaimerGlobal();
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
        return TextUtils.isEmpty(this.f11543n) ? R.style.AppTheme_WithoutArrow : R.style.AppTheme;
    }
}
