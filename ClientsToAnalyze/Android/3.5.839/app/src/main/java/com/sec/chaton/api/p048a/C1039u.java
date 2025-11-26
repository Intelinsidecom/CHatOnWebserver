package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.trunk.TrunkDetailActivity;
import com.sec.chaton.util.C4904y;

/* compiled from: TrunkLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.u */
/* loaded from: classes.dex */
public class C1039u extends AbstractC1019a {

    /* renamed from: c */
    private static final String f3331c = C1039u.class.getSimpleName();

    @Override // com.sec.chaton.api.p048a.AbstractC1019a
    /* renamed from: a */
    public boolean mo6112a(Activity activity, Intent intent) {
        if (intent == null || intent.getData() == null) {
            return false;
        }
        Uri data = intent.getData();
        if (!"trunk".equals(data.getHost())) {
            return false;
        }
        String queryParameter = data.getQueryParameter("session_id");
        String queryParameter2 = data.getQueryParameter("item_id");
        if (C4904y.f17872b) {
            C4904y.m18639b("session id : " + queryParameter, f3331c);
            C4904y.m18639b("item id : " + queryParameter2, f3331c);
        }
        if (queryParameter == null || queryParameter2 == null) {
            return false;
        }
        Intent intent2 = new Intent();
        intent2.setClass(activity, TrunkDetailActivity.class);
        intent2.putExtra("sessionId", queryParameter);
        intent2.putExtra("itemId", queryParameter2);
        intent2.putExtra("link_mod", true);
        activity.startActivity(intent2);
        return true;
    }
}
