package com.sec.chaton.facebook;

import com.coolots.sso.model.ChatONCallStartInfo;
import com.p001a.p002a.C0036k;
import java.io.IOException;
import java.net.MalformedURLException;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.p */
/* loaded from: classes.dex */
class C0735p extends AbstractC0728i {

    /* renamed from: a */
    final /* synthetic */ C0725f f2727a;

    /* synthetic */ C0735p(C0725f c0725f, HandlerC0726g handlerC0726g) {
        this(c0725f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0735p(C0725f c0725f) {
        super(c0725f, "Logout");
        this.f2727a = c0725f;
    }

    @Override // com.sec.chaton.facebook.AbstractC0728i
    /* renamed from: a */
    protected int mo3226a() {
        String message;
        try {
            message = C0725f.f2701b.m5a(this.f2727a.f2703c);
            if (message.length() != 0 && !"false".equals(message)) {
                C0036k.m29a(this.f2727a.f2703c);
            } else {
                this.f2709b = ChatONCallStartInfo.ERROR_NOT_INITIALIZED_ENGINE;
                message = "auth.expireSession failed";
            }
        } catch (MalformedURLException e) {
            this.f2709b = -1004;
            message = e.getMessage();
        } catch (IOException e2) {
            this.f2709b = -1003;
            message = e2.getMessage();
        }
        this.f2710c = message;
        return this.f2709b;
    }
}
