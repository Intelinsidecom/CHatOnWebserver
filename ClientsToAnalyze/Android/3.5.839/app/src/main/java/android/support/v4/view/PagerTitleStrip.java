package android.support.v4.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup implements InterfaceC0191by {

    /* renamed from: n */
    private static final int[] f365n = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* renamed from: o */
    private static final int[] f366o = {R.attr.textAllCaps};

    /* renamed from: q */
    private static final InterfaceC0149aj f367q;

    /* renamed from: a */
    ViewPager f368a;

    /* renamed from: b */
    TextView f369b;

    /* renamed from: c */
    TextView f370c;

    /* renamed from: d */
    TextView f371d;

    /* renamed from: e */
    int f372e;

    /* renamed from: f */
    private int f373f;

    /* renamed from: g */
    private float f374g;

    /* renamed from: h */
    private int f375h;

    /* renamed from: i */
    private int f376i;

    /* renamed from: j */
    private boolean f377j;

    /* renamed from: k */
    private boolean f378k;

    /* renamed from: l */
    private final C0148ai f379l;

    /* renamed from: m */
    private WeakReference<AbstractC0144ae> f380m;

    /* renamed from: p */
    private int f381p;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f367q = new C0151al();
        } else {
            f367q = new C0150ak();
        }
    }

    /* renamed from: a */
    private static void m380a(TextView textView) {
        f367q.mo623a(textView);
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerTitleStrip(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        boolean z = false;
        this.f373f = -1;
        this.f374g = -1.0f;
        this.f379l = new C0148ai(this);
        TextView textView = new TextView(context);
        this.f369b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f370c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f371d = textView3;
        addView(textView3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f365n);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.f369b.setTextAppearance(context, resourceId);
            this.f370c.setTextAppearance(context, resourceId);
            this.f371d.setTextAppearance(context, resourceId);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            int color = typedArrayObtainStyledAttributes.getColor(2, 0);
            this.f369b.setTextColor(color);
            this.f370c.setTextColor(color);
            this.f371d.setTextColor(color);
        }
        this.f376i = typedArrayObtainStyledAttributes.getInteger(3, 80);
        typedArrayObtainStyledAttributes.recycle();
        this.f372e = this.f370c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f369b.setEllipsize(TextUtils.TruncateAt.END);
        this.f370c.setEllipsize(TextUtils.TruncateAt.END);
        this.f371d.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f366o);
            z = typedArrayObtainStyledAttributes2.getBoolean(0, false);
            typedArrayObtainStyledAttributes2.recycle();
        }
        if (z) {
            m380a(this.f369b);
            m380a(this.f370c);
            m380a(this.f371d);
        } else {
            this.f369b.setSingleLine();
            this.f370c.setSingleLine();
            this.f371d.setSingleLine();
        }
        this.f375h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void setTextSpacing(int i) {
        this.f375h = i;
        requestLayout();
    }

    /* renamed from: b */
    public int m383b() {
        return this.f375h;
    }

    public void setNonPrimaryAlpha(float f) {
        this.f381p = ((int) (255.0f * f)) & 255;
        int i = (this.f381p << 24) | (this.f372e & 16777215);
        this.f369b.setTextColor(i);
        this.f371d.setTextColor(i);
    }

    public void setTextColor(int i) {
        this.f372e = i;
        this.f370c.setTextColor(i);
        int i2 = (this.f381p << 24) | (this.f372e & 16777215);
        this.f369b.setTextColor(i2);
        this.f371d.setTextColor(i2);
    }

    public void setTextSize(int i, float f) {
        this.f369b.setTextSize(i, f);
        this.f370c.setTextSize(i, f);
        this.f371d.setTextSize(i, f);
    }

    public void setGravity(int i) {
        this.f376i = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        AbstractC0144ae abstractC0144aeM421b = viewPager.m421b();
        viewPager.m410a((InterfaceC0196cc) this.f379l);
        viewPager.m417a((InterfaceC0195cb) this.f379l);
        this.f368a = viewPager;
        m382a(this.f380m != null ? this.f380m.get() : null, abstractC0144aeM421b);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f368a != null) {
            m382a(this.f368a.m421b(), (AbstractC0144ae) null);
            this.f368a.m410a((InterfaceC0196cc) null);
            this.f368a.m417a((InterfaceC0195cb) null);
            this.f368a = null;
        }
    }

    /* renamed from: a */
    void m381a(int i, AbstractC0144ae abstractC0144ae) {
        CharSequence charSequenceM616c = null;
        int iMo612b = abstractC0144ae != null ? abstractC0144ae.mo612b() : 0;
        this.f377j = true;
        this.f369b.setText((i < 1 || abstractC0144ae == null) ? null : abstractC0144ae.m616c(i - 1));
        this.f370c.setText((abstractC0144ae == null || i >= iMo612b) ? null : abstractC0144ae.m616c(i));
        if (i + 1 < iMo612b && abstractC0144ae != null) {
            charSequenceM616c = abstractC0144ae.m616c(i + 1);
        }
        this.f371d.setText(charSequenceM616c);
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (width * 0.8f), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE);
        this.f369b.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f370c.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f371d.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f373f = i;
        if (!this.f378k) {
            mo378a(i, this.f374g, false);
        }
        this.f377j = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f377j) {
            super.requestLayout();
        }
    }

    /* renamed from: a */
    void m382a(AbstractC0144ae abstractC0144ae, AbstractC0144ae abstractC0144ae2) {
        if (abstractC0144ae != null) {
            abstractC0144ae.m613b(this.f379l);
            this.f380m = null;
        }
        if (abstractC0144ae2 != null) {
            abstractC0144ae2.m609a((DataSetObserver) this.f379l);
            this.f380m = new WeakReference<>(abstractC0144ae2);
        }
        if (this.f368a != null) {
            this.f373f = -1;
            this.f374g = -1.0f;
            m381a(this.f368a.m424c(), abstractC0144ae2);
            requestLayout();
        }
    }

    /* renamed from: a */
    void mo378a(int i, float f, boolean z) {
        int i2;
        int i3;
        int i4;
        if (i != this.f373f) {
            m381a(i, this.f368a.m421b());
        } else if (!z && f == this.f374g) {
            return;
        }
        this.f378k = true;
        int measuredWidth = this.f369b.getMeasuredWidth();
        int measuredWidth2 = this.f370c.getMeasuredWidth();
        int measuredWidth3 = this.f371d.getMeasuredWidth();
        int i5 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i6 = paddingRight + i5;
        int i7 = (width - (paddingLeft + i5)) - i6;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        int i8 = ((width - i6) - ((int) (f2 * i7))) - (measuredWidth2 / 2);
        int i9 = i8 + measuredWidth2;
        int baseline = this.f369b.getBaseline();
        int baseline2 = this.f370c.getBaseline();
        int baseline3 = this.f371d.getBaseline();
        int iMax = Math.max(Math.max(baseline, baseline2), baseline3);
        int i10 = iMax - baseline;
        int i11 = iMax - baseline2;
        int i12 = iMax - baseline3;
        int iMax2 = Math.max(Math.max(this.f369b.getMeasuredHeight() + i10, this.f370c.getMeasuredHeight() + i11), this.f371d.getMeasuredHeight() + i12);
        switch (this.f376i & 112) {
            case 16:
                int i13 = (((height - paddingTop) - paddingBottom) - iMax2) / 2;
                i2 = i13 + i10;
                i3 = i11 + i13;
                i4 = i13 + i12;
                break;
            case 80:
                int i14 = (height - paddingBottom) - iMax2;
                i2 = i14 + i10;
                i3 = i11 + i14;
                i4 = i14 + i12;
                break;
            default:
                i2 = paddingTop + i10;
                i3 = i11 + paddingTop;
                i4 = paddingTop + i12;
                break;
        }
        this.f370c.layout(i8, i3, i9, this.f370c.getMeasuredHeight() + i3);
        int iMin = Math.min(paddingLeft, (i8 - this.f375h) - measuredWidth);
        this.f369b.layout(iMin, i2, measuredWidth + iMin, this.f369b.getMeasuredHeight() + i2);
        int iMax3 = Math.max((width - paddingRight) - measuredWidth3, this.f375h + i9);
        this.f371d.layout(iMax3, i4, iMax3 + measuredWidth3, this.f371d.getMeasuredHeight() + i4);
        this.f374g = f;
        this.f378k = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int iMo377a = mo377a();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (size * 0.8f), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 - paddingTop, Integer.MIN_VALUE);
        this.f369b.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f370c.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f371d.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        if (mode2 == 1073741824) {
            setMeasuredDimension(size, size2);
        } else {
            setMeasuredDimension(size, Math.max(iMo377a, this.f370c.getMeasuredHeight() + paddingTop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f368a != null) {
            mo378a(this.f373f, this.f374g >= 0.0f ? this.f374g : 0.0f, true);
        }
    }

    /* renamed from: a */
    int mo377a() {
        Drawable background = getBackground();
        if (background == null) {
            return 0;
        }
        return background.getIntrinsicHeight();
    }
}
