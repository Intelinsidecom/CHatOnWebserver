package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import com.sec.chaton.p027e.C1443k;
import com.sec.chaton.p035io.entry.inner.CoverStorySample;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.File;

/* compiled from: CoverStorySampleDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.h */
/* loaded from: classes.dex */
public class C1364h {

    /* renamed from: a */
    public static final String f5115a = C1364h.class.getSimpleName();

    /* renamed from: a */
    public static ContentProviderOperation m6085a(CoverStorySample coverStorySample) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1443k.f5371a);
        if (C3250y.f11733a) {
            C3250y.m11456e("[insert db] CoverStory ID = " + coverStorySample.f5642id + "/  CoverStory thumbUrl = " + coverStorySample.thumbnailurl, f5115a);
        }
        String strM6086a = m6086a(coverStorySample.thumbnailurl);
        builderNewInsert.withValue("coverstory_id", coverStorySample.f5642id);
        builderNewInsert.withValue("coverstory_thumb_url", coverStorySample.thumbnailurl);
        builderNewInsert.withValue("coverstory_filename", strM6086a);
        return builderNewInsert.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m6087b(CoverStorySample coverStorySample) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1443k.f5371a);
        if (C3250y.f11733a) {
            C3250y.m11456e("[update db] CoverStory ID = " + coverStorySample.f5642id + "/  CoverStory thumbUrl = " + coverStorySample.thumbnailurl, f5115a);
        }
        String strM6086a = m6086a(coverStorySample.thumbnailurl);
        builderNewInsert.withValue("coverstory_id", coverStorySample.f5642id);
        builderNewInsert.withValue("coverstory_thumb_url", coverStorySample.thumbnailurl);
        builderNewInsert.withValue("coverstory_filename", strM6086a);
        return builderNewInsert.build();
    }

    /* renamed from: c */
    public static ContentProviderOperation m6089c(CoverStorySample coverStorySample) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1443k.f5371a);
        if (C3250y.f11733a) {
            C3250y.m11456e("[delete db] CoverStory ID = " + coverStorySample.f5642id, f5115a);
        }
        builderNewDelete.withSelection("coverstory_id = ?", new String[]{coverStorySample.f5642id});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static String m6086a(String str) {
        if (str != null && str.length() > 0) {
            String[] strArrSplit = str.split("/");
            String str2 = "";
            if (strArrSplit.length > 0) {
                str2 = strArrSplit[strArrSplit.length - 1];
                if (C3250y.f11733a) {
                    C3250y.m11456e("filestr: " + str2, f5115a);
                }
            }
            String[] strArrSplit2 = str2.split("\\?");
            if (strArrSplit2.length > 0) {
                String str3 = strArrSplit2[0];
                if (C3250y.f11733a) {
                    C3250y.m11456e("fileName: " + str3, f5115a);
                    return str3;
                }
                return str3;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static void m6088b(String str) {
        String[] list;
        String str2 = CommonApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        if (C3250y.f11734b) {
            C3250y.m11450b(" deleteSampleImage dirInternalPath : " + str2 + " Deleted sample Image ID : " + str, f5115a);
        }
        File file = new File(str2);
        if (file.exists() && (list = file.list()) != null) {
            for (String str3 : list) {
                if (str3.equalsIgnoreCase(str + ".jpg")) {
                    File file2 = new File(str2 + "/" + str + ".jpg");
                    C3250y.m11450b("deleteSampleImage filename : " + str3 + " @@ sampleId : " + str + ".jpg", f5115a);
                    if (file2.exists() && !file2.isDirectory()) {
                        file2.delete();
                        return;
                    }
                }
            }
        }
    }
}
