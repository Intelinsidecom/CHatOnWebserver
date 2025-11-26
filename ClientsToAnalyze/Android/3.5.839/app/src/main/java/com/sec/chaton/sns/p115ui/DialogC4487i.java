package com.sec.chaton.sns.p115ui;

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
import com.renren.android.C0726g;
import com.sec.chaton.p051c.C1428b;
import com.sec.chaton.sns.p113a.InterfaceC4366c;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: RenrenDialog.java */
/* renamed from: com.sec.chaton.sns.ui.i */
/* loaded from: classes.dex */
public class DialogC4487i extends Dialog {

    /* renamed from: a */
    static final FrameLayout.LayoutParams f16182a = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: b */
    Context f16183b;

    /* renamed from: c */
    private String f16184c;

    /* renamed from: d */
    private InterfaceC4366c f16185d;

    /* renamed from: e */
    private ProgressDialog f16186e;

    /* renamed from: f */
    private WebView f16187f;

    /* renamed from: g */
    private FrameLayout f16188g;

    /* renamed from: h */
    private ImageView f16189h;

    /* renamed from: i */
    private boolean f16190i;

    public DialogC4487i(Context context, String str, InterfaceC4366c interfaceC4366c) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f16190i = false;
        this.f16183b = context;
        this.f16184c = str;
        this.f16185d = interfaceC4366c;
    }

    public DialogC4487i(Context context, String str, Bundle bundle, InterfaceC4366c interfaceC4366c) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f16190i = false;
        this.f16183b = context;
        bundle = bundle == null ? new Bundle() : bundle;
        bundle.putString("display", "touch");
        this.f16184c = C0726g.m2298a(C1428b.f5086B, "dialog/" + str, bundle).toString();
        this.f16185d = interfaceC4366c;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setOnCancelListener(new DialogInterfaceOnCancelListenerC4488j(this));
        this.f16186e = ProgressDialogC4926s.m18727a(this.f16183b, null, this.f16183b.getResources().getString(com.sec.chaton.R.string.dialog_connecting_server));
        this.f16186e.setCanceledOnTouchOutside(false);
        this.f16186e.setOnCancelListener(new DialogInterfaceOnCancelListenerC4489k(this));
        requestWindowFeature(1);
        this.f16188g = new FrameLayout(getContext());
        m16997a();
        m16998a(this.f16189h.getDrawable().getIntrinsicWidth() / 2);
        this.f16188g.addView(this.f16189h, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.f16188g, new ViewGroup.LayoutParams(-1, -1));
    }

    /* renamed from: a */
    private void m16998a(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f16187f = new WebView(getContext());
        this.f16187f.setVerticalScrollBarEnabled(false);
        this.f16187f.setHorizontalScrollBarEnabled(false);
        this.f16187f.getSettings().setJavaScriptEnabled(true);
        this.f16187f.setWebViewClient(new C4492n(this, null));
        this.f16187f.loadUrl(this.f16184c);
        this.f16187f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f16187f.setVisibility(4);
        this.f16187f.getSettings().setSavePassword(false);
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.f16187f);
        this.f16188g.addView(linearLayout);
    }

    /* renamed from: a */
    private void m16997a() throws Resources.NotFoundException {
        this.f16189h = new ImageView(getContext());
        this.f16189h.setOnClickListener(new ViewOnClickListenerC4490l(this));
        this.f16189h.setImageDrawable(getContext().getResources().getDrawable(com.sec.chaton.R.drawable.com_facebook_close));
        this.f16189h.setVisibility(4);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f16190i = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f16190i = false;
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f16187f != null) {
            this.f16187f.stopLoading();
        }
        if (!this.f16190i) {
            if (this.f16186e.isShowing()) {
                this.f16186e.dismiss();
            }
            super.dismiss();
        }
    }
}
