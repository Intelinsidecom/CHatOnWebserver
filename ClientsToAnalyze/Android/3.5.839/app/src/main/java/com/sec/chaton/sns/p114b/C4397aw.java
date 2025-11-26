package com.sec.chaton.sns.p114b;

import com.sec.chaton.sns.p113a.AbstractC4370g;
import com.sec.spp.push.dlc.api.DlcApi;
import java.util.ArrayList;
import java.util.List;
import p010b.C0320g;
import p010b.InterfaceC0271b;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.sns.b.aw */
/* loaded from: classes.dex */
class C4397aw extends AbstractC4370g {

    /* renamed from: d */
    ArrayList<Long> f15929d;

    /* renamed from: e */
    final /* synthetic */ C4394at f15930e;

    /* renamed from: f */
    private int f15931f;

    /* synthetic */ C4397aw(C4394at c4394at, HandlerC4395au handlerC4395au) {
        this(c4394at);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C4397aw(C4394at c4394at) {
        super(c4394at, "GetFriendsListTask");
        this.f15930e = c4394at;
        this.f15929d = new ArrayList<>();
        this.f15931f = 0;
    }

    @Override // com.sec.chaton.sns.p113a.AbstractC4370g
    /* renamed from: a */
    protected int mo16575a() {
        Object message;
        try {
            if (this.f15929d.isEmpty()) {
                long jM950b = -1;
                do {
                    InterfaceC0271b interfaceC0271bA = C4394at.f15922e.m945a(jM950b);
                    for (long j : interfaceC0271bA.m949a()) {
                        this.f15929d.add(Long.valueOf(j));
                    }
                    jM950b = interfaceC0271bA.m950b();
                } while (jM950b != 0);
            }
            int iM16712c = m16712c() * 100;
            int size = iM16712c + 100 < this.f15929d.size() ? iM16712c + 100 : this.f15929d.size();
            this.f15930e.m16571a("startIndex = " + iM16712c + " endIndex = " + size);
            List<Long> listSubList = this.f15929d.subList(m16712c() * 100, size);
            long[] jArr = new long[100];
            for (int i = 0; i < listSubList.size(); i++) {
                jArr[i] = listSubList.get(i).longValue();
            }
            message = C4394at.f15922e.m947a(jArr);
            m16713d();
            this.f15835a = -1;
        } catch (C0320g e) {
            e.printStackTrace();
            this.f15835a = -1001;
            message = e.getMessage();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            this.f15835a = DlcApi.RC_SVC_NOT_CONNECTED;
            message = e2.getMessage();
        }
        this.f15836b = message;
        return this.f15835a;
    }

    /* renamed from: c */
    private int m16712c() {
        return this.f15931f;
    }

    /* renamed from: d */
    private void m16713d() {
        this.f15931f++;
    }

    /* renamed from: b */
    public boolean m16714b() {
        return (!this.f15929d.isEmpty() && m16712c() * 100 < this.f15929d.size()) || this.f15929d.isEmpty();
    }
}
