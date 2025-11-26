package com.sec.chaton.localbackup.chatview;

import android.support.v4.app.Fragment;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class ChatViewActivity extends BaseSinglePaneActivity {

    /* renamed from: n */
    private InterfaceC2524c f9072n;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        ChatViewFragment chatViewFragment = new ChatViewFragment();
        this.f9072n = chatViewFragment;
        return chatViewFragment;
    }

    /* renamed from: h */
    protected void m10897h() {
        finish();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f9072n != null) {
            this.f9072n.mo10925a();
        }
        super.onBackPressed();
    }
}
