package com.samsung.android.sdk.pen.objectruntime.preload;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.pen.objectruntime.preload.PhysicsRenderer;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class SnowPaper implements SpenObjectRuntimeInterface {
    private static Object mListener;
    private static Method mOnActionComplete;
    private static Method mSetImage;
    private Bitmap m3DBitmap;
    private Context mContext;
    private DummyView mDummyView;
    private String mFilePath;
    private RelativeLayout.LayoutParams mLayoutParams;
    private Object mObjectBase;
    private Method mObjectImage;
    private PhysicsRenderer mPhysicsRenderer;
    private PhysicsGLView mPhysicsView;
    private ViewGroup mViewGroup;
    private static final Class[] mGetExtraDataArgsSignature = {String.class};
    private static Object[] mSetImageArgs = new Object[1];
    private static final Class[] mSetImageArgsSignature = {Bitmap.class};
    private static Boolean IsRunning = false;
    private static final Class[] mOnActionCompleteArgsSignature = {Object.class};
    private final RectF mRect = new RectF();
    private final Object[] mGetExtraDataArgs = new Object[1];
    private final Object[] mSetExtraDataArgs = new Object[2];
    private final Object[] mOnActionCompleteArgs = new Object[1];

    public static class DummyView extends View {
        public DummyView(Context context) {
            super(context);
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onLoad(Context context) {
        this.mContext = context;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public void start(Object objectBase, RectF relativeRect, PointF pan, float zoomRatio, PointF frameStartPosition, ViewGroup viewGroup) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.mObjectBase = objectBase;
        this.mViewGroup = viewGroup;
        try {
            mSetImage = objectBase.getClass().getMethod("setImage", mSetImageArgsSignature);
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        }
        try {
            this.mObjectImage = objectBase.getClass().getSuperclass().getMethod("setExtraDataString", String.class, String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Object returnObject = mInvoke(objectBase, "getRect", new Object[0]);
        Object fieldObject = mGetField(returnObject, "left");
        this.mRect.left = ((Float) fieldObject).floatValue();
        Object fieldObject2 = mGetField(returnObject, "top");
        this.mRect.top = ((Float) fieldObject2).floatValue();
        Object fieldObject3 = mGetField(returnObject, "right");
        this.mRect.right = ((Float) fieldObject3).floatValue();
        Object fieldObject4 = mGetField(returnObject, "bottom");
        this.mRect.bottom = ((Float) fieldObject4).floatValue();
        int width = (int) (relativeRect.right - relativeRect.left);
        int height = (int) (relativeRect.bottom - relativeRect.top);
        this.mLayoutParams = new RelativeLayout.LayoutParams(width, height);
        this.mLayoutParams.setMargins((int) relativeRect.left, (int) relativeRect.top, 0, 0);
        this.mGetExtraDataArgs[0] = "currentPage";
        String filePath = (String) mInvoke(objectBase, "getExtraDataString", mGetExtraDataArgsSignature, this.mGetExtraDataArgs);
        if (filePath == null) {
            if (this.mPhysicsView == null && !IsRunning.booleanValue()) {
                RelativeLayout.LayoutParams dummyLayoutParams = new RelativeLayout.LayoutParams(this.mViewGroup.getWidth(), this.mViewGroup.getHeight());
                dummyLayoutParams.setMargins(0, 0, 0, 0);
                this.mDummyView = new DummyView(this.mContext);
                this.mDummyView.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.objectruntime.preload.SnowPaper.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        SnowPaper.this.invokeListener();
                        return false;
                    }
                });
                this.mDummyView.setLayoutParams(dummyLayoutParams);
                this.mDummyView.bringToFront();
                this.mPhysicsView = new PhysicsGLView(this.mContext);
                this.mPhysicsView.setLayoutParams(this.mLayoutParams);
                this.mPhysicsView.setZOrderMediaOverlay(true);
                this.mViewGroup.addView(this.mDummyView);
                this.mViewGroup.addView(this.mPhysicsView);
                this.mPhysicsRenderer = new PhysicsRenderer(this.mContext, this.mPhysicsView, 1);
                this.mPhysicsView.setPhysicsRenderer(this.mPhysicsRenderer);
                IsRunning = true;
                PhysicsRenderer.OnCompleteSandFrameListener listener = new PhysicsRenderer.OnCompleteSandFrameListener() { // from class: com.samsung.android.sdk.pen.objectruntime.preload.SnowPaper.2
                    @Override // com.samsung.android.sdk.pen.objectruntime.preload.PhysicsRenderer.OnCompleteSandFrameListener
                    public void OnCompleteSandFrameListener(Bitmap bitmap, int mode) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        SnowPaper.this.m3DBitmap = bitmap;
                        SnowPaper.this.setImage(SnowPaper.this.m3DBitmap);
                    }
                };
                this.mPhysicsRenderer.setOnCompleteSandFrameListener(listener);
                return;
            }
            return;
        }
        this.mFilePath = filePath;
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        setImage(bitmap);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public void stop(boolean objectRuntimeStopFlag) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (IsRunning.booleanValue() && this.mPhysicsRenderer != null) {
            this.mPhysicsRenderer.ScreenCapture();
            if (this.m3DBitmap == null) {
                Log.e("mytag", "[SnowPaperActiveObject] onUnselected() - Capture image is nuLLLLLLLLLLLLLLLLLLLLLLLL");
            }
            setImage(this.m3DBitmap);
            if (this.mObjectImage != null) {
                this.mSetExtraDataArgs[0] = "currentPage";
                this.mSetExtraDataArgs[1] = this.mFilePath;
                try {
                    this.mObjectImage.invoke(this.mObjectBase, this.mSetExtraDataArgs);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
            }
            if (this.mPhysicsView != null) {
                this.mPhysicsView.onStop();
                this.mViewGroup.removeView(this.mPhysicsView);
                this.mPhysicsView = null;
            }
            if (this.mDummyView != null) {
                this.mViewGroup.removeView(this.mDummyView);
                this.mDummyView = null;
            }
            IsRunning = false;
        }
    }

    public void stopSetBitmap(boolean objectRuntimeStopFlag) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.mPhysicsRenderer.ScreenCapture();
        if (this.m3DBitmap == null) {
            Log.e("mytag", "[SnowPaperActiveObject] onUnselected() - Capture image is nuLLLLLLLLLLLLLLLLLLLLLLLL");
        }
        setImage(this.m3DBitmap);
        if (this.mObjectImage != null) {
            this.mSetExtraDataArgs[0] = "currentPage";
            this.mSetExtraDataArgs[1] = this.mFilePath;
            try {
                this.mObjectImage.invoke(this.mObjectBase, this.mSetExtraDataArgs);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        IsRunning = false;
    }

    public void stopRemoveView() {
        if (this.mPhysicsView != null) {
            this.mPhysicsView.onStop();
            this.mViewGroup.removeView(this.mPhysicsView);
            this.mPhysicsView = null;
        }
        if (this.mDummyView != null) {
            this.mViewGroup.removeView(this.mDummyView);
            this.mDummyView = null;
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public void setRect(RectF rect) {
        this.mRect.left = rect.left;
        this.mRect.top = rect.top;
        this.mRect.right = rect.right;
        this.mRect.bottom = rect.bottom;
        int width = (int) (this.mRect.right - this.mRect.left);
        int height = (int) (this.mRect.bottom - this.mRect.top);
        this.mLayoutParams = new RelativeLayout.LayoutParams(width, height);
        this.mLayoutParams.setMargins((int) this.mRect.left, (int) this.mRect.top, 0, 0);
        if (this.mPhysicsView != null) {
            this.mPhysicsView.setLayoutParams(this.mLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImage(Bitmap bitmap) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (mSetImage != null) {
            mSetImageArgs[0] = bitmap;
            try {
                mSetImage.invoke(this.mObjectBase, mSetImageArgs);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    private Object mInvoke(Object instance, String runner, Object... args) {
        try {
            return instance.getClass().getMethod(runner, new Class[0]).invoke(instance, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private Object mInvoke(Object instance, String runner, Class[] clazz, Object... args) {
        try {
            return instance.getClass().getMethod(runner, clazz).invoke(instance, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private Object mGetField(Object instance, String name) {
        try {
            return instance.getClass().getField(name).get(instance);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public boolean setListener(SpenObjectRuntimeInterface.UpdateListener objectRuntimeListener) {
        mListener = objectRuntimeListener;
        try {
            mOnActionComplete = mListener.getClass().getMethod("onCompleted", mOnActionCompleteArgsSignature);
            return true;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return true;
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void getProperty(Bundle propertyMap) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onUnload() {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void setProperty(Bundle propertyMap) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenNativeHandleInterface
    public int getNativeHandle() {
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public void onTouchEvent(MotionEvent event) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeListener() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (mOnActionComplete != null) {
            this.mOnActionCompleteArgs[0] = this.mObjectBase;
            stopSetBitmap(false);
            try {
                mOnActionComplete.invoke(mListener, this.mOnActionCompleteArgs);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
            stopRemoveView();
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public boolean unlock(String key) {
        return true;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public String getPrivateKeyHint() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public int getType() {
        return 1;
    }
}
