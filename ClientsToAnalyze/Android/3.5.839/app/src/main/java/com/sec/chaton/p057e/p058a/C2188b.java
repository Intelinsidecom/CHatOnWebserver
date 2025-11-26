package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p057e.C2255ba;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.shop.items.AniconItem;
import com.sec.chaton.shop.items.AniconPackage;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5052r;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AniconDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.b */
/* loaded from: classes.dex */
public class C2188b extends C2196j {
    /* renamed from: a */
    public static ContentProviderOperation m9785a(DownloadRequestEntry downloadRequestEntry) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_type", EnumC2258bd.Anicon.m10123a());
        contentValues.put("item_id", Long.valueOf(downloadRequestEntry.itemId));
        contentValues.put("name", downloadRequestEntry.aniconPackage.charName);
        contentValues.put("extras", m9790a(downloadRequestEntry.aniconPackage).toString());
        contentValues.put("expiration_time", Long.valueOf(downloadRequestEntry.endValidPeriod));
        contentValues.put("data1", downloadRequestEntry.aniconPackage.packageNumFirst);
        contentValues.put("data2", downloadRequestEntry.aniconPackage.packageNumSecond);
        contentValues.put("data3", downloadRequestEntry.aniconPackage.packageNumThird);
        contentValues.put("install", Long.valueOf(C5034k.m19090a()));
        contentValues.put("newly_installed", Long.valueOf(C5034k.m19090a()));
        contentValues.put("item_version", Integer.valueOf(downloadRequestEntry.itemVersion));
        return ContentProviderOperation.newInsert(C4821am.m18188a(C2257bc.m10121a(EnumC2258bd.Anicon))).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9788a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str2);
        return ContentProviderOperation.newUpdate(C2257bc.m10121a(EnumC2258bd.Anicon).buildUpon().appendPath(str).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9787a(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("install", Long.valueOf(j));
        return ContentProviderOperation.newUpdate(C2257bc.m10121a(EnumC2258bd.Anicon).buildUpon().appendPath(str).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9786a(DownloadRequestEntry downloadRequestEntry, AniconItem aniconItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("anicon_id", Integer.valueOf(aniconItem.aniconId));
        contentValues.put("package_id", Long.valueOf(downloadRequestEntry.itemId));
        contentValues.put("delegate_url", aniconItem.delegateImage);
        contentValues.put("cd_proxy_url", C4809aa.m18104a().m18121a("primary_contact_addrss", "http://us.content.samsungchaton.com") + "/file/download/anicon");
        return ContentProviderOperation.newInsert(C4821am.m18188a(C2255ba.f8038a)).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static C2189c m9789a(String str) {
        C2189c c2189c = new C2189c();
        JSONObject jSONObject = new JSONObject(str);
        c2189c.m9796a(jSONObject.getInt(VKApiConst.COUNT));
        c2189c.m9797a(jSONObject.getString("panel"));
        return c2189c;
    }

    /* renamed from: a */
    public static JSONObject m9790a(AniconPackage aniconPackage) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(VKApiConst.COUNT, aniconPackage.aniconCount);
        jSONObject.put("panel", aniconPackage.panelUrl);
        return jSONObject;
    }

    /* renamed from: a */
    public static void m9791a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = null;
        try {
            DownloadRequestEntry downloadRequestEntry = new DownloadRequestEntry();
            ContentValues contentValues = new ContentValues();
            cursorRawQuery = sQLiteDatabase.rawQuery(C5052r.m19199a("SELECT * FROM ", "anicon_package", " WHERE ", "install", " != ?"), new String[]{Spam.ACTIVITY_CANCEL});
            while (cursorRawQuery.moveToNext()) {
                downloadRequestEntry.itemId = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("package_id"));
                downloadRequestEntry.aniconPackage.charName = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("name"));
                downloadRequestEntry.aniconPackage.aniconCount = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("anicon_count"));
                downloadRequestEntry.endValidPeriod = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("expiration_time"));
                downloadRequestEntry.aniconPackage.panelUrl = "";
                long j = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("install"));
                contentValues.put("item_type", EnumC2258bd.Anicon.m10123a());
                contentValues.put("item_id", Long.valueOf(downloadRequestEntry.itemId));
                contentValues.put("name", downloadRequestEntry.aniconPackage.charName);
                contentValues.put("extras", m9790a(downloadRequestEntry.aniconPackage).toString());
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

    /* renamed from: b */
    public static void m9792b(SQLiteDatabase sQLiteDatabase) {
        boolean z = C1427a.f5063a.split("[.]").length == 4;
        String str = z ? "801" : "201";
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery(C5052r.m19199a("SELECT * FROM ", "download_item", " WHERE ", "item_id", " =? "), new String[]{str});
            if (cursorRawQuery != null && cursorRawQuery.moveToNext()) {
                int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("install"));
                if (C4904y.f17872b) {
                    C4904y.m18639b("installed : " + i, C2188b.class.getSimpleName());
                }
                if (i > 0) {
                    if (cursorRawQuery != null) {
                        return;
                    } else {
                        return;
                    }
                }
                sQLiteDatabase.delete("download_item", "item_id=?", new String[]{str});
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            sQLiteDatabase.delete("anicon_item", "package_id=?", new String[]{str});
            if (z) {
                m9794d(sQLiteDatabase);
            } else {
                m9793c(sQLiteDatabase);
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* renamed from: c */
    private static void m9793c(SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_type", EnumC2258bd.Anicon.m10123a());
        contentValues.put("item_id", (Integer) 201);
        contentValues.put("reference_id", (Integer) 0);
        contentValues.put("name", "Hi ChatON, Hello Chatty");
        contentValues.put("new", (Integer) 0);
        contentValues.put("special", (Integer) 0);
        AniconPackage aniconPackage = new AniconPackage();
        aniconPackage.aniconCount = 12;
        aniconPackage.panelUrl = "http://cdn.samsungbigdata.com/itemshop/sms/anicon/package/201/panel_ac_chatonsymbol01set_pn.png";
        try {
            contentValues.put("extras", m9790a(aniconPackage).toString());
        } catch (JSONException e) {
        }
        contentValues.put("expiration_time", (Long) 2145916799998L);
        contentValues.put("down_rank", (Integer) 999);
        contentValues.put("data1", "0036");
        contentValues.put("data2", "001");
        contentValues.put("data3", "001");
        contentValues.put("install", Long.valueOf(C5034k.m19090a()));
        sQLiteDatabase.insert("download_item", null, contentValues);
        int[] iArr = {2404, 2400, 2407, 2401, 2406, 2408, 2409, 2411, 2410, 2402, 2403, 2405};
        String[] strArr = {"http://cdn.samsungbigdata.com/itemshop/sms/anicon/piece/2404/240/png/zip/2404_png_240.zip", "http://cdn.samsungbigdata.com/itemshop/sms/anicon/piece/2400/240/png/zip/2400_png_240.zip", "http://cdn.samsungbigdata.com/itemshop/sms/anicon/piece/2407/240/png/zip/2407_png_240.zip", "http://cdn.samsungbigdata.com/itemshop/sms/anicon/piece/2401/240/png/zip/2401_png_240.zip", "http://cdn.samsungbigdata.com/itemshop/sms/anicon/piece/2406/240/png/zip/2406_png_240.zip", "http://cdn.samsungbigdata.com/itemshop/sms/anicon/piece/2408/240/png/zip/2408_png_240.zip", "http://cdn.samsungbigdata.com/itemshop/sms/anicon/piece/2409/240/png/zip/2409_png_240.zip", "http://cdn.samsungbigdata.com/itemshop/sms/anicon/piece/2411/240/png/zip/2411_png_240.zip", "http://cdn.samsungbigdata.com/itemshop/sms/anicon/piece/2410/240/png/zip/2410_png_240.zip", "http://cdn.samsungbigdata.com/itemshop/sms/anicon/piece/2402/240/png/zip/2402_png_240.zip", "http://cdn.samsungbigdata.com/itemshop/sms/anicon/piece/2403/240/png/zip/2403_png_240.zip", "http://cdn.samsungbigdata.com/itemshop/sms/anicon/piece/2405/240/png/zip/2405_png_240.zip"};
        String[] strArr2 = {"surprise_sub.jpg", "joy_sub.jpg", "sorrow_sub.jpg", "anger_sub.jpg", "congratulation_sub.jpg", "dissatisfaction_sub.jpg", "pain_sub.jpg", "event_sub.jpg", "fun_sub.jpg", "love_sub.jpg", "hello_sub.jpg", "arrogance_sub.jpg"};
        for (int i = 0; i < 12; i++) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("anicon_id", Integer.valueOf(iArr[i]));
            contentValues2.put("package_id", (Integer) 201);
            contentValues2.put("zip_url", strArr[i]);
            contentValues2.put("delegate_url", strArr2[i]);
            contentValues2.put("cd_proxy_url", "https://us.content.samsungchaton.com/file/download/anicon");
            sQLiteDatabase.insert("anicon_item", null, contentValues2);
        }
    }

    /* renamed from: d */
    private static void m9794d(SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_type", EnumC2258bd.Anicon.m10123a());
        contentValues.put("item_id", (Integer) 801);
        contentValues.put("reference_id", (Integer) 0);
        contentValues.put("name", "Hi ChatON, Hello Chatty");
        contentValues.put("new", (Integer) 0);
        contentValues.put("special", (Integer) 0);
        AniconPackage aniconPackage = new AniconPackage();
        aniconPackage.aniconCount = 12;
        aniconPackage.panelUrl = "http://stg-cdn.samsungbigdata.com/itemshop/sms/anicon/package/801/panel_ac_chatonsymbol01set_pn.png";
        try {
            contentValues.put("extras", m9790a(aniconPackage).toString());
        } catch (JSONException e) {
        }
        contentValues.put("expiration_time", (Long) 2145916799863L);
        contentValues.put("down_rank", (Integer) 999);
        contentValues.put("data1", "0036");
        contentValues.put("data2", "001");
        contentValues.put("data3", "001");
        contentValues.put("install", Long.valueOf(C5034k.m19090a()));
        sQLiteDatabase.insert("download_item", null, contentValues);
        int[] iArr = {8074, 8064, 8063, 8065, 8072, 8066, 8067, 8068, 8069, 8070, 8071, 8073};
        String[] strArr = {"http://stg-cdn.samsungbigdata.com/itemshop/sms/anicon/piece/8074/240/png/zip/8074_png_240.zip", "http://stg-cdn.samsungbigdata.com/itemshop/sms/anicon/piece/8064/240/png/zip/8064_png_240.zip", "http://stg-cdn.samsungbigdata.com/itemshop/sms/anicon/piece/8063/240/png/zip/8063_png_240.zip", "http://stg-cdn.samsungbigdata.com/itemshop/sms/anicon/piece/8065/240/png/zip/8065_png_240.zip", "http://stg-cdn.samsungbigdata.com/itemshop/sms/anicon/piece/8072/240/png/zip/8072_png_240.zip", "http://stg-cdn.samsungbigdata.com/itemshop/sms/anicon/piece/8066/240/png/zip/8066_png_240.zip", "http://stg-cdn.samsungbigdata.com/itemshop/sms/anicon/piece/8067/240/png/zip/8067_png_240.zip", "http://stg-cdn.samsungbigdata.com/itemshop/sms/anicon/piece/8068/240/png/zip/8068_png_240.zip", "http://stg-cdn.samsungbigdata.com/itemshop/sms/anicon/piece/8069/240/png/zip/8069_png_240.zip", "http://stg-cdn.samsungbigdata.com/itemshop/sms/anicon/piece/8070/240/png/zip/8070_png_240.zip", "http://stg-cdn.samsungbigdata.com/itemshop/sms/anicon/piece/8071/240/png/zip/8071_png_240.zip", "http://stg-cdn.samsungbigdata.com/itemshop/sms/anicon/piece/8073/240/png/zip/8073_png_240.zip"};
        String[] strArr2 = {"event_sub.jpg", "anger_sub.jpg", "joy_sub.jpg", "love_sub.jpg", "pain_sub.jpg", "hello_sub.jpg", "surprise_sub.jpg", "arrogance_sub.jpg", "congratulation_sub.jpg", "sorrow_sub.jpg", "dissatisfaction_sub.jpg", "fun_sub.jpg"};
        for (int i = 0; i < 12; i++) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("anicon_id", Integer.valueOf(iArr[i]));
            contentValues2.put("package_id", (Integer) 801);
            contentValues2.put("zip_url", strArr[i]);
            contentValues2.put("delegate_url", strArr2[i]);
            contentValues2.put("cd_proxy_url", "http://us.content.samsungchaton.com/file/download/anicon");
            sQLiteDatabase.insert("anicon_item", null, contentValues2);
        }
    }
}
