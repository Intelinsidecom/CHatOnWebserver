package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.C2268bn;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.shop.items.FontItem;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5034k;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FontDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.k */
/* loaded from: classes.dex */
public class C2197k extends C2196j {

    /* renamed from: a */
    private static final String f7835a = C2197k.class.getSimpleName();

    /* renamed from: a */
    public static ContentProviderOperation m9900a(DownloadRequestEntry downloadRequestEntry) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_type", EnumC2258bd.Font.m10123a());
        contentValues.put("item_id", Long.valueOf(downloadRequestEntry.itemId));
        contentValues.put("name", downloadRequestEntry.font.title);
        contentValues.put("install", Long.valueOf(C5034k.m19090a()));
        contentValues.put("newly_installed", Long.valueOf(C5034k.m19090a()));
        contentValues.put("extras", m9902a(downloadRequestEntry.font).toString());
        contentValues.put("expiration_time", Long.valueOf(downloadRequestEntry.endValidPeriod));
        contentValues.put("item_version", Integer.valueOf(downloadRequestEntry.itemVersion));
        return ContentProviderOperation.newInsert(C4821am.m18188a(C2257bc.m10121a(EnumC2258bd.Font))).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static JSONObject m9902a(FontItem fontItem) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("filesize", fontItem.fileSize);
        return jSONObject;
    }

    /* renamed from: a */
    public static void m9903a(Context context) throws SQLException {
        if (context != null) {
            C2268bn.m10126a(context).getWritableDatabase().execSQL("DELETE FROM font_filter WHERE filter_id NOT IN (SELECT reference_id FROM download_item WHERE install != 0 AND item_type == \"" + EnumC2258bd.Font.m10123a() + "\" GROUP BY reference_id)");
        }
    }

    /* renamed from: b */
    public static String[] m9904b(Context context) {
        if (context == null) {
            return null;
        }
        Cursor cursorRawQuery = C2268bn.m10126a(context).getReadableDatabase().rawQuery("SELECT item_id FROM download_item WHERE item_type == \"" + EnumC2258bd.Font.m10123a() + "\" AND install != 0 ORDER BY item_id", null);
        if (cursorRawQuery == null) {
            C4904y.m18639b("download_font, cursor is (null) ", f7835a);
            return null;
        }
        int count = cursorRawQuery.getCount();
        if (count <= 0) {
            C4904y.m18639b("download_font, not installed is (zero) ", f7835a);
            cursorRawQuery.close();
            return null;
        }
        String[] strArr = new String[count];
        int i = 0;
        while (cursorRawQuery.moveToNext()) {
            strArr[i] = String.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("item_id")));
            i++;
        }
        C4904y.m18639b("download_font, not installed count/id : " + count + "/" + strArr, f7835a);
        cursorRawQuery.close();
        return strArr;
    }

    /* renamed from: a */
    public static ArrayList<String> m9901a(Context context, String str) {
        if (context == null) {
            return null;
        }
        Cursor cursorRawQuery = C2268bn.m10126a(context).getReadableDatabase().rawQuery("SELECT *  FROM download_item WHERE item_id == " + str + " AND item_type == \"" + EnumC2258bd.Font.m10123a() + "\"", null);
        if (cursorRawQuery.getCount() <= 0) {
            C4904y.m18639b("download_font, getFontItem, not found : " + str.toString(), f7835a);
            return null;
        }
        cursorRawQuery.moveToFirst();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("name")));
        arrayList.add(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("install")));
        cursorRawQuery.close();
        return arrayList;
    }
}
