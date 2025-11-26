package com.sec.chaton;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class SelectCountry extends BaseSinglePaneActivity {

    /* renamed from: n */
    private boolean f2005n;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new FragmentSelectCountry();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 100:
                if (!this.f2005n) {
                    setResult(11);
                    finish();
                    break;
                }
                break;
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f2005n = true;
        super.onDestroy();
    }
}
