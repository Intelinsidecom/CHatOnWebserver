package com.sec.chaton;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.util.C4904y;
import java.util.Locale;

/* loaded from: classes.dex */
public class EOSPopupActivity extends BaseActivity {

    /* renamed from: n */
    private final String f1925n = "https://works.chaton.com/mkt/notice/eos/";

    /* renamed from: o */
    private final String f1926o = EOSPopupActivity.class.getSimpleName();

    /* renamed from: p */
    private boolean f1927p;

    /* renamed from: q */
    private WebView f1928q;

    /* renamed from: r */
    private boolean f1929r;

    /* renamed from: s */
    private ProgressBar f1930s;

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m18784t().mo18824a(false);
        m18784t().mo18833d(false);
        setContentView(R.layout.layout_eos_activity);
        m2887f();
        this.f1927p = getIntent().getBooleanExtra("force_close", false);
        String stringExtra = getIntent().getStringExtra("country_code");
        ((Button) findViewById(R.id.btn)).setOnClickListener(new ViewOnClickListenerC4929y(this));
        this.f1930s = (ProgressBar) findViewById(R.id.progress);
        Locale locale = Locale.getDefault();
        if (C4904y.f17872b && locale != null) {
            C4904y.m18639b("locale : " + locale.toString(), this.f1926o);
        }
        if (locale == null) {
            this.f1928q.loadUrl("https://works.chaton.com/mkt/notice/eos/&iso2=" + stringExtra);
        } else {
            this.f1928q.loadUrl("https://works.chaton.com/mkt/notice/eos/?lang=" + locale.toString() + "&iso2=" + stringExtra);
        }
    }

    /* renamed from: f */
    private void m2887f() {
        this.f1928q = (WebView) findViewById(R.id.webview);
        this.f1928q.getSettings().setJavaScriptEnabled(true);
        this.f1928q.setHorizontalScrollBarEnabled(false);
        this.f1928q.setVerticalScrollbarOverlay(true);
        String path = getDir("webview_appcache", 0).getPath();
        this.f1928q.getSettings().setCacheMode(-1);
        this.f1928q.getSettings().setAppCacheMaxSize(8388608L);
        this.f1928q.getSettings().setAppCachePath(path);
        this.f1928q.getSettings().setAllowFileAccess(true);
        this.f1928q.getSettings().setAppCacheEnabled(true);
        this.f1928q.setWebViewClient(new C4930z(this, this));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f1928q.canGoBack()) {
            this.f1928q.goBack();
        } else if (this.f1927p) {
            setResult(11);
            finish();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f1929r = true;
    }
}
