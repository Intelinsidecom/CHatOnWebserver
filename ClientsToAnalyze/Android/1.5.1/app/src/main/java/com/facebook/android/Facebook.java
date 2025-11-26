package com.facebook.android;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieSyncManager;
import com.sec.pns.msg.MsgResultCode;

/* loaded from: classes.dex */
public class Facebook {

    /* renamed from: a */
    protected static String f192a = "https://m.facebook.com/dialog/";

    /* renamed from: b */
    protected static String f193b = "https://graph.facebook.com/";

    /* renamed from: c */
    protected static String f194c = "https://api.facebook.com/restserver.php";

    /* renamed from: d */
    private String f195d = null;

    /* renamed from: e */
    private long f196e = 0;

    /* renamed from: f */
    private String f197f;

    /* renamed from: g */
    private Activity f198g;

    /* renamed from: h */
    private String[] f199h;

    /* renamed from: i */
    private int f200i;

    /* renamed from: j */
    private DialogListener f201j;

    public interface DialogListener {
        /* renamed from: a */
        void mo244a();

        /* renamed from: a */
        void mo245a(Bundle bundle);

        /* renamed from: a */
        void mo246a(DialogError dialogError);

        /* renamed from: a */
        void mo247a(FacebookError facebookError);
    }

    public Facebook(String str) {
        if (str == null) {
            throw new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
        }
        this.f197f = str;
    }

    /* renamed from: a */
    private void m228a(Activity activity, String[] strArr) {
        Bundle bundle = new Bundle();
        if (strArr.length > 0) {
            bundle.putString("scope", TextUtils.join(",", strArr));
        }
        CookieSyncManager.createInstance(activity);
        m238a(activity, "oauth", bundle, new C0051d(this));
    }

    /* renamed from: a */
    private boolean m229a(Activity activity, Intent intent) {
        ResolveInfo resolveInfoResolveActivity = activity.getPackageManager().resolveActivity(intent, 0);
        if (resolveInfoResolveActivity == null) {
            return false;
        }
        try {
            for (Signature signature : activity.getPackageManager().getPackageInfo(resolveInfoResolveActivity.activityInfo.packageName, 64).signatures) {
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
    private boolean m230a(Activity activity, String str, String[] strArr, int i) {
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        intent.putExtra("client_id", str);
        if (strArr.length > 0) {
            intent.putExtra("scope", TextUtils.join(",", strArr));
        }
        if (!m229a(activity, intent)) {
            return false;
        }
        this.f198g = activity;
        this.f199h = strArr;
        this.f200i = i;
        try {
            activity.startActivityForResult(intent, i);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    /* renamed from: a */
    public String m231a(Context context) {
        Util.m264a(context);
        Bundle bundle = new Bundle();
        bundle.putString("method", "auth.expireSession");
        String strM232a = m232a(bundle);
        m239a((String) null);
        m235a(0L);
        return strM232a;
    }

    /* renamed from: a */
    public String m232a(Bundle bundle) {
        if (bundle.containsKey("method")) {
            return m233a((String) null, bundle, "GET");
        }
        throw new IllegalArgumentException("API method must be specified. (parameters must contain key \"method\" and value). See http://developers.facebook.com/docs/reference/rest/");
    }

    /* renamed from: a */
    public String m233a(String str, Bundle bundle, String str2) {
        bundle.putString("format", "json");
        if (m240a()) {
            bundle.putString("access_token", m241b());
        }
        return Util.m263a(str != null ? f193b + str : f194c, str2, bundle);
    }

    /* renamed from: a */
    public void m234a(int i, int i2, Intent intent) {
        if (i == this.f200i) {
            if (i2 != -1) {
                if (i2 == 0) {
                    if (intent != null) {
                        Log.d("Facebook-authorize", "Login failed: " + intent.getStringExtra("error"));
                        this.f201j.mo246a(new DialogError(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                        return;
                    } else {
                        Log.d("Facebook-authorize", "Login canceled by user.");
                        this.f201j.mo244a();
                        return;
                    }
                }
                return;
            }
            String stringExtra = intent.getStringExtra("error");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("error_type");
            }
            if (stringExtra == null) {
                m239a(intent.getStringExtra("access_token"));
                m242b(intent.getStringExtra("expires_in"));
                if (!m240a()) {
                    this.f201j.mo247a(new FacebookError("Failed to receive access token."));
                    return;
                } else {
                    Log.d("Facebook-authorize", "Login Success! access_token=" + m241b() + " expires=" + m243c());
                    this.f201j.mo245a(intent.getExtras());
                    return;
                }
            }
            if (stringExtra.equals("service_disabled") || stringExtra.equals("AndroidAuthKillSwitchException")) {
                Log.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
                m228a(this.f198g, this.f199h);
            } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
                Log.d("Facebook-authorize", "Login canceled by user.");
                this.f201j.mo244a();
            } else {
                Log.d("Facebook-authorize", "Login failed: " + stringExtra);
                this.f201j.mo247a(new FacebookError(stringExtra));
            }
        }
    }

    /* renamed from: a */
    public void m235a(long j) {
        this.f196e = j;
    }

    /* renamed from: a */
    public void m236a(Activity activity, String[] strArr, int i, DialogListener dialogListener) {
        this.f201j = dialogListener;
        if (i >= 0 ? m230a(activity, this.f197f, strArr, i) : false) {
            return;
        }
        m228a(activity, strArr);
    }

    /* renamed from: a */
    public void m237a(Activity activity, String[] strArr, DialogListener dialogListener) {
        m236a(activity, strArr, 32665, dialogListener);
    }

    /* renamed from: a */
    public void m238a(Context context, String str, Bundle bundle, DialogListener dialogListener) {
        String str2 = f192a + str;
        bundle.putString("display", "touch");
        bundle.putString("redirect_uri", "fbconnect://success");
        if (str.equals("oauth")) {
            bundle.putString("type", "user_agent");
            bundle.putString("client_id", this.f197f);
        } else {
            bundle.putString("app_id", this.f197f);
        }
        if (m240a()) {
            bundle.putString("access_token", m241b());
        }
        String str3 = str2 + "?" + Util.m260a(bundle);
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            Util.m265a(context, "Error", "Application requires permission to access the Internet");
        } else {
            new FbDialog(context, str3, dialogListener).show();
        }
    }

    /* renamed from: a */
    public void m239a(String str) {
        this.f195d = str;
    }

    /* renamed from: a */
    public boolean m240a() {
        return m241b() != null && (m243c() == 0 || System.currentTimeMillis() < m243c());
    }

    /* renamed from: b */
    public String m241b() {
        return this.f195d;
    }

    /* renamed from: b */
    public void m242b(String str) {
        if (str == null || str.equals("0")) {
            return;
        }
        m235a(System.currentTimeMillis() + (Integer.parseInt(str) * MsgResultCode.SUCCESS));
    }

    /* renamed from: c */
    public long m243c() {
        return this.f196e;
    }
}
