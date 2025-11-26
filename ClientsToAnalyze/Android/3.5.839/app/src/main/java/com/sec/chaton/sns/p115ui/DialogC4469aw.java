package com.sec.chaton.sns.p115ui;

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
import com.sec.chaton.sns.p113a.InterfaceC4366c;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import java.util.Timer;
import p021c.C0349h;
import p021c.p022a.C0333h;

/* compiled from: WeiboDialog.java */
/* renamed from: com.sec.chaton.sns.ui.aw */
/* loaded from: classes.dex */
public class DialogC4469aw extends Dialog {

    /* renamed from: d */
    public Context f16141d;

    /* renamed from: e */
    Handler f16142e;

    /* renamed from: g */
    private C0349h f16143g;

    /* renamed from: h */
    private C0333h f16144h;

    /* renamed from: i */
    private String f16145i;

    /* renamed from: j */
    private String f16146j;

    /* renamed from: k */
    private InterfaceC4366c f16147k;

    /* renamed from: l */
    private ProgressDialog f16148l;

    /* renamed from: m */
    private WebView f16149m;

    /* renamed from: n */
    private FrameLayout f16150n;

    /* renamed from: o */
    private ImageView f16151o;

    /* renamed from: p */
    private boolean f16152p;

    /* renamed from: q */
    private Timer f16153q;

    /* renamed from: r */
    private AsyncTaskC4476bc f16154r;

    /* renamed from: f */
    private static final String f16140f = DialogC4469aw.class.getSimpleName();

    /* renamed from: a */
    static final float[] f16137a = {30.0f, 60.0f};

    /* renamed from: b */
    static final float[] f16138b = {30.0f, 60.0f};

    /* renamed from: c */
    static final FrameLayout.LayoutParams f16139c = new FrameLayout.LayoutParams(-1, -1);

    public DialogC4469aw(Context context, C0349h c0349h, C0333h c0333h, InterfaceC4366c interfaceC4366c) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f16146j = null;
        this.f16152p = false;
        this.f16153q = null;
        this.f16154r = null;
        this.f16142e = new HandlerC4474ba(this);
        this.f16141d = context;
        this.f16144h = c0333h;
        this.f16145i = Uri.parse(c0333h.m1168a() + "&from=chaton").toString();
        this.f16147k = interfaceC4366c;
        this.f16143g = c0349h;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setOnCancelListener(new DialogInterfaceOnCancelListenerC4470ax(this));
        requestWindowFeature(1);
        this.f16148l = ProgressDialogC4926s.m18727a(this.f16141d, null, this.f16141d.getResources().getString(com.sec.chaton.R.string.dialog_connecting_server));
        this.f16148l.setCanceledOnTouchOutside(false);
        this.f16148l.setOnCancelListener(new DialogInterfaceOnCancelListenerC4471ay(this));
        this.f16150n = new FrameLayout(getContext());
        m16968a();
        m16969a(this.f16151o.getDrawable().getIntrinsicWidth() / 2);
        this.f16150n.addView(this.f16151o, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.f16150n, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f16149m != null) {
            this.f16149m.stopLoading();
        }
        if (!this.f16152p) {
            if (this.f16148l.isShowing()) {
                this.f16148l.dismiss();
            }
            super.dismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        this.f16150n.setBackgroundColor(0);
        this.f16150n.invalidate();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            this.f16150n.setBackgroundColor(0);
            this.f16150n.invalidate();
        }
        super.onWindowFocusChanged(z);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f16152p = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f16152p = false;
        super.onAttachedToWindow();
    }

    /* renamed from: a */
    private void m16968a() throws Resources.NotFoundException {
        this.f16151o = new ImageView(getContext());
        this.f16151o.setOnClickListener(new ViewOnClickListenerC4472az(this));
        this.f16151o.setImageDrawable(getContext().getResources().getDrawable(com.sec.chaton.R.drawable.com_facebook_close));
        this.f16151o.setVisibility(4);
    }

    /* renamed from: a */
    private void m16969a(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f16149m = new WebView(getContext());
        WebSettings settings = this.f16149m.getSettings();
        settings.setSavePassword(false);
        settings.setJavaScriptEnabled(true);
        settings.getUserAgentString();
        this.f16149m.requestFocus(130);
        this.f16149m.setVerticalScrollbarOverlay(true);
        this.f16149m.setHorizontalScrollBarEnabled(false);
        this.f16149m.loadUrl(this.f16145i);
        this.f16149m.setLayoutParams(f16139c);
        this.f16149m.setVisibility(4);
        this.f16149m.setWebViewClient(new C4477bd(this, null));
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.f16149m);
        this.f16150n.addView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m16972b(String str) {
        C4904y.m18639b(str, f16140f);
    }
}
