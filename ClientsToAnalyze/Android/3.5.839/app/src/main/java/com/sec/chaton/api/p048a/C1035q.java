package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.shop.ChatONShopActivity;
import com.sec.chaton.util.C4904y;

/* compiled from: ShopLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.q */
/* loaded from: classes.dex */
public class C1035q extends AbstractC1019a {
    @Override // com.sec.chaton.api.p048a.AbstractC1019a
    /* renamed from: a */
    public boolean mo6112a(Activity activity, Intent intent) throws NumberFormatException {
        if (intent == null || intent.getData() == null) {
            return false;
        }
        Uri data = intent.getData();
        if (!"shop".equals(data.getHost())) {
            return false;
        }
        String queryParameter = data.getQueryParameter("page_name");
        String queryParameter2 = data.getQueryParameter("category_id");
        String queryParameter3 = data.getQueryParameter("item_id");
        if (C4904y.f17872b) {
            C4904y.m18639b("pageName :" + queryParameter, getClass().getSimpleName());
            C4904y.m18639b("categoryId :" + queryParameter2, getClass().getSimpleName());
            C4904y.m18639b("itemId :" + queryParameter3, getClass().getSimpleName());
        }
        if (queryParameter == null) {
            return false;
        }
        int i = Integer.parseInt(queryParameter);
        if (i != 0 && i != 2 && i != 1) {
            return false;
        }
        Intent intent2 = new Intent(activity, (Class<?>) ChatONShopActivity.class);
        intent2.putExtra("page_name", i);
        if (queryParameter2 != null) {
            intent2.putExtra("category_id", Long.parseLong(queryParameter2));
        }
        if (queryParameter3 != null) {
            intent2.putExtra("item_id", queryParameter3);
        }
        activity.startActivity(intent2);
        return true;
    }
}
