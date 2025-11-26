package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.samsungaccount.MainActivity;
import com.sec.chaton.util.C4904y;

/* compiled from: MappingLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.l */
/* loaded from: classes.dex */
public class C1030l extends AbstractC1019a {

    /* renamed from: c */
    private static final String f3329c = C1030l.class.getSimpleName();

    @Override // com.sec.chaton.api.p048a.AbstractC1019a
    /* renamed from: a */
    public boolean mo6112a(Activity activity, Intent intent) {
        Uri data;
        if ((!m6111a() && !C2349a.m10301a("sms_feature")) || (data = intent.getData()) == null) {
            return false;
        }
        String host = data.getHost();
        String path = data.getPath();
        if (!"mapping".equals(host) || !"/samsungaccount".equals(path)) {
            return false;
        }
        if (C4904y.f17874d) {
            C4904y.m18645d("Going to samsung account mapping procedure.", f3329c);
        }
        Intent intent2 = new Intent(activity, (Class<?>) MainActivity.class);
        intent2.addFlags(33554432);
        intent2.putExtra("is_mapping_mode", true);
        intent2.putExtra("is_direct_call", true);
        activity.startActivity(intent2);
        return true;
    }
}
