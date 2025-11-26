package com.sec.chaton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.renren.android.feed.FeedPublishRequestParam;
import com.sec.chaton.base.BaseActivity;
import com.sec.common.util.C3349k;

/* loaded from: classes.dex */
public class IntentControllerActivity extends BaseActivity {
    /* renamed from: a */
    public static Intent m1170a(Context context) {
        return m1171a(context, false);
    }

    /* renamed from: a */
    public static Intent m1171a(Context context, boolean z) {
        Intent intent = new Intent(context, (Class<?>) IntentControllerActivity.class);
        intent.putExtra("skipSplash", z);
        return intent;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (C3349k.m11799a(intent, FeedPublishRequestParam.MESSAGE_TOO_LONG)) {
            Intent intentM1157a = HomeActivity.m1157a((Context) this);
            intentM1157a.setAction("android.intent.action.MAIN");
            intentM1157a.addCategory("android.intent.category.LAUNCHER");
            if (!isTaskRoot()) {
                intentM1157a.setFlags(270532608);
            }
            startActivity(intentM1157a);
        } else {
            boolean booleanExtra = intent.getBooleanExtra("skipSplash", false);
            String stringExtra = intent.getStringExtra("packageName");
            if (stringExtra != null && (stringExtra.equals("com.coolots.chaton") || stringExtra.equals("com.coolots.chatonforcanada"))) {
                booleanExtra = true;
            }
            startActivity(HomeActivity.m1158a(this, intent, booleanExtra));
        }
        finish();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getDefaultTheme() {
        return R.style.AppTheme_NoTitleBar;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getBlackTheme() {
        return R.style.AppTheme_NoTitleBar;
    }
}
