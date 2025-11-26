package com.sec.chaton.samsungaccount;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import java.net.URI;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bm */
/* loaded from: classes.dex */
class C2351bm extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ DialogC2339ba f8805a;

    /* renamed from: b */
    private boolean f8806b;

    private C2351bm(DialogC2339ba dialogC2339ba) {
        this.f8805a = dialogC2339ba;
        this.f8806b = false;
    }

    /* synthetic */ C2351bm(DialogC2339ba dialogC2339ba, DialogInterfaceOnCancelListenerC2340bb dialogInterfaceOnCancelListenerC2340bb) {
        this(dialogC2339ba);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C3250y.m11450b("shouldOverrideUrlLoading, url : " + str, getClass().getSimpleName());
        this.f8806b = true;
        List<NameValuePair> list = URLEncodedUtils.parse(URI.create(str), "utf-8");
        C3250y.m11450b("params :" + list, getClass().getSimpleName());
        for (NameValuePair nameValuePair : list) {
            if (nameValuePair.getName().equals("code")) {
                this.f8805a.f8775a.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("code_expires_in")) {
                this.f8805a.f8775a.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("error")) {
                this.f8805a.f8776b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("error_code")) {
                this.f8805a.f8776b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("code_expires_in")) {
                this.f8805a.f8776b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("error_description")) {
                this.f8805a.f8776b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("close")) {
                this.f8805a.f8791q = true;
            }
            C3250y.m11450b("Name :" + nameValuePair.getName() + " value : " + nameValuePair.getValue(), getClass().getSimpleName());
        }
        if (this.f8805a.f8775a.size() != 0) {
            this.f8805a.f8785k.m5616a(this.f8805a.f8775a.get(0), "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
        } else if (this.f8805a.f8776b.size() != 0) {
            AbstractC3271a.m11494a(this.f8805a.f8787m).mo11500a(this.f8805a.f8787m.getResources().getString(R.string.toast_error)).mo11509b(this.f8805a.f8787m.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2352bn(this)).mo11505a().show();
        } else if (this.f8805a.f8791q) {
            this.f8805a.f8791q = false;
            this.f8805a.m8824b();
        } else {
            this.f8806b = false;
            C3250y.m11455d("url has no regular data", getClass().getSimpleName());
            this.f8805a.f8790p.setVisibility(0);
            webView.loadUrl(str);
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        C3250y.m11450b("onPageFinished...", getClass().getSimpleName());
        if (!this.f8806b) {
            List<NameValuePair> list = URLEncodedUtils.parse(URI.create(str), "utf-8");
            C3250y.m11450b("[HoneyComb] params : " + list + " url : " + str, getClass().getSimpleName());
            for (NameValuePair nameValuePair : list) {
                if (nameValuePair.getName().equals("code")) {
                    this.f8805a.f8775a.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("code_expires_in")) {
                    this.f8805a.f8775a.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("error")) {
                    this.f8805a.f8776b.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("error_code")) {
                    this.f8805a.f8776b.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("code_expires_in")) {
                    this.f8805a.f8776b.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("error_description")) {
                    this.f8805a.f8776b.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("close")) {
                    this.f8805a.f8791q = true;
                }
                C3250y.m11450b("Name :" + nameValuePair.getName() + " value : " + nameValuePair.getValue(), getClass().getSimpleName());
            }
            if (this.f8805a.f8775a.size() != 0) {
                webView.setVisibility(8);
                this.f8805a.f8785k.m5616a(this.f8805a.f8775a.get(0), "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
                return;
            }
            if (this.f8805a.f8776b.size() == 0) {
                if (this.f8805a.f8791q) {
                    this.f8805a.f8791q = false;
                    m8833a();
                    webView.setVisibility(8);
                    this.f8805a.m8824b();
                    return;
                }
                m8833a();
                C3250y.m11455d("url has no regular data", getClass().getSimpleName());
                this.f8805a.f8790p.setVisibility(0);
                return;
            }
            m8833a();
            webView.setVisibility(8);
            AbstractC3271a.m11494a(this.f8805a.f8787m).mo11500a(this.f8805a.f8787m.getResources().getString(R.string.toast_error)).mo11509b(this.f8805a.f8787m.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2353bo(this)).mo11505a().show();
            return;
        }
        this.f8806b = false;
        if (this.f8805a.f8789o != null && this.f8805a.f8789o.isShowing()) {
            if (this.f8805a.f8775a.size() == 0) {
                this.f8805a.f8789o.dismiss();
            }
            C3250y.m11450b("onPageFinished pd dismissed", getClass().getSimpleName());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        C3250y.m11450b("onPageStarted... url : " + str, getClass().getSimpleName());
        if (this.f8805a.f8789o != null) {
            if (!this.f8805a.f8789o.isShowing()) {
                this.f8805a.f8789o.show();
            }
        } else {
            this.f8805a.f8789o = ProgressDialogC3265l.m11489a(this.f8805a.f8787m, null, this.f8805a.f8787m.getResources().getString(R.string.dialog_provision_ing));
        }
    }

    /* renamed from: a */
    private void m8833a() {
        if (this.f8805a.f8789o != null && this.f8805a.f8789o.isShowing()) {
            if (this.f8805a.f8775a.size() == 0) {
                this.f8805a.f8789o.dismiss();
            }
            C3250y.m11450b("onPageFinished pd dismissed", getClass().getSimpleName());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        webView.setVisibility(8);
        super.onReceivedError(webView, i, str, str2);
        C3250y.m11450b("errorCode=" + i + " failingUrl = " + str2 + " desctiption = " + str, getClass().getSimpleName());
        AbstractC3271a.m11494a(this.f8805a.f8787m).mo11500a(this.f8805a.f8787m.getResources().getString(R.string.toast_error)).mo11509b(this.f8805a.f8787m.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2354bp(this)).mo11505a().show();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (C3250y.f11734b) {
            C3250y.m11450b("[onReceivedSslError] view=" + webView + " handler = " + sslErrorHandler + " error = " + sslError, getClass().getSimpleName());
        }
        sslErrorHandler.proceed();
    }
}
