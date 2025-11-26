package com.sec.chaton.p025d.p026a;

import com.sec.chaton.p016a.C0366di;
import com.sec.chaton.p016a.p017a.C0272i;
import java.util.ArrayList;

/* compiled from: InitChatRoomTask.java */
/* renamed from: com.sec.chaton.d.a.cv */
/* loaded from: classes.dex */
public class C1221cv extends C0272i {

    /* renamed from: d */
    public ArrayList<String> f4733d;

    /* renamed from: e */
    public C0366di f4734e;

    /* renamed from: f */
    final /* synthetic */ C1220cu f4735f;

    /* renamed from: g */
    private String f4736g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1221cv(C1220cu c1220cu, boolean z, String str, int i, long j) {
        super(z, i, j);
        this.f4735f = c1220cu;
        this.f4736g = str;
        this.f4733d = null;
        this.f4734e = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1221cv(C1220cu c1220cu, boolean z, String str, int i, ArrayList<String> arrayList, long j) {
        super(z, i, j);
        this.f4735f = c1220cu;
        this.f4736g = str;
        this.f4733d = arrayList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1221cv(C1220cu c1220cu, boolean z, int i, ArrayList<String> arrayList, long j) {
        super(z, i, j);
        this.f4735f = c1220cu;
        this.f4733d = arrayList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1221cv(C1220cu c1220cu, boolean z, int i, C0366di c0366di, long j) {
        super(z, i, j);
        this.f4735f = c1220cu;
        this.f4734e = c0366di;
    }

    /* renamed from: a */
    public String m5550a() {
        return this.f4736g;
    }
}
