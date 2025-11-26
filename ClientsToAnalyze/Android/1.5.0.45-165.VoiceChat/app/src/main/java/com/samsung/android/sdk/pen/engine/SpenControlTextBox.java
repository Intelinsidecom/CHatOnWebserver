package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.samsung.android.sdk.pen.SpenSettingTextInfo;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.engine.SpenControlBase;
import com.samsung.android.sdk.pen.engine.SpenTextBox;
import com.samsung.android.sdk.pen.util.SpenError;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SpenControlTextBox extends SpenControlBase {
    private static final boolean DBG = true;
    private static final int DEFAULT_BORDER_LEFT_MARGIN = 3;
    private static final int TEXT_INPUT_UNLIMITED = -1;
    private int BOTTOM_MARGIN;
    private int LEFT_MARGIN;
    private int RIGHT_MARGIN;
    private int TOP_MARGIN;
    private ActionListener mActionListener;
    private boolean mEditable;
    private boolean mFirstDraw;
    private final GestureDetector mGestureDetector;
    private boolean mReceiveActionDown;
    private final Runnable mRequestObjectChange;
    private boolean mSizeChanged;
    private SpenTextBox mTextBox;
    private final SpenTextBox.TextBoxActionListener mTextBoxActionListener;
    private SpenSettingTextInfo mTextSettingInfo;
    private boolean mTransactionFitTextBox;
    private final Handler mUpdateHandler;
    private boolean mUseTextEraser;

    protected interface ActionListener {
        void onFocusChanged(boolean z);

        void onMoreButtonDown(SpenObjectTextBox spenObjectTextBox);

        boolean onSelectionChanged(int i, int i2);

        void onSettingTextInfoChanged(SpenSettingTextInfo spenSettingTextInfo);
    }

    public SpenControlTextBox(Context context, SpenPageDoc pageDoc) {
        super(context, pageDoc);
        this.mTextSettingInfo = null;
        this.mEditable = false;
        this.mUseTextEraser = false;
        this.mReceiveActionDown = false;
        this.mTransactionFitTextBox = false;
        this.mSizeChanged = false;
        this.LEFT_MARGIN = 0;
        this.RIGHT_MARGIN = 0;
        this.TOP_MARGIN = 0;
        this.BOTTOM_MARGIN = 0;
        this.mActionListener = null;
        this.mFirstDraw = false;
        this.mTextBoxActionListener = new SpenTextBox.TextBoxActionListener() { // from class: com.samsung.android.sdk.pen.engine.SpenControlTextBox.1
            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onRequestScroll(float x, float y) {
                SpenControlTextBox.this.onRequestScroll(x, y);
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onSettingTextInfoChanged(SpenSettingTextInfo info) {
                if (info != null) {
                    SpenControlTextBox.this.mTextSettingInfo.style = info.style;
                    SpenControlTextBox.this.mTextSettingInfo.color = info.color;
                    SpenControlTextBox.this.mTextSettingInfo.size = info.size;
                    SpenControlTextBox.this.mTextSettingInfo.font = info.font;
                    SpenControlTextBox.this.mTextSettingInfo.align = info.align;
                    SpenControlTextBox.this.mTextSettingInfo.lineIndent = info.lineIndent;
                    SpenControlTextBox.this.mTextSettingInfo.lineSpacing = info.lineSpacing;
                    SpenControlTextBox.this.mTextSettingInfo.direction = info.direction;
                }
                if (SpenControlTextBox.this.mActionListener != null) {
                    SpenControlTextBox.this.mActionListener.onSettingTextInfoChanged(info);
                }
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onObjectChanged(SpenObjectTextBox object) {
                SpenControlTextBox.super.fit();
                SpenControlTextBox.this.invalidate();
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onExceedLimit() {
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public boolean onSelectionChanged(int selStart, int selEnd) {
                SpenSLog.m134d("onSelectionChanged is called start : " + selStart + " end : " + selEnd);
                if (SpenControlTextBox.this.mActionListener != null) {
                    return SpenControlTextBox.this.mActionListener.onSelectionChanged(selStart, selEnd);
                }
                return true;
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onMoreButtonDown(SpenObjectTextBox object) {
                if (SpenControlTextBox.this.mActionListener != null) {
                    SpenControlTextBox.this.mActionListener.onMoreButtonDown(object);
                }
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onRequestCoordinateInfo(SpenControlBase.CoordinateInfo coordinateInfo) {
                if (SpenControlTextBox.this.mListener != null) {
                    SpenControlTextBox.this.mListener.onRequestCoordinateInfo(coordinateInfo);
                }
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onUndo() {
                SpenControlTextBox.this.mEditable = false;
                SpenControlTextBox.this.onObjectChanged();
                SpenControlTextBox.this.mEditable = true;
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onVisibleUpdated(SpenObjectTextBox object, boolean visible) {
                if (SpenControlTextBox.this.mListener != null) {
                    SpenControlTextBox.this.mListener.onVisibleUpdated(SpenControlTextBox.this.getObjectList(), visible);
                }
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onFocusChanged(boolean gainFocus) {
                if (SpenControlTextBox.this.mActionListener != null) {
                    SpenControlTextBox.this.mActionListener.onFocusChanged(gainFocus);
                }
            }
        };
        this.mTextSettingInfo = new SpenSettingTextInfo();
        this.mGestureDetector = new GestureDetector(context, new GestureListener(this, null));
        this.mUpdateHandler = new Handler();
        this.mRequestObjectChange = new Runnable() { // from class: com.samsung.android.sdk.pen.engine.SpenControlTextBox.2
            @Override // java.lang.Runnable
            public void run() {
                SpenControlTextBox.this.onVisibleUpdated(false);
            }
        };
    }

    protected void onVisibleUpdated(boolean visible) {
        if (this.mListener != null) {
            this.mListener.onVisibleUpdated(getObjectList(), visible);
        }
    }

    protected void setActionListener(ActionListener actionListener) {
        this.mActionListener = actionListener;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    public void setTouchEnabled(boolean enable) {
        super.setTouchEnabled(enable);
        if (this.mTextBox != null) {
            this.mTextBox.enableTouch(enable);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.fit();
        RectF rect = getRect();
        SpenObjectTextBox object = (SpenObjectTextBox) getObjectList().get(0);
        if (verifyRect(rect)) {
            if (this.mPageDoc.isValid()) {
                this.mTextBox = new SpenTextBox(getContext(), (ViewGroup) getParent(), this.mPageDoc.getWidth(), this.mPageDoc.getHeight());
                this.mTextBox.setObjectText(object);
                this.mTextBox.setEraserMode(this.mUseTextEraser);
                this.mTextBox.setTextBoxListener(this.mTextBoxActionListener);
                this.mTextBox.setSelection(object.getCursorPos(), true);
                this.mTextBox.setMargin(this.LEFT_MARGIN, this.TOP_MARGIN, this.RIGHT_MARGIN, this.BOTTOM_MARGIN);
                this.mTextBox.enableTextInput(this.mEditable);
                String desctription = this.mTextBox.getText(false);
                if (desctription == null) {
                    desctription = "";
                }
                setContentDescription("TextBox " + desctription);
                sendAccessibilityEvent(128);
                if (this.mEditable) {
                    this.mTextBox.fit(true);
                } else {
                    bringToFront();
                }
            } else {
                return;
            }
        }
        super.onAttachedToWindow();
    }

    public void setEditable(boolean enable) {
        if (!this.mIsClosed) {
            this.mEditable = enable;
            if (this.mEditable) {
                super.setContextMenuVisible(false);
                if (this.mTextBox != null) {
                    this.mTextBox.bringToFront();
                    this.mTextBox.enableTextInput(true);
                }
                setStyle(2);
            } else {
                super.setContextMenuVisible(true);
                if (this.mTextBox != null) {
                    this.mIsClosed = true;
                    onObjectChanged();
                    this.mIsClosed = false;
                    this.mTextBox.hideSoftInput();
                }
                setStyle(0);
            }
            getObject().setRotatable(this.mEditable ? false : true);
            if (!this.mEditable) {
                bringToFront();
            }
        }
    }

    public boolean isEditable() {
        return this.mEditable;
    }

    public void showSoftInput() {
        if (checkTextBoxValidation()) {
            this.mTextBox.showSoftInput();
        }
    }

    public void hideSoftInput() {
        if (checkTextBoxValidation()) {
            this.mTextBox.hideSoftInput();
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    protected void onDrawBorder(Canvas canvas, RectF rect, SpenObjectBase objectBase) throws Resources.NotFoundException, PackageManager.NameNotFoundException, IOException {
        if (getStyle() == 2 && isEditable()) {
            rect.left -= 3.0f;
            Paint tmpPaint = this.mTempPaint.getPaint(7);
            if (Build.MODEL.contains("SM-N750")) {
                tmpPaint.setStrokeWidth(4.0f);
            }
            canvas.drawRect(rect, tmpPaint);
            return;
        }
        super.onDrawBorder(canvas, rect, objectBase);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase, android.view.View
    public void onDraw(Canvas canvas) throws Resources.NotFoundException, PackageManager.NameNotFoundException, IOException {
        if (this.mFirstDraw && isFocused()) {
            this.mFirstDraw = false;
            this.mUpdateHandler.post(this.mRequestObjectChange);
        }
        if (checkTextBoxValidation()) {
            if (this.mSizeChanged) {
                this.mSizeChanged = false;
                this.mTextBox.fit(true);
            }
            super.onDraw(canvas);
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        SpenControlBase.CoordinateInfo coordinateInfo = new SpenControlBase.CoordinateInfo();
        coordinateInfo.reset();
        this.mSizeChanged = true;
        if (this.mTextBox != null && this.mTextBox.isContextMenuShowing()) {
            this.mTextBox.updateContextMenuLocation();
        }
    }

    public void fit(boolean checkCursorPosition) {
        super.fit();
        if (!this.mTransactionFitTextBox) {
            this.mTransactionFitTextBox = true;
            if (this.mTextBox != null) {
                this.mTextBox.fit(checkCursorPosition);
            }
            this.mTransactionFitTextBox = false;
        }
    }

    public void setObject(SpenObjectTextBox ObjectTextBox) {
        ArrayList<SpenObjectBase> objectList = new ArrayList<>();
        RectF rect = ObjectTextBox.getRect();
        rect.left = (int) rect.left;
        rect.right = (int) Math.ceil(rect.right);
        rect.top = (int) rect.top;
        rect.bottom = (int) Math.ceil(rect.bottom);
        ObjectTextBox.setRect(rect, false);
        objectList.add(ObjectTextBox);
        setObjectList(objectList);
    }

    public SpenObjectTextBox getObject() {
        return (SpenObjectTextBox) getObjectList().get(0);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    protected boolean handleTouchEvent(MotionEvent event) {
        if (getObjectList().get(0) == null) {
            return false;
        }
        switch (event.getAction() & 255) {
            case 1:
                SpenSLog.m135d(true, "handleTouchEvent() MotionEvent.ACTION_UP");
                if (this.mTouchState.isResizeZonePressed() || this.mTouchState.isRotateZonePressed() || this.mTouchState.isMoveZonePressed()) {
                    if (this.mTouchState.isCornerZonePressed()) {
                        getObject().setAutoFitOption(0);
                    }
                    if (this.mTouchState.isHorizontalResizeZonePressed()) {
                        int option = getObject().getAutoFitOption();
                        getObject().setAutoFitOption(option & (-2));
                    }
                    if (this.mTouchState.isVerticalResizeZonePressed()) {
                        int option2 = getObject().getAutoFitOption();
                        getObject().setAutoFitOption(option2 & (-3));
                    }
                    int minTextWidth = this.mTextBox.getDefaultWidth();
                    int minTextHeight = this.mTextBox.getDefaultHeight();
                    for (int i = 0; i < getObjectList().size(); i++) {
                        RectF rectf = getRectList().get(i);
                        RectF boundBox = getBoundBox(i);
                        if (boundBox == null) {
                            SpenSLog.m137e(true, "handleTouchEvent() boundBox is null.");
                            return false;
                        }
                        if (boundBox.width() < minTextWidth) {
                            if (this.mTouchState.mState == 8 || this.mTouchState.mState == 3 || this.mTouchState.mState == 5) {
                                rectf.right = rectf.left + minTextWidth;
                                boundBox.right = boundBox.left + minTextWidth;
                            } else if (this.mTouchState.mState == 6 || this.mTouchState.mState == 1 || this.mTouchState.mState == 4) {
                                rectf.left = rectf.right - minTextWidth;
                                boundBox.left = boundBox.right - minTextWidth;
                            }
                        }
                        if (boundBox.height() < minTextHeight) {
                            if (this.mTouchState.mState == 8 || this.mTouchState.mState == 6 || this.mTouchState.mState == 7) {
                                rectf.bottom = rectf.top + minTextHeight;
                                boundBox.bottom = boundBox.top + minTextHeight;
                            } else if (this.mTouchState.mState == 1 || this.mTouchState.mState == 2 || this.mTouchState.mState == 3) {
                                rectf.top = rectf.bottom - minTextHeight;
                                boundBox.top = boundBox.bottom - minTextHeight;
                            }
                        }
                        int deltaX = (int) (boundBox.centerX() - rectf.centerX());
                        int deltaY = (int) (boundBox.centerY() - rectf.centerY());
                        rectf.offset(deltaX, deltaY);
                    }
                    onObjectChanged();
                }
                super.fit();
                this.mTouchState.reset();
                invalidate();
                return true;
            default:
                return super.handleTouchEvent(event);
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mTextBox == null) {
            return true;
        }
        if (!isTouchEnabled()) {
            return false;
        }
        if (event.getAction() == 0) {
            this.mReceiveActionDown = true;
        }
        this.mTransactionTouchEvent.check(event);
        if (this.mTextBox != null && this.mTextBox.mTextEraserEnable) {
            this.mTextBox.dispatchTouchEvent(event);
            if (event.getAction() == 1) {
                close();
            }
            return true;
        }
        switch (event.getAction() & 255) {
            case 2:
                if (this.mContextMenu.mInstance != null) {
                    this.mContextMenu.mInstance.hide();
                }
                if (!this.mEditable) {
                    this.mTextBox.hideTextBox();
                    break;
                }
                break;
        }
        boolean ret = false;
        if (handleTouchEvent(event)) {
            if (this.mEditable) {
                this.mTouchState.reset();
            }
            if ((event.getAction() & 255) == 1) {
                this.mTextBox.isFocused();
            }
            ret = true;
        }
        this.mGestureDetector.onTouchEvent(event);
        return ret;
    }

    private boolean checkTextBoxValidation() {
        return this.mTextBox != null;
    }

    private void checkSettingTextInfo(SpenSettingTextInfo info) {
        if (info.align < 0 || info.align > 3) {
            SpenError.ThrowUncheckedException(7);
        }
        if (info.direction < 0 || info.direction > 1) {
            SpenError.ThrowUncheckedException(7);
        }
        if (info.font == null || info.lineSpacing < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || info.size < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            SpenError.ThrowUncheckedException(7);
        }
        if (info.style < 0 || info.style > 7) {
            SpenError.ThrowUncheckedException(7);
        }
    }

    public void appendText(String str) {
        if (checkTextBoxValidation()) {
            if (str == null) {
                SpenError.ThrowUncheckedException(7);
            } else {
                this.mTextBox.appendText(str);
            }
        }
    }

    public void removeText() {
        if (checkTextBoxValidation()) {
            this.mTextBox.removeText();
        }
    }

    public void setMargin(int left, int top, int right, int bottom) {
        this.LEFT_MARGIN = left;
        this.RIGHT_MARGIN = right;
        this.TOP_MARGIN = top;
        this.BOTTOM_MARGIN = bottom;
        if (checkTextBoxValidation()) {
            this.mTextBox.setMargin(left, right, top, bottom);
        }
    }

    public void setText(String str) {
        if (checkTextBoxValidation()) {
            if (str == null) {
                SpenError.ThrowUncheckedException(7);
            } else {
                this.mTextBox.setText(str);
            }
        }
    }

    public String getText(boolean onlySelection) {
        if (checkTextBoxValidation()) {
            return this.mTextBox.getText(onlySelection);
        }
        return null;
    }

    public void setTextCursorPosition(int index) {
        if (checkTextBoxValidation()) {
            String str = this.mTextBox.getText(false);
            if (str == null) {
                SpenError.ThrowUncheckedException(7);
            } else if (index < 0 || index > str.length()) {
                SpenError.ThrowUncheckedException(7);
            } else {
                this.mTextBox.setCursorPos(index);
            }
        }
    }

    public int getTextCursorPosition() {
        if (checkTextBoxValidation()) {
            return this.mTextBox.getCursorPos();
        }
        return 0;
    }

    public void setTextLimit(int count) {
        if (checkTextBoxValidation()) {
            if (count < -1) {
                SpenError.ThrowUncheckedException(7);
            }
            this.mTextBox.setTextLimit(count);
        }
    }

    public int getTextLimit() {
        if (checkTextBoxValidation()) {
            return this.mTextBox.getTextLimit();
        }
        return -1;
    }

    public void setSelection(int start, int end) {
        if (checkTextBoxValidation()) {
            String str = this.mTextBox.getText(false);
            if (str == null || start > end) {
                SpenError.ThrowUncheckedException(7);
                return;
            }
            if (start < 0 || end > str.length()) {
                SpenError.ThrowUncheckedException(7);
            } else if (start == end) {
                this.mTextBox.setSelection(start, true);
            } else {
                this.mTextBox.setSelection(start, end, true);
            }
        }
    }

    public void selectAllText() {
        if (checkTextBoxValidation()) {
            this.mTextBox.setSelectionAll();
        }
    }

    public void setTextSelectionContextMenu(SpenContextMenu contextMenu) {
        if (this.mTextBox != null) {
            this.mTextBox.setContextMenu(contextMenu);
        }
    }

    public void setTextSettingInfo(SpenSettingTextInfo info) {
        int type;
        boolean option;
        if (checkTextBoxValidation()) {
            checkSettingTextInfo(info);
            if (this.mTextSettingInfo.style != info.style) {
                if (this.mTextSettingInfo.style > info.style) {
                    type = this.mTextSettingInfo.style - info.style;
                    option = false;
                } else {
                    type = info.style - this.mTextSettingInfo.style;
                    option = true;
                }
                if ((type & 1) == 1) {
                    this.mTextBox.setTextStyle(1, option);
                }
                if ((type & 2) == 2) {
                    this.mTextBox.setTextStyle(2, option);
                }
                if ((type & 4) == 4) {
                    this.mTextBox.setTextStyle(4, option);
                }
            }
            if (this.mTextSettingInfo.color != info.color) {
                SpenObjectTextBox.ForegroundColorSpanInfo txtSpan = new SpenObjectTextBox.ForegroundColorSpanInfo();
                txtSpan.foregroundColor = info.color;
                this.mTextBox.setTextFont(txtSpan);
            }
            if (this.mTextSettingInfo.size != info.size) {
                SpenObjectTextBox.FontSizeSpanInfo txtSpan2 = new SpenObjectTextBox.FontSizeSpanInfo();
                txtSpan2.fontSize = info.size;
                this.mTextBox.setTextFont(txtSpan2);
            }
            if (this.mTextSettingInfo.font.compareTo(info.font) != 0) {
                SpenObjectTextBox.FontNameSpanInfo txtSpan3 = new SpenObjectTextBox.FontNameSpanInfo();
                txtSpan3.fontName = info.font;
                this.mTextBox.setTextFont(txtSpan3);
            }
            if (this.mTextSettingInfo.direction != info.direction) {
                SpenObjectTextBox.TextDirectionSpanInfo directionInfo = new SpenObjectTextBox.TextDirectionSpanInfo();
                directionInfo.textDirection = (char) info.direction;
                this.mTextBox.setTextFont(directionInfo);
            }
            if (this.mTextSettingInfo.align != info.align) {
                SpenObjectTextBox.AlignParagraphInfo alignInfo = new SpenObjectTextBox.AlignParagraphInfo();
                alignInfo.align = (char) info.align;
                this.mTextBox.setParagraph(alignInfo);
            }
            if (this.mTextSettingInfo.lineSpacing != info.lineSpacing || this.mTextSettingInfo.lineSpacingType != info.lineSpacingType) {
                SpenObjectTextBox.LineSpacingParagraphInfo spacingInfo = new SpenObjectTextBox.LineSpacingParagraphInfo();
                spacingInfo.type = info.lineSpacingType;
                spacingInfo.lineSpacing = info.lineSpacing;
                this.mTextBox.setParagraph(spacingInfo);
            }
            this.mTextSettingInfo.style = info.style;
            this.mTextSettingInfo.color = info.color;
            this.mTextSettingInfo.size = info.size;
            this.mTextSettingInfo.font = info.font;
            this.mTextSettingInfo.align = info.align;
            this.mTextSettingInfo.lineSpacing = info.lineSpacing;
            this.mTextSettingInfo.direction = info.direction;
            if (!this.mEditable) {
                super.fit();
                onObjectChanged();
            }
        }
    }

    public SpenSettingTextInfo getTextSettingInfo() {
        SpenSettingTextInfo info = new SpenSettingTextInfo();
        info.style = this.mTextSettingInfo.style;
        info.color = this.mTextSettingInfo.color;
        info.size = this.mTextSettingInfo.size;
        info.font = this.mTextSettingInfo.font;
        info.align = this.mTextSettingInfo.align;
        info.lineIndent = this.mTextSettingInfo.lineIndent;
        info.lineSpacing = this.mTextSettingInfo.lineSpacing;
        info.direction = this.mTextSettingInfo.direction;
        return info;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    public void close() {
        this.mIsClosed = true;
        if (!this.mPageDoc.isValid()) {
            if (this.mTextBox != null) {
                this.mTextBox.close();
                this.mTextBox = null;
                return;
            }
            return;
        }
        try {
            if (this.mTextBox != null) {
                SpenObjectTextBox object = this.mTextBox.getObjectText();
                if (object != null) {
                    try {
                        object.parseHyperText();
                        String str = object.getText();
                        if ((str != null || object.getTemplateProperty()) && !this.mTextBox.isViewModeEnabled()) {
                            object.setVereticalPan(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                        }
                        if (this.mEditable) {
                            this.mEditable = false;
                            onVisibleUpdated(true);
                        } else {
                            this.mEditable = false;
                            onObjectChanged();
                        }
                    } catch (SpenAlreadyClosedException e) {
                        e.printStackTrace();
                    }
                }
                this.mTextBox.close();
                this.mTextBox = null;
            }
        } catch (SpenAlreadyClosedException e2) {
            e2.printStackTrace();
        }
        super.close();
    }

    public void setTextEraserEnabled(boolean enable) {
        this.mUseTextEraser = enable;
        if (this.mTextBox != null) {
            this.mTextBox.setEraserMode(enable);
        }
    }

    public boolean isTextEraserEnabled() {
        return this.mUseTextEraser;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    public int getPixel(int x, int y) {
        if (this.mTextBox == null) {
            return 0;
        }
        int x2 = x - ((int) (this.mTextBox.getX() + 1.0f));
        int y2 = y - ((int) (this.mTextBox.getY() + 1.0f));
        if (x2 <= 0 || x2 >= this.mTextBox.getWidth() || y2 <= 0 || y2 >= this.mTextBox.getHeight()) {
            return 0;
        }
        return this.mTextBox.getPixel(x2, y2);
    }

    private boolean verifyRect(RectF rect) {
        return rect != null && rect.width() > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && rect.height() > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    public void setContextMenuVisible(boolean visible) {
        if (this.mTextBox != null && isEditable()) {
            this.mTextBox.setContextMenuVisible(visible);
            this.mTextBox.updateContextMenuLocation();
        } else {
            super.setContextMenuVisible(visible);
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    public boolean isContextMenuVisible() {
        return (this.mTextBox == null || !isEditable()) ? super.isContextMenuVisible() : this.mTextBox.isContextMenuVisible();
    }

    private class GestureListener implements GestureDetector.OnGestureListener {
        private GestureListener() {
        }

        /* synthetic */ GestureListener(SpenControlTextBox spenControlTextBox, GestureListener gestureListener) {
            this();
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent e) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e) {
            if (SpenControlTextBox.this.mReceiveActionDown) {
                SpenObjectTextBox objectTextBox = (SpenObjectTextBox) SpenControlTextBox.this.getObjectList().get(0);
                if (SpenControlTextBox.this.getRect().contains(e.getX(), e.getY()) && objectTextBox.isRotatable() && !objectTextBox.isReadOnlyEnabled()) {
                    SpenControlTextBox.this.mTextBox.bringToFront();
                    SpenControlTextBox.this.mTextBox.enableTextInput(true);
                    SpenControlTextBox.this.mTextBox.fit(true);
                    SpenControlTextBox.this.setEditable(true);
                    SpenControlTextBox.this.setStyle(2);
                    if (SpenControlTextBox.this.mContextMenu.mInstance != null) {
                        SpenControlTextBox.this.mContextMenu.mInstance.hide();
                    }
                }
                if (SpenControlTextBox.this.getStyle() != 2 && SpenControlTextBox.this.mContextMenu.mInstance != null) {
                    SpenControlTextBox.this.updateContextMenu();
                    SpenControlTextBox.this.mContextMenu.show();
                }
            }
            return true;
        }
    }
}
