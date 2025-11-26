package com.sec.chaton.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.C0062R;

/* loaded from: classes.dex */
public abstract class BaseSinglePaneActivity extends BaseActivity {
    private Fragment mFragment;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.activity_singlepane_base);
        if (bundle == null) {
            this.mFragment = onCreatePane();
            this.mFragment.setArguments(intentToFragmentArgument(getIntent()));
            getSupportFragmentManager().mo6a().mo11a(C0062R.id.root_container, this.mFragment).mo10a();
        }
    }

    protected abstract Fragment onCreatePane();
}
