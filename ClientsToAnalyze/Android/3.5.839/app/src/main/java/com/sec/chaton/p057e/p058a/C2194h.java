package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import com.sec.chaton.p057e.C2291k;
import com.sec.chaton.p065io.entry.inner.CoverStorySample;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.File;

/* compiled from: CoverStorySampleDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.h */
/* loaded from: classes.dex */
public class C2194h {

    /* renamed from: a */
    public static final String f7834a = C2194h.class.getSimpleName();

    /* renamed from: a */
    public static ContentProviderOperation m9890a(CoverStorySample coverStorySample) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2291k.f8198a);
        if (C4904y.f17871a) {
            C4904y.m18646e("[insert db] CoverStory ID = " + coverStorySample.f8564id + "/  CoverStory thumbUrl = " + coverStorySample.thumbnailurl, f7834a);
        }
        String strM9891a = m9891a(coverStorySample.thumbnailurl);
        builderNewInsert.withValue("coverstory_id", coverStorySample.f8564id);
        builderNewInsert.withValue("coverstory_thumb_url", coverStorySample.thumbnailurl);
        builderNewInsert.withValue("coverstory_filename", strM9891a);
        return builderNewInsert.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m9892b(CoverStorySample coverStorySample) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2291k.f8198a);
        if (C4904y.f17871a) {
            C4904y.m18646e("[update db] CoverStory ID = " + coverStorySample.f8564id + "/  CoverStory thumbUrl = " + coverStorySample.thumbnailurl, f7834a);
        }
        String strM9891a = m9891a(coverStorySample.thumbnailurl);
        builderNewInsert.withValue("coverstory_id", coverStorySample.f8564id);
        builderNewInsert.withValue("coverstory_thumb_url", coverStorySample.thumbnailurl);
        builderNewInsert.withValue("coverstory_filename", strM9891a);
        return builderNewInsert.build();
    }

    /* renamed from: c */
    public static ContentProviderOperation m9894c(CoverStorySample coverStorySample) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2291k.f8198a);
        if (C4904y.f17871a) {
            C4904y.m18646e("[delete db] CoverStory ID = " + coverStorySample.f8564id, f7834a);
        }
        builderNewDelete.withSelection("coverstory_id = ?", new String[]{coverStorySample.f8564id});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static String m9891a(String str) {
        if (str != null && str.length() > 0) {
            String[] strArrSplit = str.split("/");
            String str2 = "";
            if (strArrSplit.length > 0) {
                str2 = strArrSplit[strArrSplit.length - 1];
                if (C4904y.f17871a) {
                    C4904y.m18646e("filestr: " + str2, f7834a);
                }
            }
            String[] strArrSplit2 = str2.split("\\?");
            if (strArrSplit2.length > 0) {
                String str3 = strArrSplit2[0];
                if (C4904y.f17871a) {
                    C4904y.m18646e("fileName: " + str3, f7834a);
                    return str3;
                }
                return str3;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static void m9893b(String str) {
        String[] list;
        String str2 = CommonApplication.m18732r().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        if (C4904y.f17872b) {
            C4904y.m18639b(" deleteSampleImage dirInternalPath : " + str2 + " Deleted sample Image ID : " + str, f7834a);
        }
        File file = new File(str2);
        if (file.exists() && (list = file.list()) != null) {
            for (String str3 : list) {
                if (str3.equalsIgnoreCase(str + ".jpg")) {
                    File file2 = new File(str2 + "/" + str + ".jpg");
                    C4904y.m18639b("deleteSampleImage filename : " + str3 + " @@ sampleId : " + str + ".jpg", f7834a);
                    if (file2.exists() && !file2.isDirectory()) {
                        file2.delete();
                        return;
                    }
                }
            }
        }
    }
}
