package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.C1071bk;
import com.sec.chaton.EnumC1094bm;
import com.sec.chaton.TabActivity;
import com.sec.chaton.global.C2349a;

/* compiled from: MyPageLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.m */
/* loaded from: classes.dex */
public class C1031m extends AbstractC1019a {
    @Override // com.sec.chaton.api.p048a.AbstractC1019a
    /* renamed from: a */
    public boolean mo6112a(Activity activity, Intent intent) {
        if (!m6111a() && !C2349a.m10301a("sms_feature")) {
            return false;
        }
        Uri data = intent.getData();
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("callMyPageTab")) {
            m6131a(activity);
            return true;
        }
        if (data == null || !"mypage".equals(data.getHost())) {
            return false;
        }
        m6131a(activity);
        return true;
    }

    /* renamed from: a */
    private void m6131a(Activity activity) {
        Intent intentM3015a = TabActivity.m3015a(activity, 2);
        intentM3015a.putExtra(C1071bk.f3371e, EnumC1094bm.API);
        activity.startActivity(intentM3015a);
    }
}
