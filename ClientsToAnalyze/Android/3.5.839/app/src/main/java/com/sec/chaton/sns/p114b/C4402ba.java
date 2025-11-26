package com.sec.chaton.sns.p114b;

import com.sec.chaton.sns.p113a.AbstractC4370g;
import p010b.C0320g;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.sns.b.ba */
/* loaded from: classes.dex */
class C4402ba extends AbstractC4370g {

    /* renamed from: d */
    String f15939d;

    /* renamed from: e */
    final /* synthetic */ C4394at f15940e;

    /* synthetic */ C4402ba(C4394at c4394at, String str, HandlerC4395au handlerC4395au) {
        this(c4394at, str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C4402ba(C4394at c4394at, String str) {
        super(c4394at, "TweetMessageTask");
        this.f15940e = c4394at;
        this.f15939d = null;
        this.f15939d = str;
    }

    @Override // com.sec.chaton.sns.p113a.AbstractC4370g
    /* renamed from: a */
    protected int mo16575a() {
        String message = null;
        try {
            C4394at.f15922e.m946b_(this.f15939d);
        } catch (C0320g e) {
            e.printStackTrace();
            this.f15835a = -1001;
            message = e.getMessage();
        }
        this.f15836b = message;
        return this.f15835a;
    }
}
