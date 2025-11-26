package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p057e.C2227ao;
import com.sec.chaton.p065io.entry.GetProfileImageList;
import com.sec.chaton.p065io.entry.inner.ProfileImage;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProfileImageDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.af */
/* loaded from: classes.dex */
public class C2180af {

    /* renamed from: a */
    public static final String f7821a = C2180af.class.getSimpleName();

    /* renamed from: a */
    public static ContentProviderOperation m9733a(ProfileImage profileImage) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2227ao.f7955a);
        builderNewInsert.withValue("profile_image_id", profileImage.profileimageid);
        builderNewInsert.withValue("profile_image_url", profileImage.profileimageurl);
        builderNewInsert.withValue("regdttm", profileImage.regdttm);
        builderNewInsert.withValue("represent", profileImage.represent);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9732a() {
        if (C4904y.f17871a) {
            C4904y.m18646e("[delete all db] profileimage", f7821a);
        }
        return ContentProviderOperation.newDelete(C2227ao.f7955a).build();
    }

    /* renamed from: a */
    public static void m9734a(GetProfileImageList getProfileImageList) {
        String str = "";
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(m9732a());
        Iterator<ProfileImage> it = getProfileImageList.profileimagelist.iterator();
        while (it.hasNext()) {
            ProfileImage next = it.next();
            if (C4904y.f17872b) {
                C4904y.m18639b("ProfileImage id : " + next.profileimageid + " / ProfileImage Url :" + next.profileimageurl, f7821a);
            }
            if (next.represent.equals(Spam.ACTIVITY_REPORT)) {
                str = next.profileimageid;
            }
            arrayList.add(m9733a(next));
        }
        try {
            CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        } catch (OperationApplicationException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f7821a);
            }
        } catch (RemoteException e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f7821a);
            }
        }
        if (!C4809aa.m18104a().m18121a("profile_small_image0", "").equals(str)) {
            C2496n.m10782c(CommonApplication.m18732r());
            C4809aa.m18108a("profile_small_image0", str);
        }
    }
}
