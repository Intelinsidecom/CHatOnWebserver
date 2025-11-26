package com.sec.chaton.facebook;

import android.os.Bundle;
import com.coolots.sso.model.ChatONCallStartInfo;
import com.p001a.p002a.C0030e;
import com.p001a.p002a.C0037l;
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.i */
/* loaded from: classes.dex */
abstract class AbstractC0728i {

    /* renamed from: a */
    private String f2708a;

    /* renamed from: b */
    protected int f2709b = -1;

    /* renamed from: c */
    protected String f2710c;

    /* renamed from: d */
    final /* synthetic */ C0725f f2711d;

    /* renamed from: a */
    protected abstract int mo3226a();

    public AbstractC0728i(C0725f c0725f, String str) {
        this.f2711d = c0725f;
        this.f2710c = null;
        this.f2708a = str;
        this.f2710c = null;
    }

    /* renamed from: a */
    protected int m3229a(String str, Bundle bundle, String str2, String str3) throws JSONException {
        String message;
        try {
            message = C0725f.f2701b.m7a(str, bundle, str2);
            if (!message.startsWith("[")) {
                JSONObject jSONObjectM44c = C0037l.m44c(message);
                if (str3 != null) {
                    message = jSONObjectM44c.getString(str3);
                }
            }
        } catch (C0030e e) {
            this.f2709b = ChatONCallStartInfo.ERROR_NOT_INITIALIZED_ENGINE;
            message = e.getMessage();
        } catch (MalformedURLException e2) {
            this.f2709b = -1004;
            message = e2.getMessage();
        } catch (IOException e3) {
            this.f2709b = -1003;
            message = e3.getMessage();
        } catch (JSONException e4) {
            this.f2709b = -1005;
            message = e4.getMessage();
        }
        this.f2710c = message;
        return this.f2709b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m3228b() {
        return this.f2710c;
    }

    public String toString() {
        return this.f2708a + " result:" + this.f2709b + "(" + this.f2710c + ")";
    }
}
