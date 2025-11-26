package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.C2268bn;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.shop.items.SoundItem;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5034k;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SoundDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.ak */
/* loaded from: classes.dex */
public class C2185ak extends C2196j {

    /* renamed from: a */
    private static final String f7826a = C2185ak.class.getSimpleName();

    /* renamed from: a */
    public static ContentProviderOperation m9756a(DownloadRequestEntry downloadRequestEntry) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_type", EnumC2258bd.Sound.m10123a());
        contentValues.put("item_id", Long.valueOf(downloadRequestEntry.itemId));
        contentValues.put("name", downloadRequestEntry.sound.title);
        contentValues.put("expiration_time", Long.valueOf(downloadRequestEntry.endValidPeriod));
        contentValues.put("install", Long.valueOf(C5034k.m19090a()));
        contentValues.put("newly_installed", Long.valueOf(C5034k.m19090a()));
        contentValues.put("item_version", Integer.valueOf(downloadRequestEntry.itemVersion));
        contentValues.put("extras", m9757a(downloadRequestEntry.sound).toString());
        return ContentProviderOperation.newInsert(C4821am.m18188a(C2257bc.m10121a(EnumC2258bd.Sound))).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static String[] m9758a(Context context) {
        if (context == null) {
            return null;
        }
        Cursor cursorRawQuery = C2268bn.m10126a(context).getReadableDatabase().rawQuery("SELECT item_id FROM download_item WHERE item_type == \"" + EnumC2258bd.Sound.m10123a() + "\" AND install != 0", null);
        if (cursorRawQuery == null) {
            C4904y.m18639b("download_sound, cursor is (null) ", f7826a);
            return null;
        }
        int count = cursorRawQuery.getCount();
        if (count <= 0) {
            C4904y.m18639b("download_sound, not installed is (zero) ", f7826a);
            cursorRawQuery.close();
            return null;
        }
        String[] strArr = new String[count];
        int i = 0;
        while (cursorRawQuery.moveToNext()) {
            strArr[i] = String.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("item_id")));
            i++;
        }
        C4904y.m18639b("download_font, not installed count/id : " + count + "/" + strArr, f7826a);
        cursorRawQuery.close();
        return strArr;
    }

    /* renamed from: a */
    public static JSONObject m9757a(SoundItem soundItem) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("filesize", soundItem.fileSize);
        return jSONObject;
    }
}
