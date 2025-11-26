package com.facebook.p033c;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.C0431aa;
import com.facebook.C0551y;
import com.facebook.p032b.C0476s;
import com.sec.chaton.R;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: WebDialog.java */
/* renamed from: com.facebook.c.o */
/* loaded from: classes.dex */
public class DialogC0518o extends Dialog {

    /* renamed from: a */
    private String f1304a;

    /* renamed from: b */
    private InterfaceC0526w f1305b;

    /* renamed from: c */
    private WebView f1306c;

    /* renamed from: d */
    private ProgressDialog f1307d;

    /* renamed from: e */
    private ImageView f1308e;

    /* renamed from: f */
    private FrameLayout f1309f;

    /* renamed from: g */
    private boolean f1310g;

    /* renamed from: h */
    private boolean f1311h;

    /* renamed from: i */
    private Context f1312i;

    public DialogC0518o(Context context, String str, Bundle bundle, int i, InterfaceC0526w interfaceC0526w) {
        super(context, i);
        this.f1310g = false;
        this.f1311h = false;
        bundle = bundle == null ? new Bundle() : bundle;
        bundle.putString("display", "touch");
        bundle.putString("type", "user_agent");
        this.f1304a = C0476s.m1708a("m.facebook.com", "dialog/" + str, bundle).toString();
        this.f1312i = context;
        this.f1305b = interfaceC0526w;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f1306c != null) {
            this.f1306c.stopLoading();
        }
        if (!this.f1311h) {
            if (this.f1307d.isShowing()) {
                this.f1307d.dismiss();
            }
            super.dismiss();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f1311h = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f1311h = false;
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setOnCancelListener(new DialogInterfaceOnCancelListenerC0519p(this));
        this.f1307d = ProgressDialogC4926s.m18727a(this.f1312i, null, this.f1312i.getResources().getString(R.string.dialog_connecting_server));
        this.f1307d.setCanceledOnTouchOutside(false);
        this.f1307d.setOnCancelListener(new DialogInterfaceOnCancelListenerC0520q(this));
        requestWindowFeature(1);
        this.f1309f = new FrameLayout(getContext());
        m1894b();
        m1888a(this.f1308e.getDrawable().getIntrinsicWidth() / 2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        this.f1309f.addView(this.f1308e, layoutParams);
        addContentView(this.f1309f, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1889a(Bundle bundle) {
        if (this.f1305b != null && !this.f1310g) {
            this.f1310g = true;
            this.f1305b.mo1908a(bundle, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1893a(Throwable th) {
        C0551y c0551y;
        if (this.f1305b != null && !this.f1310g) {
            this.f1310g = true;
            if (th instanceof C0431aa) {
                c0551y = (C0431aa) th;
            } else if (th instanceof C0551y) {
                c0551y = (C0551y) th;
            } else {
                c0551y = new C0551y(th);
            }
            this.f1305b.mo1908a(null, c0551y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1887a() {
        m1893a(new C0431aa());
    }

    /* renamed from: b */
    private void m1894b() throws Resources.NotFoundException {
        this.f1308e = new ImageView(getContext());
        this.f1308e.setOnClickListener(new ViewOnClickListenerC0521r(this));
        this.f1308e.setImageDrawable(getContext().getResources().getDrawable(R.drawable.com_facebook_close));
        this.f1308e.setVisibility(4);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: a */
    private void m1888a(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f1306c = new WebView(getContext());
        this.f1306c.setVerticalScrollBarEnabled(false);
        this.f1306c.setHorizontalScrollBarEnabled(false);
        this.f1306c.setWebViewClient(new C0524u(this, null));
        this.f1306c.getSettings().setJavaScriptEnabled(true);
        this.f1306c.getSettings().setDomStorageEnabled(true);
        this.f1306c.getSettings().setDatabaseEnabled(true);
        this.f1306c.getSettings().setDatabasePath(PushClientApplication.m12499n().getDir("webview_database", 0).getPath());
        this.f1306c.loadUrl(this.f1304a);
        this.f1306c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f1306c.setVisibility(4);
        this.f1306c.getSettings().setSavePassword(false);
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.f1306c);
        this.f1309f.addView(linearLayout);
    }
}
