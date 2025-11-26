package com.sds.coolots.call.view.p016a;

import android.opengl.GLSurfaceView;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.common.util.Log;
import java.io.IOException;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* renamed from: com.sds.coolots.call.view.a.c */
/* loaded from: classes.dex */
class C1236c implements GLSurfaceView.EGLContextFactory {

    /* renamed from: a */
    private static int f2889a = 12440;

    private C1236c() {
    }

    /* synthetic */ C1236c(C1236c c1236c) {
        this();
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) throws IOException {
        Log.m2971w(String.valueOf(C1234a.f2878a) + "creating OpenGL ES 2.0 context");
        C1234a.m2815b("Before eglCreateContext", egl10);
        EGLContext eGLContextEglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{f2889a, 2, 12344});
        C1234a.m2815b("After eglCreateContext", egl10);
        return eGLContextEglCreateContext;
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        egl10.eglDestroyContext(eGLDisplay, eGLContext);
        EngineInterface.getInstance().destrotyRenderer();
    }
}
