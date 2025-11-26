package com.sec.chaton.calllog.view;

import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.InterfaceC3226cn;

/* loaded from: classes.dex */
public class CallLogDetailActivity extends BaseSinglePaneActivity implements InterfaceC0868j, InterfaceC3226cn {
    @Override // com.sec.chaton.calllog.view.InterfaceC0868j
    /* renamed from: c */
    public void mo4503c() {
        finish();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        return new CallLogDetailFragment();
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
