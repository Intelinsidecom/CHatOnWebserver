package com.sec.chaton.calllog.view;

import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class ShowConferenceMemberList extends BaseSinglePaneActivity implements InterfaceC1467ai {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new ShowConferenceMemberListFragment();
    }

    @Override // com.sec.chaton.calllog.view.InterfaceC1467ai
    /* renamed from: h */
    public void mo7763h() {
        finish();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.AppTheme_Setting;
    }
}
