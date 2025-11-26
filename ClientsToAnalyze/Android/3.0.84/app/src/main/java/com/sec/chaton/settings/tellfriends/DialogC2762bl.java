package com.sec.chaton.settings.tellfriends;

import android.R;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2786b;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import java.util.Timer;
import weibo4android.Weibo;
import weibo4android.http.RequestToken;

/* compiled from: WeiboDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bl */
/* loaded from: classes.dex */
public class DialogC2762bl extends Dialog {

    /* renamed from: d */
    public Context f10173d;

    /* renamed from: e */
    Handler f10174e;

    /* renamed from: g */
    private Weibo f10175g;

    /* renamed from: h */
    private RequestToken f10176h;

    /* renamed from: i */
    private String f10177i;

    /* renamed from: j */
    private String f10178j;

    /* renamed from: k */
    private InterfaceC2786b f10179k;

    /* renamed from: l */
    private ProgressDialog f10180l;

    /* renamed from: m */
    private WebView f10181m;

    /* renamed from: n */
    private FrameLayout f10182n;

    /* renamed from: o */
    private ImageView f10183o;

    /* renamed from: p */
    private boolean f10184p;

    /* renamed from: q */
    private Timer f10185q;

    /* renamed from: r */
    private AsyncTaskC2768br f10186r;

    /* renamed from: f */
    private static final String f10172f = DialogC2762bl.class.getSimpleName();

    /* renamed from: a */
    static final float[] f10169a = {30.0f, 60.0f};

    /* renamed from: b */
    static final float[] f10170b = {30.0f, 60.0f};

    /* renamed from: c */
    static final FrameLayout.LayoutParams f10171c = new FrameLayout.LayoutParams(-1, -1);

    public DialogC2762bl(Context context, Weibo weibo, RequestToken requestToken, InterfaceC2786b interfaceC2786b) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f10178j = null;
        this.f10184p = false;
        this.f10185q = null;
        this.f10186r = null;
        this.f10174e = new HandlerC2766bp(this);
        this.f10173d = context;
        this.f10176h = requestToken;
        this.f10177i = Uri.parse(requestToken.getAuthenticationURL() + "&from=chaton").toString();
        this.f10179k = interfaceC2786b;
        this.f10175g = weibo;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setOnCancelListener(new DialogInterfaceOnCancelListenerC2763bm(this));
        requestWindowFeature(1);
        this.f10180l = new ProgressDialogC3265l(getContext());
        this.f10180l.requestWindowFeature(1);
        this.f10180l.setMessage(getContext().getString(com.sec.chaton.R.string.dialog_connecting_server));
        this.f10180l.setCanceledOnTouchOutside(false);
        this.f10180l.setOnCancelListener(new DialogInterfaceOnCancelListenerC2764bn(this));
        requestWindowFeature(1);
        this.f10182n = new FrameLayout(getContext());
        m9879a();
        m9880a(this.f10183o.getDrawable().getIntrinsicWidth() / 2);
        this.f10182n.addView(this.f10183o, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.f10182n, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f10181m != null) {
            this.f10181m.stopLoading();
        }
        if (!this.f10184p) {
            if (this.f10180l.isShowing()) {
                this.f10180l.dismiss();
            }
            super.dismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        this.f10182n.setBackgroundColor(0);
        this.f10182n.invalidate();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            this.f10182n.setBackgroundColor(0);
            this.f10182n.invalidate();
        }
        super.onWindowFocusChanged(z);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f10184p = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f10184p = false;
        super.onAttachedToWindow();
    }

    /* renamed from: a */
    private void m9879a() throws Resources.NotFoundException {
        this.f10183o = new ImageView(getContext());
        this.f10183o.setOnClickListener(new ViewOnClickListenerC2765bo(this));
        this.f10183o.setImageDrawable(getContext().getResources().getDrawable(com.sec.chaton.R.drawable.com_facebook_close));
        this.f10183o.setVisibility(4);
    }

    /* renamed from: a */
    private void m9880a(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f10181m = new WebView(getContext());
        WebSettings settings = this.f10181m.getSettings();
        settings.setSavePassword(false);
        settings.setJavaScriptEnabled(true);
        settings.getUserAgentString();
        this.f10181m.requestFocus(130);
        this.f10181m.setVerticalScrollbarOverlay(true);
        this.f10181m.setHorizontalScrollBarEnabled(false);
        this.f10181m.loadUrl(this.f10177i);
        this.f10181m.setLayoutParams(f10171c);
        this.f10181m.setVisibility(4);
        this.f10181m.setWebViewClient(new C2769bs(this, null));
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.f10181m);
        this.f10182n.addView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9883b(String str) {
        C3250y.m11450b(str, f10172f);
    }
}
