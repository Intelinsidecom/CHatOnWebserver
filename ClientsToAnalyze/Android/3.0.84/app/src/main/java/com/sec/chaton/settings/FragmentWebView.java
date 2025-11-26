package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.p037j.C1554c;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.util.C2117i;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3188bc;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3218cf;
import com.sec.chaton.util.EnumC3219cg;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import java.io.File;
import java.util.Locale;
import org.apache.http.util.EncodingUtils;

/* loaded from: classes.dex */
public class FragmentWebView extends Fragment {
    private static final int FILECHOOSER_RESULTCODE = 1;
    public static final String FROM_ABOUT_CHATON = "FROM_ABOUT_CHATON";
    public static final String PARAM_MENU = "PARAM_MENU";
    public static final String REGI_VOC = "REGI_VOC";
    public static final String SHOW_BREADCRUMB = "SHOW_BREADCRUMB";
    private static final String fileName = "NOTICE.html";
    private String countryletter;
    private InterfaceC3274d dialog;
    private ValueCallback<Uri> mUploadMessage;
    WebView mWebView;
    private String menu;
    private String url;

    /* renamed from: pd */
    private ProgressDialog f9217pd = null;
    private final String DEFAULT_SERVER_ADDRESS = "http://smm.samsung.com";
    Handler mGetVersionHandler = new Handler(Looper.getMainLooper()) { // from class: com.sec.chaton.settings.FragmentWebView.5
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0267d c0267d = (C0267d) message.obj;
            if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && ((GetVersionNotice) c0267d.m1354e()) != null) {
                C3159aa.m10966a("accept_time", C3159aa.m10962a().m10979a("server_time", ""));
                C3250y.m11450b("[NOTICE] Acccep time : " + C3159aa.m10962a().m10979a("accept_time", ""), getClass().getSimpleName());
                C3159aa.m10964a("notice", (Integer) 0);
            }
            FragmentWebView.this.mWebView.loadUrl(FragmentWebView.this.url);
            C3250y.m11450b("Noti url : " + FragmentWebView.this.url, getClass().getSimpleName());
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        View viewInflate = layoutInflater.inflate(R.layout.layout_notice_webview, viewGroup, false);
        if (GlobalApplication.m6456e()) {
            viewInflate.findViewById(R.id.breadcrumb).setVisibility(8);
        }
        this.mWebView = (WebView) viewInflate.findViewById(R.id.webview1);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.setWebChromeClient(new InternalWebChromeClient());
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setVerticalScrollbarOverlay(true);
        String path = PushClientApplication.m8156h().getDir("webview_appcache", 0).getPath();
        this.mWebView.getSettings().setCacheMode(-1);
        this.mWebView.getSettings().setAppCacheMaxSize(8388608L);
        this.mWebView.getSettings().setAppCachePath(path);
        this.mWebView.getSettings().setAllowFileAccess(true);
        this.mWebView.getSettings().setAppCacheEnabled(true);
        View viewFindViewById = viewInflate.findViewById(R.id.breadcrumb);
        if (getActivity() != null) {
            this.f9217pd = ProgressDialogC3265l.m11489a(getActivity(), null, getResources().getString(R.string.dialog_provision_ing));
            this.f9217pd.setCancelable(true);
            this.f9217pd.setCanceledOnTouchOutside(false);
            this.f9217pd.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.sec.chaton.settings.FragmentWebView.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (FragmentWebView.this.getActivity() != null) {
                        FragmentWebView.this.getActivity().finish();
                    }
                }
            });
        }
        String strM11068h = C3171am.m11068h();
        this.countryletter = C3159aa.m10962a().m10979a("country_letter", "");
        C3250y.m11450b("MCC=" + strM11068h + " SCC=" + C3171am.m11060d(), getClass().getSimpleName());
        Locale locale = Locale.getDefault();
        C3250y.m11450b(locale.getLanguage() + locale.getCountry(), getClass().getSimpleName());
        Bundle arguments = getArguments();
        String serverAddress = getServerAddress();
        C3250y.m11450b("serverAddress : " + serverAddress, getClass().getSimpleName());
        Boolean boolValueOf = Boolean.valueOf(arguments.getBoolean("FROM_ABOUT_CHATON"));
        C3250y.m11450b("isFromAboutChaton : " + boolValueOf, getClass().getSimpleName());
        String strM11082t = C3171am.m11082t();
        if (arguments != null) {
            if (arguments.containsKey("PARAM_MENU")) {
                this.menu = arguments.getString("PARAM_MENU");
                C3250y.m11450b("menu=" + this.menu, getClass().getSimpleName());
                if ("Help".equals(this.menu)) {
                    int iM6733a = C1594v.m6733a(getActivity());
                    if ((-3 == iM6733a || -2 == iM6733a) && getActivity() != null) {
                        this.dialog = AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.toast_error)).mo11509b(getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings.FragmentWebView.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                FragmentWebView.this.getActivity().finish();
                            }
                        }).mo11505a();
                        this.dialog.show();
                    }
                    if (viewFindViewById != null && !arguments.containsKey(SHOW_BREADCRUMB)) {
                        viewFindViewById.setVisibility(8);
                    }
                    this.mWebView.loadUrl(serverAddress + "/mwv/faq.html?l=" + locale.toString());
                } else if ("Upgrade".equals(this.menu)) {
                    this.mWebView.loadUrl("https://market.android.com/");
                } else if ("Q&A".equals(this.menu)) {
                    this.mWebView.loadUrl("http://211.239.154.3:9090/chaton/webview/android/qna/index.html");
                } else if ("TERMS_AND_CONDITION".equals(this.menu)) {
                    if (viewFindViewById != null) {
                        viewFindViewById.setVisibility(8);
                    }
                    int iM6733a2 = C1594v.m6733a(getActivity());
                    if ((-3 == iM6733a2 || -2 == iM6733a2) && getActivity() != null) {
                        this.dialog = AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.toast_error)).mo11509b(getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings.FragmentWebView.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                FragmentWebView.this.getActivity().finish();
                            }
                        }).mo11505a();
                        this.dialog.show();
                    }
                    if (boolValueOf.booleanValue()) {
                        if (TextUtils.isEmpty(strM11082t)) {
                            this.url = serverAddress + "/mwv/disclaimer.html?c=234&f=TC";
                        } else {
                            this.url = serverAddress + "/mwv/disclaimer.html?iso2=" + strM11082t + "&f=TC";
                        }
                    } else if (!TextUtils.isEmpty(this.countryletter)) {
                        this.url = serverAddress + "/mwv/disclaimer.html?iso2=" + this.countryletter + "&f=TC";
                    } else if (strM11068h == null) {
                        this.url = serverAddress + "/mwv/disclaimer.html?c=234&f=TC";
                    } else {
                        this.url = serverAddress + "/mwv/disclaimer.html?c=" + strM11068h + "&f=TC";
                    }
                    this.mWebView.loadUrl(this.url);
                    C3250y.m11450b("TERMS_AND_CONDITION url : " + this.url, getClass().getSimpleName());
                } else if ("PRIVACY_POLICY".equals(this.menu)) {
                    if (viewFindViewById != null) {
                        viewFindViewById.setVisibility(8);
                    }
                    if (boolValueOf.booleanValue()) {
                        if (TextUtils.isEmpty(strM11082t)) {
                            this.url = serverAddress + "/mwv/disclaimer.html?c=234&f=PP";
                        } else {
                            this.url = serverAddress + "/mwv/disclaimer.html?iso2=" + strM11082t + "&f=PP";
                        }
                    } else if (!TextUtils.isEmpty(this.countryletter)) {
                        this.url = serverAddress + "/mwv/disclaimer.html?iso2=" + this.countryletter + "&f=PP";
                    } else if (strM11068h == null) {
                        this.url = serverAddress + "/mwv/disclaimer.html?c=234&f=PP";
                    } else {
                        this.url = serverAddress + "/mwv/disclaimer.html?c=" + strM11068h + "&f=PP";
                    }
                    this.mWebView.loadUrl(this.url);
                    C3250y.m11450b("PRIVACY_POLICY url : " + this.url, getClass().getSimpleName());
                } else if ("ACCEPT_USE_DATA".equals(this.menu)) {
                    if (!TextUtils.isEmpty(this.countryletter)) {
                        this.url = serverAddress + "/mwv/disclaimer.html?iso2=" + this.countryletter + "&f=PUA";
                    } else if (strM11068h == null) {
                        this.url = serverAddress + "/mwv/disclaimer.html?c=234&f=PUA";
                    } else {
                        this.url = serverAddress + "/mwv/disclaimer.html?c=" + strM11068h + "&f=PUA";
                    }
                    this.mWebView.loadUrl(this.url);
                    C3250y.m11450b("ACCEPT_USE_DATA url : " + this.url, getClass().getSimpleName());
                } else if ("Noti".equals(this.menu)) {
                    if (viewFindViewById != null && !arguments.containsKey(SHOW_BREADCRUMB)) {
                        viewFindViewById.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(strM11082t)) {
                        this.url = serverAddress + "/mwv/notice.html?l=" + locale.toString() + "&iso2=" + strM11082t;
                    } else if (strM11068h != null) {
                        this.url = serverAddress + "/mwv/notice.html?l=" + locale.toString() + "&c=" + strM11068h;
                    } else {
                        this.url = serverAddress + "/mwv/notice.html?l=" + locale.toString();
                    }
                    int iM6733a3 = C1594v.m6733a(getActivity());
                    if ((-3 == iM6733a3 || -2 == iM6733a3) && getActivity() != null) {
                        this.dialog = AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.toast_error)).mo11509b(getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings.FragmentWebView.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                FragmentWebView.this.getActivity().finish();
                            }
                        }).mo11505a();
                        this.dialog.show();
                    }
                    new C1324bj(this.mGetVersionHandler).m5694b();
                } else if ("License".equals(this.menu)) {
                    if (viewFindViewById != null) {
                        viewFindViewById.setVisibility(8);
                    }
                    showOpenLicence();
                } else if ("VOC".equals(this.menu)) {
                    if (viewFindViewById != null && !arguments.containsKey(SHOW_BREADCRUMB)) {
                        viewFindViewById.setVisibility(8);
                    }
                    boolean z = false;
                    if (arguments.containsKey("REGI_VOC")) {
                        z = true;
                    }
                    String strMakePostURL = makePostURL(z);
                    C3250y.m11450b("<PostData>\n" + strMakePostURL, getClass().getSimpleName());
                    this.mWebView.postUrl(serverAddress + "/mwv/voc.html?l=" + locale.toString(), EncodingUtils.getBytes(strMakePostURL, "BASE64"));
                } else if ("CHATONV_3RDPARTY_DISCLAIMER".equals(this.menu)) {
                    this.url = serverAddress + "/mwv/agreement.html?c=450&l=ko_rKR";
                    this.mWebView.loadUrl(this.url);
                    C3250y.m11450b("CHATONV_3RDPARTY_DISCLAIMER url : " + this.url, getClass().getSimpleName());
                } else if ("SDS_TERMS_AND_CONDITION".equals(this.menu)) {
                    this.url = "http://www.coolots.com/chatonv/sdsterms.html";
                    this.mWebView.loadUrl(this.url);
                    C3250y.m11450b("SDS_TERMS_AND_CONDITION url : " + this.url, getClass().getSimpleName());
                } else if ("SDS_DOWNLOAD_CHATON_V".equals(this.menu)) {
                    this.url = "http://www.coolots.com/chatonv/download.html";
                    this.mWebView.loadUrl(this.url);
                    C3250y.m11450b("SDS_DOWNLOAD_CHATON_V url : " + this.url, getClass().getSimpleName());
                }
            }
            this.mWebView.setWebViewClient(new MyClient(this.f9217pd));
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (C3250y.f11734b) {
            C3250y.m11450b("onDestroyView", getClass().getSimpleName());
        }
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
        if (this.dialog != null && this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
    }

    String getServerAddress() {
        if (!TextUtils.isEmpty(C3159aa.m10962a().m10979a("primary_admin_mobileweb_address", ""))) {
            return C1554c.m6590a(EnumC3218cf.PRIMARY, EnumC3219cg.ADMIN_MOBILEWEB);
        }
        if (!TextUtils.isEmpty(C3159aa.m10962a().m10979a("secondary_admin_mobileweb_addrss", ""))) {
            return C1554c.m6590a(EnumC3218cf.SECONDARY, EnumC3219cg.ADMIN_MOBILEWEB);
        }
        return "http://smm.samsung.com";
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (this.mUploadMessage != null) {
                this.mUploadMessage.onReceiveValue(null);
            }
            this.mUploadMessage = null;
            return;
        }
        if (i == 1 && this.mUploadMessage != null) {
            Uri data = (intent == null || i2 != -1) ? null : intent.getData();
            if (C3250y.f11734b) {
                C3250y.m11450b("result : " + data, getClass().getSimpleName());
            }
            if (Build.VERSION.SDK_INT < 11 && this.mUploadMessage != null) {
                this.mUploadMessage.onReceiveValue(data);
                return;
            }
            Cursor cursorQuery = getActivity().getContentResolver().query(data, null, null, null, null);
            File fileM11134a = null;
            String string = null;
            while (cursorQuery.moveToNext()) {
                if (cursorQuery.getColumnIndex("_data") != -1) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                } else {
                    fileM11134a = C3188bc.m11134a(getActivity(), null, null, data, false);
                }
            }
            if (string != null) {
                File file = new File(string);
                if (C3188bc.m11135a(file)) {
                    fileM11134a = C3188bc.m11134a(getActivity(), file, null, null, false);
                }
            }
            if (this.mUploadMessage != null) {
                if (fileM11134a == null) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Can't resize iamge", getClass().getSimpleName());
                    }
                    this.mUploadMessage.onReceiveValue(data);
                } else {
                    this.mUploadMessage.onReceiveValue(Uri.fromFile(fileM11134a));
                }
                this.mUploadMessage = null;
            }
        }
    }

    private String makePostURL(boolean z) {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService("connectivity");
        StringBuilder sb = new StringBuilder();
        sb.append("Sender=" + C3159aa.m10962a().m10979a("msisdn", "")).append("&");
        sb.append("Version=" + C0816a.f3112a).append("&");
        sb.append("Connection=" + (connectivityManager.getActiveNetworkInfo() != null ? connectivityManager.getActiveNetworkInfo().getTypeName() : connectivityManager.getActiveNetworkInfo())).append("&");
        sb.append("Display=" + Build.DISPLAY).append("&");
        sb.append("Brand=" + Build.BRAND).append("&");
        sb.append("Server=" + C3159aa.m10962a().m10979a("primary_message_addrss", "secondary_message_addrss")).append(" ").append(C3159aa.m10962a().m10979a("primary_contact_addrss", "secondary_contact_addrss")).append(" ").append(C3159aa.m10962a().m10979a("primary_file_addrss", "secondary_file_addrss")).append(" ").append(C3159aa.m10962a().m10979a("primary_sms_address", "secondary_sms_addrss")).append(" ").append(C3159aa.m10962a().m10979a("primary_admin_mobileweb_address", "secondary_admin_mobileweb_addrss")).append(" ").append(C3159aa.m10962a().m10979a("primary_live_mobileweb_address", "secondary_live_mobileweb_addrss")).append(" ").append(C3159aa.m10962a().m10979a("primary_message_wifi_addrss", "secondary_message_wifi_addrss")).append("&");
        sb.append("mode=" + (z ? "1" : "0")).append("&");
        sb.append("Model=" + Build.MODEL).append("&");
        sb.append("IMSI=" + C3171am.m11062e()).append("&");
        sb.append("Push=" + C2117i.m8370a(getActivity()));
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0083 A[Catch: IOException -> 0x00c4, TRY_LEAVE, TryCatch #10 {IOException -> 0x00c4, blocks: (B:38:0x007e, B:40:0x0083), top: B:89:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
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
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.settings.FragmentWebView.showOpenLicence():void");
    }

    class MyClient extends WebViewClient {

        /* renamed from: pd */
        private ProgressDialog f9218pd;

        public MyClient(ProgressDialog progressDialog) {
            this.f9218pd = progressDialog;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C3250y.m11450b("shouldOverrideUrlLoading, url : " + str, getClass().getSimpleName());
            if (str.startsWith("http:")) {
                FragmentWebView.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } else {
                webView.loadUrl(str);
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            C3250y.m11450b("onPageFinished...", getClass().getSimpleName());
            if (FragmentWebView.this.getActivity() != null && this.f9218pd != null && this.f9218pd.isShowing()) {
                this.f9218pd.dismiss();
                C3250y.m11450b("onPageFinished pd dismissed", getClass().getSimpleName());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            webView.setVisibility(8);
            super.onReceivedError(webView, i, str, str2);
            C3250y.m11450b("errorCode=" + i + "failingUrl = " + str2 + "desctiption = " + str, getClass().getSimpleName());
            if (FragmentWebView.this.getActivity() != null && FragmentWebView.this.getActivity() != null) {
                FragmentWebView.this.dialog = AbstractC3271a.m11494a(FragmentWebView.this.getActivity()).mo11500a(FragmentWebView.this.getResources().getString(R.string.toast_error)).mo11509b(FragmentWebView.this.getResources().getString(R.string.toast_network_unable)).mo11515d(R.string.dialog_confirm, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings.FragmentWebView.MyClient.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        FragmentWebView.this.getActivity().finish();
                    }
                }).mo11505a();
                FragmentWebView.this.dialog.show();
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
            C3250y.m11450b("progress=" + i, getClass().getSimpleName());
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            C3250y.m11450b("errorCode=" + i + "failingUrl = " + str2 + "desctiption = " + str, getClass().getSimpleName());
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            C3250y.m11450b("openFileChooser under SDK 10", getClass().getSimpleName());
            FragmentWebView.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            if (!BuddyProfileActivity.m3573a(FragmentWebView.this.getActivity(), intent)) {
                intent = new Intent();
                intent.setAction("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("image/*");
            }
            FragmentWebView.this.startActivityForResult(intent, 1);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            C3250y.m11450b("openFileChooser over SDK 11 and under SDK 15", getClass().getSimpleName());
            FragmentWebView.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            if (!BuddyProfileActivity.m3573a(FragmentWebView.this.getActivity(), intent)) {
                intent = new Intent();
                intent.setAction("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("image/*");
            }
            FragmentWebView.this.startActivityForResult(intent, 1);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            C3250y.m11450b("openFileChooser over SDK 16", getClass().getSimpleName());
            FragmentWebView.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            FragmentWebView.this.startActivityForResult(intent, 1);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            super.onJsAlert(webView, str, str2, jsResult);
            if (FragmentWebView.this.getActivity() != null) {
                AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(FragmentWebView.this.getActivity());
                abstractC3271aM11494a.mo11495a(R.string.app_name);
                abstractC3271aM11494a.mo11509b(str2);
                abstractC3271aM11494a.mo11515d(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings.FragmentWebView.InternalWebChromeClient.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.confirm();
                    }
                });
                InterfaceC3274d interfaceC3274dMo11505a = abstractC3271aM11494a.mo11505a();
                interfaceC3274dMo11505a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.sec.chaton.settings.FragmentWebView.InternalWebChromeClient.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        jsResult.cancel();
                    }
                });
                interfaceC3274dMo11505a.show();
            }
            return true;
        }
    }
}
