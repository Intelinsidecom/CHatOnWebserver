package com.sec.chaton.userprofile;

import android.view.MenuItem;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class MyInfoActivity extends BaseSinglePaneActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public MyInfoFragment mo1193a() {
        return new MyInfoFragment();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
