package com.sec.chaton.settings;

import android.os.Bundle;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.base.C0240a;
import com.sec.chaton.block.BlockActivity;
import com.sec.chaton.block.BlockFragment;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class SettingActivity extends BaseMultiPaneActivity {
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        if (bundle == null) {
            new SettingFragment().setArguments(m1828b(getIntent()));
        }
        if (GlobalApplication.m3265f()) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        findViewById(R.id.base_divider).setVisibility(0);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.sec.chaton.base.BaseMultiPaneActivity
    /* renamed from: a */
    protected C0240a mo608a(String str) {
        if (ActivityAbout.class.getName().equals(str)) {
            return new C0240a(this, AboutFragment.class, "containter", R.id.fragment_container);
        }
        if (ActivityWebView.class.getName().equals(str)) {
            return new C0240a(this, FragmentWebView.class, "containter", R.id.fragment_container);
        }
        if (BlockActivity.class.getName().equals(str)) {
            return new C0240a(this, BlockFragment.class, "containter", R.id.fragment_container);
        }
        if (ActivityDeleteAccount.class.getName().equals(str)) {
            return new C0240a(this, FragmentDeleteAccount.class, "containter", R.id.fragment_container);
        }
        if (RelationHideActivity.class.getName().equals(str)) {
            return new C0240a(this, RelationHideFragment.class, "containter", R.id.fragment_container);
        }
        if (ActivitySkinChange.class.getName().equals(str)) {
            return new C0240a(this, FragmentSkinChange2.class, "containter", R.id.fragment_container);
        }
        if (ActivityChatView.class.getName().equals(str)) {
            return new C0240a(this, FragmentChatView.class, "containter", R.id.fragment_container);
        }
        if (ActivityAlertType2.class.getName().equals(str)) {
            return new C0240a(this, FragmentAlertTypeView2.class, "containter", R.id.fragment_container);
        }
        if (ActivityRingTone.class.getName().equals(str)) {
            return new C0240a(this, FragmentRingToneView.class, "containter", R.id.fragment_container);
        }
        if (BuddyActivity2.class.getName().equals(str)) {
            return new C0240a(this, BuddyFragment.class, "containter", R.id.fragment_container);
        }
        if (ActivitySyncNow.class.getName().equals(str)) {
            return new C0240a(this, SyncNowFragment.class, "containter", R.id.fragment_container);
        }
        return super.mo608a(str);
    }
}
