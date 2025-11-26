package android.support.v4.view;

import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;
    private DataSetObserver mObserver;

    interface DataSetObserver {
        void onDataSetChanged();
    }

    public abstract void destroyItem(View view, int i, Object obj);

    public abstract void finishUpdate(View view);

    public abstract int getCount();

    public abstract Object instantiateItem(View view, int i);

    public abstract boolean isViewFromObject(View view, Object obj);

    public abstract void restoreState(Parcelable parcelable, ClassLoader classLoader);

    public abstract Parcelable saveState();

    public abstract void startUpdate(View view);

    public void setPrimaryItem(View view, int i, Object obj) {
    }

    public int getItemPosition(Object obj) {
        return -1;
    }

    public void notifyDataSetChanged() {
        if (this.mObserver != null) {
            this.mObserver.onDataSetChanged();
        }
    }

    void setDataSetObserver(DataSetObserver dataSetObserver) {
        this.mObserver = dataSetObserver;
    }
}
