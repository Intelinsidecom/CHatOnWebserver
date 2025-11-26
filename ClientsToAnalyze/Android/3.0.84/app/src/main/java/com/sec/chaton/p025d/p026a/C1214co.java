package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.inner.BuddyProfile;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: GetUserProfileAllTask.java */
/* renamed from: com.sec.chaton.d.a.co */
/* loaded from: classes.dex */
public class C1214co extends AbstractC1145a {

    /* renamed from: b */
    private boolean f4719b;

    /* renamed from: c */
    private String f4720c;

    public C1214co(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4719b = false;
        this.f4720c = null;
        this.f4720c = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3250y.m11456e("beforeRequest", "GetUserProfileAllTask");
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        if (c0267d.m11704n() && c0267d.m1354e() != null) {
            BuddyProfile buddyProfile = (BuddyProfile) c0267d.m1354e();
            if (this.f4720c != null) {
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                C3250y.m11456e("Name : " + buddyProfile.name + ", Status : " + buddyProfile.status + ", Birthday : " + buddyProfile.birthday + ", Email : " + buddyProfile.email + ", Imgstatus : " + buddyProfile.imgstatus, "GetUserProfileAllTask");
                if (!this.f4720c.startsWith("0999")) {
                    arrayList.add(C1360d.m6021a(this.f4720c, buddyProfile));
                }
                if (buddyProfile.getImagestatus() != BuddyProfile.BuddyImageStatus.NOT_CHANGE) {
                    C3205bt.m11182a(CommonApplication.m11493l()).m11227b(this.f4720c);
                }
                CommonApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                C3250y.m11453c("buddy " + buddyProfile.name + " written in db.", "GetUserProfileAllTask");
                return;
            }
            C3159aa.m10962a().m10986b("Push Name", buddyProfile.name);
            C3159aa.m10962a().m10986b("status_message", buddyProfile.status);
            C3159aa.m10962a().m10986b("birthday_server", buddyProfile.birthday);
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000004", "0002", c0267d);
        }
    }
}
