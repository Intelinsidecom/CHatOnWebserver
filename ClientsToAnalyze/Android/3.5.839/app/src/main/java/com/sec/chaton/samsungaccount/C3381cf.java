package com.sec.chaton.samsungaccount;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import java.net.URI;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.cf */
/* loaded from: classes.dex */
class C3381cf extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ DialogC3368bt f12339a;

    /* renamed from: b */
    private boolean f12340b;

    private C3381cf(DialogC3368bt dialogC3368bt) {
        this.f12339a = dialogC3368bt;
        this.f12340b = false;
    }

    /* synthetic */ C3381cf(DialogC3368bt dialogC3368bt, DialogInterfaceOnCancelListenerC3369bu dialogInterfaceOnCancelListenerC3369bu) {
        this(dialogC3368bt);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C4904y.m18639b("shouldOverrideUrlLoading, url : " + str, getClass().getSimpleName());
        this.f12340b = true;
        m13215a(webView, str, false);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        C4904y.m18639b("onPageFinished, url : " + str, getClass().getSimpleName());
        if (!this.f12340b) {
            m13215a(webView, str, true);
            return;
        }
        this.f12340b = false;
        if (this.f12339a.f12321o != null && this.f12339a.f12321o.isShowing()) {
            if (this.f12339a.f12307a.size() == 0) {
                this.f12339a.f12321o.dismiss();
            }
            C4904y.m18639b("onPageFinished pd dismissed", getClass().getSimpleName());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        C4904y.m18639b("onPageStarted... url : " + str, getClass().getSimpleName());
        if (this.f12339a.f12321o != null || this.f12339a.f12319m == null) {
            if (this.f12339a.f12321o != null && !this.f12339a.f12321o.isShowing()) {
                this.f12339a.f12321o.show();
                return;
            }
            return;
        }
        this.f12339a.f12321o = ProgressDialogC4926s.m18727a(this.f12339a.f12319m, null, this.f12339a.f12319m.getResources().getString(R.string.dialog_provision_ing));
    }

    /* renamed from: a */
    private void m13214a() {
        if (this.f12339a.f12321o != null && this.f12339a.f12321o.isShowing()) {
            if (this.f12339a.f12307a.size() == 0) {
                this.f12339a.f12321o.dismiss();
            }
            C4904y.m18639b("onPageFinished pd dismissed", getClass().getSimpleName());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        webView.setVisibility(8);
        super.onReceivedError(webView, i, str, str2);
        C4904y.m18639b("errorCode=" + i + " failingUrl = " + str2 + " desctiption = " + str, getClass().getSimpleName());
        InterfaceC4936e interfaceC4936eMo18745a = AbstractC4932a.m18733a(this.f12339a.f12319m).mo18740a(this.f12339a.f12319m.getResources().getString(R.string.toast_error)).mo18749b(this.f12339a.f12319m.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3382cg(this)).mo18745a();
        interfaceC4936eMo18745a.setCancelable(false);
        if (!this.f12339a.f12324r) {
            interfaceC4936eMo18745a.show();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        if (C4904y.f17872b) {
            C4904y.m18639b("[onReceivedSslError] view=" + webView + " handler = " + sslErrorHandler + " error = " + sslError, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m13215a(WebView webView, String str, boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("parsingURL, isFinishPage : " + z, getClass().getSimpleName());
        }
        List<NameValuePair> list = URLEncodedUtils.parse(URI.create(str), "utf-8");
        C4904y.m18639b("params :" + list, getClass().getSimpleName());
        for (NameValuePair nameValuePair : list) {
            if (nameValuePair.getName().equals("code")) {
                this.f12339a.f12307a.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("code_expires_in")) {
                this.f12339a.f12307a.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("error")) {
                this.f12339a.f12308b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals(VKApiConst.ERROR_CODE)) {
                this.f12339a.f12308b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("code_expires_in")) {
                this.f12339a.f12308b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("error_description")) {
                this.f12339a.f12308b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("close")) {
                this.f12339a.f12323q = true;
            }
            C4904y.m18639b("Name :" + nameValuePair.getName() + " value : " + nameValuePair.getValue(), getClass().getSimpleName());
        }
        if (this.f12339a.f12307a.size() != 0) {
            if (z) {
                webView.setVisibility(8);
            }
            this.f12339a.f12317k.m9389a(this.f12339a.f12307a.get(0), "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
            return;
        }
        if (this.f12339a.f12308b.size() == 0) {
            if (this.f12339a.f12323q) {
                this.f12339a.f12323q = false;
                if (z) {
                    m13214a();
                    webView.setVisibility(8);
                }
                this.f12339a.m13203b();
                return;
            }
            C4904y.m18645d("url has no regular data", getClass().getSimpleName());
            this.f12339a.f12322p.setVisibility(0);
            if (z) {
                m13214a();
                return;
            } else {
                this.f12340b = false;
                webView.loadUrl(str);
                return;
            }
        }
        if (z) {
            m13214a();
            webView.setVisibility(8);
        }
        InterfaceC4936e interfaceC4936eMo18745a = AbstractC4932a.m18733a(this.f12339a.f12319m).mo18740a(this.f12339a.f12319m.getResources().getString(R.string.toast_error)).mo18749b(this.f12339a.f12319m.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3383ch(this, z)).mo18745a();
        interfaceC4936eMo18745a.setCancelable(false);
        if (!this.f12339a.f12324r) {
            interfaceC4936eMo18745a.show();
        }
    }
}
