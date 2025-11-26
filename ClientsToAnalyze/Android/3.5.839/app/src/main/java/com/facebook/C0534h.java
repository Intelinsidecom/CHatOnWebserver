package com.facebook;

import android.content.Context;
import android.os.Bundle;
import com.facebook.p033c.C0522s;
import com.facebook.p033c.DialogC0518o;
import com.p137vk.sdk.VKOpenAuthActivity;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.h */
/* loaded from: classes.dex */
class C0534h extends C0522s {
    public C0534h(Context context, String str, Bundle bundle) {
        super(context, str, "oauth", bundle);
    }

    @Override // com.facebook.p033c.C0522s, com.facebook.p033c.C0523t
    /* renamed from: a */
    public DialogC0518o mo1900a() {
        Bundle bundleE = m1906e();
        bundleE.putString("redirect_uri", "fbconnect://success");
        bundleE.putString(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, m1903b());
        return new DialogC0518o(m1904c(), "oauth", bundleE, m1905d(), m1907f());
    }
}
