package com.sec.chaton.localbackup;

import android.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class ActivitySecretKey extends BaseSinglePaneActivity implements InterfaceC2515ab {

    /* renamed from: n */
    private SecretKeyView f8995n;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        this.f8995n = new SecretKeyView();
        return this.f8995n;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.localbackup.InterfaceC2515ab
    /* renamed from: b */
    public void mo10835b(boolean z) {
        if (z) {
            m10836h();
        }
        finish();
    }

    /* renamed from: h */
    public void m10836h() {
        setResult(-1);
    }
}
