package com.sec.chaton.sns.p114b;

import android.os.Bundle;
import com.renren.android.C0724f;
import com.renren.android.feed.FeedPublishRequestParam;
import com.sec.chaton.R;

/* compiled from: RenrenManager.java */
/* renamed from: com.sec.chaton.sns.b.u */
/* loaded from: classes.dex */
class C4437u extends C4438v {

    /* renamed from: d */
    String f16011d;

    /* renamed from: e */
    final /* synthetic */ C4432p f16012e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4437u(C4432p c4432p, String str) {
        super(c4432p, "PostInviteMessageTask");
        this.f16012e = c4432p;
        this.f16011d = str;
    }

    @Override // com.sec.chaton.sns.p114b.C4438v, com.sec.chaton.sns.p113a.AbstractC4370g
    /* renamed from: a */
    protected int mo16575a() {
        Bundle bundleM2295a;
        try {
            bundleM2295a = new FeedPublishRequestParam("ChatON", this.f16012e.f16002e.getString(R.string.twitter_invite), "www.chaton.com/invite.html", this.f16012e.f16002e.getString(R.string.logo_url_for_facebook), "ChatON", "ChatON", "www.chaton.com/invite.html", this.f16011d).m2295a();
        } catch (C0724f e) {
            e.printStackTrace();
            bundleM2295a = null;
        }
        return m16814a(bundleM2295a);
    }
}
