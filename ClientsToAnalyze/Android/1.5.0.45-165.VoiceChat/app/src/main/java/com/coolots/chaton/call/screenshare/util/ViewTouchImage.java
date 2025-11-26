package com.coolots.chaton.call.screenshare.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.coolots.chaton.call.screenshare.DocsViewActivity;
import com.samsung.android.sdk.pen.engine.SpenMultiView;
import com.sds.coolots.common.util.Log;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class ViewTouchImage extends ImageView implements View.OnTouchListener, GestureDetector.OnGestureListener {
    private static final String CLASSNAME = "[ViewTouchImage]";
    private static final int DRAG = 1;
    private static final int FLINKING_DOWN_POSSIBLE = 4;
    private static final int FLINKING_IMPOSSIBLE = 5;
    private static final int FLINKING_LEFT_POSSIBLE = 1;
    private static final int FLINKING_LEFT_RIGHT = 0;
    private static final int FLINKING_POSSIBLE = 0;
    private static final int FLINKING_RIGHT_POSSIBLE = 2;
    private static final int FLINKING_UP_DOWN = 1;
    private static final int FLINKING_UP_POSSIBLE = 3;
    private static final int HEIGHT = 1;
    private static final int NONE = 0;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_MAX_OFF_PATH_2 = 400;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private static final int WIDTH = 0;
    private static final int ZOOM = 2;
    private GestureDetector gestureScanner;
    private boolean isFlinkUpDown;
    private boolean isInit;
    private Context mContext;
    private int mHeight;
    private IDocsViewActivity mIDocsViewActivity;
    private Matrix mMatrix;
    private Matrix mSavedMatrix;
    private Matrix mSavedMatrix2;
    private int mScaleHeight;
    private int mScaleWidth;
    private SpenMultiView mSpenMultiView;
    private int mWidth;
    private PointF mid;
    private int mode;
    private float oldDist;
    private PointF start;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public ViewTouchImage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mMatrix = new Matrix();
        this.mSavedMatrix = new Matrix();
        this.mSavedMatrix2 = new Matrix();
        this.isFlinkUpDown = true;
        this.mode = 0;
        this.start = new PointF();
        this.mid = new PointF();
        this.oldDist = 1.0f;
        this.mSpenMultiView = null;
        this.isInit = false;
        this.mContext = context;
        setOnTouchListener(this);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.gestureScanner = new GestureDetector(this);
    }

    public ViewTouchImage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewTouchImage(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        logI("onLayout");
        super.onLayout(changed, left, top, right, bottom);
        if (!this.isInit) {
            init();
            this.isInit = true;
        }
    }

    public void setIDocsViewActivity(IDocsViewActivity aIdocsviewactivity) {
        this.mIDocsViewActivity = aIdocsviewactivity;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bm) {
        logI("setImageBitmap(Bitmap bm)");
        super.setImageBitmap(bm);
        this.isInit = false;
        init();
        ((DocsViewActivity) this.mContext).setDocsPageInfo();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        logI("setImageBitmap(Uri uri)");
        super.setImageURI(uri);
        this.isInit = false;
        init();
        ((DocsViewActivity) this.mContext).setDocsPageInfo();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        logI("setImageDrawable");
        super.setImageDrawable(drawable);
        this.isInit = false;
        init();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int resId) {
        logI("setImageResource");
        super.setImageResource(resId);
        this.isInit = false;
        init();
    }

    protected void init() {
        matrixTurning(this.mMatrix, this);
        setImageMatrix(this.mMatrix);
        setImagePit();
    }

    public void setImagePit() {
        float[] value = new float[9];
        this.mMatrix.getValues(value);
        int width = getWidth();
        int height = getHeight();
        Drawable d = getDrawable();
        if (d != null) {
            int imageWidth = d.getIntrinsicWidth();
            int imageHeight = d.getIntrinsicHeight();
            value[2] = 0.0f;
            value[5] = 0.0f;
            if (imageWidth > width || imageHeight > height) {
                int target = 0;
                if (imageWidth < imageHeight) {
                    target = 1;
                }
                if (target == 0) {
                    float f = width / imageWidth;
                    value[4] = f;
                    value[0] = f;
                }
                if (target == 1) {
                    float f2 = height / imageHeight;
                    value[4] = f2;
                    value[0] = f2;
                }
                int scaleWidth = (int) (imageWidth * value[0]);
                int scaleHeight = (int) (imageHeight * value[4]);
                if (scaleWidth > width) {
                    float f3 = width / imageWidth;
                    value[4] = f3;
                    value[0] = f3;
                }
                if (scaleHeight > height) {
                    float f4 = height / imageHeight;
                    value[4] = f4;
                    value[0] = f4;
                }
            }
            int scaleWidth2 = (int) (imageWidth * value[0]);
            int scaleHeight2 = (int) (imageHeight * value[4]);
            if (scaleWidth2 < width) {
                value[2] = (width / 2.0f) - (scaleWidth2 / 2.0f);
            }
            if (scaleHeight2 < height) {
                value[5] = (height / 2.0f) - (scaleHeight2 / 2.0f);
            }
            this.mMatrix.setValues(value);
            setImageMatrix(this.mMatrix);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        ImageView view = (ImageView) v;
        this.gestureScanner.onTouchEvent(event);
        switch (event.getAction() & 255) {
            case 0:
                this.mSavedMatrix.set(this.mMatrix);
                this.start.set(event.getX(), event.getY());
                ((DocsViewActivity) this.mContext).setDocsPageInfo();
                this.mode = 1;
                break;
            case 1:
            case 6:
                this.mode = 0;
                ((DocsViewActivity) this.mContext).hideDocsViewInfo();
                break;
            case 2:
                if (this.mode == 1) {
                    this.mMatrix.set(this.mSavedMatrix);
                    this.mMatrix.postTranslate(event.getX() - this.start.x, event.getY() - this.start.y);
                    break;
                } else if (this.mode == 2) {
                    float newDist = spacing(event);
                    if (newDist > 10.0f) {
                        this.mMatrix.set(this.mSavedMatrix);
                        float scale = newDist / this.oldDist;
                        this.mMatrix.postScale(scale, scale, this.mid.x, this.mid.y);
                        break;
                    }
                }
                break;
            case 5:
                this.oldDist = spacing(event);
                if (this.oldDist > 10.0f) {
                    this.mSavedMatrix.set(this.mMatrix);
                    midPoint(this.mid, event);
                    this.mode = 2;
                    break;
                }
                break;
        }
        matrixTurning(this.mMatrix, view);
        view.setImageMatrix(this.mMatrix);
        if (this.mSpenMultiView != null) {
            float[] value = new float[9];
            this.mMatrix.getValues(value);
            if (this.mode == 1 && (event.getAction() & 255) == 2) {
                logI("YKYU DRAG x = " + value[2]);
                logI("YKYU DRAG y = " + value[5]);
                logI("YKYU DRAG x = " + (event.getX() - this.start.x));
                logI("YKYU DRAG y = " + (event.getY() - this.start.y));
                this.mSpenMultiView.setPan(new PointF(-(value[2] / this.mSpenMultiView.getZoomRatio()), -(value[5] / this.mSpenMultiView.getZoomRatio())));
            }
            if (this.mode == 2 && (event.getAction() & 255) == 2) {
                logI("YKYU ZOOM x = " + value[2]);
                logI("YKYU ZOOM y = " + value[5]);
                logI("YKYU ZOOM x = " + this.mid.x);
                logI("YKYU ZOOM y = " + this.mid.y);
                this.mSpenMultiView.setZoom(this.mid.x, this.mid.y, value[0]);
            }
            logI("YKYU ZOOMRatio = " + value[0]);
        }
        return true;
    }

    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return FloatMath.sqrt((x * x) + (y * y));
    }

    private void midPoint(PointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2.0f, y / 2.0f);
    }

    private void matrixTurning(Matrix matrix, ImageView view) {
        float[] value = new float[9];
        matrix.getValues(value);
        float[] savedValue = new float[9];
        this.mSavedMatrix2.getValues(savedValue);
        int width = view.getWidth();
        int height = view.getHeight();
        this.mWidth = width;
        this.mHeight = height;
        Drawable d = view.getDrawable();
        if (d != null) {
            int imageWidth = d.getIntrinsicWidth();
            int imageHeight = d.getIntrinsicHeight();
            int scaleWidth = (int) (imageWidth * value[0]);
            int scaleHeight = (int) (imageHeight * value[4]);
            this.mScaleWidth = scaleWidth;
            this.mScaleHeight = scaleHeight;
            if (value[2] < width - scaleWidth) {
                value[2] = width - scaleWidth;
            }
            if (value[5] < height - scaleHeight) {
                value[5] = height - scaleHeight;
            }
            if (value[2] > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                value[2] = 0.0f;
            }
            if (value[5] > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                value[5] = 0.0f;
            }
            if (value[0] > 10.0f || value[4] > 10.0f) {
                value[0] = savedValue[0];
                value[4] = savedValue[4];
                value[2] = savedValue[2];
                value[5] = savedValue[5];
            }
            if (imageWidth <= width && imageHeight <= height) {
                if (value[0] < 1.0f) {
                    value[0] = 1.0f;
                }
                if (value[4] < 1.0f) {
                    value[4] = 1.0f;
                }
            } else if (scaleWidth < width && scaleHeight < height) {
                int target = 0;
                if (imageWidth < imageHeight) {
                    target = 1;
                }
                if (target == 0) {
                    float f = width / imageWidth;
                    value[4] = f;
                    value[0] = f;
                }
                if (target == 1) {
                    float f2 = height / imageHeight;
                    value[4] = f2;
                    value[0] = f2;
                }
                int scaleWidth2 = (int) (imageWidth * value[0]);
                int scaleHeight2 = (int) (imageHeight * value[4]);
                if (scaleWidth2 > width) {
                    float f3 = width / imageWidth;
                    value[4] = f3;
                    value[0] = f3;
                }
                if (scaleHeight2 > height) {
                    float f4 = height / imageHeight;
                    value[4] = f4;
                    value[0] = f4;
                }
            }
            int scaleWidth3 = (int) (imageWidth * value[0]);
            int scaleHeight3 = (int) (imageHeight * value[4]);
            if (scaleWidth3 < width) {
                value[2] = (width / 2.0f) - (scaleWidth3 / 2.0f);
            }
            if (scaleHeight3 < height) {
                value[5] = (height / 2.0f) - (scaleHeight3 / 2.0f);
            }
            if (this.mode == 2) {
                float test = value[0] * 100.0f;
                if (test < 100.0f) {
                    test = 100.0f;
                }
                String zoom_rate = Integer.toString((int) test);
                ((DocsViewActivity) this.mContext).setZoomRateInfo(zoom_rate);
            }
            matrix.setValues(value);
            this.mSavedMatrix2.set(matrix);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent arg0) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        try {
            if (this.isFlinkUpDown) {
                if (Math.abs(e1.getY() - e2.getY()) <= 400.0f) {
                    return false;
                }
            } else if (Math.abs(e1.getY() - e2.getY()) > 250.0f) {
                return false;
            }
            if (e1.getX() - e2.getX() > 120.0f && Math.abs(velocityX) > 200.0f) {
                logI("Left Swipe");
                if (!this.isFlinkUpDown && (isflicking(1) == 1 || isflicking(0) == 0)) {
                    this.mIDocsViewActivity.moveToNext();
                }
            } else if (e2.getX() - e1.getX() > 120.0f && Math.abs(velocityX) > 200.0f) {
                logI("Right Swipe");
                if (!this.isFlinkUpDown && (isflicking(2) == 2 || isflicking(0) == 0)) {
                    this.mIDocsViewActivity.moveToPrev();
                }
            } else if (e1.getY() - e2.getY() > 120.0f && Math.abs(velocityY) > 200.0f) {
                logI("Swipe Up");
                if (this.isFlinkUpDown && (isflicking(3) == 3 || isflicking(0) == 0)) {
                    this.mIDocsViewActivity.moveToNext();
                }
            } else if (e2.getY() - e1.getY() > 120.0f && Math.abs(velocityY) > 200.0f) {
                logI("Swipe down");
                if (this.isFlinkUpDown && (isflicking(4) == 4 || isflicking(0) == 0)) {
                    this.mIDocsViewActivity.moveToPrev();
                }
            }
        } catch (Exception e) {
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent arg0) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent arg0) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent arg0) {
        return false;
    }

    public int isflicking(int flickingdirection) {
        float[] value = new float[9];
        this.mMatrix.getValues(value);
        if (flickingdirection == 1 && (-value[2]) + this.mWidth == this.mScaleWidth) {
            return 1;
        }
        if (flickingdirection == 2 && value[2] == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            return 2;
        }
        if (flickingdirection == 3 && (-value[5]) + this.mHeight == this.mScaleHeight) {
            return 3;
        }
        if (flickingdirection == 4 && value[5] == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            return 4;
        }
        return this.mWidth >= this.mScaleWidth ? 0 : 5;
    }

    public void setSCanvas(SpenMultiView spenmultiview) {
        this.mSpenMultiView = spenmultiview;
    }

    @Override // android.view.View
    public Matrix getMatrix() {
        return this.mMatrix;
    }
}
