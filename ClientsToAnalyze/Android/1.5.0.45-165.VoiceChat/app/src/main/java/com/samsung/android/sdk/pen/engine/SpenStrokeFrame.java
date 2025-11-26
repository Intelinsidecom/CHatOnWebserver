package com.samsung.android.sdk.pen.engine;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectContainer;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.engine.SpenStrokeFrameView;
import com.samsung.android.sdk.pen.pen.SpenPen;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.recognition.SpenCreationFailureException;
import com.samsung.android.sdk.pen.recognition.SpenRecognitionBase;
import com.samsung.android.sdk.pen.recognition.SpenRecognitionInfo;
import com.samsung.android.sdk.pen.recognition.SpenShapeRecognition;
import com.samsung.android.sdk.pen.recognition.SpenShapeRecognitionManager;
import com.samsung.android.sdk.pen.util.SpenScreenCodecDecoder;
import com.vlingo.sdk.internal.vlservice.config.VLConfigParser;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class SpenStrokeFrame {
    private static final String CHANGE_STROKE_FRAME_BEAUTIFY_DESCRIPTION_NAME = "string_transform_into_auto_shape";
    private static final String CHANGE_STROKE_FRAME_BEAUTIFY_DRAWABLE_NAME = "snote_photoframe_refine";
    private static final String CHANGE_STROKE_FRAME_BG_DRAWABLE_NAME = "selector_change_stroke_frame_bg";
    private static final String CHANGE_STROKE_FRAME_ORIGINAL_DESCRIPTION_NAME = "string_transform_back_to_original_shape";
    private static final String CHANGE_STROKE_FRAME_ORIGINAL_DRAWABLE_NAME = "snote_photoframe_undo";
    private static final int PIXEL_TO_ZOOM_STANDARD_VALUE = 5;
    private static final float SIGMA = 1.0E-4f;
    private static final int STROKE_FRAME_MIN_WIDTH_HEIGHT = 10;
    private static final String TAG = "SpenStrokeFrame";

    /* renamed from: dm */
    private DisplayMetrics f400dm;
    private Activity mActivity;
    private SpenObjectContainer mBeautifyContainer;
    private SpenObjectImage mBeautifyImage;
    private ArrayList<SpenObjectBase> mBeautifyStoke;
    private Bitmap mBgBitmap;
    private SpenStrokeFrameView mCameraView;
    private RelativeLayout.LayoutParams mCameraViewLayoutParams;
    private Drawable mChangeFrameBeautifyDrawable;
    private Drawable mChangeFrameBgDrawable;
    private ImageButton mChangeFrameButton;
    private String mChangeFrameDescriptionBeautify;
    private String mChangeFrameDescriptionOriginal;
    private Drawable mChangeFrameOriginalDrawable;
    private Path mFrameShapePath;
    private SpenObjectContainer mObjectContainer;
    private SpenObjectContainer mOriginalContainer;
    private SpenObjectImage mOriginalImage;
    private ArrayList<SpenObjectBase> mOriginalStroke;
    private int mPageHeight;
    private int mPageWidth;
    private PointF mPan;
    private SpenPen mPen;
    private float mPenSize;
    SpenStrokeFrameView.OnPreviewCallback mPreviewCallback;
    private float mPreviewRatio;
    private float mRatio;
    private Bitmap mShapeMaskBitmap;
    private RelativeLayout.LayoutParams mShapeMaskLayoutParams;
    private ImageView mShapeMaskView;
    private SpenShapeRecognition mShapeRecognition;
    private Bitmap mSpenSurfaceViewBitmap;
    private PointF mStartFramePosition;
    private int mStrokeFrameAction;
    private int mStrokeFrameType;
    private ImageView mTouchImage;
    private ViewGroup mViewGroup;
    private Bitmap mWorkBitmap;
    private int mZoomCur;
    private int mZoomLast;
    private int mZoomMode;
    private int mZoomPrev;
    private float mZoomY;
    private SpenStrokeFrameListener updateListener;
    private static int HASH_KEY_IMAGE_SIZE = 0;
    private static int HASH_KEY_IMAGE_MARGIN = HASH_KEY_IMAGE_SIZE + 1;
    private static int HASH_KEY_IMAGE_MARGIN_WHEN_TOP = HASH_KEY_IMAGE_MARGIN + 1;
    private static int HASH_KEY_IMAGE_MARGIN_WHEN_BOTTOM = HASH_KEY_IMAGE_MARGIN_WHEN_TOP + 1;
    private static int HASH_KEY_PIXEL_1080_1920 = 3000;
    private static int HASH_KEY_PIXEL_2560_1600 = 4160;
    private static int HASH_KEY_PIXEL_720_1280 = 2000;
    private static int HASH_KEY_PIXEL_DEFAULT = HASH_KEY_PIXEL_1080_1920;
    private static final HashMap<Integer, HashMap<Integer, Rect>> CHANGE_STROKE_FRAME_IMAGE_UX_TABLE = new HashMap<>();
    private RectF mRect = new RectF();
    private final Path mTouchCheckPath = new Path();
    private final PointF mPrevTouchPoint = new PointF();

    SpenStrokeFrame() {
    }

    static {
        Rect size = new Rect(0, 0, 39, 39);
        Rect margin = new Rect(0, 0, 1, 1);
        HashMap<Integer, Rect> info = new HashMap<>();
        info.put(Integer.valueOf(HASH_KEY_IMAGE_SIZE), size);
        info.put(Integer.valueOf(HASH_KEY_IMAGE_MARGIN), margin);
        Rect margin2 = new Rect(0, 0, 4, 3);
        info.put(Integer.valueOf(HASH_KEY_IMAGE_MARGIN_WHEN_TOP), margin2);
        Rect margin3 = new Rect(0, 2, 0, 3);
        info.put(Integer.valueOf(HASH_KEY_IMAGE_MARGIN_WHEN_BOTTOM), margin3);
        CHANGE_STROKE_FRAME_IMAGE_UX_TABLE.put(Integer.valueOf(HASH_KEY_PIXEL_1080_1920), info);
        Rect size2 = new Rect(0, 0, 58, 59);
        Rect margin4 = new Rect(0, 0, 1, 1);
        HashMap<Integer, Rect> info2 = new HashMap<>();
        info2.put(Integer.valueOf(HASH_KEY_IMAGE_SIZE), size2);
        info2.put(Integer.valueOf(HASH_KEY_IMAGE_MARGIN), margin4);
        Rect margin5 = new Rect(0, 0, 5, 5);
        info2.put(Integer.valueOf(HASH_KEY_IMAGE_MARGIN_WHEN_TOP), margin5);
        new Rect(0, 3, 0, 5);
        CHANGE_STROKE_FRAME_IMAGE_UX_TABLE.put(Integer.valueOf(HASH_KEY_PIXEL_2560_1600), info2);
        Rect size3 = new Rect(0, 0, 35, 35);
        Rect margin6 = new Rect(0, 0, 1, 1);
        HashMap<Integer, Rect> info3 = new HashMap<>();
        info3.put(Integer.valueOf(HASH_KEY_IMAGE_SIZE), size3);
        info3.put(Integer.valueOf(HASH_KEY_IMAGE_MARGIN), margin6);
        Rect margin7 = new Rect(0, 0, 4, 3);
        info3.put(Integer.valueOf(HASH_KEY_IMAGE_MARGIN_WHEN_TOP), margin7);
        Rect margin8 = new Rect(0, 2, 0, 3);
        info3.put(Integer.valueOf(HASH_KEY_IMAGE_MARGIN_WHEN_BOTTOM), margin8);
        CHANGE_STROKE_FRAME_IMAGE_UX_TABLE.put(Integer.valueOf(HASH_KEY_PIXEL_720_1280), info3);
    }

    public void takeStrokeFrame(Activity activity, Bitmap spenSurfaceViewBitmap, Bitmap bgBitmap, int pageWidth, int pageHeight, int frameType, SpenObjectContainer objectContainer, SpenStrokeFrameListener listener, PointF pan, float zoomRatio, PointF frameStartPosition, ViewGroup layout) {
        this.mActivity = activity;
        this.mStrokeFrameType = frameType;
        this.mObjectContainer = objectContainer;
        this.mViewGroup = layout;
        this.mPan = pan;
        this.mRatio = zoomRatio;
        this.mStartFramePosition = frameStartPosition;
        this.mSpenSurfaceViewBitmap = spenSurfaceViewBitmap;
        this.mBgBitmap = bgBitmap;
        this.mPageWidth = pageWidth;
        this.mPageHeight = pageHeight;
        this.updateListener = listener;
        this.mStrokeFrameAction = 1;
        this.mOriginalStroke = new ArrayList<>();
        this.mOriginalContainer = (SpenObjectContainer) this.mObjectContainer.getObject(0);
        Iterator<SpenObjectBase> it = this.mOriginalContainer.getObjectList().iterator();
        while (it.hasNext()) {
            SpenObjectBase o = it.next();
            if (o.getType() == 3) {
                this.mOriginalImage = (SpenObjectImage) o;
            } else if (o.getType() == 1) {
                this.mOriginalStroke.add(o);
            }
        }
        this.mBeautifyContainer = (SpenObjectContainer) this.mObjectContainer.getObject(1);
        this.mBeautifyImage = (SpenObjectImage) this.mBeautifyContainer.getObject(0);
        this.mPen = createPen();
        if (this.mPen == null) {
            Log.v(TAG, "Pen Create is failed");
            cancel(32);
        } else if (!startRecognition()) {
            Log.v(TAG, "Recognition is failed");
            cancel(8);
        }
    }

    public void retakeStrokeFrame(Activity activity, Bitmap spenSurfaceViewBitmap, Bitmap bgBitmap, int pageWidth, int pageHeight, int frameType, SpenObjectContainer objectContainer, SpenStrokeFrameListener listener, PointF pan, float zoomRatio, PointF frameStartPosition, ViewGroup layout) {
        boolean resultValue;
        this.mActivity = activity;
        this.mStrokeFrameType = frameType;
        this.mObjectContainer = objectContainer;
        this.mViewGroup = layout;
        this.mPan = pan;
        this.mRatio = zoomRatio;
        this.mStartFramePosition = frameStartPosition;
        this.mSpenSurfaceViewBitmap = spenSurfaceViewBitmap;
        this.mPageWidth = pageWidth;
        this.mPageHeight = pageHeight;
        this.updateListener = listener;
        this.mStrokeFrameAction = 2;
        this.mWorkBitmap = Bitmap.createBitmap(this.mPageWidth, this.mPageHeight, Bitmap.Config.ARGB_8888);
        if (this.mWorkBitmap == null) {
            Log.d(TAG, "workBitmap create is failed");
            cancel(32);
            return;
        }
        this.mShapeMaskBitmap = Bitmap.createBitmap(this.mSpenSurfaceViewBitmap.getWidth(), this.mSpenSurfaceViewBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (this.mShapeMaskBitmap == null) {
            Log.d(TAG, "ShapeMaskBitmap create is failed");
            cancel(32);
            return;
        }
        this.mOriginalStroke = new ArrayList<>();
        this.mOriginalContainer = (SpenObjectContainer) this.mObjectContainer.getObject(0);
        Iterator<SpenObjectBase> it = this.mOriginalContainer.getObjectList().iterator();
        while (it.hasNext()) {
            SpenObjectBase o = it.next();
            if (o.getType() == 3) {
                this.mOriginalImage = (SpenObjectImage) o;
            } else if (o.getType() == 1) {
                this.mOriginalStroke.add(o);
            }
        }
        this.mBeautifyStoke = new ArrayList<>();
        this.mBeautifyContainer = (SpenObjectContainer) this.mObjectContainer.getObject(1);
        Iterator<SpenObjectBase> it2 = this.mBeautifyContainer.getObjectList().iterator();
        while (it2.hasNext()) {
            SpenObjectBase o2 = it2.next();
            if (o2.getType() == 3) {
                this.mBeautifyImage = (SpenObjectImage) o2;
            } else if (o2.getType() == 1) {
                this.mBeautifyStoke.add(o2);
            }
        }
        this.mPen = createPen();
        if (this.mPen == null) {
            Log.v(TAG, "Pen Create is failed");
            cancel(32);
            return;
        }
        if (this.mStrokeFrameType == 0) {
            this.mFrameShapePath = makePath(this.mOriginalContainer);
        } else {
            this.mFrameShapePath = makePath(this.mBeautifyContainer);
        }
        this.mFrameShapePath.computeBounds(this.mRect, false);
        Path relativePath = new Path();
        RectF relativeRect = convertRelative(this.mRect);
        Matrix m = new Matrix();
        m.setRectToRect(this.mRect, relativeRect, Matrix.ScaleToFit.FILL);
        this.mFrameShapePath.transform(m, relativePath);
        createShapeMaskBitmap(relativePath);
        if (this.mStrokeFrameType == 0) {
            resultValue = drawPen(this.mShapeMaskBitmap, this.mOriginalContainer, this.mRect, relativeRect);
        } else {
            resultValue = drawPen(this.mShapeMaskBitmap, this.mBeautifyContainer, this.mRect, relativeRect);
        }
        if (!resultValue) {
            Log.e(TAG, "drawPen is failed");
            cancel(32);
            return;
        }
        setRect(relativeRect);
        if (!startCamera()) {
            Log.v(TAG, "startCamera is failed");
            cancel(32);
        }
    }

    public SpenObjectContainer cancelStrokeFrame() {
        cleanResource();
        return this.mObjectContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRect(RectF rect) {
        this.mRect = rect;
        this.mCameraViewLayoutParams = new RelativeLayout.LayoutParams((int) this.mRect.width(), (int) this.mRect.height());
        this.mCameraViewLayoutParams.setMargins((int) this.mRect.left, (int) this.mRect.top, 0, 0);
        if (this.mTouchImage != null) {
            this.mTouchImage.setLayoutParams(this.mCameraViewLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startCamera() {
        if (!loadChangeFrameButtonResources()) {
            Log.v(TAG, "ChangeFrame Resource Loading is failed");
            return false;
        }
        this.mChangeFrameButton = new ImageButton(this.mActivity);
        setChangeFrameButtonResources();
        updateChangeFrameButtonPosition();
        this.mChangeFrameButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.engine.SpenStrokeFrame.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenObjectContainer drawStroke;
                if (SpenStrokeFrame.this.mStrokeFrameType == 0) {
                    SpenStrokeFrame.this.mStrokeFrameType = 1;
                    SpenStrokeFrame.this.mFrameShapePath = SpenStrokeFrame.this.makePath(SpenStrokeFrame.this.mBeautifyContainer);
                    drawStroke = SpenStrokeFrame.this.mBeautifyContainer;
                } else {
                    SpenStrokeFrame.this.mStrokeFrameType = 0;
                    SpenStrokeFrame.this.mFrameShapePath = SpenStrokeFrame.this.makePath((SpenObjectContainer) SpenStrokeFrame.this.mObjectContainer.getObject(0));
                    drawStroke = SpenStrokeFrame.this.mOriginalContainer;
                }
                SpenStrokeFrame.this.setChangeFrameButtonResources();
                SpenStrokeFrame.this.mFrameShapePath.computeBounds(SpenStrokeFrame.this.mRect, false);
                Path relativePath = new Path();
                RectF relativeRect = SpenStrokeFrame.this.convertRelative(SpenStrokeFrame.this.mRect);
                Matrix m = new Matrix();
                m.setRectToRect(SpenStrokeFrame.this.mRect, relativeRect, Matrix.ScaleToFit.FILL);
                SpenStrokeFrame.this.mFrameShapePath.transform(m, relativePath);
                SpenStrokeFrame.this.createShapeMaskBitmap(relativePath);
                boolean resultValue = SpenStrokeFrame.this.drawPen(SpenStrokeFrame.this.mShapeMaskBitmap, drawStroke, SpenStrokeFrame.this.mRect, relativeRect);
                if (resultValue) {
                    SpenStrokeFrame.this.setRect(relativeRect);
                    SpenStrokeFrame.this.updateChangeFrameButtonPosition();
                    SpenStrokeFrame.this.mShapeMaskView.setImageBitmap(SpenStrokeFrame.this.mShapeMaskBitmap);
                } else {
                    Log.e(SpenStrokeFrame.TAG, "drawPen is failed");
                    SpenStrokeFrame.this.cancel(32);
                }
            }
        });
        this.mShapeMaskView = new ImageView(this.mActivity);
        this.mShapeMaskLayoutParams = new RelativeLayout.LayoutParams(this.mViewGroup.getWidth(), this.mViewGroup.getHeight());
        this.mShapeMaskView.setLayoutParams(this.mShapeMaskLayoutParams);
        this.mShapeMaskView.setImageBitmap(this.mShapeMaskBitmap);
        this.mShapeMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.engine.SpenStrokeFrame.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        this.mTouchImage = new ImageView(this.mActivity);
        this.mCameraView = new SpenStrokeFrameView(this.mActivity);
        if (this.mCameraView == null || this.mTouchImage == null) {
            Log.v(TAG, "CameraView or TouchImage is null. CameraView = " + this.mCameraView + "TouchImage = " + this.mTouchImage);
            return false;
        }
        this.mCameraView.requestFocusFromTouch();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1, 1);
        layoutParams.setMargins((int) this.mRect.left, (int) this.mRect.top, 0, 0);
        this.mCameraView.setLayoutParams(layoutParams);
        this.mCameraView.setZOrderMediaOverlay(true);
        this.mPreviewCallback = new SpenStrokeFrameView.OnPreviewCallback() { // from class: com.samsung.android.sdk.pen.engine.SpenStrokeFrame.3
            @Override // com.samsung.android.sdk.pen.engine.SpenStrokeFrameView.OnPreviewCallback
            public void OnPreview() {
                Camera.Size size = SpenStrokeFrame.this.mCameraView.getCamera().getParameters().getPreviewSize();
                if (size != null) {
                    float width = SpenStrokeFrame.this.mRect.width();
                    float height = SpenStrokeFrame.this.mRect.height();
                    if (Math.abs(width) >= SpenStrokeFrame.SIGMA && Math.abs(height) >= SpenStrokeFrame.SIGMA && Math.abs(size.width) >= SpenStrokeFrame.SIGMA && Math.abs(size.height) >= SpenStrokeFrame.SIGMA) {
                        if (SpenStrokeFrame.this.mActivity.getResources().getConfiguration().orientation == 1) {
                            SpenStrokeFrame.this.mPreviewRatio = size.width / size.height;
                            if (SpenStrokeFrame.this.mPreviewRatio > height / width) {
                                height = (int) (SpenStrokeFrame.this.mPreviewRatio * (width / height) * height);
                            } else {
                                width = (int) (width / (SpenStrokeFrame.this.mPreviewRatio * (width / height)));
                            }
                            if (width > height) {
                                float tmp = width;
                                width = height;
                                height = tmp;
                            }
                        } else {
                            SpenStrokeFrame.this.mPreviewRatio = size.height / size.width;
                            if (SpenStrokeFrame.this.mPreviewRatio > height / width) {
                                height = (int) (SpenStrokeFrame.this.mPreviewRatio * (width / height) * height);
                            } else {
                                width = (int) (width / (SpenStrokeFrame.this.mPreviewRatio * (width / height)));
                            }
                            if (width < height) {
                                float tmp2 = width;
                                width = height;
                                height = tmp2;
                            }
                        }
                        SpenStrokeFrame.this.mCameraViewLayoutParams = new RelativeLayout.LayoutParams((int) width, (int) height);
                        SpenStrokeFrame.this.mCameraViewLayoutParams.setMargins((int) SpenStrokeFrame.this.mRect.left, (int) SpenStrokeFrame.this.mRect.top, 0, 0);
                        SpenStrokeFrame.this.mCameraView.setLayoutParams(SpenStrokeFrame.this.mCameraViewLayoutParams);
                        return;
                    }
                    return;
                }
                Log.v(SpenStrokeFrame.TAG, "Camera PreviewSize is null");
            }
        };
        this.mCameraView.setOnPreviewCallback(this.mPreviewCallback);
        this.mTouchImage.setLayoutParams(this.mCameraViewLayoutParams);
        this.mTouchImage.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.engine.SpenStrokeFrame.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                float checkDistance;
                int cX;
                int cY;
                switch (event.getAction()) {
                    case 0:
                        SpenStrokeFrame.this.mTouchCheckPath.reset();
                        SpenStrokeFrame.this.mTouchCheckPath.moveTo(event.getX(), event.getY());
                        SpenStrokeFrame.this.mPrevTouchPoint.set(event.getX(), event.getY());
                        SpenStrokeFrame.this.mZoomMode = 1;
                        SpenStrokeFrame.this.mZoomY = event.getY();
                        SpenStrokeFrame spenStrokeFrame = SpenStrokeFrame.this;
                        SpenStrokeFrame spenStrokeFrame2 = SpenStrokeFrame.this;
                        int i = SpenStrokeFrame.this.mZoomCur;
                        spenStrokeFrame2.mZoomLast = i;
                        spenStrokeFrame.mZoomPrev = i;
                        break;
                    case 1:
                        PathMeasure pm = new PathMeasure(SpenStrokeFrame.this.mTouchCheckPath, false);
                        if (event.getToolType(0) == 2) {
                            checkDistance = 50.0f;
                        } else {
                            checkDistance = 10.0f;
                        }
                        if (pm.getLength() < checkDistance) {
                            SpenStrokeFrame.this.mCameraView.takePicture();
                            SpenStrokeFrame.this.mZoomMode = 0;
                            break;
                        } else {
                            if (SpenStrokeFrame.this.mZoomMode == 1) {
                                if (SpenStrokeFrame.this.mRect.width() / SpenStrokeFrame.this.mRect.height() > SpenStrokeFrame.this.mPreviewRatio) {
                                    cX = (int) (((event.getX() - (SpenStrokeFrame.this.mRect.width() / 2.0f)) / SpenStrokeFrame.this.mRect.width()) * (-2000.0f));
                                    if (cX < -970) {
                                        cX = -970;
                                    }
                                    if (cX > 970) {
                                        cX = 970;
                                    }
                                    cY = (int) (((event.getY() - (SpenStrokeFrame.this.mRect.height() / 2.0f)) / (SpenStrokeFrame.this.mRect.width() * SpenStrokeFrame.this.mPreviewRatio)) * 2000.0f);
                                    if (cY < -970) {
                                        cY = -970;
                                    }
                                    if (cY > 970) {
                                        cY = 970;
                                    }
                                } else {
                                    cX = (int) (((event.getX() - (SpenStrokeFrame.this.mRect.width() / 2.0f)) / (SpenStrokeFrame.this.mRect.height() / SpenStrokeFrame.this.mPreviewRatio)) * (-2000.0f));
                                    if (cX < -970) {
                                        cX = -970;
                                    }
                                    if (cX > 970) {
                                        cX = 970;
                                    }
                                    cY = (int) (((event.getY() - (SpenStrokeFrame.this.mRect.height() / 2.0f)) / SpenStrokeFrame.this.mRect.height()) * 2000.0f);
                                    if (cY < -970) {
                                        cY = -970;
                                    }
                                    if (cY > 970) {
                                        cY = 970;
                                    }
                                }
                                SpenStrokeFrame.this.mCameraView.setFocus(new Rect(cY - 30, cX - 30, cY + 30, cX + 30));
                            }
                            SpenStrokeFrame.this.mZoomMode = 0;
                            break;
                        }
                    case 2:
                        SpenStrokeFrame.this.mCameraView.cancelAutoFocus();
                        float curX = event.getX();
                        float curY = event.getY();
                        SpenStrokeFrame.this.mTouchCheckPath.lineTo(curX, curY);
                        SpenStrokeFrame.this.mPrevTouchPoint.set(curX, curY);
                        int zoom = ((int) (SpenStrokeFrame.this.mZoomY - curY)) / 5;
                        if (100 - SpenStrokeFrame.this.mZoomLast < zoom) {
                            zoom = 100 - SpenStrokeFrame.this.mZoomLast;
                        }
                        if (zoom > 10) {
                            SpenStrokeFrame.this.mZoomMode = 2;
                        }
                        SpenStrokeFrame.this.mZoomCur = SpenStrokeFrame.this.mZoomLast + zoom;
                        if (SpenStrokeFrame.this.mZoomCur < 0) {
                            SpenStrokeFrame.this.mZoomCur = 0;
                            SpenStrokeFrame.this.mZoomLast = 0;
                            SpenStrokeFrame.this.mZoomY = curY;
                            break;
                        } else if (SpenStrokeFrame.this.mZoomCur > 100) {
                            SpenStrokeFrame.this.mZoomCur = 100;
                            SpenStrokeFrame.this.mZoomLast = 100;
                            SpenStrokeFrame.this.mZoomY = curY;
                            break;
                        } else if (SpenStrokeFrame.this.mZoomPrev != SpenStrokeFrame.this.mZoomCur) {
                            SpenStrokeFrame.this.mZoomPrev = SpenStrokeFrame.this.mZoomCur;
                            SpenStrokeFrame.this.mCameraView.setZoom(SpenStrokeFrame.this.mZoomCur);
                            break;
                        }
                        break;
                }
                return true;
            }
        });
        SpenStrokeFrameView.OnCompleteCameraFrameListener listener = new SpenStrokeFrameView.OnCompleteCameraFrameListener() { // from class: com.samsung.android.sdk.pen.engine.SpenStrokeFrame.5
            @Override // com.samsung.android.sdk.pen.engine.SpenStrokeFrameView.OnCompleteCameraFrameListener
            public void onComplete(byte[] arg0) {
                if (SpenStrokeFrame.this.mWorkBitmap != null) {
                    SpenStrokeFrame.this.mWorkBitmap.recycle();
                    SpenStrokeFrame.this.mWorkBitmap = null;
                }
                if (SpenStrokeFrame.this.mBgBitmap != null) {
                    SpenStrokeFrame.this.mBgBitmap.recycle();
                    SpenStrokeFrame.this.mBgBitmap = null;
                }
                if (SpenStrokeFrame.this.mShapeMaskBitmap != null) {
                    SpenStrokeFrame.this.mShapeMaskBitmap.recycle();
                    SpenStrokeFrame.this.mShapeMaskBitmap = null;
                }
                if (arg0 == null) {
                    Log.v(SpenStrokeFrame.TAG, "Camera onComplete arg0 is null");
                    SpenStrokeFrame.this.cancel(32);
                    return;
                }
                Bitmap bitmap = BitmapFactory.decodeByteArray(arg0, 0, arg0.length, null);
                if (bitmap != null) {
                    SpenStrokeFrame.this.mPreviewRatio = bitmap.getWidth() / bitmap.getHeight();
                    Bitmap rotateBitmap = SpenStrokeFrame.this.createRotateBitmap(bitmap);
                    RectF absoluteRect = new RectF();
                    SpenStrokeFrame.this.mFrameShapePath = SpenStrokeFrame.this.makePath(SpenStrokeFrame.this.mOriginalContainer);
                    SpenStrokeFrame.this.mFrameShapePath.computeBounds(absoluteRect, false);
                    Path relativePath = new Path();
                    RectF relativeRect = SpenStrokeFrame.this.convertRelative(absoluteRect);
                    Matrix m = new Matrix();
                    m.setRectToRect(absoluteRect, relativeRect, Matrix.ScaleToFit.FILL);
                    SpenStrokeFrame.this.mFrameShapePath.transform(m, relativePath);
                    Bitmap fitBitmap = SpenStrokeFrame.this.createSizeFitableBitmap(rotateBitmap, relativeRect);
                    if (fitBitmap != null) {
                        Bitmap resultBitmap = SpenStrokeFrame.this.createStrokeFrameBitmap(fitBitmap, relativePath);
                        if (resultBitmap != null) {
                            fitBitmap.recycle();
                            SpenStrokeFrame.this.mOriginalImage.setRect(absoluteRect, false);
                            SpenStrokeFrame.this.mOriginalImage.setImage(resultBitmap);
                            resultBitmap.recycle();
                            SpenStrokeFrame.this.mFrameShapePath = SpenStrokeFrame.this.makePath(SpenStrokeFrame.this.mBeautifyContainer);
                            SpenStrokeFrame.this.mFrameShapePath.computeBounds(absoluteRect, false);
                            Path relativePath2 = new Path();
                            RectF relativeRect2 = SpenStrokeFrame.this.convertRelative(absoluteRect);
                            Matrix m2 = new Matrix();
                            m2.setRectToRect(absoluteRect, relativeRect2, Matrix.ScaleToFit.FILL);
                            SpenStrokeFrame.this.mFrameShapePath.transform(m2, relativePath2);
                            Bitmap fitBitmap2 = SpenStrokeFrame.this.createSizeFitableBitmap(rotateBitmap, relativeRect2);
                            if (fitBitmap2 == null) {
                                Log.v(SpenStrokeFrame.TAG, "Camera onComplete Bitmap is null");
                                SpenStrokeFrame.this.cancel(32);
                                return;
                            }
                            bitmap.recycle();
                            rotateBitmap.recycle();
                            Bitmap resultBitmap2 = SpenStrokeFrame.this.createStrokeFrameBitmap(fitBitmap2, relativePath2);
                            if (resultBitmap2 == null) {
                                Log.v(SpenStrokeFrame.TAG, "Beautify Stroke Frame ResultBitmap is null");
                                SpenStrokeFrame.this.cancel(32);
                                return;
                            }
                            fitBitmap2.recycle();
                            SpenStrokeFrame.this.mBeautifyImage.setRect(absoluteRect, false);
                            SpenStrokeFrame.this.mBeautifyImage.setImage(resultBitmap2);
                            resultBitmap2.recycle();
                            SpenStrokeFrame.this.mObjectContainer.setMinSize(10.0f, 10.0f);
                            SpenStrokeFrame.this.updateListener.onCompleted(SpenStrokeFrame.this.mStrokeFrameType, SpenStrokeFrame.this.mObjectContainer);
                            SpenStrokeFrame.this.cleanResource();
                            return;
                        }
                        SpenStrokeFrame.this.cleanResource();
                        SpenStrokeFrame.this.cancel(32);
                        return;
                    }
                    SpenStrokeFrame.this.cleanResource();
                    Log.v(SpenStrokeFrame.TAG, "Camera onComplete Bitmap is null");
                    SpenStrokeFrame.this.cancel(32);
                    return;
                }
                SpenStrokeFrame.this.cleanResource();
                Log.v(SpenStrokeFrame.TAG, "Camera onComplete Bitmap is null");
                SpenStrokeFrame.this.cancel(32);
            }
        };
        this.mCameraView.setOnCompleteCameraFrameListener(listener);
        this.mViewGroup.addView(this.mCameraView);
        this.mViewGroup.addView(this.mShapeMaskView);
        this.mViewGroup.addView(this.mTouchImage);
        this.mViewGroup.addView(this.mChangeFrameButton);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap createStrokeFrameBitmap(Bitmap src, Path relativePath) {
        if (src == null || relativePath == null) {
            Log.v(TAG, "createStrokeFrameBitmap src or rect  is nullsrc " + src + " relativePath " + relativePath);
            return null;
        }
        RectF r = new RectF();
        relativePath.computeBounds(r, false);
        Bitmap resultBitmap = Bitmap.createBitmap((int) r.width(), (int) r.height(), Bitmap.Config.ARGB_8888);
        if (resultBitmap == null) {
            Log.d(TAG, "resultBitmap createBitmap is failed. out fof memory");
            return null;
        }
        relativePath.offset(-r.left, -r.top);
        Canvas backCanvas = new Canvas(resultBitmap);
        backCanvas.clipPath(relativePath, Region.Op.INTERSECT);
        backCanvas.drawBitmap(src, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
        return resultBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createShapeMaskBitmap(Path path) {
        Canvas canvas = new Canvas(this.mShapeMaskBitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        canvas.clipPath(path, Region.Op.XOR);
        canvas.drawBitmap(this.mSpenSurfaceViewBitmap, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean drawPen(Bitmap dst, SpenObjectContainer strokeContainer, RectF absoluteRect, RectF relativeRect) {
        if (this.mWorkBitmap == null) {
            Log.d(TAG, "workBitmap isn't created");
            return false;
        }
        Canvas c = new Canvas(this.mWorkBitmap);
        c.drawColor(0, PorterDuff.Mode.SRC);
        this.mPen.setReferenceBitmap(this.mBgBitmap);
        this.mPen.setBitmap(this.mWorkBitmap);
        ArrayList<SpenObjectBase> oList = strokeContainer.getObjectList();
        Iterator<SpenObjectBase> it = oList.iterator();
        while (it.hasNext()) {
            SpenObjectBase o = it.next();
            if (o.getType() == 1) {
                SpenObjectStroke s = (SpenObjectStroke) o;
                PointF[] point = s.getPoints();
                float[] pressures = s.getPressures();
                int length = point.length;
                if (length >= 2) {
                    int[] time = s.getTimeStamps();
                    RectF r = new RectF();
                    MotionEvent e = MotionEvent.obtain(time[0], time[0], 1, point[0].x, point[0].y, pressures[0], 1.0f, 0, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0, 0);
                    for (int i = 1; i < length; i++) {
                        e.addBatch(time[i], point[i].x, point[i].y, pressures[i], 1.0f, 0);
                    }
                    this.mPen.redrawPen(e, r);
                }
            }
        }
        RectF srcRect = new RectF(absoluteRect);
        increaseRect(srcRect, this.mPenSize);
        RectF dstRect = new RectF(relativeRect);
        increaseRect(dstRect, this.mPenSize * this.mRatio);
        Canvas dstCanvas = new Canvas(dst);
        dstCanvas.drawBitmap(this.mWorkBitmap, new Rect((int) srcRect.left, (int) srcRect.top, (int) srcRect.right, (int) srcRect.bottom), new Rect((int) dstRect.left, (int) dstRect.top, (int) dstRect.right, (int) dstRect.bottom), (Paint) null);
        this.mPen.setBitmap(null);
        this.mPen.setReferenceBitmap(null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Path makePath(SpenObjectContainer container) {
        ArrayList<SpenObjectStroke> strokeList = new ArrayList<>();
        ArrayList<SpenObjectBase> containerList = container.getObjectList();
        for (int i = 0; i < containerList.size(); i++) {
            if (containerList.get(i).getType() == 1) {
                strokeList.add((SpenObjectStroke) containerList.get(i));
            }
        }
        Path path = new Path();
        int size = strokeList.size();
        int[] used = new int[size];
        used[0] = 1;
        for (int i2 = 1; i2 < size; i2++) {
            used[i2] = 0;
        }
        float lastX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        float lastY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        PointF[] pf = strokeList.get(0).getPoints();
        path.moveTo(pf[0].x, pf[0].y);
        for (int i3 = 1; i3 < pf.length; i3++) {
            lastX = pf[i3].x;
            lastY = pf[i3].y;
            path.lineTo(lastX, lastY);
        }
        for (int i4 = 1; i4 < size; i4++) {
            int nextStroke = 0;
            boolean isStart = true;
            float minLength = 1000.0f;
            for (int j = 1; j < size; j++) {
                if (used[j] != 1) {
                    if (nextStroke == 0) {
                        nextStroke = j;
                        PointF[] nextPoint = strokeList.get(j).getPoints();
                        if (nextPoint == null || nextPoint.length == 0) {
                            Log.d(TAG, "nextPoint is null");
                            return null;
                        }
                        float sx = nextPoint[0].x;
                        float sy = nextPoint[0].y;
                        float ex = nextPoint[nextPoint.length - 1].x;
                        float ey = nextPoint[nextPoint.length - 1].y;
                        if (((lastX - sx) * (lastX - sx)) + ((lastY - sy) * (lastY - sy)) > ((lastX - ex) * (lastX - ex)) + ((lastY - ey) * (lastY - ey))) {
                            minLength = ((lastX - ex) * (lastX - ex)) + ((lastY - ey) * (lastY - ey));
                            isStart = false;
                        } else {
                            minLength = ((lastX - sx) * (lastX - sx)) + ((lastY - sy) * (lastY - sy));
                            isStart = true;
                        }
                    } else {
                        PointF[] nextPoint2 = strokeList.get(j).getPoints();
                        if (nextPoint2 == null || nextPoint2.length == 0) {
                            Log.d(TAG, "nextPoint is null");
                            return null;
                        }
                        float sx2 = nextPoint2[0].x;
                        float sy2 = nextPoint2[0].y;
                        float ex2 = nextPoint2[nextPoint2.length - 1].x;
                        float ey2 = nextPoint2[nextPoint2.length - 1].y;
                        if (minLength > ((lastX - sx2) * (lastX - sx2)) + ((lastY - sy2) * (lastY - sy2))) {
                            minLength = ((lastX - sx2) * (lastX - sx2)) + ((lastY - sy2) * (lastY - sy2));
                            nextStroke = j;
                            isStart = true;
                        } else if (minLength > ((lastX - ex2) * (lastX - ex2)) + ((lastY - ey2) * (lastY - ey2))) {
                            minLength = ((lastX - ex2) * (lastX - ex2)) + ((lastY - ey2) * (lastY - ey2));
                            nextStroke = j;
                            isStart = false;
                        }
                    }
                }
            }
            if (nextStroke != 0) {
                used[nextStroke] = 1;
                PointF[] nextPoint3 = strokeList.get(nextStroke).getPoints();
                if (isStart) {
                    for (int j2 = 0; j2 < nextPoint3.length; j2++) {
                        lastX = nextPoint3[j2].x;
                        lastY = nextPoint3[j2].y;
                        path.lineTo(lastX, lastY);
                    }
                } else {
                    for (int j3 = nextPoint3.length - 1; j3 >= 0; j3--) {
                        lastX = nextPoint3[j3].x;
                        lastY = nextPoint3[j3].y;
                        path.lineTo(lastX, lastY);
                    }
                }
            } else {
                return path;
            }
        }
        return path;
    }

    private SpenPen createPen() {
        if (this.mOriginalStroke.size() < 1) {
            Log.d(TAG, "OriginalStroke Size = 0");
            return null;
        }
        SpenObjectStroke s = (SpenObjectStroke) this.mOriginalStroke.get(0);
        SpenPenManager penManager = new SpenPenManager(this.mActivity);
        try {
            SpenPen pen = penManager.createPen(s.getPenName());
            if (pen.getPenAttribute(0)) {
                this.mPenSize = s.getPenSize();
                pen.setSize(this.mPenSize);
            }
            if (pen.getPenAttribute(3)) {
                pen.setCurveEnabled(s.isCurveEnabled());
            }
            if (pen.getPenAttribute(2)) {
                pen.setColor(s.getColor());
            }
            if (pen.getPenAttribute(4)) {
                pen.setAdvancedSetting(s.getAdvancedPenSetting());
                return pen;
            }
            return pen;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private boolean startRecognition() {
        SpenShapeRecognitionManager srm = new SpenShapeRecognitionManager(this.mActivity);
        List<SpenRecognitionInfo> infoList = srm.getInfoList(1, 4);
        try {
            this.mShapeRecognition = srm.createRecognition(infoList.get(0));
            this.mShapeRecognition.setResultListener(new SpenRecognitionBase.ResultListener() { // from class: com.samsung.android.sdk.pen.engine.SpenStrokeFrame.6
                @Override // com.samsung.android.sdk.pen.recognition.SpenRecognitionBase.ResultListener
                public void onResult(List<SpenObjectBase> input, List<SpenObjectBase> output) {
                    Path otherPath;
                    if (output == null) {
                        Log.d(SpenStrokeFrame.TAG, "Beautify result is null. so this action is canceled");
                        SpenStrokeFrame.this.cancel(8);
                        return;
                    }
                    SpenObjectContainer resultContainer = (SpenObjectContainer) output.get(0);
                    Iterator<SpenObjectBase> it = resultContainer.getObjectList().iterator();
                    while (it.hasNext()) {
                        SpenObjectBase o = it.next();
                        SpenStrokeFrame.this.mBeautifyContainer.appendObject(o);
                    }
                    new Path();
                    RectF otherRect = new RectF();
                    if (SpenStrokeFrame.this.mStrokeFrameType == 0) {
                        SpenStrokeFrame.this.mFrameShapePath = SpenStrokeFrame.this.makePath(SpenStrokeFrame.this.mOriginalContainer);
                        otherPath = SpenStrokeFrame.this.makePath(SpenStrokeFrame.this.mBeautifyContainer);
                    } else {
                        SpenStrokeFrame.this.mFrameShapePath = SpenStrokeFrame.this.makePath(SpenStrokeFrame.this.mBeautifyContainer);
                        otherPath = SpenStrokeFrame.this.makePath(SpenStrokeFrame.this.mOriginalContainer);
                    }
                    if (SpenStrokeFrame.this.mFrameShapePath != null && otherPath != null) {
                        SpenStrokeFrame.this.mFrameShapePath.computeBounds(SpenStrokeFrame.this.mRect, false);
                        otherPath.computeBounds(otherRect, false);
                        RectF relativePageRect = SpenStrokeFrame.this.convertRelative(new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, SpenStrokeFrame.this.mPageWidth, SpenStrokeFrame.this.mPageHeight));
                        RectF absolutePageRect = SpenStrokeFrame.this.convertAbsolute(relativePageRect);
                        if (!absolutePageRect.contains(otherRect) || !absolutePageRect.contains(SpenStrokeFrame.this.mRect)) {
                            Log.d(SpenStrokeFrame.TAG, "StrokeFrame Rect is outside of Page. StrokeFrameType = " + SpenStrokeFrame.this.mStrokeFrameType + " Rect 2 = " + otherRect);
                            SpenStrokeFrame.this.cancel(16);
                            return;
                        }
                        if (SpenStrokeFrame.this.mRect.width() < 10.0f || SpenStrokeFrame.this.mRect.height() < 10.0f) {
                            Log.d(SpenStrokeFrame.TAG, "StrokeFrame Rect is too small. StrokeFrameType = " + SpenStrokeFrame.this.mStrokeFrameType + " Rect 1 = " + SpenStrokeFrame.this.mRect);
                            SpenStrokeFrame.this.cancel(4);
                            return;
                        }
                        if (otherRect.width() >= 10.0f && otherRect.height() >= 10.0f) {
                            SpenStrokeFrame.this.mWorkBitmap = Bitmap.createBitmap(SpenStrokeFrame.this.mPageWidth, SpenStrokeFrame.this.mPageHeight, Bitmap.Config.ARGB_8888);
                            if (SpenStrokeFrame.this.mWorkBitmap != null) {
                                SpenStrokeFrame.this.mShapeMaskBitmap = Bitmap.createBitmap(SpenStrokeFrame.this.mSpenSurfaceViewBitmap.getWidth(), SpenStrokeFrame.this.mSpenSurfaceViewBitmap.getHeight(), Bitmap.Config.ARGB_8888);
                                if (SpenStrokeFrame.this.mShapeMaskBitmap == null) {
                                    Log.d(SpenStrokeFrame.TAG, "ShapeMaskBitmap create is failed");
                                    SpenStrokeFrame.this.cancel(32);
                                    return;
                                }
                                Path relativePath = new Path();
                                RectF relativeRect = SpenStrokeFrame.this.convertRelative(SpenStrokeFrame.this.mRect);
                                Matrix m = new Matrix();
                                m.setRectToRect(SpenStrokeFrame.this.mRect, relativeRect, Matrix.ScaleToFit.FILL);
                                SpenStrokeFrame.this.mFrameShapePath.transform(m, relativePath);
                                SpenStrokeFrame.this.createShapeMaskBitmap(relativePath);
                                boolean resultValue = SpenStrokeFrame.this.mStrokeFrameType == 0 ? SpenStrokeFrame.this.drawPen(SpenStrokeFrame.this.mShapeMaskBitmap, SpenStrokeFrame.this.mOriginalContainer, SpenStrokeFrame.this.mRect, relativeRect) : SpenStrokeFrame.this.drawPen(SpenStrokeFrame.this.mShapeMaskBitmap, SpenStrokeFrame.this.mBeautifyContainer, SpenStrokeFrame.this.mRect, relativeRect);
                                if (resultValue) {
                                    SpenStrokeFrame.this.setRect(relativeRect);
                                    if (!SpenStrokeFrame.this.startCamera()) {
                                        Log.v(SpenStrokeFrame.TAG, "startCamera is failed");
                                        SpenStrokeFrame.this.cancel(32);
                                        return;
                                    }
                                    return;
                                }
                                Log.e(SpenStrokeFrame.TAG, "drawPen is failed");
                                SpenStrokeFrame.this.cancel(32);
                                return;
                            }
                            Log.d(SpenStrokeFrame.TAG, "workBitmap create is failed");
                            SpenStrokeFrame.this.cancel(32);
                            return;
                        }
                        Log.d(SpenStrokeFrame.TAG, "StrokeFrame Rect is too small. StrokeFrameType = " + SpenStrokeFrame.this.mStrokeFrameType + " Rect 2 = " + otherRect);
                        SpenStrokeFrame.this.cancel(8);
                        return;
                    }
                    Log.d(SpenStrokeFrame.TAG, "Cancel cause failed to recognize");
                    SpenStrokeFrame.this.cancel(8);
                }
            });
            this.mShapeRecognition.request(this.mOriginalStroke);
            return true;
        } catch (SpenCreationFailureException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanResource() {
        if (this.mShapeRecognition != null) {
            try {
                this.mShapeRecognition.setResultListener(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            SpenShapeRecognitionManager srm = new SpenShapeRecognitionManager(this.mActivity);
            srm.destroyRecognition(this.mShapeRecognition);
            this.mShapeRecognition = null;
        }
        if (this.mChangeFrameButton != null) {
            this.mViewGroup.removeView(this.mChangeFrameButton);
            this.mChangeFrameButton = null;
        }
        if (this.mTouchImage != null) {
            this.mViewGroup.removeView(this.mTouchImage);
            this.mTouchImage = null;
        }
        if (this.mCameraView != null) {
            this.mCameraView.stop();
            this.mViewGroup.removeView(this.mCameraView);
            this.mCameraView = null;
        }
        if (this.mShapeMaskView != null) {
            this.mViewGroup.removeView(this.mShapeMaskView);
            this.mShapeMaskView = null;
        }
        if (this.mPen != null) {
            this.mPen.setBitmap(null);
            this.mPen.setReferenceBitmap(null);
            SpenPenManager penManager = new SpenPenManager(this.mActivity);
            penManager.destroyPen(this.mPen);
            this.mPen = null;
        }
        if (this.mWorkBitmap != null) {
            this.mWorkBitmap.recycle();
            this.mWorkBitmap = null;
        }
        if (this.mBgBitmap != null) {
            this.mBgBitmap.recycle();
            this.mBgBitmap = null;
        }
        if (this.mSpenSurfaceViewBitmap != null) {
            this.mSpenSurfaceViewBitmap.recycle();
            this.mSpenSurfaceViewBitmap = null;
        }
        if (this.mShapeMaskBitmap != null) {
            this.mShapeMaskBitmap.recycle();
            this.mShapeMaskBitmap = null;
        }
        if (this.mChangeFrameOriginalDrawable != null) {
            this.mChangeFrameOriginalDrawable = null;
        }
        if (this.mChangeFrameBeautifyDrawable != null) {
            this.mChangeFrameBeautifyDrawable = null;
        }
        if (this.mChangeFrameBgDrawable != null) {
            this.mChangeFrameBgDrawable = null;
        }
        this.mActivity = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap createRotateBitmap(Bitmap src) {
        Matrix matrix = new Matrix();
        matrix.setRotate(this.mCameraView.getCameraDegree(), src.getWidth() / 2.0f, src.getHeight() / 2.0f);
        Bitmap rotateBitmap = Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
        if (rotateBitmap == null) {
            Log.v(TAG, "rotateBitmap is null. out of memory");
            return null;
        }
        return rotateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap createSizeFitableBitmap(Bitmap src, RectF dstRect) {
        float width = dstRect.width();
        float height = dstRect.height();
        if (width == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || height == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            Log.v(TAG, "width or height is 0. width = " + width + " height = " + height);
            return null;
        }
        if (this.mActivity.getResources().getConfiguration().orientation == 1) {
            if (this.mPreviewRatio > height / width) {
                height = (int) (this.mPreviewRatio * (width / height) * height);
                float margin = this.mViewGroup.getHeight() - this.mRect.top;
                if (margin < height) {
                    height = margin;
                }
            } else {
                width = (int) (width / (this.mPreviewRatio * (width / height)));
                float margin2 = this.mViewGroup.getWidth() - this.mRect.left;
                if (margin2 < width) {
                    width = margin2;
                }
            }
        } else if (this.mPreviewRatio > width / height) {
            width = (int) (this.mPreviewRatio * (height / width) * width);
            float margin3 = this.mViewGroup.getWidth() - this.mRect.left;
            if (margin3 < width) {
                width = margin3;
            }
        } else {
            height = (int) (height / (this.mPreviewRatio * (height / width)));
            float margin4 = this.mViewGroup.getHeight() - this.mRect.top;
            if (margin4 < height) {
                height = margin4;
            }
        }
        if (width <= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || height <= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            Log.v(TAG, "width or height is 0. width = " + width + " height = " + height);
            return null;
        }
        Bitmap resultBitmap = Bitmap.createBitmap((int) width, (int) height, Bitmap.Config.ARGB_8888);
        if (resultBitmap == null) {
            Log.v(TAG, "resultBitmap is null. out of memory");
            return null;
        }
        Canvas canvas = new Canvas(resultBitmap);
        Rect r = new Rect(0, 0, (int) width, (int) height);
        canvas.drawBitmap(src, new Rect(0, 0, src.getWidth(), src.getHeight()), r, (Paint) null);
        return resultBitmap;
    }

    private int getIntValueAppliedDensity(float paramFloat) {
        return Math.round(this.f400dm.density * paramFloat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF convertRelative(RectF srcRect) {
        RectF dstRect = new RectF();
        dstRect.left = ((srcRect.left - this.mPan.x) * this.mRatio) + this.mStartFramePosition.x;
        dstRect.right = ((srcRect.right - this.mPan.x) * this.mRatio) + this.mStartFramePosition.x;
        dstRect.top = ((srcRect.top - this.mPan.y) * this.mRatio) + this.mStartFramePosition.y;
        dstRect.bottom = ((srcRect.bottom - this.mPan.y) * this.mRatio) + this.mStartFramePosition.y;
        return dstRect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel(int causeCode) {
        cleanResource();
        if (this.mStrokeFrameAction == 1) {
            this.updateListener.onCanceled(causeCode | 1, this.mObjectContainer);
        } else {
            this.updateListener.onCanceled(causeCode | 2, this.mObjectContainer);
        }
    }

    private boolean loadChangeFrameButtonResources() throws PackageManager.NameNotFoundException {
        PackageManager pm = this.mActivity.getPackageManager();
        if (pm == null) {
            Log.v(TAG, "PackageManager is null");
            return false;
        }
        try {
            Resources res = pm.getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
            this.f400dm = res.getDisplayMetrics();
            if (this.f400dm == null) {
                Log.v(TAG, "DisplayMetrics Get is failed");
                return false;
            }
            int beautifyDescriptionID = res.getIdentifier(CHANGE_STROKE_FRAME_BEAUTIFY_DESCRIPTION_NAME, VLConfigParser.TYPE_STRING, Spen.SPEN_NATIVE_PACKAGE_NAME);
            int originalDescriptionID = res.getIdentifier(CHANGE_STROKE_FRAME_ORIGINAL_DESCRIPTION_NAME, VLConfigParser.TYPE_STRING, Spen.SPEN_NATIVE_PACKAGE_NAME);
            int bgDrawableID = res.getIdentifier(CHANGE_STROKE_FRAME_BG_DRAWABLE_NAME, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
            int beautifyDrawableID = res.getIdentifier(CHANGE_STROKE_FRAME_BEAUTIFY_DRAWABLE_NAME, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
            int originalDrawableID = res.getIdentifier(CHANGE_STROKE_FRAME_ORIGINAL_DRAWABLE_NAME, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
            if (originalDescriptionID == 0 || beautifyDescriptionID == 0 || bgDrawableID == 0 || beautifyDrawableID == 0 || originalDrawableID == 0) {
                Log.v(TAG, "ChangeFrame Resource not found. Original = " + originalDescriptionID + " Beautify = " + beautifyDescriptionID + " BgDrawable = " + bgDrawableID + " BeautifyDrawable = " + beautifyDrawableID + " OriginalDrawable = " + originalDrawableID);
                return false;
            }
            this.mChangeFrameDescriptionOriginal = res.getString(originalDescriptionID);
            this.mChangeFrameDescriptionBeautify = res.getString(beautifyDescriptionID);
            this.mChangeFrameBgDrawable = res.getDrawable(bgDrawableID);
            this.mChangeFrameOriginalDrawable = SpenScreenCodecDecoder.getDrawable(res, originalDrawableID);
            this.mChangeFrameBeautifyDrawable = SpenScreenCodecDecoder.getDrawable(res, beautifyDrawableID);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Log.v(TAG, "SpenSDK Resource not found");
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChangeFrameButtonResources() {
        if (this.mChangeFrameButton == null) {
            Log.d(TAG, "ChangeFrameButton isn't created yet");
            return;
        }
        if (Build.VERSION.SDK_INT < 16) {
            this.mChangeFrameButton.setBackgroundDrawable(this.mChangeFrameBgDrawable);
        } else {
            this.mChangeFrameButton.setBackground(this.mChangeFrameBgDrawable);
        }
        if (this.mStrokeFrameType == 0) {
            this.mChangeFrameButton.setImageDrawable(this.mChangeFrameBeautifyDrawable);
            this.mChangeFrameButton.setContentDescription(this.mChangeFrameDescriptionBeautify);
        } else {
            this.mChangeFrameButton.setImageDrawable(this.mChangeFrameOriginalDrawable);
            this.mChangeFrameButton.setContentDescription(this.mChangeFrameDescriptionOriginal);
        }
        this.mChangeFrameButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChangeFrameButtonPosition() {
        if (this.mChangeFrameButton == null) {
            Log.d(TAG, "ChangeFrameButton isn't created yet");
            return;
        }
        int h = this.mViewGroup.getHeight();
        Rect r = new Rect();
        int key = this.f400dm.widthPixels + this.f400dm.heightPixels;
        if (!CHANGE_STROKE_FRAME_IMAGE_UX_TABLE.containsKey(Integer.valueOf(key))) {
            key = HASH_KEY_PIXEL_DEFAULT;
        }
        Rect topMargin = CHANGE_STROKE_FRAME_IMAGE_UX_TABLE.get(Integer.valueOf(key)).get(Integer.valueOf(HASH_KEY_IMAGE_MARGIN_WHEN_TOP));
        Rect bottomMargin = CHANGE_STROKE_FRAME_IMAGE_UX_TABLE.get(Integer.valueOf(key)).get(Integer.valueOf(HASH_KEY_IMAGE_MARGIN_WHEN_TOP));
        Rect size = CHANGE_STROKE_FRAME_IMAGE_UX_TABLE.get(Integer.valueOf(key)).get(Integer.valueOf(HASH_KEY_IMAGE_SIZE));
        if (h - this.mRect.bottom >= getIntValueAppliedDensity(size.height() + bottomMargin.top)) {
            r.left = ((int) this.mRect.right) - getIntValueAppliedDensity(size.width() - bottomMargin.right);
            r.top = ((int) this.mRect.bottom) + getIntValueAppliedDensity(bottomMargin.top);
            r.right = r.left + getIntValueAppliedDensity(size.width());
            r.bottom = r.top + getIntValueAppliedDensity(size.height());
        } else if (this.mRect.top >= getIntValueAppliedDensity(size.height() + topMargin.bottom)) {
            r.left = ((int) this.mRect.right) - getIntValueAppliedDensity(size.width() - topMargin.right);
            r.top = ((int) this.mRect.top) - getIntValueAppliedDensity(size.height() + topMargin.bottom);
            r.right = r.left + getIntValueAppliedDensity(size.width());
            r.bottom = r.top + getIntValueAppliedDensity(size.height());
        } else {
            Rect margin = CHANGE_STROKE_FRAME_IMAGE_UX_TABLE.get(Integer.valueOf(key)).get(Integer.valueOf(HASH_KEY_IMAGE_MARGIN));
            r.left = ((int) this.mRect.right) - getIntValueAppliedDensity(size.width() + margin.right);
            r.top = this.mViewGroup.getHeight() - getIntValueAppliedDensity(size.height() + margin.bottom);
            r.right = r.left + getIntValueAppliedDensity(size.width());
            r.bottom = r.top + getIntValueAppliedDensity(size.height());
        }
        RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams(r.width(), r.height());
        layout.setMargins(r.left, r.top, 0, 0);
        this.mChangeFrameButton.setLayoutParams(layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF convertAbsolute(RectF relativeRect) {
        RectF dstRect = new RectF();
        dstRect.left = ((relativeRect.left - this.mStartFramePosition.x) / this.mRatio) + this.mPan.x;
        dstRect.right = ((relativeRect.right - this.mStartFramePosition.x) / this.mRatio) + this.mPan.x;
        dstRect.top = ((relativeRect.top - this.mStartFramePosition.y) / this.mRatio) + this.mPan.y;
        dstRect.bottom = ((relativeRect.bottom - this.mStartFramePosition.y) / this.mRatio) + this.mPan.y;
        return dstRect;
    }

    private void increaseRect(RectF rect, float value) {
        rect.left -= value;
        rect.top -= value;
        rect.right += value;
        rect.bottom += value;
    }
}
