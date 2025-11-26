package com.sec.chaton.settings;

import android.os.Bundle;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.base.C0353a;
import com.sec.chaton.block.BlockActivity;
import com.sec.chaton.block.BlockFragment;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.buddy.BuddyFragment;

/* loaded from: classes.dex */
public class SettingActivity extends BaseMultiPaneActivity {
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        if (bundle == null) {
            C1057ca c1057ca = new C1057ca();
            c1057ca.setArguments(m2042b(getIntent()));
            getFragmentManager().beginTransaction().add(R.id.fragment_controller, c1057ca).commit();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
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
    protected C0353a mo655a(String str) {
        if (ActivityAbout.class.getName().equals(str)) {
            return new C0353a(this, AboutFragment.class, "containter", R.id.fragment_container);
        }
        if (ActivityWebView.class.getName().equals(str)) {
            return new C0353a(this, FragmentWebView.class, "containter", R.id.fragment_container);
        }
        if (BlockActivity.class.getName().equals(str)) {
            return new C0353a(this, BlockFragment.class, "containter", R.id.fragment_container);
        }
        if (ActivityDeleteAccount.class.getName().equals(str)) {
            return new C0353a(this, FragmentDeleteAccount.class, "containter", R.id.fragment_container);
        }
        if (RelationHideActivity.class.getName().equals(str)) {
            return new C0353a(this, RelationHideFragment.class, "containter", R.id.fragment_container);
        }
        if (ActivitySkinChange.class.getName().equals(str)) {
            return new C0353a(this, FragmentSkinChange2.class, "containter", R.id.fragment_container);
        }
        if (ActivityChatView.class.getName().equals(str)) {
            return new C0353a(this, FragmentChatView.class, "containter", R.id.fragment_container);
        }
        if (ActivityAlertType.class.getName().equals(str)) {
            return new C0353a(this, FragmentAlertTypeView.class, "containter", R.id.fragment_container);
        }
        if (ActivityRingTone.class.getName().equals(str)) {
            return new C0353a(this, FragmentRingToneView.class, "containter", R.id.fragment_container);
        }
        if (BuddyActivity2.class.getName().equals(str)) {
            return new C0353a(this, BuddyFragment.class, "containter", R.id.fragment_container);
        }
        if (ActivitySyncNow.class.getName().equals(str)) {
            return new C0353a(this, SyncNowFragment.class, "containter", R.id.fragment_container);
        }
        return super.mo655a(str);
    }
}
