package com.sec.chaton.sstream;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.chaton.util.C4811ac;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import p000a.p001a.C0002b;

/* loaded from: classes.dex */
public class SStreamActivity extends PasswordLockActivity {

    /* renamed from: a */
    public static final String f16434a = SStreamActivity.class.getSimpleName();

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        m17249a(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m17249a(intent);
    }

    /* renamed from: a */
    private void m17249a(Intent intent) {
        C4904y.m18639b("storyItemId[" + C0002b.m1a(intent) + "]", f16434a);
        C4904y.m18639b("intent[" + intent.toString() + "]", f16434a);
        if ("android.intent.action.VIEW".equals(intent.getAction())) {
            startActivity(m17250b(intent));
            finish();
        }
    }

    /* renamed from: b */
    private Intent m17250b(Intent intent) {
        String strM1a = C0002b.m1a(intent);
        if (C0002b.m6b(intent)) {
            Intent intentM2923a = IntentControllerActivity.m2923a((Context) this, false);
            intentM2923a.putExtra("callChatTab", true);
            return intentM2923a;
        }
        Uri uri = Uri.parse(strM1a);
        EnumC2300t enumC2300tM10207a = EnumC2300t.m10207a(Integer.parseInt(uri.getQueryParameter("chatType")));
        String queryParameter = uri.getQueryParameter("inboxNO");
        C4904y.m18639b("storyItemId[" + queryParameter + "]", f16434a);
        C4904y.m18639b("intent[" + intent.toString() + "]", f16434a);
        return C4811ac.m18133a(CommonApplication.m18732r(), queryParameter, enumC2300tM10207a);
    }
}
