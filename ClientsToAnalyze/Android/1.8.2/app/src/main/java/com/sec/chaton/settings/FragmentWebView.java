package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.push.util.C1141i;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1732ao;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.ProgressDialogC1806j;
import java.io.File;
import java.util.Locale;
import org.apache.http.util.EncodingUtils;

/* loaded from: classes.dex */
public class FragmentWebView extends Fragment {
    private static final int FILECHOOSER_RESULTCODE = 1;
    public static final String FROM_ABOUT_CHATON = "FROM_ABOUT_CHATON";
    public static final String PARAM_MENU = "PARAM_MENU";
    public static final String REGI_VOC = "REGI_VOC";
    private static final String fileName = "NOTICE.html";
    private String countryletter;
    private ValueCallback mUploadMessage;
    WebView mWebView;
    private String menu;
    private String url;
    private TextView webview_title;

    /* renamed from: pd */
    private ProgressDialog f4689pd = null;
    final String SERVER_ADDRESS = "smm.samsung.com";

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        View viewInflate = layoutInflater.inflate(R.layout.layout_notice_webview, viewGroup, false);
        this.webview_title = (TextView) viewInflate.findViewById(R.id.webview_title);
        this.mWebView = (WebView) viewInflate.findViewById(R.id.webview1);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
        this.mWebView.setWebChromeClient(new InternalWebChromeClient());
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setVerticalScrollbarOverlay(true);
        if (getActivity() != null) {
            this.f4689pd = ProgressDialogC1806j.m6140a(getActivity(), null, getResources().getString(R.string.dialog_provision_ing));
            this.f4689pd.setCancelable(true);
            this.f4689pd.setCanceledOnTouchOutside(false);
        }
        this.f4689pd.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.sec.chaton.settings.FragmentWebView.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                FragmentWebView.this.getFragmentManager().popBackStack((String) null, 0);
            }
        });
        String strM5883j = C1721ad.m5883j();
        this.countryletter = C1789u.m6075a().getString("country_letter", "");
        C1786r.m6061b("MCC=" + strM5883j + " SCC=" + C1721ad.m5878e(), getClass().getSimpleName());
        Locale locale = Locale.getDefault();
        C1786r.m6061b(locale.getLanguage() + locale.getCountry(), getClass().getSimpleName());
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey(PARAM_MENU)) {
                this.menu = arguments.getString(PARAM_MENU);
                C1786r.m6061b("menu=" + this.menu, getClass().getSimpleName());
                if ("Help".equals(this.menu)) {
                    this.mWebView.loadUrl("http://smm.samsung.com/mwv/faq.html?l=" + locale.toString());
                    this.webview_title.setText(getResources().getString(R.string.settings_help));
                } else if ("Upgrade".equals(this.menu)) {
                    this.mWebView.loadUrl("https://market.android.com/");
                } else if ("Q&A".equals(this.menu)) {
                    this.mWebView.loadUrl("http://211.239.154.3:9090/chaton/webview/android/qna/index.html");
                } else if ("TERMS_AND_CONDITION".equals(this.menu)) {
                    this.webview_title.setText(getResources().getString(R.string.setting_disclaimer_terms));
                    if (strM5883j != null) {
                        this.url = "http://smm.samsung.com/mwv/disclaimer.html?c=" + strM5883j + "&f=TC";
                    } else if (TextUtils.isEmpty(this.countryletter)) {
                        this.url = "http://smm.samsung.com/mwv/disclaimer.html?c=234&f=TC";
                    } else {
                        this.url = "http://smm.samsung.com/mwv/disclaimer.html?iso2=" + this.countryletter + "&f=TC";
                    }
                    this.mWebView.loadUrl(this.url);
                    C1786r.m6061b("TERMS_AND_CONDITION url : " + this.url, getClass().getSimpleName());
                } else if ("PRIVACY_POLICY".equals(this.menu)) {
                    this.webview_title.setText(getResources().getString(R.string.setting_disclaimer_policy));
                    if (strM5883j != null) {
                        this.url = "http://smm.samsung.com/mwv/disclaimer.html?c=" + strM5883j + "&f=PP";
                    } else if (TextUtils.isEmpty(this.countryletter)) {
                        this.url = "http://smm.samsung.com/mwv/disclaimer.html?c=234&f=PP";
                    } else {
                        this.url = "http://smm.samsung.com/mwv/disclaimer.html?iso2=" + this.countryletter + "&f=PP";
                    }
                    this.mWebView.loadUrl(this.url);
                    C1786r.m6061b("PRIVACY_POLICY url : " + this.url, getClass().getSimpleName());
                } else if ("ACCEPT_USE_DATA".equals(this.menu)) {
                    this.webview_title.setText(getResources().getString(R.string.layout_chat_fragment_delete));
                    if (strM5883j != null) {
                        this.url = "http://smm.samsung.com/mwv/disclaimer.html?c=" + strM5883j + "&f=PUA";
                    } else if (TextUtils.isEmpty(this.countryletter)) {
                        this.url = "http://smm.samsung.com/mwv/disclaimer.html?c=234&f=PUA";
                    } else {
                        this.url = "http://smm.samsung.com/mwv/disclaimer.html?iso2=" + this.countryletter + "&f=PUA";
                    }
                    this.mWebView.loadUrl(this.url);
                    C1786r.m6061b("ACCEPT_USE_DATA url : " + this.url, getClass().getSimpleName());
                } else if ("Noti".equals(this.menu)) {
                    this.mWebView.loadUrl("http://smm.samsung.com/mwv/notice.html?l=" + locale.toString());
                    this.webview_title.setText(getResources().getString(R.string.setting_category_notice));
                    C1789u.m6079a("accept_time", C1789u.m6075a().getString("server_time", ""));
                    C1786r.m6061b("[NOTICE] Acccep time : " + C1789u.m6075a().getString("accept_time", ""), getClass().getSimpleName());
                    C1789u.m6077a("notice", (Integer) 0);
                } else if ("License".equals(this.menu)) {
                    showOpenLicence();
                } else if ("VOC".equals(this.menu)) {
                    String strMakePostURL = makePostURL(arguments.containsKey(REGI_VOC));
                    C1786r.m6061b("<PostData>\n" + strMakePostURL, getClass().getSimpleName());
                    this.mWebView.postUrl("http://smm.samsung.com/mwv/voc.html?l=" + locale.toString(), EncodingUtils.getBytes(strMakePostURL, "BASE64"));
                    this.webview_title.setText(getResources().getString(R.string.contact_us));
                }
            }
            this.mWebView.setWebViewClient(new MyClient(this.f4689pd));
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            this.mUploadMessage.onReceiveValue(null);
            this.mUploadMessage = null;
            return;
        }
        if (i == 1 && this.mUploadMessage != null) {
            Uri data = (intent == null || i2 != -1) ? null : intent.getData();
            if (Build.VERSION.SDK_INT < 11) {
                this.mUploadMessage.onReceiveValue(data);
                return;
            }
            Cursor cursorQuery = getActivity().getContentResolver().query(data, null, null, null, null);
            File fileM5914a = null;
            String string = null;
            while (cursorQuery.moveToNext()) {
                if (cursorQuery.getColumnIndex("_data") != -1) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                } else {
                    fileM5914a = C1732ao.m5914a(getActivity(), null, null, data);
                }
            }
            if (string != null) {
                File file = new File(string);
                if (C1732ao.m5915a(file)) {
                    fileM5914a = C1732ao.m5914a(getActivity(), file, null, null);
                }
            }
            if (fileM5914a == null) {
                this.mUploadMessage.onReceiveValue(data);
            } else {
                this.mUploadMessage.onReceiveValue(Uri.fromFile(fileM5914a));
            }
            this.mUploadMessage = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073 A[Catch: IOException -> 0x00b6, TRY_LEAVE, TryCatch #1 {IOException -> 0x00b6, blocks: (B:30:0x006e, B:32:0x0073), top: B:67:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void showOpenLicence() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.settings.FragmentWebView.showOpenLicence():void");
    }

    class MyClient extends WebViewClient {

        /* renamed from: pd */
        private ProgressDialog f4690pd;

        public MyClient(ProgressDialog progressDialog) {
            this.f4690pd = progressDialog;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C1786r.m6061b("shouldOverrideUrlLoading, url : " + str, getClass().getSimpleName());
            if (str.startsWith("http:")) {
                FragmentWebView.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } else {
                webView.loadUrl(str);
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            C1786r.m6061b("onPageFinished...", getClass().getSimpleName());
            if (FragmentWebView.this.getActivity() != null && this.f4690pd != null && this.f4690pd.isShowing()) {
                this.f4690pd.dismiss();
                C1786r.m6061b("onPageFinished pd dismissed", getClass().getSimpleName());
            }
        }
    }

    private String makePostURL(boolean z) {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService("connectivity");
        StringBuilder sb = new StringBuilder();
        sb.append("Sender=" + C1789u.m6075a().getString("msisdn", "")).append("&");
        sb.append("Version=" + C0452a.f1723b).append("&");
        sb.append("Connection=" + (connectivityManager.getActiveNetworkInfo() != null ? connectivityManager.getActiveNetworkInfo().getTypeName() : connectivityManager.getActiveNetworkInfo())).append("&");
        sb.append("Display=" + Build.DISPLAY).append("&");
        sb.append("Brand=" + Build.BRAND).append("&");
        sb.append("Server=" + C1789u.m6075a().getString("primary_message_addrss", "secondary_message_addrss")).append(" ").append(C1789u.m6075a().getString("primary_contact_addrss", "secondary_contact_addrss")).append(" ").append(C1789u.m6075a().getString("primary_file_addrss", "secondary_file_addrss")).append(" ").append(C1789u.m6075a().getString("primary_sms_address", "secondary_sms_addrss")).append("&");
        sb.append("mode=" + (z ? "1" : "0")).append("&");
        sb.append("Model=" + Build.MODEL).append("&");
        sb.append("IMSI=" + C1721ad.m5880g()).append("&");
        sb.append("Push=" + C1141i.m4319a(getActivity()));
        return sb.toString();
    }

    class InternalWebChromeClient extends WebChromeClient {
        private InternalWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (FragmentWebView.this.getActivity() != null) {
                FragmentWebView.this.getActivity().setProgress(i * 100);
            }
            C1786r.m6061b("progress=" + i, getClass().getSimpleName());
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            C1786r.m6061b("errorCode=" + i + "failingUrl = " + str2 + "desctiption = " + str, getClass().getSimpleName());
        }

        public void openFileChooser(ValueCallback valueCallback) {
            C1786r.m6061b("openFileChooser under SDK 10", getClass().getSimpleName());
            FragmentWebView.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            FragmentWebView.this.startActivityForResult(Intent.createChooser(intent, FragmentWebView.this.getString(R.string.file_chooser)), 1);
        }

        public void openFileChooser(ValueCallback valueCallback, String str) {
            C1786r.m6061b("openFileChooser over SDK 11", getClass().getSimpleName());
            FragmentWebView.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            FragmentWebView.this.startActivityForResult(Intent.createChooser(intent, FragmentWebView.this.getString(R.string.file_chooser)), 1);
        }
    }
}
