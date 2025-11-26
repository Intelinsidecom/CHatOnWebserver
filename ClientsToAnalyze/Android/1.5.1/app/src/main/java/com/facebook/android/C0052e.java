package com.facebook.android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.facebook.android.e */
/* loaded from: classes.dex */
class C0052e extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ FbDialog f217a;

    private C0052e(FbDialog fbDialog) {
        this.f217a = fbDialog;
    }

    /* synthetic */ C0052e(FbDialog fbDialog, DialogInterfaceOnCancelListenerC0048a dialogInterfaceOnCancelListenerC0048a) {
        this(fbDialog);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        String title = this.f217a.f210g.getTitle();
        if (title != null && title.length() > 0) {
            this.f217a.f212i.setText(title);
        }
        this.f217a.f209f.dismiss();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Log.d("Facebook-WebView", "Webview loading URL: " + str);
        super.onPageStarted(webView, str, bitmap);
        this.f217a.f209f.show();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f217a.f208e.mo246a(new DialogError(str, i, str2));
        this.f217a.dismiss();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Log.d("Facebook-WebView", "Redirect URL: " + str);
        if (!str.startsWith("fbconnect://success")) {
            if (str.startsWith("fbconnect://cancel")) {
                this.f217a.f208e.mo244a();
                this.f217a.dismiss();
                return true;
            }
            if (str.contains("touch")) {
                return false;
            }
            this.f217a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }
        Bundle bundleM266b = Util.m266b(str);
        String string = bundleM266b.getString("error");
        if (string == null) {
            string = bundleM266b.getString("error_type");
        }
        if (string == null) {
            this.f217a.f208e.mo245a(bundleM266b);
        } else if (string.equals("access_denied") || string.equals("OAuthAccessDeniedException")) {
            this.f217a.f208e.mo244a();
        } else {
            this.f217a.f208e.mo247a(new FacebookError(string));
        }
        this.f217a.dismiss();
        return true;
    }
}
