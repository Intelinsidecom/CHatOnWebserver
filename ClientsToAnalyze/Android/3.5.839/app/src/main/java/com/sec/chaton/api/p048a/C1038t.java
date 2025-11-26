package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.api.AuthorizeActivity;

/* compiled from: ThirdAuthLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.t */
/* loaded from: classes.dex */
public class C1038t extends AbstractC1019a {
    @Override // com.sec.chaton.api.p048a.AbstractC1019a
    /* renamed from: a */
    public boolean mo6112a(Activity activity, Intent intent) {
        Uri data = intent.getData();
        if (data == null || !"3rdauth".equals(data.getHost())) {
            return false;
        }
        Intent intent2 = new Intent(activity, (Class<?>) AuthorizeActivity.class);
        intent2.addFlags(33554432);
        intent2.setData(intent.getData());
        intent2.putExtra("key_skip_contact_sync", true);
        activity.startActivity(intent2);
        return true;
    }
}
