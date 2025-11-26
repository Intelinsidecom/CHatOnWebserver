package com.samsung.android.sdk.pen.objectruntime.preload;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.util.SpenScreenCodecDecoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public class PhysicsRenderer implements GLSurfaceView.Renderer, SensorEventListener {
    public static final int SAND_PAPER_EFFECT = 0;
    public static final int SNOW_PAPER_EFFECT = 1;
    static PhysicsRenderer gRenderer;
    static Context g_ctx;
    private static Context mContext;
    private static IPhysicsEngineJNI mPhysicsEngineJNI;
    private OnCompleteSandFrameListener mCompleteListener;
    private int mPaperEffectType;
    private int mScreenHeight;
    private int mScreenWidth;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private final boolean DBG = true;
    private final String TAG = "PhysicsRenderer";
    private boolean stopFlag = false;
    private boolean captureFlag = false;
    private boolean shakeFlag = false;
    private boolean touchFlag = false;
    private final boolean mSensorEventOn = true;
    private long mStart = 0;
    private long mEnd = 0;
    private boolean doneTest = false;
    private int huristicCnt = 0;

    public interface OnCompleteSandFrameListener {
        void OnCompleteSandFrameListener(Bitmap bitmap, int i);
    }

    public void setOnCompleteSandFrameListener(OnCompleteSandFrameListener listener) {
        this.mCompleteListener = listener;
    }

    public PhysicsRenderer(Context context, View view, int type) {
        this.mPaperEffectType = 0;
        mContext = context;
        g_ctx = context;
        this.mPaperEffectType = type;
        gRenderer = this;
        this.mSensorManager = (SensorManager) mContext.getSystemService("sensor");
        this.mSensor = this.mSensorManager.getDefaultSensor(1);
        mPhysicsEngineJNI = new PhysicsEngineJNI();
    }

    public static String readRawTextFile(int resId) throws Resources.NotFoundException, IOException {
        InputStream inputStream = mContext.getResources().openRawResource(resId);
        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);
        StringBuilder text = new StringBuilder();
        while (true) {
            try {
                try {
                    String line = buffreader.readLine();
                    if (line != null) {
                        text.append(line);
                        text.append('\n');
                    } else {
                        return text.toString();
                    }
                } finally {
                    buffreader.close();
                    inputreader.close();
                    inputStream.close();
                }
            } catch (IOException e) {
                return null;
            }
        }
    }

    public void onStop() {
        if (this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this);
        }
        this.stopFlag = true;
    }

    public void ScreenCapture() {
        this.captureFlag = true;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl) {
        if (!this.stopFlag) {
            mPhysicsEngineJNI.Draw_PhysicsEngine();
        }
        if (!this.doneTest) {
            this.mEnd = System.currentTimeMillis();
            System.out.println("end absolute time: " + this.mEnd);
            System.out.println("init time: " + (this.mEnd - this.mStart));
            this.doneTest = true;
        }
        if (this.captureFlag) {
            int limitCnt = 10;
            if (this.shakeFlag) {
                limitCnt = 1;
            }
            if (this.huristicCnt > limitCnt) {
                this.captureFlag = false;
                this.shakeFlag = false;
                this.huristicCnt = 0;
                return;
            }
            int[] b = new int[this.mScreenWidth * this.mScreenHeight];
            int[] bt = new int[this.mScreenWidth * this.mScreenHeight];
            IntBuffer ib = IntBuffer.wrap(b);
            ib.position(0);
            gl.glReadPixels(0, 0, this.mScreenWidth, this.mScreenHeight, 6408, 5121, ib);
            for (int i = 0; i < this.mScreenHeight; i++) {
                for (int j = 0; j < this.mScreenWidth; j++) {
                    int pix = b[(this.mScreenWidth * i) + j];
                    int pb = (pix >> 16) & 255;
                    int pr = (pix << 16) & 16711680;
                    int pix1 = ((-16711936) & pix) | pr | pb;
                    bt[(((this.mScreenHeight - i) - 1) * this.mScreenWidth) + j] = pix1;
                }
            }
            Bitmap scBitmap = Bitmap.createBitmap(bt, this.mScreenWidth, this.mScreenHeight, Bitmap.Config.ARGB_8888);
            if (this.mCompleteListener != null) {
                this.mCompleteListener.OnCompleteSandFrameListener(scBitmap, 0);
            }
            this.huristicCnt++;
        }
        if (this.stopFlag) {
            mPhysicsEngineJNI.DeInit_PhysicsEngineJNI();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        this.stopFlag = false;
        this.mScreenWidth = width;
        this.mScreenHeight = height;
        mPhysicsEngineJNI.Init_PhysicsEngine(this.mPaperEffectType, width, height);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl, EGLConfig config) throws Resources.NotFoundException, PackageManager.NameNotFoundException, IOException {
        this.mStart = System.currentTimeMillis();
        mPhysicsEngineJNI.Init_PhysicsEngineJNI();
        if (this.mSensor != null) {
            this.mSensorManager.registerListener(this, this.mSensor, 2);
        }
        Init_SetTexture();
    }

    public void Init_SetTexture() throws Resources.NotFoundException, PackageManager.NameNotFoundException, IOException {
        if (this.mPaperEffectType == 0) {
            try {
                PackageManager manager = mContext.getPackageManager();
                Resources mSdkResources = manager.getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
                int resId = mSdkResources.getIdentifier("sand", "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
                Drawable drawable = SpenScreenCodecDecoder.getDrawable(mSdkResources, resId);
                Bitmap bitmap = null;
                if (drawable != null) {
                    if (drawable instanceof BitmapDrawable) {
                        bitmap = ((BitmapDrawable) drawable).getBitmap();
                    } else {
                        bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmap);
                        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                        drawable.draw(canvas);
                    }
                }
                mPhysicsEngineJNI.SetTexture("sand", bitmap, false);
                return;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }
        if (this.mPaperEffectType == 1) {
            try {
                PackageManager manager2 = mContext.getPackageManager();
                Resources mSdkResources2 = manager2.getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
                int resId2 = mSdkResources2.getIdentifier("snow", "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
                Drawable drawable2 = SpenScreenCodecDecoder.getDrawable(mSdkResources2, resId2);
                Bitmap bitmap2 = null;
                if (drawable2 != null) {
                    if (drawable2 instanceof BitmapDrawable) {
                        bitmap2 = ((BitmapDrawable) drawable2).getBitmap();
                    } else {
                        bitmap2 = Bitmap.createBitmap(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                        Canvas canvas2 = new Canvas(bitmap2);
                        drawable2.setBounds(0, 0, canvas2.getWidth(), canvas2.getHeight());
                        drawable2.draw(canvas2);
                    }
                }
                mPhysicsEngineJNI.SetTexture("snow", bitmap2, false);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        if (!this.stopFlag && !this.touchFlag) {
            mPhysicsEngineJNI.onSensorEvent(event.sensor.getType(), event.values[0], event.values[1], event.values[2]);
            this.shakeFlag = true;
            this.captureFlag = true;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int[] pointer_xpos = new int[10];
        int[] pointer_ypos = new int[10];
        int multitouch_num = event.getPointerCount();
        mPhysicsEngineJNI.onSettingEvent(0, event.getPressure());
        switch (action & 255) {
            case 0:
                int pointer_id = event.getPointerId(0);
                pointer_xpos[pointer_id] = (int) event.getX(0);
                pointer_ypos[pointer_id] = (int) event.getY(0);
                mPhysicsEngineJNI.onTouchEvent(pointer_id, multitouch_num, 0, pointer_xpos, pointer_ypos);
                this.captureFlag = false;
                this.shakeFlag = false;
                this.touchFlag = true;
                return true;
            case 1:
                int pointer_id2 = event.getPointerId(0);
                pointer_xpos[pointer_id2] = (int) event.getX(0);
                pointer_ypos[pointer_id2] = (int) event.getY(0);
                mPhysicsEngineJNI.onTouchEvent(pointer_id2, multitouch_num, 1, pointer_xpos, pointer_ypos);
                this.touchFlag = false;
                ScreenCapture();
                return true;
            case 2:
                int pointer_id3 = 0;
                for (int i = 0; i < multitouch_num; i++) {
                    pointer_id3 = event.getPointerId(i);
                    pointer_xpos[pointer_id3] = (int) event.getX(i);
                    pointer_ypos[pointer_id3] = (int) event.getY(i);
                }
                mPhysicsEngineJNI.onTouchEvent(pointer_id3, multitouch_num, 2, pointer_xpos, pointer_ypos);
                this.touchFlag = true;
                return true;
            default:
                return true;
        }
    }

    public void onResume() {
        Log.d("PhysicsRenderer", "onResume");
        if (this.mSensor != null) {
            this.mSensorManager.registerListener(this, this.mSensor, 2);
        }
    }

    public void onPause() {
        if (this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this);
        }
    }
}
