package com.sec.chaton.multimedia.emoticon;

import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.anicon.AniconContainer;
import com.sec.chaton.multimedia.emoticon.anicon.C0921d;
import com.sec.chaton.multimedia.emoticon.anicon.InterfaceC0920c;
import com.sec.chaton.multimedia.emoticon.p032b.C0952g;
import com.sec.chaton.util.C1786r;
import com.sec.common.p055a.C1811a;
import com.sec.common.p056b.p060d.C1828c;
import com.sec.common.widget.PagerPositionStrip2;

/* loaded from: classes.dex */
public class EmoticonSelectionView extends FrameLayout implements View.OnClickListener, InterfaceC0920c, InterfaceC0960f {

    /* renamed from: a */
    private static final String f3354a = EmoticonSelectionView.class.getSimpleName();

    /* renamed from: b */
    private Context f3355b;

    /* renamed from: c */
    private boolean f3356c;

    /* renamed from: d */
    private String f3357d;

    /* renamed from: e */
    private FrameLayout f3358e;

    /* renamed from: f */
    private FrameLayout f3359f;

    /* renamed from: g */
    private View f3360g;

    /* renamed from: h */
    private Button f3361h;

    /* renamed from: i */
    private View f3362i;

    /* renamed from: j */
    private PagerPositionStrip2 f3363j;

    /* renamed from: k */
    private ViewPager f3364k;

    /* renamed from: l */
    private View f3365l;

    /* renamed from: m */
    private ImageView f3366m;

    /* renamed from: n */
    private Button f3367n;

    /* renamed from: o */
    private Button f3368o;

    /* renamed from: p */
    private PagerAdapter f3369p;

    /* renamed from: q */
    private PagerAdapter f3370q;

    /* renamed from: r */
    private Cursor f3371r;

    /* renamed from: s */
    private LinearLayout.LayoutParams f3372s;

    /* renamed from: t */
    private LinearLayout.LayoutParams f3373t;

    /* renamed from: u */
    private InterfaceC0967m f3374u;

    public EmoticonSelectionView(Context context) {
        super(context);
        this.f3355b = context;
        m3661b();
    }

    public EmoticonSelectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3355b = context;
        m3661b();
    }

    public EmoticonSelectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3355b = context;
        m3661b();
    }

    public void setEmoticonSelectedListener(InterfaceC0967m interfaceC0967m) {
        this.f3374u = interfaceC0967m;
    }

    /* renamed from: b */
    private void m3661b() {
        if (C1786r.f6452b) {
            C1786r.m6061b("EmoticonSelectionView.initialize()", f3354a);
        }
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.layout_emoticon_selection_view, (ViewGroup) this, true);
        viewInflate.findViewById(R.id.EmoticonView);
        this.f3358e = (FrameLayout) viewInflate.findViewById(R.id.emoticonButton);
        this.f3359f = (FrameLayout) viewInflate.findViewById(R.id.ticonButton);
        this.f3360g = viewInflate.findViewById(R.id.closeButton);
        this.f3361h = (Button) viewInflate.findViewById(R.id.viewMore);
        this.f3362i = viewInflate.findViewById(R.id.pagerLayout);
        this.f3363j = (PagerPositionStrip2) viewInflate.findViewById(R.id.emoticonPositionStrip);
        this.f3364k = (ViewPager) viewInflate.findViewById(R.id.emoticonViewPager);
        this.f3365l = viewInflate.findViewById(R.id.previewLayout);
        this.f3366m = (ImageView) viewInflate.findViewById(android.R.id.icon);
        this.f3367n = (Button) viewInflate.findViewById(android.R.id.button1);
        this.f3368o = (Button) viewInflate.findViewById(android.R.id.button2);
        this.f3358e.setOnClickListener(this);
        this.f3359f.setOnClickListener(this);
        this.f3367n.setOnClickListener(this);
        this.f3368o.setOnClickListener(this);
        this.f3360g.setOnClickListener(this);
        this.f3361h.setOnClickListener(this);
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 2) {
            this.f3373t = new LinearLayout.LayoutParams(268, 50);
            this.f3359f.setLayoutParams(this.f3373t);
            this.f3358e.setLayoutParams(this.f3373t);
        } else if (configuration.orientation == 1) {
            this.f3373t = new LinearLayout.LayoutParams(100, 50);
            this.f3359f.setLayoutParams(this.f3373t);
            this.f3358e.setLayoutParams(this.f3373t);
        }
        this.f3356c = true;
        m3659a("emoticon");
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m3265f()) {
            if (configuration.orientation == 2) {
                if (this.f3364k.getHeight() != 236) {
                    this.f3372s = new LinearLayout.LayoutParams(-1, 489);
                    this.f3364k.setLayoutParams(this.f3372s);
                }
                this.f3373t = new LinearLayout.LayoutParams(268, 50);
                this.f3359f.setLayoutParams(this.f3373t);
                this.f3358e.setLayoutParams(this.f3373t);
                return;
            }
            if (configuration.orientation == 1) {
                if (this.f3364k.getHeight() != 236) {
                    this.f3372s = new LinearLayout.LayoutParams(-1, 969);
                    this.f3364k.setLayoutParams(this.f3372s);
                }
                this.f3373t = new LinearLayout.LayoutParams(100, 50);
                this.f3359f.setLayoutParams(this.f3373t);
                this.f3358e.setLayoutParams(this.f3373t);
            }
        }
    }

    /* renamed from: a */
    private void m3659a(String str) {
        PagerAdapter pagerAdapter;
        ViewPager viewPager = null;
        if (TextUtils.isEmpty(this.f3357d) || !this.f3357d.equals(str)) {
            if ("emoticon".equals(str)) {
                this.f3357d = "emoticon";
                this.f3359f.setSelected(false);
                this.f3358e.setSelected(true);
                if (this.f3369p == null) {
                    this.f3369p = new C0966l(this, m3663c().getSupportFragmentManager());
                }
                viewPager = this.f3364k;
                pagerAdapter = this.f3369p;
            } else if ("anicon".equals(str)) {
                this.f3357d = "anicon";
                this.f3358e.setSelected(false);
                this.f3359f.setSelected(true);
                if (this.f3370q == null) {
                    this.f3371r = m3664d();
                    this.f3370q = new C0963i(this, m3663c().getSupportFragmentManager(), this.f3371r);
                }
                viewPager = this.f3364k;
                pagerAdapter = this.f3370q;
            } else {
                pagerAdapter = null;
            }
            this.f3363j.setVisibility(0);
            this.f3362i.setVisibility(0);
            this.f3365l.setVisibility(8);
            viewPager.setAdapter(pagerAdapter);
            viewPager.setCurrentItem(1, false);
            this.f3363j.setViewPager(viewPager);
        }
    }

    /* renamed from: c */
    private FragmentActivity m3663c() {
        return (FragmentActivity) getContext();
    }

    /* renamed from: d */
    private Cursor m3664d() {
        return getContext().getContentResolver().query(C0952g.f3515a.buildUpon().appendPath("install").build(), null, null, null, "install");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3665e();
        if (this.f3371r != null) {
            this.f3371r.close();
        }
        this.f3369p = null;
        this.f3370q = null;
        this.f3371r = null;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.f3356c) {
            if (i == 4 || i == 8) {
                m3665e();
                this.f3362i.setVisibility(0);
                this.f3365l.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f3358e) {
            m3659a("emoticon");
            return;
        }
        if (view == this.f3359f) {
            m3659a("anicon");
            return;
        }
        if (view == this.f3367n) {
            this.f3362i.setVisibility(0);
            this.f3365l.setVisibility(8);
            m3665e();
            if (this.f3374u != null) {
                this.f3374u.mo2604b((String) this.f3366m.getTag());
                return;
            }
            return;
        }
        if (view == this.f3368o) {
            this.f3362i.setVisibility(0);
            this.f3365l.setVisibility(8);
            m3665e();
            return;
        }
        if (view == this.f3360g) {
            if (this.f3374u != null) {
                this.f3374u.mo2610h();
                return;
            }
            return;
        }
        if (view == this.f3361h) {
            Log.d("anicon", "" + this.f3362i.getHeight());
            if (this.f3364k.getHeight() == 236) {
                Configuration configuration = getResources().getConfiguration();
                if (configuration.orientation == 2) {
                    this.f3372s = new LinearLayout.LayoutParams(-1, 489);
                } else if (configuration.orientation == 1) {
                    this.f3372s = new LinearLayout.LayoutParams(-1, 969);
                }
                this.f3364k.setLayoutParams(this.f3372s);
                this.f3361h.setBackgroundDrawable(getResources().getDrawable(R.drawable.chat_emoticon_arrow_up));
                return;
            }
            if (this.f3364k.getHeight() == 489 || this.f3364k.getHeight() == 969) {
                this.f3364k.setLayoutParams(new LinearLayout.LayoutParams(-1, 236));
                this.f3361h.setBackgroundDrawable(getResources().getDrawable(R.drawable.chat_emoticon_arrow_down));
            }
        }
    }

    @Override // com.sec.chaton.multimedia.emoticon.InterfaceC0960f
    /* renamed from: a */
    public void mo3667a(EmoticonContainer emoticonContainer, String str) {
        if (C1786r.f6452b) {
            C1786r.m6061b(C1828c.m6207a("onEmoticonClicked() ", emoticonContainer, ", " + str), f3354a);
        }
        if (this.f3374u != null) {
            this.f3374u.mo2599a(str);
        }
    }

    @Override // com.sec.chaton.multimedia.emoticon.anicon.InterfaceC0920c
    /* renamed from: a */
    public void mo3668a(AniconContainer aniconContainer, String str) {
        if (C1786r.f6452b) {
            C1786r.m6061b(C1828c.m6207a("onAniconClicked() ", aniconContainer, ", ", str), f3354a);
        }
        this.f3362i.setVisibility(8);
        this.f3365l.setVisibility(0);
        this.f3366m.setTag(str);
        m3662b(str);
    }

    /* renamed from: b */
    private void m3662b(String str) {
        if (m3666f()) {
            m3665e();
        }
        AnimationDrawable animationDrawableM3791b = C0921d.m3791b(getContext(), str);
        if (animationDrawableM3791b != null) {
            this.f3366m.setImageDrawable(animationDrawableM3791b);
            animationDrawableM3791b.start();
        }
    }

    /* renamed from: e */
    private void m3665e() {
        Drawable drawable;
        if (m3666f() && (drawable = this.f3366m.getDrawable()) != null) {
            this.f3366m.setImageBitmap(null);
            drawable.setCallback(null);
            if (drawable instanceof AnimationDrawable) {
                C1811a.m6145a(drawable);
            }
        }
    }

    /* renamed from: f */
    private boolean m3666f() {
        return this.f3366m.getDrawable() instanceof AnimationDrawable;
    }
}
