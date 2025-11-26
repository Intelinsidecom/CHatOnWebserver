package com.sec.chaton.facebook;

import com.coolots.sso.model.ChatONCallStartInfo;
import com.p001a.p002a.C0037b;
import java.io.IOException;
import java.net.MalformedURLException;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.a */
/* loaded from: classes.dex */
class C0686a extends AbstractC0701p {

    /* renamed from: a */
    final /* synthetic */ C0700o f2360a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0686a(C0700o c0700o) {
        super(c0700o, "Logout");
        this.f2360a = c0700o;
    }

    @Override // com.sec.chaton.facebook.AbstractC0701p
    /* renamed from: a */
    protected int mo3065a() {
        String message;
        try {
            message = C0700o.f2375a.m23a(this.f2360a.f2376b);
            if (message.length() != 0 && !"false".equals(message)) {
                C0037b.m10a(this.f2360a.f2376b);
            } else {
                this.f2379b = ChatONCallStartInfo.ERROR_NOT_INITIALIZED_ENGINE;
                message = "auth.expireSession failed";
            }
        } catch (MalformedURLException e) {
            this.f2379b = -1004;
            message = e.getMessage();
        } catch (IOException e2) {
            this.f2379b = -1003;
            message = e2.getMessage();
        }
        this.f2380c = message;
        return this.f2379b;
    }
}
