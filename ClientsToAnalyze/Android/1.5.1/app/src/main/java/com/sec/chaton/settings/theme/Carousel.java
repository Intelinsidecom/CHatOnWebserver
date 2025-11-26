package com.sec.chaton.settings.theme;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import android.widget.SpinnerAdapter;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.C0062R;
import com.sec.chaton.settings.theme.CarouselAdapter;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Carousel extends CarouselSpinner implements GestureDetector.OnGestureListener {

    /* renamed from: F */
    private static final String f3202F = Carousel.class.getSimpleName();

    /* renamed from: G */
    private CarouselAdapter.AdapterContextMenuInfo f3203G;

    /* renamed from: H */
    private int f3204H;

    /* renamed from: I */
    private Camera f3205I;

    /* renamed from: J */
    private Runnable f3206J;

    /* renamed from: K */
    private int f3207K;

    /* renamed from: L */
    private View f3208L;

    /* renamed from: M */
    private RunnableC0515f f3209M;

    /* renamed from: N */
    private GestureDetector f3210N;

    /* renamed from: O */
    private int f3211O;

    /* renamed from: P */
    private boolean f3212P;

    /* renamed from: Q */
    private int f3213Q;

    /* renamed from: R */
    private int f3214R;

    /* renamed from: S */
    private boolean f3215S;

    /* renamed from: T */
    private View f3216T;

    /* renamed from: U */
    private boolean f3217U;

    /* renamed from: V */
    private boolean f3218V;

    /* renamed from: W */
    private boolean f3219W;

    /* renamed from: X */
    private boolean f3220X;

    /* renamed from: Y */
    private float f3221Y;

    /* renamed from: Z */
    private boolean f3222Z;

    public class Transer extends Transformation {
    }

    public Carousel(Context context) {
        this(context, null);
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.f3204H = 10;
        this.f3205I = new Camera();
        this.f3206J = new RunnableC0518i(this);
        this.f3209M = new RunnableC0515f(this);
        this.f3213Q = 12;
        this.f3214R = 3;
        this.f3217U = true;
        this.f3218V = true;
        this.f3221Y = 0.2617994f;
        setChildrenDrawingOrderEnabled(true);
        this.f3210N = new GestureDetector(this);
        this.f3210N.setIsLongpressEnabled(true);
        setStaticTransformationsEnabled(true);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0062R.styleable.Carousel);
        this.f3204H = typedArrayObtainStyledAttributes.getInteger(1, AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE);
        this.f3222Z = typedArrayObtainStyledAttributes.getBoolean(2, false);
        int integer = typedArrayObtainStyledAttributes.getInteger(4, 0);
        TypedArray typedArrayObtainTypedArray = getResources().obtainTypedArray(typedArrayObtainStyledAttributes.getResourceId(3, -1));
        int integer2 = typedArrayObtainStyledAttributes.getInteger(6, 3);
        int integer3 = typedArrayObtainStyledAttributes.getInteger(7, 12);
        float f = typedArrayObtainStyledAttributes.getFloat(5, 15.0f);
        if (f > 15.0f || f < 0.0f) {
        }
        this.f3214R = integer2 < 3 ? 3 : integer2;
        this.f3213Q = integer3 > 12 ? 12 : integer3;
        if (typedArrayObtainStyledAttributes.length() < this.f3214R || typedArrayObtainStyledAttributes.length() > this.f3213Q) {
            throw new IllegalArgumentException("Invalid set of items.");
        }
        C0510a c0510a = new C0510a(this, getContext());
        c0510a.m3280a(typedArrayObtainTypedArray, this.f3222Z);
        setAdapter((SpinnerAdapter) c0510a);
        m3250c((integer < 0 || integer >= c0510a.getCount()) ? 0 : integer);
    }

    /* renamed from: a */
    private int m3221a(View view, boolean z) {
        int measuredHeight = z ? getMeasuredHeight() : getHeight();
        int measuredHeight2 = z ? view.getMeasuredHeight() : view.getHeight();
        switch (this.f3211O) {
            case 16:
                return ((((measuredHeight - this.f3261D.bottom) - this.f3261D.top) - measuredHeight2) / 2) + this.f3261D.top;
            case 48:
                return this.f3261D.top;
            case 80:
                return (measuredHeight - this.f3261D.bottom) - measuredHeight2;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    private void m3224a(int i, float f) {
        if (this.f3234l) {
            CarouselImageView carouselImageView = (CarouselImageView) this.f3264v.getView(i, null, this);
            m3228b(carouselImageView, carouselImageView.m3261a(), f);
            return;
        }
        CarouselImageView carouselImageView2 = (CarouselImageView) this.f3262E.m3285a(i);
        if (carouselImageView2 != null) {
            m3228b(carouselImageView2, carouselImageView2.m3261a(), f);
        } else {
            CarouselImageView carouselImageView3 = (CarouselImageView) this.f3264v.getView(i, null, this);
            m3228b(carouselImageView3, carouselImageView3.m3261a(), f);
        }
    }

    /* renamed from: a */
    private void m3225a(CarouselImageView carouselImageView, int i, float f) {
        float f2;
        float f3;
        carouselImageView.setAlpha(f < 90.0f ? (int) (((180.0f - f) / 180.0f) * 255.0f) : f > 270.0f ? (int) (((f - 180.0f) / 180.0f) * 255.0f) : 0);
        if (f < 180.0f) {
            f2 = (i / 2) * (f / 90.0f);
            f3 = ((i * 2) / 3) * (f / 90.0f);
        } else if (f > 180.0f) {
            f2 = -((i / 2) * ((360.0f - f) / 90.0f));
            f3 = ((i * 2) / 3) * ((360.0f - f) / 90.0f);
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        float fSin = ((-getHeight()) / 10) - (((float) (f3 * Math.sin(this.f3221Y))) / 4.0f);
        carouselImageView.setX(f2);
        carouselImageView.setZ(f3);
        carouselImageView.setY(fSin);
    }

    /* renamed from: b */
    private void m3228b(CarouselImageView carouselImageView, int i, float f) {
        int height;
        int width;
        addViewInLayout(carouselImageView, -1, generateDefaultLayoutParams());
        carouselImageView.setSelected(i == this.f3237o);
        if (this.f3230h) {
            height = ((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) / 3;
            width = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            height = getHeight() / 3;
            width = getWidth();
        }
        carouselImageView.setCurrentAngle(f);
        m3225a(carouselImageView, width, f);
        carouselImageView.measure(width, height);
        carouselImageView.layout(0, m3221a((View) carouselImageView, true), width, height);
    }

    /* renamed from: b */
    private boolean m3229b(View view, int i, long j) {
        boolean zM3260a = this.f3233k != null ? this.f3233k.m3260a(this, this.f3208L, this.f3207K, j) : false;
        if (!zM3260a) {
            this.f3203G = new CarouselAdapter.AdapterContextMenuInfo(view, i, j);
            zM3260a = super.showContextMenuForChild(this);
        }
        if (zM3260a) {
            performHapticFeedback(0);
        }
        return zM3260a;
    }

    /* renamed from: p */
    private void m3232p() {
        if (this.f3220X) {
            this.f3220X = false;
            super.mo3235a();
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m3233q() {
        if (getChildCount() == 0 || this.f3216T == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < mo3248b().getCount(); i++) {
            arrayList.add((CarouselImageView) mo3248b().getView(i, null, null));
        }
        Collections.sort(arrayList, new C0519j(this));
        float fM3263b = ((CarouselImageView) arrayList.get(0)).m3263b();
        if (fM3263b > 180.0f) {
            fM3263b = -(360.0f - fM3263b);
        }
        if (fM3263b != 0.0f) {
            this.f3209M.m3284b(-fM3263b);
        } else {
            mo3237a(((CarouselImageView) arrayList.get(0)).m3261a());
            m3232p();
        }
    }

    /* renamed from: r */
    private void m3234r() {
        View view = this.f3216T;
        View childAt = getChildAt(this.f3237o - this.f3223a);
        this.f3216T = childAt;
        if (childAt == null) {
            return;
        }
        childAt.setSelected(true);
        childAt.setFocusable(true);
        if (hasFocus()) {
            childAt.requestFocus();
        }
        if (view != null) {
            view.setSelected(false);
            view.setFocusable(false);
        }
    }

    @Override // com.sec.chaton.settings.theme.CarouselAdapter
    /* renamed from: a */
    void mo3235a() {
        if (this.f3220X) {
            return;
        }
        super.mo3235a();
    }

    /* renamed from: a */
    void m3236a(float f) {
        if (getChildCount() == 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= mo3248b().getCount()) {
                this.f3262E.m3286a();
                invalidate();
                return;
            }
            CarouselImageView carouselImageView = (CarouselImageView) mo3248b().getView(i2, null, null);
            float fM3263b = carouselImageView.m3263b() + f;
            while (fM3263b > 360.0f) {
                fM3263b -= 360.0f;
            }
            while (fM3263b < 0.0f) {
                fM3263b += 360.0f;
            }
            carouselImageView.setCurrentAngle(fM3263b);
            m3225a(carouselImageView, getWidth(), fM3263b);
            i = i2 + 1;
        }
    }

    @Override // com.sec.chaton.settings.theme.CarouselAdapter
    /* renamed from: a */
    void mo3237a(int i) {
        super.mo3237a(i);
        m3234r();
    }

    @Override // com.sec.chaton.settings.theme.CarouselSpinner
    /* renamed from: a */
    void mo3238a(int i, boolean z) {
        if (this.f3234l) {
            m3256i();
        }
        if (mo3253f() == 0) {
            m3272n();
            return;
        }
        if (this.f3235m >= 0) {
            mo3237a(this.f3235m);
        }
        m3273o();
        detachAllViewsFromParent();
        float count = 360.0f / mo3248b().getCount();
        float f = this.f3237o * count;
        for (int i2 = 0; i2 < mo3248b().getCount(); i2++) {
            float f2 = (i2 * count) - f;
            if (f2 < 0.0f) {
                f2 += 360.0f;
            }
            m3224a(i2, f2);
        }
        this.f3262E.m3286a();
        invalidate();
        m3250c(this.f3237o);
        m3257j();
        this.f3228f = false;
        m3234r();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.LayoutParams;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        return 1;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        return this.f3237o;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return this.f3239q;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return keyEvent.dispatch(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
        if (this.f3216T != null) {
            this.f3216T.setPressed(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetSelected(boolean z) {
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i; i3++) {
            CarouselImageView carouselImageView = (CarouselImageView) mo3248b().getView(i3, null, null);
            if (i2 == 0) {
                carouselImageView.setDrawn(false);
            }
            arrayList.add((CarouselImageView) mo3248b().getView(i3, null, null));
        }
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            CarouselImageView carouselImageView2 = (CarouselImageView) it.next();
            if (!carouselImageView2.m3265d()) {
                carouselImageView2.setDrawn(true);
                return carouselImageView2.m3261a();
            }
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        transformation.clear();
        transformation.setTransformationType(Transformation.TYPE_BOTH);
        float left = getLeft() + (getWidth() / 2);
        float bottom = getBottom() + (getHeight() / 2);
        float width = view.getWidth() / 2.0f;
        float height = view.getHeight();
        float fAbs = Math.abs(left - width);
        float fAbs2 = Math.abs(bottom - height);
        this.f3205I.save();
        if (fAbs / 1000.0f > 1.0f) {
        }
        if (fAbs2 / 1000.0f > 1.0f) {
        }
        Matrix matrix = transformation.getMatrix();
        this.f3205I.translate(((CarouselImageView) view).getX(), ((CarouselImageView) view).getY(), ((CarouselImageView) view).m3264c());
        this.f3205I.getMatrix(matrix);
        matrix.preTranslate(-width, -height);
        matrix.postTranslate(width, height);
        this.f3205I.restore();
        return true;
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.f3203G;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        ChatONLogWriter.m3506b("SKIN onFling", null);
        if (!this.f3217U) {
            removeCallbacks(this.f3206J);
            if (!this.f3220X) {
                this.f3220X = true;
            }
        }
        this.f3209M.m3283a((int) (-f));
        return true;
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z || this.f3216T == null) {
            return;
        }
        this.f3216T.requestFocus(i);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ChatONLogWriter.m3506b("SKIN onKeyDown", null);
        switch (i) {
            case 21:
                playSoundEffect(1);
                return true;
            case 22:
                playSoundEffect(3);
                return true;
            case 23:
            case 66:
                this.f3215S = true;
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        ChatONLogWriter.m3506b("SKIN onKeyUp", null);
        switch (i) {
            case 23:
            case 66:
                m3245a(getChildAt(this.f3237o - this.f3223a), this.f3237o, this.f3264v.getItemId(this.f3237o));
                return true;
            default:
                return super.onKeyUp(i, keyEvent);
        }
    }

    @Override // com.sec.chaton.settings.theme.CarouselAdapter, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f3230h = true;
        mo3238a(0, false);
        this.f3230h = false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.f3207K < 0) {
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.f3217U) {
            if (this.f3220X) {
                this.f3220X = false;
            }
        } else if (this.f3212P && !this.f3220X) {
            this.f3220X = true;
        }
        m3236a(((int) f) * (-1));
        this.f3212P = false;
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.f3207K < 0) {
            return false;
        }
        m3245a(this.f3208L, this.f3237o, this.f3237o);
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f3210N.onTouchEvent(motionEvent);
    }

    public void setAnimationDuration(int i) {
        this.f3204H = i;
    }

    public void setCallbackDuringFling(boolean z) {
        this.f3217U = z;
    }

    public void setCallbackOnUnselectedItemClick(boolean z) {
        this.f3218V = z;
    }

    public void setGravity(int i) {
        if (this.f3211O != i) {
            this.f3211O = i;
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean showContextMenu() {
        if (!isPressed() || this.f3237o < 0) {
            return false;
        }
        return m3229b(getChildAt(this.f3237o - this.f3223a), this.f3237o, this.f3238p);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        int iA = m3244a(view);
        if (iA < 0) {
            return false;
        }
        return m3229b(view, iA, this.f3264v.getItemId(iA));
    }
}
