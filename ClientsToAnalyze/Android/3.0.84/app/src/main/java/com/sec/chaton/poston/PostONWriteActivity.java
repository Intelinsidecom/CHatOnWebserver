package com.sec.chaton.poston;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.buddy.BuddyProfileFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.userprofile.MyPageFragment;

/* loaded from: classes.dex */
public class PostONWriteActivity extends BaseSinglePaneActivity implements InterfaceC2009bv {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        return new PostONWriteFragment();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (((InterfaceC1988ba) m3089b()).mo8026a()) {
                return super.onKeyDown(i, keyEvent);
            }
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.sec.chaton.poston.InterfaceC2009bv
    /* renamed from: a */
    public void mo7977a(boolean z, String str, String str2, String str3) {
        Intent intent;
        if (z) {
            intent = new Intent(this, (Class<?>) MyPageFragment.class);
        } else {
            intent = new Intent(this, (Class<?>) BuddyProfileFragment.class);
        }
        intent.putExtra("HAS_MORE", str);
        intent.putExtra("END_TIME", str2);
        intent.putExtra("IS_BLIND", str3);
        setResult(-1, intent);
        finish();
    }

    @Override // com.sec.chaton.poston.InterfaceC2009bv
    /* renamed from: c */
    public void mo7978c() {
        finish();
    }
}
