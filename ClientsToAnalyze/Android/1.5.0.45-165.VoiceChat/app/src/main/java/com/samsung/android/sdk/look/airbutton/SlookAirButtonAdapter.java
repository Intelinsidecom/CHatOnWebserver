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

    public SlookAirButtonAdapter(ArrayList<AirButtonItem> itemList) {
        addItem(itemList);
    }

    public void addItem(AirButtonItem item) {
        if (this.mItemList == null) {
            this.mItemList = new ArrayList<>();
        }
        this.mItemList.add(item);
    }

    public int addItem(ArrayList<AirButtonItem> itemList) {
        if (this.mItemList != null) {
            this.mItemList.clear();
        }
        this.mItemList = itemList;
        return this.mItemList.size() - 1;
    }

    public void insertItem(int index, AirButtonItem item) {
        if (this.mItemList == null) {
            if (index == 0) {
                addItem(item);
                return;
            }
            throw new IllegalArgumentException("The list is empty.");
        }
        this.mItemList.add(index, item);
    }

    public void removeItem(int index) {
        if (this.mItemList == null) {
            throw new IllegalArgumentException("The list is empty.");
        }
        this.mItemList.remove(index);
    }

    public void updateItem(int index, AirButtonItem item) {
        if (this.mItemList == null) {
            throw new IllegalArgumentException("The list is empty.");
        }
        this.mItemList.set(index, item);
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

    public AirButtonItem getItem(int idx) {
        if (this.mItemList == null || idx >= this.mItemList.size()) {
            return null;
        }
        return this.mItemList.get(idx);
    }

    public void setEmptyText(CharSequence text) {
        this.mEmptyText = text;
    }

    public CharSequence getEmptyText() {
        return this.mEmptyText;
    }

    public boolean onHoverEnter(View parentView) {
        return true;
    }

    public void onHoverExit(View parentView) {
    }

    public void onShow(View parentView) {
    }

    public void onHide(View parentView) {
    }

    public void onDismiss(View parentView) {
    }

    public static class AirButtonItem {
        private View mView = null;
        private Drawable mImage = null;
        private String mDescription = null;
        private String mSubDescription = null;
        private Object mData = null;

        public AirButtonItem(View view, Object data) {
            set(view, data);
        }

        public AirButtonItem(Drawable image, String description, Object data) {
            set(image, description, data);
        }

        public AirButtonItem(Drawable image, String description, String subDescription, Object data) {
            set(image, description, subDescription, data);
        }

        public void set(View view, Object data) {
            this.mView = view;
            this.mData = data;
        }

        public void set(Drawable image, String description, Object data) {
            this.mImage = image;
            this.mDescription = description;
            this.mData = data;
        }

        public void set(Drawable image, String description, String subDescription, Object data) {
            this.mImage = image;
            this.mDescription = description;
            this.mSubDescription = subDescription;
            this.mData = data;
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
