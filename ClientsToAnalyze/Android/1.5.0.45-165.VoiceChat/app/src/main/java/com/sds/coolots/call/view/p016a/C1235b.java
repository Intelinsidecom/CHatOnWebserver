package com.sds.coolots.call.view.p016a;

import android.opengl.GLSurfaceView;
import com.sds.coolots.common.util.Log;
import java.io.IOException;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* renamed from: com.sds.coolots.call.view.a.b */
/* loaded from: classes.dex */
class C1235b implements GLSurfaceView.EGLConfigChooser {

    /* renamed from: g */
    private static int f2880g = 4;

    /* renamed from: h */
    private static int[] f2881h = {12324, 4, 12323, 4, 12322, 4, 12352, f2880g, 12344};

    /* renamed from: a */
    protected int f2882a;

    /* renamed from: b */
    protected int f2883b;

    /* renamed from: c */
    protected int f2884c;

    /* renamed from: d */
    protected int f2885d;

    /* renamed from: e */
    protected int f2886e;

    /* renamed from: f */
    protected int f2887f;

    /* renamed from: i */
    private final int[] f2888i = new int[1];

    public C1235b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f2882a = i;
        this.f2883b = i2;
        this.f2884c = i3;
        this.f2885d = i4;
        this.f2886e = i5;
        this.f2887f = i6;
    }

    /* renamed from: a */
    private int m2816a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f2888i) ? this.f2888i[0] : i2;
    }

    /* renamed from: a */
    private void m2817a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) throws IOException {
        int[] iArr = {12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354};
        String[] strArr = {"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
        int[] iArr2 = new int[1];
        for (int i = 0; i < iArr.length; i++) {
            int i2 = iArr[i];
            String str = strArr[i];
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, iArr2)) {
                Log.m2971w(String.valueOf(C1234a.f2878a) + String.format("  %s: %d\n", str, Integer.valueOf(iArr2[0])));
            } else {
                while (egl10.eglGetError() != 12288) {
                }
            }
        }
    }

    /* renamed from: b */
    private void m2818b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) throws IOException {
        int length = eGLConfigArr.length;
        Log.m2971w(String.valueOf(C1234a.f2878a) + String.format("%d configurations", Integer.valueOf(length)));
        for (int i = 0; i < length; i++) {
            Log.m2971w(String.valueOf(C1234a.f2878a) + String.format("Configuration %d:\n", Integer.valueOf(i)));
            m2817a(egl10, eGLDisplay, eGLConfigArr[i]);
        }
    }

    /* renamed from: a */
    public EGLConfig m2819a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        for (EGLConfig eGLConfig : eGLConfigArr) {
            int iM2816a = m2816a(egl10, eGLDisplay, eGLConfig, 12325, 0);
            int iM2816a2 = m2816a(egl10, eGLDisplay, eGLConfig, 12326, 0);
            if (iM2816a >= this.f2886e && iM2816a2 >= this.f2887f) {
                int iM2816a3 = m2816a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                int iM2816a4 = m2816a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                int iM2816a5 = m2816a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                int iM2816a6 = m2816a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                if (iM2816a3 == this.f2882a && iM2816a4 == this.f2883b && iM2816a5 == this.f2884c && iM2816a6 == this.f2885d) {
                    return eGLConfig;
                }
            }
        }
        return null;
    }

    @Override // android.opengl.GLSurfaceView.EGLConfigChooser
    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = new int[1];
        egl10.eglChooseConfig(eGLDisplay, f2881h, null, 0, iArr);
        int i = iArr[0];
        if (i <= 0) {
            throw new IllegalArgumentException("No configs match configSpec");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i];
        egl10.eglChooseConfig(eGLDisplay, f2881h, eGLConfigArr, i, iArr);
        return m2819a(egl10, eGLDisplay, eGLConfigArr);
    }
}
