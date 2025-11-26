package com.sec.chaton.msgsend;

import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p067j.EnumC2468s;

/* compiled from: ChatONLiveChatRoomEntity.java */
/* renamed from: com.sec.chaton.msgsend.e */
/* loaded from: classes.dex */
public class C2697e extends AbstractC2682a {

    /* renamed from: g */
    public static final String f9680g = C2697e.class.getSimpleName();

    C2697e(EnumC2301u enumC2301u, String str, EnumC2300t enumC2300t, String[] strArr) {
        super(enumC2301u, str, enumC2300t, strArr);
    }

    @Override // com.sec.chaton.msgsend.AbstractC2682a
    /* renamed from: a */
    C2688af mo11272a() {
        return new C2688af(EnumC2687ae.NOTHING_TODO);
    }

    @Override // com.sec.chaton.msgsend.AbstractC2682a
    /* renamed from: a */
    boolean mo11279a(String str, String str2, int i, long j) {
        return true;
    }

    @Override // com.sec.chaton.msgsend.AbstractC2682a
    /* renamed from: a */
    EnumC2689ag mo11273a(EnumC2693ak enumC2693ak, EnumC2468s enumC2468s, long j) {
        return EnumC2689ag.REASON_LATEST_SENT_MSG_SUCCESS;
    }

    @Override // com.sec.chaton.msgsend.AbstractC2682a
    /* renamed from: a */
    void mo11274a(long j) {
    }
}
