package com.sec.chaton.localbackup.chatview;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class ChatViewActivity extends BaseSinglePaneActivity {

    /* renamed from: a */
    private InterfaceC1622c f6028a;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        ChatViewFragment chatViewFragment = new ChatViewFragment();
        this.f6028a = chatViewFragment;
        return chatViewFragment;
    }

    /* renamed from: c */
    protected void m6867c() {
        finish();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f6028a != null) {
            this.f6028a.mo6895a();
        }
        super.onBackPressed();
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
