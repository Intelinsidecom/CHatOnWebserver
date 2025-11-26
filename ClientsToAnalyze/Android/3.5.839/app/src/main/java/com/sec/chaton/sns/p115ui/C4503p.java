package com.sec.chaton.sns.p115ui;

import android.content.Context;
import android.os.Bundle;
import com.renren.android.Renren;
import com.sec.chaton.R;

/* compiled from: RenrenDialog.java */
/* renamed from: com.sec.chaton.sns.ui.p */
/* loaded from: classes.dex */
public class C4503p extends C4491m<C4503p> {
    @Override // com.sec.chaton.sns.p115ui.C4491m
    /* renamed from: a */
    public /* bridge */ /* synthetic */ DialogC4487i mo17005a() {
        return super.mo17005a();
    }

    public C4503p(Context context, Renren renren, Bundle bundle) {
        super(context, renren, "request", bundle);
        bundle.putString("app_msg", context.getResources().getString(R.string.twitter_invite));
        bundle.putString("accept_url", "www.chaton.com/invite.html");
        bundle.putString("accept_label", "ChatON");
        bundle.putString("request_type", "invite");
    }
}
