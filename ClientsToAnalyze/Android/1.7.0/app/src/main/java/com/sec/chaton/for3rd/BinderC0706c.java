package com.sec.chaton.for3rd;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Process;
import com.sec.chaton.access_token.C0231a;
import com.sec.chaton.p013a.C0202ao;
import com.sec.chaton.util.C1341p;

/* compiled from: DataAccessService.java */
/* renamed from: com.sec.chaton.for3rd.c */
/* loaded from: classes.dex */
class BinderC0706c extends AbstractBinderC0705b {

    /* renamed from: a */
    final /* synthetic */ DataAccessService f2391a;

    BinderC0706c(DataAccessService dataAccessService) {
        this.f2391a = dataAccessService;
    }

    @Override // com.sec.chaton.for3rd.InterfaceC0704a
    @Deprecated
    /* renamed from: a */
    public Bitmap mo3093a(String str) {
        C1341p.m4660c("tid" + Thread.currentThread().getId() + " getProfileImage, callingPid=" + Binder.getCallingPid() + ", Uid=" + Binder.getCallingUid() + ", My Pid=" + Process.myPid() + ", Uid=" + Process.myUid(), DataAccessService.f2389a);
        return null;
    }

    @Override // com.sec.chaton.for3rd.InterfaceC0704a
    /* renamed from: b */
    public boolean mo3094b(String str) {
        C1341p.m4660c("tid" + Thread.currentThread().getId() + " isBlockedBuddy, callingPid=" + Binder.getCallingPid() + ", Uid=" + Binder.getCallingUid() + ", My Pid=" + Process.myPid() + ", Uid=" + Process.myUid(), DataAccessService.f2389a);
        if (!C0231a.m886a(this.f2391a, Binder.getCallingUid())) {
            throw new SecurityException("Access Token is invalid.");
        }
        int iM770e = new C0202ao(null).m770e(str, true);
        C1341p.m4660c("isBlockedBuddy faultCode=" + iM770e, DataAccessService.f2389a);
        return iM770e == 15007;
    }

    @Override // com.sec.chaton.for3rd.InterfaceC0704a
    /* renamed from: a */
    public int mo3092a(String str, int i) {
        int i2 = 1;
        C1341p.m4660c("tid" + Thread.currentThread().getId() + " getBuddyStatus buddyNo=" + str + ", timeout=" + i + ", callingPid=" + Binder.getCallingPid() + ", Uid=" + Binder.getCallingUid() + ", My Pid=" + Process.myPid() + ", Uid=" + Process.myUid(), DataAccessService.f2389a);
        if (!C0231a.m886a(this.f2391a, Binder.getCallingUid())) {
            throw new SecurityException("Access Token is invalid.");
        }
        int iM756a = new C0202ao(null).m756a(str, true, i);
        switch (iM756a) {
            case -1:
                i2 = -1;
                break;
            case 15007:
                i2 = 2;
                break;
            case 15009:
                i2 = 3;
                break;
            case 15010:
                break;
            default:
                i2 = 0;
                break;
        }
        C1341p.m4660c("getBuddyStatus faultCode=" + iM756a + ", status=" + i2, DataAccessService.f2389a);
        return i2;
    }
}
