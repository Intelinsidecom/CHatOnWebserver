package com.sec.chaton.coolots;

import android.content.Context;
import android.os.RemoteException;
import com.sec.chaton.util.C1789u;

/* compiled from: DeleteAccountService.java */
/* renamed from: com.sec.chaton.coolots.f */
/* loaded from: classes.dex */
public class C0526f extends AbstractC0521a {
    public C0526f(Context context, InterfaceC0523c interfaceC0523c) {
        super(context, interfaceC0523c, "DeleteAccountService");
    }

    @Override // com.sec.chaton.coolots.AbstractC0521a
    /* renamed from: c */
    protected boolean mo2700c() {
        try {
            C1789u.m6077a("group_voice_call_max_count", (Integer) 0);
            C1789u.m6077a("group_video_call_max_count", (Integer) 0);
            this.f2137d.mo45a();
            m2699b();
            if (this.f2136c == null) {
                return true;
            }
            this.f2136c.mo2366a(true);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchMethodError e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
