package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.p035io.entry.inner.BuddyProfileNew;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: GetBuddyProfileTask.java */
/* renamed from: com.sec.chaton.d.a.bm */
/* loaded from: classes.dex */
public class C1185bm extends AbstractC1145a {

    /* renamed from: b */
    private String f4684b;

    /* renamed from: c */
    private Long f4685c;

    public C1185bm(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4684b = null;
        this.f4684b = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3250y.m11456e("beforeRequest", "GetProfileAllTask");
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        if (c0267d.m11704n() && c0267d.m1354e() != null) {
            BuddyProfileNew buddyProfileNew = (BuddyProfileNew) c0267d.m1354e();
            this.f4685c = buddyProfileNew.timestamp;
            if (buddyProfileNew != null && buddyProfileNew.buddy != null && buddyProfileNew.buddy.size() > 0) {
                Buddy buddy = buddyProfileNew.buddy.get(0);
                if (this.f4684b != null) {
                    ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                    C3250y.m11456e("Name : " + buddy.name + ", Status : " + buddy.status + ", Birthday : " + buddy.birthday + ", Samsungemail : " + buddy.samsungemail + ", Imgstatus : " + buddy.imgstatus + ", Orgnum : " + buddy.orgnum + ", Orgname : " + buddy.orgname, getClass().getSimpleName());
                    if (!this.f4684b.startsWith("0999")) {
                        Buddy buddy2 = new Buddy();
                        buddy2.name = buddy.name;
                        buddy2.status = buddy.status;
                        buddy2.birthday = buddy.birthday;
                        buddy2.imgstatus = buddy.imgstatus;
                        arrayList.add(C1360d.m6020a(this.f4684b, buddy2, this.f4685c.longValue()));
                    }
                    if (buddy.getImagestatus() != Buddy.BuddyImageStatus.NOT_CHANGE) {
                        C3205bt.m11182a(GlobalApplication.m11493l()).m11227b(this.f4684b);
                    }
                    GlobalApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                    C3250y.m11453c("buddy " + buddy.name + " written in db.", getClass().getSimpleName());
                    return;
                }
                C3159aa.m10962a().m10986b("Push Name", buddy.name);
                C3159aa.m10962a().m10986b("status_message", buddy.status);
                C3159aa.m10962a().m10986b("birthday_server", buddy.birthday);
            }
        }
    }
}
