package com.sec.chaton.p057e.p059b;

import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: BuddyGroupAddTask.java */
/* renamed from: com.sec.chaton.e.b.i */
/* loaded from: classes.dex */
public class C2248i extends AbstractC2240a {

    /* renamed from: c */
    private int f8001c;

    /* renamed from: d */
    private String f8002d;

    /* renamed from: e */
    private ArrayList<String> f8003e;

    /* renamed from: f */
    private int f8004f;

    public C2248i(InterfaceC2243d interfaceC2243d, String str, int i) {
        super(interfaceC2243d, new Handler(Looper.getMainLooper()));
        this.f8002d = str;
        this.f8004f = i;
    }

    public C2248i(InterfaceC2243d interfaceC2243d, String[] strArr, int i) {
        super(interfaceC2243d, new Handler(Looper.getMainLooper()));
        this.f8004f = i;
        this.f8002d = strArr[0];
        this.f8003e = new ArrayList<>();
        for (int i2 = 1; i2 < strArr.length; i2++) {
            this.f8003e.add(strArr[i2]);
        }
    }

    public C2248i(InterfaceC2243d interfaceC2243d, String str, String[] strArr, int i) {
        super(interfaceC2243d, new Handler(Looper.getMainLooper()));
        this.f8004f = i;
        this.f8002d = str;
        this.f8003e = new ArrayList<>();
        for (String str2 : strArr) {
            this.f8003e.add(str2);
        }
    }

    @Override // com.sec.chaton.p057e.p059b.AbstractC2240a
    /* renamed from: a */
    public Object mo8896a() throws RemoteException, OperationApplicationException {
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        if (this.f8004f == 2) {
            C2191e.m9866c(contentResolver, this.f8002d);
            this.f8001c = C2191e.m9867d(contentResolver, this.f8002d);
            C2191e.m9854a(contentResolver, this.f8001c, this.f8003e);
            return Integer.valueOf(this.f8001c);
        }
        if (this.f8004f == 3) {
            if (this.f8001c == 0) {
                return Integer.valueOf(C2191e.m9870g(contentResolver, this.f8002d));
            }
            return Integer.valueOf(C2191e.m9860b(contentResolver, this.f8001c, this.f8002d));
        }
        if (this.f8004f == 10) {
            if (C2191e.m9848a(contentResolver, String.valueOf(this.f8001c), this.f8002d) == 1) {
                C2191e.m9856a(contentResolver, String.valueOf(this.f8001c));
                if (this.f8003e != null && this.f8003e.size() > 0) {
                    C2191e.m9854a(contentResolver, this.f8001c, this.f8003e);
                }
            }
            return "" + this.f8001c;
        }
        return null;
    }
}
