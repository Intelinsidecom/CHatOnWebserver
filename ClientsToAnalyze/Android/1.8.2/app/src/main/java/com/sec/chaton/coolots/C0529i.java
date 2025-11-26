package com.sec.chaton.coolots;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.sec.chaton.util.C1789u;
import java.util.ArrayList;

/* compiled from: MakeCallService.java */
/* renamed from: com.sec.chaton.coolots.i */
/* loaded from: classes.dex */
public class C0529i extends AbstractC0521a {

    /* renamed from: e */
    public static int f2152e = 1;

    /* renamed from: f */
    public static int f2153f = 0;

    /* renamed from: g */
    private String f2154g;

    /* renamed from: h */
    private ArrayList f2155h;

    /* renamed from: i */
    private boolean f2156i;

    /* renamed from: j */
    private String f2157j;

    public C0529i(Context context, InterfaceC0523c interfaceC0523c, String[] strArr, boolean z) {
        this(context, interfaceC0523c, strArr, z, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0529i(Context context, InterfaceC0523c interfaceC0523c, String[] strArr, boolean z, String str) {
        super(context, interfaceC0523c, "MakeCallService");
        str = str == null ? strArr[0] + "_temp_session" : str;
        for (int i = 0; i < strArr.length; i++) {
            Log.i(this.f2134a, "Receiver " + i + ":" + strArr[i] + ", isVoice=" + z + ", sessionId=" + str);
        }
        if (strArr.length == 1) {
            this.f2154g = strArr[0];
        } else {
            this.f2155h = new ArrayList();
            for (String str2 : strArr) {
                this.f2155h.add(str2);
            }
        }
        this.f2156i = z;
        this.f2157j = str;
    }

    @Override // com.sec.chaton.coolots.AbstractC0521a
    /* renamed from: c */
    boolean mo2700c() {
        boolean zMo57b;
        NoSuchMethodError e;
        RemoteException e2;
        String string = C1789u.m6075a().getString("Push Name", "");
        try {
            if (this.f2154g != null) {
                if (this.f2156i) {
                    zMo57b = this.f2137d.mo48a(this.f2154g, this.f2157j, string);
                } else {
                    zMo57b = this.f2137d.mo55b(this.f2154g, this.f2157j, string);
                }
            } else if (this.f2155h == null) {
                zMo57b = false;
            } else if (this.f2156i) {
                zMo57b = this.f2137d.mo51a(this.f2155h, this.f2157j, string);
            } else {
                zMo57b = this.f2137d.mo57b(this.f2155h, this.f2157j, string);
            }
        } catch (RemoteException e3) {
            zMo57b = false;
            e2 = e3;
        } catch (NoSuchMethodError e4) {
            zMo57b = false;
            e = e4;
        }
        try {
            m2699b();
            if (this.f2136c != null) {
                this.f2136c.mo2366a(zMo57b);
            }
        } catch (RemoteException e5) {
            e2 = e5;
            e2.printStackTrace();
            return zMo57b;
        } catch (NoSuchMethodError e6) {
            e = e6;
            e.printStackTrace();
            return zMo57b;
        }
        return zMo57b;
    }
}
