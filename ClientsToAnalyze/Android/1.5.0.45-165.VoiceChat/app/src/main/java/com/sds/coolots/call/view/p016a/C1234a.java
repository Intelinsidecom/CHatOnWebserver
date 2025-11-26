package com.sds.coolots.call.view.p016a;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import javax.microedition.khronos.egl.EGL10;

/* renamed from: com.sds.coolots.call.view.a.a */
/* loaded from: classes.dex */
public class C1234a extends GLSurfaceView implements DisposeInterface {

    /* renamed from: a */
    private static String f2878a = "GL2JNIView";

    /* renamed from: b */
    private static final boolean f2879b = false;

    public C1234a(Context context) {
        super(context);
        m2814a(false, 0, 0);
    }

    public C1234a(Context context, AttributeSet attributeSet) {
        super(context);
        m2814a(false, 0, 0);
    }

    public C1234a(Context context, boolean z, int i, int i2) {
        super(context);
        m2814a(z, i, i2);
    }

    /* renamed from: a */
    private void m2814a(boolean z, int i, int i2) {
        C1236c c1236c = null;
        byte b = 0;
        Log.m2958e("TTTTT INIT CALLED!!!!!!!!!!!!!");
        if (z) {
            getHolder().setFormat(-3);
        }
        setEGLContextFactory(new C1236c(c1236c));
        setEGLConfigChooser(z ? new C1235b(8, 8, 8, 8, i, i2) : new C1235b(5, 6, 5, 0, i, i2));
        setRenderer(new C1237d(b == true ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m2815b(String str, EGL10 egl10) {
        while (true) {
            int iEglGetError = egl10.eglGetError();
            if (iEglGetError == 12288) {
                return;
            } else {
                Log.m2958e(String.valueOf(f2878a) + String.format("%s: EGL error: 0x%x", str, Integer.valueOf(iEglGetError)));
            }
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        setEGLContextFactory(null);
        setEGLConfigChooser((GLSurfaceView.EGLConfigChooser) null);
        setRenderer(null);
        EngineInterface.getInstance().destrotyRenderer();
    }
}
