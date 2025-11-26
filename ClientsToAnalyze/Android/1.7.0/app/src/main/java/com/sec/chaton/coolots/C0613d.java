package com.sec.chaton.coolots;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.sec.chaton.util.C1323bs;
import java.util.ArrayList;

/* compiled from: MakeCallService.java */
/* renamed from: com.sec.chaton.coolots.d */
/* loaded from: classes.dex */
public class C0613d extends AbstractC0617h {

    /* renamed from: a */
    public static int f2153a = 1;

    /* renamed from: b */
    public static int f2154b = 0;

    /* renamed from: g */
    private String f2155g;

    /* renamed from: h */
    private ArrayList f2156h;

    /* renamed from: i */
    private boolean f2157i;

    /* renamed from: j */
    private String f2158j;

    public C0613d(Context context, InterfaceC0616g interfaceC0616g, String[] strArr, boolean z) {
        this(context, interfaceC0616g, strArr, z, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0613d(Context context, InterfaceC0616g interfaceC0616g, String[] strArr, boolean z, String str) {
        super(context, interfaceC0616g, "MakeCallService");
        str = str == null ? strArr[0] + "_temp_session" : str;
        for (int i = 0; i < strArr.length; i++) {
            Log.i(this.f2165c, "Receiver " + i + ":" + strArr[i] + ", isVoice=" + z + ", sessionId=" + str);
        }
        if (strArr.length == 1) {
            this.f2155g = strArr[0];
        } else {
            this.f2156h = new ArrayList();
            for (String str2 : strArr) {
                this.f2156h.add(str2);
            }
        }
        this.f2157i = z;
        this.f2158j = str;
    }

    @Override // com.sec.chaton.coolots.AbstractC0617h
    /* renamed from: a */
    boolean mo2830a() {
        boolean zMo57b;
        NoSuchMethodError e;
        RemoteException e2;
        String string = C1323bs.m4575a().getString("Push Name", "");
        try {
            if (this.f2155g != null) {
                if (this.f2157i) {
                    zMo57b = this.f2168f.mo48a(this.f2155g, this.f2158j, string);
                } else {
                    zMo57b = this.f2168f.mo55b(this.f2155g, this.f2158j, string);
                }
            } else if (this.f2156h == null) {
                zMo57b = false;
            } else if (this.f2157i) {
                zMo57b = this.f2168f.mo51a(this.f2156h, this.f2158j, string);
            } else {
                zMo57b = this.f2168f.mo57b(this.f2156h, this.f2158j, string);
            }
        } catch (RemoteException e3) {
            zMo57b = false;
            e2 = e3;
        } catch (NoSuchMethodError e4) {
            zMo57b = false;
            e = e4;
        }
        try {
            m2833c();
            if (this.f2167e != null) {
                this.f2167e.mo2367a(zMo57b);
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
