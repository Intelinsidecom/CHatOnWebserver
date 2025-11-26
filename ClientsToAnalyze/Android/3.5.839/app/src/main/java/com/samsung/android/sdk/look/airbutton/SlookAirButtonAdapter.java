package com.samsung.android.sdk.look.airbutton;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SlookAirButtonAdapter {
    private CharSequence mEmptyText;
    private ArrayList<AirButtonItem> mItemList = null;

    public SlookAirButtonAdapter() {
    }

    public SlookAirButtonAdapter(ArrayList<AirButtonItem> arrayList) {
        addItem(arrayList);
    }

    public void addItem(AirButtonItem airButtonItem) {
        if (this.mItemList == null) {
            this.mItemList = new ArrayList<>();
        }
        this.mItemList.add(airButtonItem);
    }

    public int addItem(ArrayList<AirButtonItem> arrayList) {
        if (this.mItemList != null) {
            this.mItemList.clear();
        }
        this.mItemList = arrayList;
        return this.mItemList.size() - 1;
    }

    public void insertItem(int i, AirButtonItem airButtonItem) {
        if (this.mItemList == null) {
            if (i == 0) {
                addItem(airButtonItem);
                return;
            }
            throw new IllegalArgumentException("The list is empty.");
        }
        this.mItemList.add(i, airButtonItem);
    }

    public void removeItem(int i) {
        if (this.mItemList == null) {
            throw new IllegalArgumentException("The list is empty.");
        }
        this.mItemList.remove(i);
    }

    public void updateItem(int i, AirButtonItem airButtonItem) {
        if (this.mItemList == null) {
            throw new IllegalArgumentException("The list is empty.");
        }
        this.mItemList.set(i, airButtonItem);
    }

    public void clear() {
        if (this.mItemList != null) {
            this.mItemList.clear();
        }
    }

    public int getCount() {
        if (this.mItemList == null) {
            return 0;
        }
        return this.mItemList.size();
    }

    public AirButtonItem getItem(int i) {
        if (this.mItemList == null || i >= this.mItemList.size()) {
            return null;
        }
        return this.mItemList.get(i);
    }

    public void setEmptyText(CharSequence charSequence) {
        this.mEmptyText = charSequence;
    }

    public CharSequence getEmptyText() {
        return this.mEmptyText;
    }

    public boolean onHoverEnter(View view) {
        return true;
    }

    public void onHoverExit(View view) {
    }

    public void onShow(View view) {
    }

    public void onHide(View view) {
    }

    public void onDismiss(View view) {
    }

    public class AirButtonItem {
        private View mView = null;
        private Drawable mImage = null;
        private String mDescription = null;
        private String mSubDescription = null;
        private Object mData = null;

        public AirButtonItem(View view, Object obj) {
            set(view, obj);
        }

        public AirButtonItem(Drawable drawable, String str, Object obj) {
            set(drawable, str, obj);
        }

        public AirButtonItem(Drawable drawable, String str, String str2, Object obj) {
            set(drawable, str, str2, obj);
        }

        public void set(View view, Object obj) {
            this.mView = view;
            this.mData = obj;
        }

        public void set(Drawable drawable, String str, Object obj) {
            this.mImage = drawable;
            this.mDescription = str;
            this.mData = obj;
        }

        public void set(Drawable drawable, String str, String str2, Object obj) {
            this.mImage = drawable;
            this.mDescription = str;
            this.mSubDescription = str2;
            this.mData = obj;
        }

        public View getView() {
            return this.mView;
        }

        public Drawable getImage() {
            return this.mImage;
        }

        public String getDescription() {
            return this.mDescription;
        }

        public String getSubDescription() {
            return this.mSubDescription;
        }

        public Object getData() {
            return this.mData;
        }
    }
}
