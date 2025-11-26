package com.sec.chaton.trunk.database.p122a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.sec.chaton.trunk.database.C4666b;
import com.sec.chaton.trunk.database.C4667c;
import com.sec.chaton.trunk.database.C4669e;
import com.sec.chaton.trunk.database.EnumC4668d;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.trunk.entry.inner.Trunk;
import com.sec.chaton.trunk.entry.inner.TrunkItem;
import com.sec.chaton.trunk.entry.inner.TrunkItemComment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TrunkDatabaseHelper.java */
/* renamed from: com.sec.chaton.trunk.database.a.a */
/* loaded from: classes.dex */
public class C4664a {

    /* renamed from: a */
    private static final String f16890a = C4664a.class.getSimpleName();

    /* renamed from: a */
    public static ContentProviderResult[] m17660a(Context context, ArrayList<ContentProviderOperation> arrayList) {
        return context.getContentResolver().applyBatch("com.develop.sec.chaton.provider", arrayList);
    }

    /* renamed from: a */
    public static ContentProviderResult[] m17659a(Context context, ContentProviderOperation contentProviderOperation) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(contentProviderOperation);
        return context.getContentResolver().applyBatch("com.develop.sec.chaton.provider", arrayList);
    }

    /* renamed from: a */
    public static ContentProviderOperation m17650a(Trunk trunk) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("session_id", trunk.sessionid);
        contentValues.put("last_update_time", trunk.lastupdttm);
        contentValues.put("last_comment_time", trunk.lastcmtdttm);
        contentValues.put("total_item_count", trunk.totitemcnt);
        contentValues.put("unread_item_count", trunk.unreaditemcnt);
        return ContentProviderOperation.newInsert(C4669e.f16906a.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m17655a(String str) {
        new ContentValues().put("session_id", str);
        return ContentProviderOperation.newDelete(C4669e.f16906a.buildUpon().appendPath(str).build()).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m17651a(TrunkItem trunkItem) {
        return m17652a(trunkItem, EnumC4668d.Item, false);
    }

    /* renamed from: a */
    public static ContentProviderOperation m17653a(TrunkItem trunkItem, boolean z) {
        return m17652a(trunkItem, EnumC4668d.Item, z);
    }

    /* renamed from: a */
    private static ContentProviderOperation m17652a(TrunkItem trunkItem, EnumC4668d enumC4668d, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("session_id", trunkItem.sessionid);
        contentValues.put("item_id", trunkItem.itemid);
        contentValues.put("total_comment_count", trunkItem.totcmtcnt);
        contentValues.put("unread_comment_count", trunkItem.unreadcmtcnt);
        contentValues.put("last_comment_time", trunkItem.lastcmtdttm);
        contentValues.put("registration_time", trunkItem.regdttm);
        contentValues.put("item_description", trunkItem.description);
        contentValues.put("content_type", trunkItem.file.contenttype);
        contentValues.put("isams", trunkItem.file.isams);
        contentValues.put("thumbnail", trunkItem.file.thumburl);
        contentValues.put("down_url", trunkItem.file.downurl);
        contentValues.put("item_type", Integer.valueOf(enumC4668d.m17667a()));
        contentValues.put("sender_uid", trunkItem.user.f16910id);
        if (trunkItem.user.orgname != null) {
            contentValues.put("sender_name", trunkItem.user.orgname);
        } else {
            contentValues.put("sender_name", trunkItem.user.name);
        }
        contentValues.put("sender_number", trunkItem.user.orgnum);
        return ContentProviderOperation.newInsert(C4667c.f16901a.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).appendQueryParameter("withLoadMoreItem", String.valueOf(z)).build()).withValues(contentValues).build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m17661b(String str) {
        return m17656a(str, EnumC4668d.Item);
    }

    /* renamed from: a */
    public static ContentProviderOperation m17657a(List<String> list) {
        return m17658a(list, EnumC4668d.Item);
    }

    /* renamed from: a */
    private static ContentProviderOperation m17656a(String str, EnumC4668d enumC4668d) {
        return ContentProviderOperation.newDelete(C4667c.f16901a.buildUpon().appendPath(str).appendQueryParameter("effect", Boolean.TRUE.toString()).build()).withSelection("item_type=?", new String[]{String.valueOf(enumC4668d.m17667a())}).build();
    }

    /* renamed from: a */
    private static ContentProviderOperation m17658a(List<String> list, EnumC4668d enumC4668d) {
        Uri uriBuild = C4667c.f16901a.buildUpon().appendQueryParameter("effect", Boolean.TRUE.toString()).build();
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return ContentProviderOperation.newDelete(uriBuild).withSelection("item_type=? AND item_id in (" + sb.toString() + ")", new String[]{String.valueOf(enumC4668d.m17667a())}).build();
    }

    /* renamed from: c */
    public static ContentProviderOperation m17662c(String str) {
        return ContentProviderOperation.newDelete(C4667c.f16901a.buildUpon().appendQueryParameter("rearrangeLoadMoreItem", Boolean.FALSE.toString()).build()).withSelection("session_id=?", new String[]{str}).build();
    }

    /* renamed from: d */
    public static ContentProviderOperation m17663d(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("dummy", "dummy");
        return ContentProviderOperation.newUpdate(C4667c.f16901a.buildUpon().appendPath("markAsRead").appendPath(str).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m17649a(Comment comment) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("comment_id", comment.cid);
        contentValues.put("item_id", comment.itemid);
        contentValues.put("registration_time", comment.regdttm);
        contentValues.put("writer_uid", comment.user.f16910id);
        if (comment.user.orgname != null) {
            contentValues.put("writer_name", comment.user.orgname);
        } else {
            contentValues.put("writer_name", comment.user.name);
        }
        contentValues.put("writer_number", comment.user.orgnum);
        contentValues.put("content", comment.content);
        return ContentProviderOperation.newInsert(C4666b.f16900a.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m17654a(TrunkItemComment trunkItemComment) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", trunkItemComment.itemid);
        contentValues.put("total_comment_count", trunkItemComment.totcmtcnt);
        contentValues.put("last_comment_time", trunkItemComment.lastcmtdttm);
        return ContentProviderOperation.newInsert(C4667c.f16901a.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).appendQueryParameter("withLoadMoreItem", String.valueOf(false)).build()).withValues(contentValues).build();
    }

    /* renamed from: e */
    public static ContentProviderOperation m17664e(String str) {
        return ContentProviderOperation.newDelete(C4666b.f16900a).withSelection("item_id=?", new String[]{str}).build();
    }
}
