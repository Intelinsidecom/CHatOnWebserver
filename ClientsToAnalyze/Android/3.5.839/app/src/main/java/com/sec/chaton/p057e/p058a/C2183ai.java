package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p065io.entry.inner.Skin;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.shop.items.BgBubblePackage;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5052r;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SkinDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.ai */
/* loaded from: classes.dex */
public class C2183ai extends C2196j {

    /* renamed from: a */
    static final String f7822a = C2183ai.class.getSimpleName();

    /* renamed from: a */
    public static ContentProviderOperation m9744a(DownloadRequestEntry downloadRequestEntry) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_type", EnumC2258bd.Skin.m10123a());
        contentValues.put("item_id", Long.valueOf(downloadRequestEntry.itemId));
        contentValues.put("expiration_time", Long.valueOf(downloadRequestEntry.endValidPeriod));
        contentValues.put("install", Long.valueOf(C5034k.m19090a()));
        contentValues.put("extras", m9747a(downloadRequestEntry.bgBubble).toString());
        contentValues.put("item_version", Integer.valueOf(downloadRequestEntry.itemVersion));
        return ContentProviderOperation.newInsert(C4821am.m18188a(C2257bc.m10121a(EnumC2258bd.Skin))).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9745a(String str, long j, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_type", EnumC2258bd.SkinTheme.m10123a());
        contentValues.put("item_id", str);
        contentValues.put("expiration_time", Long.valueOf(j));
        contentValues.put("install", Long.valueOf(C5034k.m19090a()));
        try {
            contentValues.put("extras", m9749b(str2).toString());
        } catch (JSONException e) {
            if (C4904y.f17875e) {
                C4904y.m18639b("Json Err" + e, f7822a);
            }
        }
        return ContentProviderOperation.newInsert(C4821am.m18188a(C2257bc.m10121a(EnumC2258bd.SkinTheme))).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static C2184aj m9746a(String str) {
        C2184aj c2184aj = new C2184aj();
        JSONObject jSONObject = new JSONObject(str);
        c2184aj.m9754a(jSONObject.getString("bgtype"));
        try {
            c2184aj.m9755b(jSONObject.getString("detailviewurl"));
            c2184aj.m9753a(jSONObject.getLong("filesize"));
        } catch (Exception e) {
            c2184aj.m9755b("(empty)");
            c2184aj.m9753a(0L);
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f7822a);
            }
        }
        return c2184aj;
    }

    /* renamed from: a */
    public static JSONObject m9747a(BgBubblePackage bgBubblePackage) throws JSONException {
        String str;
        JSONObject jSONObject = new JSONObject();
        switch (bgBubblePackage.bgType) {
            case 1:
                str = "pa";
                break;
            case 2:
                str = "ma";
                break;
            case 3:
                str = "pa_ma";
                break;
            case 4:
                str = "ma_pa";
                break;
            default:
                str = "pa_ma";
                break;
        }
        jSONObject.put("bgtype", str);
        return jSONObject;
    }

    /* renamed from: b */
    public static JSONObject m9749b(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bgtype", str);
        return jSONObject;
    }

    /* renamed from: a */
    public static void m9748a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = null;
        try {
            DownloadRequestEntry downloadRequestEntry = new DownloadRequestEntry();
            ContentValues contentValues = new ContentValues();
            cursorRawQuery = sQLiteDatabase.rawQuery(C5052r.m19199a("SELECT * FROM ", "skin", " WHERE ", "install", " != ?"), new String[]{Spam.ACTIVITY_CANCEL});
            while (cursorRawQuery.moveToNext()) {
                downloadRequestEntry.itemId = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("skin_id"));
                downloadRequestEntry.bgBubble.bgType = m9751c(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("bg_type")));
                downloadRequestEntry.endValidPeriod = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("expiration_date"));
                long j = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("install"));
                contentValues.put("item_type", EnumC2258bd.Skin.m10123a());
                contentValues.put("item_id", Long.valueOf(downloadRequestEntry.itemId));
                contentValues.put("extras", m9747a(downloadRequestEntry.bgBubble).toString());
                contentValues.put("expiration_time", Long.valueOf(downloadRequestEntry.endValidPeriod));
                contentValues.put("install", Long.valueOf(j));
                sQLiteDatabase.insert("download_item", null, contentValues);
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* renamed from: c */
    private static int m9751c(String str) {
        if (str.equals("pa")) {
            return 1;
        }
        if (str.equals("ma")) {
            return 2;
        }
        if (str.equals("pa_ma")) {
            return 3;
        }
        return 4;
    }

    /* renamed from: b */
    public static void m9750b(SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        BgBubblePackage bgBubblePackage = new BgBubblePackage();
        bgBubblePackage.bgType = 1;
        Skin skin = new Skin();
        skin.f8579id = "-5";
        skin.newitem = false;
        skin.special = 0;
        skin.thumbnailurl = C5052r.m19199a("android.resource", "://", CommonApplication.m18732r().getPackageName(), "/drawable/default_preview_05");
        skin.expirationdate = Long.MAX_VALUE;
        contentValues.put("item_type", EnumC2258bd.Skin.m10123a());
        contentValues.put("item_id", skin.f8579id);
        contentValues.put("new", skin.newitem);
        contentValues.put("special", skin.special);
        contentValues.put("extras", m9747a(bgBubblePackage).toString());
        contentValues.put("expiration_time", skin.expirationdate);
        contentValues.put("install", (Integer) 1);
        sQLiteDatabase.insert("download_item", null, contentValues);
    }
}
