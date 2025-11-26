package com.sec.chaton.samsungaccount;

import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class ActivitySamsungAccountLogIn extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new FragmentSamsungAccountLogin();
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
