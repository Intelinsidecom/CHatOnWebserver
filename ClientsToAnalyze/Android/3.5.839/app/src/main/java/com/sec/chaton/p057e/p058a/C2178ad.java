package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p057e.C2221ai;
import com.sec.chaton.p057e.C2222aj;
import com.sec.chaton.p057e.C2223ak;
import com.sec.chaton.p057e.C2224al;
import com.sec.chaton.p057e.C2225am;
import com.sec.chaton.p057e.C2226an;
import com.sec.chaton.p065io.entry.inner.PostONComment;
import com.sec.chaton.p065io.entry.inner.PostONDetailEntry;
import com.sec.chaton.p065io.entry.inner.PostONEntry;
import com.sec.chaton.p065io.entry.inner.PostONMultimediaEntry;
import com.sec.chaton.p065io.entry.inner.PostONMultimediaList;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PostONDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.ad */
/* loaded from: classes.dex */
public class C2178ad {

    /* renamed from: a */
    private static Uri f7806a = C2225am.f7951a;

    /* renamed from: b */
    private static Uri f7807b = C2222aj.f7945a;

    /* renamed from: c */
    private static Uri f7808c = C2223ak.f7947a;

    /* renamed from: d */
    private static Uri f7809d = C2226an.f7954b;

    /* renamed from: e */
    private static Uri f7810e = C2225am.f7952b;

    /* renamed from: f */
    private static Uri f7811f = C2222aj.f7946b;

    /* renamed from: g */
    private static Uri f7812g = C2223ak.f7948b;

    /* renamed from: h */
    private static Uri f7813h = C2224al.f7949a;

    /* renamed from: i */
    private static Uri f7814i = C2221ai.f7943a;

    /* renamed from: j */
    private static Uri f7815j = C2224al.f7950b;

    /* renamed from: k */
    private static Uri f7816k = C2221ai.f7944b;

    /* renamed from: a */
    public static Cursor m9711a(ContentResolver contentResolver) {
        ContentResolver contentResolver2 = CommonApplication.m18732r().getContentResolver();
        C4904y.m18646e("postonJoinedBuddyUri_buddy: " + f7811f, "PostONDatabaseHelper");
        return contentResolver2.query(f7811f, null, null, null, null);
    }

    /* renamed from: a */
    public static ContentProviderOperation m9708a() {
        return ContentProviderOperation.newDelete(f7806a).build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m9716b() {
        return ContentProviderOperation.newDelete(f7807b).build();
    }

    /* renamed from: c */
    public static ContentProviderOperation m9719c() {
        return ContentProviderOperation.newDelete(f7813h).build();
    }

    /* renamed from: d */
    public static ContentProviderOperation m9720d() {
        return ContentProviderOperation.newDelete(f7814i).build();
    }

    /* renamed from: a */
    public static ArrayList<ContentProviderOperation> m9712a(PostONDetailEntry postONDetailEntry) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C4821am.m18188a(f7806a));
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        JSONArray jSONArray = new JSONArray();
        builderNewInsert.withValue("buddy_no", postONDetailEntry.sender);
        builderNewInsert.withValue("buddy_name", postONDetailEntry.sendername);
        builderNewInsert.withValue("image_status", postONDetailEntry.imgstatus);
        builderNewInsert.withValue("poston_id", postONDetailEntry.postonid);
        builderNewInsert.withValue("timestamp", postONDetailEntry.regdttm);
        builderNewInsert.withValue("isread", postONDetailEntry.read_msec);
        builderNewInsert.withValue("read_comment_count", postONDetailEntry.commentreadcount);
        builderNewInsert.withValue("unread_comment_count", postONDetailEntry.commentunreadcount);
        builderNewInsert.withValue("unread_mood_count", postONDetailEntry.unreadmoodcount);
        builderNewInsert.withValue("total_mood_count", postONDetailEntry.totalmoodcount);
        builderNewInsert.withValue("poston", postONDetailEntry.postonmessage);
        builderNewInsert.withValue("order_msec", postONDetailEntry.order_msec);
        builderNewInsert.withValue("multimedia_list", m9715a(postONDetailEntry.multimedialist, postONDetailEntry.postonid, jSONArray, arrayList, true).toString());
        if (C4904y.f17871a) {
            C4904y.m18646e("KEY_BUDDY_NO = " + postONDetailEntry.sender + "/KEY_BUDDY_NAME = " + postONDetailEntry.sendername + "/KEY_IMAGE_STATUS = " + postONDetailEntry.imgstatus + "/KEY_POSTON" + postONDetailEntry.postonmessage, "getPostON");
        }
        arrayList.add(builderNewInsert.build());
        return arrayList;
    }

    /* renamed from: a */
    public static ArrayList<ContentProviderOperation> m9713a(PostONEntry postONEntry) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C4821am.m18188a(f7806a));
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
        builderNewInsert.withValue("order_msec", postONEntry.order_msec);
        builderNewInsert.withValue("multimedia_list", m9715a(postONEntry.multimedialist, postONEntry.postonid, jSONArray, arrayList, true).toString());
        if (C4904y.f17871a) {
            C4904y.m18646e("KEY_BUDDY_NO = " + postONEntry.sender + "/KEY_BUDDY_NAME = " + postONEntry.sendername + "/KEY_IMAGE_STATUS = " + postONEntry.imgstatus + "/KEY_POSTON" + postONEntry.postonmessage, "getPostON");
        }
        arrayList.add(builderNewInsert.build());
        return arrayList;
    }

    /* renamed from: b */
    public static ArrayList<ContentProviderOperation> m9718b(PostONEntry postONEntry) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(f7807b);
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
        builderNewInsert.withValue("multimedia_list", m9715a(postONEntry.multimedialist, postONEntry.postonid, jSONArray, arrayList, false).toString());
        if (C4904y.f17871a) {
            C4904y.m18646e("KEY_BUDDY_NO = " + postONEntry.sender + "/KEY_BUDDY_NAME = " + postONEntry.sendername + "/KEY_IMAGE_STATUS = " + postONEntry.imgstatus + "/KEY_POSTON" + postONEntry.postonmessage, "getPostON");
        }
        arrayList.add(builderNewInsert.build());
        return arrayList;
    }

    /* renamed from: a */
    public static ContentProviderOperation m9710a(PostONMultimediaEntry postONMultimediaEntry, String str) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C4821am.m18188a(f7813h));
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
    public static ContentProviderOperation m9717b(PostONMultimediaEntry postONMultimediaEntry, String str) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(f7814i);
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
    private static JSONArray m9715a(PostONMultimediaList postONMultimediaList, String str, JSONArray jSONArray, ArrayList<ContentProviderOperation> arrayList, boolean z) throws JSONException {
        ArrayList<PostONMultimediaEntry> arrayList2 = postONMultimediaList.multimedia;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList2.size()) {
                break;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("metaID", arrayList2.get(i2).metaid);
            jSONObject.put("metaType", arrayList2.get(i2).metatype);
            if ("3".equals(arrayList2.get(i2).metatype)) {
                jSONObject.put("url", arrayList2.get(i2).metacontents);
            } else {
                jSONObject.put("url", arrayList2.get(i2).host + arrayList2.get(i2).metacontents);
            }
            jSONObject.put("sequence", arrayList2.get(i2).sequence);
            jSONArray.put(i2, jSONObject);
            C4904y.m18646e("JSon Encode: metaID= " + arrayList2.get(i2).metaid + " /metaType= " + arrayList2.get(i2).metatype + " /url=" + arrayList2.get(i2).host + arrayList2.get(i2).metacontents + " /sequence" + arrayList2.get(i2).sequence, "encodeMultimedia");
            if (z) {
                arrayList.add(m9710a(arrayList2.get(i2), str));
            } else {
                arrayList.add(m9717b(arrayList2.get(i2), str));
            }
            i = i2 + 1;
        }
        if (C4904y.f17871a) {
            C4904y.m18646e("JSonArray: " + jSONArray.toString(), "encodeMultimedia");
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static ArrayList<C2179ae> m9714a(String str) {
        ArrayList<C2179ae> arrayList = new ArrayList<>();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = new JSONObject(jSONArray.getString(i));
            C2179ae c2179ae = new C2179ae();
            c2179ae.m9727a(jSONObject.getString("metaID"));
            c2179ae.m9729b(jSONObject.getString("metaType"));
            c2179ae.m9730c(jSONObject.getString("url"));
            c2179ae.m9731d(jSONObject.getString("sequence"));
            if (C4904y.f17871a) {
                C4904y.m18646e("JSon Decode: metaID= " + c2179ae.f7817a + " /metaType= " + c2179ae.f7818b + " /url=" + c2179ae.f7819c + " /sequence" + c2179ae.f7820d, "encodeMultimedia");
            }
            arrayList.add(c2179ae);
        }
        return arrayList;
    }

    /* renamed from: e */
    public static ContentProviderOperation m9721e() {
        return ContentProviderOperation.newDelete(f7808c).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9709a(PostONComment postONComment) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(f7808c);
        builderNewInsert.withValue("buddy_no", postONComment.sender);
        builderNewInsert.withValue("buddy_name", postONComment.sendername);
        builderNewInsert.withValue("timestamp", postONComment.regdttm);
        builderNewInsert.withValue("comment", postONComment.value);
        builderNewInsert.withValue("isread", postONComment.read_msec);
        builderNewInsert.withValue("commentid", postONComment.commentid);
        return builderNewInsert.build();
    }
}
