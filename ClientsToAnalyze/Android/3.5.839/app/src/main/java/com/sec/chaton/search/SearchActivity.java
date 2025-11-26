package com.sec.chaton.search;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.C1071bk;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.chaton.util.C4811ac;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class SearchActivity extends PasswordLockActivity {

    /* renamed from: a */
    private static final String f12368a = SearchActivity.class.getSimpleName();

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        m13216a(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        m13216a(intent);
    }

    /* renamed from: a */
    private void m13216a(Intent intent) {
        if ("android.intent.action.VIEW".equals(intent.getAction())) {
            startActivity(HomeActivity.m2914a(this, m13218c(intent), intent.getIntExtra("skipSplash", 0)));
            finish();
        } else if (C1071bk.f3374h.equals(intent.getAction())) {
            startActivity(m13217b(intent));
            finish();
        }
    }

    /* renamed from: b */
    private Intent m13217b(Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("inboxNO");
        Intent intentM2920a = IntentControllerActivity.m2920a(CommonApplication.m18732r());
        intentM2920a.setAction(C1071bk.f3374h);
        intentM2920a.putExtra("PROFILE_BUDDY_NO", queryParameter);
        return intentM2920a;
    }

    /* renamed from: c */
    private Intent m13218c(Intent intent) {
        Uri data = intent.getData();
        return C4811ac.m18133a(CommonApplication.m18732r(), data.getQueryParameter("inboxNO"), EnumC2300t.m10207a(Integer.parseInt(data.getQueryParameter("chatType"))));
    }
}
