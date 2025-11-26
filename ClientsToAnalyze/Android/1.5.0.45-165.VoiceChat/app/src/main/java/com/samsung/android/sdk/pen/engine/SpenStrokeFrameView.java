package com.samsung.android.sdk.pen.engine;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Parcelable;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.infraware.office.evengine.InterfaceC0507E;
import com.sds.coolots.common.controller.EngineCallBackInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class SpenStrokeFrameView extends SurfaceView implements SurfaceHolder.Callback, Camera.PreviewCallback {
    private static final String TAG = "CameraFrame";
    private final Activity mActivity;
    private Camera mCamera;
    private int mCameraDegree;
    private OnCompleteCameraFrameListener mCompleteListener;
    private boolean mIsAutofocus;
    private boolean mIsPreviewCreated;
    private int mPictureHeight;
    private int mPictureWidth;
    private OnPreviewCallback mPreviewCallback;
    private int mPreviewHeight;
    private int mPreviewWidth;
    private final SurfaceHolder mSurfaceHolder;
    private int mZoomMax;
    private final Camera.PictureCallback pictureListener;
    private final Camera.ShutterCallback shutterListener;

    public interface OnCompleteCameraFrameListener {
        void onComplete(byte[] bArr);
    }

    public interface OnPreviewCallback {
        void OnPreview();
    }

    public void setOnCompleteCameraFrameListener(OnCompleteCameraFrameListener listener) {
        this.mCompleteListener = listener;
    }

    public SpenStrokeFrameView(Activity activity) {
        super(activity);
        this.mPreviewWidth = 0;
        this.mPreviewHeight = 0;
        this.mPictureWidth = 0;
        this.mPictureHeight = 0;
        this.mIsAutofocus = false;
        this.mIsPreviewCreated = false;
        this.shutterListener = new Camera.ShutterCallback() { // from class: com.samsung.android.sdk.pen.engine.SpenStrokeFrameView.1
            @Override // android.hardware.Camera.ShutterCallback
            public void onShutter() {
            }
        };
        this.pictureListener = new Camera.PictureCallback() { // from class: com.samsung.android.sdk.pen.engine.SpenStrokeFrameView.2
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] arg0, Camera arg1) {
                if (arg0 != null && SpenStrokeFrameView.this.mCompleteListener != null) {
                    Log.d("KYKY", "KYKY start oncomplete");
                    SpenStrokeFrameView.this.mCompleteListener.onComplete(arg0);
                }
            }
        };
        this.mActivity = activity;
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.addCallback(this);
        this.mSurfaceHolder.setKeepScreenOn(true);
    }

    public void stop() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder arg0) throws IOException {
        initCamera();
        this.mIsPreviewCreated = true;
    }

    public void cancelAutoFocus() {
        this.mCamera.cancelAutoFocus();
    }

    public void initCamera() throws IOException {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.mCamera.release();
            this.mCamera = null;
        }
        try {
            this.mCamera = Camera.open();
            if (this.mCamera == null) {
                Log.d("TAG", "Camera open failed");
                return;
            }
            try {
                this.mCamera.setPreviewDisplay(this.mSurfaceHolder);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.mCamera.setPreviewCallback(this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.mPictureHeight = 0;
            this.mPictureWidth = 0;
            this.mPreviewHeight = 0;
            this.mPreviewWidth = 0;
            Camera.Parameters parameters = this.mCamera.getParameters();
            if (parameters != null) {
                List<Camera.Size> pictureSizeList = parameters.getSupportedPictureSizes();
                if (pictureSizeList != null) {
                    for (Camera.Size size : pictureSizeList) {
                        if (size.width * 3 == size.height * 4 && size.width < 1200 && this.mPictureWidth < size.width) {
                            this.mPictureWidth = size.width;
                            this.mPictureHeight = size.height;
                        }
                    }
                    if (this.mPictureWidth == 0) {
                        Iterator<Camera.Size> it = pictureSizeList.iterator();
                        if (it.hasNext()) {
                            Camera.Size size2 = it.next();
                            this.mPictureWidth = size2.width;
                            this.mPictureHeight = size2.height;
                        }
                    }
                    Log.d(TAG, "PictureSize Width: " + this.mPictureWidth + "Height :" + this.mPictureHeight);
                    List<Camera.Size> previewSizeList = parameters.getSupportedPreviewSizes();
                    if (previewSizeList != null) {
                        for (Camera.Size size3 : previewSizeList) {
                            if (size3.width * 3 == size3.height * 4 && this.mPreviewWidth < size3.width && size3.width < 800) {
                                this.mPreviewWidth = size3.width;
                                this.mPreviewHeight = size3.height;
                            }
                        }
                    }
                    if (this.mPreviewWidth == 0) {
                        Iterator<Camera.Size> it2 = pictureSizeList.iterator();
                        if (it2.hasNext()) {
                            Camera.Size size4 = it2.next();
                            this.mPreviewWidth = size4.width;
                            this.mPreviewHeight = size4.height;
                        }
                    }
                }
                Log.d(TAG, "PreviewSize Width: " + this.mPreviewWidth + "Height :" + this.mPreviewHeight);
                parameters.setPreviewSize(this.mPreviewWidth, this.mPreviewHeight);
                parameters.setPictureSize(this.mPictureWidth, this.mPictureHeight);
                List<String> focusModes = parameters.getSupportedFocusModes();
                if (focusModes != null) {
                    if (focusModes.contains("continuous-picture")) {
                        parameters.setFocusMode("continuous-picture");
                    } else if (focusModes.contains("auto")) {
                        parameters.setFocusMode("auto");
                    } else {
                        Log.d(TAG, "No focus mode");
                    }
                }
                this.mZoomMax = parameters.getMaxZoom();
                this.mCamera.setParameters(parameters);
            }
            try {
                this.mCamera.startPreview();
            } catch (Exception e3) {
                this.mCompleteListener.onComplete(null);
            }
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(0, info);
            int rotation = this.mActivity.getWindowManager().getDefaultDisplay().getRotation();
            int degrees = 0;
            switch (rotation) {
                case 0:
                    degrees = 0;
                    break;
                case 1:
                    degrees = 90;
                    break;
                case 2:
                    degrees = EngineCallBackInterface.SIP_RINGTONE_NONE;
                    break;
                case 3:
                    degrees = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
                    break;
            }
            this.mCameraDegree = ((info.orientation - degrees) + 360) % 360;
            this.mCamera.setDisplayOrientation(this.mCameraDegree);
        } catch (Exception e4) {
            Log.d("TAG", "Camera open exception" + e4.getMessage());
        }
    }

    public int getCameraDegree() {
        return this.mCameraDegree;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
    }

    public void setOnPreviewCallback(OnPreviewCallback cb) {
        this.mPreviewCallback = cb;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] data, Camera camera) {
        this.mPreviewCallback.OnPreview();
    }

    public void takePicture() {
        if (this.mCamera == null) {
            Log.d("KYKY", "KYKY 2 camera open error");
        } else if (!this.mIsAutofocus) {
            Log.d("KYKY", "KYKY Start autofocus.");
            this.mIsAutofocus = true;
            this.mCamera.takePicture(this.shutterListener, null, this.pictureListener);
        }
    }

    public void setFocus(Rect r) {
        if (this.mCamera == null) {
            Log.d(TAG, "Camera is not created yet.");
            return;
        }
        if (!this.mIsPreviewCreated) {
            Log.d(TAG, "Preview of Camera is not  created yet.");
            return;
        }
        Camera.Area area = new Camera.Area(r, 1000);
        ArrayList<Camera.Area> al = new ArrayList<>();
        al.add(area);
        Camera.Parameters parameters = this.mCamera.getParameters();
        parameters.setFocusAreas(al);
        parameters.setFocusMode("auto");
        this.mCamera.setParameters(parameters);
        Log.d(TAG, "setFocus.");
        try {
            this.mCamera.autoFocus(null);
        } catch (RuntimeException e) {
            Log.d(TAG, "Preview of Camera is not  created yet. state = " + this.mIsPreviewCreated);
        }
    }

    public void setZoom(int zoom) {
        if (this.mCamera == null) {
            Log.d(TAG, "camera open error");
            return;
        }
        if (zoom < 0) {
            zoom = 0;
        }
        if (zoom > 100) {
            zoom = 100;
        }
        Camera.Parameters parameters = this.mCamera.getParameters();
        parameters.setZoom((this.mZoomMax * zoom) / 100);
        this.mCamera.setParameters(parameters);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder arg0) {
        stop();
    }

    public Camera getCamera() {
        return this.mCamera;
    }
}
