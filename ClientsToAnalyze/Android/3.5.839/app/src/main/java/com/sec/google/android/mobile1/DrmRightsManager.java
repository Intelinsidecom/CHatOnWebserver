package com.sec.google.android.mobile1;

import java.io.InputStream;

/* loaded from: classes.dex */
public class DrmRightsManager {

    /* renamed from: a */
    private static DrmRightsManager f18602a = null;

    private native int nativeInstallDrmRights(InputStream inputStream, int i, int i2, DrmRights drmRights);

    private native int nativeQueryRights(DrmRawContent drmRawContent, DrmRights drmRights);

    static {
        try {
            System.loadLibrary("drm1_jni");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("WARNING: Could not load libdrm1_jni.so");
        }
    }

    protected DrmRightsManager() {
    }

    /* renamed from: a */
    public static synchronized DrmRightsManager m19507a() {
        if (f18602a == null) {
            f18602a = new DrmRightsManager();
        }
        return f18602a;
    }

    /* renamed from: a */
    public synchronized DrmRights m19509a(InputStream inputStream, int i, String str) {
        int i2;
        DrmRights drmRights;
        if ("application/vnd.oma.drm.rights+xml".equals(str)) {
            i2 = 3;
        } else if ("application/vnd.oma.drm.rights+wbxml".equals(str)) {
            i2 = 4;
        } else if ("application/vnd.oma.drm.message".equals(str)) {
            i2 = 1;
        } else {
            throw new IllegalArgumentException("mimeType must be DRM_MIMETYPE_RIGHTS_XML or DRM_MIMETYPE_RIGHTS_WBXML or DRM_MIMETYPE_MESSAGE");
        }
        if (i <= 0) {
            drmRights = null;
        } else {
            drmRights = new DrmRights();
            if (-1 == nativeInstallDrmRights(inputStream, i, i2, drmRights)) {
                throw new C5112a("nativeInstallDrmRights() returned JNI_DRM_FAILURE");
            }
        }
        return drmRights;
    }

    /* renamed from: a */
    public synchronized DrmRights m19508a(DrmRawContent drmRawContent) {
        DrmRights drmRights;
        drmRights = new DrmRights();
        if (-1 == nativeQueryRights(drmRawContent, drmRights)) {
            drmRights = null;
        }
        return drmRights;
    }
}
