package com.sec.chaton.multimedia.image;

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
import com.sec.chaton.R;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p037j.p040c.AsyncTaskC1557c;
import com.sec.chaton.p037j.p040c.C1555a;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.AlertDialogC3256c;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.util.C3347i;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class ImagePagerFragment extends Fragment implements InterfaceC1869at {

    /* renamed from: f */
    private static final String f6933f = ImagePagerFragment.class.getSimpleName();

    /* renamed from: a */
    protected ProgressBar f6936a;

    /* renamed from: b */
    protected long f6937b;

    /* renamed from: c */
    protected String f6938c;

    /* renamed from: d */
    protected String f6939d;

    /* renamed from: l */
    private int f6946l;

    /* renamed from: m */
    private C1850aa f6947m;

    /* renamed from: n */
    private ImageView f6948n;

    /* renamed from: o */
    private ImageButton f6949o;

    /* renamed from: p */
    private ViewTreeObserver.OnGlobalLayoutListener f6950p;

    /* renamed from: q */
    private ViewTreeObserver.OnGlobalLayoutListener f6951q;

    /* renamed from: r */
    private String f6952r;

    /* renamed from: s */
    private EnumC1455w f6953s;

    /* renamed from: t */
    private AlertDialogC3256c f6954t;

    /* renamed from: u */
    private boolean f6955u;

    /* renamed from: v */
    private Activity f6956v;

    /* renamed from: w */
    private FrameLayout f6957w;

    /* renamed from: x */
    private ImageView f6958x;

    /* renamed from: y */
    private AsyncTaskC1873b f6959y;

    /* renamed from: z */
    private C1851ab f6960z;

    /* renamed from: g */
    private final String f6941g = "messageId";

    /* renamed from: h */
    private final String f6942h = "downloadUri";

    /* renamed from: i */
    private final String f6943i = "msgType";

    /* renamed from: j */
    private final String f6944j = "content";

    /* renamed from: k */
    private final String f6945k = Config.NOTIFICATION_INTENT_SENDER;

    /* renamed from: e */
    View.OnClickListener f6940e = new ViewOnClickListenerC1892u(this);

    /* renamed from: A */
    private View.OnClickListener f6934A = new ViewOnClickListenerC1896y(this);

    /* renamed from: B */
    private Handler f6935B = new HandlerC1897z(this);

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_image_pager_item, viewGroup, false);
        this.f6957w = (FrameLayout) viewInflate.findViewById(R.id.layout_image);
        this.f6948n = (ImageView) viewInflate.findViewById(R.id.pager_image);
        this.f6936a = (ProgressBar) viewInflate.findViewById(R.id.download_progress);
        this.f6949o = (ImageButton) viewInflate.findViewById(R.id.play_button);
        if (m7630e() != null && m7630e().m7613c().containsKey(Integer.valueOf(this.f6946l))) {
            C1891t c1891t = m7630e().m7611b().get(m7630e().m7613c().get(Integer.valueOf(this.f6946l)));
            if (c1891t != null) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("[Item]" + c1891t.toString(), f6933f);
                }
                this.f6952r = c1891t.f7178e;
                this.f6953s = c1891t.f7179f;
                this.f6937b = c1891t.f7175b;
                this.f6938c = c1891t.f7177d;
                this.f6939d = c1891t.f7174a;
            }
        } else if (bundle != null) {
            this.f6952r = bundle.getString("downloadUri");
            this.f6953s = EnumC1455w.m6358a(bundle.getInt("msgType"));
            this.f6937b = bundle.getLong("messageId");
            this.f6938c = bundle.getString("content");
            this.f6939d = bundle.getString(Config.NOTIFICATION_INTENT_SENDER);
            if (C3250y.f11734b) {
                StringBuilder sb = new StringBuilder();
                sb.append("messageId: " + this.f6937b);
                sb.append(", mediaType: " + this.f6953s);
                sb.append(", sender: " + this.f6939d);
                sb.append(", content: " + this.f6938c);
                sb.append(", downloadUri: " + this.f6952r);
                sb.append("\n");
                C3250y.m11450b("[restore from onSaveInstanceState]" + sb.toString(), f6933f);
            }
        }
        if (m7630e() != null) {
            m7630e().m7610a(this.f6937b, this);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (C3250y.f11734b) {
            StringBuilder sb = new StringBuilder();
            sb.append("messageId: " + this.f6937b);
            sb.append(", mediaType: " + this.f6953s);
            sb.append(", sender: " + this.f6939d);
            sb.append(", content: " + this.f6938c);
            sb.append(", downloadUri: " + this.f6952r);
            sb.append("\n");
            C3250y.m11450b("[onSaveInstanceState]" + sb.toString(), f6933f);
        }
        bundle.putString("downloadUri", this.f6952r);
        bundle.putInt("msgType", this.f6953s.m6364a());
        bundle.putLong("messageId", this.f6937b);
        bundle.putString("content", this.f6938c);
        bundle.putString(Config.NOTIFICATION_INTENT_SENDER, this.f6939d);
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: a */
    protected void mo6864a() {
        if (!C1555a.m6596a().m6599a(this.f6937b, false) && m7630e() != null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("downloadImage : " + this.f6937b, f6933f);
            }
            C1555a.m6596a().m6597a(null, null, m7630e().m7616f(), 0, this.f6938c, false, m7630e().m7614d(), this.f6937b, this.f6953s, EnumC1450r.ONETOONE, this.f6939d);
        }
    }

    /* renamed from: a */
    public void m7628a(String str) {
        this.f6936a.setVisibility(4);
        if (!TextUtils.isEmpty(str) && !C0816a.f3113b.equals(str)) {
            if (!m7622b(str)) {
                m7621b();
            }
            String str2 = (this.f6952r == null || !this.f6952r.contains("thumbnail")) ? null : this.f6952r;
            this.f6952r = str;
            if (this.f6952r.startsWith("file:")) {
                this.f6952r = Uri.parse(this.f6952r).getPath();
            }
            if (this.f6953s == EnumC1455w.AMS || C3025f.m10540b(this.f6952r)) {
                this.f6949o.setBackgroundResource(R.drawable.chat_btn_ams_play);
                this.f6949o.setVisibility(0);
                this.f6955u = true;
            } else if (m7630e() != null) {
                m7630e().m7608a(this.f6946l, true);
            }
            if (m7630e() != null) {
                m7630e().m7612b(this.f6946l, true);
            }
            if (m7630e() != null) {
                this.f6960z = new C1851ab(this.f6937b + this.f6952r, this.f6952r, this.f6953s, str2, m7630e().m7616f(), this.f6948n);
            }
            if (m7622b(this.f6952r) && this.f6959y == null) {
                this.f6959y = new AsyncTaskC1873b(this.f6952r, this.f6957w, this.f6948n, this.f6935B);
                if (Build.VERSION.SDK_INT < 11) {
                    this.f6959y.execute(new String[0]);
                } else {
                    this.f6959y.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                }
            } else if (m7630e() != null && this.f6958x != null) {
                this.f6958x.setVisibility(0);
                m7630e().m7615e().m11730a(this.f6958x, this.f6960z);
            }
            this.f6949o.bringToFront();
            if (this.f6958x != null) {
                if (this.f6953s == EnumC1455w.VIDEO || this.f6955u) {
                    this.f6958x.setOnTouchListener(null);
                } else {
                    this.f6958x.setOnTouchListener(this.f6947m);
                }
                ViewTreeObserver viewTreeObserver = this.f6958x.getViewTreeObserver();
                this.f6951q = new ViewTreeObserverOnGlobalLayoutListenerC1893v(this);
                viewTreeObserver.addOnGlobalLayoutListener(this.f6951q);
            }
        }
    }

    /* renamed from: c */
    protected void mo6866c() {
        if (!C1555a.m6596a().m6598a(this.f6937b)) {
            if (!C3223ck.m11331e()) {
                AbstractC3271a.m11494a(m7630e()).mo11495a(R.string.pop_up_attention).mo11506b(R.string.popup_not_enough_memory).mo11515d(R.string.dialog_ok, null).mo11512b();
                return;
            }
            if (this.f6954t == null) {
                this.f6954t = new AlertDialogC3256c(m7630e());
                this.f6954t.setTitle(R.string.download_title);
                this.f6954t.setMessage(getString(R.string.anicon_file_downloading));
                this.f6954t.setCancelable(false);
            }
            this.f6954t.setButton(-2, getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1894w(this));
            if (m7630e() != null) {
                C1555a.m6596a().m6597a(null, null, m7630e().m7616f(), 0, this.f6938c, false, m7630e().m7614d(), this.f6937b, this.f6953s, EnumC1450r.ONETOONE, this.f6939d);
                this.f6954t.show();
                this.f6954t.m11483a(0);
                AsyncTaskC1557c asyncTaskC1557cM6601b = C1555a.m6596a().m6601b(this.f6937b);
                if (asyncTaskC1557cM6601b != null) {
                    asyncTaskC1557cM6601b.m6610a(this.f6954t);
                    asyncTaskC1557cM6601b.m6608a(m7630e().m7616f());
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f6946l = getArguments() != null ? getArguments().getInt("position") : 0;
        this.f6947m = new C1850aa(this, this);
        super.onCreate(bundle);
    }

    /* renamed from: d */
    public C1850aa m7629d() {
        return this.f6947m;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        if (this.f6948n != null && (viewTreeObserver2 = this.f6948n.getViewTreeObserver()) != null) {
            viewTreeObserver2.removeGlobalOnLayoutListener(this.f6950p);
        }
        if (this.f6958x != null && (viewTreeObserver = this.f6958x.getViewTreeObserver()) != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f6951q);
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        this.f6936a.setVisibility(4);
        if ((this.f6953s == EnumC1455w.IMAGE || this.f6953s == EnumC1455w.AMS) && (TextUtils.isEmpty(this.f6952r) || C0816a.f3113b.equals(this.f6952r) || this.f6952r.contains("thumbnail"))) {
            mo6864a();
        }
        AsyncTaskC1557c asyncTaskC1557cM6601b = C1555a.m6596a().m6601b(this.f6937b);
        if (asyncTaskC1557cM6601b != null && !asyncTaskC1557cM6601b.m6613a()) {
            if (C3250y.f11734b) {
                C3250y.m11450b("setImageHander : " + this.f6937b, f6933f);
            }
            if (m7630e() != null) {
                m7630e().m7608a(this.f6946l, false);
                m7630e().m7612b(this.f6946l, false);
                asyncTaskC1557cM6601b.m6608a(m7630e().m7616f());
            }
            if (this.f6953s == EnumC1455w.IMAGE || this.f6953s == EnumC1455w.AMS) {
                this.f6936a.setVisibility(0);
            }
        }
        this.f6949o.setOnClickListener(this.f6940e);
        if (this.f6952r != null && this.f6952r.startsWith("file:")) {
            this.f6952r = this.f6952r.substring(6);
        }
        if (this.f6953s == EnumC1455w.IMAGE || this.f6953s == EnumC1455w.AMS) {
            this.f6955u = C3025f.m10540b(this.f6952r);
        }
        if (m7630e() != null) {
            this.f6960z = new C1851ab(this.f6937b + this.f6952r, this.f6952r, this.f6953s, null, m7630e().m7616f(), null);
            if (m7622b(this.f6952r) && this.f6959y == null) {
                this.f6959y = new AsyncTaskC1873b(this.f6952r, this.f6957w, this.f6948n, this.f6935B);
                if (Build.VERSION.SDK_INT < 11) {
                    this.f6959y.execute(new String[0]);
                } else {
                    this.f6959y.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                }
            } else {
                m7630e().m7615e().m11730a(this.f6948n, this.f6960z);
            }
        }
        if (this.f6953s == EnumC1455w.VIDEO || this.f6955u) {
            if (this.f6955u) {
                this.f6949o.setBackgroundResource(R.drawable.chat_btn_ams_play);
            }
            this.f6949o.setVisibility(0);
            this.f6948n.setOnTouchListener(null);
        } else {
            this.f6948n.setOnTouchListener(this.f6947m);
        }
        if (this.f6948n != null) {
            ViewTreeObserver viewTreeObserver = this.f6948n.getViewTreeObserver();
            this.f6950p = new ViewTreeObserverOnGlobalLayoutListenerC1895x(this);
            viewTreeObserver.addOnGlobalLayoutListener(this.f6950p);
        }
        if (this.f6948n != null) {
            this.f6948n.setOnClickListener(this.f6934A);
        }
        super.onResume();
    }

    /* renamed from: b */
    private boolean m7622b(String str) {
        return C3347i.m11781d() && str != null && !str.contains("thumbnail") && str.toLowerCase().endsWith("gif") && Build.VERSION.SDK_INT >= 14;
    }

    /* renamed from: b */
    private void m7621b() {
        this.f6958x = new ImageView(m7630e());
        this.f6958x.setAdjustViewBounds(true);
        this.f6958x.setVisibility(8);
        this.f6957w.addView(this.f6958x, new ViewGroup.LayoutParams(-1, -1));
        this.f6958x.setOnClickListener(this.f6934A);
    }

    /* renamed from: e */
    protected ImagePagerActivity m7630e() {
        return (ImagePagerActivity) this.f6956v;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f6956v = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f6956v = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f6948n.setImageBitmap(null);
        if (m7630e() != null) {
            m7630e().m7615e().m11732a(this.f6948n);
            m7630e().m7609a(this.f6937b);
            if (this.f6958x != null) {
                this.f6958x.setImageBitmap(null);
                m7630e().m7615e().m11732a(this.f6958x);
            }
        }
        if (this.f6959y != null) {
            this.f6959y.m7709a();
        }
        super.onDestroyView();
    }

    @Override // com.sec.chaton.multimedia.image.InterfaceC1869at
    /* renamed from: f */
    public void mo7631f() {
        if (m7630e() != null && m7629d().m7705a()) {
            m7630e().m7618h();
        }
    }
}
