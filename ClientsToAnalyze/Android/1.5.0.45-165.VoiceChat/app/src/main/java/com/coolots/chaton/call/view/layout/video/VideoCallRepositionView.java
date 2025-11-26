package com.coolots.chaton.call.view.layout.video;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.view.VideoCallActivity;
import com.coolots.chaton.common.util.ModelInfomation;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class VideoCallRepositionView extends View implements DisposeInterface {
    private boolean mChangePreviewMode;
    private Drawable mDrawable;
    private int mDrawableH;
    private int mDrawableW;
    private int mEventStatus;
    private final GestureDetector mGestureDetector;
    private final GestureDetector.OnGestureListener mGestureListener;
    private int mHWGap;
    private Point mImgLoc;
    private int mLandFullWidth;
    private int mPreViewDownMargin;
    private int mPreviewPosX;
    private int mPreviewPosY;
    private int mPrieViewTopMargin;
    private int mScreenWidth;
    private VideoCallActivity mVideoCallActivity;
    private Point mouseMargin;
    private int moveX;
    private int moveY;
    private boolean toImage;

    public VideoCallRepositionView(Context context) {
        super(context);
        this.moveX = 0;
        this.moveY = 0;
        this.toImage = false;
        this.mEventStatus = -1;
        this.mChangePreviewMode = false;
        this.mLandFullWidth = 894;
        this.mHWGap = 40;
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallRepositionView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent arg0) {
                if (!VideoCallRepositionView.this.toImage) {
                    VideoCallRepositionView.this.mVideoCallActivity.setRepositionVisiblity();
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent event) {
                int posx = (int) event.getX();
                int posy = (int) event.getY();
                VideoCallRepositionView.this.mVideoCallActivity.setSelectedViewMenu(posx, posy);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent arg0) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent arg0) {
                return false;
            }
        };
        setFocusable(true);
        Resources res = context.getResources();
        this.mImgLoc = new Point(0, 0);
        this.mouseMargin = new Point(0, 0);
        this.mDrawable = res.getDrawable(C0000R.drawable.myvideo_outline);
        if (getResources().getConfiguration().orientation == 1) {
            this.mDrawableW = this.mDrawable.getIntrinsicWidth();
            this.mDrawableH = this.mDrawable.getIntrinsicHeight();
        } else {
            this.mDrawableW = this.mDrawable.getIntrinsicHeight();
            this.mDrawableH = this.mDrawable.getIntrinsicWidth();
        }
        this.mGestureDetector = new GestureDetector(context, this.mGestureListener);
        this.mScreenWidth = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();
    }

    public VideoCallRepositionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.moveX = 0;
        this.moveY = 0;
        this.toImage = false;
        this.mEventStatus = -1;
        this.mChangePreviewMode = false;
        this.mLandFullWidth = 894;
        this.mHWGap = 40;
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallRepositionView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent arg0) {
                if (!VideoCallRepositionView.this.toImage) {
                    VideoCallRepositionView.this.mVideoCallActivity.setRepositionVisiblity();
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent event) {
                int posx = (int) event.getX();
                int posy = (int) event.getY();
                VideoCallRepositionView.this.mVideoCallActivity.setSelectedViewMenu(posx, posy);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent arg0) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent arg0) {
                return false;
            }
        };
        setFocusable(true);
        Resources res = context.getResources();
        this.mImgLoc = new Point(0, 0);
        this.mouseMargin = new Point(0, 0);
        this.mDrawable = res.getDrawable(C0000R.drawable.myvideo_outline);
        if (getResources().getConfiguration().orientation == 1) {
            this.mDrawableW = this.mDrawable.getIntrinsicWidth();
            this.mDrawableH = this.mDrawable.getIntrinsicHeight();
        } else {
            this.mDrawableW = this.mDrawable.getIntrinsicHeight();
            this.mDrawableH = this.mDrawable.getIntrinsicWidth();
        }
        this.mGestureDetector = new GestureDetector(context, this.mGestureListener);
        this.mScreenWidth = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.argb(0, 0, 0, 0));
        boolean isEventUp = false;
        this.mImgLoc.x = this.moveX;
        this.mImgLoc.y = this.moveY;
        if (this.mEventStatus == 2) {
            checkPreviewOutLine();
        }
        if (this.mEventStatus == 1 || this.mEventStatus == -1) {
            isEventUp = true;
            checkPreviewOutLine();
        }
        if (this.moveX > canvas.getWidth()) {
            this.moveX = 0 - this.mDrawableW;
        }
        if (this.moveY > canvas.getHeight()) {
            this.moveY = 0 - this.mDrawableH;
        }
        canvas.save();
        if (this.mVideoCallActivity != null) {
            this.mVideoCallActivity.changePreview(this.mImgLoc, isEventUp);
        }
    }

    private void checkPreviewOutLine() {
        if (this.mChangePreviewMode) {
            if (getResources().getConfiguration().orientation == 1) {
                if (this.moveX < this.mHWGap) {
                    Point point = this.mImgLoc;
                    int i = this.mHWGap;
                    this.moveX = i;
                    point.x = i;
                }
                if (this.moveX > this.mScreenWidth - (this.mDrawableW + this.mHWGap)) {
                    Point point2 = this.mImgLoc;
                    int i2 = this.mScreenWidth - (this.mDrawableW + this.mHWGap);
                    this.moveX = i2;
                    point2.x = i2;
                }
                if (this.moveY > this.mPreViewDownMargin + this.mHWGap) {
                    Point point3 = this.mImgLoc;
                    int i3 = this.mPreViewDownMargin + this.mHWGap;
                    this.moveY = i3;
                    point3.y = i3;
                }
                if (this.moveY < this.mPrieViewTopMargin - this.mHWGap) {
                    Point point4 = this.mImgLoc;
                    int i4 = this.mPrieViewTopMargin - this.mHWGap;
                    this.moveY = i4;
                    point4.y = i4;
                    return;
                }
                return;
            }
            if (this.moveX <= (-this.mHWGap)) {
                Point point5 = this.mImgLoc;
                int i5 = -this.mHWGap;
                this.moveX = i5;
                point5.x = i5;
            }
            if (this.moveX > this.mLandFullWidth - (this.mDrawableW - this.mHWGap)) {
                Point point6 = this.mImgLoc;
                int i6 = this.mLandFullWidth - (this.mDrawableW - this.mHWGap);
                this.moveX = i6;
                point6.x = i6;
            }
            if (this.moveY > this.mPreViewDownMargin - this.mHWGap) {
                Point point7 = this.mImgLoc;
                int i7 = this.mPreViewDownMargin - this.mHWGap;
                this.moveY = i7;
                point7.y = i7;
            }
            if (this.moveY < this.mPrieViewTopMargin + this.mHWGap) {
                Point point8 = this.mImgLoc;
                int i8 = this.mPrieViewTopMargin + this.mHWGap;
                this.moveY = i8;
                point8.y = i8;
                return;
            }
            return;
        }
        if (getResources().getConfiguration().orientation == 1) {
            if (this.moveX > this.mScreenWidth - this.mDrawableW) {
                Point point9 = this.mImgLoc;
                int i9 = this.mScreenWidth - this.mDrawableW;
                this.moveX = i9;
                point9.x = i9;
            }
        } else if (this.moveX > this.mLandFullWidth - this.mDrawableW) {
            Point point10 = this.mImgLoc;
            int i10 = this.mLandFullWidth - this.mDrawableW;
            this.moveX = i10;
            point10.x = i10;
        }
        if (this.moveX <= 0) {
            Point point11 = this.mImgLoc;
            this.moveX = 0;
            point11.x = 0;
        }
        if (this.moveY > this.mPreViewDownMargin) {
            Point point12 = this.mImgLoc;
            int i11 = this.mPreViewDownMargin;
            this.moveY = i11;
            point12.y = i11;
        }
        if (this.moveY < this.mPrieViewTopMargin) {
            Point point13 = this.mImgLoc;
            int i12 = this.mPrieViewTopMargin;
            this.moveY = i12;
            point13.y = i12;
        }
    }

    public void setParent(VideoCallActivity parent) {
        this.mVideoCallActivity = parent;
        this.mDrawable.setBounds(0, 0, this.mDrawableW + this.moveX, this.mDrawableH + this.moveY);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int keyAction = event.getAction();
        int posx = (int) event.getX();
        int posy = (int) event.getY();
        switch (keyAction) {
            case 0:
                this.mEventStatus = 0;
                checkImageMove(posx, posy);
                this.mouseMargin.x = posx - this.mImgLoc.x;
                this.mouseMargin.y = posy - this.mImgLoc.y;
                break;
            case 1:
                this.mEventStatus = 1;
                this.toImage = false;
                break;
            case 2:
                this.mEventStatus = 2;
                this.moveX = posx - this.mouseMargin.x;
                this.moveY = posy - this.mouseMargin.y;
                break;
        }
        invalidate();
        if (this.mGestureDetector != null) {
            this.mGestureDetector.onTouchEvent(event);
        }
        return true;
    }

    public void setDownEvent(MotionEvent event, Point point) {
        this.mImgLoc = point;
        int posx = (int) event.getX();
        int posy = (int) event.getY();
        this.mouseMargin.x = posx - this.mImgLoc.x;
        this.mouseMargin.y = posy - this.mImgLoc.y;
        this.moveX = posx - this.mouseMargin.x;
        this.moveY = posy - this.mouseMargin.y;
    }

    private void checkImageMove(int posx, int posy) {
        if (getResources().getConfiguration().orientation == 1) {
            if (posx > this.mImgLoc.x && posx < this.mImgLoc.x + this.mDrawableW && posy > this.mImgLoc.y && posy < this.mImgLoc.y + this.mDrawableH) {
                this.toImage = true;
                return;
            }
            return;
        }
        if (posx > this.mImgLoc.x && posx < this.mImgLoc.x + this.mDrawableH && posy > this.mImgLoc.y && posy < this.mImgLoc.y + this.mDrawableW) {
            this.toImage = true;
        }
    }

    public void setChangePointStatus(Point point, boolean changePreviewMode, int sWidth, int sHeight) {
        this.mImgLoc = point;
        this.mChangePreviewMode = changePreviewMode;
        this.mScreenWidth = sWidth;
    }

    public void setDeviceType(ModelInfomation modelCreator) {
        if (modelCreator != null) {
            if (getResources().getConfiguration().orientation == 1) {
                this.mDrawableH = modelCreator.getPreviewHeight();
                this.mDrawableW = modelCreator.getPreviewWidth();
                this.mHWGap = (this.mDrawableH - this.mDrawableW) / 2;
                this.mPreviewPosX = modelCreator.getPortPreviewX();
                this.mPreviewPosY = modelCreator.getPortPreviewY();
                this.mPrieViewTopMargin = modelCreator.getPortRepositonTopMargin();
                this.mPreViewDownMargin = modelCreator.getPortRepositionDownMargin();
                this.moveX = this.mPreviewPosX;
                this.moveY = this.mPreviewPosY;
                return;
            }
            this.mDrawableW = modelCreator.getLandPreviewHeight();
            this.mDrawableH = modelCreator.getLandPreviewWidth();
            this.mHWGap = (this.mDrawableW - this.mDrawableH) / 2;
            this.mPreviewPosX = modelCreator.getLandPreviewX();
            this.mPreviewPosY = modelCreator.getLandPreviewY();
            this.mPrieViewTopMargin = modelCreator.getLandRepositonTopMargin();
            this.mPreViewDownMargin = modelCreator.getLandRepositionDownMargin();
            this.mLandFullWidth = modelCreator.getLandFullHeight();
            this.moveX = this.mPreviewPosX;
            this.moveY = this.mPreviewPosY;
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
            this.mDrawable = null;
        }
    }
}
