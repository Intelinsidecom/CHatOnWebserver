package com.sec.chaton.sns.p115ui;

import android.R;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.sns.p113a.InterfaceC4366c;
import com.sec.chaton.widget.ProgressDialogC4926s;
import java.util.Timer;
import p010b.InterfaceC0319f;

/* compiled from: TwDialog.java */
/* renamed from: com.sec.chaton.sns.ui.ai */
/* loaded from: classes.dex */
public class DialogC4455ai extends Dialog {

    /* renamed from: a */
    static final float[] f16098a = {30.0f, 60.0f};

    /* renamed from: b */
    static final float[] f16099b = {30.0f, 60.0f};

    /* renamed from: c */
    static final FrameLayout.LayoutParams f16100c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d */
    public Context f16101d;

    /* renamed from: e */
    AsyncTaskC4461ao f16102e;

    /* renamed from: f */
    Handler f16103f;

    /* renamed from: g */
    private InterfaceC0319f f16104g;

    /* renamed from: h */
    private String f16105h;

    /* renamed from: i */
    private String f16106i;

    /* renamed from: j */
    private InterfaceC4366c f16107j;

    /* renamed from: k */
    private ProgressDialog f16108k;

    /* renamed from: l */
    private WebView f16109l;

    /* renamed from: m */
    private FrameLayout f16110m;

    /* renamed from: n */
    private ImageView f16111n;

    /* renamed from: o */
    private boolean f16112o;

    /* renamed from: p */
    private Timer f16113p;

    public DialogC4455ai(Context context, InterfaceC0319f interfaceC0319f, String str, InterfaceC4366c interfaceC4366c) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f16106i = null;
        this.f16112o = false;
        this.f16113p = null;
        this.f16102e = null;
        this.f16103f = new HandlerC4459am(this);
        this.f16101d = context;
        this.f16105h = str;
        this.f16107j = interfaceC4366c;
        this.f16104g = interfaceC0319f;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setOnCancelListener(new DialogInterfaceOnCancelListenerC4456aj(this));
        this.f16108k = ProgressDialogC4926s.m18727a(this.f16101d, null, this.f16101d.getResources().getString(com.sec.chaton.R.string.dialog_connecting_server));
        this.f16108k.setCanceledOnTouchOutside(false);
        this.f16108k.setOnCancelListener(new DialogInterfaceOnCancelListenerC4457ak(this));
        requestWindowFeature(1);
        this.f16110m = new FrameLayout(getContext());
        m16940a();
        m16941a(this.f16111n.getDrawable().getIntrinsicWidth() / 2);
        this.f16110m.addView(this.f16111n, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.f16110m, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f16109l != null) {
            this.f16109l.stopLoading();
        }
        if (!this.f16112o) {
            if (this.f16108k.isShowing()) {
                this.f16108k.dismiss();
            }
            super.dismiss();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f16112o = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f16112o = false;
        super.onAttachedToWindow();
    }

    /* renamed from: a */
    private void m16940a() throws Resources.NotFoundException {
        this.f16111n = new ImageView(getContext());
        this.f16111n.setOnClickListener(new ViewOnClickListenerC4458al(this));
        this.f16111n.setImageDrawable(getContext().getResources().getDrawable(com.sec.chaton.R.drawable.com_facebook_close));
        this.f16111n.setVisibility(4);
    }

    /* renamed from: a */
    private void m16941a(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f16109l = new WebView(getContext());
        WebSettings settings = this.f16109l.getSettings();
        settings.setSavePassword(false);
        settings.setJavaScriptEnabled(true);
        settings.getUserAgentString();
        this.f16109l.requestFocus(130);
        this.f16109l.setVerticalScrollbarOverlay(true);
        this.f16109l.setHorizontalScrollBarEnabled(false);
        this.f16109l.addJavascriptInterface(new C4462ap(this), "PinCode");
        this.f16109l.loadUrl(this.f16105h);
        this.f16109l.setLayoutParams(f16100c);
        this.f16109l.setVisibility(4);
        this.f16109l.setWebViewClient(new C4463aq(this, null));
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.f16109l);
        this.f16110m.addView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m16943b() {
        setOnDismissListener(null);
        dismiss();
    }
}
