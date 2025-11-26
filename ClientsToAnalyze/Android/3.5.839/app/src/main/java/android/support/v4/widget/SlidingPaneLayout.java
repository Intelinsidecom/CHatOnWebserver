package android.support.v4.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.C0159at;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: a */
    static final InterfaceC0234ai f519a;

    /* renamed from: b */
    private int f520b;

    /* renamed from: c */
    private int f521c;

    /* renamed from: d */
    private Drawable f522d;

    /* renamed from: e */
    private final int f523e;

    /* renamed from: f */
    private boolean f524f;

    /* renamed from: g */
    private View f525g;

    /* renamed from: h */
    private float f526h;

    /* renamed from: i */
    private float f527i;

    /* renamed from: j */
    private int f528j;

    /* renamed from: k */
    private boolean f529k;

    /* renamed from: l */
    private int f530l;

    /* renamed from: m */
    private float f531m;

    /* renamed from: n */
    private float f532n;

    /* renamed from: o */
    private InterfaceC0232ag f533o;

    /* renamed from: p */
    private final C0238am f534p;

    /* renamed from: q */
    private boolean f535q;

    /* renamed from: r */
    private boolean f536r;

    /* renamed from: s */
    private final Rect f537s;

    /* renamed from: t */
    private final ArrayList<RunnableC0230ae> f538t;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            f519a = new C0237al();
        } else if (i >= 16) {
            f519a = new C0236ak();
        } else {
            f519a = new C0235aj();
        }
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f520b = -858993460;
        this.f536r = true;
        this.f537s = new Rect();
        this.f538t = new ArrayList<>();
        float f = context.getResources().getDisplayMetrics().density;
        this.f523e = (int) ((32.0f * f) + 0.5f);
        ViewConfiguration.get(context);
        setWillNotDraw(false);
        C0159at.m635a(this, new C0229ad(this));
        C0159at.m639b(this, 1);
        this.f534p = C0238am.m827a(this, 0.5f, new C0231af(this));
        this.f534p.m846a(1);
        this.f534p.m845a(f * 400.0f);
    }

    public void setParallaxDistance(int i) {
        this.f530l = i;
        requestLayout();
    }

    public void setSliderFadeColor(int i) {
        this.f520b = i;
    }

    public void setCoveredFadeColor(int i) {
        this.f521c = i;
    }

    public void setPanelSlideListener(InterfaceC0232ag interfaceC0232ag) {
        this.f533o = interfaceC0232ag;
    }

    /* renamed from: a */
    void m796a(View view) {
        if (this.f533o != null) {
            this.f533o.m819a(view, this.f526h);
        }
    }

    /* renamed from: b */
    void m798b(View view) {
        if (this.f533o != null) {
            this.f533o.m818a(view);
        }
        sendAccessibilityEvent(32);
    }

    /* renamed from: c */
    void m800c(View view) {
        if (this.f533o != null) {
            this.f533o.m820b(view);
        }
        sendAccessibilityEvent(32);
    }

    /* renamed from: d */
    void m802d(View view) {
        int bottom;
        int top;
        int right;
        int left;
        int i;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view != null && m793f(view)) {
            left = view.getLeft();
            right = view.getRight();
            top = view.getTop();
            bottom = view.getBottom();
        } else {
            bottom = 0;
            top = 0;
            right = 0;
            left = 0;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != view) {
                int iMax = Math.max(paddingLeft, childAt.getLeft());
                int iMax2 = Math.max(paddingTop, childAt.getTop());
                int iMin = Math.min(width, childAt.getRight());
                int iMin2 = Math.min(height, childAt.getBottom());
                if (iMax >= left && iMax2 >= top && iMin <= right && iMin2 <= bottom) {
                    i = 4;
                } else {
                    i = 0;
                }
                childAt.setVisibility(i);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    void m795a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* renamed from: f */
    private static boolean m793f(View view) {
        Drawable background;
        if (C0159at.m644g(view)) {
            return true;
        }
        return Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f536r = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f536r = true;
        int size = this.f538t.size();
        for (int i = 0; i < size; i++) {
            this.f538t.get(i).run();
        }
        this.f538t.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cd A[PHI: r2
  0x00cd: PHI (r2v12 float) = (r2v11 float), (r2v14 float) binds: [B:35:0x00bf, B:37:0x00c6] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r16, int r17) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f536r) {
            this.f526h = (this.f524f && this.f535q) ? 1.0f : 0.0f;
        }
        int i8 = 0;
        int i9 = paddingLeft;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() == 8) {
                i6 = i9;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f541b) {
                    int iMin = (Math.min(paddingLeft, (i7 - paddingRight) - this.f523e) - i9) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f528j = iMin;
                    layoutParams.f542c = ((layoutParams.leftMargin + i9) + iMin) + (measuredWidth / 2) > i7 - paddingRight;
                    i6 = layoutParams.leftMargin + ((int) (iMin * this.f526h)) + i9;
                    i5 = 0;
                } else if (!this.f524f || this.f530l == 0) {
                    i5 = 0;
                    i6 = paddingLeft;
                } else {
                    i5 = (int) ((1.0f - this.f526h) * this.f530l);
                    i6 = paddingLeft;
                }
                int i10 = i6 - i5;
                childAt.layout(i10, paddingTop, i10 + measuredWidth, childAt.getMeasuredHeight() + paddingTop);
                paddingLeft += childAt.getWidth();
            }
            i8++;
            i9 = i6;
        }
        if (this.f536r) {
            if (this.f524f) {
                if (this.f530l != 0) {
                    m779a(this.f526h);
                }
                if (((LayoutParams) this.f525g.getLayoutParams()).f542c) {
                    m783a(this.f525g, this.f526h, this.f520b);
                }
            } else {
                for (int i11 = 0; i11 < childCount; i11++) {
                    m783a(getChildAt(i11), 0.0f, this.f520b);
                }
            }
            m802d(this.f525g);
        }
        this.f536r = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f536r = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f524f) {
            this.f535q = view == this.f525g;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            r2 = 0
            r1 = 1
            int r3 = android.support.v4.view.C0224z.m741a(r8)
            boolean r0 = r7.f524f
            if (r0 != 0) goto L2d
            if (r3 != 0) goto L2d
            int r0 = r7.getChildCount()
            if (r0 <= r1) goto L2d
            android.view.View r0 = r7.getChildAt(r1)
            if (r0 == 0) goto L2d
            android.support.v4.widget.am r4 = r7.f534p
            float r5 = r8.getX()
            int r5 = (int) r5
            float r6 = r8.getY()
            int r6 = (int) r6
            boolean r0 = r4.m857b(r0, r5, r6)
            if (r0 != 0) goto L41
            r0 = r1
        L2b:
            r7.f535q = r0
        L2d:
            boolean r0 = r7.f524f
            if (r0 == 0) goto L37
            boolean r0 = r7.f529k
            if (r0 == 0) goto L43
            if (r3 == 0) goto L43
        L37:
            android.support.v4.widget.am r0 = r7.f534p
            r0.m864e()
            boolean r2 = super.onInterceptTouchEvent(r8)
        L40:
            return r2
        L41:
            r0 = r2
            goto L2b
        L43:
            r0 = 3
            if (r3 == r0) goto L48
            if (r3 != r1) goto L4e
        L48:
            android.support.v4.widget.am r0 = r7.f534p
            r0.m864e()
            goto L40
        L4e:
            switch(r3) {
                case 0: goto L5e;
                case 1: goto L51;
                case 2: goto L82;
                default: goto L51;
            }
        L51:
            r0 = r2
        L52:
            android.support.v4.widget.am r3 = r7.f534p
            boolean r3 = r3.m849a(r8)
            if (r3 != 0) goto L5c
            if (r0 == 0) goto L40
        L5c:
            r2 = r1
            goto L40
        L5e:
            r7.f529k = r2
            float r0 = r8.getX()
            float r3 = r8.getY()
            r7.f531m = r0
            r7.f532n = r3
            android.support.v4.widget.am r4 = r7.f534p
            android.view.View r5 = r7.f525g
            int r0 = (int) r0
            int r3 = (int) r3
            boolean r0 = r4.m857b(r5, r0, r3)
            if (r0 == 0) goto L51
            android.view.View r0 = r7.f525g
            boolean r0 = r7.m805e(r0)
            if (r0 == 0) goto L51
            r0 = r1
            goto L52
        L82:
            float r0 = r8.getX()
            float r3 = r8.getY()
            float r4 = r7.f531m
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            float r4 = r7.f532n
            float r3 = r3 - r4
            float r3 = java.lang.Math.abs(r3)
            android.support.v4.widget.am r4 = r7.f534p
            int r4 = r4.m861d()
            float r4 = (float) r4
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L51
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L51
            android.support.v4.widget.am r0 = r7.f534p
            r0.m864e()
            r7.f529k = r1
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f524f) {
            return super.onTouchEvent(motionEvent);
        }
        this.f534p.m853b(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f531m = x;
                this.f532n = y;
                return true;
            case 1:
                if (!m805e(this.f525g)) {
                    return true;
                }
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float f = x2 - this.f531m;
                float f2 = y2 - this.f532n;
                int iM861d = this.f534p.m861d();
                if ((f * f) + (f2 * f2) >= iM861d * iM861d || !this.f534p.m857b(this.f525g, (int) x2, (int) y2)) {
                    return true;
                }
                m786a(this.f525g, 0);
                return true;
            default:
                return true;
        }
    }

    /* renamed from: a */
    private boolean m786a(View view, int i) {
        if (!this.f536r && !m797a(0.0f, i)) {
            return false;
        }
        this.f535q = false;
        return true;
    }

    /* renamed from: b */
    private boolean m788b(View view, int i) {
        if (!this.f536r && !m797a(1.0f, i)) {
            return false;
        }
        this.f535q = true;
        return true;
    }

    /* renamed from: b */
    public boolean m799b() {
        return m788b(this.f525g, 0);
    }

    /* renamed from: c */
    public boolean m801c() {
        return m786a(this.f525g, 0);
    }

    /* renamed from: d */
    public boolean m803d() {
        return !this.f524f || this.f526h == 1.0f;
    }

    /* renamed from: e */
    public boolean m804e() {
        return this.f524f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m780a(int i) {
        LayoutParams layoutParams = (LayoutParams) this.f525g.getLayoutParams();
        this.f526h = (i - (getPaddingLeft() + layoutParams.leftMargin)) / this.f528j;
        if (this.f530l != 0) {
            m779a(this.f526h);
        }
        if (layoutParams.f542c) {
            m783a(this.f525g, this.f526h, this.f520b);
        }
        m796a(this.f525g);
    }

    /* renamed from: a */
    private void m783a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) ((((-16777216) & i) >>> 24) * f)) << 24) | (16777215 & i);
            if (layoutParams.f543d == null) {
                layoutParams.f543d = new Paint();
            }
            layoutParams.f543d.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (C0159at.m641d(view) != 2) {
                C0159at.m633a(view, 2, layoutParams.f543d);
            }
            m794g(view);
            return;
        }
        if (C0159at.m641d(view) != 0) {
            if (layoutParams.f543d != null) {
                layoutParams.f543d.setColorFilter(null);
            }
            RunnableC0230ae runnableC0230ae = new RunnableC0230ae(this, view);
            this.f538t.add(runnableC0230ae);
            C0159at.m636a(this, runnableC0230ae);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iSave = canvas.save(2);
        if (this.f524f && !layoutParams.f541b && this.f525g != null) {
            canvas.getClipBounds(this.f537s);
            this.f537s.right = Math.min(this.f537s.right, this.f525g.getLeft());
            canvas.clipRect(this.f537s);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            zDrawChild = super.drawChild(canvas, view, j);
        } else if (layoutParams.f542c && this.f526h > 0.0f) {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, view.getLeft(), view.getTop(), layoutParams.f543d);
                zDrawChild = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                zDrawChild = super.drawChild(canvas, view, j);
            }
        } else {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            zDrawChild = super.drawChild(canvas, view, j);
        }
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m794g(View view) {
        f519a.mo823a(this, view);
    }

    /* renamed from: a */
    boolean m797a(float f, int i) {
        if (!this.f524f) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) this.f525g.getLayoutParams();
        if (!this.f534p.m850a(this.f525g, (int) (layoutParams.leftMargin + getPaddingLeft() + (this.f528j * f)), this.f525g.getTop())) {
            return false;
        }
        m795a();
        C0159at.m638b(this);
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f534p.m851a(true)) {
            if (!this.f524f) {
                this.f534p.m865f();
            } else {
                C0159at.m638b(this);
            }
        }
    }

    public void setShadowDrawable(Drawable drawable) {
        this.f522d = drawable;
    }

    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && this.f522d != null) {
            int intrinsicWidth = this.f522d.getIntrinsicWidth();
            int left = childAt.getLeft();
            this.f522d.setBounds(left - intrinsicWidth, childAt.getTop(), left, childAt.getBottom());
            this.f522d.draw(canvas);
        }
    }

    /* renamed from: a */
    private void m779a(float f) {
        LayoutParams layoutParams = (LayoutParams) this.f525g.getLayoutParams();
        boolean z = layoutParams.f542c && layoutParams.leftMargin <= 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != this.f525g) {
                int i2 = (int) ((1.0f - this.f527i) * this.f530l);
                this.f527i = f;
                childAt.offsetLeftAndRight(i2 - ((int) ((1.0f - f) * this.f530l)));
                if (z) {
                    m783a(childAt, 1.0f - this.f527i, this.f521c);
                }
            }
        }
    }

    /* renamed from: e */
    boolean m805e(View view) {
        if (view == null) {
            return false;
        }
        return this.f524f && ((LayoutParams) view.getLayoutParams()).f542c && this.f526h > 0.0f;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isOpen = m804e() ? m803d() : this.f535q;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            m799b();
        } else {
            m801c();
        }
        this.f535q = savedState.isOpen;
    }

    public class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: e */
        private static final int[] f539e = {R.attr.layout_weight};

        /* renamed from: a */
        public float f540a;

        /* renamed from: b */
        boolean f541b;

        /* renamed from: c */
        boolean f542c;

        /* renamed from: d */
        Paint f543d;

        public LayoutParams() {
            super(-1, -1);
            this.f540a = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f540a = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f540a = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f540a = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f539e);
            this.f540a = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0233ah();
        boolean isOpen;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.isOpen = parcel.readInt() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isOpen ? 1 : 0);
        }
    }
}
