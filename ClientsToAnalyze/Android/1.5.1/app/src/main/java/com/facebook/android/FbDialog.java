package com.facebook.android;

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
import com.facebook.android.Facebook;
import com.sec.chaton.C0062R;

/* loaded from: classes.dex */
public class FbDialog extends Dialog {

    /* renamed from: a */
    static final float[] f204a = {20.0f, 60.0f};

    /* renamed from: b */
    static final float[] f205b = {40.0f, 60.0f};

    /* renamed from: c */
    static final FrameLayout.LayoutParams f206c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d */
    private String f207d;

    /* renamed from: e */
    private Facebook.DialogListener f208e;

    /* renamed from: f */
    private ProgressDialog f209f;

    /* renamed from: g */
    private WebView f210g;

    /* renamed from: h */
    private LinearLayout f211h;

    /* renamed from: i */
    private TextView f212i;

    public FbDialog(Context context, String str, Facebook.DialogListener dialogListener) {
        super(context);
        this.f207d = str;
        this.f208e = dialogListener;
        setOnCancelListener(new DialogInterfaceOnCancelListenerC0048a(this));
    }

    /* renamed from: a */
    private void m249a() throws Resources.NotFoundException {
        requestWindowFeature(1);
        Drawable drawable = getContext().getResources().getDrawable(C0062R.drawable.facebook_icon);
        this.f212i = new TextView(getContext());
        this.f212i.setText("Facebook");
        this.f212i.setTextColor(-1);
        this.f212i.setTypeface(Typeface.DEFAULT_BOLD);
        this.f212i.setBackgroundColor(-9599820);
        this.f212i.setPadding(6, 4, 4, 4);
        this.f212i.setCompoundDrawablePadding(6);
        this.f212i.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f211h.addView(this.f212i);
    }

    /* renamed from: b */
    private void m251b() {
        this.f210g = new WebView(getContext());
        this.f210g.setVerticalScrollBarEnabled(false);
        this.f210g.setHorizontalScrollBarEnabled(false);
        this.f210g.setWebViewClient(new C0052e(this, null));
        this.f210g.getSettings().setJavaScriptEnabled(true);
        this.f210g.loadUrl(this.f207d);
        this.f210g.setLayoutParams(f206c);
        this.f211h.addView(this.f210g);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        this.f209f = new ProgressDialog(getContext());
        this.f209f.requestWindowFeature(1);
        this.f209f.setMessage("Loading.....");
        this.f209f.setOnCancelListener(new DialogInterfaceOnCancelListenerC0049b(this));
        this.f211h = new C0050c(getContext(), this);
        this.f211h.setOrientation(1);
        m249a();
        m251b();
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        float f = getContext().getResources().getDisplayMetrics().density;
        float[] fArr = getContext().getResources().getConfiguration().orientation == 2 ? f204a : f205b;
        addContentView(this.f211h, new LinearLayout.LayoutParams(defaultDisplay.getWidth() - ((int) ((fArr[0] * f) + 0.5f)), defaultDisplay.getHeight() - ((int) ((f * fArr[1]) + 0.5f))));
    }
}
