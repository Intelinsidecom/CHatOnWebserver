package com.facebook.p009c;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.C0061ab;
import com.facebook.C0065af;
import com.facebook.C0179x;
import com.facebook.p007a.C0059f;
import com.facebook.p008b.C0105s;

/* compiled from: WebDialog.java */
/* renamed from: com.facebook.c.u */
/* loaded from: classes.dex */
class C0153u extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ DialogC0147o f353a;

    private C0153u(DialogC0147o dialogC0147o) {
        this.f353a = dialogC0147o;
    }

    /* synthetic */ C0153u(DialogC0147o dialogC0147o, DialogInterfaceOnCancelListenerC0148p dialogInterfaceOnCancelListenerC0148p) {
        this(dialogC0147o);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) throws NumberFormatException {
        int i;
        C0105s.m271a("FacebookSDK.WebDialog", "Redirect URL: " + str);
        if (str.startsWith("fbconnect://success")) {
            Bundle bundleM110b = C0059f.m110b(str);
            String string = bundleM110b.getString("error");
            if (string == null) {
                string = bundleM110b.getString("error_type");
            }
            String string2 = bundleM110b.getString("error_msg");
            if (string2 == null) {
                string2 = bundleM110b.getString("error_description");
            }
            String string3 = bundleM110b.getString("error_code");
            if (C0105s.m273a(string3)) {
                i = -1;
            } else {
                try {
                    i = Integer.parseInt(string3);
                } catch (NumberFormatException e) {
                    i = -1;
                }
            }
            if (C0105s.m273a(string) && C0105s.m273a(string2) && i == -1) {
                this.f353a.m446a(bundleM110b);
            } else if (string != null && (string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) {
                this.f353a.m444a();
            } else {
                this.f353a.m450a(new C0065af(new C0061ab(i, string, string2), string2));
            }
            this.f353a.dismiss();
            return true;
        }
        if (str.startsWith("fbconnect://cancel")) {
            this.f353a.m444a();
            this.f353a.dismiss();
            return true;
        }
        if (str.contains("touch")) {
            return false;
        }
        this.f353a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f353a.m450a(new C0179x(str, i, str2));
        this.f353a.dismiss();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        this.f353a.m450a(new C0179x(null, -11, null));
        sslErrorHandler.cancel();
        this.f353a.dismiss();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        C0105s.m271a("FacebookSDK.WebDialog", "Webview loading URL: " + str);
        super.onPageStarted(webView, str, bitmap);
        if (!this.f353a.f342h) {
            this.f353a.f338d.show();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (!this.f353a.f342h) {
            this.f353a.f338d.dismiss();
        }
        this.f353a.f340f.setBackgroundColor(0);
        this.f353a.f337c.setVisibility(0);
        this.f353a.f339e.setVisibility(0);
    }
}
