package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.sec.chaton.C0229at;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private int mActivePointerId;
    private PagerAdapter mAdapter;
    private float mBaseLineFlingVelocity;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCurItem;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFlingVelocityInfluence;
    private boolean mInLayout;
    private float mInitialMotionX;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private EdgeEffectCompat mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private PagerAdapter.DataSetObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private int mPageMargin;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffectCompat mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrolling;
    private boolean mScrollingCacheEnabled;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private static final Comparator COMPARATOR = new Comparator() { // from class: android.support.v4.view.ViewPager.1
        @Override // java.util.Comparator
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.position - itemInfo2.position;
        }
    };
    private static final Interpolator sInterpolator = new Interpolator() { // from class: android.support.v4.view.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2) + 1.0f;
        }
    };

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    class ItemInfo {
        Object object;
        int position;
        boolean scrolling;

        ItemInfo() {
        }
    }

    public class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.mItems = new ArrayList();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mScrollState = 0;
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItems = new ArrayList();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mScrollState = 0;
        initViewPager();
    }

    void initViewPager() {
        setWillNotDraw(DEBUG);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffectCompat(context);
        this.mRightEdge = new EdgeEffectCompat(context);
        this.mBaseLineFlingVelocity = context.getResources().getDisplayMetrics().density * 2500.0f;
        this.mFlingVelocityInfluence = 0.4f;
    }

    private void setScrollState(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
            if (this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageScrollStateChanged(i);
            }
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.mAdapter != null) {
            this.mAdapter.setDataSetObserver(null);
            this.mAdapter.startUpdate(this);
            for (int i = 0; i < this.mItems.size(); i++) {
                ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
                this.mAdapter.destroyItem(this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate(this);
            this.mItems.clear();
            removeAllViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        this.mAdapter = pagerAdapter;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new DataSetObserver();
            }
            this.mAdapter.setDataSetObserver(this.mObserver);
            this.mPopulatePending = DEBUG;
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, DEBUG, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
                return;
            }
            populate();
        }
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    public void setCurrentItem(int i) {
        this.mPopulatePending = DEBUG;
        setCurrentItemInternal(i, !this.mFirstLayout, DEBUG);
    }

    public void setCurrentItem(int i, boolean z) {
        this.mPopulatePending = DEBUG;
        setCurrentItemInternal(i, z, DEBUG);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        if (this.mAdapter == null || this.mAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(DEBUG);
            return;
        }
        if (!z2 && this.mCurItem == i && this.mItems.size() != 0) {
            setScrollingCacheEnabled(DEBUG);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.mAdapter.getCount()) {
            i = this.mAdapter.getCount() - 1;
        }
        int i3 = this.mOffscreenPageLimit;
        if (i > this.mCurItem + i3 || i < this.mCurItem - i3) {
            for (int i4 = 0; i4 < this.mItems.size(); i4++) {
                ((ItemInfo) this.mItems.get(i4)).scrolling = true;
            }
        }
        boolean z3 = this.mCurItem != i;
        this.mCurItem = i;
        populate();
        int width = (getWidth() + this.mPageMargin) * i;
        if (z) {
            smoothScrollTo(width, 0, i2);
            if (z3 && this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageSelected(i);
                return;
            }
            return;
        }
        if (z3 && this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        completeScroll();
        scrollTo(width, 0);
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w(TAG, "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int width = getWidth();
        recomputeScrollPosition(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null ? true : DEBUG);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable) || drawable == this.mMarginDrawable) {
            return true;
        }
        return DEBUG;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
    }

    void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 0);
    }

    void smoothScrollTo(int i, int i2, int i3) {
        int i4;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(DEBUG);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = i - scrollX;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            completeScroll();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        this.mScrolling = true;
        setScrollState(2);
        int iAbs = (int) ((Math.abs(i5) / (getWidth() + this.mPageMargin)) * 100.0f);
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            i4 = (int) (((iAbs / (iAbs2 / this.mBaseLineFlingVelocity)) * this.mFlingVelocityInfluence) + iAbs);
        } else {
            i4 = iAbs + 100;
        }
        this.mScroller.startScroll(scrollX, scrollY, i5, i6, Math.min(i4, MAX_SETTLE_DURATION));
        invalidate();
    }

    void addNewItem(int i, int i2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = i;
        itemInfo.object = this.mAdapter.instantiateItem(this, i);
        if (i2 < 0) {
            this.mItems.add(itemInfo);
        } else {
            this.mItems.add(i2, itemInfo);
        }
    }

    void dataSetChanged() {
        int i;
        int iMax;
        boolean z;
        boolean z2 = true;
        int i2 = 0;
        int i3 = -1;
        boolean z3 = this.mItems.size() < 3 && this.mItems.size() < this.mAdapter.getCount();
        while (i2 < this.mItems.size()) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition == -1) {
                i = i2;
                iMax = i3;
                z = z3;
            } else if (itemPosition == -2) {
                this.mItems.remove(i2);
                int i4 = i2 - 1;
                this.mAdapter.destroyItem(this, itemInfo.position, itemInfo.object);
                if (this.mCurItem == itemInfo.position) {
                    i = i4;
                    iMax = Math.max(0, Math.min(this.mCurItem, this.mAdapter.getCount() - 1));
                    z = true;
                } else {
                    i = i4;
                    iMax = i3;
                    z = true;
                }
            } else if (itemInfo.position != itemPosition) {
                if (itemInfo.position == this.mCurItem) {
                    i3 = itemPosition;
                }
                itemInfo.position = itemPosition;
                i = i2;
                iMax = i3;
                z = true;
            } else {
                i = i2;
                iMax = i3;
                z = z3;
            }
            z3 = z;
            i3 = iMax;
            i2 = i + 1;
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (i3 >= 0) {
            setCurrentItemInternal(i3, DEBUG, true);
        } else {
            z2 = z3;
        }
        if (z2) {
            populate();
            requestLayout();
        }
    }

    void populate() {
        ItemInfo itemInfo;
        if (this.mAdapter != null && !this.mPopulatePending && getWindowToken() != null) {
            this.mAdapter.startUpdate(this);
            int i = this.mOffscreenPageLimit;
            int iMax = Math.max(0, this.mCurItem - i);
            int iMin = Math.min(this.mAdapter.getCount() - 1, i + this.mCurItem);
            int i2 = 0;
            int i3 = -1;
            while (i2 < this.mItems.size()) {
                ItemInfo itemInfo2 = (ItemInfo) this.mItems.get(i2);
                if ((itemInfo2.position < iMax || itemInfo2.position > iMin) && !itemInfo2.scrolling) {
                    this.mItems.remove(i2);
                    i2--;
                    this.mAdapter.destroyItem(this, itemInfo2.position, itemInfo2.object);
                } else if (i3 < iMin && itemInfo2.position > iMax) {
                    int i4 = i3 + 1;
                    if (i4 < iMax) {
                        i4 = iMax;
                    }
                    while (i4 <= iMin && i4 < itemInfo2.position) {
                        addNewItem(i4, i2);
                        i4++;
                        i2++;
                    }
                }
                int i5 = i2;
                int i6 = itemInfo2.position;
                int i7 = i5 + 1;
                i3 = i6;
                i2 = i7;
            }
            int i8 = this.mItems.size() > 0 ? ((ItemInfo) this.mItems.get(this.mItems.size() - 1)).position : -1;
            if (i8 < iMin) {
                int i9 = i8 + 1;
                if (i9 <= iMax) {
                    i9 = iMax;
                }
                while (i9 <= iMin) {
                    addNewItem(i9, -1);
                    i9++;
                }
            }
            int i10 = 0;
            while (true) {
                if (i10 < this.mItems.size()) {
                    if (((ItemInfo) this.mItems.get(i10)).position != this.mCurItem) {
                        i10++;
                    } else {
                        itemInfo = (ItemInfo) this.mItems.get(i10);
                        break;
                    }
                } else {
                    itemInfo = null;
                    break;
                }
            }
            this.mAdapter.setPrimaryItem(this, this.mCurItem, itemInfo != null ? itemInfo.object : null);
            this.mAdapter.finishUpdate(this);
            if (hasFocus()) {
                View viewFindFocus = findFocus();
                ItemInfo itemInfoInfoForAnyChild = viewFindFocus != null ? infoForAnyChild(viewFindFocus) : null;
                if (itemInfoInfoForAnyChild == null || itemInfoInfoForAnyChild.position != this.mCurItem) {
                    for (int i11 = 0; i11 < getChildCount(); i11++) {
                        View childAt = getChildAt(i11);
                        ItemInfo itemInfoInfoForChild = infoForChild(childAt);
                        if (itemInfoInfoForChild != null && itemInfoInfoForChild.position == this.mCurItem && childAt.requestFocus(2)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks() { // from class: android.support.v4.view.ViewPager.SavedState.1
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        if (this.mAdapter != null) {
            savedState.adapterState = this.mAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.mAdapter != null) {
            this.mAdapter.restoreState(savedState.adapterState, savedState.loader);
            setCurrentItemInternal(savedState.position, DEBUG, true);
        } else {
            this.mRestoredCurItem = savedState.position;
            this.mRestoredAdapterState = savedState.adapterState;
            this.mRestoredClassLoader = savedState.loader;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.mInLayout) {
            addViewInLayout(view, i, layoutParams);
            view.measure(this.mChildWidthMeasureSpec, this.mChildHeightMeasureSpec);
        } else {
            super.addView(view, i, layoutParams);
        }
    }

    ItemInfo infoForChild(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mItems.size()) {
                ItemInfo itemInfo = (ItemInfo) this.mItems.get(i2);
                if (!this.mAdapter.isViewFromObject(view, itemInfo.object)) {
                    i = i2 + 1;
                } else {
                    return itemInfo;
                }
            } else {
                return null;
            }
        }
    }

    ItemInfo infoForAnyChild(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return infoForChild(view);
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = DEBUG;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                childAt.measure(this.mChildWidthMeasureSpec, this.mChildHeightMeasureSpec);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            recomputeScrollPosition(i, i3, this.mPageMargin, this.mPageMargin);
        }
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        int i5 = i + i3;
        if (i2 > 0) {
            int scrollX = getScrollX();
            int i6 = (int) ((((scrollX % r1) / (i2 + i4)) + (scrollX / r1)) * i5);
            scrollTo(i6, getScrollY());
            if (!this.mScroller.isFinished()) {
                this.mScroller.startScroll(i6, 0, i5 * this.mCurItem, 0, this.mScroller.getDuration() - this.mScroller.timePassed());
                return;
            }
            return;
        }
        int i7 = this.mCurItem * i5;
        if (i7 != getScrollX()) {
            completeScroll();
            scrollTo(i7, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ItemInfo itemInfoInfoForChild;
        this.mInLayout = true;
        populate();
        this.mInLayout = DEBUG;
        int childCount = getChildCount();
        int i5 = i3 - i;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (itemInfoInfoForChild = infoForChild(childAt)) != null) {
                int paddingLeft = (itemInfoInfoForChild.position * (this.mPageMargin + i5)) + getPaddingLeft();
                int paddingTop = getPaddingTop();
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
            }
        }
        this.mFirstLayout = DEBUG;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
            if (this.mOnPageChangeListener != null) {
                int width = getWidth() + this.mPageMargin;
                int i = currX / width;
                int i2 = currX % width;
                this.mOnPageChangeListener.onPageScrolled(i, i2 / width, i2);
            }
            invalidate();
            return;
        }
        completeScroll();
    }

    private void completeScroll() {
        boolean z = this.mScrolling;
        if (z) {
            setScrollingCacheEnabled(DEBUG);
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
            setScrollState(0);
        }
        this.mPopulatePending = DEBUG;
        this.mScrolling = DEBUG;
        boolean z2 = z;
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
            if (itemInfo.scrolling) {
                z2 = true;
                itemInfo.scrolling = DEBUG;
            }
        }
        if (z2) {
            populate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (action == 3 || action == 1) {
            this.mIsBeingDragged = DEBUG;
            this.mIsUnableToDrag = DEBUG;
            this.mActivePointerId = -1;
            return DEBUG;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return DEBUG;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                this.mLastMotionY = motionEvent.getY();
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                if (this.mScrollState == 2) {
                    this.mIsBeingDragged = true;
                    this.mIsUnableToDrag = DEBUG;
                    setScrollState(1);
                    break;
                } else {
                    completeScroll();
                    this.mIsBeingDragged = DEBUG;
                    this.mIsUnableToDrag = DEBUG;
                    break;
                }
            case 2:
                int i = this.mActivePointerId;
                if (i != -1) {
                    int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
                    float x2 = MotionEventCompat.getX(motionEvent, iFindPointerIndex);
                    float f = x2 - this.mLastMotionX;
                    float fAbs = Math.abs(f);
                    float y = MotionEventCompat.getY(motionEvent, iFindPointerIndex);
                    float fAbs2 = Math.abs(y - this.mLastMotionY);
                    int scrollX = getScrollX();
                    if ((f <= 0.0f || scrollX != 0) && f < 0.0f && this.mAdapter != null && scrollX >= ((this.mAdapter.getCount() - 1) * getWidth()) - 1) {
                    }
                    if (!canScroll(this, DEBUG, (int) f, (int) x2, (int) y)) {
                        if (fAbs > this.mTouchSlop && fAbs > fAbs2) {
                            this.mIsBeingDragged = true;
                            setScrollState(1);
                            this.mLastMotionX = x2;
                            setScrollingCacheEnabled(true);
                            break;
                        } else if (fAbs2 > this.mTouchSlop) {
                            this.mIsUnableToDrag = true;
                            break;
                        }
                    } else {
                        this.mLastMotionX = x2;
                        this.mInitialMotionX = x2;
                        this.mLastMotionY = y;
                        return DEBUG;
                    }
                }
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        return this.mIsBeingDragged;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        float f;
        boolean zOnRelease = DEBUG;
        if (this.mFakeDragging) {
            return true;
        }
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || this.mAdapter == null || this.mAdapter.getCount() == 0) {
            return DEBUG;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                completeScroll();
                float x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                break;
            case 1:
                if (this.mIsBeingDragged) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
                    this.mPopulatePending = true;
                    int scrollX = getScrollX() / (getWidth() + this.mPageMargin);
                    if (xVelocity <= 0) {
                        scrollX++;
                    }
                    setCurrentItemInternal(scrollX, true, true, xVelocity);
                    this.mActivePointerId = -1;
                    endDrag();
                    zOnRelease = this.mLeftEdge.onRelease() | this.mRightEdge.onRelease();
                    break;
                }
                break;
            case 2:
                if (!this.mIsBeingDragged) {
                    int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                    float x2 = MotionEventCompat.getX(motionEvent, iFindPointerIndex);
                    float fAbs = Math.abs(x2 - this.mLastMotionX);
                    float fAbs2 = Math.abs(MotionEventCompat.getY(motionEvent, iFindPointerIndex) - this.mLastMotionY);
                    if (fAbs > this.mTouchSlop && fAbs > fAbs2) {
                        this.mIsBeingDragged = true;
                        this.mLastMotionX = x2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                    }
                }
                if (this.mIsBeingDragged) {
                    float x3 = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId));
                    float f2 = this.mLastMotionX - x3;
                    this.mLastMotionX = x3;
                    float scrollX2 = getScrollX() + f2;
                    int width = getWidth();
                    int i = width + this.mPageMargin;
                    int count = this.mAdapter.getCount() - 1;
                    float fMax = Math.max(0, (this.mCurItem - 1) * i);
                    float fMin = Math.min(this.mCurItem + 1, count) * i;
                    if (scrollX2 < fMax) {
                        if (fMax == 0.0f) {
                            zOnRelease = this.mLeftEdge.onPull((-scrollX2) / width);
                        }
                        z = zOnRelease;
                        f = fMax;
                    } else if (scrollX2 > fMin) {
                        if (fMin == count * i) {
                            zOnRelease = this.mRightEdge.onPull((scrollX2 - fMin) / width);
                        }
                        z = zOnRelease;
                        f = fMin;
                    } else {
                        z = false;
                        f = scrollX2;
                    }
                    this.mLastMotionX += f - ((int) f);
                    scrollTo((int) f, getScrollY());
                    if (this.mOnPageChangeListener != null) {
                        int i2 = ((int) f) / i;
                        int i3 = ((int) f) % i;
                        this.mOnPageChangeListener.onPageScrolled(i2, i3 / i, i3);
                    }
                    zOnRelease = z;
                    break;
                }
                break;
            case 3:
                if (this.mIsBeingDragged) {
                    setCurrentItemInternal(this.mCurItem, true, true);
                    this.mActivePointerId = -1;
                    endDrag();
                    zOnRelease = this.mLeftEdge.onRelease() | this.mRightEdge.onRelease();
                    break;
                }
                break;
            case 5:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mLastMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                this.mLastMotionX = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId));
                break;
        }
        if (zOnRelease) {
            invalidate();
        }
        return true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean zDraw = DEBUG;
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        if (overScrollMode == 0 || (overScrollMode == 1 && this.mAdapter != null && this.mAdapter.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), 0.0f);
                this.mLeftEdge.setSize(height, getWidth());
                zDraw = false | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.mRightEdge.isFinished()) {
                int iSave2 = canvas.save();
                int width = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int count = this.mAdapter != null ? this.mAdapter.getCount() : 1;
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), ((-count) * (this.mPageMargin + width)) + this.mPageMargin);
                this.mRightEdge.setSize(height2, width);
                zDraw |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (zDraw) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            int i = scrollX % (this.mPageMargin + width);
            if (i != 0) {
                int i2 = (scrollX - i) + width;
                this.mMarginDrawable.setBounds(i2, 0, this.mPageMargin + i2, getHeight());
                this.mMarginDrawable.draw(canvas);
            }
        }
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return DEBUG;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        this.mFakeDragBeginTime = jUptimeMillis;
        return true;
    }

    public void endFakeDrag() {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int yVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.mActivePointerId);
        this.mPopulatePending = true;
        if (Math.abs(yVelocity) <= this.mMinimumVelocity && Math.abs(this.mInitialMotionX - this.mLastMotionX) < getWidth() / 3) {
            setCurrentItemInternal(this.mCurItem, true, true);
        } else if (this.mLastMotionX > this.mInitialMotionX) {
            setCurrentItemInternal(this.mCurItem - 1, true, true);
        } else {
            setCurrentItemInternal(this.mCurItem + 1, true, true);
        }
        endDrag();
        this.mFakeDragging = DEBUG;
    }

    public void fakeDragBy(float f) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        this.mLastMotionX += f;
        float scrollX = getScrollX() - f;
        int width = getWidth() + this.mPageMargin;
        float fMax = Math.max(0, (this.mCurItem - 1) * width);
        float fMin = Math.min(this.mCurItem + 1, this.mAdapter.getCount() - 1) * width;
        if (scrollX >= fMax) {
            fMax = scrollX > fMin ? fMin : scrollX;
        }
        this.mLastMotionX += fMax - ((int) fMax);
        scrollTo((int) fMax, getScrollY());
        if (this.mOnPageChangeListener != null) {
            int i = ((int) fMax) / width;
            int i2 = ((int) fMax) % width;
            this.mOnPageChangeListener.onPageScrolled(i, i2 / width, i2);
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = MotionEventCompat.getX(motionEvent, i);
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = DEBUG;
        this.mIsUnableToDrag = DEBUG;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom() && canScroll(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z && ViewCompat.canScrollHorizontally(view, -i)) {
            return true;
        }
        return DEBUG;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent)) {
            return true;
        }
        return DEBUG;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return DEBUG;
        }
        switch (keyEvent.getKeyCode()) {
            case C0229at.HorizontalSrollView_android_fitsSystemWindows /* 21 */:
                break;
            case C0229at.HorizontalSrollView_android_scrollbars /* 22 */:
                break;
            case 61:
                if (!KeyEventCompat.hasNoModifiers(keyEvent)) {
                    if (KeyEventCompat.hasModifiers(keyEvent, 1)) {
                        break;
                    }
                } else {
                    break;
                }
                break;
        }
        return DEBUG;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean arrowScroll(int r6) {
        /*
            r5 = this;
            r4 = 66
            r3 = 17
            android.view.View r0 = r5.findFocus()
            if (r0 != r5) goto Lb
            r0 = 0
        Lb:
            r1 = 0
            android.view.FocusFinder r2 = android.view.FocusFinder.getInstance()
            android.view.View r2 = r2.findNextFocus(r5, r0, r6)
            if (r2 == 0) goto L51
            if (r2 == r0) goto L51
            if (r6 != r3) goto L39
            if (r0 == 0) goto L34
            int r1 = r2.getLeft()
            int r0 = r0.getLeft()
            if (r1 < r0) goto L34
            boolean r0 = r5.pageLeft()
        L2a:
            if (r0 == 0) goto L33
            int r1 = android.view.SoundEffectConstants.getContantForFocusDirection(r6)
            r5.playSoundEffect(r1)
        L33:
            return r0
        L34:
            boolean r0 = r2.requestFocus()
            goto L2a
        L39:
            if (r6 != r4) goto L65
            if (r0 == 0) goto L4c
            int r1 = r2.getLeft()
            int r0 = r0.getLeft()
            if (r1 > r0) goto L4c
            boolean r0 = r5.pageRight()
            goto L2a
        L4c:
            boolean r0 = r2.requestFocus()
            goto L2a
        L51:
            if (r6 == r3) goto L56
            r0 = 1
            if (r6 != r0) goto L5b
        L56:
            boolean r0 = r5.pageLeft()
            goto L2a
        L5b:
            if (r6 == r4) goto L60
            r0 = 2
            if (r6 != r0) goto L65
        L60:
            boolean r0 = r5.pageRight()
            goto L2a
        L65:
            r0 = r1
            goto L2a
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.arrowScroll(int):boolean");
    }

    boolean pageLeft() {
        if (this.mCurItem <= 0) {
            return DEBUG;
        }
        setCurrentItem(this.mCurItem - 1, true);
        return true;
    }

    boolean pageRight() {
        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.getCount() - 1) {
            return DEBUG;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i, int i2) {
        ItemInfo itemInfoInfoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (itemInfoInfoForChild = infoForChild(childAt)) != null && itemInfoInfoForChild.position == this.mCurItem) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
                arrayList.add(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList arrayList) {
        ItemInfo itemInfoInfoForChild;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (itemInfoInfoForChild = infoForChild(childAt)) != null && itemInfoInfoForChild.position == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        ItemInfo itemInfoInfoForChild;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (itemInfoInfoForChild = infoForChild(childAt)) != null && itemInfoInfoForChild.position == this.mCurItem && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return DEBUG;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo itemInfoInfoForChild;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (itemInfoInfoForChild = infoForChild(childAt)) != null && itemInfoInfoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return DEBUG;
    }

    class DataSetObserver implements PagerAdapter.DataSetObserver {
        private DataSetObserver() {
        }

        @Override // android.support.v4.view.PagerAdapter.DataSetObserver
        public void onDataSetChanged() {
            ViewPager.this.dataSetChanged();
        }
    }
}
