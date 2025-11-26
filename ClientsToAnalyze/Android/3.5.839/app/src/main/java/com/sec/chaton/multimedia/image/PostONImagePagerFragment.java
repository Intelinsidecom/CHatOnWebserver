package com.sec.chaton.multimedia.image;

import android.app.Activity;
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
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.poston.CallableC2983ba;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AlertDialogC4916i;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.p133a.C5017a;
import com.sec.spp.push.Config;
import com.sec.widget.C5179v;
import java.io.File;

/* loaded from: classes.dex */
public class PostONImagePagerFragment extends Fragment implements InterfaceC2838aw {

    /* renamed from: b */
    private static final String f10303b = PostONImagePagerFragment.class.getSimpleName();

    /* renamed from: i */
    private static String f10304i = Spam.ACTIVITY_REPORT;

    /* renamed from: j */
    private static String f10305j = Spam.ACTIVITY_CHECK;

    /* renamed from: k */
    private static String f10306k = C4873ck.m18502c() + "/poston/";

    /* renamed from: l */
    private static String f10307l = "pager";

    /* renamed from: A */
    private File f10308A;

    /* renamed from: B */
    private String f10309B;

    /* renamed from: C */
    private AlertDialogC4916i f10310C;

    /* renamed from: D */
    private C5007c f10311D;

    /* renamed from: F */
    private Activity f10313F;

    /* renamed from: G */
    private FrameLayout f10314G;

    /* renamed from: H */
    private ImageView f10315H;

    /* renamed from: I */
    private View f10316I;

    /* renamed from: J */
    private int f10317J;

    /* renamed from: K */
    private int f10318K;

    /* renamed from: m */
    private int f10329m;

    /* renamed from: n */
    private C2836au f10330n;

    /* renamed from: o */
    private ImageView f10331o;

    /* renamed from: p */
    private ImageButton f10332p;

    /* renamed from: q */
    private ViewTreeObserver.OnGlobalLayoutListener f10333q;

    /* renamed from: r */
    private ViewTreeObserver.OnGlobalLayoutListener f10334r;

    /* renamed from: s */
    private String f10335s;

    /* renamed from: t */
    private String f10336t;

    /* renamed from: u */
    private String f10337u;

    /* renamed from: v */
    private String f10338v;

    /* renamed from: w */
    private String f10339w;

    /* renamed from: x */
    private String f10340x;

    /* renamed from: y */
    private String f10341y;

    /* renamed from: z */
    private String f10342z;

    /* renamed from: c */
    private final String f10323c = "postonId";

    /* renamed from: d */
    private final String f10324d = "downloadUri";

    /* renamed from: e */
    private final String f10325e = "msgType";

    /* renamed from: f */
    private final String f10326f = "content";

    /* renamed from: g */
    private final String f10327g = Config.NOTIFICATION_INTENT_SENDER;

    /* renamed from: h */
    private final String f10328h = "sequence";

    /* renamed from: E */
    private String f10312E = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");

    /* renamed from: a */
    View.OnClickListener f10322a = new ViewOnClickListenerC2829an(this);

    /* renamed from: L */
    private Handler f10319L = new HandlerC2831ap(this);

    /* renamed from: M */
    private View.OnClickListener f10320M = new ViewOnClickListenerC2833ar(this);

    /* renamed from: N */
    private ViewTreeObserver.OnGlobalLayoutListener f10321N = new ViewTreeObserverOnGlobalLayoutListenerC2834as(this);

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_image_pager_item_poston, viewGroup, false);
        this.f10314G = (FrameLayout) viewInflate.findViewById(R.id.layout_image);
        this.f10331o = (ImageView) viewInflate.findViewById(R.id.pager_image);
        this.f10332p = (ImageButton) viewInflate.findViewById(R.id.play_button);
        this.f10341y = f10306k + this.f10309B;
        this.f10311D = new C5007c();
        if (m11910c() != null && m11910c().m11878h().containsKey(Integer.valueOf(this.f10329m))) {
            C2828am c2828am = m11910c().m11877g().get(m11910c().m11878h().get(Integer.valueOf(this.f10329m)));
            if (c2828am != null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("[Item]" + c2828am.toString(), f10303b);
                }
                this.f10335s = c2828am.f10398a;
                this.f10336t = c2828am.f10400c;
                this.f10337u = c2828am.f10401d;
                this.f10338v = c2828am.f10402e;
                this.f10339w = c2828am.f10403f;
                this.f10340x = c2828am.f10404g;
            }
        } else if (bundle != null) {
            this.f10335s = bundle.getString("postonId");
            this.f10337u = bundle.getString("downloadUri");
            this.f10336t = bundle.getString("msgType");
            this.f10338v = bundle.getString("content");
            this.f10339w = bundle.getString(Config.NOTIFICATION_INTENT_SENDER);
            this.f10340x = bundle.getString("sequence");
            if (C4904y.f17872b) {
                StringBuilder sb = new StringBuilder();
                sb.append("mPostonNo: " + this.f10335s);
                sb.append(", mMetaType: " + this.f10336t);
                sb.append(", mDownUri: " + this.f10337u);
                sb.append(", mContent: " + this.f10338v);
                sb.append(", mSender: " + this.f10339w);
                sb.append(", mSequence: " + this.f10340x);
                sb.append("\n");
                C4904y.m18639b("[restore from onSaveInstanceState]" + sb.toString(), f10303b);
            }
        }
        if (m11910c() != null) {
            m11910c().m11872a(this.f10335s, this);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (C4904y.f17872b) {
            StringBuilder sb = new StringBuilder();
            sb.append("mPostonNo: " + this.f10335s);
            sb.append(", mediaType: " + this.f10336t);
            sb.append(", sender: " + this.f10339w);
            sb.append(", content: " + this.f10338v);
            sb.append(", downloadUri: " + this.f10337u);
            sb.append(", mSequence: " + this.f10340x);
            sb.append("\n");
            C4904y.m18639b("[onSaveInstanceState]" + sb.toString(), f10303b);
        }
        bundle.putString("downloadUri", this.f10337u);
        bundle.putString("msgType", this.f10336t);
        bundle.putString("postonId", this.f10335s);
        bundle.putString("content", this.f10338v);
        bundle.putString(Config.NOTIFICATION_INTENT_SENDER, this.f10339w);
        bundle.putString("sequence", this.f10340x);
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: a */
    protected void m11908a() {
        int iLastIndexOf;
        String str = CallableC2983ba.f11084d;
        if (this.f10337u != null && (iLastIndexOf = this.f10337u.lastIndexOf(47)) > 0) {
            File file = new File(this.f10341y, this.f10337u.substring(iLastIndexOf + 1));
            if (file.exists() && file.length() > 0) {
                str = CallableC2983ba.f11085e;
            }
        }
        CallableC2983ba callableC2983ba = new CallableC2983ba(this.f10337u, this.f10309B, this.f10336t.equals(f10304i), f10307l, str, this.f10319L);
        if (C4904y.f17871a) {
            C4904y.m18646e("downloadMultimedia() mDownUri : " + this.f10337u, f10303b);
        }
        this.f10311D.m19023b(this.f10331o, callableC2983ba);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m11901h() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(getActivity(), R.string.sdcard_not_found, 0).show();
            return;
        }
        if (this.f10310C == null) {
            this.f10310C = new AlertDialogC4916i(this.f10313F);
            this.f10310C.setTitle(R.string.download_title);
            this.f10310C.setMessage(getString(R.string.anicon_file_downloading));
            this.f10310C.setCancelable(false);
        }
        this.f10310C.setButton(-2, getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC2830ao(this));
        this.f10310C.show();
        this.f10310C.m18719a(0);
        try {
            C5017a.m19064a().m19068a(this.f10319L, this.f10337u + this.f10312E, this.f10308A, null);
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f10303b);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10329m = getArguments() != null ? getArguments().getInt(VKApiConst.POSITION) : 0;
        this.f10309B = getArguments().getString("buddyId");
        this.f10330n = new C2836au(this, this);
    }

    /* renamed from: b */
    public C2836au m11909b() {
        return this.f10330n;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        super.onPause();
        if (this.f10331o != null && (viewTreeObserver2 = this.f10331o.getViewTreeObserver()) != null) {
            viewTreeObserver2.removeGlobalOnLayoutListener(this.f10333q);
        }
        if (this.f10315H != null && (viewTreeObserver = this.f10315H.getViewTreeObserver()) != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f10334r);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f10310C != null && this.f10310C.isShowing()) {
            C5017a.m19064a().m19070a(this.f10319L, this.f10337u + this.f10312E);
            this.f10310C.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        m11908a();
        this.f10332p.setOnClickListener(this.f10322a);
        if (this.f10337u != null && this.f10337u.startsWith("file:")) {
            this.f10337u = Uri.parse(this.f10337u).getPath();
        }
        if (this.f10336t.equals(f10305j)) {
            this.f10332p.setVisibility(0);
            if (this.f10331o != null) {
                this.f10331o.setOnTouchListener(null);
            }
        } else if (this.f10331o != null) {
            this.f10331o.setOnTouchListener(this.f10330n);
        }
        if (this.f10331o != null) {
            ViewTreeObserver viewTreeObserver = this.f10331o.getViewTreeObserver();
            this.f10333q = new ViewTreeObserverOnGlobalLayoutListenerC2832aq(this);
            viewTreeObserver.addOnGlobalLayoutListener(this.f10333q);
        }
        if (this.f10331o != null) {
            this.f10331o.setOnClickListener(this.f10320M);
        }
        super.onResume();
    }

    /* renamed from: c */
    protected PostONImagePagerActivity m11910c() {
        return (PostONImagePagerActivity) this.f10313F;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f10313F = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f10313F = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f10331o.setImageBitmap(null);
        if (m11910c() != null) {
            m11910c().m11879i().m19015a((View) this.f10331o);
            m11910c().m11875c(this.f10335s);
            if (this.f10315H != null) {
                this.f10315H.setImageBitmap(null);
                m11910c().m11879i().m19015a((View) this.f10315H);
            }
        }
        super.onDestroyView();
    }

    @Override // com.sec.chaton.multimedia.image.InterfaceC2838aw
    /* renamed from: e */
    public void mo11845e() {
        if (m11910c() != null && !m11910c().isFinishing() && m11909b().m11931a()) {
            m11910c().m11881k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11887a(boolean z) {
        if (m11910c() != null) {
            m11910c().m11874b(this.f10329m, z);
            if (C4904y.f17872b) {
                C4904y.m18639b("PostON enableShare : " + z + " // index : " + this.f10329m, f10303b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11891b(boolean z) {
        if (m11910c() != null) {
            m11910c().m11870a(this.f10329m, z);
            if (C4904y.f17872b) {
                C4904y.m18639b("PostON enableSave : " + z + " // index : " + this.f10329m, f10303b);
            }
        }
    }
}
