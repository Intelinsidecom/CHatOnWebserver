package com.sec.chaton.trunk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.image.AsyncTaskC2843c;
import com.sec.chaton.multimedia.image.InterfaceC2838aw;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.trunk.p121c.C4637b;
import com.sec.chaton.trunk.p121c.C4638c;
import com.sec.chaton.trunk.p121c.C4641f;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.chaton.trunk.p121c.InterfaceC4640e;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5052r;
import com.sec.widget.C5179v;
import java.io.File;

/* loaded from: classes.dex */
public class TrunkFullView extends Fragment implements InterfaceC2838aw, InterfaceC4640e, InterfaceC4672f {

    /* renamed from: b */
    private static final String f16468b = TrunkFullView.class.getSimpleName();

    /* renamed from: A */
    private C4637b f16469A;

    /* renamed from: B */
    private C4590ao f16470B;

    /* renamed from: C */
    private InterfaceC4674h f16471C;

    /* renamed from: D */
    private InterfaceC4673g f16472D;

    /* renamed from: E */
    private InterfaceC4673g f16473E;

    /* renamed from: F */
    private ViewTreeObserver.OnGlobalLayoutListener f16474F;

    /* renamed from: G */
    private C4610bb f16475G;

    /* renamed from: H */
    private ViewTreeObserver f16476H;

    /* renamed from: I */
    private C5007c f16477I;

    /* renamed from: J */
    private Uri f16478J;

    /* renamed from: K */
    private boolean f16479K;

    /* renamed from: L */
    private boolean f16480L;

    /* renamed from: M */
    private int f16481M;

    /* renamed from: N */
    private AsyncTaskC2843c f16482N;

    /* renamed from: O */
    private C4589an f16483O;

    /* renamed from: P */
    private Handler f16484P = new HandlerC4595at(this);

    /* renamed from: Q */
    private View.OnClickListener f16485Q = new ViewOnClickListenerC4599ax(this);

    /* renamed from: R */
    private Handler f16486R = new HandlerC4601az(this);

    /* renamed from: a */
    public ImageView f16487a;

    /* renamed from: c */
    private Activity f16488c;

    /* renamed from: d */
    private InterfaceC4609ba f16489d;

    /* renamed from: e */
    private Toast f16490e;

    /* renamed from: f */
    private ProgressBar f16491f;

    /* renamed from: g */
    private ImageView f16492g;

    /* renamed from: h */
    private ImageView f16493h;

    /* renamed from: i */
    private ImageView f16494i;

    /* renamed from: j */
    private FrameLayout f16495j;

    /* renamed from: k */
    private Dialog f16496k;

    /* renamed from: l */
    private Dialog f16497l;

    /* renamed from: m */
    private String f16498m;

    /* renamed from: n */
    private String f16499n;

    /* renamed from: o */
    private String f16500o;

    /* renamed from: p */
    private EnumC4642g f16501p;

    /* renamed from: q */
    private String f16502q;

    /* renamed from: r */
    private int f16503r;

    /* renamed from: s */
    private String f16504s;

    /* renamed from: t */
    private String f16505t;

    /* renamed from: u */
    private boolean f16506u;

    /* renamed from: v */
    private boolean f16507v;

    /* renamed from: w */
    private boolean f16508w;

    /* renamed from: x */
    private boolean f16509x;

    /* renamed from: y */
    private boolean f16510y;

    /* renamed from: z */
    private boolean f16511z;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public TrunkPageActivity m17321h() {
        return (TrunkPageActivity) this.f16488c;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f16488c = activity;
        try {
            this.f16489d = (InterfaceC4609ba) this.f16488c;
        } catch (ClassCastException e) {
            throw new ClassCastException(C5052r.m19199a(activity.toString(), " must implement ITrunkFullViewListener."));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f16488c = null;
        this.f16489d = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        C4645cc c4645cc;
        this.f16481M = getArguments() != null ? getArguments().getInt(VKApiConst.POSITION) : 0;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f16498m = bundle.getString("sessionId");
            this.f16499n = bundle.getString("inboxNo");
            this.f16500o = bundle.getString("itemId");
            this.f16502q = bundle.getString("downloadUrl");
            this.f16501p = C4641f.m17614a(bundle.getString("contentType"), false);
            this.f16503r = bundle.getInt("totalcomment");
            this.f16479K = bundle.getBoolean("isvalid");
            if (C4904y.f17872b) {
                StringBuilder sb = new StringBuilder();
                sb.append("sessionId: " + this.f16498m);
                sb.append(", inboxNo: " + this.f16499n);
                sb.append(", itemId: " + this.f16500o);
                sb.append(", contentType: " + this.f16501p);
                sb.append(", downloadUri: " + this.f16502q);
                sb.append(", totalCommentCount" + this.f16503r);
                sb.append("isvalid: " + this.f16479K);
                sb.append("\n");
                C4904y.m18639b("[restore from onSaveInstanceState]" + sb.toString(), f16468b);
            }
        } else if (m17321h() != null && m17321h().m17462f().size() > this.f16481M && (c4645cc = m17321h().m17462f().get(this.f16481M)) != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("[Item]" + c4645cc.toString(), f16468b);
            }
            this.f16498m = c4645cc.f16828a;
            this.f16499n = c4645cc.f16829b;
            this.f16500o = c4645cc.f16833f;
            this.f16502q = c4645cc.f16835h;
            this.f16501p = c4645cc.f16836i;
            this.f16503r = c4645cc.f16837j;
            this.f16479K = c4645cc.f16838k;
        }
        this.f16490e = C5179v.m19811a(CommonApplication.m18732r(), (CharSequence) null, 0);
        this.f16469A = new C4637b();
        this.f16477I = new C5007c();
        this.f16475G = new C4610bb(this, this);
    }

    /* renamed from: b */
    public C4610bb m17344b() {
        return this.f16475G;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (C4904y.f17872b) {
            StringBuilder sb = new StringBuilder();
            sb.append("sessionId: " + this.f16498m);
            sb.append(", inboxNo: " + this.f16499n);
            sb.append(", itemId: " + this.f16500o);
            sb.append(", contentType: " + this.f16501p);
            sb.append(", downloadUri: " + this.f16502q);
            sb.append(", totalCommentCount" + this.f16503r);
            sb.append("isvalid: " + this.f16479K);
            sb.append("\n");
            C4904y.m18639b("[onSaveInstanceState]" + sb.toString(), f16468b);
        }
        bundle.putString("sessionId", this.f16498m);
        bundle.putString("inboxNo", this.f16499n);
        bundle.putString("itemId", this.f16500o);
        bundle.putString("downloadUrl", this.f16502q);
        bundle.putString("contentType", this.f16501p.toString());
        bundle.putInt("totalcomment", this.f16503r);
        bundle.putBoolean("isvalid", this.f16479K);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_trunk_full, viewGroup, false);
        this.f16495j = (FrameLayout) viewInflate.findViewById(R.id.trunkImageWithoutComment);
        this.f16487a = (ImageView) viewInflate.findViewById(R.id.trunkContentMainImage_f);
        this.f16492g = (ImageView) viewInflate.findViewById(R.id.defaultImage_f);
        this.f16493h = (ImageView) viewInflate.findViewById(R.id.defaultVideo_f);
        this.f16494i = (ImageView) viewInflate.findViewById(R.id.defaultPlayBtn_f);
        this.f16491f = (ProgressBar) viewInflate.findViewById(R.id.trunkContentDownloadProgressbar_f);
        this.f16487a.setOnTouchListener(this.f16475G);
        m17310b(false);
        this.f16470B = new C4590ao(this, this.f16484P, this.f16499n, this.f16498m, this.f16500o);
        this.f16470B.m17508a();
        this.f16471C.mo17549a(100, 239);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C4638c.m17609a(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f16487a != null) {
            this.f16476H = this.f16495j.getViewTreeObserver();
            this.f16474F = new ViewTreeObserverOnGlobalLayoutListenerC4596au(this);
            this.f16476H.addOnGlobalLayoutListener(this.f16474F);
        }
        this.f16470B.m17509b();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f16476H != null && this.f16476H.isAlive()) {
            this.f16476H.removeGlobalOnLayoutListener(this.f16474F);
        }
        this.f16470B.m17510c();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        C4638c.m17611b(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f16470B.m17511d();
        if (this.f16477I != null) {
            this.f16477I.m19014a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f16469A.m17604a();
    }

    @Override // com.sec.chaton.trunk.InterfaceC4672f
    /* renamed from: a */
    public Activity mo17338a() {
        return this.f16488c;
    }

    @Override // com.sec.chaton.trunk.InterfaceC4672f
    /* renamed from: a */
    public void mo17342a(String str) {
        this.f16504s = str;
        if ("ME".equals(this.f16504s) && this.f16479K) {
            this.f16510y = true;
        } else {
            this.f16510y = false;
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC4672f
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo17339a(EnumC4642g enumC4642g, File file, String str) {
        if (!this.f16507v) {
            if (!this.f16508w || this.f16505t == null || !this.f16505t.equals(str)) {
                this.f16501p = enumC4642g;
                this.f16505t = str;
                if (this.f16478J == null || !this.f16478J.equals(C4636a.m17601a(this.f16505t))) {
                    this.f16509x = false;
                    if (this.f16505t == null || this.f16505t.trim().equals("")) {
                        this.f16477I.m19015a((View) this.f16487a);
                        return;
                    }
                    if (this.f16501p == EnumC4642g.IMAGE) {
                        this.f16478J = C4636a.m17601a(this.f16505t);
                        if (this.f16478J == null) {
                            if (file.exists()) {
                                if (C4904y.f17872b) {
                                    C4904y.m18639b(C5052r.m19199a("For thumbnail image exists, show it. ", file.getAbsolutePath()), f16468b);
                                }
                                this.f16483O = new C4589an(Uri.parse(file.getAbsolutePath()), this.f16501p, false, null);
                                this.f16477I.m19023b(this.f16487a, this.f16483O);
                                this.f16487a.setOnTouchListener(null);
                            }
                            m17323i();
                            return;
                        }
                        this.f16511z = true;
                        this.f16480L = C4641f.m17617b(this.f16505t);
                        if (C4904y.f17872b) {
                            C4904y.m18639b(C5052r.m19199a("Is AMS image: ", Boolean.valueOf(this.f16480L)), f16468b);
                        }
                        if (this.f16480L) {
                            m17310b(true);
                            this.f16509x = false;
                            this.f16487a.setOnTouchListener(null);
                            this.f16487a.setOnClickListener(this.f16485Q);
                            this.f16494i.setImageResource(R.drawable.chat_btn_ams_play_selector);
                            this.f16494i.setFocusable(true);
                            this.f16494i.setOnTouchListener(null);
                            this.f16494i.setOnClickListener(new ViewOnClickListenerC4597av(this));
                        } else {
                            m17310b(false);
                            this.f16509x = true;
                            this.f16487a.setOnTouchListener(this.f16475G);
                        }
                        this.f16483O = new C4589an(this.f16478J, this.f16501p, false, null);
                        if (m17312b(this.f16478J.toString()) && this.f16482N == null) {
                            this.f16482N = AsyncTaskC2843c.m11934a(this.f16478J.toString(), this.f16495j, this.f16487a, this.f16486R);
                            if (Build.VERSION.SDK_INT < 11) {
                                this.f16482N.execute(new String[0]);
                                return;
                            } else {
                                this.f16482N.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                return;
                            }
                        }
                        this.f16477I.m19023b(this.f16487a, this.f16483O);
                        return;
                    }
                    if (this.f16501p == EnumC4642g.VIDEO) {
                        m17310b(true);
                        this.f16487a.setOnTouchListener(null);
                        this.f16487a.setOnClickListener(this.f16485Q);
                        this.f16478J = C4636a.m17601a(this.f16505t);
                        if (this.f16478J == null) {
                            this.f16487a.setImageResource(R.drawable.turnk_no_veido_default);
                            this.f16477I.m19015a((View) this.f16487a);
                        } else {
                            this.f16511z = true;
                            this.f16509x = true;
                            this.f16477I.m19023b(this.f16487a, new C4589an(this.f16478J, this.f16501p, false, this.f16494i));
                        }
                        this.f16494i.setOnClickListener(new ViewOnClickListenerC4598aw(this));
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m17312b(String str) {
        return C5034k.m19099d() && str != null && !str.contains("thumbnail") && str.toLowerCase().endsWith("gif") && Build.VERSION.SDK_INT >= 14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m17310b(boolean z) {
        if (!this.f16508w) {
            if (z) {
                this.f16494i.setVisibility(0);
            } else {
                this.f16494i.setVisibility(8);
            }
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC4672f
    /* renamed from: a */
    public void mo17341a(InterfaceC4674h interfaceC4674h) {
        this.f16471C = interfaceC4674h;
    }

    @Override // com.sec.chaton.trunk.InterfaceC4672f
    /* renamed from: a */
    public void mo17340a(InterfaceC4673g interfaceC4673g) {
        this.f16472D = interfaceC4673g;
    }

    @Override // com.sec.chaton.trunk.InterfaceC4672f
    /* renamed from: b */
    public void mo17345b(InterfaceC4673g interfaceC4673g) {
        this.f16473E = interfaceC4673g;
    }

    @Override // com.sec.chaton.trunk.p121c.InterfaceC4640e
    /* renamed from: a */
    public void mo17343a(boolean z) {
        if (C4904y.f17874d) {
            C4904y.m18645d("Storage state is changed. finish activity.", f16468b);
        }
        if (this.f16489d != null) {
            this.f16489d.mo17457a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m17323i() {
        this.f16508w = true;
        m17325j();
        this.f16473E.mo17550a();
    }

    /* renamed from: j */
    private void m17325j() {
        this.f16469A.m17605a("content");
        this.f16491f.setVisibility(0);
        this.f16494i.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m17328k() {
        this.f16469A.m17606b("content");
        if (!this.f16469A.m17607c("content")) {
            this.f16491f.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m17330l() {
        this.f16490e.setText(R.string.popup_no_network_connection);
        this.f16490e.setDuration(0);
        this.f16490e.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m17332m() {
        if (this.f16497l == null) {
            this.f16497l = AbstractC4932a.m18733a(m17321h()).mo18734a(R.string.trunk_title).mo18746b(R.string.trunk_content_deleted).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4600ay(this)).mo18745a().mo18758a();
            this.f16497l.setCancelable(false);
        }
        if (this.f16497l != null) {
            this.f16497l.show();
        }
    }

    /* renamed from: c */
    public boolean m17346c() {
        return this.f16509x;
    }

    /* renamed from: d */
    public boolean m17347d() {
        return this.f16511z;
    }

    /* renamed from: f */
    public String m17348f() {
        return this.f16500o;
    }

    @Override // com.sec.chaton.multimedia.image.InterfaceC2838aw
    /* renamed from: e */
    public void mo11845e() {
        if (m17321h() != null && m17344b().m11931a()) {
            m17321h().m17464h();
        }
    }
}
