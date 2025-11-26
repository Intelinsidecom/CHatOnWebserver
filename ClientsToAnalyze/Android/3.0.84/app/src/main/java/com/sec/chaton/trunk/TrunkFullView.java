package com.sec.chaton.trunk;

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
import com.sec.chaton.R;
import com.sec.chaton.multimedia.image.AsyncTaskC1873b;
import com.sec.chaton.multimedia.image.InterfaceC1869at;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.trunk.p061c.C3021b;
import com.sec.chaton.trunk.p061c.C3022c;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.chaton.trunk.p061c.InterfaceC3024e;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3364o;
import com.sec.widget.C3641ai;
import java.io.File;

/* loaded from: classes.dex */
public class TrunkFullView extends Fragment implements InterfaceC1869at, InterfaceC3024e, InterfaceC3052f {

    /* renamed from: c */
    private static final String f10521c = TrunkFullView.class.getSimpleName();

    /* renamed from: A */
    private boolean f10522A;

    /* renamed from: B */
    private C3021b f10523B;

    /* renamed from: C */
    private C2971al f10524C;

    /* renamed from: D */
    private InterfaceC3054h f10525D;

    /* renamed from: E */
    private InterfaceC3053g f10526E;

    /* renamed from: F */
    private InterfaceC3053g f10527F;

    /* renamed from: G */
    private ViewTreeObserver.OnGlobalLayoutListener f10528G;

    /* renamed from: H */
    private C2984ay f10529H;

    /* renamed from: I */
    private ViewTreeObserver f10530I;

    /* renamed from: J */
    private C3326c f10531J;

    /* renamed from: K */
    private Uri f10532K;

    /* renamed from: L */
    private boolean f10533L;

    /* renamed from: M */
    private int f10534M;

    /* renamed from: N */
    private AsyncTaskC1873b f10535N;

    /* renamed from: O */
    private C2970ak f10536O;

    /* renamed from: P */
    private Handler f10537P = new HandlerC2976aq(this);

    /* renamed from: Q */
    private View.OnClickListener f10538Q = new ViewOnClickListenerC2980au(this);

    /* renamed from: R */
    private Handler f10539R = new HandlerC2982aw(this);

    /* renamed from: a */
    public ImageView f10540a;

    /* renamed from: b */
    public String f10541b;

    /* renamed from: d */
    private Activity f10542d;

    /* renamed from: e */
    private InterfaceC2983ax f10543e;

    /* renamed from: f */
    private Toast f10544f;

    /* renamed from: g */
    private ProgressBar f10545g;

    /* renamed from: h */
    private ImageView f10546h;

    /* renamed from: i */
    private ImageView f10547i;

    /* renamed from: j */
    private ImageView f10548j;

    /* renamed from: k */
    private FrameLayout f10549k;

    /* renamed from: l */
    private Dialog f10550l;

    /* renamed from: m */
    private Dialog f10551m;

    /* renamed from: n */
    private String f10552n;

    /* renamed from: o */
    private String f10553o;

    /* renamed from: p */
    private String f10554p;

    /* renamed from: q */
    private EnumC3026g f10555q;

    /* renamed from: r */
    private String f10556r;

    /* renamed from: s */
    private int f10557s;

    /* renamed from: t */
    private String f10558t;

    /* renamed from: u */
    private String f10559u;

    /* renamed from: v */
    private boolean f10560v;

    /* renamed from: w */
    private boolean f10561w;

    /* renamed from: x */
    private boolean f10562x;

    /* renamed from: y */
    private boolean f10563y;

    /* renamed from: z */
    private boolean f10564z;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public TrunkPageActivity m10223h() {
        return (TrunkPageActivity) this.f10542d;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f10542d = activity;
        try {
            this.f10543e = (InterfaceC2983ax) this.f10542d;
        } catch (ClassCastException e) {
            throw new ClassCastException(C3364o.m11849a(activity.toString(), " must implement ITrunkFullViewListener."));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10542d = null;
        this.f10543e = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        C3017by c3017by;
        this.f10534M = getArguments() != null ? getArguments().getInt("position") : 0;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f10552n = bundle.getString("sessionId");
            this.f10553o = bundle.getString("inboxNo");
            this.f10554p = bundle.getString("itemId");
            this.f10556r = bundle.getString("downloadUrl");
            this.f10555q = C3025f.m10537a(bundle.getString("contentType"), false);
            this.f10557s = bundle.getInt("totalcomment");
            this.f10533L = bundle.getBoolean("isvalid");
            if (C3250y.f11734b) {
                StringBuilder sb = new StringBuilder();
                sb.append("sessionId: " + this.f10552n);
                sb.append(", inboxNo: " + this.f10553o);
                sb.append(", itemId: " + this.f10554p);
                sb.append(", contentType: " + this.f10555q);
                sb.append(", downloadUri: " + this.f10556r);
                sb.append(", totalCommentCount" + this.f10557s);
                sb.append("isvalid: " + this.f10533L);
                sb.append("\n");
                C3250y.m11450b("[restore from onSaveInstanceState]" + sb.toString(), f10521c);
            }
        } else if (m10223h() != null && m10223h().m10363c().size() > this.f10534M && (c3017by = m10223h().m10363c().get(this.f10534M)) != null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("[Item]" + c3017by.toString(), f10521c);
            }
            this.f10552n = c3017by.f10865a;
            this.f10553o = c3017by.f10866b;
            this.f10554p = c3017by.f10870f;
            this.f10556r = c3017by.f10872h;
            this.f10555q = c3017by.f10873i;
            this.f10557s = c3017by.f10874j;
            this.f10533L = c3017by.f10875k;
        }
        this.f10544f = C3641ai.m13211a(CommonApplication.m11493l(), (CharSequence) null, 0);
        this.f10523B = new C3021b();
        this.f10531J = new C3326c();
        this.f10529H = new C2984ay(this, this);
    }

    /* renamed from: b */
    public C2984ay m10246b() {
        return this.f10529H;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (C3250y.f11734b) {
            StringBuilder sb = new StringBuilder();
            sb.append("sessionId: " + this.f10552n);
            sb.append(", inboxNo: " + this.f10553o);
            sb.append(", itemId: " + this.f10554p);
            sb.append(", contentType: " + this.f10555q);
            sb.append(", downloadUri: " + this.f10556r);
            sb.append(", totalCommentCount" + this.f10557s);
            sb.append("isvalid: " + this.f10533L);
            sb.append("\n");
            C3250y.m11450b("[onSaveInstanceState]" + sb.toString(), f10521c);
        }
        bundle.putString("sessionId", this.f10552n);
        bundle.putString("inboxNo", this.f10553o);
        bundle.putString("itemId", this.f10554p);
        bundle.putString("downloadUrl", this.f10556r);
        bundle.putString("contentType", this.f10555q.toString());
        bundle.putInt("totalcomment", this.f10557s);
        bundle.putBoolean("isvalid", this.f10533L);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_trunk_full, viewGroup, false);
        this.f10549k = (FrameLayout) viewInflate.findViewById(R.id.trunkImageWithoutComment);
        this.f10540a = (ImageView) viewInflate.findViewById(R.id.trunkContentMainImage_f);
        this.f10546h = (ImageView) viewInflate.findViewById(R.id.defaultImage_f);
        this.f10547i = (ImageView) viewInflate.findViewById(R.id.defaultVideo_f);
        this.f10548j = (ImageView) viewInflate.findViewById(R.id.defaultPlayBtn_f);
        this.f10545g = (ProgressBar) viewInflate.findViewById(R.id.trunkContentDownloadProgressbar_f);
        this.f10540a.setOnTouchListener(this.f10529H);
        m10212b(false);
        this.f10524C = new C2971al(this, this.f10537P, this.f10553o, this.f10552n, this.f10554p);
        this.f10524C.m10411a();
        this.f10525D.mo10453a(100, 239);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C3022c.m10532a(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f10540a != null) {
            this.f10530I = this.f10549k.getViewTreeObserver();
            this.f10528G = new ViewTreeObserverOnGlobalLayoutListenerC2977ar(this);
            this.f10530I.addOnGlobalLayoutListener(this.f10528G);
        }
        this.f10524C.m10412b();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f10530I != null && this.f10530I.isAlive()) {
            this.f10530I.removeGlobalOnLayoutListener(this.f10528G);
        }
        this.f10524C.m10413c();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        C3022c.m10534b(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f10524C.m10414d();
        if (this.f10531J != null) {
            this.f10531J.m11731a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f10523B.m10527a();
    }

    @Override // com.sec.chaton.trunk.InterfaceC3052f
    /* renamed from: a */
    public Activity mo10240a() {
        return this.f10542d;
    }

    @Override // com.sec.chaton.trunk.InterfaceC3052f
    /* renamed from: a */
    public void mo10244a(String str) {
        this.f10558t = str;
        if ("ME".equals(this.f10558t) && this.f10533L) {
            this.f10564z = true;
        } else {
            this.f10564z = false;
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC3052f
    /* renamed from: a */
    public void mo10241a(EnumC3026g enumC3026g, File file, String str) {
        if (!this.f10561w) {
            if (!this.f10562x || this.f10559u == null || !this.f10559u.equals(str)) {
                this.f10555q = enumC3026g;
                this.f10559u = str;
                if (this.f10532K == null || !this.f10532K.equals(C3020a.m10524a(this.f10559u))) {
                    this.f10563y = false;
                    if (this.f10559u == null || this.f10559u.trim().equals("")) {
                        this.f10531J.m11732a(this.f10540a);
                    } else if (this.f10555q == EnumC3026g.IMAGE) {
                        this.f10532K = C3020a.m10524a(this.f10559u);
                        if (this.f10532K == null) {
                            if (file.exists()) {
                                if (C3250y.f11734b) {
                                    C3250y.m11450b(C3364o.m11849a("For thumbnail image exists, show it. ", file.getAbsolutePath()), f10521c);
                                }
                                this.f10531J.m11732a(this.f10540a);
                                this.f10540a.setImageBitmap(C3162ad.m11003a(Uri.parse(file.getAbsolutePath())));
                            }
                            m10225i();
                        } else {
                            this.f10522A = true;
                            boolean zM10540b = C3025f.m10540b(this.f10559u);
                            if (C3250y.f11734b) {
                                C3250y.m11450b(C3364o.m11849a("Is AMS image: ", Boolean.valueOf(zM10540b)), f10521c);
                            }
                            if (zM10540b) {
                                m10212b(true);
                                this.f10563y = false;
                                if (this.f10530I != null && this.f10530I.isAlive()) {
                                    this.f10530I.removeGlobalOnLayoutListener(this.f10528G);
                                }
                                this.f10540a.setOnTouchListener(null);
                                this.f10540a.setOnClickListener(this.f10538Q);
                                this.f10548j.setImageResource(R.drawable.chat_btn_ams_play);
                                this.f10548j.setOnTouchListener(null);
                                this.f10548j.setOnClickListener(new ViewOnClickListenerC2978as(this));
                            } else {
                                m10212b(false);
                                this.f10563y = true;
                            }
                            this.f10536O = new C2970ak(this.f10532K, this.f10555q, false, null);
                            if (m10214b(this.f10532K.toString()) && this.f10535N == null) {
                                this.f10535N = new AsyncTaskC1873b(this.f10532K.toString(), this.f10549k, this.f10540a, this.f10539R);
                                if (Build.VERSION.SDK_INT < 11) {
                                    this.f10535N.execute(new String[0]);
                                } else {
                                    this.f10535N.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                }
                            } else {
                                this.f10531J.m11730a(this.f10540a, this.f10536O);
                            }
                        }
                    } else if (this.f10555q == EnumC3026g.VIDEO) {
                        if (this.f10530I != null && this.f10530I.isAlive()) {
                            this.f10530I.removeGlobalOnLayoutListener(this.f10528G);
                        }
                        m10212b(true);
                        this.f10540a.setOnTouchListener(null);
                        this.f10540a.setOnClickListener(this.f10538Q);
                        this.f10532K = C3020a.m10524a(this.f10559u);
                        if (this.f10532K == null) {
                            this.f10540a.setImageResource(R.drawable.turnk_no_veido_default);
                            this.f10531J.m11732a(this.f10540a);
                        } else {
                            this.f10522A = true;
                            this.f10563y = true;
                            this.f10531J.m11730a(this.f10540a, new C2970ak(this.f10532K, this.f10555q, false, this.f10548j));
                        }
                        this.f10548j.setOnClickListener(new ViewOnClickListenerC2979at(this));
                    }
                    this.f10543e.mo10362b();
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m10214b(String str) {
        return C3347i.m11781d() && str != null && !str.contains("thumbnail") && str.toLowerCase().endsWith("gif") && Build.VERSION.SDK_INT >= 14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10212b(boolean z) {
        if (!this.f10562x) {
            if (z) {
                this.f10548j.setVisibility(0);
            } else {
                this.f10548j.setVisibility(8);
            }
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC3052f
    /* renamed from: a */
    public void mo10243a(InterfaceC3054h interfaceC3054h) {
        this.f10525D = interfaceC3054h;
    }

    @Override // com.sec.chaton.trunk.InterfaceC3052f
    /* renamed from: a */
    public void mo10242a(InterfaceC3053g interfaceC3053g) {
        this.f10526E = interfaceC3053g;
    }

    @Override // com.sec.chaton.trunk.InterfaceC3052f
    /* renamed from: b */
    public void mo10247b(InterfaceC3053g interfaceC3053g) {
        this.f10527F = interfaceC3053g;
    }

    @Override // com.sec.chaton.trunk.p061c.InterfaceC3024e
    /* renamed from: a */
    public void mo10245a(boolean z) {
        if (C3250y.f11736d) {
            C3250y.m11455d("Storage state is changed. finish activity.", f10521c);
        }
        if (this.f10543e != null) {
            this.f10543e.mo10359a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m10225i() {
        this.f10562x = true;
        m10228j();
        this.f10527F.mo10454a();
    }

    /* renamed from: j */
    private void m10228j() {
        this.f10523B.m10528a("content");
        this.f10545g.setVisibility(0);
        this.f10548j.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m10230k() {
        this.f10523B.m10529b("content");
        if (!this.f10523B.m10530c("content")) {
            this.f10545g.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m10232l() {
        this.f10544f.setText(R.string.popup_no_network_connection);
        this.f10544f.setDuration(0);
        this.f10544f.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m10233m() {
        if (this.f10551m == null) {
            this.f10551m = AbstractC3271a.m11494a(m10223h()).mo11500a((CharSequence) null).mo11506b(R.string.trunk_content_deleted).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2981av(this)).mo11505a().mo11517a();
            this.f10551m.setCancelable(false);
        }
        if (this.f10551m != null) {
            this.f10551m.show();
        }
    }

    /* renamed from: c */
    public boolean m10248c() {
        return this.f10563y;
    }

    /* renamed from: d */
    public boolean m10249d() {
        return this.f10522A;
    }

    /* renamed from: e */
    public String m10250e() {
        return this.f10554p;
    }

    @Override // com.sec.chaton.multimedia.image.InterfaceC1869at
    /* renamed from: f */
    public void mo7631f() {
        if (m10223h() != null && m10246b().m7705a()) {
            m10223h().m10366f();
        }
    }
}
