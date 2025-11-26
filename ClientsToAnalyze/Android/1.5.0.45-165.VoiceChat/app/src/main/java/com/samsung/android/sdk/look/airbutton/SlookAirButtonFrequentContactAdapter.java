package com.samsung.android.sdk.look.airbutton;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.sdk.look.SlookResourceManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter;
import com.sds.coolots.common.controller.DatabaseHelper;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class SlookAirButtonFrequentContactAdapter extends SlookAirButtonAdapter {
    public static final String DATA = "data";
    public static final String DISPLAY_NAME = "display_name";

    /* renamed from: ID */
    public static final String f391ID = "id";
    public static final String LOOKUP_KEY = "lookup_key";
    public static final String PHOTO = "photo";
    public static final String PHOTO_URI = "photo_uri";
    private static final String TAG = "AirButtonFrequentContactAdapter";
    private boolean DEBUG;
    private Context mContext;
    private int mMaxCount;
    private StringBuilder mSelectionSb;
    private final String FREQUENT_URI = "content://com.android.contacts/contacts/frequent_data";
    private final String MIME_TYPE = "MIME_TYPE";
    private final String EMAIL = "vnd.android.cursor.item/email_v2";
    private final String PHONE = "vnd.android.cursor.item/phone_v2";
    private final String IS_PRIVATE = "is_private";
    private final String EXTRA_CONDITION = "extra_condition";
    private ArrayList<Bundle> mData = new ArrayList<>();
    private Slook mSlook = new Slook();
    private boolean mIsShowing = false;
    private boolean mNeedUpdate = true;
    private int mCount = 0;

    public SlookAirButtonFrequentContactAdapter(View view, Bundle option) {
        this.mMaxCount = 15;
        this.DEBUG = false;
        if (isSupport(1)) {
            if (option != null) {
                String mimeType = option.getString("MIME_TYPE");
                this.mSelectionSb = new StringBuilder();
                boolean isMimeType = false;
                if (mimeType != null) {
                    this.mSelectionSb.append("view_data.");
                    this.mSelectionSb.append("mimetype");
                    this.mSelectionSb.append("='");
                    this.mSelectionSb.append(mimeType);
                    this.mSelectionSb.append("'");
                    isMimeType = true;
                }
                boolean isPrivate = option.getBoolean("PRIVATE", false);
                if (!isPrivate) {
                    if (isMimeType) {
                        this.mSelectionSb.append(" and ");
                    }
                    this.mSelectionSb.append("is_private=0");
                }
                String selection = option.getString("extra_condition");
                if (selection != null) {
                    if (isMimeType || !isPrivate) {
                        this.mSelectionSb.append(" and ");
                    }
                    this.mSelectionSb.append(selection);
                }
            }
            this.mMaxCount = SlookResourceManager.getInt(2);
            this.DEBUG = true;
            this.mContext = view.getContext();
            setEmptyText("No contact list to add");
        }
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public void onShow(View parentView) {
        updateData();
        this.mIsShowing = true;
        super.onShow(parentView);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public void onHide(View parentView) {
        this.mIsShowing = false;
        this.mNeedUpdate = true;
        this.mData.clear();
        super.onHide(parentView);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public void onDismiss(View parentView) {
        this.mIsShowing = false;
        this.mNeedUpdate = true;
        this.mData.clear();
        super.onDismiss(parentView);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public int getCount() {
        return this.mCount;
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public SlookAirButtonAdapter.AirButtonItem getItem(int idx) throws Resources.NotFoundException {
        Drawable drawable;
        Bundle bundle = this.mData.get(idx);
        String name = bundle.getString(DISPLAY_NAME);
        String data = bundle.getString(DATA);
        byte[] photo = bundle.getByteArray(PHOTO);
        if (photo == null) {
            int resourceId = SlookResourceManager.getDrawableId(1);
            drawable = this.mContext.getResources().getDrawable(resourceId);
        } else {
            drawable = new BitmapDrawable(this.mContext.getResources(), BitmapFactory.decodeByteArray(photo, 0, photo.length));
        }
        return new SlookAirButtonAdapter.AirButtonItem(drawable, name, data, bundle);
    }

    private synchronized void updateData() {
        if (this.mNeedUpdate && !this.mIsShowing) {
            this.mNeedUpdate = false;
            this.mData.clear();
            String[] PROJECTION = {DatabaseHelper.KEY_ROWID, DISPLAY_NAME, PHOTO_URI, "data15", "lookup", "mimetype", "data1", "is_private"};
            Uri frequentDataUri = Uri.parse("content://com.android.contacts/contacts/frequent_data");
            Cursor c = this.mContext.getContentResolver().query(frequentDataUri, PROJECTION, this.mSelectionSb != null ? this.mSelectionSb.toString() : null, null, "_id LIMIT " + this.mMaxCount);
            if (c != null) {
                while (c.moveToNext()) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putInt("id", c.getInt(0));
                        bundle.putString(DISPLAY_NAME, c.getString(1));
                        bundle.putString(PHOTO_URI, c.getString(2));
                        bundle.putByteArray(PHOTO, c.getBlob(3));
                        bundle.putString(LOOKUP_KEY, c.getString(4));
                        bundle.putString("MIME_TYPE", c.getString(5));
                        bundle.putString(DATA, c.getString(6));
                        bundle.putBoolean("is_private", c.getInt(7) == 1);
                        this.mData.add(bundle);
                    } finally {
                        if (c != null) {
                            c.close();
                        }
                    }
                }
                try {
                    this.mCount = this.mData.size();
                } catch (NoSuchMethodError e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isSupport(int ver) {
        if (this.mSlook.getVersionCode() >= ver) {
            return true;
        }
        Log.e(TAG, "This is not supported in device");
        return false;
    }
}
