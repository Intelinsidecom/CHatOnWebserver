package com.sec.chaton.p025d.p027b;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.p026a.C0622b;
import java.util.ArrayList;

/* compiled from: BuddyGroupAddTask.java */
/* renamed from: com.sec.chaton.d.b.l */
/* loaded from: classes.dex */
public class C0649l extends AbstractC0647j {

    /* renamed from: a */
    private int f2256a;

    /* renamed from: b */
    private String f2257b;

    /* renamed from: c */
    private ArrayList f2258c;

    /* renamed from: e */
    private int f2259e;

    public C0649l(InterfaceC0641d interfaceC0641d, String str, int i) {
        super(interfaceC0641d, new Handler(Looper.getMainLooper()));
        this.f2257b = str;
        this.f2259e = i;
    }

    public C0649l(InterfaceC0641d interfaceC0641d, String[] strArr, int i) {
        super(interfaceC0641d, new Handler(Looper.getMainLooper()));
        this.f2259e = i;
        this.f2257b = strArr[0];
        this.f2258c = new ArrayList();
        for (int i2 = 1; i2 < strArr.length; i2++) {
            this.f2258c.add(strArr[i2]);
        }
    }

    public C0649l(InterfaceC0641d interfaceC0641d, String str, String[] strArr, int i) {
        super(interfaceC0641d, new Handler(Looper.getMainLooper()));
        this.f2259e = i;
        this.f2257b = str;
        this.f2258c = new ArrayList();
        for (String str2 : strArr) {
            this.f2258c.add(str2);
        }
    }

    @Override // com.sec.chaton.p025d.p027b.AbstractC0647j
    /* renamed from: a */
    public Object mo2950a() {
        ContentResolver contentResolver = GlobalApplication.m3100a().getContentResolver();
        if (this.f2259e == 2) {
            C0622b.m2847c(contentResolver, this.f2257b);
            this.f2256a = C0622b.m2848d(contentResolver, this.f2257b);
            C0622b.m2843a(contentResolver, this.f2256a, this.f2258c);
            return Integer.valueOf(this.f2256a);
        }
        if (this.f2259e == 3) {
            if (this.f2256a == 0) {
                return Integer.valueOf(C0622b.m2849e(contentResolver, this.f2257b));
            }
            return Integer.valueOf(C0622b.m2840a(contentResolver, this.f2256a, this.f2257b));
        }
        if (this.f2259e == 10) {
            if (C0622b.m2841a(contentResolver, String.valueOf(this.f2256a), this.f2257b) == 1) {
                C0622b.m2845a(contentResolver, String.valueOf(this.f2256a));
                if (this.f2258c != null && this.f2258c.size() > 0) {
                    C0622b.m2843a(contentResolver, this.f2256a, this.f2258c);
                }
            }
            return "" + this.f2256a;
        }
        return null;
    }

    /* renamed from: b */
    public void m2974b(int i) {
        this.f2256a = i;
    }
}
