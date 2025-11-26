package com.sec.chaton.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public abstract class BaseSinglePaneActivity extends BaseActivity {

    /* renamed from: n */
    private Fragment f3348n;

    /* renamed from: o */
    private boolean f3349o = false;

    /* renamed from: f */
    protected abstract Fragment mo2967f();

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_singlepane);
        if (bundle == null) {
            this.f3348n = mo2967f();
            if (this.f3348n != null) {
                this.f3348n.setArguments(m6158a(getIntent()));
                m50e().mo183a().mo96a(R.id.fragment_controller, this.f3348n, "com.sec.chaton:single_pane_fragment").mo99b();
            }
        }
    }

    /* renamed from: g */
    protected Fragment m6162g() {
        return m50e().mo182a("com.sec.chaton:single_pane_fragment");
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (C4904y.f17872b) {
            C4904y.m18639b("onActivityResult", "com.sec.chaton:single_pane_fragment");
        }
        this.f3349o = true;
    }
}
