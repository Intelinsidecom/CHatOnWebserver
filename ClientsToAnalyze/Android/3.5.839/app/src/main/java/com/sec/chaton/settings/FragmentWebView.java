package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
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
import com.sec.chaton.base.InterfaceC1061c;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.p055d.C2132m;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.p067j.C2433c;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.util.C3117i;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4838bc;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4867ce;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import org.apache.http.util.EncodingUtils;

/* loaded from: classes.dex */
public class FragmentWebView extends Fragment implements InterfaceC1061c {
    public static final String ERROR_CODE = "ERROR_CODE";
    private static final int FILECHOOSER_RESULTCODE = 1;
    private static final String FILE_NAME = "NOTICE.html";
    public static final String FROM_ABOUT_CHATON = "FROM_ABOUT_CHATON";
    private static final String OUT_STATE_ERROR_CODE = "outstatekeyerrorcode";
    public static final String PARAM_MENU = "PARAM_MENU";
    public static final String REGI_VOC = "REGI_VOC";
    public static final String SHOW_BREADCRUMB = "SHOW_BREADCRUMB";
    private Bundle bundle;
    private String countryletter;
    private InterfaceC4936e dialog;
    private String errorCode;
    private Boolean isFromAboutChaton;
    private C2132m mGLDControl;
    private ValueCallback<Uri> mUploadMessage;
    WebView mWebView;
    private String menu;
    private String serverAddress;
    private String url;

    /* renamed from: pd */
    private ProgressDialog f12778pd = null;
    private final String DEFAULT_SERVER_ADDRESS = "http://smm.samsung.com";
    Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.sec.chaton.settings.FragmentWebView.6
        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            if (FragmentWebView.this.getActivity() != null) {
                C0778b c0778b = (C0778b) message.obj;
                switch (message.what) {
                    case 104:
                        if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                            FragmentWebView.this.dismissProgressBar();
                            FragmentWebView.this.dialog = AbstractC4932a.m18733a(FragmentWebView.this.getActivity()).mo18740a(FragmentWebView.this.getResources().getString(R.string.toast_error)).mo18749b(FragmentWebView.this.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.dialog_confirm, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings.FragmentWebView.6.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    if (FragmentWebView.this.getActivity() != null) {
                                        FragmentWebView.this.getActivity().finish();
                                    }
                                }
                            }).mo18745a();
                            FragmentWebView.this.dialog.show();
                            break;
                        } else {
                            FragmentWebView.this.serverAddress = FragmentWebView.this.getServerAddress();
                            if (FragmentWebView.this.serverAddress == null) {
                                FragmentWebView.this.serverAddress = "http://smm.samsung.com";
                            }
                            FragmentWebView.this.runMobileWeb();
                            break;
                        }
                        break;
                    case 1104:
                        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR && ((GetVersionNotice) c0778b.m3110e()) != null) {
                            if (C4809aa.m18104a().m18121a("server_time", (String) null) != null) {
                                C4809aa.m18108a("accept_time", C4809aa.m18104a().m18121a("server_time", ""));
                            }
                            C4904y.m18639b("[NOTICE] Acccep time : " + C4809aa.m18104a().m18121a("accept_time", ""), getClass().getSimpleName());
                            C4809aa.m18106a("notice", (Integer) 0);
                        }
                        FragmentWebView.this.mWebView.loadUrl(FragmentWebView.this.url);
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Noti url : " + FragmentWebView.this.url, getClass().getSimpleName());
                            break;
                        }
                        break;
                }
            }
        }
    };

    public enum mode {
        voc,
        faq,
        question
    }

    public FragmentWebView() {
    }

    public FragmentWebView(String str) {
        this.errorCode = str;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && bundle.containsKey(OUT_STATE_ERROR_CODE)) {
            this.errorCode = bundle.getString(OUT_STATE_ERROR_CODE);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        View viewInflate = layoutInflater.inflate(R.layout.layout_notice_webview, viewGroup, false);
        this.mWebView = (WebView) viewInflate.findViewById(R.id.webview1);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.setWebChromeClient(new InternalWebChromeClient());
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setVerticalScrollbarOverlay(true);
        String path = PushClientApplication.m12499n().getDir("webview_appcache", 0).getPath();
        this.mWebView.getSettings().setCacheMode(-1);
        this.mWebView.getSettings().setAppCacheMaxSize(8388608L);
        this.mWebView.getSettings().setAppCachePath(path);
        this.mWebView.getSettings().setAllowFileAccess(true);
        this.mWebView.getSettings().setAppCacheEnabled(true);
        if (getActivity() != null) {
            this.f12778pd = ProgressDialogC4926s.m18727a(getActivity(), null, getResources().getString(R.string.dialog_provision_ing));
            this.f12778pd.setCancelable(true);
            this.f12778pd.setCanceledOnTouchOutside(false);
            this.f12778pd.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.sec.chaton.settings.FragmentWebView.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (FragmentWebView.this.getActivity() != null) {
                        FragmentWebView.this.getActivity().finish();
                    }
                }
            });
        }
        this.countryletter = C4809aa.m18104a().m18121a("country_letter", "");
        Locale locale = Locale.getDefault();
        C4904y.m18639b(locale.getLanguage() + locale.getCountry(), getClass().getSimpleName());
        this.bundle = getArguments();
        this.mGLDControl = new C2132m(this.mHandler);
        this.serverAddress = getServerAddress();
        C4904y.m18639b("serverAddress : " + this.serverAddress, getClass().getSimpleName());
        this.isFromAboutChaton = Boolean.valueOf(this.bundle.getBoolean(FROM_ABOUT_CHATON));
        C4904y.m18639b("isFromAboutChaton : " + this.isFromAboutChaton, getClass().getSimpleName());
        if (this.serverAddress != null) {
            runMobileWeb();
        }
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runMobileWeb() throws Throwable {
        if (this.bundle != null) {
            Locale locale = Locale.getDefault();
            String strM18257y = C4822an.m18257y();
            String strM18243k = C4822an.m18243k();
            String strM18236g = C4822an.m18236g();
            if (C4904y.f17872b) {
                C4904y.m18639b(locale.getLanguage() + locale.getCountry(), getClass().getSimpleName());
                C4904y.m18639b("MCC=" + strM18243k + " SCC=" + strM18236g, getClass().getSimpleName());
            }
            if (!C4822an.m18218a() && TextUtils.isEmpty(strM18257y)) {
                strM18257y = C4809aa.m18104a().m18121a("lite_feature_user_disclaimer_mcc_code", "GB");
            }
            if (this.bundle.containsKey(PARAM_MENU)) {
                this.menu = this.bundle.getString(PARAM_MENU);
                C4904y.m18639b("menu=" + this.menu, getClass().getSimpleName());
                if ("Help".equals(this.menu)) {
                    getActivity().setTitle(R.string.settings_support_FAQs);
                    int iM10677a = C2471v.m10677a(getActivity());
                    if (-3 == iM10677a || -2 == iM10677a) {
                        this.dialog = AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.toast_error)).mo18749b(getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.dialog_confirm, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings.FragmentWebView.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (FragmentWebView.this.getActivity() != null) {
                                    FragmentWebView.this.getActivity().finish();
                                }
                            }
                        }).mo18745a();
                        if (getActivity() != null) {
                            this.dialog.show();
                        }
                    }
                    this.mWebView.loadUrl(this.serverAddress + "/mwv/faq.html?l=" + locale.toString());
                } else if ("NewHelp".equals(this.menu)) {
                    int iM10677a2 = C2471v.m10677a(getActivity());
                    if (-3 == iM10677a2 || -2 == iM10677a2) {
                        this.dialog = AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.toast_error)).mo18749b(getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.dialog_confirm, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings.FragmentWebView.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (FragmentWebView.this.getActivity() != null) {
                                    FragmentWebView.this.getActivity().finish();
                                }
                            }
                        }).mo18745a();
                        if (getActivity() != null) {
                            this.dialog.show();
                        }
                    }
                    String strMakeURLForMuse = makeURLForMuse(getActivity(), mode.voc, null);
                    C4904y.m18639b("<PostData>\n" + strMakeURLForMuse, getClass().getSimpleName());
                    this.mWebView.postUrl("http://help.content.samsung.com/csmobile/auth/gosupport.do", EncodingUtils.getBytes(strMakeURLForMuse, "BASE64"));
                } else if ("Upgrade".equals(this.menu)) {
                    this.mWebView.loadUrl("https://market.android.com/");
                } else if ("Q&A".equals(this.menu)) {
                    this.mWebView.loadUrl("http://211.239.154.3:9090/chaton/webview/android/qna/index.html");
                } else if ("TERMS_AND_CONDITION".equals(this.menu)) {
                    getActivity().setTitle(R.string.setting_about_btn1_text);
                    int iM10677a3 = C2471v.m10677a(getActivity());
                    if (-3 == iM10677a3 || -2 == iM10677a3) {
                        this.dialog = AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.toast_error)).mo18749b(getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.dialog_confirm, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings.FragmentWebView.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (FragmentWebView.this.getActivity() != null) {
                                    FragmentWebView.this.getActivity().finish();
                                }
                            }
                        }).mo18745a();
                        if (getActivity() != null) {
                            this.dialog.show();
                        }
                    }
                    if (this.isFromAboutChaton.booleanValue()) {
                        if (TextUtils.isEmpty(strM18257y)) {
                            this.url = this.serverAddress + "/mwv/disclaimer.html?c=234&f=TC";
                        } else {
                            this.url = this.serverAddress + "/mwv/disclaimer.html?iso2=" + strM18257y + "&f=TC";
                        }
                    } else if (!TextUtils.isEmpty(this.countryletter)) {
                        this.url = this.serverAddress + "/mwv/disclaimer.html?iso2=" + this.countryletter + "&f=TC";
                    } else if (strM18243k == null) {
                        this.url = this.serverAddress + "/mwv/disclaimer.html?c=234&f=TC";
                    } else {
                        this.url = this.serverAddress + "/mwv/disclaimer.html?c=" + strM18243k + "&f=TC";
                    }
                    this.mWebView.loadUrl(this.url);
                    C4904y.m18639b("TERMS_AND_CONDITION url : " + this.url, getClass().getSimpleName());
                } else if ("PRIVACY_POLICY".equals(this.menu)) {
                    getActivity().setTitle(R.string.setting_about_btn1_text);
                    if (this.isFromAboutChaton.booleanValue()) {
                        if (TextUtils.isEmpty(strM18257y)) {
                            this.url = this.serverAddress + "/mwv/disclaimer.html?c=234&f=PP";
                        } else {
                            this.url = this.serverAddress + "/mwv/disclaimer.html?iso2=" + strM18257y + "&f=PP";
                        }
                    } else if (!TextUtils.isEmpty(this.countryletter)) {
                        this.url = this.serverAddress + "/mwv/disclaimer.html?iso2=" + this.countryletter + "&f=PP";
                    } else if (strM18243k == null) {
                        this.url = this.serverAddress + "/mwv/disclaimer.html?c=234&f=PP";
                    } else {
                        this.url = this.serverAddress + "/mwv/disclaimer.html?c=" + strM18243k + "&f=PP";
                    }
                    this.mWebView.loadUrl(this.url);
                    C4904y.m18639b("PRIVACY_POLICY url : " + this.url, getClass().getSimpleName());
                } else if ("PUSH_MARKETING".equals(this.menu)) {
                    getActivity().setTitle(R.string.setting_about_btn1_text);
                    if (this.isFromAboutChaton.booleanValue()) {
                        if (TextUtils.isEmpty(strM18257y)) {
                            this.url = this.serverAddress + "/mwv/disclaimer.html?c=234&f=SMM";
                        } else {
                            this.url = this.serverAddress + "/mwv/disclaimer.html?iso2=" + strM18257y + "&f=SMM";
                        }
                    } else if (!TextUtils.isEmpty(this.countryletter)) {
                        this.url = this.serverAddress + "/mwv/disclaimer.html?iso2=" + this.countryletter + "&f=SMM";
                    } else if (strM18243k == null) {
                        this.url = this.serverAddress + "/mwv/disclaimer.html?c=234&f=SMM";
                    } else {
                        this.url = this.serverAddress + "/mwv/disclaimer.html?c=" + strM18243k + "&f=SMM";
                    }
                    this.mWebView.loadUrl(this.url);
                    C4904y.m18639b("PUSH_MARKETING url : " + this.url, getClass().getSimpleName());
                } else if ("ACCEPT_USE_DATA".equals(this.menu)) {
                    getActivity().setTitle(R.string.setting_about_btn1_text);
                    if (!TextUtils.isEmpty(this.countryletter)) {
                        this.url = this.serverAddress + "/mwv/disclaimer.html?iso2=" + this.countryletter + "&f=PUA";
                    } else if (strM18243k == null) {
                        this.url = this.serverAddress + "/mwv/disclaimer.html?c=234&f=PUA";
                    } else {
                        this.url = this.serverAddress + "/mwv/disclaimer.html?c=" + strM18243k + "&f=PUA";
                    }
                    this.mWebView.loadUrl(this.url);
                    C4904y.m18639b("ACCEPT_USE_DATA url : " + this.url, getClass().getSimpleName());
                } else if ("Noti".equals(this.menu)) {
                    getActivity().setTitle(R.string.attach_title_announcements);
                    if (!TextUtils.isEmpty(strM18257y)) {
                        this.url = this.serverAddress + "/mwv/notice.html?l=" + locale.toString() + "&iso2=" + strM18257y;
                    } else if (strM18243k != null) {
                        this.url = this.serverAddress + "/mwv/notice.html?l=" + locale.toString() + "&c=" + strM18243k;
                    } else {
                        this.url = this.serverAddress + "/mwv/notice.html?l=" + locale.toString();
                    }
                    int iM10677a4 = C2471v.m10677a(getActivity());
                    if (-3 == iM10677a4 || -2 == iM10677a4) {
                        this.dialog = AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.toast_error)).mo18749b(getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.dialog_confirm, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings.FragmentWebView.5
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (FragmentWebView.this.getActivity() != null) {
                                    FragmentWebView.this.getActivity().finish();
                                }
                            }
                        }).mo18745a();
                        if (getActivity() != null) {
                            this.dialog.show();
                        }
                    }
                    new C2122ca(this.mHandler).m9471b();
                } else if ("License".equals(this.menu)) {
                    getActivity().setTitle(R.string.settings_license);
                    showOpenLicence();
                } else if ("VOC".equals(this.menu)) {
                    getActivity().setTitle(R.string.contact_us);
                    if (this.bundle.containsKey(REGI_VOC)) {
                    }
                    String strMakeURLForMuse2 = makeURLForMuse(getActivity(), mode.voc, this.errorCode);
                    C4904y.m18639b("<PostData>\n" + strMakeURLForMuse2, getClass().getSimpleName());
                    this.mWebView.postUrl("http://help.content.samsung.com/csmobile/auth/gosupport.do", EncodingUtils.getBytes(strMakeURLForMuse2, "BASE64"));
                } else if ("CHATONV_3RDPARTY_DISCLAIMER".equals(this.menu)) {
                    this.url = this.serverAddress + "/mwv/agreement.html?c=450&l=ko_rKR";
                    this.mWebView.loadUrl(this.url);
                    C4904y.m18639b("CHATONV_3RDPARTY_DISCLAIMER url : " + this.url, getClass().getSimpleName());
                } else if ("SDS_TERMS_AND_CONDITION".equals(this.menu)) {
                    this.url = "http://www.coolots.com/chatonv/sdsterms.html";
                    this.mWebView.loadUrl(this.url);
                    C4904y.m18639b("SDS_TERMS_AND_CONDITION url : " + this.url, getClass().getSimpleName());
                } else if ("SDS_DOWNLOAD_CHATON_V".equals(this.menu)) {
                    this.url = "http://www.coolots.com/chatonv/download.html";
                    this.mWebView.loadUrl(this.url);
                    C4904y.m18639b("SDS_DOWNLOAD_CHATON_V url : " + this.url, getClass().getSimpleName());
                }
            }
            this.mWebView.setWebViewClient(new MyClient(this.f12778pd));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(OUT_STATE_ERROR_CODE, this.errorCode);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroyView", getClass().getSimpleName());
        }
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
        if (this.dialog != null && this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
        dismissProgressBar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissProgressBar() {
        if (getActivity() != null && this.f12778pd != null && this.f12778pd.isShowing()) {
            this.f12778pd.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getServerAddress() {
        if (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("primary_admin_mobileweb_address", ""))) {
            return C2433c.m10534a(EnumC4867ce.PRIMARY, EnumC4868cf.ADMIN_MOBILEWEB);
        }
        if (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("secondary_admin_mobileweb_addrss", ""))) {
            return C2433c.m10534a(EnumC4867ce.SECONDARY, EnumC4868cf.ADMIN_MOBILEWEB);
        }
        this.mGLDControl.m9552a();
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        File fileM18307a;
        String string;
        if (i2 != -1) {
            if (this.mUploadMessage != null) {
                this.mUploadMessage.onReceiveValue(null);
            }
            this.mUploadMessage = null;
            return;
        }
        if (i == 1 && this.mUploadMessage != null) {
            Uri data = (intent == null || i2 != -1) ? null : intent.getData();
            if (C4904y.f17872b) {
                C4904y.m18639b("result : " + data, getClass().getSimpleName());
            }
            if (Build.VERSION.SDK_INT < 11 && this.mUploadMessage != null) {
                this.mUploadMessage.onReceiveValue(data);
                return;
            }
            Cursor cursorQuery = getActivity().getContentResolver().query(data, null, null, null, null);
            if (cursorQuery != null) {
                fileM18307a = null;
                string = null;
                while (cursorQuery.moveToNext()) {
                    if (cursorQuery.getColumnIndex("_data") != -1) {
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                    } else {
                        fileM18307a = C4838bc.m18307a(getActivity(), null, null, data, false);
                    }
                }
                cursorQuery.close();
            } else {
                fileM18307a = null;
                string = null;
            }
            if (string != null) {
                File file = new File(string);
                if (C4838bc.m18308a(file)) {
                    fileM18307a = C4838bc.m18307a(getActivity(), file, null, null, false);
                }
            }
            if (this.mUploadMessage != null) {
                if (fileM18307a == null) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Can't resize iamge", getClass().getSimpleName());
                    }
                    this.mUploadMessage.onReceiveValue(data);
                } else {
                    this.mUploadMessage.onReceiveValue(Uri.fromFile(fileM18307a));
                }
                this.mUploadMessage = null;
            }
        }
    }

    private String makePostURL(boolean z, String str) {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService("connectivity");
        StringBuilder sb = new StringBuilder();
        sb.append("Sender=" + C4809aa.m18104a().m18121a("msisdn", "")).append("&");
        sb.append("Version=" + C1427a.f5063a).append("&");
        sb.append("Connection=" + (connectivityManager.getActiveNetworkInfo() != null ? connectivityManager.getActiveNetworkInfo().getTypeName() : connectivityManager.getActiveNetworkInfo())).append("&");
        sb.append("Display=" + Build.DISPLAY).append("&");
        sb.append("Brand=" + Build.BRAND).append("&");
        sb.append("Server=" + C4809aa.m18104a().m18121a("primary_message_addrss", "secondary_message_addrss")).append(" ").append(C4809aa.m18104a().m18121a("primary_contact_addrss", "secondary_contact_addrss")).append(" ").append(C4809aa.m18104a().m18121a("primary_file_addrss", "secondary_file_addrss")).append(" ").append(C4809aa.m18104a().m18121a("primary_sms_address", "secondary_sms_addrss")).append(" ").append(C4809aa.m18104a().m18121a("primary_admin_mobileweb_address", "secondary_admin_mobileweb_addrss")).append(" ").append(C4809aa.m18104a().m18121a("primary_live_mobileweb_address", "secondary_live_mobileweb_addrss")).append(" ").append(C4809aa.m18104a().m18121a("primary_message_wifi_addrss", "secondary_message_wifi_addrss")).append("&");
        sb.append("mode=" + (z ? Spam.ACTIVITY_REPORT : Spam.ACTIVITY_CANCEL)).append("&");
        sb.append("Model=" + Build.MODEL).append("&");
        sb.append("IMSI=" + C4822an.m18238h()).append("&");
        sb.append("Push=" + C3117i.m12712a(getActivity()));
        if (!TextUtils.isEmpty(str)) {
            sb.append("&").append("ErrorCode=" + str);
        }
        return sb.toString();
    }

    public static String makeURLForMuse(Context context, mode modeVar, String str) throws Resources.NotFoundException {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        String langugaeForCS = getLangugaeForCS(context);
        StringBuilder sb = new StringBuilder();
        sb.append("http://help.content.samsung.com/csmobile/auth/gosupport.do").append("?");
        sb.append("serviceCd=chaton").append("&");
        sb.append("_common_country=" + C4822an.m18257y()).append("&");
        sb.append("_common_lang=" + langugaeForCS).append("&");
        if (modeVar.equals(mode.voc)) {
            sb.append("targetUrl=/ticket/createQuestionTicket.do").append("&");
        } else if (modeVar.equals(mode.faq)) {
            sb.append("targetUrl=/faq/searchFaq.do").append("&");
        } else if (modeVar.equals(mode.question)) {
            sb.append("targetUrl=/ticket/searchTicketList.do").append("&");
        }
        sb.append("chnlCd=ODC").append("&");
        sb.append("mcc=" + (C4822an.m18243k() != null ? C4822an.m18243k() : C4822an.m18241i())).append("&");
        sb.append("saccountID=" + C4859bx.m18389b(context)).append("&");
        sb.append("mnc=" + (C4822an.m18244l() != null ? C4822an.m18244l() : C4822an.m18242j())).append("&");
        sb.append("brandNm=" + C4822an.m18193C()).append("&");
        try {
            sb.append("dvcModelCd=" + URLEncoder.encode(C4822an.m18231e(), "UTF-8")).append("&");
        } catch (UnsupportedEncodingException e) {
            sb.append("dvcModelCd=" + C4822an.m18231e()).append("&");
            if (C4904y.f17875e) {
                C4904y.m18634a(e.toString(), "makeURLForMuse");
            }
        }
        sb.append("odcVersion=ChatON" + C1427a.f5063a).append("&");
        sb.append(new StringBuilder().append("msisdn=").append(C4809aa.m18104a().m18121a("msisdn", (String) null)).toString() != null ? C4809aa.m18104a().m18121a("msisdn", (String) null) : C4822an.m18234f()).append("&");
        sb.append("connectionType=" + (connectivityManager.getActiveNetworkInfo() != null ? connectivityManager.getActiveNetworkInfo().getTypeName() : connectivityManager.getActiveNetworkInfo())).append("&");
        sb.append("closeHeaderYn=Y").append("&");
        sb.append("closeFooterYn=Y");
        if (!TextUtils.isEmpty(str)) {
            sb.append("&").append("odcErrCd=" + str);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("Final URL : " + sb.toString(), "makeURLForMuse");
        }
        return sb.toString();
    }

    private static String getLangugaeForCS(Context context) throws Resources.NotFoundException {
        String simpleName = context.getClass().getSimpleName();
        Locale locale = context.getResources().getConfiguration().locale;
        String lowerCase = "en_gb";
        if (locale != null) {
            lowerCase = locale.getLanguage();
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("Start getLangugaeForCS : " + lowerCase, simpleName);
        }
        if ("en".equals(lowerCase) || "ar".equals(lowerCase) || "zh".equals(lowerCase) || "fr".equals(lowerCase)) {
            if (Locale.getDefault() != null) {
                lowerCase = Locale.getDefault().toString().toLowerCase();
            }
        } else {
            if ("pt".equals(lowerCase) || "es".equals(lowerCase)) {
                CharSequence[] textArray = context.getResources().getTextArray(R.array.latin_america_iso_list);
                String country = "";
                if (locale != null) {
                    country = locale.getCountry();
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("getLangugaeForCS, country : " + country, simpleName);
                }
                for (CharSequence charSequence : textArray) {
                    if (charSequence.equals(country)) {
                        lowerCase = lowerCase + "_latn";
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Final getLangugaeForCS : " + lowerCase, simpleName);
                        }
                    }
                }
                if (Locale.getDefault() != null) {
                    lowerCase = Locale.getDefault().toString().toLowerCase();
                }
            }
            return lowerCase;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("Final getLangugaeForCS : " + lowerCase, simpleName);
        }
        return lowerCase;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0086 A[Catch: IOException -> 0x00db, TRY_LEAVE, TryCatch #16 {IOException -> 0x00db, blocks: (B:38:0x0081, B:40:0x0086), top: B:91:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.settings.FragmentWebView.showOpenLicence():void");
    }

    class MyClient extends WebViewClient {

        /* renamed from: pd */
        private ProgressDialog f12779pd;
        private boolean redirect;

        public MyClient(ProgressDialog progressDialog) {
            this.f12779pd = progressDialog;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C4904y.m18639b("shouldOverrideUrlLoading, url : " + str, getClass().getSimpleName());
            this.redirect = true;
            webView.loadUrl(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (C4904y.f17872b) {
                C4904y.m18639b("onPageStarted, url : " + str, getClass().getSimpleName());
            }
            this.redirect = false;
            if (FragmentWebView.this.getActivity() != null && this.f12779pd != null && !this.f12779pd.isShowing()) {
                this.f12779pd.show();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            C4904y.m18639b("onPageFinished, url : " + str, getClass().getSimpleName());
            if (!this.redirect && FragmentWebView.this.getActivity() != null && this.f12779pd != null && this.f12779pd.isShowing()) {
                this.f12779pd.dismiss();
                C4904y.m18639b("onPageFinished pd dismissed", getClass().getSimpleName());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            webView.setVisibility(8);
            super.onReceivedError(webView, i, str, str2);
            C4904y.m18639b("errorCode=" + i + "failingUrl = " + str2 + "desctiption = " + str, getClass().getSimpleName());
            if (FragmentWebView.this.getActivity() != null) {
                if (FragmentWebView.this.dialog == null || !FragmentWebView.this.dialog.isShowing()) {
                    FragmentWebView.this.dialog = AbstractC4932a.m18733a(FragmentWebView.this.getActivity()).mo18740a(FragmentWebView.this.getResources().getString(R.string.toast_error)).mo18749b(FragmentWebView.this.getResources().getString(R.string.toast_network_unable)).mo18756d(R.string.dialog_confirm, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings.FragmentWebView.MyClient.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            if (FragmentWebView.this.getActivity() != null) {
                                FragmentWebView.this.getActivity().finish();
                            }
                        }
                    }).mo18745a();
                    if (FragmentWebView.this.getActivity() != null) {
                        FragmentWebView.this.dialog.show();
                    }
                }
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
            C4904y.m18639b("progress=" + i, getClass().getSimpleName());
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            C4904y.m18639b("errorCode=" + i + "failingUrl = " + str2 + "desctiption = " + str, getClass().getSimpleName());
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            C4904y.m18639b("openFileChooser under SDK 10", getClass().getSimpleName());
            FragmentWebView.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            if (!BuddyProfileActivity.m6743a(FragmentWebView.this.getActivity(), intent)) {
                intent = new Intent();
                intent.setAction("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("image/*");
            }
            try {
                FragmentWebView.this.startActivityForResult(intent, 1);
            } catch (ActivityNotFoundException e) {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, getClass().getSimpleName());
                }
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            C4904y.m18639b("openFileChooser over SDK 11 and under SDK 15", getClass().getSimpleName());
            FragmentWebView.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            if (!BuddyProfileActivity.m6743a(FragmentWebView.this.getActivity(), intent)) {
                intent = new Intent();
                intent.setAction("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("image/*");
            }
            try {
                FragmentWebView.this.startActivityForResult(intent, 1);
            } catch (ActivityNotFoundException e) {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, getClass().getSimpleName());
                }
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            C4904y.m18639b("openFileChooser over SDK 16", getClass().getSimpleName());
            FragmentWebView.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            try {
                FragmentWebView.this.startActivityForResult(intent, 1);
            } catch (ActivityNotFoundException e) {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, getClass().getSimpleName());
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            super.onJsAlert(webView, str, str2, jsResult);
            if (FragmentWebView.this.getActivity() != null) {
                AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(FragmentWebView.this.getActivity());
                abstractC4932aM18733a.mo18734a(R.string.app_name);
                abstractC4932aM18733a.mo18749b(str2);
                abstractC4932aM18733a.mo18756d(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings.FragmentWebView.InternalWebChromeClient.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.confirm();
                    }
                });
                InterfaceC4936e interfaceC4936eMo18745a = abstractC4932aM18733a.mo18745a();
                interfaceC4936eMo18745a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.sec.chaton.settings.FragmentWebView.InternalWebChromeClient.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        jsResult.cancel();
                    }
                });
                interfaceC4936eMo18745a.show();
            }
            return true;
        }
    }

    @Override // com.sec.chaton.base.InterfaceC1061c
    public boolean onBackKeyPressed() {
        if (!this.mWebView.canGoBack()) {
            return false;
        }
        this.mWebView.goBack();
        return true;
    }
}
