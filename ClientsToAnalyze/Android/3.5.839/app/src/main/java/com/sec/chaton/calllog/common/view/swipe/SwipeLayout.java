package com.sec.chaton.calllog.common.view.swipe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4904y;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public abstract class SwipeLayout extends FrameLayout implements GestureDetector.OnGestureListener {

    /* renamed from: a */
    private InterfaceC1447e f5147a;

    /* renamed from: b */
    private GestureDetector f5148b;

    /* renamed from: c */
    private boolean f5149c;

    /* renamed from: d */
    private boolean f5150d;

    /* renamed from: e */
    private int f5151e;

    /* renamed from: f */
    private final HandlerC1446d f5152f;

    /* renamed from: g */
    private final C1445c f5153g;

    /* renamed from: h */
    private int f5154h;

    /* renamed from: a */
    protected abstract void mo7556a(float f);

    /* renamed from: a */
    protected abstract void mo7558a(int i, int i2);

    /* renamed from: b */
    protected abstract void mo7559b(float f);

    /* renamed from: c */
    protected abstract void mo7561c(float f);

    /* renamed from: a */
    private void m7548a(String str) {
        C4904y.m18634a(str, "[SwipeLayout]");
    }

    public void setEnabledSwipe(boolean z) {
        this.f5149c = z;
        if (this.f5147a == null) {
            this.f5149c = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeLayout(Context context, InterfaceC1447e interfaceC1447e) {
        super(context);
        C1443a c1443a = null;
        this.f5149c = false;
        this.f5150d = false;
        this.f5151e = 0;
        this.f5152f = new HandlerC1446d(this);
        this.f5153g = new C1445c(this);
        this.f5154h = 0;
        this.f5147a = interfaceC1447e;
        this.f5148b = new GestureDetector(GlobalApplication.m18732r(), this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f5149c) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        this.f5148b.onTouchEvent(motionEvent);
        switch (action) {
            case 0:
                m7547a(motionEvent);
                return true;
            case 1:
                m7551b(motionEvent);
                return true;
            case 2:
                m7553c(x);
                return true;
            default:
                return true;
        }
    }

    /* renamed from: a */
    private void m7547a(MotionEvent motionEvent) {
        this.f5154h = (int) motionEvent.getX();
        this.f5151e = 1;
        this.f5152f.sendEmptyMessageDelayed(1, 100L);
        this.f5152f.sendEmptyMessageDelayed(3, 1000L);
        if (this.f5147a != null) {
            this.f5147a.mo7543a(this.f5153g);
        }
    }

    /* renamed from: c */
    private void m7553c(int i) {
        if (this.f5151e == 2) {
            if (this.f5154h < i) {
                mo7558a(0, i - this.f5154h);
                return;
            } else {
                if (this.f5150d) {
                    mo7558a(1, i - this.f5154h);
                    return;
                }
                return;
            }
        }
        if (Math.abs(i - this.f5154h) >= 50 && this.f5154h < i) {
            m7550b();
            this.f5151e = 2;
        }
    }

    /* renamed from: b */
    private void m7551b(MotionEvent motionEvent) {
        switch (this.f5151e) {
            case 1:
                if (this.f5147a != null) {
                    this.f5147a.onClick(this);
                }
                this.f5152f.sendEmptyMessageDelayed(2, 100L);
                break;
            case 2:
                m7548a("<<YHT>>DETECT ERROR CASE !!!!!!");
                m7554d((int) motionEvent.getX());
                break;
            default:
                if (((int) motionEvent.getX()) - this.f5154h < 0) {
                    m7554d((int) motionEvent.getX());
                    break;
                }
                break;
        }
        this.f5151e = 0;
    }

    /* renamed from: d */
    private void m7554d(int i) {
        this.f5151e = 0;
        m7550b();
        mo7561c(i - this.f5154h);
    }

    /* renamed from: a */
    protected void mo7557a(int i) {
        if (this.f5147a != null) {
            this.f5147a.mo7543a((InterfaceC1444b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7546a() {
        setPressed(false);
        setBackgroundColor(0);
        this.f5151e = 0;
        if (this.f5147a != null) {
            this.f5147a.mo7541a(this);
        }
    }

    /* renamed from: b */
    private void m7550b() {
        this.f5152f.removeMessages(1);
        setPressed(false);
        setBackgroundColor(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m7560b(int i) {
        if (this.f5147a != null) {
            this.f5147a.mo7542a(this, i);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0098  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0098 -> B:23:0x006a). Please report as a decompilation issue!!! */
    @Override // android.view.GestureDetector.OnGestureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onFling(android.view.MotionEvent r8, android.view.MotionEvent r9, float r10, float r11) {
        /*
            r7 = this;
            r6 = 1125515264(0x43160000, float:150.0)
            r5 = 1092616192(0x41200000, float:10.0)
            r4 = 0
            r3 = 1
            java.lang.String r0 = "<<YHT>>onFling !!!!!!"
            r7.m7548a(r0)
            float r0 = r9.getX()
            float r1 = r8.getX()
            float r0 = r0 - r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L97
            r1.<init>()     // Catch: java.lang.Exception -> L97
            java.lang.String r2 = "Distance:"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> L97
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch: java.lang.Exception -> L97
            java.lang.String r1 = ", Velocity:"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L97
            float r1 = java.lang.Math.abs(r10)     // Catch: java.lang.Exception -> L97
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L97
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L97
            r7.m7548a(r0)     // Catch: java.lang.Exception -> L97
            float r0 = r8.getX()     // Catch: java.lang.Exception -> L97
            float r1 = r9.getX()     // Catch: java.lang.Exception -> L97
            float r0 = r0 - r1
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L6b
            float r0 = java.lang.Math.abs(r10)     // Catch: java.lang.Exception -> L97
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L6b
            r0 = 0
            r7.f5151e = r0     // Catch: java.lang.Exception -> L97
            r7.m7550b()     // Catch: java.lang.Exception -> L97
            boolean r0 = r7.f5150d     // Catch: java.lang.Exception -> L97
            if (r0 == 0) goto L6a
            com.sec.chaton.calllog.common.view.swipe.e r0 = r7.f5147a     // Catch: java.lang.Exception -> L97
            if (r0 == 0) goto L6a
            float r0 = r8.getX()     // Catch: java.lang.Exception -> L97
            float r1 = r9.getX()     // Catch: java.lang.Exception -> L97
            float r0 = r0 - r1
            r7.mo7556a(r0)     // Catch: java.lang.Exception -> L97
        L6a:
            return r3
        L6b:
            float r0 = r9.getX()     // Catch: java.lang.Exception -> L97
            float r1 = r8.getX()     // Catch: java.lang.Exception -> L97
            float r0 = r0 - r1
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L98
            float r0 = java.lang.Math.abs(r10)     // Catch: java.lang.Exception -> L97
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L98
            r0 = 0
            r7.f5151e = r0     // Catch: java.lang.Exception -> L97
            r7.m7550b()     // Catch: java.lang.Exception -> L97
            com.sec.chaton.calllog.common.view.swipe.e r0 = r7.f5147a     // Catch: java.lang.Exception -> L97
            if (r0 == 0) goto L98
            float r0 = r9.getX()     // Catch: java.lang.Exception -> L97
            float r1 = r8.getX()     // Catch: java.lang.Exception -> L97
            float r0 = r0 - r1
            r7.mo7559b(r0)     // Catch: java.lang.Exception -> L97
            goto L6a
        L97:
            r0 = move-exception
        L98:
            r7.f5151e = r4
            r7.m7550b()
            float r0 = r9.getX()
            float r1 = r8.getX()
            float r0 = r0 - r1
            r7.mo7561c(r0)
            goto L6a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.calllog.common.view.swipe.SwipeLayout.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        Toast.makeText(getContext(), getResources().getString(R.string.swipe_longpress), 0);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        Toast.makeText(getContext(), getResources().getString(R.string.swipe_scroll), 0);
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        Toast.makeText(getContext(), getResources().getString(R.string.swipe_showpress), 0);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Toast.makeText(getContext(), getResources().getString(R.string.swipe_singletapup), 0);
        return false;
    }
}
