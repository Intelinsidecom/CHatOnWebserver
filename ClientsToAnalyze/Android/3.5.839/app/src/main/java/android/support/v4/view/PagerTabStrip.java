package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {

    /* renamed from: f */
    private int f349f;

    /* renamed from: g */
    private int f350g;

    /* renamed from: h */
    private int f351h;

    /* renamed from: i */
    private int f352i;

    /* renamed from: j */
    private int f353j;

    /* renamed from: k */
    private int f354k;

    /* renamed from: l */
    private final Paint f355l;

    /* renamed from: m */
    private final Rect f356m;

    /* renamed from: n */
    private int f357n;

    /* renamed from: o */
    private boolean f358o;

    /* renamed from: p */
    private boolean f359p;

    /* renamed from: q */
    private int f360q;

    /* renamed from: r */
    private boolean f361r;

    /* renamed from: s */
    private float f362s;

    /* renamed from: t */
    private float f363t;

    /* renamed from: u */
    private int f364u;

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f355l = new Paint();
        this.f356m = new Rect();
        this.f357n = 255;
        this.f358o = false;
        this.f359p = false;
        this.f349f = this.f372e;
        this.f355l.setColor(this.f349f);
        float f = context.getResources().getDisplayMetrics().density;
        this.f350g = (int) ((3.0f * f) + 0.5f);
        this.f351h = (int) ((6.0f * f) + 0.5f);
        this.f352i = (int) (64.0f * f);
        this.f354k = (int) ((16.0f * f) + 0.5f);
        this.f360q = (int) ((1.0f * f) + 0.5f);
        this.f353j = (int) ((f * 32.0f) + 0.5f);
        this.f364u = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(m383b());
        setWillNotDraw(false);
        this.f369b.setFocusable(true);
        this.f369b.setOnClickListener(new ViewOnClickListenerC0145af(this));
        this.f371d.setFocusable(true);
        this.f371d.setOnClickListener(new ViewOnClickListenerC0146ag(this));
        if (getBackground() == null) {
            this.f358o = true;
        }
    }

    public void setTabIndicatorColor(int i) {
        this.f349f = i;
        this.f355l.setColor(this.f349f);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(getContext().getResources().getColor(i));
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.f351h) {
            i4 = this.f351h;
        }
        super.setPadding(i, i2, i3, i4);
    }

    @Override // android.support.v4.view.PagerTitleStrip
    public void setTextSpacing(int i) {
        if (i < this.f352i) {
            i = this.f352i;
        }
        super.setTextSpacing(i);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.f359p) {
            this.f358o = drawable == null;
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.f359p) {
            this.f358o = ((-16777216) & i) == 0;
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.f359p) {
            this.f358o = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.f358o = z;
        this.f359p = true;
        invalidate();
    }

    @Override // android.support.v4.view.PagerTitleStrip
    /* renamed from: a */
    int mo377a() {
        return Math.max(super.mo377a(), this.f353j);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.f361r) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.f362s = x;
                this.f363t = y;
                this.f361r = false;
                break;
            case 1:
                if (x >= this.f370c.getLeft() - this.f354k) {
                    if (x > this.f370c.getRight() + this.f354k) {
                        this.f368a.setCurrentItem(this.f368a.m424c() + 1);
                        break;
                    }
                } else {
                    this.f368a.setCurrentItem(this.f368a.m424c() - 1);
                    break;
                }
                break;
            case 2:
                if (Math.abs(x - this.f362s) > this.f364u || Math.abs(y - this.f363t) > this.f364u) {
                    this.f361r = true;
                    break;
                }
                break;
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f370c.getLeft() - this.f354k;
        int right = this.f370c.getRight() + this.f354k;
        int i = height - this.f350g;
        this.f355l.setColor((this.f357n << 24) | (this.f349f & 16777215));
        canvas.drawRect(left, i, right, height, this.f355l);
        if (this.f358o) {
            this.f355l.setColor((-16777216) | (this.f349f & 16777215));
            canvas.drawRect(getPaddingLeft(), height - this.f360q, getWidth() - getPaddingRight(), height, this.f355l);
        }
    }

    @Override // android.support.v4.view.PagerTitleStrip
    /* renamed from: a */
    void mo378a(int i, float f, boolean z) {
        Rect rect = this.f356m;
        int height = getHeight();
        int left = this.f370c.getLeft() - this.f354k;
        int right = this.f370c.getRight() + this.f354k;
        int i2 = height - this.f350g;
        rect.set(left, i2, right, height);
        super.mo378a(i, f, z);
        this.f357n = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f370c.getLeft() - this.f354k, i2, this.f370c.getRight() + this.f354k, height);
        invalidate(rect);
    }
}
