package com.sec.chaton.trunk;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class TrunkActivity extends BaseSinglePaneActivity {
    private static String EXTRA_SESSION_ID = "sessionId";
    private static String EXTRA_INBOX_NO = "inboxNO";

    public static void ActionStartTrunkActivity(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setClass(GlobalApplication.m2386d(), TrunkActivity.class);
        intent.putExtra(EXTRA_SESSION_ID, str);
        intent.putExtra(EXTRA_INBOX_NO, str2);
        context.startActivity(intent);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    protected Fragment onCreatePane() {
        return new TrunkFragment();
    }
}
