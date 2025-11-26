package com.sec.chaton.settings;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.DeviceInfoUtil;

/* loaded from: classes.dex */
public class ActivityWebView extends Activity {

    /* renamed from: a */
    WebView f3077a;

    /* renamed from: c */
    private String f3079c;

    /* renamed from: e */
    private TextView f3081e;

    /* renamed from: d */
    private SharedPreferences f3080d = null;

    /* renamed from: b */
    Activity f3078b = this;

    /* renamed from: f */
    private ProgressDialog f3082f = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(2);
        setContentView(C0062R.layout.layout_notice_webview);
        this.f3081e = (TextView) findViewById(C0062R.id.webview_title);
        this.f3077a = (WebView) findViewById(C0062R.id.webview1);
        this.f3077a.getSettings().setJavaScriptEnabled(true);
        this.f3077a.setWebChromeClient(new C0470as(this));
        this.f3077a.setWebChromeClient(new C0469ar(this));
        this.f3077a.setHorizontalScrollBarEnabled(false);
        this.f3077a.setVerticalScrollBarEnabled(false);
        this.f3082f = ProgressDialog.show(this, null, getResources().getString(C0062R.string.dialog_provision_ing));
        String strM3570g = DeviceInfoUtil.m3570g();
        if (strM3570g == null) {
            strM3570g = "310";
        }
        ChatONLogWriter.m3506b("MCC=" + strM3570g + " SCC=" + DeviceInfoUtil.m3567d(), getClass().getSimpleName());
        String language = getResources().getConfiguration().locale.getLanguage();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("PARAM_MENU")) {
                this.f3079c = extras.getString("PARAM_MENU");
                if (this.f3079c.equals("Help")) {
                    this.f3077a.loadUrl("http://www.chaton.com/mwv/faq.html?l=" + language);
                    this.f3081e.setText(getResources().getString(C0062R.string.settings_help));
                } else if (this.f3079c.equals("Upgrade")) {
                    this.f3077a.loadUrl("https://market.android.com/");
                } else if (this.f3079c.equals("Q&A")) {
                    this.f3077a.loadUrl("http://211.239.154.3:9090/chaton/webview/android/qna/index.html");
                } else if (this.f3079c.equals("TERMS_AND_CONDITION")) {
                    this.f3081e.setText(getResources().getString(C0062R.string.setting_disclaimer_terms));
                    this.f3077a.loadUrl("http://www.chaton.com/mwv/disclaimer.html?c=" + strM3570g + "&f=TC");
                } else if (this.f3079c.equals("PRIVACY_POLICY")) {
                    this.f3081e.setText(getResources().getString(C0062R.string.setting_disclaimer_policy));
                    this.f3077a.loadUrl("http://www.chaton.com/mwv/disclaimer.html?c=" + strM3570g + "&f=PP");
                }
            }
            this.f3077a.setWebViewClient(new C0520u(this, this.f3082f));
        }
    }
}
