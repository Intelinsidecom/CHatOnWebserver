package com.samsung.android.sdk.pen.engine;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.TextKeyListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.infraware.office.evengine.InterfaceC0507E;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.SpenSettingTextInfo;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.engine.SpenControlBase;
import com.samsung.android.sdk.pen.util.SpenError;
import com.samsung.spensdk.SCanvasView;
import com.sec.spp.push.Config;
import com.vlingo.sdk.internal.vlservice.config.VLConfigParser;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class SpenTextBox extends View {
    private static final int BITMAP_CUE_BOTTOM = 1;
    private static final int BITMAP_CUE_MAX = 2;
    private static final int BITMAP_CUE_TOP = 0;
    private static final int BITMAP_HANDLE_CENTER_BOTTOM = 5;
    private static final int BITMAP_HANDLE_CENTER_TOP = 4;
    private static final int BITMAP_HANDLE_LEFT_BOTTOM = 1;
    private static final int BITMAP_HANDLE_LEFT_TOP = 0;
    private static final int BITMAP_HANDLE_MAX = 6;
    private static final int BITMAP_HANDLE_RIGHT_BOTTOM = 3;
    private static final int BITMAP_HANDLE_RIGHT_TOP = 2;
    private static final int BORDER_STATIC_LINE_WIDTH = 4;
    private static final char CR_CHAR = '\r';
    private static final int CUE_BOTTOM = 1;
    private static final int CUE_MAX = 2;
    private static final int CUE_TOP = 0;
    private static final int CURSOR_WIDTH = 2;
    private static final boolean DBG = false;
    private static final int DEFAULT_CONTEXTMENU_DELAY = 5000;
    private static final int DEFAULT_PADDING = 5;
    private static final int HANDLE_END = 2;
    private static final int HANDLE_MAX = 3;
    private static final int HANDLE_MIDDLE = 1;
    private static final int HANDLE_START = 0;
    private static final float ITALIC_ANGLE_IN_DEGREE = 15.0f;
    private static final char LF_CHAR = '\n';
    private static final int PRESS_AREA_COLOR_DARK = -15111536;
    private static final int PRESS_AREA_COLOR_LIGHT = -2139501838;
    private static final int SCROLL_BAR_COLOR = -2141233313;
    private static final int SCROLL_BAR_WIDTH = 4;
    private static final char SPACE_CHAR = ' ';
    private static final char TAB_CHAR = '\t';
    private static final int TEXT_INPUT_LIMITED = 5000;
    private int CONTROL_BOTTOM_MARGIN;
    private int CONTROL_LEFT_MARGIN;
    private int CONTROL_RIGHT_MARGIN;
    private int CONTROL_TOP_MARGIN;
    private final float MAX_OBJECT_HEIGHT;
    private final float MAX_OBJECT_WIDTH;
    private AccessibilityManager mAccessibilityManager;
    private boolean mAltKeyPressed;
    private Bitmap mBitmap;
    private final Blink mBlink;
    private ChangeWatcher mChangeWatcher;
    private Toast mClipboardMessage;
    private Context mContext;
    private final CContextMenu mContextMenu;
    private boolean mContextMenuVisible;
    private Bitmap[] mCueBitmap;
    private ImageButton[] mCueButton;
    private int mCurrentOrientation;
    private HandleDuration mCursorHandleDuration;
    private boolean mCursorHandleVisible;
    private boolean mCursorVisible;
    private float mDeltaY;
    private Editable mEditable;
    private int[] mEndIndex;
    protected boolean mFirstDraw;
    protected GestureDetector mGestureDetector;
    private Bitmap[] mHandleBitmap;
    private ImageButton[] mHandleButton;
    View.OnTouchListener[] mHandleListener;
    private boolean mHandlePressed;
    private boolean mHasWindowFocus;
    private Paint mHighLightPaint;
    private boolean mHighlightPathBogus;
    private EditableInputConnection mInputConnection;
    private final BroadcastReceiver mInputMethodChangedReceiver;
    private boolean mIsCommitText;
    private boolean mIsComposingText;
    private boolean mIsDeletedText;
    private boolean mIsEditableClear;
    private boolean mIsFirstCharLF;
    private boolean mIsTyping;
    private boolean mIsViewMode;
    private KeyListener mKeyListener;
    private IntentFilter mKeypadFilter;
    private int mLineCount;
    private PointF[] mLinePosition;
    private Rect mMetricsRect;
    private int mNativeTextView;
    private SpenObjectTextBox mObjectText;
    private int mPrevLineIndex;
    private int mPrevRelativeWidth;
    private Runnable mRequestObjectChange;
    private Matrix mScaleMatrix;
    private ScrollBarDuration mScrollBarDuration;
    private Paint mScrollBarPaint;
    private boolean mScrollBarVisible;
    private Paint mSelectPaint;
    private boolean mShiftKeyPressed;
    private long mShowCursor;
    private int[] mStartIndex;
    private int mSurroundingTextLength;
    private SpenControlBase.CoordinateInfo mTempCoordinateInfo;
    private Matrix mTempMatrix;
    private RectF mTempRectF;
    private TextBoxActionListener mTextBoxActionListener;
    private int[] mTextDirection;
    protected boolean mTextEraserEnable;
    private boolean[] mTextItalic;
    private int mTextLimit;
    private RectF[] mTextRect;
    private float[] mTextSize;
    private SpenTextBox mTextView;
    private boolean mTouchEnable;
    private final Typing mTyping;
    private Handler mUpdateHandler;
    private static final float SIN_15_DEGREE = (float) Math.sin(Math.toRadians(15.0d));
    private static final String[] DEFAULT_HANDLE_FILE_NAME = new String[6];
    private static final String[] DEFAULT_CUE_FILE_NAME = new String[2];
    private static final SpenSettingTextInfo DEFAULT_SPAN = new SpenSettingTextInfo();
    private static ArrayList<SpenContextMenuItemInfo> mContextMenuItemList = null;

    public interface TextBoxActionListener {
        void onExceedLimit();

        void onFocusChanged(boolean z);

        void onMoreButtonDown(SpenObjectTextBox spenObjectTextBox);

        void onObjectChanged(SpenObjectTextBox spenObjectTextBox);

        void onRequestCoordinateInfo(SpenControlBase.CoordinateInfo coordinateInfo);

        void onRequestScroll(float f, float f2);

        boolean onSelectionChanged(int i, int i2);

        void onSettingTextInfoChanged(SpenSettingTextInfo spenSettingTextInfo);

        void onUndo();

        void onVisibleUpdated(SpenObjectTextBox spenObjectTextBox, boolean z);
    }

    private static native ArrayList<Object> native_command(int i, int i2, ArrayList<Object> arrayList, int i3);

    private static native boolean native_construct(int i, Context context);

    private static native void native_finalize(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int native_getHeight(int i);

    private static native float native_getHintTextWidth(int i);

    private static native int native_getLineCount(int i);

    private static native int native_getLineEndIndex(int i, int i2);

    private static native boolean native_getLinePosition(int i, int i2, PointF pointF);

    private static native int native_getLineStartIndex(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native float native_getPan(int i);

    private static native boolean native_getTextRect(int i, int i2, RectF rectF);

    private static native int native_init();

    private static native boolean native_measure(int i, int i2);

    private static native boolean native_setBitmap(int i, Bitmap bitmap);

    private static native boolean native_setObjectText(int i, SpenObjectTextBox spenObjectTextBox);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void native_setPan(int i, float f);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean native_update(int i);

    private static class CContextMenu {
        public boolean mDirtyFlag;
        public SpenContextMenu mInstance;

        private CContextMenu() {
            this.mInstance = null;
            this.mDirtyFlag = false;
        }

        /* synthetic */ CContextMenu(CContextMenu cContextMenu) {
            this();
        }

        public void reset() {
            this.mDirtyFlag = false;
        }

        public void setDirty() {
            this.mDirtyFlag = true;
        }

        public void setRect(Rect rect) {
            if (this.mInstance != null) {
                this.mInstance.setRect(rect);
            }
        }

        public void setInstance(SpenContextMenu instance) {
            this.mInstance = instance;
        }

        public void close() {
            if (this.mInstance != null) {
                this.mInstance.close();
            }
        }

        public void hide() {
            if (this.mInstance != null) {
                this.mInstance.hide();
            }
        }

        public void show(int delay) {
            if (this.mInstance != null) {
                this.mInstance.show(delay);
            }
        }

        public boolean isShowing() {
            if (this.mInstance != null) {
                return this.mInstance.isShowing();
            }
            return false;
        }
    }

    private static class Word {
        public int endIndex;
        public int startIndex;

        private Word() {
            this.startIndex = 0;
            this.endIndex = 0;
        }

        /* synthetic */ Word(Word word) {
            this();
        }
    }

    public SpenTextBox(Context context, ViewGroup layout, int parentWidth, int ParentHeight) throws PackageManager.NameNotFoundException {
        super(context);
        this.CONTROL_LEFT_MARGIN = 0;
        this.CONTROL_RIGHT_MARGIN = 0;
        this.CONTROL_TOP_MARGIN = 0;
        this.CONTROL_BOTTOM_MARGIN = 0;
        DEFAULT_HANDLE_FILE_NAME[0] = new String("text_select_handle_left_2_browser");
        DEFAULT_HANDLE_FILE_NAME[1] = new String("text_select_handle_left_browser");
        DEFAULT_HANDLE_FILE_NAME[2] = new String("text_select_handle_right_2_browser");
        DEFAULT_HANDLE_FILE_NAME[3] = new String("text_select_handle_right_browser");
        DEFAULT_HANDLE_FILE_NAME[4] = new String("text_select_handle_reverse");
        DEFAULT_HANDLE_FILE_NAME[5] = new String("text_select_handle_middle");
        DEFAULT_CUE_FILE_NAME[0] = new String("text_cue_top_press");
        DEFAULT_CUE_FILE_NAME[1] = new String("text_cue_bottom_press");
        this.mObjectText = null;
        this.mBitmap = null;
        this.mPrevRelativeWidth = 0;
        this.mCurrentOrientation = 0;
        this.mHighLightPaint = null;
        this.mSelectPaint = null;
        this.mScrollBarPaint = null;
        this.mHighlightPathBogus = true;
        this.mKeypadFilter = null;
        this.mCursorVisible = true;
        this.mCursorHandleVisible = false;
        this.mScrollBarVisible = false;
        this.mTouchEnable = true;
        this.mHandlePressed = false;
        this.mIsViewMode = false;
        this.mHasWindowFocus = true;
        this.mTextEraserEnable = false;
        this.mFirstDraw = true;
        this.mContextMenuVisible = true;
        this.mContext = null;
        this.mAccessibilityManager = null;
        this.mEditable = null;
        this.mChangeWatcher = null;
        this.mKeyListener = null;
        this.mIsTyping = false;
        this.mIsCommitText = false;
        this.mIsDeletedText = false;
        this.mIsComposingText = false;
        this.mIsEditableClear = false;
        this.mAltKeyPressed = false;
        this.mShiftKeyPressed = false;
        this.mTextLimit = 5000;
        this.mSurroundingTextLength = 0;
        this.mLineCount = 0;
        this.mPrevLineIndex = 0;
        this.mDeltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mLinePosition = null;
        this.mStartIndex = null;
        this.mEndIndex = null;
        this.mTextRect = null;
        this.mTextSize = null;
        this.mTextDirection = null;
        this.mTextItalic = null;
        this.mIsFirstCharLF = false;
        this.mTempCoordinateInfo = null;
        this.mTempMatrix = null;
        this.mTempRectF = null;
        this.mScaleMatrix = null;
        this.mMetricsRect = null;
        this.mTextBoxActionListener = null;
        this.mUpdateHandler = null;
        this.mRequestObjectChange = null;
        this.mClipboardMessage = null;
        this.mTextView = null;
        this.mInputMethodChangedReceiver = new BroadcastReceiver() { // from class: com.samsung.android.sdk.pen.engine.SpenTextBox.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                boolean isKeypadShown = intent.getBooleanExtra("AxT9IME.isVisibleWindow", false);
                if (isKeypadShown && SpenTextBox.this.mTextView == null) {
                    SpenTextBox.this.hideSoftInput();
                }
                SpenSLog.m135d(false, "isKeypadShown" + isKeypadShown);
            }
        };
        this.mHandleListener = new View.OnTouchListener[3];
        this.mHandleListener[0] = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.engine.SpenTextBox.2
            private final PointF mDownPoint = new PointF();
            private int mLastStartIndex = 0;

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                float[] pts = SpenTextBox.this.getAbsolutePoint(event.getRawX(), event.getRawY());
                if (pts != null) {
                    int start = Selection.getSelectionStart(SpenTextBox.this.mEditable);
                    int end = Selection.getSelectionEnd(SpenTextBox.this.mEditable);
                    switch (event.getAction()) {
                        case 0:
                            this.mLastStartIndex = start;
                            Rect cursorRect = SpenTextBox.this.getCursorRect(start);
                            if (cursorRect == null) {
                                SpenSLog.m137e(false, "cursorRect is null.");
                            } else {
                                this.mDownPoint.set(cursorRect.centerX() - pts[0], cursorRect.centerY() - pts[1]);
                                SpenTextBox.this.mBlink.stopBlink();
                                SpenTextBox.this.mHighlightPathBogus = true;
                                SpenTextBox.this.mHandlePressed = true;
                            }
                            return true;
                        case 1:
                            if (start > end) {
                                start = end;
                                end = start;
                            }
                            SpenTextBox.this.setSelection(start, end, false);
                            SpenTextBox.this.mBlink.startBlink();
                            SpenTextBox.this.mHandlePressed = false;
                            return true;
                        case 2:
                            float newX = this.mDownPoint.x + pts[0];
                            float newY = this.mDownPoint.y + pts[1];
                            int line = SpenTextBox.this.getLineForVertical(newY);
                            int index = SpenTextBox.this.getCursorIndex(line, newX);
                            if (end != index && this.mLastStartIndex != index) {
                                SpenSLog.m135d(false, "Start Handdle.. line = " + line + ", index = " + index + ", newX = " + newX + ", newY = " + newY);
                                if (SpenTextBox.this.mEditable != null) {
                                    if (SpenTextBox.this.mEditable.length() >= (index < end ? end : index)) {
                                        Selection.setSelection(SpenTextBox.this.mEditable, index, end);
                                        if (SpenTextBox.this.mObjectText != null) {
                                            SpenTextBox.this.mObjectText.setCursorPos(index);
                                            SpenTextBox.this.updateSelection();
                                            this.mLastStartIndex = index;
                                            this.mDownPoint.set(this.mDownPoint.x, this.mDownPoint.y + SpenTextBox.this.checkForVerticalScroll(index));
                                            SpenTextBox.this.onDrawHandle();
                                        }
                                    }
                                }
                                return true;
                            }
                            return true;
                        default:
                            return true;
                    }
                }
                SpenSLog.m137e(false, "pts is null.");
                return true;
            }
        };
        this.mHandleListener[1] = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.engine.SpenTextBox.3
            private final PointF mDownPoint = new PointF();
            private int mLastCursorPos = 0;
            private boolean mCursorPosChanged = false;

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                float[] pts = SpenTextBox.this.getAbsolutePoint(event.getRawX(), event.getRawY());
                if (pts == null) {
                    SpenSLog.m137e(false, "pts is null.");
                    return true;
                }
                SpenTextBox.this.showCursorHandle();
                switch (event.getAction()) {
                    case 0:
                        if (SpenTextBox.this.mObjectText != null) {
                            int pos = SpenTextBox.this.mObjectText.getCursorPos();
                            this.mLastCursorPos = pos;
                            Rect temp = SpenTextBox.this.getCursorRect(pos);
                            if (temp == null) {
                                SpenSLog.m137e(false, "cursorRect is null");
                            } else {
                                RectF cursorRect = new RectF(temp);
                                this.mDownPoint.set(cursorRect.centerX() - pts[0], cursorRect.centerY() - pts[1]);
                                SpenTextBox.this.mBlink.stopBlink();
                                SpenTextBox.this.mHighlightPathBogus = true;
                                SpenTextBox.this.mHandlePressed = true;
                                this.mCursorPosChanged = false;
                            }
                        }
                        return true;
                    case 1:
                        if (SpenTextBox.this.mObjectText != null) {
                            if (!this.mCursorPosChanged && SpenTextBox.this.mTextBoxActionListener != null) {
                                SpenTextBox.this.onSelectionChanged(SpenTextBox.this.mObjectText.getCursorPos(), SpenTextBox.this.mObjectText.getCursorPos());
                            }
                            SpenTextBox.this.setSelection(SpenTextBox.this.mObjectText.getCursorPos(), false);
                            SpenTextBox.this.mBlink.startBlink();
                            SpenTextBox.this.mHandlePressed = false;
                        }
                        return true;
                    case 2:
                        float newX = this.mDownPoint.x + pts[0];
                        float newY = this.mDownPoint.y + pts[1];
                        int line = SpenTextBox.this.getLineForVertical(newY);
                        int index = SpenTextBox.this.getCursorIndex(line, newX);
                        if (this.mLastCursorPos != index) {
                            SpenSLog.m135d(false, "Middle Handdle.. line = " + line + ", index = " + index + ", newX = " + newX + ", newY = " + newY);
                            if (SpenTextBox.this.mEditable != null && SpenTextBox.this.mEditable.length() >= index) {
                                Selection.setSelection(SpenTextBox.this.mEditable, index);
                                if (SpenTextBox.this.mObjectText != null) {
                                    SpenTextBox.this.mObjectText.setCursorPos(index);
                                    SpenTextBox.this.updateSelection();
                                    this.mDownPoint.set(this.mDownPoint.x, this.mDownPoint.y + SpenTextBox.this.checkForVerticalScroll(index));
                                    this.mLastCursorPos = index;
                                    this.mCursorPosChanged = true;
                                    SpenTextBox.this.onDrawHandle();
                                    SpenTextBox.this.invalidate();
                                }
                            } else {
                                return true;
                            }
                        }
                        return true;
                    default:
                        return true;
                }
            }
        };
        this.mHandleListener[2] = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.engine.SpenTextBox.4
            private final PointF mDownPoint = new PointF();
            private int mLastEndIndex = 0;

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                float[] pts = SpenTextBox.this.getAbsolutePoint(event.getRawX(), event.getRawY());
                if (pts != null) {
                    int start = Selection.getSelectionStart(SpenTextBox.this.mEditable);
                    int end = Selection.getSelectionEnd(SpenTextBox.this.mEditable);
                    switch (event.getAction()) {
                        case 0:
                            this.mLastEndIndex = end;
                            Rect cursorRect = SpenTextBox.this.getCursorRect(end);
                            if (cursorRect == null) {
                                SpenSLog.m137e(false, "cursorRect is null");
                            } else {
                                this.mDownPoint.set(cursorRect.centerX() - pts[0], cursorRect.centerY() - pts[1]);
                                SpenTextBox.this.mBlink.stopBlink();
                                SpenTextBox.this.mHighlightPathBogus = true;
                                SpenTextBox.this.mHandlePressed = true;
                            }
                            return true;
                        case 1:
                            if (start > end) {
                                start = end;
                                end = start;
                            }
                            SpenTextBox.this.setSelection(start, end, false);
                            SpenTextBox.this.mBlink.startBlink();
                            SpenTextBox.this.mHandlePressed = false;
                            return true;
                        case 2:
                            float newX = this.mDownPoint.x + pts[0];
                            float newY = this.mDownPoint.y + pts[1];
                            int line = SpenTextBox.this.getLineForVertical(newY);
                            int index = SpenTextBox.this.getCursorIndex(line, newX);
                            if (start != index && this.mLastEndIndex != index) {
                                SpenSLog.m135d(false, "End Handdle.. line = " + line + ", index = " + index + ", newX = " + newX + ", newY = " + newY);
                                if (SpenTextBox.this.mEditable != null) {
                                    if (SpenTextBox.this.mEditable.length() >= (start < index ? index : start)) {
                                        Selection.setSelection(SpenTextBox.this.mEditable, start, index);
                                        if (SpenTextBox.this.mObjectText != null) {
                                            SpenTextBox.this.mObjectText.setCursorPos(index);
                                            SpenTextBox.this.updateSelection();
                                            this.mLastEndIndex = index;
                                            this.mDownPoint.set(this.mDownPoint.x, this.mDownPoint.y + SpenTextBox.this.checkForVerticalScroll(index));
                                            SpenTextBox.this.onDrawHandle();
                                        }
                                    }
                                }
                                return true;
                            }
                            return true;
                        default:
                            return true;
                    }
                }
                SpenSLog.m137e(false, "pts is null.");
                return true;
            }
        };
        this.mNativeTextView = 0;
        this.mContext = context;
        this.mAccessibilityManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
        this.mNativeTextView = native_init();
        this.mSelectPaint = new Paint();
        this.mSelectPaint.setStyle(Paint.Style.FILL);
        this.mSelectPaint.setColor(PRESS_AREA_COLOR_LIGHT);
        this.mSelectPaint.setAntiAlias(true);
        this.mHighLightPaint = new Paint();
        this.mHighLightPaint.setColor(-16738561);
        this.mScrollBarPaint = new Paint();
        this.mScrollBarPaint.setStyle(Paint.Style.FILL);
        this.mScrollBarPaint.setColor(SCROLL_BAR_COLOR);
        this.mScrollBarPaint.setAntiAlias(true);
        this.mBlink = new Blink(this);
        this.mScaleMatrix = new Matrix();
        this.mContextMenu = new CContextMenu(null);
        this.mChangeWatcher = new ChangeWatcher(this, null);
        if (this.mEditable == null) {
            this.mEditable = Editable.Factory.getInstance().newEditable("");
            Selection.setSelection(this.mEditable, 0);
            InputFilter[] arrayOfInputFilter = {new SpenTextByteLengthFilter(getContext(), 5000)};
            this.mEditable.setFilters(arrayOfInputFilter);
        }
        this.mKeyListener = TextKeyListener.getInstance(false, TextKeyListener.Capitalize.SENTENCES);
        this.mTyping = new Typing(this);
        this.mUpdateHandler = new Handler();
        this.mRequestObjectChange = new Runnable() { // from class: com.samsung.android.sdk.pen.engine.SpenTextBox.5
            @Override // java.lang.Runnable
            public void run() {
                SpenTextBox.this.onVisibleUpdated(false);
            }
        };
        if (!native_construct(this.mNativeTextView, getContext())) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        this.MAX_OBJECT_WIDTH = parentWidth;
        this.MAX_OBJECT_HEIGHT = ParentHeight;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels > displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels;
        this.mMetricsRect = new Rect(0, 0, width, width);
        this.mCurrentOrientation = getContext().getResources().getConfiguration().orientation;
        this.mTextView = this;
        this.mKeypadFilter = new IntentFilter();
        this.mKeypadFilter.addAction("ResponseAxT9Info");
        getContext().registerReceiver(this.mInputMethodChangedReceiver, this.mKeypadFilter);
        initTextBox(layout);
    }

    public void close() {
        InputFilter[] arrayOfInputFilter;
        hideSoftInput();
        getContext().unregisterReceiver(this.mInputMethodChangedReceiver);
        ViewGroup layout = (ViewGroup) getParent();
        if (layout != null) {
            layout.removeView(this);
            for (int i = 0; i < 3; i++) {
                layout.removeView(this.mHandleButton[i]);
            }
        }
        if (this.mNativeTextView != 0) {
            native_finalize(this.mNativeTextView);
            this.mNativeTextView = 0;
            if (this.mBitmap != null) {
                this.mBitmap.recycle();
                this.mBitmap = null;
            }
        }
        for (int i2 = 0; i2 < 6; i2++) {
            if (this.mHandleBitmap[i2] != null) {
                this.mHandleBitmap[i2].recycle();
                this.mHandleBitmap[i2] = null;
            }
        }
        if (this.mContextMenu != null) {
            this.mContextMenu.hide();
            this.mContextMenu.close();
        }
        if (this.mEditable != null && (arrayOfInputFilter = this.mEditable.getFilters()) != null) {
            ((SpenTextByteLengthFilter) arrayOfInputFilter[0]).close();
        }
        this.mHandleBitmap = null;
        this.mObjectText = null;
        this.mTextView = null;
    }

    public void setTextBoxListener(TextBoxActionListener actionListener) {
        this.mTextBoxActionListener = actionListener;
        if (this.mEditable != null) {
            int start = Selection.getSelectionStart(this.mEditable);
            int end = Selection.getSelectionEnd(this.mEditable);
            SpenSettingTextInfo textInfo = getSettingInfo(start, end);
            this.mTextBoxActionListener.onSettingTextInfoChanged(textInfo);
        }
    }

    public void fit(boolean checkCursorPos) {
        SpenSLog.m135d(false, "fit() is called.");
        if (this.mNativeTextView == 0) {
            SpenSLog.m137e(false, "fit() mNativeTextView is invalid.");
            return;
        }
        if (checkCursorPos) {
            adjustTextBox();
        }
        SpenControlBase.CoordinateInfo coordinateInfo = getCoordinateInfo();
        if (coordinateInfo == null) {
            SpenSLog.m137e(false, "coordinateInfo is null.");
            return;
        }
        if (this.mObjectText != null) {
            RectF objectRect = this.mObjectText.getRect();
            if (objectRect == null) {
                SpenSLog.m137e(false, "objectRect is null.");
                return;
            }
            RectF relativeRect = new RectF();
            relativeCoordinate(relativeRect, objectRect, coordinateInfo);
            ViewGroup parentLayout = (ViewGroup) getParent();
            if (parentLayout != null) {
                RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
                localLayoutParams.leftMargin = (int) relativeRect.left;
                localLayoutParams.topMargin = (int) relativeRect.top;
                localLayoutParams.rightMargin = (int) (parentLayout.getWidth() - (relativeRect.left + relativeRect.width()));
                localLayoutParams.width = (int) relativeRect.width();
                localLayoutParams.height = (int) relativeRect.height();
                if (this.mBitmap != null) {
                    if (this.mBitmap.getWidth() != ((int) objectRect.width()) || this.mBitmap.getHeight() != ((int) objectRect.height())) {
                        SpenSLog.m135d(false, "fit() Bitmap is recycled.");
                        this.mBitmap.recycle();
                        int width = (int) Math.ceil(objectRect.width());
                        int height = (int) Math.ceil(objectRect.height());
                        if (width > 0 && height > 0) {
                            this.mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                            native_setBitmap(this.mNativeTextView, this.mBitmap);
                        }
                        SpenSLog.m135d(false, "fit() bitmap width = " + width + ", object height = " + height);
                    } else {
                        this.mBitmap.setPixel(0, 0, this.mBitmap.getPixel(0, 0));
                    }
                } else {
                    int width2 = (int) Math.ceil(objectRect.width());
                    int height2 = (int) Math.ceil(objectRect.height());
                    if (width2 > 0 && height2 > 0) {
                        this.mBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
                        native_setBitmap(this.mNativeTextView, this.mBitmap);
                    }
                }
                setLayoutParams(localLayoutParams);
            }
            setPivotX(relativeRect.width() / 2.0f);
            setPivotY(relativeRect.height() / 2.0f);
            setRotation(this.mObjectText.getRotation());
            this.mScaleMatrix.setScale(coordinateInfo.zoomRatio, coordinateInfo.zoomRatio, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            native_update(this.mNativeTextView);
            this.mBlink.restartBlink();
            invalidate();
        }
    }

    public void measureText() {
        SpenSLog.m135d(false, "measureText() start..");
        if (this.mNativeTextView == 0) {
            SpenSLog.m137e(false, "measureText() mNativeTextView is invalid.");
            return;
        }
        if (this.mObjectText != null) {
            native_measure(this.mNativeTextView, (int) this.mObjectText.getRect().width());
            float diffY = getDeltaY(this.mObjectText.getGravity());
            int stringLength = 0;
            String str = this.mObjectText.getText();
            if (str != null) {
                stringLength = str.length();
            }
            if (stringLength > 0) {
                this.mLineCount = native_getLineCount(this.mNativeTextView);
                this.mLinePosition = new PointF[this.mLineCount];
                this.mStartIndex = new int[this.mLineCount];
                this.mEndIndex = new int[this.mLineCount];
                this.mTextRect = new RectF[stringLength];
                this.mTextSize = new float[stringLength];
                this.mTextDirection = new int[stringLength];
                this.mTextItalic = new boolean[stringLength];
                for (int cnt = 0; cnt < this.mLineCount; cnt++) {
                    this.mLinePosition[cnt] = new PointF();
                    native_getLinePosition(this.mNativeTextView, cnt, this.mLinePosition[cnt]);
                    this.mLinePosition[cnt].offset(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, diffY);
                    this.mStartIndex[cnt] = native_getLineStartIndex(this.mNativeTextView, cnt);
                    this.mEndIndex[cnt] = native_getLineEndIndex(this.mNativeTextView, cnt);
                }
                if (native_getLineStartIndex(this.mNativeTextView, 0) == -1) {
                    this.mIsFirstCharLF = true;
                } else {
                    this.mIsFirstCharLF = false;
                }
                this.mDeltaY = native_getPan(this.mNativeTextView);
                for (int cnt2 = 0; cnt2 < stringLength; cnt2++) {
                    this.mTextRect[cnt2] = new RectF();
                    native_getTextRect(this.mNativeTextView, cnt2, this.mTextRect[cnt2]);
                    this.mTextRect[cnt2].offset(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, diffY);
                    this.mTextDirection[cnt2] = 0;
                    this.mTextItalic[cnt2] = false;
                }
                ArrayList<SpenObjectTextBox.TextSpanInfo> spans = this.mObjectText.getSpan();
                if (spans != null) {
                    for (int cnt3 = 0; cnt3 < spans.size(); cnt3++) {
                        if (spans.get(cnt3) instanceof SpenObjectTextBox.FontSizeSpanInfo) {
                            int startPos = spans.get(cnt3).startPos;
                            int endPos = spans.get(cnt3).endPos;
                            if (endPos > stringLength) {
                                endPos = stringLength;
                            }
                            float fontSize = ((SpenObjectTextBox.FontSizeSpanInfo) spans.get(cnt3)).fontSize;
                            for (int i = startPos; i < endPos; i++) {
                                this.mTextSize[i] = fontSize;
                            }
                        }
                        if (spans.get(cnt3) instanceof SpenObjectTextBox.TextDirectionSpanInfo) {
                            int startPos2 = spans.get(cnt3).startPos;
                            int endPos2 = spans.get(cnt3).endPos;
                            if (endPos2 > stringLength) {
                                endPos2 = stringLength;
                            }
                            if (startPos2 > stringLength || endPos2 > stringLength) {
                                SpenSLog.m137e(false, "Invalid Span Info");
                                break;
                            }
                            for (int cnt1 = startPos2; cnt1 < endPos2; cnt1++) {
                                this.mTextDirection[cnt1] = ((SpenObjectTextBox.TextDirectionSpanInfo) spans.get(cnt3)).textDirection;
                            }
                        }
                        if (spans.get(cnt3) instanceof SpenObjectTextBox.ItalicStyleSpanInfo) {
                            int startPos3 = spans.get(cnt3).startPos;
                            int endPos3 = spans.get(cnt3).endPos;
                            if (endPos3 > stringLength) {
                                endPos3 = stringLength;
                            }
                            for (int cnt12 = startPos3; cnt12 < endPos3; cnt12++) {
                                this.mTextItalic[cnt12] = ((SpenObjectTextBox.ItalicStyleSpanInfo) spans.get(cnt3)).isItalic;
                            }
                        }
                    }
                }
            } else {
                initMeasureInfo();
            }
            SpenSLog.m135d(false, "measureText() end..");
        }
    }

    public void showTextBox() {
        setVisibility(0);
    }

    public void hideTextBox() {
        setVisibility(8);
    }

    public void appendText(String str) {
        int start = Selection.getSelectionStart(this.mEditable);
        int end = Selection.getSelectionEnd(this.mEditable);
        if (this.mTextLimit == 5000 || this.mTextLimit > this.mEditable.length() + str.length()) {
            this.mEditable.replace(start, end, str);
        } else {
            this.mEditable.replace(start, end, str.substring(0, this.mTextLimit - start));
        }
        this.mCursorVisible = this.mTextEraserEnable ? false : true;
        measureText();
    }

    public void removeText() {
        int start = Selection.getSelectionStart(this.mEditable);
        int end = Selection.getSelectionEnd(this.mEditable);
        this.mIsDeletedText = true;
        if (start != end) {
            if (start < end) {
                this.mEditable.delete(start, end);
                setSelection(start, false);
            } else {
                this.mEditable.delete(end, start);
                setSelection(end, false);
            }
        } else if (start > 0) {
            this.mEditable.delete(start - 1, start);
        }
        measureText();
    }

    public void setText(String str) {
        if (this.mTextLimit == 5000 || this.mTextLimit > str.length()) {
            this.mEditable.replace(0, this.mEditable.length(), str);
        } else {
            this.mEditable.replace(0, this.mEditable.length(), str.substring(0, this.mTextLimit));
        }
        measureText();
    }

    public String getText(boolean option) {
        if (this.mEditable == null) {
            return null;
        }
        int start = Selection.getSelectionStart(this.mEditable);
        int end = Selection.getSelectionEnd(this.mEditable);
        String str = this.mEditable.toString();
        if (option) {
            if (str != null) {
                return str.substring(start, end);
            }
            return null;
        }
        return str;
    }

    public void setTextFont(SpenObjectTextBox.TextSpanInfo textSpan) {
        int start = Selection.getSelectionStart(this.mEditable);
        int end = Selection.getSelectionEnd(this.mEditable);
        if (textSpan instanceof SpenObjectTextBox.ForegroundColorSpanInfo) {
            setTextFontColor(((SpenObjectTextBox.ForegroundColorSpanInfo) textSpan).foregroundColor, start, end);
        } else if (textSpan instanceof SpenObjectTextBox.FontSizeSpanInfo) {
            setTextFontSize(((SpenObjectTextBox.FontSizeSpanInfo) textSpan).fontSize, start, end);
        } else if (textSpan instanceof SpenObjectTextBox.BackgroundColorSpanInfo) {
            setTextBackgroundColor(((SpenObjectTextBox.BackgroundColorSpanInfo) textSpan).backgroundColor, start, end);
        } else if (textSpan instanceof SpenObjectTextBox.FontNameSpanInfo) {
            setTextFontName(((SpenObjectTextBox.FontNameSpanInfo) textSpan).fontName, start, end);
        } else if (textSpan instanceof SpenObjectTextBox.TextDirectionSpanInfo) {
            setTextDirection(((SpenObjectTextBox.TextDirectionSpanInfo) textSpan).textDirection, start, end);
        }
        fit(true);
        measureText();
    }

    public void setTextStyle(int type, boolean option) {
        SpenSLog.m135d(false, "Bold=" + (type & 1) + " ITALIC=" + (type & 2) + " UNDER=" + (type & 4));
        int start = Selection.getSelectionStart(this.mEditable);
        int end = Selection.getSelectionEnd(this.mEditable);
        if (type == 1) {
            setTextBold(option, start, end);
        } else if (type == 2) {
            setTextItalic(option, start, end);
        } else if (type == 4) {
            setTextUnderline(option, start, end);
        }
        fit(true);
        measureText();
    }

    public void setContextMenu(SpenContextMenu contextMenu) {
        this.mContextMenu.hide();
        this.mContextMenu.setInstance(contextMenu);
    }

    public void setContextMenuVisible(boolean visible) {
        this.mContextMenuVisible = visible;
    }

    public boolean isContextMenuVisible() {
        return this.mContextMenuVisible;
    }

    public void setParagraph(SpenObjectTextBox.TextParagraphInfo paragraphInfo) {
        if (paragraphInfo != null) {
            if (paragraphInfo instanceof SpenObjectTextBox.AlignParagraphInfo) {
                setParagraphAlign(((SpenObjectTextBox.AlignParagraphInfo) paragraphInfo).align);
            } else if (paragraphInfo instanceof SpenObjectTextBox.LineSpacingParagraphInfo) {
                setParagraphSpacing(((SpenObjectTextBox.LineSpacingParagraphInfo) paragraphInfo).type, ((SpenObjectTextBox.LineSpacingParagraphInfo) paragraphInfo).lineSpacing);
            }
            fit(true);
            measureText();
        }
    }

    public void setEraserMode(boolean option) {
        this.mTextEraserEnable = option;
    }

    public void setObjectText(SpenObjectTextBox textObj) {
        SpenSLog.m135d(false, "setObjectText() is called.");
        if (textObj == null || this.mNativeTextView == 0) {
            SpenSLog.m137e(false, new StringBuilder("setObjectText() ").append(textObj).toString() == null ? "textObj" : "mNativeTextView is invalid.");
            return;
        }
        this.mObjectText = textObj;
        native_setObjectText(this.mNativeTextView, this.mObjectText);
        initEditable();
        measureText();
    }

    public SpenObjectTextBox getObjectText() {
        return this.mObjectText;
    }

    public int isAccessoryKeyboardState() throws NoSuchMethodException, SecurityException {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService("input_method");
        Class cls = imm.getClass();
        try {
            Method mtd = cls.getMethod("isAccessoryKeyboardState", null);
            try {
                try {
                    return ((Integer) mtd.invoke(imm, new Object[0])).intValue();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return 0;
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                    return 0;
                }
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return 0;
            }
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        }
    }

    public void showSoftInput() {
        if (this.mHasWindowFocus) {
            InputMethodManager imm = (InputMethodManager) getContext().getSystemService("input_method");
            imm.showSoftInput(this.mTextView, 0);
        } else {
            new Handler().postDelayed(new Runnable() { // from class: com.samsung.android.sdk.pen.engine.SpenTextBox.6
                @Override // java.lang.Runnable
                public void run() {
                    InputMethodManager imm2 = (InputMethodManager) SpenTextBox.this.getContext().getSystemService("input_method");
                    imm2.showSoftInput(SpenTextBox.this.mTextView, 0);
                }
            }, 100L);
        }
    }

    public void hideSoftInput() {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService("input_method");
        imm.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public void enableTextInput(boolean option) {
        if (option) {
            setFocusableInTouchMode(true);
            setVisibility(0);
            setFocusable(true);
            requestFocus();
            if (!this.mTextEraserEnable) {
                showSoftInput();
            }
        }
    }

    public void setViewModeEnabled(boolean option) {
        this.mIsViewMode = option;
        if (option) {
            setFocusableInTouchMode(true);
            setVisibility(0);
            setFocusable(true);
            requestFocus();
            fit(true);
        }
    }

    public boolean isViewModeEnabled() {
        return this.mIsViewMode;
    }

    public boolean isContextMenuShowing() {
        if (this.mContextMenu != null) {
            return this.mContextMenu.isShowing();
        }
        return false;
    }

    public void setCursorPos(int index) {
        setSelection(index, true);
    }

    public int getCursorPos() {
        if (this.mObjectText == null) {
            return 0;
        }
        return this.mObjectText.getCursorPos();
    }

    public void setSelection(int pos, boolean isForce) {
        if (pos < 0) {
            SpenSLog.m135d(false, "setSelection pos < 0");
        }
        if (this.mEditable != null && this.mEditable.length() >= pos) {
            Selection.setSelection(this.mEditable, pos);
            if (this.mObjectText != null) {
                this.mObjectText.setCursorPos(pos);
                updateSelection();
                this.mHandleButton[0].setVisibility(8);
                this.mHandleButton[2].setVisibility(8);
                if (this.mTextBoxActionListener != null) {
                    SpenSettingTextInfo textInfo = getSettingInfo(pos, pos);
                    this.mTextBoxActionListener.onSettingTextInfoChanged(textInfo);
                }
                this.mCursorVisible = this.mTextEraserEnable ? false : true;
                if (isForce) {
                    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
                    if (localLayoutParams.width > 0 && localLayoutParams.height > 0) {
                        fit(true);
                    }
                }
                measureText();
            }
        }
    }

    public void setSelection(int start, int end, boolean isForce) {
        SpenSLog.m135d(false, "setSelection start = " + start + " ,end = " + end);
        if (this.mObjectText != null && this.mEditable != null && this.mEditable.length() >= end) {
            Selection.setSelection(this.mEditable, start, end);
            this.mObjectText.setCursorPos(start);
            updateSelection();
            if (!this.mTextEraserEnable && this.mTextBoxActionListener != null) {
                SpenSettingTextInfo textInfo = getSettingInfo(start, end);
                this.mTextBoxActionListener.onSettingTextInfoChanged(textInfo);
                onSelectionChanged(start, end);
            }
            this.mCursorVisible = false;
            if (isForce) {
                fit(true);
            }
            measureText();
        }
    }

    public void setSelectionAll() {
        String str;
        if (this.mObjectText != null && (str = this.mObjectText.getText()) != null && str.length() != 0) {
            setSelection(0, str.length(), true);
        }
    }

    public void setTextLimit(int count) {
        if (this.mEditable != null) {
            if (5000 < count) {
                count = 5000;
            }
            this.mTextLimit = count;
            if (this.mEditable.length() > this.mTextLimit) {
                this.mIsDeletedText = true;
                if (this.mTextLimit != -1) {
                    this.mEditable.delete(this.mTextLimit, this.mEditable.length());
                }
            }
            InputFilter[] arrayOfInputFilter = {new SpenTextByteLengthFilter(getContext(), count)};
            this.mEditable.setFilters(arrayOfInputFilter);
        }
    }

    public int getTextLimit() {
        return this.mTextLimit;
    }

    public int getPixel(int x, int y) {
        int res = 0;
        if (this.mBitmap != null) {
            float[] pts = getAbsolutePoint(x, y);
            if (pts == null) {
                SpenSLog.m137e(false, "pts is null.");
                return 0;
            }
            float deltaY = native_getPan(this.mNativeTextView);
            int nX = (int) pts[0];
            int nY = (int) (pts[1] - deltaY);
            if (nX >= 0 && nX < this.mBitmap.getWidth() && nY >= 0 && nY < this.mBitmap.getHeight()) {
                res = this.mBitmap.getPixel(nX, nY);
            }
        }
        return res;
    }

    public float getMaximumWidth() {
        RectF objectRect = this.mObjectText.getRect();
        if (objectRect == null) {
            return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        SpenControlBase.CoordinateInfo coordinateInfo = getCoordinateInfo();
        if (coordinateInfo == null) {
            SpenSLog.m137e(false, "coordinateInfo is null.");
            return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        RectF relativeRect = new RectF();
        relativeCoordinate(relativeRect, objectRect, coordinateInfo);
        SpenSLog.m135d(false, "checkForHorizontalScroll() start");
        RectF absoluteTextRect = new RectF();
        RectF absoluteRect = this.mObjectText.getRect();
        float absoluteMargin = this.mObjectText.getLeftMargin() + this.mObjectText.getRightMargin();
        String str = this.mObjectText.getText();
        if (this.mObjectText.isHintTextEnabled() && (str == null || str.length() == 0)) {
            absoluteMargin += native_getHintTextWidth(this.mNativeTextView);
        } else if (native_getLineCount(this.mNativeTextView) == 0) {
            ArrayList<SpenObjectTextBox.TextSpanInfo> sInfo = this.mObjectText.findSpans(this.mObjectText.getCursorPos(), this.mObjectText.getCursorPos());
            if (sInfo != null) {
                Iterator<SpenObjectTextBox.TextSpanInfo> it = sInfo.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SpenObjectTextBox.TextSpanInfo info = it.next();
                    if (info instanceof SpenObjectTextBox.FontSizeSpanInfo) {
                        absoluteMargin += ((SpenObjectTextBox.FontSizeSpanInfo) info).fontSize;
                        break;
                    }
                }
            }
        } else {
            absoluteMargin += 5.0f;
        }
        float relativeMargin = coordinateInfo.zoomRatio * absoluteMargin;
        float lineAbsoluteWidth = absoluteMargin;
        float lineRelativeWidth = relativeMargin;
        float tempLineAbsoluteWidth = absoluteMargin;
        float tempLineRelativeWidth = relativeMargin;
        if (str != null) {
            int length = str.length();
            SpenSLog.m135d(false, "checkForHorizontalScroll() length = " + length);
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (str.charAt(i) == '\n') {
                    tempLineAbsoluteWidth = absoluteMargin;
                    tempLineRelativeWidth = relativeMargin;
                } else {
                    native_getTextRect(this.mNativeTextView, i, absoluteTextRect);
                    float relativeTextWidth = coordinateInfo.zoomRatio * absoluteTextRect.width();
                    if (absoluteRect.left + tempLineAbsoluteWidth + absoluteTextRect.width() < (this.MAX_OBJECT_WIDTH - this.CONTROL_RIGHT_MARGIN) - 4.0f) {
                        tempLineAbsoluteWidth += absoluteTextRect.width();
                        tempLineRelativeWidth += relativeTextWidth;
                    } else {
                        float lineAbsoluteWidth2 = ((this.MAX_OBJECT_WIDTH - this.CONTROL_RIGHT_MARGIN) - 4.0f) - absoluteRect.left;
                        lineRelativeWidth = coordinateInfo.zoomRatio * lineAbsoluteWidth2;
                        break;
                    }
                }
                if (tempLineAbsoluteWidth > lineAbsoluteWidth) {
                    lineAbsoluteWidth = tempLineAbsoluteWidth;
                }
                if (tempLineRelativeWidth > lineRelativeWidth) {
                    lineRelativeWidth = tempLineRelativeWidth;
                }
                i++;
            }
        }
        return (int) Math.ceil(lineRelativeWidth);
    }

    public float getMaximumHeight() {
        return native_getHeight(this.mNativeTextView);
    }

    public int getDefaultWidth() {
        if (this.mObjectText == null) {
            return 0;
        }
        int absoluteWidth = Math.round(this.mObjectText.getLeftMargin() + this.mObjectText.getRightMargin());
        float fontWidth = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        int stringLength = getTextLength();
        RectF rect = new RectF();
        for (int i = 0; i < stringLength; i++) {
            native_getTextRect(this.mNativeTextView, i, rect);
            if (fontWidth < rect.width()) {
                fontWidth = rect.width();
            }
        }
        float fontWidth2 = fontWidth + 4.0f;
        SpenControlBase.CoordinateInfo coordinateInfo = getCoordinateInfo();
        if (coordinateInfo == null) {
            SpenSLog.m137e(false, "coordinateInfo is null.");
            return 0;
        }
        return (int) Math.ceil((absoluteWidth + fontWidth2) * coordinateInfo.zoomRatio);
    }

    public int getDefaultHeight() {
        if (this.mObjectText == null) {
            return 0;
        }
        int absoluteHeight = Math.round(this.mObjectText.getTopMargin() + this.mObjectText.getBottomMargin());
        float fontSize = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        ArrayList<SpenObjectTextBox.TextSpanInfo> sInfo = this.mObjectText.findSpans(this.mObjectText.getCursorPos(), this.mObjectText.getCursorPos());
        if (sInfo != null) {
            Iterator<SpenObjectTextBox.TextSpanInfo> it = sInfo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SpenObjectTextBox.TextSpanInfo info = it.next();
                if (info instanceof SpenObjectTextBox.FontSizeSpanInfo) {
                    fontSize = ((SpenObjectTextBox.FontSizeSpanInfo) info).fontSize;
                    break;
                }
            }
        }
        ArrayList<SpenObjectTextBox.TextParagraphInfo> pInfo = this.mObjectText.getParagraph();
        if (pInfo != null) {
            Iterator<SpenObjectTextBox.TextParagraphInfo> it2 = pInfo.iterator();
            while (it2.hasNext()) {
                SpenObjectTextBox.TextParagraphInfo info2 = it2.next();
                if (info2 instanceof SpenObjectTextBox.LineSpacingParagraphInfo) {
                    if (((SpenObjectTextBox.LineSpacingParagraphInfo) info2).type == 1) {
                        absoluteHeight = (int) (absoluteHeight + (((SpenObjectTextBox.LineSpacingParagraphInfo) info2).lineSpacing * fontSize));
                    } else {
                        absoluteHeight = (int) (absoluteHeight + ((SpenObjectTextBox.LineSpacingParagraphInfo) info2).lineSpacing);
                    }
                }
            }
        }
        SpenControlBase.CoordinateInfo coordinateInfo = getCoordinateInfo();
        if (coordinateInfo == null) {
            SpenSLog.m137e(false, "coordinateInfo is null.");
            return 0;
        }
        return (int) Math.ceil(absoluteHeight * coordinateInfo.zoomRatio);
    }

    public void setMargin(int left, int top, int right, int bottom) {
        this.CONTROL_LEFT_MARGIN = left;
        this.CONTROL_RIGHT_MARGIN = right;
        this.CONTROL_TOP_MARGIN = top;
        this.CONTROL_BOTTOM_MARGIN = bottom;
    }

    public boolean isTextInputable() {
        return isFocused();
    }

    private void updateContextmenu() {
        if (this.mContextMenu != null && this.mContextMenu.mDirtyFlag && this.mContextMenuVisible) {
            this.mContextMenu.reset();
            ViewGroup parentLayout = (ViewGroup) getParent();
            Rect parentRect = new Rect();
            parentLayout.getGlobalVisibleRect(parentRect);
            SpenSLog.m134d("onSelectionChange : parentRect" + parentRect);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            Rect textRect = new Rect();
            textRect.left = localLayoutParams.leftMargin + parentRect.left;
            textRect.top = localLayoutParams.topMargin + parentRect.top;
            textRect.right = textRect.left + localLayoutParams.width;
            textRect.bottom = textRect.top + localLayoutParams.height;
            SpenSLog.m134d("onSelectionChange : textRect " + textRect);
            int selStart = Selection.getSelectionStart(this.mEditable);
            int selEnd = Selection.getSelectionStart(this.mEditable);
            Rect startCursorRect = getCursorRect(selStart);
            if (startCursorRect == null) {
                SpenSLog.m137e(false, "startCursorRect is null.");
                return;
            }
            Rect endCursorRect = getCursorRect(selEnd);
            if (endCursorRect == null) {
                SpenSLog.m137e(false, "endCursorRect is null.");
                return;
            }
            float deltaY = native_getPan(this.mNativeTextView);
            startCursorRect.offset(textRect.left, (int) (textRect.top - deltaY));
            endCursorRect.offset(textRect.left, (int) (textRect.top - deltaY));
            Rect rect = startCursorRect;
            if (startCursorRect.top - 400 > parentRect.top) {
                rect.offset(0, -400);
            } else if (endCursorRect.bottom + VLSpotterContext.DEFAULT_PHRASESPOT_PARAMB < parentRect.bottom) {
                rect = endCursorRect;
                rect.offset(0, 200);
            } else {
                rect.top = parentRect.top;
            }
            SpenSLog.m135d(false, "updateContextmenu() : rect " + rect);
            this.mContextMenu.setRect(rect);
            this.mContextMenu.show(5000);
            return;
        }
        if (this.mContextMenu != null && !this.mContextMenuVisible && isContextMenuShowing()) {
            this.mContextMenu.hide();
        }
    }

    protected void updateContextMenuLocation() {
        if (this.mContextMenu != null && this.mContextMenu.mInstance != null) {
            this.mContextMenu.setDirty();
            this.mContextMenu.hide();
            updateContextmenu();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        SpenSLog.m135d(false, "onDraw()");
        if (this.mFirstDraw) {
            this.mFirstDraw = false;
            this.mUpdateHandler.post(this.mRequestObjectChange);
        }
        if (this.mBitmap != null && this.mNativeTextView != 0) {
            onDrawSelect(canvas);
            canvas.drawBitmap(this.mBitmap, this.mScaleMatrix, null);
            onDrawHandle();
            onDrawCursor(canvas);
            onDrawScrollBar(canvas);
            updateContextmenu();
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.mBlink.stopBlink();
        this.mTyping.stopInput();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        if (this.mTextBoxActionListener != null) {
            this.mTextBoxActionListener.onFocusChanged(gainFocus);
        }
        this.mShowCursor = SystemClock.uptimeMillis();
        if (gainFocus) {
            this.mBlink.startBlink();
            if (this.mObjectText != null) {
                ArrayList<Object> tempObjectList = new ArrayList<>();
                tempObjectList.add(this.mObjectText);
                native_command(0, 0, tempObjectList, 0);
            }
        } else {
            this.mBlink.stopBlink();
            this.mTyping.stopInput();
        }
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }

    protected void onObjectChanged() {
        if (this.mTextBoxActionListener != null) {
            this.mTextBoxActionListener.onObjectChanged(this.mObjectText);
        }
    }

    protected void onVisibleUpdated(boolean bVisible) {
        if (this.mTextBoxActionListener != null) {
            this.mTextBoxActionListener.onVisibleUpdated(this.mObjectText, bVisible);
        }
    }

    protected void onRequestScroll(float dx, float dy) {
        SpenSLog.m135d(false, "onRequestScroll dx = " + dx + ", dy = " + dy);
        if (this.mTextBoxActionListener != null) {
            this.mTextBoxActionListener.onRequestScroll(dx, dy);
            this.mTextBoxActionListener.onObjectChanged(this.mObjectText);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        if (this.mCurrentOrientation != newConfig.orientation) {
            this.mContextMenu.setDirty();
            if (!this.mContextMenu.isShowing()) {
                this.mContextMenu.reset();
            }
            this.mCurrentOrientation = newConfig.orientation;
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        return super.dispatchKeyEventPreIme(event);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        SpenSLog.m135d(false, "onKeyDown() keyCode = " + keyCode);
        int start = Selection.getSelectionStart(this.mEditable);
        int end = Selection.getSelectionEnd(this.mEditable);
        switch (keyCode) {
            case 19:
            case 20:
            case 21:
            case 22:
            case 92:
            case 93:
            case 122:
            case 123:
                this.mBlink.restartBlink();
                onMoveByKey(keyCode, event);
                return true;
            case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SEND_INTERNAL_STRING /* 57 */:
            case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SECOND_DISPLAY /* 58 */:
                this.mAltKeyPressed = true;
                return true;
            case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MEDIA_LINK /* 59 */:
            case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_BRBOOKCLIP_EVENT /* 60 */:
                this.mShiftKeyPressed = true;
                return true;
            case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_FLICK_EVENT /* 61 */:
            case 62:
            case 66:
                this.mCursorVisible = true;
                break;
            case 112:
                this.mIsDeletedText = true;
                if (start == end) {
                    if (start >= getTextLength()) {
                        return true;
                    }
                    this.mEditable.delete(start, start + 1);
                    return true;
                }
                Editable editable = this.mEditable;
                int i = start < end ? start : end;
                if (start >= end) {
                    end = start;
                }
                editable.delete(i, end);
                return true;
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO /* 150 */:
            case ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_SCREENSIZE /* 151 */:
            case 152:
            case 153:
                if (event.isNumLockOn()) {
                    appendText(Integer.toString(keyCode - 144));
                    return true;
                }
                onMoveByKey(keyCode, event);
                return true;
        }
        if (keyCode == 67) {
            this.mIsDeletedText = true;
        }
        if (this.mKeyListener == null || !this.mKeyListener.onKeyDown(this, this.mEditable, keyCode, event)) {
            return super.onKeyDown(keyCode, event);
        }
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        SpenSLog.m135d(false, "onKeyUp() keyCode = " + keyCode);
        switch (keyCode) {
            case 19:
            case 20:
            case 21:
            case 22:
            case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_FLICK_EVENT /* 61 */:
            case 66:
            case 67:
                return false;
            case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SEND_INTERNAL_STRING /* 57 */:
            case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SECOND_DISPLAY /* 58 */:
                this.mAltKeyPressed = false;
                return true;
            case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MEDIA_LINK /* 59 */:
            case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_BRBOOKCLIP_EVENT /* 60 */:
                this.mShiftKeyPressed = false;
                int start = Selection.getSelectionStart(this.mEditable);
                int end = Selection.getSelectionEnd(this.mEditable);
                if (start > end) {
                    setSelection(end, start, false);
                }
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }

    @Override // android.view.View
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        String str;
        int end;
        if (event.isCtrlPressed()) {
            ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService("clipboard");
            int start = Selection.getSelectionStart(this.mEditable);
            int end2 = Selection.getSelectionEnd(this.mEditable);
            if (start > end2) {
                start = end2;
                end2 = start;
            }
            switch (keyCode) {
                case 29:
                    setSelectionAll();
                    break;
                case 31:
                    String str2 = this.mEditable.toString().substring(start, end2);
                    if (str2 != null) {
                        ClipData clip = clipboard.getPrimaryClip();
                        if (clip != null) {
                            int length = clip.getItemCount();
                            for (int i = 0; i < length; i++) {
                                if (clip.getItemAt(0).getText().toString().compareTo(str2) == 0) {
                                    if (this.mClipboardMessage == null) {
                                        this.mClipboardMessage = Toast.makeText(getContext(), getMultiLanguage("string_already_exists"), 0);
                                    } else {
                                        this.mClipboardMessage.setText(getMultiLanguage("string_already_exists"));
                                        this.mClipboardMessage.setDuration(0);
                                    }
                                    this.mClipboardMessage.setGravity(80, 0, ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO);
                                    this.mClipboardMessage.show();
                                    break;
                                }
                            }
                        }
                        clipboard.setPrimaryClip(ClipData.newPlainText("clipData", str2));
                        if (this.mClipboardMessage == null) {
                            this.mClipboardMessage = Toast.makeText(getContext(), getMultiLanguage("string_copied_to_clipboard"), 0);
                        } else {
                            this.mClipboardMessage.setText(getMultiLanguage("string_copied_to_clipboard"));
                            this.mClipboardMessage.setDuration(0);
                        }
                        this.mClipboardMessage.setGravity(80, 0, ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO);
                        this.mClipboardMessage.show();
                        if (start <= end2) {
                            start = end2;
                        }
                        setSelection(start, false);
                        break;
                    }
                    break;
                case 50:
                    ClipData clip2 = clipboard.getPrimaryClip();
                    if (clip2 != null && (str = clip2.getItemAt(0).getText().toString()) != null) {
                        appendText(str);
                        if (this.mClipboardMessage == null) {
                            this.mClipboardMessage = Toast.makeText(getContext(), getMultiLanguage("string_pasted_to_clipboard"), 0);
                        } else {
                            this.mClipboardMessage.setText(getMultiLanguage("string_pasted_to_clipboard"));
                            this.mClipboardMessage.setDuration(0);
                        }
                        this.mClipboardMessage.setGravity(80, 0, ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO);
                        this.mClipboardMessage.show();
                        int diff = str.length() - Math.abs(end2 - start);
                        if (this.mTextLimit > this.mEditable.length() + diff) {
                            end = start + str.length();
                        } else {
                            end = start - diff;
                        }
                        if (start <= end) {
                            start = end;
                        }
                        setSelection(start, false);
                        break;
                    }
                    break;
                case 52:
                    if (start != end2) {
                        String str3 = this.mEditable.toString().substring(start, end2);
                        if (str3 != null) {
                            ClipData clip3 = clipboard.getPrimaryClip();
                            if (clip3 != null) {
                                int length2 = clip3.getItemCount();
                                for (int i2 = 0; i2 < length2; i2++) {
                                    if (clip3.getItemAt(0).getText().toString().compareTo(str3) == 0) {
                                        if (this.mClipboardMessage == null) {
                                            this.mClipboardMessage = Toast.makeText(getContext(), getMultiLanguage("string_already_exists"), 0);
                                        } else {
                                            this.mClipboardMessage.setText(getMultiLanguage("string_already_exists"));
                                            this.mClipboardMessage.setDuration(0);
                                        }
                                        this.mClipboardMessage.setGravity(80, 0, ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO);
                                        this.mClipboardMessage.show();
                                        removeText();
                                        break;
                                    }
                                }
                            }
                            clipboard.setPrimaryClip(ClipData.newPlainText("clipData", str3));
                            if (this.mClipboardMessage == null) {
                                this.mClipboardMessage = Toast.makeText(getContext(), getMultiLanguage("string_copied_to_clipboard"), 0);
                            } else {
                                this.mClipboardMessage.setText(getMultiLanguage("string_copied_to_clipboard"));
                                this.mClipboardMessage.setDuration(0);
                            }
                            this.mClipboardMessage.setGravity(80, 0, ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO);
                            this.mClipboardMessage.show();
                        }
                        removeText();
                        break;
                    }
                    break;
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return true;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        int imeOption;
        int inputType;
        int imeOption2 = this.mObjectText.getIMEActionType();
        int inputType2 = this.mObjectText.getTextInputType();
        switch (imeOption2) {
            case 0:
                imeOption = 0;
                break;
            case 1:
                imeOption = 1;
                break;
            case 2:
                imeOption = 2;
                break;
            case 3:
                imeOption = 3;
                break;
            case 4:
                imeOption = 6;
                break;
            case 5:
                imeOption = 4;
                break;
            case 6:
                imeOption = 5;
                break;
            default:
                imeOption = 1;
                break;
        }
        switch (inputType2) {
            case 0:
                inputType = 0;
                break;
            case 1:
                inputType = 1;
                break;
            case 2:
                inputType = 2;
                break;
            case 3:
                inputType = 3;
                break;
            case 4:
                inputType = 4;
                break;
            default:
                inputType = 1;
                break;
        }
        outAttrs.actionLabel = null;
        outAttrs.label = SCanvasView.TAG;
        outAttrs.imeOptions |= 268435456 | imeOption;
        outAttrs.privateImeOptions = "inputType=DisableEmoji";
        outAttrs.inputType = inputType | 16384;
        if (this.mInputConnection == null) {
            this.mInputConnection = new EditableInputConnection(this);
        }
        outAttrs.initialSelStart = Selection.getSelectionStart(this.mEditable);
        outAttrs.initialSelEnd = Selection.getSelectionEnd(this.mEditable);
        return this.mInputConnection;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        this.mHasWindowFocus = hasWindowFocus;
        if (hasWindowFocus) {
            this.mBlink.startBlink();
        } else {
            this.mBlink.stopBlink();
        }
        super.onWindowFocusChanged(hasWindowFocus);
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        event.getText().add(this.mEditable);
    }

    private void onMoveByKey(int keyCode, KeyEvent event) {
        int start = Selection.getSelectionStart(this.mEditable);
        int end = Selection.getSelectionEnd(this.mEditable);
        int pos = getCursorPos();
        Rect cursorRect = getCursorRect(start);
        if (cursorRect == null) {
            SpenSLog.m137e(false, "onMoveByKey().. cursorRect is null.");
            return;
        }
        int line = getLineForVertical(cursorRect.centerY());
        if (this.mTextRect == null || this.mStartIndex == null || this.mEndIndex == null) {
            SpenSLog.m137e(false, "onMoveByKey() Fail to measureText().");
            return;
        }
        switch (keyCode) {
            case 19:
            case 152:
                if (this.mShiftKeyPressed) {
                    if (line > 0) {
                        setSelection(getCursorIndex(line - 1, cursorRect.centerX()), end, false);
                        break;
                    }
                } else if (line > 0) {
                    setSelection(getCursorIndex(line - 1, cursorRect.centerX()), false);
                    break;
                }
                break;
            case 20:
            case 146:
                if (this.mShiftKeyPressed) {
                    if (line < this.mLineCount - 1) {
                        setSelection(getCursorIndex(line + 1, cursorRect.centerX()), end, false);
                        break;
                    }
                } else if (line < this.mLineCount - 1) {
                    setSelection(getCursorIndex(line + 1, cursorRect.centerX()), false);
                    break;
                }
                break;
            case 21:
            case 148:
                if (this.mAltKeyPressed) {
                    setSelection(getCursorIndex(line, this.mTextRect[this.mStartIndex[line]].left), false);
                    break;
                } else if (this.mShiftKeyPressed) {
                    if (start > 0) {
                        setSelection(start - 1, end, false);
                        break;
                    }
                } else if (pos > 0) {
                    if (start != end) {
                        setSelection(start, false);
                        break;
                    } else {
                        setSelection(pos - 1, false);
                        break;
                    }
                }
                break;
            case 22:
            case ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO /* 150 */:
                if (this.mAltKeyPressed) {
                    setSelection(getCursorIndex(line, this.mTextRect[this.mEndIndex[line]].right), false);
                    break;
                } else if (this.mShiftKeyPressed) {
                    if (this.mLineCount > 0 && start < this.mEndIndex[this.mLineCount - 1] + 1) {
                        setSelection(start + 1, end, false);
                        break;
                    }
                } else if (this.mLineCount > 0 && pos < this.mEndIndex[this.mLineCount - 1] + 1) {
                    if (start != end) {
                        setSelection(end, false);
                        break;
                    } else {
                        setSelection(pos + 1, false);
                        break;
                    }
                }
                break;
            case 92:
            case 153:
                setSelection(0, false);
                break;
            case 93:
            case 147:
                if (this.mLineCount > 0) {
                    setSelection(this.mEndIndex[this.mLineCount - 1] + 1, false);
                    break;
                }
                break;
            case 122:
            case ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_SCREENSIZE /* 151 */:
                setSelection(getCursorIndex(line, this.mTextRect[this.mStartIndex[line]].left), false);
                break;
            case 123:
            case 145:
                int cursorPos = getCursorIndex(line, this.mTextRect[this.mEndIndex[line]].right);
                if (this.mEndIndex != null && this.mEndIndex.length > 0) {
                    int i = 0;
                    while (true) {
                        if (i < this.mEndIndex.length) {
                            if (cursorPos == this.mEndIndex[i]) {
                                if (i == this.mEndIndex.length - 1) {
                                    cursorPos++;
                                } else {
                                    char oneChar = this.mObjectText.getText().charAt(cursorPos + 1);
                                    if (oneChar == '\n' || oneChar == '\r') {
                                    }
                                }
                            }
                            i++;
                        }
                    }
                    cursorPos++;
                }
                setSelection(cursorPos, false);
                break;
        }
        if (pos != getCursorPos()) {
            fit(true);
            measureText();
        }
    }

    private void initTextBox(ViewGroup viewGroup) throws PackageManager.NameNotFoundException {
        GestureListener gestureListener = null;
        byte b = 0;
        this.mTempCoordinateInfo = new SpenControlBase.CoordinateInfo();
        this.mTempMatrix = new Matrix();
        this.mTempRectF = new RectF();
        if (viewGroup != null) {
            viewGroup.addView(this, new RelativeLayout.LayoutParams(-2, -2));
        }
        this.mGestureDetector = new GestureDetector(getContext(), new GestureListener(this, gestureListener));
        this.mGestureDetector.setOnDoubleTapListener(new DoubleTapListener(this, b == true ? 1 : 0));
        this.mGestureDetector.setIsLongpressEnabled(true);
        setFocusableInTouchMode(false);
        setVisibility(8);
        setFocusable(false);
        initHandle();
    }

    @Deprecated
    private void initCue() throws PackageManager.NameNotFoundException {
        this.mCueBitmap = new Bitmap[2];
        for (int i = 0; i < 2; i++) {
            Bitmap temp = getDrawableImage(DEFAULT_CUE_FILE_NAME[i]);
            if (temp != null) {
                this.mCueBitmap[i] = Bitmap.createBitmap(temp);
                this.mCueBitmap[i] = this.mCueBitmap[i].copy(Bitmap.Config.ARGB_8888, false);
                temp.recycle();
                if (this.mCueBitmap[i].isRecycled()) {
                    SpenSLog.m135d(false, "Bitmap is already recycled.");
                }
            } else {
                return;
            }
        }
        this.mCueButton = new ImageButton[2];
        ViewGroup parentLayout = (ViewGroup) getParent();
        int bitmapIndex = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            this.mCueButton[i2] = new ImageButton(getContext());
            this.mCueButton[i2].setBackgroundColor(0);
            switch (i2) {
                case 0:
                    bitmapIndex = 0;
                    break;
                case 1:
                    bitmapIndex = 1;
                    break;
            }
            if (this.mCueBitmap[bitmapIndex] != null) {
                this.mCueButton[i2].setImageBitmap(this.mCueBitmap[bitmapIndex]);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                parentLayout.addView(this.mCueButton[i2], layoutParams);
            }
            this.mCueButton[i2].setVisibility(8);
        }
    }

    private void initHandle() throws PackageManager.NameNotFoundException {
        this.mHandleBitmap = new Bitmap[6];
        for (int i = 0; i < 6; i++) {
            Bitmap temp = getDrawableImage(DEFAULT_HANDLE_FILE_NAME[i]);
            if (temp != null) {
                this.mHandleBitmap[i] = Bitmap.createBitmap(temp);
                this.mHandleBitmap[i] = this.mHandleBitmap[i].copy(Bitmap.Config.ARGB_8888, false);
                temp.recycle();
                if (this.mHandleBitmap[i].isRecycled()) {
                    SpenSLog.m135d(false, "Bitmap is already recycled.");
                }
            } else {
                return;
            }
        }
        this.mHandleButton = new ImageButton[3];
        ViewGroup parentLayout = (ViewGroup) getParent();
        int bitmapIndex = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            this.mHandleButton[i2] = new ImageButton(getContext());
            this.mHandleButton[i2].setBackgroundColor(0);
            switch (i2) {
                case 0:
                    bitmapIndex = 0;
                    break;
                case 1:
                    bitmapIndex = 5;
                    break;
                case 2:
                    bitmapIndex = 3;
                    break;
            }
            if (this.mHandleBitmap[bitmapIndex] != null) {
                this.mHandleButton[i2].setImageBitmap(this.mHandleBitmap[bitmapIndex]);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                parentLayout.addView(this.mHandleButton[i2], layoutParams);
            }
            this.mHandleButton[i2].setOnTouchListener(this.mHandleListener[i2]);
            this.mHandleButton[i2].setVisibility(8);
        }
    }

    private void initEditable() {
        if (this.mObjectText != null) {
            String strBefore = this.mObjectText.getText();
            SpenSLog.m135d(false, "initEditable() strBefore = " + strBefore);
            this.mIsEditableClear = true;
            TextKeyListener.clear(this.mEditable);
            if (strBefore != null && strBefore.length() > 0 && strBefore.charAt(strBefore.length() - 1) != '\n') {
                this.mKeyListener = TextKeyListener.getInstance(false, TextKeyListener.Capitalize.NONE);
            } else {
                this.mKeyListener = TextKeyListener.getInstance(false, TextKeyListener.Capitalize.SENTENCES);
            }
            setChangeWatcher();
            String str = this.mObjectText.getText();
            String strAfter = null;
            if (str != null) {
                int pos = this.mObjectText.getCursorPos();
                if (pos > str.length()) {
                    pos = str.length();
                    this.mObjectText.setCursorPos(pos);
                }
                strBefore = str.substring(0, pos);
                strAfter = str.substring(pos, str.length());
            }
            String strContent = "";
            if (strBefore != null && strBefore.length() > 0) {
                strContent = strBefore;
            }
            if (strAfter != null && strAfter.length() > 0) {
                strContent = String.valueOf(strContent) + strAfter;
            }
            SpenSLog.m135d(false, "initEditable() strContent = " + strContent + ", strBefore = " + strBefore + ", strAfter = " + strAfter);
            if (strContent.length() > 0) {
                this.mEditable.replace(0, this.mEditable.length(), strContent);
                if (strBefore != null && this.mEditable.length() >= strBefore.length()) {
                    Selection.setSelection(this.mEditable, strBefore.length());
                }
            } else {
                this.mEditable.clear();
                Selection.setSelection(this.mEditable, 0);
            }
            this.mSurroundingTextLength = 0;
            this.mIsEditableClear = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMeasureInfo() {
        this.mLineCount = 0;
        this.mLinePosition = null;
        this.mStartIndex = null;
        this.mEndIndex = null;
        this.mTextRect = null;
        this.mTextSize = null;
        this.mTextDirection = null;
        this.mTextItalic = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpenControlBase.CoordinateInfo getCoordinateInfo() {
        this.mTempCoordinateInfo.reset();
        if (this.mTextBoxActionListener != null) {
            this.mTextBoxActionListener.onRequestCoordinateInfo(this.mTempCoordinateInfo);
        }
        return this.mTempCoordinateInfo;
    }

    protected void onSelectionChanged(int selStart, int selEnd) {
        SpenSLog.m135d(false, "onSelectionChange is called");
        if (this.mTextBoxActionListener != null && this.mTextBoxActionListener.onSelectionChanged(selStart, selEnd)) {
            this.mContextMenu.setDirty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTextLength() {
        String str;
        if (this.mObjectText == null || (str = this.mObjectText.getText()) == null) {
            return 0;
        }
        return str.length();
    }

    private void adjustTextBox() {
        int relativeHeight;
        if (this.mObjectText != null) {
            native_measure(this.mNativeTextView, (int) Math.ceil(this.mObjectText.getRect().width()));
            SpenControlBase.CoordinateInfo coordinateInfo = getCoordinateInfo();
            if (coordinateInfo == null) {
                SpenSLog.m137e(false, "coordinateInfo is null.");
                return;
            }
            RectF objectRect = this.mObjectText.getRect();
            RectF relativeRect = new RectF();
            relativeCoordinate(relativeRect, objectRect, coordinateInfo);
            int absoluteHeight = native_getHeight(this.mNativeTextView);
            if (absoluteHeight == 0) {
                relativeHeight = getDefaultHeight();
            } else {
                relativeHeight = (int) Math.ceil(absoluteHeight * coordinateInfo.zoomRatio);
            }
            if (this.mObjectText.getAutoFitOption() == 2 || this.mObjectText.getAutoFitOption() == 3) {
                if (relativeHeight < ((int) Math.ceil(relativeRect.height()))) {
                    if (relativeHeight > 0) {
                        float minHeight = this.mObjectText.getMinHeight();
                        if (minHeight <= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            resize(relativeRect.width(), relativeHeight);
                        } else {
                            float minHeight2 = minHeight * coordinateInfo.zoomRatio;
                            if (minHeight2 < relativeHeight) {
                                resize(relativeRect.width(), relativeHeight);
                            } else {
                                resize(relativeRect.width(), minHeight2);
                            }
                        }
                    }
                } else if (relativeHeight > ((int) Math.ceil(relativeRect.height()))) {
                    if (absoluteHeight + Math.abs(this.mObjectText.getRect().top) < this.MAX_OBJECT_HEIGHT - this.CONTROL_BOTTOM_MARGIN) {
                        SpenSLog.m135d(false, "adjustTextBox() Set smaller than the original size.");
                        float maxHeight = this.mObjectText.getMaxHeight();
                        if (maxHeight <= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            resize(relativeRect.width(), relativeHeight);
                        } else {
                            float maxHeight2 = maxHeight * coordinateInfo.zoomRatio;
                            if (maxHeight2 > relativeHeight) {
                                resize(relativeRect.width(), relativeHeight);
                            } else {
                                resize(relativeRect.width(), maxHeight2);
                            }
                        }
                    } else {
                        int relativeHeight2 = (int) (((this.MAX_OBJECT_HEIGHT - this.CONTROL_BOTTOM_MARGIN) - Math.abs(this.mObjectText.getRect().top)) * coordinateInfo.zoomRatio);
                        resize(relativeRect.width(), relativeHeight2);
                    }
                }
            } else {
                SpenSLog.m135d(false, "adjustTextBox() height == localLayoutParams.height or Gravity is GRAVITY_CLIP_VERTICAL.");
            }
            checkCursorPosition();
        }
    }

    private void adjustCursorSize(Rect rect, int start, int end) {
        SpenSLog.m135d(false, "adjustCursorSize() is called.");
        if (this.mObjectText != null) {
            float currentFontSize = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            float maxFontSize = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            int lineCount = native_getLineCount(this.mNativeTextView);
            int lineStart = 0;
            int lineEnd = 0;
            for (int i = 0; i < lineCount; i++) {
                lineStart = native_getLineStartIndex(this.mNativeTextView, i);
                lineEnd = native_getLineEndIndex(this.mNativeTextView, i);
                if (lineStart <= start && lineEnd + 1 >= start) {
                    break;
                }
            }
            ArrayList<SpenObjectTextBox.TextSpanInfo> spans = this.mObjectText.findSpans(lineStart, lineEnd);
            if (spans != null) {
                for (int i2 = 0; i2 < spans.size(); i2++) {
                    if (spans.get(i2) instanceof SpenObjectTextBox.FontSizeSpanInfo) {
                        float fontSize = ((SpenObjectTextBox.FontSizeSpanInfo) spans.get(i2)).fontSize;
                        if (maxFontSize <= fontSize) {
                            maxFontSize = fontSize;
                        }
                    }
                }
            }
            ArrayList<SpenObjectTextBox.TextSpanInfo> spans2 = this.mObjectText.findSpans(start, start);
            if (spans2 != null) {
                for (int i3 = 0; i3 < spans2.size(); i3++) {
                    if ((start == 0 || spans2.get(i3).startPos != start) && (spans2.get(i3) instanceof SpenObjectTextBox.FontSizeSpanInfo)) {
                        currentFontSize = ((SpenObjectTextBox.FontSizeSpanInfo) spans2.get(i3)).fontSize;
                    }
                }
            }
            if (maxFontSize != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                rect.bottom = (int) (rect.bottom - ((maxFontSize - currentFontSize) / 4.0f));
            }
            rect.top = rect.bottom - ((int) (1.3f * currentFontSize));
            SpenSLog.m135d(false, "adjustCursorSize maxFontSize = " + maxFontSize);
        }
    }

    private void resize(float relativeWidth, float relativeHeight) {
        RectF prevRelativeRect = new RectF();
        RectF relativeRect = new RectF();
        SpenControlBase.CoordinateInfo coordinateInfo = getCoordinateInfo();
        if (coordinateInfo == null) {
            SpenSLog.m137e(false, "coordinateInfo is null.");
            return;
        }
        if (this.mObjectText != null) {
            RectF objectRelativeRect = new RectF();
            RectF objectRect = this.mObjectText.getRect();
            if (objectRect != null) {
                relativeCoordinate(objectRelativeRect, objectRect, coordinateInfo);
                prevRelativeRect.set(objectRelativeRect);
                relativeRect.set(prevRelativeRect);
                relativeRect.bottom = relativeRect.top + relativeHeight;
                relativeRect.right = relativeRect.left + relativeWidth;
                objectRelativeRect.set(relativeRect);
                float rotation = this.mObjectText.getRotation();
                setRotation(rotation);
                RectF tempAbsoluteRect = new RectF();
                if (rotation == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    setPivotX(prevRelativeRect.centerX());
                    setPivotY(prevRelativeRect.centerY());
                    getMatrix().mapRect(prevRelativeRect);
                    setPivotX(relativeRect.centerX());
                    setPivotY(relativeRect.centerY());
                    getMatrix().mapRect(relativeRect);
                    objectRelativeRect.offset(relativeRect.left - prevRelativeRect.left, prevRelativeRect.top - relativeRect.top);
                } else if (relativeRect.width() == prevRelativeRect.width()) {
                    objectRelativeRect.offset(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, prevRelativeRect.centerY() - relativeRect.centerY());
                } else if (relativeRect.height() == prevRelativeRect.height()) {
                    objectRelativeRect.offset(prevRelativeRect.centerX() - relativeRect.centerX(), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                }
                absoluteCoordinate(tempAbsoluteRect, objectRelativeRect, coordinateInfo);
                this.mObjectText.setRect(tempAbsoluteRect, true);
                onObjectChanged();
            }
        }
    }

    @Deprecated
    private boolean checkForHorizontalScroll() {
        SpenSLog.m135d(false, "checkForHorizontalScroll() is called.");
        if (this.mNativeTextView == 0) {
            SpenSLog.m137e(false, "checkForHorizontalScroll() mNativeTextView is invalid.");
            return false;
        }
        if (this.mObjectText == null) {
            return false;
        }
        if (this.mHandlePressed || (this.mObjectText.getAutoFitOption() != 3 && this.mObjectText.getAutoFitOption() != 1)) {
            SpenSLog.m135d(false, "checkForHorizontalScroll() Don't need to check scroll.");
            return false;
        }
        RectF objectRect = this.mObjectText.getRect();
        SpenControlBase.CoordinateInfo coordinateInfo = getCoordinateInfo();
        if (coordinateInfo == null) {
            SpenSLog.m137e(false, "coordinateInfo is null.");
            return false;
        }
        RectF relativeRect = new RectF();
        relativeCoordinate(relativeRect, objectRect, coordinateInfo);
        float lineRelativeWidth = getMaximumWidth();
        if (this.mPrevRelativeWidth != lineRelativeWidth) {
            this.mPrevRelativeWidth = (int) lineRelativeWidth;
            resize(lineRelativeWidth, relativeRect.height());
            relativeRect.right = relativeRect.left + lineRelativeWidth;
        }
        SpenSLog.m135d(false, "checkForHorizontalScroll() end");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float checkForVerticalScroll(int index) {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (localLayoutParams == null) {
            SpenSLog.m137e(false, "localLayoutParams is null");
            return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        if (this.mObjectText == null) {
            return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        SpenControlBase.CoordinateInfo coordinateInfo = getCoordinateInfo();
        if (coordinateInfo == null) {
            SpenSLog.m137e(false, "coordinateInfo is null.");
            return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        RectF objectRect = this.mObjectText.getRect();
        if (objectRect == null) {
            SpenSLog.m137e(false, "objectRect is null");
            return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        Rect temp = getCursorRect(this.mObjectText.getCursorPos());
        if (temp == null) {
            SpenSLog.m137e(false, "cursorRect is null");
            return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        RectF cursorRect = new RectF(temp);
        float deltaY = native_getPan(this.mNativeTextView);
        float minHeight = native_getHeight(this.mNativeTextView);
        float margin = this.mObjectText.getTopMargin() + this.mObjectText.getBottomMargin();
        if (margin > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            margin = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        if (minHeight > objectRect.height()) {
            if (cursorRect.top < deltaY) {
                deltaY = cursorRect.top;
            } else if (cursorRect.bottom > objectRect.height() + deltaY) {
                deltaY = cursorRect.bottom - objectRect.height();
            }
            if (minHeight < objectRect.height() + margin + deltaY) {
                deltaY -= ((objectRect.height() + margin) + deltaY) - minHeight;
            }
        } else {
            deltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        if (deltaY < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            deltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        cursorRect.offset(objectRect.left, objectRect.top - deltaY);
        float[] pts = getRelativePoint(cursorRect.left, cursorRect.top);
        if (pts == null) {
            SpenSLog.m137e(false, "pts is null");
            return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        cursorRect.top = pts[1];
        float[] pts2 = getRelativePoint(cursorRect.left, cursorRect.bottom);
        if (pts2 == null) {
            SpenSLog.m137e(false, "pts is null");
            return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        cursorRect.bottom = pts2[1];
        RectF relativeCursorRect = new RectF();
        relativeCoordinate(relativeCursorRect, cursorRect, coordinateInfo);
        ViewGroup parentLayout = (ViewGroup) getParent();
        if (parentLayout == null || parentLayout.getHeight() == 0 || parentLayout.getWidth() == 0) {
            return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        float delta = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        if (relativeCursorRect.bottom > parentLayout.getHeight()) {
            float delta2 = relativeCursorRect.bottom - parentLayout.getHeight();
            delta = (delta2 / coordinateInfo.zoomRatio) + 9.0f;
        } else if (relativeCursorRect.top < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            float delta3 = relativeCursorRect.top;
            delta = delta3 / coordinateInfo.zoomRatio;
            if (cursorRect.top > 5.0f) {
                delta -= 9.0f;
            }
        }
        fit(true);
        SpenSLog.m135d(false, "checkForVerticalScroll index = " + index + ", delta = " + delta);
        return delta;
    }

    private void checkCursorPosition() {
        if (this.mObjectText == null) {
            SpenSLog.m137e(false, "mObjectText is null.");
            return;
        }
        if (isFocused() && !this.mIsViewMode) {
            SpenControlBase.CoordinateInfo coordinateInfo = getCoordinateInfo();
            if (coordinateInfo == null) {
                SpenSLog.m137e(false, "coordinateInfo is null.");
                return;
            }
            RectF objectRect = this.mObjectText.getRect();
            if (objectRect == null) {
                SpenSLog.m137e(false, "objectRect is null");
                return;
            }
            int pos = this.mObjectText.getCursorPos();
            Rect temp = getCursorRect(pos);
            if (temp == null) {
                SpenSLog.m137e(false, "cursorRect is null");
                return;
            }
            RectF cursorRect = new RectF(temp);
            float minHeight = native_getHeight(this.mNativeTextView);
            float deltaY = native_getPan(this.mNativeTextView);
            float margin = this.mObjectText.getTopMargin() + this.mObjectText.getBottomMargin();
            if (margin > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                margin = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            }
            if (minHeight > objectRect.height()) {
                if (cursorRect.top < deltaY) {
                    deltaY = cursorRect.top;
                } else if (cursorRect.bottom > objectRect.height() + deltaY) {
                    deltaY = cursorRect.bottom - objectRect.height();
                }
                if (minHeight < objectRect.height() + margin + deltaY) {
                    deltaY -= ((objectRect.height() + margin) + deltaY) - minHeight;
                }
            } else {
                deltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            }
            if (deltaY < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                deltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            }
            int currentLineIndex = getCurrnetLineIndex(pos);
            if (this.mPrevLineIndex != currentLineIndex) {
                native_setPan(this.mNativeTextView, deltaY);
                this.mObjectText.setVereticalPan(deltaY);
                if (Math.ceil(objectRect.height()) < minHeight) {
                    showScrollBar();
                }
            }
            cursorRect.offset(objectRect.left, objectRect.top - native_getPan(this.mNativeTextView));
            float[] pts = getRelativePoint(cursorRect.left, cursorRect.top);
            if (pts == null) {
                SpenSLog.m137e(false, "pts is null");
                return;
            }
            cursorRect.top = pts[1];
            float[] pts2 = getRelativePoint(cursorRect.left, cursorRect.bottom);
            if (pts2 == null) {
                SpenSLog.m137e(false, "pts is null");
                return;
            }
            cursorRect.bottom = pts2[1];
            RectF relativeCursorRect = new RectF();
            relativeCoordinate(relativeCursorRect, cursorRect, coordinateInfo);
            SpenSLog.m135d(false, "checkCursorPosition() cursorRect left = " + cursorRect.left + ", top = " + cursorRect.top + ", right = " + cursorRect.right + ", bottom = " + cursorRect.bottom + ", height = " + cursorRect.height());
            SpenSLog.m135d(false, "checkCursorPosition() relativeCursorRect left = " + relativeCursorRect.left + ", top = " + relativeCursorRect.top + ", right = " + relativeCursorRect.right + ", bottom = " + relativeCursorRect.bottom + ", height = " + relativeCursorRect.height());
            float xDiff = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            float yDiff = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            ViewGroup parentLayout = (ViewGroup) getParent();
            if (parentLayout != null && parentLayout.getHeight() != 0 && parentLayout.getWidth() != 0) {
                if (relativeCursorRect.bottom > parentLayout.getHeight()) {
                    float yDiff2 = relativeCursorRect.bottom - parentLayout.getHeight();
                    yDiff = (yDiff2 / coordinateInfo.zoomRatio) + 9.0f;
                } else if (relativeCursorRect.top < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    float yDiff3 = relativeCursorRect.top;
                    yDiff = yDiff3 / coordinateInfo.zoomRatio;
                    if (cursorRect.top > 5.0f) {
                        yDiff -= 9.0f;
                    }
                    if (relativeCursorRect.bottom - yDiff > parentLayout.getHeight()) {
                        yDiff = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                    }
                }
                if (relativeCursorRect.right > parentLayout.getWidth()) {
                    float xDiff2 = relativeCursorRect.right - parentLayout.getWidth();
                    xDiff = xDiff2 / coordinateInfo.zoomRatio;
                    if (cursorRect.right < objectRect.right - 5.0f) {
                        xDiff += 5.0f;
                    }
                } else if (relativeCursorRect.left < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    float xDiff3 = relativeCursorRect.left;
                    xDiff = xDiff3 / coordinateInfo.zoomRatio;
                    if (cursorRect.left > 35.0f) {
                        xDiff -= 35.0f;
                    }
                }
                if (xDiff != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || yDiff != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    onRequestScroll(xDiff, yDiff);
                }
                this.mPrevLineIndex = currentLineIndex;
            }
        }
    }

    @Deprecated
    private void checkObjectBounds() {
        if (this.mObjectText != null) {
            RectF objectRect = this.mObjectText.getRect();
            SpenControlBase.CoordinateInfo coordinateInfo = getCoordinateInfo();
            if (coordinateInfo == null) {
                SpenSLog.m137e(false, "coordinateInfo is null.");
                return;
            }
            RectF relativeRect = new RectF();
            relativeCoordinate(relativeRect, objectRect, coordinateInfo);
            if (objectRect.left < this.CONTROL_LEFT_MARGIN + 0) {
                objectRect.right = objectRect.width() + this.CONTROL_LEFT_MARGIN;
                objectRect.left = this.CONTROL_LEFT_MARGIN;
            }
            if (objectRect.top < this.CONTROL_TOP_MARGIN + 0) {
                objectRect.bottom = objectRect.height() + this.CONTROL_TOP_MARGIN;
                objectRect.top = this.CONTROL_TOP_MARGIN;
            }
            if (objectRect.right > this.MAX_OBJECT_WIDTH - this.CONTROL_RIGHT_MARGIN) {
                if (this.mObjectText.getAutoFitOption() == 0 || this.mObjectText.getAutoFitOption() == 2) {
                    objectRect.left = (this.MAX_OBJECT_WIDTH - this.CONTROL_RIGHT_MARGIN) - objectRect.width();
                }
                objectRect.right = this.MAX_OBJECT_WIDTH - this.CONTROL_RIGHT_MARGIN;
                int minWidth = getDefaultWidth();
                if (objectRect.width() < minWidth) {
                    objectRect.left = (this.MAX_OBJECT_WIDTH - this.CONTROL_RIGHT_MARGIN) - minWidth;
                }
            }
            if (objectRect.bottom > this.MAX_OBJECT_HEIGHT - this.CONTROL_BOTTOM_MARGIN) {
                if (this.mObjectText.getAutoFitOption() == 0 || this.mObjectText.getAutoFitOption() == 1) {
                    objectRect.top = (this.MAX_OBJECT_HEIGHT - this.CONTROL_BOTTOM_MARGIN) - objectRect.height();
                }
                objectRect.bottom = this.MAX_OBJECT_HEIGHT - this.CONTROL_BOTTOM_MARGIN;
                int minHeight = getDefaultHeight();
                if (objectRect.height() < minHeight) {
                    objectRect.top = (this.MAX_OBJECT_HEIGHT - this.CONTROL_BOTTOM_MARGIN) - minHeight;
                }
            }
            this.mObjectText.setRect(objectRect, true);
            if (!isFocused()) {
                onObjectChanged();
            }
        }
    }

    private void onDrawCursor(Canvas canvas) {
        int start;
        int end;
        SpenSLog.m135d(false, "onDrawCursor()");
        if (this.mCursorVisible && isFocused() && !this.mIsViewMode && this.mObjectText != null && this.mHighlightPathBogus && (start = Selection.getSelectionStart(this.mEditable)) == (end = Selection.getSelectionEnd(this.mEditable))) {
            Rect cursorRect = getCursorRect(start);
            if (cursorRect == null) {
                SpenSLog.m137e(false, "onDrawCursor() cursorRect is null.");
                return;
            }
            RectF objectRect = this.mObjectText.getRect();
            if (objectRect == null) {
                SpenSLog.m137e(false, "onDrawCursor() objectRect is null.");
                return;
            }
            float deltaY = native_getPan(this.mNativeTextView);
            if (cursorRect.bottom < deltaY || cursorRect.top > objectRect.height() + deltaY) {
                SpenSLog.m135d(false, "onDrawCursor() cursor is out of range.");
                return;
            }
            adjustCursorSize(cursorRect, start, end);
            int top = (int) (cursorRect.top - deltaY);
            int bottom = (int) (cursorRect.bottom - deltaY);
            if (top < 0) {
                top = 0;
            }
            cursorRect.top = top;
            cursorRect.bottom = (int) (((float) bottom) > objectRect.height() ? objectRect.height() : bottom);
            this.mTempRectF.set(cursorRect);
            this.mScaleMatrix.mapRect(this.mTempRectF);
            this.mTempRectF.round(cursorRect);
            if (!isItalicAttribute(start)) {
                canvas.drawRect(cursorRect, this.mHighLightPaint);
                return;
            }
            canvas.save();
            canvas.translate((float) (SIN_15_DEGREE * (cursorRect.height() / 2.0d)), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            canvas.rotate(ITALIC_ANGLE_IN_DEGREE, cursorRect.centerX(), cursorRect.centerY());
            canvas.drawRect(cursorRect, this.mHighLightPaint);
            canvas.restore();
        }
    }

    private void onDrawScrollBar(Canvas canvas) {
        Rect scrollbarRect;
        SpenSLog.m135d(false, "onDrawCursor()");
        if (this.mScrollBarVisible && (scrollbarRect = getScrollBarRect()) != null) {
            this.mTempRectF.set(scrollbarRect);
            this.mScaleMatrix.mapRect(this.mTempRectF);
            this.mTempRectF.round(scrollbarRect);
            canvas.drawRect(this.mTempRectF, this.mScrollBarPaint);
        }
    }

    private Rect getScrollBarRect() {
        if (this.mObjectText == null) {
            return null;
        }
        RectF objectRect = this.mObjectText.getRect();
        if (objectRect == null) {
            SpenSLog.m137e(false, "invalid objectRect");
            return null;
        }
        objectRect.offset(-objectRect.left, -objectRect.top);
        float deltaY = native_getPan(this.mNativeTextView);
        Rect rect = new Rect();
        rect.left = ((int) objectRect.right) - 13;
        rect.right = (((int) objectRect.right) - 5) + 4;
        rect.top = (int) (objectRect.height() * (deltaY / native_getHeight(this.mNativeTextView)));
        rect.bottom = (int) (rect.top + (objectRect.height() * (objectRect.height() / native_getHeight(this.mNativeTextView))));
        return rect;
    }

    private void setHandlePos(View handle, int x, int y, int width, int height, RectF relativeObjectRect) {
        ViewGroup parentLayout;
        SpenSLog.m135d(false, "setHandlePos() x = " + x + ", y = " + y + ", relativeObjectRect.top = " + relativeObjectRect.top + ", relativeObjectRect.bottom = " + relativeObjectRect.bottom);
        if (this.mObjectText != null && (parentLayout = (ViewGroup) getParent()) != null) {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) handle.getLayoutParams();
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.setRotate(this.mObjectText.getRotation(), relativeObjectRect.centerX(), relativeObjectRect.centerY());
            float[] points = {x, y};
            matrix.mapPoints(points);
            params.leftMargin = (int) points[0];
            params.rightMargin = parentLayout.getWidth() - (params.leftMargin + width);
            params.topMargin = (int) points[1];
            params.bottomMargin = parentLayout.getHeight() - (params.topMargin + height);
            params.width = width;
            params.height = height;
            handle.setPivotX(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            handle.setPivotY(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            handle.setRotation(this.mObjectText.getRotation());
            handle.setPadding(0, 0, 0, 0);
            handle.setLayoutParams(params);
            handle.setVisibility(0);
            handle.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDrawHandle() {
        float y;
        if (this.mHandleBitmap != null && isFocused() && !this.mIsViewMode && this.mObjectText != null) {
            int start = Selection.getSelectionStart(this.mEditable);
            int end = Selection.getSelectionEnd(this.mEditable);
            if (start == end && !this.mCursorHandleVisible) {
                if (this.mHandleButton[0].isShown()) {
                    this.mHandleButton[0].setVisibility(8);
                }
                if (this.mHandleButton[2].isShown()) {
                    this.mHandleButton[2].setVisibility(8);
                    return;
                }
                return;
            }
            RectF objectRect = this.mObjectText.getRect();
            RectF relativeRect = new RectF();
            SpenControlBase.CoordinateInfo coordinateInfo = getCoordinateInfo();
            if (coordinateInfo == null) {
                SpenSLog.m137e(false, "coordinateInfo is null.");
                return;
            }
            relativeCoordinate(relativeRect, objectRect, coordinateInfo);
            Rect cursorRect = getCursorRect(this.mObjectText.getCursorPos());
            if (cursorRect == null) {
                SpenSLog.m137e(false, "cursorRect is null.");
                return;
            }
            float deltaY = native_getPan(this.mNativeTextView);
            ImageButton handle = this.mHandleButton[1];
            if (start == end) {
                if (cursorRect.bottom < deltaY || cursorRect.top > objectRect.height() + deltaY) {
                    handle.setVisibility(8);
                    return;
                }
                cursorRect.offset(0, (int) (-deltaY));
                this.mTempRectF.set(cursorRect);
                this.mScaleMatrix.mapRect(this.mTempRectF);
                this.mTempRectF.round(cursorRect);
                float x = relativeRect.left + cursorRect.centerX();
                float y2 = relativeRect.top + cursorRect.bottom;
                int width = this.mHandleBitmap[5].getWidth();
                int height = this.mHandleBitmap[5].getHeight();
                if (this.mCursorHandleVisible) {
                    if (height + y2 > coordinateInfo.frameRect.bottom) {
                        y2 -= cursorRect.height() + this.mHandleButton[1].getHeight();
                        if (this.mHandleBitmap[4] != null) {
                            handle.setImageBitmap(this.mHandleBitmap[4]);
                        }
                    } else if (this.mHandleBitmap[5] != null) {
                        handle.setImageBitmap(this.mHandleBitmap[5]);
                    }
                    setHandlePos(handle, (int) Math.round(x - (width / 2.0d)), (int) y2, width, height, relativeRect);
                }
                this.mHandleButton[0].setVisibility(8);
                this.mHandleButton[2].setVisibility(8);
                return;
            }
            handle.setVisibility(8);
            Rect cursorRect2 = getCursorRect(start);
            if (cursorRect2 == null) {
                SpenSLog.m137e(false, "onDrawHandle().. cursorRect is null.");
                return;
            }
            ImageButton handle2 = this.mHandleButton[0];
            if (cursorRect2.bottom < deltaY || cursorRect2.top > objectRect.height() + deltaY) {
                handle2.setVisibility(8);
            } else {
                cursorRect2.offset(0, (int) (-deltaY));
                this.mTempRectF.set(cursorRect2);
                this.mScaleMatrix.mapRect(this.mTempRectF);
                this.mTempRectF.round(cursorRect2);
                float x2 = relativeRect.left + cursorRect2.left;
                float y3 = relativeRect.top + cursorRect2.top;
                int width2 = this.mHandleBitmap[0].getWidth();
                int height2 = this.mHandleBitmap[0].getHeight();
                if (x2 - width2 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && y3 - height2 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    y = y3 + cursorRect2.height();
                    if (this.mHandleBitmap[3] != null) {
                        handle2.setImageBitmap(this.mHandleBitmap[3]);
                    }
                } else if (y3 - height2 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    x2 -= width2;
                    y = y3 + cursorRect2.height();
                    if (this.mHandleBitmap[1] != null) {
                        handle2.setImageBitmap(this.mHandleBitmap[1]);
                    }
                } else if (x2 - width2 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    y = y3 - height2;
                    if (this.mHandleBitmap[2] != null) {
                        handle2.setImageBitmap(this.mHandleBitmap[2]);
                    }
                } else {
                    x2 -= width2;
                    y = y3 - height2;
                    if (this.mHandleBitmap[0] != null) {
                        handle2.setImageBitmap(this.mHandleBitmap[0]);
                    }
                }
                setHandlePos(handle2, (int) x2, (int) y, width2, height2, relativeRect);
            }
            Rect cursorRect3 = getCursorRect(end);
            if (cursorRect3 == null) {
                SpenSLog.m137e(false, "onDrawHandle().. cursorRect is null.");
                return;
            }
            ImageButton handle3 = this.mHandleButton[2];
            if (cursorRect3.bottom < deltaY || cursorRect3.top > objectRect.height() + deltaY) {
                handle3.setVisibility(8);
                return;
            }
            cursorRect3.offset(0, (int) (-native_getPan(this.mNativeTextView)));
            this.mTempRectF.set(cursorRect3);
            this.mScaleMatrix.mapRect(this.mTempRectF);
            this.mTempRectF.round(cursorRect3);
            float x3 = relativeRect.left + cursorRect3.right;
            float y4 = relativeRect.top + cursorRect3.bottom;
            int width3 = this.mHandleBitmap[3].getWidth();
            int height3 = this.mHandleBitmap[3].getHeight();
            ViewGroup parentLayout = (ViewGroup) getParent();
            if (parentLayout != null && parentLayout.getHeight() != 0 && parentLayout.getWidth() != 0) {
                if (width3 + x3 > parentLayout.getWidth() && height3 + y4 > parentLayout.getHeight()) {
                    x3 -= width3;
                    y4 -= cursorRect3.height() + height3;
                    if (this.mHandleBitmap[0] != null) {
                        handle3.setImageBitmap(this.mHandleBitmap[0]);
                    }
                } else if (height3 + y4 > parentLayout.getHeight()) {
                    y4 -= cursorRect3.height() + height3;
                    if (this.mHandleBitmap[2] != null) {
                        handle3.setImageBitmap(this.mHandleBitmap[2]);
                    }
                } else if (width3 + x3 > parentLayout.getWidth()) {
                    x3 -= width3;
                    if (this.mHandleBitmap[1] != null) {
                        handle3.setImageBitmap(this.mHandleBitmap[1]);
                    }
                } else if (this.mHandleBitmap[3] != null) {
                    handle3.setImageBitmap(this.mHandleBitmap[3]);
                }
                setHandlePos(handle3, (int) x3, (int) y4, width3, height3, relativeRect);
            }
        }
    }

    private void applyScaledRect(Rect rect) {
        this.mTempRectF.set(rect);
        this.mScaleMatrix.mapRect(this.mTempRectF);
        this.mTempRectF.round(rect);
    }

    private void drawSelectedLine(Canvas canvas, int startIndex, int endIndex, RectF result, Rect drawRect) {
        if (this.mTextRect != null) {
            result.set(this.mTextRect[startIndex]);
            for (int cnt = startIndex + 1; cnt <= endIndex; cnt++) {
                result.left = result.left < this.mTextRect[cnt].left ? result.left : this.mTextRect[cnt].left;
                result.top = result.top < this.mTextRect[cnt].top ? result.top : this.mTextRect[cnt].top;
                result.right = result.right > this.mTextRect[cnt].right ? result.right : this.mTextRect[cnt].right;
                result.bottom = result.bottom > this.mTextRect[cnt].bottom ? result.bottom : this.mTextRect[cnt].bottom;
            }
            float deltaY = native_getPan(this.mNativeTextView);
            RectF objectRect = this.mObjectText.getRect();
            if (objectRect == null) {
                SpenSLog.m137e(false, "drawSelectedLine() objectRect is invalid.");
                return;
            }
            int top = (int) (result.top - deltaY);
            int bottom = (int) (result.bottom - deltaY);
            int i = (int) result.left;
            if (top < 0) {
                top = 0;
            }
            drawRect.set(i, top, (int) result.right, (int) (((float) bottom) > objectRect.height() ? objectRect.height() : bottom));
            applyScaledRect(drawRect);
            canvas.drawRect(drawRect, this.mSelectPaint);
        }
    }

    private void drawSelectRect(Canvas canvas, int startIndex, int endIndex, RectF result, Rect drawRect) {
        if (this.mTextRect != null && this.mObjectText != null) {
            float deltaY = native_getPan(this.mNativeTextView);
            RectF objectRect = this.mObjectText.getRect();
            if (objectRect == null) {
                SpenSLog.m137e(false, "drawSelectRect() objectRect is invalid.");
                return;
            }
            for (int cnt = startIndex; cnt < endIndex; cnt++) {
                int top = (int) (this.mTextRect[cnt].top - deltaY);
                int bottom = (int) (this.mTextRect[cnt].bottom - deltaY);
                int i = (int) this.mTextRect[cnt].left;
                if (top < 0) {
                    top = 0;
                }
                drawRect.set(i, top, (int) this.mTextRect[cnt].right, (int) (((float) bottom) > objectRect.height() ? objectRect.height() : bottom));
                applyScaledRect(drawRect);
                canvas.drawRect(drawRect, this.mSelectPaint);
            }
        }
    }

    private void onDrawSelect(Canvas canvas) {
        int startIndex;
        int endIndex;
        if (isFocused() && !this.mIsViewMode && (endIndex = Selection.getSelectionEnd(this.mEditable)) != (startIndex = Selection.getSelectionStart(this.mEditable))) {
            if (this.mIsTyping) {
                measureText();
            }
            if (this.mStartIndex != null && this.mEndIndex != null) {
                if (startIndex > endIndex) {
                    startIndex = endIndex;
                    endIndex = startIndex;
                }
                int endLine = -1;
                int startLine = -1;
                int cnt = 0;
                while (true) {
                    if (cnt >= this.mLineCount) {
                        break;
                    }
                    if (this.mStartIndex[cnt] <= startIndex && this.mEndIndex[cnt] >= startIndex) {
                        startLine = cnt;
                    }
                    if (this.mStartIndex[cnt] > endIndex - 1 || this.mEndIndex[cnt] < endIndex - 1) {
                        cnt++;
                    } else {
                        endLine = cnt;
                        break;
                    }
                }
                SpenSLog.m135d(false, "stringLength = " + getTextLength() + " startIndex = " + startIndex + " endIndex = " + endIndex);
                SpenSLog.m135d(false, "lineCount = " + this.mLineCount + " startLine = " + startLine + " endLine = " + endLine);
                if (startLine != -1 && endLine != -1) {
                    RectF selectRect = new RectF();
                    Rect drawRect = new Rect();
                    if (startLine == endLine) {
                        drawSelectRect(canvas, startIndex, endIndex, selectRect, drawRect);
                        return;
                    }
                    drawSelectRect(canvas, startIndex, this.mEndIndex[startLine] + 1, selectRect, drawRect);
                    for (int cnt2 = startLine + 1; cnt2 < endLine; cnt2++) {
                        drawSelectedLine(canvas, this.mStartIndex[cnt2], this.mEndIndex[cnt2], selectRect, drawRect);
                    }
                    drawSelectRect(canvas, this.mStartIndex[endLine], endIndex, selectRect, drawRect);
                }
            }
        }
    }

    private float getDeltaY(int gravity) {
        int relativeHeight;
        RectF objectRect = this.mObjectText.getRect();
        if (objectRect == null) {
            SpenSLog.m137e(false, "measureText() objectRect is invalid.");
            return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        SpenControlBase.CoordinateInfo coordinateInfo = getCoordinateInfo();
        if (coordinateInfo == null) {
            SpenSLog.m137e(false, "coordinateInfo is null.");
            return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        RectF relativeRect = new RectF();
        relativeCoordinate(relativeRect, objectRect, coordinateInfo);
        int absoluteHeight = native_getHeight(this.mNativeTextView);
        if (absoluteHeight == 0) {
            relativeHeight = getDefaultHeight();
        } else {
            relativeHeight = (int) (absoluteHeight * coordinateInfo.zoomRatio);
        }
        float diffY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        if (gravity == 1 || gravity == 2) {
            diffY = relativeRect.height() - relativeHeight;
            if (gravity == 1) {
                diffY /= 2.0f;
            }
        }
        if (relativeRect.height() < relativeHeight) {
            return VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        return diffY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCursorRect(int pos) {
        RectF textRect;
        SpenSLog.m135d(false, "getCursorRect() is called.");
        if (this.mNativeTextView == 0) {
            SpenSLog.m137e(false, "getCursorRect() mNativeTextView is invalid.");
            return null;
        }
        if (this.mObjectText == null) {
            return null;
        }
        Rect rect = new Rect();
        if (pos > 0) {
            if (this.mIsTyping) {
                SpenSLog.m135d(false, "getCursorRect() calculate by native_getTextRect.");
                RectF textRect2 = new RectF();
                if (isFrontPosition(pos)) {
                    native_getTextRect(this.mNativeTextView, pos, textRect2);
                    textRect2.offset(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, getDeltaY(this.mObjectText.getGravity()));
                    if (isLTRAttribute(pos)) {
                        rect.set(((int) textRect2.left) - 2, (int) textRect2.top, ((int) textRect2.left) + 2, (int) textRect2.bottom);
                        return rect;
                    }
                    rect.set(((int) textRect2.right) - 2, (int) textRect2.top, ((int) textRect2.right) + 2, (int) textRect2.bottom);
                    return rect;
                }
                native_getTextRect(this.mNativeTextView, pos - 1, textRect2);
                textRect2.offset(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, getDeltaY(this.mObjectText.getGravity()));
                if (isLTRAttribute(pos - 1)) {
                    rect.set(((int) textRect2.right) - 2, (int) textRect2.top, ((int) textRect2.right) + 2, (int) textRect2.bottom);
                    return rect;
                }
                rect.set(((int) textRect2.left) - 2, (int) textRect2.top, ((int) textRect2.left) + 2, (int) textRect2.bottom);
                return rect;
            }
            SpenSLog.m135d(false, "getCursorRect() calculate by mTextRect.");
            if (this.mTextRect == null || this.mStartIndex == null || this.mTextDirection == null) {
                return null;
            }
            if (isFrontPosition(pos)) {
                RectF textRect3 = this.mTextRect[pos];
                if (this.mTextDirection[pos] == 0) {
                    rect.set(((int) textRect3.left) - 2, (int) textRect3.top, ((int) textRect3.left) + 2, (int) textRect3.bottom);
                    return rect;
                }
                rect.set(((int) textRect3.right) - 2, (int) textRect3.top, ((int) textRect3.right) + 2, (int) textRect3.bottom);
                return rect;
            }
            RectF textRect4 = this.mTextRect[pos - 1];
            if (this.mTextDirection[pos - 1] == 0) {
                rect.set(((int) textRect4.right) - 2, (int) textRect4.top, ((int) textRect4.right) + 2, (int) textRect4.bottom);
                return rect;
            }
            rect.set(((int) textRect4.left) - 2, (int) textRect4.top, ((int) textRect4.left) + 2, (int) textRect4.bottom);
            return rect;
        }
        String str = this.mEditable.toString();
        if (str.length() > 0 && native_getLineStartIndex(this.mNativeTextView, 0) != -1) {
            if (this.mTextRect == null) {
                textRect = new RectF();
                native_getTextRect(this.mNativeTextView, 0, textRect);
            } else {
                textRect = this.mTextRect[0];
            }
            rect.set(((int) textRect.left) - 2, (int) textRect.top, ((int) textRect.left) + 2, (int) textRect.bottom);
            return rect;
        }
        ArrayList<SpenObjectTextBox.TextSpanInfo> spans = this.mObjectText.findSpans(0, 0);
        if (spans != null) {
            int cnt = spans.size() - 1;
            while (true) {
                if (cnt < 0) {
                    break;
                }
                if (spans.get(cnt) instanceof SpenObjectTextBox.FontSizeSpanInfo) {
                    rect.top = (int) this.mObjectText.getTopMargin();
                    rect.bottom = ((int) ((SpenObjectTextBox.FontSizeSpanInfo) spans.get(cnt)).fontSize) + rect.top;
                    rect.left = (int) this.mObjectText.getLeftMargin();
                    rect.right = rect.left + 4;
                    break;
                }
                cnt--;
            }
        }
        ArrayList<SpenObjectTextBox.TextParagraphInfo> pInfo = this.mObjectText.getParagraph();
        if (pInfo != null) {
            int cnt2 = pInfo.size();
            for (int i = 0; i < cnt2; i++) {
                if (pInfo.get(i) instanceof SpenObjectTextBox.LineSpacingParagraphInfo) {
                    if (((SpenObjectTextBox.LineSpacingParagraphInfo) pInfo.get(i)).type == 0) {
                        rect.bottom = ((int) ((SpenObjectTextBox.LineSpacingParagraphInfo) pInfo.get(i)).lineSpacing) + rect.top;
                    } else {
                        rect.bottom = ((int) (((SpenObjectTextBox.LineSpacingParagraphInfo) pInfo.get(i)).lineSpacing * rect.height())) + rect.top;
                    }
                }
                if (pInfo.get(i) instanceof SpenObjectTextBox.AlignParagraphInfo) {
                    RectF objectRect = this.mObjectText.getRect();
                    if (objectRect == null) {
                        SpenSLog.m137e(false, "getCursorRect() objectRect is invalid.");
                        return null;
                    }
                    if (((SpenObjectTextBox.AlignParagraphInfo) pInfo.get(i)).align == 2) {
                        rect.left = (int) (rect.left + (objectRect.width() / 2.0f));
                        rect.right = (int) (rect.right + (objectRect.width() / 2.0f));
                    } else if (((SpenObjectTextBox.AlignParagraphInfo) pInfo.get(i)).align == 1) {
                        rect.left = (int) (((objectRect.width() - this.mObjectText.getRightMargin()) - 4.0f) - rect.width());
                        rect.right = (int) ((objectRect.width() - this.mObjectText.getRightMargin()) - 4.0f);
                    }
                }
            }
            return rect;
        }
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean findWord(int index, Word word) {
        if (this.mObjectText == null) {
            return false;
        }
        if (this.mIsTyping) {
            measureText();
        }
        if (index >= getTextLength() || index < 0) {
            return false;
        }
        word.endIndex = 0;
        word.startIndex = 0;
        int line = getLineFromIndex(index);
        if (line < 0 || this.mStartIndex == null || this.mEndIndex == null) {
            return false;
        }
        word.startIndex = this.mStartIndex[line];
        word.endIndex = this.mEndIndex[line] + 1;
        String str = this.mObjectText.getText();
        for (int cnt = index - 1; cnt >= word.startIndex; cnt--) {
            char oneChar = str.charAt(cnt);
            if (oneChar == ' ' || oneChar == '\t' || oneChar == '\n' || oneChar == '\r') {
                word.startIndex = cnt + 1;
                break;
            }
        }
        char oneChar2 = str.charAt(index);
        if (oneChar2 == ' ' || oneChar2 == '\t' || oneChar2 == '\n' || oneChar2 == '\r') {
            word.endIndex = index;
            return true;
        }
        for (int cnt2 = index + 1; cnt2 < word.endIndex; cnt2++) {
            char oneChar3 = str.charAt(cnt2);
            if (oneChar3 == ' ' || oneChar3 == '\t') {
                word.endIndex = cnt2;
                break;
            }
        }
        return true;
    }

    private int getLineFromIndex(int index) {
        if (this.mIsTyping) {
            measureText();
        }
        if (this.mEndIndex != null && index >= 0) {
            for (int line = 0; line < this.mLineCount; line++) {
                if (index <= this.mEndIndex[line]) {
                    return line;
                }
            }
            return 0;
        }
        return 0;
    }

    private int getCurrnetLineIndex(int pos) {
        int lineCount = native_getLineCount(this.mNativeTextView);
        for (int i = lineCount - 1; i >= 0; i--) {
            if (pos >= native_getLineStartIndex(this.mNativeTextView, i)) {
                return i;
            }
        }
        return 0;
    }

    private void setChangeWatcher() {
        if (this.mEditable != null) {
            int textLength = this.mEditable.length();
            Spannable sp = this.mEditable;
            ChangeWatcher[] watchers = (ChangeWatcher[]) sp.getSpans(0, sp.length(), ChangeWatcher.class);
            for (ChangeWatcher changeWatcher : watchers) {
                sp.removeSpan(changeWatcher);
            }
            if (this.mChangeWatcher == null) {
                this.mChangeWatcher = new ChangeWatcher(this, null);
            }
            SpenSLog.m135d(false, "setChangeWatcher() textLength = " + textLength);
            sp.setSpan(this.mChangeWatcher, 0, textLength, 6553618);
            if (this.mKeyListener != null) {
                sp.setSpan(this.mKeyListener, 0, textLength, 18);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSettingInfo() {
        if (this.mObjectText != null && this.mTextBoxActionListener != null) {
            int pos = this.mObjectText.getCursorPos();
            SpenSettingTextInfo textInfo = getSettingInfo(pos, pos);
            this.mTextBoxActionListener.onSettingTextInfoChanged(textInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelection() {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService("input_method");
        if (imm != null && imm.isActive(this)) {
            int selStart = Selection.getSelectionStart(this.mEditable);
            int selEnd = Selection.getSelectionEnd(this.mEditable);
            int candStart = -1;
            int candEnd = -1;
            if (this.mEditable.length() > 0) {
                candStart = EditableInputConnection.getComposingSpanStart(this.mEditable);
                candEnd = EditableInputConnection.getComposingSpanEnd(this.mEditable);
            }
            imm.updateSelection(this, selStart, selEnd, candStart, candEnd);
            SpenSLog.m135d(false, "updateSelection selStart = " + selStart + ", selEnd = " + selEnd + ", candStart = " + candStart + ", candEnd = " + candEnd);
        }
    }

    private void setTextFontSize(float size, int start, int end) {
        if (this.mObjectText != null) {
            SpenObjectTextBox.TextSpanInfo span = new SpenObjectTextBox.FontSizeSpanInfo();
            if (!isFocused()) {
                String str = this.mObjectText.getText();
                span.startPos = 0;
                span.endPos = str != null ? str.length() : 0;
                span.intervalType = 3;
            } else {
                span.startPos = start;
                span.endPos = end;
                span.intervalType = 3;
            }
            ((SpenObjectTextBox.FontSizeSpanInfo) span).fontSize = size;
            this.mObjectText.appendSpan(span);
        }
    }

    private void setTextFontColor(int color, int start, int end) {
        if (this.mObjectText != null) {
            ArrayList<SpenObjectTextBox.TextSpanInfo> spans = this.mObjectText.getSpan();
            if (spans != null) {
                Iterator<SpenObjectTextBox.TextSpanInfo> it = spans.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SpenObjectTextBox.TextSpanInfo inf = it.next();
                    if ((inf instanceof SpenObjectTextBox.ForegroundColorSpanInfo) && inf.startPos == start && inf.endPos == end && ((SpenObjectTextBox.ForegroundColorSpanInfo) inf).foregroundColor != color) {
                        this.mObjectText.removeSpan(inf);
                        break;
                    }
                }
            }
            SpenObjectTextBox.TextSpanInfo span = new SpenObjectTextBox.ForegroundColorSpanInfo();
            if (!isFocused()) {
                String str = this.mObjectText.getText();
                span.startPos = 0;
                span.endPos = str == null ? 0 : str.length();
                span.intervalType = 3;
            } else {
                span.startPos = start;
                span.endPos = end;
                span.intervalType = 3;
            }
            ((SpenObjectTextBox.ForegroundColorSpanInfo) span).foregroundColor = color;
            this.mObjectText.appendSpan(span);
        }
    }

    private void setTextFontName(String font, int start, int end) {
        if (this.mObjectText != null) {
            SpenObjectTextBox.TextSpanInfo span = new SpenObjectTextBox.FontNameSpanInfo();
            if (!isFocused()) {
                String str = this.mObjectText.getText();
                span.startPos = 0;
                span.endPos = str != null ? str.length() : 0;
                span.intervalType = 3;
            } else {
                span.startPos = start;
                span.endPos = end;
                span.intervalType = 3;
            }
            ((SpenObjectTextBox.FontNameSpanInfo) span).fontName = font;
            this.mObjectText.appendSpan(span);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextDirection(int direction, int start, int end) {
        if (this.mObjectText != null) {
            SpenObjectTextBox.TextSpanInfo span = new SpenObjectTextBox.TextDirectionSpanInfo();
            if (!isFocused()) {
                String str = this.mObjectText.getText();
                span.startPos = 0;
                span.endPos = str != null ? str.length() : 0;
                span.intervalType = 3;
            } else {
                span.startPos = start;
                span.endPos = end;
                span.intervalType = 3;
            }
            ((SpenObjectTextBox.TextDirectionSpanInfo) span).textDirection = direction;
            this.mObjectText.appendSpan(span);
        }
    }

    private void setTextBackgroundColor(int color, int start, int end) {
        if (this.mObjectText != null) {
            SpenObjectTextBox.TextSpanInfo span = new SpenObjectTextBox.BackgroundColorSpanInfo();
            if (!isFocused()) {
                String str = this.mObjectText.getText();
                span.startPos = 0;
                span.endPos = str != null ? str.length() : 0;
                span.intervalType = 3;
            } else {
                span.startPos = start;
                span.endPos = end;
                span.intervalType = 3;
            }
            ((SpenObjectTextBox.BackgroundColorSpanInfo) span).backgroundColor = color;
            this.mObjectText.appendSpan(span);
        }
    }

    private void setTextBold(boolean bold, int start, int end) {
        if (this.mObjectText != null) {
            SpenObjectTextBox.TextSpanInfo span = new SpenObjectTextBox.BoldStyleSpanInfo();
            if (!isFocused()) {
                String str = this.mObjectText.getText();
                span.startPos = 0;
                span.endPos = str != null ? str.length() : 0;
                span.intervalType = 3;
            } else {
                span.startPos = start;
                span.endPos = end;
                span.intervalType = 3;
            }
            ((SpenObjectTextBox.BoldStyleSpanInfo) span).isBold = bold;
            this.mObjectText.appendSpan(span);
        }
    }

    private void setTextItalic(boolean italic, int start, int end) {
        if (this.mObjectText != null) {
            SpenObjectTextBox.TextSpanInfo span = new SpenObjectTextBox.ItalicStyleSpanInfo();
            if (!isFocused()) {
                String str = this.mObjectText.getText();
                span.startPos = 0;
                span.endPos = str != null ? str.length() : 0;
                span.intervalType = 3;
            } else {
                span.startPos = start;
                span.endPos = end;
                span.intervalType = 3;
            }
            ((SpenObjectTextBox.ItalicStyleSpanInfo) span).isItalic = italic;
            this.mObjectText.appendSpan(span);
        }
    }

    private void setTextUnderline(boolean underline, int start, int end) {
        if (this.mObjectText != null) {
            SpenObjectTextBox.TextSpanInfo span = new SpenObjectTextBox.UnderlineStyleSpanInfo();
            if (!isFocused()) {
                String str = this.mObjectText.getText();
                span.startPos = 0;
                span.endPos = str != null ? str.length() : 0;
                span.intervalType = 3;
            } else {
                span.startPos = start;
                span.endPos = end;
                span.intervalType = 3;
            }
            ((SpenObjectTextBox.UnderlineStyleSpanInfo) span).isUnderline = underline;
            this.mObjectText.appendSpan(span);
        }
    }

    private void setParagraphAlign(int align) {
        ArrayList<SpenObjectTextBox.TextParagraphInfo> spans;
        if (this.mObjectText != null && (spans = this.mObjectText.getParagraph()) != null) {
            SpenObjectTextBox.AlignParagraphInfo span = new SpenObjectTextBox.AlignParagraphInfo();
            span.startPos = 0;
            span.endPos = 0;
            String str = this.mObjectText.getText();
            if (str != null) {
                span.endPos = str.length();
            }
            span.align = align;
            spans.add(span);
            this.mObjectText.setParagraph(spans);
        }
    }

    private void setParagraphIndent(int indent) {
    }

    private void setParagraphSpacing(int type, float spacing) {
        ArrayList<SpenObjectTextBox.TextParagraphInfo> spans;
        if (this.mObjectText != null && (spans = this.mObjectText.getParagraph()) != null) {
            SpenObjectTextBox.LineSpacingParagraphInfo span = new SpenObjectTextBox.LineSpacingParagraphInfo();
            span.startPos = 0;
            span.endPos = 0;
            String str = this.mObjectText.getText();
            if (str != null) {
                span.endPos = str.length();
            }
            span.type = type;
            span.lineSpacing = spacing;
            spans.add(span);
            this.mObjectText.setParagraph(spans);
        }
    }

    private Matrix getInvMatrix() {
        getMatrix().invert(this.mTempMatrix);
        return this.mTempMatrix;
    }

    private SpenSettingTextInfo getSettingInfo(int start, int end) {
        if (this.mObjectText == null) {
            return null;
        }
        SpenSettingTextInfo textInfo = new SpenSettingTextInfo();
        textInfo.size *= (float) (this.MAX_OBJECT_WIDTH / 200.0d);
        int sLength = 0;
        int cLength = 0;
        int bgLength = 0;
        int fLength = 0;
        boolean sMatch = false;
        boolean cMatch = false;
        boolean bgMatch = false;
        boolean fMatch = false;
        ArrayList<SpenObjectTextBox.TextSpanInfo> sInfo = this.mObjectText.findSpans(start, end);
        if (sInfo != null) {
            for (int i = sInfo.size() - 1; i >= 0; i--) {
                SpenObjectTextBox.TextSpanInfo info = sInfo.get(i);
                if ((info instanceof SpenObjectTextBox.FontSizeSpanInfo) && !sMatch) {
                    if (start == end) {
                        if (info.startPos == info.endPos) {
                            textInfo.size = ((SpenObjectTextBox.FontSizeSpanInfo) info).fontSize;
                            sMatch = true;
                        } else if (info.startPos != end) {
                            textInfo.size = ((SpenObjectTextBox.FontSizeSpanInfo) info).fontSize;
                            sLength++;
                        }
                    } else if (info.startPos <= start && info.endPos >= end) {
                        textInfo.size = ((SpenObjectTextBox.FontSizeSpanInfo) info).fontSize;
                        sMatch = true;
                    } else if (sLength == 0) {
                        textInfo.size = ((SpenObjectTextBox.FontSizeSpanInfo) info).fontSize;
                        sLength++;
                    } else if (textInfo.size != ((SpenObjectTextBox.FontSizeSpanInfo) info).fontSize) {
                        textInfo.size = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                    }
                } else if ((info instanceof SpenObjectTextBox.ForegroundColorSpanInfo) && !cMatch) {
                    if (start == end) {
                        if (info.startPos == info.endPos) {
                            textInfo.color = ((SpenObjectTextBox.ForegroundColorSpanInfo) info).foregroundColor;
                            cMatch = true;
                        } else if (info.startPos != end) {
                            textInfo.color = ((SpenObjectTextBox.ForegroundColorSpanInfo) info).foregroundColor;
                            cLength++;
                        }
                    } else if (info.startPos <= start && info.endPos >= end) {
                        textInfo.color = ((SpenObjectTextBox.ForegroundColorSpanInfo) info).foregroundColor;
                        cMatch = true;
                    } else if (cLength == 0) {
                        textInfo.color = ((SpenObjectTextBox.ForegroundColorSpanInfo) info).foregroundColor;
                        cLength++;
                    } else if (textInfo.color != ((SpenObjectTextBox.ForegroundColorSpanInfo) info).foregroundColor) {
                        textInfo.color = 0;
                    }
                } else if ((info instanceof SpenObjectTextBox.BackgroundColorSpanInfo) && !bgMatch) {
                    if (start == end) {
                        if (info.startPos == info.endPos) {
                            textInfo.bgColor = ((SpenObjectTextBox.BackgroundColorSpanInfo) info).backgroundColor;
                            bgMatch = true;
                        } else if (info.startPos != end) {
                            textInfo.bgColor = ((SpenObjectTextBox.BackgroundColorSpanInfo) info).backgroundColor;
                            bgLength++;
                        }
                    } else if (info.startPos <= start && info.endPos >= end) {
                        textInfo.bgColor = ((SpenObjectTextBox.BackgroundColorSpanInfo) info).backgroundColor;
                        bgMatch = true;
                    } else if (bgLength == 0) {
                        textInfo.bgColor = ((SpenObjectTextBox.BackgroundColorSpanInfo) info).backgroundColor;
                        bgLength++;
                    } else if (textInfo.bgColor != ((SpenObjectTextBox.BackgroundColorSpanInfo) info).backgroundColor) {
                        textInfo.bgColor = 0;
                    }
                } else if ((info instanceof SpenObjectTextBox.FontNameSpanInfo) && !fMatch) {
                    if (start == end) {
                        if (info.startPos == info.endPos) {
                            textInfo.font = ((SpenObjectTextBox.FontNameSpanInfo) info).fontName;
                            fMatch = true;
                        } else if (info.startPos != end) {
                            textInfo.font = ((SpenObjectTextBox.FontNameSpanInfo) info).fontName;
                            fLength++;
                        }
                    } else if (info.startPos <= start && info.endPos >= end) {
                        textInfo.font = ((SpenObjectTextBox.FontNameSpanInfo) info).fontName;
                        fMatch = true;
                    } else if (fLength == 0) {
                        textInfo.font = ((SpenObjectTextBox.FontNameSpanInfo) info).fontName;
                        fLength++;
                    } else if (textInfo.font.compareTo(((SpenObjectTextBox.FontNameSpanInfo) info).fontName) != 0) {
                        textInfo.font = "";
                    }
                } else if ((info instanceof SpenObjectTextBox.BoldStyleSpanInfo) && (info.startPos != end || end == 0)) {
                    if (((SpenObjectTextBox.BoldStyleSpanInfo) info).isBold && start >= info.startPos && end <= info.endPos) {
                        textInfo.style |= 1;
                    }
                } else if ((info instanceof SpenObjectTextBox.ItalicStyleSpanInfo) && (info.startPos != end || end == 0)) {
                    if (((SpenObjectTextBox.ItalicStyleSpanInfo) info).isItalic && start >= info.startPos && end <= info.endPos) {
                        textInfo.style |= 2;
                    }
                } else if ((info instanceof SpenObjectTextBox.UnderlineStyleSpanInfo) && (info.startPos != end || end == 0)) {
                    if (((SpenObjectTextBox.UnderlineStyleSpanInfo) info).isUnderline && start >= info.startPos && end <= info.endPos) {
                        textInfo.style |= 4;
                    }
                } else if ((info instanceof SpenObjectTextBox.TextDirectionSpanInfo) && info.startPos != end) {
                    textInfo.direction = ((SpenObjectTextBox.TextDirectionSpanInfo) info).textDirection;
                }
            }
        }
        ArrayList<SpenObjectTextBox.TextParagraphInfo> pInfo = this.mObjectText.getParagraph();
        if (pInfo != null) {
            Iterator<SpenObjectTextBox.TextParagraphInfo> it = pInfo.iterator();
            while (it.hasNext()) {
                SpenObjectTextBox.TextParagraphInfo info2 = it.next();
                if (info2 instanceof SpenObjectTextBox.AlignParagraphInfo) {
                    textInfo.align = ((SpenObjectTextBox.AlignParagraphInfo) info2).align;
                } else if (info2 instanceof SpenObjectTextBox.LineSpacingParagraphInfo) {
                    textInfo.lineSpacingType = ((SpenObjectTextBox.LineSpacingParagraphInfo) info2).type;
                    textInfo.lineSpacing = ((SpenObjectTextBox.LineSpacingParagraphInfo) info2).lineSpacing;
                }
            }
            return textInfo;
        }
        return textInfo;
    }

    private Bitmap getDrawableImage(String drawableName) throws PackageManager.NameNotFoundException {
        try {
            PackageManager manager = getContext().getPackageManager();
            Resources mApk1Resources = manager.getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
            int mDrawableResID = mApk1Resources.getIdentifier(drawableName, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
            try {
                Bitmap tmp = BitmapFactory.decodeResource(mApk1Resources, mDrawableResID);
                return tmp;
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                return null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private String getMultiLanguage(String strName) throws PackageManager.NameNotFoundException {
        try {
            PackageManager manager = getContext().getPackageManager();
            Resources sdkResources = manager.getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
            int strID = sdkResources.getIdentifier(strName, VLConfigParser.TYPE_STRING, Spen.SPEN_NATIVE_PACKAGE_NAME);
            if (strID == 0) {
                return null;
            }
            return sdkResources.getString(strID);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLineForVertical(float v) {
        SpenSLog.m135d(false, "getLineForVertical v = " + v + ", mLineCount =" + this.mLineCount);
        if (this.mIsTyping) {
            measureText();
        }
        if (this.mLinePosition == null) {
            return 0;
        }
        for (int line = this.mLineCount - 1; line >= 0; line--) {
            if (v >= this.mLinePosition[line].y) {
                SpenSLog.m135d(false, "getLineForVertical line = " + line);
                return line;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getOffsetForHorizontal(int line, float h) {
        int start;
        if (this.mObjectText == null) {
            return 0;
        }
        if (this.mIsTyping) {
            measureText();
        }
        if (this.mStartIndex == null || this.mEndIndex == null || this.mTextRect == null || line >= this.mLineCount || line < 0) {
            return 0;
        }
        if (this.mStartIndex[line] == this.mEndIndex[line]) {
            return this.mStartIndex[line] + 1;
        }
        String str = this.mObjectText.getText();
        char oneChar = str.charAt(this.mStartIndex[line]);
        if (oneChar == '\n' || oneChar == '\r') {
            start = this.mStartIndex[line] + 1;
        } else {
            start = this.mStartIndex[line];
        }
        int end = this.mEndIndex[line];
        int startIndex = this.mEndIndex[line];
        int lastIndex = startIndex;
        float startX = this.mTextRect[this.mEndIndex[line]].left;
        float lastX = startX;
        for (int index = start; index <= end; index++) {
            if (h < this.mTextRect[index].left || h > this.mTextRect[index].right) {
                if (lastX < this.mTextRect[index].left) {
                    lastX = this.mTextRect[index].left;
                    lastIndex = index;
                }
                if (startX > this.mTextRect[index].left) {
                    startX = this.mTextRect[index].left;
                    startIndex = index;
                }
            } else {
                return index;
            }
        }
        if (h >= startX) {
            startIndex = lastIndex;
        }
        int index2 = startIndex;
        return index2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCursorIndex(int line, float h) {
        String str;
        int start;
        SpenSLog.m135d(false, "getCursorIndex line = " + line + ", h =" + h);
        if (this.mObjectText == null) {
            return 0;
        }
        if (this.mIsTyping) {
            measureText();
        }
        if (this.mStartIndex == null || this.mEndIndex == null || this.mTextRect == null || this.mTextDirection == null) {
            SpenSLog.m137e(false, "getCursorIndex fail to measureText()");
            return 0;
        }
        if (line >= this.mLineCount) {
            return this.mEndIndex[this.mLineCount - 1];
        }
        if (line >= 0 && (str = this.mObjectText.getText()) != null) {
            if (this.mStartIndex[line] == this.mEndIndex[line] && this.mIsFirstCharLF) {
                return this.mStartIndex[line] + 1;
            }
            char oneChar = str.charAt(this.mStartIndex[line]);
            if (oneChar == '\n' || oneChar == '\r') {
                start = this.mStartIndex[line] + 1;
            } else {
                start = this.mStartIndex[line];
            }
            int end = this.mEndIndex[line];
            int startIndex = this.mEndIndex[line];
            int lastIndex = startIndex;
            float startX = this.mTextRect[this.mEndIndex[line]].left;
            float lastX = startX;
            int index = start;
            while (index <= end) {
                if (h < this.mTextRect[index].left || h > this.mTextRect[index].right) {
                    if (lastX < this.mTextRect[index].left) {
                        lastX = this.mTextRect[index].left;
                        lastIndex = index;
                    }
                    if (startX > this.mTextRect[index].left) {
                        startX = this.mTextRect[index].left;
                        startIndex = index;
                    }
                    index++;
                } else {
                    SpenSLog.m135d(false, "getCursorIndex index = " + index);
                    if (h >= this.mTextRect[index].centerX()) {
                        if (this.mTextDirection[index] == 0) {
                            if (index < end) {
                                index++;
                            }
                            while (index <= end && this.mTextRect[index].width() == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                                index++;
                            }
                            return index;
                        }
                        return index;
                    }
                    if (this.mTextDirection[index] != 0) {
                        if (index < end) {
                            index++;
                        }
                        while (index <= end && this.mTextRect[index].width() == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            index++;
                        }
                        return index;
                    }
                    return index;
                }
            }
            SpenSLog.m135d(false, "getCursorIndex h = " + h + " startIndex = " + startIndex + " lastIndex = " + lastIndex);
            if (h < startX) {
                if (this.mTextDirection[startIndex] != 0) {
                    int index2 = startIndex + 1;
                    return index2;
                }
                int index3 = startIndex;
                return index3;
            }
            if (this.mTextDirection[lastIndex] == 0) {
                int index4 = lastIndex + 1;
                return index4;
            }
            int index5 = lastIndex;
            return index5;
        }
        return 0;
    }

    private void absoluteCoordinate(RectF dstRect, RectF srcRect, SpenControlBase.CoordinateInfo coordinateInfo) {
        dstRect.left = ((srcRect.left - coordinateInfo.frameRect.left) / coordinateInfo.zoomRatio) + coordinateInfo.pan.x;
        dstRect.right = ((srcRect.right - coordinateInfo.frameRect.left) / coordinateInfo.zoomRatio) + coordinateInfo.pan.x;
        dstRect.top = ((srcRect.top - coordinateInfo.frameRect.top) / coordinateInfo.zoomRatio) + coordinateInfo.pan.y;
        dstRect.bottom = ((srcRect.bottom - coordinateInfo.frameRect.top) / coordinateInfo.zoomRatio) + coordinateInfo.pan.y;
    }

    private void relativeCoordinate(RectF dstRect, RectF srcRect, SpenControlBase.CoordinateInfo coordinateInfo) {
        dstRect.left = ((srcRect.left - coordinateInfo.pan.x) * coordinateInfo.zoomRatio) + coordinateInfo.frameRect.left;
        dstRect.right = ((srcRect.right - coordinateInfo.pan.x) * coordinateInfo.zoomRatio) + coordinateInfo.frameRect.left;
        dstRect.top = ((srcRect.top - coordinateInfo.pan.y) * coordinateInfo.zoomRatio) + coordinateInfo.frameRect.top;
        dstRect.bottom = ((srcRect.bottom - coordinateInfo.pan.y) * coordinateInfo.zoomRatio) + coordinateInfo.frameRect.top;
    }

    private boolean isItalicAttribute(int pos) {
        if (this.mObjectText == null) {
            return false;
        }
        ArrayList<SpenObjectTextBox.TextSpanInfo> spans = this.mObjectText.findSpans(pos, pos);
        if (spans != null) {
            for (int cnt = spans.size() - 1; cnt >= 0; cnt--) {
                SpenObjectTextBox.TextSpanInfo info = spans.get(cnt);
                if ((info instanceof SpenObjectTextBox.ItalicStyleSpanInfo) && (info.startPos != pos || pos == 0 || info.startPos == info.endPos)) {
                    if (!((SpenObjectTextBox.ItalicStyleSpanInfo) info).isItalic) {
                        return false;
                    }
                    if (pos >= info.startPos && pos <= info.endPos) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isLTRAttribute(int pos) {
        if (this.mObjectText == null) {
            return false;
        }
        ArrayList<SpenObjectTextBox.TextSpanInfo> spans = this.mObjectText.findSpans(pos, pos);
        if (spans != null) {
            int cnt = spans.size() - 1;
            while (true) {
                if (cnt < 0) {
                    break;
                }
                if (!(spans.get(cnt) instanceof SpenObjectTextBox.TextDirectionSpanInfo)) {
                    cnt--;
                } else {
                    int startPos = spans.get(cnt).startPos;
                    int endPos = spans.get(cnt).endPos;
                    int stringLength = 0;
                    String str = this.mEditable.toString();
                    if (str != null) {
                        stringLength = str.length();
                    }
                    if (startPos > stringLength || endPos > stringLength) {
                        SpenSLog.m137e(false, "Invalid Span Info");
                    } else {
                        return ((SpenObjectTextBox.TextDirectionSpanInfo) spans.get(cnt)).textDirection == 0;
                    }
                }
            }
        }
        return true;
    }

    public class EditableInputConnection extends BaseInputConnection {
        private final SpenTextBox mTextView;

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean clearMetaKeyStates(int states) {
            Log.d("EditableInputConnection", "clearMetaKeyStates()");
            Editable content = getEditable();
            if (content != null) {
                if (SpenTextBox.this.mKeyListener != null) {
                    try {
                        SpenTextBox.this.mKeyListener.clearMetaKeyState(this.mTextView, content, states);
                    } catch (AbstractMethodError e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
            return false;
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int beforeLength, int afterLength) {
            SpenSLog.m135d(false, "deleteSurroundingText() beforeLength = " + beforeLength + ", afterLength = " + afterLength);
            if (beforeLength - afterLength > 1) {
                SpenTextBox.this.mIsDeletedText = true;
            }
            Editable content = getEditable();
            if (content == null) {
                return false;
            }
            beginBatchEdit();
            int a = Selection.getSelectionStart(content);
            int b = Selection.getSelectionEnd(content);
            if (a > b) {
                a = b;
                b = a;
            }
            int ca = getComposingSpanStart(content);
            int cb = getComposingSpanEnd(content);
            if (cb < ca) {
                ca = cb;
                cb = ca;
            }
            if (ca != -1 && cb != -1) {
                if (ca < a) {
                    a = ca;
                }
                if (cb > b) {
                    b = cb;
                }
            }
            int deleted = 0;
            if (beforeLength > 0) {
                int start = a - beforeLength;
                if (start < 0) {
                    start = 0;
                }
                content.delete(start, a);
                deleted = a - start;
            }
            if (afterLength > 0) {
                int b2 = b - deleted;
                int end = b2 + afterLength;
                if (end > content.length()) {
                    end = content.length();
                }
                content.delete(b2, end);
            }
            endBatchEdit();
            return true;
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence text, int newCursorPosition) {
            SpenSLog.m135d(false, "commitText());");
            checkSelection(text);
            SpenTextBox.this.mIsDeletedText = false;
            SpenTextBox.this.mIsCommitText = true;
            super.commitText(text, newCursorPosition);
            SpenTextBox.this.updateSelection();
            SpenTextBox.this.mIsCommitText = false;
            return true;
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean setComposingText(CharSequence text, int newCursorPosition) {
            SpenSLog.m135d(false, "setComposingText());");
            checkSelection(text);
            SpenTextBox.this.mIsDeletedText = false;
            SpenTextBox.this.mIsComposingText = true;
            super.setComposingText(text, newCursorPosition);
            SpenTextBox.this.mIsComposingText = false;
            return true;
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean finishComposingText() {
            SpenSLog.m135d(false, "finishComposingText());");
            return super.finishComposingText();
        }

        public EditableInputConnection(View textview) {
            super(textview, true);
            this.mTextView = (SpenTextBox) textview;
        }

        @Override // android.view.inputmethod.BaseInputConnection
        public Editable getEditable() {
            return SpenTextBox.this.mEditable;
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent event) {
            SpenSLog.m135d(false, "sendKeyEvent() code = " + event.getKeyCode() + ", action = " + event.getAction());
            event.getAction();
            boolean ret = super.sendKeyEvent(event);
            return ret;
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
            ExtractedText et = null;
            if (this.mTextView != null) {
                et = new ExtractedText();
                et.flags = 0;
                et.partialStartOffset = -1;
                et.partialEndOffset = -1;
                et.startOffset = 0;
                et.text = "";
                et.selectionStart = 0;
                et.selectionEnd = 0;
                Editable content = getEditable();
                String str = content.toString();
                if (str.length() != 0) {
                    et.text = str;
                    if (0 > 0) {
                        et.selectionStart = 0;
                        et.selectionEnd = et.selectionStart + 0;
                    } else {
                        et.selectionStart = Selection.getSelectionStart(content);
                        et.selectionEnd = Selection.getSelectionEnd(content);
                    }
                }
            }
            return et;
        }

        private void checkSelection(CharSequence text) {
            SpenTextBox.this.mHandleButton[0].setVisibility(8);
            SpenTextBox.this.mHandleButton[2].setVisibility(8);
            SpenTextBox.this.mCursorVisible = true;
        }
    }

    private boolean isCursorVisible() {
        return true;
    }

    private boolean shouldBlink() {
        return isCursorVisible() && isFocused();
    }

    private static class Blink extends Handler {
        private static final int CURSOR_DELAY = 600;
        public static final int CURSOR_MESSAGE = 1;
        private boolean mIsStartBlink = false;
        private final WeakReference<SpenTextBox> mTextBox;

        Blink(SpenTextBox textBox) {
            this.mTextBox = new WeakReference<>(textBox);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            SpenTextBox textBox;
            if (this.mTextBox != null && (textBox = this.mTextBox.get()) != null) {
                switch (msg.what) {
                    case 1:
                        textBox.invalidate();
                        if (this.mIsStartBlink) {
                            removeMessages(1);
                            textBox.mHighlightPathBogus = !textBox.mHighlightPathBogus;
                            sendEmptyMessageDelayed(1, 600L);
                            break;
                        }
                        break;
                }
                super.handleMessage(msg);
            }
        }

        public void startBlink() {
            SpenTextBox textBox;
            if (this.mTextBox != null && (textBox = this.mTextBox.get()) != null) {
                textBox.mHighlightPathBogus = true;
                this.mIsStartBlink = true;
                removeMessages(1);
                sendEmptyMessageDelayed(1, 600L);
            }
        }

        public void restartBlink() {
            SpenTextBox textBox;
            if (this.mTextBox != null && (textBox = this.mTextBox.get()) != null) {
                textBox.mHighlightPathBogus = true;
                removeMessages(1);
                if (this.mIsStartBlink) {
                    sendEmptyMessageDelayed(1, 600L);
                }
            }
        }

        public void stopBlink() {
            SpenTextBox textBox;
            if (this.mTextBox != null && (textBox = this.mTextBox.get()) != null) {
                textBox.mHighlightPathBogus = false;
                this.mIsStartBlink = false;
                removeMessages(1);
            }
        }
    }

    private static class Typing extends Handler {
        private static final int INPUT_DELAY = 200;
        public static final int INPUT_END_MESSAGE = 1;
        private final WeakReference<SpenTextBox> mTextBox;

        Typing(SpenTextBox textBox) {
            this.mTextBox = new WeakReference<>(textBox);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            SpenTextBox textBox;
            if (this.mTextBox != null && (textBox = this.mTextBox.get()) != null) {
                switch (msg.what) {
                    case 1:
                        textBox.measureText();
                        textBox.updateSettingInfo();
                        textBox.mIsTyping = false;
                        break;
                }
                super.handleMessage(msg);
            }
        }

        public void startInput() {
            removeMessages(1);
            sendEmptyMessageDelayed(1, 200L);
        }

        public void stopInput() {
            removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCursorHandle() {
        if (this.mCursorHandleDuration == null) {
            this.mCursorHandleDuration = new HandleDuration(this);
        }
        this.mCursorHandleDuration.removeCallbacks(this.mCursorHandleDuration);
        this.mCursorHandleDuration.postAtTime(this.mCursorHandleDuration, SystemClock.uptimeMillis() + Config.DISCONNECT_TIMEOUT);
        this.mCursorHandleVisible = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showScrollBar() {
        if (this.mScrollBarDuration == null) {
            this.mScrollBarDuration = new ScrollBarDuration(this);
        }
        this.mScrollBarDuration.removeCallbacks(this.mScrollBarDuration);
        this.mScrollBarDuration.postAtTime(this.mScrollBarDuration, SystemClock.uptimeMillis() + 500);
        this.mScrollBarVisible = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCursorHandle() {
        if (this.mCursorHandleDuration != null && this.mHandleButton[1] != null) {
            this.mCursorHandleDuration.removeCallbacks(this.mCursorHandleDuration);
            this.mCursorHandleVisible = false;
            this.mHandleButton[1].setVisibility(8);
        }
    }

    public void enableTouch(boolean touchEnable) {
        this.mTouchEnable = touchEnable;
    }

    public boolean isTouchEnabled() {
        return this.mTouchEnable;
    }

    private static class HandleDuration extends Handler implements Runnable {
        private final WeakReference<SpenTextBox> mTextBox;

        HandleDuration(SpenTextBox textBox) {
            this.mTextBox = new WeakReference<>(textBox);
        }

        @Override // java.lang.Runnable
        public void run() {
            SpenTextBox textBox;
            if (this.mTextBox != null && (textBox = this.mTextBox.get()) != null) {
                textBox.mCursorHandleVisible = false;
                textBox.mHandleButton[1].setVisibility(8);
                if (textBox.mContextMenu != null && textBox.mContextMenu.isShowing()) {
                    textBox.mContextMenu.hide();
                }
                removeCallbacks(this);
            }
        }
    }

    private static class ScrollBarDuration extends Handler implements Runnable {
        private final WeakReference<SpenTextBox> mTextBox;

        ScrollBarDuration(SpenTextBox textBox) {
            this.mTextBox = new WeakReference<>(textBox);
        }

        @Override // java.lang.Runnable
        public void run() {
            SpenTextBox textBox;
            if (this.mTextBox != null && (textBox = this.mTextBox.get()) != null) {
                textBox.mScrollBarVisible = false;
                textBox.invalidate();
                removeCallbacks(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] getAbsolutePoint(float x, float y) {
        if (this.mObjectText == null) {
            return null;
        }
        float[] point = {x, native_getPan(this.mNativeTextView) + y};
        this.mScaleMatrix.invert(this.mTempMatrix);
        this.mTempMatrix.mapPoints(point);
        RectF relativeRect = new RectF();
        SpenControlBase.CoordinateInfo coordinateInfo = getCoordinateInfo();
        if (coordinateInfo == null) {
            SpenSLog.m137e(false, "coordinateInfo is null.");
            return null;
        }
        relativeCoordinate(relativeRect, this.mObjectText.getRect(), coordinateInfo);
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(this.mObjectText.getRotation(), relativeRect.centerX(), relativeRect.centerY());
        matrix.invert(this.mTempMatrix);
        this.mTempMatrix.mapPoints(point);
        return point;
    }

    private float[] getRelativePoint(float x, float y) {
        RectF objectRect;
        float[] pts = {x, y};
        if (this.mObjectText != null && (objectRect = this.mObjectText.getRect()) != null) {
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.setRotate(this.mObjectText.getRotation(), objectRect.centerX(), objectRect.centerY());
            matrix.mapPoints(pts);
            return pts;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onCueTopButtonDown(MotionEvent event) {
        float deltaY = native_getPan(this.mNativeTextView);
        float minHeight = native_getHeight(this.mNativeTextView);
        if (this.mObjectText == null) {
            return false;
        }
        RectF objectRect = this.mObjectText.getRect();
        if (minHeight <= objectRect.height()) {
            return false;
        }
        RectF firstTextRect = new RectF();
        native_getTextRect(this.mNativeTextView, 0, firstTextRect);
        float[] point = {event.getX(), event.getY()};
        this.mScaleMatrix.invert(this.mTempMatrix);
        this.mTempMatrix.mapPoints(point);
        return firstTextRect.bottom < deltaY && point[0] > objectRect.width() - 50.0f && point[1] < 50.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onCueBottomButtonDown(MotionEvent event) {
        float deltaY = native_getPan(this.mNativeTextView);
        float minHeight = native_getHeight(this.mNativeTextView);
        if (this.mObjectText == null) {
            return false;
        }
        RectF objectRect = this.mObjectText.getRect();
        if (minHeight <= objectRect.height()) {
            return false;
        }
        RectF endTextRect = new RectF();
        native_getTextRect(this.mNativeTextView, native_getLineEndIndex(this.mNativeTextView, native_getLineCount(this.mNativeTextView) - 1), endTextRect);
        float[] point = {event.getX(), event.getY()};
        this.mScaleMatrix.invert(this.mTempMatrix);
        this.mTempMatrix.mapPoints(point);
        return endTextRect.top > objectRect.height() + deltaY && point[0] > objectRect.width() - 50.0f && point[1] > objectRect.height() - 50.0f;
    }

    @Deprecated
    private boolean onCueBottonDown(MotionEvent event) {
        if (this.mObjectText == null) {
            return false;
        }
        RectF objectRect = this.mObjectText.getRect();
        RectF relativeRect = new RectF();
        SpenControlBase.CoordinateInfo coordinateInfo = getCoordinateInfo();
        if (coordinateInfo == null) {
            SpenSLog.m137e(false, "coordinateInfo is null.");
            return false;
        }
        relativeCoordinate(relativeRect, objectRect, coordinateInfo);
        if (onCueTopButtonDown(event)) {
            int x = ((int) relativeRect.right) - this.mCueBitmap[0].getWidth();
            int y = (int) relativeRect.top;
            int width = this.mCueBitmap[0].getWidth();
            int height = this.mCueBitmap[0].getHeight();
            setHandlePos(this.mCueButton[0], x, y, width, height, relativeRect);
            return true;
        }
        if (onCueBottomButtonDown(event)) {
            int x2 = (((int) relativeRect.right) - this.mCueBitmap[1].getWidth()) + 2;
            int y2 = (((int) relativeRect.bottom) - this.mCueBitmap[1].getHeight()) + 4;
            int width2 = this.mCueBitmap[1].getWidth();
            int height2 = this.mCueBitmap[1].getHeight();
            setHandlePos(this.mCueButton[1], x2, y2, width2, height2, relativeRect);
            return true;
        }
        if (event.getAction() == 1) {
            this.mCueButton[0].setVisibility(8);
            this.mCueButton[1].setVisibility(8);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (!this.mTouchEnable) {
            return false;
        }
        if (event.getAction() == 0) {
            if (this.mContextMenu != null) {
                this.mContextMenu.hide();
            }
            if (this.mIsViewMode && !isFocused()) {
                bringToFront();
                requestFocus();
            }
        }
        if (this.mTextEraserEnable) {
            if (this.mObjectText == null) {
                return false;
            }
            RectF objectRect = this.mObjectText.getRect();
            SpenControlBase.CoordinateInfo coordinateInfo = getCoordinateInfo();
            if (coordinateInfo == null) {
                SpenSLog.m137e(false, "coordinateInfo is null.");
                return false;
            }
            RectF relativeRect = new RectF();
            relativeCoordinate(relativeRect, objectRect, coordinateInfo);
            float[] pts = {event.getX() - relativeRect.left, event.getY() - relativeRect.top};
            getInvMatrix().mapPoints(pts);
            switch (event.getAction()) {
                case 0:
                    int line = getLineForVertical(pts[1]);
                    int index = getCursorIndex(line, pts[0]);
                    setSelection(index, index, false);
                    break;
                case 1:
                    int start = Selection.getSelectionStart(this.mEditable);
                    int line2 = getLineForVertical(pts[1]);
                    int index2 = getCursorIndex(line2, pts[0]);
                    setSelection(start, index2, false);
                    removeText();
                    break;
                case 2:
                    int start2 = Selection.getSelectionStart(this.mEditable);
                    int line3 = getLineForVertical(pts[1]);
                    int index3 = getCursorIndex(line3, pts[0]);
                    setSelection(start2, index3, false);
                    break;
            }
            return true;
        }
        return this.mGestureDetector.onTouchEvent(event);
    }

    private class GestureListener implements GestureDetector.OnGestureListener {
        private GestureListener() {
        }

        /* synthetic */ GestureListener(SpenTextBox spenTextBox, GestureListener gestureListener) {
            this();
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            SpenSLog.m135d(false, "onFling velocityX = " + velocityX + ", velocityY" + velocityY);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e) {
            String str;
            if (!SpenTextBox.this.mIsViewMode) {
                if (SpenTextBox.this.mIsTyping) {
                    SpenTextBox.this.measureText();
                }
                if (SpenTextBox.this.mLineCount > 0) {
                    if (SpenTextBox.this.mObjectText != null && (str = SpenTextBox.this.mObjectText.getText()) != null) {
                        float[] point = {e.getX(), e.getY()};
                        SpenTextBox.this.mScaleMatrix.invert(SpenTextBox.this.mTempMatrix);
                        SpenTextBox.this.mTempMatrix.mapPoints(point);
                        point[1] = point[1] + SpenTextBox.native_getPan(SpenTextBox.this.mNativeTextView);
                        int line = SpenTextBox.this.getLineForVertical(point[1]);
                        int offset = SpenTextBox.this.getOffsetForHorizontal(line, point[0]);
                        if (SpenTextBox.this.mTextRect != null && SpenTextBox.this.mEndIndex != null) {
                            if (offset == SpenTextBox.this.mEndIndex[line] && SpenTextBox.this.mTextRect[offset].right < point[0]) {
                                offset++;
                            }
                            char oneChar = offset >= str.length() ? str.charAt(offset - 1) : str.charAt(offset);
                            if (oneChar == ' ' || oneChar == '\t' || oneChar == '\n' || oneChar == '\r') {
                                SpenTextBox.this.setSelection(offset, false);
                                SpenTextBox.this.onSelectionChanged(offset, offset);
                                SpenTextBox.this.showCursorHandle();
                            } else {
                                Word word = new Word(null);
                                if (SpenTextBox.this.findWord(offset, word)) {
                                    int start = word.startIndex;
                                    int end = word.endIndex;
                                    SpenTextBox.this.setSelection(start, end, false);
                                } else {
                                    SpenTextBox.this.setSelection(offset, false);
                                    SpenTextBox.this.showCursorHandle();
                                    if (offset == SpenTextBox.this.getTextLength() && SpenTextBox.this.mTextBoxActionListener != null) {
                                        SpenTextBox.this.onSelectionChanged(offset, offset);
                                    }
                                }
                            }
                            SpenTextBox.this.showSoftInput();
                            return;
                        }
                        return;
                    }
                    return;
                }
                SpenTextBox.this.showCursorHandle();
                if (SpenTextBox.this.mTextBoxActionListener != null) {
                    SpenTextBox.this.onSelectionChanged(0, 0);
                }
                SpenTextBox.this.setSelection(0, false);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            SpenSLog.m135d(false, "onScroll distanceX = " + distanceX + ", distanceY" + distanceY);
            if (SpenTextBox.this.mObjectText != null) {
                SpenControlBase.CoordinateInfo coordinateInfo = SpenTextBox.this.getCoordinateInfo();
                float distanceY2 = distanceY / coordinateInfo.zoomRatio;
                float minimumHeight = SpenTextBox.native_getHeight(SpenTextBox.this.mNativeTextView);
                RectF objectRect = SpenTextBox.this.mObjectText.getRect();
                if (objectRect != null && minimumHeight > Math.ceil(objectRect.height())) {
                    float deltaY = SpenTextBox.native_getPan(SpenTextBox.this.mNativeTextView);
                    if (distanceY2 > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                        float deltaY2 = deltaY + distanceY2;
                        if (deltaY2 < minimumHeight - objectRect.height()) {
                            SpenTextBox.native_setPan(SpenTextBox.this.mNativeTextView, deltaY2);
                            SpenTextBox.this.mObjectText.setVereticalPan(deltaY2);
                        } else if (minimumHeight < objectRect.height()) {
                            SpenTextBox.native_setPan(SpenTextBox.this.mNativeTextView, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                            SpenTextBox.this.mObjectText.setVereticalPan(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                        } else {
                            SpenTextBox.native_setPan(SpenTextBox.this.mNativeTextView, minimumHeight - objectRect.height());
                            SpenTextBox.this.mObjectText.setVereticalPan(minimumHeight - objectRect.height());
                        }
                    } else {
                        float deltaY3 = deltaY + distanceY2;
                        if (deltaY3 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            deltaY3 = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                        }
                        SpenTextBox.native_setPan(SpenTextBox.this.mNativeTextView, deltaY3);
                        SpenTextBox.this.mObjectText.setVereticalPan(deltaY3);
                    }
                    SpenTextBox.native_update(SpenTextBox.this.mNativeTextView);
                    if (SpenTextBox.this.mBitmap != null) {
                        SpenTextBox.this.mBitmap.setPixel(0, 0, SpenTextBox.this.mBitmap.getPixel(0, 0));
                    }
                    SpenTextBox.this.showScrollBar();
                    SpenTextBox.this.measureText();
                    SpenTextBox.this.invalidate();
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent e) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e) {
            if (SpenTextBox.this.mBitmap == null || SpenTextBox.this.mIsViewMode || SpenTextBox.this.mObjectText == null) {
                return false;
            }
            if (SpenTextBox.this.mLineCount > 0) {
                float[] point = {e.getX(), e.getY()};
                SpenTextBox.this.mScaleMatrix.invert(SpenTextBox.this.mTempMatrix);
                SpenTextBox.this.mTempMatrix.mapPoints(point);
                point[1] = point[1] + SpenTextBox.native_getPan(SpenTextBox.this.mNativeTextView);
                if ((SpenTextBox.this.onCueTopButtonDown(e) || SpenTextBox.this.onCueBottomButtonDown(e)) && SpenTextBox.this.mTextBoxActionListener != null) {
                    SpenTextBox.this.mTextBoxActionListener.onMoreButtonDown(SpenTextBox.this.mObjectText);
                    return true;
                }
                int line = SpenTextBox.this.getLineForVertical(point[1]);
                int index = SpenTextBox.this.getCursorIndex(line, point[0]);
                SpenTextBox.this.setSelection(index, false);
                SpenTextBox.this.showCursorHandle();
                SpenTextBox.this.invalidate();
            }
            SpenTextBox.this.showSoftInput();
            return true;
        }
    }

    private class DoubleTapListener implements GestureDetector.OnDoubleTapListener {
        private DoubleTapListener() {
        }

        /* synthetic */ DoubleTapListener(SpenTextBox spenTextBox, DoubleTapListener doubleTapListener) {
            this();
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e) {
            if (SpenTextBox.this.mIsViewMode) {
                return true;
            }
            if (SpenTextBox.this.mIsTyping) {
                SpenTextBox.this.measureText();
            }
            if (SpenTextBox.this.mLineCount > 0) {
                if (SpenTextBox.this.mObjectText == null) {
                    return false;
                }
                String str = SpenTextBox.this.mObjectText.getText();
                if (str == null) {
                    return true;
                }
                float[] point = {e.getX(), e.getY()};
                SpenTextBox.this.mScaleMatrix.invert(SpenTextBox.this.mTempMatrix);
                SpenTextBox.this.mTempMatrix.mapPoints(point);
                point[1] = point[1] + SpenTextBox.native_getPan(SpenTextBox.this.mNativeTextView);
                int line = SpenTextBox.this.getLineForVertical(point[1]);
                int offset = SpenTextBox.this.getOffsetForHorizontal(line, point[0]);
                if (SpenTextBox.this.mTextRect == null || SpenTextBox.this.mEndIndex == null) {
                    return true;
                }
                if (offset == SpenTextBox.this.mEndIndex[line] && SpenTextBox.this.mTextRect[offset].right < point[0]) {
                    offset++;
                }
                char oneChar = offset >= str.length() ? str.charAt(offset - 1) : str.charAt(offset);
                if (oneChar == ' ' || oneChar == '\t' || oneChar == '\n' || oneChar == '\r') {
                    SpenTextBox.this.setSelection(offset, false);
                    SpenTextBox.this.onSelectionChanged(offset, offset);
                    return true;
                }
                Word word = new Word(null);
                if (SpenTextBox.this.findWord(offset, word)) {
                    int start = word.startIndex;
                    int end = word.endIndex;
                    SpenTextBox.this.setSelection(start, end, false);
                    return true;
                }
                SpenTextBox.this.setSelection(offset, false);
                return true;
            }
            if (SpenTextBox.this.mTextBoxActionListener != null) {
                SpenTextBox.this.onSelectionChanged(0, 0);
            }
            SpenTextBox.this.setSelection(0, false);
            SpenTextBox.this.showCursorHandle();
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent e) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAccessibilityEventTypeViewTextChanged(CharSequence beforeText, int fromIndex, int removedCount, int addedCount) {
        AccessibilityEvent event = AccessibilityEvent.obtain(16);
        event.setFromIndex(fromIndex);
        event.setRemovedCount(removedCount);
        event.setAddedCount(addedCount);
        event.setBeforeText(beforeText);
        sendAccessibilityEventUnchecked(event);
    }

    private class ChangeWatcher implements TextWatcher, SpanWatcher {
        private CharSequence mBeforeText;

        private ChangeWatcher() {
        }

        /* synthetic */ ChangeWatcher(SpenTextBox spenTextBox, ChangeWatcher changeWatcher) {
            this();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence buffer, int start, int before, int after) {
            SpenSLog.m135d(false, "beforeTextChanged");
            SpenTextBox.this.hideCursorHandle();
            SpenTextBox.this.mTyping.startInput();
            SpenTextBox.this.mIsTyping = true;
            SpenTextBox.this.initMeasureInfo();
            if (SpenTextBox.this.mAccessibilityManager.isEnabled()) {
                this.mBeforeText = buffer.toString();
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence text, int start, int before, int after) {
            try {
                if (SpenTextBox.this.mAccessibilityManager.isEnabled() && (SpenTextBox.this.isFocused() || (SpenTextBox.this.isSelected() && SpenTextBox.this.isShown()))) {
                    SpenTextBox.this.sendAccessibilityEventTypeViewTextChanged(this.mBeforeText, start, before, after);
                    this.mBeforeText = null;
                }
            } catch (SpenAlreadyClosedException e) {
                e.printStackTrace();
            }
            if (SpenTextBox.this.mObjectText != null) {
                if (!SpenTextBox.this.mIsEditableClear) {
                    if (SpenTextBox.this.mContextMenu != null && SpenTextBox.this.mContextMenu.isShowing()) {
                        SpenTextBox.this.mContextMenu.hide();
                    }
                    String str = text.subSequence(start, start + after).toString();
                    SpenSLog.m135d(false, "onTextChanged() text = " + text.toString() + ", str = " + str + ", start = " + start + ", before = " + before + ", after = " + after);
                    if (before != 0) {
                        String objectString = SpenTextBox.this.mObjectText.getText();
                        if (objectString != null) {
                            if (str.length() < 1) {
                                if (SpenTextBox.this.mIsCommitText || SpenTextBox.this.mIsComposingText || SpenTextBox.this.mIsDeletedText) {
                                    SpenSLog.m135d(false, "onTextChanged() removeText : " + start + " ~ " + before);
                                    SpenTextBox.this.mObjectText.removeText(start, before);
                                    if (!SpenTextBox.this.mCursorVisible) {
                                        SpenTextBox.this.mCursorVisible = true;
                                    }
                                } else {
                                    SpenTextBox.this.mSurroundingTextLength += before;
                                }
                            } else if (SpenTextBox.this.mSurroundingTextLength == 0) {
                                SpenTextBox.this.mObjectText.replaceText(str, start, before);
                            } else {
                                SpenTextBox.this.mObjectText.replaceText(str, start, SpenTextBox.this.mSurroundingTextLength);
                                SpenTextBox.this.mSurroundingTextLength = 0;
                            }
                        } else {
                            return;
                        }
                    } else if (SpenTextBox.this.mSurroundingTextLength != 0) {
                        SpenTextBox.this.mObjectText.replaceText(str, start, SpenTextBox.this.mSurroundingTextLength);
                        SpenTextBox.this.mSurroundingTextLength = 0;
                    } else {
                        if (str.length() > 0) {
                            int dir = Character.getDirectionality(str.charAt(0));
                            switch (dir) {
                                case 0:
                                case 3:
                                case 14:
                                case 15:
                                    SpenTextBox.this.setTextDirection(0, SpenTextBox.this.mObjectText.getCursorPos(), SpenTextBox.this.mObjectText.getCursorPos());
                                    break;
                                case 1:
                                case 2:
                                case 16:
                                case 17:
                                    SpenTextBox.this.setTextDirection(1, SpenTextBox.this.mObjectText.getCursorPos(), SpenTextBox.this.mObjectText.getCursorPos());
                                    break;
                            }
                        }
                        SpenTextBox.this.mObjectText.insertTextAtCursor(str);
                    }
                    if (after != 0) {
                        SpenTextBox.this.updateSelection();
                    }
                    SpenTextBox.this.fit(true);
                }
                String desctription = SpenTextBox.this.mObjectText.getText();
                if (desctription == null) {
                    desctription = "";
                }
                SpenTextBox.this.setContentDescription("TextBox " + desctription);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable buffer) {
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable buf, Object what, int s, int e, int st, int en) {
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable buf, Object what, int s, int e) {
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable buf, Object what, int s, int e) {
        }
    }

    private boolean isFrontPosition(int pos) {
        if (this.mEndIndex == null) {
            return false;
        }
        for (int index = 0; index < this.mEndIndex.length - 1; index++) {
            if (this.mEndIndex[index] + 1 == pos) {
                char oneChar = this.mObjectText.getText().charAt(pos);
                return (oneChar == '\n' || oneChar == '\r') ? false : true;
            }
        }
        return false;
    }
}
