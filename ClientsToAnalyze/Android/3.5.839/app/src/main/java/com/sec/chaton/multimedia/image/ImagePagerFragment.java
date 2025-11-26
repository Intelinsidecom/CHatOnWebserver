package com.sec.chaton.multimedia.image;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p067j.p070c.AsyncTaskC2436c;
import com.sec.chaton.p067j.p070c.C2434a;
import com.sec.chaton.trunk.p118a.C4565a;
import com.sec.chaton.util.C4838bc;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AlertDialogC4916i;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.spp.push.Config;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class ImagePagerFragment extends Fragment implements InterfaceC2838aw {

    /* renamed from: f */
    private static final String f10232f = ImagePagerFragment.class.getSimpleName();

    /* renamed from: A */
    private Future<C0778b> f10233A;

    /* renamed from: B */
    private C4565a f10234B;

    /* renamed from: D */
    private Handler f10236D;

    /* renamed from: a */
    protected ProgressBar f10240a;

    /* renamed from: b */
    protected long f10241b;

    /* renamed from: c */
    protected String f10242c;

    /* renamed from: d */
    protected String f10243d;

    /* renamed from: l */
    private int f10250l;

    /* renamed from: m */
    private C2819ad f10251m;

    /* renamed from: n */
    private ImageView f10252n;

    /* renamed from: o */
    private ImageButton f10253o;

    /* renamed from: p */
    private ViewTreeObserver.OnGlobalLayoutListener f10254p;

    /* renamed from: q */
    private ViewTreeObserver.OnGlobalLayoutListener f10255q;

    /* renamed from: r */
    private String f10256r;

    /* renamed from: s */
    private EnumC2214ab f10257s;

    /* renamed from: t */
    private AlertDialogC4916i f10258t;

    /* renamed from: u */
    private boolean f10259u;

    /* renamed from: v */
    private Activity f10260v;

    /* renamed from: w */
    private FrameLayout f10261w;

    /* renamed from: x */
    private ImageView f10262x;

    /* renamed from: y */
    private AsyncTaskC2843c f10263y;

    /* renamed from: z */
    private C2820ae f10264z;

    /* renamed from: g */
    private final String f10245g = "messageId";

    /* renamed from: h */
    private final String f10246h = "downloadUri";

    /* renamed from: i */
    private final String f10247i = "msgType";

    /* renamed from: j */
    private final String f10248j = "content";

    /* renamed from: k */
    private final String f10249k = Config.NOTIFICATION_INTENT_SENDER;

    /* renamed from: C */
    private int f10235C = -1;

    /* renamed from: e */
    View.OnClickListener f10244e = new ViewOnClickListenerC2861u(this);

    /* renamed from: E */
    private View.OnClickListener f10237E = new ViewOnClickListenerC2816aa(this);

    /* renamed from: F */
    private Handler f10238F = new HandlerC2817ab(this);

    /* renamed from: G */
    private Handler f10239G = new HandlerC2818ac(this);

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_image_pager_item, viewGroup, false);
        this.f10261w = (FrameLayout) viewInflate.findViewById(R.id.layout_image);
        this.f10252n = (ImageView) viewInflate.findViewById(R.id.pager_image);
        this.f10240a = (ProgressBar) viewInflate.findViewById(R.id.download_progress);
        this.f10253o = (ImageButton) viewInflate.findViewById(R.id.play_button);
        if (m11844d() != null && m11844d().m11820h().containsKey(Integer.valueOf(this.f10250l))) {
            C2860t c2860t = m11844d().m11819g().get(m11844d().m11820h().get(Integer.valueOf(this.f10250l)));
            if (c2860t != null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("[Item]" + c2860t.toString(), f10232f);
                }
                this.f10256r = c2860t.f10498e;
                this.f10257s = c2860t.f10499f;
                this.f10241b = c2860t.f10495b;
                this.f10242c = c2860t.f10497d;
                this.f10243d = c2860t.f10494a;
            }
        } else if (bundle != null) {
            this.f10256r = bundle.getString("downloadUri");
            this.f10257s = EnumC2214ab.m10070a(bundle.getInt("msgType"));
            this.f10241b = bundle.getLong("messageId");
            this.f10242c = bundle.getString("content");
            this.f10243d = bundle.getString(Config.NOTIFICATION_INTENT_SENDER);
            if (C4904y.f17872b) {
                StringBuilder sb = new StringBuilder();
                sb.append("messageId: " + this.f10241b);
                sb.append(", mediaType: " + this.f10257s);
                sb.append(", sender: " + this.f10243d);
                sb.append(", content: " + this.f10242c);
                sb.append(", downloadUri: " + this.f10256r);
                sb.append("\n");
                C4904y.m18639b("[restore from onSaveInstanceState]" + sb.toString(), f10232f);
            }
        }
        if (m11844d() != null) {
            m11844d().m11814a(this.f10241b, this);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (C4904y.f17872b) {
            StringBuilder sb = new StringBuilder();
            sb.append("messageId: " + this.f10241b);
            sb.append(", mediaType: " + this.f10257s);
            sb.append(", sender: " + this.f10243d);
            sb.append(", content: " + this.f10242c);
            sb.append(", downloadUri: " + this.f10256r);
            sb.append("\n");
            C4904y.m18639b("[onSaveInstanceState]" + sb.toString(), f10232f);
        }
        bundle.putString("downloadUri", this.f10256r);
        bundle.putInt("msgType", this.f10257s.m10076a());
        bundle.putLong("messageId", this.f10241b);
        bundle.putString("content", this.f10242c);
        bundle.putString(Config.NOTIFICATION_INTENT_SENDER, this.f10243d);
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: a */
    protected void mo10895a() {
        if (!C2434a.m10540a().m10543a(this.f10241b, false) && m11844d() != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("downloadImage : " + this.f10241b, f10232f);
            }
            C2434a.m10540a().m10541a(null, null, m11844d().m11823k(), 0, this.f10242c, false, m11844d().m11821i(), this.f10241b, this.f10257s, EnumC2300t.ONETOONE, this.f10243d);
        }
        AsyncTaskC2436c asyncTaskC2436cM10545b = C2434a.m10540a().m10545b(this.f10241b);
        if (asyncTaskC2436cM10545b != null && !asyncTaskC2436cM10545b.m10557a()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("setImageHander : " + this.f10241b, f10232f);
            }
            if (m11844d() != null) {
                m11844d().m11812a(this.f10250l, false);
                m11844d().m11817c(this.f10250l, false);
                asyncTaskC2436cM10545b.m10552a(m11844d().m11823k());
            }
            this.f10240a.setVisibility(0);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m11842a(String str) {
        this.f10240a.setVisibility(4);
        if (!TextUtils.isEmpty(str) && !C1427a.f5066d.equals(str)) {
            if (!C4838bc.m18309a(str)) {
                m11838h();
            }
            String str2 = (this.f10256r == null || !this.f10256r.contains("thumbnail")) ? null : this.f10256r;
            this.f10256r = str;
            if (this.f10256r.startsWith("file:")) {
                this.f10256r = Uri.parse(this.f10256r).getPath();
            }
            if (this.f10257s == EnumC2214ab.AMS) {
                this.f10253o.setBackgroundResource(R.drawable.chat_btn_ams_play_selector);
                this.f10253o.setVisibility(0);
                this.f10259u = true;
                if (m11844d() != null) {
                    m11844d().m11815b(this.f10250l, false);
                }
            } else if (m11844d() != null) {
                m11844d().m11812a(this.f10250l, true);
            }
            if (m11844d() != null) {
                m11844d().m11817c(this.f10250l, true);
            }
            if (m11844d() != null) {
                this.f10264z = new C2820ae(this.f10241b + this.f10256r, this.f10256r, this.f10257s, str2, m11844d().m11823k(), this.f10252n);
            }
            if (C4838bc.m18309a(this.f10256r) && this.f10263y == null) {
                this.f10263y = AsyncTaskC2843c.m11934a(this.f10256r, this.f10261w, this.f10252n, this.f10238F);
                if (Build.VERSION.SDK_INT < 11) {
                    this.f10263y.execute(new String[0]);
                } else {
                    this.f10263y.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                }
            } else if (m11844d() != null && this.f10262x != null) {
                this.f10262x.setVisibility(0);
                m11844d().m11822j().m19023b(this.f10262x, this.f10264z);
            }
            this.f10253o.bringToFront();
            if (this.f10262x != null) {
                if (this.f10257s == EnumC2214ab.VIDEO || this.f10259u) {
                    this.f10262x.setOnTouchListener(null);
                } else {
                    this.f10262x.setOnTouchListener(this.f10251m);
                }
                ViewTreeObserver viewTreeObserver = this.f10262x.getViewTreeObserver();
                this.f10255q = new ViewTreeObserverOnGlobalLayoutListenerC2863w(this);
                viewTreeObserver.addOnGlobalLayoutListener(this.f10255q);
            }
        }
    }

    /* renamed from: b */
    protected void mo10896b() {
        if (!C2434a.m10540a().m10542a(this.f10241b)) {
            if (!C4873ck.m18504e()) {
                AbstractC4932a.m18733a(m11844d()).mo18734a(R.string.pop_up_attention).mo18746b(R.string.popup_not_enough_memory).mo18756d(R.string.dialog_ok, null).mo18752b();
                return;
            }
            if (this.f10258t == null) {
                this.f10258t = new AlertDialogC4916i(m11844d());
                this.f10258t.setTitle(R.string.download_title);
                this.f10258t.setMessage(getString(R.string.anicon_file_downloading));
                this.f10258t.setCancelable(false);
            }
            this.f10258t.setButton(-2, getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC2864x(this));
            if (m11844d() != null) {
                C2434a.m10540a().m10541a(null, null, m11844d().m11823k(), 0, this.f10242c, false, m11844d().m11821i(), this.f10241b, this.f10257s, EnumC2300t.ONETOONE, this.f10243d);
                this.f10258t.show();
                this.f10258t.m18719a(0);
                AsyncTaskC2436c asyncTaskC2436cM10545b = C2434a.m10540a().m10545b(this.f10241b);
                if (asyncTaskC2436cM10545b != null) {
                    asyncTaskC2436cM10545b.m10554a(this.f10258t);
                    asyncTaskC2436cM10545b.m10552a(m11844d().m11823k());
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f10250l = getArguments() != null ? getArguments().getInt(VKApiConst.POSITION) : 0;
        this.f10251m = new C2819ad(this, this);
        this.f10234B = new C4565a(m11844d(), this.f10239G);
        super.onCreate(bundle);
    }

    /* renamed from: c */
    public C2819ad m11843c() {
        return this.f10251m;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        if (this.f10252n != null && (viewTreeObserver2 = this.f10252n.getViewTreeObserver()) != null) {
            viewTreeObserver2.removeGlobalOnLayoutListener(this.f10254p);
        }
        if (this.f10262x != null && (viewTreeObserver = this.f10262x.getViewTreeObserver()) != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f10255q);
        }
        super.onPause();
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x015d  */
    @Override // android.support.v4.app.Fragment
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResume() {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.image.ImagePagerFragment.onResume():void");
    }

    /* renamed from: h */
    private void m11838h() {
        this.f10262x = new ImageView(m11844d());
        this.f10262x.setAdjustViewBounds(true);
        this.f10262x.setVisibility(8);
        this.f10261w.addView(this.f10262x, new ViewGroup.LayoutParams(-1, -1));
        this.f10262x.setOnClickListener(this.f10237E);
    }

    /* renamed from: d */
    protected ImagePagerActivity m11844d() {
        return (ImagePagerActivity) this.f10260v;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f10260v = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f10260v = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f10252n.setImageBitmap(null);
        if (m11844d() != null) {
            m11844d().m11822j().m19015a((View) this.f10252n);
            m11844d().m11813a(this.f10241b);
            if (this.f10262x != null) {
                this.f10262x.setImageBitmap(null);
                m11844d().m11822j().m19015a((View) this.f10262x);
            }
        }
        if (this.f10263y != null) {
            this.f10263y.m11937a();
        }
        if (this.f10236D != null) {
            this.f10236D.removeMessages(0);
        }
        if (this.f10233A != null) {
            this.f10233A.cancel(true);
        }
        super.onDestroyView();
    }

    @Override // com.sec.chaton.multimedia.image.InterfaceC2838aw
    /* renamed from: e */
    public void mo11845e() {
        if (m11844d() != null && m11843c().m11931a()) {
            m11844d().m11816b(this.f10259u);
        }
    }

    /* renamed from: f */
    public int m11846f() {
        return this.f10235C;
    }
}
