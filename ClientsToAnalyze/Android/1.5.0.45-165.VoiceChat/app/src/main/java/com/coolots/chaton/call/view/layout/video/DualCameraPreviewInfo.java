package com.coolots.chaton.call.view.layout.video;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.coolots.chaton.call.view.VideoCallActivity;

/* loaded from: classes.dex */
public class DualCameraPreviewInfo {
    private static final float MAX_LONG_PREVIEW__SIZE = 640.0f;
    private static final float MAX_SHORT_PREVIEW__SIZE = 480.0f;
    private static final int ORIENTATION_LANDSCAPE_270 = 270;
    private static final int ORIENTATION_LANDSCAPE_90 = 90;
    private VideoCallActivity mActivity;
    private int mHeight;
    private Point mPoint = new Point();
    private float mRatioX;
    private float mRatioY;
    private int mWidth;

    public DualCameraPreviewInfo(VideoCallActivity activity) {
        this.mActivity = activity;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Point getPoint() {
        return this.mPoint;
    }

    public void setPreViewInfoForStartCamera() {
        int angle = this.mActivity.getSavedOrientation();
        makeRtio(angle);
        initPreviewSize();
        if (this.mActivity.isAutoRotation()) {
            setPointAsAutoRotationForStartCamera(angle);
        } else {
            setPointAsNoneAutoForStartCamera(angle);
        }
    }

    public void setPreViewInfoForSwitchCamera() {
        int angle = this.mActivity.getSavedOrientation();
        makeRtio(angle);
        initPreviewSize();
        if (this.mActivity.isAutoRotation()) {
            setPointAsAutoRotationForSwitchCamera(angle);
        } else {
            setPointAsNoneAutoForSwitchCamera(angle);
        }
    }

    public void setPreViewInfoForDualPosition() {
        int angle = this.mActivity.getSavedOrientation();
        makeRtio(angle);
        initPreviewSize();
        if (this.mActivity.isAutoRotation()) {
            setPointAsAutoRotation(angle);
        } else {
            setPointAsNoneAuto(angle);
        }
    }

    private void setPointAsAutoRotationForStartCamera(int angle) {
        int preViewPadding = this.mActivity.getPreviewPaddingRight();
        if (this.mPoint == null) {
            this.mPoint = new Point();
        }
        switch (angle) {
            case ORIENTATION_LANDSCAPE_90 /* 90 */:
                this.mPoint.x = (480 - this.mWidth) - ((int) (preViewPadding / this.mRatioY));
                this.mPoint.y = (640 - this.mHeight) - ((int) (preViewPadding / this.mRatioX));
                break;
            case 270:
                this.mPoint.x = (int) (preViewPadding / this.mRatioY);
                this.mPoint.y = (int) (preViewPadding / this.mRatioX);
                break;
            default:
                this.mPoint.x = (int) (preViewPadding / this.mRatioX);
                this.mPoint.y = (int) (preViewPadding / this.mRatioY);
                break;
        }
    }

    private void setPointAsNoneAutoForStartCamera(int angle) {
        int preViewPadding = this.mActivity.getPreviewPaddingRight();
        if (this.mPoint == null) {
            this.mPoint = new Point();
        }
        switch (angle) {
            case ORIENTATION_LANDSCAPE_90 /* 90 */:
            case 270:
                this.mPoint.x = (int) (preViewPadding / this.mRatioY);
                this.mPoint.y = (int) (preViewPadding / this.mRatioX);
                break;
            default:
                this.mPoint.x = (int) (preViewPadding / this.mRatioX);
                this.mPoint.y = (int) (preViewPadding / this.mRatioY);
                break;
        }
    }

    private void setPointAsAutoRotation(int angle) {
        int preViewPadding = this.mActivity.getPreviewPaddingRight();
        if (this.mPoint == null) {
            this.mPoint = new Point();
        }
        switch (angle) {
            case ORIENTATION_LANDSCAPE_90 /* 90 */:
                if (this.mActivity.getCameraToggle() == 444) {
                    this.mPoint.x = (int) (preViewPadding / this.mRatioY);
                    this.mPoint.y = (int) (preViewPadding / this.mRatioX);
                    break;
                } else {
                    this.mPoint.x = (480 - this.mWidth) - ((int) (preViewPadding / this.mRatioY));
                    this.mPoint.y = (640 - this.mHeight) - ((int) (preViewPadding / this.mRatioX));
                    break;
                }
            case 270:
                if (this.mActivity.getCameraToggle() == 444) {
                    this.mPoint.x = (480 - this.mWidth) - ((int) (preViewPadding / this.mRatioY));
                    this.mPoint.y = (640 - this.mHeight) - ((int) (preViewPadding / this.mRatioX));
                    break;
                } else {
                    this.mPoint.x = (int) (preViewPadding / this.mRatioY);
                    this.mPoint.y = (int) (preViewPadding / this.mRatioX);
                    break;
                }
            default:
                this.mPoint.x = (int) (preViewPadding / this.mRatioX);
                this.mPoint.y = (int) (preViewPadding / this.mRatioY);
                break;
        }
    }

    private void setPointAsNoneAuto(int angle) {
        int preViewPadding = this.mActivity.getPreviewPaddingRight();
        if (this.mPoint == null) {
            this.mPoint = new Point();
        }
        switch (angle) {
            case ORIENTATION_LANDSCAPE_90 /* 90 */:
            case 270:
                if (this.mActivity.getCameraToggle() == 444) {
                    this.mPoint.x = (480 - this.mWidth) - ((int) (preViewPadding / this.mRatioY));
                    this.mPoint.y = (640 - this.mHeight) - ((int) (preViewPadding / this.mRatioX));
                    break;
                } else {
                    this.mPoint.x = (int) (preViewPadding / this.mRatioY);
                    this.mPoint.y = (int) (preViewPadding / this.mRatioX);
                    break;
                }
            default:
                this.mPoint.x = (int) (preViewPadding / this.mRatioX);
                this.mPoint.y = (int) (preViewPadding / this.mRatioY);
                break;
        }
    }

    private void setPointAsAutoRotationForSwitchCamera(int angle) {
        int preViewPadding = this.mActivity.getPreviewPaddingRight();
        if (this.mPoint == null) {
            this.mPoint = new Point();
        }
        switch (angle) {
            case ORIENTATION_LANDSCAPE_90 /* 90 */:
                if (this.mActivity.getCameraToggle() == 444) {
                    this.mPoint.x = (480 - this.mWidth) - ((int) (preViewPadding / this.mRatioY));
                    this.mPoint.y = (640 - this.mHeight) - ((int) (preViewPadding / this.mRatioX));
                    break;
                } else {
                    this.mPoint.x = (int) (preViewPadding / this.mRatioY);
                    this.mPoint.y = (int) (preViewPadding / this.mRatioX);
                    break;
                }
            case 270:
                if (this.mActivity.getCameraToggle() == 444) {
                    this.mPoint.x = (int) (preViewPadding / this.mRatioY);
                    this.mPoint.y = (int) (preViewPadding / this.mRatioX);
                    break;
                } else {
                    this.mPoint.x = (480 - this.mWidth) - ((int) (preViewPadding / this.mRatioY));
                    this.mPoint.y = (640 - this.mHeight) - ((int) (preViewPadding / this.mRatioX));
                    break;
                }
            default:
                this.mPoint.x = (int) (preViewPadding / this.mRatioX);
                this.mPoint.y = (int) (preViewPadding / this.mRatioY);
                break;
        }
    }

    private void setPointAsNoneAutoForSwitchCamera(int angle) {
        int preViewPadding = this.mActivity.getPreviewPaddingRight();
        if (this.mPoint == null) {
            this.mPoint = new Point();
        }
        switch (angle) {
            case ORIENTATION_LANDSCAPE_90 /* 90 */:
            case 270:
                if (this.mActivity.getCameraToggle() == 444) {
                    this.mPoint.x = (int) (preViewPadding / this.mRatioY);
                    this.mPoint.y = (int) (preViewPadding / this.mRatioX);
                    break;
                } else {
                    this.mPoint.x = (480 - this.mWidth) - ((int) (preViewPadding / this.mRatioY));
                    this.mPoint.y = (640 - this.mHeight) - ((int) (preViewPadding / this.mRatioX));
                    break;
                }
            default:
                this.mPoint.x = (int) (preViewPadding / this.mRatioX);
                this.mPoint.y = (int) (preViewPadding / this.mRatioY);
                break;
        }
    }

    private void makeRtio(int angle) {
        Display display = getDisplay();
        int displayWidth = display.getWidth();
        int displayHeight = display.getHeight();
        if (displayWidth > displayHeight) {
            this.mRatioX = (displayWidth - this.mActivity.getButtonLayoutSize(2)) / MAX_LONG_PREVIEW__SIZE;
            this.mRatioY = (displayHeight - getSystemStatusBarHeight()) / MAX_SHORT_PREVIEW__SIZE;
        } else {
            this.mRatioX = displayWidth / MAX_SHORT_PREVIEW__SIZE;
            this.mRatioY = (((displayHeight - getSystemStatusBarHeight()) - this.mActivity.getVideoCallStatusBarHeight()) - this.mActivity.getButtonLayoutSize(1)) / MAX_LONG_PREVIEW__SIZE;
        }
    }

    private void initPreviewSize() {
        this.mWidth = (int) (this.mActivity.mPreviewWidth / this.mRatioX);
        this.mHeight = (int) (this.mActivity.mPreviewHeight / this.mRatioY);
    }

    public int getSystemStatusBarHeight() {
        Rect rectgle = new Rect();
        Window window = this.mActivity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rectgle);
        return rectgle.top;
    }

    public Display getDisplay() {
        return ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay();
    }
}
