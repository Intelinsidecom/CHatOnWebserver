package com.samsung.android.sdk.pen.recognition.preload;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenSignatureVerificationInterface;
import java.util.List;

/* loaded from: classes.dex */
public class Signature implements SpenSignatureVerificationInterface {
    public static final int SIGNATURE_DEFAULT_MIN_SIZE = 200;
    public static final int SIGNATURE_DEFAULT_USER_ID = 10;
    public static final int SIGNATURE_MAX_POINT_COUNT = 1024;
    public static final int SIGNATURE_MAX_REGISTRATION_NUM = 3;
    public static final int SIGNATURE_VERIFICATION_LEVEL_HIGH = 2;
    public static final int SIGNATURE_VERIFICATION_LEVEL_LOW = 0;
    public static final int SIGNATURE_VERIFICATION_LEVEL_MEDIUM = 1;
    private static final String TAG = "Signature";
    public static final String VERIFICATION_LEVEL_KEY = "VerificationLevel";
    private Context mContext = null;
    private HSVLib mHSVLib = null;
    private SpenSignatureVerificationInterface.ResultListener mListener = null;
    private int mVerificationLevel = 1;
    private final Handler mHandler = new Handler() { // from class: com.samsung.android.sdk.pen.recognition.preload.Signature.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            HandleInfo info = (HandleInfo) msg.obj;
            if (Signature.this.mListener != null) {
                Signature.this.mListener.onResult(info.mInput, info.mResult);
            }
        }
    };

    private String getSignatureTempPath() {
        String PARENT_DIR = this.mContext.getFilesDir().getParent();
        String TEMP_DIR = String.valueOf(PARENT_DIR) + "/_tmp/";
        return TEMP_DIR;
    }

    private boolean unregisterSignature() {
        return this.mHSVLib.deleteRegistration(10);
    }

    private boolean openSignatureEngine() {
        String saveDirPath = getSignatureTempPath();
        Log.i(TAG, "openSignatureEngine() : saveDirPath = " + saveDirPath);
        this.mHSVLib = new HSVLib();
        return this.mHSVLib.initHSV(saveDirPath, 1024, 3, 10, 200);
    }

    private boolean closeSignatureEngine() {
        if (this.mHSVLib == null) {
            Log.e(TAG, "Signature Engine is not Opened!");
            return false;
        }
        this.mHSVLib = null;
        return true;
    }

    private int registerSignature() {
        if (this.mHSVLib != null) {
            return this.mHSVLib.signatureTraining(10);
        }
        Log.e(TAG, "Signature Engine is not Opened!");
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean verifySignature(int verificationLevel) {
        int nLevel;
        if (this.mHSVLib == null) {
            Log.e(TAG, "Signature Engine is not Opened!");
            return false;
        }
        switch (verificationLevel) {
            case 0:
                nLevel = 0;
                break;
            case 1:
                nLevel = 1;
                break;
            case 2:
                nLevel = 2;
                break;
            default:
                return false;
        }
        return this.mHSVLib.verification(10, nLevel);
    }

    private static class HandleInfo {
        private List<SpenObjectStroke> mInput;
        boolean mResult;

        HandleInfo(List<SpenObjectStroke> input, boolean result) {
            this.mInput = null;
            this.mResult = false;
            this.mInput = input;
            this.mResult = result;
        }
    }

    class SignatureVerificationRunnable implements Runnable {
        private List<SpenObjectStroke> mInput;

        SignatureVerificationRunnable(List<SpenObjectStroke> stroke) {
            this.mInput = null;
            this.mInput = stroke;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (SpenObjectStroke __stroke : this.mInput) {
                PointF[] points = __stroke.getPoints();
                int[] stamp = __stroke.getTimeStamps();
                float[] pressure = __stroke.getPressures();
                Signature.this.mHSVLib.setDrawData(points, stamp, pressure);
            }
            boolean ret = Signature.this.verifySignature(Signature.this.mVerificationLevel);
            Message msg = Message.obtain(Signature.this.mHandler, 0, new HandleInfo(this.mInput, ret));
            Signature.this.mHandler.sendMessage(msg);
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onLoad(Context context) throws Exception {
        this.mContext = context;
        if (!openSignatureEngine()) {
            this.mHSVLib = null;
            this.mContext = null;
            throw new RuntimeException("Fail to load signature engine");
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onUnload() {
        closeSignatureEngine();
        this.mListener = null;
        this.mContext = null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void setProperty(Bundle propertyMap) {
        if (propertyMap.containsKey(VERIFICATION_LEVEL_KEY)) {
            int level = propertyMap.getInt(VERIFICATION_LEVEL_KEY);
            if (level < 0 || level > 2) {
                level = 1;
            }
            this.mVerificationLevel = level;
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void getProperty(Bundle propertyMap) {
        propertyMap.putInt(VERIFICATION_LEVEL_KEY, this.mVerificationLevel);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenNativeHandleInterface
    public int getNativeHandle() {
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenSignatureVerificationInterface
    public void register(List<SpenObjectStroke> stroke) {
        if (this.mHSVLib == null) {
            throw new IllegalStateException("Signature Engine is not Opened!");
        }
        if (stroke == null) {
            throw new IllegalArgumentException("stroke is null");
        }
        for (SpenObjectStroke __stroke : stroke) {
            PointF[] points = __stroke.getPoints();
            int[] stamp = __stroke.getTimeStamps();
            float[] pressure = __stroke.getPressures();
            this.mHSVLib.setDrawData(points, stamp, pressure);
        }
        int ret = registerSignature();
        if (ret < 0) {
            throw new RuntimeException("Fail to register the signature!");
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenSignatureVerificationInterface
    public void unregisterAll() {
        unregisterSignature();
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenSignatureVerificationInterface
    public int getRegisteredCount() {
        if (this.mHSVLib != null) {
            return this.mHSVLib.getRegisteredDataCount(10);
        }
        Log.e(TAG, "Signature Engine is not Opened!");
        return -1;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenSignatureVerificationInterface
    public void request(List<SpenObjectStroke> stroke) {
        if (this.mListener == null) {
            Log.e(TAG, "The result listener isn't set yet!!");
            throw new IllegalStateException();
        }
        if (this.mHSVLib == null) {
            Log.e(TAG, "Signature Engine is not Opened!");
            throw new IllegalStateException();
        }
        if (stroke == null) {
            Log.e(TAG, "Input parameter 'stroke' is null");
            throw new IllegalArgumentException();
        }
        if (!this.mHSVLib.checkRegistration(10)) {
            Log.e(TAG, "Registered signature is not enough");
            throw new IllegalStateException();
        }
        Thread thread = new Thread(new SignatureVerificationRunnable(stroke));
        thread.start();
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenSignatureVerificationInterface
    public void setResultListener(SpenSignatureVerificationInterface.ResultListener listener) {
        this.mListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenSignatureVerificationInterface
    public int getMinimumRequiredCount() {
        return 3;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public boolean unlock(String key) {
        return true;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public String getPrivateKeyHint() {
        return null;
    }
}
