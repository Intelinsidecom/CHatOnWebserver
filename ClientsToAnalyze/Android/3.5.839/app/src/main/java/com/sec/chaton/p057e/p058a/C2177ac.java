package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.RemoteException;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.p057e.C2264bj;
import com.sec.chaton.p057e.EnumC2265bk;
import com.sec.chaton.p065io.entry.inner.Promotion;
import com.sec.chaton.settings.moreapps.entry.CurationList;
import com.sec.chaton.settings.moreapps.entry.EventList;
import com.sec.chaton.settings.moreapps.entry.RecommendList;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PlusListDataBaseHelper.java */
/* renamed from: com.sec.chaton.e.a.ac */
/* loaded from: classes.dex */
public class C2177ac {

    /* renamed from: a */
    private static final String f7805a = C2177ac.class.getSimpleName();

    /* renamed from: a */
    public static ContentProviderOperation m9703a(CurationList curationList) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", curationList.specialUserId);
        contentValues.put("title", curationList.name);
        contentValues.put("rank", curationList.rank);
        contentValues.put(VKApiConst.COUNTRY, curationList.targetCountry);
        contentValues.put("menutype", EnumC2265bk.LIVE.m10125a());
        return ContentProviderOperation.newInsert(C2264bj.f8054a).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9705a(RecommendList recommendList) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(recommendList.itemId));
        contentValues.put("itemtype", recommendList.itemType);
        contentValues.put("title", recommendList.title);
        contentValues.put("pricetype", recommendList.priceType);
        contentValues.put("price", recommendList.price);
        contentValues.put("thumbnailurl", recommendList.thumbUrl);
        contentValues.put("currency", recommendList.currency);
        contentValues.put("menutype", EnumC2265bk.SHOP.m10125a());
        return ContentProviderOperation.newInsert(C2264bj.f8054a).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9704a(EventList eventList) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(eventList.eventId));
        contentValues.put("title", eventList.title);
        contentValues.put("start_time", Long.valueOf(eventList.startDate));
        contentValues.put("end_time", Long.valueOf(eventList.endDate));
        if (eventList.imageUrl.size() > 1) {
            if (eventList.imageUrl.get(0).contains("_h.")) {
                contentValues.put("banner_h", eventList.imageUrl.get(0));
                contentValues.put("banner_v", eventList.imageUrl.get(1));
            } else {
                contentValues.put("banner_h", eventList.imageUrl.get(1));
                contentValues.put("banner_v", eventList.imageUrl.get(0));
            }
        }
        contentValues.put("weburl", eventList.webUrl);
        contentValues.put("menutype", EnumC2265bk.EVENT.m10125a());
        return ContentProviderOperation.newInsert(C2264bj.f8054a).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static void m9707a(List<Promotion> list) {
        ContentValues contentValues = new ContentValues();
        StringBuilder sb = new StringBuilder(C4809aa.m18104a().m18121a("new_promotion_ids", ""));
        sb.append(",");
        ArrayList arrayList = new ArrayList();
        for (Promotion promotion : list) {
            contentValues.put("id", promotion.f8577id);
            contentValues.put("start_time", promotion.from);
            contentValues.put("end_time", promotion.f8578to);
            contentValues.put("weburl", promotion.value);
            contentValues.put("menutype", EnumC2265bk.EVENT.m10125a());
            sb.append(promotion.f8577id).append(",");
            arrayList.add(ContentProviderOperation.newInsert(C2264bj.f8054a).withValues(contentValues).build());
        }
        try {
            C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
        } catch (OperationApplicationException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f7805a);
            }
        } catch (RemoteException e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f7805a);
            }
        }
        C4809aa.m18104a().m18128b("new_promotion_ids", sb.toString());
    }

    /* renamed from: a */
    public static ContentProviderOperation m9702a() {
        return ContentProviderOperation.newDelete(C2264bj.f8054a).build();
    }

    /* renamed from: a */
    public static void m9706a(SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        Cursor cursorQuery = sQLiteDatabase.query("pluslist", null, null, null, null, null, null);
        while (cursorQuery.moveToNext()) {
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
            if (cursorQuery.getString(cursorQuery.getColumnIndex("itemtype")) != null) {
                contentValues.put("menutype", EnumC2265bk.SHOP.m10125a());
            } else {
                contentValues.put("menutype", EnumC2265bk.LIVE.m10125a());
            }
            sQLiteDatabase.update("pluslist", contentValues, "id=?", new String[]{string});
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("update", "Check");
        }
    }
}
