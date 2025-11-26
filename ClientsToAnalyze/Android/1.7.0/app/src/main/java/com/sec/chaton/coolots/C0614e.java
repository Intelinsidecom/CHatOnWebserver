package com.sec.chaton.coolots;

import android.content.Context;
import android.os.RemoteException;
import com.sec.chaton.util.C1323bs;

/* compiled from: DeleteAccountService.java */
/* renamed from: com.sec.chaton.coolots.e */
/* loaded from: classes.dex */
public class C0614e extends AbstractC0617h {
    public C0614e(Context context, InterfaceC0616g interfaceC0616g) {
        super(context, interfaceC0616g, "DeleteAccountService");
    }

    @Override // com.sec.chaton.coolots.AbstractC0617h
    /* renamed from: a */
    protected boolean mo2830a() {
        try {
            C1323bs.m4577a("group_voice_call_max_count", (Integer) 0);
            C1323bs.m4577a("group_video_call_max_count", (Integer) 0);
            this.f2168f.mo45a();
            m2833c();
            if (this.f2167e == null) {
                return true;
            }
            this.f2167e.mo2367a(true);
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
