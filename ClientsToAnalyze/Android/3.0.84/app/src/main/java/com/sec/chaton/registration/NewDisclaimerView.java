package com.sec.chaton.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C3159aa;

/* loaded from: classes.dex */
public class NewDisclaimerView extends BaseSinglePaneActivity {

    /* renamed from: a */
    String f8376a;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f8376a = C3159aa.m10962a().m10979a("country_letter", "");
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        if (TextUtils.isEmpty(this.f8376a)) {
            m11543k().mo11584a(false);
            m11543k().mo11593d(false);
        }
        return new NewDisclaimerFragment();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        setResult(2, new Intent());
        finish();
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getDefaultTheme() {
        return TextUtils.isEmpty(this.f8376a) ? R.style.AppTheme_WithoutArrow : R.style.AppTheme;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getBlackTheme() {
        return TextUtils.isEmpty(this.f8376a) ? R.style.AppTheme_Black_WithoutArrow : R.style.AppTheme_Black;
    }
}
