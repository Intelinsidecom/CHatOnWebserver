package com.renren.android.p041b;

import android.os.Bundle;
import android.text.TextUtils;
import com.p137vk.sdk.api.VKApiConst;
import com.renren.android.p040a.AbstractC0708a;

/* compiled from: FriendsGetFriendsRequestParam.java */
/* renamed from: com.renren.android.b.a */
/* loaded from: classes.dex */
public class C0711a extends AbstractC0708a {

    /* renamed from: a */
    private int f1639a = 1;

    /* renamed from: b */
    private int f1640b = 500;

    /* renamed from: c */
    private String[] f1641c = null;

    /* renamed from: a */
    public void m2266a(String[] strArr) {
        this.f1641c = strArr;
    }

    /* renamed from: a */
    public Bundle m2265a() {
        Bundle bundle = new Bundle();
        bundle.putString("method", "friends.getFriends");
        bundle.putString("page", String.valueOf(this.f1639a));
        bundle.putString(VKApiConst.COUNT, String.valueOf(this.f1640b));
        if (this.f1641c != null && this.f1641c.length > 0) {
            bundle.putString(VKApiConst.FIELDS, TextUtils.join(", ", this.f1641c));
        }
        return bundle;
    }
}
