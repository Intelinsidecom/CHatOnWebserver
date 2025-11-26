package com.sec.chaton.localbackup.chatlist;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class ChatListActivity extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        return new ChatListFragment();
    }

    /* renamed from: c */
    protected void m6857c() {
        finish();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (GlobalApplication.m6456e()) {
            m3080a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            m3080a(this);
        }
    }
}
