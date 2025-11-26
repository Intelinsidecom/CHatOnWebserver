package com.sec.chaton.facebook;

import com.facebook.android.SessionStore;
import java.io.IOException;
import java.net.MalformedURLException;

/* renamed from: com.sec.chaton.facebook.a */
/* loaded from: classes.dex */
class C0219a extends AbstractC0231m {

    /* renamed from: a */
    final /* synthetic */ FacebookManager f1847a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0219a(FacebookManager facebookManager) {
        super(facebookManager, "Logout");
        this.f1847a = facebookManager;
    }

    @Override // com.sec.chaton.facebook.AbstractC0231m
    /* renamed from: a */
    protected int mo2365a() {
        String message;
        try {
            message = FacebookManager.f1836a.m231a(this.f1847a.f1837b);
            if (message.length() == 0 || message.equals("false")) {
                this.f1866b = -1001;
                message = "auth.expireSession failed";
            } else {
                SessionStore.m254a(this.f1847a.f1837b);
            }
        } catch (MalformedURLException e) {
            this.f1866b = -1004;
            message = e.getMessage();
        } catch (IOException e2) {
            this.f1866b = -1003;
            message = e2.getMessage();
        }
        this.f1867c = message;
        return this.f1866b;
    }
}
