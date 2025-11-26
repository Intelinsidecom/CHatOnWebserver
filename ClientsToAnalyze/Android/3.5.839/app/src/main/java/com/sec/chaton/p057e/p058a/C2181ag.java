package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import com.sec.chaton.p057e.C2228ap;
import com.sec.chaton.p065io.entry.inner.Recommendee;
import com.sec.chaton.p065io.entry.inner.SpecialUser;

/* compiled from: RecommendDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.ag */
/* loaded from: classes.dex */
public class C2181ag {
    /* renamed from: a */
    public static ContentProviderOperation m9735a(int i) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2228ap.f7956a);
        builderNewDelete.withSelection("type=" + i, null);
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9738a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2228ap.f7956a);
        builderNewDelete.withSelection("buddy_no=? OR chatonid=? ", new String[]{str, str});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9736a(Recommendee recommendee) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2228ap.f7956a);
        builderNewInsert.withValue("buddy_no", recommendee.ruserid);
        builderNewInsert.withValue("buddy_name", recommendee.rname);
        builderNewInsert.withValue("type", 200);
        builderNewInsert.withValue("timestamp", Long.valueOf(recommendee.timestamp.longValue() / 1000));
        builderNewInsert.withValue("chatonid", recommendee.rchatonid);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9737a(SpecialUser specialUser) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2228ap.f7956a);
        builderNewInsert.withValue("buddy_no", specialUser.specialuserid);
        builderNewInsert.withValue("buddy_name", specialUser.name);
        builderNewInsert.withValue("type", 100);
        builderNewInsert.withValue("description", specialUser.description);
        builderNewInsert.withValue("followcount", specialUser.followcount);
        builderNewInsert.withValue("photoloaded", specialUser.photoloaded);
        builderNewInsert.withValue("msgstatus", specialUser.msgstatus);
        builderNewInsert.withValue("tel", specialUser.tel);
        builderNewInsert.withValue("likecount", specialUser.likecount);
        builderNewInsert.withValue("status", specialUser.status);
        builderNewInsert.withValue("url", specialUser.url);
        builderNewInsert.withValue("weburl", specialUser.weburl);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9739a(String str, String str2, Long l) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2228ap.f7956a);
        builderNewInsert.withValue("buddy_no", str);
        builderNewInsert.withValue("buddy_name", str2);
        builderNewInsert.withValue("type", 201);
        builderNewInsert.withValue("timestamp", Long.valueOf(l.longValue() / 1000));
        return builderNewInsert.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m9740b(String str, String str2, Long l) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2228ap.f7956a);
        builderNewInsert.withValue("buddy_no", str);
        builderNewInsert.withValue("buddy_name", str2);
        builderNewInsert.withValue("type", 202);
        builderNewInsert.withValue("timestamp", Long.valueOf(l.longValue() / 1000));
        return builderNewInsert.build();
    }

    /* renamed from: c */
    public static ContentProviderOperation m9741c(String str, String str2, Long l) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2228ap.f7956a);
        builderNewInsert.withValue("buddy_no", str);
        builderNewInsert.withValue("buddy_name", str2);
        builderNewInsert.withValue("type", 203);
        builderNewInsert.withValue("timestamp", Long.valueOf(l.longValue() / 1000));
        return builderNewInsert.build();
    }
}
