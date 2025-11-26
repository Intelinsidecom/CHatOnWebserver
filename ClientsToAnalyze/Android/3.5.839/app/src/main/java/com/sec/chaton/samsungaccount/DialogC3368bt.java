package com.sec.chaton.samsungaccount;

import android.R;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.p055d.C2104bj;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bt */
/* loaded from: classes.dex */
public class DialogC3368bt extends Dialog {

    /* renamed from: a */
    protected ArrayList<String> f12307a;

    /* renamed from: b */
    protected ArrayList<String> f12308b;

    /* renamed from: c */
    private final String f12309c;

    /* renamed from: d */
    private final String f12310d;

    /* renamed from: e */
    private String f12311e;

    /* renamed from: f */
    private String f12312f;

    /* renamed from: g */
    private String f12313g;

    /* renamed from: h */
    private String f12314h;

    /* renamed from: i */
    private String f12315i;

    /* renamed from: j */
    private InterfaceC3377cb f12316j;

    /* renamed from: k */
    private C2104bj f12317k;

    /* renamed from: l */
    private FrameLayout f12318l;

    /* renamed from: m */
    private Context f12319m;

    /* renamed from: n */
    private WebView f12320n;

    /* renamed from: o */
    private ProgressDialog f12321o;

    /* renamed from: p */
    private ImageView f12322p;

    /* renamed from: q */
    private boolean f12323q;

    /* renamed from: r */
    private boolean f12324r;

    /* renamed from: s */
    private Handler f12325s;

    public DialogC3368bt(Context context, InterfaceC3377cb interfaceC3377cb) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f12309c = "/mobile/account/check.do";
        this.f12310d = "";
        this.f12321o = null;
        this.f12307a = new ArrayList<>();
        this.f12308b = new ArrayList<>();
        this.f12323q = false;
        this.f12324r = false;
        this.f12325s = new HandlerC3371bw(this);
        this.f12319m = context;
        this.f12316j = interfaceC3377cb;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f12321o != null && this.f12321o.isShowing()) {
            this.f12321o.cancel();
        }
        if (this.f12319m != null) {
            this.f12319m = null;
        }
        this.f12324r = true;
        super.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        DialogInterfaceOnCancelListenerC3369bu dialogInterfaceOnCancelListenerC3369bu = null;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().getAttributes().dimAmount = 0.7f;
        getWindow().addFlags(2);
        setOnCancelListener(new DialogInterfaceOnCancelListenerC3369bu(this));
        this.f12317k = new C2104bj(this.f12325s);
        this.f12312f = C4822an.m18236g();
        this.f12313g = this.f12319m.getResources().getConfiguration().locale.getLanguage();
        if (TextUtils.isEmpty(this.f12313g)) {
            this.f12313g = "en";
        }
        this.f12318l = new FrameLayout(this.f12319m);
        m13199a();
        int intrinsicWidth = this.f12322p.getDrawable().getIntrinsicWidth() / 2;
        LinearLayout linearLayout = new LinearLayout(this.f12319m);
        this.f12320n = new WebView(this.f12319m);
        this.f12320n.getSettings().setJavaScriptEnabled(true);
        this.f12320n.setHorizontalScrollBarEnabled(false);
        this.f12320n.setVerticalScrollbarOverlay(true);
        this.f12320n.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f12320n.setWebViewClient(new C3381cf(this, dialogInterfaceOnCancelListenerC3369bu));
        this.f12320n.setWebChromeClient(new C3378cc(this, dialogInterfaceOnCancelListenerC3369bu));
        this.f12320n.clearCache(true);
        linearLayout.setPadding(intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        linearLayout.addView(this.f12320n);
        this.f12318l.addView(linearLayout);
        this.f12318l.addView(this.f12322p, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.f12318l, new FrameLayout.LayoutParams(-1, -1));
        m13203b();
    }

    /* renamed from: a */
    private void m13199a() throws Resources.NotFoundException {
        this.f12322p = new ImageView(getContext());
        this.f12322p.setOnClickListener(new ViewOnClickListenerC3370bv(this));
        this.f12322p.setImageDrawable(getContext().getResources().getDrawable(com.sec.chaton.R.drawable.com_facebook_close));
        this.f12322p.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13203b() {
        if (!TextUtils.isEmpty(this.f12312f)) {
            this.f12311e = "https://account.samsung.com/mobile/account/check.do?serviceID=fs24s8z0hh&actionID=StartOAuth2&countryCode=" + this.f12312f + "&languageCode=" + this.f12313g;
        } else {
            this.f12311e = "https://account.samsung.com/mobile/account/check.do?serviceID=fs24s8z0hh&actionID=StartOAuth2&countryCode=&languageCode=" + this.f12313g;
        }
        this.f12320n.loadUrl(this.f12311e);
        C4904y.m18639b("Load url : " + this.f12311e, getClass().getSimpleName());
    }
}
