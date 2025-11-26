package com.sec.chaton.settings.tellfriends;

import android.content.Context;
import android.os.Bundle;
import com.renren.android.Renren;
import com.sec.chaton.R;

/* compiled from: RenrenDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.l */
/* loaded from: classes.dex */
public class C2818l extends C2815i<C2818l> {
    @Override // com.sec.chaton.settings.tellfriends.C2815i
    /* renamed from: a */
    public /* bridge */ /* synthetic */ DialogC2811e mo10035a() {
        return super.mo10035a();
    }

    public C2818l(Context context, Renren renren, Bundle bundle) {
        super(context, renren, "request", bundle);
        bundle.putString("app_msg", context.getResources().getString(R.string.twitter_invite));
        bundle.putString("accept_url", "www.chaton.com/invite.html");
        bundle.putString("accept_label", "ChatON");
        bundle.putString("request_type", "invite");
    }
}
