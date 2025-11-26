package com.sec.chaton.calllog.view;

import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.InterfaceC4876cn;

/* loaded from: classes.dex */
public class CallLogDetailActivity extends BaseSinglePaneActivity implements InterfaceC1479j, InterfaceC4876cn {
    @Override // com.sec.chaton.calllog.view.InterfaceC1479j
    /* renamed from: h */
    public void mo7657h() {
        finish();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new CallLogDetailFragment();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.AppTheme_Setting;
    }
}
