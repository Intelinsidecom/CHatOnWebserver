package com.sec.chaton.specialbuddy;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.base.InterfaceC0459d;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class ChatONLiveBuddyListActivity extends BaseSinglePaneActivity {

    /* renamed from: a */
    static final String f10387a = ChatONLiveBuddyListActivity.class.getSimpleName();

    /* renamed from: b */
    private InterfaceC0459d f10388b;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        ChatONLiveBuddyListFragment chatONLiveBuddyListFragment = new ChatONLiveBuddyListFragment();
        if (chatONLiveBuddyListFragment instanceof InterfaceC0459d) {
            this.f10388b = chatONLiveBuddyListFragment;
        }
        return chatONLiveBuddyListFragment;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f10388b = null;
        super.onDestroy();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        boolean zMo3094a = false;
        if (this.f10388b != null) {
            zMo3094a = this.f10388b.mo3094a();
        }
        if (!zMo3094a) {
            try {
                super.onBackPressed();
            } catch (IllegalStateException e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (C3250y.f11734b) {
            C3250y.m11450b("onCreate()", getClass().getSimpleName());
        }
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        setTitle(R.string.more_live_partner_button_name);
        m3080a(this);
        m10073c();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3080a(this);
    }

    /* renamed from: c */
    private void m10073c() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return super.onSupportCreateOptionsMenu(menu);
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
