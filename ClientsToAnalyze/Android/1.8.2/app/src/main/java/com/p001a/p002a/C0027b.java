package com.p001a.p002a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieSyncManager;
import com.sec.spp.push.Config;

/* compiled from: Facebook.java */
/* renamed from: com.a.a.b */
/* loaded from: classes.dex */
public class C0027b {

    /* renamed from: a */
    protected static String f2a = "https://m.facebook.com/dialog/";

    /* renamed from: b */
    protected static String f3b = "https://graph.facebook.com/";

    /* renamed from: c */
    protected static String f4c = "https://api.facebook.com/restserver.php";

    /* renamed from: d */
    private String f5d = null;

    /* renamed from: e */
    private long f6e = 0;

    /* renamed from: f */
    private String f7f;

    /* renamed from: g */
    private Activity f8g;

    /* renamed from: h */
    private String[] f9h;

    /* renamed from: i */
    private int f10i;

    /* renamed from: j */
    private InterfaceC0029d f11j;

    /* renamed from: k */
    private Fragment f12k;

    public C0027b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
        }
        this.f7f = str;
    }

    /* renamed from: a */
    public void m13a(Fragment fragment) {
        this.f12k = fragment;
    }

    /* renamed from: a */
    public void m11a(Activity activity, String[] strArr, InterfaceC0029d interfaceC0029d) {
        m10a(activity, strArr, 32665, interfaceC0029d);
    }

    /* renamed from: a */
    public void m10a(Activity activity, String[] strArr, int i, InterfaceC0029d interfaceC0029d) {
        boolean zM4a = false;
        this.f11j = interfaceC0029d;
        if (i >= 0) {
            zM4a = m4a(activity, this.f7f, strArr, i);
        }
        if (!zM4a) {
            m2a(activity, strArr);
        }
    }

    /* renamed from: a */
    private boolean m4a(Activity activity, String str, String[] strArr, int i) {
        boolean z = true;
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        intent.putExtra("client_id", str);
        if (strArr.length > 0) {
            intent.putExtra("scope", TextUtils.join(",", strArr));
        }
        if (!m3a(activity, intent)) {
            return false;
        }
        this.f8g = activity;
        this.f9h = strArr;
        this.f10i = i;
        try {
            if (this.f12k != null) {
                this.f12k.startActivityForResult(intent, i);
            } else {
                activity.startActivityForResult(intent, i);
            }
        } catch (ActivityNotFoundException e) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    private boolean m3a(Activity activity, Intent intent) {
        ResolveInfo resolveInfoResolveActivity = activity.getPackageManager().resolveActivity(intent, 0);
        if (resolveInfoResolveActivity == null) {
            return false;
        }
        try {
            Signature[] signatureArr = activity.getPackageManager().getPackageInfo(resolveInfoResolveActivity.activityInfo.packageName, 64).signatures;
            for (Signature signature : signatureArr) {
                if (signature.toCharsString().equals("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2")) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: a */
    private void m2a(Activity activity, String[] strArr) {
        Bundle bundle = new Bundle();
        if (strArr.length > 0) {
            bundle.putString("scope", TextUtils.join(",", strArr));
        }
        CookieSyncManager.createInstance(activity);
        m12a(activity, "oauth", bundle, new C0028c(this));
    }

    /* renamed from: a */
    public void m8a(int i, int i2, Intent intent) {
        if (i == this.f10i) {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("error");
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra("error_type");
                }
                if (stringExtra != null) {
                    if ("service_disabled".equals(stringExtra) || "AndroidAuthKillSwitchException".equals(stringExtra)) {
                        Log.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
                        m2a(this.f8g, this.f9h);
                        return;
                    } else if ("access_denied".equals(stringExtra) || "OAuthAccessDeniedException".equals(stringExtra)) {
                        Log.d("Facebook-authorize", "Login canceled by user.");
                        this.f11j.mo19a();
                        return;
                    } else {
                        Log.d("Facebook-authorize", "Login failed: " + stringExtra);
                        this.f11j.mo22a(new C0030e(stringExtra));
                        return;
                    }
                }
                m14a(intent.getStringExtra("access_token"));
                m17b(intent.getStringExtra("expires_in"));
                if (m15a()) {
                    Log.d("Facebook-authorize", "Login Success! access_token=" + m16b() + " expires=" + m18c());
                    this.f11j.mo20a(intent.getExtras());
                    return;
                } else {
                    this.f11j.mo22a(new C0030e("Failed to receive access token."));
                    return;
                }
            }
            if (i2 == 0) {
                if (intent != null) {
                    Log.d("Facebook-authorize", "Login failed: " + intent.getStringExtra("error"));
                    this.f11j.mo21a(new C0026a(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                } else {
                    Log.d("Facebook-authorize", "Login canceled by user.");
                    this.f11j.mo19a();
                }
            }
        }
    }

    /* renamed from: a */
    public String m5a(Context context) {
        C0037l.m41a(context);
        Bundle bundle = new Bundle();
        bundle.putString("method", "auth.expireSession");
        String strM6a = m6a(bundle);
        m14a((String) null);
        m9a(0L);
        return strM6a;
    }

    /* renamed from: a */
    public String m6a(Bundle bundle) {
        if (!bundle.containsKey("method")) {
            throw new IllegalArgumentException("API method must be specified. (parameters must contain key \"method\" and value). See http://developers.facebook.com/docs/reference/rest/");
        }
        return m7a((String) null, bundle, "GET");
    }

    /* renamed from: a */
    public String m7a(String str, Bundle bundle, String str2) {
        bundle.putString("format", "json");
        if (m15a()) {
            bundle.putString("access_token", m16b());
        }
        return C0037l.m40a(str != null ? f3b + str : f4c, str2, bundle);
    }

    /* renamed from: a */
    public void m12a(Context context, String str, Bundle bundle, InterfaceC0029d interfaceC0029d) {
        String str2 = f2a + str;
        bundle.putString("display", "touch");
        bundle.putString("redirect_uri", "fbconnect://success");
        if ("oauth".equals(str)) {
            bundle.putString("type", "user_agent");
            bundle.putString("client_id", this.f7f);
        } else {
            bundle.putString("app_id", this.f7f);
        }
        if (m15a()) {
            bundle.putString("access_token", m16b());
        }
        String str3 = str2 + "?" + C0037l.m37a(bundle);
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            C0037l.m42a(context, Config.EXTRA_ERROR, "Application requires permission to access the Internet");
        } else {
            new DialogC0031f(context, str3, interfaceC0029d).show();
        }
    }

    /* renamed from: a */
    public boolean m15a() {
        return m16b() != null && (m18c() == 0 || System.currentTimeMillis() < m18c());
    }

    /* renamed from: b */
    public String m16b() {
        return this.f5d;
    }

    /* renamed from: c */
    public long m18c() {
        return this.f6e;
    }

    /* renamed from: a */
    public void m14a(String str) {
        this.f5d = str;
    }

    /* renamed from: a */
    public void m9a(long j) {
        this.f6e = j;
    }

    /* renamed from: b */
    public void m17b(String str) {
        if (str != null && !str.equals("0")) {
            m9a(System.currentTimeMillis() + (Integer.parseInt(str) * 1000));
        }
    }
}
