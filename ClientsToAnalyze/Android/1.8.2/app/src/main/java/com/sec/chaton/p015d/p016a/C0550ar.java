package com.sec.chaton.p015d.p016a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.C0704s;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetSpecialBuddyList;
import com.sec.chaton.p028io.entry.inner.SpecialUser;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: GetFollowingSpecialBuddyTask.java */
/* renamed from: com.sec.chaton.d.a.ar */
/* loaded from: classes.dex */
public class C0550ar extends AbstractRunnableC0532a {
    public C0550ar(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1786r.m6066e("beforeRequest", "GetFollowingSpecialBuddyTask");
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) throws RemoteException, OperationApplicationException {
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if ((c0101b.m665b() == EnumC0803m.NO_CONTENT || c0101b.m665b() == EnumC0803m.SUCCESS) && c0101b.m671d() != null) {
                GetSpecialBuddyList getSpecialBuddyList = (GetSpecialBuddyList) c0101b.m671d();
                C1786r.m6063c("the number of specialbuddy from Server : " + getSpecialBuddyList.specialuser.size(), getClass().getSimpleName());
                for (SpecialUser specialUser : getSpecialBuddyList.specialuser) {
                    C1786r.m6066e("NO : " + specialUser.specialuserid + ", Name : " + specialUser.name, getClass().getSimpleName());
                    if (specialUser.specialuserid.startsWith("0999")) {
                        arrayList.add(m2749a(specialUser));
                    }
                }
                GlobalApplication.m3260b().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            }
        }
    }

    /* renamed from: a */
    private static ContentProviderOperation m2749a(SpecialUser specialUser) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0704s.f2647a);
        builderNewUpdate.withSelection("buddy_no='" + specialUser.specialuserid + "'", null);
        builderNewUpdate.withValue("buddy_name", specialUser.name);
        builderNewUpdate.withValue("msgstatus", specialUser.msgstatus);
        builderNewUpdate.withValue("description", specialUser.description);
        builderNewUpdate.withValue("photoloaded", specialUser.photoloaded);
        builderNewUpdate.withValue("status", specialUser.status);
        builderNewUpdate.withValue(RtspHeaders.Values.URL, specialUser.url);
        builderNewUpdate.withValue("weburl", specialUser.weburl);
        return builderNewUpdate.build();
    }
}
