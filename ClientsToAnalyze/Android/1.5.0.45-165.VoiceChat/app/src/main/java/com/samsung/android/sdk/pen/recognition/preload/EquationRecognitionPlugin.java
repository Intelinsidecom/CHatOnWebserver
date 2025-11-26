package com.samsung.android.sdk.pen.recognition.preload;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognitionInterface;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class EquationRecognitionPlugin implements SpenRecognitionInterface {
    private static final String TAG = "recognition-EquationRecognitionPlugin";
    private static EquationRecognition mRecogManager = null;
    private SpenRecognitionInterface.ResultListener mListener = null;
    private final Handler mHandler = new Handler() { // from class: com.samsung.android.sdk.pen.recognition.preload.EquationRecognitionPlugin.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            HandleInfo info = (HandleInfo) msg.obj;
            if (EquationRecognitionPlugin.this.mListener != null) {
                EquationRecognitionPlugin.this.mListener.onResult(info.mInput, info.mOutput);
            }
        }
    };

    public EquationRecognitionPlugin() {
        Log.d(TAG, "creating equation recognition plugin");
    }

    public boolean initRecognizer(Context context) {
        if (mRecogManager == null) {
            mRecogManager = new EquationRecognition(context);
            if (mRecogManager == null) {
                Log.e(TAG, "Fail to create Equation recognition instance.");
                return false;
            }
            if (!mRecogManager.init(context)) {
                Log.e(TAG, "Fail to initialize.");
                return false;
            }
        }
        return true;
    }

    private static class HandleInfo {
        private List<SpenObjectBase> mInput;
        private List<SpenObjectBase> mOutput;

        HandleInfo(List<SpenObjectBase> input, List<SpenObjectBase> output) {
            this.mInput = null;
            this.mOutput = null;
            this.mInput = input;
            this.mOutput = output;
        }
    }

    class EquationRecognitionRunnable implements Runnable {
        private List<SpenObjectBase> mInput;

        EquationRecognitionRunnable(List<SpenObjectBase> input) {
            this.mInput = null;
            this.mInput = input;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (SpenObjectBase obj : this.mInput) {
                PointF[] points = ((SpenObjectStroke) obj).getPoints();
                if (points != null) {
                    int length = points.length;
                    if (length > 1024) {
                        length = 1024;
                    }
                    if (length > 0) {
                        float[] pointX = new float[length];
                        float[] pointY = new float[length];
                        for (int i = 0; i < length; i++) {
                            pointX[i] = points[i].x;
                            pointY[i] = points[i].y;
                        }
                        EquationRecognitionPlugin.mRecogManager.addStroke(pointX, pointY);
                    }
                }
            }
            String result = EquationRecognitionPlugin.mRecogManager.process();
            ArrayList<SpenObjectBase> output = null;
            if (result != null) {
                Log.i(EquationRecognitionPlugin.TAG, "result = " + result);
                output = new ArrayList<>();
                SpenObjectTextBox text = new SpenObjectTextBox(result);
                output.add(text);
            }
            Message msg = Message.obtain(EquationRecognitionPlugin.this.mHandler, 0, new HandleInfo(this.mInput, output));
            EquationRecognitionPlugin.this.mHandler.sendMessage(msg);
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognitionInterface
    public void request(List<SpenObjectBase> input) {
        if (this.mListener == null) {
            Log.e(TAG, "The result listener isn't set yet!!");
            throw new IllegalStateException();
        }
        Thread thread = new Thread(new EquationRecognitionRunnable(input));
        thread.start();
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onLoad(Context context) throws Exception {
        if (!initRecognizer(context)) {
            throw new RuntimeException("Fail to load Equation recognition engine");
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onUnload() {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void getProperty(Bundle arg0) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void setProperty(Bundle arg0) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenNativeHandleInterface
    public int getNativeHandle() {
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognitionInterface
    public void setResultListener(SpenRecognitionInterface.ResultListener listener) {
        this.mListener = listener;
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
