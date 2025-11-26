package com.sec.chaton.registration;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class ActivityDisclaimer extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        return new FragmentDisclaimer();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        GlobalApplication.m6449a(this);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getDefaultTheme() {
        return R.style.AppTheme_Dialog;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getBlackTheme() {
        return R.style.AppTheme_Dialog;
    }
}
