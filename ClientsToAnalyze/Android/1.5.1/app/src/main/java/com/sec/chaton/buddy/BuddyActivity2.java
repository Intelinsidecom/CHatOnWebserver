package com.sec.chaton.buddy;

import android.support.v4.app.Fragment;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.chat.ChatActivity;

/* loaded from: classes.dex */
public class BuddyActivity2 extends BaseSinglePaneActivity {

    /* renamed from: a */
    private ChatActivity.OnBackKeyListener f382a;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f382a == null || this.f382a.mo526d()) {
            super.onBackPressed();
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    protected Fragment onCreatePane() {
        BuddyFragment buddyFragment = new BuddyFragment();
        this.f382a = buddyFragment;
        return buddyFragment;
    }
}
