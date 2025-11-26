package com.sec.chaton.p057e.p059b;

import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.common.CommonApplication;

/* compiled from: BuddyBlockTask.java */
/* renamed from: com.sec.chaton.e.b.g */
/* loaded from: classes.dex */
public class C2246g extends AbstractC2240a {

    /* renamed from: c */
    private C1106c f7995c;

    /* renamed from: d */
    private boolean f7996d;

    /* renamed from: e */
    private int f7997e;

    public C2246g(InterfaceC2243d interfaceC2243d, C1106c c1106c, int i, boolean z) {
        super(interfaceC2243d, new Handler(Looper.getMainLooper()));
        this.f7995c = c1106c;
        this.f7997e = i;
        this.f7996d = z;
    }

    @Override // com.sec.chaton.p057e.p059b.AbstractC2240a
    /* renamed from: a */
    public Object mo8896a() {
        if (this.f7997e == 1) {
            Cursor cursorM9806a = C2190d.m9806a(CommonApplication.m18732r().getContentResolver(), this.f7995c);
            if (cursorM9806a == null) {
                return true;
            }
            return cursorM9806a;
        }
        if (this.f7997e == 2) {
        }
        return true;
    }
}
