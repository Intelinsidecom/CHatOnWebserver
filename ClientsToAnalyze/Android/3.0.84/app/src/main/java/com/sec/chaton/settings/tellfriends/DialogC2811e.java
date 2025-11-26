package com.sec.chaton.settings.tellfriends;

import android.R;
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
import com.renren.android.C0214g;
import com.sec.chaton.p020c.C0817b;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2786b;

/* compiled from: RenrenDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.e */
/* loaded from: classes.dex */
public class DialogC2811e extends Dialog {

    /* renamed from: a */
    static final FrameLayout.LayoutParams f10324a = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: b */
    Context f10325b;

    /* renamed from: c */
    private String f10326c;

    /* renamed from: d */
    private InterfaceC2786b f10327d;

    /* renamed from: e */
    private ProgressDialog f10328e;

    /* renamed from: f */
    private WebView f10329f;

    /* renamed from: g */
    private FrameLayout f10330g;

    /* renamed from: h */
    private ImageView f10331h;

    /* renamed from: i */
    private boolean f10332i;

    public DialogC2811e(Context context, String str, InterfaceC2786b interfaceC2786b) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f10332i = false;
        this.f10325b = context;
        this.f10326c = str;
        this.f10327d = interfaceC2786b;
    }

    public DialogC2811e(Context context, String str, Bundle bundle, InterfaceC2786b interfaceC2786b) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f10332i = false;
        this.f10325b = context;
        bundle = bundle == null ? new Bundle() : bundle;
        bundle.putString("display", "touch");
        this.f10326c = C0214g.m566a(C0817b.f3150v, "dialog/" + str, bundle).toString();
        this.f10327d = interfaceC2786b;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setOnCancelListener(new DialogInterfaceOnCancelListenerC2812f(this));
        this.f10328e = new ProgressDialog(getContext());
        this.f10328e.requestWindowFeature(1);
        this.f10328e.setMessage(getContext().getString(com.sec.chaton.R.string.dialog_connecting_server));
        this.f10328e.setCanceledOnTouchOutside(false);
        this.f10328e.setOnCancelListener(new DialogInterfaceOnCancelListenerC2813g(this));
        requestWindowFeature(1);
        this.f10330g = new FrameLayout(getContext());
        m10027a();
        m10028a(this.f10331h.getDrawable().getIntrinsicWidth() / 2);
        this.f10330g.addView(this.f10331h, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.f10330g, new ViewGroup.LayoutParams(-1, -1));
    }

    /* renamed from: a */
    private void m10028a(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f10329f = new WebView(getContext());
        this.f10329f.setVerticalScrollBarEnabled(false);
        this.f10329f.setHorizontalScrollBarEnabled(false);
        this.f10329f.getSettings().setJavaScriptEnabled(true);
        this.f10329f.setWebViewClient(new C2816j(this, null));
        this.f10329f.loadUrl(this.f10326c);
        this.f10329f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f10329f.setVisibility(4);
        this.f10329f.getSettings().setSavePassword(false);
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.f10329f);
        this.f10330g.addView(linearLayout);
    }

    /* renamed from: a */
    private void m10027a() throws Resources.NotFoundException {
        this.f10331h = new ImageView(getContext());
        this.f10331h.setOnClickListener(new ViewOnClickListenerC2814h(this));
        this.f10331h.setImageDrawable(getContext().getResources().getDrawable(com.sec.chaton.R.drawable.com_facebook_close));
        this.f10331h.setVisibility(4);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f10332i = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f10332i = false;
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f10329f != null) {
            this.f10329f.stopLoading();
        }
        if (!this.f10332i) {
            if (this.f10328e.isShowing()) {
                this.f10328e.dismiss();
            }
            super.dismiss();
        }
    }
}
