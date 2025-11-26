package com.sec.chaton.buddy;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.buddy.p019a.C0512b;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class BuddyGroupMemberEditActivity extends BaseSinglePaneActivity implements InterfaceC0598db {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        return new BuddyGroupMemberEditFragment();
    }

    @Override // com.sec.chaton.buddy.InterfaceC0598db
    /* renamed from: a */
    public void mo3452a(int i) {
        m3451c(i);
    }

    @Override // com.sec.chaton.buddy.InterfaceC0598db
    /* renamed from: b */
    public void mo3453b(int i) {
    }

    /* renamed from: c */
    private void m3451c(int i) {
        C3250y.m11450b("setTitleView() : " + i, getClass().getSimpleName());
        String strM3962b = null;
        if (getIntent().getIntExtra("ACTIVITY_PURPOSE", 1) == 19) {
            strM3962b = ((C0512b) getIntent().getExtras().get("groupInfo")).m3962b();
        }
        if (strM3962b != null) {
            if (i >= 0) {
                strM3962b = strM3962b + " (" + i + ")";
            }
            setTitle(strM3962b);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            m3080a(this);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (GlobalApplication.m6456e()) {
            m3080a(this);
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m3080a(this);
    }
}
