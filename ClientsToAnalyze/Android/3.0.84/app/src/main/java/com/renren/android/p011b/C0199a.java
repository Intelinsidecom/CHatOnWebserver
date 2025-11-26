package com.renren.android.p011b;

import android.os.Bundle;
import android.text.TextUtils;
import com.renren.android.p010a.AbstractC0196a;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: FriendsGetFriendsRequestParam.java */
/* renamed from: com.renren.android.b.a */
/* loaded from: classes.dex */
public class C0199a extends AbstractC0196a {

    /* renamed from: a */
    private int f403a = 1;

    /* renamed from: b */
    private int f404b = HttpResponseCode.INTERNAL_SERVER_ERROR;

    /* renamed from: c */
    private String[] f405c = null;

    /* renamed from: a */
    public void m534a(String[] strArr) {
        this.f405c = strArr;
    }

    /* renamed from: a */
    public Bundle m533a() {
        Bundle bundle = new Bundle();
        bundle.putString("method", "friends.getFriends");
        bundle.putString("page", String.valueOf(this.f403a));
        bundle.putString("count", String.valueOf(this.f404b));
        if (this.f405c != null && this.f405c.length > 0) {
            bundle.putString("fields", TextUtils.join(", ", this.f405c));
        }
        return bundle;
    }
}
