package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.mobileweb.C2586a;
import com.sec.chaton.mobileweb.EnumC2589c;

/* compiled from: LivePartnerLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.k */
/* loaded from: classes.dex */
public class C1029k extends AbstractC1019a {
    @Override // com.sec.chaton.api.p048a.AbstractC1019a
    /* renamed from: a */
    public boolean mo6112a(Activity activity, Intent intent) {
        Uri data;
        C2586a c2586aM10989a;
        EnumC2589c enumC2589cM10991a;
        Intent intentM10990a;
        if ((!m6111a() && !C2349a.m10301a("sms_feature")) || intent == null || (data = intent.getData()) == null || (c2586aM10989a = C2586a.m10989a(data)) == null || (enumC2589cM10991a = c2586aM10989a.m10991a()) == null || !enumC2589cM10991a.m11001c() || (intentM10990a = c2586aM10989a.m10990a(activity)) == null) {
            return false;
        }
        activity.startActivity(intentM10990a);
        return true;
    }
}
