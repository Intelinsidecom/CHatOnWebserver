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
import java.util.ArrayList;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public final class SlookAirButtonRecentMediaAdapter extends SlookAirButtonAdapter {
    public static final String AUDIO_TYPE = "audio";

    /* renamed from: ID */
    private static final String f452ID = "id";
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

    public SlookAirButtonRecentMediaAdapter(View view, Bundle bundle) {
        this.mMaxCount = 15;
        this.DEBUG = false;
        if (isSupport(1)) {
            this.mContext = view.getContext();
            this.mFilter = getFilter(bundle);
            this.DEBUG = true;
            this.mMaxCount = SlookResourceManager.getInt(3);
            setEmptyText("No medias to add");
        }
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public SlookAirButtonAdapter.AirButtonItem getItem(int i) {
        Bundle bundle = this.mData.get(i);
        int i2 = bundle.getInt("id");
        int i3 = bundle.getInt(MIME_TYPE);
        return new SlookAirButtonAdapter.AirButtonItem(getThumbNail(i2, i3, bundle.getString("title")), null, getUri(i2, i3));
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public int getCount() {
        return this.mCount;
    }

    private Drawable getThumbNail(int i, int i2, String str) {
        switch (i2) {
            case 1:
                return new BitmapDrawable(this.mContext.getResources(), MediaStore.Images.Thumbnails.getThumbnail(this.mContext.getContentResolver(), i, 3, null));
            case 2:
                return getAudioDrawable(str);
            case 3:
                return new BitmapDrawable(this.mContext.getResources(), MediaStore.Video.Thumbnails.getThumbnail(this.mContext.getContentResolver(), i, 3, null));
            default:
                return null;
        }
    }

    private Drawable getAudioDrawable(String str) throws Resources.NotFoundException {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(HttpResponseCode.f13733OK, HttpResponseCode.f13733OK, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Drawable drawable = this.mContext.getResources().getDrawable(SlookResourceManager.getDrawableId(2));
        drawable.setBounds(new Rect(0, 0, HttpResponseCode.f13733OK, HttpResponseCode.f13733OK));
        canvas.drawColor(-2236963, PorterDuff.Mode.SRC);
        drawable.draw(canvas);
        return new BitmapDrawable(this.mContext.getResources(), bitmapCreateBitmap);
    }

    private Uri getUri(int i, int i2) {
        switch (i2) {
            case 1:
                return ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, i);
            case 2:
                return ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, i);
            case 3:
                return ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, i);
            default:
                return null;
        }
    }

    private String getFilter(Bundle bundle) {
        boolean z = false;
        StringBuilder sb = new StringBuilder();
        if (bundle == null || bundle.getBoolean(IMAGE_TYPE)) {
            sb.append("media_type = ");
            sb.append(1);
            z = true;
        }
        if (bundle == null || bundle.getBoolean(VIDEO_TYPE)) {
            if (z) {
                sb.append(" or ");
            }
            sb.append("media_type = ");
            sb.append(3);
            z = true;
        }
        if (bundle == null || bundle.getBoolean(AUDIO_TYPE)) {
            if (z) {
                sb.append(" or ");
            }
            sb.append("media_type = ");
            sb.append(2);
        }
        String string = sb.toString();
        if (string == null || string.length() <= 0) {
            return null;
        }
        return string;
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

    private synchronized void updateData() {
        Cursor cursorQuery;
        if (this.mNeedUpdate && !this.mIsShowing) {
            this.mNeedUpdate = false;
            this.mData.clear();
            try {
                cursorQuery = this.mContext.getContentResolver().query(MediaStore.Files.getContentUri(VOLUME), new String[]{"_id", "media_type", "title"}, this.mFilter, null, "date_modified DESC LIMIT " + this.mMaxCount);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putInt("id", cursorQuery.getInt(0));
                            bundle.putInt(MIME_TYPE, cursorQuery.getInt(1));
                            this.mData.add(bundle);
                        } catch (Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    this.mCount = this.mData.size();
                } else if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
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
