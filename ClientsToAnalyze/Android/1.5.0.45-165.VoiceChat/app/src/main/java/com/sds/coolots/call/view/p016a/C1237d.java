package com.sds.coolots.call.view.p016a;

import android.opengl.GLSurfaceView;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.util.Log;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.sds.coolots.call.view.a.d */
/* loaded from: classes.dex */
class C1237d implements GLSurfaceView.Renderer {
    private C1237d() {
    }

    /* synthetic */ C1237d(C1237d c1237d) {
        this();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        EngineInterface.getInstance().onRender();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Log.m2958e("Renderer onSurfaceChanged width = " + i + ", height = " + i2);
        if (PhoneManager.getMediaEngineType() == 0) {
            EngineInterface.getInstance().setRenderer(i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.m2958e("Renderer onSurfaceCreated");
    }
}
