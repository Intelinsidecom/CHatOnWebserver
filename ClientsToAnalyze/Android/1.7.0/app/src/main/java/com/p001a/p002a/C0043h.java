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
/* renamed from: com.a.a.h */
/* loaded from: classes.dex */
public class C0043h {

    /* renamed from: a */
    protected static String f4a = "https://m.facebook.com/dialog/";

    /* renamed from: b */
    protected static String f5b = "https://graph.facebook.com/";

    /* renamed from: c */
    protected static String f6c = "https://api.facebook.com/restserver.php";

    /* renamed from: d */
    private String f7d = null;

    /* renamed from: e */
    private long f8e = 0;

    /* renamed from: f */
    private String f9f;

    /* renamed from: g */
    private Activity f10g;

    /* renamed from: h */
    private String[] f11h;

    /* renamed from: i */
    private int f12i;

    /* renamed from: j */
    private InterfaceC0041f f13j;

    /* renamed from: k */
    private Fragment f14k;

    public C0043h(String str) {
        if (str == null) {
            throw new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
        }
        this.f9f = str;
    }

    /* renamed from: a */
    public void m29a(Activity activity, String[] strArr, InterfaceC0041f interfaceC0041f) {
        m28a(activity, strArr, 32665, interfaceC0041f);
    }

    /* renamed from: a */
    public void m28a(Activity activity, String[] strArr, int i, InterfaceC0041f interfaceC0041f) {
        boolean zM22a = false;
        this.f13j = interfaceC0041f;
        if (i >= 0) {
            zM22a = m22a(activity, this.f9f, strArr, i);
        }
        if (!zM22a) {
            m20a(activity, strArr);
        }
    }

    /* renamed from: a */
    private boolean m22a(Activity activity, String str, String[] strArr, int i) {
        boolean z = true;
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        intent.putExtra("client_id", str);
        if (strArr.length > 0) {
            intent.putExtra("scope", TextUtils.join(",", strArr));
        }
        if (!m21a(activity, intent)) {
            return false;
        }
        this.f10g = activity;
        this.f11h = strArr;
        this.f12i = i;
        try {
            if (this.f14k != null) {
                this.f14k.startActivityForResult(intent, i);
            } else {
                activity.startActivityForResult(intent, i);
            }
        } catch (ActivityNotFoundException e) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    private boolean m21a(Activity activity, Intent intent) {
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
    private void m20a(Activity activity, String[] strArr) {
        Bundle bundle = new Bundle();
        if (strArr.length > 0) {
            bundle.putString("scope", TextUtils.join(",", strArr));
        }
        CookieSyncManager.createInstance(activity);
        m30a(activity, "oauth", bundle, new C0042g(this));
    }

    /* renamed from: a */
    public void m26a(int i, int i2, Intent intent) {
        if (i == this.f12i) {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("error");
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra("error_type");
                }
                if (stringExtra != null) {
                    if ("service_disabled".equals(stringExtra) || "AndroidAuthKillSwitchException".equals(stringExtra)) {
                        Log.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
                        m20a(this.f10g, this.f11h);
                        return;
                    } else if ("access_denied".equals(stringExtra) || "OAuthAccessDeniedException".equals(stringExtra)) {
                        Log.d("Facebook-authorize", "Login canceled by user.");
                        this.f13j.mo15a();
                        return;
                    } else {
                        Log.d("Facebook-authorize", "Login failed: " + stringExtra);
                        this.f13j.mo18a(new C0047l(stringExtra));
                        return;
                    }
                }
                m31a(intent.getStringExtra("access_token"));
                m34b(intent.getStringExtra("expires_in"));
                if (m32a()) {
                    Log.d("Facebook-authorize", "Login Success! access_token=" + m33b() + " expires=" + m35c());
                    this.f13j.mo16a(intent.getExtras());
                    return;
                } else {
                    this.f13j.mo18a(new C0047l("Failed to receive access token."));
                    return;
                }
            }
            if (i2 == 0) {
                if (intent != null) {
                    Log.d("Facebook-authorize", "Login failed: " + intent.getStringExtra("error"));
                    this.f13j.mo17a(new C0046k(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                } else {
                    Log.d("Facebook-authorize", "Login canceled by user.");
                    this.f13j.mo15a();
                }
            }
        }
    }

    /* renamed from: a */
    public String m23a(Context context) {
        C0036a.m6a(context);
        Bundle bundle = new Bundle();
        bundle.putString("method", "auth.expireSession");
        String strM24a = m24a(bundle);
        m31a((String) null);
        m27a(0L);
        return strM24a;
    }

    /* renamed from: a */
    public String m24a(Bundle bundle) {
        if (!bundle.containsKey("method")) {
            throw new IllegalArgumentException("API method must be specified. (parameters must contain key \"method\" and value). See http://developers.facebook.com/docs/reference/rest/");
        }
        return m25a((String) null, bundle, "GET");
    }

    /* renamed from: a */
    public String m25a(String str, Bundle bundle, String str2) {
        bundle.putString("format", "json");
        if (m32a()) {
            bundle.putString("access_token", m33b());
        }
        return C0036a.m5a(str != null ? f5b + str : f6c, str2, bundle);
    }

    /* renamed from: a */
    public void m30a(Context context, String str, Bundle bundle, InterfaceC0041f interfaceC0041f) {
        String str2 = f4a + str;
        bundle.putString("display", "touch");
        bundle.putString("redirect_uri", "fbconnect://success");
        if ("oauth".equals(str)) {
            bundle.putString("type", "user_agent");
            bundle.putString("client_id", this.f9f);
        } else {
            bundle.putString("app_id", this.f9f);
        }
        if (m32a()) {
            bundle.putString("access_token", m33b());
        }
        String str3 = str2 + "?" + C0036a.m2a(bundle);
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            C0036a.m7a(context, Config.EXTRA_ERROR, "Application requires permission to access the Internet");
        } else {
            new DialogC0045j(context, str3, interfaceC0041f).show();
        }
    }

    /* renamed from: a */
    public boolean m32a() {
        return m33b() != null && (m35c() == 0 || System.currentTimeMillis() < m35c());
    }

    /* renamed from: b */
    public String m33b() {
        return this.f7d;
    }

    /* renamed from: c */
    public long m35c() {
        return this.f8e;
    }

    /* renamed from: a */
    public void m31a(String str) {
        this.f7d = str;
    }

    /* renamed from: a */
    public void m27a(long j) {
        this.f8e = j;
    }

    /* renamed from: b */
    public void m34b(String str) {
        if (str != null && !str.equals("0")) {
            m27a(System.currentTimeMillis() + (Integer.parseInt(str) * 1000));
        }
    }
}
