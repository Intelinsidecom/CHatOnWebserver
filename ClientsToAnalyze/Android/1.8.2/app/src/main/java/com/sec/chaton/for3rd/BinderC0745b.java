package com.sec.chaton.for3rd;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.sec.chaton.access_token.C0203a;
import com.sec.chaton.p015d.C0632d;
import com.sec.chaton.p028io.entry.inner.BlockBuddy;
import com.sec.chaton.util.C1746bb;
import java.util.Iterator;
import java.util.List;

/* compiled from: DataAccessService.java */
/* renamed from: com.sec.chaton.for3rd.b */
/* loaded from: classes.dex */
class BinderC0745b extends AbstractBinderC0747d {

    /* renamed from: a */
    final /* synthetic */ DataAccessService f2745a;

    BinderC0745b(DataAccessService dataAccessService) {
        this.f2745a = dataAccessService;
    }

    @Override // com.sec.chaton.for3rd.InterfaceC0746c
    /* renamed from: a */
    public Bitmap mo3239a(String str) {
        Log.i(DataAccessService.f2742a, "tid" + Thread.currentThread().getId() + " getProfileImage, callingPid=" + Binder.getCallingPid() + ", Uid=" + Binder.getCallingUid() + ", My Pid=" + Process.myPid() + ", Uid=" + Process.myUid());
        return C1746bb.m5945a(this.f2745a).m5964e(str);
    }

    @Override // com.sec.chaton.for3rd.InterfaceC0746c
    /* renamed from: b */
    public boolean mo3240b(String str) {
        Log.i(DataAccessService.f2742a, "tid" + Thread.currentThread().getId() + " isBlockedBuddy, callingPid=" + Binder.getCallingPid() + ", Uid=" + Binder.getCallingUid() + ", My Pid=" + Process.myPid() + ", Uid=" + Process.myUid());
        if (!C0203a.m1794a(this.f2745a, Binder.getCallingUid())) {
            throw new SecurityException("Access Token is invalid.");
        }
        List listM2845a = new C0632d(null).m2845a(true);
        if (listM2845a != null) {
            Iterator it = listM2845a.iterator();
            while (it.hasNext()) {
                if (((BlockBuddy) it.next()).value.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
