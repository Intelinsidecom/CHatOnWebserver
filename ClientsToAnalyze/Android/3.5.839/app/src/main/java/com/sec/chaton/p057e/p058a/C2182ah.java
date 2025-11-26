package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import com.sec.chaton.p057e.C2267bm;
import com.sec.chaton.shop.inappbilling.p100a.C3756s;
import com.sec.chaton.util.C4821am;

/* compiled from: ShopDataBaseHelper.java */
/* renamed from: com.sec.chaton.e.a.ah */
/* loaded from: classes.dex */
public class C2182ah {
    /* renamed from: a */
    public static ContentProviderOperation m9743a(String str, String str2, String str3, C3756s c3756s, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_type", str);
        contentValues.put("item_id", str2);
        contentValues.put("marketcode", str3);
        if (c3756s != null) {
            contentValues.put("payload", c3756s.m14139c());
            contentValues.put("purchase_json", c3756s.m14141e());
            contentValues.put("signature", c3756s.m14142f());
        }
        if (z) {
            contentValues.put("consume", "Y");
        } else {
            contentValues.put("consume", "N");
        }
        return ContentProviderOperation.newInsert(C4821am.m18188a(C2267bm.f8062a).buildUpon().appendPath(str2).appendPath(str).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9742a(String str, String str2) {
        return ContentProviderOperation.newDelete(C2267bm.f8062a.buildUpon().appendPath(str2).appendPath(str).build()).build();
    }
}
