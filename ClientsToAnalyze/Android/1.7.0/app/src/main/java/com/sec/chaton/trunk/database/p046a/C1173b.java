package com.sec.chaton.trunk.database.p046a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import com.sec.chaton.trunk.database.C1175c;
import com.sec.chaton.trunk.database.C1176d;
import com.sec.chaton.trunk.database.C1178f;
import com.sec.chaton.trunk.database.EnumC1177e;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.trunk.entry.inner.Trunk;
import com.sec.chaton.trunk.entry.inner.TrunkItem;
import java.util.ArrayList;

/* compiled from: TrunkDatabaseHelper.java */
/* renamed from: com.sec.chaton.trunk.database.a.b */
/* loaded from: classes.dex */
public class C1173b {

    /* renamed from: a */
    private static final String f4034a = C1173b.class.getSimpleName();

    /* renamed from: a */
    public static ContentProviderResult[] m4238a(Context context, ArrayList arrayList) {
        return context.getContentResolver().applyBatch("com.develop.sec.chaton.provider", arrayList);
    }

    /* renamed from: a */
    public static ContentProviderResult[] m4237a(Context context, ContentProviderOperation contentProviderOperation) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(contentProviderOperation);
        return context.getContentResolver().applyBatch("com.develop.sec.chaton.provider", arrayList);
    }

    /* renamed from: a */
    public static ContentProviderOperation m4231a(Trunk trunk) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("session_id", trunk.sessionid);
        contentValues.put("last_update_time", Long.valueOf(trunk.lastupdttm));
        contentValues.put("last_comment_time", Long.valueOf(trunk.lastcmtdttm));
        contentValues.put("total_item_count", Integer.valueOf(trunk.totitemcnt));
        contentValues.put("unread_item_count", Integer.valueOf(trunk.unreaditemcnt));
        return ContentProviderOperation.newInsert(C1178f.f4044a.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m4235a(String str) {
        new ContentValues().put("session_id", str);
        return ContentProviderOperation.newDelete(C1178f.f4044a.buildUpon().appendPath(str).build()).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m4232a(TrunkItem trunkItem) {
        return m4233a(trunkItem, EnumC1177e.Item, false);
    }

    /* renamed from: a */
    public static ContentProviderOperation m4234a(TrunkItem trunkItem, boolean z) {
        return m4233a(trunkItem, EnumC1177e.Item, z);
    }

    /* renamed from: a */
    private static ContentProviderOperation m4233a(TrunkItem trunkItem, EnumC1177e enumC1177e, boolean z) {
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
        contentValues.put("item_type", Integer.valueOf(enumC1177e.m4254a()));
        contentValues.put("sender_uid", trunkItem.user.f4046id);
        contentValues.put("sender_name", trunkItem.user.orgname);
        contentValues.put("sender_number", trunkItem.user.orgnum);
        return ContentProviderOperation.newInsert(C1175c.f4038a.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).appendQueryParameter("withLoadMoreItem", String.valueOf(z)).build()).withValues(contentValues).build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m4239b(String str) {
        return m4236a(str, EnumC1177e.Item);
    }

    /* renamed from: a */
    private static ContentProviderOperation m4236a(String str, EnumC1177e enumC1177e) {
        return ContentProviderOperation.newDelete(C1175c.f4038a.buildUpon().appendPath(str).appendQueryParameter("effect", Boolean.TRUE.toString()).build()).withSelection("item_type=?", new String[]{String.valueOf(enumC1177e.m4254a())}).build();
    }

    /* renamed from: c */
    public static ContentProviderOperation m4240c(String str) {
        return ContentProviderOperation.newDelete(C1175c.f4038a.buildUpon().appendQueryParameter("rearrangeLoadMoreItem", Boolean.FALSE.toString()).build()).withSelection("session_id=?", new String[]{str}).build();
    }

    /* renamed from: d */
    public static ContentProviderOperation m4241d(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("dummy", "dummy");
        return ContentProviderOperation.newUpdate(C1175c.f4038a.buildUpon().appendPath("markAsRead").appendPath(str).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m4230a(Comment comment) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("comment_id", comment.cid);
        contentValues.put("item_id", comment.itemid);
        contentValues.put("registration_time", Long.valueOf(comment.regdttm));
        contentValues.put("writer_uid", comment.user.f4046id);
        contentValues.put("writer_name", comment.user.orgname);
        contentValues.put("writer_number", comment.user.orgnum);
        contentValues.put("content", comment.content);
        return ContentProviderOperation.newInsert(C1176d.f4039a.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).build()).withValues(contentValues).build();
    }

    /* renamed from: e */
    public static ContentProviderOperation m4242e(String str) {
        return ContentProviderOperation.newDelete(C1176d.f4039a.buildUpon().appendPath(str).appendQueryParameter("effect", Boolean.TRUE.toString()).build()).build();
    }

    /* renamed from: f */
    public static ContentProviderOperation m4243f(String str) {
        return ContentProviderOperation.newDelete(C1176d.f4039a).withSelection("item_id=?", new String[]{str}).build();
    }
}
