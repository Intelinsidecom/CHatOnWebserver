package com.sec.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.sec.chaton.C0432aj;
import com.sec.chaton.R;
import java.lang.Character;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TwIndexScrollView extends FrameLayout implements AbsListView.OnScrollListener {

    /* renamed from: b */
    public static boolean f13422b = false;

    /* renamed from: l */
    private static int f13423l;

    /* renamed from: m */
    private static int f13424m;

    /* renamed from: A */
    private InterfaceC3668bi f13425A;

    /* renamed from: B */
    private float f13426B;

    /* renamed from: C */
    private boolean f13427C;

    /* renamed from: D */
    private boolean f13428D;

    /* renamed from: E */
    private boolean f13429E;

    /* renamed from: F */
    private Animation f13430F;

    /* renamed from: G */
    private Animation f13431G;

    /* renamed from: H */
    private boolean f13432H;

    /* renamed from: I */
    private Runnable f13433I;

    /* renamed from: J */
    private int f13434J;

    /* renamed from: K */
    private final long f13435K;

    /* renamed from: L */
    private final long f13436L;

    /* renamed from: M */
    private boolean f13437M;

    /* renamed from: N */
    private int f13438N;

    /* renamed from: a */
    int f13439a;

    /* renamed from: c */
    private final boolean f13440c;

    /* renamed from: d */
    private float f13441d;

    /* renamed from: e */
    private boolean f13442e;

    /* renamed from: f */
    private boolean f13443f;

    /* renamed from: g */
    private boolean f13444g;

    /* renamed from: h */
    private Rect f13445h;

    /* renamed from: i */
    private Paint f13446i;

    /* renamed from: j */
    private int f13447j;

    /* renamed from: k */
    private Drawable f13448k;

    /* renamed from: n */
    private int f13449n;

    /* renamed from: o */
    private int f13450o;

    /* renamed from: p */
    private int f13451p;

    /* renamed from: q */
    private int f13452q;

    /* renamed from: r */
    private int f13453r;

    /* renamed from: s */
    private int f13454s;

    /* renamed from: t */
    private int f13455t;

    /* renamed from: u */
    private ArrayList<C3667bh> f13456u;

    /* renamed from: v */
    private int f13457v;

    /* renamed from: w */
    private AbstractC3657ay f13458w;

    /* renamed from: x */
    private final C3665bf f13459x;

    /* renamed from: y */
    private String[] f13460y;

    /* renamed from: z */
    private C3664be f13461z;

    public void setmIsFavoriteContactMode(boolean z) {
        this.f13444g = z;
    }

    public TwIndexScrollView(Context context) {
        super(context);
        this.f13440c = true;
        this.f13442e = false;
        this.f13439a = 0;
        this.f13443f = false;
        this.f13444g = false;
        this.f13445h = null;
        this.f13446i = null;
        this.f13448k = null;
        this.f13455t = 1;
        this.f13459x = new C3665bf(this);
        this.f13460y = null;
        this.f13461z = null;
        this.f13425A = null;
        this.f13427C = false;
        this.f13428D = false;
        this.f13429E = false;
        this.f13430F = null;
        this.f13431G = null;
        this.f13432H = true;
        this.f13433I = null;
        this.f13434J = -1;
        this.f13435K = 500L;
        this.f13436L = 350L;
        this.f13437M = false;
        this.f13438N = 0;
        this.f13453r = (int) getResources().getDimension(R.dimen.tw_indexview_first_handle_textgap);
        m13137a(context);
    }

    public TwIndexScrollView(Context context, int i) {
        super(context);
        this.f13440c = true;
        this.f13442e = false;
        this.f13439a = 0;
        this.f13443f = false;
        this.f13444g = false;
        this.f13445h = null;
        this.f13446i = null;
        this.f13448k = null;
        this.f13455t = 1;
        this.f13459x = new C3665bf(this);
        this.f13460y = null;
        this.f13461z = null;
        this.f13425A = null;
        this.f13427C = false;
        this.f13428D = false;
        this.f13429E = false;
        this.f13430F = null;
        this.f13431G = null;
        this.f13432H = true;
        this.f13433I = null;
        this.f13434J = -1;
        this.f13435K = 500L;
        this.f13436L = 350L;
        this.f13437M = false;
        this.f13438N = 0;
        this.f13453r = i;
        m13137a(context);
    }

    public TwIndexScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13440c = true;
        this.f13442e = false;
        this.f13439a = 0;
        this.f13443f = false;
        this.f13444g = false;
        this.f13445h = null;
        this.f13446i = null;
        this.f13448k = null;
        this.f13455t = 1;
        this.f13459x = new C3665bf(this);
        this.f13460y = null;
        this.f13461z = null;
        this.f13425A = null;
        this.f13427C = false;
        this.f13428D = false;
        this.f13429E = false;
        this.f13430F = null;
        this.f13431G = null;
        this.f13432H = true;
        this.f13433I = null;
        this.f13434J = -1;
        this.f13435K = 500L;
        this.f13436L = 350L;
        this.f13437M = false;
        this.f13438N = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0432aj.TwIndexView);
        int i = typedArrayObtainStyledAttributes.getInt(0, 1);
        typedArrayObtainStyledAttributes.recycle();
        this.f13455t = i;
        this.f13453r = typedArrayObtainStyledAttributes.getInt(1, (int) getResources().getDimension(R.dimen.tw_indexview_first_handle_textgap));
        m13137a(context);
    }

    public TwIndexScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13440c = true;
        this.f13442e = false;
        this.f13439a = 0;
        this.f13443f = false;
        this.f13444g = false;
        this.f13445h = null;
        this.f13446i = null;
        this.f13448k = null;
        this.f13455t = 1;
        this.f13459x = new C3665bf(this);
        this.f13460y = null;
        this.f13461z = null;
        this.f13425A = null;
        this.f13427C = false;
        this.f13428D = false;
        this.f13429E = false;
        this.f13430F = null;
        this.f13431G = null;
        this.f13432H = true;
        this.f13433I = null;
        this.f13434J = -1;
        this.f13435K = 500L;
        this.f13436L = 350L;
        this.f13437M = false;
        this.f13438N = 0;
        this.f13453r = (int) getResources().getDimension(R.dimen.tw_indexview_first_handle_textgap);
        m13137a(context);
    }

    /* renamed from: a */
    private void m13137a(Context context) {
        Resources resources = getResources();
        setFocusable(false);
        bringToFront();
        setHapticFeedbackEnabled(false);
        setSoundEffectsEnabled(false);
        if (this.f13461z == null) {
            this.f13461z = new C3664be(this, getContext());
            this.f13461z.setVisibility(4);
        } else {
            removeView(this.f13461z);
        }
        addView(this.f13461z, new FrameLayout.LayoutParams(-1, -1));
        this.f13450o = (int) resources.getDimension(R.dimen.tw_indexview_first_handle_width);
        this.f13451p = (int) resources.getDimension(R.dimen.tw_indexview_second_handle_width);
        this.f13452q = (int) resources.getDimension(R.dimen.tw_indexview_second_handle_gap);
        this.f13447j = (int) resources.getDimension(R.dimen.tw_indexview_characters_width);
        this.f13454s = (int) resources.getDimension(R.dimen.tw_indexview_first_handle_toppading);
        f13423l = resources.getColor(R.color.fastscroll_index_color);
        f13424m = resources.getColor(R.color.fastscroll_sub_rectangular_orange_color);
        this.f13449n = (int) resources.getDimension(R.dimen.tw_indexview_first_handle_textsize);
        this.f13446i = new Paint();
        this.f13446i.setColor(f13423l);
        this.f13446i.setTextSize(this.f13449n);
        this.f13446i.setAntiAlias(true);
        this.f13446i.setTextAlign(Paint.Align.CENTER);
        this.f13446i.setTypeface(Typeface.DEFAULT);
        this.f13448k = resources.getDrawable(R.drawable.tw_scrollbar_handle_top_bg_default_holo_dark);
        this.f13456u = new ArrayList<>();
        this.f13430F = AnimationUtils.loadAnimation(context, R.anim.tw_indexscrollview_fade_in);
        this.f13431G = AnimationUtils.loadAnimation(context, R.anim.tw_indexscrollview_fade_out);
        this.f13430F.setInterpolator(new LinearInterpolator());
        this.f13431G.setInterpolator(new LinearInterpolator());
        this.f13430F.setDuration(500L);
        this.f13431G.setDuration(500L);
        this.f13431G.setFillEnabled(true);
        this.f13431G.setFillAfter(true);
        this.f13430F.setAnimationListener(new AnimationAnimationListenerC3661bb(this));
        this.f13431G.setAnimationListener(new AnimationAnimationListenerC3662bc(this));
        this.f13433I = new RunnableC3663bd(this);
    }

    public void setIndexer(AbstractC3657ay abstractC3657ay) {
        if (abstractC3657ay == null) {
            throw new IllegalArgumentException("TwIndexView.setIndexer(indexer) : indexer=null.");
        }
        if (this.f13429E) {
            throw new UnsupportedOperationException("TwIndexView.setIndexer(indexer) :  you are not allowed to set the indexer if you already use indexScroll view under Simple scroll mode !!!");
        }
        if (this.f13458w != null) {
            this.f13458w.m13232b(this.f13459x);
        }
        this.f13458w = abstractC3657ay;
        this.f13460y = this.f13458w.m13230a();
        this.f13458w.m13229a(this.f13459x);
        m13140a(true);
    }

    public void setSimpleIndexHandleChar(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("TwIndexView.setIndexHandleChar(handleChar) ");
        }
        if (this.f13458w != null) {
            throw new UnsupportedOperationException("TwIndexView.setSimpleIndexHandleChar(String [] handleChar) :  you must not set the indexer to use simple index handle mode !!!");
        }
        this.f13429E = true;
        this.f13460y = strArr;
        m13140a(true);
    }

    public void setSimpleIndexHandleCharForContact(String[] strArr) {
        this.f13437M = true;
        setSimpleIndexHandleChar(strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13140a(boolean z) {
        int size = this.f13456u.size();
        if (z || size < 1) {
            this.f13456u.clear();
            Rect rectM13136a = m13136a(0);
            if (rectM13136a != null) {
                m13143a("", rectM13136a.top);
                return;
            }
            return;
        }
        while (m13148c() > 1) {
            m13145b();
        }
    }

    /* renamed from: a */
    private boolean m13143a(String str, int i) {
        ArrayList<C3658az> arrayListM13228a;
        Rect rectM13136a;
        for (int i2 = 0; i2 < str.length(); i2++) {
            Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(str.charAt(i2));
            if (Character.UnicodeBlock.HANGUL_SYLLABLES.equals(unicodeBlockOf) || Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO.equals(unicodeBlockOf) || Character.UnicodeBlock.HANGUL_JAMO.equals(unicodeBlockOf)) {
                return false;
            }
        }
        if (this.f13443f && this.f13456u.size() > 0) {
            C3667bh c3667bh = this.f13456u.get(this.f13456u.size() - 1);
            int iM13253c = c3667bh.m13253c();
            int iM13247a = c3667bh.m13247a();
            if (iM13253c % iM13247a == iM13247a && iM13253c != c3667bh.m13252b().size() - 1) {
                return false;
            }
        }
        int size = this.f13456u.size();
        if (this.f13457v > 0 && size >= this.f13457v) {
            return false;
        }
        if (this.f13429E) {
            arrayListM13228a = new ArrayList<>();
            for (int i3 = 0; i3 < this.f13460y.length; i3++) {
                C3658az c3658az = new C3658az();
                c3658az.f13549b = true;
                c3658az.f13550c = i3;
                c3658az.f13548a = this.f13460y[i3];
                arrayListM13228a.add(c3658az);
            }
        } else {
            arrayListM13228a = this.f13458w.m13228a(str, size != 0);
        }
        if (arrayListM13228a == null || arrayListM13228a.size() == 0 || (rectM13136a = m13136a(size)) == null) {
            return false;
        }
        this.f13456u.add(new C3667bh(this, str, arrayListM13228a, i, this.f13453r, rectM13136a, size));
        return true;
    }

    /* renamed from: b */
    private void m13145b() {
        int size = this.f13456u.size();
        if (size > 1) {
            this.f13456u.remove(size - 1);
        }
    }

    /* renamed from: c */
    private int m13148c() {
        return this.f13456u.size();
    }

    /* renamed from: d */
    private C3667bh m13151d() {
        int size = this.f13456u.size();
        if (size > 0) {
            return this.f13456u.get(size - 1);
        }
        return null;
    }

    public void setSubscrollLimit(int i) {
        if (i > 1) {
            this.f13457v = i;
        }
    }

    public void setHandlePosition(int i) {
        this.f13455t = i;
        m13153e();
        m13140a(true);
        invalidate();
    }

    /* renamed from: e */
    private void m13153e() {
        this.f13445h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Rect m13136a(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int height = getHeight();
        int width = getWidth();
        if (height == 0) {
            height = displayMetrics.heightPixels;
        }
        if (width == 0) {
            width = displayMetrics.widthPixels;
        }
        if (i == 0) {
            if (this.f13460y == null) {
                return null;
            }
            int length = (this.f13453r * this.f13460y.length) + (this.f13454s * 2);
            if (this.f13429E && !this.f13437M) {
                this.f13450o = (int) resources.getDimension(R.dimen.tw_indexview_first_handle_width_clock);
            }
            int dimension = (int) resources.getDimension(R.dimen.tw_indexview_first_handle_top_margin);
            int i6 = dimension + length;
            if (height == 0 || i6 <= height) {
                height = i6;
            }
            if (this.f13455t == 1) {
                int i7 = width;
                i5 = width - this.f13450o;
                i4 = i7;
            } else {
                i4 = this.f13450o;
                i5 = 0;
            }
            this.f13445h = new Rect(i5, dimension, i4, height);
            return this.f13445h;
        }
        int i8 = this.f13452q + this.f13451p;
        if (this.f13455t == 1) {
            i3 = (this.f13445h.left - this.f13452q) - (i8 * (i - 1));
            i2 = i3 - this.f13451p;
        } else {
            i2 = this.f13445h.right + this.f13452q + (i8 * (i - 1));
            i3 = this.f13451p + i2;
        }
        return new Rect(i2, this.f13445h.top, i3, this.f13445h.bottom);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        this.f13441d = y;
        float x = motionEvent.getX();
        C3667bh c3667bhM13151d = m13151d();
        switch (action) {
            case 0:
                if (c3667bhM13151d != null && !this.f13428D && this.f13456u.size() > 0 && this.f13456u.get(0).m13258g().contains((int) x, (int) y)) {
                    this.f13428D = true;
                    this.f13427C = false;
                    this.f13426B = x;
                    c3667bhM13151d.m13245b(y);
                    m13139a(c3667bhM13151d.m13257f());
                    if (this.f13431G.hasStarted() && !this.f13431G.hasEnded()) {
                        m13161i();
                    } else if (this.f13432H) {
                        m13154f();
                    }
                    m13157g();
                    break;
                } else {
                    return false;
                }
                break;
            case 1:
            case 3:
                if (this.f13428D) {
                    m13154f();
                    this.f13428D = false;
                    m13140a(false);
                    this.f13461z.setVisibility(4);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (c3667bhM13151d != null && this.f13428D) {
                    int iM13148c = m13148c() - 1;
                    float fAbs = Math.abs(x - this.f13426B);
                    float f = ((this.f13452q + this.f13451p) * (iM13148c + 1.0f)) - (0.5f * this.f13451p);
                    float f2 = ((this.f13452q + this.f13451p) * iM13148c) - this.f13452q;
                    if (fAbs >= f && iM13148c < this.f13457v - 1) {
                        if (!this.f13427C) {
                            if (m13143a(c3667bhM13151d.m13257f(), (int) c3667bhM13151d.f13577l)) {
                                this.f13427C = false;
                                m13151d().m13250a(y);
                                f13422b = true;
                                invalidate();
                                break;
                            } else {
                                this.f13427C = true;
                                break;
                            }
                        }
                    } else if (fAbs < f2) {
                        this.f13427C = false;
                        m13145b();
                        C3667bh c3667bhM13151d2 = m13151d();
                        if (c3667bhM13151d2 != null) {
                            c3667bhM13151d2.m13250a(y);
                            m13139a(c3667bhM13151d2.m13257f());
                        }
                        m13154f();
                        break;
                    } else {
                        this.f13427C = false;
                        if (c3667bhM13151d.m13250a(y)) {
                            m13139a(c3667bhM13151d.m13257f());
                            m13154f();
                            invalidate();
                            break;
                        }
                    }
                }
                break;
        }
        return true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f13428D) {
            this.f13428D = false;
            while (m13148c() > 1) {
                m13145b();
            }
        }
        C3667bh c3667bhM13151d = m13151d();
        if (c3667bhM13151d != null) {
            c3667bhM13151d.m13254c(i2);
        }
        this.f13461z.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13139a(String str) {
        this.f13461z.m13240a(str);
        if (this.f13461z.getVisibility() != 0) {
            this.f13461z.setVisibility(0);
        } else {
            this.f13461z.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m13154f() {
        C3667bh c3667bhM13151d;
        int i = 0;
        if (this.f13425A != null && this.f13459x.m13242a() && (c3667bhM13151d = m13151d()) != null) {
            if (c3667bhM13151d.m13255d() != null) {
                if (this.f13444g && this.f13456u.size() == 1 && !Character.isLetter(this.f13460y[m13151d().m13253c()].charAt(0))) {
                    i = -c3667bhM13151d.m13255d().f13550c;
                } else {
                    i = c3667bhM13151d.m13255d().f13550c;
                }
            }
            this.f13425A.m13259a(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) throws Resources.NotFoundException {
        super.dispatchDraw(canvas);
        if (!this.f13442e) {
            int i = 0;
            while (i < this.f13456u.size()) {
                this.f13456u.get(i).m13249a(canvas, this.f13448k, this.f13446i, f13423l, f13424m, i == this.f13456u.size() + (-1) ? MotionEventCompat.ACTION_MASK : 0);
                i++;
            }
            if (!this.f13428D && this.f13432H) {
                removeCallbacks(this.f13433I);
                postDelayed(this.f13433I, 350L);
            }
        }
    }

    /* renamed from: g */
    private void m13157g() {
        removeCallbacks(this.f13433I);
        if (!this.f13432H) {
            this.f13432H = true;
            startAnimation(this.f13430F);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m13158h() {
        if (this.f13432H) {
            this.f13432H = false;
            startAnimation(this.f13431G);
        }
    }

    /* renamed from: i */
    private void m13161i() {
        Transformation transformation = new Transformation();
        this.f13431G.getTransformation(System.currentTimeMillis(), transformation);
        transformation.setAlpha(0.2f);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (!this.f13428D && getVisibility() == 0 && getParent() != null && i3 - i2 > 0 && this.f13434J != i) {
            this.f13434J = i;
            m13157g();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void setOnIndexSelectedListener(InterfaceC3668bi interfaceC3668bi) {
        this.f13425A = interfaceC3668bi;
    }

    public void setInvisibleIndexScroll(boolean z) {
        if (z) {
            setVisibility(4);
        } else {
            setVisibility(0);
        }
        if (this.f13442e != z) {
            this.f13442e = z;
            invalidate();
        }
    }

    public void setTopPadding(int i) {
        this.f13439a = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.f13432H) {
            this.f13432H = true;
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (this.f13428D) {
            this.f13428D = false;
            m13140a(false);
            this.f13461z.setVisibility(4);
        }
        return parcelableOnSaveInstanceState;
    }
}
