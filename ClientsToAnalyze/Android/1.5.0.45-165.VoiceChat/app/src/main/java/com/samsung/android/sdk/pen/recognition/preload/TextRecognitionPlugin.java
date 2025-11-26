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
import com.samsung.android.sdk.pen.plugin.interfaces.SpenLanguageRecognitionInterface;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognitionInterface;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TextRecognitionPlugin implements SpenLanguageRecognitionInterface {
    private static final String TAG = "recognition-TextRecognitionPlugin";
    private TextRecognition mRecogManager = null;
    private SpenRecognitionInterface.ResultListener mListener = null;
    private final Handler mRecogHandler = new Handler() { // from class: com.samsung.android.sdk.pen.recognition.preload.TextRecognitionPlugin.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            HandleInfo info = (HandleInfo) msg.obj;
            if (TextRecognitionPlugin.this.mListener == null) {
                return;
            }
            TextRecognitionPlugin.this.mListener.onResult(info.mInput, info.mOutput);
        }
    };

    public TextRecognitionPlugin() {
        Log.d(TAG, "creating text recognition plugin");
    }

    public boolean initRecognizer(Context context) {
        if (this.mRecogManager == null) {
            this.mRecogManager = new TextRecognition();
            if (this.mRecogManager == null) {
                Log.e(TAG, "Fail to create TextRecognition instance");
                return false;
            }
            if (!this.mRecogManager.init(context, "eng")) {
                this.mRecogManager = null;
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

    class TextRecognitionRunnable implements Runnable {
        private List<SpenObjectBase> mInput;

        TextRecognitionRunnable(List<SpenObjectBase> input) {
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
                        float[] ptx = new float[length];
                        float[] pty = new float[length];
                        for (int i = 0; i < length; i++) {
                            ptx[i] = points[i].x;
                            pty[i] = points[i].y;
                        }
                        TextRecognitionPlugin.this.mRecogManager.addStroke(ptx, pty);
                    }
                }
            }
            ArrayList<SpenObjectBase> list = null;
            String[] candidates = TextRecognitionPlugin.this.mRecogManager.process();
            if (candidates != null && candidates.length > 0) {
                list = new ArrayList<>();
                SpenObjectTextBox text = new SpenObjectTextBox(candidates[0]);
                list.add(text);
            }
            Message msg = Message.obtain(TextRecognitionPlugin.this.mRecogHandler, 0, new HandleInfo(this.mInput, list));
            TextRecognitionPlugin.this.mRecogHandler.sendMessage(msg);
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognitionInterface
    public void setResultListener(SpenRecognitionInterface.ResultListener listener) {
        this.mListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onLoad(Context context) throws Exception {
        if (!initRecognizer(context)) {
            throw new RuntimeException("Fail to load Text recognition engine");
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenLanguageRecognitionInterface
    public String getLanguage() {
        return this.mRecogManager.getCurrentLanguage();
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenLanguageRecognitionInterface
    public void setLanguage(String arg0) {
        if (this.mRecogManager != null) {
            this.mRecogManager.setLanguage(arg0);
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
    public void request(List<SpenObjectBase> input) {
        if (this.mListener == null) {
            Log.e(TAG, "The result listener isn't set yet!!");
            throw new IllegalStateException();
        }
        Thread thread = new Thread(new TextRecognitionRunnable(input));
        thread.start();
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenLanguageRecognitionInterface
    public List<String> getSupportedLanguage() {
        if (this.mRecogManager == null) {
            return null;
        }
        return this.mRecogManager.getSupportedLanguage();
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
