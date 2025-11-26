package com.sec.chaton.buddy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.base.C0240a;
import com.sec.chaton.buddy.honeycomb.BuddySelectFragment;
import com.sec.chaton.buddy.honeycomb.InterfaceC0432o;
import com.sec.chaton.chat.InterfaceC0454a;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class BuddyActivity2 extends BaseMultiPaneActivity {

    /* renamed from: a */
    private InterfaceC0454a f888a;

    /* renamed from: b */
    private BuddyFragment f889b;

    /* renamed from: c */
    private Fragment f890c;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        if (GlobalApplication.m3265f()) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        if (bundle == null) {
            this.f889b = new BuddyFragment();
            this.f888a = this.f889b;
            this.f889b.setArguments(m1828b(getIntent()));
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.add(R.id.fragment_controller, this.f889b);
            if (findViewById(R.id.fragment_container) != null) {
                Bundle extras = getIntent().getExtras();
                if ((extras.containsKey("ACTIVITY_PURPOSE") && extras.getInt("ACTIVITY_PURPOSE") == 10) || extras.getInt("ACTIVITY_PURPOSE") == 11 || extras.getInt("ACTIVITY_PURPOSE") == 2 || extras.getInt("ACTIVITY_PURPOSE") == 3 || extras.getInt("ACTIVITY_PURPOSE") == 13 || extras.getInt("ACTIVITY_PURPOSE") == 14 || extras.getInt("ACTIVITY_PURPOSE") == 15 || extras.getInt("ACTIVITY_PURPOSE") == 9 || extras.getInt("ACTIVITY_PURPOSE") == 5) {
                    this.f890c = new BuddySelectFragment();
                    this.f890c.setArguments(m1828b(getIntent()));
                    fragmentTransactionBeginTransaction.add(R.id.fragment_container, this.f890c);
                    if (this.f890c instanceof InterfaceC0298bj) {
                        this.f889b.m2034a((InterfaceC0298bj) this.f890c);
                    }
                    if (this.f889b instanceof InterfaceC0432o) {
                        ((BuddySelectFragment) this.f890c).m2431a(this.f889b);
                    }
                } else if (extras.containsKey("ACTIVITY_PURPOSE") && extras.getInt("ACTIVITY_PURPOSE") == 16) {
                    this.f890c = new BuddyProfileFragment();
                    this.f890c.setArguments(m1828b(getIntent()));
                    fragmentTransactionBeginTransaction.replace(R.id.fragment_container, this.f890c);
                }
            }
            if (!fragmentTransactionBeginTransaction.isEmpty()) {
                fragmentTransactionBeginTransaction.commit();
            }
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
        if (this.f888a == null || this.f888a.isBackKeyIgnore()) {
            super.onBackPressed();
        }
    }

    @Override // com.sec.chaton.base.BaseMultiPaneActivity
    /* renamed from: a */
    protected C0240a mo608a(String str) {
        return super.mo608a(str);
    }
}
