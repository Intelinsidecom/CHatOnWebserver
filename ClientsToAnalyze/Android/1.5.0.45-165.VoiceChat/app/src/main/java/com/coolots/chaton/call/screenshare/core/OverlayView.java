package com.coolots.chaton.call.screenshare.core;

import android.app.Service;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.sds.coolots.common.util.Log;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public abstract class OverlayView extends RelativeLayout {
    private static final String CLASSNAME = "[OverlayView]";
    public static final int MOVE_EDGE_VALUE = 10;
    public static final int SCREEN_DOCS_MODE = 3;
    public static final int SCREEN_DOCS_MODE_START = 2;
    public static final int SCREEN_DOCS_PEN_MODE = 4;
    public static final int SCREEN_SHARE_EXTERNAL_PAUSE_MODE = 2;
    public static final int SCREEN_SHARE_MODE = 0;
    public static final int SCREEN_SHARE_NOT_VIEW_MODE_MVOE = 2;
    public static final int SCREEN_SHARE_PAUSE_MODE = 1;
    public static final int SCREEN_SHARE_PEN_MODE = 1;
    public static final int SCREEN_SHARE_RUN_MODE = 0;
    public static final int SCREEN_SHARE_VIEW_MODE_MOVE = 1;
    private LayoutInflater inflater;
    private boolean inside;
    protected WindowManager.LayoutParams layoutParams;
    protected int mLayoutResId;
    public Point mMenuPoint;
    protected OnSendCommandData mOnSendCommandData;
    public boolean mShow;
    protected int mUserId;
    private WindowManager windowManager;

    public interface OnSendCommandData {
        void onSendData(int i, byte[] bArr);
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public OverlayView(Service service, int layoutResId) {
        super(service);
        this.inside = false;
        this.mMenuPoint = new Point(0, 0);
        this.inflater = null;
        this.windowManager = null;
        this.mLayoutResId = layoutResId;
    }

    public OverlayView(Context context, int layoutResId) {
        super(context);
        this.inside = false;
        this.mMenuPoint = new Point(0, 0);
        this.inflater = null;
        this.windowManager = null;
        this.mLayoutResId = layoutResId;
    }

    public void SetOnSendCommandData(OnSendCommandData onSendCmd) {
        this.mOnSendCommandData = onSendCmd;
    }

    public Service getService() {
        return (Service) getContext();
    }

    @Override // android.widget.RelativeLayout
    public int getGravity() {
        return 17;
    }

    protected void setupLayoutParams() {
        this.layoutParams = new WindowManager.LayoutParams(-2, -2, 2021, 262440, -3);
        this.layoutParams.gravity = getGravity();
    }

    protected void inflateView() {
        if (this.inflater == null) {
            this.inflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        }
        this.inflater.inflate(this.mLayoutResId, this);
        onInflateView();
    }

    protected void onInflateView() {
    }

    public boolean isVisible() {
        return true;
    }

    protected void reloadLayout() {
        unload();
        load();
    }

    public void refreshLayout() {
        removeAllViews();
        inflateView();
        refresh();
    }

    protected void addView() {
        setupLayoutParams();
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) getContext().getSystemService("window");
        }
        this.windowManager.addView(this, this.layoutParams);
    }

    protected void load() {
        inflateView();
        addView();
        refresh();
    }

    protected void unload() {
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) getContext().getSystemService("window");
        }
        this.windowManager.removeView(this);
        removeAllViews();
    }

    public void destory() {
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) getContext().getSystemService("window");
        }
        this.windowManager.removeView(this);
    }

    public void setPosition(Point point) {
        this.mMenuPoint = point;
        this.layoutParams.x = this.mMenuPoint.x;
        this.layoutParams.y = this.mMenuPoint.y;
        logI("setPosition x: " + this.mMenuPoint.x + "  mMenuPoint.y: " + this.mMenuPoint.y);
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) getContext().getSystemService("window");
        }
        this.windowManager.updateViewLayout(this, this.layoutParams);
    }

    public void moveView(int x, int y) {
        try {
            this.layoutParams.x = x;
            this.layoutParams.y = y;
            if (this.windowManager == null) {
                this.windowManager = (WindowManager) getContext().getSystemService("window");
            }
            this.windowManager.updateViewLayout(this, this.layoutParams);
        } catch (Exception ex) {
            logE("moveView exception:  " + ex);
        }
    }

    public void moveView2(int incx, int incy, int type) {
        try {
            int[] nextPos = {this.layoutParams.x + incx, this.layoutParams.y + incy};
            if (nextPos[0] < 0) {
                nextPos[0] = 0;
            }
            if (nextPos[1] < 0) {
                nextPos[1] = 0;
            }
            Point screenSize = getScreenSize();
            if (nextPos[0] > screenSize.x - getWidth()) {
                nextPos[0] = screenSize.x - getWidth();
            }
            if (nextPos[1] > screenSize.y - getHeight()) {
                nextPos[1] = screenSize.y - getHeight();
            }
            this.layoutParams.x = nextPos[0];
            this.layoutParams.y = nextPos[1];
            if (type == 1) {
                this.mMenuPoint.x = this.layoutParams.x;
                this.mMenuPoint.y = this.layoutParams.y;
            }
            if (this.windowManager == null) {
                this.windowManager = (WindowManager) getContext().getSystemService("window");
            }
            this.windowManager.updateViewLayout(this, this.layoutParams);
        } catch (Exception e) {
            Log.m2958e("exception" + e);
        }
    }

    public void moveBtnEdge(int tgtX) {
        int srcX = this.layoutParams.x;
        Handler mhandler = new Handler() { // from class: com.coolots.chaton.call.screenshare.core.OverlayView.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                OverlayView.this.layoutParams.x = msg.getData().getInt("next");
                if (OverlayView.this.windowManager == null) {
                    OverlayView.this.windowManager = (WindowManager) OverlayView.this.getContext().getSystemService("window");
                }
                OverlayView.this.windowManager.updateViewLayout((View) msg.obj, OverlayView.this.layoutParams);
            }
        };
        moveTimer mt = new moveTimer(this, srcX, tgtX, 200, mhandler);
        mt.start();
    }

    public void sizeView(int w, int h) {
        try {
            this.layoutParams.width = w;
            this.layoutParams.height = h;
            if (this.windowManager == null) {
                this.windowManager = (WindowManager) getContext().getSystemService("window");
            }
            this.windowManager.updateViewLayout(this, this.layoutParams);
        } catch (Exception e) {
            Log.m2958e("exception" + e);
        }
    }

    public void refresh() {
        if (!isVisible()) {
            setVisibility(8);
        } else {
            setVisibility(0);
            refreshViews();
        }
    }

    protected void refreshViews() {
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
    }

    public boolean isInside(View view, int x, int y) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return x >= location[0] && x <= location[0] + view.getWidth() && y >= location[1] && y <= location[1] + view.getHeight();
    }

    protected void onTouchEvent_Up(MotionEvent event, boolean inside) {
    }

    protected void onTouchEvent_Move(MotionEvent event, boolean inside) {
    }

    protected void onTouchEvent_PressInactive(MotionEvent event) {
    }

    protected void onTouchEvent_PressActive(MotionEvent event, boolean inside) {
    }

    protected void onTouchEvent_PressOutside(MotionEvent event) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == 4) {
            if (isInside(this, (int) event.getRawX(), (int) event.getRawY())) {
                onTouchEvent_PressInactive(event);
            } else {
                logI("onTouchEvent_PressOutside");
                onTouchEvent_PressOutside(event);
            }
        } else if (event.getActionMasked() == 0) {
            if (isInside(this, (int) event.getRawX(), (int) event.getRawY())) {
                this.inside = true;
            } else {
                this.inside = false;
            }
            onTouchEvent_PressActive(event, this.inside);
        } else if (event.getActionMasked() == 1) {
            onTouchEvent_Up(event, this.inside);
        } else if (event.getActionMasked() == 2) {
            onTouchEvent_Move(event, this.inside);
        }
        return super.onTouchEvent(event);
    }

    public void show() {
        this.mShow = true;
        setEnabled(this.mShow);
        setVisibility(0);
    }

    public void dismiss() {
        this.mShow = false;
        setEnabled(this.mShow);
        setVisibility(8);
    }

    public class moveTimer extends Timer {
        private int cnt;
        private int incPos;
        private boolean isLeft;
        private Handler mhandler;
        private int spare;
        private int srcPos;
        private int tgtPos;
        private View tgtView;
        private int time;
        private boolean timerStop;

        /* renamed from: tt */
        private TimerTask f5tt;

        public moveTimer() {
            this.time = 500;
            this.cnt = 10;
            this.srcPos = 0;
            this.incPos = 0;
            this.tgtPos = 0;
            this.spare = 0;
            this.timerStop = false;
            this.isLeft = false;
        }

        public moveTimer(View view, int curX, int lastX, int time, Handler handler) {
            this.time = 500;
            this.cnt = 10;
            this.srcPos = 0;
            this.incPos = 0;
            this.tgtPos = 0;
            this.spare = 0;
            this.timerStop = false;
            this.isLeft = false;
            this.time = time;
            this.srcPos = curX;
            this.tgtPos = lastX;
            this.tgtView = view;
            this.mhandler = handler;
            this.incPos = (this.tgtPos - this.srcPos) / this.cnt;
            this.spare = (this.tgtPos - this.srcPos) - (this.incPos * this.cnt);
            if (curX > lastX) {
                this.isLeft = true;
            }
            this.f5tt = new TimerTask() { // from class: com.coolots.chaton.call.screenshare.core.OverlayView.moveTimer.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    int next = OverlayView.this.layoutParams.x + moveTimer.this.incPos;
                    if ((moveTimer.this.isLeft && moveTimer.this.spare + next < 0) || (!moveTimer.this.isLeft && moveTimer.this.spare + next > moveTimer.this.tgtPos)) {
                        next = moveTimer.this.tgtPos;
                        moveTimer.this.timerStop = true;
                        OverlayView.this.logI("End!!!! next Pos X= " + next + "Target Pos X= " + moveTimer.this.tgtPos + " increment=" + moveTimer.this.incPos + " spare=" + moveTimer.this.spare);
                    }
                    Message msg = moveTimer.this.mhandler.obtainMessage();
                    Bundle b = new Bundle();
                    b.putInt("next", next);
                    b.putInt("target", moveTimer.this.tgtPos);
                    msg.setData(b);
                    msg.obj = moveTimer.this.tgtView;
                    moveTimer.this.mhandler.sendMessage(msg);
                    if (moveTimer.this.timerStop) {
                        cancel();
                    }
                }
            };
        }

        public void start() {
            int interval = this.time / this.cnt;
            schedule(this.f5tt, new Date(), interval);
        }
    }

    private Point getScreenSize() {
        Point size = new Point();
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) getContext().getSystemService("window");
        }
        Display screenSize = this.windowManager.getDefaultDisplay();
        screenSize.getSize(size);
        return size;
    }

    public void OnRecveData(int command, byte[] data) {
    }

    public void dismissMenu(boolean show) {
    }
}
