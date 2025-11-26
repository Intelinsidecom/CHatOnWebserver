package com.sec.chaton.sns.p115ui;

import android.R;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.sns.C4363a;
import com.sec.chaton.sns.p113a.InterfaceC4366c;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: OdnokDialog.java */
/* renamed from: com.sec.chaton.sns.ui.a */
/* loaded from: classes.dex */
public class DialogC4446a extends Dialog {

    /* renamed from: d */
    public Context f16072d;

    /* renamed from: f */
    private String f16073f;

    /* renamed from: g */
    private InterfaceC4366c f16074g;

    /* renamed from: h */
    private ProgressDialog f16075h;

    /* renamed from: i */
    private WebView f16076i;

    /* renamed from: j */
    private FrameLayout f16077j;

    /* renamed from: k */
    private ImageView f16078k;

    /* renamed from: l */
    private boolean f16079l;

    /* renamed from: e */
    private static final Integer f16071e = -10;

    /* renamed from: a */
    static final float[] f16068a = {30.0f, 60.0f};

    /* renamed from: b */
    static final float[] f16069b = {30.0f, 60.0f};

    /* renamed from: c */
    static final FrameLayout.LayoutParams f16070c = new FrameLayout.LayoutParams(-1, -1);

    public DialogC4446a(Context context, String str, InterfaceC4366c interfaceC4366c) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f16079l = false;
        this.f16072d = context;
        this.f16073f = str;
        this.f16074g = interfaceC4366c;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setOnCancelListener(new DialogInterfaceOnCancelListenerC4473b(this));
        this.f16075h = ProgressDialogC4926s.m18727a(this.f16072d, null, this.f16072d.getResources().getString(com.sec.chaton.R.string.dialog_connecting_server));
        this.f16075h.setCanceledOnTouchOutside(false);
        this.f16075h.setOnCancelListener(new DialogInterfaceOnCancelListenerC4478c(this));
        requestWindowFeature(1);
        this.f16077j = new FrameLayout(getContext());
        m16928b();
        m16924a(this.f16078k.getDrawable().getIntrinsicWidth() / 2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        this.f16077j.addView(this.f16078k, layoutParams);
        addContentView(this.f16077j, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f16076i != null) {
            this.f16076i.stopLoading();
        }
        if (!this.f16079l) {
            if (this.f16075h.isShowing()) {
                this.f16075h.dismiss();
            }
            super.dismiss();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f16079l = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f16079l = false;
        super.onAttachedToWindow();
    }

    /* renamed from: b */
    private void m16928b() throws Resources.NotFoundException {
        this.f16078k = new ImageView(getContext());
        this.f16078k.setOnClickListener(new ViewOnClickListenerC4479d(this));
        this.f16078k.setImageDrawable(getContext().getResources().getDrawable(com.sec.chaton.R.drawable.com_facebook_close));
        this.f16078k.setVisibility(4);
    }

    /* renamed from: a */
    private void m16924a(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f16076i = new WebView(getContext());
        WebSettings settings = this.f16076i.getSettings();
        settings.setSavePassword(false);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.getUserAgentString();
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(PushClientApplication.m12499n().getDir("webview_database", 0).getPath());
        this.f16076i.requestFocus(130);
        this.f16076i.setVerticalScrollbarOverlay(true);
        this.f16076i.setHorizontalScrollBarEnabled(false);
        this.f16076i.loadUrl(this.f16073f);
        this.f16076i.setLayoutParams(f16070c);
        this.f16076i.setVisibility(4);
        this.f16076i.setWebViewClient(new C4486h(this, null));
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.f16076i);
        this.f16077j.addView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m16929c() {
        AbstractC4932a.m18733a(this.f16072d).mo18746b(com.sec.chaton.R.string.od_login_error_dialog_message).mo18755c("Ok", new DialogInterfaceOnClickListenerC4480e(this)).mo18734a(com.sec.chaton.R.string.od_login_error_dialog_title).mo18752b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m16926a(String str) {
        if (str != null) {
            try {
                if (str.startsWith("okauth://ok")) {
                    Uri uri = Uri.parse(str);
                    if (!str.contains("error=")) {
                        String queryParameter = uri.getQueryParameter("code");
                        if (queryParameter == null) {
                            this.f16074g.mo2271a();
                        } else {
                            new C4481f(this, queryParameter).start();
                        }
                    } else {
                        if ("access_denied".equals(uri.getQueryParameter("error"))) {
                            C4363a.m16557f(this.f16072d);
                        }
                        this.f16074g.mo2271a();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
