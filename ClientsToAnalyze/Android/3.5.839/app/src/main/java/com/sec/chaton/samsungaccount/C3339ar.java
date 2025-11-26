package com.sec.chaton.samsungaccount;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;
import java.net.URI;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.ar */
/* loaded from: classes.dex */
public class C3339ar extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ FragmentSamsungAccountLogin f12276a;

    /* renamed from: b */
    private boolean f12277b = false;

    public C3339ar(FragmentSamsungAccountLogin fragmentSamsungAccountLogin) {
        this.f12276a = fragmentSamsungAccountLogin;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C4904y.m18639b("shouldOverrideUrlLoading, url : " + str, getClass().getSimpleName());
        this.f12277b = true;
        List<NameValuePair> list = URLEncodedUtils.parse(URI.create(str), "utf-8");
        C4904y.m18639b("params :" + list, getClass().getSimpleName());
        for (NameValuePair nameValuePair : list) {
            if (nameValuePair.getName().equals("code")) {
                this.f12276a.f12178a.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("code_expires_in")) {
                this.f12276a.f12178a.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("error")) {
                this.f12276a.f12179b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals(VKApiConst.ERROR_CODE)) {
                this.f12276a.f12179b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("code_expires_in")) {
                this.f12276a.f12179b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("error_description")) {
                this.f12276a.f12179b.add(nameValuePair.getValue());
            } else if (nameValuePair.getName().equals("close")) {
                this.f12276a.f12189l = true;
            }
            C4904y.m18639b("Name :" + nameValuePair.getName() + " value : " + nameValuePair.getValue(), getClass().getSimpleName());
        }
        if (this.f12276a.f12178a.size() != 0) {
            this.f12276a.f12184g.m9389a(this.f12276a.f12178a.get(0), "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
        } else if (this.f12276a.f12179b.size() != 0) {
            AbstractC4932a.m18733a(this.f12276a.f12181d).mo18740a(this.f12276a.getResources().getString(R.string.toast_error)).mo18749b(this.f12276a.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3340as(this)).mo18745a().show();
        } else if (this.f12276a.f12189l) {
            this.f12276a.f12189l = false;
            this.f12276a.m13154a();
        } else {
            this.f12277b = false;
            C4904y.m18645d("url has no regular data", getClass().getSimpleName());
            webView.loadUrl(str);
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        C4904y.m18639b("onPageFinished...", getClass().getSimpleName());
        if (!this.f12277b) {
            List<NameValuePair> list = URLEncodedUtils.parse(URI.create(str), "utf-8");
            C4904y.m18639b("[HoneyComb] params : " + list + " url : " + str, getClass().getSimpleName());
            for (NameValuePair nameValuePair : list) {
                if (nameValuePair.getName().equals("code")) {
                    this.f12276a.f12178a.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("code_expires_in")) {
                    this.f12276a.f12178a.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("error")) {
                    this.f12276a.f12179b.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals(VKApiConst.ERROR_CODE)) {
                    this.f12276a.f12179b.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("code_expires_in")) {
                    this.f12276a.f12179b.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("error_description")) {
                    this.f12276a.f12179b.add(nameValuePair.getValue());
                } else if (nameValuePair.getName().equals("close")) {
                    this.f12276a.f12189l = true;
                }
                C4904y.m18639b("Name :" + nameValuePair.getName() + " value : " + nameValuePair.getValue(), getClass().getSimpleName());
            }
            if (this.f12276a.f12178a.size() != 0) {
                webView.setVisibility(8);
                this.f12276a.f12184g.m9389a(this.f12276a.f12178a.get(0), "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
                return;
            }
            if (this.f12276a.f12179b.size() == 0) {
                if (this.f12276a.f12189l) {
                    this.f12276a.f12189l = false;
                    m13195a();
                    webView.setVisibility(8);
                    this.f12276a.m13154a();
                    return;
                }
                m13195a();
                C4904y.m18645d("url has no regular data", getClass().getSimpleName());
                return;
            }
            m13195a();
            webView.setVisibility(8);
            AbstractC4932a.m18733a(this.f12276a.f12181d).mo18740a(this.f12276a.getResources().getString(R.string.toast_error)).mo18749b(this.f12276a.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3341at(this)).mo18745a().show();
            return;
        }
        this.f12277b = false;
        if (this.f12276a.f12182e != null && this.f12276a.f12182e.isShowing()) {
            if (this.f12276a.f12178a.size() == 0) {
                this.f12276a.f12182e.dismiss();
            }
            C4904y.m18639b("onPageFinished pd dismissed", getClass().getSimpleName());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        C4904y.m18639b("onPageStarted... url : " + str, getClass().getSimpleName());
        if (this.f12276a.f12182e != null && !this.f12276a.f12182e.isShowing()) {
            this.f12276a.f12182e = ProgressDialogC4926s.m18727a(this.f12276a.f12181d, null, this.f12276a.getResources().getString(R.string.dialog_provision_ing));
        }
    }

    /* renamed from: a */
    private void m13195a() {
        if (this.f12276a.f12182e != null && this.f12276a.f12182e.isShowing()) {
            if (this.f12276a.f12178a.size() == 0) {
                this.f12276a.f12182e.dismiss();
            }
            C4904y.m18639b("onPageFinished pd dismissed", getClass().getSimpleName());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        webView.setVisibility(8);
        super.onReceivedError(webView, i, str, str2);
        C4904y.m18639b("errorCode=" + i + " failingUrl = " + str2 + " desctiption = " + str, getClass().getSimpleName());
        AbstractC4932a.m18733a(this.f12276a.f12181d).mo18740a(this.f12276a.getResources().getString(R.string.toast_error)).mo18749b(this.f12276a.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3342au(this)).mo18745a().show();
    }
}
