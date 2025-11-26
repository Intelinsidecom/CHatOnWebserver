package com.sec.chaton.forward;

import android.support.v4.app.Fragment;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class ChatForwardActivity extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    protected Fragment onCreatePane() {
        return new ChatForwardFragment();
    }
}
