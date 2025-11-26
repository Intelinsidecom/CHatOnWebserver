package com.samsung.android.sdk.pen.engine;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.BaseAdapter;
import android.widget.EdgeEffect;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.engine.SpenHorizontalListView;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class SpenContextMenu {
    private static final int DEFAULT_HEIGHT = 61;
    private static final int DEFAULT_HEIGHT_2 = 78;
    private static final int DEFAULT_HEIGHT_2_N1 = 92;
    private static final int DEFAULT_HEIGHT_2_VIENNA = 96;
    private static final int DEFAULT_HEIGHT_N1 = 72;
    protected static final int DEFAULT_ITEM_WIDTH = 72;
    protected static final int DEFAULT_ITEM_WIDTH_N1 = 98;
    private static final int DEFAULT_MINIMUM_DELAY = 1000;
    protected static final int DEFAULT_SEPERATOR_WIDTH = 1;
    protected static final int DEFAULT_SEPERATOR_WIDTH_N1 = 2;
    private static final int DEFAULT_TALKBACK_BORDER_LINE_COLOR = -16742986;
    private static final int DEFAULT_TALKBACK_BORDER_WIDTH = 8;
    private static final int DEFAULT_TEXT_SIZE = 12;
    private static final int DEFAULT_TEXT_SIZE_N1 = 15;
    private static final int DEFAULT_WIDTH = 310;
    private static final float MAX_RATE_PER_WIDTH = 0.9f;
    protected static final String QUICK_POPUP_BG = "quick_popup_bg";
    protected static final String QUICK_POPUP_BG_PRESS = "quick_popup_bg_press";
    protected static final String QUICK_POPUP_DV = "quick_popup_dv";
    protected static final String SHADOW_BORDER = "shadow_border";
    protected static final String SHADOW_BORDER_N1 = "shadow_border_n1";
    protected static final String SHADOW_BORDER_VIENNA = "shadow_border_vienna";
    protected static final String TW_QUICK_BUBBLE_DIVIDER_HOLO_LIGHT = "tw_quick_bubble_divider_holo_light";
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_WIDE = 1;
    private AccessibilityManager mAccessibilityManager;
    private CustomImageView mBgImageLeftItem;
    private CustomImageView mBgImageRightItem;
    private final Context mContext;
    private SpenHorizontalListView mHorizontalListView;
    private boolean mIsNormalMode;
    private boolean mIsViennaModel;
    CMenu mMenu;
    private int mNumItem;
    private View mParent;
    private View mPopupView;
    private PopupWindow mPopupWindow;
    private Rect mRect;
    private Resources mResourceSDK;
    private ContextMenuListener mSelectListener;
    private static final int SDK_VERSION = Build.VERSION.SDK_INT;
    private static int mType = 0;
    private Timer mTimer = null;
    private final Handler mHandler = new Handler();
    private int mDelay = 0;
    private Timer mScrollTimer = null;
    private boolean mScrollFlag = false;
    private EdgeEffect mLeftEdgeEffect = null;
    private EdgeEffect mRightEdgeEffect = null;
    private final SpenHorizontalListView.Listener mSpenHorizontalListViewListener = new SpenHorizontalListView.Listener() { // from class: com.samsung.android.sdk.pen.engine.SpenContextMenu.1
        @Override // com.samsung.android.sdk.pen.engine.SpenHorizontalListView.Listener
        public void onScrolll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            SpenContextMenu.this.mScrollFlag = true;
            if (SpenContextMenu.this.mBgImageLeftItem != null && SpenContextMenu.this.mHorizontalListView.isEdgeLeft()) {
                SpenContextMenu.this.mBgImageLeftItem.invalidate();
            }
            if (SpenContextMenu.this.mBgImageRightItem != null && SpenContextMenu.this.mHorizontalListView.isEdgeRight()) {
                SpenContextMenu.this.mBgImageRightItem.invalidate();
            }
        }
    };
    private float mCount = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;

    public interface ContextMenuListener {
        void onSelected(int i);
    }

    private class CustomImageView extends ImageButton {
        private int mIsLeftEdge;
        private Paint mTalkBackBoderPaint;
        private RectF mTalkBackBorderRect;
        private int mTalkBackIndex;

        public CustomImageView(Context context) {
            super(context);
            this.mIsLeftEdge = 1;
            if (this.mTalkBackBoderPaint == null) {
                this.mTalkBackBoderPaint = new Paint();
                this.mTalkBackBoderPaint.setStrokeWidth(8.0f);
                this.mTalkBackBoderPaint.setStyle(Paint.Style.STROKE);
                this.mTalkBackBoderPaint.setColor(SpenContextMenu.DEFAULT_TALKBACK_BORDER_LINE_COLOR);
            }
            if (this.mTalkBackBorderRect == null) {
                this.mTalkBackBorderRect = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            }
            this.mTalkBackIndex = 0;
            this.mIsLeftEdge = 1;
        }

        public CustomImageView(Context context, int isLeftEdge) {
            super(context);
            this.mIsLeftEdge = 1;
            this.mIsLeftEdge = isLeftEdge;
            if (this.mTalkBackBoderPaint == null) {
                this.mTalkBackBoderPaint = new Paint();
                this.mTalkBackBoderPaint.setStrokeWidth(8.0f);
                this.mTalkBackBoderPaint.setStyle(Paint.Style.STROKE);
                this.mTalkBackBoderPaint.setColor(SpenContextMenu.DEFAULT_TALKBACK_BORDER_LINE_COLOR);
            }
            if (this.mTalkBackBorderRect == null) {
                this.mTalkBackBorderRect = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            }
            this.mTalkBackIndex = 0;
        }

        private void drawEdgeEffectsUnclipped(Canvas canvas) {
            float paddingRight;
            boolean needsInvalidate = false;
            boolean isReady = false;
            if (SpenContextMenu.this.mRightEdgeEffect != null && !SpenContextMenu.this.mRightEdgeEffect.isFinished()) {
                isReady = true;
            }
            if (SpenContextMenu.this.mLeftEdgeEffect != null && !SpenContextMenu.this.mLeftEdgeEffect.isFinished()) {
                isReady = true;
            }
            if (isReady) {
                int restoreCount = canvas.save();
                if (this.mIsLeftEdge == 0) {
                    canvas.translate(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, canvas.getHeight());
                    canvas.rotate(-90.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                    canvas.scale(1.0f, 0.5f);
                    if (SpenContextMenu.this.mLeftEdgeEffect.draw(canvas)) {
                        needsInvalidate = true;
                    }
                } else if (this.mIsLeftEdge == 2) {
                    if (SpenContextMenu.this.mContext != null) {
                        Resources res = SpenContextMenu.this.mContext.getResources();
                        DisplayMetrics dm = res.getDisplayMetrics();
                        if (SpenContextMenu.mType == 1) {
                            float paddingRight2 = TypedValue.applyDimension(1, 98.0f, dm);
                            paddingRight = paddingRight2 + 2.0f;
                        } else {
                            float paddingRight3 = TypedValue.applyDimension(1, 72.0f, dm);
                            paddingRight = paddingRight3 + 1.0f;
                        }
                        canvas.translate(paddingRight, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                        canvas.rotate(90.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                        canvas.scale(1.0f, 0.5f);
                        if (SpenContextMenu.this.mRightEdgeEffect.draw(canvas)) {
                            needsInvalidate = true;
                        }
                    } else {
                        return;
                    }
                }
                canvas.restoreToCount(restoreCount);
                if (needsInvalidate) {
                    invalidate();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void drawTalkbackBorder(int index) {
            if (SpenContextMenu.this.mAccessibilityManager != null && SpenContextMenu.this.mAccessibilityManager.isEnabled()) {
                this.mTalkBackIndex = index;
                invalidate();
            }
        }

        @Override // android.widget.ImageView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.mTalkBackIndex == 1) {
                this.mTalkBackBorderRect.right = getWidth();
                this.mTalkBackBorderRect.bottom = getHeight();
                canvas.drawRect(this.mTalkBackBorderRect, this.mTalkBackBoderPaint);
                return;
            }
            if (this.mTalkBackIndex != 2 && this.mIsLeftEdge != 1) {
                drawEdgeEffectsUnclipped(canvas);
            }
        }
    }

    private static class CMenu {
        private ArrayList<SpenContextMenuItemInfo> mItemList;

        private CMenu() {
        }

        /* synthetic */ CMenu(CMenu cMenu) {
            this();
        }
    }

    public static int getType() {
        return mType;
    }

    public static void setType(int type) {
        mType = type;
    }

    private void updateContextMenuLocation() {
        int itemWidth;
        int seperatorWidth;
        int itemHeight;
        int itemHeight_2;
        int delta_padding;
        int width;
        if (this.mMenu != null && this.mMenu.mItemList != null && this.mContext != null) {
            Resources res = this.mContext.getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            int size = this.mMenu.mItemList.size();
            if (mType == 1) {
                itemWidth = DEFAULT_ITEM_WIDTH_N1;
                seperatorWidth = 2;
                itemHeight = 72;
                if (this.mIsViennaModel) {
                    itemHeight_2 = DEFAULT_HEIGHT_2_VIENNA;
                    delta_padding = 6;
                } else {
                    itemHeight_2 = DEFAULT_HEIGHT_2_N1;
                    delta_padding = 8;
                }
            } else {
                itemWidth = 72;
                seperatorWidth = 1;
                itemHeight = 61;
                itemHeight_2 = DEFAULT_HEIGHT_2;
                delta_padding = 5;
            }
            this.mNumItem = 0;
            if (size < 4) {
                this.mNumItem = size;
                width = itemWidth * this.mNumItem;
            } else if (size < 6) {
                Configuration config = this.mContext.getResources().getConfiguration();
                if (config.orientation == 1) {
                    this.mNumItem = 4;
                    width = itemWidth * this.mNumItem;
                } else {
                    this.mNumItem = size;
                    width = itemWidth * this.mNumItem;
                }
            } else {
                Configuration config2 = this.mContext.getResources().getConfiguration();
                if (config2.orientation == 1) {
                    this.mNumItem = 4;
                    width = itemWidth * this.mNumItem;
                } else {
                    this.mNumItem = 6;
                    width = itemWidth * this.mNumItem;
                }
            }
            int width2 = ((int) TypedValue.applyDimension(1, width, dm)) + ((this.mNumItem - 1) * seperatorWidth);
            Rect outRect = new Rect(0, 0, 1080, 1080);
            if (this.mParent != null) {
                this.mParent.getWindowVisibleDisplayFrame(outRect);
            }
            int pWidth = outRect.width();
            if (pWidth != 0) {
                int widthAdapt = width2;
                if (widthAdapt / pWidth > MAX_RATE_PER_WIDTH) {
                    while (this.mNumItem > 0) {
                        this.mNumItem--;
                        widthAdapt = ((int) TypedValue.applyDimension(1, itemWidth * this.mNumItem, dm)) + ((this.mNumItem - 1) * seperatorWidth);
                        if (widthAdapt / pWidth <= MAX_RATE_PER_WIDTH) {
                            break;
                        }
                    }
                    if (this.mNumItem > 0) {
                        width2 = widthAdapt;
                    } else {
                        this.mNumItem = 1;
                        int width3 = itemWidth;
                        width2 = (int) TypedValue.applyDimension(1, width3, dm);
                    }
                }
            }
            if (this.mIsNormalMode) {
                this.mRect.right = this.mRect.left + width2;
                this.mRect.bottom = this.mRect.top + ((int) TypedValue.applyDimension(1, itemHeight, dm));
            } else {
                this.mRect.right = this.mRect.left + width2;
                this.mRect.bottom = this.mRect.top + ((int) TypedValue.applyDimension(1, itemHeight_2, dm));
            }
            int delta_padding2 = (int) TypedValue.applyDimension(1, delta_padding, dm);
            if (this.mPopupWindow != null) {
                this.mPopupWindow.setWidth(this.mRect.width() + (delta_padding2 * 2));
                this.mPopupWindow.setHeight(this.mRect.height() + (delta_padding2 * 2));
                if (this.mPopupView != null) {
                    this.mPopupView.setPadding(delta_padding2, delta_padding2, delta_padding2, delta_padding2);
                    if (this.mHorizontalListView != null) {
                        if (this.mHorizontalListView.getAdapter() != null) {
                            ((BaseAdapter) this.mHorizontalListView.getAdapter()).notifyDataSetChanged();
                        }
                        if (this.mMenu.mItemList.size() > this.mNumItem) {
                            this.mLeftEdgeEffect = this.mHorizontalListView.getLeftEdgeEffect();
                            this.mRightEdgeEffect = this.mHorizontalListView.getRightEdgeEffect();
                        }
                    }
                }
            }
        }
    }

    public SpenContextMenu(Context context, View parent, ArrayList<SpenContextMenuItemInfo> menu, ContextMenuListener selectListener) throws Resources.NotFoundException {
        int itemWidth;
        int seperatorWidth;
        int itemHeight;
        int itemHeight_2;
        int delta_padding;
        int numItem;
        int width;
        int id;
        this.mSelectListener = null;
        this.mIsNormalMode = true;
        this.mContext = context;
        if (context != null) {
            this.mAccessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            this.mIsViennaModel = false;
            if (Build.MODEL.contains("SM-P90")) {
                this.mIsViennaModel = true;
            }
            this.mRect = new Rect(0, 0, 310, 61);
            PackageManager manager = this.mContext.getPackageManager();
            try {
                this.mResourceSDK = manager.getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
            } catch (PackageManager.NameNotFoundException e) {
                this.mResourceSDK = null;
            }
            this.mMenu = new CMenu(null);
            this.mMenu.mItemList = menu;
            this.mIsNormalMode = isNormalMode();
            this.mSelectListener = selectListener;
            this.mParent = parent;
            this.mPopupView = null;
            RelativeLayout linearLayout = new RelativeLayout(context);
            new RelativeLayout.LayoutParams(-1, -1);
            Drawable shadowImage = null;
            if (this.mResourceSDK != null) {
                if (mType == 1) {
                    if (this.mIsViennaModel) {
                        id = this.mResourceSDK.getIdentifier(SHADOW_BORDER_VIENNA, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
                    } else {
                        id = this.mResourceSDK.getIdentifier(SHADOW_BORDER_N1, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
                    }
                    shadowImage = this.mResourceSDK.getDrawable(id);
                } else {
                    shadowImage = this.mResourceSDK.getDrawable(this.mResourceSDK.getIdentifier(SHADOW_BORDER, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME));
                }
            }
            if (SDK_VERSION < 16 && shadowImage != null) {
                linearLayout.setBackgroundDrawable(shadowImage);
            } else if (shadowImage != null) {
                linearLayout.setBackground(shadowImage);
            }
            Resources res = context.getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            int size = this.mMenu.mItemList.size();
            if (mType == 1) {
                itemWidth = DEFAULT_ITEM_WIDTH_N1;
                seperatorWidth = 2;
                itemHeight = 72;
                if (this.mIsViennaModel) {
                    itemHeight_2 = DEFAULT_HEIGHT_2_VIENNA;
                    delta_padding = 6;
                } else {
                    itemHeight_2 = DEFAULT_HEIGHT_2_N1;
                    delta_padding = 8;
                }
            } else {
                itemWidth = 72;
                seperatorWidth = 1;
                itemHeight = 61;
                itemHeight_2 = DEFAULT_HEIGHT_2;
                delta_padding = 5;
            }
            if (size < 4) {
                numItem = size;
                width = itemWidth * numItem;
            } else if (size < 6) {
                Configuration config = this.mContext.getResources().getConfiguration();
                if (config.orientation == 1) {
                    numItem = 4;
                    width = itemWidth * 4;
                } else {
                    numItem = size;
                    width = itemWidth * numItem;
                }
            } else {
                Configuration config2 = this.mContext.getResources().getConfiguration();
                if (config2.orientation == 1) {
                    numItem = 4;
                    width = itemWidth * 4;
                } else {
                    numItem = 6;
                    width = itemWidth * 6;
                }
            }
            int width2 = ((int) TypedValue.applyDimension(1, width, dm)) + ((numItem - 1) * seperatorWidth);
            Rect outRect = new Rect(0, 0, 1080, 1080);
            if (this.mParent != null) {
                this.mParent.getWindowVisibleDisplayFrame(outRect);
            }
            int pWidth = outRect.width();
            if (pWidth != 0) {
                int widthAdapt = width2;
                if (widthAdapt / pWidth > MAX_RATE_PER_WIDTH) {
                    while (numItem > 0) {
                        numItem--;
                        widthAdapt = ((int) TypedValue.applyDimension(1, itemWidth * numItem, dm)) + ((numItem - 1) * seperatorWidth);
                        if (widthAdapt / pWidth <= MAX_RATE_PER_WIDTH) {
                            break;
                        }
                    }
                    if (numItem > 0) {
                        width2 = widthAdapt;
                    } else {
                        int width3 = itemWidth;
                        width2 = (int) TypedValue.applyDimension(1, width3, dm);
                    }
                }
            }
            if (this.mIsNormalMode) {
                this.mRect.right = width2;
                this.mRect.bottom = (int) TypedValue.applyDimension(1, itemHeight, dm);
            } else {
                this.mRect.right = width2;
                this.mRect.bottom = (int) TypedValue.applyDimension(1, itemHeight_2, dm);
            }
            this.mHorizontalListView = new SpenHorizontalListView(context, null);
            this.mHorizontalListView.setListener(this.mSpenHorizontalListViewListener);
            ViewGroup.LayoutParams listLayoutParam = new ViewGroup.LayoutParams(-1, -1);
            this.mHorizontalListView.setLayoutParams(listLayoutParam);
            this.mHorizontalListView.setPadding(0, 0, 0, 0);
            this.mHorizontalListView.setFadingEdgeLength(0);
            this.mHorizontalListView.setVerticalScrollBarEnabled(false);
            this.mHorizontalListView.setOverScrollMode(0);
            this.mHorizontalListView.setAdapter((ListAdapter) new HAdapter());
            this.mHorizontalListView.setScrollBarStyle(0);
            linearLayout.addView(this.mHorizontalListView);
            int delta_padding2 = (int) TypedValue.applyDimension(1, delta_padding, dm);
            linearLayout.setPadding(delta_padding2, delta_padding2, delta_padding2, delta_padding2);
            this.mPopupView = linearLayout;
            this.mPopupWindow = new PopupWindow(this.mPopupView, this.mRect.width() + (delta_padding2 * 2), this.mRect.height() + (delta_padding2 * 2));
            this.mPopupWindow.setAnimationStyle(-1);
            this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources()));
            this.mPopupWindow.setOutsideTouchable(false);
            this.mPopupWindow.setFocusable(false);
            this.mPopupWindow.setTouchInterceptor(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.engine.SpenContextMenu.2
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent event) {
                    int action = event.getAction() & 255;
                    switch (action) {
                        case 0:
                            SpenContextMenu.this.mScrollFlag = false;
                            if (SpenContextMenu.this.mParent != null && (SpenContextMenu.this.mParent instanceof SpenControlBase)) {
                                SpenContextMenu.this.setFocusMenuItem(-1);
                            }
                            return false;
                        case 1:
                        default:
                            return false;
                        case 2:
                            if (SpenContextMenu.this.mDelay > 1000) {
                                SpenContextMenu.this.updateTimer(SpenContextMenu.this.mDelay);
                            }
                            return false;
                    }
                }
            });
        }
    }

    private boolean isNormalMode() {
        int viewWidth;
        String str;
        if (this.mMenu == null || this.mMenu.mItemList == null || this.mContext == null) {
            return true;
        }
        TextView textView = new TextView(this.mContext);
        RelativeLayout.LayoutParams textParam = new RelativeLayout.LayoutParams(-2, -2);
        textParam.addRule(14);
        if (mType == 1) {
            textView.setTextColor(Color.parseColor("#1e1e1e"));
            textView.setTextSize(1, 15.0f);
        } else {
            textView.setTextColor(-16777216);
            textView.setTextSize(1, 12.0f);
        }
        Paint paint = textView.getPaint();
        Resources res = this.mContext.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        if (mType == 1) {
            viewWidth = (int) TypedValue.applyDimension(1, 98.0f, dm);
        } else {
            viewWidth = (int) TypedValue.applyDimension(1, 72.0f, dm);
        }
        int viewWidth2 = viewWidth - (((int) TypedValue.applyDimension(1, 3.0f, dm)) * 2);
        for (int i = 0; i < this.mMenu.mItemList.size() && (str = ((SpenContextMenuItemInfo) this.mMenu.mItemList.get(i)).name) != null; i++) {
            int length = str.length();
            float[] widths = new float[length];
            int count = paint.getTextWidths(str, 0, length, widths);
            float width = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            for (int j = 0; j < count; j++) {
                width += widths[j];
            }
            if (viewWidth2 < width) {
                return false;
            }
        }
        return true;
    }

    public boolean close() {
        hide();
        return true;
    }

    public Rect getRect() {
        return this.mRect;
    }

    public void setRect(Rect rect) {
        this.mRect.set(rect);
    }

    public void setItemEnabled(int id, boolean enable) {
        if (this.mMenu != null && this.mMenu.mItemList != null) {
            Iterator it = this.mMenu.mItemList.iterator();
            while (it.hasNext()) {
                SpenContextMenuItemInfo contextMenuItemInfo = (SpenContextMenuItemInfo) it.next();
                if (contextMenuItemInfo.f393id == id) {
                    contextMenuItemInfo.enable = enable;
                }
            }
            if (this.mHorizontalListView.getAdapter() != null) {
                ((BaseAdapter) this.mHorizontalListView.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    public boolean getItemEnabled(int id) {
        if (this.mMenu == null) {
            return false;
        }
        Iterator it = this.mMenu.mItemList.iterator();
        while (it.hasNext()) {
            SpenContextMenuItemInfo contextMenuItemInfo = (SpenContextMenuItemInfo) it.next();
            if (contextMenuItemInfo.f393id == id) {
                return contextMenuItemInfo.enable;
            }
        }
        return false;
    }

    public void show() {
        if (this.mParent != null && this.mPopupWindow != null && this.mRect != null) {
            updateContextMenuLocation();
            if (this.mParent.getRight() > this.mRect.left + this.mPopupWindow.getWidth()) {
                this.mPopupWindow.update(this.mRect.left, this.mRect.top, this.mPopupWindow.getWidth(), this.mPopupWindow.getHeight());
                this.mPopupWindow.showAtLocation(this.mParent, 0, this.mRect.left, this.mRect.top);
            } else {
                int left = this.mParent.getRight() - this.mPopupWindow.getWidth();
                if (left < 0) {
                    left = 0;
                }
                this.mPopupWindow.update(this.mRect.left, this.mRect.top, this.mPopupWindow.getWidth(), this.mPopupWindow.getHeight());
                this.mPopupWindow.showAtLocation(this.mParent, 0, left, this.mRect.top);
            }
            playScrollAnimation(6);
        }
    }

    public boolean isShowing() {
        if (this.mPopupWindow != null) {
            return this.mPopupWindow.isShowing();
        }
        return false;
    }

    private void playScrollAnimation(int delay) {
        float lvWidth;
        if (this.mScrollTimer != null) {
            this.mScrollTimer.cancel();
        }
        if (this.mContext != null) {
            Resources res = this.mContext.getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            if (mType == 1) {
                float lvWidth2 = this.mMenu.mItemList.size() * DEFAULT_ITEM_WIDTH_N1;
                lvWidth = TypedValue.applyDimension(1, lvWidth2, dm) + ((this.mMenu.mItemList.size() - 1) * 2);
            } else {
                float lvWidth3 = this.mMenu.mItemList.size() * 72;
                lvWidth = TypedValue.applyDimension(1, lvWidth3, dm) + ((this.mMenu.mItemList.size() - 1) * 1);
            }
            final float lvWidth4 = lvWidth - this.mRect.width();
            final float step = TypedValue.applyDimension(1, 2.0f, dm);
            this.mScrollTimer = new Timer();
            this.mScrollTimer.scheduleAtFixedRate(new TimerTask() { // from class: com.samsung.android.sdk.pen.engine.SpenContextMenu.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Handler handler = SpenContextMenu.this.mHandler;
                    final float f = lvWidth4;
                    final float f2 = step;
                    handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.engine.SpenContextMenu.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            float pos = f - (SpenContextMenu.this.mCount * f2);
                            SpenContextMenu.this.mCount += 1.0f;
                            if (pos > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                                SpenContextMenu.this.mHorizontalListView.scrollTo((int) pos);
                                return;
                            }
                            SpenContextMenu.this.mHorizontalListView.scrollTo(0);
                            if (SpenContextMenu.this.mScrollTimer != null) {
                                SpenContextMenu.this.mScrollTimer.cancel();
                                SpenContextMenu.this.mScrollTimer = null;
                            }
                        }
                    });
                }
            }, 100L, delay);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTimer(int delay) {
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.samsung.android.sdk.pen.engine.SpenContextMenu.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SpenContextMenu.this.mHandler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.engine.SpenContextMenu.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SpenContextMenu.this.hide();
                    }
                });
            }
        }, delay);
    }

    public void show(int delay) {
        show();
        this.mDelay = delay;
        updateTimer(delay);
    }

    public void hide() {
        this.mPopupWindow.dismiss();
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mCount = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        if (this.mScrollTimer != null) {
            this.mScrollTimer.cancel();
            this.mScrollTimer = null;
        }
    }

    private class HAdapter extends BaseAdapter {
        private final View.OnClickListener mOnButtonClicked = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.engine.SpenContextMenu.HAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenContextMenu.this.mSelectListener != null && !SpenContextMenu.this.mScrollFlag) {
                    SpenContextMenu.this.mSelectListener.onSelected(v.getId());
                }
            }
        };

        public HAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return (SpenContextMenu.this.mMenu.mItemList.size() * 2) - 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return 0L;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"NewApi"})
        public View getView(int position, View convertView, ViewGroup parent) throws Resources.NotFoundException {
            int defaultWidth;
            int defaultHeight;
            int defaultHeight_2;
            int defaultSeperatorWidth;
            int width;
            int height;
            int delta_padding;
            int delta_padding2;
            boolean isNormalText;
            boolean isNormalText2;
            int delta_padding3;
            int height2;
            if (SpenContextMenu.this.mContext != null) {
                Resources res = SpenContextMenu.this.mContext.getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                LinearLayout linearLayout = new LinearLayout(SpenContextMenu.this.mContext);
                LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(-1, -1);
                layoutParam.setMargins(0, 0, 0, 0);
                linearLayout.setLayoutParams(layoutParam);
                linearLayout.setPadding(0, 0, 0, 0);
                linearLayout.setVisibility(0);
                if (SpenContextMenu.mType == 1) {
                    defaultWidth = SpenContextMenu.DEFAULT_ITEM_WIDTH_N1;
                    defaultHeight = 72;
                    if (SpenContextMenu.this.mIsViennaModel) {
                        defaultHeight_2 = SpenContextMenu.DEFAULT_HEIGHT_2_VIENNA;
                    } else {
                        defaultHeight_2 = SpenContextMenu.DEFAULT_HEIGHT_2_N1;
                    }
                    defaultSeperatorWidth = 2;
                } else {
                    defaultWidth = 72;
                    defaultHeight = 61;
                    defaultHeight_2 = SpenContextMenu.DEFAULT_HEIGHT_2;
                    defaultSeperatorWidth = 1;
                }
                if ((position + 1) % 2 == 0) {
                    ImageView imageView = new ImageView(SpenContextMenu.this.mContext);
                    if (SpenContextMenu.this.mIsNormalMode) {
                        height2 = (int) TypedValue.applyDimension(1, defaultHeight, dm);
                    } else {
                        height2 = (int) TypedValue.applyDimension(1, defaultHeight_2, dm);
                    }
                    ViewGroup.LayoutParams viewLayoutParams = new ViewGroup.LayoutParams(defaultSeperatorWidth, height2);
                    imageView.setLayoutParams(viewLayoutParams);
                    imageView.setPadding(0, 0, 0, 0);
                    if (SpenContextMenu.mType == 1 && !SpenContextMenu.this.mIsViennaModel) {
                        if (SpenContextMenu.SDK_VERSION < 16) {
                            imageView.setBackgroundDrawable(SpenContextMenu.this.mResourceSDK.getDrawable(SpenContextMenu.this.mResourceSDK.getIdentifier(SpenContextMenu.TW_QUICK_BUBBLE_DIVIDER_HOLO_LIGHT, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME)));
                        } else {
                            imageView.setBackground(SpenContextMenu.this.mResourceSDK.getDrawable(SpenContextMenu.this.mResourceSDK.getIdentifier(SpenContextMenu.TW_QUICK_BUBBLE_DIVIDER_HOLO_LIGHT, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME)));
                        }
                    } else {
                        imageView.setBackgroundColor(-7829368);
                    }
                    linearLayout.addView(imageView);
                    return linearLayout;
                }
                int index = position / 2;
                if (SpenContextMenu.this.mIsNormalMode) {
                    width = (int) TypedValue.applyDimension(1, defaultWidth, dm);
                    height = (int) TypedValue.applyDimension(1, defaultHeight, dm);
                } else {
                    width = (int) TypedValue.applyDimension(1, defaultWidth, dm);
                    height = (int) TypedValue.applyDimension(1, defaultHeight_2, dm);
                }
                RelativeLayout.LayoutParams buttonLayoutParams = new RelativeLayout.LayoutParams(width, height);
                RelativeLayout relativeLayout = new RelativeLayout(SpenContextMenu.this.mContext);
                relativeLayout.setLayoutParams(buttonLayoutParams);
                relativeLayout.setPadding(0, 0, 0, 0);
                if (SpenContextMenu.mType == 1) {
                    relativeLayout.setBackgroundColor(Color.rgb(255, 255, 255));
                } else {
                    relativeLayout.setBackgroundColor(Color.rgb(233, 235, 236));
                }
                relativeLayout.setClickable(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                relativeLayout.setFocusable(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                relativeLayout.setLongClickable(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                relativeLayout.setEnabled(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                StateListDrawable imageDrawable = new StateListDrawable();
                Drawable backgroundImage = ((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).drawableBackgroundPressed;
                if (backgroundImage == null) {
                    backgroundImage = SpenContextMenu.this.mResourceSDK.getDrawable(SpenContextMenu.this.mResourceSDK.getIdentifier(SpenContextMenu.QUICK_POPUP_BG_PRESS, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME));
                }
                imageDrawable.addState(new int[]{R.attr.state_pressed}, backgroundImage);
                Drawable backgroundImage2 = ((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).drawableBackgroundNormal;
                RelativeLayout.LayoutParams bgImageParam = new RelativeLayout.LayoutParams(-1, -1);
                int itemNum = (SpenContextMenu.this.mMenu.mItemList.size() - 1) * 2;
                if (position == 0 || position == itemNum) {
                    if (position == 0) {
                        SpenContextMenu.this.mBgImageLeftItem = SpenContextMenu.this.new CustomImageView(SpenContextMenu.this.mContext, 0);
                        SpenContextMenu.this.mBgImageLeftItem.setLayoutParams(bgImageParam);
                        SpenContextMenu.this.mBgImageLeftItem.setContentDescription(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).name);
                        if (SpenContextMenu.mType == 1) {
                            if (backgroundImage2 != null) {
                                if (SpenContextMenu.SDK_VERSION < 16) {
                                    SpenContextMenu.this.mBgImageLeftItem.setBackgroundDrawable(backgroundImage2);
                                } else {
                                    SpenContextMenu.this.mBgImageLeftItem.setBackground(backgroundImage2);
                                }
                            } else {
                                SpenContextMenu.this.mBgImageLeftItem.setBackgroundColor(Color.rgb(255, 255, 255));
                            }
                            if (SpenContextMenu.this.mIsViennaModel) {
                                delta_padding2 = 6;
                            } else {
                                delta_padding2 = 8;
                            }
                        } else {
                            if (backgroundImage2 != null) {
                                if (SpenContextMenu.SDK_VERSION < 16) {
                                    SpenContextMenu.this.mBgImageLeftItem.setBackgroundDrawable(backgroundImage2);
                                } else {
                                    SpenContextMenu.this.mBgImageLeftItem.setBackground(backgroundImage2);
                                }
                            } else {
                                SpenContextMenu.this.mBgImageLeftItem.setBackgroundColor(Color.rgb(233, 235, 236));
                            }
                            delta_padding2 = 5;
                        }
                        SpenContextMenu.this.mBgImageLeftItem.setClickable(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                        SpenContextMenu.this.mBgImageLeftItem.setFocusable(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                        SpenContextMenu.this.mBgImageLeftItem.setLongClickable(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                        SpenContextMenu.this.mBgImageLeftItem.setEnabled(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                        SpenContextMenu.this.mBgImageLeftItem.setImageDrawable(imageDrawable);
                        SpenContextMenu.this.mBgImageLeftItem.setPadding(-delta_padding2, -delta_padding2, -delta_padding2, -delta_padding2);
                        SpenContextMenu.this.mBgImageLeftItem.setId(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).f393id);
                        if (((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable) {
                            SpenContextMenu.this.mBgImageLeftItem.setOnClickListener(this.mOnButtonClicked);
                        }
                        SpenContextMenu.this.mBgImageLeftItem.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        SpenContextMenu.this.mBgImageLeftItem.setOnHoverListener(new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.engine.SpenContextMenu.HAdapter.2
                            @Override // android.view.View.OnHoverListener
                            public boolean onHover(View v, MotionEvent event) {
                                switch (event.getAction()) {
                                    case 9:
                                        SpenContextMenu.this.mBgImageLeftItem.drawTalkbackBorder(1);
                                        break;
                                    case 10:
                                        SpenContextMenu.this.mBgImageLeftItem.drawTalkbackBorder(2);
                                        break;
                                }
                                return false;
                            }
                        });
                        relativeLayout.addView(SpenContextMenu.this.mBgImageLeftItem);
                    }
                    if (position == itemNum) {
                        SpenContextMenu.this.mBgImageRightItem = SpenContextMenu.this.new CustomImageView(SpenContextMenu.this.mContext, 2);
                        SpenContextMenu.this.mBgImageRightItem.setLayoutParams(bgImageParam);
                        SpenContextMenu.this.mBgImageRightItem.setContentDescription(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).name);
                        if (SpenContextMenu.mType == 1) {
                            if (backgroundImage2 != null) {
                                if (SpenContextMenu.SDK_VERSION < 16) {
                                    SpenContextMenu.this.mBgImageRightItem.setBackgroundDrawable(backgroundImage2);
                                } else {
                                    SpenContextMenu.this.mBgImageRightItem.setBackground(backgroundImage2);
                                }
                            } else {
                                SpenContextMenu.this.mBgImageRightItem.setBackgroundColor(Color.rgb(255, 255, 255));
                            }
                            if (SpenContextMenu.this.mIsViennaModel) {
                                delta_padding = 6;
                            } else {
                                delta_padding = 8;
                            }
                        } else {
                            if (backgroundImage2 != null) {
                                if (SpenContextMenu.SDK_VERSION < 16) {
                                    SpenContextMenu.this.mBgImageRightItem.setBackgroundDrawable(backgroundImage2);
                                } else {
                                    SpenContextMenu.this.mBgImageRightItem.setBackground(backgroundImage2);
                                }
                            } else {
                                SpenContextMenu.this.mBgImageRightItem.setBackgroundColor(Color.rgb(233, 235, 236));
                            }
                            delta_padding = 5;
                        }
                        SpenContextMenu.this.mBgImageRightItem.setClickable(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                        SpenContextMenu.this.mBgImageRightItem.setFocusable(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                        SpenContextMenu.this.mBgImageRightItem.setLongClickable(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                        SpenContextMenu.this.mBgImageRightItem.setEnabled(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                        SpenContextMenu.this.mBgImageRightItem.setImageDrawable(imageDrawable);
                        SpenContextMenu.this.mBgImageRightItem.setPadding(-delta_padding, -delta_padding, -delta_padding, -delta_padding);
                        SpenContextMenu.this.mBgImageRightItem.setId(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).f393id);
                        if (((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable) {
                            SpenContextMenu.this.mBgImageRightItem.setOnClickListener(this.mOnButtonClicked);
                        }
                        SpenContextMenu.this.mBgImageRightItem.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        SpenContextMenu.this.mBgImageRightItem.setOnHoverListener(new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.engine.SpenContextMenu.HAdapter.3
                            @Override // android.view.View.OnHoverListener
                            public boolean onHover(View v, MotionEvent event) {
                                switch (event.getAction()) {
                                    case 9:
                                        SpenContextMenu.this.mBgImageRightItem.drawTalkbackBorder(1);
                                        break;
                                    case 10:
                                        SpenContextMenu.this.mBgImageRightItem.drawTalkbackBorder(2);
                                        break;
                                }
                                return false;
                            }
                        });
                        relativeLayout.addView(SpenContextMenu.this.mBgImageRightItem);
                    }
                } else {
                    CustomImageView bgImage = SpenContextMenu.this.new CustomImageView(SpenContextMenu.this.mContext);
                    bgImage.setLayoutParams(bgImageParam);
                    bgImage.setContentDescription(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).name);
                    if (SpenContextMenu.mType == 1) {
                        if (backgroundImage2 != null) {
                            if (SpenContextMenu.SDK_VERSION < 16) {
                                bgImage.setBackgroundDrawable(backgroundImage2);
                            } else {
                                bgImage.setBackground(backgroundImage2);
                            }
                        } else {
                            bgImage.setBackgroundColor(Color.rgb(255, 255, 255));
                        }
                        if (SpenContextMenu.this.mIsViennaModel) {
                            delta_padding3 = 6;
                        } else {
                            delta_padding3 = 8;
                        }
                    } else {
                        if (backgroundImage2 != null) {
                            if (SpenContextMenu.SDK_VERSION < 16) {
                                bgImage.setBackgroundDrawable(backgroundImage2);
                            } else {
                                bgImage.setBackground(backgroundImage2);
                            }
                        } else {
                            bgImage.setBackgroundColor(Color.rgb(233, 235, 236));
                        }
                        delta_padding3 = 5;
                    }
                    bgImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    int delta_padding4 = (int) TypedValue.applyDimension(1, delta_padding3, dm);
                    bgImage.setClickable(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                    bgImage.setFocusable(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                    bgImage.setLongClickable(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                    bgImage.setEnabled(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable);
                    bgImage.setImageDrawable(imageDrawable);
                    bgImage.setPadding(-delta_padding4, -delta_padding4, -delta_padding4, -delta_padding4);
                    bgImage.setId(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).f393id);
                    if (((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable) {
                        bgImage.setOnClickListener(this.mOnButtonClicked);
                    }
                    bgImage.setOnHoverListener(new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.engine.SpenContextMenu.HAdapter.4
                        @Override // android.view.View.OnHoverListener
                        public boolean onHover(View view, MotionEvent event) {
                            switch (event.getAction()) {
                                case 9:
                                    ((CustomImageView) view).drawTalkbackBorder(1);
                                    break;
                                case 10:
                                    ((CustomImageView) view).drawTalkbackBorder(2);
                                    break;
                            }
                            return false;
                        }
                    });
                    relativeLayout.addView(bgImage);
                }
                ImageView image = new ImageView(SpenContextMenu.this.mContext);
                image.setId(10);
                if (!((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable) {
                    image.setImageDrawable(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).drawableDisableItem);
                } else {
                    image.setImageDrawable(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).drawableNormalItem);
                }
                image.setVisibility(0);
                RelativeLayout.LayoutParams imageParam = new RelativeLayout.LayoutParams(-2, -2);
                if (SpenContextMenu.mType == 1) {
                    imageParam.leftMargin = (int) TypedValue.applyDimension(1, 33.0f, dm);
                    imageParam.topMargin = (int) TypedValue.applyDimension(1, 8.0f, dm);
                    if (!SpenContextMenu.this.mIsNormalMode) {
                        if (SpenContextMenu.this.mIsViennaModel) {
                            imageParam.bottomMargin = (int) TypedValue.applyDimension(1, 56.0f, dm);
                        } else {
                            imageParam.bottomMargin = (int) TypedValue.applyDimension(1, 52.0f, dm);
                        }
                    } else {
                        imageParam.bottomMargin = (int) TypedValue.applyDimension(1, 32.0f, dm);
                    }
                } else {
                    imageParam.leftMargin = (int) TypedValue.applyDimension(1, 20.0f, dm);
                    imageParam.topMargin = (int) TypedValue.applyDimension(1, 8.0f, dm);
                    if (SpenContextMenu.this.mIsNormalMode) {
                        imageParam.bottomMargin = (int) TypedValue.applyDimension(1, 21.0f, dm);
                    } else {
                        imageParam.bottomMargin = (int) TypedValue.applyDimension(1, 38.0f, dm);
                    }
                }
                imageParam.addRule(6);
                imageParam.addRule(14);
                image.setLayoutParams(imageParam);
                relativeLayout.addView(image);
                TextView text = new TextView(SpenContextMenu.this.mContext);
                RelativeLayout.LayoutParams textParam = new RelativeLayout.LayoutParams(-1, -2);
                textParam.addRule(14);
                textParam.addRule(12, image.getId());
                if (SpenContextMenu.mType == 1) {
                    textParam.leftMargin = (int) TypedValue.applyDimension(1, 3.0f, dm);
                    textParam.rightMargin = (int) TypedValue.applyDimension(1, 3.0f, dm);
                    textParam.topMargin = (int) TypedValue.applyDimension(1, 10.0f, dm);
                    text.setTextColor(Color.parseColor("#1e1e1e"));
                    text.setTextSize(1, 15.0f);
                    if (!SpenContextMenu.this.mIsNormalMode) {
                        String str = ((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).name;
                        if (str != null) {
                            float[] widths = new float[str.length()];
                            Paint paint = text.getPaint();
                            int c = paint.getTextWidths(str, 0, str.length(), widths);
                            float textWidth = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                            for (int i = 0; i < c; i++) {
                                textWidth += widths[i];
                            }
                            int viewWidth = (int) TypedValue.applyDimension(1, 98.0f, dm);
                            if (textWidth < viewWidth - (((int) TypedValue.applyDimension(1, 3.0f, dm)) * 2)) {
                                isNormalText2 = true;
                            } else {
                                isNormalText2 = false;
                            }
                            textParam.bottomMargin = (int) TypedValue.applyDimension(1, 7.0f, dm);
                            text.setSingleLine(false);
                            text.setLineSpacing((int) TypedValue.applyDimension(1, 4.0f, dm), 1.0f);
                            if (SpenContextMenu.this.mIsViennaModel) {
                                text.setPadding(0, 0, 0, (int) TypedValue.applyDimension(1, -4.0f, dm));
                            } else {
                                text.setPadding(0, 0, 0, (int) TypedValue.applyDimension(1, -9.0f, dm));
                            }
                            if (isNormalText2) {
                                text.setText(String.valueOf(str) + "\n");
                            } else {
                                text.setText(str);
                            }
                        }
                    } else {
                        textParam.bottomMargin = (int) TypedValue.applyDimension(1, 7.0f, dm);
                        text.setText(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).name);
                    }
                } else {
                    textParam.leftMargin = (int) TypedValue.applyDimension(1, 3.0f, dm);
                    textParam.rightMargin = (int) TypedValue.applyDimension(1, 3.0f, dm);
                    textParam.topMargin = (int) TypedValue.applyDimension(1, 2.0f, dm);
                    text.setTextColor(-16777216);
                    text.setTextSize(1, 12.0f);
                    if (!SpenContextMenu.this.mIsNormalMode) {
                        String str2 = ((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).name;
                        if (str2 != null) {
                            float[] widths2 = new float[str2.length()];
                            Paint paint2 = text.getPaint();
                            int c2 = paint2.getTextWidths(str2, 0, str2.length(), widths2);
                            float textWidth2 = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                            for (int i2 = 0; i2 < c2; i2++) {
                                textWidth2 += widths2[i2];
                            }
                            int viewWidth2 = (int) TypedValue.applyDimension(1, 72.0f, dm);
                            if (textWidth2 < viewWidth2 - (((int) TypedValue.applyDimension(1, 3.0f, dm)) * 2)) {
                                isNormalText = true;
                            } else {
                                isNormalText = false;
                            }
                            textParam.bottomMargin = (int) TypedValue.applyDimension(1, 5.0f, dm);
                            text.setSingleLine(false);
                            text.setLineSpacing((int) TypedValue.applyDimension(1, 3.0f, dm), 0.75f);
                            text.setPadding(0, 0, 0, (int) TypedValue.applyDimension(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, dm));
                            if (isNormalText) {
                                text.setText(String.valueOf(str2) + "\n");
                            } else {
                                text.setText(str2);
                            }
                        }
                    } else {
                        textParam.bottomMargin = (int) TypedValue.applyDimension(1, 5.0f, dm);
                        text.setText(((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).name);
                    }
                }
                if (!((SpenContextMenuItemInfo) SpenContextMenu.this.mMenu.mItemList.get(index)).enable) {
                    text.setAlpha(0.3f);
                }
                text.setEllipsize(TextUtils.TruncateAt.END);
                text.setMaxLines(2);
                text.setLayoutParams(textParam);
                text.setGravity(1);
                relativeLayout.addView(text);
                linearLayout.addView(relativeLayout);
                relativeLayout.setFocusable(true);
                linearLayout.setId(240784 + index);
                return linearLayout;
            }
            Log.e("SpenContextMenu", "mContext is NULL at position = " + position);
            return null;
        }
    }

    protected View setFocusMenuItem(int i) {
        View v = null;
        int count = 0;
        if (i == -1) {
            if (this.mParent != null && (this.mParent instanceof SpenControlBase)) {
                ((SpenControlBase) this.mParent).requestFocus();
            }
            return null;
        }
        for (int t = 0; t < this.mHorizontalListView.getChildCount(); t++) {
            v = this.mHorizontalListView.getChildAt(t);
            String id = new StringBuilder(String.valueOf(v.getId())).toString();
            if (id.contains("2407")) {
                if (count == i) {
                    LinearLayout linearLayout = (LinearLayout) v;
                    linearLayout.getChildAt(0).setBackgroundColor(Color.rgb(200, 200, 200));
                } else {
                    LinearLayout linearLayout2 = (LinearLayout) v;
                    linearLayout2.getChildAt(0).setBackgroundColor(Color.rgb(233, 235, 236));
                }
                count++;
            }
        }
        if (i >= this.mNumItem) {
            v = this.mHorizontalListView.getChildAt(this.mHorizontalListView.getChildCount() - 1);
            LinearLayout linearLayout3 = (LinearLayout) v;
            linearLayout3.getChildAt(0).setBackgroundColor(Color.rgb(200, 200, 200));
        }
        return v;
    }

    protected void handleSelectMenuItem(int index) {
        if (this.mSelectListener != null) {
            this.mSelectListener.onSelected(((SpenContextMenuItemInfo) this.mMenu.mItemList.get(index)).f393id);
        }
    }

    protected int getCountMenuItem() {
        return this.mMenu.mItemList.size();
    }

    protected void scrollToMenuItem(int index) {
        float position;
        if (index < this.mNumItem) {
            this.mHorizontalListView.scrollTo(0);
            return;
        }
        Resources res = this.mContext.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        if (mType == 1) {
            float position2 = ((index + 1) - this.mNumItem) * DEFAULT_ITEM_WIDTH_N1;
            position = TypedValue.applyDimension(1, position2, dm) + (((index + 1) - this.mNumItem) * 2);
        } else {
            float position3 = ((index + 1) - this.mNumItem) * 72;
            position = TypedValue.applyDimension(1, position3, dm) + (((index + 1) - this.mNumItem) * 1);
        }
        this.mHorizontalListView.scrollTo((int) position);
    }
}
