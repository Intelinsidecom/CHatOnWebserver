package com.facebook.p033c;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.C0432ab;
import com.facebook.C0436af;
import com.facebook.C0550x;
import com.facebook.p031a.C0430f;
import com.facebook.p032b.C0476s;
import com.p137vk.sdk.api.VKApiConst;

/* compiled from: WebDialog.java */
/* renamed from: com.facebook.c.u */
/* loaded from: classes.dex */
class C0524u extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ DialogC0518o f1323a;

    private C0524u(DialogC0518o dialogC0518o) {
        this.f1323a = dialogC0518o;
    }

    /* synthetic */ C0524u(DialogC0518o dialogC0518o, DialogInterfaceOnCancelListenerC0519p dialogInterfaceOnCancelListenerC0519p) {
        this(dialogC0518o);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) throws NumberFormatException {
        int i;
        C0476s.m1715a("FacebookSDK.WebDialog", "Redirect URL: " + str);
        if (str.startsWith("fbconnect://success")) {
            Bundle bundleM1553b = C0430f.m1553b(str);
            String string = bundleM1553b.getString("error");
            if (string == null) {
                string = bundleM1553b.getString("error_type");
            }
            String string2 = bundleM1553b.getString(VKApiConst.ERROR_MSG);
            if (string2 == null) {
                string2 = bundleM1553b.getString("error_description");
            }
            String string3 = bundleM1553b.getString(VKApiConst.ERROR_CODE);
            if (C0476s.m1717a(string3)) {
                i = -1;
            } else {
                try {
                    i = Integer.parseInt(string3);
                } catch (NumberFormatException e) {
                    i = -1;
                }
            }
            if (C0476s.m1717a(string) && C0476s.m1717a(string2) && i == -1) {
                this.f1323a.m1889a(bundleM1553b);
            } else if (string != null && (string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) {
                this.f1323a.m1887a();
            } else {
                this.f1323a.m1893a(new C0436af(new C0432ab(i, string, string2), string2));
            }
            this.f1323a.dismiss();
            return true;
        }
        if (str.startsWith("fbconnect://cancel")) {
            this.f1323a.m1887a();
            this.f1323a.dismiss();
            return true;
        }
        if (str.contains("touch")) {
            return false;
        }
        this.f1323a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f1323a.m1893a(new C0550x(str, i, str2));
        this.f1323a.dismiss();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        this.f1323a.m1893a(new C0550x(null, -11, null));
        sslErrorHandler.cancel();
        this.f1323a.dismiss();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        C0476s.m1715a("FacebookSDK.WebDialog", "Webview loading URL: " + str);
        super.onPageStarted(webView, str, bitmap);
        if (!this.f1323a.f1311h) {
            this.f1323a.f1307d.show();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (!this.f1323a.f1311h) {
            this.f1323a.f1307d.dismiss();
        }
        this.f1323a.f1309f.setBackgroundColor(0);
        this.f1323a.f1306c.setVisibility(0);
        this.f1323a.f1308e.setVisibility(0);
    }
}
