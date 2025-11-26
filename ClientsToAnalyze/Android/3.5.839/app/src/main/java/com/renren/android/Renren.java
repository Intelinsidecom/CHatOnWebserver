package com.renren.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieSyncManager;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.p051c.C1428b;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.sns.p113a.InterfaceC4366c;
import com.sec.chaton.sns.p115ui.DialogC4487i;
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
    public static final Parcelable.Creator<Renren> CREATOR = new C0722d();

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
        m2256a(context);
    }

    public Renren(Parcel parcel) {
        Bundle bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
        this.apiKey = bundle.getString(KEY_API_KEY);
        this.secret = bundle.getString("secret");
        this.appId = bundle.getString(KEY_APP_ID);
        this.accessTokenManager = AccessTokenManager.CREATOR.createFromParcel(parcel);
    }

    /* renamed from: a */
    public void m2256a(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            Log.w("Renren", "App miss permission android.permission.ACCESS_NETWORK_STATE! Some mobile's WebView don't display page!");
        }
        this.accessTokenManager = new AccessTokenManager(context);
        this.accessTokenManager.m2247f();
    }

    /* renamed from: a */
    void m2257a(String str) {
        if (this.accessTokenManager != null) {
            this.accessTokenManager.m2242a(str);
        }
    }

    /* renamed from: a */
    public void m2255a(Activity activity, String[] strArr, InterfaceC4366c interfaceC4366c) {
        if (m2258a()) {
            interfaceC4366c.mo2273a(new Bundle());
        } else {
            m2250a(activity, strArr, new C0714c(this, interfaceC4366c), C1428b.f5117w, "token");
        }
    }

    /* renamed from: a */
    private void m2250a(Activity activity, String[] strArr, InterfaceC4366c interfaceC4366c, String str, String str2) {
        CookieSyncManager.createInstance(activity);
        Bundle bundle = new Bundle();
        bundle.putString(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, this.apiKey);
        bundle.putString("redirect_uri", str);
        bundle.putString("response_type", str2);
        bundle.putString("display", "touch");
        if (strArr == null) {
            strArr = DEFAULT_PERMISSIONS;
        }
        if (strArr != null && strArr.length > 0) {
            bundle.putString(VKOpenAuthActivity.VK_EXTRA_SCOPE, TextUtils.join(" ", strArr));
        }
        String str3 = C1428b.f5116v + "?" + C0726g.m2300a(bundle);
        if (activity.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            C0726g.m2303a(activity, Config.EXTRA_ERROR, "Application requires permission to access the Internet");
        } else {
            new DialogC4487i(activity, str3, interfaceC4366c).show();
        }
    }

    /* renamed from: a */
    public boolean m2258a() {
        return this.accessTokenManager.m2246e();
    }

    /* renamed from: b */
    public boolean m2259b() {
        String strM2241a = this.accessTokenManager.m2241a();
        return strM2241a != null && strM2241a.trim().length() > 0;
    }

    /* renamed from: c */
    public String m2260c() {
        return this.appId;
    }

    /* renamed from: d */
    public String m2261d() {
        if (this.accessTokenManager != null) {
            return this.accessTokenManager.m2241a();
        }
        return null;
    }

    /* renamed from: e */
    public long m2262e() {
        return this.accessTokenManager.m2245d();
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
            bundle.putString("secret", this.secret);
        }
        if (this.appId != null) {
            bundle.putString(KEY_APP_ID, this.appId);
        }
        bundle.writeToParcel(parcel, i);
        this.accessTokenManager.writeToParcel(parcel, i);
    }

    /* renamed from: a */
    public String m2254a(Bundle bundle) {
        return m2249a(bundle, RESPONSE_FORMAT_JSON);
    }

    /* renamed from: a */
    private String m2249a(Bundle bundle, String str) throws IOException {
        bundle.putString("format", str);
        if (m2258a()) {
            bundle.putString("session_key", this.accessTokenManager.m2243b());
        }
        m2253c(bundle);
        m2252b(bundle);
        String strM2307b = C0726g.m2307b(C1428b.f5120z, "POST", bundle);
        m2251a(bundle.getString("method"), strM2307b);
        return strM2307b;
    }

    /* renamed from: b */
    private void m2252b(Bundle bundle) {
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
    private void m2251a(String str, String str2) {
        if (str != null && str2 != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("method=").append(str).append("&").append(str2);
            Log.i(LOG_TAG_RESPONSE, stringBuffer.toString());
        }
    }

    /* renamed from: c */
    private void m2253c(Bundle bundle) {
        bundle.putString(KEY_API_KEY, this.apiKey);
        bundle.putString(VKApiConst.VERSION, "1.0");
        bundle.putString("call_id", String.valueOf(System.currentTimeMillis()));
        bundle.putString("xn_ss", Spam.ACTIVITY_REPORT);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : new TreeSet(bundle.keySet())) {
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append(bundle.getString(str));
        }
        stringBuffer.append(this.accessTokenManager.m2244c());
        bundle.putString(VKApiConst.SIG, C0726g.m2308c(stringBuffer.toString()));
    }
}
