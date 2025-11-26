package android.support.v4.view;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ParcelableCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.sec.pns.msg.MsgResultCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: a */
    private final ArrayList f148a;

    /* renamed from: b */
    private PagerAdapter f149b;

    /* renamed from: c */
    private int f150c;

    /* renamed from: d */
    private int f151d;

    /* renamed from: e */
    private Parcelable f152e;

    /* renamed from: f */
    private ClassLoader f153f;

    /* renamed from: g */
    private Scroller f154g;

    /* renamed from: h */
    private InterfaceC0028f f155h;

    /* renamed from: i */
    private int f156i;

    /* renamed from: j */
    private int f157j;

    /* renamed from: k */
    private boolean f158k;

    /* renamed from: l */
    private boolean f159l;

    /* renamed from: m */
    private boolean f160m;

    /* renamed from: n */
    private boolean f161n;

    /* renamed from: o */
    private boolean f162o;

    /* renamed from: p */
    private boolean f163p;

    /* renamed from: q */
    private int f164q;

    /* renamed from: r */
    private float f165r;

    /* renamed from: s */
    private float f166s;

    /* renamed from: t */
    private float f167t;

    /* renamed from: u */
    private int f168u;

    /* renamed from: v */
    private VelocityTracker f169v;

    /* renamed from: w */
    private int f170w;

    /* renamed from: x */
    private int f171x;

    /* renamed from: y */
    private OnPageChangeListener f172y;

    /* renamed from: z */
    private int f173z;

    public interface OnPageChangeListener {
        /* renamed from: a */
        void mo205a(int i);

        /* renamed from: a */
        void mo206a(int i, float f, int i2);

        /* renamed from: b */
        void mo207b(int i);
    }

    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = ParcelableCompat.m166a(new C0034l());
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            ClassLoader classLoader2 = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader2);
            this.loader = classLoader2;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i);
        }
    }

    public class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        /* renamed from: a */
        public void mo205a(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        /* renamed from: a */
        public void mo206a(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        /* renamed from: b */
        public void mo207b(int i) {
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.f148a = new ArrayList();
        this.f151d = -1;
        this.f152e = null;
        this.f153f = null;
        this.f168u = -1;
        this.f173z = 0;
        m200a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f148a = new ArrayList();
        this.f151d = -1;
        this.f152e = null;
        this.f153f = null;
        this.f168u = -1;
        this.f173z = 0;
        m200a();
    }

    /* renamed from: a */
    private void m194a(int i) {
        if (this.f173z == i) {
            return;
        }
        this.f173z = i;
        if (this.f172y != null) {
            this.f172y.mo207b(i);
        }
    }

    /* renamed from: a */
    private void m195a(MotionEvent motionEvent) {
        int iM178a = MotionEventCompat.m178a(motionEvent);
        if (MotionEventCompat.m180b(motionEvent, iM178a) == this.f168u) {
            int i = iM178a == 0 ? 1 : 0;
            this.f166s = MotionEventCompat.m181c(motionEvent, i);
            this.f168u = MotionEventCompat.m180b(motionEvent, i);
            if (this.f169v != null) {
                this.f169v.clear();
            }
        }
    }

    /* renamed from: a */
    private void m196a(boolean z) {
        if (this.f159l != z) {
            this.f159l = z;
        }
    }

    /* renamed from: c */
    private void m197c() {
        boolean z;
        boolean z2 = this.f161n;
        if (z2) {
            m196a(false);
            this.f154g.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f154g.getCurrX();
            int currY = this.f154g.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
            m194a(0);
        }
        this.f160m = false;
        this.f161n = false;
        int i = 0;
        while (true) {
            z = z2;
            if (i >= this.f148a.size()) {
                break;
            }
            C0041s c0041s = (C0041s) this.f148a.get(i);
            if (c0041s.f177c) {
                z = true;
                c0041s.f177c = false;
            }
            z2 = z;
            i++;
        }
        if (z) {
            m203b();
        }
    }

    /* renamed from: d */
    private void m198d() {
        this.f162o = false;
        this.f163p = false;
        if (this.f169v != null) {
            this.f169v.recycle();
            this.f169v = null;
        }
    }

    /* renamed from: a */
    C0041s m199a(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f148a.size()) {
                return null;
            }
            C0041s c0041s = (C0041s) this.f148a.get(i2);
            if (this.f149b.m189a(view, c0041s.f175a)) {
                return c0041s;
            }
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    void m200a() {
        setWillNotDraw(false);
        this.f154g = new Scroller(getContext());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f164q = ViewConfigurationCompat.m193a(viewConfiguration);
        this.f170w = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f171x = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    /* renamed from: a */
    void m201a(int i, int i2) {
        if (getChildCount() == 0) {
            m196a(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i3 = i - scrollX;
        int i4 = i2 - scrollY;
        if (i3 == 0 && i4 == 0) {
            m197c();
            return;
        }
        m196a(true);
        this.f161n = true;
        m194a(2);
        this.f154g.startScroll(scrollX, scrollY, i3, i4);
        invalidate();
    }

    /* renamed from: a */
    void m202a(int i, boolean z, boolean z2) {
        if (this.f149b == null || this.f149b.m183a() <= 0) {
            m196a(false);
            return;
        }
        if (!z2 && this.f150c == i && this.f148a.size() != 0) {
            m196a(false);
            return;
        }
        int iM183a = i < 0 ? 0 : i >= this.f149b.m183a() ? this.f149b.m183a() - 1 : i;
        if (iM183a > this.f150c + 1 || iM183a < this.f150c - 1) {
            for (int i2 = 0; i2 < this.f148a.size(); i2++) {
                ((C0041s) this.f148a.get(i2)).f177c = true;
            }
        }
        boolean z3 = this.f150c != iM183a;
        this.f150c = iM183a;
        m203b();
        if (z) {
            m201a(getWidth() * iM183a, 0);
            if (!z3 || this.f172y == null) {
                return;
            }
            this.f172y.mo205a(iM183a);
            return;
        }
        if (z3 && this.f172y != null) {
            this.f172y.mo205a(iM183a);
        }
        m197c();
        scrollTo(getWidth() * iM183a, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!this.f158k) {
            super.addView(view, i, layoutParams);
        } else {
            addViewInLayout(view, i, layoutParams);
            view.measure(this.f156i, this.f157j);
        }
    }

    /* renamed from: b */
    void m203b() {
        if (this.f149b == null || this.f160m || getWindowToken() == null) {
            return;
        }
        this.f149b.m187a(this);
        int i = this.f150c > 0 ? this.f150c - 1 : this.f150c;
        int iM183a = this.f149b.m183a();
        int i2 = this.f150c < iM183a - 1 ? this.f150c + 1 : iM183a - 1;
        int i3 = 0;
        int i4 = -1;
        while (i3 < this.f148a.size()) {
            C0041s c0041s = (C0041s) this.f148a.get(i3);
            if ((c0041s.f176b < i || c0041s.f176b > i2) && !c0041s.f177c) {
                this.f148a.remove(i3);
                i3--;
                this.f149b.m188a(this, c0041s.f176b, c0041s.f175a);
            } else if (i4 < i2 && c0041s.f176b > i) {
                int i5 = i4 + 1;
                if (i5 < i) {
                    i5 = i;
                }
                while (i5 <= i2 && i5 < c0041s.f176b) {
                    m204b(i5, i3);
                    i5++;
                    i3++;
                }
            }
            i3++;
            i4 = c0041s.f176b;
        }
        int i6 = this.f148a.size() > 0 ? ((C0041s) this.f148a.get(this.f148a.size() - 1)).f176b : -1;
        if (i6 < i2) {
            int i7 = i6 + 1;
            if (i7 <= i) {
                i7 = i;
            }
            while (i7 <= i2) {
                m204b(i7, -1);
                i7++;
            }
        }
        this.f149b.m191b(this);
    }

    /* renamed from: b */
    void m204b(int i, int i2) {
        C0041s c0041s = new C0041s();
        c0041s.f176b = i;
        c0041s.f175a = this.f149b.m184a(this, i);
        if (i2 < 0) {
            this.f148a.add(c0041s);
        } else {
            this.f148a.add(i2, c0041s);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f154g.isFinished() || !this.f154g.computeScrollOffset()) {
            m197c();
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f154g.getCurrX();
        int currY = this.f154g.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
        }
        if (this.f172y != null) {
            int width = getWidth();
            int i = currX / width;
            int i2 = currX % width;
            this.f172y.mo206a(i, i2 / width, i2);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f149b != null) {
            m203b();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f162o = false;
            this.f163p = false;
            this.f168u = -1;
            return false;
        }
        if (action != 0) {
            if (this.f162o) {
                return true;
            }
            if (this.f163p) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f165r = x;
                this.f166s = x;
                this.f167t = motionEvent.getY();
                this.f168u = MotionEventCompat.m180b(motionEvent, 0);
                if (this.f173z != 2) {
                    m197c();
                    this.f162o = false;
                    this.f163p = false;
                    break;
                } else {
                    this.f162o = true;
                    this.f163p = false;
                    m194a(1);
                    break;
                }
            case 2:
                int i = this.f168u;
                if (i != -1) {
                    int iM179a = MotionEventCompat.m179a(motionEvent, i);
                    float fM181c = MotionEventCompat.m181c(motionEvent, iM179a);
                    float fAbs = Math.abs(fM181c - this.f166s);
                    float fAbs2 = Math.abs(MotionEventCompat.m182d(motionEvent, iM179a) - this.f167t);
                    if (fAbs > this.f164q && fAbs > fAbs2) {
                        this.f162o = true;
                        m194a(1);
                        this.f166s = fM181c;
                        m196a(true);
                        break;
                    } else if (fAbs2 > this.f164q) {
                        this.f163p = true;
                        break;
                    }
                }
                break;
            case 6:
                m195a(motionEvent);
                break;
        }
        return this.f162o;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0041s c0041sM199a;
        this.f158k = true;
        m203b();
        this.f158k = false;
        int childCount = getChildCount();
        int i5 = i3 - i;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (c0041sM199a = m199a(childAt)) != null) {
                int paddingLeft = (c0041sM199a.f176b * i5) + getPaddingLeft();
                int paddingTop = getPaddingTop();
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        this.f156i = View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
        this.f157j = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824);
        this.f158k = true;
        m203b();
        this.f158k = false;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                childAt.measure(this.f156i, this.f157j);
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.f149b != null) {
            this.f149b.m185a(savedState.adapterState, savedState.loader);
            m202a(savedState.position, false, true);
        } else {
            this.f151d = savedState.position;
            this.f152e = savedState.adapterState;
            this.f153f = savedState.loader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.f150c;
        savedState.adapterState = this.f149b.m190b();
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = this.f150c * i;
        if (i5 != getScrollX()) {
            m197c();
            scrollTo(i5, getScrollY());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f149b == null || this.f149b.m183a() == 0) {
            return false;
        }
        if (this.f169v == null) {
            this.f169v = VelocityTracker.obtain();
        }
        this.f169v.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                m197c();
                float x = motionEvent.getX();
                this.f165r = x;
                this.f166s = x;
                this.f168u = MotionEventCompat.m180b(motionEvent, 0);
                break;
            case 1:
                if (this.f162o) {
                    VelocityTracker velocityTracker = this.f169v;
                    velocityTracker.computeCurrentVelocity(MsgResultCode.SUCCESS, this.f171x);
                    int iM192a = (int) VelocityTrackerCompat.m192a(velocityTracker, this.f168u);
                    this.f160m = true;
                    if (Math.abs(iM192a) <= this.f170w && Math.abs(this.f165r - this.f166s) < getWidth() / 3) {
                        m202a(this.f150c, true, true);
                    } else if (this.f166s > this.f165r) {
                        m202a(this.f150c - 1, true, true);
                    } else {
                        m202a(this.f150c + 1, true, true);
                    }
                    this.f168u = -1;
                    m198d();
                    break;
                }
                break;
            case 2:
                if (!this.f162o) {
                    int iM179a = MotionEventCompat.m179a(motionEvent, this.f168u);
                    float fM181c = MotionEventCompat.m181c(motionEvent, iM179a);
                    float fAbs = Math.abs(fM181c - this.f166s);
                    float fAbs2 = Math.abs(MotionEventCompat.m182d(motionEvent, iM179a) - this.f167t);
                    if (fAbs > this.f164q && fAbs > fAbs2) {
                        this.f162o = true;
                        this.f166s = fM181c;
                        m194a(1);
                        m196a(true);
                    }
                }
                if (this.f162o) {
                    float fM181c2 = MotionEventCompat.m181c(motionEvent, MotionEventCompat.m179a(motionEvent, this.f168u));
                    float f = this.f166s - fM181c2;
                    this.f166s = fM181c2;
                    float scrollX = getScrollX() + f;
                    int width = getWidth();
                    float fMax = Math.max(0, (this.f150c - 1) * width);
                    float fMin = Math.min(this.f150c + 1, this.f149b.m183a() - 1) * width;
                    if (scrollX < fMax) {
                        scrollX = fMax;
                    } else if (scrollX > fMin) {
                        scrollX = fMin;
                    }
                    this.f166s += scrollX - ((int) scrollX);
                    scrollTo((int) scrollX, getScrollY());
                    if (this.f172y != null) {
                        int i = ((int) scrollX) / width;
                        int i2 = ((int) scrollX) % width;
                        this.f172y.mo206a(i, i2 / width, i2);
                        break;
                    }
                }
                break;
            case 3:
                if (this.f162o) {
                    m202a(this.f150c, true, true);
                    this.f168u = -1;
                    m198d();
                    break;
                }
                break;
            case 5:
                int iM178a = MotionEventCompat.m178a(motionEvent);
                this.f166s = MotionEventCompat.m181c(motionEvent, iM178a);
                this.f168u = MotionEventCompat.m180b(motionEvent, iM178a);
                break;
            case 6:
                m195a(motionEvent);
                this.f166s = MotionEventCompat.m181c(motionEvent, MotionEventCompat.m179a(motionEvent, this.f168u));
                break;
        }
        return true;
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.f149b != null) {
            this.f149b.m186a((InterfaceC0028f) null);
        }
        this.f149b = pagerAdapter;
        if (this.f149b != null) {
            if (this.f155h == null) {
                this.f155h = new C0025c(this);
            }
            this.f149b.m186a(this.f155h);
            this.f160m = false;
            if (this.f151d < 0) {
                m203b();
                return;
            }
            this.f149b.m185a(this.f152e, this.f153f);
            m202a(this.f151d, false, true);
            this.f151d = -1;
            this.f152e = null;
            this.f153f = null;
        }
    }

    public void setCurrentItem(int i) {
        this.f160m = false;
        m202a(i, true, false);
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f172y = onPageChangeListener;
    }
}
