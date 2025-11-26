package com.sec.chaton.calllog.common.view.swipe;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public abstract class SwipeLayout extends FrameLayout implements GestureDetector.OnGestureListener {

    /* renamed from: a */
    private InterfaceC0836e f3177a;

    /* renamed from: b */
    private GestureDetector f3178b;

    /* renamed from: c */
    private boolean f3179c;

    /* renamed from: d */
    private boolean f3180d;

    /* renamed from: e */
    private int f3181e;

    /* renamed from: f */
    private final HandlerC0835d f3182f;

    /* renamed from: g */
    private final C0834c f3183g;

    /* renamed from: h */
    private int f3184h;

    /* renamed from: a */
    protected abstract void mo4402a(float f);

    /* renamed from: a */
    protected abstract void mo4404a(int i, int i2);

    /* renamed from: b */
    protected abstract void mo4405b(float f);

    /* renamed from: c */
    protected abstract void mo4407c(float f);

    /* renamed from: a */
    private void m4394a(String str) {
        C3250y.m11442a(str, "[SwipeLayout]");
    }

    public void setEnabledSwipe(boolean z) {
        this.f3179c = z;
        if (this.f3177a == null) {
            this.f3179c = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeLayout(Context context, InterfaceC0836e interfaceC0836e) {
        super(context);
        C0832a c0832a = null;
        this.f3179c = false;
        this.f3180d = false;
        this.f3181e = 0;
        this.f3182f = new HandlerC0835d(this);
        this.f3183g = new C0834c(this);
        this.f3184h = 0;
        this.f3177a = interfaceC0836e;
        this.f3178b = new GestureDetector(GlobalApplication.m11493l(), this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f3179c) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        this.f3178b.onTouchEvent(motionEvent);
        switch (action) {
            case 0:
                m4393a(motionEvent);
                return true;
            case 1:
                m4397b(motionEvent);
                return true;
            case 2:
                m4399c(x);
                return true;
            default:
                return true;
        }
    }

    /* renamed from: a */
    private void m4393a(MotionEvent motionEvent) {
        this.f3184h = (int) motionEvent.getX();
        this.f3181e = 1;
        this.f3182f.sendEmptyMessageDelayed(1, 100L);
        this.f3182f.sendEmptyMessageDelayed(3, 1000L);
        if (this.f3177a != null) {
            this.f3177a.mo4389a(this.f3183g);
        }
    }

    /* renamed from: c */
    private void m4399c(int i) {
        if (this.f3181e == 2) {
            if (this.f3184h < i) {
                mo4404a(0, i - this.f3184h);
                return;
            } else {
                if (this.f3180d) {
                    mo4404a(1, i - this.f3184h);
                    return;
                }
                return;
            }
        }
        if (Math.abs(i - this.f3184h) >= 50 && this.f3184h < i) {
            m4396b();
            this.f3181e = 2;
        }
    }

    /* renamed from: b */
    private void m4397b(MotionEvent motionEvent) {
        switch (this.f3181e) {
            case 1:
                if (this.f3177a != null) {
                    this.f3177a.onClick(this);
                }
                this.f3182f.sendEmptyMessageDelayed(2, 100L);
                break;
            case 2:
                m4394a("<<YHT>>DETECT ERROR CASE !!!!!!");
                m4400d((int) motionEvent.getX());
                break;
            default:
                if (((int) motionEvent.getX()) - this.f3184h < 0) {
                    m4400d((int) motionEvent.getX());
                    break;
                }
                break;
        }
        this.f3181e = 0;
    }

    /* renamed from: d */
    private void m4400d(int i) {
        this.f3181e = 0;
        m4396b();
        mo4407c(i - this.f3184h);
    }

    /* renamed from: a */
    protected void mo4403a(int i) {
        if (this.f3177a != null) {
            this.f3177a.mo4389a((InterfaceC0833b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4392a() {
        setPressed(false);
        setBackgroundColor(0);
        this.f3181e = 0;
        if (this.f3177a != null) {
            this.f3177a.mo4387a(this);
        }
    }

    /* renamed from: b */
    private void m4396b() {
        this.f3182f.removeMessages(1);
        setPressed(false);
        setBackgroundColor(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m4406b(int i) {
        if (this.f3177a != null) {
            this.f3177a.mo4388a(this, i);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0095 -> B:23:0x0067). Please report as a decompilation issue!!! */
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
            r7.m4394a(r0)
            float r0 = r9.getX()
            float r1 = r8.getX()
            float r0 = r0 - r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L94
            r1.<init>()     // Catch: java.lang.Exception -> L94
            java.lang.String r2 = "Distance:"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> L94
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch: java.lang.Exception -> L94
            java.lang.String r1 = ", Velocity:"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L94
            float r1 = java.lang.Math.abs(r10)     // Catch: java.lang.Exception -> L94
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L94
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L94
            r7.m4394a(r0)     // Catch: java.lang.Exception -> L94
            float r0 = r8.getX()     // Catch: java.lang.Exception -> L94
            float r1 = r9.getX()     // Catch: java.lang.Exception -> L94
            float r0 = r0 - r1
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L68
            float r0 = java.lang.Math.abs(r10)     // Catch: java.lang.Exception -> L94
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L68
            r0 = 0
            r7.f3181e = r0     // Catch: java.lang.Exception -> L94
            r7.m4396b()     // Catch: java.lang.Exception -> L94
            boolean r0 = r7.f3180d     // Catch: java.lang.Exception -> L94
            if (r0 == 0) goto L67
            com.sec.chaton.calllog.common.view.swipe.e r0 = r7.f3177a     // Catch: java.lang.Exception -> L94
            if (r0 == 0) goto L67
            float r0 = r8.getX()     // Catch: java.lang.Exception -> L94
            float r1 = r9.getX()     // Catch: java.lang.Exception -> L94
            float r0 = r0 - r1
            r7.mo4402a(r0)     // Catch: java.lang.Exception -> L94
        L67:
            return r3
        L68:
            float r0 = r9.getX()     // Catch: java.lang.Exception -> L94
            float r1 = r8.getX()     // Catch: java.lang.Exception -> L94
            float r0 = r0 - r1
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L95
            float r0 = java.lang.Math.abs(r10)     // Catch: java.lang.Exception -> L94
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L95
            r0 = 0
            r7.f3181e = r0     // Catch: java.lang.Exception -> L94
            r7.m4396b()     // Catch: java.lang.Exception -> L94
            com.sec.chaton.calllog.common.view.swipe.e r0 = r7.f3177a     // Catch: java.lang.Exception -> L94
            if (r0 == 0) goto L95
            float r0 = r9.getX()     // Catch: java.lang.Exception -> L94
            float r1 = r8.getX()     // Catch: java.lang.Exception -> L94
            float r0 = r0 - r1
            r7.mo4405b(r0)     // Catch: java.lang.Exception -> L94
            goto L67
        L94:
            r0 = move-exception
        L95:
            r7.f3181e = r4
            r7.m4396b()
            float r0 = r9.getX()
            float r1 = r8.getX()
            float r0 = r0 - r1
            r7.mo4407c(r0)
            goto L67
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
