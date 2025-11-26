package com.sec.chaton.event;

import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class NewFeature extends BaseSinglePaneActivity implements InterfaceC2323d {

    /* renamed from: n */
    private Fragment f8243n;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        this.f8243n = new NewFeatureFragment();
        return this.f8243n;
    }

    @Override // com.sec.chaton.event.InterfaceC2323d
    /* renamed from: h */
    public void mo10232h() {
        finish();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.NewFeatureTheme_Dialog;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getBlackTheme() {
        return R.style.NewFeatureTheme_Dialog;
    }
}
