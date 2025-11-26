package com.sec.chaton.api;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.sec.chaton.R;
import com.sec.chaton.p067j.C2433c;
import com.sec.chaton.registration.AuthenticatorActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4867ce;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.chaton.widget.ProgressDialogC4926s;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class AuthorizeFragment extends Fragment {

    /* renamed from: a */
    private static final String f3301a = AuthorizeFragment.class.getSimpleName();

    /* renamed from: b */
    private static final String f3302b = Charset.forName("UTF-8").name();

    /* renamed from: c */
    private Activity f3303c;

    /* renamed from: d */
    private WebView f3304d;

    /* renamed from: e */
    private ViewStub f3305e;

    /* renamed from: f */
    private ProgressDialogC4926s f3306f;

    /* renamed from: g */
    private ProgressDialogC4926s f3307g;

    /* renamed from: h */
    private ExecutorService f3308h;

    /* renamed from: i */
    private C1018a f3309i;

    /* renamed from: j */
    private String f3310j;

    /* renamed from: k */
    private String f3311k;

    /* renamed from: l */
    private boolean f3312l = false;

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3303c = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C4809aa.m18104a().m18129b("uid")) {
            Intent intent = new Intent(this.f3303c, (Class<?>) AuthenticatorActivity.class);
            intent.putExtra("key_skip_contact_sync", true);
            startActivityForResult(intent, 0);
        }
        this.f3306f = new ProgressDialogC4926s(this.f3303c, false);
        this.f3306f.setMessage(this.f3303c.getString(R.string.dialog_connecting_server));
        this.f3307g = new ProgressDialogC4926s(this.f3303c, false);
        this.f3307g.setMessage(this.f3303c.getString(R.string.buddy_list_progress_dialog_message));
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f3308h = Executors.newSingleThreadExecutor();
        Uri data = this.f3303c.getIntent().getData();
        if (data == null) {
            throw new IllegalArgumentException("The data of intent is null.");
        }
        try {
            this.f3310j = m6095a(data, VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, f3302b);
            this.f3311k = m6095a(data, "redirect_uri", f3302b);
            if (C4904y.f17872b) {
                C4904y.m18639b("ClientId: " + this.f3310j + ", RedirectUri: " + this.f3311k, f3301a);
            }
            View viewInflate = layoutInflater.inflate(R.layout.layout_authorize, viewGroup, false);
            this.f3304d = (WebView) viewInflate.findViewById(R.id.webview);
            if (C4809aa.m18104a().m18129b("uid")) {
                try {
                    m6103b(this.f3310j, this.f3311k);
                } catch (UnsupportedEncodingException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, f3301a);
                    }
                    m6097a(0);
                }
            }
            this.f3305e = (ViewStub) viewInflate.findViewById(R.id.no_contents);
            return viewInflate;
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            if (i2 == -1) {
                try {
                    m6103b(this.f3310j, this.f3311k);
                    return;
                } catch (UnsupportedEncodingException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, f3301a);
                        return;
                    }
                    return;
                }
            }
            m6097a(0);
            return;
        }
        if (i == 1) {
            if (i2 == -1) {
                try {
                    this.f3312l = true;
                    m6103b(this.f3310j, this.f3311k);
                    return;
                } catch (UnsupportedEncodingException e2) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e2, f3301a);
                        return;
                    }
                    return;
                }
            }
            m6097a(0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroy();
        this.f3308h.shutdown();
        if (this.f3309i != null) {
            this.f3309i.m19058a(true);
        }
        if (this.f3306f.isShowing()) {
            this.f3306f.dismiss();
        }
        if (this.f3307g.isShowing()) {
            this.f3307g.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3303c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public Map<String, String> m6105c() {
        HashMap map = new HashMap();
        if (Build.VERSION.SDK_INT <= 10) {
            map.put("accept", "text/html");
        } else {
            map.put("Accept", "text/html");
        }
        map.put("Content-Type", "text/html");
        map.put("Authorization", "Basic " + Base64.encodeToString((C4809aa.m18104a().m18121a("uid", "") + ":" + C4822an.m18228d()).getBytes(), 2));
        if (C4904y.f17872b) {
            for (Map.Entry entry : map.entrySet()) {
                C4904y.m18639b("Header: " + ((String) entry.getKey()) + ": " + ((String) entry.getValue()), f3301a);
            }
        }
        return map;
    }

    /* renamed from: a */
    private String m6096a(String str, String str2) {
        String str3 = "http://stg.contact.samsungchaton.com/oauth/authorize?client_id=" + URLEncoder.encode(str, "UTF-8") + "&redirect_uri=" + URLEncoder.encode(str2, "UTF-8") + "&response_type=code&hasSamsungAccount=" + this.f3312l;
        String str4 = m6094a() + "/oauth/authorize?" + VKOpenAuthActivity.VK_EXTRA_CLIENT_ID + "=" + URLEncoder.encode(str, "UTF-8") + "&redirect_uri=" + URLEncoder.encode(str2, "UTF-8") + "&response_type=code&hasSamsungAccount=" + this.f3312l;
        if (C4904y.f17872b) {
            C4904y.m18639b("URL: " + str3, f3301a);
        }
        return str3;
    }

    /* renamed from: a */
    private String m6095a(Uri uri, String str, String str2) {
        if (str == null) {
            throw new NullPointerException("key");
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return "";
        }
        int length = encodedQuery.length();
        int i = 0;
        while (true) {
            int iIndexOf = encodedQuery.indexOf(38, i);
            int i2 = iIndexOf != -1 ? iIndexOf : length;
            int iIndexOf2 = encodedQuery.indexOf(61, i);
            if (iIndexOf2 > i2 || iIndexOf2 == -1) {
                iIndexOf2 = i2;
            }
            if (iIndexOf2 - i == str.length() && encodedQuery.regionMatches(i, str, 0, str.length())) {
                if (iIndexOf2 == i2) {
                    return "";
                }
                return URLDecoder.decode(encodedQuery.substring(iIndexOf2 + 1, i2), str2);
            }
            if (iIndexOf != -1) {
                i = iIndexOf + 1;
            } else {
                return "";
            }
        }
    }

    /* renamed from: b */
    private void m6103b(String str, String str2) {
        String strM6096a = m6096a(str, str2);
        if (C4904y.f17872b) {
            C4904y.m18639b("Open 3rd party application allow page. URL: " + strM6096a, f3301a);
        }
        this.f3304d.loadUrl(strM6096a, m6105c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6097a(int i) {
        m6098a(i, (Intent) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6098a(int i, Intent intent) {
        if (intent != null) {
            this.f3303c.setResult(i, intent);
        } else {
            this.f3303c.setResult(i);
        }
        this.f3303c.finish();
    }

    /* renamed from: a */
    public static String m6094a() {
        String strM10534a = C2433c.m10534a(EnumC4867ce.PRIMARY, EnumC4868cf.LIVE_MOBILEWEB);
        String strM10534a2 = C2433c.m10534a(EnumC4867ce.SECONDARY, EnumC4868cf.LIVE_MOBILEWEB);
        if (C4904y.f17872b) {
            C4904y.m18639b("getAuthServerAddress(), GLD primary : " + strM10534a, f3301a);
            C4904y.m18639b("getAuthServerAddress(), GLD secondary : " + strM10534a2, f3301a);
            C4904y.m18639b("getAuthServerAddress(), GLD default : http://smm.samsung.com", f3301a);
        }
        if (TextUtils.isEmpty(strM10534a)) {
            return !TextUtils.isEmpty(strM10534a2) ? strM10534a2 : "http://smm.samsung.com";
        }
        return strM10534a;
    }
}
