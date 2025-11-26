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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sec.chaton.R;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.push.util.C0915a;
import com.sec.chaton.util.C1311bg;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.GeneralHeaderView;
import java.io.File;
import java.util.Locale;
import org.apache.http.util.EncodingUtils;

/* loaded from: classes.dex */
public class FragmentWebView extends Fragment {
    private static final int FILECHOOSER_RESULTCODE = 1;
    public static final String PARAM_MENU = "PARAM_MENU";
    public static final String REGI_VOC = "REGI_VOC";
    private static final String fileName = "NOTICE.html";
    private String countryletter;
    private ValueCallback mUploadMessage;
    WebView mWebView;
    private String menu;

    /* renamed from: pd */
    private ProgressDialog f3561pd = null;
    private String url;
    private GeneralHeaderView webview_title;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        View viewInflate = layoutInflater.inflate(R.layout.layout_notice_webview, viewGroup, false);
        this.webview_title = (GeneralHeaderView) viewInflate.findViewById(R.id.webview_title);
        this.mWebView = (WebView) viewInflate.findViewById(R.id.webview1);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.setWebChromeClient(new InternalWebChromeClient());
        this.mWebView.setHorizontalScrollBarEnabled(true);
        this.mWebView.setVerticalScrollbarOverlay(true);
        if (getActivity() != null) {
            this.f3561pd = ProgressDialogC1354a.m4723a(getActivity(), null, getResources().getString(R.string.dialog_provision_ing));
            this.f3561pd.setCancelable(true);
            this.f3561pd.setCanceledOnTouchOutside(false);
        }
        this.f3561pd.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.sec.chaton.settings.FragmentWebView.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (FragmentWebView.this.getActivity() != null) {
                    FragmentWebView.this.getActivity().finish();
                }
            }
        });
        String strM4630g = C1336k.m4630g();
        this.countryletter = C1323bs.m4575a().getString("country_letter", "");
        C1341p.m4658b("MCC=" + strM4630g + " SCC=" + C1336k.m4628e(), getClass().getSimpleName());
        Locale locale = Locale.getDefault();
        C1341p.m4658b(locale.getLanguage() + locale.getCountry(), getClass().getSimpleName());
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey(PARAM_MENU)) {
                this.menu = arguments.getString(PARAM_MENU);
                C1341p.m4658b("menu=" + this.menu, getClass().getSimpleName());
                if ("Help".equals(this.menu)) {
                    this.mWebView.loadUrl("http://smm.samsung.com/mwv/faq.html?l=" + locale.toString());
                    this.webview_title.setText(getResources().getString(R.string.settings_help));
                } else if ("Upgrade".equals(this.menu)) {
                    this.mWebView.loadUrl("https://market.android.com/");
                } else if ("Q&A".equals(this.menu)) {
                    this.mWebView.loadUrl("http://211.239.154.3:9090/chaton/webview/android/qna/index.html");
                } else if ("TERMS_AND_CONDITION".equals(this.menu)) {
                    this.webview_title.setText(getResources().getString(R.string.setting_disclaimer_terms));
                    if (strM4630g != null) {
                        this.url = "http://smm.samsung.com/mwv/disclaimer.html?c=" + strM4630g + "&f=TC";
                    } else if (TextUtils.isEmpty(this.countryletter)) {
                        this.url = "http://smm.samsung.com/mwv/disclaimer.html?c=234&f=TC";
                    } else {
                        this.url = "http://smm.samsung.com/mwv/disclaimer.html?iso2=" + this.countryletter + "&f=TC";
                    }
                    this.mWebView.loadUrl(this.url);
                    C1341p.m4658b("TERMS_AND_CONDITION url : " + this.url, getClass().getSimpleName());
                } else if ("PRIVACY_POLICY".equals(this.menu)) {
                    this.webview_title.setText(getResources().getString(R.string.setting_disclaimer_policy));
                    if (strM4630g != null) {
                        this.url = "http://smm.samsung.com/mwv/disclaimer.html?c=" + strM4630g + "&f=PP";
                    } else if (TextUtils.isEmpty(this.countryletter)) {
                        this.url = "http://smm.samsung.com/mwv/disclaimer.html?c=234&f=PP";
                    } else {
                        this.url = "http://smm.samsung.com/mwv/disclaimer.html?iso2=" + this.countryletter + "&f=PP";
                    }
                    this.mWebView.loadUrl(this.url);
                    C1341p.m4658b("PRIVACY_POLICY url : " + this.url, getClass().getSimpleName());
                } else if ("Noti".equals(this.menu)) {
                    this.mWebView.loadUrl("http://smm.samsung.com/mwv/notice.html?l=" + locale.toString());
                    this.webview_title.setText(getResources().getString(R.string.setting_category_notice));
                    C1323bs.m4579a("accept_time", C1323bs.m4575a().getString("server_time", ""));
                    C1341p.m4658b("[NOTICE] Acccep time : " + C1323bs.m4575a().getString("accept_time", ""), getClass().getSimpleName());
                    C1323bs.m4577a("notice", (Integer) 0);
                } else if ("License".equals(this.menu)) {
                    showOpenLicence();
                } else if ("VOC".equals(this.menu)) {
                    String strMakePostURL = makePostURL(arguments.containsKey(REGI_VOC));
                    C1341p.m4658b("<PostData>\n" + strMakePostURL, getClass().getSimpleName());
                    this.mWebView.postUrl("http://smm.samsung.com/mwv/voc.html?l=" + locale.toString(), EncodingUtils.getBytes(strMakePostURL, "BASE64"));
                    this.webview_title.setText(getResources().getString(R.string.contact_us));
                } else if ("CHATONV_3RDPARTY_DISCLAIMER".equals(this.menu)) {
                    this.webview_title.setText(getResources().getString(R.string.setting_disclaimer_terms));
                    this.url = "http://smm.samsung.com/mwv/agreement.html?c=450&l=ko_rKR";
                    this.mWebView.loadUrl(this.url);
                    C1341p.m4658b("CHATONV_3RDPARTY_DISCLAIMER url : " + this.url, getClass().getSimpleName());
                } else if ("SDS_TERMS_AND_CONDITION".equals(this.menu)) {
                    this.webview_title.setText("SDS " + getResources().getString(R.string.setting_disclaimer_terms));
                    this.url = "http://www.coolots.com/chatonv/sdsterms.html";
                    this.mWebView.loadUrl(this.url);
                    C1341p.m4658b("SDS_TERMS_AND_CONDITION url : " + this.url, getClass().getSimpleName());
                }
            }
            this.mWebView.setWebViewClient(new MyClient(this.f3561pd));
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        File fileM4564a;
        String string;
        if (i2 != -1) {
            this.mUploadMessage.onReceiveValue(null);
            this.mUploadMessage = null;
            return;
        }
        if (i == 1 && this.mUploadMessage != null) {
            Uri data = (intent == null || i2 != -1) ? null : intent.getData();
            if (data != null) {
                if (Build.VERSION.SDK_INT < 11) {
                    this.mUploadMessage.onReceiveValue(data);
                    return;
                }
                if (data.toString().contains("file://")) {
                    string = data.toString();
                    fileM4564a = null;
                } else {
                    Cursor cursorQuery = getActivity().getContentResolver().query(data, null, null, null, null);
                    if (cursorQuery != null && cursorQuery.getCount() != 0) {
                        fileM4564a = null;
                        string = null;
                        while (cursorQuery.moveToNext()) {
                            if (cursorQuery.getColumnIndex("_data") != -1) {
                                string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                            } else {
                                fileM4564a = C1311bg.m4564a(getActivity(), null, null, data);
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (string != null) {
                    File file = new File(string);
                    if (C1311bg.m4565a(file)) {
                        fileM4564a = C1311bg.m4564a(getActivity(), file, null, null);
                    }
                }
                if (fileM4564a == null) {
                    this.mUploadMessage.onReceiveValue(data);
                } else {
                    this.mUploadMessage.onReceiveValue(Uri.fromFile(fileM4564a));
                }
                this.mUploadMessage = null;
            }
        }
    }

    private String makePostURL(boolean z) {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService("connectivity");
        StringBuilder sb = new StringBuilder();
        sb.append("Sender=" + C1323bs.m4575a().getString("msisdn", "")).append("&");
        sb.append("Version=" + C0684a.f2331b).append("&");
        sb.append("Connection=" + (connectivityManager.getActiveNetworkInfo() != null ? connectivityManager.getActiveNetworkInfo().getTypeName() : connectivityManager.getActiveNetworkInfo())).append("&");
        sb.append("Display=" + Build.DISPLAY).append("&");
        sb.append("Brand=" + Build.BRAND).append("&");
        sb.append("Server=" + C1323bs.m4575a().getString("primary_message_addrss", "secondary_message_addrss")).append(" ").append(C1323bs.m4575a().getString("primary_contact_addrss", "secondary_contact_addrss")).append(" ").append(C1323bs.m4575a().getString("primary_file_addrss", "secondary_file_addrss")).append(" ").append(C1323bs.m4575a().getString("primary_sms_address", "secondary_sms_addrss")).append("&");
        sb.append("mode=" + (z ? "1" : "0")).append("&");
        sb.append("Model=" + Build.MODEL).append("&");
        sb.append("IMSI=" + C1336k.m4629f()).append("&");
        sb.append("Push=" + C0915a.m3609a(getActivity()));
        return sb.toString();
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
        private ProgressDialog f3562pd;

        public MyClient(ProgressDialog progressDialog) {
            this.f3562pd = progressDialog;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C1341p.m4658b("shouldOverrideUrlLoading, url : " + str, getClass().getSimpleName());
            if (str.startsWith("http:")) {
                FragmentWebView.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } else {
                webView.loadUrl(str);
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            C1341p.m4658b("onPageFinished...", getClass().getSimpleName());
            if (this.f3562pd.isShowing() && this.f3562pd != null) {
                this.f3562pd.dismiss();
                C1341p.m4658b("onPageFinished pd dismissed", getClass().getSimpleName());
            }
        }
    }

    class InternalWebChromeClient extends WebChromeClient {
        private InternalWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (FragmentWebView.this.getActivity() != null) {
                FragmentWebView.this.getActivity().setProgress(i * 100);
            }
            C1341p.m4658b("progress=" + i, getClass().getSimpleName());
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            C1341p.m4658b("errorCode=" + i + "failingUrl = " + str2 + "desctiption = " + str, getClass().getSimpleName());
        }

        public void openFileChooser(ValueCallback valueCallback) {
            C1341p.m4658b("openFileChooser under SDK 10", getClass().getSimpleName());
            FragmentWebView.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            FragmentWebView.this.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
        }

        public void openFileChooser(ValueCallback valueCallback, String str) {
            C1341p.m4658b("openFileChooser over SDK 11", getClass().getSimpleName());
            FragmentWebView.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            FragmentWebView.this.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
        }
    }
}
