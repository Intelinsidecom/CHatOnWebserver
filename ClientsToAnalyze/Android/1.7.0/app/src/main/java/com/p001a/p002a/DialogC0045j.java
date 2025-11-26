package com.p001a.p002a;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.ProgressDialogC1354a;

/* compiled from: FbDialog.java */
/* renamed from: com.a.a.j */
/* loaded from: classes.dex */
public class DialogC0045j extends Dialog {

    /* renamed from: a */
    static final float[] f16a = {30.0f, 60.0f};

    /* renamed from: b */
    static final float[] f17b = {30.0f, 60.0f};

    /* renamed from: c */
    static final FrameLayout.LayoutParams f18c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d */
    private String f19d;

    /* renamed from: e */
    private InterfaceC0041f f20e;

    /* renamed from: f */
    private ProgressDialog f21f;

    /* renamed from: g */
    private WebView f22g;

    /* renamed from: h */
    private LinearLayout f23h;

    /* renamed from: i */
    private TextView f24i;

    /* renamed from: j */
    private boolean f25j;

    public DialogC0045j(Context context, String str, InterfaceC0041f interfaceC0041f) {
        super(context, R.style.MainCustomTheme_Dialog);
        this.f19d = str;
        this.f20e = interfaceC0041f;
        setOnDismissListener(new DialogInterfaceOnDismissListenerC0038c(this));
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        this.f21f = new ProgressDialogC1354a(getContext());
        this.f21f.requestWindowFeature(1);
        this.f21f.setMessage(getContext().getString(R.string.dialog_connecting_server));
        this.f21f.setCanceledOnTouchOutside(false);
        this.f21f.setOnCancelListener(new DialogInterfaceOnCancelListenerC0039d(this));
        this.f23h = new C0040e(getContext(), this);
        this.f23h.setOrientation(1);
        m37a();
        m39b();
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        float f = getContext().getResources().getDisplayMetrics().density;
        float[] fArr = getContext().getResources().getConfiguration().orientation == 2 ? f16a : f17b;
        addContentView(this.f23h, new LinearLayout.LayoutParams(defaultDisplay.getWidth() - ((int) ((fArr[0] * f) + 0.5f)), defaultDisplay.getHeight() - ((int) ((fArr[1] * f) + 0.5f))));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f25j = true;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f25j = false;
    }

    /* renamed from: a */
    private void m37a() throws Resources.NotFoundException {
        requestWindowFeature(1);
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.facebook_icon);
        this.f24i = new TextView(getContext());
        this.f24i.setText("Facebook");
        this.f24i.setTextColor(-1);
        this.f24i.setTypeface(Typeface.DEFAULT_BOLD);
        this.f24i.setBackgroundColor(-9599820);
        this.f24i.setPadding(6, 4, 4, 4);
        this.f24i.setCompoundDrawablePadding(6);
        this.f24i.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f23h.addView(this.f24i);
    }

    /* renamed from: b */
    private void m39b() {
        this.f22g = new WebView(getContext());
        this.f22g.setVerticalScrollbarOverlay(true);
        this.f22g.setHorizontalScrollBarEnabled(false);
        this.f22g.setWebViewClient(new C0044i(this, null));
        this.f22g.getSettings().setJavaScriptEnabled(true);
        this.f22g.loadUrl(this.f19d);
        this.f22g.setLayoutParams(f18c);
        this.f23h.addView(this.f22g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m40c() {
        setOnDismissListener(null);
        dismiss();
    }
}
