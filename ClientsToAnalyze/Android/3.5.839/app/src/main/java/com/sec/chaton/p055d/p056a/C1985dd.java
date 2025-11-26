package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.C0919es;
import com.sec.chaton.p046a.p047a.C0788l;
import java.util.ArrayList;

/* compiled from: InitChatRoomTask.java */
/* renamed from: com.sec.chaton.d.a.dd */
/* loaded from: classes.dex */
public class C1985dd extends C0788l {

    /* renamed from: d */
    public ArrayList<String> f7285d;

    /* renamed from: e */
    public C0919es f7286e;

    /* renamed from: f */
    final /* synthetic */ C1984dc f7287f;

    /* renamed from: g */
    private String f7288g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1985dd(C1984dc c1984dc, boolean z, String str, int i, long j) {
        super(z, i, j);
        this.f7287f = c1984dc;
        this.f7288g = str;
        this.f7285d = null;
        this.f7286e = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1985dd(C1984dc c1984dc, boolean z, String str, int i, ArrayList<String> arrayList, long j) {
        super(z, i, j);
        this.f7287f = c1984dc;
        this.f7288g = str;
        this.f7285d = arrayList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1985dd(C1984dc c1984dc, boolean z, int i, ArrayList<String> arrayList, long j) {
        super(z, i, j);
        this.f7287f = c1984dc;
        this.f7285d = arrayList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1985dd(C1984dc c1984dc, boolean z, int i, C0919es c0919es, long j) {
        super(z, i, j);
        this.f7287f = c1984dc;
        this.f7286e = c0919es;
    }

    /* renamed from: a */
    public String m9136a() {
        return this.f7288g;
    }
}
