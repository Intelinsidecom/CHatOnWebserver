package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p027e.C1390ah;
import com.sec.chaton.p035io.entry.GetRecommendeeList;
import com.sec.chaton.p035io.entry.GetSpecialUserList;
import com.sec.chaton.p035io.entry.inner.Recommendee;
import com.sec.chaton.p035io.entry.inner.SpecialUser;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: GetRecommendeeListTask.java */
/* renamed from: com.sec.chaton.d.a.cg */
/* loaded from: classes.dex */
public class C1206cg extends AbstractC1145a {

    /* renamed from: b */
    private boolean f4712b;

    public C1206cg(Handler handler, C1580h c1580h, boolean z) {
        super(handler, c1580h);
        this.f4712b = false;
        this.f4712b = z;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3250y.m11456e("beforeRequest", "GetRecommendeeListTask");
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                if (this.f4712b) {
                    arrayList.add(m5541a(100));
                } else {
                    arrayList.add(m5541a(HttpResponseCode.f13733OK));
                }
            }
            if (c0267d.m1351b() == EnumC1587o.SUCCESS && c0267d.m1354e() != null) {
                if (this.f4712b) {
                    GetSpecialUserList getSpecialUserList = (GetSpecialUserList) c0267d.m1354e();
                    C3250y.m11453c("the number of specialbuddy from Server : " + getSpecialUserList.specialuser.size(), getClass().getSimpleName());
                    arrayList.add(m5541a(100));
                    for (SpecialUser specialUser : getSpecialUserList.specialuser) {
                        C3250y.m11456e("NO : " + specialUser.specialuserid + ", Name : " + specialUser.name, getClass().getSimpleName());
                        if (specialUser.specialuserid.startsWith("0999")) {
                            arrayList.add(m5545b(specialUser));
                        }
                    }
                } else {
                    GetRecommendeeList getRecommendeeList = (GetRecommendeeList) c0267d.m1354e();
                    C3250y.m11453c("the number of recommendee from Server : " + getRecommendeeList.recommendee.size(), getClass().getSimpleName());
                    arrayList.add(m5541a(HttpResponseCode.f13733OK));
                    Iterator<Recommendee> it = getRecommendeeList.recommendee.iterator();
                    while (it.hasNext()) {
                        Recommendee next = it.next();
                        C3250y.m11456e("NO : " + next.ruserid + ", Name : " + next.rname, getClass().getSimpleName());
                        arrayList.add(m5542a(next));
                        C3205bt.m11182a(CommonApplication.m11493l()).m11227b(next.ruserid);
                    }
                }
            }
            CommonApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        }
    }

    /* renamed from: a */
    private static ContentProviderOperation m5542a(Recommendee recommendee) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1388af.f5186a);
        builderNewInsert.withValue("buddy_no", recommendee.ruserid);
        builderNewInsert.withValue("buddy_name", recommendee.rname);
        builderNewInsert.withValue(PrefFragmentChats.TYPE, Integer.valueOf(HttpResponseCode.f13733OK));
        builderNewInsert.withValue("timestamp", Long.valueOf(recommendee.timestamp.longValue() / 1000));
        builderNewInsert.withValue("chatonid", recommendee.rchatonid);
        return builderNewInsert.build();
    }

    /* renamed from: b */
    private static ContentProviderOperation m5545b(SpecialUser specialUser) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1388af.f5186a);
        builderNewInsert.withValue("buddy_no", specialUser.specialuserid);
        builderNewInsert.withValue("buddy_name", specialUser.name);
        builderNewInsert.withValue(PrefFragmentChats.TYPE, 100);
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
    public static ContentProviderOperation m5543a(SpecialUser specialUser) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1390ah.f5188a);
        if (specialUser.likecount == null && TextUtils.isEmpty(specialUser.likecount)) {
            specialUser.likecount = "0";
        }
        if (specialUser.followcount == null && TextUtils.isEmpty(specialUser.followcount)) {
            specialUser.followcount = "0";
        }
        builderNewInsert.withValue("buddy_no", specialUser.specialuserid);
        builderNewInsert.withValue("buddy_name", specialUser.name);
        builderNewInsert.withValue("description", specialUser.description);
        builderNewInsert.withValue("followcount", specialUser.followcount);
        builderNewInsert.withValue("photoloaded", specialUser.photoloaded);
        builderNewInsert.withValue("likecount", specialUser.likecount);
        builderNewInsert.withValue("status", specialUser.status);
        builderNewInsert.withValue("url", specialUser.url);
        builderNewInsert.withValue("weburl", specialUser.weburl);
        builderNewInsert.withValue("tel", specialUser.tel);
        builderNewInsert.withValue("msgstatus", specialUser.msgstatus);
        builderNewInsert.withValue("isNew", "Y");
        return builderNewInsert.build();
    }

    /* renamed from: a */
    private static ContentProviderOperation m5541a(int i) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1388af.f5186a);
        builderNewDelete.withSelection("type=" + i, null);
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m5544a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1388af.f5186a);
        builderNewDelete.withSelection("buddy_no=? OR chatonid=? ", new String[]{str, str});
        return builderNewDelete.build();
    }
}
