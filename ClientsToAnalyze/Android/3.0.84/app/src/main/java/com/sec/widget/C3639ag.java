package com.sec.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.sec.chaton.R;

/* compiled from: FastScrollableListView.java */
/* renamed from: com.sec.widget.ag */
/* loaded from: classes.dex */
class C3639ag {

    /* renamed from: a */
    private static int f13493a = 4;

    /* renamed from: b */
    private Drawable f13494b;

    /* renamed from: c */
    private Drawable f13495c;

    /* renamed from: d */
    private int f13496d;

    /* renamed from: e */
    private int f13497e;

    /* renamed from: f */
    private int f13498f;

    /* renamed from: g */
    private RectF f13499g;

    /* renamed from: h */
    private int f13500h;

    /* renamed from: i */
    private AbsListView f13501i;

    /* renamed from: j */
    private boolean f13502j;

    /* renamed from: k */
    private int f13503k;

    /* renamed from: l */
    private Paint f13504l;

    /* renamed from: m */
    private int f13505m;

    /* renamed from: o */
    private boolean f13507o;

    /* renamed from: p */
    private Object[] f13508p;

    /* renamed from: q */
    private String f13509q;

    /* renamed from: r */
    private boolean f13510r;

    /* renamed from: s */
    private RunnableC3640ah f13511s;

    /* renamed from: t */
    private int f13512t;

    /* renamed from: v */
    private BaseAdapter f13514v;

    /* renamed from: w */
    private SectionIndexer f13515w;

    /* renamed from: x */
    private boolean f13516x;

    /* renamed from: n */
    private int f13506n = -1;

    /* renamed from: u */
    private Handler f13513u = new Handler();

    public C3639ag(Context context, AbsListView absListView) {
        this.f13501i = absListView;
        m13193a(context);
    }

    /* renamed from: a */
    public void m13199a(int i) {
        switch (i) {
            case 0:
                this.f13513u.removeCallbacks(this.f13511s);
                this.f13501i.invalidate();
                break;
            case 2:
                if (this.f13512t != 2) {
                    m13195d();
                }
            case 3:
                this.f13513u.removeCallbacks(this.f13511s);
                break;
            case 4:
                int width = this.f13501i.getWidth();
                this.f13501i.invalidate(width - this.f13497e, this.f13498f, width, this.f13498f + this.f13496d);
                break;
        }
        this.f13512t = i;
    }

    /* renamed from: a */
    public int m13198a() {
        return this.f13512t;
    }

    /* renamed from: d */
    private void m13195d() {
        if (this.f13501i != null) {
            int width = this.f13501i.getWidth();
            this.f13494b.setBounds(width - this.f13497e, 0, width, this.f13496d);
        }
    }

    /* renamed from: a */
    private void m13194a(Context context, Drawable drawable) {
        this.f13494b = drawable;
        this.f13497e = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_width);
        this.f13496d = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_height);
        this.f13516x = true;
    }

    /* renamed from: a */
    private void m13193a(Context context) {
        Resources resources = context.getResources();
        m13194a(context, resources.getDrawable(R.drawable.fastscrollbar_handle_accelerated_anim2));
        this.f13495c = resources.getDrawable(R.drawable.fastscrollbar_handle_accelerated_anim2);
        this.f13502j = true;
        m13196e();
        this.f13500h = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_overlay_size);
        this.f13499g = new RectF();
        this.f13511s = new RunnableC3640ah(this);
        this.f13504l = new Paint();
        this.f13504l.setAntiAlias(true);
        this.f13504l.setTextAlign(Paint.Align.CENTER);
        this.f13504l.setTextSize(this.f13500h / 2);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.textColorPrimary});
        this.f13504l.setColor(typedArrayObtainStyledAttributes.getColorStateList(typedArrayObtainStyledAttributes.getIndex(0)).getDefaultColor());
        this.f13504l.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f13512t = 0;
    }

    /* renamed from: b */
    void m13205b() {
        m13199a(0);
    }

    /* renamed from: c */
    boolean m13207c() {
        return this.f13512t != 0;
    }

    /* renamed from: a */
    public void m13201a(Canvas canvas) {
        if (this.f13512t != 0) {
            int i = this.f13498f;
            int width = this.f13501i.getWidth();
            RunnableC3640ah runnableC3640ah = this.f13511s;
            int iM13209b = -1;
            if (this.f13512t == 4) {
                iM13209b = runnableC3640ah.m13209b();
                if (iM13209b < 104) {
                }
                this.f13494b.setBounds(width - ((this.f13497e * iM13209b) / 208), 0, width, this.f13496d);
                this.f13516x = true;
            }
            canvas.translate(0.0f, i);
            this.f13494b.draw(canvas);
            canvas.translate(0.0f, -i);
            if (this.f13512t == 3 && this.f13510r) {
                this.f13495c.draw(canvas);
                Paint paint = this.f13504l;
                float fDescent = paint.descent();
                RectF rectF = this.f13499g;
                canvas.drawText(this.f13509q, ((int) (rectF.left + rectF.right)) / 2, ((((int) (rectF.top + rectF.bottom)) / 2) + (this.f13500h / 4)) - fDescent, paint);
                return;
            }
            if (this.f13512t == 4) {
                if (iM13209b == 0) {
                    m13199a(0);
                } else {
                    this.f13501i.invalidate(width - this.f13497e, i, width, this.f13496d + i);
                }
            }
        }
    }

    /* renamed from: a */
    void m13200a(int i, int i2, int i3, int i4) {
        if (this.f13494b != null) {
            this.f13494b.setBounds(i - this.f13497e, 0, i, this.f13496d);
        }
        RectF rectF = this.f13499g;
        rectF.left = (i - this.f13500h) / 2;
        rectF.right = rectF.left + this.f13500h;
        rectF.top = i2 / 10;
        rectF.bottom = rectF.top + this.f13500h;
        if (this.f13495c != null) {
            this.f13495c.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }
    }

    /* renamed from: a */
    void m13202a(AbsListView absListView, int i, int i2, int i3) {
        if (this.f13506n != i3 && i2 > 0) {
            this.f13506n = i3;
            this.f13507o = this.f13506n / i2 >= f13493a;
        }
        if (!this.f13507o) {
            if (this.f13512t != 0) {
                m13199a(0);
                return;
            }
            return;
        }
        if (i3 - i2 > 0 && this.f13512t != 3) {
            this.f13498f = ((this.f13501i.getHeight() - this.f13496d) * i) / (i3 - i2);
            if (this.f13516x) {
                m13195d();
                this.f13516x = false;
            }
        }
        this.f13502j = true;
        if (i != this.f13503k) {
            this.f13503k = i;
            if (this.f13512t != 3) {
                m13199a(2);
                this.f13513u.postDelayed(this.f13511s, 1500L);
            }
        }
    }

    /* renamed from: e */
    private void m13196e() {
        Object adapter = this.f13501i.getAdapter();
        this.f13515w = null;
        if (adapter instanceof HeaderViewListAdapter) {
            this.f13505m = ((HeaderViewListAdapter) adapter).getHeadersCount();
            adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
        }
        if (adapter instanceof SectionIndexer) {
            this.f13514v = (BaseAdapter) adapter;
            this.f13515w = (SectionIndexer) adapter;
            this.f13508p = this.f13515w.getSections();
        } else {
            this.f13514v = (BaseAdapter) adapter;
            this.f13508p = new String[]{" "};
        }
    }

    /* renamed from: a */
    private void m13192a(float f) {
        int i;
        int i2;
        int count = this.f13501i.getCount();
        this.f13502j = false;
        float f2 = (1.0f / count) / 8.0f;
        Object[] objArr = this.f13508p;
        if (objArr != null && objArr.length > 1) {
            int length = objArr.length;
            int i3 = (int) (length * f);
            if (i3 >= length) {
                i3 = length - 1;
            }
            int positionForSection = this.f13515w.getPositionForSection(i3);
            int i4 = i3 + 1;
            int positionForSection2 = i3 < length + (-1) ? this.f13515w.getPositionForSection(i3 + 1) : count;
            if (positionForSection2 == positionForSection) {
                int i5 = positionForSection;
                int i6 = i3;
                while (true) {
                    if (i6 <= 0) {
                        positionForSection = i5;
                        i = i3;
                        i2 = i3;
                        break;
                    }
                    i2 = i6 - 1;
                    int positionForSection3 = this.f13515w.getPositionForSection(i2);
                    if (positionForSection3 != positionForSection) {
                        positionForSection = positionForSection3;
                        i = i2;
                        break;
                    } else {
                        if (i2 == 0) {
                            positionForSection = positionForSection3;
                            i = 0;
                            i2 = i3;
                            break;
                        }
                        i6 = i2;
                        i5 = positionForSection3;
                    }
                }
            } else {
                i2 = i3;
                i = i3;
            }
            int i7 = i4 + 1;
            while (i7 < length && this.f13515w.getPositionForSection(i7) == positionForSection2) {
                i7++;
                i4++;
            }
            float f3 = i2 / length;
            int i8 = (i2 != i3 || f - f3 >= f2) ? ((int) (((positionForSection2 - positionForSection) * (f - f3)) / ((i4 / length) - f3))) + positionForSection : positionForSection;
            int i9 = i8 > count + (-1) ? count - 1 : i8;
            if (this.f13501i instanceof ExpandableListView) {
                ExpandableListView expandableListView = (ExpandableListView) this.f13501i;
                expandableListView.setSelectionFromTop(expandableListView.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i9 + this.f13505m)), 0);
            } else if (this.f13501i instanceof ListView) {
                ((ListView) this.f13501i).setSelectionFromTop(i9 + this.f13505m, 0);
            } else {
                this.f13501i.setSelection(i9 + this.f13505m);
            }
        } else {
            int i10 = (int) (count * f);
            if (this.f13501i instanceof ExpandableListView) {
                ExpandableListView expandableListView2 = (ExpandableListView) this.f13501i;
                expandableListView2.setSelectionFromTop(expandableListView2.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i10 + this.f13505m)), 0);
            } else if (this.f13501i instanceof ListView) {
                ((ListView) this.f13501i).setSelectionFromTop(i10 + this.f13505m, 0);
            } else {
                this.f13501i.setSelection(i10 + this.f13505m);
            }
            i = -1;
        }
        if (i >= 0) {
            String string = objArr[i].toString();
            this.f13509q = string;
            this.f13510r = !(string.length() == 1 && string.charAt(0) == ' ') && i < objArr.length;
            return;
        }
        this.f13510r = false;
    }

    /* renamed from: f */
    private void m13197f() {
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
        this.f13501i.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* renamed from: a */
    boolean m13204a(MotionEvent motionEvent) {
        if (this.f13512t <= 0 || motionEvent.getAction() != 0 || !m13203a(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        m13199a(3);
        return true;
    }

    /* renamed from: b */
    boolean m13206b(MotionEvent motionEvent) {
        int i = 0;
        if (this.f13512t == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!m13203a(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
            m13199a(3);
            if (this.f13514v == null && this.f13501i != null) {
                m13196e();
            }
            if (this.f13501i != null) {
                this.f13501i.requestDisallowInterceptTouchEvent(true);
            }
            m13197f();
            return true;
        }
        if (action == 1) {
            if (this.f13512t != 3) {
                return false;
            }
            if (this.f13501i != null) {
                this.f13501i.requestDisallowInterceptTouchEvent(false);
            }
            m13199a(2);
            Handler handler = this.f13513u;
            handler.removeCallbacks(this.f13511s);
            handler.postDelayed(this.f13511s, 1000L);
            return true;
        }
        if (action != 2 || this.f13512t != 3) {
            return false;
        }
        int height = this.f13501i.getHeight();
        int y = (((int) motionEvent.getY()) - this.f13496d) + 10;
        if (y >= 0) {
            i = this.f13496d + y > height ? height - this.f13496d : y;
        }
        if (Math.abs(this.f13498f - i) < 2) {
            return true;
        }
        this.f13498f = i;
        if (this.f13502j) {
            m13192a(this.f13498f / (height - this.f13496d));
        }
        return true;
    }

    /* renamed from: a */
    boolean m13203a(float f, float f2) {
        return f > ((float) (this.f13501i.getWidth() - this.f13497e)) && f2 >= ((float) this.f13498f) && f2 <= ((float) (this.f13498f + this.f13496d));
    }
}
