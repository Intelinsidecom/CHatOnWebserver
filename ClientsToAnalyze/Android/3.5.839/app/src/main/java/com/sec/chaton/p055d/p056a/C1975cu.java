package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.inner.BuddyProfile;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4884g;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: GetUserProfileAllTask.java */
/* renamed from: com.sec.chaton.d.a.cu */
/* loaded from: classes.dex */
public class C1975cu extends AbstractC1900a {

    /* renamed from: b */
    private boolean f7266b;

    /* renamed from: c */
    private String f7267c;

    public C1975cu(C2454e c2454e, String str) {
        super(c2454e);
        this.f7266b = false;
        this.f7267c = null;
        this.f7267c = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4904y.m18646e("beforeRequest", "GetUserProfileAllTask");
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        if (c0778b.m18954n() && c0778b.m3110e() != null) {
            BuddyProfile buddyProfile = (BuddyProfile) c0778b.m3110e();
            if (this.f7267c != null) {
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                C4904y.m18646e("Name : " + buddyProfile.name + ", Status : " + buddyProfile.status + ", Birthday : " + buddyProfile.birthday + ", Email : " + buddyProfile.email + ", Imgstatus : " + buddyProfile.imgstatus, "GetUserProfileAllTask");
                if (!this.f7267c.startsWith("0999")) {
                    arrayList.add(C2190d.m9803a(this.f7267c, buddyProfile));
                }
                if (buddyProfile.getImagestatus() != BuddyProfile.BuddyImageStatus.NOT_CHANGE) {
                    C2496n.m10790e(CommonApplication.m18732r(), this.f7267c);
                }
                CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                C4904y.m18641c("buddy " + buddyProfile.name + " written in db.", "GetUserProfileAllTask");
                return;
            }
            if (!TextUtils.isEmpty(buddyProfile.name)) {
                C4809aa.m18104a().m18128b("Push Name", buddyProfile.name.trim());
            }
            C4809aa.m18104a().m18128b("status_message", buddyProfile.status);
            C4809aa.m18104a().m18128b("birthday_server", buddyProfile.birthday);
            C4904y.m18646e("ProfileControl.METHOD_GET_PROFILE_ALL Success", getClass().getSimpleName());
            String strM18121a = C4809aa.m18104a().m18121a("birthday_server", "");
            if (!strM18121a.equals("")) {
                C4884g.m18544a(strM18121a);
            }
            if (!TextUtils.isEmpty(buddyProfile.samsungemail)) {
                C4822an.m18215a(buddyProfile.samsungemail);
                return;
            }
            return;
        }
        C2404a.m10430a("01000004", "0002", c0778b);
    }
}
