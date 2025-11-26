package com.sec.chaton.event;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class UsingChatONDialogActivity extends BaseSinglePaneActivity implements InterfaceC2328i {

    /* renamed from: n */
    private Fragment f8254n;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        this.f8254n = new UsingChatONDialogFragment();
        return this.f8254n;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.NewFeatureTheme;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getBlackTheme() {
        return R.style.NewFeatureTheme;
    }

    @Override // com.sec.chaton.event.InterfaceC2328i
    /* renamed from: b */
    public void mo10242b(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("key_register_now", z);
        setResult(-1, intent);
        finish();
    }
}
