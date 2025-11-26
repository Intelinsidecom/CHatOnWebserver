package com.sec.chaton.buddy;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.base.C0240a;
import com.sec.chaton.chat.InterfaceC0454a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1767bw;

/* loaded from: classes.dex */
public class BuddySelectActivity extends BaseMultiPaneActivity implements InterfaceC0302bn {

    /* renamed from: a */
    public static final String f1204a = BuddySelectActivity.class.getSimpleName();

    /* renamed from: b */
    final String f1205b;

    /* renamed from: c */
    private InterfaceC0454a f1206c;

    /* renamed from: d */
    private BuddyFragment f1207d;

    public BuddySelectActivity() {
        this.f1205b = C1767bw.m6002a() ? GlobalApplication.m3256a().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m3260b().getFilesDir().getAbsolutePath();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_buddy_select);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(798, 738);
        }
        if (bundle == null) {
            this.f1207d = new BuddyFragment(this);
            this.f1206c = this.f1207d;
            this.f1207d.setArguments(m1828b(getIntent()));
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.add(R.id.buddy_controller, this.f1207d);
            if (!fragmentTransactionBeginTransaction.isEmpty()) {
                fragmentTransactionBeginTransaction.commit();
            }
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws NumberFormatException {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        switch (menuItem.getItemId()) {
            case R.id.actionbar_title_cancel /* 2131494128 */:
                finish();
                return true;
            case R.id.actionbar_title_change /* 2131494129 */:
            default:
                return super.onOptionsItemSelected(menuItem);
            case R.id.actionbar_title_done /* 2131494130 */:
                this.f1207d.m2054k();
                return true;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f1206c == null || this.f1206c.isBackKeyIgnore()) {
            super.onBackPressed();
        }
    }

    @Override // com.sec.chaton.base.BaseMultiPaneActivity
    /* renamed from: a */
    protected C0240a mo608a(String str) {
        return super.mo608a(str);
    }

    @Override // com.sec.chaton.buddy.InterfaceC0302bn
    /* renamed from: a */
    public void mo2228a() {
    }

    @Override // com.sec.chaton.buddy.InterfaceC0302bn
    /* renamed from: b */
    public void mo2229b() {
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }
}
