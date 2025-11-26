package com.sec.chaton.settings.tellfriends;

import android.os.Bundle;
import com.renren.android.C0212f;
import com.renren.android.feed.FeedPublishRequestParam;
import com.sec.chaton.R;

/* compiled from: RenrenManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.r */
/* loaded from: classes.dex */
class C2824r extends C2825s {

    /* renamed from: a */
    String f10354a;

    /* renamed from: b */
    final /* synthetic */ C2819m f10355b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2824r(C2819m c2819m, String str) {
        super(c2819m, "PostInviteMessageTask");
        this.f10355b = c2819m;
        this.f10354a = str;
    }

    @Override // com.sec.chaton.settings.tellfriends.C2825s, com.sec.chaton.settings.tellfriends.common.AbstractC2800p
    /* renamed from: a */
    protected int mo9862a() {
        Bundle bundleM563a;
        try {
            bundleM563a = new FeedPublishRequestParam("ChatON", this.f10355b.f10345e.getString(R.string.twitter_invite), "www.chaton.com/invite.html", this.f10355b.f10345e.getString(R.string.logo_url_for_facebook), "ChatON", "ChatON", "www.chaton.com/invite.html", this.f10354a).m563a();
        } catch (C0212f e) {
            e.printStackTrace();
            bundleM563a = null;
        }
        return m10056a(bundleM563a);
    }
}
