package com.sec.chaton.trunk.database.p052a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import com.sec.chaton.trunk.database.C1586b;
import com.sec.chaton.trunk.database.C1587c;
import com.sec.chaton.trunk.database.C1589e;
import com.sec.chaton.trunk.database.EnumC1588d;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.trunk.entry.inner.Trunk;
import com.sec.chaton.trunk.entry.inner.TrunkItem;
import java.util.ArrayList;

/* compiled from: TrunkDatabaseHelper.java */
/* renamed from: com.sec.chaton.trunk.database.a.a */
/* loaded from: classes.dex */
public class C1584a {

    /* renamed from: a */
    private static final String f5687a = C1584a.class.getSimpleName();

    /* renamed from: a */
    public static ContentProviderResult[] m5472a(Context context, ArrayList arrayList) {
        return context.getContentResolver().applyBatch("com.develop.sec.chaton.provider", arrayList);
    }

    /* renamed from: a */
    public static ContentProviderResult[] m5471a(Context context, ContentProviderOperation contentProviderOperation) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(contentProviderOperation);
        return context.getContentResolver().applyBatch("com.develop.sec.chaton.provider", arrayList);
    }

    /* renamed from: a */
    public static ContentProviderOperation m5465a(Trunk trunk) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("session_id", trunk.sessionid);
        contentValues.put("last_update_time", Long.valueOf(trunk.lastupdttm));
        contentValues.put("last_comment_time", Long.valueOf(trunk.lastcmtdttm));
        contentValues.put("total_item_count", Integer.valueOf(trunk.totitemcnt));
        contentValues.put("unread_item_count", Integer.valueOf(trunk.unreaditemcnt));
        return ContentProviderOperation.newInsert(C1589e.f5703a.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m5469a(String str) {
        new ContentValues().put("session_id", str);
        return ContentProviderOperation.newDelete(C1589e.f5703a.buildUpon().appendPath(str).build()).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m5466a(TrunkItem trunkItem) {
        return m5467a(trunkItem, EnumC1588d.Item, false);
    }

    /* renamed from: a */
    public static ContentProviderOperation m5468a(TrunkItem trunkItem, boolean z) {
        return m5467a(trunkItem, EnumC1588d.Item, z);
    }

    /* renamed from: a */
    private static ContentProviderOperation m5467a(TrunkItem trunkItem, EnumC1588d enumC1588d, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("session_id", trunkItem.sessionid);
        contentValues.put("item_id", trunkItem.itemid);
        contentValues.put("total_comment_count", Integer.valueOf(trunkItem.totcmtcnt));
        contentValues.put("unread_comment_count", Integer.valueOf(trunkItem.unreadcmtcnt));
        contentValues.put("last_comment_time", Long.valueOf(trunkItem.lastcmtdttm));
        contentValues.put("registration_time", Long.valueOf(trunkItem.regdttm));
        contentValues.put("content_type", trunkItem.file.contenttype);
        contentValues.put("thumbnail", trunkItem.file.thumburl);
        contentValues.put("down_url", trunkItem.file.downurl);
        contentValues.put("item_type", Integer.valueOf(enumC1588d.m5481a()));
        contentValues.put("sender_uid", trunkItem.user.f5717id);
        contentValues.put("sender_name", trunkItem.user.orgname);
        contentValues.put("sender_number", trunkItem.user.orgnum);
        return ContentProviderOperation.newInsert(C1587c.f5698a.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).appendQueryParameter("withLoadMoreItem", String.valueOf(z)).build()).withValues(contentValues).build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m5473b(String str) {
        return m5470a(str, EnumC1588d.Item);
    }

    /* renamed from: a */
    private static ContentProviderOperation m5470a(String str, EnumC1588d enumC1588d) {
        return ContentProviderOperation.newDelete(C1587c.f5698a.buildUpon().appendPath(str).appendQueryParameter("effect", Boolean.TRUE.toString()).build()).withSelection("item_type=?", new String[]{String.valueOf(enumC1588d.m5481a())}).build();
    }

    /* renamed from: c */
    public static ContentProviderOperation m5474c(String str) {
        return m5470a(str, EnumC1588d.LoadMore);
    }

    /* renamed from: d */
    public static ContentProviderOperation m5475d(String str) {
        return ContentProviderOperation.newDelete(C1587c.f5698a.buildUpon().appendQueryParameter("rearrangeLoadMoreItem", Boolean.FALSE.toString()).build()).withSelection("session_id=?", new String[]{str}).build();
    }

    /* renamed from: e */
    public static ContentProviderOperation m5476e(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("dummy", "dummy");
        return ContentProviderOperation.newUpdate(C1587c.f5698a.buildUpon().appendPath("markAsRead").appendPath(str).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m5464a(Comment comment) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("comment_id", comment.cid);
        contentValues.put("item_id", comment.itemid);
        contentValues.put("registration_time", Long.valueOf(comment.regdttm));
        contentValues.put("writer_uid", comment.user.f5717id);
        contentValues.put("writer_name", comment.user.orgname);
        contentValues.put("writer_number", comment.user.orgnum);
        contentValues.put("content", comment.content);
        return ContentProviderOperation.newInsert(C1586b.f5697a.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).build()).withValues(contentValues).build();
    }

    /* renamed from: f */
    public static ContentProviderOperation m5477f(String str) {
        return ContentProviderOperation.newDelete(C1586b.f5697a.buildUpon().appendPath(str).appendQueryParameter("effect", Boolean.TRUE.toString()).build()).build();
    }

    /* renamed from: g */
    public static ContentProviderOperation m5478g(String str) {
        return ContentProviderOperation.newDelete(C1586b.f5697a).withSelection("item_id=?", new String[]{str}).build();
    }
}
