package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SpenControlImage extends SpenControlBase {
    private static boolean CONFIG_DRAW_MOVING_OBJECT = false;
    private static final int DEFAULT_MOVE_COLOR = 1442840575;
    CMovingImage mMovingImage;

    private static class CMovingImage {
        protected BitmapDrawable mDrawable;

        private CMovingImage() {
            this.mDrawable = null;
        }

        /* synthetic */ CMovingImage(CMovingImage cMovingImage) {
            this();
        }
    }

    public SpenControlImage(Context context, SpenPageDoc pageDoc) {
        super(context, pageDoc);
        initialize();
    }

    private void initialize() {
        this.mMovingImage = new CMovingImage(null);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    protected void onFlip(int flipDirection, SpenObjectBase objectBase) {
        if (CONFIG_DRAW_MOVING_OBJECT) {
            if (this.mMovingImage.mDrawable != null) {
                Matrix m = new Matrix();
                Bitmap src = this.mMovingImage.mDrawable.getBitmap();
                Bitmap.createBitmap(src.getWidth(), src.getHeight(), Bitmap.Config.ARGB_8888);
                Bitmap map = src.copy(Bitmap.Config.ARGB_8888, true);
                if ((flipDirection & 2) == 2) {
                    m.preScale(-1.0f, 1.0f);
                }
                if ((flipDirection & 1) == 1) {
                    m.preScale(1.0f, -1.0f);
                }
                Bitmap dst = Bitmap.createBitmap(map, 0, 0, map.getWidth(), map.getHeight(), m, false);
                dst.setDensity(160);
                this.mMovingImage.mDrawable = new BitmapDrawable(getResources(), dst);
            } else {
                return;
            }
        }
        super.onFlip(flipDirection, objectBase);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    protected void onDrawObject(Canvas canvas, Rect rect, SpenObjectBase objectBase) {
        if (CONFIG_DRAW_MOVING_OBJECT) {
            if (objectBase != null) {
                if (this.mMovingImage.mDrawable != null) {
                    this.mMovingImage.mDrawable.setBounds(rect);
                    this.mMovingImage.mDrawable.draw(canvas);
                    this.mMovingImage.mDrawable.setAlpha(127);
                    return;
                } else {
                    Paint paint = new Paint();
                    paint.reset();
                    paint.setColor(DEFAULT_MOVE_COLOR);
                    paint.setStrokeWidth(2.0f);
                    canvas.drawRect(rect, paint);
                    return;
                }
            }
            return;
        }
        super.onDrawObject(canvas, rect, objectBase);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    protected void onObjectChanged() {
        super.onObjectChanged();
    }

    public void setObject(SpenObjectImage objectImage) {
        this.mRotateAngle = objectImage.getRotation();
        ArrayList<SpenObjectBase> objectList = new ArrayList<>();
        objectList.add(objectImage);
        setObjectList(objectList);
        if (objectImage.getSorInfo() == null) {
            this.mMovingImage.mDrawable = new BitmapDrawable(getResources(), objectImage.getImage());
        } else {
            this.mMovingImage.mDrawable = null;
        }
    }

    public SpenObjectImage getObject() {
        if (getObjectList() == null || getObjectList().size() == 0) {
            return null;
        }
        return (SpenObjectImage) getObjectList().get(0);
    }
}
