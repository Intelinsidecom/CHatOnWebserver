package android.support.v4.widget;

import android.content.Context;
import android.os.Build;
import android.widget.Scroller;

/* loaded from: classes.dex */
class ScrollerCompat {
    Scroller mScroller;

    class ScrollerCompatImplIcs extends ScrollerCompat {
        public ScrollerCompatImplIcs(Context context) {
            super(context);
        }

        @Override // android.support.v4.widget.ScrollerCompat
        public float getCurrVelocity() {
            return ScrollerCompatIcs.getCurrVelocity(this.mScroller);
        }
    }

    public static ScrollerCompat from(Context context) {
        return Build.VERSION.SDK_INT >= 14 ? new ScrollerCompatImplIcs(context) : new ScrollerCompat(context);
    }

    ScrollerCompat(Context context) {
        this.mScroller = new Scroller(context);
    }

    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    public int getDuration() {
        return this.mScroller.getDuration();
    }

    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    public float getCurrVelocity() {
        return 0.0f;
    }

    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        this.mScroller.startScroll(i, i2, i3, i4);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mScroller.startScroll(i, i2, i3, i4, i5);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.mScroller.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void abortAnimation() {
        this.mScroller.abortAnimation();
    }
}
