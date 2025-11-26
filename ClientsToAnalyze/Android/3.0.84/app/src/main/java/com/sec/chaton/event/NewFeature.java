package com.sec.chaton.event;

import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class NewFeature extends BaseSinglePaneActivity implements InterfaceC1469k {

    /* renamed from: a */
    private Fragment f5423a;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        this.f5423a = new NewFeatureFragment();
        return this.f5423a;
    }

    @Override // com.sec.chaton.event.InterfaceC1469k
    /* renamed from: c */
    public void mo6371c() {
        finish();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getDefaultTheme() {
        return R.style.NewFeatureTheme;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getBlackTheme() {
        return R.style.NewFeatureTheme;
    }
}
