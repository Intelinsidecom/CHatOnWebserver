package com.sec.chaton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.renren.android.feed.FeedPublishRequestParam;
import com.sec.common.util.C5047m;

/* loaded from: classes.dex */
public class IntentControllerActivity extends Activity {
    /* renamed from: a */
    public static Intent m2920a(Context context) {
        return m2923a(context, false);
    }

    @Deprecated
    /* renamed from: a */
    public static Intent m2923a(Context context, boolean z) {
        return m2921a(context, z ? 1 : 0);
    }

    /* renamed from: a */
    public static Intent m2921a(Context context, int i) {
        Intent intent = new Intent(context, (Class<?>) IntentControllerActivity.class);
        intent.putExtra("skipSplash", i);
        return intent;
    }

    /* renamed from: a */
    public static Intent m2922a(Context context, Intent intent, int i) {
        intent.setClass(context, IntentControllerActivity.class);
        intent.putExtra("skipSplash", i);
        intent.setFlags(65536);
        return intent;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (C5047m.m19189a(intent, FeedPublishRequestParam.MESSAGE_TOO_LONG)) {
            Intent intentM2912a = HomeActivity.m2912a((Context) this);
            intentM2912a.setAction("android.intent.action.MAIN");
            intentM2912a.addCategory("android.intent.category.LAUNCHER");
            if (!isTaskRoot()) {
                intentM2912a.setFlags(270532608);
            }
            startActivity(intentM2912a);
        } else {
            int intExtra = intent.getIntExtra("skipSplash", 0);
            String stringExtra = intent.getStringExtra("packageName");
            if (stringExtra != null && (stringExtra.equals("com.coolots.chaton") || stringExtra.equals("com.coolots.chatonforcanada"))) {
                intExtra = 1;
            }
            startActivity(HomeActivity.m2914a(this, intent, intExtra));
        }
        finish();
    }
}
