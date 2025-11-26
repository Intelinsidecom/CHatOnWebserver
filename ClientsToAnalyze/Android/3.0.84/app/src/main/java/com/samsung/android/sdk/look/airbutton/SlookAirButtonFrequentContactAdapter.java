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
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class SlookAirButtonFrequentContactAdapter extends SlookAirButtonAdapter {
    public static final String DATA = "data";
    public static final String DISPLAY_NAME = "display_name";

    /* renamed from: ID */
    public static final String f451ID = "id";
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

    public SlookAirButtonFrequentContactAdapter(View view, Bundle bundle) {
        boolean z;
        this.mMaxCount = 15;
        this.DEBUG = false;
        if (isSupport(1)) {
            if (bundle != null) {
                String string = bundle.getString("MIME_TYPE");
                this.mSelectionSb = new StringBuilder();
                if (string != null) {
                    this.mSelectionSb.append("view_data.");
                    this.mSelectionSb.append("mimetype");
                    this.mSelectionSb.append("='");
                    this.mSelectionSb.append(string);
                    this.mSelectionSb.append("'");
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = bundle.getBoolean("PRIVATE", false);
                if (!z2) {
                    if (z) {
                        this.mSelectionSb.append(" and ");
                    }
                    this.mSelectionSb.append("is_private=0");
                }
                String string2 = bundle.getString("extra_condition");
                if (string2 != null) {
                    if (z || !z2) {
                        this.mSelectionSb.append(" and ");
                    }
                    this.mSelectionSb.append(string2);
                }
            }
            this.mMaxCount = SlookResourceManager.getInt(2);
            this.DEBUG = true;
            this.mContext = view.getContext();
            setEmptyText("No contact list to add");
        }
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public void onShow(View view) {
        updateData();
        this.mIsShowing = true;
        super.onShow(view);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public void onHide(View view) {
        this.mIsShowing = false;
        this.mNeedUpdate = true;
        this.mData.clear();
        super.onHide(view);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public void onDismiss(View view) {
        this.mIsShowing = false;
        this.mNeedUpdate = true;
        this.mData.clear();
        super.onDismiss(view);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public int getCount() {
        return this.mCount;
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public SlookAirButtonAdapter.AirButtonItem getItem(int i) throws Resources.NotFoundException {
        Drawable bitmapDrawable;
        Bundle bundle = this.mData.get(i);
        String string = bundle.getString(DISPLAY_NAME);
        String string2 = bundle.getString(DATA);
        byte[] byteArray = bundle.getByteArray(PHOTO);
        if (byteArray == null) {
            bitmapDrawable = this.mContext.getResources().getDrawable(SlookResourceManager.getDrawableId(1));
        } else {
            bitmapDrawable = new BitmapDrawable(this.mContext.getResources(), BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));
        }
        return new SlookAirButtonAdapter.AirButtonItem(bitmapDrawable, string, string2, bundle);
    }

    private synchronized void updateData() {
        if (this.mNeedUpdate && !this.mIsShowing) {
            this.mNeedUpdate = false;
            this.mData.clear();
            Cursor cursorQuery = this.mContext.getContentResolver().query(Uri.parse("content://com.android.contacts/contacts/frequent_data"), new String[]{"_id", DISPLAY_NAME, PHOTO_URI, "data15", "lookup", "mimetype", "data1", "is_private"}, this.mSelectionSb != null ? this.mSelectionSb.toString() : null, null, "_id LIMIT " + this.mMaxCount);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putInt("id", cursorQuery.getInt(0));
                        bundle.putString(DISPLAY_NAME, cursorQuery.getString(1));
                        bundle.putString(PHOTO_URI, cursorQuery.getString(2));
                        bundle.putByteArray(PHOTO, cursorQuery.getBlob(3));
                        bundle.putString(LOOKUP_KEY, cursorQuery.getString(4));
                        bundle.putString("MIME_TYPE", cursorQuery.getString(5));
                        bundle.putString(DATA, cursorQuery.getString(6));
                        bundle.putBoolean("is_private", cursorQuery.getInt(7) == 1);
                        this.mData.add(bundle);
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
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

    private boolean isSupport(int i) {
        if (this.mSlook.getVersionCode() >= i) {
            return true;
        }
        Log.e(TAG, "This is not supported in device");
        return false;
    }
}
