package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EdgeEffect;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes.dex */
class SpenHorizontalListView extends AdapterView<ListAdapter> {
    protected ListAdapter mAdapter;
    protected int mCurrentX;
    private boolean mDataChanged;
    private final DataSetObserver mDataObserver;
    private int mDisplayOffset;
    private GestureDetector mGesture;
    private boolean mIsEdgeLeft;
    private EdgeEffect mLeftEdgeEffect;
    private int mLeftViewIndex;
    private Listener mListener;
    private int mMaxX;
    protected int mNextX;
    private final GestureDetector.OnGestureListener mOnGesture;
    private AdapterView.OnItemClickListener mOnItemClicked;
    private AdapterView.OnItemLongClickListener mOnItemLongClicked;
    private AdapterView.OnItemSelectedListener mOnItemSelected;
    private final Queue<View> mRemovedViewQueue;
    private EdgeEffect mRightEdgeEffect;
    private int mRightViewIndex;
    protected Scroller mScroller;

    public interface Listener {
        void onScrolll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);
    }

    protected synchronized boolean isEdgeLeft() {
        return this.mIsEdgeLeft;
    }

    protected synchronized boolean isEdgeRight() {
        return !this.mIsEdgeLeft;
    }

    protected synchronized EdgeEffect getLeftEdgeEffect() {
        return this.mLeftEdgeEffect;
    }

    protected synchronized EdgeEffect getRightEdgeEffect() {
        return this.mRightEdgeEffect;
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public SpenHorizontalListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mLeftViewIndex = -1;
        this.mRightViewIndex = 0;
        this.mMaxX = SpenObjectBase.SPEN_INFINITY_INT;
        this.mDisplayOffset = 0;
        this.mRemovedViewQueue = new LinkedList();
        this.mDataChanged = false;
        this.mDataObserver = new DataSetObserver() { // from class: com.samsung.android.sdk.pen.engine.SpenHorizontalListView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                synchronized (SpenHorizontalListView.this) {
                    SpenHorizontalListView.this.mDataChanged = true;
                }
                SpenHorizontalListView.this.invalidate();
                SpenHorizontalListView.this.requestLayout();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                SpenHorizontalListView.this.reset();
                SpenHorizontalListView.this.invalidate();
                SpenHorizontalListView.this.requestLayout();
            }
        };
        this.mOnGesture = new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.sdk.pen.engine.SpenHorizontalListView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent e) {
                return SpenHorizontalListView.this.onDown(e);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return SpenHorizontalListView.this.onFling(e1, e2, velocityX, velocityY);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                synchronized (SpenHorizontalListView.this) {
                    int childCount = SpenHorizontalListView.this.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        SpenHorizontalListView.this.getChildAt(i).setPressed(false);
                    }
                    SpenHorizontalListView.this.mNextX += (int) distanceX;
                    if (SpenHorizontalListView.this.mNextX <= 0) {
                        SpenHorizontalListView.this.mIsEdgeLeft = true;
                        if (SpenHorizontalListView.this.mLeftEdgeEffect != null) {
                            SpenHorizontalListView.this.mLeftEdgeEffect.onPull(0.3f);
                        }
                    }
                    if (SpenHorizontalListView.this.mNextX >= SpenHorizontalListView.this.mMaxX) {
                        SpenHorizontalListView.this.mIsEdgeLeft = false;
                        if (SpenHorizontalListView.this.mRightEdgeEffect != null) {
                            SpenHorizontalListView.this.mRightEdgeEffect.onPull(0.3f);
                        }
                    }
                }
                SpenHorizontalListView.this.requestLayout();
                if (SpenHorizontalListView.this.mListener != null) {
                    SpenHorizontalListView.this.mListener.onScrolll(e1, e2, distanceX, distanceY);
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e) {
                for (int i = 0; i < SpenHorizontalListView.this.getChildCount(); i++) {
                    View child = SpenHorizontalListView.this.getChildAt(i);
                    if (isEventWithinView(e, child)) {
                        if (SpenHorizontalListView.this.mOnItemClicked != null) {
                            SpenHorizontalListView.this.mOnItemClicked.onItemClick(SpenHorizontalListView.this, child, SpenHorizontalListView.this.mLeftViewIndex + 1 + i, SpenHorizontalListView.this.mAdapter.getItemId(SpenHorizontalListView.this.mLeftViewIndex + 1 + i));
                        }
                        if (SpenHorizontalListView.this.mOnItemSelected != null) {
                            SpenHorizontalListView.this.mOnItemSelected.onItemSelected(SpenHorizontalListView.this, child, SpenHorizontalListView.this.mLeftViewIndex + 1 + i, SpenHorizontalListView.this.mAdapter.getItemId(SpenHorizontalListView.this.mLeftViewIndex + 1 + i));
                            return true;
                        }
                        return true;
                    }
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent e) {
                int childCount = SpenHorizontalListView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View child = SpenHorizontalListView.this.getChildAt(i);
                    if (isEventWithinView(e, child)) {
                        if (SpenHorizontalListView.this.mOnItemLongClicked != null) {
                            SpenHorizontalListView.this.mOnItemLongClicked.onItemLongClick(SpenHorizontalListView.this, child, SpenHorizontalListView.this.mLeftViewIndex + 1 + i, SpenHorizontalListView.this.mAdapter.getItemId(SpenHorizontalListView.this.mLeftViewIndex + 1 + i));
                            return;
                        }
                        return;
                    }
                }
            }

            private boolean isEventWithinView(MotionEvent e, View child) {
                Rect viewRect = new Rect();
                int[] childPosition = new int[2];
                child.getLocationOnScreen(childPosition);
                int left = childPosition[0];
                int right = left + child.getWidth();
                int top = childPosition[1];
                int bottom = top + child.getHeight();
                viewRect.set(left, top, right, bottom);
                return viewRect.contains((int) e.getRawX(), (int) e.getRawY());
            }
        };
        initView();
    }

    private synchronized void initView() {
        this.mLeftViewIndex = -1;
        this.mRightViewIndex = 0;
        this.mDisplayOffset = 0;
        this.mCurrentX = 0;
        this.mNextX = 0;
        this.mMaxX = SpenObjectBase.SPEN_INFINITY_INT;
        this.mScroller = new Scroller(getContext());
        this.mGesture = new GestureDetector(getContext(), this.mOnGesture);
        this.mGesture.setIsLongpressEnabled(false);
        this.mIsEdgeLeft = false;
        if (this.mLeftEdgeEffect == null) {
            this.mLeftEdgeEffect = new EdgeEffect(getContext());
        }
        if (this.mRightEdgeEffect == null) {
            this.mRightEdgeEffect = new EdgeEffect(getContext());
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener listener) {
        this.mOnItemSelected = listener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.mOnItemClicked = listener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener listener) {
        this.mOnItemLongClicked = listener;
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter adapter) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataObserver);
        }
        this.mAdapter = adapter;
        this.mAdapter.registerDataSetObserver(this.mDataObserver);
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void reset() {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public void setSelection(int position) {
    }

    private void addAndMeasureChild(View child, int viewPos) {
        ViewGroup.LayoutParams params = child.getLayoutParams();
        if (params == null) {
            params = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(child, viewPos, params, true);
        child.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.mAdapter != null) {
            if (this.mDataChanged) {
                int oldCurrentX = this.mCurrentX;
                initView();
                removeAllViewsInLayout();
                this.mNextX = oldCurrentX;
                this.mDataChanged = false;
            }
            if (this.mScroller.computeScrollOffset()) {
                int scrollx = this.mScroller.getCurrX();
                this.mNextX = scrollx;
            }
            if (this.mNextX <= 0) {
                this.mNextX = 0;
                this.mIsEdgeLeft = true;
                this.mScroller.forceFinished(true);
            }
            if (this.mNextX >= this.mMaxX) {
                this.mNextX = this.mMaxX;
                this.mIsEdgeLeft = false;
                this.mScroller.forceFinished(true);
            }
            int dx = this.mCurrentX - this.mNextX;
            removeNonVisibleItems(dx);
            fillList(dx);
            positionItems(dx);
            this.mCurrentX = this.mNextX;
            checkScroller();
        }
    }

    private void checkScroller() {
        if (!this.mScroller.isFinished()) {
            post(new Runnable() { // from class: com.samsung.android.sdk.pen.engine.SpenHorizontalListView.3
                @Override // java.lang.Runnable
                public void run() {
                    SpenHorizontalListView.this.requestLayout();
                }
            });
        }
    }

    private void fillList(int dx) {
        int edge = 0;
        View child = getChildAt(getChildCount() - 1);
        if (child != null) {
            edge = child.getRight();
        }
        fillListRight(edge, dx);
        int edge2 = 0;
        View child2 = getChildAt(0);
        if (child2 != null) {
            edge2 = child2.getLeft();
        }
        fillListLeft(edge2, dx);
    }

    private void fillListRight(int rightEdge, int dx) {
        View child;
        while (rightEdge + dx < getWidth() && this.mRightViewIndex < this.mAdapter.getCount() && (child = this.mAdapter.getView(this.mRightViewIndex, this.mRemovedViewQueue.poll(), this)) != null) {
            addAndMeasureChild(child, -1);
            rightEdge += child.getMeasuredWidth();
            if (this.mRightViewIndex == this.mAdapter.getCount() - 1) {
                if (rightEdge + dx < getWidth() && rightEdge > getWidth()) {
                    int itemWidth = 72;
                    if (SpenContextMenu.getType() == 1) {
                        itemWidth = 98;
                    }
                    this.mMaxX = ((this.mRightViewIndex / 2) + 1) * itemWidth;
                    Resources res = getContext().getResources();
                    DisplayMetrics dm = res.getDisplayMetrics();
                    this.mMaxX = (int) TypedValue.applyDimension(1, this.mMaxX, dm);
                    this.mMaxX += (this.mRightViewIndex * itemWidth) / 2;
                    this.mMaxX -= getWidth();
                } else {
                    this.mMaxX = (this.mCurrentX + rightEdge) - getWidth();
                }
            }
            if (this.mMaxX < 0) {
                this.mMaxX = 0;
            }
            this.mRightViewIndex++;
        }
    }

    private void fillListLeft(int leftEdge, int dx) {
        View child;
        while (leftEdge + dx > 0 && this.mLeftViewIndex >= 0 && (child = this.mAdapter.getView(this.mLeftViewIndex, this.mRemovedViewQueue.poll(), this)) != null) {
            addAndMeasureChild(child, 0);
            leftEdge -= child.getMeasuredWidth();
            this.mLeftViewIndex--;
            this.mDisplayOffset -= child.getMeasuredWidth();
        }
    }

    private void removeNonVisibleItems(int dx) {
        View child = getChildAt(0);
        while (child != null && child.getRight() + dx <= 0) {
            this.mDisplayOffset += child.getMeasuredWidth();
            this.mRemovedViewQueue.offer(child);
            removeViewInLayout(child);
            this.mLeftViewIndex++;
            child = getChildAt(0);
        }
        View child2 = getChildAt(getChildCount() - 1);
        while (child2 != null && child2.getLeft() + dx >= getWidth()) {
            this.mRemovedViewQueue.offer(child2);
            removeViewInLayout(child2);
            this.mRightViewIndex--;
            child2 = getChildAt(getChildCount() - 1);
        }
    }

    private void positionItems(int dx) {
        if (getChildCount() > 0) {
            this.mDisplayOffset += dx;
            int left = this.mDisplayOffset;
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                int childWidth = child.getMeasuredWidth();
                child.layout(left, 0, left + childWidth, child.getMeasuredHeight());
                left += childWidth;
            }
        }
    }

    public synchronized void scrollTo(int x) {
        this.mScroller.startScroll(this.mNextX, 0, x - this.mNextX, 0, 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public synchronized boolean dispatchTouchEvent(MotionEvent ev) {
        boolean handled;
        handled = super.dispatchTouchEvent(ev);
        return this.mGesture == null ? handled : handled | this.mGesture.onTouchEvent(ev);
    }

    protected boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        synchronized (this) {
            if (this.mIsEdgeLeft) {
                this.mLeftEdgeEffect.onPull(0.3f);
            } else {
                this.mRightEdgeEffect.onPull(0.3f);
            }
            this.mScroller.fling(this.mNextX, 0, (int) (-velocityX), 0, 0, this.mMaxX, 0, 0);
        }
        requestLayout();
        return true;
    }

    private void releaseEdgeEffect() {
        this.mIsEdgeLeft = false;
        this.mLeftEdgeEffect.onRelease();
        this.mRightEdgeEffect.onRelease();
    }

    protected synchronized boolean onDown(MotionEvent e) {
        releaseEdgeEffect();
        this.mScroller.forceFinished(true);
        return true;
    }
}
