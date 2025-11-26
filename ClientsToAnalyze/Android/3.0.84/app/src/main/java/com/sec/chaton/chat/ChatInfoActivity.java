package com.sec.chaton.chat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.buddy.InterfaceC0598db;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class ChatInfoActivity extends BaseSinglePaneActivity implements InterfaceC0598db, InterfaceC1054dw {
    @Override // com.sec.chaton.chat.InterfaceC1054dw
    /* renamed from: c */
    public void mo5026c() {
        finish();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        return new ChatInfoFragment();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        m5025d();
        super.onResume();
        BaseActivity.m3080a(this);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    /* renamed from: d */
    private void m5025d() {
        C3250y.m11450b("showAgainPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            C3241p.m11403b(false);
            startActivity(intent);
        }
    }

    @Override // com.sec.chaton.buddy.InterfaceC0598db
    /* renamed from: a */
    public void mo3452a(int i) {
        m11543k().mo11586b(R.string.chat_view_menu_info2);
    }

    @Override // com.sec.chaton.buddy.InterfaceC0598db
    /* renamed from: b */
    public void mo3453b(int i) {
    }
}
