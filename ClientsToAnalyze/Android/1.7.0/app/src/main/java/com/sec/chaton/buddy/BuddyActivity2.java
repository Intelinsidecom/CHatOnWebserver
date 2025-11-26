package com.sec.chaton.buddy;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.base.C0353a;
import com.sec.chaton.chat.InterfaceC0531ag;
import com.sec.widget.C1632t;

/* loaded from: classes.dex */
public class BuddyActivity2 extends BaseMultiPaneActivity {

    /* renamed from: a */
    private InterfaceC0531ag f1088a;

    /* renamed from: b */
    private BuddyFragment f1089b;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        if (bundle == null) {
            this.f1089b = new BuddyFragment();
            this.f1088a = this.f1089b;
            Bundle bundleB = m2042b(getIntent());
            if ("android.intent.action.PICK".equals(getIntent().getAction())) {
                bundleB.putInt("ACTIVITY_PURPOSE", 1000);
            }
            this.f1089b.setArguments(bundleB);
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.add(R.id.fragment_controller, this.f1089b);
            if (findViewById(R.id.fragment_container) != null) {
            }
            fragmentTransactionBeginTransaction.commit();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f1088a == null || this.f1088a.mo2202d()) {
            super.onBackPressed();
        }
    }

    @Override // com.sec.chaton.base.BaseMultiPaneActivity
    /* renamed from: a */
    protected C0353a mo655a(String str) {
        return super.mo655a(str);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        if (this.f1089b == null || !C1632t.m5917c()) {
            return super.onMenuOpened(i, menu);
        }
        this.f1089b.m2207i();
        return false;
    }
}
