package com.sec.chaton.settings.tellfriends;

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
import com.sec.chaton.settings.tellfriends.common.InterfaceC2786b;
import com.sec.chaton.widget.ProgressDialogC3265l;
import java.util.Timer;
import twitter4j.Twitter;

/* compiled from: TwDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ar */
/* loaded from: classes.dex */
public class DialogC2741ar extends Dialog {

    /* renamed from: a */
    static final float[] f10123a = {30.0f, 60.0f};

    /* renamed from: b */
    static final float[] f10124b = {30.0f, 60.0f};

    /* renamed from: c */
    static final FrameLayout.LayoutParams f10125c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d */
    public Context f10126d;

    /* renamed from: e */
    AsyncTaskC2747ax f10127e;

    /* renamed from: f */
    Handler f10128f;

    /* renamed from: g */
    private Twitter f10129g;

    /* renamed from: h */
    private String f10130h;

    /* renamed from: i */
    private String f10131i;

    /* renamed from: j */
    private InterfaceC2786b f10132j;

    /* renamed from: k */
    private ProgressDialog f10133k;

    /* renamed from: l */
    private WebView f10134l;

    /* renamed from: m */
    private FrameLayout f10135m;

    /* renamed from: n */
    private ImageView f10136n;

    /* renamed from: o */
    private boolean f10137o;

    /* renamed from: p */
    private Timer f10138p;

    public DialogC2741ar(Context context, Twitter twitter, String str, InterfaceC2786b interfaceC2786b) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f10131i = null;
        this.f10137o = false;
        this.f10138p = null;
        this.f10127e = null;
        this.f10128f = new HandlerC2745av(this);
        this.f10126d = context;
        this.f10130h = str;
        this.f10132j = interfaceC2786b;
        this.f10129g = twitter;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setOnCancelListener(new DialogInterfaceOnCancelListenerC2742as(this));
        this.f10133k = new ProgressDialogC3265l(getContext());
        this.f10133k.requestWindowFeature(1);
        this.f10133k.setMessage(getContext().getString(com.sec.chaton.R.string.dialog_connecting_server));
        this.f10133k.setCanceledOnTouchOutside(false);
        this.f10133k.setOnCancelListener(new DialogInterfaceOnCancelListenerC2743at(this));
        requestWindowFeature(1);
        this.f10135m = new FrameLayout(getContext());
        m9825a();
        m9826a(this.f10136n.getDrawable().getIntrinsicWidth() / 2);
        this.f10135m.addView(this.f10136n, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.f10135m, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f10134l != null) {
            this.f10134l.stopLoading();
        }
        if (!this.f10137o) {
            if (this.f10133k.isShowing()) {
                this.f10133k.dismiss();
            }
            super.dismiss();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f10137o = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f10137o = false;
        super.onAttachedToWindow();
    }

    /* renamed from: a */
    private void m9825a() throws Resources.NotFoundException {
        this.f10136n = new ImageView(getContext());
        this.f10136n.setOnClickListener(new ViewOnClickListenerC2744au(this));
        this.f10136n.setImageDrawable(getContext().getResources().getDrawable(com.sec.chaton.R.drawable.com_facebook_close));
        this.f10136n.setVisibility(4);
    }

    /* renamed from: a */
    private void m9826a(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f10134l = new WebView(getContext());
        WebSettings settings = this.f10134l.getSettings();
        settings.setSavePassword(false);
        settings.setJavaScriptEnabled(true);
        settings.getUserAgentString();
        this.f10134l.requestFocus(130);
        this.f10134l.setVerticalScrollbarOverlay(true);
        this.f10134l.setHorizontalScrollBarEnabled(false);
        this.f10134l.addJavascriptInterface(new C2748ay(this), "PinCode");
        this.f10134l.loadUrl(this.f10130h);
        this.f10134l.setLayoutParams(f10125c);
        this.f10134l.setVisibility(4);
        this.f10134l.setWebViewClient(new C2749az(this, null));
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.f10134l);
        this.f10135m.addView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m9828b() {
        setOnDismissListener(null);
        dismiss();
    }
}
