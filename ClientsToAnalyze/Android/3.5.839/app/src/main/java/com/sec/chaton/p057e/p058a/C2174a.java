package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.sec.chaton.p055d.EnumC2125f;
import com.sec.chaton.p057e.C2235aw;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.settings.p096a.C3433a;
import com.sec.chaton.shop.entrys.StampItem;
import com.sec.chaton.shop.items.AmsStampItem;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4873ck;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5052r;
import java.io.File;

/* compiled from: AmsItemDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.a */
/* loaded from: classes.dex */
public class C2174a {
    /* renamed from: a */
    public static ContentProviderOperation m9663a(StampItem stampItem, EnumC2258bd enumC2258bd) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", stampItem.packageId);
        contentValues.put("item_type", enumC2258bd.m10123a());
        contentValues.put("expiration_time", (Long) Long.MAX_VALUE);
        contentValues.put("install", Long.valueOf(C5034k.m19090a()));
        contentValues.put("newly_installed", (Integer) 0);
        return ContentProviderOperation.newInsert(C4821am.m18188a(C2257bc.m10121a(enumC2258bd))).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9662a(StampItem stampItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("stamp_id", stampItem.itemId);
        contentValues.put("item_id", stampItem.packageId);
        contentValues.put("file_name", stampItem.itemId);
        return ContentProviderOperation.newInsert(C4821am.m18188a(C2235aw.f7979a)).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static void m9665a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = null;
        try {
            ContentValues contentValues = new ContentValues();
            AmsStampItem amsStampItem = new AmsStampItem();
            cursorRawQuery = sQLiteDatabase.rawQuery(C5052r.m19199a("SELECT * FROM ", "download_item", " WHERE ", "item_type", " = ? and ", "install", "!= ?"), new String[]{EnumC2258bd.AmsStamp.m10123a(), Spam.ACTIVITY_CANCEL});
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                while (cursorRawQuery.moveToNext()) {
                    amsStampItem.amsStampId = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("item_id"));
                    contentValues.put("stamp_id", Long.valueOf(amsStampItem.amsStampId));
                    contentValues.put("item_id", Long.valueOf(amsStampItem.amsStampId));
                    contentValues.put("file_name", Long.valueOf(amsStampItem.amsStampId));
                    sQLiteDatabase.insert("ams_stamp_item", null, contentValues);
                    m9664a(amsStampItem.amsStampId);
                }
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* renamed from: a */
    public static void m9664a(long j) {
        if (C4873ck.m18500a()) {
            String string = Long.toString(j);
            File fileM13701c = C3433a.m13701c(CommonApplication.m18732r(), EnumC2125f.Stamp, string);
            String absolutePath = fileM13701c.getAbsolutePath();
            File file = new File(fileM13701c.getAbsolutePath() + "temp");
            fileM13701c.renameTo(file);
            if (fileM13701c != null) {
                File file2 = new File(absolutePath + "/" + string);
                if (!file2.exists()) {
                    fileM13701c.mkdirs();
                }
                file.renameTo(file2);
            }
        }
    }
}
