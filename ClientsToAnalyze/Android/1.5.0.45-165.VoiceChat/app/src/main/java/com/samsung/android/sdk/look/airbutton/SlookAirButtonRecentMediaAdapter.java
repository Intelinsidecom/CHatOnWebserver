package com.samsung.android.sdk.look.airbutton;

import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.sdk.look.SlookResourceManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter;
import com.sds.coolots.common.controller.DatabaseHelper;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class SlookAirButtonRecentMediaAdapter extends SlookAirButtonAdapter {
    public static final String AUDIO_TYPE = "audio";

    /* renamed from: ID */
    private static final String f392ID = "id";
    public static final String IMAGE_TYPE = "image";
    private static final String MIME_TYPE = "mime_type";
    private static final String TAG = "AirButtonRecentMediaAdapter";
    private static final String TITLE = "title";
    public static final String VIDEO_TYPE = "video";
    private static final String VOLUME = "external";
    private boolean DEBUG;
    private Context mContext;
    private String mFilter;
    private int mMaxCount;
    private ArrayList<Bundle> mData = new ArrayList<>();
    private Slook mSlook = new Slook();
    private boolean mIsShowing = false;
    private boolean mNeedUpdate = true;
    private int mCount = 0;

    public SlookAirButtonRecentMediaAdapter(View view, Bundle option) {
        this.mMaxCount = 15;
        this.DEBUG = false;
        if (isSupport(1)) {
            this.mContext = view.getContext();
            this.mFilter = getFilter(option);
            this.DEBUG = true;
            this.mMaxCount = SlookResourceManager.getInt(3);
            setEmptyText("No medias to add");
        }
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public SlookAirButtonAdapter.AirButtonItem getItem(int idx) throws Resources.NotFoundException {
        Bundle bundle = this.mData.get(idx);
        int id = bundle.getInt("id");
        int media_type = bundle.getInt(MIME_TYPE);
        String title = bundle.getString("title");
        Drawable thumbnail = getThumbNail(id, media_type, title);
        Uri uri = getUri(id, media_type);
        return new SlookAirButtonAdapter.AirButtonItem(thumbnail, null, uri);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public int getCount() {
        return this.mCount;
    }

    private Drawable getThumbNail(int id, int media_type, String title) throws Resources.NotFoundException {
        switch (media_type) {
            case 1:
                Bitmap bitmap = MediaStore.Images.Thumbnails.getThumbnail(this.mContext.getContentResolver(), id, 3, null);
                return new BitmapDrawable(this.mContext.getResources(), bitmap);
            case 2:
                Drawable dr = getAudioDrawable(title);
                return dr;
            case 3:
                Bitmap bitmap2 = MediaStore.Video.Thumbnails.getThumbnail(this.mContext.getContentResolver(), id, 3, null);
                return new BitmapDrawable(this.mContext.getResources(), bitmap2);
            default:
                return null;
        }
    }

    private Drawable getAudioDrawable(String title) throws Resources.NotFoundException {
        Bitmap bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        int resourceId = SlookResourceManager.getDrawableId(2);
        Drawable dr = this.mContext.getResources().getDrawable(resourceId);
        dr.setBounds(new Rect(0, 0, 200, 200));
        canvas.drawColor(-2236963, PorterDuff.Mode.SRC);
        dr.draw(canvas);
        return new BitmapDrawable(this.mContext.getResources(), bitmap);
    }

    private Uri getUri(int id, int media_type) {
        switch (media_type) {
            case 1:
                return ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);
            case 2:
                return ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id);
            case 3:
                return ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id);
            default:
                return null;
        }
    }

    private String getFilter(Bundle option) {
        boolean bAdded = false;
        StringBuilder str = new StringBuilder();
        if (option == null || option.getBoolean(IMAGE_TYPE)) {
            str.append("media_type = ");
            str.append(1);
            bAdded = true;
        }
        if (option == null || option.getBoolean(VIDEO_TYPE)) {
            if (bAdded) {
                str.append(" or ");
            }
            str.append("media_type = ");
            str.append(3);
            bAdded = true;
        }
        if (option == null || option.getBoolean(AUDIO_TYPE)) {
            if (bAdded) {
                str.append(" or ");
            }
            str.append("media_type = ");
            str.append(2);
        }
        String filter = str.toString();
        if (filter == null || filter.length() <= 0) {
            return null;
        }
        return filter;
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

    private synchronized void updateData() {
        if (this.mNeedUpdate && !this.mIsShowing) {
            this.mNeedUpdate = false;
            this.mData.clear();
            Cursor c = null;
            try {
                c = this.mContext.getContentResolver().query(MediaStore.Files.getContentUri(VOLUME), new String[]{DatabaseHelper.KEY_ROWID, "media_type", "title"}, this.mFilter, null, "date_modified DESC LIMIT " + this.mMaxCount);
                if (c != null) {
                    while (c.moveToNext()) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("id", c.getInt(0));
                        bundle.putInt(MIME_TYPE, c.getInt(1));
                        this.mData.add(bundle);
                    }
                    this.mCount = this.mData.size();
                } else if (c != null) {
                    c.close();
                }
            } finally {
                if (c != null) {
                    c.close();
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
