package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.settings.tellfriends.common.AbstractC2800p;
import twitter4j.TwitterException;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bh */
/* loaded from: classes.dex */
class C2758bh extends AbstractC2800p {

    /* renamed from: a */
    String f10165a;

    /* renamed from: b */
    final /* synthetic */ C2751ba f10166b;

    /* synthetic */ C2758bh(C2751ba c2751ba, String str, HandlerC2752bb handlerC2752bb) {
        this(c2751ba, str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C2758bh(C2751ba c2751ba, String str) {
        super(c2751ba, "TweetMessageTask");
        this.f10166b = c2751ba;
        this.f10165a = null;
        this.f10165a = str;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.AbstractC2800p
    /* renamed from: a */
    protected int mo9862a() {
        String message = null;
        try {
            C2751ba.f10150e.updateStatus(this.f10165a);
        } catch (TwitterException e) {
            e.printStackTrace();
            this.f10304e = -1001;
            message = e.getMessage();
        }
        this.f10305f = message;
        return this.f10304e;
    }
}
