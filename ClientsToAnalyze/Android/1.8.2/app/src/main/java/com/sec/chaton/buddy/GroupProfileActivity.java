package com.sec.chaton.buddy;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class GroupProfileActivity extends BaseSinglePaneActivity {

    /* renamed from: a */
    private String[] f1208a = null;

    /* renamed from: b */
    private Bundle f1209b;

    /* renamed from: c */
    private int f1210c;

    /* renamed from: d */
    private BuddyFragment f1211d;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo649a() {
        return new GroupProfileFragment();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1209b = getIntent().getExtras();
        this.f1210c = this.f1209b.getInt("ACTIVITY_PURPOSE");
        if (this.f1210c == 6 && this.f1209b.getString("group profile", "profile").equals("GROUP PROFILE")) {
            this.f1208a = this.f1209b.getStringArray("ACTION_PURPOSE_ARG2");
        }
        if (bundle == null) {
            this.f1211d = new BuddyFragment();
            this.f1211d.setArguments(m1828b(getIntent()));
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.add(R.id.buddy_controller, this.f1211d);
            if (!fragmentTransactionBeginTransaction.isEmpty()) {
                fragmentTransactionBeginTransaction.commit();
            }
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeButtonEnabled(true);
                actionBar.setTitle(getString(R.string.buddy_group_profile_title, new Object[]{Integer.valueOf(this.f1208a.length)}));
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
}
