package com.sec.chaton.facebook;

import android.os.Bundle;
import com.facebook.android.FacebookError;
import com.facebook.android.Util;
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.sec.chaton.facebook.m */
/* loaded from: classes.dex */
abstract class AbstractC0231m {

    /* renamed from: a */
    private String f1865a;

    /* renamed from: b */
    protected int f1866b = -1;

    /* renamed from: c */
    protected String f1867c;

    /* renamed from: d */
    final /* synthetic */ FacebookManager f1868d;

    public AbstractC0231m(FacebookManager facebookManager, String str) {
        this.f1868d = facebookManager;
        this.f1867c = null;
        this.f1865a = str;
        this.f1867c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m2369b() {
        return this.f1867c;
    }

    /* renamed from: a */
    protected abstract int mo2365a();

    /* renamed from: a */
    protected int m2370a(String str, Bundle bundle, String str2, String str3) throws JSONException {
        String message;
        try {
            message = FacebookManager.f1836a.m233a(str, bundle, str2);
            if (!message.startsWith("[")) {
                JSONObject jSONObjectM267c = Util.m267c(message);
                if (str3 != null) {
                    message = jSONObjectM267c.getString(str3);
                }
            }
        } catch (FacebookError e) {
            this.f1866b = -1001;
            message = e.getMessage();
        } catch (MalformedURLException e2) {
            this.f1866b = -1004;
            message = e2.getMessage();
        } catch (IOException e3) {
            this.f1866b = -1003;
            message = e3.getMessage();
        } catch (JSONException e4) {
            this.f1866b = -1005;
            message = e4.getMessage();
        }
        this.f1867c = message;
        return this.f1866b;
    }

    public String toString() {
        return this.f1865a + " result:" + this.f1866b + "(" + this.f1867c + ")";
    }
}
