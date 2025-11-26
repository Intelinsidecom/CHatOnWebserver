package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p027e.C1383aa;
import com.sec.chaton.p027e.C1384ab;
import com.sec.chaton.p027e.C1385ac;
import com.sec.chaton.p027e.C1386ad;
import com.sec.chaton.p027e.C1387ae;
import com.sec.chaton.p027e.C1458z;
import com.sec.chaton.p035io.entry.inner.PostONComment;
import com.sec.chaton.p035io.entry.inner.PostONEntry;
import com.sec.chaton.p035io.entry.inner.PostONMultimediaEntry;
import com.sec.chaton.p035io.entry.inner.PostONMultimediaList;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PostONDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.z */
/* loaded from: classes.dex */
public class C1382z {

    /* renamed from: a */
    private static Uri f5165a = C1386ad.f5182a;

    /* renamed from: b */
    private static Uri f5166b = C1383aa.f5176a;

    /* renamed from: c */
    private static Uri f5167c = C1384ab.f5178a;

    /* renamed from: d */
    private static Uri f5168d = C1387ae.f5185b;

    /* renamed from: e */
    private static Uri f5169e = C1386ad.f5183b;

    /* renamed from: f */
    private static Uri f5170f = C1383aa.f5177b;

    /* renamed from: g */
    private static Uri f5171g = C1384ab.f5179b;

    /* renamed from: h */
    private static Uri f5172h = C1385ac.f5180a;

    /* renamed from: i */
    private static Uri f5173i = C1458z.f5416a;

    /* renamed from: j */
    private static Uri f5174j = C1385ac.f5181b;

    /* renamed from: k */
    private static Uri f5175k = C1458z.f5417b;

    /* renamed from: a */
    public static Cursor m6231a(ContentResolver contentResolver) {
        ContentResolver contentResolver2 = CommonApplication.m11493l().getContentResolver();
        C3250y.m11456e("postonJoinedBuddyUri_me: " + f5169e, "PostONDatabaseHelper");
        return contentResolver2.query(f5169e, null, null, null, null);
    }

    /* renamed from: b */
    public static Cursor m6237b(ContentResolver contentResolver) {
        ContentResolver contentResolver2 = CommonApplication.m11493l().getContentResolver();
        C3250y.m11456e("postonJoinedBuddyUri_buddy: " + f5170f, "PostONDatabaseHelper");
        return contentResolver2.query(f5170f, null, null, null, null);
    }

    /* renamed from: a */
    public static ContentProviderOperation m6228a() {
        return ContentProviderOperation.newDelete(f5165a).build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m6235b() {
        return ContentProviderOperation.newDelete(f5166b).build();
    }

    /* renamed from: c */
    public static ContentProviderOperation m6239c() {
        return ContentProviderOperation.newDelete(f5172h).build();
    }

    /* renamed from: d */
    public static ContentProviderOperation m6241d() {
        return ContentProviderOperation.newDelete(f5173i).build();
    }

    /* renamed from: a */
    public static ArrayList<ContentProviderOperation> m6232a(PostONEntry postONEntry) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(f5165a);
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        JSONArray jSONArray = new JSONArray();
        builderNewInsert.withValue("buddy_no", postONEntry.sender);
        builderNewInsert.withValue("buddy_name", postONEntry.sendername);
        builderNewInsert.withValue("image_status", postONEntry.imgstatus);
        builderNewInsert.withValue("poston_id", postONEntry.postonid);
        builderNewInsert.withValue("timestamp", postONEntry.regdttm);
        builderNewInsert.withValue("isread", postONEntry.read_msec);
        builderNewInsert.withValue("read_comment_count", postONEntry.commentreadcount);
        builderNewInsert.withValue("unread_comment_count", postONEntry.commentunreadcount);
        builderNewInsert.withValue("unread_mood_count", postONEntry.unreadmoodcount);
        builderNewInsert.withValue("total_mood_count", postONEntry.totalmoodcount);
        builderNewInsert.withValue("poston", postONEntry.postonmessage);
        builderNewInsert.withValue("multimedia_list", m6234a(postONEntry.multimedialist, postONEntry.postonid, jSONArray, arrayList, true).toString());
        C3250y.m11456e("KEY_BUDDY_NO = " + postONEntry.sender + "/KEY_BUDDY_NAME = " + postONEntry.sendername + "/KEY_IMAGE_STATUS = " + postONEntry.imgstatus + "/KEY_POSTON" + postONEntry.postonmessage, "getPostON");
        arrayList.add(builderNewInsert.build());
        return arrayList;
    }

    /* renamed from: b */
    public static ArrayList<ContentProviderOperation> m6238b(PostONEntry postONEntry) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(f5166b);
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        JSONArray jSONArray = new JSONArray();
        builderNewInsert.withValue("buddy_no", postONEntry.sender);
        builderNewInsert.withValue("buddy_name", postONEntry.sendername);
        builderNewInsert.withValue("image_status", postONEntry.imgstatus);
        builderNewInsert.withValue("poston_id", postONEntry.postonid);
        builderNewInsert.withValue("timestamp", postONEntry.regdttm);
        builderNewInsert.withValue("isread", postONEntry.read_msec);
        builderNewInsert.withValue("read_comment_count", postONEntry.commentreadcount);
        builderNewInsert.withValue("unread_comment_count", postONEntry.commentunreadcount);
        builderNewInsert.withValue("unread_mood_count", postONEntry.unreadmoodcount);
        builderNewInsert.withValue("total_mood_count", postONEntry.totalmoodcount);
        builderNewInsert.withValue("poston", postONEntry.postonmessage);
        builderNewInsert.withValue("multimedia_list", m6234a(postONEntry.multimedialist, postONEntry.postonid, jSONArray, arrayList, false).toString());
        C3250y.m11456e("KEY_BUDDY_NO = " + postONEntry.sender + "/KEY_BUDDY_NAME = " + postONEntry.sendername + "/KEY_IMAGE_STATUS = " + postONEntry.imgstatus + "/KEY_POSTON" + postONEntry.postonmessage, "getPostON");
        arrayList.add(builderNewInsert.build());
        return arrayList;
    }

    /* renamed from: a */
    public static ContentProviderOperation m6230a(PostONMultimediaEntry postONMultimediaEntry, String str) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(f5172h);
        builderNewInsert.withValue("poston_no", str);
        builderNewInsert.withValue("poston_metaid", postONMultimediaEntry.metaid);
        builderNewInsert.withValue("poston_metatype", postONMultimediaEntry.metatype);
        if ("3".equals(postONMultimediaEntry.metatype)) {
            builderNewInsert.withValue("poston_url", postONMultimediaEntry.metacontents);
        } else {
            builderNewInsert.withValue("poston_url", postONMultimediaEntry.host + postONMultimediaEntry.metacontents);
        }
        builderNewInsert.withValue("poston_seq", postONMultimediaEntry.sequence);
        return builderNewInsert.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m6236b(PostONMultimediaEntry postONMultimediaEntry, String str) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(f5173i);
        builderNewInsert.withValue("poston_no", str);
        builderNewInsert.withValue("poston_metaid", postONMultimediaEntry.metaid);
        builderNewInsert.withValue("poston_metatype", postONMultimediaEntry.metatype);
        if ("3".equals(postONMultimediaEntry.metatype)) {
            builderNewInsert.withValue("poston_url", postONMultimediaEntry.metacontents);
        } else {
            builderNewInsert.withValue("poston_url", postONMultimediaEntry.host + postONMultimediaEntry.metacontents);
        }
        builderNewInsert.withValue("poston_seq", postONMultimediaEntry.sequence);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    private static JSONArray m6234a(ArrayList<PostONMultimediaList> arrayList, String str, JSONArray jSONArray, ArrayList<ContentProviderOperation> arrayList2, boolean z) throws JSONException {
        for (int i = 0; i < arrayList.size(); i++) {
            ArrayList<PostONMultimediaEntry> arrayList3 = arrayList.get(i).multimedia;
            for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("metaID", arrayList3.get(i2).metaid);
                jSONObject.put("metaType", arrayList3.get(i2).metatype);
                if ("3".equals(arrayList3.get(i2).metatype)) {
                    jSONObject.put("url", arrayList3.get(i2).metacontents);
                } else {
                    jSONObject.put("url", arrayList3.get(i2).host + arrayList3.get(i2).metacontents);
                }
                jSONObject.put("sequence", arrayList3.get(i2).sequence);
                jSONArray.put(i2, jSONObject);
                C3250y.m11456e("JSon Encode: metaID= " + arrayList3.get(i2).metaid + " /metaType= " + arrayList3.get(i2).metatype + " /url=" + arrayList3.get(i2).host + arrayList3.get(i2).metacontents + " /sequence" + arrayList3.get(i2).sequence, "encodeMultimedia");
                if (z) {
                    arrayList2.add(m6230a(arrayList3.get(i2), str));
                } else {
                    arrayList2.add(m6236b(arrayList3.get(i2), str));
                }
            }
        }
        C3250y.m11456e("JSonArray: " + jSONArray.toString(), "encodeMultimedia");
        return jSONArray;
    }

    /* renamed from: a */
    public static ArrayList<C1352aa> m6233a(String str) {
        ArrayList<C1352aa> arrayList = new ArrayList<>();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = new JSONObject(jSONArray.getString(i));
            C1352aa c1352aa = new C1352aa();
            c1352aa.m5958a(jSONObject.getString("metaID"));
            c1352aa.m5960b(jSONObject.getString("metaType"));
            c1352aa.m5961c(jSONObject.getString("url"));
            c1352aa.m5962d(jSONObject.getString("sequence"));
            C3250y.m11456e("JSon Decode: metaID= " + c1352aa.f5089a + " /metaType= " + c1352aa.f5090b + " /url=" + c1352aa.f5091c + " /sequence" + c1352aa.f5092d, "encodeMultimedia");
            arrayList.add(c1352aa);
        }
        return arrayList;
    }

    /* renamed from: c */
    public static Cursor m6240c(ContentResolver contentResolver) {
        return CommonApplication.m11493l().getContentResolver().query(f5171g, null, null, null, "timestamp asc");
    }

    /* renamed from: e */
    public static ContentProviderOperation m6242e() {
        return ContentProviderOperation.newDelete(f5167c).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6229a(PostONComment postONComment) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(f5167c);
        builderNewInsert.withValue("buddy_no", postONComment.sender);
        builderNewInsert.withValue("buddy_name", postONComment.sendername);
        builderNewInsert.withValue("timestamp", postONComment.regdttm);
        builderNewInsert.withValue("comment", postONComment.value);
        builderNewInsert.withValue("isread", postONComment.read_msec);
        builderNewInsert.withValue("commentid", postONComment.commentid);
        return builderNewInsert.build();
    }
}
