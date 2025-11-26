package com.sec.chaton.specialbuddy;

import android.os.Bundle;
import android.view.MenuItem;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.base.InterfaceC1061c;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public abstract class AbstractChatONLiveActivity extends BaseSinglePaneActivity {

    /* renamed from: n */
    protected InterfaceC1061c f16280n;

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f16280n = null;
        super.onDestroy();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        boolean zOnBackKeyPressed = false;
        if (this.f16280n != null) {
            zOnBackKeyPressed = this.f16280n.onBackKeyPressed();
        }
        if (!zOnBackKeyPressed) {
            try {
                super.onBackPressed();
            } catch (IllegalStateException e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onCreate()", getClass().getSimpleName());
        }
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
