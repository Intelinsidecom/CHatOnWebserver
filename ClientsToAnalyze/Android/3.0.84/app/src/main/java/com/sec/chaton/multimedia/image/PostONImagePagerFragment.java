package com.sec.chaton.multimedia.image;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.poston.CallableC1986az;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.p070a.C3332a;
import com.sec.spp.push.Config;
import java.io.File;

/* loaded from: classes.dex */
public class PostONImagePagerFragment extends Fragment implements InterfaceC1869at {

    /* renamed from: b */
    private static final String f6996b = PostONImagePagerFragment.class.getSimpleName();

    /* renamed from: i */
    private static String f6997i = "1";

    /* renamed from: j */
    private static String f6998j = "2";

    /* renamed from: k */
    private static String f6999k = C3223ck.m11329c() + "/poston/";

    /* renamed from: l */
    private static String f7000l = "pager";

    /* renamed from: A */
    private File f7001A;

    /* renamed from: B */
    private String f7002B;

    /* renamed from: C */
    private ProgressDialog f7003C;

    /* renamed from: D */
    private C3326c f7004D;

    /* renamed from: F */
    private Activity f7006F;

    /* renamed from: G */
    private FrameLayout f7007G;

    /* renamed from: H */
    private ImageView f7008H;

    /* renamed from: I */
    private View f7009I;

    /* renamed from: J */
    private ViewTreeObserver f7010J;

    /* renamed from: K */
    private int f7011K;

    /* renamed from: L */
    private int f7012L;

    /* renamed from: m */
    private int f7023m;

    /* renamed from: n */
    private C1867ar f7024n;

    /* renamed from: o */
    private ImageView f7025o;

    /* renamed from: p */
    private ImageButton f7026p;

    /* renamed from: q */
    private ViewTreeObserver.OnGlobalLayoutListener f7027q;

    /* renamed from: r */
    private ViewTreeObserver.OnGlobalLayoutListener f7028r;

    /* renamed from: s */
    private String f7029s;

    /* renamed from: t */
    private String f7030t;

    /* renamed from: u */
    private String f7031u;

    /* renamed from: v */
    private String f7032v;

    /* renamed from: w */
    private String f7033w;

    /* renamed from: x */
    private String f7034x;

    /* renamed from: y */
    private String f7035y;

    /* renamed from: z */
    private String f7036z;

    /* renamed from: c */
    private final String f7017c = "postonId";

    /* renamed from: d */
    private final String f7018d = "downloadUri";

    /* renamed from: e */
    private final String f7019e = "msgType";

    /* renamed from: f */
    private final String f7020f = "content";

    /* renamed from: g */
    private final String f7021g = Config.NOTIFICATION_INTENT_SENDER;

    /* renamed from: h */
    private final String f7022h = "sequence";

    /* renamed from: E */
    private String f7005E = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");

    /* renamed from: a */
    View.OnClickListener f7016a = new ViewOnClickListenerC1860ak(this);

    /* renamed from: M */
    private Handler f7013M = new HandlerC1862am(this);

    /* renamed from: N */
    private View.OnClickListener f7014N = new ViewOnClickListenerC1864ao(this);

    /* renamed from: O */
    private ViewTreeObserver.OnGlobalLayoutListener f7015O = new ViewTreeObserverOnGlobalLayoutListenerC1865ap(this);

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_image_pager_item_poston, viewGroup, false);
        this.f7007G = (FrameLayout) viewInflate.findViewById(R.id.layout_image);
        this.f7025o = (ImageView) viewInflate.findViewById(R.id.pager_image);
        this.f7026p = (ImageButton) viewInflate.findViewById(R.id.play_button);
        this.f7035y = f6999k + this.f7002B;
        this.f7004D = new C3326c();
        if (m7687b() != null && m7687b().m7659c().containsKey(Integer.valueOf(this.f7023m))) {
            C1859aj c1859aj = m7687b().m7658b().get(m7687b().m7659c().get(Integer.valueOf(this.f7023m)));
            if (c1859aj != null) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("[Item]" + c1859aj.toString(), f6996b);
                }
                this.f7029s = c1859aj.f7087a;
                this.f7030t = c1859aj.f7089c;
                this.f7031u = c1859aj.f7090d;
                this.f7032v = c1859aj.f7091e;
                this.f7033w = c1859aj.f7092f;
                this.f7034x = c1859aj.f7093g;
            }
        } else if (bundle != null) {
            this.f7029s = bundle.getString("postonId");
            this.f7031u = bundle.getString("downloadUri");
            this.f7030t = bundle.getString("msgType");
            this.f7032v = bundle.getString("content");
            this.f7033w = bundle.getString(Config.NOTIFICATION_INTENT_SENDER);
            this.f7034x = bundle.getString("sequence");
            if (C3250y.f11734b) {
                StringBuilder sb = new StringBuilder();
                sb.append("mPostonNo: " + this.f7029s);
                sb.append(", mMetaType: " + this.f7030t);
                sb.append(", mDownUri: " + this.f7031u);
                sb.append(", mContent: " + this.f7032v);
                sb.append(", mSender: " + this.f7033w);
                sb.append(", mSequence: " + this.f7034x);
                sb.append("\n");
                C3250y.m11450b("[restore from onSaveInstanceState]" + sb.toString(), f6996b);
            }
        }
        if (m7687b() != null) {
            m7687b().m7657a(this.f7029s, this);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (C3250y.f11734b) {
            StringBuilder sb = new StringBuilder();
            sb.append("mPostonNo: " + this.f7029s);
            sb.append(", mediaType: " + this.f7030t);
            sb.append(", sender: " + this.f7033w);
            sb.append(", content: " + this.f7032v);
            sb.append(", downloadUri: " + this.f7031u);
            sb.append(", mSequence: " + this.f7034x);
            sb.append("\n");
            C3250y.m11450b("[onSaveInstanceState]" + sb.toString(), f6996b);
        }
        bundle.putString("downloadUri", this.f7031u);
        bundle.putString("msgType", this.f7030t);
        bundle.putString("postonId", this.f7029s);
        bundle.putString("content", this.f7032v);
        bundle.putString(Config.NOTIFICATION_INTENT_SENDER, this.f7033w);
        bundle.putString("sequence", this.f7034x);
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: a */
    protected void m7686a(boolean z) {
        String str;
        if (z) {
            str = CallableC1986az.f7685d;
        } else {
            str = CallableC1986az.f7686e;
        }
        CallableC1986az callableC1986az = new CallableC1986az(this.f7031u, this.f7002B, this.f7030t.equals(f6997i), f7000l, str);
        if (C3250y.f11733a) {
            C3250y.m11456e("downloadMultimedia() mDownUri : " + this.f7031u, f6996b);
        }
        this.f7004D.m11730a(this.f7025o, callableC1986az);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m7674e() {
        if (this.f7003C == null) {
            this.f7003C = new ProgressDialog(this.f7006F);
            this.f7003C.setProgressStyle(1);
            this.f7003C.setMessage(getResources().getString(R.string.media_file_download));
            this.f7003C.setCancelable(false);
        }
        this.f7003C.setButton(-2, getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1861al(this));
        this.f7003C.show();
        this.f7003C.setProgress(0);
        try {
            C3332a.m11750a().m11754a(this.f7013M, this.f7031u + this.f7005E, this.f7001A, null);
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f6996b);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (GlobalApplication.m6456e() && GlobalApplication.m6457f()) {
            this.f7009I = getActivity().getWindow().getDecorView();
            m7677g();
            this.f7011K = this.f7009I.getHeight();
            this.f7012L = this.f7009I.getWidth();
        }
        this.f7023m = getArguments() != null ? getArguments().getInt("position") : 0;
        this.f7002B = getArguments().getString("buddyId");
        this.f7024n = new C1867ar(this, this);
    }

    /* renamed from: a */
    public C1867ar m7685a() {
        return this.f7024n;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        super.onPause();
        if (this.f7025o != null && (viewTreeObserver2 = this.f7025o.getViewTreeObserver()) != null) {
            viewTreeObserver2.removeGlobalOnLayoutListener(this.f7027q);
        }
        if (this.f7008H != null && (viewTreeObserver = this.f7008H.getViewTreeObserver()) != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f7028r);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f7003C != null && this.f7003C.isShowing()) {
            C3332a.m11750a().m11756a(this.f7013M, this.f7031u + this.f7005E);
            this.f7003C.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        m7686a(true);
        this.f7026p.setOnClickListener(this.f7016a);
        if (this.f7031u != null && this.f7031u.startsWith("file:")) {
            this.f7031u = Uri.parse(this.f7031u).getPath();
        }
        if (this.f7030t.equals(f6998j)) {
            this.f7026p.setVisibility(0);
            this.f7025o.setOnTouchListener(null);
        } else {
            this.f7025o.setOnTouchListener(this.f7024n);
        }
        if (this.f7025o != null) {
            ViewTreeObserver viewTreeObserver = this.f7025o.getViewTreeObserver();
            this.f7027q = new ViewTreeObserverOnGlobalLayoutListenerC1863an(this);
            viewTreeObserver.addOnGlobalLayoutListener(this.f7027q);
        }
        if (this.f7025o != null) {
            this.f7025o.setOnClickListener(this.f7014N);
        }
        super.onResume();
    }

    /* renamed from: b */
    protected PostONImagePagerActivity m7687b() {
        return (PostONImagePagerActivity) this.f7006F;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f7006F = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f7006F = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f7025o.setImageBitmap(null);
        if (m7687b() != null) {
            m7687b().m7660d().m11732a(this.f7025o);
            m7687b().m7656a(this.f7029s);
            if (this.f7008H != null) {
                this.f7008H.setImageBitmap(null);
                m7687b().m7660d().m11732a(this.f7008H);
            }
        }
        super.onDestroyView();
    }

    @Override // com.sec.chaton.multimedia.image.InterfaceC1869at
    /* renamed from: f */
    public void mo7631f() {
        if (m7687b() != null && m7685a().m7705a()) {
            m7687b().m7662f();
        }
    }

    /* renamed from: g */
    private void m7677g() {
        this.f7010J = this.f7009I.getViewTreeObserver();
        this.f7010J.addOnGlobalLayoutListener(this.f7015O);
    }
}
