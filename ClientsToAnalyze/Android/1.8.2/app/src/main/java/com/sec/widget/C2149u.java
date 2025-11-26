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
/* renamed from: com.sec.widget.u */
/* loaded from: classes.dex */
class C2149u {

    /* renamed from: a */
    private static int f7817a = 1;

    /* renamed from: b */
    private Drawable f7818b;

    /* renamed from: c */
    private Drawable f7819c;

    /* renamed from: d */
    private int f7820d;

    /* renamed from: e */
    private int f7821e;

    /* renamed from: f */
    private int f7822f;

    /* renamed from: g */
    private RectF f7823g;

    /* renamed from: h */
    private int f7824h;

    /* renamed from: i */
    private ExpandableListView f7825i;

    /* renamed from: j */
    private boolean f7826j;

    /* renamed from: k */
    private int f7827k;

    /* renamed from: l */
    private Paint f7828l;

    /* renamed from: m */
    private int f7829m;

    /* renamed from: o */
    private boolean f7831o;

    /* renamed from: p */
    private Object[] f7832p;

    /* renamed from: q */
    private String f7833q;

    /* renamed from: r */
    private boolean f7834r;

    /* renamed from: s */
    private RunnableC2150v f7835s;

    /* renamed from: t */
    private int f7836t;

    /* renamed from: v */
    private ExpandableListAdapter f7838v;

    /* renamed from: w */
    private SectionIndexer f7839w;

    /* renamed from: x */
    private boolean f7840x;

    /* renamed from: n */
    private int f7830n = -1;

    /* renamed from: u */
    private Handler f7837u = new Handler();

    public C2149u(Context context, ExpandableListView expandableListView) {
        this.f7825i = expandableListView;
        m7518a(context);
    }

    /* renamed from: a */
    public void m7524a(int i) {
        switch (i) {
            case 0:
                this.f7837u.removeCallbacks(this.f7835s);
                this.f7825i.invalidate();
                break;
            case 2:
                if (this.f7836t != 2) {
                    m7520d();
                }
            case 3:
                this.f7837u.removeCallbacks(this.f7835s);
                break;
            case 4:
                int width = this.f7825i.getWidth();
                this.f7825i.invalidate(width - this.f7821e, this.f7822f, width, this.f7822f + this.f7820d);
                break;
        }
        this.f7836t = i;
    }

    /* renamed from: a */
    public int m7523a() {
        return this.f7836t;
    }

    /* renamed from: d */
    private void m7520d() {
        int width = this.f7825i.getWidth();
        this.f7818b.setBounds(width - this.f7821e, 0, width, this.f7820d);
        this.f7818b.setAlpha(208);
    }

    /* renamed from: a */
    private void m7519a(Context context, Drawable drawable) {
        this.f7818b = drawable;
        this.f7821e = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_width);
        this.f7820d = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_height);
        this.f7840x = true;
    }

    /* renamed from: a */
    private void m7518a(Context context) {
        Resources resources = context.getResources();
        m7519a(context, resources.getDrawable(R.drawable.fastscrollbar_handle_accelerated_anim2));
        this.f7819c = resources.getDrawable(R.drawable.fastscroll_menu_submenu_background);
        this.f7826j = true;
        m7521e();
        this.f7824h = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_overlay_size);
        this.f7823g = new RectF();
        this.f7835s = new RunnableC2150v(this);
        this.f7828l = new Paint();
        this.f7828l.setAntiAlias(true);
        this.f7828l.setTextAlign(Paint.Align.CENTER);
        this.f7828l.setTextSize((this.f7824h * 2) / 3);
        this.f7828l.setColor(-1277150);
        this.f7828l.setStyle(Paint.Style.FILL_AND_STROKE);
        if (this.f7825i.getWidth() > 0 && this.f7825i.getHeight() > 0) {
            m7525a(this.f7825i.getWidth(), this.f7825i.getHeight(), 0, 0);
        }
        this.f7836t = 0;
    }

    /* renamed from: b */
    void m7530b() {
        m7524a(0);
    }

    /* renamed from: c */
    boolean m7532c() {
        return this.f7836t != 0;
    }

    /* renamed from: a */
    public void m7526a(Canvas canvas) {
        if (this.f7836t != 0) {
            int i = this.f7822f;
            int width = this.f7825i.getWidth();
            RunnableC2150v runnableC2150v = this.f7835s;
            int iM7534b = -1;
            if (this.f7836t == 4) {
                iM7534b = runnableC2150v.m7534b();
                if (iM7534b < 104) {
                    this.f7818b.setAlpha(iM7534b * 2);
                }
                this.f7818b.setBounds(width - ((this.f7821e * iM7534b) / 208), 0, width, this.f7820d);
                this.f7840x = true;
            }
            canvas.translate(0.0f, i);
            this.f7818b.draw(canvas);
            canvas.translate(0.0f, -i);
            if (this.f7836t == 3 && this.f7834r) {
                if (this.f7833q.length() != 0) {
                    this.f7819c.draw(canvas);
                    Paint paint = this.f7828l;
                    float fDescent = paint.descent();
                    RectF rectF = this.f7823g;
                    canvas.drawText(this.f7833q, ((int) (rectF.left + rectF.right)) / 2, ((((int) (rectF.top + rectF.bottom)) / 2) + (paint.getTextSize() / 2.0f)) - fDescent, paint);
                    return;
                }
                return;
            }
            if (this.f7836t == 4) {
                if (iM7534b == 0) {
                    m7524a(0);
                } else {
                    this.f7825i.invalidate(width - this.f7821e, i, width, this.f7820d + i);
                }
            }
        }
    }

    /* renamed from: a */
    void m7525a(int i, int i2, int i3, int i4) {
        if (this.f7818b != null) {
            this.f7818b.setBounds(i - this.f7821e, 0, i, this.f7820d);
        }
        RectF rectF = this.f7823g;
        rectF.left = (i - this.f7824h) / 2;
        rectF.right = rectF.left + this.f7824h;
        rectF.top = i2 / 10;
        rectF.bottom = rectF.top + this.f7824h;
        if (this.f7819c != null) {
            this.f7819c.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }
    }

    /* renamed from: a */
    void m7527a(AbsListView absListView, int i, int i2, int i3) {
        if (this.f7830n != i3 && i2 > 0) {
            this.f7830n = i3;
            this.f7831o = this.f7830n / i2 >= f7817a;
        }
        if (!this.f7831o) {
            if (this.f7836t != 0) {
                m7524a(0);
                return;
            }
            return;
        }
        if (i3 - i2 > 0 && this.f7836t != 3) {
            this.f7822f = ((this.f7825i.getHeight() - this.f7820d) * i) / (i3 - i2);
            if (this.f7840x) {
                m7520d();
                this.f7840x = false;
            }
        }
        this.f7826j = true;
        if (i != this.f7827k) {
            this.f7827k = i;
            if (this.f7836t != 3) {
                m7524a(2);
                this.f7837u.postDelayed(this.f7835s, 1500L);
            }
        }
    }

    /* renamed from: e */
    private void m7521e() {
        ExpandableListAdapter expandableListAdapter = this.f7825i.getExpandableListAdapter();
        this.f7839w = null;
        if (expandableListAdapter instanceof SectionIndexer) {
            this.f7839w = (SectionIndexer) expandableListAdapter;
            this.f7838v = expandableListAdapter;
            this.f7832p = this.f7839w.getSections();
        }
    }

    /* renamed from: a */
    private void m7517a(float f) {
        int i;
        int count = this.f7825i.getCount();
        this.f7826j = false;
        float f2 = (1.0f / count) / 8.0f;
        Object[] objArr = this.f7832p;
        if (objArr != null && objArr.length > 1) {
            int length = objArr.length;
            i = (int) (length * f);
            if (i >= length) {
                i = length - 1;
            }
            this.f7825i.setSelectedGroup(this.f7829m + i);
        } else {
            int i2 = (int) (count * f);
            this.f7825i.setSelectionFromTop(this.f7825i.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(this.f7829m + i2)), 0);
            this.f7825i.setSelection(i2 + this.f7829m);
            i = -1;
        }
        if (i >= 0) {
            String string = objArr[i].toString();
            this.f7833q = string;
            this.f7834r = !(string.length() == 1 && string.charAt(0) == ' ') && i < objArr.length;
            return;
        }
        this.f7834r = false;
    }

    /* renamed from: f */
    private void m7522f() {
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
        this.f7825i.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* renamed from: a */
    boolean m7529a(MotionEvent motionEvent) {
        if (this.f7836t <= 0 || motionEvent.getAction() != 0 || !m7528a(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        m7524a(3);
        return true;
    }

    /* renamed from: b */
    boolean m7531b(MotionEvent motionEvent) {
        int i = 0;
        if (this.f7836t == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!m7528a(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
            m7524a(3);
            if (this.f7838v == null && this.f7825i != null) {
                m7521e();
            }
            if (this.f7825i != null) {
                this.f7825i.requestDisallowInterceptTouchEvent(true);
            }
            m7522f();
            return true;
        }
        if (action == 1) {
            if (this.f7836t != 3) {
                return false;
            }
            if (this.f7825i != null) {
                this.f7825i.requestDisallowInterceptTouchEvent(false);
            }
            m7524a(2);
            Handler handler = this.f7837u;
            handler.removeCallbacks(this.f7835s);
            handler.postDelayed(this.f7835s, 1000L);
            return true;
        }
        if (action != 2 || this.f7836t != 3) {
            return false;
        }
        int height = this.f7825i.getHeight();
        int y = (((int) motionEvent.getY()) - this.f7820d) + 10;
        if (y >= 0) {
            i = this.f7820d + y > height ? height - this.f7820d : y;
        }
        if (Math.abs(this.f7822f - i) < 2) {
            return true;
        }
        this.f7822f = i;
        if (this.f7826j) {
            m7517a(this.f7822f / (height - this.f7820d));
        }
        return true;
    }

    /* renamed from: a */
    boolean m7528a(float f, float f2) {
        return f > ((float) (this.f7825i.getWidth() - this.f7821e)) && f2 >= ((float) this.f7822f) && f2 <= ((float) (this.f7822f + this.f7820d));
    }
}
