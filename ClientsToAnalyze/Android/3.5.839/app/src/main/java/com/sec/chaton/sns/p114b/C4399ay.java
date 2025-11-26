package com.sec.chaton.sns.p114b;

import android.text.TextUtils;
import com.sec.chaton.sns.p113a.AbstractC4370g;
import com.sec.spp.push.dlc.api.DlcApi;
import p010b.C0320g;
import p010b.p012b.C0280i;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.sns.b.ay */
/* loaded from: classes.dex */
class C4399ay extends AbstractC4370g {

    /* renamed from: d */
    final /* synthetic */ C4394at f15934d;

    /* synthetic */ C4399ay(C4394at c4394at, HandlerC4395au handlerC4395au) {
        this(c4394at);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C4399ay(C4394at c4394at) {
        super(c4394at, "GetRequestTokenTask");
        this.f15934d = c4394at;
    }

    @Override // com.sec.chaton.sns.p113a.AbstractC4370g
    /* renamed from: a */
    protected int mo16575a() {
        this.f15934d.m16571a("GetRequestTokenTask() : Get Request Token");
        try {
            C0280i unused = C4394at.f15923f = C4394at.f15922e.mo967a();
            if (C4394at.f15923f == null || TextUtils.isEmpty(C4394at.f15923f.mo954c())) {
                this.f15934d.m16572b("Incorrect Request Token!");
                this.f15835a = DlcApi.RC_SVC_NOT_CONNECTED;
                this.f15836b = null;
            } else {
                this.f15835a = -1;
                this.f15836b = C4394at.f15923f.mo954c();
            }
        } catch (C0320g e) {
            e.printStackTrace();
            this.f15835a = -1001;
            e.getMessage();
        }
        return this.f15835a;
    }
}
