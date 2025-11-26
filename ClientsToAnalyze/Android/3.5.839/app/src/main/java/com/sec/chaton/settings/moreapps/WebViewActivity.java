package com.sec.chaton.settings.moreapps;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class WebViewActivity extends Activity {

    /* renamed from: a */
    public static final String f13250a = WebViewActivity.class.getSimpleName();

    /* renamed from: b */
    private WebView f13251b;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_webview);
        this.f13251b = (WebView) findViewById(R.id.webview);
        m13940a(getIntent().getExtras().getString("link_url"));
    }

    /* renamed from: a */
    private boolean m13940a(String str) {
        if (str == null) {
            return false;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("loadUrl() : is null webview - " + (this.f13251b == null) + "/ url - " + str.toString(), f13250a);
        }
        if (this.f13251b == null) {
            return false;
        }
        try {
            this.f13251b.loadUrl(str);
            return true;
        } catch (RuntimeException e) {
            if (!C4904y.f17875e) {
                return false;
            }
            C4904y.m18635a(e, f13250a);
            return false;
        }
    }
}
