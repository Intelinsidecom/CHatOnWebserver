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
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.sec.chaton.C1880ci;
import com.sec.chaton.R;
import java.lang.Character;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TwIndexScrollView extends FrameLayout implements AbsListView.OnScrollListener {

    /* renamed from: b */
    public static boolean f18789b = false;

    /* renamed from: l */
    private static int f18790l;

    /* renamed from: m */
    private static int f18791m;

    /* renamed from: A */
    private InterfaceC5158au f18792A;

    /* renamed from: B */
    private float f18793B;

    /* renamed from: C */
    private boolean f18794C;

    /* renamed from: D */
    private boolean f18795D;

    /* renamed from: E */
    private boolean f18796E;

    /* renamed from: F */
    private Animation f18797F;

    /* renamed from: G */
    private Animation f18798G;

    /* renamed from: H */
    private boolean f18799H;

    /* renamed from: I */
    private Runnable f18800I;

    /* renamed from: J */
    private int f18801J;

    /* renamed from: K */
    private final long f18802K;

    /* renamed from: L */
    private final long f18803L;

    /* renamed from: M */
    private boolean f18804M;

    /* renamed from: N */
    private int f18805N;

    /* renamed from: a */
    int f18806a;

    /* renamed from: c */
    private final boolean f18807c;

    /* renamed from: d */
    private float f18808d;

    /* renamed from: e */
    private boolean f18809e;

    /* renamed from: f */
    private boolean f18810f;

    /* renamed from: g */
    private boolean f18811g;

    /* renamed from: h */
    private Rect f18812h;

    /* renamed from: i */
    private Paint f18813i;

    /* renamed from: j */
    private int f18814j;

    /* renamed from: k */
    private Drawable f18815k;

    /* renamed from: n */
    private int f18816n;

    /* renamed from: o */
    private int f18817o;

    /* renamed from: p */
    private int f18818p;

    /* renamed from: q */
    private int f18819q;

    /* renamed from: r */
    private int f18820r;

    /* renamed from: s */
    private int f18821s;

    /* renamed from: t */
    private int f18822t;

    /* renamed from: u */
    private ArrayList<C5157at> f18823u;

    /* renamed from: v */
    private int f18824v;

    /* renamed from: w */
    private AbstractC5148ak f18825w;

    /* renamed from: x */
    private final C5155ar f18826x;

    /* renamed from: y */
    private String[] f18827y;

    /* renamed from: z */
    private C5154aq f18828z;

    public void setmIsFavoriteContactMode(boolean z) {
        this.f18811g = z;
    }

    public TwIndexScrollView(Context context) {
        super(context);
        this.f18807c = true;
        this.f18809e = false;
        this.f18806a = 0;
        this.f18810f = false;
        this.f18811g = false;
        this.f18812h = null;
        this.f18813i = null;
        this.f18815k = null;
        this.f18822t = 1;
        this.f18826x = new C5155ar(this);
        this.f18827y = null;
        this.f18828z = null;
        this.f18792A = null;
        this.f18794C = false;
        this.f18795D = false;
        this.f18796E = false;
        this.f18797F = null;
        this.f18798G = null;
        this.f18799H = true;
        this.f18800I = null;
        this.f18801J = -1;
        this.f18802K = 500L;
        this.f18803L = 350L;
        this.f18804M = false;
        this.f18805N = 0;
        this.f18820r = (int) getResources().getDimension(R.dimen.tw_indexview_first_handle_textgap);
        m19670a(context);
    }

    public TwIndexScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18807c = true;
        this.f18809e = false;
        this.f18806a = 0;
        this.f18810f = false;
        this.f18811g = false;
        this.f18812h = null;
        this.f18813i = null;
        this.f18815k = null;
        this.f18822t = 1;
        this.f18826x = new C5155ar(this);
        this.f18827y = null;
        this.f18828z = null;
        this.f18792A = null;
        this.f18794C = false;
        this.f18795D = false;
        this.f18796E = false;
        this.f18797F = null;
        this.f18798G = null;
        this.f18799H = true;
        this.f18800I = null;
        this.f18801J = -1;
        this.f18802K = 500L;
        this.f18803L = 350L;
        this.f18804M = false;
        this.f18805N = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1880ci.TwIndexView);
        int i = typedArrayObtainStyledAttributes.getInt(0, 1);
        typedArrayObtainStyledAttributes.recycle();
        this.f18822t = i;
        this.f18820r = typedArrayObtainStyledAttributes.getInt(1, (int) getResources().getDimension(R.dimen.tw_indexview_first_handle_textgap));
        m19670a(context);
    }

    public TwIndexScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18807c = true;
        this.f18809e = false;
        this.f18806a = 0;
        this.f18810f = false;
        this.f18811g = false;
        this.f18812h = null;
        this.f18813i = null;
        this.f18815k = null;
        this.f18822t = 1;
        this.f18826x = new C5155ar(this);
        this.f18827y = null;
        this.f18828z = null;
        this.f18792A = null;
        this.f18794C = false;
        this.f18795D = false;
        this.f18796E = false;
        this.f18797F = null;
        this.f18798G = null;
        this.f18799H = true;
        this.f18800I = null;
        this.f18801J = -1;
        this.f18802K = 500L;
        this.f18803L = 350L;
        this.f18804M = false;
        this.f18805N = 0;
        this.f18820r = (int) getResources().getDimension(R.dimen.tw_indexview_first_handle_textgap);
        m19670a(context);
    }

    /* renamed from: a */
    private void m19670a(Context context) {
        Resources resources = getResources();
        setFocusable(false);
        bringToFront();
        setHapticFeedbackEnabled(false);
        setSoundEffectsEnabled(false);
        if (this.f18828z == null) {
            this.f18828z = new C5154aq(this, getContext());
            this.f18828z.setVisibility(4);
        } else {
            removeView(this.f18828z);
        }
        addView(this.f18828z, new FrameLayout.LayoutParams(-1, -1));
        this.f18817o = (int) resources.getDimension(R.dimen.tw_indexview_first_handle_width);
        this.f18818p = (int) resources.getDimension(R.dimen.tw_indexview_second_handle_width);
        this.f18819q = (int) resources.getDimension(R.dimen.tw_indexview_second_handle_gap);
        this.f18814j = (int) resources.getDimension(R.dimen.tw_indexview_characters_width);
        this.f18821s = (int) resources.getDimension(R.dimen.tw_indexview_first_handle_toppading);
        f18790l = resources.getColor(R.color.fastscroll_index_color);
        f18791m = resources.getColor(R.color.fastscroll_sub_rectangular_orange_color);
        this.f18816n = (int) resources.getDimension(R.dimen.tw_indexview_first_handle_textsize);
        this.f18813i = new Paint();
        this.f18813i.setColor(f18790l);
        this.f18813i.setTextSize(this.f18816n);
        this.f18813i.setAntiAlias(true);
        this.f18813i.setTextAlign(Paint.Align.CENTER);
        this.f18813i.setTypeface(Typeface.DEFAULT);
        this.f18815k = resources.getDrawable(R.drawable.tw_scrollbar_handle_top_bg_default_holo_dark);
        this.f18823u = new ArrayList<>();
        this.f18797F = AnimationUtils.loadAnimation(context, R.anim.tw_indexscrollview_fade_in);
        this.f18798G = AnimationUtils.loadAnimation(context, R.anim.tw_indexscrollview_fade_out);
        this.f18797F.setInterpolator(new LinearInterpolator());
        this.f18798G.setInterpolator(new LinearInterpolator());
        this.f18797F.setDuration(500L);
        this.f18798G.setDuration(500L);
        this.f18798G.setFillEnabled(true);
        this.f18798G.setFillAfter(true);
        this.f18797F.setAnimationListener(new AnimationAnimationListenerC5151an(this));
        this.f18798G.setAnimationListener(new AnimationAnimationListenerC5152ao(this));
        this.f18800I = new RunnableC5153ap(this);
    }

    public void setIndexer(AbstractC5148ak abstractC5148ak) {
        if (abstractC5148ak == null) {
            throw new IllegalArgumentException("TwIndexView.setIndexer(indexer) : indexer=null.");
        }
        if (this.f18796E) {
            throw new UnsupportedOperationException("TwIndexView.setIndexer(indexer) :  you are not allowed to set the indexer if you already use indexScroll view under Simple scroll mode !!!");
        }
        if (this.f18825w != null) {
            this.f18825w.m19719b(this.f18826x);
        }
        this.f18825w = abstractC5148ak;
        this.f18827y = this.f18825w.m19717a();
        this.f18825w.m19716a(this.f18826x);
        m19673a(true);
    }

    public void setSimpleIndexHandleChar(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("TwIndexView.setIndexHandleChar(handleChar) ");
        }
        if (this.f18825w != null) {
            throw new UnsupportedOperationException("TwIndexView.setSimpleIndexHandleChar(String [] handleChar) :  you must not set the indexer to use simple index handle mode !!!");
        }
        this.f18796E = true;
        this.f18827y = strArr;
        m19673a(true);
    }

    public void setSimpleIndexHandleCharForContact(String[] strArr) {
        this.f18804M = true;
        setSimpleIndexHandleChar(strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m19673a(boolean z) {
        int size = this.f18823u.size();
        if (z || size < 1) {
            this.f18823u.clear();
            Rect rectM19669a = m19669a(0);
            if (rectM19669a != null) {
                m19676a("", rectM19669a.top);
                return;
            }
            return;
        }
        while (m19681c() > 1) {
            m19678b();
        }
    }

    /* renamed from: a */
    private boolean m19676a(String str, int i) {
        ArrayList<C5149al> arrayListM19715a;
        Rect rectM19669a;
        for (int i2 = 0; i2 < str.length(); i2++) {
            Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(str.charAt(i2));
            if (Character.UnicodeBlock.HANGUL_SYLLABLES.equals(unicodeBlockOf) || Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO.equals(unicodeBlockOf) || Character.UnicodeBlock.HANGUL_JAMO.equals(unicodeBlockOf)) {
                return false;
            }
        }
        if (this.f18810f && this.f18823u.size() > 0) {
            C5157at c5157at = this.f18823u.get(this.f18823u.size() - 1);
            int iM19738c = c5157at.m19738c();
            int iM19732a = c5157at.m19732a();
            if (iM19738c % iM19732a == iM19732a && iM19738c != c5157at.m19737b().size() - 1) {
                return false;
            }
        }
        int size = this.f18823u.size();
        if (this.f18824v > 0 && size >= this.f18824v) {
            return false;
        }
        if (this.f18796E) {
            arrayListM19715a = new ArrayList<>();
            for (int i3 = 0; i3 < this.f18827y.length; i3++) {
                C5149al c5149al = new C5149al();
                c5149al.f18853b = true;
                c5149al.f18854c = i3;
                c5149al.f18852a = this.f18827y[i3];
                arrayListM19715a.add(c5149al);
            }
        } else {
            arrayListM19715a = this.f18825w.m19715a(str, size != 0);
        }
        if (arrayListM19715a == null || arrayListM19715a.size() == 0 || (rectM19669a = m19669a(size)) == null) {
            return false;
        }
        this.f18823u.add(new C5157at(this, str, arrayListM19715a, i, this.f18820r, rectM19669a, size));
        return true;
    }

    /* renamed from: b */
    private void m19678b() {
        int size = this.f18823u.size();
        if (size > 1) {
            this.f18823u.remove(size - 1);
        }
    }

    /* renamed from: c */
    private int m19681c() {
        return this.f18823u.size();
    }

    /* renamed from: d */
    private C5157at m19684d() {
        int size = this.f18823u.size();
        if (size > 0) {
            return this.f18823u.get(size - 1);
        }
        return null;
    }

    public void setSubscrollLimit(int i) {
        if (i > 1) {
            this.f18824v = i;
        }
    }

    public void setHandlePosition(int i) {
        this.f18822t = i;
        m19686e();
        m19673a(true);
        invalidate();
    }

    /* renamed from: e */
    private void m19686e() {
        this.f18812h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Rect m19669a(int i) {
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
            if (this.f18827y == null) {
                return null;
            }
            int length = (this.f18820r * this.f18827y.length) + (this.f18821s * 2);
            if (this.f18796E && !this.f18804M) {
                this.f18817o = (int) resources.getDimension(R.dimen.tw_indexview_first_handle_width_clock);
            }
            int dimension = (int) resources.getDimension(R.dimen.tw_indexview_first_handle_top_margin);
            int i6 = dimension + length;
            if (height == 0 || i6 <= height) {
                height = i6;
            }
            if (this.f18822t == 1) {
                int i7 = width;
                i5 = width - this.f18817o;
                i4 = i7;
            } else {
                i4 = this.f18817o;
                i5 = 0;
            }
            this.f18812h = new Rect(i5, dimension, i4, height);
            return this.f18812h;
        }
        int i8 = this.f18819q + this.f18818p;
        if (this.f18822t == 1) {
            i3 = (this.f18812h.left - this.f18819q) - (i8 * (i - 1));
            i2 = i3 - this.f18818p;
        } else {
            i2 = this.f18812h.right + this.f18819q + (i8 * (i - 1));
            i3 = this.f18818p + i2;
        }
        return new Rect(i2, this.f18812h.top, i3, this.f18812h.bottom);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        this.f18808d = y;
        float x = motionEvent.getX();
        C5157at c5157atM19684d = m19684d();
        switch (action) {
            case 0:
                if (c5157atM19684d != null && !this.f18795D && this.f18823u.size() > 0 && this.f18823u.get(0).m19743g().contains((int) x, (int) y)) {
                    this.f18795D = true;
                    this.f18794C = false;
                    this.f18793B = x;
                    c5157atM19684d.m19730b(y);
                    m19672a(c5157atM19684d.m19742f());
                    if (this.f18798G.hasStarted() && !this.f18798G.hasEnded()) {
                        m19694i();
                    } else if (this.f18799H) {
                        m19687f();
                    }
                    m19690g();
                    break;
                } else {
                    return false;
                }
                break;
            case 1:
            case 3:
                if (this.f18795D) {
                    m19687f();
                    this.f18795D = false;
                    m19673a(false);
                    this.f18828z.setVisibility(4);
                    invalidate();
                    break;
                }
                break;
            case 2:
                if (c5157atM19684d != null && this.f18795D) {
                    int iM19681c = m19681c() - 1;
                    float fAbs = Math.abs(x - this.f18793B);
                    float f = ((this.f18819q + this.f18818p) * (iM19681c + 1.0f)) - (0.5f * this.f18818p);
                    float f2 = ((this.f18819q + this.f18818p) * iM19681c) - this.f18819q;
                    if (fAbs >= f && iM19681c < this.f18824v - 1) {
                        if (!this.f18794C) {
                            if (m19676a(c5157atM19684d.m19742f(), (int) c5157atM19684d.f18881l)) {
                                this.f18794C = false;
                                C5157at c5157atM19684d2 = m19684d();
                                if (c5157atM19684d2 != null) {
                                    c5157atM19684d2.m19735a(y);
                                }
                                f18789b = true;
                                invalidate();
                                break;
                            } else {
                                this.f18794C = true;
                                break;
                            }
                        }
                    } else if (fAbs < f2) {
                        this.f18794C = false;
                        m19678b();
                        C5157at c5157atM19684d3 = m19684d();
                        if (c5157atM19684d3 != null) {
                            c5157atM19684d3.m19735a(y);
                            m19672a(c5157atM19684d3.m19742f());
                        }
                        m19687f();
                        break;
                    } else {
                        this.f18794C = false;
                        if (c5157atM19684d.m19735a(y)) {
                            m19672a(c5157atM19684d.m19742f());
                            m19687f();
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
        if (this.f18795D) {
            this.f18795D = false;
            while (m19681c() > 1) {
                m19678b();
            }
        }
        C5157at c5157atM19684d = m19684d();
        if (c5157atM19684d != null) {
            c5157atM19684d.m19739c(i2);
        }
        this.f18828z.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m19672a(String str) {
        this.f18828z.m19725a(str);
        if (this.f18828z.getVisibility() != 0) {
            this.f18828z.setVisibility(0);
        } else {
            this.f18828z.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m19687f() {
        C5157at c5157atM19684d;
        int i = 0;
        if (this.f18792A != null && this.f18826x.m19727a() && (c5157atM19684d = m19684d()) != null) {
            if (c5157atM19684d.m19740d() != null) {
                if (this.f18811g && this.f18823u.size() == 1 && !Character.isLetter(this.f18827y[m19684d().m19738c()].charAt(0))) {
                    i = -c5157atM19684d.m19740d().f18854c;
                } else {
                    i = c5157atM19684d.m19740d().f18854c;
                }
            }
            this.f18792A.m19744a(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) throws Resources.NotFoundException {
        super.dispatchDraw(canvas);
        if (!this.f18809e) {
            int i = 0;
            while (i < this.f18823u.size()) {
                this.f18823u.get(i).m19734a(canvas, this.f18815k, this.f18813i, f18790l, f18791m, i == this.f18823u.size() + (-1) ? 255 : 0);
                i++;
            }
            if (!this.f18795D && this.f18799H) {
                removeCallbacks(this.f18800I);
                postDelayed(this.f18800I, 350L);
            }
        }
    }

    /* renamed from: g */
    private void m19690g() {
        removeCallbacks(this.f18800I);
        if (!this.f18799H) {
            this.f18799H = true;
            startAnimation(this.f18797F);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m19691h() {
        if (this.f18799H) {
            this.f18799H = false;
            startAnimation(this.f18798G);
        }
    }

    /* renamed from: i */
    private void m19694i() {
        Transformation transformation = new Transformation();
        this.f18798G.getTransformation(System.currentTimeMillis(), transformation);
        transformation.setAlpha(0.2f);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (!this.f18795D && getVisibility() == 0 && getParent() != null && i3 - i2 > 0 && this.f18801J != i) {
            this.f18801J = i;
            m19690g();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void setOnIndexSelectedListener(InterfaceC5158au interfaceC5158au) {
        this.f18792A = interfaceC5158au;
    }

    public void setInvisibleIndexScroll(boolean z) {
        if (z) {
            setVisibility(4);
        } else {
            setVisibility(0);
        }
        if (this.f18809e != z) {
            this.f18809e = z;
            invalidate();
        }
    }

    public void setTopPadding(int i) {
        this.f18806a = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.f18799H) {
            this.f18799H = true;
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (this.f18795D) {
            this.f18795D = false;
            m19673a(false);
            this.f18828z.setVisibility(4);
        }
        return parcelableOnSaveInstanceState;
    }
}
