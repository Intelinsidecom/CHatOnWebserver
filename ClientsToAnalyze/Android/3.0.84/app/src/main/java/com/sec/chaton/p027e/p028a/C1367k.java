package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p035io.entry.inner.FontPackage;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FontDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.k */
/* loaded from: classes.dex */
public class C1367k extends C1366j {

    /* renamed from: a */
    private static final String f5116a = C1367k.class.getSimpleName();

    /* renamed from: a */
    public static ContentProviderOperation m6094a(FontPackage fontPackage) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_type", EnumC1399aq.Font.m6252a());
        contentValues.put("item_id", fontPackage.f5645id);
        contentValues.put("reference_id", fontPackage.filterid);
        contentValues.put("name", fontPackage.title);
        contentValues.put("new", fontPackage.newitem);
        contentValues.put("special", fontPackage.special);
        contentValues.put("extras", m6098b(fontPackage).toString());
        contentValues.put("expiration_time", fontPackage.expirationdate);
        return ContentProviderOperation.newInsert(C3170al.m11041a(C1398ap.m6249a(EnumC1399aq.Font))).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static C1368l m6095a(String str) {
        C1368l c1368l = new C1368l();
        JSONObject jSONObject = new JSONObject(str);
        c1368l.f5119c = jSONObject.getString("previewurl");
        c1368l.f5118b = jSONObject.getString("thumbnailurl");
        c1368l.f5117a = jSONObject.getString("description");
        c1368l.f5120d = jSONObject.getLong("filesize");
        return c1368l;
    }

    /* renamed from: b */
    public static JSONObject m6098b(FontPackage fontPackage) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("previewurl", fontPackage.previewurl);
        jSONObject.put("thumbnailurl", fontPackage.thumbnailurl);
        jSONObject.put("description", fontPackage.description);
        jSONObject.put("filesize", fontPackage.filesize);
        return jSONObject;
    }

    /* renamed from: a */
    public static void m6097a(Context context) throws SQLException {
        if (context != null) {
            C1404av.m6253a(context).getWritableDatabase().execSQL("DELETE FROM font_filter WHERE filter_id NOT IN (SELECT reference_id FROM download_item WHERE install != 0 AND item_type == \"" + EnumC1399aq.Font.m6252a() + "\" GROUP BY reference_id)");
        }
    }

    /* renamed from: b */
    public static String[] m6099b(Context context) {
        if (context == null) {
            return null;
        }
        Cursor cursorRawQuery = C1404av.m6253a(context).getReadableDatabase().rawQuery("SELECT item_id FROM download_item WHERE item_type == \"" + EnumC1399aq.Font.m6252a() + "\" AND install != 0 ORDER BY item_id", null);
        if (cursorRawQuery == null) {
            C3250y.m11450b("download_font, cursor is (null) ", f5116a);
            return null;
        }
        int count = cursorRawQuery.getCount();
        if (count <= 0) {
            C3250y.m11450b("download_font, not installed is (zero) ", f5116a);
            cursorRawQuery.close();
            return null;
        }
        String[] strArr = new String[count];
        int i = 0;
        while (cursorRawQuery.moveToNext()) {
            strArr[i] = String.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("item_id")));
            i++;
        }
        C3250y.m11450b("download_font, not installed count/id : " + count + "/" + strArr, f5116a);
        cursorRawQuery.close();
        return strArr;
    }

    /* renamed from: a */
    public static ArrayList<String> m6096a(Context context, String str) {
        if (context == null) {
            return null;
        }
        Cursor cursorRawQuery = C1404av.m6253a(context).getReadableDatabase().rawQuery("SELECT *  FROM download_item WHERE item_id == " + str + " AND item_type == \"" + EnumC1399aq.Font.m6252a() + "\"", null);
        if (cursorRawQuery.getCount() <= 0) {
            C3250y.m11450b("download_font, getFontItem, not found : " + str.toString(), f5116a);
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
