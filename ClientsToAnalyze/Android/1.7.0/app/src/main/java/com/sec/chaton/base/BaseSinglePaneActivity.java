package com.sec.chaton.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public abstract class BaseSinglePaneActivity extends BaseActivity {

    /* renamed from: a */
    private Fragment f1020a;

    /* renamed from: a */
    protected abstract Fragment mo664a();

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_singlepane);
        if (bundle == null) {
            this.f1020a = mo664a();
            this.f1020a.setArguments(m2042b(getIntent()));
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_controller, this.f1020a, "com.sec.chaton:single_pane_fragment").commit();
        }
    }

    /* renamed from: e */
    protected Fragment m2047e() {
        return getSupportFragmentManager().findFragmentByTag("com.sec.chaton:single_pane_fragment");
    }
}
