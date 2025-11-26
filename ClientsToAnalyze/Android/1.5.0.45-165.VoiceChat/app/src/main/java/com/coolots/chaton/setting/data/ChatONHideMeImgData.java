package com.coolots.chaton.setting.data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.io.File;

/* loaded from: classes.dex */
public class ChatONHideMeImgData {
    private static final String CLASSNAME = "[ChatONHideMeImgData]";
    public static final String GALLERY_LAND_IMAGE_FILENAME = "outgoing_land.jpg";
    public static final String GALLERY_LAND_IMAGE_PATH = "data/data/com.coolots.chaton/files/outgoing_land.jpg";
    public static final String GALLERY_PORT_IMAGE_FILENAME = "outgoing_port.jpg";
    public static final String GALLERY_PORT_IMAGE_PATH = "data/data/com.coolots.chaton/files/outgoing_port.jpg";
    public static final int IMAGE_DEFAULT_HEIGHT = 640;
    public static final int IMAGE_DEFAULT_WIDTH = 480;
    public static final String IMAGE_DIR_PATH = "data/data/com.coolots.chaton/files";
    public static final String LAND_IMAGE_FILENAME = "hide_me_land.jpg";
    public static final String LAND_IMAGE_PATH = "data/data/com.coolots.chaton/files/hide_me_land.jpg";
    public static final String PORT_IMAGE_FILENAME = "hide_me_port.jpg";
    public static final String PORT_IMAGE_PATH = "data/data/com.coolots.chaton/files/hide_me_port.jpg";

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public static Bitmap getLandscapeImage() {
        return getImage(LAND_IMAGE_PATH);
    }

    public static Bitmap getPortraitImage() {
        return getImage(PORT_IMAGE_PATH);
    }

    public static Bitmap getGalleryLandscapeImage() {
        return getImage(GALLERY_LAND_IMAGE_PATH);
    }

    public static Bitmap getGalleryPortraitImage() {
        return getImage(GALLERY_PORT_IMAGE_PATH);
    }

    private static Bitmap getImage(String filePath) {
        logI("getImage");
        File file = new File(IMAGE_DIR_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            BitmapFactory.Options sizeOpt = new BitmapFactory.Options();
            sizeOpt.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(filePath, sizeOpt);
            int width = sizeOpt.outWidth;
            int height = sizeOpt.outHeight;
            int scaleWidth = width / IMAGE_DEFAULT_HEIGHT;
            int scaleHeight = height / IMAGE_DEFAULT_WIDTH;
            int rate = 1;
            if (scaleWidth > 1 || scaleHeight > 1) {
                rate = scaleWidth < scaleHeight ? scaleWidth : scaleHeight;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = rate;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inPurgeable = true;
            options.inDither = true;
            Bitmap img = BitmapFactory.decodeFile(filePath, options);
            return img;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap makeDefaultHideImage(int defaultImageRID) {
        try {
            BitmapFactory.Options sizeOpt = new BitmapFactory.Options();
            sizeOpt.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(MainApplication.mContext.getResources(), defaultImageRID, sizeOpt);
            int width = sizeOpt.outWidth;
            int height = sizeOpt.outHeight;
            logI("width: " + width + " height: " + height);
            int scaleWidth = width / IMAGE_DEFAULT_HEIGHT;
            int scaleHeight = height / IMAGE_DEFAULT_WIDTH;
            int rate = 1;
            if (scaleWidth > 1 || scaleHeight > 1) {
                rate = scaleWidth < scaleHeight ? scaleWidth : scaleHeight;
            }
            logI("rate: " + rate);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = rate;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inPurgeable = true;
            options.inDither = true;
            return BitmapFactory.decodeResource(MainApplication.mContext.getResources(), defaultImageRID, options);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void removeImage() {
        File file = new File(LAND_IMAGE_PATH);
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(PORT_IMAGE_PATH);
        if (file2.exists()) {
            file2.delete();
        }
    }
}
