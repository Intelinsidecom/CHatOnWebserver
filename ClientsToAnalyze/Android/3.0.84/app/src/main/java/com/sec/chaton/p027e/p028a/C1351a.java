package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p035io.entry.inner.AmsItem;
import com.sec.chaton.util.C3170al;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AmsItemDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.a */
/* loaded from: classes.dex */
public class C1351a {
    /* renamed from: a */
    public static ContentProviderOperation m5950a(AmsItem amsItem) {
        if (amsItem == null || amsItem.amstype == null || amsItem.amstype.m5703b() == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", amsItem.f5638id);
        contentValues.put("item_type", amsItem.amstype.m5703b().m6252a());
        contentValues.put("expiration_time", amsItem.expirationdate);
        contentValues.put("new", amsItem.newitem);
        contentValues.put("special", amsItem.special);
        contentValues.put("extras", m5952b(amsItem).toString());
        return ContentProviderOperation.newInsert(C3170al.m11041a(C1398ap.m6249a(amsItem.amstype.m5703b()))).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static void m5951a(AmsItem amsItem, String str) {
        JSONObject jSONObject = new JSONObject(str);
        amsItem.thumbnailurl = jSONObject.getString("thumbnailUrl");
        amsItem.filesize = Long.valueOf(jSONObject.getLong("filesize"));
    }

    /* renamed from: b */
    public static JSONObject m5952b(AmsItem amsItem) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thumbnailUrl", amsItem.thumbnailurl);
        jSONObject.put("filesize", amsItem.filesize);
        return jSONObject;
    }
}
