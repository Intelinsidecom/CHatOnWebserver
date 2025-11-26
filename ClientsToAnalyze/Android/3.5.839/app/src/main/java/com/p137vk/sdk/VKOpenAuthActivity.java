package com.p137vk.sdk;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.Locale;

/* loaded from: classes.dex */
public class VKOpenAuthActivity extends Activity {
    private static final String REDIRECT_URL = "https://oauth.vk.com/blank.html";
    public static final String VK_EXTRA_API_VERSION = "version";
    public static final String VK_EXTRA_CLIENT_ID = "client_id";
    public static final String VK_EXTRA_REVOKE = "revoke";
    public static final String VK_EXTRA_SCOPE = "scope";
    public static final String VK_EXTRA_TOKEN_DATA = "extra-token-data";
    public static final String VK_EXTRA_VALIDATION_URL = "extra-validation-url";
    public static final String VK_RESULT_INTENT_NAME = "com.vk.auth-token";
    protected WebView mWebView;

    @Override // android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(new VKOpenAuthView(this));
        hideActionBar();
        findViewById(R.id.content).setBackgroundColor(Color.rgb(240, 242, 245));
        loadPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPage() {
        String str;
        try {
            String stringExtra = getIntent().getStringExtra(VK_EXTRA_VALIDATION_URL);
            if (stringExtra == null) {
                int intExtra = getIntent().getIntExtra(VK_EXTRA_CLIENT_ID, 0);
                String stringExtra2 = getIntent().getStringExtra(VK_EXTRA_SCOPE);
                String stringExtra3 = getIntent().getStringExtra(VK_EXTRA_API_VERSION);
                boolean booleanExtra = getIntent().getBooleanExtra(VK_EXTRA_REVOKE, false);
                Locale locale = Locale.US;
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(intExtra);
                objArr[1] = stringExtra2;
                objArr[2] = REDIRECT_URL;
                objArr[3] = stringExtra3;
                objArr[4] = Integer.valueOf(booleanExtra ? 1 : 0);
                str = String.format(locale, "https://oauth.vk.com/authorize?client_id=%s&scope=%s&redirect_uri=%s&display=mobile&v=%s&response_type=token&revoke=%d", objArr);
            } else {
                str = stringExtra;
            }
            this.mWebView = (WebView) findViewById(R.id.copyUrl);
            this.mWebView.setWebViewClient(new OAuthWebViewClient());
            this.mWebView.getSettings().setJavaScriptEnabled(true);
            this.mWebView.loadUrl(str);
            this.mWebView.setVisibility(4);
        } catch (Exception e) {
            setResult(0);
            finish();
        }
    }

    @TargetApi(11)
    private void hideActionBar() {
        try {
            if (Build.VERSION.SDK_INT >= 11 && getActionBar() != null) {
                getActionBar().hide();
            }
        } catch (Exception e) {
        }
    }

    class OAuthWebViewClient extends WebViewClient {
        public boolean canShowPage;

        private OAuthWebViewClient() {
            this.canShowPage = true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith(VKOpenAuthActivity.REDIRECT_URL)) {
                Log.d("WebView", str);
                Intent intent = new Intent(VKOpenAuthActivity.VK_RESULT_INTENT_NAME);
                intent.putExtra(VKOpenAuthActivity.VK_EXTRA_TOKEN_DATA, str.substring(str.indexOf(35) + 1));
                if (VKOpenAuthActivity.this.getIntent().hasExtra(VKOpenAuthActivity.VK_EXTRA_VALIDATION_URL)) {
                    intent.putExtra(VKOpenAuthActivity.VK_EXTRA_VALIDATION_URL, true);
                }
                VKOpenAuthActivity.this.setResult(-1, intent);
                VKOpenAuthActivity.this.finish();
                return true;
            }
            this.canShowPage = true;
            return false;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.canShowPage) {
                webView.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.canShowPage = false;
            new AlertDialog.Builder(VKOpenAuthActivity.this).setMessage(str).setPositiveButton(com.sec.chaton.R.string.vk_retry, new DialogInterface.OnClickListener() { // from class: com.vk.sdk.VKOpenAuthActivity.OAuthWebViewClient.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    VKOpenAuthActivity.this.loadPage();
                }
            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.vk.sdk.VKOpenAuthActivity.OAuthWebViewClient.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    VKOpenAuthActivity.this.finish();
                }
            }).show();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0, new Intent(VK_RESULT_INTENT_NAME));
        super.onBackPressed();
    }

    class VKOpenAuthView extends RelativeLayout {
        public VKOpenAuthView(Context context) {
            super(context);
            ProgressBar progressBar = new ProgressBar(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13, 1);
            progressBar.setLayoutParams(layoutParams);
            addView(progressBar);
            WebView webView = new WebView(context);
            webView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            addView(webView);
            webView.setId(R.id.copyUrl);
            webView.setVisibility(4);
        }
    }
}
