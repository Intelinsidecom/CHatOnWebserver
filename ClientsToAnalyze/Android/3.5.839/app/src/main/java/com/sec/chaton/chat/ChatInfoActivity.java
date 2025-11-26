package com.sec.chaton.chat;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.buddy.InterfaceC1261dv;

/* loaded from: classes.dex */
public class ChatInfoActivity extends BaseSinglePaneActivity implements InterfaceC1261dv, InterfaceC1710fj {
    @Override // com.sec.chaton.chat.InterfaceC1710fj
    /* renamed from: h */
    public void mo8281h() {
        finish();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new ChatInfoFragment();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        BaseActivity.m6159a(this);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.buddy.InterfaceC1261dv
    /* renamed from: a */
    public void mo6198a(int i) {
        m18784t().mo18826b(R.string.chat_view_menu_info2);
    }

    @Override // com.sec.chaton.buddy.InterfaceC1261dv
    /* renamed from: b */
    public void mo6199b(int i) {
    }
}
