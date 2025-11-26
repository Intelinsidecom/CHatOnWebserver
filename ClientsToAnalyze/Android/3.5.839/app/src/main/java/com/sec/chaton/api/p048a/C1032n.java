package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.poston.PostONDetailActivity;
import com.sec.chaton.poston.PostONDetailFragment;
import java.io.UnsupportedEncodingException;

/* compiled from: PostONDetailLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.n */
/* loaded from: classes.dex */
public class C1032n extends AbstractC1019a {
    @Override // com.sec.chaton.api.p048a.AbstractC1019a
    /* renamed from: a */
    public boolean mo6112a(Activity activity, Intent intent) {
        Uri data;
        if ((!m6111a() && !C2349a.m10301a("sms_feature")) || (data = intent.getData()) == null) {
            return false;
        }
        String host = data.getHost();
        String path = data.getPath();
        if (!"poston".equals(host) || !"/main".equals(path)) {
            return false;
        }
        m6133a(activity, m6132a(data, "poston_id"), m6132a(data, VKApiConst.OWNER_ID));
        return true;
    }

    /* renamed from: a */
    private void m6133a(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) PostONDetailActivity.class);
        intent.putExtra(PostONDetailFragment.f10881n, PostONDetailFragment.f10884q);
        intent.putExtra(PostONDetailFragment.f10876i, str);
        intent.putExtra(PostONDetailFragment.f10867a, str2);
        activity.startActivity(intent);
    }

    /* renamed from: a */
    private String m6132a(Uri uri, String str) throws C1026h {
        try {
            return m6110a(uri, str, f3317b);
        } catch (UnsupportedEncodingException e) {
            throw new C1026h(e);
        }
    }
}
