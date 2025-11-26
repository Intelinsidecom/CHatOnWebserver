package com.samsung.android.sdk.pen.recognition.preload;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectContainer;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognitionInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ShapeRecognitionPlugin implements SpenRecognitionInterface {
    private static final String TAG = "ShapeRecognitionPlugin";
    private static ShapeRecognition mRecogManager = null;
    private SpenRecognitionInterface.ResultListener mListener = null;
    private final Handler mHandler = new Handler() { // from class: com.samsung.android.sdk.pen.recognition.preload.ShapeRecognitionPlugin.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            HandleInfo info = (HandleInfo) msg.obj;
            if (ShapeRecognitionPlugin.this.mListener != null) {
                ShapeRecognitionPlugin.this.mListener.onResult(info.mInput, info.mOutput);
            }
        }
    };

    public ShapeRecognitionPlugin() {
        Log.d(TAG, "creating shape recognition plugin");
    }

    public boolean initRecognizer(Context context) {
        if (mRecogManager == null) {
            mRecogManager = new ShapeRecognition();
            if (mRecogManager == null) {
                Log.e(TAG, "Fail to create Shape recognition instance.");
                return false;
            }
            if (!mRecogManager.init(context)) {
                Log.e(TAG, "Fail to initialize.");
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStroke(ArrayList<SpenObjectBase> input) {
        Iterator<SpenObjectBase> it = input.iterator();
        while (it.hasNext()) {
            SpenObjectBase obj = it.next();
            PointF[] pointArray = ((SpenObjectStroke) obj).getPoints();
            if (pointArray != null) {
                int length = pointArray.length;
                if (length > 1024) {
                    length = 1024;
                }
                if (length > 0) {
                    float[] pointX = new float[length];
                    float[] pointY = new float[length];
                    for (int i = 0; i < length; i++) {
                        float fx = pointArray[i].x;
                        float fy = pointArray[i].y;
                        int gx = (int) pointArray[i].x;
                        int gy = (int) pointArray[i].y;
                        pointX[i] = fx - ((float) gx) > 0.5f ? gx + 0.5f : gx;
                        pointY[i] = fy - ((float) gy) > 0.5f ? gy + 0.5f : gy;
                    }
                    mRecogManager.addStroke(pointX, pointY);
                }
            }
        }
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

    class ShapeRecognitionRunnable implements Runnable {
        private List<SpenObjectBase> mInput;

        ShapeRecognitionRunnable(List<SpenObjectBase> input) {
            this.mInput = null;
            this.mInput = input;
        }

        @Override // java.lang.Runnable
        public void run() {
            ShapeRecognitionPlugin.this.addStroke((ArrayList) this.mInput);
            ArrayList<PointF[]> pointList = ShapeRecognitionPlugin.mRecogManager.process();
            Log.i(ShapeRecognitionPlugin.TAG, "process: pointList size = " + pointList.size());
            ArrayList<SpenObjectBase> output = null;
            if (pointList.size() > 0) {
                ArrayList<SpenObjectBase> strokeList = new ArrayList<>();
                ArrayList<String> shapeTypeList = ShapeRecognitionPlugin.mRecogManager.getShapeTypeList();
                output = new ArrayList<>();
                int c = 0;
                Iterator<PointF[]> it = pointList.iterator();
                while (it.hasNext()) {
                    PointF[] points = it.next();
                    if (points.length == 1) {
                        if (strokeList.size() > 0) {
                            SpenObjectContainer container = new SpenObjectContainer(strokeList);
                            Log.w(ShapeRecognitionPlugin.TAG, "process: name = " + shapeTypeList.get(c) + "[" + c + "]");
                            container.setExtraDataString("ShapeType", shapeTypeList.get(c));
                            output.add(container);
                            c++;
                        }
                        strokeList.clear();
                    } else {
                        float[] pressures = new float[points.length + 1];
                        int[] timestamps = new int[points.length];
                        for (int i = 0; i < points.length; i++) {
                            pressures[i] = 1.0f;
                            timestamps[i] = (int) SystemClock.uptimeMillis();
                        }
                        pressures[points.length] = 1.0f;
                        SpenObjectStroke inputStroke = (SpenObjectStroke) this.mInput.get(0);
                        SpenObjectStroke stroke = new SpenObjectStroke(inputStroke.getPenName(), points, pressures, timestamps);
                        stroke.setPenSize(inputStroke.getPenSize());
                        stroke.setColor(inputStroke.getColor());
                        strokeList.add(stroke);
                    }
                }
            }
            Message msg = Message.obtain(ShapeRecognitionPlugin.this.mHandler, 0, new HandleInfo(this.mInput, output));
            ShapeRecognitionPlugin.this.mHandler.sendMessage(msg);
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognitionInterface
    public void request(List<SpenObjectBase> input) {
        if (this.mListener == null) {
            Log.e(TAG, "The result listener isn't set yet!!");
            throw new IllegalStateException();
        }
        Thread thread = new Thread(new ShapeRecognitionRunnable(input));
        thread.start();
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognitionInterface
    public void setResultListener(SpenRecognitionInterface.ResultListener listener) {
        this.mListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onLoad(Context context) throws Exception {
        if (!initRecognizer(context)) {
            throw new RuntimeException("Fail to load Shape recognition engine");
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

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public boolean unlock(String key) {
        return true;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public String getPrivateKeyHint() {
        return null;
    }
}
