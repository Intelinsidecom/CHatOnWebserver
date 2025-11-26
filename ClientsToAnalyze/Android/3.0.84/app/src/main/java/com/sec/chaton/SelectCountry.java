package com.sec.chaton;

import android.support.v4.app.Fragment;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class SelectCountry extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        return new FragmentSelectCountry();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
