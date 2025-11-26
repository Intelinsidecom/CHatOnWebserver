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
import com.sec.chaton.p025d.C1307at;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.ba */
/* loaded from: classes.dex */
public class DialogC2339ba extends Dialog {

    /* renamed from: a */
    protected ArrayList<String> f8775a;

    /* renamed from: b */
    protected ArrayList<String> f8776b;

    /* renamed from: c */
    private final String f8777c;

    /* renamed from: d */
    private final String f8778d;

    /* renamed from: e */
    private String f8779e;

    /* renamed from: f */
    private String f8780f;

    /* renamed from: g */
    private String f8781g;

    /* renamed from: h */
    private String f8782h;

    /* renamed from: i */
    private String f8783i;

    /* renamed from: j */
    private InterfaceC2347bi f8784j;

    /* renamed from: k */
    private C1307at f8785k;

    /* renamed from: l */
    private FrameLayout f8786l;

    /* renamed from: m */
    private Context f8787m;

    /* renamed from: n */
    private WebView f8788n;

    /* renamed from: o */
    private ProgressDialog f8789o;

    /* renamed from: p */
    private ImageView f8790p;

    /* renamed from: q */
    private boolean f8791q;

    /* renamed from: r */
    private Handler f8792r;

    public DialogC2339ba(Context context, InterfaceC2347bi interfaceC2347bi) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f8777c = "/mobile/account/check.do";
        this.f8778d = "";
        this.f8789o = null;
        this.f8775a = new ArrayList<>();
        this.f8776b = new ArrayList<>();
        this.f8791q = false;
        this.f8792r = new HandlerC2342bd(this);
        this.f8787m = context;
        this.f8784j = interfaceC2347bi;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f8789o != null && this.f8789o.isShowing()) {
            this.f8789o.cancel();
        }
        if (this.f8787m != null) {
            this.f8787m = null;
        }
        super.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        DialogInterfaceOnCancelListenerC2340bb dialogInterfaceOnCancelListenerC2340bb = null;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().getAttributes().dimAmount = 0.7f;
        getWindow().addFlags(2);
        setOnCancelListener(new DialogInterfaceOnCancelListenerC2340bb(this));
        this.f8785k = new C1307at(this.f8792r);
        this.f8780f = C3171am.m11060d();
        this.f8781g = this.f8787m.getResources().getConfiguration().locale.getLanguage();
        if (TextUtils.isEmpty(this.f8781g)) {
            this.f8781g = "en";
        }
        this.f8786l = new FrameLayout(this.f8787m);
        m8820a();
        int intrinsicWidth = this.f8790p.getDrawable().getIntrinsicWidth() / 2;
        LinearLayout linearLayout = new LinearLayout(this.f8787m);
        this.f8788n = new WebView(this.f8787m);
        this.f8788n.getSettings().setJavaScriptEnabled(true);
        this.f8788n.setHorizontalScrollBarEnabled(false);
        this.f8788n.setVerticalScrollbarOverlay(true);
        this.f8788n.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f8788n.setWebViewClient(new C2351bm(this, dialogInterfaceOnCancelListenerC2340bb));
        this.f8788n.setWebChromeClient(new C2348bj(this, dialogInterfaceOnCancelListenerC2340bb));
        linearLayout.setPadding(intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        linearLayout.addView(this.f8788n);
        this.f8786l.addView(linearLayout);
        this.f8786l.addView(this.f8790p, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.f8786l, new FrameLayout.LayoutParams(-1, -1));
        m8824b();
    }

    /* renamed from: a */
    private void m8820a() throws Resources.NotFoundException {
        this.f8790p = new ImageView(getContext());
        this.f8790p.setOnClickListener(new ViewOnClickListenerC2341bc(this));
        this.f8790p.setImageDrawable(getContext().getResources().getDrawable(com.sec.chaton.R.drawable.com_facebook_close));
        this.f8790p.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8824b() {
        if (!TextUtils.isEmpty(this.f8780f)) {
            this.f8779e = "https://account.samsung.com/mobile/account/check.do?serviceID=fs24s8z0hh&actionID=StartOAuth2&countryCode=" + this.f8780f + "&languageCode=" + this.f8781g;
        } else {
            this.f8779e = "https://account.samsung.com/mobile/account/check.do?serviceID=fs24s8z0hh&actionID=StartOAuth2&countryCode=&languageCode=" + this.f8781g;
        }
        this.f8788n.loadUrl(this.f8779e);
        C3250y.m11450b("Load url : " + this.f8779e, getClass().getSimpleName());
    }
}
