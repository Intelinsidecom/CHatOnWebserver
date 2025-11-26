package com.renren.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieSyncManager;
import com.sec.chaton.p020c.C0817b;
import com.sec.chaton.settings.tellfriends.DialogC2811e;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2786b;
import com.sec.spp.push.Config;
import java.io.IOException;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class Renren implements Parcelable {
    public static final String CANCEL_URI = "rrconnect://cancel";
    private static final String KEY_API_KEY = "api_key";
    private static final String KEY_APP_ID = "appid";
    private static final String KEY_SECRET = "secret";
    private static final String LOG_TAG = "Renren";
    private static final String LOG_TAG_REQUEST = "Renren-SDK-Request";
    private static final String LOG_TAG_RESPONSE = "Renren-SDK-Response";
    public static final String RENREN_LABEL = "Renren";
    public static final String RESPONSE_FORMAT_JSON = "json";
    public static final String RESPONSE_FORMAT_XML = "xml";
    private static final String SIGNATURE = "4382fbee4f43aa1ed294ae9052e86a61";
    public static final String SUCCESS_URI = "rrconnect://success";
    private AccessTokenManager accessTokenManager;
    private String apiKey;
    private String appId;
    private String secret;
    private static final String[] DEFAULT_PERMISSIONS = {"publish_feed", "create_album", "photo_upload", "read_user_album", "status_update"};
    public static final Parcelable.Creator<Renren> CREATOR = new C0210d();

    public Renren(String str, String str2, String str3, Context context) {
        if (str == null) {
            throw new RuntimeException("apiKey必须提供");
        }
        if (str2 == null) {
            throw new RuntimeException("secret必须提供");
        }
        if (str3 == null) {
            throw new RuntimeException("appId必须提供");
        }
        this.apiKey = str;
        this.secret = str2;
        this.appId = str3;
        m524a(context);
    }

    public Renren(Parcel parcel) {
        Bundle bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
        this.apiKey = bundle.getString(KEY_API_KEY);
        this.secret = bundle.getString(KEY_SECRET);
        this.appId = bundle.getString(KEY_APP_ID);
        this.accessTokenManager = AccessTokenManager.CREATOR.createFromParcel(parcel);
    }

    /* renamed from: a */
    public void m524a(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            Log.w("Renren", "App miss permission android.permission.ACCESS_NETWORK_STATE! Some mobile's WebView don't display page!");
        }
        this.accessTokenManager = new AccessTokenManager(context);
        this.accessTokenManager.m515f();
    }

    /* renamed from: a */
    void m525a(String str) {
        if (this.accessTokenManager != null) {
            this.accessTokenManager.m510a(str);
        }
    }

    /* renamed from: a */
    public void m523a(Activity activity, String[] strArr, InterfaceC2786b interfaceC2786b) {
        if (m526a()) {
            interfaceC2786b.mo541a(new Bundle());
        } else {
            m518a(activity, strArr, new C0202c(this, interfaceC2786b), C0817b.f3145q, "token");
        }
    }

    /* renamed from: a */
    private void m518a(Activity activity, String[] strArr, InterfaceC2786b interfaceC2786b, String str, String str2) {
        CookieSyncManager.createInstance(activity);
        Bundle bundle = new Bundle();
        bundle.putString("client_id", this.apiKey);
        bundle.putString("redirect_uri", str);
        bundle.putString("response_type", str2);
        bundle.putString("display", "touch");
        if (strArr == null) {
            strArr = DEFAULT_PERMISSIONS;
        }
        if (strArr != null && strArr.length > 0) {
            bundle.putString("scope", TextUtils.join(" ", strArr));
        }
        String str3 = C0817b.f3144p + "?" + C0214g.m568a(bundle);
        if (activity.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            C0214g.m571a(activity, Config.EXTRA_ERROR, "Application requires permission to access the Internet");
        } else {
            new DialogC2811e(activity, str3, interfaceC2786b).show();
        }
    }

    /* renamed from: a */
    public boolean m526a() {
        return this.accessTokenManager.m514e();
    }

    /* renamed from: b */
    public boolean m527b() {
        String strM509a = this.accessTokenManager.m509a();
        return strM509a != null && strM509a.trim().length() > 0;
    }

    /* renamed from: c */
    public String m528c() {
        return this.appId;
    }

    /* renamed from: d */
    public String m529d() {
        if (this.accessTokenManager != null) {
            return this.accessTokenManager.m509a();
        }
        return null;
    }

    /* renamed from: e */
    public long m530e() {
        return this.accessTokenManager.m513d();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        if (this.apiKey != null) {
            bundle.putString(KEY_API_KEY, this.apiKey);
        }
        if (this.secret != null) {
            bundle.putString(KEY_SECRET, this.secret);
        }
        if (this.appId != null) {
            bundle.putString(KEY_APP_ID, this.appId);
        }
        bundle.writeToParcel(parcel, i);
        this.accessTokenManager.writeToParcel(parcel, i);
    }

    /* renamed from: a */
    public String m522a(Bundle bundle) {
        return m517a(bundle, RESPONSE_FORMAT_JSON);
    }

    /* renamed from: a */
    private String m517a(Bundle bundle, String str) throws IOException {
        bundle.putString("format", str);
        if (m526a()) {
            bundle.putString("session_key", this.accessTokenManager.m511b());
        }
        m521c(bundle);
        m520b(bundle);
        String strM575b = C0214g.m575b(C0817b.f3148t, "POST", bundle);
        m519a(bundle.getString("method"), strM575b);
        return strM575b;
    }

    /* renamed from: b */
    private void m520b(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("method");
            if (string != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("method=").append(string).append("&").append(bundle.toString());
                Log.i(LOG_TAG_REQUEST, stringBuffer.toString());
                return;
            }
            Log.i(LOG_TAG_REQUEST, bundle.toString());
        }
    }

    /* renamed from: a */
    private void m519a(String str, String str2) {
        if (str != null && str2 != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("method=").append(str).append("&").append(str2);
            Log.i(LOG_TAG_RESPONSE, stringBuffer.toString());
        }
    }

    /* renamed from: c */
    private void m521c(Bundle bundle) {
        bundle.putString(KEY_API_KEY, this.apiKey);
        bundle.putString("v", "1.0");
        bundle.putString("call_id", String.valueOf(System.currentTimeMillis()));
        bundle.putString("xn_ss", "1");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : new TreeSet(bundle.keySet())) {
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append(bundle.getString(str));
        }
        stringBuffer.append(this.accessTokenManager.m512c());
        bundle.putString("sig", C0214g.m576c(stringBuffer.toString()));
    }
}
