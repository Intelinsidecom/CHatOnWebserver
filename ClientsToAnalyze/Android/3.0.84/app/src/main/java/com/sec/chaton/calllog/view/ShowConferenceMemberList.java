package com.sec.chaton.calllog.view;

import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class ShowConferenceMemberList extends BaseSinglePaneActivity implements InterfaceC0856ai {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        return new ShowConferenceMemberListFragment();
    }

    @Override // com.sec.chaton.calllog.view.InterfaceC0856ai
    /* renamed from: c */
    public void mo4607c() {
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
