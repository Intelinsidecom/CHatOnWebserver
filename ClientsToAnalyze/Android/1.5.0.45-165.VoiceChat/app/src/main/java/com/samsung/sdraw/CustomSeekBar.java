package com.samsung.sdraw;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.MotionEvent;
import android.widget.SeekBar;

/* loaded from: classes.dex */
public class CustomSeekBar extends SeekBar {

    /* renamed from: a */
    protected int f1040a;

    /* renamed from: b */
    private C1044cc f1041b;

    /* renamed from: c */
    private boolean f1042c;

    /* renamed from: d */
    private int f1043d;

    public CustomSeekBar(Context context) {
        super(context);
        this.f1040a = 160;
        this.f1042c = false;
        this.f1043d = 1009;
        this.f1040a = context.getResources().getDisplayMetrics().densityDpi;
        osVerGB();
    }

    public void setPenSettingViewHolder(C1044cc viewHolder) {
        this.f1041b = viewHolder;
    }

    public void osVerGB() {
        if (Build.VERSION.RELEASE.startsWith("2.3")) {
            this.f1042c = true;
        } else {
            this.f1042c = false;
        }
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (!this.f1042c) {
            int action = event.getAction();
            if (action == 0) {
                if (this.f1041b != null) {
                    if (this.f1041b instanceof C0998ak) {
                        if (this.f1040a == 213) {
                            setThumb(this.f1041b.m1531c("/eraser_handel_press.png"));
                        } else {
                            setThumb(this.f1041b.m1527b("/snote_slider_circle_press.png"));
                        }
                    } else if (this.f1040a == 240) {
                        setThumb(this.f1041b.m1527b("/snote_slider_circle_press.png"));
                    } else if (this.f1040a == 480) {
                        setThumb(this.f1041b.m1527b("/eraser_handel_press_480.png"));
                    } else {
                        setThumb(this.f1041b.m1527b("/eraser_handel_press.png"));
                    }
                }
            } else if ((action == 3 || action == 1) && this.f1041b != null) {
                if (this.f1041b instanceof C0998ak) {
                    if (this.f1040a == 213) {
                        setThumb(this.f1041b.m1531c("/eraser_handel.png"));
                    } else {
                        setThumb(this.f1041b.m1527b("/snote_slider_circle.png"));
                    }
                } else if (this.f1040a == 240) {
                    setThumb(this.f1041b.m1527b("/snote_slider_circle.png"));
                } else if (this.f1040a == 480) {
                    setThumb(this.f1041b.m1527b("/eraser_handel_480.png"));
                } else {
                    setThumb(this.f1041b.m1527b("/eraser_handel.png"));
                }
            }
        }
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        if (!this.f1042c && this.f1041b != null) {
            if (this.f1043d == 1009) {
                setThumb(((C0999al) this.f1041b).f1457H);
            } else if (this.f1043d == 1010) {
                setThumb(((C0999al) this.f1041b).f1456G);
            } else if (this.f1043d == 2009) {
                setThumb(((C1061q) this.f1041b).f1763j);
            }
        }
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }

    public void setSeekbarId(int seekBarId) {
        this.f1043d = seekBarId;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent arg0) {
        super.onHoverEvent(arg0);
        return true;
    }
}
