package com.sec.chaton.trunk.database.p062a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.sec.chaton.trunk.database.C3046b;
import com.sec.chaton.trunk.database.C3047c;
import com.sec.chaton.trunk.database.C3049e;
import com.sec.chaton.trunk.database.EnumC3048d;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.trunk.entry.inner.Trunk;
import com.sec.chaton.trunk.entry.inner.TrunkItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TrunkDatabaseHelper.java */
/* renamed from: com.sec.chaton.trunk.database.a.a */
/* loaded from: classes.dex */
public class C3044a {

    /* renamed from: a */
    private static final String f10941a = C3044a.class.getSimpleName();

    /* renamed from: a */
    public static ContentProviderResult[] m10565a(Context context, ArrayList<ContentProviderOperation> arrayList) {
        return context.getContentResolver().applyBatch("com.develop.sec.chaton.provider", arrayList);
    }

    /* renamed from: a */
    public static ContentProviderResult[] m10564a(Context context, ContentProviderOperation contentProviderOperation) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(contentProviderOperation);
        return context.getContentResolver().applyBatch("com.develop.sec.chaton.provider", arrayList);
    }

    /* renamed from: a */
    public static ContentProviderOperation m10556a(Trunk trunk) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("session_id", trunk.sessionid);
        contentValues.put("last_update_time", trunk.lastupdttm);
        contentValues.put("last_comment_time", trunk.lastcmtdttm);
        contentValues.put("total_item_count", trunk.totitemcnt);
        contentValues.put("unread_item_count", trunk.unreaditemcnt);
        return ContentProviderOperation.newInsert(C3049e.f10957a.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m10560a(String str) {
        new ContentValues().put("session_id", str);
        return ContentProviderOperation.newDelete(C3049e.f10957a.buildUpon().appendPath(str).build()).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m10557a(TrunkItem trunkItem) {
        return m10558a(trunkItem, EnumC3048d.Item, false);
    }

    /* renamed from: a */
    public static ContentProviderOperation m10559a(TrunkItem trunkItem, boolean z) {
        return m10558a(trunkItem, EnumC3048d.Item, z);
    }

    /* renamed from: a */
    private static ContentProviderOperation m10558a(TrunkItem trunkItem, EnumC3048d enumC3048d, boolean z) {
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
        contentValues.put("item_type", Integer.valueOf(enumC3048d.m10573a()));
        contentValues.put("sender_uid", trunkItem.user.f10961id);
        if (trunkItem.user.orgname != null) {
            contentValues.put("sender_name", trunkItem.user.orgname);
        } else {
            contentValues.put("sender_name", trunkItem.user.name);
        }
        contentValues.put("sender_number", trunkItem.user.orgnum);
        return ContentProviderOperation.newInsert(C3047c.f10952a.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).appendQueryParameter("withLoadMoreItem", String.valueOf(z)).build()).withValues(contentValues).build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m10566b(String str) {
        return m10561a(str, EnumC3048d.Item);
    }

    /* renamed from: a */
    public static ContentProviderOperation m10562a(List<String> list) {
        return m10563a(list, EnumC3048d.Item);
    }

    /* renamed from: a */
    private static ContentProviderOperation m10561a(String str, EnumC3048d enumC3048d) {
        return ContentProviderOperation.newDelete(C3047c.f10952a.buildUpon().appendPath(str).appendQueryParameter("effect", Boolean.TRUE.toString()).build()).withSelection("item_type=?", new String[]{String.valueOf(enumC3048d.m10573a())}).build();
    }

    /* renamed from: a */
    private static ContentProviderOperation m10563a(List<String> list, EnumC3048d enumC3048d) {
        Uri uriBuild = C3047c.f10952a.buildUpon().appendQueryParameter("effect", Boolean.TRUE.toString()).build();
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return ContentProviderOperation.newDelete(uriBuild).withSelection("item_type=? AND item_id in (" + sb.toString() + ")", new String[]{String.valueOf(enumC3048d.m10573a())}).build();
    }

    /* renamed from: c */
    public static ContentProviderOperation m10567c(String str) {
        return ContentProviderOperation.newDelete(C3047c.f10952a.buildUpon().appendQueryParameter("rearrangeLoadMoreItem", Boolean.FALSE.toString()).build()).withSelection("session_id=?", new String[]{str}).build();
    }

    /* renamed from: d */
    public static ContentProviderOperation m10568d(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("dummy", "dummy");
        return ContentProviderOperation.newUpdate(C3047c.f10952a.buildUpon().appendPath("markAsRead").appendPath(str).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m10555a(Comment comment) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("comment_id", comment.cid);
        contentValues.put("item_id", comment.itemid);
        contentValues.put("registration_time", comment.regdttm);
        contentValues.put("writer_uid", comment.user.f10961id);
        if (comment.user.orgname != null) {
            contentValues.put("writer_name", comment.user.orgname);
        } else {
            contentValues.put("writer_name", comment.user.name);
        }
        contentValues.put("writer_number", comment.user.orgnum);
        contentValues.put("content", comment.content);
        return ContentProviderOperation.newInsert(C3046b.f10951a.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).build()).withValues(contentValues).build();
    }

    /* renamed from: e */
    public static ContentProviderOperation m10569e(String str) {
        return ContentProviderOperation.newDelete(C3046b.f10951a.buildUpon().appendPath(str).appendQueryParameter("effect", Boolean.TRUE.toString()).build()).build();
    }

    /* renamed from: f */
    public static ContentProviderOperation m10570f(String str) {
        return ContentProviderOperation.newDelete(C3046b.f10951a).withSelection("item_id=?", new String[]{str}).build();
    }
}
