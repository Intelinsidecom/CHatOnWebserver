package com.samsung.android.sdk.pen.settingui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.infraware.office.evengine.InterfaceC0507E;
import com.samsung.spen.lib.image.SPenImageFilterConstants;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;

/* loaded from: classes.dex */
class SpenColorPaletteView2 extends View {
    private static final int COLOR_COLUMN_NUM = 7;
    private static final int COLOR_NUM_MAX = 14;
    private static final int COLOR_ROW_NUM = 2;
    private static final int CUSTOM_COLOR_IDX = 12;
    protected static final int DEFAULT_COLOR = -16777216;
    private static int ITEM_BORDER_WIDTH = 1;
    private static int ITEM_GAPX = 5;
    private static int ITEM_GAPY = 7;
    private static final int SPOID_ICON = -17825793;
    private static final int USER_COLOR = -16777218;
    private static final int WINDOW_BORDER_WIDTH = 0;
    private int currentTableIndex;
    boolean isRainbow;
    private Paint mBorderPaint;
    private Rect mCanvasRect;
    private OnColorChangedListener mColorChangeListener;
    private final String[] mColorContentDescritionTable1;
    private final String[] mColorContentDescritionTable2;
    private final String[] mColorContentDescritionTable3;
    int mColorHoverIdx;
    private Paint mColorPaint;
    private int[] mColorTable;
    private final int[] mColorTable1;
    private final int[] mColorTable2;
    private final int[] mColorTable3;
    private String mCustom_imagepath;
    private BitmapDrawable mDrColorShadow;
    private BitmapDrawable mDrSeleteBox;
    private BitmapDrawable mDrSpoid;
    private BitmapDrawable mDrUserColor;
    SPenImageUtil mDrawimage;
    private boolean mFirstExecuted;
    private Rect mItemRect;
    int mPreColorHoverIdx;
    private Rect mSelectRect;
    private int mSeletedItem;

    interface OnColorChangedListener {
        void colorChanged(int i, int i2);
    }

    public SpenColorPaletteView2(Context paramContext, String custom_imagepath, float ratio) {
        super(paramContext);
        this.mSeletedItem = 0;
        this.isRainbow = true;
        this.currentTableIndex = 1;
        this.mColorTable = new int[]{Color.rgb(255, 255, 255), Color.rgb(253, 255, 45), Color.rgb(255, SPenImageFilterConstants.FILTER_POPART, 93), Color.rgb(255, 59, 91), Color.rgb(255, 73, 201), Color.rgb(202, SPenImageFilterConstants.FILTER_OILPAINT, 255), Color.rgb(122, 55, 222), Color.rgb(1, 148, 46), Color.rgb(56, 168, 255), Color.rgb(51, 103, 253), Color.rgb(166, 165, 165), Color.rgb(0, 0, 0), USER_COLOR, SPOID_ICON};
        this.mColorTable1 = new int[]{Color.rgb(255, 255, 255), Color.rgb(253, 255, 45), Color.rgb(255, SPenImageFilterConstants.FILTER_POPART, 93), Color.rgb(255, 59, 91), Color.rgb(255, 73, 201), Color.rgb(202, SPenImageFilterConstants.FILTER_OILPAINT, 255), Color.rgb(122, 55, 222), Color.rgb(1, 148, 46), Color.rgb(56, 168, 255), Color.rgb(51, 103, 253), Color.rgb(166, 165, 165), Color.rgb(0, 0, 0), USER_COLOR, SPOID_ICON};
        this.mColorTable2 = new int[]{Color.rgb(255, ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARALL, 193), Color.rgb(249, 164, 143), Color.rgb(245, 126, 96), Color.rgb(255, 149, 165), Color.rgb(245, 77, 103), Color.rgb(237, 26, 59), Color.rgb(188, 4, 33), Color.rgb(139, 0, 124), Color.rgb(188, 4, 91), Color.rgb(140, 83, 122), Color.rgb(89, 66, 84), Color.rgb(102, 48, 10), USER_COLOR, SPOID_ICON};
        this.mColorTable3 = new int[]{Color.rgb(252, 227, 60), Color.rgb(250, 199, 75), Color.rgb(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO, 227, 108), Color.rgb(91, 221, 56), Color.rgb(65, 165, 38), Color.rgb(14, 128, 25), Color.rgb(102, 127, 42), Color.rgb(14, 128, 100), Color.rgb(19, 155, 105), Color.rgb(5, 89, 117), Color.rgb(17, 75, 157), Color.rgb(10, 41, 108), USER_COLOR, SPOID_ICON};
        this.mColorContentDescritionTable1 = new String[]{"White, Tap to apply", "Yellow, Tap to apply", "Coral, Tap to apply", "Tomato, Tap to apply", "Hotpink, Tap to apply", "Plum, Tap to apply", "Blueviolet, Tap to apply", "Forestgreen, Tap to apply", "Dodgeblue, Tap to apply", "Royalblue, Tap to apply", "Darkgray, Tap to apply", "Black, Tap to apply", "Custom colour palette, Tap to apply", "Spuit, Button"};
        this.mColorContentDescritionTable2 = new String[]{"Peachpuff, Tap to apply", "Lightsalmon, Tap to apply", "Darksalmon, Tap to apply", "linghtpink, Tap to apply", "Palevioletred, Tap to apply", "Crimson, Tap to apply", "Red, Tap to apply", "Mediumvioletred, Tap to apply", "Purple, Tap to apply", "MediumOrchid, Tap to apply", "Dimgray, Tap to apply", "Saddlebrown, Tap to apply", "Custom colour palette, Tap to apply", "Spuit, Button"};
        this.mColorContentDescritionTable3 = new String[]{"Gold, Tap to apply", "Orange, Tap to apply", "Greenyellow, Tap to apply", "Limegreen, Tap to apply", "Seegreen, Tap to apply", "Green, Tap to apply", "OliverDrab, Tap to apply", "DarkCyan, Tap to apply", "Teal, Tap to apply", "Steelblue, Tap to apply", "Blue, Tap to apply", "Darkblue, Tap to apply", "Custom colour palette, Tap to apply", "Spuit, Button"};
        this.mColorChangeListener = null;
        this.mCustom_imagepath = "";
        this.mFirstExecuted = true;
        this.mCustom_imagepath = custom_imagepath;
        this.mDrawimage = new SPenImageUtil(paramContext, this.mCustom_imagepath, ratio);
        initView();
    }

    public void close() {
        this.mCanvasRect = null;
        this.mItemRect = null;
        this.mSelectRect = null;
        this.mBorderPaint = null;
        this.mColorPaint = null;
        this.mColorChangeListener = null;
        if (this.mDrSeleteBox != null) {
            Bitmap bm = this.mDrSeleteBox.getBitmap();
            if (bm != null) {
                bm.recycle();
            }
            this.mDrSeleteBox = null;
        }
        if (this.mDrColorShadow != null) {
            Bitmap bm2 = this.mDrColorShadow.getBitmap();
            if (bm2 != null) {
                bm2.recycle();
            }
            this.mDrColorShadow = null;
        }
        if (this.mDrUserColor != null) {
            Bitmap bm3 = this.mDrUserColor.getBitmap();
            if (bm3 != null) {
                bm3.recycle();
            }
            this.mDrUserColor = null;
        }
        if (this.mDrSpoid != null) {
            Bitmap bm4 = this.mDrSpoid.getBitmap();
            if (bm4 != null) {
                bm4.recycle();
            }
            this.mDrSpoid = null;
        }
        this.mCustom_imagepath = null;
        this.mDrawimage = null;
    }

    protected void setNextColorTable(int index) {
        int index2 = index + 1;
        if (index2 == 4) {
            index2 = 1;
        }
        this.currentTableIndex = index2;
        switch (this.currentTableIndex) {
            case 1:
                this.mColorTable = this.mColorTable1;
                break;
            case 2:
                this.mColorTable = this.mColorTable2;
                break;
            case 3:
                this.mColorTable = this.mColorTable3;
                break;
        }
        invalidate();
        onSizeChanged(InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_NEW_EVENT, 83, getWidth(), getHeight());
    }

    protected void setBackColorTable(int index) {
        int index2 = index - 1;
        if (index2 == 0) {
            index2 = 3;
        }
        this.currentTableIndex = index2;
        switch (this.currentTableIndex) {
            case 1:
                this.mColorTable = this.mColorTable1;
                break;
            case 2:
                this.mColorTable = this.mColorTable2;
                break;
            case 3:
                this.mColorTable = this.mColorTable3;
                break;
        }
        invalidate();
    }

    protected int getCurrentTableIndex() {
        return this.currentTableIndex;
    }

    private void initView() {
        ITEM_GAPX = this.mDrawimage.getIntValueAppliedDensity(1.0f) * 3;
        ITEM_GAPY = this.mDrawimage.getIntValueAppliedDensity(1.0f) * 5;
        ITEM_BORDER_WIDTH = this.mDrawimage.getIntValueAppliedDensity(1.0f) * 1;
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setColor(DEFAULT_COLOR);
        this.mBorderPaint.setStrokeWidth(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mColorPaint = new Paint(1);
        this.mDrSeleteBox = (BitmapDrawable) this.mDrawimage.setDrawableImg("snote_colorchip_select_box", 38, 39);
        this.mDrColorShadow = (BitmapDrawable) this.mDrawimage.setDrawableImg("snote_colorchip_shadow", 38, 38);
        this.mDrUserColor = (BitmapDrawable) this.mDrawimage.setDrawableImg("snote_colorbox_mini", 38, 38);
        this.mDrSpoid = (BitmapDrawable) this.mDrawimage.setDrawableImg("snote_color_spoid_normal", 38, 38);
    }

    public void setInitialValue(OnColorChangedListener listener, int color) {
        this.mColorChangeListener = listener;
        setSelectBoxPos(color);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int mPaddingLeft = getPaddingLeft();
        int mPaddingRight = getPaddingRight();
        int mPaddingTop = getPaddingTop();
        int mPaddingBottom = getPaddingBottom();
        this.mCanvasRect = new Rect(getLeft() + mPaddingLeft, getTop() + mPaddingTop, getRight() - mPaddingRight, getBottom() - mPaddingBottom);
        int itemW = ((this.mCanvasRect.width() + 0) - (ITEM_GAPX * 6)) / 7;
        int itemH = this.mDrawimage.getIntValueAppliedDensity(1.0f) != 0 ? itemW : itemW - 1;
        this.mItemRect = new Rect(0, 0, itemW, itemH);
        this.mSelectRect = new Rect(this.mItemRect.left - ITEM_BORDER_WIDTH, this.mItemRect.top - ITEM_BORDER_WIDTH, this.mItemRect.right + ITEM_BORDER_WIDTH, this.mItemRect.bottom + ITEM_BORDER_WIDTH);
        this.mDrColorShadow.setBounds(this.mItemRect);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case 19:
                if (this.mSeletedItem - 7 >= 0 && this.mSeletedItem - 7 < 14) {
                    this.mSeletedItem -= 7;
                    invalidate();
                    return true;
                }
                break;
            case 20:
                if (this.mSeletedItem + 7 >= 0 && this.mSeletedItem + 7 < 14) {
                    this.mSeletedItem += 7;
                    invalidate();
                    return true;
                }
                break;
            case 21:
                if (this.mSeletedItem - 1 >= 0 && this.mSeletedItem - 1 < 14) {
                    this.mSeletedItem--;
                    invalidate();
                    return true;
                }
                break;
            case 22:
                if (this.mSeletedItem + 1 >= 0 && this.mSeletedItem + 1 < 14) {
                    this.mSeletedItem++;
                    invalidate();
                    return true;
                }
                break;
            case 66:
                if (this.mColorChangeListener == null) {
                    return true;
                }
                this.mColorChangeListener.colorChanged(this.mColorTable[this.mSeletedItem], this.mSeletedItem);
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(getPaddingLeft() + 0, getPaddingTop() + 0);
        if (this.mFirstExecuted) {
            ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
            int m = (getWidth() + 0) / 7;
            float rowNumF = this.mColorTable.length / 7.0f;
            int rowNum = this.mColorTable.length / 7;
            if (rowNumF > rowNum) {
                rowNum++;
            }
            localLayoutParams.height = (m * rowNum) + getPaddingBottom();
            setLayoutParams(localLayoutParams);
            this.mFirstExecuted = false;
        }
        try {
            onDrawColorSet(canvas);
        } catch (IOException e) {
            e.printStackTrace();
        }
        drawSeleteBox(canvas);
        canvas.restore();
    }

    private void onDrawColorSet(Canvas canvas) throws IOException {
        if (this.mCanvasRect != null) {
            Rect localRect = new Rect(this.mItemRect);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 7; j++) {
                    int color = this.mColorTable[(i * 7) + j];
                    this.mColorPaint.setColor(color);
                    if (color == USER_COLOR) {
                        if (this.isRainbow) {
                            this.mDrUserColor.setBounds(localRect);
                            this.mDrUserColor.draw(canvas);
                        } else {
                            canvas.drawRect(localRect, this.mColorPaint);
                            this.mDrColorShadow.setBounds(localRect);
                            this.mDrColorShadow.draw(canvas);
                        }
                    } else if (color == SPOID_ICON) {
                        this.mDrSpoid.setBounds(localRect);
                        this.mDrSpoid.draw(canvas);
                    } else {
                        canvas.drawRect(localRect, this.mColorPaint);
                        this.mDrColorShadow.setBounds(localRect);
                        this.mDrColorShadow.draw(canvas);
                    }
                    localRect.offset(localRect.width() + ITEM_GAPX, 0);
                }
                localRect.offset(-localRect.left, localRect.height() + ITEM_GAPY);
            }
        }
    }

    private void drawSeleteBox(Canvas canvas) {
        if (this.mSeletedItem != -1) {
            int m = this.mSeletedItem % 7;
            int n = this.mSeletedItem / 7;
            this.mSelectRect.set(this.mItemRect);
            this.mSelectRect.offset((this.mSelectRect.width() + ITEM_GAPX) * m, (this.mSelectRect.height() + ITEM_GAPY) * n);
            this.mSelectRect.bottom += 2;
            this.mDrSeleteBox.setBounds(this.mSelectRect);
            this.mDrSeleteBox.draw(canvas);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int colorIdx = this.mSeletedItem;
        int action = event.getAction();
        if (action == 2 && getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        switch (event.getAction()) {
            case 0:
            case 2:
                colorIdx = getColorIdx(event.getX(), event.getY());
                break;
            case 1:
                playSoundEffect(0);
                break;
        }
        if (colorIdx == 12) {
            if (event.getAction() == 0) {
                this.mSeletedItem = colorIdx;
                if (this.isRainbow) {
                    this.isRainbow = false;
                }
            }
        } else {
            this.mSeletedItem = colorIdx;
        }
        this.mColorHoverIdx = colorIdx;
        if (this.mColorChangeListener != null) {
            switch (event.getAction()) {
                case 1:
                    this.mColorChangeListener.colorChanged(this.mColorTable[this.mSeletedItem], this.mSeletedItem);
                    break;
            }
        }
        invalidate();
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        boolean result = super.onHoverEvent(event);
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case 7:
                this.mColorHoverIdx = getColorIdx(x, y);
                break;
            case 9:
                this.mColorHoverIdx = getColorIdx(x, y);
                break;
            case 10:
                this.mColorHoverIdx = this.mSeletedItem;
                this.mPreColorHoverIdx = -1;
                return true;
        }
        if (this.mPreColorHoverIdx != this.mColorHoverIdx) {
            sendAccessibilityEvent(32768);
            if (this.currentTableIndex == 1) {
                setContentDescription(this.mColorContentDescritionTable1[this.mColorHoverIdx]);
            } else if (this.currentTableIndex == 2) {
                setContentDescription(this.mColorContentDescritionTable2[this.mColorHoverIdx]);
            } else if (this.currentTableIndex == 3) {
                setContentDescription(this.mColorContentDescritionTable3[this.mColorHoverIdx]);
            }
            sendAccessibilityEvent(65536);
            this.mPreColorHoverIdx = this.mColorHoverIdx;
            return result;
        }
        return result;
    }

    private int getColorIdx(float x, float y) {
        int m = 1;
        while (m <= 7 && x > (this.mItemRect.width() * m) + ((m - 1) * ITEM_GAPX)) {
            m++;
        }
        int n = 1;
        while (n <= 2 && y >= this.mItemRect.height() * n) {
            n++;
        }
        if (m > 7) {
            m = 7;
        }
        if (n > 2) {
            n = 2;
        }
        return ((n - 1) * 7) + (m - 1);
    }

    public void setSelectBoxPos(int color) {
        if (color == DEFAULT_COLOR) {
            color = DEFAULT_COLOR;
        }
        int color2 = color | DEFAULT_COLOR;
        int m = this.mColorTable.length - 1;
        while (true) {
            if (m < 0) {
                break;
            }
            if (color2 != this.mColorTable[m]) {
                m--;
            } else {
                this.mSeletedItem = m;
                break;
            }
        }
        if (m < 0) {
            this.mSeletedItem = -1;
        }
        invalidate();
    }

    public void setColor(int color) {
        int color2 = color | DEFAULT_COLOR;
        if ((DEFAULT_COLOR & color2) != -33554432) {
            int m = this.mColorTable.length - 1;
            while (true) {
                if (m < 0) {
                    break;
                }
                if (color2 != this.mColorTable[m]) {
                    m--;
                } else {
                    this.mSeletedItem = m;
                    break;
                }
            }
            if (m < 0) {
                int i = this.mColorTable.length - 2;
                while (i >= 0) {
                    if (color2 != this.mColorTable1[i] && color2 != this.mColorTable2[i] && color2 != this.mColorTable3[i]) {
                        i--;
                    } else {
                        this.mSeletedItem = -1;
                        break;
                    }
                }
                if (i < 0) {
                    this.mSeletedItem = 12;
                    this.mColorTable[12] = color2;
                    this.mColorTable1[12] = color2;
                    this.mColorTable2[12] = color2;
                    this.mColorTable3[12] = color2;
                }
            }
        } else {
            this.mSeletedItem = 12;
            this.mColorTable[12] = color2;
            this.mColorTable1[12] = color2;
            this.mColorTable2[12] = color2;
            this.mColorTable3[12] = color2;
        }
        invalidate();
    }

    public void setColorPickerColor(int color) {
        if ((color & DEFAULT_COLOR) == 0) {
            color |= DEFAULT_COLOR;
        }
        this.mSeletedItem = 12;
        this.mColorTable[12] = color;
        invalidate();
    }

    public int getColor() {
        return this.mColorTable[this.mSeletedItem];
    }

    public void setColorPickerMode() {
        this.mSeletedItem = 12;
    }
}
