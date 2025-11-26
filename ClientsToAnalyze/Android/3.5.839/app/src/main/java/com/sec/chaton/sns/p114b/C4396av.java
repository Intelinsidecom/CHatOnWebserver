package com.sec.chaton.sns.p114b;

import com.sec.chaton.sns.p113a.AbstractC4370g;
import com.sec.spp.push.dlc.api.DlcApi;
import java.util.ArrayList;
import p010b.C0320g;
import p010b.InterfaceC0271b;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.sns.b.av */
/* loaded from: classes.dex */
class C4396av extends AbstractC4370g {

    /* renamed from: d */
    ArrayList<Long> f15927d;

    /* renamed from: e */
    final /* synthetic */ C4394at f15928e;

    /* synthetic */ C4396av(C4394at c4394at, HandlerC4395au handlerC4395au) {
        this(c4394at);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C4396av(C4394at c4394at) {
        super(c4394at, "GetFriendsIDsTask");
        this.f15928e = c4394at;
        this.f15927d = new ArrayList<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.chaton.sns.p113a.AbstractC4370g
    /* renamed from: a */
    protected int mo16575a() {
        String message;
        long jM950b = -1;
        do {
            try {
                InterfaceC0271b interfaceC0271bA = C4394at.f15922e.m945a(jM950b);
                for (long j : interfaceC0271bA.m949a()) {
                    this.f15927d.add(Long.valueOf(j));
                }
                jM950b = interfaceC0271bA.m950b();
            } catch (C0320g e) {
                e.printStackTrace();
                this.f15835a = -1001;
                message = e.getMessage();
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                this.f15835a = DlcApi.RC_SVC_NOT_CONNECTED;
                message = e2.getMessage();
            }
        } while (jM950b != 0);
        long[] jArr = new long[this.f15927d.size()];
        for (int i = 0; i < this.f15927d.size(); i++) {
            jArr[i] = this.f15927d.get(i).longValue();
        }
        this.f15835a = -1;
        message = jArr;
        this.f15836b = message;
        return this.f15835a;
    }
}
