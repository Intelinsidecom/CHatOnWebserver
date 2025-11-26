package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.util.C1786r;

/* compiled from: TwitterSignIn.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dc */
/* loaded from: classes.dex */
class C1429dc {
    final /* synthetic */ TwitterSignIn this$0;

    C1429dc(TwitterSignIn twitterSignIn) {
        this.this$0 = twitterSignIn;
    }

    public void getPinCode(String str) {
        C1786r.m6063c("PinCode : [" + str + "]", getClass().getSimpleName());
        if (this.this$0.m5009b(str)) {
            this.this$0.f5090a = str;
            C1786r.m6063c("Called. getPinCode ", getClass().getSimpleName());
            if (this.this$0.f5094e == null) {
                C1786r.m6063c("Called. getPinCode. mOAuthAccessTokenTask is null", getClass().getSimpleName());
                this.this$0.f5094e = (AsyncTaskC1430dd) new AsyncTaskC1430dd(this.this$0).execute(str);
                return;
            } else {
                C1786r.m6063c("Called. getPinCode. mOAuthAccessTokenTask is not null", getClass().getSimpleName());
                return;
            }
        }
        C1786r.m6054a("Incorrect PinCode!", getClass().getSimpleName());
    }
}
