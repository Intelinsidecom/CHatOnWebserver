package com.facebook;

import android.content.Context;
import android.os.Bundle;
import com.facebook.p009c.C0151s;
import com.facebook.p009c.DialogC0147o;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.h */
/* loaded from: classes.dex */
class C0163h extends C0151s {
    public C0163h(Context context, String str, Bundle bundle) {
        super(context, str, "oauth", bundle);
    }

    @Override // com.facebook.p009c.C0151s, com.facebook.p009c.C0152t
    /* renamed from: a */
    public DialogC0147o mo457a() {
        Bundle bundleE = m463e();
        bundleE.putString("redirect_uri", "fbconnect://success");
        bundleE.putString("client_id", m460b());
        return new DialogC0147o(m461c(), "oauth", bundleE, m462d(), m464f());
    }
}
