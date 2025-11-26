package com.sec.chaton.samsungaccount;

import android.graphics.Bitmap;
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

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.j */
/* loaded from: classes.dex */
public class C2362j extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ FragmentSamsungAccountLogin f8819a;

    /* renamed from: b */
    private boolean f8820b = false;

    public C2362j(FragmentSamsungAccountLogin fragmentSamsungAccountLogin) {
        this.f8819a = fragmentSamsungAccountLogin;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C3250y.m11450b("shouldOverrideUrlLoading, url : " + str, getClass().getSimpleName());
        this.f8820b = true;
        List<NameValuePair> list = URLEncodedUtils.parse(URI.create(str), "utf-8");
        C3250y.m11450b("params :" + list, getClass().getSimpleName());
        for (NameValuePair nameValuePair : list) {
            if (nameValuePair.getName().equals("code")) {
                this.f8819a.f8634a.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("code_expires_in")) {
                this.f8819a.f8634a.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("error")) {
                this.f8819a.f8635b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("error_code")) {
                this.f8819a.f8635b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("code_expires_in")) {
                this.f8819a.f8635b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("error_description")) {
                this.f8819a.f8635b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("close")) {
                this.f8819a.f8645l = true;
            }
            C3250y.m11450b("Name :" + nameValuePair.getName() + " value : " + nameValuePair.getValue(), getClass().getSimpleName());
        }
        if (this.f8819a.f8634a.size() != 0) {
            this.f8819a.f8640g.m5616a(this.f8819a.f8634a.get(0), "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
        } else if (this.f8819a.f8635b.size() != 0) {
            AbstractC3271a.m11494a(this.f8819a.f8637d).mo11500a(this.f8819a.getResources().getString(R.string.toast_error)).mo11509b(this.f8819a.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2363k(this)).mo11505a().show();
        } else if (this.f8819a.f8645l) {
            this.f8819a.f8645l = false;
            this.f8819a.m8690a();
        } else {
            this.f8820b = false;
            C3250y.m11455d("url has no regular data", getClass().getSimpleName());
            webView.loadUrl(str);
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        C3250y.m11450b("onPageFinished...", getClass().getSimpleName());
        if (!this.f8820b) {
            List<NameValuePair> list = URLEncodedUtils.parse(URI.create(str), "utf-8");
            C3250y.m11450b("[HoneyComb] params : " + list + " url : " + str, getClass().getSimpleName());
            for (NameValuePair nameValuePair : list) {
                if (nameValuePair.getName().equals("code")) {
                    this.f8819a.f8634a.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("code_expires_in")) {
                    this.f8819a.f8634a.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("error")) {
                    this.f8819a.f8635b.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("error_code")) {
                    this.f8819a.f8635b.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("code_expires_in")) {
                    this.f8819a.f8635b.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("error_description")) {
                    this.f8819a.f8635b.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("close")) {
                    this.f8819a.f8645l = true;
                }
                C3250y.m11450b("Name :" + nameValuePair.getName() + " value : " + nameValuePair.getValue(), getClass().getSimpleName());
            }
            if (this.f8819a.f8634a.size() != 0) {
                webView.setVisibility(8);
                this.f8819a.f8640g.m5616a(this.f8819a.f8634a.get(0), "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
                return;
            }
            if (this.f8819a.f8635b.size() == 0) {
                if (this.f8819a.f8645l) {
                    this.f8819a.f8645l = false;
                    m8834a();
                    webView.setVisibility(8);
                    this.f8819a.m8690a();
                    return;
                }
                m8834a();
                C3250y.m11455d("url has no regular data", getClass().getSimpleName());
                return;
            }
            m8834a();
            webView.setVisibility(8);
            AbstractC3271a.m11494a(this.f8819a.f8637d).mo11500a(this.f8819a.getResources().getString(R.string.toast_error)).mo11509b(this.f8819a.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2364l(this)).mo11505a().show();
            return;
        }
        this.f8820b = false;
        if (this.f8819a.f8638e != null && this.f8819a.f8638e.isShowing()) {
            if (this.f8819a.f8634a.size() == 0) {
                this.f8819a.f8638e.dismiss();
            }
            C3250y.m11450b("onPageFinished pd dismissed", getClass().getSimpleName());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        C3250y.m11450b("onPageStarted... url : " + str, getClass().getSimpleName());
        if (this.f8819a.f8638e != null && !this.f8819a.f8638e.isShowing()) {
            this.f8819a.f8638e = ProgressDialogC3265l.m11489a(this.f8819a.f8637d, null, this.f8819a.getResources().getString(R.string.dialog_provision_ing));
        }
    }

    /* renamed from: a */
    private void m8834a() {
        if (this.f8819a.f8638e != null && this.f8819a.f8638e.isShowing()) {
            if (this.f8819a.f8634a.size() == 0) {
                this.f8819a.f8638e.dismiss();
            }
            C3250y.m11450b("onPageFinished pd dismissed", getClass().getSimpleName());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        webView.setVisibility(8);
        super.onReceivedError(webView, i, str, str2);
        C3250y.m11450b("errorCode=" + i + " failingUrl = " + str2 + " desctiption = " + str, getClass().getSimpleName());
        AbstractC3271a.m11494a(this.f8819a.f8637d).mo11500a(this.f8819a.getResources().getString(R.string.toast_error)).mo11509b(this.f8819a.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2365m(this)).mo11505a().show();
    }
}
