package com.sec.chaton.mobileweb;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.InterfaceC1061c;

/* loaded from: classes.dex */
public class GeneralWebActivity extends BaseActivity {

    /* renamed from: n */
    private static final String f9197n = GeneralWebActivity.class.getSimpleName();

    /* renamed from: o */
    private InterfaceC1061c f9198o;

    /* renamed from: p */
    private GeneralWebFragment f9199p;

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_singlepane);
        Intent intent = getIntent();
        if (intent != null) {
            if (m50e().mo187c() == null || m50e().mo187c().size() <= 0) {
                if (this.f9199p == null) {
                    this.f9199p = new GeneralWebFragment();
                }
                this.f9198o = this.f9199p;
                GeneralWebFragment generalWebFragment = this.f9199p;
                generalWebFragment.setArguments(m6158a(intent));
                m50e().mo183a().mo96a(R.id.fragment_controller, generalWebFragment, f9197n).mo99b();
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        boolean zOnBackKeyPressed = false;
        if (this.f9198o != null) {
            zOnBackKeyPressed = this.f9198o.onBackKeyPressed();
        }
        if (!zOnBackKeyPressed) {
            super.onBackPressed();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }
}
