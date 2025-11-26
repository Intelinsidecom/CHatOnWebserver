package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p035io.entry.inner.Skin;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SkinDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.ab */
/* loaded from: classes.dex */
public class C1353ab extends C1366j {

    /* renamed from: a */
    static final String f5093a = C1353ab.class.getSimpleName();

    /* renamed from: a */
    public static ContentProviderOperation m5963a(Skin skin) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_type", EnumC1399aq.Skin.m6252a());
        contentValues.put("item_id", skin.f5654id);
        contentValues.put("new", skin.newitem);
        contentValues.put("special", skin.special);
        contentValues.put("expiration_time", skin.expirationdate);
        contentValues.put("extras", m5966b(skin).toString());
        return ContentProviderOperation.newInsert(C3170al.m11041a(C1398ap.m6249a(EnumC1399aq.Skin))).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static C1354ac m5964a(String str) {
        C1354ac c1354ac = new C1354ac();
        JSONObject jSONObject = new JSONObject(str);
        c1354ac.m5972b(jSONObject.getString("bgtype"));
        c1354ac.m5970a(jSONObject.getString("thumbnailurl"));
        try {
            c1354ac.m5974c(jSONObject.getString("detailviewurl"));
            c1354ac.m5969a(jSONObject.getLong("filesize"));
        } catch (Exception e) {
            c1354ac.m5974c("(empty)");
            c1354ac.m5969a(0L);
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f5093a);
            }
        }
        return c1354ac;
    }

    /* renamed from: b */
    public static JSONObject m5966b(Skin skin) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bgtype", skin.bgtype);
        jSONObject.put("thumbnailurl", skin.thumbnailurl);
        if (TextUtils.isEmpty(skin.detailviewurl)) {
            jSONObject.put("detailviewurl", "(empty)");
        } else {
            jSONObject.put("detailviewurl", skin.detailviewurl);
        }
        if (skin.volume == null) {
            jSONObject.put("filesize", 0L);
        } else {
            jSONObject.put("filesize", skin.volume);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m5965a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = null;
        try {
            Skin skin = new Skin();
            ContentValues contentValues = new ContentValues();
            cursorRawQuery = sQLiteDatabase.rawQuery(C3364o.m11849a("SELECT * FROM ", "skin", " WHERE ", "install", " != ?"), new String[]{"0"});
            while (cursorRawQuery.moveToNext()) {
                skin.f5654id = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("skin_id"));
                skin.newitem = Boolean.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("new")) != 0);
                skin.special = Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("special")));
                skin.thumbnailurl = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("thumbnail_url"));
                skin.bgtype = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("bg_type"));
                skin.expirationdate = Long.valueOf(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("expiration_date")));
                long j = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("install"));
                contentValues.put("item_type", EnumC1399aq.Skin.m6252a());
                contentValues.put("item_id", skin.f5654id);
                contentValues.put("new", skin.newitem);
                contentValues.put("special", skin.special);
                contentValues.put("extras", m5966b(skin).toString());
                contentValues.put("expiration_time", skin.expirationdate);
                contentValues.put("install", Long.valueOf(j));
                sQLiteDatabase.insert("download_item", null, contentValues);
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* renamed from: b */
    public static void m5967b(SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        Skin skin = new Skin();
        skin.f5654id = "-5";
        skin.bgtype = "pa";
        skin.newitem = false;
        skin.special = 0;
        skin.thumbnailurl = C3364o.m11849a("android.resource", "://", CommonApplication.m11493l().getPackageName(), "/drawable/default_preview_05");
        skin.expirationdate = Long.MAX_VALUE;
        contentValues.put("item_type", EnumC1399aq.Skin.m6252a());
        contentValues.put("item_id", skin.f5654id);
        contentValues.put("new", skin.newitem);
        contentValues.put("special", skin.special);
        contentValues.put("extras", m5966b(skin).toString());
        contentValues.put("expiration_time", skin.expirationdate);
        contentValues.put("install", (Integer) 1);
        sQLiteDatabase.insert("download_item", null, contentValues);
    }
}
