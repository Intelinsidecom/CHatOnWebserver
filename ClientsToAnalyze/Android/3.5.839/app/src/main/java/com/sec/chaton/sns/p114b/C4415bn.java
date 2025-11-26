package com.sec.chaton.sns.p114b;

import android.text.TextUtils;
import com.sec.chaton.sns.p113a.AbstractC4370g;
import com.sec.spp.push.dlc.api.DlcApi;
import p021c.C0351j;
import p021c.p022a.C0333h;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.sns.b.bn */
/* loaded from: classes.dex */
class C4415bn extends AbstractC4370g {

    /* renamed from: d */
    final /* synthetic */ C4410bi f15967d;

    /* synthetic */ C4415bn(C4410bi c4410bi, HandlerC4411bj handlerC4411bj) {
        this(c4410bi);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C4415bn(C4410bi c4410bi) {
        super(c4410bi, "GetRequestTokenTask");
        this.f15967d = c4410bi;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004e -> B:18:0x003c). Please report as a decompilation issue!!! */
    @Override // com.sec.chaton.sns.p113a.AbstractC4370g
    /* renamed from: a */
    protected int mo16575a() {
        String message = null;
        this.f15967d.m16571a("GetRequestTokenTask() : Get Request Token");
        try {
            try {
                C0333h unused = C4410bi.f15958e = C4410bi.f15957d.m1234c("chaton://WeiboSubMenuActivity");
                if (C4410bi.f15958e == null || TextUtils.isEmpty(C4410bi.f15958e.mo1123d())) {
                    this.f15967d.m16572b("Incorrect Request Token!");
                    this.f15835a = DlcApi.RC_SVC_NOT_CONNECTED;
                    this.f15836b = null;
                } else {
                    this.f15835a = -1;
                    message = C4410bi.f15958e.mo1123d();
                }
            } catch (C0351j e) {
                e.printStackTrace();
                this.f15835a = -1005;
                message = e.getMessage();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f15835a = DlcApi.RC_SVC_NOT_CONNECTED;
            message = e2.getMessage();
        }
        this.f15836b = message;
        return this.f15835a;
    }
}
