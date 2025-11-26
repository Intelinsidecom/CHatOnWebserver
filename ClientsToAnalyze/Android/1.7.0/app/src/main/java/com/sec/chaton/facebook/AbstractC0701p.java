package com.sec.chaton.facebook;

import android.os.Bundle;
import com.coolots.sso.model.ChatONCallStartInfo;
import com.p001a.p002a.C0036a;
import com.p001a.p002a.C0047l;
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.p */
/* loaded from: classes.dex */
abstract class AbstractC0701p {

    /* renamed from: a */
    private String f2378a;

    /* renamed from: b */
    protected int f2379b = -1;

    /* renamed from: c */
    protected String f2380c;

    /* renamed from: d */
    final /* synthetic */ C0700o f2381d;

    /* renamed from: a */
    protected abstract int mo3065a();

    public AbstractC0701p(C0700o c0700o, String str) {
        this.f2381d = c0700o;
        this.f2380c = null;
        this.f2378a = str;
        this.f2380c = null;
    }

    /* renamed from: a */
    protected int m3088a(String str, Bundle bundle, String str2, String str3) throws JSONException {
        String message;
        try {
            message = C0700o.f2375a.m25a(str, bundle, str2);
            if (!message.startsWith("[")) {
                JSONObject jSONObjectM9c = C0036a.m9c(message);
                if (str3 != null) {
                    message = jSONObjectM9c.getString(str3);
                }
            }
        } catch (C0047l e) {
            this.f2379b = ChatONCallStartInfo.ERROR_NOT_INITIALIZED_ENGINE;
            message = e.getMessage();
        } catch (MalformedURLException e2) {
            this.f2379b = -1004;
            message = e2.getMessage();
        } catch (IOException e3) {
            this.f2379b = -1003;
            message = e3.getMessage();
        } catch (JSONException e4) {
            this.f2379b = -1005;
            message = e4.getMessage();
        }
        this.f2380c = message;
        return this.f2379b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m3087b() {
        return this.f2380c;
    }

    public String toString() {
        return this.f2378a + " result:" + this.f2379b + "(" + this.f2380c + ")";
    }
}
