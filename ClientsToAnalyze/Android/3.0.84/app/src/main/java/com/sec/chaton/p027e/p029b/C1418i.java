package com.sec.chaton.p027e.p029b;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: BuddyGroupAddTask.java */
/* renamed from: com.sec.chaton.e.b.i */
/* loaded from: classes.dex */
public class C1418i extends AbstractC1410a {

    /* renamed from: c */
    private int f5261c;

    /* renamed from: d */
    private String f5262d;

    /* renamed from: e */
    private ArrayList<String> f5263e;

    /* renamed from: f */
    private int f5264f;

    public C1418i(InterfaceC1413d interfaceC1413d, String str, int i) {
        super(interfaceC1413d, new Handler(Looper.getMainLooper()));
        this.f5262d = str;
        this.f5264f = i;
    }

    public C1418i(InterfaceC1413d interfaceC1413d, String[] strArr, int i) {
        super(interfaceC1413d, new Handler(Looper.getMainLooper()));
        this.f5264f = i;
        this.f5262d = strArr[0];
        this.f5263e = new ArrayList<>();
        for (int i2 = 1; i2 < strArr.length; i2++) {
            this.f5263e.add(strArr[i2]);
        }
    }

    public C1418i(InterfaceC1413d interfaceC1413d, String str, String[] strArr, int i) {
        super(interfaceC1413d, new Handler(Looper.getMainLooper()));
        this.f5264f = i;
        this.f5262d = str;
        this.f5263e = new ArrayList<>();
        for (String str2 : strArr) {
            this.f5263e.add(str2);
        }
    }

    @Override // com.sec.chaton.p027e.p029b.AbstractC1410a
    /* renamed from: a */
    public Object mo6263a() {
        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
        if (this.f5264f == 2) {
            C1362f.m6071c(contentResolver, this.f5262d);
            this.f5261c = C1362f.m6072d(contentResolver, this.f5262d);
            C1362f.m6061a(contentResolver, this.f5261c, this.f5263e);
            return Integer.valueOf(this.f5261c);
        }
        if (this.f5264f == 3) {
            if (this.f5261c == 0) {
                return Integer.valueOf(C1362f.m6075g(contentResolver, this.f5262d));
            }
            return Integer.valueOf(C1362f.m6067b(contentResolver, this.f5261c, this.f5262d));
        }
        if (this.f5264f == 10) {
            if (C1362f.m6056a(contentResolver, String.valueOf(this.f5261c), this.f5262d) == 1) {
                C1362f.m6063a(contentResolver, String.valueOf(this.f5261c));
                if (this.f5263e != null && this.f5263e.size() > 0) {
                    C1362f.m6061a(contentResolver, this.f5261c, this.f5263e);
                }
            }
            return "" + this.f5261c;
        }
        return null;
    }
}
