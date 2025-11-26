package com.sec.chaton.p015d.p016a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.C0702q;
import com.sec.chaton.p017e.C0704s;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetRecommendeeList;
import com.sec.chaton.p028io.entry.GetSpecialBuddyList;
import com.sec.chaton.p028io.entry.inner.Recommendee;
import com.sec.chaton.p028io.entry.inner.SpecialUser;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.Iterator;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: GetRecommendeeListTask.java */
/* renamed from: com.sec.chaton.d.a.aw */
/* loaded from: classes.dex */
public class C0555aw extends AbstractRunnableC0532a {

    /* renamed from: d */
    private boolean f2233d;

    public C0555aw(Handler handler, C0798h c0798h, boolean z) {
        super(handler, c0798h);
        this.f2233d = false;
        this.f2233d = z;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1786r.m6066e("beforeRequest", "GetRecommendeeListTask");
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) throws RemoteException, OperationApplicationException {
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (c0101b.m665b() == EnumC0803m.NO_CONTENT || c0101b.m665b() == EnumC0803m.SUCCESS) {
            }
            if (c0101b.m671d() != null) {
                if (!this.f2233d) {
                    GetRecommendeeList getRecommendeeList = (GetRecommendeeList) c0101b.m671d();
                    C1786r.m6063c("the number of recommendee from Server : " + getRecommendeeList.recommendee.size(), getClass().getSimpleName());
                    Iterator it = getRecommendeeList.recommendee.iterator();
                    while (it.hasNext()) {
                        arrayList.add(m2752a((Recommendee) it.next()));
                    }
                    GlobalApplication.m3260b().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                    return;
                }
                GetSpecialBuddyList getSpecialBuddyList = (GetSpecialBuddyList) c0101b.m671d();
                C1786r.m6063c("the number of specialbuddy from Server : " + getSpecialBuddyList.specialuser.size(), getClass().getSimpleName());
                for (SpecialUser specialUser : getSpecialBuddyList.specialuser) {
                    C1786r.m6066e("NO : " + specialUser.specialuserid + ", Name : " + specialUser.name, getClass().getSimpleName());
                    if (specialUser.specialuserid.startsWith("0999")) {
                        arrayList.add(m2755b(specialUser));
                    }
                }
                GlobalApplication.m3260b().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            }
        }
    }

    /* renamed from: a */
    private static ContentProviderOperation m2752a(Recommendee recommendee) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0702q.f2645a);
        builderNewInsert.withValue("buddy_no", recommendee.ruserid);
        builderNewInsert.withValue("buddy_name", recommendee.rname);
        builderNewInsert.withValue("type", Integer.valueOf(HttpResponseCode.f7897OK));
        return builderNewInsert.build();
    }

    /* renamed from: b */
    private static ContentProviderOperation m2755b(SpecialUser specialUser) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0702q.f2645a);
        builderNewInsert.withValue("buddy_no", specialUser.specialuserid);
        builderNewInsert.withValue("buddy_name", specialUser.name);
        builderNewInsert.withValue("type", 100);
        builderNewInsert.withValue("description", specialUser.description);
        builderNewInsert.withValue("followcount", specialUser.followcount);
        builderNewInsert.withValue("photoloaded", specialUser.photoloaded);
        builderNewInsert.withValue("likecount", specialUser.likecount);
        builderNewInsert.withValue("status", specialUser.status);
        builderNewInsert.withValue(RtspHeaders.Values.URL, specialUser.url);
        builderNewInsert.withValue("weburl", specialUser.weburl);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m2753a(SpecialUser specialUser) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0704s.f2647a);
        builderNewInsert.withValue("buddy_no", specialUser.specialuserid);
        builderNewInsert.withValue("buddy_name", specialUser.name);
        builderNewInsert.withValue("description", specialUser.description);
        builderNewInsert.withValue("followcount", specialUser.followcount);
        builderNewInsert.withValue("photoloaded", specialUser.photoloaded);
        builderNewInsert.withValue("likecount", specialUser.likecount);
        builderNewInsert.withValue("status", specialUser.status);
        builderNewInsert.withValue(RtspHeaders.Values.URL, specialUser.url);
        builderNewInsert.withValue("weburl", specialUser.weburl);
        builderNewInsert.withValue("isNew", "Y");
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m2754a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C0702q.f2645a);
        builderNewDelete.withSelection("buddy_no='" + str + "'", null);
        return builderNewDelete.build();
    }
}
