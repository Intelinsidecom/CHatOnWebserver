package com.sec.chaton.calllog.view;

import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class CallLogActivity extends BaseSinglePaneActivity implements InterfaceC0880t {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        return new CallLogFragment();
    }

    @Override // com.sec.chaton.calllog.view.InterfaceC0880t
    /* renamed from: c */
    public void mo4502c() {
        finish();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getDefaultTheme() {
        return R.style.AppTheme_Setting;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getBlackTheme() {
        return R.style.AppTheme_Black_Setting;
    }
}
