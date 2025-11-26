package com.sec.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SectionIndexer;
import com.sec.chaton.R;

/* compiled from: FastScrollableExpandableListView.java */
/* renamed from: com.sec.widget.ac */
/* loaded from: classes.dex */
class C3635ac {

    /* renamed from: a */
    private static int f13465a = 1;

    /* renamed from: b */
    private Drawable f13466b;

    /* renamed from: c */
    private Drawable f13467c;

    /* renamed from: d */
    private int f13468d;

    /* renamed from: e */
    private int f13469e;

    /* renamed from: f */
    private int f13470f;

    /* renamed from: g */
    private RectF f13471g;

    /* renamed from: h */
    private int f13472h;

    /* renamed from: i */
    private ExpandableListView f13473i;

    /* renamed from: j */
    private boolean f13474j;

    /* renamed from: k */
    private int f13475k;

    /* renamed from: l */
    private Paint f13476l;

    /* renamed from: m */
    private int f13477m;

    /* renamed from: o */
    private boolean f13479o;

    /* renamed from: p */
    private Object[] f13480p;

    /* renamed from: q */
    private String f13481q;

    /* renamed from: r */
    private boolean f13482r;

    /* renamed from: s */
    private RunnableC3636ad f13483s;

    /* renamed from: t */
    private int f13484t;

    /* renamed from: v */
    private ExpandableListAdapter f13486v;

    /* renamed from: w */
    private SectionIndexer f13487w;

    /* renamed from: x */
    private boolean f13488x;

    /* renamed from: n */
    private int f13478n = -1;

    /* renamed from: u */
    private Handler f13485u = new Handler();

    public C3635ac(Context context, ExpandableListView expandableListView) {
        this.f13473i = expandableListView;
        m13172a(context);
    }

    /* renamed from: a */
    public void m13178a(int i) {
        switch (i) {
            case 0:
                this.f13485u.removeCallbacks(this.f13483s);
                this.f13473i.invalidate();
                break;
            case 2:
                if (this.f13484t != 2) {
                    m13174d();
                }
            case 3:
                this.f13485u.removeCallbacks(this.f13483s);
                break;
            case 4:
                int width = this.f13473i.getWidth();
                this.f13473i.invalidate(width - this.f13469e, this.f13470f, width, this.f13470f + this.f13468d);
                break;
        }
        this.f13484t = i;
    }

    /* renamed from: a */
    public int m13177a() {
        return this.f13484t;
    }

    /* renamed from: d */
    private void m13174d() {
        if (this.f13473i != null) {
            int width = this.f13473i.getWidth();
            this.f13466b.setBounds(width - this.f13469e, 0, width, this.f13468d);
        }
    }

    /* renamed from: a */
    private void m13173a(Context context, Drawable drawable) {
        this.f13466b = drawable;
        this.f13469e = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_width);
        this.f13468d = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_height);
        this.f13488x = true;
    }

    /* renamed from: a */
    private void m13172a(Context context) {
        Resources resources = context.getResources();
        m13173a(context, resources.getDrawable(R.drawable.fastscrollbar_handle_accelerated_anim2));
        this.f13467c = resources.getDrawable(R.drawable.fastscroll_menu_submenu_background);
        this.f13474j = true;
        m13175e();
        this.f13472h = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_overlay_size);
        this.f13471g = new RectF();
        this.f13483s = new RunnableC3636ad(this);
        this.f13476l = new Paint();
        this.f13476l.setAntiAlias(true);
        this.f13476l.setTextAlign(Paint.Align.CENTER);
        this.f13476l.setTextSize((float) (this.f13472h * 0.75d));
        this.f13476l.setColor(-1277150);
        this.f13476l.setStyle(Paint.Style.FILL_AND_STROKE);
        if (this.f13473i.getWidth() > 0 && this.f13473i.getHeight() > 0) {
            m13179a(this.f13473i.getWidth(), this.f13473i.getHeight(), 0, 0);
        }
        this.f13484t = 0;
    }

    /* renamed from: b */
    void m13184b() {
        m13178a(0);
    }

    /* renamed from: c */
    boolean m13186c() {
        return this.f13484t != 0;
    }

    /* renamed from: a */
    public void m13180a(Canvas canvas) {
        if (this.f13484t != 0) {
            int i = this.f13470f;
            int width = this.f13473i.getWidth();
            RunnableC3636ad runnableC3636ad = this.f13483s;
            int iM13188b = -1;
            if (this.f13484t == 4) {
                iM13188b = runnableC3636ad.m13188b();
                if (iM13188b < 104) {
                }
                this.f13466b.setBounds(width - ((this.f13469e * iM13188b) / 208), 0, width, this.f13468d);
                this.f13488x = true;
            }
            canvas.translate(0.0f, i);
            this.f13466b.draw(canvas);
            canvas.translate(0.0f, -i);
            if (this.f13484t == 3 && this.f13482r) {
                if (this.f13481q.length() != 0) {
                    this.f13467c.draw(canvas);
                    Paint paint = this.f13476l;
                    float fDescent = paint.descent();
                    RectF rectF = this.f13471g;
                    canvas.drawText(this.f13481q, (rectF.left + rectF.right) / 2.0f, (float) ((((rectF.top + rectF.bottom) / 2.0f) + (paint.getTextSize() / 2.0f)) - (fDescent / 1.5d)), paint);
                    return;
                }
                return;
            }
            if (this.f13484t == 4) {
                if (iM13188b == 0) {
                    m13178a(0);
                } else {
                    this.f13473i.invalidate(width - this.f13469e, i, width, this.f13468d + i);
                }
            }
        }
    }

    /* renamed from: a */
    void m13179a(int i, int i2, int i3, int i4) {
        if (this.f13466b != null) {
            this.f13466b.setBounds(i - this.f13469e, 0, i, this.f13468d);
        }
        RectF rectF = this.f13471g;
        rectF.left = (i - this.f13472h) / 2;
        rectF.right = rectF.left + this.f13472h;
        rectF.top = i2 / 10;
        rectF.bottom = rectF.top + this.f13472h;
        if (this.f13467c != null) {
            this.f13467c.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }
    }

    /* renamed from: a */
    void m13181a(AbsListView absListView, int i, int i2, int i3) {
        if (this.f13478n != i3 && i2 > 0) {
            this.f13478n = i3;
            this.f13479o = this.f13478n / i2 >= f13465a;
        }
        if (!this.f13479o) {
            if (this.f13484t != 0) {
                m13178a(0);
                return;
            }
            return;
        }
        if (i3 - i2 > 0 && this.f13484t != 3) {
            this.f13470f = ((this.f13473i.getHeight() - this.f13468d) * i) / (i3 - i2);
            if (this.f13488x) {
                m13174d();
                this.f13488x = false;
            }
        }
        this.f13474j = true;
        if (i != this.f13475k) {
            this.f13475k = i;
            if (this.f13484t != 3) {
                m13178a(2);
                this.f13485u.postDelayed(this.f13483s, 1500L);
            }
        }
    }

    /* renamed from: e */
    private void m13175e() {
        ExpandableListAdapter expandableListAdapter = this.f13473i.getExpandableListAdapter();
        this.f13487w = null;
        if (expandableListAdapter instanceof SectionIndexer) {
            this.f13487w = (SectionIndexer) expandableListAdapter;
            this.f13486v = expandableListAdapter;
            this.f13480p = this.f13487w.getSections();
        }
    }

    /* renamed from: a */
    private void m13171a(float f) {
        int i;
        int count = this.f13473i.getCount();
        this.f13474j = false;
        Object[] objArr = this.f13480p;
        if (objArr != null && objArr.length > 1) {
            int length = objArr.length;
            i = (int) (length * f);
            if (i >= length) {
                i = length - 1;
            }
            this.f13473i.setSelectedGroup(this.f13477m + i);
        } else {
            int i2 = (int) (count * f);
            this.f13473i.setSelectionFromTop(this.f13473i.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(this.f13477m + i2)), 0);
            this.f13473i.setSelection(i2 + this.f13477m);
            i = -1;
        }
        if (i >= 0) {
            String string = objArr[i].toString();
            this.f13481q = string;
            this.f13482r = !(string.length() == 1 && string.charAt(0) == ' ') && i < objArr.length;
            return;
        }
        this.f13482r = false;
    }

    /* renamed from: f */
    private void m13176f() {
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
        this.f13473i.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* renamed from: a */
    boolean m13183a(MotionEvent motionEvent) {
        if (this.f13484t <= 0 || motionEvent.getAction() != 0 || !m13182a(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        m13178a(3);
        return true;
    }

    /* renamed from: b */
    boolean m13185b(MotionEvent motionEvent) {
        int i = 0;
        if (this.f13484t == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!m13182a(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
            m13178a(3);
            if (this.f13486v == null && this.f13473i != null) {
                m13175e();
            }
            if (this.f13473i != null) {
                this.f13473i.requestDisallowInterceptTouchEvent(true);
            }
            m13176f();
            return true;
        }
        if (action == 1) {
            if (this.f13484t != 3) {
                return false;
            }
            if (this.f13473i != null) {
                this.f13473i.requestDisallowInterceptTouchEvent(false);
            }
            m13178a(2);
            Handler handler = this.f13485u;
            handler.removeCallbacks(this.f13483s);
            handler.postDelayed(this.f13483s, 1000L);
            return true;
        }
        if (action != 2 || this.f13484t != 3) {
            return false;
        }
        int height = this.f13473i.getHeight();
        int y = (((int) motionEvent.getY()) - this.f13468d) + 10;
        if (y >= 0) {
            i = this.f13468d + y > height ? height - this.f13468d : y;
        }
        if (Math.abs(this.f13470f - i) < 2) {
            return true;
        }
        this.f13470f = i;
        if (this.f13474j) {
            m13171a(this.f13470f / (height - this.f13468d));
        }
        return true;
    }

    /* renamed from: a */
    boolean m13182a(float f, float f2) {
        return f > ((float) (this.f13473i.getWidth() - this.f13469e)) && f2 >= ((float) this.f13470f) && f2 <= ((float) (this.f13470f + this.f13468d));
    }
}
