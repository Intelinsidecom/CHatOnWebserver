package com.facebook.p009c;

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
import com.facebook.C0060aa;
import com.facebook.C0180y;
import com.facebook.p008b.C0105s;
import com.sec.chaton.R;
import com.sec.chaton.settings2.PrefFragmentChats;

/* compiled from: WebDialog.java */
/* renamed from: com.facebook.c.o */
/* loaded from: classes.dex */
public class DialogC0147o extends Dialog {

    /* renamed from: a */
    private String f335a;

    /* renamed from: b */
    private InterfaceC0155w f336b;

    /* renamed from: c */
    private WebView f337c;

    /* renamed from: d */
    private ProgressDialog f338d;

    /* renamed from: e */
    private ImageView f339e;

    /* renamed from: f */
    private FrameLayout f340f;

    /* renamed from: g */
    private boolean f341g;

    /* renamed from: h */
    private boolean f342h;

    public DialogC0147o(Context context, String str, Bundle bundle, int i, InterfaceC0155w interfaceC0155w) {
        super(context, i);
        this.f341g = false;
        this.f342h = false;
        bundle = bundle == null ? new Bundle() : bundle;
        bundle.putString("display", "touch");
        bundle.putString(PrefFragmentChats.TYPE, "user_agent");
        this.f335a = C0105s.m264a("m.facebook.com", "dialog/" + str, bundle).toString();
        this.f336b = interfaceC0155w;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f337c != null) {
            this.f337c.stopLoading();
        }
        if (!this.f342h) {
            if (this.f338d.isShowing()) {
                this.f338d.dismiss();
            }
            super.dismiss();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f342h = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f342h = false;
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setOnCancelListener(new DialogInterfaceOnCancelListenerC0148p(this));
        this.f338d = new ProgressDialog(getContext());
        this.f338d.requestWindowFeature(1);
        this.f338d.setMessage(getContext().getString(R.string.dialog_connecting_server));
        this.f338d.setOnCancelListener(new DialogInterfaceOnCancelListenerC0149q(this));
        requestWindowFeature(1);
        this.f340f = new FrameLayout(getContext());
        m451b();
        m445a(this.f339e.getDrawable().getIntrinsicWidth() / 2);
        this.f340f.addView(this.f339e, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.f340f, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m446a(Bundle bundle) {
        if (this.f336b != null && !this.f341g) {
            this.f341g = true;
            this.f336b.mo465a(bundle, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m450a(Throwable th) {
        C0180y c0180y;
        if (this.f336b != null && !this.f341g) {
            this.f341g = true;
            if (th instanceof C0060aa) {
                c0180y = (C0060aa) th;
            } else if (th instanceof C0180y) {
                c0180y = (C0180y) th;
            } else {
                c0180y = new C0180y(th);
            }
            this.f336b.mo465a(null, c0180y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m444a() {
        m450a(new C0060aa());
    }

    /* renamed from: b */
    private void m451b() throws Resources.NotFoundException {
        this.f339e = new ImageView(getContext());
        this.f339e.setOnClickListener(new ViewOnClickListenerC0150r(this));
        this.f339e.setImageDrawable(getContext().getResources().getDrawable(R.drawable.com_facebook_close));
        this.f339e.setVisibility(4);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: a */
    private void m445a(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f337c = new WebView(getContext());
        this.f337c.setVerticalScrollBarEnabled(false);
        this.f337c.setHorizontalScrollBarEnabled(false);
        this.f337c.setWebViewClient(new C0153u(this, null));
        this.f337c.getSettings().setJavaScriptEnabled(true);
        this.f337c.loadUrl(this.f335a);
        this.f337c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f337c.setVisibility(4);
        this.f337c.getSettings().setSavePassword(false);
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.f337c);
        this.f340f.addView(linearLayout);
    }
}
