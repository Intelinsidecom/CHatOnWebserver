package com.sec.chaton.registration;

import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C3159aa;

/* loaded from: classes.dex */
public class ActivityRegistPushName extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        if (!C3159aa.m10962a().m10979a("provisioning_sns_login_state", "").equals("DONE")) {
            m11543k().mo11584a(false);
            m11543k().mo11593d(false);
        }
        return new FragmentRegistPushName();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        setResult(2);
        finish();
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getDefaultTheme() {
        return R.style.AppTheme_WithoutArrow;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getBlackTheme() {
        return R.style.AppTheme_Black_WithoutArrow;
    }
}
