package com.samsung.android.sdk.pen.objectruntime.preload;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Region;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/* loaded from: classes.dex */
public class PhysicsGLView extends GLSurfaceView {
    private final Context mContext;
    private boolean mIsPaused;
    private PhysicsRenderer mRenderer;
    private final SurfaceHolder mSurfaceHolder;

    public PhysicsGLView(Context context) {
        super(context);
        this.mIsPaused = false;
        this.mContext = context;
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.addCallback(this);
        this.mSurfaceHolder.setKeepScreenOn(true);
        if (detectOpenGLES20()) {
            setEGLContextClientVersion(2);
            setEGLConfigChooser(8, 8, 8, 8, 16, 0);
            getHolder().setFormat(3);
            return;
        }
        Log.e("WaterEffect", "this machine does not support OpenGL ES2.0");
    }

    public void setPhysicsRenderer(PhysicsRenderer Renderer) {
        this.mRenderer = Renderer;
        setRenderer(this.mRenderer);
    }

    private boolean detectOpenGLES20() {
        ActivityManager am = (ActivityManager) this.mContext.getSystemService("activity");
        ConfigurationInfo info = am.getDeviceConfigurationInfo();
        return info != null && info.reqGlEsVersion >= 131072;
    }

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        return false;
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.mIsPaused = true;
    }

    public void onStop() {
        this.mRenderer.onStop();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        requestRender();
        if (this.mIsPaused) {
            requestRender();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        if (visibility == 0) {
            super.onWindowVisibilityChanged(visibility);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        this.mRenderer.onTouchEvent(event);
        return true;
    }
}
