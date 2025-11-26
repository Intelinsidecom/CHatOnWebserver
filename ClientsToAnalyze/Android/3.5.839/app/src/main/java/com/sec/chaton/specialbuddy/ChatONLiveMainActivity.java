package com.sec.chaton.specialbuddy;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class ChatONLiveMainActivity extends AbstractChatONLiveActivity {

    /* renamed from: o */
    static final String f16289o = ChatONLiveMainActivity.class.getSimpleName();

    /* renamed from: p */
    boolean f16290p = false;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("key_start_with_buddylist")) {
            this.f16290p = intent.getBooleanExtra("key_start_with_buddylist", false);
        }
        ChatONLiveMainFragment chatONLiveMainFragment = new ChatONLiveMainFragment();
        this.f16280n = chatONLiveMainFragment;
        return chatONLiveMainFragment;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        setTitle(R.string.live);
        if (this.f16290p) {
            m6159a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f16290p) {
            m6159a(this);
        }
    }
}
