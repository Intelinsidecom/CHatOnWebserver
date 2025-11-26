package com.sec.chaton.settings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.widget.SMSProgressBar;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes.dex */
public class ActivityAbout extends BaseActivity {

    /* renamed from: a */
    Context f2971a;

    /* renamed from: b */
    String f2972b;

    /* renamed from: c */
    String f2973c;

    /* renamed from: d */
    protected Boolean f2974d;

    /* renamed from: e */
    private TextView f2975e;

    /* renamed from: f */
    private TextView f2976f;

    /* renamed from: g */
    private Button f2977g;

    /* renamed from: h */
    private Button f2978h;

    /* renamed from: i */
    private ProgressDialog f2979i;

    /* renamed from: a */
    public static void m3120a(Context context) {
        String string = ChatONPref.m3519a().getString("UpdateUrl", "");
        String string2 = ChatONPref.m3519a().getString("SamsungappsUrl", "");
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri uri = Uri.parse(string2);
        intent.addFlags(335544320);
        intent.setData(uri);
        ChatONLogWriter.m3511e("uri :" + uri, "ActivityAbout");
        try {
            context.startActivity(intent);
            ChatONLogWriter.m3506b("apps market was installed in the device", "ActivityAbout");
        } catch (ActivityNotFoundException e) {
            try {
                intent.setData(Uri.parse(string));
                context.startActivity(intent);
                ChatONLogWriter.m3506b("There is no apps market in the device", "ActivityAbout");
            } catch (ActivityNotFoundException e2) {
                intent.setData(Uri.parse("http://market.android.com/details?id=com.sec.chaton"));
                context.startActivity(intent);
                ChatONLogWriter.m3499a("There is no apps and google markget in the device", "ActivityAbout");
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_settings_about);
        this.f2971a = this;
        this.f2979i = (ProgressDialog) new SMSProgressBar(this).onCreate(C0062R.string.setting_about_version_checking);
        this.f2975e = (TextView) findViewById(C0062R.id.setting_current_version);
        this.f2976f = (TextView) findViewById(C0062R.id.setting_upgrade_version);
        try {
            this.f2972b = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            this.f2972b = "";
        }
        this.f2975e.setText(getString(C0062R.string.setting_about_current_ver) + " " + this.f2972b);
        this.f2973c = ChatONPref.m3519a().getString("UpdateTargetVersion", "");
        this.f2976f.setText(getString(C0062R.string.setting_about_latest_ver) + " " + (this.f2973c.length() > 0 ? this.f2973c : this.f2972b));
        this.f2976f.setVisibility(0);
        this.f2974d = Boolean.valueOf(ChatONPref.m3519a().contains("UpdateIsCritical"));
        this.f2977g = (Button) findViewById(C0062R.id.setting_about_btn1);
        if (this.f2974d.booleanValue()) {
            this.f2977g.setOnClickListener(new ViewOnClickListenerC0485bg(this));
        } else {
            this.f2977g.setEnabled(false);
        }
        this.f2978h = (Button) findViewById(C0062R.id.setting_about_btn_license);
        this.f2978h.setOnClickListener(new ViewOnClickListenerC0486bh(this));
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) throws Throwable {
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        InputStream inputStreamOpen;
        Dialog dialog;
        InputStreamReader inputStreamReader2 = null;
        try {
            switch (i) {
                case 1:
                    try {
                        StringBuilder sb = new StringBuilder(2048);
                        char[] cArr = new char[2048];
                        inputStreamOpen = getAssets().open("NOTICE.html");
                        try {
                            InputStreamReader inputStreamReader3 = new InputStreamReader(inputStreamOpen);
                            while (true) {
                                try {
                                    int i2 = inputStreamReader3.read(cArr);
                                    if (i2 < 0) {
                                        if (inputStreamOpen != null) {
                                            try {
                                                inputStreamOpen.close();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        if (inputStreamReader3 != null) {
                                            inputStreamReader3.close();
                                        }
                                        if (TextUtils.isEmpty(sb)) {
                                            ChatONLogWriter.m3499a("License file is empty", "ActivityAbout");
                                            return null;
                                        }
                                        WebView webView = new WebView(this);
                                        webView.loadDataWithBaseURL(null, sb.toString(), "text/html", "utf-8", null);
                                        webView.setWebViewClient(new WebViewClient());
                                        return new AlertDialog.Builder(this).setTitle(C0062R.string.settings_license).setView(webView).create();
                                    }
                                    sb.append(cArr, 0, i2);
                                } catch (FileNotFoundException e2) {
                                    e = e2;
                                    inputStreamReader = inputStreamReader3;
                                    ChatONLogWriter.m3511e("License file not found", "ActivityAbout");
                                    e.printStackTrace();
                                    if (inputStreamOpen != null) {
                                        try {
                                            inputStreamOpen.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                            dialog = null;
                                            return dialog;
                                        }
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    dialog = null;
                                    return dialog;
                                } catch (IOException e4) {
                                    e = e4;
                                    inputStreamReader = inputStreamReader3;
                                    ChatONLogWriter.m3511e("Error reading license", "ActivityAbout");
                                    e.printStackTrace();
                                    if (inputStreamOpen != null) {
                                        try {
                                            inputStreamOpen.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                            dialog = null;
                                            return dialog;
                                        }
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    dialog = null;
                                    return dialog;
                                } catch (Throwable th) {
                                    th = th;
                                    inputStreamReader2 = inputStreamReader3;
                                    inputStream = inputStreamOpen;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    if (inputStreamReader2 != null) {
                                        inputStreamReader2.close();
                                    }
                                    throw th;
                                }
                            }
                        } catch (FileNotFoundException e7) {
                            e = e7;
                            inputStreamReader = null;
                        } catch (IOException e8) {
                            e = e8;
                            inputStreamReader = null;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = inputStreamOpen;
                        }
                    } catch (FileNotFoundException e9) {
                        e = e9;
                        inputStreamReader = null;
                        inputStreamOpen = null;
                    } catch (IOException e10) {
                        e = e10;
                        inputStreamReader = null;
                        inputStreamOpen = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                    }
                default:
                    return null;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader2 = inputStreamReader;
            inputStream = inputStreamOpen;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f2979i.dismiss();
    }
}
