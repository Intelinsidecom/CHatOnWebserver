package com.sec.chaton.settings;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class ActivityMultiDeviceView extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        if (getIntent().getBooleanExtra("request_max_device", false)) {
            setTitle(R.string.deregister_device);
        }
        return new FragmentMultiDeviceView();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        if (((FragmentMultiDeviceView) m6162g()) != null && ((FragmentMultiDeviceView) m6162g()).m13590a()) {
            setResult(-1, new Intent());
        }
        finish();
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (((FragmentMultiDeviceView) m6162g()) != null && ((FragmentMultiDeviceView) m6162g()).m13590a()) {
            setResult(-1, new Intent());
            finish();
        } else {
            super.onBackPressed();
        }
    }
}
