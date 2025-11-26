package com.sec.chaton.sns.p115ui;

import android.R;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.sns.p113a.InterfaceC4366c;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: VKontakteDialog.java */
/* renamed from: com.sec.chaton.sns.ui.ar */
/* loaded from: classes.dex */
public class DialogC4464ar extends Dialog {

    /* renamed from: a */
    static final float[] f16122a = {30.0f, 60.0f};

    /* renamed from: b */
    static final float[] f16123b = {30.0f, 60.0f};

    /* renamed from: c */
    static final FrameLayout.LayoutParams f16124c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d */
    public Context f16125d;

    /* renamed from: e */
    private String f16126e;

    /* renamed from: f */
    private InterfaceC4366c f16127f;

    /* renamed from: g */
    private ProgressDialog f16128g;

    /* renamed from: h */
    private WebView f16129h;

    /* renamed from: i */
    private FrameLayout f16130i;

    /* renamed from: j */
    private ImageView f16131j;

    /* renamed from: k */
    private boolean f16132k;

    public DialogC4464ar(Context context, String str, InterfaceC4366c interfaceC4366c) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f16132k = false;
        this.f16125d = context;
        this.f16126e = str;
        this.f16127f = interfaceC4366c;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setOnCancelListener(new DialogInterfaceOnCancelListenerC4465as(this));
        this.f16128g = ProgressDialogC4926s.m18727a(this.f16125d, null, this.f16125d.getResources().getString(com.sec.chaton.R.string.dialog_connecting_server));
        this.f16128g.setCanceledOnTouchOutside(false);
        this.f16128g.setOnCancelListener(new DialogInterfaceOnCancelListenerC4466at(this));
        requestWindowFeature(1);
        this.f16130i = new FrameLayout(getContext());
        m16955a();
        m16956a(this.f16131j.getDrawable().getIntrinsicWidth() / 2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        this.f16130i.addView(this.f16131j, layoutParams);
        addContentView(this.f16130i, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f16129h != null) {
            this.f16129h.stopLoading();
        }
        if (!this.f16132k) {
            if (this.f16128g.isShowing()) {
                this.f16128g.dismiss();
            }
            super.dismiss();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f16132k = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f16132k = false;
        super.onAttachedToWindow();
    }

    /* renamed from: a */
    private void m16955a() throws Resources.NotFoundException {
        this.f16131j = new ImageView(getContext());
        this.f16131j.setOnClickListener(new ViewOnClickListenerC4467au(this));
        this.f16131j.setImageDrawable(getContext().getResources().getDrawable(com.sec.chaton.R.drawable.com_facebook_close));
        this.f16131j.setVisibility(4);
    }

    /* renamed from: a */
    private void m16956a(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f16129h = new WebView(getContext());
        WebSettings settings = this.f16129h.getSettings();
        settings.setSavePassword(false);
        settings.setJavaScriptEnabled(true);
        settings.getUserAgentString();
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(PushClientApplication.m12499n().getDir("webview_database", 0).getPath());
        this.f16129h.requestFocus(130);
        this.f16129h.setVerticalScrollbarOverlay(true);
        this.f16129h.setHorizontalScrollBarEnabled(false);
        this.f16129h.loadUrl(this.f16126e);
        this.f16129h.setLayoutParams(f16124c);
        this.f16129h.setVisibility(4);
        this.f16129h.setWebViewClient(new C4468av(this, null));
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.f16129h);
        this.f16130i.addView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m16958b() {
        setOnDismissListener(null);
        dismiss();
    }
}
