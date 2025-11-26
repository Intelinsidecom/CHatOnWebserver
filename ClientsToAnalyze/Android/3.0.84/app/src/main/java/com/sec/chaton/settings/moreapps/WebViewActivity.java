package com.sec.chaton.settings.moreapps;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class WebViewActivity extends Activity {

    /* renamed from: a */
    public static final String f10016a = WebViewActivity.class.getSimpleName();

    /* renamed from: b */
    private WebView f10017b;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_webview);
        this.f10017b = (WebView) findViewById(R.id.webview);
        m9700a(getIntent().getExtras().getString("link_url"));
    }

    /* renamed from: a */
    private boolean m9700a(String str) {
        if (str == null) {
            return false;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("loadUrl() : is null webview - " + (this.f10017b == null) + "/ url - " + str.toString(), f10016a);
        }
        if (this.f10017b == null) {
            return false;
        }
        try {
            this.f10017b.loadUrl(str);
            return true;
        } catch (RuntimeException e) {
            if (!C3250y.f11737e) {
                return false;
            }
            C3250y.m11443a(e, f10016a);
            return false;
        }
    }
}
