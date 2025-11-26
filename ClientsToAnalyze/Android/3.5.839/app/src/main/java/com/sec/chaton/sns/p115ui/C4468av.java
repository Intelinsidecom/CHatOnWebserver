package com.sec.chaton.sns.p115ui;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.p137vk.sdk.VKAccessToken;
import com.sec.chaton.p051c.C1428b;
import com.sec.chaton.sns.p113a.C4365b;
import com.sec.chaton.util.C4904y;

/* compiled from: VKontakteDialog.java */
/* renamed from: com.sec.chaton.sns.ui.av */
/* loaded from: classes.dex */
class C4468av extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ DialogC4464ar f16136a;

    private C4468av(DialogC4464ar dialogC4464ar) {
        this.f16136a = dialogC4464ar;
    }

    /* synthetic */ C4468av(DialogC4464ar dialogC4464ar, DialogInterfaceOnCancelListenerC4465as dialogInterfaceOnCancelListenerC4465as) {
        this(dialogC4464ar);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        C4904y.m18641c("On Page Finished URL : " + str.toString(), getClass().getSimpleName());
        super.onPageFinished(webView, str);
        if (!this.f16136a.f16132k) {
            this.f16136a.f16128g.dismiss();
        }
        this.f16136a.f16130i.setBackgroundColor(0);
        this.f16136a.f16129h.setVisibility(0);
        this.f16136a.f16131j.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        C4904y.m18641c("onPageStarted URL : " + str.toString(), getClass().getSimpleName());
        super.onPageStarted(webView, str, bitmap);
        boolean zM16964a = m16964a(str);
        if (!this.f16136a.f16132k && !zM16964a) {
            this.f16136a.f16128g.show();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f16136a.f16127f.mo2272a(new C4365b(str, i, str2));
        this.f16136a.dismiss();
    }

    /* renamed from: a */
    private boolean m16964a(String str) {
        boolean z = false;
        if (str != null) {
            try {
                if (str.startsWith(C1428b.f5090F)) {
                    if (str.contains("error=")) {
                        this.f16136a.f16127f.mo2271a();
                    } else {
                        this.f16136a.f16127f.mo2273a(VKAccessToken.tokenFromUrlString(str.substring(str.indexOf(35) + 1)));
                        this.f16136a.m16958b();
                        z = true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }
}
