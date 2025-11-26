package com.sec.chaton.search;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.C2310s;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.util.C3161ac;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class SearchActivity extends Activity {

    /* renamed from: a */
    private static final String f8839a = SearchActivity.class.getSimpleName();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        m8835a(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        m8835a(intent);
    }

    /* renamed from: a */
    private void m8835a(Intent intent) {
        if ("android.intent.action.VIEW".equals(intent.getAction())) {
            startActivity(HomeActivity.m1158a(this, m8837c(intent), intent.getBooleanExtra("skipSplash", false)));
            finish();
        } else if (C2310s.f8622f.equals(intent.getAction())) {
            startActivity(m8836b(intent));
            finish();
        }
    }

    /* renamed from: b */
    private Intent m8836b(Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("inboxNO");
        Intent intentM1170a = IntentControllerActivity.m1170a(CommonApplication.m11493l());
        intentM1170a.setAction(C2310s.f8622f);
        intentM1170a.putExtra("PROFILE_BUDDY_NO", queryParameter);
        return intentM1170a;
    }

    /* renamed from: c */
    private Intent m8837c(Intent intent) {
        Uri data = intent.getData();
        return C3161ac.m10991a(CommonApplication.m11493l(), data.getQueryParameter("inboxNO"), EnumC1450r.m6339a(Integer.parseInt(data.getQueryParameter("chatType"))));
    }
}
