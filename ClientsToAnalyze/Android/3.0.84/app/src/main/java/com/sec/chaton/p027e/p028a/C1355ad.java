package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p035io.entry.inner.EffectSound;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SoundDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.ad */
/* loaded from: classes.dex */
public class C1355ad extends C1366j {

    /* renamed from: a */
    private static final String f5098a = C1355ad.class.getSimpleName();

    /* renamed from: a */
    public static ContentProviderOperation m5976a(EffectSound effectSound) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_type", EnumC1399aq.Sound.m6252a());
        contentValues.put("item_id", effectSound.f5643id);
        contentValues.put("new", effectSound.newitem);
        contentValues.put("special", effectSound.special);
        contentValues.put("name", effectSound.title);
        contentValues.put("extras", m5979b(effectSound).toString());
        return ContentProviderOperation.newInsert(C3170al.m11041a(C1398ap.m6249a(EnumC1399aq.Sound))).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static String[] m5978a(Context context) {
        if (context == null) {
            return null;
        }
        Cursor cursorRawQuery = C1404av.m6253a(context).getReadableDatabase().rawQuery("SELECT item_id FROM download_item WHERE item_type == \"" + EnumC1399aq.Sound.m6252a() + "\" AND install != 0", null);
        if (cursorRawQuery == null) {
            C3250y.m11450b("download_sound, cursor is (null) ", f5098a);
            return null;
        }
        int count = cursorRawQuery.getCount();
        if (count <= 0) {
            C3250y.m11450b("download_sound, not installed is (zero) ", f5098a);
            cursorRawQuery.close();
            return null;
        }
        String[] strArr = new String[count];
        int i = 0;
        while (cursorRawQuery.moveToNext()) {
            strArr[i] = String.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("item_id")));
            i++;
        }
        C3250y.m11450b("download_font, not installed count/id : " + count + "/" + strArr, f5098a);
        cursorRawQuery.close();
        return strArr;
    }

    /* renamed from: a */
    public static C1356ae m5977a(String str) {
        C1356ae c1356ae = new C1356ae();
        JSONObject jSONObject = new JSONObject(str);
        c1356ae.m5981a(jSONObject.getLong("filesize"));
        c1356ae.m5982a(jSONObject.getString("samplefileurl"));
        return c1356ae;
    }

    /* renamed from: b */
    public static JSONObject m5979b(EffectSound effectSound) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("filesize", effectSound.filesize);
        jSONObject.put("samplefileurl", effectSound.samplefileurl);
        return jSONObject;
    }
}
