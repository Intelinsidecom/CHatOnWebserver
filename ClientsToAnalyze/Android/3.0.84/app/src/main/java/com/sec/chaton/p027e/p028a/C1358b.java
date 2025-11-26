package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.sec.chaton.p027e.C1396an;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p035io.entry.inner.Anicon;
import com.sec.chaton.p035io.entry.inner.Package;
import com.sec.chaton.util.C3170al;
import com.sec.common.util.C3364o;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AniconDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.b */
/* loaded from: classes.dex */
public class C1358b extends C1366j {
    /* renamed from: a */
    public static ContentProviderOperation m6003a(Package r3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_type", EnumC1399aq.Anicon.m6252a());
        contentValues.put("item_id", r3.f5653id);
        if (!TextUtils.isEmpty(r3.categoryid)) {
            contentValues.put("reference_id", r3.categoryid);
        }
        contentValues.put("name", r3.name);
        contentValues.put("new", r3._new);
        contentValues.put("special", r3.special);
        contentValues.put("extras", m6006b(r3).toString());
        contentValues.put("expiration_time", r3.expirationdate);
        contentValues.put("down_rank", r3.down_rank);
        contentValues.put("data1", r3.data1);
        contentValues.put("data2", r3.data2);
        contentValues.put("data3", r3.data3);
        return ContentProviderOperation.newInsert(C3170al.m11041a(C1398ap.m6249a(EnumC1399aq.Anicon))).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6002a(Anicon anicon) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("anicon_id", anicon.f5639id);
        contentValues.put("package_id", anicon.packageid);
        contentValues.put("zip_url", anicon.aniconzipurl);
        contentValues.put("delegate_url", anicon.delegateimage);
        contentValues.put("cd_proxy_url", anicon.cdproxyurl);
        return ContentProviderOperation.newInsert(C3170al.m11041a(C1396an.f5203a)).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static C1359c m6004a(String str) {
        C1359c c1359c = new C1359c();
        JSONObject jSONObject = new JSONObject(str);
        c1359c.m6010a(jSONObject.getString("preview"));
        c1359c.m6012b(jSONObject.getString("thumbnail"));
        c1359c.m6008a(jSONObject.getInt("count"));
        c1359c.m6009a(jSONObject.getLong("volume"));
        c1359c.m6014c(jSONObject.getString("panel"));
        return c1359c;
    }

    /* renamed from: b */
    public static JSONObject m6006b(Package r3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("preview", r3.previewurl);
        jSONObject.put("thumbnail", r3.thumbnailurl);
        jSONObject.put("count", r3.aniconcount);
        jSONObject.put("volume", r3.volume);
        jSONObject.put("panel", r3.panelurl);
        return jSONObject;
    }

    /* renamed from: a */
    public static void m6005a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = null;
        try {
            Package r0 = new Package();
            ContentValues contentValues = new ContentValues();
            cursorRawQuery = sQLiteDatabase.rawQuery(C3364o.m11849a("SELECT * FROM ", "anicon_package", " WHERE ", "install", " != ?"), new String[]{"0"});
            while (cursorRawQuery.moveToNext()) {
                r0.categoryid = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("category_id"));
                r0.f5653id = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("package_id"));
                r0.name = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("name"));
                r0.previewurl = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("preview_url"));
                r0.thumbnailurl = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("thumbnail_url"));
                r0.aniconcount = Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("anicon_count")));
                r0.volume = Long.valueOf(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("volume")));
                r0.expirationdate = Long.valueOf(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("expiration_time")));
                r0.special = Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("special")));
                int columnIndex = cursorRawQuery.getColumnIndex("new");
                if (columnIndex != -1) {
                    r0._new = Integer.valueOf(cursorRawQuery.getInt(columnIndex));
                } else {
                    r0._new = 0;
                }
                r0.panelurl = "";
                long j = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("install"));
                contentValues.put("item_type", EnumC1399aq.Anicon.m6252a());
                contentValues.put("item_id", r0.f5653id);
                if (!TextUtils.isEmpty(r0.categoryid)) {
                    contentValues.put("reference_id", r0.categoryid);
                }
                contentValues.put("name", r0.name);
                contentValues.put("new", r0._new);
                contentValues.put("special", r0.special);
                contentValues.put("extras", m6006b(r0).toString());
                contentValues.put("expiration_time", r0.expirationdate);
                contentValues.put("install", Long.valueOf(j));
                sQLiteDatabase.insert("download_item", null, contentValues);
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }
}
