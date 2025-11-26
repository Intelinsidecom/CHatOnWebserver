package com.sec.chaton.sstream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.util.C3161ac;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import p000a.p001a.C0002b;

/* loaded from: classes.dex */
public class SStreamActivity extends Activity {

    /* renamed from: a */
    public static final String f10482a = SStreamActivity.class.getSimpleName();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        m10165a(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m10165a(intent);
    }

    /* renamed from: a */
    private void m10165a(Intent intent) {
        C3250y.m11450b("storyItemId[" + C0002b.m1a(intent) + "]", f10482a);
        C3250y.m11450b("intent[" + intent.toString() + "]", f10482a);
        if ("android.intent.action.VIEW".equals(intent.getAction())) {
            startActivity(m10166b(intent));
            finish();
        }
    }

    /* renamed from: b */
    private Intent m10166b(Intent intent) {
        String strM1a = C0002b.m1a(intent);
        if (C0002b.m6b(intent)) {
            Intent intentM1171a = IntentControllerActivity.m1171a((Context) this, false);
            intentM1171a.putExtra("callChatTab", true);
            return intentM1171a;
        }
        Uri uri = Uri.parse(strM1a);
        EnumC1450r enumC1450rM6339a = EnumC1450r.m6339a(Integer.parseInt(uri.getQueryParameter("chatType")));
        String queryParameter = uri.getQueryParameter("inboxNO");
        if (enumC1450rM6339a.equals(EnumC1450r.ONETOONE)) {
            queryParameter = C1381y.m6218d(CommonApplication.m11493l().getContentResolver(), queryParameter).get(0);
        }
        C3250y.m11450b("storyItemId[" + queryParameter + "]", f10482a);
        C3250y.m11450b("intent[" + intent.toString() + "]", f10482a);
        return C3161ac.m10991a(this, queryParameter, enumC1450rM6339a);
    }
}
